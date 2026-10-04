package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.VoiceDataDeleteConfirmDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p039I2.DialogInterfaceOnClickListenerC0140a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/dialog/VoiceDataDeleteConfirmDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "mPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/VoiceDataDeleteConfirmDialogPresenter;", "mColor", "", "getPresenter", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVoiceDataDeleteConfirmDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceDataDeleteConfirmDialogFragment.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/dialog/VoiceDataDeleteConfirmDialogFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n1#2:73\n*E\n"})
public final class VoiceDataDeleteConfirmDialogFragment extends DialogFragment {

    @NotNull
    private static final String TAG;
    private int mColor = -1;

    @Nullable
    private VoiceDataDeleteConfirmDialogPresenter mPresenter;

    static {
        String strCreateTag = Logger.createTag("VoiceDataDeleteConfirmDialog");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(VoiceDataDeleteConfirmDialogFragment voiceDataDeleteConfirmDialogFragment, DialogInterface dialogInterface, int i) {
        VoiceDataDeleteConfirmDialogPresenter presenter = voiceDataDeleteConfirmDialogFragment.getPresenter();
        if (presenter != null) {
            presenter.delete();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$3(VoiceDataDeleteConfirmDialogFragment voiceDataDeleteConfirmDialogFragment, AlertDialog alertDialog, DialogInterface dialogInterface) {
        if (voiceDataDeleteConfirmDialogFragment.mColor != -1) {
            alertDialog.getButton(-1).setTextColor(voiceDataDeleteConfirmDialogFragment.mColor);
        }
    }

    @Nullable
    public final VoiceDataDeleteConfirmDialogPresenter getPresenter() {
        DialogContract.IFragmentPresenterContainer iFragmentPresenterContainer;
        if (this.mPresenter == null && getActivity() != null && (iFragmentPresenterContainer = (DialogContract.IFragmentPresenterContainer) requireActivity().getSupportFragmentManager().findFragmentByTag("Composer")) != null) {
            this.mPresenter = (VoiceDataDeleteConfirmDialogPresenter) iFragmentPresenterContainer.getDialogFragmentPresenter(13);
        }
        if (this.mPresenter == null) {
            Logger.m10999d(TAG, "getPresenter()# Presenter is null. dismiss call");
            dismiss();
        }
        return this.mPresenter;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        int itemCount;
        Resources resources;
        int i = 0;
        if (getPresenter() != null) {
            VoiceDataDeleteConfirmDialogPresenter presenter = getPresenter();
            Intrinsics.checkNotNull(presenter);
            itemCount = presenter.getItemCount();
        } else {
            itemCount = 0;
        }
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(getActivity(), i, 2, null);
        alertDialogBuilderForAppCompat.setMessage(requireActivity().getResources().getQuantityString(C9086R.plurals.voice_delete_confirm_message, itemCount, Integer.valueOf(itemCount)));
        alertDialogBuilderForAppCompat.setPositiveButton(requireActivity().getResources().getString(C9086R.string.dialog_delete), new DialogInterfaceOnClickListenerC10231a(this, 8));
        alertDialogBuilderForAppCompat.setNegativeButton(requireActivity().getResources().getString(C9086R.string.composer_cancel), new DialogInterfaceOnClickListenerC0140a(21));
        Context context = getContext();
        if (context != null && (resources = context.getResources()) != null) {
            this.mColor = resources.getColor(C9086R.color.composer_default_button_color_red, null);
        }
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        alertDialogCreate.setOnShowListener(new DialogInterfaceOnShowListenerC10246p(this, alertDialogCreate, 1));
        return alertDialogCreate;
    }
}
