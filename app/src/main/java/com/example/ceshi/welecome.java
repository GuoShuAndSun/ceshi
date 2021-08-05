package com.example.ceshi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class welecome extends AppCompatActivity {

    ImageView weimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_welecome);

        weimage=findViewById(R.id.welecmoe_image);
        String url="http://android10g.com/welecome.png";//从网上找图片的地址，记得是.jpg文件
        Glide.with(this).load(url).into(weimage);


        initWelecome();

    }




    public void initWelecome(){
        new Handler().postDelayed(new Runnable(){

            public void run(){
                //execute the task
                Intent intentWelecome=new Intent(welecome.this,MainActivity.class);
                startActivity(intentWelecome);
            }

        },3500);
    }


}