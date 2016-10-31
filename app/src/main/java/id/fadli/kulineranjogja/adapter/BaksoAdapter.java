package id.fadli.kulineranjogja.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import id.fadli.kulineranjogja.R;
import id.fadli.kulineranjogja.model.BaksoModel;
import id.fadli.kulineranjogja.ui.DetailBakso;

/**
 * Created by fadli on 28/10/2016.
 */

public class BaksoAdapter extends RecyclerView.Adapter<BaksoAdapter.MieBaksoHolder> {

    private final Context mContext;
    private List<BaksoModel> mieBaksoList;
    private LayoutInflater inflater;

    public BaksoAdapter(Context mContext, List<BaksoModel> mieBaksoList) {
        this.mContext = mContext;
        this.mieBaksoList = mieBaksoList;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public MieBaksoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_miebakso, parent, false);
        MieBaksoHolder holder = new MieBaksoHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MieBaksoHolder holder, int position) {

        BaksoModel menu = mieBaksoList.get(position);
        holder.titleBakso.setText(menu.getName());
        holder.desBakso.setText(menu.getDeskripsi());
        //glide
        Glide.with(mContext).load(menu.getThumbnail()).into(holder.thumbnailBakso);

    }

    @Override
    public int getItemCount() {
        return mieBaksoList.size();
    }

    class MieBaksoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleBakso, desBakso;
        public ImageView thumbnailBakso;

        private final Context context;

        public MieBaksoHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            titleBakso = (TextView) itemView.findViewById(R.id.title_mie);
            desBakso = (TextView) itemView.findViewById(R.id.deskripsi_mie);
            thumbnailBakso = (ImageView) itemView.findViewById(R.id.thumbnail_mie);
            thumbnailBakso.setOnClickListener(this);
            thumbnailBakso.setClickable(true);
        }

        @Override
        public void onClick(View v) {

            Intent intent = null;
            switch (getAdapterPosition()) {
                case 0:
                    intent = new Intent(context, DetailBakso.class);
                    break;
            }
            Toast.makeText(context, "The Item Clicked is: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
            mContext.startActivity(intent);

        }
    }
}

