package com.samsung.android.sdk.smp;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.BroadcastUtil;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.display.DisplayManager;
import com.samsung.android.sdk.smp.display.PopupDisplayManager;
import com.samsung.android.sdk.smp.display.PopupViewInflater;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@TargetApi(29)
public class SmpPopupService extends Service implements PopupViewInflater.OnClickButtonListener, PopupViewInflater.OnResultHandler, PopupViewInflater.BackgroundBlurHandler {
    private static final int FOREGROUND_NOTI_ID = 9000999;
    private static final String TAG = "SmpPopupService";
    private long mClearTime;
    private int mDisplayId;
    private boolean mIsFirstDisplay;
    private boolean mIsPLink;
    private String mMid;
    private PopupViewInflater mPopupInflater;
    private int mStartId;
    private View mView;
    private WindowManager mWindowManager;

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPopup() {
        View view;
        Context applicationContext = getApplicationContext();
        if (this.mDisplayId == PopupDisplayManager.getCurrentDisplayID(applicationContext)) {
            PopupDisplayManager.setCurrentDisplayID(applicationContext, -1);
        }
        WindowManager windowManager = this.mWindowManager;
        if (windowManager != null && (view = this.mView) != null) {
            windowManager.removeView(view);
        }
        this.mWindowManager = null;
        this.mView = null;
    }

    private String getAvailableNotiChannelId(Context context) {
        PrefManager prefManager = PrefManager.getInstance(context);
        String notiChannelId = prefManager.getNotiChannelId(2);
        if (isChannelEnabled(context, notiChannelId)) {
            return notiChannelId;
        }
        String notiChannelId2 = prefManager.getNotiChannelId(1);
        if (isChannelEnabled(context, notiChannelId2)) {
            return notiChannelId2;
        }
        SmpLog.m6494e(TAG, "getAvailableNotiChannelId. notification channel is not available");
        return null;
    }

