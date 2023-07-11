package com.vinaylogics.effecthandlers.launched_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun LaunchedEffectFlowDemo(
    viewModel: LaunchEffectViewModel
) {
    LaunchedEffect(key1 = true) {
        viewModel.sharedFlow.collect { event ->
            when(event){
                is LaunchEffectViewModel.ScreenEvents.ShowSnackBar -> {

                }
                is LaunchEffectViewModel.ScreenEvents.Navigate -> {

                }
            }

        }
    }
}