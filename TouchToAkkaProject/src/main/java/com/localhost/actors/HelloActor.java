package com.localhost.actors;

import akka.actor.UntypedAbstractActor;

/**
 * Created by o.serohin on 20.07.2017.
 */
public class HelloActor extends UntypedAbstractActor {
    @Override
    public void onReceive(Object o) throws Throwable {
        System.out.println("Hello, " + getSender().path() + "!");
    }
}
