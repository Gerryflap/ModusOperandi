package com.lipsum.modusoperandi;

import com.lipsum.modusoperandi.event.Event;
import com.lipsum.modusoperandi.event.EventConsumer;
import com.lipsum.modusoperandi.event.EventQueue;
import com.lipsum.modusoperandi.event.EventType;
import com.lipsum.modusoperandi.event.events.KeyEvent;

import java.util.HashMap;

public class KeyHoldWatcher {
    private HashMap<Integer, Boolean> heldKeys;

    public KeyHoldWatcher() {
        heldKeys = new HashMap<>();
        EventConsumer keyEventEventConsumer = this::onKeyEvent;
        EventQueue.getInstance().addConsumer(keyEventEventConsumer);
    }

    private void onKeyEvent(Event keyEvent) {
        if (keyEvent instanceof KeyEvent) {
            if (((KeyEvent) keyEvent).isKeyDown()) {
                heldKeys.put(((KeyEvent) keyEvent).getKeyCode(), true);
            } else {
                heldKeys.put(((KeyEvent) keyEvent).getKeyCode(), false);
            }
        }
    }

    public void releaseAll() {
        heldKeys.clear();
    }

    public boolean isKeyHeld(int keyCode) {
        return heldKeys.getOrDefault(keyCode, false);
    }

    public void dispose() {
//        EventQueue.getInstance().deregisterConsumer(keyEventEventConsumer, EventType.KEY_EVENT);
    }
}
