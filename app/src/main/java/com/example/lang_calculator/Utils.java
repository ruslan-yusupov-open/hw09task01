package com.example.lang_calculator;


import android.app.Activity;
import android.content.Intent;

class Utils {
    private static int sTheme;
    private static int sColor;

    public final static int THEME_SMALL = 0;
    public final static int THEME_AVG = 1;
    public final static int THEME_BIG = 2;

    public final static int COLOR_BLACK = 0;
    public final static int COLOR_GREEN = 1;
    public final static int COLOR_BLUE = 2;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme, int color) {
        sTheme = theme;
        sColor = color;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    /**
     * Set the theme of the activity, according to the configuration.
     */
    public static void onActivityCreateSetTheme(Activity activity) {
        if (sTheme == THEME_SMALL && sColor == COLOR_BLACK)
            activity.setTheme(R.style.AppTheme);

        if (sColor == COLOR_BLACK)
            switch (sTheme) {
                case THEME_AVG:
                    activity.setTheme(R.style.AppAvgMargin);
                    break;
                case THEME_BIG:
                    activity.setTheme(R.style.AppBigMargin);
                    break;
            }

        if (sTheme == THEME_SMALL)
            switch (sColor) {
                case COLOR_GREEN:
                    activity.setTheme(R.style.AppThemeGreen);
                    break;
                case COLOR_BLUE:
                    activity.setTheme(R.style.AppThemeBlue);
                    break;
            }
    }

    public static int getsTheme() {
        return sTheme;
    }

    public static int getsColor() {
        return sColor;
    }
}