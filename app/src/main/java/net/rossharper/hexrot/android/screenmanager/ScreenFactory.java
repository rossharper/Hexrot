package net.rossharper.hexrot.android.screenmanager;

import android.app.Fragment;

// TODO: invert perhaps? A command pattern for displaying a screen?
// The command is created android-side and provided with the screen manager
// It knows that it creates and displays a fragment so it can do that with the screen manager
// directly.
// Hopefully avoids the return type issue and allow the commands to be used in java land
// without needing to use event bus.
// (But perhaps then fire event anyway that stats can hang off)

public interface ScreenFactory {
    Fragment getScreen();
}
