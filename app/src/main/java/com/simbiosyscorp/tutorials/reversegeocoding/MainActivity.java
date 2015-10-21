package com.simbiosyscorp.tutorials.reversegeocoding;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText lat,lon;
    Button getAddressBtn;
    TextView addressDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAddressBtn= (Button) findViewById(R.id.address);
        lat= (EditText) findViewById(R.id.lat);
        lon= (EditText) findViewById(R.id.lon);
        addressDisplay= (TextView) findViewById(R.id.adressText);
        getAddressBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //Making an instance of Geocoder
        //getFromLocation function of the Geocoder class takes
        // Location as parameter and returns addresses
        Geocoder geocoder=new Geocoder(getApplicationContext());
        List<Address> addresses;
        try {
            addresses=geocoder.getFromLocation(Double.parseDouble(lat.getText().toString()),Double.parseDouble(lon.getText().toString()),1);
            addressDisplay.setText("Address :"+addresses.get(0).getAddressLine(0)+"    "+addresses.get(0).getCountryName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
});
    }


}
