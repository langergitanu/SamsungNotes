package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.listener;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sdk.pen.engine.SpenTouchListener;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmQuickSaveControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/SpenPreTouchListenerImpl;", "Lcom/samsung/android/sdk/pen/engine/SpenTouchListener;", "quickSaveControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmQuickSaveControl;", "toolShareControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmQuickSaveControl;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl;)V", "onTouch", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "release", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenPreTouchListenerImpl implements SpenTouchListener {

    @Nullable
    private SmQuickSaveControl quickSaveControl;

    @Nullable
    private ToolShareControl toolShareControl;

    public SpenPreTouchListenerImpl(@Nullable SmQuickSaveControl smQuickSaveControl, @Nullable ToolShareControl toolShareControl) {
        this.quickSaveControl = smQuickSaveControl;
        this.toolShareControl = toolShareControl;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002e  */
    @Override // com.samsung.android.sdk.pen.engine.SpenTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(@Nullable View view, @Nullable MotionEvent event) {
        if (event == null) {
            return false;
        }
        ToolShareControl toolShareControl = this.toolShareControl;
        if (toolShareControl != null) {
            Intrinsics.checkNotNull(view);
            if (toolShareControl.deliveryPreTouch(view, event)) {
                return true;
            }
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            SmQuickSaveControl smQuickSaveControl = this.quickSaveControl;
            if (smQuickSaveControl != null) {
                smQuickSaveControl.lock("SmHwTouchDown");
            }
        } else if (actionMasked == 1) {
            SmQuickSaveControl smQuickSaveControl2 = this.quickSaveControl;
            if (smQuickSaveControl2 != null) {
                smQuickSaveControl2.unlock("SmHwTouchUp");
            }
        } else if (actionMasked != 211) {
            if (actionMasked == 212) {
            }
        }
        return false;
    }

    public final void release() {
        this.quickSaveControl = null;
        this.toolShareControl = null;
    }
}
