package com.vinaylogics.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vinaylogics.animatecircularprogressbar.CircularProgressBar
import com.vinaylogics.simpleanimation.GetInfiniteTransitionAnimation

class MainActivity : ComponentActivity() {


    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Box(
               contentAlignment = Alignment.Center,
               modifier = Modifier.fillMaxSize()
           ) {

               CircularProgressBar(percentage = 0.8f, number = 100)

           }
        }

    }
}




@Preview(showBackground = true)
@Composable
fun ShowImageCard(){

}

