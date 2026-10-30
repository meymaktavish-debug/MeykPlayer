package com.auralis.player.ui

enum class PlayerStyle(
    val title: String,
    val description: String
) {
    PIXEL(
        title = "Pixel Clean",
        description = "Обложка, аккуратная типографика и простые элементы управления."
    ),
    IMMERSIVE(
        title = "Immersive",
        description = "Крупная обложка и атмосферная композиция с цветами альбома."
    ),
    COMPACT(
        title = "Compact",
        description = "Компактная компоновка: больше места для очереди и библиотеки."
    ),
    LYRICS_FIRST(
        title = "Lyrics First",
        description = "Тексты песен занимают центральное место на экране."
    )
}
