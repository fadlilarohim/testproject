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
import id.fadli.kulineranjogja.gudeg.SentraGudeg;
import id.fadli.kulineranjogja.gudeg.amad;
import id.fadli.kulineranjogja.gudeg.citro;
import id.fadli.kulineranjogja.gudeg.juminten;
import id.fadli.kulineranjogja.gudeg.narni;
import id.fadli.kulineranjogja.gudeg.pawon;
import id.fadli.kulineranjogja.gudeg.permata;
import id.fadli.kulineranjogja.gudeg.rini;
import id.fadli.kulineranjogja.gudeg.sagan;
import id.fadli.kulineranjogja.gudeg.tekluk;
import id.fadli.kulineranjogja.gudeg.yujum;
import id.fadli.kulineranjogja.model.Model;

/**
 * Created by fadli on 1/11/2016.
 */

public class GudegAdapter extends RecyclerView.Adapter<GudegAdapter.GudegHolder> {
    private final Context mContext;
    private List<Model> listGudeg;
    private LayoutInflater inflater;

    public GudegAdapter(Context mContext, List<Model> listGudeg) {
        this.mContext = mContext;
        this.listGudeg = listGudeg;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public GudegHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_miebakso, parent, false);
        GudegAdapter.GudegHolder holder = new GudegAdapter.GudegHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(GudegHolder holder, int position) {
        Model menu = listGudeg.get(position);
        holder.titleBakmie.setText(menu.getName());
        holder.deskripsiBakmie.setText(menu.getDeskripsi());
        //glide
        Glide.with(mContext).load(menu.getThumbnail()).into(holder.thumbnailBakmie);

    }

    @Override
    public int getItemCount() {
        return listGudeg.size();
    }

    class GudegHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleBakmie, deskripsiBakmie;
        public ImageView thumbnailBakmie;

        private final Context context;

        public GudegHolder(View itemView) {
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
                    intent = new Intent(context, yujum.class);
                    break;
                case 1:
                    intent = new Intent(context, narni.class);
                    break;
                case 2:
                    intent = new Intent(context, sagan.class);
                    break;
                case 3:
                    intent = new Intent(context, pawon.class);
                    break;
                case 4:
                    intent = new Intent(context, rini.class);
                    break;
                case 5:
                    intent = new Intent(context, citro.class);
                    break;
                case 6:
                    intent = new Intent(context, permata.class);
                    break;
                case 7:
                    intent = new Intent(context, tekluk.class);
                    break;
                case 8:
                    intent = new Intent(context, amad.class);
                    break;
                case 9:
                    intent = new Intent(context, juminten.class);
                    break;
                case 10:
                    intent = new Intent(context, SentraGudeg.class);
                    break;
            }
            mContext.startActivity(intent);
            Toast.makeText(context, "The Item Clicked is: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }

    }
}
