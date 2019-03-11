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

	ImageView img;	//��Ӧ�ؼ�
	boolean flag;
	
	public static int width;
	public static int height;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //ȥ������
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        			WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //ȥ״̬��
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);	//��ǰ�ֻ���Ļ�������õ�dm��
        width = dm.widthPixels;		//��ǰ�ֻ���Ļ�Ŀ�͸�
        height = dm.heightPixels;
        
        
        setContentView(new PlaneView(this));	//���ز���

        
        
//        img = (ImageView)this.findViewById(R.id.img);
//        img.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		flag = !flag;
		v.setBackgroundResource(flag ? R.drawable.iiii : R.drawable.ic_launcher);
	}


    
}
