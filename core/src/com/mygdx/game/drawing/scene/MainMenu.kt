package com.mygdx.game.drawing.scene

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.mygdx.game.drawing.Drawing
import com.mygdx.game.drawing.loaded

class MainMenu(assets: AssetManager) : Drawing {
    private val background = lazy {
        Sprite(
            assets.loaded("menubackground.png", Texture::class.java)
        )
    }

    override fun drawOn(batch: Batch) {
        background.value.setSize(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        background.value.draw(batch)
    }
}