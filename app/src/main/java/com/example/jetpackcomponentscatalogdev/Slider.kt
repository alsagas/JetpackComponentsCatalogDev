package com.example.jetpackcomponentscatalogdev

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MyBasicSlider() {
    Column(Modifier.padding(10.dp),horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderpsosition by remember { mutableStateOf(0f) }
        var completeValue by remember { mutableStateOf("") }
        Slider(value = sliderpsosition, onValueChange = {sliderpsosition = it})
        Text(text = sliderpsosition.toString())
    }
}
@Preview
@Composable
fun MyAdvanceSlider() {
    Column(Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0f) }
        var completeValue by remember { mutableStateOf("") }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = { completeValue = sliderPosition.toString() },
            valueRange = 0f..10f,
            steps = 9,
            enabled = false
        )
        Text(text = completeValue)
    }
}
@Preview
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        var currentRange by remember { mutableStateOf(0f..10f) }

        RangeSlider(
            values = currentRange,
            onValueChange = { currentRange = it },
            valueRange = 0f..10f,
            steps = 9
        )

        Text(text = "Valor inferior ${currentRange.start}")
        Text(text = "Valor Superior ${currentRange.endInclusive}")
    }
}
