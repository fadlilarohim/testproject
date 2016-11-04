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
import id.fadli.kulineranjogja.adapter.GudegAdapter;
import id.fadli.kulineranjogja.model.Model;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by fadli on 1/11/2016.
 */

public class Gudeg extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GudegAdapter adapter;
    private List<Model> listGudeg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miebakso);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_miebakso);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setTitle("Gudeg");

        recyclerView = (RecyclerView) findViewById(R.id.recview_miebakso);

        listGudeg = new ArrayList<>();
        adapter = new GudegAdapter(this, listGudeg);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new SlideInUpAnimator());
        recyclerView.setAdapter(adapter);

        prepareGudeg();

        try {
            Glide.with(this).load(R.drawable.gudeg).into((ImageView) findViewById(R.id.bgheader_miebakso));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareGudeg() {
        int[] covers = new int[]{
                R.drawable.yujum,
                R.drawable.narni,
                R.drawable.sagan,
                R.drawable.pawon,
                R.drawable.hjrini,
                R.drawable.citro,
                R.drawable.permata,
                R.drawable.tekluk,
                R.drawable.amad,
                R.drawable.juminten,
                R.drawable.gudeg,};

        Model a = new Model("Gudeg Yu Djum Wijilan", "Jalan Wijilan No.167, Yogyakarta, Daerah Istimewa Yogyakarta", covers[0]);
        listGudeg.add(a);
        a = new Model("Gudeg Yu Narni", "Gang Kebondalem, Jalan Margo Utomo, Kota Yogyakarta, Daerah Istimewa Yogyakarta, Indonesia", covers[1]);
        listGudeg.add(a);
        a = new Model("Gudeg Sagan", "Jalan Professor Dr Herman Yohanes No.53, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55223", covers[2]);
        listGudeg.add(a);
        a = new Model("Gudeg Pawon", "Jl. Janturan UH/IV No. 36, Umbulharjo, Kota Yogyakarta", covers[3]);
        listGudeg.add(a);
        a = new Model("Gudeg Bu Hj Rini", "Jl. Wijilan No.7, Panembahan, Kraton, Kota Yogyakarta", covers[4]);
        listGudeg.add(a);
        a = new Model("Gudeg Bu Tjitro 1925", "Jalan Janti No. 330, Banguntapan, Bantul", covers[5]);
        listGudeg.add(a);
        a = new Model("Gudeg Permata", "Jalan Gajah Mada, Purwo Kinanti, Pakualaman, Kota Yogyakarta", covers[6]);
        listGudeg.add(a);
        a = new Model("Gudeg Bromo Bu Tekluk", "Jalan Gejayan No. 2C, Depok, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55281", covers[7]);
        listGudeg.add(a);
        a = new Model("Gudeg Bu Hj. Amad", "Jl. Kaliurang Km. 4.5, Kec. Sleman, Daerah Istimewa Yogyakarta", covers[8]);
        listGudeg.add(a);
        a = new Model("Gudeg Juminten", "Jalan Asem Gede No.14, Daerah Istimewa Yogyakarta, Indonesia", covers[9]);
        listGudeg.add(a);
        a = new Model("Sentra Gudeg Wijilan", "Wijilan", covers[10]);
        listGudeg.add(a);
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
