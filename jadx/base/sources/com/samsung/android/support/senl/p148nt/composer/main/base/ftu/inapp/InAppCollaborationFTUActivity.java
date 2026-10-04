package com.samsung.android.support.senl.p148nt.composer.main.base.ftu.inapp;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.support.senl.p148nt.base.common.constants.FTUConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class InAppCollaborationFTUActivity extends AppCompatActivity {
    private static final int DELAY_FINISH_WITH_FAIL = 150;
    private static final int DELAY_FINISH_WITH_SUCCESS = 400;
    private static final int DELAY_SHOW_START_BUTTON = 4000;
    private static final int DURATION_DISMISS = 150;
    private static final int DURATION_SHOW = 200;
    private LottieAnimationView mLottie;
    private Button mStart;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final View.OnClickListener mOnStartClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.ftu.inapp.InAppCollaborationFTUActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InAppCollaborationFTUActivity.this.dismissAllView();
            InAppCollaborationFTUActivity.this.finishWithDelay(true);
        }
    };
    private final View.OnTouchListener mOnDimTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.ftu.inapp.InAppCollaborationFTUActivity.2
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InAppCollaborationFTUActivity.this.dismissAllView();
            InAppCollaborationFTUActivity.this.finishWithDelay(false);
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissAllView() {
        dismissFTUVideo();
        dismissStartButton();
    }

    private void dismissFTUVideo() {
        LottieAnimationView lottieAnimationView = this.mLottie;
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.animate().alpha(0.0f).setDuration(150L).setInterpolator(new LinearInterpolator()).withEndAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.ftu.inapp.InAppCollaborationFTUActivity.4
            @Override // java.lang.Runnable
            public void run() {
                InAppCollaborationFTUActivity.this.mLottie.setVisibility(4);
            }
        }).start();
    }

    private void dismissStartButton() {
        Button button = this.mStart;
        if (button == null) {
            return;
        }
        button.animate().alpha(0.0f).setDuration(150L).setInterpolator(new LinearInterpolator()).withEndAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.ftu.inapp.InAppCollaborationFTUActivity.5
            @Override // java.lang.Runnable
            public void run() {
                InAppCollaborationFTUActivity.this.mStart.setVisibility(4);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithDelay(final boolean z) {
        this.mHandler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.ftu.inapp.InAppCollaborationFTUActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    InAppCollaborationFTUActivity.this.finishWithSuccess();
                } else {
                    InAppCollaborationFTUActivity.this.finishWithFail();
                }
            }
        }, z ? 400L : 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithFail() {
        setResult(0);
        runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.ftu.inapp.InAppCollaborationFTUActivity.8
            @Override // java.lang.Runnable
            public void run() {
                InAppCollaborationFTUActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithSuccess() {
        setResult(-1);
        runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.ftu.inapp.InAppCollaborationFTUActivity.7
            @Override // java.lang.Runnable
            public void run() {
                InAppCollaborationFTUActivity.this.finish();
            }
        });
    }

    private void init() {
        this.mLottie = (LottieAnimationView) findViewById(C9086R.id.lottie);
        Button button = (Button) findViewById(C9086R.id.use_phone_as_toolbar);
        this.mStart = button;
        button.setOnClickListener(this.mOnStartClickListener);
        getWindow().getDecorView().setOnTouchListener(this.mOnDimTouchListener);
    }

    private void showFTUVideo() {
        LottieAnimationView lottieAnimationView = this.mLottie;
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.setVisibility(0);
        this.mLottie.setAlpha(0.0f);
        this.mLottie.animate().alpha(1.0f).setDuration(200L).setInterpolator(new LinearInterpolator()).withEndAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.ftu.inapp.InAppCollaborationFTUActivity.3
            @Override // java.lang.Runnable
            public void run() {
                InAppCollaborationFTUActivity.this.mLottie.playAnimation();
                InAppCollaborationFTUActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.ftu.inapp.InAppCollaborationFTUActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InAppCollaborationFTUActivity.this.showStartButton();
                    }
                }, 4000L);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showStartButton() {
        Button button = this.mStart;
        if (button == null) {
            return;
        }
        button.setVisibility(0);
        this.mStart.setAlpha(0.0f);
        this.mStart.animate().alpha(1.0f).setDuration(200L).setInterpolator(new LinearInterpolator()).start();
    }

    private void updateSystemColor() {
        SystemUi.setStatusBarTheme(this, getColor(C9086R.color.in_app_collaboration_ftu_bg_color), !ContextUtils.isNightMode(this));
        SystemUi.setNavigationBarTheme(this, getColor(C9086R.color.in_app_collaboration_ftu_bg_color), !ContextUtils.isNightMode(this));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateSystemColor();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C9086R.layout.in_app_collaboration_ftu_activity);
        init();
        showFTUVideo();
        updateSystemColor();
        FTUConstants.setInAppFTUUsed();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (ContextUtils.isNightMode(this)) {
            finishWithFail();
        }
    }
}
