package com.example.ceshi;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ceshi.banner.adapter.ImageNetAdapter;
import com.example.ceshi.banner.bean.DataBean;
import com.google.android.material.snackbar.Snackbar;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.indicator.RoundLinesIndicator;
import com.youth.banner.util.LogUtils;


public class fragment_home_activity extends Fragment {

    Context context;
    View rootView;
    Banner banner;
    SwipeRefreshLayout refresh;
    private String mParam1;
    private String mParam2;

    public fragment_home_activity(Context context) {
        this.context=context;
        // Required empty public constructor
    }


    public static fragment_home_activity newInstance(Context context) {
        fragment_home_activity fragment = new fragment_home_activity(context);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
///////////////
//为了避免每次都创建view 要提前做一下判断做一下优化
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.banner_activity, container, false);
        }
        initView1();
        //初始化retrofit请求网络的数据
        post();
        return rootView;




///////////////

    }
    private void initView1() {
        banner= rootView.findViewById(R.id.banner);
    }
    private void post() {

        //    @BindView(R.id.indicator)
        RoundLinesIndicator indicator;

        //加载网络的图片 一定要添加一个网络适配器
        ImageNetAdapter adapter=new ImageNetAdapter(DataBean.getTestData3());

        banner.setAdapter(adapter)
                .addBannerLifecycleObserver(getActivity())//添加生命周期观察者
                .setIndicator(new CircleIndicator(context))//设置指示器
                .setOnBannerListener((data, position) -> {
                    Snackbar.make(banner, ((DataBean) data).title, Snackbar.LENGTH_SHORT).show();
                    LogUtils.d("position：" + position);
                });


        //添加item之间切换时的间距(如果使用了画廊效果就不要添加间距了，因为内部已经添加过了)
//        banner.addPageTransformer(new MarginPageTransformer((int) BannerUtils.dp2px(10)));

        refresh=new SwipeRefreshLayout(context);
        //和下拉刷新配套使用
        refresh.setOnRefreshListener(() -> {
            //模拟网络请求需要3秒，请求完成，设置setRefreshing 为false
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    refresh.setRefreshing(false);
                    //给banner重新设置数据
                    banner.setDatas(DataBean.getTestData3());
                    //对setdatas不满意？你可以自己控制数据，可以参考setDatas()的实现修改
                    //adapter.updateData(DataBean.getTestData2());
                }
            }, 3000);
        });

    }




}