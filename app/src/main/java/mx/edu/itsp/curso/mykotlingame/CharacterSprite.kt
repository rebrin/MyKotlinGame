package mx.edu.itsp.curso.mykotlingame

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect

class CharacterSprite(var image:Bitmap) {
    var x: Int
    var y: Int
    var xVelocity=10
    var yVelocity=5
    var screenWidth=0
    var screenHeight=0
    //filas y columnas del sprite
    val NUM_FILAS:Int=4
    val NUM_COLS:Int=4
    //ancho y alto de nuestra imagen
    var width=image.width/NUM_COLS
    var height=image.height/NUM_FILAS
    //va a contar el cuadro de sprite que estoy mostrando
    var currentFrame=0


    init {
        x = 100
        y = 100
        screenWidth= Resources.getSystem().displayMetrics.widthPixels
        screenHeight= Resources.getSystem().displayMetrics.heightPixels
    }


    fun draw(canvas: Canvas){
        update()
        var srcX=currentFrame*width
        var srcY= 3*height
        var src:Rect=Rect(srcX,srcY,srcX+width,srcY+height)
        var dest:Rect=Rect(x, y, (x+width), (y+height))
        canvas.drawBitmap(image,src,dest,null)

    }

    fun update(){
        x=x+xVelocity
        y =y+yVelocity
        if(x<0 || x>screenWidth-width)
            xVelocity*=-1
        if(y>screenHeight-height||y<0)
            yVelocity*=-1
        currentFrame=++currentFrame % NUM_COLS
    }
}