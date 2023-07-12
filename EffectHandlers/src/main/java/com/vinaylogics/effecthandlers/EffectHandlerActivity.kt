package com.vinaylogics.effecthandlers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.vinaylogics.theme.ui.theme.ComposeBasicsTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {


    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           var text by remember {
               mutableStateOf("")
           }

            ComposeBasicsTheme {
                LaunchedEffect(key1 = text ) {
                    delay(1.seconds)
                    println("The text is $text")
                }
                
            }
        }

    }
}




@Preview(showBackground = true)
@Composable
fun ShowImageCard(){

}

