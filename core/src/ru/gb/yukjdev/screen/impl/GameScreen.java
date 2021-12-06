package ru.gb.yukjdev.screen.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import ru.gb.yukjdev.math.Rect;
import ru.gb.yukjdev.pool.impl.BulletPool;
import ru.gb.yukjdev.screen.BaseScreen;
import ru.gb.yukjdev.sprite.impl.Background;
import ru.gb.yukjdev.sprite.impl.MainShip;
import ru.gb.yukjdev.sprite.impl.Star;


public class GameScreen extends BaseScreen {

    private static final int STAR_COUNT = 512;

    private TextureAtlas atlas;
    private Texture bg;

    private Background background;
    private Star[] stars;

    private MainShip mainShip;
    private BulletPool bulletPool;

    private Music music;
    private Sound laserSound;
    private Sound shotSound;
    private SpriteBatch batch1;

    @Override
    public void show() {
        super.show();
        laserSound = Gdx.audio.newSound(Gdx.files.internal("sounds/laser.wav"));
        shotSound = Gdx.audio.newSound(Gdx.files.internal("sounds/bullet.wav"));
        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.mp3"));
        music.setLooping(true);
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        bulletPool = new BulletPool();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        background.setScale(2f);
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }
        mainShip = new MainShip(atlas, bulletPool, laserSound);
        music.play();
        batch1 = new SpriteBatch();

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        mainShip.resize(worldBounds);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        freeAllDestroyed();
        draw();

    }

    private void update(float delta) {
        if (!super.paused) {
            batch1.begin();
            for (Star star : stars) {
                batch1.setColor(MathUtils.random(0.9f, 0.1f), MathUtils.random(0.9f, 0.1f),
                        MathUtils.random(0.9f, 0.1f), 1);
                star.draw(batch1);
                star.update(delta);
            }

            //  batch.setColor(Color.CLEAR);
            batch1.end();
            batch.begin();
            mainShip.update(delta);
            bulletPool.updateActiveSprites(delta);
            batch.end();


        }
    }

    private void draw() {
        batch1.begin();
        for (Star star : stars) {
            batch1.setColor(MathUtils.random(0.9f, 0.1f), MathUtils.random(0.9f, 0.1f),
                    MathUtils.random(0.9f, 0.1f), 1);
            star.draw(batch1);
        }
        //  batch.setColor(Color.CLEAR);

        batch.begin();
        background.draw(batch);
//        for (Star star : stars) {
//            star.draw(batch);
//
//        }
        bulletPool.drawActiveSprites(batch);
        mainShip.draw(batch);
        batch.end();
        batch1.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        mainShip.keyDown(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        mainShip.keyUp(keycode);
        return false;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        mainShip.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        mainShip.touchUp(touch, pointer, button);
        return false;
    }

    private void freeAllDestroyed() {
        bulletPool.freeAllDestroyed();
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlas.dispose();
        bulletPool.dispose();
        music.dispose();
        laserSound.dispose();
        shotSound.dispose();

    }


}
