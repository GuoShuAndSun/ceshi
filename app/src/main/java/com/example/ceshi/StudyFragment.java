package com.example.ceshi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;

import com.example.ceshi.utils.saveRMB;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class StudyFragment extends Fragment {

    private saveRMB saveRMB;

    //自己定义一个标记
    private static final String TITLE1 = "param1";
    private String mParam1;

    View rootView;
    private ArrayList<Test> list;
    private GridView gridview;

    public static StudyFragment newInstance(Context context) {
        StudyFragment fragment = new StudyFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //使用Budnle 对Activity和Fragment之间通信
        if (getArguments() != null) {
            mParam1 = getArguments().getString(TITLE1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //为了避免每次都创建view 要提前做一下判断做一下优化
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_study, container, false);
        }
        initView1();
        //初始化retrofit请求网络的数据
        start();
        return rootView;
    }

    private void initView1() {
        gridview = rootView.findViewById(R.id.gridview);
    }

    //初始化retrofit请求网络的数据
    private void start() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://android10g.com")
                .addConverterFactory(GsonConverterFactory.create())//添加转换器Gson
                .build();
        HttpService httpService = retrofit.create(HttpService.class);//这是post请求的接口
        Call<Test[]> call = httpService.post("S");

        call.enqueue(new Callback<Test[]>() {


            @Override
            public void onResponse(Call<Test[]> call, Response<Test[]> response) {
//                Toast.makeText(getContext(), "请求成功", Toast.LENGTH_LONG).show();

                list = new ArrayList<>();

                for (Test test : response.body()) {

                    list.add(test);//将获取到的java实体类对象添加到数组集合对象中
                }
                // gridview=(GridView) findViewById(R.id.gridview);
                gridview.setAdapter(new MyAdapter(getContext(), list));
                //给gridview的每一个商品设置点击事件
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        TextView t = view.findViewById(R.id.icon_txt);

                        Toast.makeText(getContext(), t.getText(), Toast.LENGTH_LONG).show();
                        //跳转到微信扫码界面
                        saveimagebox();

                    }
                });

            }

            //保存图片到图库
            private void saveimagebox() {
                Bitmap Bitmapbm = BitmapFactory.decodeResource(getResources(),R.drawable.weixin);

                saveRMB=new saveRMB();
                saveRMB.saveBitmapToGallery(getActivity(),"weixin.png",Bitmapbm);

                saveRMB.inittost(getActivity());
            }

            @Override
            public void onFailure(Call<Test[]> call, Throwable t) {
                Toast.makeText(getContext(), "请求失败", Toast.LENGTH_LONG).show();
            }
        });
    }

}