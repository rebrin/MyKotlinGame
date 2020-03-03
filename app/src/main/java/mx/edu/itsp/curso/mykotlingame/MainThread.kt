package mx.edu.itsp.curso.mykotlingame

import android.graphics.Canvas
import android.view.SurfaceHolder

class MainThread(var surfaceHolder: SurfaceHolder,var gameView: GameView):Thread(){
    //atributos de clase
    var running:Boolean=true
    lateinit var canvas:Canvas

    override fun run() {
        while (running) {
            canvas=surfaceHolder.lockCanvas()
            synchronized(surfaceHolder){

                gameView.update()
                gameView.draw(canvas)

                if(canvas!= null)
                surfaceHolder.unlockCanvasAndPost(canvas)
            }
        }
    }
}