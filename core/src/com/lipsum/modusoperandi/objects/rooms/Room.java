package com.lipsum.modusoperandi.objects.rooms;

import com.badlogic.gdx.graphics.Texture;

/**
 * This enum will contain all rooms
 */
public enum Room {
    TEST_ROOM(new TestRoom(new Texture("Location/kitchen.png")));


    private final AbstractRoom room;

    Room(AbstractRoom room) {
        this.room = room;
    }

    public AbstractRoom getRoom() {
        return room;
    }
}
