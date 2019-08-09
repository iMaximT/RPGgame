package com.mygdx.game.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameScreen;

public class Monster extends GameCharacter {
    private Vector2 direction;
    private Vector2 temp;
    private float moveTimer;
    private float attackTimer;
    private float attackPeriod;
    private float activityRadius;
    private float attackRadius;


    public Monster(GameScreen gameScreen){
        this.texture = new Texture("Skeleton.png");
        this.position = new Vector2(280.0f, 200.0f);
        this.direction = new Vector2(0,0);
        this.temp = new Vector2(0, 0);
        this.speed = 40.0f;
        this.activityRadius = 200.0f;
        this.attackRadius = 50.0f;
        this.gameScreen = gameScreen;
        this.hpMax = 40;
        this.hp = hpMax;
        this.attackPeriod = 0.4f;

    }


    @Override
    public void render(SpriteBatch batch){
        batch.draw(texture, position.x - 40, position.y - 40);
    }

    @Override
    public void update(float dt) {
        float dst = gameScreen.getHero().getPosition().dst(this.position);
        if( dst < activityRadius) {
            temp.set(gameScreen.getHero().getPosition()).sub(this.position).nor();//отправил монстра в сторону героя
            position.mulAdd(temp,speed * dt);

        } else {
            position.mulAdd(direction,speed * dt);//масштабирование вектора движения
            moveTimer -= dt;
            if(moveTimer  < 0.0f) {
                moveTimer = MathUtils.random(1.0f, 4.0f);
                direction.set(MathUtils.random(-1.0f, 1.0f), MathUtils.random(-1.0f, 1.0f));
                direction.nor();
            }
        }

        if (dst < attackRadius) {
            attackTimer +=dt;
            if(attackTimer >= attackPeriod) {
                attackTimer = 0.0f;
                gameScreen.getHero().takeDamage(5.0f);

            }
        }

        checkScreenBounds();


    }
}

