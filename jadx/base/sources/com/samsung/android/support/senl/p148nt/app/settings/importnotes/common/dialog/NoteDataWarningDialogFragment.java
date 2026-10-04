package com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.dialog.ImportDialogResultListener;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/dialog/NoteDataWarningDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/DialogInterface$OnClickListener;", "<init>", "()V", "mResultListener", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/dialog/ImportDialogResultListener$NoteDataWarning;", "setData", "", "type", "", "size", "", "setOnResultListener", "l", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "getTypeString", "", "showAllowingStateLoss", "fm", "Landroidx/fragment/app/FragmentManager;", "tag", "onClick", "dialog", "Landroid/content/DialogInterface;", "which", "onCancel", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NoteDataWarningDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    @NotNull
    private static final String KEY_DATA_SIZE = "key_data_size";

    @NotNull
    private static final String KEY_TYPE_MEMO = "key_type_memo";

    @NotNull
    public static final String TAG = "NoteDataWarningDialogFragment";

    @Nullable
    private ImportDialogResultListener.NoteDataWarning mResultListener;

    private final String getTypeString(int type) {
        String string = getString(type == 200 ? C8003R.string.settings_import_memo_data : C8003R.string.settings_import_scrapbook_data);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        ImportDialogResultListener.NoteDataWarning noteDataWarning = this.mResultListener;
        Intrinsics.checkNotNull(noteDataWarning);
        noteDataWarning.onCancel();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(@NotNull DialogInterface dialog, int which) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (which == -2) {
            CommonSamsungAnalytics.INSTANCE.insertLog("743", "7431");
            onCancel(dialog);
        } else {
            if (which != -1) {
                return;
            }
            CommonSamsungAnalytics.INSTANCE.insertLog("743", "7432");
            ImportDialogResultListener.NoteDataWarning noteDataWarning = this.mResultListener;
            Intrinsics.checkNotNull(noteDataWarning);
            noteDataWarning.onConfirm();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        int i = 200;
        double d = 100.0d;
        if (arguments != null) {
            i = arguments.getInt(KEY_TYPE_MEMO, 200);
            d = arguments.getDouble(KEY_DATA_SIZE, 100.0d);
        }
        String string = getString(C8003R.string.settings_import_note_data_warning_message_pss, new DecimalFormat("#.#").format(d), "MB", getTypeString(i));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        View viewInflate = getLayoutInflater().inflate(C8003R.layout.import_note_data_warning, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(C8003R.id.note_warning_message);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById).setText(string);
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext(), 0, 2, null).setNegativeButton(C8003R.string.dialog_cancel, this).setPositiveButton(C8003R.string.dialog_continue, this).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.setView(viewInflate);
        alertDialogCreate.setCancelable(true);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        return alertDialogCreate;
    }

    public final void setData(int type, double size) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_TYPE_MEMO, type);
        bundle.putDouble(KEY_DATA_SIZE, size);
        setArguments(bundle);
    }

    public final void setOnResultListener(@Nullable ImportDialogResultListener.NoteDataWarning l) {
        this.mResultListener = l;
    }

    public final void showAllowingStateLoss(@Nullable FragmentManager fm, @Nullable String tag) {
        if (fm == null || fm.isDestroyed()) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fm.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        fragmentTransactionBeginTransaction.add(this, tag);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}
