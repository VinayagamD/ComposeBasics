package com.vinaylogics.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {


    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var sizeState by remember {
                mutableStateOf(200.dp)
            }
            val size by animateDpAsState(
                targetValue = sizeState,
                tween(
                    durationMillis = 3000,
                    delayMillis = 300,
                    easing = LinearOutSlowInEasing)
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

    }
}




@Preview(showBackground = true)
@Composable
fun ShowImageCard(){

}

