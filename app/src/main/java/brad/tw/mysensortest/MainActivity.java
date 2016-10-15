package brad.tw.mysensortest;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager mSensorManager;

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


    }
}
