package com.example.newsapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.newsapp.ui.navgraph.NavGraph
import com.example.newsapp.ui.theme.NewsAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().setKeepOnScreenCondition { viewModel.splashCondition }
        setContent {
            NewsAppTheme {
                val isDarkMode = isSystemInDarkTheme()
                val uiController = rememberSystemUiController()

                SideEffect {
                    uiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isDarkMode
                    )
                }

                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    NavGraph(startDestination = viewModel.startDestination)
                }
            }
        }
    }
}