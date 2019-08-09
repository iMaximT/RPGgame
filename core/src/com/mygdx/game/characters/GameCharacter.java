package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameScreen;

public abstract class GameCharacter {
     GameScreen gameScreen;

     Texture texture;
     Texture textureHp;
     Vector2 position;
     float speed;
     float  hp, hpMax;
     float damageEffectTimer;

     public Vector2 getPosition() {
          return position;
     }

     public abstract void update(float dt);

     public abstract void render (SpriteBatch batch);

     public void checkScreenBounds() {
          if (position.x > 1280.0f) {
               position.x = 1280.0f;
          }
          if (position.x < 0.0f) {
               position.x = 0.0f;
          }
          if (position.y > 720.0f) {
               position.y = 720.0f;
          }
          if (position.y < 0.0f) {
               position.y = 0.0f;
          }
     }

    public void takeDamage(float amount) {
        hp -= amount;
        damageEffectTimer += 0.5f;
        if(damageEffectTimer > 1.0f){
            damageEffectTimer = 1.0f;
        }
    }


}
