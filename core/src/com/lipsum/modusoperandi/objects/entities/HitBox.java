package com.lipsum.modusoperandi.objects.entities;

import com.badlogic.gdx.math.Vector2;

public class HitBox {
    private final Vector2 topLeft;
    private final Vector2 widthHeight;

    public HitBox(Vector2 topLeft, Vector2 widthHeight) {
        this.topLeft = topLeft;
        this.widthHeight = widthHeight;
    }

    public boolean isInside(Vector2 position) {
        return topLeft.x >= position.x && topLeft.y >= position.y &&
                widthHeight.x <= position.x && widthHeight.y <= position.y ;
    }
}
