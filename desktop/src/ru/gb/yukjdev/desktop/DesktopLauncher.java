package ru.gb.yukjdev.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ru.gb.yukjdev.StarGameMain;

public class DesktopLauncher {
    public static void main(String[] arg) {
        System.setProperty("user.name", "\\x79\\x75\\x72\\x79");
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new StarGameMain(), config);
        config.useGL30 = true;
        config.height = 600;
        config.width = 400;
        config.resizable = false;
        new LwjglApplication(new StarGameMain(), config);
    }
}
