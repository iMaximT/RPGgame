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
    private float activityRadius;
    private GameScreen gameScreen;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Monster(GameScreen gameScreen){
        this.texture = new Texture("Skeleton.png");
        this.x = 200.0f;
        this.y = 200.0f;
        this.speed = 40.0f;
        this.activityRadius = 300.0f;
        this.gameScreen = gameScreen;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, x, y);
    }

    public void update(float dt) {
        float dst = (float) Math.sqrt((gameScreen.getHero().getX() - this.x) * (gameScreen.getHero().getX() - this.x) + (gameScreen.getHero().getY()- this.y) * (gameScreen.getHero().getY()- this.y));
        if (dst <= activityRadius) {
            if (x < gameScreen.getHero().getX()) {
                x += speed * dt;
            } else {
                x -= speed * dt;
            }
            if (y < gameScreen.getHero().getY()) {
                y += speed * dt;
            } else {
                y -= speed * dt;
            }


        } else {
            x += speed * dt;
            if (x > 1280) {
                x = 0.0f;
            }
        }

    }
}

