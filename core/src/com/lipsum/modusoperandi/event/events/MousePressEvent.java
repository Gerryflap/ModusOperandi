package com.lipsum.modusoperandi.event.events;

import com.lipsum.modusoperandi.event.EventType;

public class MousePressEvent extends MouseButtonEvent {

    public MousePressEvent(int xScreen, int yScreen, int button) {
        super(xScreen, yScreen, button);
    }

    @Override
    public EventType getEventType() {
        return EventType.MOUSE_PRESS_EVENT;
    }
}
