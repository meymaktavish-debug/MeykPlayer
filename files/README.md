# Auralis

Auralis is a native Android music player project built with Kotlin, Jetpack Compose and Material 3.

## Current milestone

This starter project establishes:

- Native Android application structure.
- Jetpack Compose and Material 3 theme.
- Bottom navigation for Library, Discover and Settings.
- Four selectable player layout presets:
  - Pixel Clean
  - Immersive
  - Compact
  - Lyrics First
- Persistent player-layout selection using Preferences DataStore.
- GitHub Actions workflow that builds a debug APK in the cloud.

The music library, playback engine, lyrics, metadata and discovery integrations are not implemented yet. The UI deliberately does not show fake songs, lyrics or search results.

## Build with GitHub Actions

1. Create a GitHub repository named `Auralis`.
2. Upload the contents of this project to the repository root.
3. Make sure the default branch is named `main`.
4. Open the repository's **Actions** tab.
5. Select **Build Android APK** and run it with **Run workflow**, or push a commit to `main`.
6. When the workflow finishes, open the run and download the `Auralis-debug-apk` artifact.
7. Extract the downloaded ZIP to get `app-debug.apk`.

The workflow uses GitHub-hosted Ubuntu runners. Your computer is only used to upload files and download the APK.

## Project configuration

- Application ID: `com.auralis.player`
- Minimum Android version: Android 8.0 (API 26)
- Compile SDK: 36
- Target SDK: 36
- Java: 17
- Gradle: 8.13
- Android Gradle Plugin: 8.13.2
- Kotlin: 2.2.21
