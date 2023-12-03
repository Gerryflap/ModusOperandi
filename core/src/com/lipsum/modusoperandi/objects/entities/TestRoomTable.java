package com.lipsum.modusoperandi.objects.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class TestRoomTable extends RoomEntity {
    static Texture texture = new Texture("test_table.png");

    private Vector2 position;

    public TestRoomTable(Vector2 position) {
        super(position);
    }


//    @Override
//    public void render(SpriteBatch batch) {
//        batch.draw(texture, position.x, position.y);
//    }
//
//    @Override
//    public void renderHitBox(SpriteBatch batch) {
//        batch.draw(texture, position.x, position.y);
//    }


}
