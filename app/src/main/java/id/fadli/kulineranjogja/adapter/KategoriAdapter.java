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
import id.fadli.kulineranjogja.model.MenuKategori;
import id.fadli.kulineranjogja.ui.Kategori;
import id.fadli.kulineranjogja.ui.Bakso;
import id.fadli.kulineranjogja.ui.Profil;


/**
 * Created by fadli on 23/10/2016.
 */

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.KategoriHolder> {

    private final Context mContext;
    private List<MenuKategori> kategoriList;
    private LayoutInflater inflater;

    public KategoriAdapter(Context mContext, List<MenuKategori> kategoriList) {
        this.mContext = mContext;
        this.kategoriList = kategoriList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public KategoriHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_kategori, parent, false);
        KategoriHolder holder = new KategoriHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(KategoriHolder holder, int position) {
        MenuKategori menu = kategoriList.get(position);
        holder.titleKat.setText(menu.getName());
        holder.desKat.setText(menu.getDeskripsi());
        //glide
        Glide.with(mContext).load(menu.getThumbnail()).into(holder.thumbnailKat);

    }

    @Override
    public int getItemCount() {
        return kategoriList.size();
    }

    class KategoriHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView titleKat, desKat;
        public ImageView thumbnailKat;

        private final Context context;

        public KategoriHolder(View view) {
            super(view);
            context = itemView.getContext();
            titleKat = (TextView) view.findViewById(R.id.title_kat);
            desKat = (TextView) view.findViewById(R.id.deskripsi);
            thumbnailKat = (ImageView) view.findViewById(R.id.thumbnail_kat);
            thumbnailKat.setClickable(true);
            thumbnailKat.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (getAdapterPosition()) {
                case 0:
                    intent = new Intent(context, Bakso.class);
                    break;

                case 1:
                    intent = new Intent(context, Kategori.class);
                    break;
                case 2:
                    intent = new Intent(context, Profil.class);
                    break;
                case 3:
                    intent = new Intent(context, Profil.class);
                    break;
                case 4:
                    intent = new Intent(context, Profil.class);
                    break;
                case 5:
                    intent = new Intent(context, Profil.class);
                    break;
                case 6:
                    intent = new Intent(context, Profil.class);
                    break;
                case 7:
                    intent = new Intent(context, Profil.class);
                    break;
            }
            mContext.startActivity(intent);
            Toast.makeText(context, "The Item Clicked is: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }

    }
}
