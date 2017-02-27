package com.melardev.tutorialstheming;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityCreateShortcut extends AppCompatActivity {

    public static String ACTION_SHORTCUT_CREATE = "action_shortcut_create";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_shortcut);
        Intent shortcutIntent = new Intent(this, MainActivity.class);
        shortcutIntent.setAction(ACTION_SHORTCUT_CREATE);
        Intent.ShortcutIconResource iconResource = Intent.ShortcutIconResource.fromContext(this, R.drawable.barcelona);

        Intent intent = new Intent();
        //intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "TutorialsUI");
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconResource);

        setResult(RESULT_OK, intent);

        finish();
        //sendBroadcast(intent);
    }

    /*
    public static void addShortcut(Context context, Note note) {
        Intent shortcutIntent = new Intent(context, MainActivity.class);
        shortcutIntent.putExtra(Constants.INTENT_KEY, note.get_id());
        shortcutIntent.setAction(Constants.ACTION_SHORTCUT);

        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        String shortcutTitle = note.getTitle().length() > 0 ? note.getTitle() : DateHelper.getFormattedDate(note
                .getCreation(), OmniNotes.getSharedPreferences().getBoolean(Constants
                .PREF_PRETTIFIED_DATES, true));
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutTitle);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                Intent.ShortcutIconResource.fromContext(context, R.drawable.ic_shortcut));
        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");

        context.sendBroadcast(addIntent);
    }
    
    public static void removeshortCut(Context context, Note note) {
        Intent shortcutIntent = new Intent(context, MainActivity.class);
        shortcutIntent.putExtra(Constants.INTENT_KEY, note.get_id());
        shortcutIntent.setAction(Constants.ACTION_SHORTCUT);

        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        String shortcutTitle = note.getTitle().length() > 0 ? note.getTitle() : DateHelper.getFormattedDate(note
                .getCreation(), OmniNotes.getSharedPreferences().getBoolean(Constants
                .PREF_PRETTIFIED_DATES, true));

        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutTitle);

        addIntent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
        context.sendBroadcast(addIntent);
    }
    */
}
