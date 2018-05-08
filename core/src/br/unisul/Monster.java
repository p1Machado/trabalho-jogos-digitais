package br.unisul;

import com.badlogic.gdx.graphics.Texture;

public class Monster extends Actor {

    private int count = 0;
    private int max;

    protected Monster(MyGdxGame game, float x, float y, Texture texture) {
        super(game, x, y, texture);
        direction = game.rand.nextInt(4);
        max = game.rand.nextInt(20) + 1;
    }

    @Override
    public void execute() {
        count++;
        if (count > max) {
            count = 0;
            max = game.rand.nextInt(20) + 1;
            move(game.rand.nextInt(4));
        } else {
            move(direction);
        }
    }
}
