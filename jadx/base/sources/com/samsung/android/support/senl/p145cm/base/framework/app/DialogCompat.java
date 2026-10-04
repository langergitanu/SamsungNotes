package com.samsung.android.support.senl.p145cm.base.framework.app;

import android.app.Dialog;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsDialogCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.DialogCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ \u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ \u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/DialogCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsDialogCompatImplFactory$IDialogCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsDialogCompatImplFactory$IDialogCompatImpl;)V", "setAnchorView", "", "dialog", "Landroid/app/Dialog;", "anchorView", "Landroid/view/View;", "anchorType", "", "x", "y", "setBlurInfoPopup", "view", "radius", "nightMode", "", "defaultAnchorType", "getDefaultAnchorType", "()I", "toolbarAnchorType", "getToolbarAnchorType", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DialogCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static DialogCompat sInstance;

    @NotNull
    private final AbsDialogCompatImplFactory.IDialogCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/DialogCompat$Companion;", "", "<init>", "()V", "sInstance", "Lcom/samsung/android/support/senl/cm/base/framework/app/DialogCompat;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/app/DialogCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized DialogCompat getInstance() {
            DialogCompat dialogCompat;
            try {
                if (DialogCompat.sInstance == null) {
                    DialogCompat.sInstance = new DialogCompat(new DialogCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                dialogCompat = DialogCompat.sInstance;
                Intrinsics.checkNotNull(dialogCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.app.DialogCompat");
            } catch (Throwable th) {
                throw th;
            }
            return dialogCompat;
        }

        private Companion() {
        }
    }

    public /* synthetic */ DialogCompat(AbsDialogCompatImplFactory.IDialogCompatImpl iDialogCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iDialogCompatImpl);
    }

    public final int getDefaultAnchorType() {
        return this.mImpl.getDefaultAnchorType();
    }

    public final int getToolbarAnchorType() {
        return this.mImpl.getToolbarAnchorType();
    }

    public final void setAnchorView(@Nullable Dialog dialog, @Nullable View anchorView) {
        this.mImpl.setDialogAnchor(dialog, anchorView);
    }

    public final void setBlurInfoPopup(@Nullable View view, int radius, boolean nightMode) {
        this.mImpl.setBlurInfoPopup(view, radius, nightMode);
    }

    private DialogCompat(AbsDialogCompatImplFactory.IDialogCompatImpl iDialogCompatImpl) {
        this.mImpl = iDialogCompatImpl;
    }

    public final void setAnchorView(@Nullable Dialog dialog, @Nullable View anchorView, int anchorType) {
        this.mImpl.setDialogAnchor(dialog, anchorView, anchorType);
    }

    public final void setAnchorView(@Nullable Dialog dialog, int x, int y2) {
        this.mImpl.setDialogAnchor(dialog, x, y2);
    }
}
