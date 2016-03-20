package tutorial.webapp

import org.scalajs.dom._
import org.scalajs.dom.raw.{HTMLDivElement, HTMLCanvasElement}
import scala.scalajs._
import scala.scalajs.js.annotation.JSName
import scala.collection.mutable.Seq

case class Point(x:Double,y:Double)(implicit p5:P5Instance)
trait Animation{
}


object TutorialApp extends js.JSApp {
	val sketch: js.Function = (p5:P5Instance) => {
		var points:Seq[Point] = Seq.empty
		implicit val p = p5
		p5.setup = () =>{
			val width = (p5.displayWidth*0.8).toInt
			val height = (p5.displayHeight*0.8).toInt
			p5.createCanvas(width , height)
			document.querySelector("#canvas-container").
			asInstanceOf[HTMLDivElement].style.width = s"${width}px"
		}
		p5.mousePressed = () => {
			points = points :+ Point(p5.mouseX,p5.mouseY)
		}

		p5.draw = () =>{
			p5.background(0)
			p5.fill(255)
			p5.ellipse(p5.mouseX,p5.mouseY,10,10)
			points.foreach{ pt =>
				p5.ellipse(pt.x,pt.y,10,10)
			}
		}
	}

	def main(): Unit = {
		println("Started!")
		new P5(sketch,"canvas-container")
	}
}
