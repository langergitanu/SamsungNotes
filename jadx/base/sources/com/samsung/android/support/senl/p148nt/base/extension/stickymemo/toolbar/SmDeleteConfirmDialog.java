package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.toolbar;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p039I2.DialogInterfaceOnClickListenerC0140a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmDeleteConfirmDialog;", "", "<init>", "()V", "confirmDialog", "Landroidx/appcompat/app/AlertDialog;", "createDialog", "context", "Landroid/content/Context;", "deleteClickListener", "Landroid/content/DialogInterface$OnClickListener;", "showDialog", "", "isShowing", "", "dismiss", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmDeleteConfirmDialog {

    @Nullable
    private AlertDialog confirmDialog;

    private final AlertDialog createDialog(Context context, final DialogInterface.OnClickListener deleteClickListener) {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context, 0, 2, null);
        alertDialogBuilderForAppCompat.setMessage(C8875R.string.sticky_memo_more_delete_confirm_message);
        alertDialogBuilderForAppCompat.setPositiveButton(C8875R.string.action_delete, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.toolbar.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SmDeleteConfirmDialog.createDialog$lambda$0(deleteClickListener, dialogInterface, i);
            }
        });
        alertDialogBuilderForAppCompat.setNegativeButton(C8875R.string.string_cancel, new DialogInterfaceOnClickListenerC0140a(9));
        alertDialogBuilderForAppCompat.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.toolbar.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f6470a.confirmDialog = null;
            }
        });
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.confirmDialog = alertDialogCreate;
        Intrinsics.checkNotNull(alertDialogCreate);
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$0(DialogInterface.OnClickListener onClickListener, DialogInterface dialogInterface, int i) {
        onClickListener.onClick(dialogInterface, i);
        dialogInterface.dismiss();
    }

    public final void dismiss() {
        AlertDialog alertDialog = this.confirmDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final boolean isShowing() {
        AlertDialog alertDialog = this.confirmDialog;
        return alertDialog != null && alertDialog.isShowing();
    }

    public final void showDialog(@NotNull Context context, @NotNull DialogInterface.OnClickListener deleteClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deleteClickListener, "deleteClickListener");
        if (isShowing()) {
            return;
        }
        createDialog(context, deleteClickListener).show();
    }
}
