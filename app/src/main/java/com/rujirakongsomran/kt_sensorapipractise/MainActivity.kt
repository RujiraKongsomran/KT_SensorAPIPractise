package com.rujirakongsomran.kt_sensorapipractise

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var sensorManager: SensorManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        // get a listing of every sensor on a device by calling the getSensorList()
        val deviceSensors: List<Sensor> =
            sensorManager.getSensorList(Sensor.TYPE_ALL)

    }
}