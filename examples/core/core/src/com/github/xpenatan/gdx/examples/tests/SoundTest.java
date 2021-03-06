package com.github.xpenatan.gdx.examples.tests;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class SoundTest implements ApplicationListener {
	Sound sound;
	float volume = 0.5f;
	long soundId = 0;
	Stage ui;
	Skin skin;

	@Override
	public void create () {
		sound = Gdx.audio.newSound(Gdx.files.getFileHandle("data/shotgun.ogg", FileType.Internal));

		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		ui = new Stage(new FitViewport(640, 400));
		TextButton play = new TextButton("Play", skin);
		TextButton stop = new TextButton("Stop", skin);
		TextButton loop = new TextButton("Loop", skin);
		final Slider pitch = new Slider(0.1f, 4, 0.1f, false, skin);
		pitch.setValue(1);
		final Label pitchValue = new Label("1.0", skin);
		final Slider volume = new Slider(0.1f, 1, 0.1f, false, skin);
		volume.setValue(1);
		final Label volumeValue = new Label("1.0", skin);
		Table table = new Table();
		final Slider pan = new Slider(-1f, 1f, 0.1f, false, skin);
		pan.setValue(0);
		final Label panValue = new Label("0.0", skin);
		table.setFillParent(true);

		table.align(Align.center | Align.top);
		table.columnDefaults(0).expandX().right().uniformX();
		table.columnDefaults(2).expandX().left().uniformX();
		table.add(play);
		table.add(loop).left();
		table.add(stop).left();
		table.row();
		table.add(new Label("Pitch", skin));
		table.add(pitch);
		table.add(pitchValue);
		table.row();
		table.add(new Label("Volume", skin));
		table.add(volume);
		table.add(volumeValue);
		table.row();
		table.add(new Label("Pan", skin));
		table.add(pan);
		table.add(panValue);
		ui.addActor(table);

		play.addListener(new ClickListener() {
			@Override
			public void clicked (InputEvent event, float x, float y) {
				soundId = sound.play(volume.getValue());
				sound.setPitch(soundId, pitch.getValue());
				sound.setPan(soundId, pan.getValue(), volume.getValue());
			}
		});

		loop.addListener(new ClickListener() {
			@Override
			public void clicked (InputEvent event, float x, float y) {
				if (soundId == 0) {
					soundId = sound.loop(volume.getValue());
					sound.setPitch(soundId, pitch.getValue());
					sound.setPan(soundId, pan.getValue(), volume.getValue());
				} else {
					sound.setLooping(soundId, true);
				}
			}
		});
		stop.addListener(new ClickListener() {
			@Override
			public void clicked (InputEvent event, float x, float y) {
				sound.stop(soundId);
				soundId = 0;
			}
		});
		pitch.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				sound.setPitch(soundId, pitch.getValue());
				pitchValue.setText("" + pitch.getValue());
			}
		});
		volume.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				sound.setVolume(soundId, volume.getValue());
				volumeValue.setText("" + volume.getValue());
			}
		});
		pan.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				sound.setPan(soundId, pan.getValue(), volume.getValue());
				panValue.setText("" + pan.getValue());
			}
		});
		Gdx.input.setInputProcessor(ui);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ui.act(Gdx.graphics.getDeltaTime());
		ui.draw();
	}

	@Override
	public void dispose () {
		ui.dispose();
		skin.dispose();
		sound.dispose();
	}

	@Override
	public void resize (int width, int height) {
	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}
}
