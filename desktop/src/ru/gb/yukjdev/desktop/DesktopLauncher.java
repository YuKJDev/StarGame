package ru.gb.yukjdev.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ru.gb.yukjdev.StarGameMain;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.useGL30 = true;
        config.height = 700;
        config.width = 500;
        config.resizable = false;
        new LwjglApplication(new StarGameMain(), config);
    }
}
