package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.listener;

import android.R;
import android.os.Handler;
import android.view.KeyEvent;
import com.samsung.android.sdk.composer.SpenTextWritingView;
import com.samsung.android.sdk.pen.text.SpenSoftInputListener;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.SmShortcutManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.ClipboardController;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001a\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/SoftInputListenerImpl;", "Lcom/samsung/android/sdk/pen/text/SpenSoftInputListener;", "spenView", "Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "handler", "Landroid/os/Handler;", "controlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "shortcutManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/SmShortcutManager;", "<init>", "(Lcom/samsung/android/sdk/composer/SpenTextWritingView;Landroid/os/Handler;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/SmShortcutManager;)V", "sipController", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController;", "clipboardController", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/ClipboardController;", "showSipRunnable", "Ljava/lang/Runnable;", "onShowSoftInput", "", "isShow", "delay", "", "removeShowRunnable", "", "onShowClipboard", "onKeyShortcut", "keycode", "", "keyEvent", "Landroid/view/KeyEvent;", "onPerformContextMenuAction", "actionId", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SoftInputListenerImpl implements SpenSoftInputListener {

    @NotNull
    private static final String TAG = SmLogger.createTag("SoftInputListenerImpl");

    @NotNull
    private final ClipboardController clipboardController;

    @NotNull
    private final Handler handler;

    @NotNull
    private final SmShortcutManager shortcutManager;

    @Nullable
    private Runnable showSipRunnable;

    @NotNull
    private final SipController sipController;

    @NotNull
    private final SpenTextWritingView spenView;

    public SoftInputListenerImpl(@NotNull SpenTextWritingView spenView, @NotNull Handler handler, @NotNull SmControlManager controlManager, @NotNull SmShortcutManager shortcutManager) {
        Intrinsics.checkNotNullParameter(spenView, "spenView");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(controlManager, "controlManager");
        Intrinsics.checkNotNullParameter(shortcutManager, "shortcutManager");
        this.spenView = spenView;
        this.handler = handler;
        this.shortcutManager = shortcutManager;
        this.sipController = controlManager.getSipController();
        this.clipboardController = controlManager.getClipboardController();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onShowSoftInput$lambda$0(SoftInputListenerImpl softInputListenerImpl) {
        softInputListenerImpl.sipController.show(softInputListenerImpl.spenView);
        softInputListenerImpl.showSipRunnable = null;
    }

    private final void removeShowRunnable() {
        Runnable runnable = this.showSipRunnable;
        if (runnable != null) {
            Handler handler = this.handler;
            Intrinsics.checkNotNull(runnable);
            handler.removeCallbacks(runnable);
            this.showSipRunnable = null;
        }
    }

    @Override // com.samsung.android.sdk.pen.text.SpenSoftInputListener
    public boolean onKeyShortcut(int keycode, @Nullable KeyEvent keyEvent) {
        SmShortcutManager smShortcutManager = this.shortcutManager;
        SpenTextWritingView spenTextWritingView = this.spenView;
        Intrinsics.checkNotNull(keyEvent);
        return smShortcutManager.onKey(spenTextWritingView, keycode, keyEvent);
    }

    @Override // com.samsung.android.sdk.pen.text.SpenSoftInputListener
    public boolean onPerformContextMenuAction(int actionId) {
        switch (actionId) {
            case R.id.selectAll:
                return this.shortcutManager.executeSelectAll();
            case R.id.cut:
                return this.shortcutManager.executeCut();
            case R.id.copy:
                return this.shortcutManager.executeCopy();
            case R.id.paste:
                return this.shortcutManager.executePaste();
            default:
                SmLogger.m8662e(TAG, "onPerformContextMenuAction# unsupported id " + actionId);
                return false;
        }
    }

    @Override // com.samsung.android.sdk.pen.text.SpenSoftInputListener
    public boolean onShowClipboard(boolean isShow) {
        this.clipboardController.showClipboard("onShowClipboard");
        return true;
    }

    @Override // com.samsung.android.sdk.pen.text.SpenSoftInputListener
    public boolean onShowSoftInput(boolean isShow) {
        String str = TAG;
        SmLogger.m8666i(str, "onShowSoftInput# isShow: " + isShow);
        if (!isShow) {
            this.sipController.hide(this.spenView);
            return true;
        }
        if (!this.spenView.hasFocus()) {
            SmLogger.m8662e(str, "onShowSoftInput# view has not focus. view: " + this.spenView);
            if (!this.spenView.requestFocus()) {
                SmLogger.m8662e(str, "onShowSoftInput# requestFocus fail. view: " + this.spenView);
                return false;
            }
        }
        if (!this.spenView.hasWindowFocus()) {
            return true;
        }
        RunnableC8669a runnableC8669a = new RunnableC8669a(this, 20);
        this.showSipRunnable = runnableC8669a;
        Handler handler = this.handler;
        Intrinsics.checkNotNull(runnableC8669a);
        handler.postDelayed(runnableC8669a, 300L);
        return false;
    }

    @Override // com.samsung.android.sdk.pen.text.SpenSoftInputListener
    public boolean onShowSoftInput(boolean isShow, long delay) {
        SmLogger.m8666i(TAG, "onShowSoftInput# isShow: " + isShow + ", delay: " + delay);
        removeShowRunnable();
        if (isShow) {
            this.sipController.delayForceToShow(this.spenView, delay);
            return false;
        }
        this.sipController.delayHide(this.spenView, delay);
        return false;
    }
}
