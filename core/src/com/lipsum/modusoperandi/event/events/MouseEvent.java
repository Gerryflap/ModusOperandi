package com.lipsum.modusoperandi.event.events;

import com.lipsum.modusoperandi.event.Event;
import com.lipsum.modusoperandi.event.EventType;

public abstract class MouseEvent implements Event {
    private final int xScreen;
    private final int yScreen;

    public MouseEvent(int xScreen, int yScreen) {
        this.xScreen = xScreen;
        this.yScreen = yScreen;
    }

    public int getScreenX() {
        return xScreen;
    }
    public int getScreenY() {
        return yScreen;
    }
}