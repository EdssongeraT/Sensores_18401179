package mx.edu.ittepic.sensorescanvas_18401179

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Nube(l:Lienzo,x:Float,y:Float) {
    val l = l
    var x = x
    var y = y

    fun pintar(c:Canvas){
        var p = Paint()
        p.color = Color.WHITE
        c.drawCircle(x,y,100f,p)
        c.drawCircle(x+100f,y,100f,p)
        c.drawCircle(x-100f,y,100f,p)
        c.drawCircle(x+50f,y-100f,100f,p)
        c.drawCircle(x-50f,y-100f,100f,p)
    }
}