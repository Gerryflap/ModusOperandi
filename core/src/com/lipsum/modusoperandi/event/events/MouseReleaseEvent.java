package com.lipsum.modusoperandi.event.events;

import com.lipsum.modusoperandi.event.EventType;

public class MouseReleaseEvent extends MouseButtonEvent {

    public MouseReleaseEvent(int xScreen, int yScreen, int button) {
        super(xScreen, yScreen, button);
    }

    @Override
    public EventType getEventType() {
        return EventType.MOUSE_RELEASE_EVENT;
    }
}