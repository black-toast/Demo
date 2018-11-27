package com.blacktoast.demo.statusbar;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

import java.lang.reflect.Field;

/**
 * Common Utils
 * Created by blacktoast on 2018/2/23.
 */

public class Utils {
    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /*-------------------------------------resource---------------------------------------------*/

    /**
     * 获取配置的string
     * @param context   上下文
     * @param id        资源id
     */
    public static String getString(Context context, @StringRes int id) {
        return context.getResources().getString(id);
    }

    /**
     * 获取配置的color
     * @param context   上下文
     * @param id        资源id
     */
    public static int getColor(Context context, @ColorRes int id) {
        return ContextCompat.getColor(context, id);
    }

    /**
     * 将资源图片转化为Bitmap
     * @param context   上下文
     * @param id        资源id
     */
    public static Bitmap getBitmap(Context context, @DrawableRes int id) {
        return ((BitmapDrawable) ContextCompat.getDrawable(context, id)).getBitmap();
    }

    /**
     * 获取app meta data
     * @param ctx   上下文
     * @param key   key
     * @return      meta data
     */
    public static String getAppMetaData(Context ctx, final String key) {
        try {
            ApplicationInfo info = ctx.getPackageManager().getApplicationInfo(ctx.getPackageName(),
                    PackageManager.GET_META_DATA);
            return info.metaData.getString(key);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /*--------------------------------------reflect---------------------------------------------*/

    /**
     * 获取反射字段
     * @param className 反射类
     * @param fieldName 字段名
     * @param obj       反射对象
     * @return          反射字段
     */
    public static Object getReflectField(String className, String fieldName, Object obj) {
        try {
            Class<?> clazz = Class.forName(className);
            Field field = clazz.getDeclaredField(fieldName);
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
