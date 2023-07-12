package com.vinaylogics.simpleanimation.theme

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GetTweenAnimation(){
    var sizeState by remember {
        mutableStateOf(200.dp)
    }
    val size by animateDpAsState(
        targetValue = sizeState,
        tween(
            durationMillis = 3000,
            delayMillis = 300,
            easing = LinearOutSlowInEasing
        )
    )
    Box(modifier = Modifier
        .size(size)
        .background(Color.Red),
        contentAlignment = Alignment.Center) {

        Button(onClick = {
            sizeState += 50.dp
        }) {
            Text("Increase Size")
        }
    }
}

@Composable
fun GetSpringAnimation(){
    var sizeState by remember {
        mutableStateOf(200.dp)
    }
    val size by animateDpAsState(
        targetValue = sizeState,
        spring(
            Spring.DampingRatioHighBouncy
        )
    )
    Box(modifier = Modifier
        .size(size)
        .background(Color.Red),
        contentAlignment = Alignment.Center) {

        Button(onClick = {
            sizeState += 50.dp
        }) {
            Text("Increase Size")
        }
    }
}