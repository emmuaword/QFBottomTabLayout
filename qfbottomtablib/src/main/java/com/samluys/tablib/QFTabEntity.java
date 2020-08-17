package com.samluys.tablib;


import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;

public interface QFTabEntity {
    String getTabTitle();

    @DrawableRes
    int getTabSelectedIcon();

    @DrawableRes
    int getTabUnselectedIcon();

    @DrawableRes
    int getTabCoverIcon();

    Drawable getTabSelectedIconDrawable();

    Drawable getTabUnselectedIconDrawable();

    Drawable getTabCoverIconDrawable();

    boolean getIsPublish();

    boolean getIsNewPage();
}