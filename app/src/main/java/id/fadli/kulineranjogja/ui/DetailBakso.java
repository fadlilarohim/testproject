package id.fadli.kulineranjogja.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import id.fadli.kulineranjogja.R;
import id.fadli.kulineranjogja.model.MieBaksoModel;

/**
 * Created by fadli on 30/10/2016.
 */

public class DetailBakso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_bakso);

        Bundle bundle = getIntent().getExtras();
        String stuff = bundle.getString("stuff");


    }
}
