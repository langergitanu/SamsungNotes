package com.samsung.android.support.senl.p148nt.stt.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.DialogContract;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p039I2.DialogInterfaceOnClickListenerC0140a;
import p046K2.DialogInterfaceOnClickListenerC0161a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/RemoveTranscriptConfirmDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "presenter", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IRemoveConfirmDialogPresenter;", "(Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IRemoveConfirmDialogPresenter;)V", "mPresenter", "mColor", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "setPresenter", "", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRemoveTranscriptConfirmDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoveTranscriptConfirmDialog.kt\ncom/samsung/android/support/senl/nt/stt/view/dialog/RemoveTranscriptConfirmDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n1#2:54\n*E\n"})
public final class RemoveTranscriptConfirmDialog extends DialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = Logger.createTag("RemoveTranscriptConfirmDialog");
    private int mColor = -1;

    @Nullable
    private DialogContract.IRemoveConfirmDialogPresenter mPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/RemoveTranscriptConfirmDialog$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return RemoveTranscriptConfirmDialog.TAG;
        }

        private Companion() {
        }
    }

    public RemoveTranscriptConfirmDialog() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(RemoveTranscriptConfirmDialog removeTranscriptConfirmDialog, DialogInterface dialogInterface, int i) {
        DialogContract.IRemoveConfirmDialogPresenter iRemoveConfirmDialogPresenter = removeTranscriptConfirmDialog.mPresenter;
        Intrinsics.checkNotNull(iRemoveConfirmDialogPresenter);
        iRemoveConfirmDialogPresenter.remove();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$3(RemoveTranscriptConfirmDialog removeTranscriptConfirmDialog, AlertDialog alertDialog, DialogInterface dialogInterface) {
        if (removeTranscriptConfirmDialog.mColor != -1) {
            alertDialog.getButton(-1).setTextColor(removeTranscriptConfirmDialog.mColor);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Resources resources;
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext(), 0, 2, null).setTitle(C11493R.string.remove_transcribe_q).setMessage(C11493R.string.remove_transcribe_confirm).setPositiveButton(C11493R.string.remove, new DialogInterfaceOnClickListenerC0161a(this, 14)).setNegativeButton(C11493R.string.composer_cancel, new DialogInterfaceOnClickListenerC0140a(25)).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        Context context = getContext();
        if (context != null && (resources = context.getResources()) != null) {
            this.mColor = resources.getColor(C11493R.color.text_error_color, null);
        }
        alertDialogCreate.setOnShowListener(new DialogInterfaceOnShowListenerC11557c(this, alertDialogCreate, 0));
        return alertDialogCreate;
    }

    public final void setPresenter(@Nullable DialogContract.IRemoveConfirmDialogPresenter presenter) {
        this.mPresenter = presenter;
    }

    public RemoveTranscriptConfirmDialog(@Nullable DialogContract.IRemoveConfirmDialogPresenter iRemoveConfirmDialogPresenter) {
        this.mPresenter = iRemoveConfirmDialogPresenter;
    }
}
