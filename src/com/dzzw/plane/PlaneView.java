package com.dzzw.plane;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class PlaneView extends View implements Runnable{

	Bitmap[] bg = new Bitmap[2];	//����ͼƬ
	int index;
	
	public PlaneView(Context context) {
		super(context);
		
		bg[0] = this.changeBitmap(R.drawable.ic_launcher);
		bg[1] = this.changeBitmap(R.drawable.iiii);
		new Thread(this).start();
	}
	
	private Bitmap changeBitmap (int id) {
		Bitmap bg = BitmapFactory.decodeResource(getResources(), id);	//ʵ����ͼƬ
		
		bg = Bitmap.createScaledBitmap(bg, MainActivity.width, MainActivity.height, true);  //����/����ͼƬ
		return bg;
	}
	
	//onDraw��view����ʵ�������Զ�����
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(bg[index], 0, 0, null);	//����ͼƬ
		
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
			
			//ˢ�»��������µ���onDraw����
			postInvalidate();
		}
	}

}
