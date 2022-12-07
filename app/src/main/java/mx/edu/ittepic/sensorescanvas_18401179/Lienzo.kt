package mx.edu.ittepic.sensorescanvas_18401179

import android.content.Context
import android.graphics.*
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.view.View

class Lienzo(activity: MainActivity):View(activity) {
    var activity=activity
    var noche=false
    var colorSol = Color.YELLOW
    var colorCielo = Color.CYAN
    var xs = arrayOf(300f,800f,400f,800f,300f)
    var ys = arrayOf(300f,700f,1000f,1400f,1800f)
    var maxX=0f
    var maxY=0f
    var solx =1000f
    var soly =0f

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()
        //---------------sol/luna-----------------
        p.color = colorSol
        c.drawCircle(solx,soly,400f,p)
        //----------------nubes--------------------
        var nube1 = Nube(this,xs[0],ys[0])
        var nube2 = Nube(this,xs[1],ys[1])
        var nube3 = Nube(this,xs[2],ys[2])
        var nube4 = Nube(this,xs[3],ys[3])
        var nube5 = Nube(this,xs[4],ys[4])
        nube1.pintar(c)
        nube2.pintar(c)
        nube3.pintar(c)
        nube4.pintar(c)
        nube5.pintar(c)
        //--------------bruja---------------------
        val imagen = BitmapFactory.decodeResource(activity.resources,R.drawable.bruja)
        val imagenReajuste = Bitmap.createScaledBitmap(imagen,300,300,true)
        c.drawBitmap(imagenReajuste,400f,800f,p)
        //--------------cielo-------------------
        setBackgroundColor(colorCielo)
    }
    
    fun cambiarhora(){
        if(noche){
            noche=false
            colorSol= Color.YELLOW
            colorCielo= Color.CYAN
        }else{
            noche=true
            colorSol= Color.GRAY
            colorCielo= Color.rgb(0,0,102)
        }
        invalidate()
    }

    fun moverNubes(lx:Float,ly:Float){
        var auxx=0f
        var auxy=0f
        maxX+=lx*2
        println("x-----------------------------"+maxX)
        maxY+=ly*2
        println("y-----------------------------"+maxY)
        if (maxX<180f&&maxX>-180f){
            xs[0] += lx
            xs[1] += lx
            xs[2] += lx
            xs[3] += lx
            xs[4] += lx
            solx += lx
        }else if (maxX>180f){
        maxX=180f
        }else{
            maxX=-180f
        }

        if (maxY<200f&&maxY>-200f) {
            ys[0] += ly
            ys[1] += ly
            ys[2] += ly
            ys[3] += ly
            ys[4] += ly
            soly += ly
        }else if (maxY>200f){
            maxY=200f
        }else{
            maxY=-200f
        }


        invalidate()
    }
    
}