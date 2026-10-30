package com.auralis.player.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.auralis.player.data.AppearanceStore
import com.auralis.player.ui.screens.DiscoverScreen
import com.auralis.player.ui.screens.LibraryScreen
import com.auralis.player.ui.screens.SettingsScreen
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

private enum class AppTab(val title: String, val symbol: String) {
    LIBRARY("Библиотека", "♫"),
    DISCOVER("Поиск", "⌕"),
    SETTINGS("Настройки", "⚙")
}

@Composable
fun AuralisApp() {
    val context = LocalContext.current
    val store = remember { AppearanceStore(context) }
    val scope = rememberCoroutineScope()

    val savedStyleName by store.playerStyle
        .map { preferences ->
            preferences[AppearanceStore.styleKey]
                ?: AppearanceStore.DEFAULT_PLAYER_STYLE
        }
        .collectAsState(initial = AppearanceStore.DEFAULT_PLAYER_STYLE)

    val selectedStyle = PlayerStyle.entries.firstOrNull { it.name == savedStyleName }
        ?: PlayerStyle.PIXEL

    var selectedTab by remember { mutableStateOf(AppTab.LIBRARY) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                AppTab.entries.forEach { tab ->
                    NavigationBarItem(
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab },
                        icon = { Text(tab.symbol) },
                        label = { Text(tab.title) }
                    )
                }
            }
        }
    ) { innerPadding ->
        when (selectedTab) {
            AppTab.LIBRARY -> LibraryScreen(Modifier.padding(innerPadding))
            AppTab.DISCOVER -> DiscoverScreen(Modifier.padding(innerPadding))
            AppTab.SETTINGS -> SettingsScreen(
                modifier = Modifier.padding(innerPadding),
                selectedStyle = selectedStyle,
                onStyleSelected = { style ->
                    scope.launch { store.savePlayerStyle(style.name) }
                }
            )
        }
    }
}
