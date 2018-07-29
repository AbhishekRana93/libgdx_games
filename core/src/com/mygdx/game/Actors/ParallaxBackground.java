package com.mygdx.game.Actors;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;

public class ParallaxBackground extends Actor {

    Array<Texture> layers;
    int srcX, srcY, scroll, speed;
    MyGdxGame game;

    public ParallaxBackground(Array<Texture> textures, MyGdxGame game) {
        this.game = game;
        scroll = srcY = speed = 0;
        layers = textures;
        for(int i = 0; i < textures.size ; i++) {
            layers.get(i).setWrap(Texture.TextureWrap.MirroredRepeat,
                    Texture.TextureWrap.MirroredRepeat);
        }

    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a * parentAlpha);

//        scroll += speed;

        for(int i = 0; i < layers.size; i++) {

//            srcX = scroll + i*scroll;
            batch.draw(
                    layers.get(i), 0, 0, 0, 0, game.V_WIDTH,
                    game.V_HEIGHT, 1, 1, 0, srcX, srcY,
                    layers.get(i).getWidth(), layers.get(i).getHeight(), false, false
            );

        }
    }
}