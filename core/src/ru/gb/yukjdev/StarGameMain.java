package ru.gb.yukjdev;

import com.badlogic.gdx.Game;

import ru.gb.yukjdev.screen.impl.MenuScreen;

public class StarGameMain extends Game {

    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
