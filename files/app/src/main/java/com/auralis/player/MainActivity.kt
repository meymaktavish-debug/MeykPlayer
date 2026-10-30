package com.auralis.player

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.auralis.player.ui.AuralisApp
import com.auralis.player.ui.theme.AuralisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuralisTheme {
                AuralisApp()
            }
        }
    }
}
