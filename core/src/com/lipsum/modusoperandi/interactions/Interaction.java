package com.lipsum.modusoperandi.interactions;

import com.lipsum.modusoperandi.event.events.InteractionEvent;

public abstract class Interaction {

    public int getRoom() {
        return room;
    }

    private int room;

    public int getInteractionId() {
        return interactionId;
    }

    private int interactionId;
    private boolean interactionActive;

    public Interaction(int room, int interactionId) {
        this.room = room;
        this.interactionId = interactionId;
    }

    public void handleInteraction() {

    }

    public boolean alreadyPerformed() {
        return InteractionManager.getInstance().getInteractionHistory().get(this.interactionId);
    }

}
