package com.example.jetpackcomponentscatalogdev.model

import androidx.annotation.DrawableRes
import java.util.concurrent.SubmissionPublisher

data class SuperHero(
    var superHeroName: String,
    var realName: String,
    var publisher: String,
    @DrawableRes var photo: Int
)
