package com.example.listofsensors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SensorListAdapter(var sensors: ArrayList<Sensor>): RecyclerView.Adapter<SensorListAdapter.SensorViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SensorListAdapter.SensorViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_sensor, parent, false)

        return SensorViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SensorListAdapter.SensorViewHolder, position: Int) {
        holder.bind(sensors[position])
    }

    override fun getItemCount() = sensors.size

    class SensorViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val sensorName = view.findViewById<TextView>(R.id.sensorName)
        private val sensorVendor = view.findViewById<TextView>(R.id.sensorVendor)

        fun bind(sensor: Sensor) {
            sensorName.text = sensor.sensorName
            sensorVendor.text = sensor.sensorVendor
        }
    }
}