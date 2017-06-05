package cn.smlcx.template.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

public class ImageLoader {

	public static Bitmap load(Context context, int resId) {
	
		BitmapFactory.Options opt = new BitmapFactory.Options();
	
		opt.inPreferredConfig = Bitmap.Config.RGB_565;
	
		opt.inPurgeable = true;
	
		opt.inInputShareable = true;
	
		//获取资源图片
	
		InputStream is = context.getResources().openRawResource(resId);
	
		Bitmap bitmap = BitmapFactory.decodeStream(is,null, opt);
	
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		//return new BitmapDrawable(context.getResources(),bitmap);
		
		return bitmap;
	}
}
