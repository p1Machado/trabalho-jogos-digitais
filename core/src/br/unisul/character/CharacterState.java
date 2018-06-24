package br.unisul.character;

import com.badlogic.gdx.graphics.g2d.Sprite;

import br.unisul.env.SpriteHandler;

public abstract class CharacterState {

    protected Sprite sprite;

    public abstract void draw();

}
