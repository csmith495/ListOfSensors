package com.example.listofsensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var sensorManager: SensorManager
private val sensorsAdapter = SensorListAdapter(arrayListOf())
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
        var sb: StringBuilder = StringBuilder()

        val recyclerview = findViewById<RecyclerView>(R.id.sensorRV)

        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<com.example.listofsensors.Sensor>()

        for(deviceSensor in deviceSensors) {
            data.add(Sensor(R.drawable.baseline_sensors_24, deviceSensor.name, deviceSensor.vendor))
        }

        val adapter = SensorListAdapter(data)

        recyclerview.adapter = adapter
    }
}