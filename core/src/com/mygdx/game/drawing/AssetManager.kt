package com.mygdx.game.drawing

import com.badlogic.gdx.assets.AssetManager

/**
 * Queues the asset to load, loads them and returns the loaded asset.
 */
fun <T> AssetManager.loaded(path: String, type: Class<T>) =
    run {
        load(path, type)
        finishLoadingAsset(path)
        get(path, type)
    }
