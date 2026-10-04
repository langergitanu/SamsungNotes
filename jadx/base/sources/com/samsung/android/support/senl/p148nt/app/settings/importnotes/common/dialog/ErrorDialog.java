package com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.dialog;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.Dialog;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p039I2.DialogInterfaceOnClickListenerC0140a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/dialog/ErrorDialog;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/dialog/Dialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mAlertDialog", "Landroidx/appcompat/app/AlertDialog;", Constants.IntentExtraValue.SHOW, "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ErrorDialog extends Dialog {

    @Nullable
    private final AlertDialog mAlertDialog;

    public ErrorDialog(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context, 0, 2, null);
        alertDialogBuilderForAppCompat.setPositiveButton(context.getResources().getString(C8003R.string.sync_network_dialog_btn_ok), new DialogInterfaceOnClickListenerC0140a(3));
        alertDialogBuilderForAppCompat.setTitle(C8003R.string.sync_import_dialog_server_error_title);
        alertDialogBuilderForAppCompat.setMessage(C8003R.string.sync_import_dialog_server_error);
        this.mAlertDialog = alertDialogBuilderForAppCompat.create();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.Dialog, com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialog
    public void show() {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
    }
}
