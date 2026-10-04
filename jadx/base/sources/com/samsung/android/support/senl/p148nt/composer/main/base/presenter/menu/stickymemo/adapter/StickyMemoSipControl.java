package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.adapter;

import android.view.View;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\r\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/adapter/StickyMemoSipControl;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager$OnSipListener;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager$SipVisibilityListener;", "sip", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager;)V", Constants.IntentExtraValue.SHOW, "", VPathDataCmd.RCurveTo, "Landroid/view/View;", "hide", "delayForceToShow", "timeout", "", "forceToShow", "delayHide", "delay", "blockToShow", "block", "", "msg", "", "blockToHide", "isInputMethodShown", "checkingMobileKeyboard", "onShow", "onHide", "onSipVisibilityChanged", "isVisible", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StickyMemoSipControl extends SipController implements SoftInputManager.OnSipListener, SoftInputManager.SipVisibilityListener {

    @NotNull
    private final SoftInputManager sip;

    public StickyMemoSipControl(@NotNull SoftInputManager sip) {
        Intrinsics.checkNotNullParameter(sip, "sip");
        this.sip = sip;
        sip.addOnSipListener(this);
        sip.setSipVisibilityListener(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController
    public void blockToHide(boolean block, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.sip.blockToHide(block);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController
    public void blockToShow(boolean block, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.sip.blockToShow(block, msg);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController
    public void delayForceToShow(@Nullable View v, long timeout) {
        this.sip.delayForceToShow(v, timeout);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController
    public void delayHide(@NotNull View v, long delay) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.sip.delayHide(v, delay);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController
    public void forceToShow(@Nullable View v, long timeout) {
        this.sip.forceToShow(v, timeout);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController
    public void hide(@Nullable View v) {
        this.sip.hide(v);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController
    public boolean isInputMethodShown() {
        return this.sip.isInputMethodShown();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
    public void onHide() {
        Iterator<SipController.OnSipStateListener> it = getOnSipStateListeners().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SipController.OnSipStateListener next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onSipHide();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
    public void onShow() {
        Iterator<SipController.OnSipStateListener> it = getOnSipStateListeners().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SipController.OnSipStateListener next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onSipShow();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.SipVisibilityListener
    public void onSipVisibilityChanged(boolean isVisible) {
        Iterator<SipController.OnSipStateListener> it = getOnSipStateListeners().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SipController.OnSipStateListener next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onSipVisibilityChanged(isVisible);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController
    public void show(@Nullable View v) {
        this.sip.setTemporarySoftInputMode(16);
        this.sip.show(v);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController
    public void show(boolean checkingMobileKeyboard) {
        this.sip.show(checkingMobileKeyboard);
    }
}
