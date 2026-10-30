package com.auralis.player.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.auralis.player.ui.PlayerStyle

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    selectedStyle: PlayerStyle,
    onStyleSelected: (PlayerStyle) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp)
    ) {
        Text(
            text = "Настройки",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(top = 22.dp, bottom = 6.dp)
        )
        Text(
            text = "Внешний вид",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 18.dp, bottom = 4.dp)
        )
        Text(
            text = "Выбери компоновку будущего экрана воспроизведения. Выбор сохраняется на устройстве.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            PlayerStyle.entries.forEach { style ->
                PlayerStyleCard(
                    style = style,
                    selected = selectedStyle == style,
                    onClick = { onStyleSelected(style) }
                )
            }
        }

        Text(
            text = "Шаблон будет применён к экрану плеера после реализации самого плеера. Сейчас работает выбор и сохранение шаблона.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(top = 14.dp, bottom = 20.dp)
        )
    }
}

@Composable
private fun PlayerStyleCard(
    style: PlayerStyle,
    selected: Boolean,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        border = if (selected) {
            BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
        } else {
            null
        },
        colors = CardDefaults.cardColors(
            containerColor = if (selected) {
                MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.45f)
            } else {
                MaterialTheme.colorScheme.surface
            }
        )
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            PlayerStylePreview(style = style)
            Column(modifier = Modifier.weight(1f)) {
                Text(style.title, style = MaterialTheme.typography.titleMedium)
                Text(
                    style.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            RadioButton(selected = selected, onClick = onClick)
        }
    }
}

@Composable
private fun PlayerStylePreview(style: PlayerStyle) {
    val shape = RoundedCornerShape(16.dp)
    val surface = MaterialTheme.colorScheme.surfaceVariant
    val accent = MaterialTheme.colorScheme.primary

    Box(
        modifier = Modifier
            .size(width = 104.dp, height = 116.dp)
            .clip(shape)
            .background(surface)
            .padding(9.dp)
    ) {
        when (style) {
            PlayerStyle.PIXEL -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Box(
                        Modifier
                            .weight(1f)
                            .fillMaxWidth(0.78f)
                            .clip(RoundedCornerShape(10.dp))
                            .background(accent.copy(alpha = 0.65f))
                    )
                    Box(Modifier.fillMaxWidth(0.8f).height(5.dp).clip(RoundedCornerShape(8.dp)).background(accent))
                    Box(Modifier.fillMaxWidth(0.5f).height(4.dp).clip(RoundedCornerShape(8.dp)).background(accent.copy(alpha = 0.35f)))
                    Text("◀   ●   ▶", style = MaterialTheme.typography.labelSmall)
                }
            }
            PlayerStyle.IMMERSIVE -> {
                Box(Modifier.fillMaxSize().clip(RoundedCornerShape(12.dp)).background(accent.copy(alpha = 0.55f))) {
                    Column(
                        Modifier.align(Alignment.BottomCenter).padding(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("♫", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onPrimary)
                        Text("●  ●  ●", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onPrimary)
                    }
                }
            }
            PlayerStyle.COMPACT -> {
                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Box(Modifier.size(34.dp).clip(RoundedCornerShape(7.dp)).background(accent.copy(alpha = 0.65f)))
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Box(Modifier.fillMaxWidth().height(5.dp).clip(RoundedCornerShape(8.dp)).background(accent))
                            Box(Modifier.fillMaxWidth(0.65f).height(4.dp).clip(RoundedCornerShape(8.dp)).background(accent.copy(alpha = 0.35f)))
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Box(Modifier.fillMaxWidth().height(4.dp).clip(RoundedCornerShape(8.dp)).background(accent.copy(alpha = 0.4f)))
                    Text("◀      ▶", modifier = Modifier.align(Alignment.CenterHorizontally), style = MaterialTheme.typography.labelMedium)
                }
            }
            PlayerStyle.LYRICS_FIRST -> {
                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Lyrics", style = MaterialTheme.typography.labelSmall, color = accent)
                    Text("♪  ♫  ♪", style = MaterialTheme.typography.titleLarge)
                    Box(Modifier.fillMaxWidth(0.8f).height(5.dp).clip(RoundedCornerShape(8.dp)).background(accent))
                    Spacer(Modifier.height(5.dp))
                    Box(Modifier.fillMaxWidth(0.55f).height(4.dp).clip(RoundedCornerShape(8.dp)).background(accent.copy(alpha = 0.35f)))
                    Text("◀   ●   ▶", style = MaterialTheme.typography.labelSmall)
                }
            }
        }
    }
}
