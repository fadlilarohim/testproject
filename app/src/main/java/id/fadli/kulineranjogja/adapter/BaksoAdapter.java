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

import id.fadli.kulineranjogja.bakso.BaksoIdolaku;
import id.fadli.kulineranjogja.bakso.Baskom;
import id.fadli.kulineranjogja.bakso.Bethesda;
import id.fadli.kulineranjogja.bakso.Blangkon;
import id.fadli.kulineranjogja.bakso.Granatz;
import id.fadli.kulineranjogja.bakso.Ironayan;
import id.fadli.kulineranjogja.bakso.Ito;
import id.fadli.kulineranjogja.bakso.JawiMiyar;
import id.fadli.kulineranjogja.bakso.Karno;
import id.fadli.kulineranjogja.bakso.Narto;
import id.fadli.kulineranjogja.bakso.Sronto;
import id.fadli.kulineranjogja.bakso.Supri;
import id.fadli.kulineranjogja.bakso.Telkom;
import id.fadli.kulineranjogja.bakso.Tembak;
import id.fadli.kulineranjogja.bakso.Tengkleng;
import id.fadli.kulineranjogja.R;
import id.fadli.kulineranjogja.model.Model;
import id.fadli.kulineranjogja.bakso.Klenger;

/**
 * Created by fadli on 28/10/2016.
 */

public class BaksoAdapter extends RecyclerView.Adapter<BaksoAdapter.MieBaksoHolder> {

    private final Context mContext;
    private List<Model> mieBaksoList;
    private LayoutInflater inflater;

    public BaksoAdapter(Context mContext, List<Model> mieBaksoList) {
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

        Model menu = mieBaksoList.get(position);
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
                    intent = new Intent(context, Klenger.class);
                    break;

                case 1:
                    intent = new Intent(context, Bethesda.class);
                    break;
                case 2:
                    intent = new Intent(context, JawiMiyar.class);
                    break;
                case 3:
                    intent = new Intent(context, Telkom.class);
                    break;
                case 4:
                    intent = new Intent(context, Ito.class);
                    break;
                case 5:
                    intent = new Intent(context, Tengkleng.class);
                    break;
                case 6:
                    intent = new Intent(context, Narto.class);
                    break;
                case 7:
                    intent = new Intent(context, Blangkon.class);
                    break;
                case 8:
                    intent = new Intent(context, Karno.class);
                    break;
                case 9:
                    intent = new Intent(context, Ironayan.class);
                    break;
                case 10:
                    intent = new Intent(context, Tembak.class);
                    break;
                case 11:
                    intent = new Intent(context, Granatz.class);
                    break;
                case 12:
                    intent = new Intent(context, Baskom.class);
                    break;
                case 13:
                    intent = new Intent(context, BaksoIdolaku.class);
                    break;
                case 14:
                    intent = new Intent(context, Supri.class);
                    break;
                case 15:
                    intent = new Intent(context, Sronto.class);
                    break;
            }
            mContext.startActivity(intent);
            Toast.makeText(context, "The Item Clicked is: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }

    }
}



