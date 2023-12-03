package com.lipsum.modusoperandi.objects.rooms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lipsum.modusoperandi.objects.entities.RoomEntity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Abstract room class, will provide all room instances
 */
public abstract class AbstractRoom {
    protected Pixmap backgroundPixmap = new Pixmap(Gdx.files.internal("Background.png"));
    protected Pixmap collisionPixmap = new Pixmap(Gdx.files.internal("Background.png"));
    protected Set<RoomEntity> roomEntitySet = new HashSet<>();

    public Texture backgroundTexture;
    public Sprite backgroundSprite;

    public Texture collisionTexture;
    public Sprite collisionSprite;

    protected void addEntity(RoomEntity roomEntity) {
        roomEntitySet.add(roomEntity);
        roomEntity.render(backgroundPixmap);
        roomEntity.renderHitBox(collisionPixmap);
    }

    protected void removeEntity(RoomEntity roomEntity) {
        roomEntitySet.remove(roomEntity);
    }

    public Set<RoomEntity> getEntities() {
        return Collections.unmodifiableSet(roomEntitySet);
    }

    protected void constructBackground(){
        backgroundTexture = new Texture(backgroundPixmap);
        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setScale(4);
        backgroundSprite.setOrigin(backgroundSprite.getWidth()*2/3,backgroundSprite.getHeight() / 3);

        collisionTexture = new Texture(collisionPixmap);
        collisionSprite = new Sprite(collisionTexture);
        collisionSprite.setScale(4);
        collisionSprite.setOrigin(collisionSprite.getWidth()*2/3,collisionSprite.getHeight() / 3);
    }

//    public void loadBackgroundTexture(Texture texture) {
//        backgroundTexture = texture;
//        backgroundSprite = new Sprite(backgroundTexture);
//        backgroundSprite.setOrigin(backgroundSprite.getWidth(), backgroundSprite.getHeight() / 2);
//        backgroundSprite.setScale(2);
//    }

    public void render(SpriteBatch batch) {
        // Draw background
        backgroundSprite.draw(batch);
        collisionSprite.draw(batch);
//        for (RoomEntity roomEntity : roomEntitySet) {
//            roomEntity.render(batch);
//        }
    }
}
