package com.lipsum.modusoperandi.objects.collidable;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.lipsum.modusoperandi.WorldManager;
import com.lipsum.modusoperandi.KeyHoldWatcher;
import com.lipsum.modusoperandi.event.Event;
import com.lipsum.modusoperandi.event.EventConsumer;
import com.lipsum.modusoperandi.event.EventQueue;
import com.lipsum.modusoperandi.event.EventType;
import com.lipsum.modusoperandi.event.events.*;


/**
 * The player entity. Is NOT meant to hold the inventory etc!
 */
public class Player extends SelfCollidable implements Traversable {

    public static final float BASE_SPEED = 300f;

    private float speed;

    private final KeyHoldWatcher keyHoldWatcher;
    private boolean lookingLeft = false;

//    private Animation<TextureRegion> walkAnimation;
    private Texture spriteSheet;
    private TextureRegion currentSprite;
    private float animationTime = 0f;

    private Event lastMouseEvent;

    private EventConsumer mousePressConsumer;
    private EventConsumer mouseReleaseConsumer;
    private EventConsumer mouseMoveConsumer;

    public Player(float x, float y) {
        super(65, 125, 50, 50);
        this.x = x;
        this.y = y;
        this.keyHoldWatcher = new KeyHoldWatcher();
        spriteSheet = new Texture("badlogic.jpg");
        this.speed = BASE_SPEED;

        mousePressConsumer = this::onMousePress;
        EventQueue.getInstance().addConsumer(mousePressConsumer);

        mouseReleaseConsumer = this::onMouseRelease;
        EventQueue.getInstance().addConsumer(mouseReleaseConsumer);

        mouseMoveConsumer = this::onMouseMove;
        EventQueue.getInstance().addConsumer(mouseMoveConsumer);

//        TextureRegion[] walkFrames = TextureRegion.split(spriteSheet, 13, 25)[0];
//        walkAnimation = new Animation<>(0.2f, walkFrames);
    }

    @Override
    public void update(float timeDeltaMillis) {
        ///////////////////
        // Walking stuff //
        ///////////////////
        float dx = 0;
        float dy = 0;
        if (keyHoldWatcher.isKeyHeld(Input.Keys.D) || keyHoldWatcher.isKeyHeld(Input.Keys.RIGHT)) {
            dx += 1;
            lookingLeft = false;
        }
        if (keyHoldWatcher.isKeyHeld(Input.Keys.A) || keyHoldWatcher.isKeyHeld(Input.Keys.LEFT)) {
            dx -= 1;
            lookingLeft = true;
        }
        if (keyHoldWatcher.isKeyHeld(Input.Keys.W) || keyHoldWatcher.isKeyHeld(Input.Keys.UP)) {
            dy += 1;
        }
        if (keyHoldWatcher.isKeyHeld(Input.Keys.S) || keyHoldWatcher.isKeyHeld(Input.Keys.DOWN)) {
            dy -= 1;
        }

        // TODO: Normalize diagonals
        super.setVelocity(speed * dx, speed * dy);

        /* publish new position to listeners */
        if (Math.abs(dx) > 0.0f || Math.abs(dy) > 0.0f) {
//            EventQueue.getInstance().invoke(new PlayerMoveEvent(x, y));
            animationTime += timeDeltaMillis * 0.001;
        }
        // TODO: Create walk animation
//        currentSprite = walkAnimation.getKeyFrame(animationTime,true);

        super.update(timeDeltaMillis);
    }

    public void onCollisionEvent(CollisionEvent event) {
    }

    private void onMousePress(Event event) {
        this.lastMouseEvent = event;
    }

    private void onMouseRelease(Event event) {

    }

    private void onMouseMove(Event event) {
        this.lastMouseEvent = event;
    }

    public float getSpeed() {
        return speed;
    }

    public void addSpeed(float speed) {
        this.speed += speed;
    }

    public void onDispose() {
//        super.onDispose();
//        // We intentionally do not do anything here anymore, because the player persists between rooms / levels. We only
//        // reset the input handling.
//        keyHoldWatcher.releaseAll();
    }

    public void hardDisposePlayer() {
        // Here, we DO dispose stuff, because the whole game is resetting.
//        EventQueue.getInstance().deregisterConsumer(mousePressConsumer, EventType.MOUSE_PRESS_EVENT);
    }


}
