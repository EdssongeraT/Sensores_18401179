package mx.edu.ittepic.sensorescanvas_18401179

import android.content.Context
import android.graphics.BitmapFactory
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var lienzo = Lienzo(this)
        setContentView(lienzo)

        var sensor = sensorProximidad(this,lienzo)
        sensor.iniciarSensor()

        var acelerome=acelerometro(this,lienzo)
        acelerome.iniciarSensor()
    }



}