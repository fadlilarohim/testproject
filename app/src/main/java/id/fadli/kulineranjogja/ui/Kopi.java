package id.fadli.kulineranjogja.ui;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import id.fadli.kulineranjogja.R;
import id.fadli.kulineranjogja.adapter.KopiAdapter;
import id.fadli.kulineranjogja.adapter.NasgorAdapter;
import id.fadli.kulineranjogja.model.Model;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by fadli on 1/11/2016.
 */

public class Kopi extends AppCompatActivity {

    private RecyclerView recyclerView;
    private KopiAdapter adapter;
    private List<Model> listKopi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miebakso);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_miebakso);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setTitle("Kopi");

        recyclerView = (RecyclerView) findViewById(R.id.recview_miebakso);

        listKopi = new ArrayList<>();
        adapter = new KopiAdapter(this, listKopi);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new SlideInUpAnimator());
        recyclerView.setAdapter(adapter);

        prepareKopi();

        try {
            Glide.with(this).load(R.drawable.kopi).into((ImageView) findViewById(R.id.bgheader_miebakso));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareKopi() {
        int[] covers = new int[]{
                R.drawable.mataram,
                R.drawable.klinik,
                R.drawable.lecker,
                R.drawable.dongeng,
                R.drawable.mato,
                R.drawable.kk,
                R.drawable.legend,
                R.drawable.omah,
                R.drawable.blandongan,
                R.drawable.epic,
                R.drawable.kecil,
                R.drawable.hestek,};

        Model a = new Model("Kedai Kopi Mataram", "l. Mataram No.55, Suryatmajan, Danurejan, Kota Yogyakarta, Daerah Istimewa Yogyakarta", covers[0]);
        listKopi.add(a);
        a = new Model("Klinik Kopi", "Jl. Kaliurang KM. 7.8, Gang Bima, Sinduharjo, Ngaglik, Kabupaten Sleman", covers[1]);
        listKopi.add(a);
        a = new Model("Lecker Rumah Kopi", "Jalan H.O.S. Cokroaminoto No.199, Tegalrejo, Kota Yogyakarta", covers[2]);
        listKopi.add(a);
        a = new Model("Dongeng Kopi Jogja", "Jalan KH Wahid Hasyim No. 3, Condongcatur, Depok, Kabupaten Sleman", covers[3]);
        listKopi.add(a);
        a = new Model("Mato Kopi Yogyakarta", "Jl. Selokan Mataram Dabag, Condongcatur, Depok, Sleman", covers[4]);
        listKopi.add(a);
        a = new Model("Kedai Kopi Espresso Bar Jakal", "Jalan Kaliurang Km 6.5 No. D44, Kentungan, Depok, Kabupaten Sleman", covers[5]);
        listKopi.add(a);
        a = new Model("Legend Coffee", "Jl. Abu Bakar Ali No. 24, Kota Baru, Daerah Istimewa Yogyakarta", covers[6]);
        listKopi.add(a);
        a = new Model("Omah Kopi", "Jl. Gondosuli, Semaki, Umbulharjo, Kota Yogyakarta, Daerah Istimewa Yogyakarta", covers[7]);
        listKopi.add(a);
        a = new Model("Warung Kopi Blandongan", "Jalan Sorowajan Baru No.11, Banguntapan, Bantul, Daerah Istimewa Yogyakarta", covers[8]);
        listKopi.add(a);
        a = new Model("Epic Coffee", "Jl. Palagan Tentara Pelajar No.29, Daerah Istimewa Yogyakarta", covers[9]);
        listKopi.add(a);
        a = new Model("Kopi Ketjil", "Jl. Demangan Baru No.8a, Kec. Depok, Kabupaten Sleman", covers[10]);
        listKopi.add(a);
        a = new Model("Hestek Kopi", "Jalan Kaliurang, Catur Tunggal, Depok, Kabupaten Sleman", covers[11]);
        listKopi.add(a);

    }

    //Recycler View Decoration
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
