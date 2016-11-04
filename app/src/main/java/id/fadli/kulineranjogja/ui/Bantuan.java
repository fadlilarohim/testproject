package id.fadli.kulineranjogja.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import id.fadli.kulineranjogja.R;
import id.fadli.kulineranjogja.adapter.BantuanAdapter;

public class Bantuan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.bantuan);
        BantuanAdapter adapterView = new BantuanAdapter(this);
        mViewPager.setAdapter(adapterView);
        setTitle("Bantuan");
    }
}
