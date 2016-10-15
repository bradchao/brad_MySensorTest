package brad.tw.mysensortest;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager mSensorManager;
    private Sensor sensor;
    private MySensorListener listener;
    private MyView myview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> deviceSensors =
                mSensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : deviceSensors){
            String name = sensor.getName();
            String type = "";
            if(Build.VERSION.SDK_INT>=20) {
                type = sensor.getStringType();
            }
            String vendor = sensor.getVendor();
            Log.v("brad", name + ":" + type + ":" + vendor);
        }

        sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//        sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (sensor == null){

        }

        myview = (MyView)findViewById(R.id.myview);


    }

    private class MySensorListener implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] vs = event.values;
            float x = vs[0];
            float y = vs[1];
            float z = vs[2];
            myview.setXY(x,y);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        listener = new MySensorListener();
        mSensorManager.registerListener(listener,sensor,
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(listener);
    }
}
