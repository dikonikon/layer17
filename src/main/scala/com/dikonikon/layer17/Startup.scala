package com.dikonikon.layer17

import akka.actor.{ActorLogging, Actor}

class NodeRootActor extends Actor with ActorLogging {

  def receive = {
    case AddIPToDNS => log.debug("received {0}", "nothing")
  }
}


object NodeStart {
  def main(args: Array[String]): Unit = {
    val initialActor = classOf[NodeRootActor].getName

    akka.Main.main(Array(initialActor))
  }
}

