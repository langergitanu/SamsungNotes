package com.samsung.android.support.senl.p148nt.base.common.data;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/SynonymCreateDbDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "mListener", "Lcom/samsung/android/support/senl/nt/base/common/data/SynonymCreateDbDialog$OnClickListener;", "getMListener", "()Lcom/samsung/android/support/senl/nt/base/common/data/SynonymCreateDbDialog$OnClickListener;", "setMListener", "(Lcom/samsung/android/support/senl/nt/base/common/data/SynonymCreateDbDialog$OnClickListener;)V", "setOnClickListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "showAllowingStateLoss", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "OnClickListener", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SynonymCreateDbDialog extends DialogFragment {

    @NotNull
    public static final String TAG = "SynonymCreateDbDialog";

    @Nullable
    private OnClickListener mListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/SynonymCreateDbDialog$OnClickListener;", "", "onConfirmCreate", "", "onConfirmShow", "onConfirmDelete", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnClickListener {
        void onConfirmCreate();

        void onConfirmDelete();

        void onConfirmShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(SynonymCreateDbDialog synonymCreateDbDialog, DialogInterface dialogInterface, int i) {
        OnClickListener onClickListener = synonymCreateDbDialog.mListener;
        Intrinsics.checkNotNull(onClickListener);
        onClickListener.onConfirmCreate();
        synonymCreateDbDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(SynonymCreateDbDialog synonymCreateDbDialog, DialogInterface dialogInterface, int i) {
        OnClickListener onClickListener = synonymCreateDbDialog.mListener;
        Intrinsics.checkNotNull(onClickListener);
        onClickListener.onConfirmShow();
        synonymCreateDbDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$2(SynonymCreateDbDialog synonymCreateDbDialog, DialogInterface dialogInterface, int i) {
        OnClickListener onClickListener = synonymCreateDbDialog.mListener;
        Intrinsics.checkNotNull(onClickListener);
        onClickListener.onConfirmDelete();
        synonymCreateDbDialog.dismiss();
    }

    @Nullable
    public final OnClickListener getMListener() {
        return this.mListener;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final int i = 0;
        AlertDialog.Builder positiveButton = new AlertDialogBuilderForAppCompat(getActivity(), 0, 2, null).setTitle("Synonym Tester").setPositiveButton("create data", new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.base.common.data.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SynonymCreateDbDialog f6440b;

            {
                this.f6440b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                switch (i) {
                    case 0:
                        SynonymCreateDbDialog.onCreateDialog$lambda$0(this.f6440b, dialogInterface, i2);
                        break;
                    case 1:
                        SynonymCreateDbDialog.onCreateDialog$lambda$1(this.f6440b, dialogInterface, i2);
                        break;
                    default:
                        SynonymCreateDbDialog.onCreateDialog$lambda$2(this.f6440b, dialogInterface, i2);
                        break;
                }
            }
        });
        final int i2 = 1;
        AlertDialog.Builder neutralButton = positiveButton.setNeutralButton("show data", new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.base.common.data.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SynonymCreateDbDialog f6440b;

            {
                this.f6440b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i22) {
                switch (i2) {
                    case 0:
                        SynonymCreateDbDialog.onCreateDialog$lambda$0(this.f6440b, dialogInterface, i22);
                        break;
                    case 1:
                        SynonymCreateDbDialog.onCreateDialog$lambda$1(this.f6440b, dialogInterface, i22);
                        break;
                    default:
                        SynonymCreateDbDialog.onCreateDialog$lambda$2(this.f6440b, dialogInterface, i22);
                        break;
                }
            }
        });
        final int i4 = 2;
        AlertDialog alertDialogCreate = neutralButton.setNegativeButton("delete data", new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.base.common.data.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SynonymCreateDbDialog f6440b;

            {
                this.f6440b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i22) {
                switch (i4) {
                    case 0:
                        SynonymCreateDbDialog.onCreateDialog$lambda$0(this.f6440b, dialogInterface, i22);
                        break;
                    case 1:
                        SynonymCreateDbDialog.onCreateDialog$lambda$1(this.f6440b, dialogInterface, i22);
                        break;
                    default:
                        SynonymCreateDbDialog.onCreateDialog$lambda$2(this.f6440b, dialogInterface, i22);
                        break;
                }
            }
        }).setCancelable(true).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        return alertDialogCreate;
    }

    public final void setMListener(@Nullable OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    public final void setOnClickListener(@Nullable OnClickListener listener) {
        this.mListener = listener;
    }

    public final void showAllowingStateLoss(@Nullable FragmentManager fragmentManager, @Nullable String tag) {
        if (fragmentManager == null || fragmentManager.isDestroyed()) {
            return;
        }
        fragmentManager.beginTransaction().add(this, tag).commitAllowingStateLoss();
    }
}
