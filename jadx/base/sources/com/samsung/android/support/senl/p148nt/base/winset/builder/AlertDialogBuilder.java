package com.samsung.android.support.senl.p148nt.base.winset.builder;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AlertDialog;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\tH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\u0006\u0010\u0010\u001a\u00020\u0011R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000f¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/builder/AlertDialogBuilder;", "Landroidx/appcompat/app/AlertDialog$Builder;", "context", "Landroid/content/Context;", BaseWidgetConstant.WIDGET_THEME, "", "<init>", "(Landroid/content/Context;I)V", "mDialog", "Landroidx/appcompat/app/AlertDialog;", "mMinLength", "create", Constants.IntentExtraValue.SHOW, "isShowing", "", "()Z", "dismiss", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AlertDialogBuilder extends AlertDialog.Builder {

    @NotNull
    private static final String TAG = "AlertDialogBuilder";

    @Nullable
    private AlertDialog mDialog;
    private int mMinLength;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AlertDialogBuilder(@NotNull Context context) {
        this(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NotNull
    public AlertDialog create() {
        Logger.m8697d(TAG, "create");
        AlertDialog alertDialogCreate = super.create();
        this.mDialog = alertDialogCreate;
        Window window = alertDialogCreate != null ? alertDialogCreate.getWindow() : null;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(window != null ? window.getAttributes() : null);
        layoutParams.width = this.mMinLength;
        if (window != null) {
            window.setAttributes(layoutParams);
        }
        if (window != null) {
            window.setBackgroundDrawableResource(C8875R.drawable.alertdialog_bg);
        }
        AlertDialog alertDialog = this.mDialog;
        Intrinsics.checkNotNull(alertDialog, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        return alertDialog;
    }

    public final void dismiss() {
        AbstractC4539a.m3188B("try dismiss ", Integer.toHexString(hashCode()), TAG);
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog == null || alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        AlertDialog alertDialog2 = this.mDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        Logger.m8697d(TAG, "dismiss done!!!");
    }

    public final boolean isShowing() {
        AlertDialog alertDialog = this.mDialog;
        return alertDialog != null && alertDialog.isShowing();
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @Nullable
    public AlertDialog show() {
        AbstractC4539a.m3188B("show : ", Integer.toHexString(hashCode()), TAG);
        AlertDialog alertDialogShow = super.show();
        this.mDialog = alertDialogShow;
        return alertDialogShow;
    }

    public /* synthetic */ AlertDialogBuilder(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? C8875R.style.Notes_AlertDialogTheme : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AlertDialogBuilder(@NotNull Context context, int i) {
        float fConvertDpToPixel;
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.m8697d(TAG, "AlertDialogBuilder(Context context, int theme)");
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        int i4 = context.getResources().getDisplayMetrics().widthPixels;
        if (i4 < i2) {
            fConvertDpToPixel = ResourceUtils.convertDpToPixel(context, 29.0f);
        } else {
            fConvertDpToPixel = ResourceUtils.convertDpToPixel(context, 124.0f);
        }
        int i5 = i4 - ((int) (fConvertDpToPixel * 2));
        this.mMinLength = i5;
        AbstractC4539a.m3203m(i5, "mMinLength = ", TAG);
    }
}
