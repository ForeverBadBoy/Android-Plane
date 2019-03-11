package com.dzzw.plane;

import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener{

	ImageView img;	//对应控件
	boolean flag;
	
	public static int width;
	public static int height;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //去标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        			WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //去状态栏
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);	//当前手机屏幕参数设置到dm中
        width = dm.widthPixels;		//当前手机屏幕的宽和高
        height = dm.heightPixels;
        
        
        setContentView(new PlaneView(this));	//加载布局

        
        
//        img = (ImageView)this.findViewById(R.id.img);
//        img.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		flag = !flag;
		v.setBackgroundResource(flag ? R.drawable.iiii : R.drawable.ic_launcher);
	}


    
}
