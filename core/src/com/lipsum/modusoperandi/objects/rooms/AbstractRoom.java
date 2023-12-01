package com.lipsum.modusoperandi.objects.rooms;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lipsum.modusoperandi.objects.entities.Entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Abstract room class, will provide all room instances
 */
public abstract class AbstractRoom {
    protected Set<Entity> entitySet = new HashSet<>();

    protected void addEntity(Entity entity) {
        entitySet.add(entity);
    }

    protected void removeEntity(Entity entity) {
        entitySet.remove(entity);
    }

    public Set<Entity> getEntities() {
        return Collections.unmodifiableSet(entitySet);
    }

    public void render(SpriteBatch batch) {
        for (Entity entity: entitySet) {
            entity.render(batch);
        }
    }
}
