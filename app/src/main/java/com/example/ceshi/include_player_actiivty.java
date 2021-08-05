package com.example.ceshi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.nb.myijklibrary.widget.PlayerView;

public class include_player_actiivty extends AppCompatActivity {
    View mRootView;
    PlayerView playerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         mRootView = getLayoutInflater().from(this).inflate(R.layout.activity_include_player_actiivty, null);

        setContentView(mRootView);
         playerView = new PlayerView(this, mRootView);
        playerView.setPlaySource("http://android10g.com/music.mp4");
        playerView.startPlay();

    }

    //当返回键盘的时候 调用playerView的销毁暂停方法
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        playerView.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        playerView.pausePlay();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        playerView.onDestroy();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        playerView.onResume();
    }



    //    public void onClick_player(View view) {
//
//        PlayerView playerView = new PlayerView(this, mRootView);
//        playerView.setPlaySource("http://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4");
//        playerView.startPlay();
//    }
}