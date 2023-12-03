package com.lipsum.modusoperandi.interactions;

import com.lipsum.modusoperandi.dialogue.DialogueItem;
import com.lipsum.modusoperandi.dialogue.Speaker;
import com.lipsum.modusoperandi.event.EventQueue;
import com.lipsum.modusoperandi.event.events.DialogueEvent;

import java.util.ArrayList;

public class TestDialogueInteraction extends Interaction {


    public TestDialogueInteraction(int room, int interactionId) {
        super(room, interactionId);
    }

    @Override
    public void handleInteraction() {
        if (alreadyPerformed()) {
            return ;
        }
        InteractionManager.getInstance().getInteractionHistory().put(this.getInteractionId(), true);
        ArrayList<DialogueItem> dialogueItems = new ArrayList<>();

        dialogueItems.add(new DialogueItem(Speaker.PLAYER, "Hmm yes I am a dialogue"));
        dialogueItems.add(new DialogueItem(Speaker.WATCH, "WAIT!!! HAVY IS DEAD"));
        dialogueItems.add(new DialogueItem(Speaker.HAVY, "HAVY IS DEAD???? I AM NOT DEAD"));

        EventQueue.getInstance().invoke(new DialogueEvent(dialogueItems));
    }
}
