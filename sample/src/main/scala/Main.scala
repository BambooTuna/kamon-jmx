import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import kamon.Kamon

object Main extends App {

  val config = ConfigFactory.load()

  Kamon.start()
  implicit val system = ActorSystem("kamon-jmx-sample", config)

  val counter = Kamon.metrics.counter("kamon-jmx-sample-counter")

  Thread.sleep(1000)

  (1 to 100).foreach { i =>
    println(s"Loop: $i")
    counter.increment(i.toLong * 10)

    Thread.sleep(1000)
  }

}