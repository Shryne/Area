package com.mygdx.game.drawing

import com.badlogic.gdx.graphics.g2d.Batch

interface Drawing {
    /**
     * Draws itself on the given batch. Note that [Batch.begin] and [Batch.end] won't be called
     * here and must be called before calling this method.
     */
    fun drawOn(batch: Batch)
}