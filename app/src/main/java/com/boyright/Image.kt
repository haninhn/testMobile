package com.boyright



data class Image (
    val id: Int,
    var imageSrc : Int,
    var selected : Boolean,
    var orientation: String,
    var start : Int
        )