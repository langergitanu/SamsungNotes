package com.samsung.android.support.senl.p145cm.base.framework.sem.app;

import android.app.Dialog;
import android.graphics.Color;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsDialogCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.view.SemBlurInfoCompat;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/DialogCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsDialogCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsDialogCompatImplFactory$IDialogCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "DialogCompatSemImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DialogCompatImplFactory extends AbsDialogCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\"\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0013\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/DialogCompatImplFactory$DialogCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsDialogCompatImplFactory$IDialogCompatImpl;", "<init>", "()V", "setDialogAnchor", "", "dialog", "Landroid/app/Dialog;", "anchorView", "Landroid/view/View;", "anchorType", "", "x", "y", "setBlurInfoPopup", "view", "radius", "nightMode", "", "defaultAnchorType", "getDefaultAnchorType", "()I", "toolbarAnchorType", "getToolbarAnchorType", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nDialogCompatImplFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DialogCompatImplFactory.kt\ncom/samsung/android/support/senl/cm/base/framework/sem/app/DialogCompatImplFactory$DialogCompatSemImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
    public static final class DialogCompatSemImpl implements AbsDialogCompatImplFactory.IDialogCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsDialogCompatImplFactory.IDialogCompatImpl
        public int getDefaultAnchorType() {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsDialogCompatImplFactory.IDialogCompatImpl
        public int getToolbarAnchorType() {
            return 1;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsDialogCompatImplFactory.IDialogCompatImpl
        public void setBlurInfoPopup(@Nullable View view, int radius, boolean nightMode) {
            if (view != null) {
                SemBlurInfoCompat.Builder builder = new SemBlurInfoCompat.Builder(0);
                view.semSetBlurInfo(nightMode ? builder.setColorCurvePreset(125).setBackgroundColor(Color.parseColor("#1AFFFFFF")).setBackgroundCornerRadius(radius).build() : builder.setColorCurvePreset(110).setBackgroundCornerRadius(radius).build());
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsDialogCompatImplFactory.IDialogCompatImpl
        public void setDialogAnchor(@Nullable Dialog dialog, @Nullable View anchorView) {
            if (anchorView == null || dialog == null) {
                return;
            }
            dialog.semSetAnchor(anchorView);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsDialogCompatImplFactory.IDialogCompatImpl
        public void setDialogAnchor(@Nullable Dialog dialog, @Nullable View anchorView, int anchorType) {
            if (anchorView == null || dialog == null) {
                return;
            }
            dialog.semSetAnchor(anchorView, anchorType);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsDialogCompatImplFactory.IDialogCompatImpl
        public void setDialogAnchor(@Nullable Dialog dialog, int x, int y2) {
            if (dialog != null) {
                dialog.semSetAnchor(x, y2);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsDialogCompatImplFactory
    @NotNull
    public AbsDialogCompatImplFactory.IDialogCompatImpl create(int deviceType) {
        return (deviceType == 2 || deviceType == 3) ? new DialogCompatSemImpl() : super.create(deviceType);
    }
}
