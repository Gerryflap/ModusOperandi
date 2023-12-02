//package com.lipsum.modusoperandi;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.lipsum.modusoperandi.config.RoomConfiguration;
//import com.lipsum.modusoperandi.event.events.MouseEvent;
//
//import java.util.Random;
//
//public class Camera {
//    private SpriteBatch spriteBatch;
//
//    private float windowFactorX = 1f;
//
//    private float windowFactorY = 1f;
//    private float START_WIDTH = RoomConfiguration.ROOM_TILE_WIDTH*RoomConfiguration.TILE_PIXEL_WIDTH;
//    private float START_HEIGHT = RoomConfiguration.ROOM_TILE_HEIGHT*RoomConfiguration.TILE_PIXEL_HEIGHT;
//    private long timingCounter = 0;
//
//    private long updateMillis = 50;
//
//    public Camera() {
//        spriteBatch = new SpriteBatch();
//        windowFactorX = Gdx.graphics.getWidth()/START_WIDTH;
//        windowFactorY = Gdx.graphics.getHeight()/START_HEIGHT;
//    }
//
//    public void draw(Texture sprite, float x, float y, float width, float height){
//        TextureRegion tr = new TextureRegion(sprite);
//        draw(tr, x, y, width, height, false, false);
//    }
//
//    public void draw(Texture sprite, float x, float y, float width, float height, boolean flipX, boolean flipY){
//        TextureRegion tr = new TextureRegion(sprite);
//        draw(tr, x, y, width, height, flipX, flipY);
//    }
//
//    public void spriteDraw(Sprite s, float x, float y, float width, float height, boolean flipX, boolean flipY){
//        float newWidth = width * factorX * windowFactorX;
//        float newHeight = height * factorY * windowFactorY;
//
//        float newX = (x + movementOffsetX + shakeX) * factorX * windowFactorX;
//        if(this.flipX){
//            newX = ((START_WIDTH-x-newWidth/windowFactorX) + movementOffsetX + shakeX) * factorX * windowFactorX;
//        }
//        float newY = (y + movementOffsetY + shakeY) * factorY * windowFactorY;
//        s.setX(newX);
//        s.setY(newY);
//        s.setSize(newWidth, newHeight);
////        s.setRegion(newX, newY, newWidth, newHeight);
////        float newOriginY = newHeight; // Origin on the bottom.
//        s.setOrigin(newWidth/2f, 0);
//        s.setScale((this.flipX ^ flipX) ? -1f : 1f, flipY ? -1f : 1f);
//
//        s.draw(spriteBatch);
//    }
//
//
//    public void draw(TextureRegion region, float x, float y, float width, float height, boolean flipX, boolean flipY){
//        float newWidth = width * factorX * windowFactorX;
//        float newHeight = height * factorY * windowFactorY;
//
//        float newX = (x + movementOffsetX + shakeX) * factorX * windowFactorX;
//        if(this.flipX){
//            newX = ((START_WIDTH-x-newWidth/windowFactorX) + movementOffsetX + shakeX) * factorX * windowFactorX;
//        }
//        float newY = (y + movementOffsetY + shakeY) * factorY * windowFactorY;
//        float newOriginX = newWidth / 2f; // Origin in middle.
////        float newOriginY = newHeight; // Origin on the bottom.
//        float xScale = (this.flipX ^ flipX) ? -1f : 1f;
//        float yScale = flipY ? -1f : 1f;
//        spriteBatch.draw(region, newX, newY, newOriginX, 0, newWidth, newHeight, xScale, yScale, 0f);
//    }
//
//
//
//
//
//    public void end(){
//        spriteBatch.end();
//    }
//
//    public float getWindowFactorX() {
//        return windowFactorX;
//    }
//
//    public float getWindowFactorY() {
//        return windowFactorY;
//    }
//
//    public float getWidth() {
//        return START_WIDTH;
//    }
//
//    public float getHeight() {
//        return START_HEIGHT;
//    }
//
//}
