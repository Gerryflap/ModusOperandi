package com.lipsum.modusoperandi.event.events;

import com.lipsum.modusoperandi.event.Event;
import com.lipsum.modusoperandi.event.EventType;
import com.lipsum.modusoperandi.objects.collidable.Collidable;

public class CollisionEvent implements Event {
    private Collidable collidingObject;
    private Collidable collidesWith;

    @Override
    public EventType getEventType() {
        return EventType.COLLISION_EVENT;
    }

    public CollisionEvent(Collidable collidingObject, Collidable collidesWith){
        this.collidingObject = collidingObject;
        this.collidesWith = collidesWith;
    }

    public Collidable getCollidingObject() {
        return collidingObject;
    }

    public Collidable getCollidesWith() {
        return collidesWith;
    }

    @Override
    public String toString() {
        return "CollisionEvent{" +
                "collidingObject=" + collidingObject +
                ", collidesWith=" + collidesWith +
                '}';
    }
}
