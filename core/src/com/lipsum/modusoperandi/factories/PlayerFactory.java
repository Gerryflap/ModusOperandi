package com.lipsum.modusoperandi.factories;

import com.lipsum.modusoperandi.objects.collidable.Player;

/**
 *
 */
public class PlayerFactory extends AbstractFactory<Player> {
    private static PlayerFactory instance = null;

    static {
        SelfCollidableFactory.getInstance().addSubFactory(PlayerFactory.getInstance());
    }

    public PlayerFactory() {
        super(Player.class);
    }

    public static PlayerFactory getInstance() {
        if (instance == null) {
            instance = new PlayerFactory();
        }
        return instance;
    }

    public Player getPlayer() {
        return getAllManagedObjects().iterator().next();
    }
}
