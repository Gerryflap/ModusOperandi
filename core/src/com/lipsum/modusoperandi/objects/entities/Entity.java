package com.lipsum.modusoperandi.objects.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Entity {
    void step(double dt);
    void render(SpriteBatch batch);
}
