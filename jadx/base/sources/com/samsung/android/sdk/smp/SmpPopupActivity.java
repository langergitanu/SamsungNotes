package com.samsung.android.sdk.smp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.util.BroadcastUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.display.DisplayManager;
import com.samsung.android.sdk.smp.display.PopupDisplayManager;
import com.samsung.android.sdk.smp.display.PopupViewInflater;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpPopupActivity extends Activity implements PopupViewInflater.OnClickButtonListener, PopupViewInflater.OnResultHandler, PopupViewInflater.BackgroundBlurHandler {
    private static final String TAG = "SmpPopupActivity";
    private long mClearTime;
    private int mDisplayId;
    private boolean mIsFirstDisplay;
    private boolean mIsPLink;
    private String mMid;
    private PopupViewInflater mPopupInflater;
    private boolean mSendFeedbackWhenDestroy;

    @Override // com.samsung.android.sdk.smp.display.PopupViewInflater.BackgroundBlurHandler
    public void bgOff() {
        getWindow().clearFlags(2);
    }

    @Override // com.samsung.android.sdk.smp.display.PopupViewInflater.BackgroundBlurHandler
    public void bgOn() {
        getWindow().addFlags(2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Rect rect = new Rect();
        getWindow().getDecorView().getHitRect(rect);
        if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.smp.display.PopupViewInflater.OnResultHandler
    public void displayFail(FeedbackEvent feedbackEvent, String str) {
        if (this.mIsFirstDisplay) {
            PopupDisplayManager.broadcastFailResult(getApplicationContext(), this.mMid, feedbackEvent, str);
        }
        this.mSendFeedbackWhenDestroy = false;
        finish();
    }

    @Override // com.samsung.android.sdk.smp.display.PopupViewInflater.OnResultHandler
    public void displayFailButRetry() {
        PopupDisplayManager.broadcastFailButRetryResult(getApplicationContext(), this.mMid, this.mIsFirstDisplay);
        this.mSendFeedbackWhenDestroy = false;
        finish();
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

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mSendFeedbackWhenDestroy) {
            this.mSendFeedbackWhenDestroy = false;
            sendBroadcast(DisplayManager.getDeleteIntent(this, this.mMid, "2", this.mDisplayId));
        }
        super.onBackPressed();
    }

    @Override // com.samsung.android.sdk.smp.display.PopupViewInflater.OnClickButtonListener
    public void onClickButton(ArrayList<Bundle> arrayList) {
        this.mSendFeedbackWhenDestroy = false;
        sendBroadcast(DisplayManager.getClickIntent(this, this.mMid, this.mIsPLink, arrayList));
        finish();
    }

    @Override // com.samsung.android.sdk.smp.display.PopupViewInflater.OnClickButtonListener
    public void onClickCloseButton() {
        this.mSendFeedbackWhenDestroy = false;
        sendBroadcast(DisplayManager.getDeleteIntent(this, this.mMid, "2", this.mDisplayId));
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        PopupViewInflater popupViewInflater = this.mPopupInflater;
        if (popupViewInflater != null) {
            popupViewInflater.onConfigurationChnaged();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        String str = TAG;
        SmpLog.m6492d(str, "onCreate");
        if (getIntent() == null || getIntent().getExtras() == null) {
            SmpLog.m6494e(str, "fail to display popup. intent null");
            finish();
            return;
        }
        if (getIntent().getBooleanExtra(MarketingConstants.DisplayConst.KEY_EXTRA_CLEAR, false)) {
            SmpLog.m6492d(str, "activity is started to clear popup");
            finish();
            return;
        }
        Bundle bundleExtra = getIntent().getBundleExtra(MarketingConstants.DisplayConst.KEY_EXTRA_POPUP_DATA);
        if (bundleExtra == null) {
            SmpLog.m6494e(str, "fail to display popup. data not found");
            finish();
            return;
        }
        boolean booleanExtra = getIntent().getBooleanExtra(MarketingConstants.DisplayConst.KEY_EXTRA_IS_FIRST_DISPLAY, true);
        this.mIsFirstDisplay = booleanExtra;
        this.mSendFeedbackWhenDestroy = booleanExtra;
        this.mClearTime = getIntent().getLongExtra(MarketingConstants.DisplayConst.KEY_EXTRA_CLEAR_TIME, -1L);
        this.mMid = bundleExtra.getString("mid");
        this.mDisplayId = bundleExtra.getInt(MarketingConstants.DisplayConst.DISPLAYID, -1);
        int i = bundleExtra.getInt("template_type");
        this.mIsPLink = bundleExtra.getBoolean("p_link", false);
        StringBuilder sb = new StringBuilder("isFirstDisplay:");
        sb.append(this.mIsFirstDisplay);
        sb.append(", clearTime:");
        sb.append(this.mClearTime);
        sb.append(", mid:");
        sb.append(this.mMid);
        sb.append(", displayId:");
        AbstractC2821a.m2235z(sb, this.mDisplayId, i, ", templateType: ", ", isPLink:");
        sb.append(this.mIsPLink);
        SmpLog.m6492d(str, sb.toString());
        if (this.mMid == null || this.mClearTime < 0 || this.mDisplayId <= 0) {
            SmpLog.m6494e(str, "fail to display popup. invalid params");
            displayFail(FeedbackEvent.CLIENT_INTERNAL_ERROR, null);
            return;
        }
        try {
            setContentView(PopupDisplayManager.getLayoutResID(i));
            try {
                PopupViewInflater popupViewInflater = new PopupViewInflater(i, this.mMid, getWindowManager(), this, this, this);
                this.mPopupInflater = popupViewInflater;
                popupViewInflater.inflateView(findViewById(C7794R.id.pop_wrapper), bundleExtra);
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
    }

    @Override // android.app.Activity
    public void onDestroy() {
        SmpLog.m6492d(TAG, "onDestroy");
        this.mPopupInflater = null;
        if (this.mSendFeedbackWhenDestroy) {
            PopupDisplayManager.broadcastNoActionResult(this, this.mMid);
        }
        if (this.mDisplayId == PopupDisplayManager.getCurrentDisplayID(getApplicationContext())) {
            PopupDisplayManager.setCurrentDisplayID(getApplicationContext(), -1);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null || !intent.getBooleanExtra(MarketingConstants.DisplayConst.KEY_EXTRA_CLEAR, false)) {
            return;
        }
        SmpLog.m6492d(TAG, "the activity is started to clear popup");
        finish();
    }
}
