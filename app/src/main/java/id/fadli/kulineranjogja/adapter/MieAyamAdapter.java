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
import id.fadli.kulineranjogja.mieayam.afui;
import id.fadli.kulineranjogja.mieayam.ijo;
import id.fadli.kulineranjogja.mieayam.jaya;
import id.fadli.kulineranjogja.mieayam.masno;
import id.fadli.kulineranjogja.mieayam.pelangi;
import id.fadli.kulineranjogja.mieayam.sekarsuli;
import id.fadli.kulineranjogja.mieayam.sogi;
import id.fadli.kulineranjogja.mieayam.terbang;
import id.fadli.kulineranjogja.mieayam.thoyonk;
import id.fadli.kulineranjogja.mieayam.tikno;
import id.fadli.kulineranjogja.mieayam.tumini;
import id.fadli.kulineranjogja.mieayam.virgo;
import id.fadli.kulineranjogja.model.Model;

/**
 * Created by fadli on 1/11/2016.
 */

public class MieAyamAdapter extends RecyclerView.Adapter<MieAyamAdapter.MieAyamHolder> {
    private final Context mContext;
    private List<Model> listMieAyam;
    private LayoutInflater inflater;

    public MieAyamAdapter(Context mContext, List<Model> listMieAyam) {
        this.mContext = mContext;
        this.listMieAyam = listMieAyam;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public MieAyamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_miebakso, parent, false);
        MieAyamAdapter.MieAyamHolder holder = new MieAyamAdapter.MieAyamHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MieAyamHolder holder, int position) {
        Model menu = listMieAyam.get(position);
        holder.titleBakmie.setText(menu.getName());
        holder.deskripsiBakmie.setText(menu.getDeskripsi());
        //glide
        Glide.with(mContext).load(menu.getThumbnail()).into(holder.thumbnailBakmie);

    }

    @Override
    public int getItemCount() {
        return listMieAyam.size();
    }

    class MieAyamHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleBakmie, deskripsiBakmie;
        public ImageView thumbnailBakmie;

        private final Context context;

        public MieAyamHolder(View itemView) {
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
                    intent = new Intent(context, tumini.class);
                    break;

                case 1:
                    intent = new Intent(context, virgo.class);
                    break;
                case 2:
                    intent = new Intent(context, masno.class);
                    break;
                case 3:
                    intent = new Intent(context, sekarsuli.class);
                    break;
                case 4:
                    intent = new Intent(context, pelangi.class);
                    break;
                case 5:
                    intent = new Intent(context, tikno.class);
                    break;
                case 6:
                    intent = new Intent(context, afui.class);
                    break;
                case 7:
                    intent = new Intent(context, ijo.class);
                    break;
                case 8:
                    intent = new Intent(context, terbang.class);
                    break;
                case 9:
                    intent = new Intent(context, jaya.class);
                    break;
                case 10:
                    intent = new Intent(context, thoyonk.class);
                    break;
                case 11:
                    intent = new Intent(context, sogi.class);
                    break;
            }
            mContext.startActivity(intent);
            Toast.makeText(context, "The Item Clicked is: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }

    }
}
