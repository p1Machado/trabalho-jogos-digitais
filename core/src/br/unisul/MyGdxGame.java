package br.unisul;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {

    public Random rand = new Random();
    public int maxWidth, maxHeight;
    SpriteBatch batch;
    Actor avatar;
    Texture avatarTexture;
    Texture monsterTexture;
    private Texture industrialTexture;
    List<Actor> actors = new ArrayList<Actor>();
    private long lastTimeCounted;
    private float sinceChange;
    private float frameRate;
    private BitmapFont font;

    @Override
    public void create() {
        maxWidth = Gdx.graphics.getWidth();
        maxHeight = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        avatarTexture = new Texture("avatar.png");
        monsterTexture = new Texture("monster.png");
        industrialTexture = new Texture("industrial.png");
        avatar = new Avatar(this, 200, 200, avatarTexture);
        actors.add(avatar);
        for (int i = 0; i < 10; i++) {
            actors.add(new Monster(this, rand.nextInt(700), rand.nextInt(500), monsterTexture));
        }
        font = new BitmapFont(
                Gdx.files.internal("verdana.fnt"),
                Gdx.files.internal("verdana.png"), false);
        font.setColor(1, 1, 1, 1);
        lastTimeCounted = TimeUtils.millis();
        sinceChange = 0;
        frameRate = Gdx.graphics.getFramesPerSecond();
    }

    private void execute() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
        for (Actor a : actors) a.run();
        long delta = TimeUtils.timeSinceMillis(lastTimeCounted);
        lastTimeCounted = TimeUtils.millis();
        sinceChange += delta;
        if (sinceChange >= 1000) {
            sinceChange = 0;
            frameRate = Gdx.graphics.getFramesPerSecond();
        }
    }

    @Override
    public void render() {
        execute();

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(industrialTexture, 0, 0);
        for (Actor a : actors) a.draw();
        if (avatar.collided) {
            font.draw(batch, "Collided!   " + (int) frameRate + " fps", 1, maxHeight + 1);
        } else {
            font.draw(batch, "I'm free... " + (int) frameRate + " fps", 1, maxHeight + 1);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        avatarTexture.dispose();
        monsterTexture.dispose();
        industrialTexture.dispose();
    }
}
