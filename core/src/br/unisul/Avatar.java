package br.unisul;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import static br.unisul.Directions.DOWN;
import static br.unisul.Directions.LEFT;
import static br.unisul.Directions.RIGHT;
import static br.unisul.Directions.UP;

public class Avatar extends Actor {

    public Avatar(MyGdxGame game, float x, float y, Texture texture) {
        super(game, x, y, texture);
    }

    @Override
    protected void execute() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            move(UP);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            move(DOWN);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            move(RIGHT);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            move(LEFT);
        }
        collided = false;
        for (Actor a : game.actors) {
            if (collision(a)) {
                break;
            }
        }
    }
}
