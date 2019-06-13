package com.samluys.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.samluys.tab.frgment.FiveFragment;
import com.samluys.tab.frgment.FourFragment;
import com.samluys.tab.frgment.OneFragment;
import com.samluys.tab.frgment.ThreeFragment;
import com.samluys.tab.frgment.TwoFragment;
import com.samluys.tablib.OnTabSelectListener;
import com.samluys.tablib.QFBottomTabLayout;
import com.samluys.tablib.QFTabEntity;

import java.util.ArrayList;

public class TestFragmentActivity extends AppCompatActivity {

    private String[] mTitles = {"首页", "社区", "", "消息", "发现"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab1, R.mipmap.tab2,
            R.mipmap.icon_center_publish, R.mipmap.tab4, R.mipmap.tab5};
    private int[] mIconSelectIds = {
            R.mipmap.tab1_selected, R.mipmap.tab2_selected,
            R.mipmap.icon_center_publish, R.mipmap.tab4_selected, R.mipmap.tab5_selected};

    private ArrayList<Fragment> fragments;

    private int[] mCoverImageIds = {
            0, R.mipmap.icon_cover,
            0, R.mipmap.icon_cover1, 0};

    private ArrayList<QFTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);

        fragments = new ArrayList<>();
        fragments.add(OneFragment.newInstance());
        fragments.add(TwoFragment.newInstance());
        fragments.add(ThreeFragment.newInstance());
        fragments.add(FourFragment.newInstance());

        QFBottomTabLayout mTabLayout_1 = findViewById(R.id.tl_1);

        for (int i = 0; i < mTitles.length; i++) {
            if (i == 1) {
                mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i], R.mipmap.icon_cover));
            } else if (i == 2) {
                mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i], 0, true));
            } else {
                mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
            }
        }

        // 默认5栏
        mTabLayout_1.setTabData(mTabEntities, this, R.id.fl_content, fragments);
        mTabLayout_1.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }

            @Override
            public void onTabPublish(int position) {
                Toast.makeText(TestFragmentActivity.this, "publish-->"+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDoubleClick(int position) {

            }

            @Override
            public boolean shouldInterceptJumpFragment(int position) {
                return false;
            }
        });
    }
}
