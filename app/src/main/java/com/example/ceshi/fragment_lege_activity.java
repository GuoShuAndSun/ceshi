package com.example.ceshi;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nb.myijklibrary.widget.PlayerView;


public class fragment_lege_activity extends Fragment    {


    static View rootView;
    ListView lege_listview1;
    Context context;


    public fragment_lege_activity(Context context) {
        this.context = context;
    }

//    public fragment_lege_activity() {
//        // Required empty public constructor
//    }


    public static Fragment newInstance(Context context) {

       fragment_lege_activity fragment = new fragment_lege_activity(context);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //为了避免每次都创建view 要提前做一下判断做一下优化
        if (rootView == null) {



            rootView = inflater.inflate(R.layout.fragment_lege, container, false);
            ListView lege_listview1 = rootView.findViewById(R.id.lege_listview1);
            lege_listview1.setAdapter(new lege_listview1_dapter(context));

            lege_listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                    switch(i){
                        case 0 :
                            getActivity().getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.f__lege, new StudyFragment(), null)
                                    .addToBackStack(null)
                                    .commit();
                            //语句
                            break; //可选
                        case 1 :
                            toastUtls();
                            //语句
                            break; //可选
                        case 2 :
                            toastUtls();
                            //语句
                            break; //可选
                        case 3 :
                            toastUtls();
                            //语句
                            break; //可选
                        case 4 :
                            toastUtls();
                            //语句
                            break; //可选
                        case 5 :
                            toastUtls();
                            //语句
                            break; //可选
                        case 6 :
                            toastUtls();
                            //语句
                            break; //可选
                        case 7 :
                            toastUtls();
                            //语句
                            break; //可选
                        case 8 :
                            toastUtls();
                            //语句
                            break; //可选
                        case 9 :
                            toastUtls();
                            //语句
                            break; //可选
                        case 10 :
                            toastUtls();
                            //语句
                            break; //可选
                        case 11 :
                            toastUtls();
                            //语句
                            break; //可选
                        //你可以有任意数量的case语句
                        default : //可选
                            //语句跳转到播放的Activity
//                          Intent play=new Intent();
//                          play.setClass(context,include_player_actiivty.class);
//                          context.startActivity(play);
                    }



                    //Toast.makeText(context,"开始播放视频"+i , Toast.LENGTH_LONG).show();

                }

                private void toastUtls() {
                    Toast.makeText(context.getApplicationContext(),"课程暂未开放,敬请期待!", Toast.LENGTH_LONG).show();
                }
            });

        }


        return rootView;
    }
    //lege_listview1定义适配器
    class lege_listview1_dapter extends BaseAdapter {

        TextView   lege_tv1;
        ImageView  lege_iv1;
        Context context;
        View view1;

        public lege_listview1_dapter(Context context) {
            this.context = context;
        }


        String[] title={
                "网页前端*合集",
                "Java*合集",
                "PHP*合集",
                "Python*合集",
                "C/C++*合集",
                "区块链*合集",
                "人工智能*合集",
                "大数据/云计算*合集",
                " 数据结构/算法*合集",
                "运维*合集",
                "数据库*合集",
                "其他语言*合集",
        };
        int icon[]={
                R.drawable.yholhk8h,
                R.drawable.yholhk8h,
                R.drawable.yholhk8h,
                R.drawable.yholhk8h,
                R.drawable.yholhk8h,
                R.drawable.yholhk8h
        };

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public Object getItem(int i) {
            return title[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            //rootView = getLayoutInflater().from(context).inflate(R.layout.fragment_lege_baseadapter, null);

            //为了避免每次都创建view 要提前做一下判断做一下优化
            ViewHolder2 vh;
            if (view == null) {

                //通过布局找到我们的控件
                LayoutInflater inflater = LayoutInflater.from(context);
                view = inflater.inflate(R.layout.fragment_lege_baseadapter, null);

                vh=new ViewHolder2();
                vh.tv_title=view.findViewById(R.id.lege_tv1);
                vh.include_playlayout=view.findViewById(R.id.include_playlayout);

                view.setTag(vh);
            }else {
                //用于保存第一次查找的组件,避免下此重复查找
                vh= (ViewHolder2) view.getTag();
            }


            vh.include_playlayout.setImageResource(icon[i]);//设置图片
            vh.tv_title.setText(title[i]);


            return view;

        }
        //用于保存第一次查找的组件,避免下此重复查找
        class ViewHolder2{
            ImageView include_playlayout;
            TextView  tv_title;
        }
    }

}
