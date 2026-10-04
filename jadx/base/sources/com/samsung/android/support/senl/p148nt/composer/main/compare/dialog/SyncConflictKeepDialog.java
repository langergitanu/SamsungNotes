package com.samsung.android.support.senl.p148nt.composer.main.compare.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.compare.dialog.SyncConflictKeepDialog;
import com.samsung.android.support.senl.p148nt.composer.main.compare.presenter.CompareViewerContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0017J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/dialog/SyncConflictKeepDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IDialog;", "<init>", "()V", "mPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IPresenter;", "mAlertDialogBuilder", "Lcom/samsung/android/support/senl/nt/base/winset/builder/AlertDialogBuilderForAppCompat;", "mAlertDialog", "Landroidx/appcompat/app/AlertDialog;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "setPresenter", "", "presenter", "showDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "onClickOk", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SyncConflictKeepDialog extends DialogFragment implements CompareViewerContract.IDialog {

    @NotNull
    private static final String TAG = "SyncConflictKeepDialog";

    @Nullable
    private AlertDialog mAlertDialog;

    @Nullable
    private AlertDialogBuilderForAppCompat mAlertDialogBuilder;

    @Nullable
    private CompareViewerContract.IPresenter mPresenter;

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClickOk() {
        CompareViewerContract.IPresenter iPresenter = this.mPresenter;
        if (iPresenter != null) {
            iPresenter.onClickOK(getTag());
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @SuppressLint({"InflateParams"})
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(getActivity(), 0, 2, null);
        this.mAlertDialogBuilder = alertDialogBuilderForAppCompat;
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mAlertDialog = alertDialogCreate;
        if (alertDialogCreate != null) {
            alertDialogCreate.setCancelable(false);
        }
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            int i = C9086R.string.only_selected_note_will_be_kept;
            CompareViewerContract.IPresenter iPresenter = this.mPresenter;
            alertDialog.setMessage(getString(i, iPresenter != null ? iPresenter.getDeviceName(getTag()) : null));
        }
        AlertDialog alertDialog2 = this.mAlertDialog;
        if (alertDialog2 != null) {
            final int i2 = 0;
            alertDialog2.setButton(-2, getString(C9086R.string.dialog_cancel), new DialogInterface.OnClickListener(this) { // from class: x3.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SyncConflictKeepDialog f10343b;

                {
                    this.f10343b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    switch (i2) {
                        case 0:
                            this.f10343b.dismiss();
                            break;
                        default:
                            this.f10343b.onClickOk();
                            break;
                    }
                }
            });
        }
        AlertDialog alertDialog3 = this.mAlertDialog;
        if (alertDialog3 != null) {
            final int i4 = 1;
            alertDialog3.setButton(-1, getString(C9086R.string.dialog_ok), new DialogInterface.OnClickListener(this) { // from class: x3.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SyncConflictKeepDialog f10343b;

                {
                    this.f10343b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i42) {
                    switch (i4) {
                        case 0:
                            this.f10343b.dismiss();
                            break;
                        default:
                            this.f10343b.onClickOk();
                            break;
                    }
                }
            });
        }
        AlertDialog alertDialog4 = this.mAlertDialog;
        Intrinsics.checkNotNull(alertDialog4, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        return alertDialog4;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IDialog
    public void setPresenter(@Nullable CompareViewerContract.IPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IDialog
    public void showDialog(@NotNull FragmentManager fragmentManager, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (isAdded()) {
            return;
        }
        show(fragmentManager, tag);
    }
}
