package com.lipsum.modusoperandi.event.events;

import com.lipsum.modusoperandi.event.Event;
import com.lipsum.modusoperandi.event.EventType;
import com.lipsum.modusoperandi.interactions.InteractionManager;

public class InteractionEvent implements Event {

    private final int interactionEventId;

    public InteractionEvent(int interactionEventId) {
        this.interactionEventId = interactionEventId;
        // TODO: This ensures all interaction can only occur once, but we want dialogue to be able to happen multiple times
        if (!InteractionManager.getInstance().getInteractionHistory().get(interactionEventId)) {
            InteractionManager.interactionActive = true;
        }
    }

    public int getInteractionEventId() {
        return interactionEventId;
    }

    @Override
    public EventType getEventType() {
        return EventType.INTERACTION_EVENT;
    }
}