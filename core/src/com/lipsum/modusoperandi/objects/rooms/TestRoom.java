package com.lipsum.modusoperandi.objects.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.lipsum.modusoperandi.objects.entities.Stove;
import com.lipsum.modusoperandi.objects.entities.TestRoomTable;

public class TestRoom extends AbstractRoom {

    public TestRoom(Texture texture) {
//        addEntity(new TestRoomTable(new Vector2(100, 100)));
        addEntity(new Stove(new Vector2(100, 100)));
        constructBackground();
//        loadBackgroundTexture(texture);
    }
}
