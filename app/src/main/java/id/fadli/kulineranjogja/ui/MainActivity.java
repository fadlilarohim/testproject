package id.fadli.kulineranjogja.ui;


import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.CollapsingToolbarLayout;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import id.fadli.kulineranjogja.R;
import id.fadli.kulineranjogja.adapter.MenuAdapter;
import id.fadli.kulineranjogja.model.MenuAwal;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MenuAdapter adapter;
    private List<MenuAwal> homeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        //Recycler View
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        homeList = new ArrayList<>();
        adapter = new MenuAdapter(this, homeList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new SlideInUpAnimator());
        recyclerView.setAdapter(adapter);

        prepareMenu();

        try {
            Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.bgheader));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void prepareMenu(){
        int[] covers = new int[]{
                R.drawable.tentang,
                R.drawable.explore,
                R.drawable.profile,
                R.drawable.bantuan,};
        MenuAwal a = new MenuAwal("Tentang", covers[0]);
        homeList.add(a);
        a = new MenuAwal("Explore kuliner", covers[1]);
        homeList.add(a);
        a = new MenuAwal("Profil", covers[2]);
        homeList.add(a);
        a = new MenuAwal("Bantuan", covers[3]);
        homeList.add(a);
    }

    //Recylcer View Decoration
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