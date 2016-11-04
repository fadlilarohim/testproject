package id.fadli.kulineranjogja.bakmie;

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

public class rebo extends AppCompatActivity {

    private TextView title, tel, map, deskripsi;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_bakso);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail_bakso);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setTitle("Bakmi Jawa Pak Rebo");

        title = (TextView) findViewById(R.id.txt_detail_bakso);
        tel = (TextView) findViewById(R.id.txt_tel_bakso);
        map = (TextView) findViewById(R.id.txt_map_bakso);
        deskripsi = (TextView) findViewById(R.id.txt_deskripsi_bakso);
        button = (Button) findViewById(R.id.Goto);

        title.setText("Bakmi Jawa Pak Rebo Kintelan");
        tel.setText("+62 817-5410-904");
        map.setText(R.string.rebo_alamat);
        deskripsi.setText(R.string.rebo_deskripsi);

        tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "+62 817-5410-904";
                Uri call = Uri.parse("tel:" + number);
                Intent surf = new Intent(Intent.ACTION_DIAL, call);
                startActivity(surf);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=&daddr=" + -7.812216 + "," + 110.368899));

                startActivity(intent);
            }
        });
    }
}
