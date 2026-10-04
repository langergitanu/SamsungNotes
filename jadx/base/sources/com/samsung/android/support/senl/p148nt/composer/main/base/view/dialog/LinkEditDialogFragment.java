package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.content.Context;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.support.senl.p145cm.base.common.constants.WebConstants;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.LinkEditDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0014J\b\u0010\u0013\u001a\u00020\u000fH\u0014J\b\u0010\u0014\u001a\u00020\u0007H\u0014J\b\u0010\u0015\u001a\u00020\u0007H\u0014J\b\u0010\u0016\u001a\u00020\u0007H\u0014J\b\u0010\u0017\u001a\u00020\u0007H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/dialog/LinkEditDialogFragment;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/dialog/RenameDialogCommonFragment;", "isTextToShow", "", "<init>", "(Z)V", "onAttach", "", "context", "Landroid/content/Context;", "onDetach", "onResume", "getPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/LinkEditDialogPresenter;", "getPositiveButtonText", "", "getTitleText", "getHintText", "getExistNameError", "getInvalidNameError", "showInvalidTitleToast", "insertPositiveClickSALog", "insertNegativeClickSALog", "insertTextClickSALog", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LinkEditDialogFragment extends RenameDialogCommonFragment {

    @NotNull
    private static final String TAG;
    private final boolean isTextToShow;

    static {
        String strCreateTag = Logger.createTag("LinkEditDialogFragment");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public LinkEditDialogFragment(boolean z) {
        super(100);
        this.isTextToShow = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    @NotNull
    public String getExistNameError() {
        String string = requireContext().getString(C9086R.string.already_in_use);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    @NotNull
    public String getHintText() {
        if (!this.isTextToShow) {
            return TextConst.ENTITY_TYPE_URL;
        }
        String string = requireContext().getString(C9086R.string.enter_text_to_show_in_link);
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
    @Nullable
    public String getPositiveButtonText() {
        return requireContext().getString(C9086R.string.dialog_done);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    @Nullable
    public String getTitleText() {
        return this.isTextToShow ? requireContext().getString(C9086R.string.enter_text_to_show_in_link) : requireContext().getString(C9086R.string.edit_link_address);
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        setPatternInvalidChars(WebConstants.SCRIPT_PATTERN);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        LinkEditDialogPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.setBlockContextMenu(false);
        }
        super.onDetach();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment, androidx.fragment.app.Fragment
    public void onResume() {
        LinkEditDialogPresenter presenter = getPresenter();
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
    public LinkEditDialogPresenter getPresenter() {
        DialogContract.IFragmentPresenterContainer iFragmentPresenterContainer;
        if (this.mPresenter == null && getActivity() != null && (iFragmentPresenterContainer = (DialogContract.IFragmentPresenterContainer) requireActivity().getSupportFragmentManager().findFragmentByTag("Composer")) != null) {
            this.mPresenter = (LinkEditDialogPresenter) iFragmentPresenterContainer.getDialogFragmentPresenter(20);
        }
        if (this.mPresenter == null) {
            Logger.m10999d(TAG, "getPresenter()# Presenter is null. dismiss call");
            dismiss();
        }
        return (LinkEditDialogPresenter) this.mPresenter;
    }
}
