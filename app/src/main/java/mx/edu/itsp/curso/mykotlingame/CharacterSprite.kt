package mx.edu.itsp.curso.mykotlingame

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas

class CharacterSprite(var image:Bitmap) {
    private var x: Float
    private var y: Float
    var xVelocity=10
    var yVelocity=5
    var screenWidth=0
    var screenHeight=0

    init {
        x = 100f
        y = 100f
        screenWidth= Resources.getSystem().displayMetrics.widthPixels
        screenHeight= Resources.getSystem().displayMetrics.heightPixels
    }


    fun draw(canvas: Canvas){
        update()
        canvas.drawBitmap(image,x,y,null)
    }

    fun update(){
        x=x+xVelocity
        y =y+yVelocity
        if(x<0 || x>screenWidth-image.width)
            xVelocity*=-1
        if(y>screenHeight-image.height||y<0)
            yVelocity*=-1
    }

}