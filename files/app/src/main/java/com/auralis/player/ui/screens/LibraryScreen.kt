package com.auralis.player.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LibraryScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Text("Auralis", style = MaterialTheme.typography.headlineLarge)
        Text("Твоя музыка — в одном месте", style = MaterialTheme.typography.titleMedium)

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Музыкальная библиотека", style = MaterialTheme.typography.titleLarge)
                Text(
                    "На следующем этапе подключим MediaStore и покажем реальные аудиофайлы с твоего телефона. Сейчас библиотека ещё не сканируется.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Spacer(Modifier.height(4.dp))
        Text("Недавно добавленные", style = MaterialTheme.typography.titleMedium)
        Text(
            "Здесь появятся найденные на устройстве треки после реализации сканирования библиотеки.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
