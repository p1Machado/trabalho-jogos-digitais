package br.unisul.env;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.Map;

import br.unisul.character.CharacterState;

public class SpriteHandler {

    private static final String WIDTH = "WIDTH";
    private static final String HEIGHT = "HEIGHT";

    public static SpriteHandler instance;

    public SpriteBatch batch;

    private Map<Class, Sprite> sprites = new HashMap<>();

    private SpriteHandler() {
        batch = new SpriteBatch();
    }

    public static SpriteHandler getInstance() {
        if (instance == null) {
            instance = new SpriteHandler();
        }
        return instance;
    }

    public Sprite registerSprite(Class<? extends CharacterState> characterKlass, String textureFile) throws Exception {
        Sprite sprite = new Sprite(new TextureRegion(new Texture(textureFile), 0, 0, 44, 60));
        sprites.put(characterKlass, sprite);
        return sprite;
    }

    public Sprite getSprite(Class id) {
        return sprites.get(id);
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void disposeAll() {
        batch.dispose();
        for (Sprite sprite : sprites.values()) {
            sprite.getTexture().dispose();
        }
    }
}
