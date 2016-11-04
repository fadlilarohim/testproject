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
import id.fadli.kulineranjogja.kopi.blandongan;
import id.fadli.kulineranjogja.kopi.dongeng;
import id.fadli.kulineranjogja.kopi.epic;
import id.fadli.kulineranjogja.kopi.espreso;
import id.fadli.kulineranjogja.kopi.hestek;
import id.fadli.kulineranjogja.kopi.kecil;
import id.fadli.kulineranjogja.kopi.klinik;
import id.fadli.kulineranjogja.kopi.lecker;
import id.fadli.kulineranjogja.kopi.legend;
import id.fadli.kulineranjogja.kopi.mataram;
import id.fadli.kulineranjogja.kopi.mato;
import id.fadli.kulineranjogja.kopi.omah;
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

public class KopiAdapter extends RecyclerView.Adapter<KopiAdapter.KopiHolder> {
    private final Context mContext;
    private List<Model> listKopi;
    private LayoutInflater inflater;

    public KopiAdapter(Context mContext, List<Model> listKopi) {
        this.mContext = mContext;
        this.listKopi = listKopi;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public KopiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_miebakso, parent, false);
        KopiAdapter.KopiHolder holder = new KopiAdapter.KopiHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(KopiHolder holder, int position) {
        Model menu = listKopi.get(position);
        holder.titleBakmie.setText(menu.getName());
        holder.deskripsiBakmie.setText(menu.getDeskripsi());
        //glide
        Glide.with(mContext).load(menu.getThumbnail()).into(holder.thumbnailBakmie);

    }

    @Override
    public int getItemCount() {
        return listKopi.size();
    }

    class KopiHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleBakmie, deskripsiBakmie;
        public ImageView thumbnailBakmie;

        private final Context context;

        public KopiHolder(View itemView) {
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
                    intent = new Intent(context, mataram.class);
                    break;

                case 1:
                    intent = new Intent(context, klinik.class);
                    break;
                case 2:
                    intent = new Intent(context, lecker.class);
                    break;
                case 3:
                    intent = new Intent(context, dongeng.class);
                    break;
                case 4:
                    intent = new Intent(context, mato.class);
                    break;
                case 5:
                    intent = new Intent(context, espreso.class);
                    break;
                case 6:
                    intent = new Intent(context, legend.class);
                    break;
                case 7:
                    intent = new Intent(context, omah.class);
                    break;
                case 8:
                    intent = new Intent(context, blandongan.class);
                    break;
                case 9:
                    intent = new Intent(context, epic.class);
                    break;
                case 10:
                    intent = new Intent(context, kecil.class);
                    break;
                case 12:
                    intent = new Intent(context, hestek.class);
                    break;
            }
            mContext.startActivity(intent);
            Toast.makeText(context, "The Item Clicked is: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }

    }
}
