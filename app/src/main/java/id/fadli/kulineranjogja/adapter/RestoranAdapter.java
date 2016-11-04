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
import id.fadli.kulineranjogja.restoran.ageng;
import id.fadli.kulineranjogja.restoran.bale;
import id.fadli.kulineranjogja.restoran.bear;
import id.fadli.kulineranjogja.restoran.canting;
import id.fadli.kulineranjogja.restoran.desa;
import id.fadli.kulineranjogja.restoran.duwur;
import id.fadli.kulineranjogja.restoran.goeboeg;
import id.fadli.kulineranjogja.restoran.honje;
import id.fadli.kulineranjogja.restoran.kamil;
import id.fadli.kulineranjogja.restoran.raminten;
import id.fadli.kulineranjogja.restoran.rnb;
import id.fadli.kulineranjogja.restoran.sekar;
import id.fadli.kulineranjogja.restoran.suharti;
import id.fadli.kulineranjogja.restoran.tan;

/**
 * Created by fadli on 1/11/2016.
 */

public class RestoranAdapter extends RecyclerView.Adapter<RestoranAdapter.RestoranHolder> {
    private final Context mContext;
    private List<Model> listRestoran;
    private LayoutInflater inflater;

    public RestoranAdapter(Context mContext, List<Model> listRestoran) {
        this.mContext = mContext;
        this.listRestoran = listRestoran;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RestoranHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_miebakso, parent, false);
        RestoranAdapter.RestoranHolder holder = new RestoranAdapter.RestoranHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RestoranHolder holder, int position) {
        Model menu = listRestoran.get(position);
        holder.titleBakmie.setText(menu.getName());
        holder.deskripsiBakmie.setText(menu.getDeskripsi());
        //glide
        Glide.with(mContext).load(menu.getThumbnail()).into(holder.thumbnailBakmie);

    }

    @Override
    public int getItemCount() {
        return listRestoran.size();
    }

    class RestoranHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleBakmie, deskripsiBakmie;
        public ImageView thumbnailBakmie;

        private final Context context;

        public RestoranHolder(View itemView) {
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
                    intent = new Intent(context, sekar.class);
                    break;

                case 1:
                    intent = new Intent(context, duwur.class);
                    break;
                case 2:
                    intent = new Intent(context, goeboeg.class);
                    break;
                case 3:
                    intent = new Intent(context, suharti.class);
                    break;
                case 4:
                    intent = new Intent(context, canting.class);
                    break;
                case 5:
                    intent = new Intent(context, desa.class);
                    break;
                case 6:
                    intent = new Intent(context, ageng.class);
                    break;
                case 7:
                    intent = new Intent(context, raminten.class);
                    break;
                case 8:
                    intent = new Intent(context, kamil.class);
                    break;
                case 9:
                    intent = new Intent(context, bale.class);
                    break;
                case 10:
                    intent = new Intent(context, bear.class);
                    break;
                case 11:
                    intent = new Intent(context, tan.class);
                    break;
                case 12:
                    intent = new Intent(context, rnb.class);
                    break;
                case 13:
                    intent = new Intent(context, honje.class);
                    break;
            }
            mContext.startActivity(intent);
            Toast.makeText(context, "The Item Clicked is: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }

    }
}
