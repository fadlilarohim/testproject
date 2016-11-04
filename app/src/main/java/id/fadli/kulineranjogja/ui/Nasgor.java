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
import id.fadli.kulineranjogja.adapter.MieAyamAdapter;
import id.fadli.kulineranjogja.adapter.NasgorAdapter;
import id.fadli.kulineranjogja.model.Model;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by fadli on 1/11/2016.
 */

public class Nasgor extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NasgorAdapter adapter;
    private List<Model> listNasgor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miebakso);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_miebakso);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setTitle("Nasi Goreng");

        recyclerView = (RecyclerView) findViewById(R.id.recview_miebakso);

        listNasgor = new ArrayList<>();
        adapter = new NasgorAdapter(this, listNasgor);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new SlideInUpAnimator());
        recyclerView.setAdapter(adapter);

        prepareNasgor();

        try {
            Glide.with(this).load(R.drawable.nasigoreng).into((ImageView) findViewById(R.id.bgheader_miebakso));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareNasgor() {
        int[] covers = new int[]{
                R.drawable.sular,
                R.drawable.beringharjo,
                R.drawable.padmanaba,
                R.drawable.wit,
                R.drawable.beni,
                R.drawable.ita,
                R.drawable.wiro,
                R.drawable.mandiri,
                R.drawable.nasgorpele,};

        Model a = new Model("Nasi Goreng Sapi Dan Kambing Pak Sular", "Jl. Krasak Timur No.28, Kotabaru, Gondokusuman, Kota Yogyakarta,", covers[0]);
        listNasgor.add(a);
        a = new Model("Nasi Goreng Beringharjo", "Jalan Mayor Suryotomo No. 7, Gondomanan, Kota Yogyakarta", covers[1]);
        listNasgor.add(a);
        a = new Model("Nasi Goreng Sapi (PADMANABA)", "Jl. Yos Sudarso, Kotabaru, Gondokusuman, Kota Yogyakarta", covers[2]);
        listNasgor.add(a);
        a = new Model("Nasi Goreng Mas Wit", "Gg. Alamanda Jl. Affandi, Caturtunggal, Kec. Depok, Kabupaten Sleman", covers[3]);
        listNasgor.add(a);
        a = new Model("Nasi Goreng Kambing Pak Beni", "Jl. Afandi Gejayan (Samping Pempek Ny Kamto)", covers[4]);
        listNasgor.add(a);
        a = new Model("Nasi Goreng Bu Ita", "Jl. Pandega Marta No.532 D, Sinduadi, Mlati, Kabupaten Sleman", covers[5]);
        listNasgor.add(a);
        a = new Model("Nasi Goreng 212", "Jalan selokan Mataram", covers[6]);
        listNasgor.add(a);
        a = new Model("Nasi Goreng Babat Mandiri", "Jl. Moses Gatotkaca Mrican Jogjakarta, Selatan Universitas Sanata Dharma.", covers[7]);
        listNasgor.add(a);
        a = new Model("Nasi Goreng Pak Pele", "JL. Pojok Tenggara Alun-Alun Utara , Panembahan , Kraton , Yogyakarta , Daerah Istimewa Yogyakarta", covers[8]);
        listNasgor.add(a);

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
