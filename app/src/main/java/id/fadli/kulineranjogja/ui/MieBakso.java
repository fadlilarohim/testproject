package id.fadli.kulineranjogja.ui;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
import id.fadli.kulineranjogja.adapter.MieBaksoAdapter;
import id.fadli.kulineranjogja.model.MenuKategori;
import id.fadli.kulineranjogja.model.MieBaksoModel;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by fadli on 28/10/2016.
 */

public class MieBakso extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MieBaksoAdapter adapter;
    private List<MieBaksoModel> mieBaksoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miebakso);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_miebakso);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setTitle("Bakso");

        recyclerView = (RecyclerView) findViewById(R.id.recview_miebakso);

        mieBaksoList = new ArrayList<>();
        adapter = new MieBaksoAdapter(this, mieBaksoList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new SlideInUpAnimator());
        recyclerView.setAdapter(adapter);

        prepareMieBakso();

        try {
            Glide.with(this).load(R.drawable.baksoup).into((ImageView) findViewById(R.id.bgheader_miebakso));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareMieBakso() {
        int[] covers = new int[]{
                R.drawable.klenger,
                R.drawable.bethesda,
                R.drawable.jawi,
                R.drawable.telkom,
                R.drawable.ito,
                R.drawable.tengkleng,
                R.drawable.narto,
                R.drawable.blangkon,
                R.drawable.karno,
                R.drawable.ironayan,
                R.drawable.tembak,
                R.drawable.granatz,
                R.drawable.baskom,
                R.drawable.idola,
                R.drawable.krikil,
                R.drawable.sronto,};

        MieBaksoModel
                a = new MieBaksoModel("Bakso Klenger Ratu Sari", "Jalan Nologaten 296 Ambarukmo Depok Sleman Yogyakarta ", covers[0]);
        mieBaksoList.add(a);
        a = new MieBaksoModel("Bakso Bethesda", "Jalan Johar Nurhadi, Kotabaru, Gondokusuman", covers[1]);
        mieBaksoList.add(a);
        a = new MieBaksoModel("Bakso Jawi Bu Miyar", "Jalan Jogonegaran No.55D, Kota Yogyakarta", covers[2]);
        mieBaksoList.add(a);
        a = new MieBaksoModel("Bakso Telkom Utomo", "Jalan Kenari Timoho No.61, Daerah Istimewa Yogyakarta", covers[3]);
        mieBaksoList.add(a);
        a = new MieBaksoModel("Bakso Ito", "Jalan Mataram No.59, Suryatmajan, Danurejan", covers[4]);
        mieBaksoList.add(a);
        a = new MieBaksoModel("Bakso Tengkleng Mas Bambang Jogja", "Jl. Monjali No. 80, Sleman, Daerah Istimewa Yogyakarta", covers[5]);
        mieBaksoList.add(a);
        a = new MieBaksoModel("Bakso Pak Narto", "Jl. Affandi, Caturtunggal, Kec. Depok, Kabupaten Sleman", covers[6]);
        mieBaksoList.add(a);
        a = new MieBaksoModel("Mie Bakso Mr. Blangkon", "JL Kaliurang, KM. 14,5, Degolan, Sleman", covers[7]);
        mieBaksoList.add(a);
        a = new MieBaksoModel("Bakso Malang Cak Karno", "Jalan MT. Haryono No. 68, Suryodiningratan, Mantrijeron, Kota Yogyakarta", covers[8]);
        mieBaksoList.add(a);
        a = new MieBaksoModel("Bakso Ironayan", "JL Kaliurang, KM. 14,5, Degolan, Sleman", covers[9]);
        mieBaksoList.add(a);
        a = new MieBaksoModel("Bakso Lapangan Tembak", "LG Blok A2 No.3, Plaza Ambarrukmo, Jalan Laksda Adisucipto, Catur Tunggal, Kecamatan Depok, Kabupaten Sleman", covers[10]);
        mieBaksoList.add(a);
        a = new MieBaksoModel("Bakso Granatz", "Ruko Babarsari, Jalan Raya Babarsari Babarsari, Jl. Babarsari No.44, Sleman", covers[11]);
        mieBaksoList.add(a);
        a = new MieBaksoModel("BASKOM (Bakso Komplit)", "Jalan Wonosari KM.9, RT.06 / RW.05, Sendang Tirto, Berbah, Kabupaten Sleman", covers[12]);
        mieBaksoList.add(a);
        a = new MieBaksoModel("Bakso Idolaku", "Jalan Taman Siswa No. 100, Daerah Istimewa Yogyakarta", covers[13]);
        mieBaksoList.add(a);
        a = new MieBaksoModel("Bakso Krikil Pak Supri", "Jalan Godean Km.5 No.105, Gamping, Sleman", covers[14]);
        mieBaksoList.add(a);
        a = new MieBaksoModel("Bakso Pak Sronto", "Jl. Letjen Suprapto, Ngampilan, Kota Yogyakarta", covers[15]);
        mieBaksoList.add(a);
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
