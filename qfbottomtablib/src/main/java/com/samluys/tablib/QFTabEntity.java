package com.samluys.tablib;


import android.support.annotation.DrawableRes;

public interface QFTabEntity {
    String getTabTitle();

    @DrawableRes
    int getTabSelectedIcon();

    @DrawableRes
    int getTabUnselectedIcon();

    @DrawableRes
    int getTabCoverIcon();

    boolean getIsPublish();
}