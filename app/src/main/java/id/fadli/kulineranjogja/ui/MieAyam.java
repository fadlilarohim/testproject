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
import id.fadli.kulineranjogja.adapter.MieAyamAdapter;
import id.fadli.kulineranjogja.model.Model;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by fadli on 1/11/2016.
 */

public class MieAyam extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MieAyamAdapter adapter;
    private List<Model> listMieAyam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miebakso);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_miebakso);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setTitle("Mie Ayam");

        recyclerView = (RecyclerView) findViewById(R.id.recview_miebakso);

        listMieAyam = new ArrayList<>();
        adapter = new MieAyamAdapter(this, listMieAyam);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new SlideInUpAnimator());
        recyclerView.setAdapter(adapter);

        prepareMieAyam();

        try {
            Glide.with(this).load(R.drawable.mieayam).into((ImageView) findViewById(R.id.bgheader_miebakso));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareMieAyam() {
        int[] covers = new int[]{
                R.drawable.tumini,
                R.drawable.virgo,
                R.drawable.masno,
                R.drawable.kuli,
                R.drawable.pelangi,
                R.drawable.idola,
                R.drawable.afui,
                R.drawable.ijo,
                R.drawable.terbang,
                R.drawable.jaya,
                R.drawable.thoyonk,
                R.drawable.sogi,};

        Model a = new Model("Mie Ayam Bu Tumini Sarirasa Jatiayu", "Jalan Imogiri Timur No. 187, Yogyakarta ", covers[0]);
        listMieAyam.add(a);
        a = new Model("Mie Ayam Virgo", " JL. Wonocatur, Banguntapan, Daerah Istimewa Yogyakarta, Indonesia", covers[1]);
        listMieAyam.add(a);
        a = new Model("Mie Ayam Mas No", "Jl. Munggur, Demangan, Gondokusuman, Kota Yogyakarta", covers[2]);
        listMieAyam.add(a);
        a = new Model("Mie Ayam Sekarsuli", "Banguntapan, Bantul Regency, Special Region of Yogyakarta, Indonesia", covers[3]);
        listMieAyam.add(a);
        a = new Model("Mie Ayam Pelangi", " Jl. Gedong Kuning No.96, Rejowinangun, Kotagede, Kota Yogyakarta", covers[4]);
        listMieAyam.add(a);
        a = new Model("Mie Ayam Idolaku Pak Tikno", "Jl. Tamansiswa No.138, Wirogunan, Mergangsan, Kota Yogyakarta", covers[5]);
        listMieAyam.add(a);
        a = new Model("Mie Ayam Palembang AFUI", "Jl. Parangtritis, Daerah Istimewa Yogyakarta 55143, Indonesia", covers[6]);
        listMieAyam.add(a);
        a = new Model("Mie Ayam Ijo Tunggal Rasa", " Jalan Sagan Utara, Gondokusuman, Kota Yogyakarta", covers[7]);
        listMieAyam.add(a);
        a = new Model("Mie Ayam Terbang", "Jl. Taman Siswa, Yogyakarta", covers[8]);
        listMieAyam.add(a);
        a = new Model("Mie Ayam Bakso Urat Kharisma Jaya", " Jalan Maguwo No. 01, Banguntapan, Bantul", covers[9]);
        listMieAyam.add(a);
        a = new Model("Mie Ayam Pak Thoyonk", "Jl. Prof. Herman Yohannes (300 meter utara Galeria Mall)", covers[10]);
        listMieAyam.add(a);
        a = new Model("Mie Ayam Sogi", "Jalan Raya Tajem, Depok", covers[11]);
        listMieAyam.add(a);

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
