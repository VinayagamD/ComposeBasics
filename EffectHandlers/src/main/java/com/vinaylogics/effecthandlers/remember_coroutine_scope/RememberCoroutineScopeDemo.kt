package com.vinaylogics.effecthandlers.remember_coroutine_scope

import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

@Composable
fun RememberCoroutineScopeDemo(){
    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch {
            delay(1.seconds)
            println("Hello World!")
        }
    }) {

    }
}