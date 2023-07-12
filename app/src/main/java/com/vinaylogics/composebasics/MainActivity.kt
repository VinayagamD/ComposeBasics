package com.vinaylogics.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vinaylogics.simpleanimation.GetInfiniteTransitionAnimation

class MainActivity : ComponentActivity() {


    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           GetInfiniteTransitionAnimation()
        }

    }
}




@Preview(showBackground = true)
@Composable
fun ShowImageCard(){

}

