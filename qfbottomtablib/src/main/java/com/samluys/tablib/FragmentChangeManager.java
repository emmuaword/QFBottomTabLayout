package com.samluys.tablib;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;


public class FragmentChangeManager {
    private FragmentManager mFragmentManager;
    private int mContainerViewId;
    /**
     * Fragment切换数组
     */
    private ArrayList<? extends Fragment> mFragments;
    /**
     * 当前选中的Tab
     */
    private int mCurrentTab;

    public FragmentChangeManager(FragmentManager fm, int containerViewId, ArrayList<? extends Fragment> fragments) {
        this.mFragmentManager = fm;
        this.mContainerViewId = containerViewId;
        this.mFragments = fragments;
        initFragments();
    }

    /**
     * 初始化fragments
     */
    private void initFragments() {

        if (mCurrentTab != 0) {
            mFragmentManager.beginTransaction()
                    .add(mContainerViewId, mFragments.get(mCurrentTab)).commitAllowingStateLoss();
        } else {
            setFragments(0);
        }
    }

    /**
     * 界面切换控制
     */
    public void setFragments(int index) {

        mFragmentManager.beginTransaction()
                .add(mContainerViewId, mFragments.get(index)).commitAllowingStateLoss();
        showCurrentFragment(index);
    }

    public void showCurrentFragment(int index) {
        for (int i = 0; i < mFragments.size(); i++) {
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            Fragment fragment = mFragments.get(i);
            if (i == index) {
                ft.show(fragment);
            } else {
                ft.hide(fragment);
            }
            ft.commitAllowingStateLoss();
        }
        mCurrentTab = index;
    }

    public int getCurrentTab() {
        return mCurrentTab;
    }

    public Fragment getCurrentFragment(int index) {
        return mFragments.get(index);
    }
}