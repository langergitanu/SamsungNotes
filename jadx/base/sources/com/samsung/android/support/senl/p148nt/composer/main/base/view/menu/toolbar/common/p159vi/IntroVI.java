package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.p159vi;

import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class IntroVI {
    public static final int INITIAL_POSITION = -100;
    private static final String INTRO_VI_COUNT_ID = "intro_vi_count";
    private static final int INTRO_VI_COUNT_MAX = 3;
    protected static String TAG = Logger.createTag("IntroVI");
    private final Contract mContract;
    private int mDockType;
    private Runnable mIntroPostRunnable;
    private Runnable mIntroRunnable;
    private WeakReference<View> mTargetViewRef;
    private boolean mIsEnded = false;
    private boolean mIsStarted = false;
    private boolean mIsKeyboardShown = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void cancel();

        void doDockingByDirection(int i);

        boolean isReleased();
    }

    public IntroVI(View view, int i, Contract contract) {
        this.mTargetViewRef = new WeakReference<>(view);
        this.mDockType = i;
        this.mContract = contract;
    }

    private static int getIntroVIRunCount() {
        return SharedPreferencesCompat.getInstance("Composer").getInt(INTRO_VI_COUNT_ID, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable getStartIntroPostRunnable() {
        Runnable runnable = this.mIntroPostRunnable;
        if (runnable != null) {
            return runnable;
        }
        Runnable runnable2 = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.IntroVI.2
            @Override // java.lang.Runnable
            public void run() {
                IntroVI.this.mIsEnded = true;
                IntroVI.this.mIsStarted = false;
                if (IntroVI.this.isInvalidState()) {
                    IntroVI.this.cancel();
                    return;
                }
                IntroVI.updateIntroVIRunCount();
                if (!IntroVI.isEnabledIntroVI()) {
                    IntroVI.setDisableState();
                }
                if (!IntroVI.this.mIsKeyboardShown) {
                    IntroGuideTip.show((View) IntroVI.this.mTargetViewRef.get());
                }
                Logger.m11000e(IntroVI.TAG, "IntroVI done");
            }
        };
        this.mIntroPostRunnable = runnable2;
        return runnable2;
    }

    private Runnable getStartIntroRunnable() {
        Runnable runnable = this.mIntroRunnable;
        if (runnable != null) {
            return runnable;
        }
        Runnable runnable2 = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.IntroVI.1
            @Override // java.lang.Runnable
            public void run() {
                if (IntroVI.this.isInvalidState()) {
                    IntroVI.this.cancel();
                    return;
                }
                Logger.m11003i(IntroVI.TAG, "IntroVI Running");
                IntroVI.this.mContract.doDockingByDirection(IntroVI.this.mDockType);
                ((View) IntroVI.this.mTargetViewRef.get()).postDelayed(IntroVI.this.getStartIntroPostRunnable(), 800L);
            }
        };
        this.mIntroRunnable = runnable2;
        return runnable2;
    }

    private static boolean isEnableState() {
        return SharedPreferencesCompat.getInstance("Composer").getBoolean(SharedPreferencesConstants.COMPOSER_KEY_INTRO_TOOLBAR_SHOWN, isEnabledIntroVI());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEnabledIntroVI() {
        return getIntroVIRunCount() < 3;
    }

    public static Boolean isInitialPosition(float f, float f4) {
        if (f == -100.0f || f4 == -100.0f) {
            return Boolean.TRUE;
        }
        setDisableState();
        return Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInvalidState() {
        boolean z = this.mContract.isReleased() || this.mTargetViewRef.get() == null;
        AbstractC8014b.m7224z("isInvalidState : ", TAG, z);
        return z;
    }

    public static boolean isSupport() {
        return isUpperSEP() && isEnableState();
    }

    private static boolean isUpperSEP() {
        return DeviceInfo.getSemPlatformVersionInt(0) >= 110500;
    }

    private void removeCallbacks() {
        this.mTargetViewRef.get().removeCallbacks(this.mIntroRunnable);
        this.mTargetViewRef.get().removeCallbacks(this.mIntroPostRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDisableState() {
        SharedPreferencesCompat.getInstance("Composer").putBoolean(SharedPreferencesConstants.COMPOSER_KEY_INTRO_TOOLBAR_SHOWN, false);
    }

    private void updateIntroStartPositionX() {
        this.mTargetViewRef.get().setTranslationX(0.0f);
    }

    private void updateIntroStartPositionY() {
        int dimensionPixelSize = this.mTargetViewRef.get().getResources().getDimensionPixelSize(C9086R.dimen.comp_hw_floating_menu_item_size);
        if (this.mDockType != 1) {
            this.mTargetViewRef.get().setTranslationY(dimensionPixelSize);
        } else {
            this.mTargetViewRef.get().setTranslationY(((View) this.mTargetViewRef.get().getParent()).getHeight() - (dimensionPixelSize * 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateIntroVIRunCount() {
        SharedPreferencesCompat.getInstance("Composer").putInt(INTRO_VI_COUNT_ID, getIntroVIRunCount() + 1);
    }

    public void cancel() {
        Logger.m11000e(TAG, "canceled");
        this.mContract.cancel();
        removeCallbacks();
        this.mIntroRunnable = null;
    }

    public boolean hasStarted() {
        return this.mIsStarted;
    }

    public boolean isRunning() {
        return this.mIsStarted && !this.mIsEnded;
    }

    public void setKeyboardShown() {
        Logger.m11003i(TAG, "setKeyboardShown");
        this.mIsKeyboardShown = true;
    }

    public boolean start() {
        Logger.m11003i(TAG, "start");
        WeakReference<View> weakReference = this.mTargetViewRef;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        this.mIsEnded = false;
        this.mIsStarted = true;
        updateIntroStartPositionX();
        updateIntroStartPositionY();
        removeCallbacks();
        this.mTargetViewRef.get().postDelayed(getStartIntroRunnable(), 500L);
        return true;
    }
}
