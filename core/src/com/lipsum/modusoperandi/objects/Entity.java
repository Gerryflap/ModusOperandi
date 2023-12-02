package com.lipsum.modusoperandi.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lipsum.modusoperandi.event.EventQueue;
import com.lipsum.modusoperandi.factories.EntityFactory;

public abstract class Entity {
    protected float x;
    protected float y;

    protected Texture sprite;
    protected float spriteWidth;
    protected float spriteHeight;

    protected float speedX;
    protected float speedY;

    public Entity(float spriteWidth, float spriteHeight) {
        EntityFactory.getInstance().addManagedObject(this);
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
        this.sprite = new Texture("badlogic.jpg");
    }

    public void update(float timeDeltaMillis){
        x += speedX * timeDeltaMillis / 1000;
        y += speedY * timeDeltaMillis / 1000;
    }

    public void afterDraw() {};

    public void render(SpriteBatch batch){
        System.out.println("Rendering " + this.toString());
        batch.draw(sprite, x - spriteWidth / 2, y, spriteWidth, spriteHeight);
    }

    public void setPosition(float xPosition, float yPosition) {
        x = xPosition;
        y = yPosition;
    }

    public void setVelocity(float xVelocity, float yVelocity) {
        speedX = xVelocity;
        speedY = yVelocity;
    }

    public void onDispose() {

    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

}
