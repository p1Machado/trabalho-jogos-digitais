package br.unisul.character;

public abstract class Character {

    private CharacterState state;

    public Character(CharacterState initialState) {
        this.state = initialState;
    }

    public void draw() {
        state.draw();
    }
}
