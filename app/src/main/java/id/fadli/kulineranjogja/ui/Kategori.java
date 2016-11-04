package id.fadli.kulineranjogja.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
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
import id.fadli.kulineranjogja.adapter.KategoriAdapter;
import id.fadli.kulineranjogja.model.MenuKategori;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class Kategori extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView recKategori;
    private KategoriAdapter adapter;
    private List<MenuKategori> kategoriList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_kategori);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setTitle("Explore Kuliner");

        recKategori = (RecyclerView) findViewById(R.id.recview_kategori);

        kategoriList = new ArrayList<>();
        adapter = new KategoriAdapter(this, kategoriList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recKategori.setLayoutManager(mLayoutManager);
        recKategori.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recKategori.setItemAnimator(new SlideInUpAnimator());
        recKategori.setAdapter(adapter);

        prepareKategori();

        try {
            Glide.with(this).load(R.drawable.kategori).into((ImageView) findViewById(R.id.bgheader_kategori));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void prepareKategori() {
        int[] covers = new int[]{
                R.drawable.bakso,
                R.drawable.bakmi,
                R.drawable.mieayam,
                R.drawable.restoran,
                R.drawable.nasigoreng,
                R.drawable.kopi,
                R.drawable.gudeg,
                R.drawable.oleh,};
        MenuKategori
                a = new MenuKategori("Bakso", "Untuk kamu pencinta makanan Bakso ", covers[0]);
        kategoriList.add(a);
        a = new MenuKategori("Bakmi", "Bakmi jawa khas Jogjakarta", covers[1]);
        kategoriList.add(a);
        a = new MenuKategori("Mie Ayam", "Mie Ayam paling hits di Jogjakarta", covers[2]);
        kategoriList.add(a);
        a = new MenuKategori("Restoran", "Restoran di Jogjakarta", covers[3]);
        kategoriList.add(a);
        a = new MenuKategori("Nasi Goreng", "Tempat-tempat nasi goreng terasik dan enak", covers[4]);
        kategoriList.add(a);
        a = new MenuKategori("Coffee", "Nongkrong asik dengan suasana khas Jogja", covers[5]);
        kategoriList.add(a);
        a = new MenuKategori("Gudeg", "Mampir ke Jogja belum lengkap kalo belum makan Gudeg", covers[6]);
        kategoriList.add(a);
        a = new MenuKategori("Oleh-oleh", "Tempat cari buah tangan untuk keluarga kamu", covers[7]);
        kategoriList.add(a);
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

