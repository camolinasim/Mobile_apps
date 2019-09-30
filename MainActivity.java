package edu.utep.cs.cs4330.mypricewatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.widget.TextView;

import android.view.View;

import android.widget.Button;

import java.util.Random;


import java.text.DecimalFormat;

import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.randomizer);
    }

    /**
     *controller for current price and percentage change behaviors
     * @param v the name of the textview to be modified
     */
    public void randomizerClicked(View v)
    {
        TextView tv = findViewById(R.id.currentPriceText);
        Random r = new Random();
        int low = 1;
        int high = 254;
        int random = r.nextInt(high-low) + low;
        tv.setText("Current Price: $" + random);

        TextView ratio = findViewById(R.id.percentageText);
        double percentage = getPercentage(255, random);
        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(percentage);
        ratio.setText("Percentage Change: " + formatted + "%");


    }

    /**
     * helper method to get the discount percentage of an item given its initial and current price
     * @param originalPrice initial price
     * @param newPrice current price
     * @return the percentage (represents how much cheaper the item is)
     */
    public double getPercentage(int originalPrice, int newPrice){
        double diff = originalPrice - newPrice;
        double percentage = (diff/originalPrice) * 100;
        return percentage;
    }

    /**
     * Takes you directly to Amazon.com
     * @param view
     */
    public void goToAmazon(View view) {
        String link = "https://www.amazon.com/Google-Nest-GA00639US-Hub-Assistant/dp/B07WWK1C5S/ref=sr_1_2?keywords=google+home+hub&qid=1569819586&sr=8-2";

        goToUrl (link);
    }

    /**
     * Helper method to go to any website
     * @param url the url of the website you want to visit
     */
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
