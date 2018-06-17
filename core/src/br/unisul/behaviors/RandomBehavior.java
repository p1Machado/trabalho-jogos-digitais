package br.unisul.behaviors;

import br.unisul.Actor;
import br.unisul.MyGdxGame;

import static br.unisul.Directions.DOWN;

public class RandomBehavior implements ActorBehavior {

    private int direction;
    private int count = 0;
    private int max;

    private MyGdxGame game;
    private Actor actor;

    public RandomBehavior(MyGdxGame game, Actor actor) {
        this.game = game;
        this.actor = actor;
        direction = game.rand.nextInt(4);
        max = game.rand.nextInt(20) + 1;
    }

    @Override
    public void execute() {
        count++;
        if (count > max) {
            count = 0;
            max = game.rand.nextInt(20) + 1;
            actor.move(game.rand.nextInt(4));
        } else {
            actor.move(direction);
        }
    }
}
