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

import id.fadli.kulineranjogja.ui.Bantuan;
import id.fadli.kulineranjogja.ui.Kategori;
import id.fadli.kulineranjogja.R;
import id.fadli.kulineranjogja.ui.Profil;
import id.fadli.kulineranjogja.ui.Tentang;
import id.fadli.kulineranjogja.model.MenuAwal;

/**
 * Created by fadli on 14/9/2016.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.HomeHolder> {

    private final Context mContext;
    private List<MenuAwal> homeList;
    private LayoutInflater inflater;

    public MenuAdapter(Context mContext, List<MenuAwal> homeList) {
        this.mContext = mContext;
        this.homeList = homeList;
        inflater= LayoutInflater.from(mContext);
    }

    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_home, parent, false);
        HomeHolder holder = new HomeHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeHolder holder, int position) {
        MenuAwal menu = homeList.get(position);
        holder.title.setText(menu.getName());
        //thumbnail dengan glide
        Glide.with(mContext).load(menu.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public ImageView thumbnail;

        private final Context context;

        public HomeHolder(View view) {
            super(view);
            context = itemView.getContext();
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            thumbnail.setClickable(true);
            thumbnail.setOnClickListener(this);
        }
        //klik menu
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (getAdapterPosition()){
                case 0:
                    intent =  new Intent(context, Tentang.class);
                    break;

                case 1:
                    intent =  new Intent(context, Kategori.class);
                    break;
                case 2:
                    intent =  new Intent(context, Profil.class);
                    break;
                case 3:
                    intent =  new Intent(context, Bantuan.class);
                    break;
            }
            mContext.startActivity(intent);
            Toast.makeText(context,"The Item Clicked is: "+getAdapterPosition(),Toast.LENGTH_SHORT).show();
        }
    }

}
