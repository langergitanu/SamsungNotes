package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p054M1.DialogInterfaceOnShowListenerC0176c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0015J\u0010\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001a\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/dialog/BarProgressDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "progressText", "", "titleText", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "onShowListener", "Landroid/content/DialogInterface$OnShowListener;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "showAllowingStateLoss", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "isShowing", "", "setCanceledOnTouchOutside", "cancel", "setOnCancelListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnShowListener", "onCancel", "dialog", "Landroid/content/DialogInterface;", SearchConstants.TargetContents.TAG, "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BarProgressDialogFragment extends DialogFragment {

    @NotNull
    private final String TAG;

    @Nullable
    private DialogInterface.OnCancelListener onCancelListener;

    @Nullable
    private DialogInterface.OnShowListener onShowListener;

    @Nullable
    private String progressText;

    @Nullable
    private final String titleText;

    public /* synthetic */ BarProgressDialogFragment(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(BarProgressDialogFragment barProgressDialogFragment, DialogInterface dialogInterface) {
        DialogInterface.OnShowListener onShowListener = barProgressDialogFragment.onShowListener;
        if (onShowListener != null) {
            onShowListener.onShow(dialogInterface);
        }
    }

    public final boolean isShowing() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        DialogInterface.OnCancelListener onCancelListener = this.onCancelListener;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialog);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        MainLogger.m7254d(this.TAG, "onCreateDialog# titleText : " + MainLogger.getEncode(this.titleText));
        View viewInflate = LayoutInflater.from(getContext()).inflate(C8003R.layout.notes_progress_bar_layout, (ViewGroup) null);
        ((ProgressBar) viewInflate.findViewById(C8003R.id.progress_bar)).setIndeterminate(true);
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity(), 0, 2, null).create();
        alertDialogCreate.setView(viewInflate);
        Window window = alertDialogCreate.getWindow();
        Intrinsics.checkNotNull(window);
        window.setGravity(17);
        TextView textView = (TextView) viewInflate.findViewById(C8003R.id.title);
        if (textView != null) {
            if (TextUtils.isEmpty(this.titleText)) {
                textView.setVisibility(8);
            } else {
                textView.setText(this.titleText);
            }
        }
        TextView textView2 = (TextView) viewInflate.findViewById(C8003R.id.sub_title);
        if (textView2 != null) {
            if (TextUtils.isEmpty(this.progressText)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(this.progressText);
            }
        }
        if (this.onShowListener != null) {
            alertDialogCreate.setOnShowListener(new DialogInterfaceOnShowListenerC0176c(this, 2));
        }
        return alertDialogCreate;
    }

    public final void setCanceledOnTouchOutside(boolean cancel) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(cancel);
        }
    }

    public final void setOnCancelListener(@Nullable DialogInterface.OnCancelListener listener) {
        this.onCancelListener = listener;
    }

    public final void setOnShowListener(@Nullable DialogInterface.OnShowListener listener) {
        this.onShowListener = listener;
    }

    public final void showAllowingStateLoss(@Nullable FragmentManager fragmentManager, @Nullable String tag) {
        if (fragmentManager == null || fragmentManager.isDestroyed()) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        fragmentTransactionBeginTransaction.add(this, tag);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public BarProgressDialogFragment(@Nullable String str, @Nullable String str2) {
        this.progressText = str;
        this.titleText = str2;
        this.TAG = "BarProgressDialogFragment";
    }
}
