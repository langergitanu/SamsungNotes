package com.samsung.android.support.senl.p148nt.base.winset.app.popover;

import android.app.Dialog;
import android.graphics.Point;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.samsung.android.support.senl.p145cm.base.framework.app.DialogCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J&\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/popover/AlertDialogWrapper;", "", "<init>", "()V", "setAnchorView", "", "dialog", "Landroid/app/Dialog;", "anchorView", "Landroid/view/View;", "anchorType", "", "pos", "Landroid/graphics/Point;", "anchorLayoutStyle", "AnchorType", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AlertDialogWrapper {

    @NotNull
    public static final AlertDialogWrapper INSTANCE = new AlertDialogWrapper();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/popover/AlertDialogWrapper$AnchorType;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AnchorType {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/popover/AlertDialogWrapper$AnchorType$Companion;", "", "<init>", "()V", "DEFAULT", "", "getDEFAULT", "()I", "TOOLBAR", "getTOOLBAR$annotations", "getTOOLBAR", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final int DEFAULT;
            private static final int TOOLBAR;

            static {
                DialogCompat.Companion companion = DialogCompat.INSTANCE;
                DEFAULT = companion.getInstance().getDefaultAnchorType();
                TOOLBAR = companion.getInstance().getToolbarAnchorType();
            }

            private Companion() {
            }

            @JvmStatic
            public static /* synthetic */ void getTOOLBAR$annotations() {
            }

            public final int getDEFAULT() {
                return DEFAULT;
            }

            public final int getTOOLBAR() {
                return TOOLBAR;
            }
        }

        static int getTOOLBAR() {
            return INSTANCE.getTOOLBAR();
        }
    }

    private AlertDialogWrapper() {
    }

    @JvmStatic
    public static final void anchorLayoutStyle(@Nullable Dialog dialog) {
        Window window;
        int dimensionPixelOffset;
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        if (PopOverUtils.isAbleToSetAnchor(dialog.getContext())) {
            dimensionPixelOffset = dialog.getContext().getResources().getDimensionPixelOffset(C8875R.dimen.alert_dialog_popover_shadow);
        } else {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            attributes.gravity = 81;
            window.setAttributes(attributes);
            dimensionPixelOffset = dialog.getContext().getResources().getDimensionPixelOffset(C8875R.dimen.alert_dialog_normal_shadow);
        }
        window.setElevation(dimensionPixelOffset);
    }

    @JvmStatic
    public static final void setAnchorView(@Nullable Dialog dialog, @Nullable View anchorView) {
        if (dialog == null || anchorView == null || !PopOverUtils.isAbleToSetAnchor(dialog.getContext())) {
            return;
        }
        DialogCompat.INSTANCE.getInstance().setAnchorView(dialog, anchorView);
    }

    @JvmStatic
    public static final void setAnchorView(@Nullable Dialog dialog, @Nullable View anchorView, @AnchorType int anchorType) {
        if (dialog == null || anchorView == null || !PopOverUtils.isAbleToSetAnchor(dialog.getContext())) {
            return;
        }
        DialogCompat.INSTANCE.getInstance().setAnchorView(dialog, anchorView, anchorType);
    }

    public final void setAnchorView(@Nullable Dialog dialog, @Nullable Point pos) {
        if (dialog == null || pos == null || !PopOverUtils.isAbleToSetAnchor(dialog.getContext())) {
            return;
        }
        DialogCompat.INSTANCE.getInstance().setAnchorView(dialog, pos.x, pos.y);
    }
}
