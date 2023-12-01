package com.lipsum.modusoperandi.objects.rooms;

/**
 * This enum will contain all rooms
 */
public enum Room {
    TEST_ROOM(new TestRoom());


    private final AbstractRoom room;

    Room(AbstractRoom room) {
        this.room = room;
    }

    public AbstractRoom getRoom() {
        return room;
    }
}
