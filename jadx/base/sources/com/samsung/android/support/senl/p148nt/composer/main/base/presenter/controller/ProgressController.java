package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appcompat.widget.SeslProgressBar;
import androidx.collection.AbstractC0622a;
import androidx.core.util.Pair;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.progress.ComposerProgressBar;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ProgressController implements Task.IProgressBarUpdater {
    private static final long MIN_SHOWTIME = 300;
    private static final String TAG = Logger.createTag("ProgressController");
    public static final int TYPE_COEDIT_UPDATING = 6;
    public static final int TYPE_COMPOSER_INITIALIZE = 5;
    public static final int TYPE_CONFLICT_NOTE_CHANGE = 4;
    public static final int TYPE_NOTE_CHANGE = 3;
    public static final int TYPE_NOT_KEEP_WHEN_RECREATE = 1;
    public static final int TYPE_SAVE = 2;
    public static final int TYPE_TASK = 0;
    private Activity mActivity;
    private final ComposerProgressBar mComposerProgressBar;
    private PopupWindow mLockWindow;
    private View.OnAttachStateChangeListener mOnAttachStateChangeListener;
    private OnCancelListener mOnCancelListener;
    private final ProgressWrapper mProgressWrapper;
    private CountDownTimer mTimer;
    private long mPreviousTime = 0;
    private long mCurrentTimerStart = 0;
    private int mCurrentTimerDelay = 0;
    private long mLastTimeLockWindow = 0;
    Runnable dismissLockWindow = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ProgressController.1
        @Override // java.lang.Runnable
        public void run() {
            if (ProgressController.this.isNotFinished()) {
                return;
            }
            AbstractC8014b.m7215q(new StringBuilder("dismissLockWindow# "), ProgressController.this.mLockWindow != null, ProgressController.TAG);
            if (ProgressController.this.mLockWindow != null) {
                ProgressController.this.mLockWindow.dismiss();
            }
        }
    };
    private final boolean[] mTypeState = {false, false, false, false, false, false, false};
    private final Handler mHandler = new HideHandler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class HideHandler extends Handler {
        public HideHandler(@NonNull Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (!(message.obj instanceof Long)) {
                Logger.m11000e(ProgressController.TAG, "HideHandler#handleMessage# invalid - " + message.what + " delay: " + message.obj);
                return;
            }
            Logger.m10999d(ProgressController.TAG, "HideHandler#handleMessage# type: " + message.what + " delay:" + message.obj);
            ProgressController.this.hideProgress(message.what, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnCancelListener {
        void onCancel(Task.ICancelCallback iCancelCallback);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ProgressBarCancelListenerImpl implements ComposerProgressBar.OnCancelListener {
        public /* synthetic */ ProgressBarCancelListenerImpl(ProgressController progressController, int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.progress.ComposerProgressBar.OnCancelListener
        public void onCancel(final DialogInterface dialogInterface) {
            if (ProgressController.this.mOnCancelListener == null) {
                return;
            }
            Logger.m10999d(ProgressController.TAG, "notifyCancel#");
            ProgressController.this.mOnCancelListener.onCancel(new Task.ICancelCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ProgressController.ProgressBarCancelListenerImpl.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.ICancelCallback
                public void onCancel(boolean z) {
                    if (z) {
                        dialogInterface.dismiss();
                    }
                }
            });
        }

        private ProgressBarCancelListenerImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ProgressWrapper {
        LottieAnimationView mLottieAnimationView;
        SeslProgressBar mProgressCircle;
        View mView;

        public /* synthetic */ ProgressWrapper(int i) {
            this();
        }

        public int getVisibility() {
            View view = this.mView;
            if (view == null) {
                return 8;
            }
            return view.getVisibility();
        }

        public void setStarProgress(boolean z) {
            this.mView = z ? this.mLottieAnimationView : this.mProgressCircle;
        }

        public void setVisibility(int i) {
            if (i == 8) {
                SeslProgressBar seslProgressBar = this.mProgressCircle;
                if (seslProgressBar != null) {
                    seslProgressBar.setVisibility(i);
                }
                LottieAnimationView lottieAnimationView = this.mLottieAnimationView;
                if (lottieAnimationView != null) {
                    lottieAnimationView.cancelAnimation();
                    this.mLottieAnimationView.setVisibility(i);
                    return;
                }
                return;
            }
            if (this.mView == null) {
                this.mView = this.mProgressCircle;
            }
            View view = this.mView;
            if (view != null) {
                view.setVisibility(i);
            }
            View view2 = this.mView;
            LottieAnimationView lottieAnimationView2 = this.mLottieAnimationView;
            if (view2 == lottieAnimationView2) {
                lottieAnimationView2.playAnimation();
            }
        }

        private ProgressWrapper() {
        }
    }

    public ProgressController() {
        int i = 0;
        this.mComposerProgressBar = new ComposerProgressBar(new ProgressBarCancelListenerImpl(this, i));
        this.mProgressWrapper = new ProgressWrapper(i);
    }

    private CountDownTimer createTimer(int i) {
        long j = i;
        return new CountDownTimer(j, j) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ProgressController.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                Logger.m10999d(ProgressController.TAG, "showProgress#Timer.onFinish# " + ProgressController.this.getState());
                ProgressController.this.mTimer = null;
                ProgressController.this.mPreviousTime = SystemClock.uptimeMillis();
                ProgressController.this.setProgressCircleVisibility(0);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getState() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.mTypeState.length; i++) {
            sb.append(i);
            sb.append('-');
            sb.append(this.mTypeState[i]);
            sb.append(' ');
        }
        return sb.toString();
    }

    private void initLockWindow() {
        if (this.mLockWindow != null) {
            return;
        }
        if (this.mOnAttachStateChangeListener != null) {
            Logger.m10999d(TAG, "initLockWindow# window is not attached");
            return;
        }
        if (this.mProgressWrapper.mProgressCircle.isAttachedToWindow()) {
            View viewInflate = ((LayoutInflater) this.mActivity.getSystemService("layout_inflater")).inflate(C9086R.layout.comp_lock, (ViewGroup) null);
            viewInflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ProgressController.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            this.mLockWindow = new PopupWindow(viewInflate, -1, -1);
        } else {
            View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ProgressController.4
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    Logger.m10999d(ProgressController.TAG, "onViewAttachedToWindow# ");
                    ProgressController.this.mOnAttachStateChangeListener = null;
                    if (ProgressController.this.mTypeState[5]) {
                        ProgressController.this.showProgress(0, 5);
                    } else if (ProgressController.this.mTypeState[0]) {
                        ProgressController.this.showProgress(0, 0);
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    ProgressController.this.mOnAttachStateChangeListener = null;
                }
            };
            this.mOnAttachStateChangeListener = onAttachStateChangeListener;
            this.mProgressWrapper.mProgressCircle.addOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    private void lockScreen(int i, boolean z) {
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "lockScreen# type:", " / ");
        sbM778t.append(isLockedScreen());
        Logger.m11003i(str, sbM778t.toString());
        this.mTypeState[i] = true;
        this.mHandler.removeCallbacks(this.dismissLockWindow);
        if (CommonUtil.isNotAvailableActivity(this.mActivity)) {
            Logger.m11000e(str, "lockScreen# mActivity is not active.");
            return;
        }
        setProgressView();
        if (isLockedScreen()) {
            Logger.m11000e(str, "lockScreen# return");
            return;
        }
        initLockWindow();
        if (this.mLockWindow == null) {
            return;
        }
        updateLockWindow(z);
        this.mLastTimeLockWindow = System.currentTimeMillis();
        this.mLockWindow.showAtLocation(this.mActivity.getWindow().getDecorView(), 17, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancelProgress() {
        if (this.mTypeState[4]) {
            hideProgress(4, true);
        } else if (this.mOnCancelListener != null) {
            Logger.m11003i(TAG, "dispatchKeyEvent onCancel#");
            this.mOnCancelListener.onCancel(new Task.ICancelCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ProgressController.3
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.ICancelCallback
                public void onCancel(boolean z) {
                    if (z) {
                        ProgressController.this.mLockWindow.dismiss();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgressCircleVisibility(int i) {
        if (this.mProgressWrapper.mProgressCircle != null) {
            AbstractC8014b.m7217s(i, "setProgressCircleVisibility# ", TAG);
            this.mProgressWrapper.setVisibility(i);
        }
    }

    private void setProgressView() {
        if (this.mProgressWrapper.mProgressCircle != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.mActivity.findViewById(C9086R.id.comp_progress_circle);
        if (viewStub != null) {
            this.mProgressWrapper.mProgressCircle = (SeslProgressBar) viewStub.inflate();
        } else {
            this.mProgressWrapper.mProgressCircle = (SeslProgressBar) this.mActivity.findViewById(C9086R.id.progress_bar);
        }
        this.mProgressWrapper.mProgressCircle.setBackgroundColor(0);
        this.mProgressWrapper.mLottieAnimationView = (LottieAnimationView) this.mActivity.findViewById(C9086R.id.comp_progress_star);
        this.mProgressWrapper.setStarProgress(false);
    }

    private void updateLockWindow(boolean z) {
        View contentView = this.mLockWindow.getContentView();
        RelativeLayout relativeLayout = (RelativeLayout) contentView.findViewById(C9086R.id.layout_action_cancel_progress);
        if (!z) {
            relativeLayout.setVisibility(8);
        } else {
            relativeLayout.setVisibility(0);
            ((TextView) contentView.findViewById(C9086R.id.action_button)).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ProgressController.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ProgressController.this.onCancelProgress();
                }
            });
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isLockedScreen()) {
            return false;
        }
        Logger.m11003i(TAG, "dispatchKeyEvent onKey# " + keyEvent);
        if (!this.mComposerProgressBar.isCancelKeyEvent(keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        onCancelProgress();
        return true;
    }

    public void enableToHideNavigationBar(boolean z) {
        this.mComposerProgressBar.enableToHideNavigationBar(z);
    }

    public void hideProgress(int i, boolean z) {
        String str = TAG;
        Logger.m11003i(str, "hideProgress# type:" + getState() + ", curProgressType: " + i + " / done: " + z + " / isShow: " + isLockedScreen() + SQLKeyword.COMMA + isShowingProgressCircle());
        if (i == 0) {
            if (!z) {
                this.mTypeState[0] = true;
            }
            this.mComposerProgressBar.hide();
        }
        if (i == 3 && z) {
            boolean[] zArr = this.mTypeState;
            if (zArr[4]) {
                zArr[4] = false;
            }
        }
        if (z && isShowingProgressCircle()) {
            long jUptimeMillis = SystemClock.uptimeMillis() - this.mPreviousTime;
            if (jUptimeMillis < 300) {
                long jMin = Math.min(300 - jUptimeMillis, 300L);
                Handler handler = this.mHandler;
                handler.sendMessageDelayed(handler.obtainMessage(i, Long.valueOf(jMin)), jMin);
                Logger.m10999d(str, "hideProgress# delay " + jMin);
                return;
            }
        }
        if (z) {
            this.mTypeState[i] = false;
            if (isNotFinished()) {
                Logger.m10999d(str, "hideProgress# not finished yet");
                return;
            }
            if (this.mTimer != null) {
                Logger.m10999d(str, "hideProgress# timer cancel");
                this.mTimer.cancel();
                this.mTimer = null;
            }
            setProgressCircleVisibility(8);
        }
        if (CommonUtil.isNotAvailableActivity(this.mActivity) || !isLockedScreen()) {
            Logger.m11000e(str, "hideProgress# LockWindow dismiss was fail.");
        } else if (!z || this.mLastTimeLockWindow + 100 <= System.currentTimeMillis()) {
            this.mHandler.removeCallbacks(this.dismissLockWindow);
            this.mLockWindow.dismiss();
        } else {
            this.mHandler.postDelayed(this.dismissLockWindow, System.currentTimeMillis() - this.mLastTimeLockWindow);
        }
        Logger.m11003i(str, "hideProgress# Complete: " + isLockedScreen() + SQLKeyword.COMMA + isShowingProgressCircle());
    }

    public void hideProgressToCancelOfChangingConflictNote() {
        hideProgress(4, true);
    }

    public void init(Activity activity) {
        AbstractC8014b.m7222x(new StringBuilder("init# "), this.mTypeState[0], TAG);
        this.mActivity = activity;
        this.mComposerProgressBar.init(activity);
        if (this.mTypeState[0]) {
            showProgress(0, 0);
        }
    }

    public boolean isLockedScreen() {
        PopupWindow popupWindow = this.mLockWindow;
        if (popupWindow != null) {
            return popupWindow.isShowing();
        }
        return false;
    }

    public boolean isNotFinished() {
        boolean z = false;
        for (boolean z2 : this.mTypeState) {
            z = z || z2;
        }
        return z;
    }

    public boolean isShowingProgressCircle() {
        return this.mProgressWrapper.getVisibility() == 0;
    }

    public boolean isShowingProgressCircleByType(int i) {
        PopupWindow popupWindow = this.mLockWindow;
        return popupWindow != null && popupWindow.isShowing() && this.mTypeState[i];
    }

    public void onChangeLayoutBefore() {
        Logger.m11003i(TAG, "onChangeLayoutBefore#");
        hideProgress(1, true);
    }

    public void onDetachView() {
        Logger.m10999d(TAG, "onDetachView# " + this.mActivity);
        int i = 1;
        while (true) {
            boolean[] zArr = this.mTypeState;
            if (i >= zArr.length) {
                break;
            }
            if (zArr[i]) {
                hideProgress(i, true);
            }
            i++;
        }
        this.mActivity = null;
        this.mHandler.removeCallbacks(this.dismissLockWindow);
        PopupWindow popupWindow = this.mLockWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.mLockWindow = null;
        }
        this.mProgressWrapper.mProgressCircle = null;
        this.mOnAttachStateChangeListener = null;
        this.mComposerProgressBar.onDetachView();
    }

    public void onInitLayoutFinished() {
        AbstractC8014b.m7222x(new StringBuilder("onInitLayoutFinished# "), this.mTypeState[0], TAG);
        this.mProgressWrapper.mProgressCircle = null;
        if (this.mTypeState[0]) {
            showProgress(0, 0);
        }
    }

    public void resetOnCancelListener(OnCancelListener onCancelListener) {
        this.mOnCancelListener = onCancelListener;
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        this.mOnCancelListener = onCancelListener;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.IProgressBarUpdater
    public void setProgress(int i) {
        this.mComposerProgressBar.setProgress(i);
    }

    public void setProgressStar(boolean z) {
        this.mProgressWrapper.setStarProgress(z);
    }

    public void showProgress(int i, int i2) {
        showProgress(i, i2, false);
    }

    public boolean showProgressBarDialog(Pair<Boolean, Integer> pair, boolean z) {
        return this.mComposerProgressBar.show(pair, z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.IProgressBarUpdater
    public void updateDialogTitle(String str) {
        this.mComposerProgressBar.setTitle(str);
    }

    public void showProgress(int i, int i2, boolean z) {
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "showProgress# delay: ", ". type : ", " / isShow: ");
        sbM1173s.append(isLockedScreen());
        sbM1173s.append(SQLKeyword.COMMA);
        sbM1173s.append(isShowingProgressCircle());
        Logger.m11003i(str, sbM1173s.toString());
        this.mHandler.removeMessages(i2);
        lockScreen(i2, z);
        if (i <= 0) {
            this.mPreviousTime = SystemClock.uptimeMillis();
            setProgressCircleVisibility(0);
            return;
        }
        if (this.mTimer != null) {
            long jUptimeMillis = ((long) this.mCurrentTimerDelay) - (SystemClock.uptimeMillis() - this.mCurrentTimerStart);
            if (jUptimeMillis < i) {
                Logger.m10999d(str, "showProgress# remainTime = " + jUptimeMillis + " new delay = " + i);
                return;
            }
            this.mTimer.cancel();
        }
        CountDownTimer countDownTimerCreateTimer = createTimer(i);
        this.mTimer = countDownTimerCreateTimer;
        countDownTimerCreateTimer.start();
        setProgressCircleVisibility(8);
        this.mCurrentTimerStart = SystemClock.uptimeMillis();
        this.mCurrentTimerDelay = i;
    }
}
