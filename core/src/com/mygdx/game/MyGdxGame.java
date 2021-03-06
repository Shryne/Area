package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.drawing.Drawing;
import com.mygdx.game.drawing.scene.MainMenu;

public class MyGdxGame implements ApplicationListener {
	private SpriteBatch batch;
	private Camera camera;
	private Stage stage;
	private Drawing menu;
	private AssetManager assets;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		stage = new Stage(new ScreenViewport());
		camera = stage.getCamera();
		camera.position.set(camera.viewportWidth / 2F, camera.viewportHeight / 2F, 0);
		camera.update();
		assets = new AssetManager();
		menu = new MainMenu(assets);
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
		stage.getBatch().getProjectionMatrix().setToOrtho2D(0, 0, width, height);
		camera.update();
	}

	@Override
	public void render() {

		camera.update();
		batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		if (assets.update()) {
			menu.drawOn(batch);
		}
		batch.end();
	}

	@Override
	public void pause() { }

	@Override
	public void resume() { }

	@Override
	public void dispose() {
		batch.dispose();
		assets.dispose();
	}
}
