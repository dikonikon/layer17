package com.dikonikon.layer17

import akka.actor.{ActorSystem, Props, ActorLogging, Actor}
import akka.testkit._

import scala.concurrent.duration._

class NodeRootActor extends Actor with ActorLogging {

  def receive = {
    case x => log.debug(s"received $x")
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
    probe.send(mainActor, AddIPToDNS())
    probe.expectNoMsg(10.second)
    system.shutdown()
  }
}

