package com.lipsum.modusoperandi.objects.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.lipsum.modusoperandi.objects.entities.*;

public class Kitchen extends AbstractRoom {

    public Kitchen() {
//        addEntity(new TestRoomTable(new Vector2(100, 100)));
        boolean flipped = false;
        for(int row=0; row < 6; row++){
            for(int col=0; col < 19; col++){
                addEntity(new FloorTile(new Vector2(8+16*col, 80+16*row), flipped));
                flipped = !flipped;
            }
        }
        addEntity(new Wall(new Vector2(16, 0)));
        addEntity(new Fridge(new Vector2(16, 10)));
        addEntity(new Countertop(new Vector2(92, 58)));
        addEntity(new Stove(new Vector2(218, 57)));
        addEntity(new LCountertop(new Vector2(269, 58)));
        constructBackground();
//        loadBackgroundTexture(texture);
    }
}
