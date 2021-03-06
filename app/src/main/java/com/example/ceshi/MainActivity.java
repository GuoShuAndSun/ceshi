package com.example.ceshi;
import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.ceshi.banner.adapter.ImageNetAdapter;
import com.example.ceshi.banner.bean.DataBean;
import com.example.ceshi.utils.saveRMB;
import com.google.android.material.snackbar.Snackbar;
//import com.hw.lrcviewlib.ILrcViewSeekListener;
//import com.hw.lrcviewlib.LrcDataBuilder;
//import com.hw.lrcviewlib.LrcRow;
//import com.hw.lrcviewlib.LrcView;
import com.loveplusplus.update.UpdateChecker;
import com.nb.myijklibrary.widget.PlayerView;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.indicator.RoundLinesIndicator;
import com.youth.banner.util.LogUtils;
import com.yy.mobile.rollingtextview.CharOrder;
import com.yy.mobile.rollingtextview.RollingTextView;
import com.yy.mobile.rollingtextview.strategy.Strategy;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import static com.example.ceshi.fragment_lege_activity.rootView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    ViewPager2 viewpager;
    View rootView;
    Button buttonUP;
    private final Handler handler = new Handler();

    MediaPlayer lrcMediaPlayer;

    private LinearLayout home1,music1,study1,book1,my1;
    private ImageView image_home1,image_msic1,image_study1,image_book1,image_my1;
    private ImageView isClickImage;//???????????????????????????
    ArrayList<Fragment> arrayListfragments;

    saveRMB saveRMB;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        //???Toolbar????????????<-??????????????????
        init_my_titlebar();

        //?????????UI
         initTabView();

         //?????????viewPager??????????????????
        init_viewPager(this);


//    this.runOnUiThread(new Runnable() {
//        @Override
//        public void run() {
//
//        }
//    });

        //?????????????????????
        initdata();

        //??????

    }

    public void buttonUP(View view) {

        buttonUP = (Button) findViewById(R.id.buttonUP);

        UpdateChecker.checkForDialog(MainActivity.this);
    }

    private void initdata() {
        final RollingTextView timeView = findViewById(R.id.timeView);
        timeView.setAnimationDuration(300);
        timeView.setLetterSpacingExtra(10);
        @SuppressLint("SimpleDateFormat") final DateFormat format = new SimpleDateFormat("HH:mm:ss");
        handler.post(new Runnable() {
            @Override
            public void run() {
                timeView.setText(format.format(new Date()));
                handler.postDelayed(this, 1000L);
            }
        });
    }


    //????????????



    //????????????
    public void onhelp(View view) {

        Intent intent = new Intent(this,help.class);

        this.startActivity(intent);
    }

    //?????????UI
    private void initTabView() {
        home1=findViewById(R.id.tab_home);
        music1=findViewById(R.id.tab_music);
        study1=findViewById(R.id.tab_study);
        book1=findViewById(R.id.tab_books);
        my1=findViewById(R.id.tab_my);

        image_home1=findViewById(R.id.tab_image_home);
        image_home1.setOnClickListener(this);

        image_msic1=findViewById(R.id.tab_image_music);
        image_msic1.setOnClickListener(this);

        image_study1=findViewById(R.id.tab_image_study);
        image_study1.setOnClickListener(this);

        image_book1=findViewById(R.id.tab_image_books);
        image_book1.setOnClickListener(this);

        image_my1=findViewById(R.id.tab_image_my);
        image_my1.setOnClickListener(this);

        image_home1.setSelected(true);
        isClickImage=image_home1;//????????????????????????


    }


    //???????????????????????????
    public void chongzhi(View view) {
        saveimagebox();

    }


    //?????????????????????
    private void saveimagebox() {
        Bitmap Bitmapbm = BitmapFactory.decodeResource(getResources(),R.drawable.weixin);

        saveRMB=new saveRMB();
        saveRMB.saveBitmapToGallery(this,"weixin.png",Bitmapbm);

        saveRMB.inittost(this);
    }



