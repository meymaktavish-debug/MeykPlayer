package com.auralis.player.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DiscoverScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Discover", style = MaterialTheme.typography.headlineLarge)
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Открывай новую музыку", style = MaterialTheme.typography.titleLarge)
                Text(
                    "Здесь будет настоящий поиск по открытым музыкальным каталогам. Интеграции ещё не подключены — фиктивные результаты не показываются.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
