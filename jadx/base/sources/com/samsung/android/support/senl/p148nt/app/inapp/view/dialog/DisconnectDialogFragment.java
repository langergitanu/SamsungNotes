package com.samsung.android.support.senl.p148nt.app.inapp.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0002\u0011\u0012B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/dialog/DisconnectDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/DialogInterface$OnClickListener;", "mContract", "Lcom/samsung/android/support/senl/nt/app/inapp/view/dialog/DisconnectDialogFragment$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/inapp/view/dialog/DisconnectDialogFragment$Contract;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DisconnectDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    @NotNull
    public static final String TAG = "DisconnectDialogFragment";

    @Nullable
    private final Contract mContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/dialog/DisconnectDialogFragment$Contract;", "", "onPositiveButton", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onPositiveButton();
    }

    public DisconnectDialogFragment(@Nullable Contract contract) {
        this.mContract = contract;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(@NotNull DialogInterface dialog, int which) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        if (which == -2) {
            dismissAllowingStateLoss();
        } else {
            if (which == -1) {
                contract.onPositiveButton();
                return;
            }
            InAppLogger.m8596e(TAG, "unexpected button type: " + which);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext(), 0, 2, null).setMessage(C8003R.string.in_app_client_disconnect_dialog_msg).setNegativeButton(C8003R.string.cancel_btn, (DialogInterface.OnClickListener) null).setPositiveButton(C8003R.string.f6004OK, this).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        return alertDialogCreate;
    }
}
