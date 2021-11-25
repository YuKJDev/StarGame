package ru.gb.yukjdev.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.gb.yukjdev.base.BaseScreen;
import ru.gb.yukjdev.math.Rect;
import ru.gb.yukjdev.splite.Background;

public class MenuScreen extends BaseScreen {

    private Background background;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 touch;
    private Texture img;

    private static final float V_LEN = 0.5f;


    @Override
    public void show() {
        super.show();
        pos = new Vector2(0, 0);
        Texture bg = new Texture("textures/bg.png");
        img = new Texture("badlogic.jpg");
        background = new Background(new TextureRegion(bg));
        v = new Vector2();
        touch = new Vector2();

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(img, pos.x, pos.y, 0.2f, 0.2f);
        //   background.draw(batch);
        batch.end();
        if (touch.dst(pos) <= v.len()) {
            pos.set(touch);
        } else {
            pos.add(v);
        }

    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        pos.set(touch);
        return super.touchDown(touch, pointer, button);
    }
}
