package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenPreview;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class HwFavoritePreview {
    static final long SHORT_DURATION_TIMEOUT = 2000;
    private static final String TAG = Logger.createTag("HwFavoritePreview");
    private SpenColorThemeUtil mColorThemeUtil;
    private SpenFavoritePenPreview mFavoritePenPreview;
    private PopupWindow mPopupWindowFavoritePenPreview;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable dismissPreviewThread = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.HwFavoritePreview.1
        @Override // java.lang.Runnable
        public void run() {
            HwFavoritePreview.this.dismissFavoritePenPreview("dismissPreviewThread");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissFavoritePenPreview(@NonNull String str) {
        if (this.mPopupWindowFavoritePenPreview == null) {
            Logger.m11003i(TAG, "dismissFavoritePenPreview - " + str + " | popupWindow is null");
            return;
        }
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("dismissFavoritePenPreview - ", str, " | isShowing : ");
        sbM15l.append(this.mPopupWindowFavoritePenPreview.isShowing());
        Logger.m11003i(str2, sbM15l.toString());
        this.mPopupWindowFavoritePenPreview.dismiss();
    }

    public void hideFavoritePenPreview() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.dismissPreviewThread);
        }
        dismissFavoritePenPreview("hideFavoritePenPreview");
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.mPopupWindowFavoritePenPreview;
        return popupWindow != null && popupWindow.isShowing();
    }

    public void showFavoritePenPreview(View view, int i, SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (this.mFavoritePenPreview == null) {
            this.mFavoritePenPreview = new SpenFavoritePenPreview(view.getContext());
        }
        if (this.mColorThemeUtil == null) {
            this.mColorThemeUtil = new SpenColorThemeUtil(view.getContext());
        }
        this.mColorThemeUtil.setColorTheme(i);
        SpenSettingUIPenInfo spenSettingUIPenInfo2 = new SpenSettingUIPenInfo(spenSettingUIPenInfo);
        int color = this.mColorThemeUtil.getColor(spenSettingUIPenInfo2.color);
        spenSettingUIPenInfo2.color = color;
        Color.colorToHSV(color, spenSettingUIPenInfo2.hsv);
        this.mFavoritePenPreview.setPenInfo(spenSettingUIPenInfo2);
        if (this.mPopupWindowFavoritePenPreview == null) {
            this.mPopupWindowFavoritePenPreview = new PopupWindow(this.mFavoritePenPreview, -2, -2);
        }
        hideFavoritePenPreview();
        this.mPopupWindowFavoritePenPreview.setAnimationStyle(C9086R.style.ColorPickerAnimation);
        this.mPopupWindowFavoritePenPreview.showAtLocation(view, 17, 0, 0);
        this.mHandler.postDelayed(this.dismissPreviewThread, 2000L);
    }
}
