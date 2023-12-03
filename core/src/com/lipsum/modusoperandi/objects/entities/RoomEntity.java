package com.lipsum.modusoperandi.objects.entities;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class RoomEntity {
    private Vector2 position;
    protected Pixmap texture = null;
    protected Pixmap hitbox_texture = null;

    public RoomEntity(Vector2 position) {
        this.position = position;
    }

    public void render(Pixmap batch) {

        batch.drawPixmap(texture, (int) position.x, (int) position.y);
    }

    public void renderHitBox(Pixmap batch) {
        if (hitbox_texture != null){
            batch.drawPixmap(hitbox_texture, (int) position.x, (int) position.y);
        }
    }
    public Vector2 getPosition() {
        return position;
    }
}
