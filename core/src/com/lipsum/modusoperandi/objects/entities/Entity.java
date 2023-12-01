package com.lipsum.modusoperandi.objects.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Optional;

public interface Entity {
    void step(double dt);
    void render(SpriteBatch batch);
    Vector2 getPosition();
    default Optional<HitBox> getHitBox() {
        return Optional.empty();
    }
}
