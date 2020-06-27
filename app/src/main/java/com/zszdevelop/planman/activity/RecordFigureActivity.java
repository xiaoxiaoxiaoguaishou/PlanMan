package com.zszdevelop.planman.activity;

import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.zszdevelop.planman.R;
import com.zszdevelop.planman.adapter.FigureAdapter;
import com.zszdevelop.planman.config.ResultCode;
import com.zszdevelop.planman.fragment.FigureFragment;
import com.zszdevelop.planman.utils.DrawerToolUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecordFigureActivity extends AppCompatActivity {


    List<Fragment> fragmentList = new ArrayList<>();
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs_figure)
    TabLayout tabsFigure;
    @Bind(R.id.vp_record_figure)
    ViewPager vpRecordFigure;
    @Bind(R.id.navigation)
    NavigationView navigation;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_figure);
        ButterKnife.bind(this);

        initView();
        initListener();
        fillData();
    }


    private void initView() {

        DrawerToolUtils.initToolbar(this, toolbar, "记录身材");

        DrawerToolUtils.interactorNavigation(this,toolbar,navigation,drawerLayout);

        fragmentList.add(FigureFragment.newInstanceFragment(ResultCode.WEIGHT_CODE));
        fragmentList.add(FigureFragment.newInstanceFragment(ResultCode.CHEST_CODE));
        fragmentList.add(FigureFragment.newInstanceFragment(ResultCode.LOIN_CODE));
        fragmentList.add(FigureFragment.newInstanceFragment(ResultCode.LEFT_ARM_CODE));
        fragmentList.add(FigureFragment.newInstanceFragment(ResultCode.RIGHT_ARM_CODE));
        fragmentList.add(FigureFragment.newInstanceFragment(ResultCode.SHOULDER_CODE));

        FigureAdapter figureAdapter = new FigureAdapter(getSupportFragmentManager(), this, fragmentList);
        vpRecordFigure.setAdapter(figureAdapter);
        tabsFigure.setTabMode(TabLayout.MODE_FIXED);
        tabsFigure.setupWithViewPager(vpRecordFigure);

    }

    @Override
    protected void onStart() {
        super.onStart();
        navigation.setCheckedItem(R.id.navigation_record_figure);
    }

    private void initListener() {

    }

    private void fillData() {
    }


}
