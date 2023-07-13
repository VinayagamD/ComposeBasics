package com.vinaylogics.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vinaylogics.mediationui.ui.home.HomeScreen
import com.vinaylogics.mytimer.Timer

class MainActivity : ComponentActivity() {


    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                color = Color(0xFF101010),
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ){
                    Timer(
                        totalTime = 100* 1000L,
                        handleColor = Color.Green,
                        activeBarColor = Color(0xFF37B900),
                        inactiveBarColor = Color.DarkGray,
                        modifier = Modifier.size(200.dp)
                    )
                }

            }
        }

    }
}


