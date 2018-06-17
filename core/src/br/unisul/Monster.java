package br.unisul;

import com.badlogic.gdx.graphics.Texture;

import br.unisul.behaviors.ActorBehavior;

public class Monster extends Actor {

    private ActorBehavior behavior;

    protected Monster(MyGdxGame game, float x, float y, Texture texture) {
        super(game, x, y, texture);
    }

    @Override
    public void execute() {
        if (behavior != null) {
            behavior.execute();
        }
    }

    public void setBehavior(ActorBehavior behavior) {
        this.behavior = behavior;
    }
}
