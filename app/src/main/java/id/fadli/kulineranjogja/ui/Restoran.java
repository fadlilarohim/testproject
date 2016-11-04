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
import id.fadli.kulineranjogja.adapter.RestoranAdapter;
import id.fadli.kulineranjogja.model.Model;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by fadli on 1/11/2016.
 */

public class Restoran extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RestoranAdapter adapter;
    private List<Model> listRestoran;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miebakso);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_miebakso);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setTitle("Restoran");

        recyclerView = (RecyclerView) findViewById(R.id.recview_miebakso);

        listRestoran = new ArrayList<>();
        adapter = new RestoranAdapter(this, listRestoran);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new SlideInUpAnimator());
        recyclerView.setAdapter(adapter);

        prepareRestoran();

        try {
            Glide.with(this).load(R.drawable.restoran).into((ImageView) findViewById(R.id.bgheader_miebakso));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareRestoran() {
        int[] covers = new int[]{
                R.drawable.sekar,
                R.drawable.duwur,
                R.drawable.goeboeg,
                R.drawable.suharti,
                R.drawable.canting,
                R.drawable.desa,
                R.drawable.ageng,
                R.drawable.raminten,
                R.drawable.kamil,
                R.drawable.bale,
                R.drawable.bear,
                R.drawable.tan,
                R.drawable.rnb,
                R.drawable.honje,};

        Model a = new Model("Sekar Kedhaton Restaurant", "Jl. Tegal Gendu No.28, Prenggan, Kotagede, Kota Yogyakarta", covers[0]);
        listRestoran.add(a);
        a = new Model("Omah Dhuwur Restaurant", "JL. Mondorakan, No. 252, Kotagede, Daerah Istimewa Yogyakarta", covers[1]);
        listRestoran.add(a);
        a = new Model("Goeboeg Resto", "Komplek Ruko Tandan Raya, JL. Wonosari Km 5, Banguntapan", covers[2]);
        listRestoran.add(a);
        a = new Model("Ayam Goreng Suharti Adisucipto", " Jl. Laksda Adisucipto No.208, Caturtunggal, Kec. Depok, Kabupaten Sleman", covers[3]);
        listRestoran.add(a);
        a = new Model("Canting Restaurant", "Galeria Mall, Galeria Mall Lt. 4 Rooftop, Jalan Sudirman No. 99-101, Daerah Istimewa Yogyakarta", covers[4]);
        listRestoran.add(a);
        a = new Model("Bumbu Desa", "Jalan Kartini No.8, Terban, Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta", covers[5]);
        listRestoran.add(a);
        a = new Model("Warung Bu Ageng", "Jl. Tirtodipuran, No.13, Mantrijeron, Daerah Istimewa Yogyakarta, Indonesia", covers[6]);
        listRestoran.add(a);
        a = new Model("House Of Raminten", " Jalan Faridan Muridan Noto No. 7, Kotabaru, Gondokusuman, Kota Yogyakarta", covers[7]);
        listRestoran.add(a);
        a = new Model("Mediterranea Restaurant by Kamil", "Jalan Tirtodipuran No. 24 A, Mantrijeron, Kota Yogyakarta", covers[8]);
        listRestoran.add(a);
        a = new Model("Bale Raos ", "Jl. Magangan Kulon No.1, Kota Yogyakarta", covers[9]);
        listRestoran.add(a);
        a = new Model("Roaster And Bear", "Jl. Margo Utomo No.52, Gowongan, Jetis, Kota Yogyakarta", covers[10]);
        listRestoran.add(a);
        a = new Model("Madam Tan Classic", "Jalan Jendral Sudirman No.16, Kota Yogyakarta, Daerah Istimewa Yogyakarta, Indonesia", covers[11]);
        listRestoran.add(a);
        a = new Model("R N B Grill", " Jl. R.W. Monginsidi No.37, Karangwaru, Tegalrejo, Kota Yogyakarta", covers[12]);
        listRestoran.add(a);
        a = new Model("Honje Restaurant", "Jalan P. Mangkubumi No. 125, Kota Yogyakarta, Daerah Istimewa Yogyakarta, Indonesia", covers[13]);
        listRestoran.add(a);

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
