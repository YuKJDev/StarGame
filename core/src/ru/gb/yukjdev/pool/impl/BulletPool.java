package ru.gb.yukjdev.pool.impl;

import ru.gb.yukjdev.pool.SpritesPool;
import ru.gb.yukjdev.sprite.impl.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
