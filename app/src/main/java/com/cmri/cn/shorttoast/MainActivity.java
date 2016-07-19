package com.cmri.cn.shorttoast;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toast mToast;
    private Context mContext;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            dismissToast();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=MainActivity.this;

    }

    public void show(View view){
        showToast("I am Toast",3000);
    }

    public void dismissToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    public void showToast(String text,long time) {
        if(mToast == null) {
            mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
        handler.sendEmptyMessageDelayed(223, time);
    }
}
