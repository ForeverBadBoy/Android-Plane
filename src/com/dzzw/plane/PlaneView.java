package com.dzzw.plane;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class PlaneView extends View implements Runnable{

	Bitmap[] bg = new Bitmap[2];	//背景图片
	int index;
	
	public PlaneView(Context context) {
		super(context);
		
		bg[0] = this.changeBitmap(R.drawable.ic_launcher);
		bg[1] = this.changeBitmap(R.drawable.iiii);
		new Thread(this).start();
	}
	
	private Bitmap changeBitmap (int id) {
		Bitmap bg = BitmapFactory.decodeResource(getResources(), id);	//实例化图片
		
		bg = Bitmap.createScaledBitmap(bg, MainActivity.width, MainActivity.height, true);  //拉伸/缩放图片
		return bg;
	}
	
	//onDraw在view对象实例化后自动调用
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(bg[index], 0, 0, null);	//绘制图片
		
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			index = index == 1 ? 0 : 1;
			
			//刷新画布，重新调用onDraw方法
			postInvalidate();
		}
	}

}
