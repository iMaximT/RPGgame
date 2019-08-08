package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Monster {
    private Texture texture;
    private float x;
    private float y;
    private float speed;
    private MyGdxGame game;

    //private float dirX, dirY;

    public Monster(MyGdxGame game){
        this.texture = new Texture("Skeleton.png");
        this.x = 200.0f;
        this.y = 200.0f;
        this.speed = 40.0f;
        this.game = game;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, x, y);
    }

    public void update(float dt) {
        float dst = (float) Math.sqrt((game.getHero().getX() - this.x) *
        /*
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += speed * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= speed * dt;
            if (x >= 1280) {
                x = 0.0f;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y+= speed * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y-= speed * dt;
        }
        */

    }
}

