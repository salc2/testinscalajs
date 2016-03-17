package tutorial.webapp

import org.scalajs.dom._
import org.scalajs.dom.raw.{HTMLDivElement, HTMLCanvasElement}
import scala.scalajs._
import scala.scalajs.js.annotation.JSName

@JSName("p5")
@js.native
class P5(sketch:js.Function,sel:String=null,sync:Boolean=false) extends js.Object

@js.native
trait P5Instance extends js.Object{
  def createCanvas(width:Int,height:Int):HTMLCanvasElement = js.native
  var setup:js.Function
  var draw:js.Function
  var mouseIsPressed:Boolean = js.native
  def fill(args:Int*):Unit = js.native
  def ellipse(x:Double,y:Double,w:Double,h:Double):Unit = js.native
  var mouseX:Double = js.native
  var mouseY:Double = js.native
  val displayWidth:Double = js.native
  val displayHeight:Double = js.native
}

object TutorialApp extends js.JSApp {
    val sketch: js.Function = (p5:P5Instance) => {
    p5.setup = () =>{
      val width = (p5.displayWidth*0.8).toInt
      val height = (p5.displayHeight*0.8).toInt
      p5.createCanvas(width , height)
      document.querySelector("#canvas-container").
        asInstanceOf[HTMLDivElement].style.width = s"${width}px"
    }

    p5.draw = () =>{
      if(p5.mouseIsPressed){
          p5.fill(0)
      }else{
        p5.fill(255)
      }
      p5.ellipse(p5.mouseX,p5.mouseY,50,50)
    }
  }

  def main(): Unit = {
    println("Started!")
    new P5(sketch,"canvas-container")
  }
}
