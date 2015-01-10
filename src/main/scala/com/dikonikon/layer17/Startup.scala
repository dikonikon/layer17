package com.dikonikon.layer17

import akka.actor.{ActorSystem, Props, ActorLogging, Actor}
import scala.concurrent.duration._

class NodeRootActor extends Actor with ActorLogging {

  def receive = {
    case x => log.debug("received {0}", "nothing")
  }
}

class Main extends Actor {

  val nodeRoot = context.actorOf(Props[NodeRootActor])

  nodeRoot ! AddIPToDNS()

  def receive = {
    case x => println(s"received $x")
  }
}


object NodeStart {
  def main(args: Array[String]): Unit = {
    println("starting Akka system")
    implicit val system = ActorSystem("Test")
    println("creating main actor")
    val mainActor = system.actorOf(Props[NodeRootActor])
    val probe = TestProbe()
    mainActor ! AddIPToDNS()
    system.awaitTermination(10.seconds)
  }
}

