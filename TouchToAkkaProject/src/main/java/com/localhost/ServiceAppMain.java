package com.localhost;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.localhost.actors.MyActor;

/**
 * Created by o.serohin on 21.07.2017.
 */
public class ServiceAppMain {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create();
        ActorRef actor = system.actorOf(Props.create(MyActor.class));
        actor.tell("hello", null);
        system.terminate();
        }
}
