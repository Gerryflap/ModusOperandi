package com.lipsum.modusoperandi.objects.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.Vector2;

public class FloorTile extends RoomEntity {

    public FloorTile(Vector2 position, boolean flipped) {
        super(position);
        if (flipped){
            texture = new Pixmap(Gdx.files.internal("entities/floor_tiles2.png"));
        } else {
            texture = new Pixmap(Gdx.files.internal("entities/floor_tiles.png"));
        }
    }
}
