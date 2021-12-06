package ru.gb.yukjdev.screen.impl;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.gb.yukjdev.math.Rect;
import ru.gb.yukjdev.screen.BaseScreen;
import ru.gb.yukjdev.sprite.impl.Background;
import ru.gb.yukjdev.sprite.impl.ButtonExit;
import ru.gb.yukjdev.sprite.impl.ButtonPlay;
import ru.gb.yukjdev.sprite.impl.Star;

public class MenuScreen extends BaseScreen {

    private Background background;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 touch;
    private Texture img;

    private static final float V_LEN = 0.5f;

    private final Game game;


    private Texture bg;
    private TextureAtlas atlas;
    private Star[] stars;
    private ButtonExit buttonExit;
    private ButtonPlay buttonPlay;

    public MenuScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/start_bg.png");
        background = new Background(bg);
        atlas = new TextureAtlas("textures/menuAtlas.tpack");
        buttonExit = new ButtonExit(atlas);
        buttonPlay = new ButtonPlay(atlas, game);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        buttonExit.resize(worldBounds);
        buttonPlay.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlas.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        buttonExit.touchDown(touch, pointer, button);
        buttonPlay.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        buttonExit.touchUp(touch, pointer, button);
        buttonPlay.touchUp(touch, pointer, button);
        return false;
    }

    private void update(float delta) {

    }

    private void draw() {
        batch.begin();
//        batch.setColor(1f, 1f, 1f, 1f);
        background.draw(batch);
//        for (Star star : stars) {
////            batch.setColor(Color.YELLOW);
//            star.draw(batch);
////            batch.setColor(Color.CLEAR);
//        }
        buttonExit.draw(batch);
        buttonPlay.draw(batch);
        batch.end();
    }
}
