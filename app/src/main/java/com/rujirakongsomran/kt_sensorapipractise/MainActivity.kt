package com.rujirakongsomran.kt_sensorapipractise

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var proximitySensor: Sensor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        // Get a listing of every sensor on a device by calling the getSensorList()
        // val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)


    }

    override fun onSensorChanged(p0: SensorEvent?) {
        val distance = p0?.values?.get(0)
        // Do something with this sensor data
        Log.d("distance", distance.toString())
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        // Do something here if sensor accuracy change
    }

    override fun onResume() {
        super.onResume()

        proximitySensor?.also { proximity ->
            sensorManager.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}