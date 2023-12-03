package com.lipsum.modusoperandi.objects.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.Vector2;

import java.nio.ByteBuffer;

public class Countertop extends RoomEntity {

    public Countertop(Vector2 position) {
        super(position);
        texture = new Pixmap(Gdx.files.internal("entities/countertop_box.png"));
        hitbox_texture = new Pixmap(Gdx.files.internal("entities/countertop_collision_box.png"));
        ByteBuffer bb = hitbox_texture.getPixels();
        long counter = 0;
        while (bb.hasRemaining()){

            if (bb.get() != -1){

                System.out.println(bb.position() + " -> " + bb.get());
                counter+=1;
            }
        }
        System.out.println("counter: "+counter);
        System.out.println(hitbox_texture.getPixel(0,0));
        System.out.println(hitbox_texture.getPixel(1,1));
        System.out.println(hitbox_texture.getPixel(125,42));
        System.out.println(hitbox_texture.getPixel(126,43));
        System.out.println("hoi");
    }
}
