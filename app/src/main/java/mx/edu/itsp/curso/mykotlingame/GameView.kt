package mx.edu.itsp.curso.mykotlingame


import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.SurfaceHolder
import android.view.SurfaceView


class GameView(context:Context) : SurfaceView(context),android.view.SurfaceHolder.Callback {
    lateinit var thread:MainThread
    lateinit var characterSprite: CharacterSprite


    init {
        holder.addCallback(this)
        thread=MainThread(holder,this)
        setFocusable(true)
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        var retry:Boolean=true
        while(retry){
            thread.running=false
            thread.join()
        }
        retry=false
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        thread.running=true
        thread.start()
        characterSprite= CharacterSprite(BitmapFactory.decodeResource(resources,R.drawable.spriteboy))
    }

    fun update(){
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        if(canvas!=null){
            characterSprite.draw(canvas)
        }
    }
}