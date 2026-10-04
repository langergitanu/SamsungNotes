package com.samsung.android.support.senl.p148nt.base.winset.app.dialog;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p054M1.DialogInterfaceOnClickListenerC0174a;
import p054M1.DialogInterfaceOnDismissListenerC0177d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eJ\u0018\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0003J\u0010\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012J\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/ConfirmDialog;", "", "title", "", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getContent", "setContent", "mButtonId", "", "mConfirmSAParam", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/NotesSamsungAnalytics$LogParam;", "mDismissRunnable", "Ljava/lang/Runnable;", "setButtonId", "", "resId", "setConfirmSamsungAnalytics", "screenID", "event", "setPostRunnable", "run", "buildDialog", "Lcom/samsung/android/support/senl/nt/base/winset/builder/AlertDialogBuilderForAppCompat;", "context", "Landroid/content/Context;", "onClickListener", "Landroid/content/DialogInterface$OnClickListener;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ConfirmDialog {

    @Nullable
    private String content;
    private int mButtonId;

    @Nullable
    private NotesSamsungAnalytics.LogParam mConfirmSAParam;

    @Nullable
    private Runnable mDismissRunnable;

    @NotNull
    private String title;

    public ConfirmDialog(@NotNull String title, @Nullable String str) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.content = str;
        this.mButtonId = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildDialog$lambda$0(ConfirmDialog confirmDialog, DialogInterface.OnClickListener onClickListener, DialogInterface dialogInterface, int i) {
        NotesSamsungAnalytics.LogParam logParam = confirmDialog.mConfirmSAParam;
        if (logParam != null && logParam != null) {
            logParam.insertLog();
        }
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i);
        } else {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildDialog$lambda$1(ConfirmDialog confirmDialog, DialogInterface dialogInterface) {
        Runnable runnable = confirmDialog.mDismissRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }

    @NotNull
    public final AlertDialogBuilderForAppCompat buildDialog(@Nullable Context context, @Nullable DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder cancelable = new AlertDialogBuilderForAppCompat(context, 0, 2, null).setMessage(this.content).setTitle(this.title).setCancelable(true);
        int i = this.mButtonId;
        if (i == -1) {
            i = C8875R.string.f6384OK;
        }
        AlertDialog.Builder positiveButton = cancelable.setPositiveButton(i, new DialogInterfaceOnClickListenerC0174a(this, onClickListener, 6));
        Intrinsics.checkNotNull(positiveButton, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.winset.builder.AlertDialogBuilderForAppCompat");
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = (AlertDialogBuilderForAppCompat) positiveButton;
        if (this.mDismissRunnable != null) {
            alertDialogBuilderForAppCompat.setOnDismissListener(new DialogInterfaceOnDismissListenerC0177d(this, 5));
        }
        return alertDialogBuilderForAppCompat;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final void setButtonId(int resId) {
        this.mButtonId = resId;
    }

    public final void setConfirmSamsungAnalytics(@Nullable String screenID, @NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.mConfirmSAParam = new NotesSamsungAnalytics.LogParam(screenID, event);
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setPostRunnable(@Nullable Runnable run) {
        this.mDismissRunnable = run;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
