package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	private Hero hero;
	private Monster monster;
	//Texture img;


	public Hero getHero() {
		return hero;
	}

	public Monster getMonster() {
		return monster;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("Knight.png");
		hero = new Hero(); //36m
		monster = new Monster(this);
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		Gdx.gl.glClearColor(0, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		hero.render(batch);
		monster.render(batch);
		/*batch.draw(img, 0, 0);
		batch.draw(img, 100, 0);
		*/
		batch.end();
	}

	public void update (float dt) {
		hero.update(dt);
		monster.update(dt);
		float dst = (float) Math.sqrt((hero.getX() - monster.getX()) * (hero.getX() - monster.getX()) + (hero.getY()- monster.getY()) * (hero.getY()- monster.getY()));
		if (dst < 40.0f) {
			hero.takeDamage(dt * 10.0f);
		}

	}

		@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
