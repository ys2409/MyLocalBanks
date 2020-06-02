package sg.edu.rp.c346.id19022397.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView tvDbs;
    TextView tvOCbc;
    TextView tvUob;
    String click;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDbs = findViewById(R.id.tVdbs);

        registerForContextMenu(tvDbs);

        tvOCbc = findViewById(R.id.tVocbc);

        registerForContextMenu(tvOCbc);

        tvUob = findViewById(R.id.tVuob);

        registerForContextMenu(tvUob);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");


        if (v.getId() == tvDbs.getId()) {

            click = "DBS";

        } else if (v.getId() == tvOCbc.getId()) {
            click = "OCBC";
        } else if (v.getId() == tvUob.getId()) {
            click = "UOB";
        } else {
            click = "";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) {
            if (click.equalsIgnoreCase("DBS")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intent);

            } else if (click.equalsIgnoreCase("OCBC")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/group-home.html"));

                startActivity(intent);
            } else {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg/personal/index.page"));

                startActivity(intent);
            }

        }



        else if (item.getItemId() == 1) {
            if (click.equalsIgnoreCase("DBS")) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800+"-"+111+"-"+ 1111));

            } else if (click.equalsIgnoreCase("OCBC")) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800+"-" +363+"-"+ 3333));

                startActivity(intent);
            } else {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + 1800+"-"+222+"-"+ 2121));

                startActivity(intent);
            }

        }

        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();
        if (id == R.id.EnglishSelection) {
            tvDbs.setText("@string/bank1");
            tvOCbc.setText("@string/bank2");
            tvUob.setText("@string/bank3");

            return true;
        } else if (id == R.id.ChineseSelection) {


            tvDbs.setText("星展银行");
            tvOCbc.setText("华侨银行");
            tvUob.setText("大华银行");

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
