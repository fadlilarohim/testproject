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
import id.fadli.kulineranjogja.bakmie.doring;
import id.fadli.kulineranjogja.bakmie.dumuk;
import id.fadli.kulineranjogja.bakmie.geno;
import id.fadli.kulineranjogja.bakmie.gito;
import id.fadli.kulineranjogja.bakmie.hadi;
import id.fadli.kulineranjogja.bakmie.kadin;
import id.fadli.kulineranjogja.bakmie.lethek;
import id.fadli.kulineranjogja.bakmie.mbahmo;
import id.fadli.kulineranjogja.bakmie.pele;
import id.fadli.kulineranjogja.bakmie.rebo;
import id.fadli.kulineranjogja.bakmie.shibitsu;
import id.fadli.kulineranjogja.model.Model;

/**
 * Created by fadli on 1/11/2016.
 */

public class BakmieAdapter extends RecyclerView.Adapter<BakmieAdapter.BakmieHolder> {

    private final Context mContext;
    private List<Model> listBakmie;
    private LayoutInflater inflater;

    public BakmieAdapter(Context mContext, List<Model> listBakmie) {
        this.mContext = mContext;
        this.listBakmie = listBakmie;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public BakmieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_miebakso, parent, false);
        BakmieAdapter.BakmieHolder holder = new BakmieAdapter.BakmieHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(BakmieHolder holder, int position) {
        Model menu = listBakmie.get(position);
        holder.titleBakmie.setText(menu.getName());
        holder.deskripsiBakmie.setText(menu.getDeskripsi());
        //glide
        Glide.with(mContext).load(menu.getThumbnail()).into(holder.thumbnailBakmie);

    }

    @Override
    public int getItemCount() {
        return listBakmie.size();
    }

    class BakmieHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleBakmie, deskripsiBakmie;
        public ImageView thumbnailBakmie;

        private final Context context;

        public BakmieHolder(View itemView) {
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
                    intent = new Intent(context, pele.class);
                    break;

                case 1:
                    intent = new Intent(context, shibitsu.class);
                    break;
                case 2:
                    intent = new Intent(context, mbahmo.class);
                    break;
                case 3:
                    intent = new Intent(context, doring.class);
                    break;
                case 4:
                    intent = new Intent(context, hadi.class);
                    break;
                case 5:
                    intent = new Intent(context, rebo.class);
                    break;
                case 6:
                    intent = new Intent(context, geno.class);
                    break;
                case 7:
                    intent = new Intent(context, dumuk.class);
                    break;
                case 8:
                    intent = new Intent(context, kadin.class);
                    break;
                case 9:
                    intent = new Intent(context, lethek.class);
                    break;
                case 10:
                    intent = new Intent(context, gito.class);
                    break;
            }
            mContext.startActivity(intent);
            Toast.makeText(context, "The Item Clicked is: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }

    }
}
