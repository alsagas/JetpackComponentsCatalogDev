package com.example.jetpackcomponentscatalogdev.ui.theme

import android.service.quicksettings.Tile

data class CheckInfo(
    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)
