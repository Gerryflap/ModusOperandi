package com.lipsum.modusoperandi.objects.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Optional;

public class TestRoomTable implements Entity {
    static Texture texture = new Texture("test_table.png");

    private Vector2 position;

    public TestRoomTable(Vector2 position) {
        this.position = position;
    }

    @Override
    public void step(double dt) {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public Optional<HitBox> getHitBox() {
        return Optional.of(new HitBox(position, new Vector2(texture.getWidth(), texture.getHeight())));
    }
}
