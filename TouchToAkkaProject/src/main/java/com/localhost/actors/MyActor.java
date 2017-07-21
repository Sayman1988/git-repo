package com.localhost.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

/**
 * Created by o.serohin on 21.07.2017.
 */
public class MyActor extends UntypedAbstractActor {
    private final ActorRef child = getContext().actorOf(Props.create(HelloActor.class));

    @Override
    public void onReceive(Object o) throws Throwable {
        if("hello".equals(o)) {
            child.tell("Hello World!", getSelf());
        }
    }
}
