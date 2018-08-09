package cn.white.ymc.wanandroidmaster.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * 主要用于 结合 banner 加载图片使用
 *
 * @packageName: cn.white.ymc.wanandroidmaster.util
 * @fileName: GlideImageLoader
 * @date: 2018/8/9  10:15
 * @author: ymc
 * @QQ:745612618
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context.getApplicationContext()).load(path).into(imageView);
    }
}
