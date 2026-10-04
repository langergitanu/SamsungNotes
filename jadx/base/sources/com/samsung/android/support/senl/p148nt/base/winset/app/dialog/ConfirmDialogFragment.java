package com.samsung.android.support.senl.p148nt.base.winset.app.dialog;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p039I2.DialogInterfaceOnClickListenerC0140a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0018\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/ConfirmDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "mAlertDialog", "Landroidx/appcompat/app/AlertDialog;", "mDialog", "Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/ConfirmDialog;", "newInstance", "title", "", "content", "setConfirmSamsungAnalytics", "", "screenID", "event", "setPostRunnable", "run", "Ljava/lang/Runnable;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onStart", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nConfirmDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfirmDialogFragment.kt\ncom/samsung/android/support/senl/nt/base/winset/app/dialog/ConfirmDialogFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,62:1\n1#2:63\n*E\n"})
public final class ConfirmDialogFragment extends DialogFragment {

    @NotNull
    private static final String KEY_CONTENT = "content";

    @NotNull
    private static final String KEY_TITLE = "title";

    @Nullable
    private AlertDialog mAlertDialog;

    @Nullable
    private ConfirmDialog mDialog;

    @NotNull
    public final ConfirmDialogFragment newInstance(@Nullable String title, @Nullable String content) {
        ConfirmDialogFragment confirmDialogFragment = new ConfirmDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("content", content);
        confirmDialogFragment.setArguments(bundle);
        return confirmDialogFragment;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        ConfirmDialog confirmDialog;
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompatBuildDialog;
        String string;
        Bundle arguments = getArguments();
        AlertDialog alertDialogCreate = null;
        if (arguments == null || (string = arguments.getString("title")) == null) {
            confirmDialog = null;
        } else {
            Bundle arguments2 = getArguments();
            String string2 = arguments2 != null ? arguments2.getString("content") : null;
            Intrinsics.checkNotNull(string2);
            confirmDialog = new ConfirmDialog(string, string2);
        }
        this.mDialog = confirmDialog;
        if (savedInstanceState != null) {
            if (confirmDialog != null) {
                confirmDialog.setTitle(String.valueOf(savedInstanceState.getString("title")));
            }
            ConfirmDialog confirmDialog2 = this.mDialog;
            if (confirmDialog2 != null) {
                confirmDialog2.setContent(String.valueOf(savedInstanceState.getString("content")));
            }
        }
        ConfirmDialog confirmDialog3 = this.mDialog;
        if (confirmDialog3 != null && (alertDialogBuilderForAppCompatBuildDialog = confirmDialog3.buildDialog(getActivity(), new DialogInterfaceOnClickListenerC0140a(10))) != null) {
            alertDialogCreate = alertDialogBuilderForAppCompatBuildDialog.create();
        }
        this.mAlertDialog = alertDialogCreate;
        Intrinsics.checkNotNull(alertDialogCreate);
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        ConfirmDialog confirmDialog = this.mDialog;
        outState.putString("title", confirmDialog != null ? confirmDialog.getTitle() : null);
        ConfirmDialog confirmDialog2 = this.mDialog;
        outState.putString("content", confirmDialog2 != null ? confirmDialog2.getContent() : null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    public final void setConfirmSamsungAnalytics(@Nullable String screenID, @NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ConfirmDialog confirmDialog = this.mDialog;
        if (confirmDialog != null) {
            confirmDialog.setConfirmSamsungAnalytics(screenID, event);
        }
    }

    public final void setPostRunnable(@Nullable Runnable run) {
        ConfirmDialog confirmDialog = this.mDialog;
        if (confirmDialog != null) {
            confirmDialog.setPostRunnable(run);
        }
    }
}
