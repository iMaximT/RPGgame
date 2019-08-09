package com.mygdx.game.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class Hero extends GameCharacter{

    public Hero(){
        texture = new Texture("Knight.png");
        textureHp = new Texture("Bar.png");
        position = new Vector2(200, 200);
        hpMax = 100.0f;
        hp = hpMax;
        speed = 100.0f;
    }

    @Override
    public void render(SpriteBatch batch){
        if(damageEffectTimer > 0.0f) {
            batch.setColor(1,1- damageEffectTimer, 1-damageEffectTimer, 1);
        }
        batch.draw(texture, position.x - 40, position.y - 40);
        batch.setColor(0,0,0,1);

        batch.draw(textureHp, position.x - 42, position.y + 80 - 42, 84, 16);//0 , 0, hp,20,1,1,0,0,0,80, 20, false, false);
        batch.setColor(1,0,0,1);
        batch.draw(textureHp, position.x - 40, position.y + 80 - 40, 0 , 0, hp/hpMax * 80,12,1,1,0,0,0,80, 20, false, false);
        batch.setColor(1,1,1,1);
    }
    @Override
    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += speed * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= speed * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            position.y+= speed * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            position.y-= speed * dt;
        }

        checkScreenBounds();

    }
}
