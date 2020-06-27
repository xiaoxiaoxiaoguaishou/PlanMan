package com.zszdevelop.planman.fragment;

import android.app.Activity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;
import com.zszdevelop.planman.R;
import com.zszdevelop.planman.adapter.TestMaterialRVAdapter;
import com.zszdevelop.planman.base.BaseFragment;
import com.zszdevelop.planman.bean.ConsumeRecordInfo;
import com.zszdevelop.planman.bean.GoalInfo;
import com.zszdevelop.planman.view.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MaterialRecycleViewFragment extends BaseFragment {



    @Bind(R.id.plmrv_material)
  public   PullLoadMoreRecyclerView plmrvMaterial;
    boolean isPrepared;

    private int mScrollOffset = 4;
    private int currentPage;
    private int actionType;
    List<ConsumeRecordInfo> lists = new ArrayList<>();
    private RefreshCallBack refreshCallBack;
    private RecyclerViewMaterialAdapter adapter;
    private GoalInfo goalInfo;
    private TestMaterialRVAdapter rvAdapter;
    private MaterialRecycleViewFragment fragment;

    public static MaterialRecycleViewFragment newInstanceFragment(int type, GoalInfo goalInfo) {

        MaterialRecycleViewFragment fragment = new MaterialRecycleViewFragment();
        fragment.actionType = type;
        fragment.goalInfo = goalInfo;
        fragment.fragment = fragment;
        return fragment;
    }

    //当该Fragment被添加,显示到Activity时调用该方法
    //在此判断显示到的Activity是否已经实现了接口
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof RefreshCallBack)) {
            throw new IllegalStateException("Fragment所在的Activity必须实现RefreshCallBack接口");
        }
        refreshCallBack = (RefreshCallBack) activity;
    }


    //当该Fragment从它所属的Activity中被删除时调用该方法
    @Override
    public void onDetach() {
        super.onDetach();
        refreshCallBack = null;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_material_recycleview;
    }

    @Override
    protected void onBindFragment(View view) {

        initView();
        initListener();
          isPrepared  = true;
        lazyLoad();



    }

    private void initListener() {

    }

    @Override
    protected void lazyLoad() {


        if (!isPrepared ||!isVisible){
            return;
        }

        fillData();
    }


    private void initView() {
        initRecycleView();

    }



    private void fillData() {

        // 设置头部文件\
        rvAdapter.clear();
        rvAdapter.setHeaderData(goalInfo);
        adapter.notifyDataSetChanged();

        currentPage = 1;
        refreshCallBack.fillDataListener(currentPage,  fragment);
    }


    private void initRecycleView() {


        plmrvMaterial.setLinearLayout();
        plmrvMaterial.getRecyclerView().setHasFixedSize(true);
        // 应用adapter
        rvAdapter = new TestMaterialRVAdapter(getActivity(), R.layout.item_plan, R.layout.item_consume_record, lists);
        // 并将应用的adapter 设置给 RecyclerViewMaterialAdapter
        this.adapter = new RecyclerViewMaterialAdapter(rvAdapter);
        plmrvMaterial.setAdapter(this.adapter);
        plmrvMaterial.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                currentPage = 1;
                lists.clear();
                adapter.notifyDataSetChanged();

                refreshCallBack.fillDataListener(currentPage, fragment);
            }

            @Override
            public void onLoadMore() {
                refreshCallBack.fillDataListener(++currentPage,  fragment);
            }
        });

        MaterialViewPagerHelper.registerRecyclerView(getActivity(), plmrvMaterial.getRecyclerView(), null);

        plmrvMaterial.getRecyclerView().addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (Math.abs(dy) > mScrollOffset) {
                    if (dy > 0) {
                        refreshCallBack.setHideMenu();
//                        fabMainMenu.hideMenu(true);
                    } else {
                        refreshCallBack.setShowMenu();
//                        fabMainMenu.showMenu(true);
                    }
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    public void setViewPagerData(List<ConsumeRecordInfo> data) {
        plmrvMaterial.setPullLoadMoreCompleted();
        if (data == null) {
            return;
        }
        lists.addAll(data);
        adapter.notifyDataSetChanged();

    }


    public interface RefreshCallBack {
        void fillDataListener(int currentPage, MaterialRecycleViewFragment fragment);
        void setHideMenu();
        void setShowMenu();
    }

}
