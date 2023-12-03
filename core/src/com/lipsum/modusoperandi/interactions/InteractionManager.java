package com.lipsum.modusoperandi.interactions;

import java.util.HashMap;

public class InteractionManager {

    // TODO: Add a flag for if an interaction is active and STOP THE PLAYER FORM MOVING OR DOING ANYTHING!!!!!!

    private static final InteractionManager instance = new InteractionManager();
    public static boolean interactionActive;
    public static InteractionManager getInstance() {
        return InteractionManager.instance;
    }

    private final HashMap<Integer, Boolean> interactionHistory = new HashMap<>();

    public InteractionManager() {
        interactionHistory.put(0, false);
    }

    public HashMap<Integer, Boolean> getInteractionHistory() {
        return interactionHistory;
    }

}
