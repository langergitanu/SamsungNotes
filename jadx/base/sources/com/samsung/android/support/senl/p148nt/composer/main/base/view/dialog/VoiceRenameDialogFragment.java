package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.VoiceRenameDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0014J\b\u0010\u000f\u001a\u00020\u0005H\u0014J\b\u0010\u0010\u001a\u00020\u0005H\u0014¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/dialog/VoiceRenameDialogFragment;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/dialog/RenameDialogCommonFragment;", "<init>", "()V", "onDetach", "", "onResume", "getPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/VoiceRenameDialogPresenter;", "getHintText", "", "getExistNameError", "getInvalidNameError", "showInvalidTitleToast", "insertPositiveClickSALog", "insertNegativeClickSALog", "insertTextClickSALog", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceRenameDialogFragment extends RenameDialogCommonFragment {

    @NotNull
    private static final String TAG;

    static {
        String strCreateTag = Logger.createTag("VoiceRenameDialogFragment");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public VoiceRenameDialogFragment() {
        super(50);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    @NotNull
    public String getExistNameError() {
        String string = requireContext().getString(C9086R.string.voice_already_in_use);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    @NotNull
    public String getHintText() {
        String string = requireContext().getString(C9086R.string.voice_alertdialog_rename_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    @NotNull
    public String getInvalidNameError() {
        String string = requireContext().getString(C9086R.string.voice_invalid_title_letter);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    public void insertNegativeClickSALog() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    public void insertPositiveClickSALog() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    public void insertTextClickSALog() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        VoiceRenameDialogPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.setBlockContextMenu(false);
        }
        super.onDetach();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment, androidx.fragment.app.Fragment
    public void onResume() {
        VoiceRenameDialogPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.setBlockContextMenu(true);
        }
        super.onResume();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    public void showInvalidTitleToast() {
        ToastHandler.show(getContext(), C9086R.string.voice_invalid_title_letter, 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    @Nullable
    public VoiceRenameDialogPresenter getPresenter() {
        DialogContract.IFragmentPresenterContainer iFragmentPresenterContainer;
        if (this.mPresenter == null && getActivity() != null && (iFragmentPresenterContainer = (DialogContract.IFragmentPresenterContainer) requireActivity().getSupportFragmentManager().findFragmentByTag("Composer")) != null) {
            this.mPresenter = (VoiceRenameDialogPresenter) iFragmentPresenterContainer.getDialogFragmentPresenter(1);
        }
        if (this.mPresenter == null) {
            Logger.m10999d(TAG, "getPresenter()# Presenter is null. dismiss call");
            dismiss();
        }
        return (VoiceRenameDialogPresenter) this.mPresenter;
    }
}
