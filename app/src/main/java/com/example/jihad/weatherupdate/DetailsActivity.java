package com.example.jihad.weatherupdate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.jihad.weatherupdate.MainActivity.listData;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView imageView = (ImageView) findViewById(R.id.weatherMainImage);
        TextView descriptionView = (TextView) findViewById(R.id.description);
        TextView cityView = (TextView) findViewById(R.id.city);
        TextView dateView = (TextView) findViewById(R.id.date);
        TextView maxView = (TextView) findViewById(R.id.max);
        TextView minView = (TextView) findViewById(R.id.min);
        TextView humidityView = (TextView) findViewById(R.id.humidity);


        Intent i = getIntent();
        int pos = i.getIntExtra("pos",0);

        WeatherData data = listData.get(pos);


        long sec = Long.parseLong(listData.get(pos).getDt());
        Date date = new Date(sec*1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String newDate = dateFormat.format(date);

        String url = "http://openweathermap.org/img/w/"+listData.get(pos).getIcon()+".png";
        Glide.with(this).load(url).into(imageView);

        descriptionView.setText(data.getDescription());
        cityView.setText("Dhaka");
        dateView.setText(newDate);
        maxView.setText("Max Temp: "+data.getMax()+ "C");
        minView.setText("Min Temp: "+data.getMin()+ "C");
        humidityView.setText("Humidity: "+data.getHumidity());


    }
}
