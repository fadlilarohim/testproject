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
import id.fadli.kulineranjogja.adapter.BakmieAdapter;
import id.fadli.kulineranjogja.adapter.BaksoAdapter;
import id.fadli.kulineranjogja.model.Model;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by fadli on 1/11/2016.
 */

public class Bakmi extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BakmieAdapter adapter;
    private List<Model> listBakmi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miebakso);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_miebakso);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setTitle("Bakmie");

        recyclerView = (RecyclerView) findViewById(R.id.recview_miebakso);

        listBakmi = new ArrayList<>();
        adapter = new BakmieAdapter(this, listBakmi);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new SlideInUpAnimator());
        recyclerView.setAdapter(adapter);

        prepareBakmie();

        try {
            Glide.with(this).load(R.drawable.bakmi).into((ImageView) findViewById(R.id.bgheader_miebakso));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareBakmie() {
        int[] covers = new int[]{
                R.drawable.pele,
                R.drawable.shibitsu,
                R.drawable.mbahmo,
                R.drawable.doring,
                R.drawable.hadi,
                R.drawable.rebo,
                R.drawable.geno,
                R.drawable.dumuk,
                R.drawable.kadin,
                R.drawable.lethek,
                R.drawable.gito,};

        Model a = new Model("Bakmi Pak Pele", "JL. Pojok Tenggara Alun-Alun Utara , Panembahan , Kraton , Yogyakarta ", covers[0]);
        listBakmi.add(a);
        a = new Model("Bakmi Shibitsu", "Jl. Bantul No.111, Gedongkiwo, Mantrijeron, Kota Yogyakarta", covers[1]);
        listBakmi.add(a);
        a = new Model("Bakmi Jawa Mbah Mo", "Desa Code, Kelurahan Trirenggo, Kecamatan Bantul, Bantul", covers[2]);
        listBakmi.add(a);
        a = new Model("Bakmi Doring", "Jalan Suryowijayan No. 348, Kota Yogyakarta", covers[3]);
        listBakmi.add(a);
        a = new Model("Bakmi Jawa Mbah Hadi Terban", "Jalan C Simanjuntak No. 1, Kota Yogyakarta, Daerah Istimewa Yogyakarta", covers[4]);
        listBakmi.add(a);
        a = new Model("Bakmi Jawa Pak Rebo", " Jl. Brigjen Katamso, Keparakan, Mergangsan, Kota Yogyakarta", covers[5]);
        listBakmi.add(a);
        a = new Model("Bakmi Jawa Pak Geno", "Jl. Parangtritis, Daerah Istimewa Yogyakarta 55143, Indonesia", covers[6]);
        listBakmi.add(a);
        a = new Model("Bakmi Mbah Dumuk", "JL. Magelang, Km 12, Kec. Sleman, Kabupaten Sleman", covers[7]);
        listBakmi.add(a);
        a = new Model("Bakmi & Bajigur Kadin Mbah Hj. Karto", " Jalan Bintaran Kulon No. 6, Wirogunan, Mergangsan, Kota Yogyakarta", covers[8]);
        listBakmi.add(a);
        a = new Model("Bakmie Lethek Bantul Mbah Mendes", "Jalan Sarirejo, Maguwoharjo, Depok, Sleman", covers[9]);
        listBakmi.add(a);
        a = new Model("Bakmi Jowo Mbah Gito", "Peleman,, Jl. Nyi Ageng Nis, Rejowinangun, Kotagede, Kota Yogyakarta", covers[10]);
        listBakmi.add(a);

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
