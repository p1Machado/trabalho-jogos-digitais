package br.unisul.sprite;

import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoopSprite extends Sprite {

    private List<LoopStage> loop;
    private Iterator<LoopStage> iterator;

    public LoopSprite(Sprite sprite, int quantity) {
        super(sprite);
        loop = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            loop.add(new LoopStage(i * (int) sprite.getWidth(), i * (int) sprite.getHeight()));
        }
        iterator = loop.iterator();
    }

    public void next() {
        LoopStage current = iterator.next();
        if (!iterator.hasNext()) {
            iterator = loop.iterator();
        }
        setRegionX(current.x);
        setRegionY(current.y);
    }

    private class LoopStage {
        int x = 0;
        int y = 0;

        public LoopStage(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
