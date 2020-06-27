package com.zszdevelop.planman.view_holder;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.zszdevelop.planman.R;


public class GoalViewHolder extends RecyclerView.ViewHolder {

    public ViewPager vp_home_plan;
    public TabLayout tabs_plan;

    public GoalViewHolder(View itemView) {
        super(itemView);
        vp_home_plan = (ViewPager) itemView.findViewById(R.id.vp_home_plan);
        tabs_plan = (TabLayout) itemView.findViewById(R.id.tabs_plan);
    }
}
