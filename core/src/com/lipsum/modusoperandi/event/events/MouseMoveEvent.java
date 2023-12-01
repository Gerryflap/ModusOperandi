package com.lipsum.modusoperandi.event.events;

import com.lipsum.modusoperandi.event.EventType;

public class MouseMoveEvent extends MouseEvent {
    public MouseMoveEvent(int xScreen, int yScreen) {
        super(xScreen, yScreen);
    }

    @Override
    public EventType getEventType() {
        return EventType.MOUSE_MOVE_EVENT;
    }
}