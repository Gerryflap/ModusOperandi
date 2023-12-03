package com.lipsum.modusoperandi.event.events;

import com.lipsum.modusoperandi.dialogue.DialogueItem;
import com.lipsum.modusoperandi.event.Event;
import com.lipsum.modusoperandi.event.EventType;

import java.util.ArrayList;

public class DialogueEvent implements Event {

    private final ArrayList<DialogueItem> dialogueItems;

    public DialogueEvent(ArrayList<DialogueItem> dialogueItems) {
        this.dialogueItems = dialogueItems;
    }

    public ArrayList<DialogueItem> getDialogueItems() {
        return dialogueItems;
    }

    @Override
    public EventType getEventType() {
        return EventType.DIALOGUE_EVENT;
    }
}