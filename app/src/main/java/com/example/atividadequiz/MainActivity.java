package com.example.atividadequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView textView;

    SensorManager sensorManager;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        sensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    }
    @Override
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this,sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void jogar(View a) {
        Intent intent = new Intent(this, quiz1.class);
        startActivity(intent);
    }

    public void credito(View b) {
        Intent intent = new Intent(this, configuracao.class);
        startActivity(intent);
    }

    public void site(View j) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://masp.org.br/"));
        startActivity(intent);
    }

    public void local(View q) {
        Intent intent = new Intent(this, mapa.class);
        startActivity(intent);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.sensor.getType() == Sensor.TYPE_LIGHT){
          textView.setText("" + event.values[0]);
      }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

