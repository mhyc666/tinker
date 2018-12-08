package com.wdh.mytinkerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tinkerpatch.sdk.TinkerPatch;

public class MainActivity extends AppCompatActivity {
    private TextView mTv;
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTv = findViewById(R.id.tv);
        mIv = findViewById(R.id.iv);
        mIv.setVisibility(View.GONE);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv:
               //原来没有点击事件，补丁之后才有
                Toast.makeText(this,"热更新之后",Toast.LENGTH_LONG).show();
                break;
            case R.id.bt:
                TinkerPatch.with().fetchPatchUpdate(true);
                //原来没有点击事件补丁之后才有
                mTv.setText("文字改变了");
                mIv.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }
}



//如何使用Tinker进行热修复
//
//        https://www.jianshu.com/p/32cc3408918b