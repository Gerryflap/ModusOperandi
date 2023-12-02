package com.lipsum.modusoperandi.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.lipsum.modusoperandi.event.Event;
import com.lipsum.modusoperandi.event.EventConsumer;
import com.lipsum.modusoperandi.event.EventQueue;
import com.lipsum.modusoperandi.event.EventType;
import com.lipsum.modusoperandi.event.events.KeyEvent;
import com.lipsum.modusoperandi.event.events.MenuChangeEvent;
import com.lipsum.modusoperandi.input.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {

    public static final int NO_MENU = -1;
    public static final int MAIN_MENU = 0;
    public static final int OPTIONS_MENU = 1;
    public static final int PAUSED_MENU = 2;
    public static final int INGAME_OVERLAY = 6;
    public static final int DEATH_MENU = 7;

    private final List<Menu> registeredMenus;
    private int currentMenuId;

    public MenuManager() {
        registeredMenus = new ArrayList<>();
        currentMenuId = -1;

        // Menu change listeners
        EventConsumer consumer = this::handleMenuChangeEvent;
        EventQueue.getInstance().addConsumer(consumer);

        // Pause menu
        EventConsumer keyConsumer = this::onKeyEvent;
        EventQueue.getInstance().addConsumer(keyConsumer);
    }

    public void handleMenuChangeEvent(Event event) {
        if (event.getEventType() == EventType.MENU_CHANGE) {
            switchMenu(((MenuChangeEvent) event).getMenuId());
        }
    }

    private void onKeyEvent(Event event) {
        if (event.getEventType() == EventType.KEY_EVENT) {
            if (((KeyEvent) event).getKeyCode() == Input.Keys.ESCAPE && ((KeyEvent) event).isKeyDown()) {
                EventQueue.getInstance().invoke(new MenuChangeEvent(MenuManager.PAUSED_MENU));
            }
        }
    }

    public void registerMenu(Menu menuToRegister) {
        registeredMenus.add(menuToRegister);
    }

    public void switchMenu(int id) {
        if (id == currentMenuId) return;
        if (currentMenuId >= 0) {
            registeredMenus.get(currentMenuId).dispose();
        }
        currentMenuId = id;
        System.out.println("Switched to different menu: " + currentMenuId);
        if (id < 0) {
            Gdx.input.setInputProcessor(InputHandler.getInstance());
            return;
        }
        registeredMenus.get(currentMenuId).create();
    }

    public void draw() {
        if (currentMenuId < 0) return;
        registeredMenus.get(currentMenuId).draw();
    }

    public void onResize(int width, int height) {
        if (currentMenuId < 0) return;
        registeredMenus.get(currentMenuId).onResize(width, height);
    }
}
