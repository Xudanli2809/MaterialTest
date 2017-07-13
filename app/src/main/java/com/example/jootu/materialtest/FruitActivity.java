package com.example.jootu.materialtest;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/*水果详情展示界面*/
public class FruitActivity extends AppCompatActivity {

    public static final String FRUIT_NAME="fruit_name";
    public static final String FRUIT_IMAGE_ID="fruit_image_id";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        Intent intent=getIntent();
        String fruitName=intent.getStringExtra(FRUIT_NAME);
        int fruitImageId=intent.getIntExtra(FRUIT_IMAGE_ID,0);
        //得到对应控件的实例
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar=(CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);

        ImageView fruitImageView=(ImageView)findViewById(R.id.fruit_image_view);
        TextView fruitContentText=(TextView)findViewById(R.id.fruit_content_text);
        //用ToolBar的标准用法，将它作为actionbar显示
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        //启用HomeAsUp按钮
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(fruitName);//将水果名设置成当前标题页
        Glide.with(this).load(fruitImageId).into(fruitImageView);//使用glide加载传入的水果图片，并设置到标题栏的ImageView上
        String fruitContent=generateFruitContent(fruitName);//填充水果的内容详情，这里只是一个事例
        fruitContentText.setText(fruitContent);//将结果填充到fruitContentText中
    }
    //定义generateFruitContent（String fruitName）方法，只是一个事例，所以为了展示，只是将水果名展示500遍
    private String generateFruitContent(String fruitName){
        StringBuilder fruitContent=new StringBuilder();
        for(int i=0;i<500;i++){
            fruitContent.append(fruitName);
        }
        return fruitContent.toString();
    }

    //重写这个方法，处理HomeAsUp按钮的点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
