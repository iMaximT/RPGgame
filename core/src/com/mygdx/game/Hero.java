package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hero {
    private Texture texture;
    private float x;
    private float y;
    private float speed;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Hero(){
        texture = new Texture("Knight.png");
        x = 200.0f;
        y = 200.0f;
        speed = 100.0f;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, x, y);
    }

    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += speed * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= speed * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y+= speed * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y-= speed * dt;
        }

    }
}
