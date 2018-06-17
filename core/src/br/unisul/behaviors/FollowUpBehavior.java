package br.unisul.behaviors;

import br.unisul.Actor;
import br.unisul.Avatar;
import br.unisul.MyGdxGame;

import static br.unisul.Directions.LEFT;
import static br.unisul.Directions.RIGHT;

public class FollowUpBehavior implements ActorBehavior {

    private Avatar avatar;
    private Actor monster;

    public FollowUpBehavior(MyGdxGame game, Actor monster) {
        this.avatar = game.avatar;
        this.monster = monster;
    }

    @Override
    public void execute() {
        float avatarX = avatar.getX();
        float avatarY = avatar.getY();

        float monsterX = monster.getX();
        float monsterY = monster.getY();

        if ((int) monsterX != (int) avatarX) {
            if (monsterX > avatarX) {
                monster.move(LEFT);
            } else if (monsterX < avatarX) {
                monster.move(RIGHT);
            }
        }
//        if (monsterY > avatarY) {
//            monster.move(DOWN);
//        } else if (monsterY < avatarY) {
//            monster.move(UP);
//        }
    }
}
