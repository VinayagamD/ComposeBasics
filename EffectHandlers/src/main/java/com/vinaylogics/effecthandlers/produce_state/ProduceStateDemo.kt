package com.vinaylogics.effecthandlers.produce_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.seconds

@Composable
fun ProduceStateDemo(countUpTo: Int): State<Int> {

    return flow<Int> {
        var value = 0
        while (value < countUpTo) {
            delay(1.seconds)
            value ++
            emit(value)
        }
    }.collectAsState(initial = 0)

}