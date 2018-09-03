package com.example.kvanamacair4.asynctask.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kvanamacair4.asynctask.R;
import com.grumpyshoe.module.locationmanager.LocationManager;
import com.grumpyshoe.module.locationmanager.impl.LocationManagerImpl;

public class LocationManagerActivity extends AppCompatActivity {

    private LocationManager locationManager;
    Button btn_last_location, btn_tracker_start, btn_tracker_stop;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_manager);
        btn_last_location = findViewById(R.id.btn_last_location);
        btn_tracker_start = findViewById(R.id.btn_tracker_start);
        btn_tracker_stop = findViewById(R.id.btn_tracker_stop);
        result = findViewById(R.id.result);

        locationManager = new LocationManagerImpl();
        // get last location
        btn_last_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
}
}