    @TargetApi(29)
    private WindowManager.LayoutParams getOverlayLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2038, 262144, -2);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    private LinearLayout getWrapperLayout() {
        return new LinearLayout(this) { // from class: com.samsung.android.sdk.smp.SmpPopupService.1
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchKeyEvent(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == 4) {
                    SmpPopupService smpPopupService = SmpPopupService.this;
                    SmpPopupService.this.sendBroadcast(DisplayManager.getDeleteIntent(smpPopupService, smpPopupService.mMid, "2", SmpPopupService.this.mDisplayId));
                    SmpPopupService.this.clearPopup();
                }
                SmpPopupService smpPopupService2 = SmpPopupService.this;
                smpPopupService2.stopSelf(smpPopupService2.mStartId);
                return super.dispatchKeyEvent(keyEvent);
            }
        };
    }

    private boolean isChannelEnabled(Context context, String str) {
        if (str == null) {
            return false;
        }
        try {
            return !DeviceInfoUtil.isNotiSettingOptionDisabled(context, str);
        } catch (InternalException.IllegalPushChannelException unused) {
            return false;
        }
    }

    private void makeForegroundService(Context context, String str) {
        startForeground(9000999, new Notification.Builder(context, str).build(), 512);
    }

    @Override // com.samsung.android.sdk.smp.display.PopupViewInflater.BackgroundBlurHandler
    public void bgOff() {
        View view = this.mView;
        if (view != null) {
            view.setBackgroundColor(0);
        }
    }

    @Override // com.samsung.android.sdk.smp.display.PopupViewInflater.BackgroundBlurHandler
    public void bgOn() {
        View view = this.mView;
        if (view != null) {
            view.setBackgroundColor(Color.argb(99, 0, 0, 0));
        }
    }

    @Override // com.samsung.android.sdk.smp.display.PopupViewInflater.OnResultHandler
    public void displayFail(FeedbackEvent feedbackEvent, String str) {
        if (this.mIsFirstDisplay) {
            PopupDisplayManager.broadcastFailResult(getApplicationContext(), this.mMid, feedbackEvent, str);
        }
        stopSelf(this.mStartId);
    }

    @Override // com.samsung.android.sdk.smp.display.PopupViewInflater.OnResultHandler
    public void displayFailButRetry() {
        PopupDisplayManager.broadcastFailButRetryResult(getApplicationContext(), this.mMid, this.mIsFirstDisplay);
        stopSelf(this.mStartId);
    }

    @Override // com.samsung.android.sdk.smp.display.PopupViewInflater.OnResultHandler
    public void displaySuccess(Bundle bundle) {
        CharSequence charSequence;
        String[] strArr;
        PopupDisplayManager.setCurrentDisplayID(getApplicationContext(), this.mDisplayId);
        PopupDisplayManager.broadcastSuccessResult(getApplicationContext(), this.mMid, this.mClearTime, this.mIsFirstDisplay);
        if (bundle != null) {
            String[] stringArray = bundle.getStringArray(MarketingConstants.DisplayConst.CLICK_LINK_URIS);
            charSequence = bundle.getCharSequence(MarketingConstants.DisplayConst.POP_BODY_TEXT);
            strArr = stringArray;
        } else {
            charSequence = null;
            strArr = null;
        }
        BroadcastUtil.broadcastMarketingDisplay(getApplicationContext(), "display", SmpConstants.MARKETING_TYPE_POPUP, this.mMid, this.mIsFirstDisplay, null, charSequence, strArr);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.samsung.android.sdk.smp.display.PopupViewInflater.OnClickButtonListener
    public void onClickButton(ArrayList<Bundle> arrayList) {
        sendBroadcast(DisplayManager.getClickIntent(this, this.mMid, this.mIsPLink, arrayList));
        stopSelf(this.mStartId);
    }

    @Override // com.samsung.android.sdk.smp.display.PopupViewInflater.OnClickButtonListener
    public void onClickCloseButton() {
        sendBroadcast(DisplayManager.getDeleteIntent(this, this.mMid, "2", this.mDisplayId));
        stopSelf(this.mStartId);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        PopupViewInflater popupViewInflater = this.mPopupInflater;
        if (popupViewInflater != null) {
            popupViewInflater.onConfigurationChnaged();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        SmpLog.m6492d(TAG, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        SmpLog.m6492d(TAG, "onDestroy");
        this.mPopupInflater = null;
        clearPopup();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String str = TAG;
        SmpLog.m6492d(str, "onStartCommand");
        if (intent == null || intent.getExtras() == null) {
            SmpLog.m6494e(str, "fail to display popup. intent null");
            stopSelf(i2);
            return 2;
        }
        if (intent.getBooleanExtra(MarketingConstants.DisplayConst.KEY_EXTRA_CLEAR, false)) {
            SmpLog.m6492d(str, "service is started to clear popup");
            makeForegroundService(getApplicationContext(), getAvailableNotiChannelId(getApplicationContext()));
            if (this.mIsFirstDisplay) {
                PopupDisplayManager.broadcastNoActionResult(this, this.mMid);
            }
            clearPopup();
            stopSelf(i2);
            return 2;
        }
        Bundle bundleExtra = intent.getBundleExtra(MarketingConstants.DisplayConst.KEY_EXTRA_POPUP_DATA);
        if (bundleExtra == null) {
            SmpLog.m6494e(str, "fail to display popup. data not found");
            stopSelf(i2);
            return 2;
        }
        this.mStartId = i2;
        this.mIsFirstDisplay = intent.getBooleanExtra(MarketingConstants.DisplayConst.KEY_EXTRA_IS_FIRST_DISPLAY, true);
        this.mClearTime = intent.getLongExtra(MarketingConstants.DisplayConst.KEY_EXTRA_CLEAR_TIME, -1L);
        this.mMid = bundleExtra.getString("mid");
        this.mDisplayId = bundleExtra.getInt(MarketingConstants.DisplayConst.DISPLAYID, -1);
        String stringExtra = intent.getStringExtra(MarketingConstants.DisplayConst.KEY_EXTRA_CHANNEL_ID);
        int i4 = bundleExtra.getInt("template_type");
        this.mIsPLink = bundleExtra.getBoolean("p_link", false);
        StringBuilder sb = new StringBuilder("startId:");
        sb.append(this.mStartId);
        sb.append(", isFirstDisplay:");
        sb.append(this.mIsFirstDisplay);
        sb.append(", clearTime:");
        sb.append(this.mClearTime);
        sb.append(", mid:");
        sb.append(this.mMid);
        sb.append(", displayId:");
        AbstractC1974b.m1331x(sb, this.mDisplayId, ", channelId:", stringExtra, ", templateType: ");
        sb.append(i4);
        sb.append(", isPLink:");
        sb.append(this.mIsPLink);
        SmpLog.m6492d(str, sb.toString());
        if (this.mMid == null || this.mClearTime < 0 || this.mDisplayId <= 0 || stringExtra == null) {
            SmpLog.m6494e(str, "fail to display popup. invalid params");
            displayFail(FeedbackEvent.CLIENT_INTERNAL_ERROR, null);
            return 2;
        }
        try {
            makeForegroundService(getApplicationContext(), stringExtra);
            this.mWindowManager = (WindowManager) getSystemService("window");
            this.mView = ((LayoutInflater) getSystemService("layout_inflater")).inflate(PopupDisplayManager.getLayoutResID(i4), getWrapperLayout());
            try {
                PopupViewInflater popupViewInflater = new PopupViewInflater(i4, this.mMid, this.mWindowManager, this, this, this);
                this.mPopupInflater = popupViewInflater;
                popupViewInflater.inflateView(this.mView, bundleExtra);
                this.mWindowManager.addView(this.mView, getOverlayLayoutParams());
            } catch (InternalException.ImageDecodingException e) {
                e = e;
                SmpLog.m6494e(TAG, e.toString());
                displayFail(FeedbackEvent.CLIENT_INTERNAL_ERROR, FeedbackDetailConstants.IMAGE_DECODE_FAIL);
            } catch (InternalException.InvalidArgumentException | InternalException.NotSupportedTypeException unused) {
                displayFail(FeedbackEvent.CLIENT_INTERNAL_ERROR, null);
            } catch (Exception e2) {
                e = e2;
                SmpLog.m6494e(TAG, e.toString());
                displayFail(FeedbackEvent.CLIENT_INTERNAL_ERROR, null);
            }
        } catch (InternalException.ImageDecodingException e3) {
            e = e3;
        } catch (InternalException.InvalidArgumentException | InternalException.NotSupportedTypeException unused2) {
        } catch (Exception e5) {
            e = e5;
        }
        return 2;
    }
}
