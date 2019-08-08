package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	private GameScreen gameScreen;
	//Texture img;

/*
	public Hero getHero() {
		return hero;
	}

	public Monster getMonster() {
		return monster;
	}
*/

	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.gameScreen = new GameScreen(batch);
		this.gameScreen.create();
		//img = new Texture("Knight.png");
	}

	@Override
	public void render () {
		gameScreen.render();
	}


		@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
