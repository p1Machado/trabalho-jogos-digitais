package br.unisul;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;

import static br.unisul.Directions.DOWN;
import static br.unisul.Directions.LEFT;
import static br.unisul.Directions.RIGHT;
import static br.unisul.Directions.UP;

public abstract class Actor {

    private static final int SPEED = 2;
    private static final int COUNTER_MAX = 10;

    protected MyGdxGame game;
    protected int direction = DOWN;
    protected boolean collided = false;

    private Sprite sprite;
    private int spriteWidth = 64;
    private int spriteHeight = 64;
    private int step = 0;
    private int counter;
    private boolean moved = false;

    protected Actor(MyGdxGame game, float x, float y, Texture texture) {
        this.game = game;
        this.sprite = new Sprite(new TextureRegion(texture, 0, 0, spriteWidth, spriteHeight));
        sprite.setPosition(x, y);
    }

    protected abstract void execute();

    public void run() {
        execute();
        counter++;
        if (counter > COUNTER_MAX) {
            counter = 0;
            if (moved) step = (step == 1) ? 0 : 1;
        }
        moved = false;
    }

    public void move(int dir) {
        direction = dir;
        if (direction == UP) {
            sprite.setY(sprite.getY() + SPEED);
            moved = true;
        } else if (direction == DOWN) {
            sprite.setY(sprite.getY() - SPEED);
            moved = true;
        } else if (direction == RIGHT) {
            sprite.setX(sprite.getX() + SPEED);
            moved = true;
        } else if (direction == LEFT) {
            sprite.setX(sprite.getX() - SPEED);
            moved = true;
        }
        if (sprite.getX() < 0) {
            sprite.setX(0);
        }
        if (sprite.getX() + spriteWidth > game.maxWidth) {
            sprite.setX(game.maxWidth - spriteWidth - 1);
        }
        if (sprite.getY() < 0) {
            sprite.setY(0);
        }
        if (sprite.getY() + spriteHeight > game.maxHeight) {
            sprite.setY(game.maxHeight - spriteHeight - 1);
        }
    }

    protected boolean collision(Actor other) {
        collided = (this != other) &&
                Intersector.overlaps(
                        sprite.getBoundingRectangle(),
                        other.sprite.getBoundingRectangle());
        return collided;
    }

    public void draw() {
        sprite.setRegion(step * spriteWidth, direction * spriteHeight, spriteWidth, spriteHeight);
        sprite.draw(game.batch);
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

}
