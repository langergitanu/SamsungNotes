package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p022E1.RunnableC0080f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0012\b\u0016\u0018\u0000 42\u00020\u0001:\u000245B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u00192\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0012\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010!\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\"\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0019H\u0002J\u001a\u0010&\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010'\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00052\u0006\u0010(\u001a\u00020$H\u0016J\u0018\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u001eH\u0016J\u0018\u0010,\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u001eH\u0016J\b\u0010-\u001a\u00020\u0019H\u0002J\b\u0010.\u001a\u00020\u0010H\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0010H\u0016J\u0006\u00100\u001a\u00020\u0019J\u000e\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u0014J\u000e\u00103\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u00066"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController;", "", "<init>", "()V", "spenView", "Landroid/view/View;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "handler", "Landroid/os/Handler;", "forceToShowRunnable", "Ljava/lang/Runnable;", "delayHideRunnable", "forceToShowInputTryCount", "", "blockingToShow", "", "blockingToHide", "onSipStateListeners", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController$OnSipStateListener;", "Lkotlin/collections/ArrayList;", "getOnSipStateListeners", "()Ljava/util/ArrayList;", "setSpenView", "", "view", "setActivity", "setHandler", "getTag", "", Constants.IntentExtraValue.SHOW, VPathDataCmd.RCurveTo, "hide", "delayForceToShow", "timeout", "", "removeCallbackForceToShow", "forceToShow", "delayHide", "delay", "blockToShow", "block", "msg", "blockToHide", "removeCallbackDelayHide", "isInputMethodShown", "checkingMobileKeyboard", "release", "addListener", "stateListener", "removeListener", "Companion", "OnSipStateListener", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class SipController {
    private static final long FORCE_TO_SHOW_INPUT_RETRY_INTERVAL = 100;

    @Nullable
    private Activity activity;
    private boolean blockingToHide;
    private boolean blockingToShow;

    @Nullable
    private Runnable delayHideRunnable;
    private int forceToShowInputTryCount;

    @Nullable
    private Runnable forceToShowRunnable;

    @Nullable
    private Handler handler = new Handler(Looper.getMainLooper());

    @NotNull
    private final ArrayList<OnSipStateListener> onSipStateListeners = new ArrayList<>();

    @Nullable
    private View spenView;

    @NotNull
    private static final String TAG = SmLogger.createTag("SipController");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController$OnSipStateListener;", "", "onSipShow", "", "onSipHide", "onSipVisibilityChanged", "isVisible", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnSipStateListener {
        void onSipHide();

        void onSipShow();

        void onSipVisibilityChanged(boolean isVisible);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delayForceToShow$lambda$0(SipController sipController, View view, long j) {
        sipController.forceToShowRunnable = null;
        if (sipController.delayHideRunnable == null) {
            sipController.forceToShow(view, j);
        } else {
            SmLogger.m8666i(TAG, "delayForceToShow# delayHideRunnable is not null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delayHide$lambda$1(SipController sipController, View view) {
        sipController.delayHideRunnable = null;
        if (sipController.forceToShowRunnable == null) {
            sipController.hide(view);
        } else {
            SmLogger.m8666i(TAG, "delayHide# forceToShowRunnable is not null");
        }
    }

    private final void removeCallbackDelayHide() {
        if (this.delayHideRunnable == null) {
            return;
        }
        SmLogger.m8666i(TAG, "removeRunnableDelayHide#");
        Handler handler = this.handler;
        if (handler != null) {
            Runnable runnable = this.delayHideRunnable;
            Intrinsics.checkNotNull(runnable);
            handler.removeCallbacks(runnable);
        }
        this.delayHideRunnable = null;
    }

    private final void removeCallbackForceToShow() {
        if (this.forceToShowRunnable == null) {
            return;
        }
        SmLogger.m8666i(TAG, "removeCallbackForceToShow#");
        Handler handler = this.handler;
        if (handler != null) {
            Runnable runnable = this.forceToShowRunnable;
            Intrinsics.checkNotNull(runnable);
            handler.removeCallbacks(runnable);
        }
        this.forceToShowRunnable = null;
    }

    public final void addListener(@NotNull OnSipStateListener stateListener) {
        Intrinsics.checkNotNullParameter(stateListener, "stateListener");
        if (this.onSipStateListeners.contains(stateListener)) {
            return;
        }
        this.onSipStateListeners.add(stateListener);
    }

    public void blockToHide(boolean block, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        SmLogger.m8661d(TAG, "blockToHide# " + block + " cause: " + msg);
    }

    public void blockToShow(boolean block, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        SmLogger.m8661d(TAG, "blockToShow# " + block + " cause: " + msg);
        this.blockingToShow = block;
    }

    public void delayForceToShow(@Nullable View v, long timeout) {
        SmLogger.m8661d(TAG, "delayForceToShow# " + timeout);
        removeCallbackForceToShow();
        this.forceToShowRunnable = new RunnableC0080f(this, v, timeout, 1);
    }

    public void delayHide(@NotNull View v, long delay) {
        Intrinsics.checkNotNullParameter(v, "v");
        SmLogger.m8666i(TAG, "delayHide# " + delay);
        removeCallbackDelayHide();
        RunnableC8515c runnableC8515c = new RunnableC8515c(this, v, 19);
        this.delayHideRunnable = runnableC8515c;
        Handler handler = this.handler;
        if (handler != null) {
            Intrinsics.checkNotNull(runnableC8515c);
            handler.postDelayed(runnableC8515c, delay);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void forceToShow(@Nullable View v, final long timeout) {
        Window window;
        if (this.blockingToShow) {
            SmLogger.m8661d(TAG, "forceToShow# sip is blocked");
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = v;
        if (v == 0) {
            Activity activity = this.activity;
            T currentFocus = (activity == null || (window = activity.getWindow()) == null) ? 0 : window.getCurrentFocus();
            objectRef.element = currentFocus;
            if (currentFocus == 0) {
                SmLogger.m8667w(TAG, "forceToShow# view is null");
                return;
            }
        }
        SmLogger.m8661d(TAG, "forceToShow#");
        InputMethodCompat.Companion companion = InputMethodCompat.INSTANCE;
        if (companion.getInstance().isEnabledMobileKeyboard(this.activity)) {
            InputMethodCompat.showSoftInput$default(companion.getInstance(), this.activity, (View) objectRef.element, false, 4, null);
            return;
        }
        if (InputMethodCompat.showSoftInput$default(companion.getInstance(), this.activity, (View) objectRef.element, false, 4, null)) {
            return;
        }
        this.forceToShowInputTryCount = 1;
        Handler handler = this.handler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.sip.SipController.forceToShow.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CommonUtils.isNotAvailableActivity(SipController.this.activity)) {
                        Logger.m8702i(SipController.TAG, "forceToShow# activity is invalid");
                        return;
                    }
                    AbstractC4539a.m3212v(SipController.this.forceToShowInputTryCount, "forceToShow# delay ", SipController.TAG);
                    if (!InputMethodCompat.showSoftInput$default(InputMethodCompat.INSTANCE.getInstance(), SipController.this.activity, objectRef.element, false, 4, null) && ((long) SipController.this.forceToShowInputTryCount) * 100 < timeout) {
                        SipController.this.forceToShowInputTryCount++;
                        objectRef.element.postDelayed(this, 100L);
                    }
                }
            }, 100L);
        }
    }

    @NotNull
    public final ArrayList<OnSipStateListener> getOnSipStateListeners() {
        return this.onSipStateListeners;
    }

    @NotNull
    public final String getTag() {
        return TAG;
    }

    public void hide(@Nullable View v) {
        SmLogger.m8661d(TAG, "hide# " + this.blockingToHide + " " + v);
        if (v == null || this.blockingToHide) {
            return;
        }
        InputMethodCompat.INSTANCE.getInstance().hideSoftInput(v.getContext(), v);
    }

    public boolean isInputMethodShown() {
        Window window;
        InputMethodCompat.Companion companion = InputMethodCompat.INSTANCE;
        InputMethodCompat companion2 = companion.getInstance();
        Activity activity = this.activity;
        return companion2.isInputMethodShown(activity, (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView(), companion.getInstance().isEnabledMobileKeyboard(this.activity));
    }

    public final void release() {
        this.spenView = null;
        this.onSipStateListeners.clear();
    }

    public final void removeListener(@NotNull OnSipStateListener stateListener) {
        Intrinsics.checkNotNullParameter(stateListener, "stateListener");
        this.onSipStateListeners.remove(stateListener);
    }

    public final void setActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    public final void setHandler(@Nullable Handler handler) {
        this.handler = handler;
    }

    public final void setSpenView(@Nullable View view) {
        this.spenView = view;
    }

    public void show(@Nullable View v) {
        if (this.blockingToShow) {
            SmLogger.m8661d(TAG, "show# sip is blocked");
            return;
        }
        if (v == null) {
            return;
        }
        InputMethodCompat.Companion companion = InputMethodCompat.INSTANCE;
        if (companion.getInstance().isEnabledMobileKeyboard(v.getContext())) {
            InputMethodCompat.showSoftInput$default(companion.getInstance(), v.getContext(), v, false, 4, null);
            return;
        }
        if (SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel() && companion.getInstance().isInputMethodShown(v.getContext(), v, false)) {
            Intent intent = new Intent();
            intent.setAction("imeAction:ShowVirtualKeyboard");
            v.getContext().sendBroadcast(intent);
            LoggerBase.INSTANCE.m7132d(getTag(), "sendBroadcast - " + intent.getAction());
        }
        InputMethodCompat companion2 = companion.getInstance();
        Context context = v.getContext();
        DesktopModeCompat.Companion companion3 = DesktopModeCompat.INSTANCE;
        companion2.showSoftInput(context, v, companion3.getInstance().isDexDualModeOnScreen(v.getContext()) || companion3.getInstance().isDexStandAloneMode(v.getContext()));
    }

    public void show(boolean checkingMobileKeyboard) {
        if (checkingMobileKeyboard) {
            if (InputMethodCompat.INSTANCE.getInstance().isEnabledMobileKeyboard(this.activity)) {
                return;
            }
            show(this.spenView);
            return;
        }
        show(this.spenView);
    }
}
