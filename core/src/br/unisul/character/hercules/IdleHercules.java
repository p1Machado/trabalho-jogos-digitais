package br.unisul.character.hercules;

import br.unisul.character.CharacterState;
import br.unisul.env.SpriteHandler;
import br.unisul.sprite.LoopSprite;

public class IdleHercules extends CharacterState {

    private int drawingCycleQuantity = 5;
    private int drawingCycleMax = 50;
    private int drawingCounter = 0;

    public IdleHercules() {
        sprite = new LoopSprite(SpriteHandler.getInstance().getSprite(IdleHercules.class), 6);
    }


    @Override
    public void draw() {
        drawingCounter++;
        if (drawingCounter == drawingCycleMax) {
            drawingCounter = 0;
            ((LoopSprite) sprite).next();
        }
        sprite.draw(SpriteHandler.getInstance().getBatch());
    }
}
