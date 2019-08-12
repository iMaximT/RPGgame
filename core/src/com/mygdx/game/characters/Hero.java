package com.mygdx.game.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameScreen;

import java.util.Vector;

public class Hero extends GameCharacter{


    public Hero(GameScreen gameScreen){
        this.gameScreen = gameScreen;
        this.texture = new Texture("Knight.png");
        this.textureHp = new Texture("Bar.png");
        this.position = new Vector2(200, 200);
        this.hpMax = 100.0f;
        this.hp = this.hpMax;
        this.speed = 100.0f;
        this.weapon = new Weapon("Sword", 50.0f, 0.5f, 4.0f);
    }

    @Override
    public void update(float dt) {
        damageEffectTimer -= dt;

        float dst = gameScreen.getHero().getPosition().dst(this.position);
        if (dst < weapon.getAttackRadius()) {
            attackTimer += dt;
            if(attackTimer> weapon.getAttackPeriod()){
                attackTimer = 0.0f;
                gameScreen.getMonster().takeDamage(weapon.getDamage());
            }
        }

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
