package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.navigation.NavigationBarItemView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class BottomProgressCircleManager {
    private static final String TAG = "BottomProgressCircleManager";
    private static BottomProgressCircleManager mInstance;
    private boolean isProgressOn = false;

    public static BottomProgressCircleManager getInstance() {
        if (mInstance == null) {
            mInstance = new BottomProgressCircleManager();
        }
        return mInstance;
    }

    public void dismiss() {
        if (this.isProgressOn) {
            MainLogger.m7258i(TAG, "dismiss");
            this.isProgressOn = false;
        }
    }

    public boolean isProgressOn() {
        return this.isProgressOn;
    }

    @SuppressLint({"RestrictedApi"})
    public boolean show(NavigationBarItemView navigationBarItemView) {
        if (navigationBarItemView == null) {
            return false;
        }
        int itemPosition = navigationBarItemView.getItemPosition();
        ViewGroup viewGroup = (ViewGroup) navigationBarItemView.getParent();
        viewGroup.removeViewAt(itemPosition);
        viewGroup.addView(View.inflate(viewGroup.getContext(), C8003R.layout.notes_progress_circle_small, null), itemPosition);
        this.isProgressOn = true;
        return true;
    }
}
