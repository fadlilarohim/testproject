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
import id.fadli.kulineranjogja.model.Model;
import id.fadli.kulineranjogja.nasgor.beni;
import id.fadli.kulineranjogja.nasgor.beringharjo;
import id.fadli.kulineranjogja.nasgor.ita;
import id.fadli.kulineranjogja.nasgor.mandiri;
import id.fadli.kulineranjogja.nasgor.maswit;
import id.fadli.kulineranjogja.nasgor.nasgorpele;
import id.fadli.kulineranjogja.nasgor.padmanaba;
import id.fadli.kulineranjogja.nasgor.sular;
import id.fadli.kulineranjogja.nasgor.wiro;

/**
 * Created by fadli on 1/11/2016.
 */

public class NasgorAdapter extends RecyclerView.Adapter<NasgorAdapter.NasgorHolder> {
    private final Context mContext;
    private List<Model> listNasgor;
    private LayoutInflater inflater;

    public NasgorAdapter(Context mContext, List<Model> listNasgor) {
        this.mContext = mContext;
        this.listNasgor = listNasgor;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public NasgorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_miebakso, parent, false);
        NasgorAdapter.NasgorHolder holder = new NasgorAdapter.NasgorHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(NasgorHolder holder, int position) {
        Model menu = listNasgor.get(position);
        holder.titleBakmie.setText(menu.getName());
        holder.deskripsiBakmie.setText(menu.getDeskripsi());
        //glide
        Glide.with(mContext).load(menu.getThumbnail()).into(holder.thumbnailBakmie);

    }

    @Override
    public int getItemCount() {
        return listNasgor.size();
    }

    class NasgorHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleBakmie, deskripsiBakmie;
        public ImageView thumbnailBakmie;

        private final Context context;

        public NasgorHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            titleBakmie = (TextView) itemView.findViewById(R.id.title_mie);
            deskripsiBakmie = (TextView) itemView.findViewById(R.id.deskripsi_mie);
            thumbnailBakmie = (ImageView) itemView.findViewById(R.id.thumbnail_mie);
            thumbnailBakmie.setOnClickListener(this);
            thumbnailBakmie.setClickable(true);
        }


        @Override
        public void onClick(View v) {

            Intent intent = null;
            switch (getAdapterPosition()) {
                case 0:
                    intent = new Intent(context, sular.class);
                    break;

                case 1:
                    intent = new Intent(context, beringharjo.class);
                    break;
                case 2:
                    intent = new Intent(context, padmanaba.class);
                    break;
                case 3:
                    intent = new Intent(context, maswit.class);
                    break;
                case 4:
                    intent = new Intent(context, beni.class);
                    break;
                case 5:
                    intent = new Intent(context, ita.class);
                    break;
                case 6:
                    intent = new Intent(context, wiro.class);
                    break;
                case 7:
                    intent = new Intent(context, mandiri.class);
                    break;
                case 8:
                    intent = new Intent(context, nasgorpele.class);
                    break;
            }
            mContext.startActivity(intent);
            Toast.makeText(context, "The Item Clicked is: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }

    }
}