//    public void Click_up(View view) {
//        AppUpdater.getInstance().getmNetManager().get("http://android10g.com/app_updater_version.json", new INetCallBack() {
//            @Override
//            public void success(String response) {
//                //Log.d("hyman","response="+response);
//                //1.??????json
//                /*
//                *               {
//                "title":"2.0.1????????????",
//                "centent???":"1.????????????????????????2.????????????????????????3??????????????????????????????",
//                "url":"android10g.com/app-release.apk",
//                "md5":"15552fjkslald34",
//                "versionCode":"100"
//                                }
//
//                * */
//                //2.???????????????
//                //??????????????????
//                //3.??????
//                //4.????????????
//                DownloadBean bean = new DownloadBean();
//                bean.parse(response);
//
//                if (bean == null) {
//                    Toast.makeText(MainActivity.this, "????????????????????????????????????", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                //??????:??????????????????
//                try {
//                    long versionCode = Long.parseLong(bean.versionCode);
//                    if (versionCode <= AppUtils.getVersionCode(MainActivity.this)) {
//                        Toast.makeText(MainActivity.this, "?????????????????????,????????????", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//
//                    //??????
//                    UpdateVersionShowDialog.show(MainActivity.this, bean);
//
//                } catch (NumberFormatException e) {
//                    Toast.makeText(MainActivity.this, "???????????????????????????????????????", Toast.LENGTH_SHORT).show();
//                    UpdateVersionShowDialog.show(MainActivity.this, bean);
//                    e.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void failed(Throwable throwable) {
//
//            }
//        });
//    }




    public static class myF extends Fragment{
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.my_gridvieview,container,false);
        }
    }
    //?????????viewPager??????????????????
    public void init_viewPager(Context context) {
         viewpager=findViewById(R.id.viewpager2);

        arrayListfragments=new ArrayList<>();


        arrayListfragments.add(fragment_home_activity.newInstance(context));//"??????"

        arrayListfragments.add(fragment_lege_activity.newInstance(context));//"??????" //??????

        arrayListfragments.add(StudyFragment.newInstance(context));//??????


        arrayListfragments.add(bookFragment.newInstance(context));//??????

        arrayListfragments.add(BlankFragment.newInstance(context));//"??????"

//___________________________________________viewpager.setAdapter???????????????1_____________________________________________

        //ViewPager2?????????????????????????????????
//        ViewPagerAdapter viewpagerAdapter=new ViewPagerAdapter();
//        viewpager.setAdapter(viewpagerAdapter);

//___________________________________________viewpager.setAdapter???????????????2_____________________________________________

//        //????????????fragments?????????viewpager?????????
        MyFragmentPagerAdapter pagerAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),getLifecycle(),arrayListfragments);
        viewpager.setAdapter(pagerAdapter);


        //????????????????????????Tab?????????????????????????????????
        viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            //??????????????????????????????
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                //??????????????????
                changeTab(position);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    //implements View.OnClickListener??????????????? ????????????????????????????????????
    @Override
    public void onClick(View view) {
        changeTab(view.getId());

    }

    //?????????????????????
    private void changeTab(int position) {
        isClickImage.setSelected(false);
        switch (position){

            case R.id.tab_image_home:viewpager.setCurrentItem(0);
            case 0:
                image_home1.setSelected(true);
                isClickImage=image_home1;
                break;

            case R.id.tab_image_music:viewpager.setCurrentItem(1);
            case 1:
                image_msic1.setSelected(true);
                isClickImage=image_msic1;
                break;

            case R.id.tab_image_study:viewpager.setCurrentItem(2);
            case 2:
                image_study1.setSelected(true);
                isClickImage=image_study1;
                break;

            case R.id.tab_image_books:viewpager.setCurrentItem(3);
            case 3:
                image_book1.setSelected(true);
                isClickImage=image_book1;
                break;

            case R.id.tab_image_my:viewpager.setCurrentItem(4);
            case 4:
                image_my1.setSelected(true);
                isClickImage=image_my1;
                break;
        }
    }



    ////???Toolbar????????????<-??????????????????
    public void init_my_titlebar(){

        //??????!!!!!!  ???????????????import android.widget.Toolbar;????????????dandroidx?????????Toolbar
        Toolbar my_Toolbar=findViewById(R.id.my_Toolbar);
        //my_Toolbar.setNavigationIcon(R.drawable.title_bar_back);
        my_Toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"???????????????" , Toast.LENGTH_LONG).show();

            }
        });
    }




}
    //______________________________________________________________________________________________
//??????????????? ?????????????????????
class MyAdapter extends BaseAdapter{
    Context context;
    List<Test> urls;
    MainActivity mainActivity;
    private GridView gridview2;

    //??????????????????
        public void sousuo(View view) {

            LayoutInflater inflater=LayoutInflater.from(context);
            View view2 = inflater.inflate(R.layout.fragment_study, null);
            gridview2=view2.findViewById(R.id.gridview);
            EditText edSearch=view2.findViewById(R.id.ed_search);


            ////////////
            edSearch.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    ArrayList urls2=new ArrayList<>();
                    urls.clear();

                    String content = edSearch.getText().toString();

                    for (int i = 0; i < urls.size(); i++) {
                        Test test = urls.get(i);

                        if (test.get??????().contains(content)) {
                            urls2.add(test);
                            gridview2.setAdapter(new MyAdapter(context, urls2));
                        }
                    }
                }
            });
            ///////////
        }

    //MyAdapter???????????????
    public MyAdapter(Context context,List<Test> urls ){
        this.context=context;
        this.urls=urls;
    }
    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public Object getItem(int i) {
        return urls.get(i);//?????????????????????????????????
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    //????????????
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder vh;
        //???view?????????????????????
        if(view==null){
            //??????????????????
            LayoutInflater inflater=LayoutInflater.from(context);
             view=inflater.inflate(R.layout.item_grid_icon,null);




            //??????????????????????????????
             vh=new ViewHolder();
             vh.iv_icom=view.findViewById(R.id.icon_img);
            vh.tv_title=view.findViewById(R.id.icon_txt);
            //???vh?????????????????????view
            view.setTag(vh);
        }else {
            //????????????????????????????????????,????????????????????????
            vh= (ViewHolder) view.getTag();
        }
        Glide.with(context).load(urls.get(i).get??????())
                .override(600,600)
                .fitCenter()
                .centerCrop()
                .into(vh.iv_icom);//????????????;
        //???tv?????????????????????????????????????????????
        vh.tv_title.setText(urls.get(i).get??????());

        //????????????
        //options = new RequestOptions().placeholder(R.mipmap.img1).error(R.mipmap.img_error).circleCrop();
        //Glide.with(context).load(imageUrl).apply(options).into(imageView);

//        centerCrop()?????????????????????????????????imageview?????????;
//        fitCenter()?????????????????????????????????imageview?????????;
//        options = new RequestOptions().override(100, 100).centerCrop();
//        Glide.with(context).load(imageUrl).apply(options).into(imageView);


        //???iv??????????????????????????????
        //RequestOptions options = new RequestOptions().bitmapTransform(new RoundedCorners(30));//???????????????30
        //apply(options)

//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context.getApplicationContext(),view., Toast.LENGTH_LONG).show();
//            }
//        });
        return view;
    }
            //????????????????????????????????????,????????????????????????
            static class ViewHolder{
                ImageView iv_icom;
                TextView  tv_title;
            }

}//MyAdapter
//retrofit?????????????????????????????????








