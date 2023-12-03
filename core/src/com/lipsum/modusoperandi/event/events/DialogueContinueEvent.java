package com.lipsum.modusoperandi.event.events;

import com.lipsum.modusoperandi.dialogue.DialogueItem;
import com.lipsum.modusoperandi.event.Event;
import com.lipsum.modusoperandi.event.EventType;

import java.util.ArrayList;

public class DialogueContinueEvent implements Event {

    public DialogueContinueEvent() {

    }

    @Override
    public EventType getEventType() {
        return EventType.DIALOGUE_CONTINUE_EVENT;
    }
}