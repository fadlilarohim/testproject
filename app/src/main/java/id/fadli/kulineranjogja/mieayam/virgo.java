package id.fadli.kulineranjogja.mieayam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import id.fadli.kulineranjogja.R;

/**
 * Created by fadli on 1/11/2016.
 */

public class virgo extends AppCompatActivity {

    private TextView title, tel, map, deskripsi;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_bakso);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail_bakso);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setTitle("Mie Ayam Virgo");

        title = (TextView) findViewById(R.id.txt_detail_bakso);
        tel = (TextView) findViewById(R.id.txt_tel_bakso);
        map = (TextView) findViewById(R.id.txt_map_bakso);
        deskripsi = (TextView) findViewById(R.id.txt_deskripsi_bakso);
        button = (Button) findViewById(R.id.Goto);

        title.setText("Mie Ayam Virgo");
        tel.setText("+62 818-0266-1950");
        map.setText(R.string.virgo_alamat);
        deskripsi.setText(R.string.virgo_deskripsi);

        tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "+62 818-0266-1950";
                Uri call = Uri.parse("tel:" + number);
                Intent surf = new Intent(Intent.ACTION_DIAL, call);
                startActivity(surf);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=&daddr="+ -7.802484+","+ 110.409283));

                startActivity(intent);
            }
        });
    }
}
