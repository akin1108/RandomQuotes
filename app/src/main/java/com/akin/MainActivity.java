package com.akin.randomquotes;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    Button b1;

private int backgrounds[]={R.drawable.images,R.drawable.image,R.drawable.images2,R.drawable.images3,R.drawable.images4,R.drawable.images5,R.drawable.images6,};
    private  String quotes[] = {"Smooth runs the water where the brook is deep","Live Life Livingly","You cry,you fall.\nYou fight,you rise","Pour in love n care to see the change","To see the change,be the change"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1= findViewById(R.id.textview);
        b1 = findViewById(R.id.button);
       final RelativeLayout rl = findViewById(R.id.relative);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int num = random.nextInt(quotes.length);
                t1.setText(quotes[num]);
                t1.setTextIsSelectable(true);
                b1.setText("More!!");
                Random random1 = new Random();
                int img=random1.nextInt(backgrounds.length);
                rl.setBackgroundResource(backgrounds[img]);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.menu:
               String toshare = t1.getText().toString();
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT,toshare);
            intent.setType("text/plain");
            startActivity(intent);
            default:return super.onOptionsItemSelected(menuItem);
        }

    }
}
