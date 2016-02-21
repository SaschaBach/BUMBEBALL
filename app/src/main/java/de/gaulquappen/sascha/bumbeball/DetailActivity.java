package de.gaulquappen.sascha.bumbeball;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Sascha on 21.02.16.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent caller = getIntent();
        final int detailPic = caller.getIntExtra(MainActivity.EXTRA_DETAIL_PIC, -99);

        ImageView imageView = (ImageView) findViewById(R.id.detail_image);
        //noinspection deprecation
        imageView.setImageDrawable(getResources().getDrawable(detailPic));

        FloatingActionButton cardboardButton = (FloatingActionButton) findViewById(R.id.cardboard_button);
        cardboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(DetailActivity.class.getName(), "Open Cardboard View");

                Intent detailIntent = new Intent(getApplicationContext(), CardboardViewActivity.class);
                detailIntent.putExtra(MainActivity.EXTRA_DETAIL_PIC, detailPic);
                startActivity(detailIntent);
            }
        });

    }

}
