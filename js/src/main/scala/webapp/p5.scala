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
  var mousePressed:js.Function
  var mouseIsPressed:Boolean = js.native
  def fill(args:Int*):Unit = js.native
  def background(args:Int*):Unit = js.native
  def ellipse(x:Double,y:Double,w:Double,h:Double):Unit = js.native
  var mouseX:Double = js.native
  var mouseY:Double = js.native
  val displayWidth:Double = js.native
  val displayHeight:Double = js.native
}


