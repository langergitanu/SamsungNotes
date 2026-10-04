package com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.common;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BackgroundUtils {
    private static final float DIM_AMOUNT_CLEAR = 0.0f;
    private static final float DIM_AMOUNT_DEFAULT = 0.6f;
    private static boolean mDimmed;

    public static void applyBackground(Context context, Window window) {
        mDimmed = true;
        applyDimBackgroundInternal(window, getDimAmount());
        applyStatusbarDimBG(context, window);
    }

    private static void applyDimBackgroundInternal(Window window, float f) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 2;
        attributes.dimAmount = f;
        window.setAttributes(attributes);
    }

    private static void applyStatusbarDimBG(Context context, Window window) {
        if (context == null) {
            return;
        }
        window.setStatusBarColor(context.getResources().getColor(R.color.transparent));
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
    }

    private static void clearDimBackgroundInternal(Window window, float f) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags &= -3;
        attributes.dimAmount = f;
        window.setAttributes(attributes);
    }

    private static float getDimAmount() {
        return mDimmed ? 0.6f : 0.0f;
    }

    public static void resetBackground(Window window) {
        if (mDimmed) {
            mDimmed = false;
            clearDimBackgroundInternal(window, getDimAmount());
        }
    }
}
