package com.samsung.android.support.senl.p148nt.app.common.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/dialog/RestoreCheckMobileDataDialogFragment;", "Lcom/samsung/android/support/senl/nt/base/winset/view/AbsDialogFragment;", "mUuid", "", "<init>", "(Ljava/lang/String;)V", "mDialogListener", "Lcom/samsung/android/support/senl/nt/app/common/dialog/RestoreCheckMobileDataDialogFragment$DialogListener;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "", "outState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "setDialogListener", "dialogListener", "DialogListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RestoreCheckMobileDataDialogFragment extends AbsDialogFragment {

    @NotNull
    private static final String TAG = "RestoreCheckMobileDataDialogFragment";

    @Nullable
    private DialogListener mDialogListener;

    @Nullable
    private String mUuid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/dialog/RestoreCheckMobileDataDialogFragment$DialogListener;", "", "onConfirm", "", "uuid", "", "onCancel", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface DialogListener {
        void onCancel();

        void onConfirm(@Nullable String uuid);
    }

    public RestoreCheckMobileDataDialogFragment(@Nullable String str) {
        this.mUuid = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(RestoreCheckMobileDataDialogFragment restoreCheckMobileDataDialogFragment, DialogInterface dialogInterface, int i) {
        restoreCheckMobileDataDialogFragment.dismiss();
        DialogListener dialogListener = restoreCheckMobileDataDialogFragment.mDialogListener;
        if (dialogListener == null) {
            MainLogger.m7255e(TAG, "onCreateDialog: DialogListener is null");
        } else if (dialogListener != null) {
            dialogListener.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(RestoreCheckMobileDataDialogFragment restoreCheckMobileDataDialogFragment, DialogInterface dialogInterface, int i) {
        restoreCheckMobileDataDialogFragment.dismiss();
        DialogListener dialogListener = restoreCheckMobileDataDialogFragment.mDialogListener;
        if (dialogListener == null) {
            MainLogger.m7255e(TAG, "onCreateDialog: DialogListener is null");
        } else if (dialogListener != null) {
            dialogListener.onConfirm(restoreCheckMobileDataDialogFragment.mUuid);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.mUuid = savedInstanceState.getString("sdocx_uuid");
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext(), 0, 2, null).create();
        alertDialogCreate.setCancelable(true);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setTitle(getString(C8003R.string.restore_corrupt_note_with_mobile_data_title));
        alertDialogCreate.setMessage(getString(C8003R.string.restore_corrupt_note_with_mobile_data_message));
        final int i = 0;
        alertDialogCreate.setButton(-2, getString(C8003R.string.dialog_cancel), new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.common.dialog.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ RestoreCheckMobileDataDialogFragment f6066b;

            {
                this.f6066b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                switch (i) {
                    case 0:
                        RestoreCheckMobileDataDialogFragment.onCreateDialog$lambda$0(this.f6066b, dialogInterface, i2);
                        break;
                    default:
                        RestoreCheckMobileDataDialogFragment.onCreateDialog$lambda$1(this.f6066b, dialogInterface, i2);
                        break;
                }
            }
        });
        final int i2 = 1;
        alertDialogCreate.setButton(-1, getString(C8003R.string.f6004OK), new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.common.dialog.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ RestoreCheckMobileDataDialogFragment f6066b;

            {
                this.f6066b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i22) {
                switch (i2) {
                    case 0:
                        RestoreCheckMobileDataDialogFragment.onCreateDialog$lambda$0(this.f6066b, dialogInterface, i22);
                        break;
                    default:
                        RestoreCheckMobileDataDialogFragment.onCreateDialog$lambda$1(this.f6066b, dialogInterface, i22);
                        break;
                }
            }
        });
        return alertDialogCreate;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString("sdocx_uuid", this.mUuid);
    }

    public final void setDialogListener(@Nullable DialogListener dialogListener) {
        this.mDialogListener = dialogListener;
    }
}
