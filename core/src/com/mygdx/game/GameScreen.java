package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.characters.Hero;
import com.mygdx.game.characters.Monster;

public class GameScreen {
    private SpriteBatch batch;
    private Hero hero;
    private Monster monster;

    public Hero getHero() {
        return hero;
    }

    public Monster getMonster() {
        return monster;
    }

    public GameScreen(SpriteBatch batch) {
        this.batch = batch;
    }

    public void create() {
        hero = new Hero();
        monster = new Monster(this);
    }

    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        update(dt);
        Gdx.gl.glClearColor(0, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        hero.render(batch);
        monster.render(batch);
        batch.end();

    }
    public void update (float dt) {
            hero.update(dt);
            monster.update(dt);

            if(hero.getPosition().dst(monster.getPosition()) < 40.0f) {
                hero.takeDamage(dt * 10.0f);
            }
            /*
            float dst = (float) Math.sqrt((hero.getX() - monster.getX()) * (hero.getX() - monster.getX()) + (hero.getY()- monster.getY()) * (hero.getY()- monster.getY()));
            if (dst < 40.0f) {
                hero.takeDamage(dt * 10.0f);
            }*/
    }

}
