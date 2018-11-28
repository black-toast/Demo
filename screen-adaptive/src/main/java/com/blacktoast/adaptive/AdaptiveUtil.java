package com.blacktoast.adaptive;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.DisplayMetrics;

/**
 * 适配工具
 * Created by cyh on 2018/4/18.
 */

public final class AdaptiveUtil {

    private AdaptiveUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 屏幕密度相关
     */
    enum Density {
        LDPI(120, 0.75f, 0.75f, "ldpi"),
        MDPI(160, 1.0f, 1.0f, "mdpi"),
        HDPI(240, 1.5f, 1.5f, "hdpi"),
        XDPI(320, 2.0f, 2.0f, "xhdpi"),
        XXDPI(480, 3.0f, 3.0f, "xxhdpi"),
        XXXHDPI(640, 4.0f, 4.0f, "xxxhdpi"),
        WHATHDPI(640, 4.0f, 4.0f, "whathdpi");

        private int densityDpi; // 像素密度
        private float density;  // density （dp-px的换算值）
        private float scaledDensity;  // scaledDensity  （sp-px的换算值）
        private String densityString;   // density string
        Density(int densityDpi, float density, float scaledDensity, String densityString) {
            this.densityDpi = densityDpi;
            this.density = density;
            this.scaledDensity = scaledDensity;
            this.densityString = densityString;
        }

        public void setDensityDpi(int densityDpi) {
            this.densityDpi = densityDpi;
        }

        public void setDensity(float density) {
            this.density = density;
        }

        public void setScaledDensity(float scaledDensity) {
            this.scaledDensity = scaledDensity;
        }

        public void setDensityString(String densityString) {
            this.densityString = densityString;
        }
    }

    /**
     * 重置密度
     */
    public static void resetDensity(ContextWrapper app) {
        DisplayMetrics displayMetrics = app.getResources().getDisplayMetrics();
        Density density = getDensity(displayMetrics.densityDpi);

        if (density == null) {
            return;
        }

        displayMetrics.densityDpi = density.densityDpi;
        displayMetrics.density = density.density;
        displayMetrics.scaledDensity = density.scaledDensity;
    }

    /**
     * 验证头条适配方案
     */
    @Deprecated
    public static void resetDensityOnToutiao(ContextWrapper app) {
        DisplayMetrics displayMetrics = app.getResources().getDisplayMetrics();

        // 头条适配方案
        float targetDensity = displayMetrics.widthPixels / 360;
        displayMetrics.densityDpi = (int) (160 * targetDensity);
        displayMetrics.density = targetDensity;
        displayMetrics.scaledDensity = displayMetrics.density;
    }

    /**
     * 获取像素密度
     * @param context    上下文
     */
    public static Density getDensity(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return getDensity(displayMetrics.densityDpi);
    }

    /**
     * 获取像素密度
     * @param densityDpi    像素密度
     */
    private static Density getDensity(int densityDpi) {
        if (densityDpi <= Density.LDPI.densityDpi) {
            return Density.LDPI;
        } else if (densityDpi <= Density.MDPI.densityDpi) {
            return Density.MDPI;
        } else if (densityDpi <= Density.HDPI.densityDpi) {
            return Density.HDPI;
        } else if (densityDpi <= Density.XDPI.densityDpi) {
            return Density.XDPI;
        } else if (densityDpi <= Density.XXDPI.densityDpi) {
            return Density.XXDPI;
        } else if (densityDpi <= Density.XXXHDPI.densityDpi) {
            return Density.XXXHDPI;
        } else {    // 其他情况使用默认屏幕信息
            int density = (int) (1.0 * densityDpi / 160);
            if (density * 160 < densityDpi) {
                density += 1;
            }

            Density.WHATHDPI.setDensityDpi(density * 160);
            Density.WHATHDPI.setDensity(density);
            Density.WHATHDPI.setScaledDensity(density);
            Density.WHATHDPI.setScaledDensity(density);
            return Density.WHATHDPI;
        }
    }

}
