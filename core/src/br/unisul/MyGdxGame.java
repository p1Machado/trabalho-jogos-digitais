package br.unisul;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import br.unisul.character.hercules.Hercules;
import br.unisul.character.hercules.IdleHercules;
import br.unisul.env.SpriteHandler;

public class MyGdxGame extends ApplicationAdapter {

    public int maxWidth, maxHeight;
    private SpriteHandler spriteHandler;
    private Hercules hercules;

    @Override
    public void create() {
        maxWidth = Gdx.graphics.getWidth();
        maxHeight = Gdx.graphics.getHeight();
        spriteHandler = SpriteHandler.getInstance();
        try {
            spriteHandler.registerSprite(IdleHercules.class, "Idle.png");
        } catch (Exception e) {
            Gdx.app.exit();
        }

        hercules = new Hercules(new IdleHercules());

        // Load textures
    }

    @Override
    public void render() {
        spriteHandler.getBatch().begin();

        hercules.draw();

        spriteHandler.getBatch().end();
    }

    @Override
    public void dispose() {
        spriteHandler.disposeAll();
    }

}
