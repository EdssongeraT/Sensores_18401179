package mx.edu.ittepic.sensorescanvas_18401179

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class acelerometro (mainActivity: MainActivity,lienzo: Lienzo){
    lateinit var sensorManager: SensorManager
    var mainActivity = mainActivity
    var sensor: Sensor?=null

    fun iniciarSensor(){
        sensorManager = mainActivity.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        if(sensor!=null){
            sensorManager.registerListener(sensorLis,sensor, SensorManager.SENSOR_DELAY_NORMAL,SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    private var sensorLis: SensorEventListener?=object : SensorEventListener {
        override fun onSensorChanged(evento: SensorEvent?) {
            if (evento?.sensor?.type == Sensor.TYPE_ACCELEROMETER){
                val  x = evento.values[0]
                val y = evento.values[1]

                lienzo.moverNubes(x,y)
            }
        }

        override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

        }

    }
}