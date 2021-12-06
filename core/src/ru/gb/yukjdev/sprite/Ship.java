package ru.gb.yukjdev.sprite;


import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.gb.yukjdev.math.Rect;
import ru.gb.yukjdev.pool.impl.BulletPool;
import ru.gb.yukjdev.sprite.impl.Bullet;

public class Ship extends Sprite {
    protected Vector2 v;
    protected Vector2 v0;

    protected Sound shotSound;
    protected BulletPool bulletPool;
    protected TextureRegion bulletRegion;
    protected Vector2 bulletV;
    protected float bulletHeight;
    protected int damage;


    protected Rect worldBounds;

    protected int hp;

    protected float reloadTimer;
    protected float reloadInterval;

    public Ship() {
    }

    public Ship(TextureRegion region, int rows, int cols, int frames) {
        super(region, rows, cols, frames);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.mulAdd(v, delta);
        reloadTimer += delta;
        if (reloadTimer > reloadInterval) {
            reloadTimer = 0f;
            shoot();
        }
    }

    private void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, bulletV, bulletHeight, worldBounds, damage);
        shotSound.play();
    }


}
