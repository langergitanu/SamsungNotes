package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.AlertDialogWrapper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.VoiceDataRenameDialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u0002./B+\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0014J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0015H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001aH\u0016J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001aH\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0014J\u0006\u0010*\u001a\u00020\u001fJ\u0010\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\u0015J\b\u0010-\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/VoiceDataRenameDialogPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/RenameDialogCommonPresenter;", "creator", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogContract$IDialogCreator;", "composerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "controllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "compViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogContract$IDialogCreator;Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;)V", "mObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "mSoftInputManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager;", "mVoiceModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel;", "mClickListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/VoiceDataRenameDialogPresenter$OnClickListener;", "mDefaultName", "", "showRenameDialog", "", "clickListener", "anchorView", "Landroid/view/View;", "hide", "getTag", "getDefaultName", "isExistName", "", "name", "setNewName", "newName", "dismiss", "view", "hideSoftInput", "findFragmentByTag", "Landroidx/fragment/app/DialogFragment;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "isShowing", "setDefaultName", "defaultName", "getOldName", "OnClickListener", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceDataRenameDialogPresenter extends RenameDialogCommonPresenter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG;

    @Nullable
    private OnClickListener mClickListener;

    @Nullable
    private String mDefaultName;

    @NotNull
    private final ObjectManager mObjectManager;

    @NotNull
    private final SoftInputManager mSoftInputManager;

    @NotNull
    private final VoiceModel mVoiceModel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/VoiceDataRenameDialogPresenter$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return VoiceDataRenameDialogPresenter.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/VoiceDataRenameDialogPresenter$OnClickListener;", "", "onClick", "", "newName", "", "dismiss", "view", "Landroid/view/View;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnClickListener {
        void dismiss(@Nullable View view);

        void onClick(@Nullable String newName);
    }

    static {
        String strCreateTag = Logger.createTag("VoiceDataRenameDialogPresenter");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceDataRenameDialogPresenter(@Nullable DialogContract.IDialogCreator iDialogCreator, @NotNull ComposerModel composerModel, @NotNull ControllerManager controllerManager, @NotNull ComposerViewPresenter compViewPresenter) {
        super(iDialogCreator);
        Intrinsics.checkNotNullParameter(composerModel, "composerModel");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(compViewPresenter, "compViewPresenter");
        ObjectManager objectManager = compViewPresenter.getObjectManager();
        Intrinsics.checkNotNullExpressionValue(objectManager, "getObjectManager(...)");
        this.mObjectManager = objectManager;
        SoftInputManager softInputManager = controllerManager.getSoftInputManager();
        Intrinsics.checkNotNullExpressionValue(softInputManager, "getSoftInputManager(...)");
        this.mSoftInputManager = softInputManager;
        VoiceModel voiceModel = composerModel.getVoiceModel();
        Intrinsics.checkNotNullExpressionValue(voiceModel, "getVoiceModel(...)");
        this.mVoiceModel = voiceModel;
    }

    private final void hideSoftInput(View view) {
        this.mSoftInputManager.hide(view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public void dismiss(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        hideSoftInput(view);
        OnClickListener onClickListener = this.mClickListener;
        if (onClickListener != null) {
            onClickListener.dismiss(view);
        }
        this.mDefaultName = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    @NotNull
    public DialogFragment findFragmentByTag(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        DialogFragment dialogFragmentFindFragmentByTag = findFragmentByTag(activity, getTag());
        Intrinsics.checkNotNullExpressionValue(dialogFragmentFindFragmentByTag, "findFragmentByTag(...)");
        return dialogFragmentFindFragmentByTag;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    @NotNull
    public String getDefaultName() {
        String str = this.mDefaultName;
        if (str == null) {
            return this.mVoiceModel.getSelectedVoiceListSize() == 1 ? this.mVoiceModel.getSelectedVoiceList().get(0) : "";
        }
        Intrinsics.checkNotNull(str);
        return str;
    }

    @Nullable
    public final String getOldName() {
        DialogFragment dialogFragmentFindFragmentByTag = findFragmentByTag(this.mActivity, getTag());
        if (dialogFragmentFindFragmentByTag instanceof VoiceDataRenameDialogFragment) {
            return ((VoiceDataRenameDialogFragment) dialogFragmentFindFragmentByTag).mInputText.getText().toString();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public void hide() {
        DialogFragment dialogFragmentFindFragmentByTag = findFragmentByTag(this.mActivity, TAG);
        if (dialogFragmentFindFragmentByTag != null) {
            dialogFragmentFindFragmentByTag.dismiss();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public boolean isExistName(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.mObjectManager.getNote() != null && this.mObjectManager.getNote().findVoiceName(name);
    }

    public final boolean isShowing() {
        return findFragmentByTag(this.mActivity, getTag()) != null;
    }

    public final void setDefaultName(@Nullable String defaultName) {
        this.mDefaultName = defaultName;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public void setNewName(@NotNull String newName) {
        Intrinsics.checkNotNullParameter(newName, "newName");
        OnClickListener onClickListener = this.mClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(newName);
        }
    }

    public final void showRenameDialog(@Nullable OnClickListener clickListener, @Nullable View anchorView) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing() || this.mActivity.isDestroyed()) {
            Logger.m10999d(getTag(), "showRenameDialog# mActivity is null or finishing or destroyed");
            return;
        }
        if (this.mVoiceModel.getSelectedVoiceListSize() != 1) {
            return;
        }
        DialogFragment dialogFragmentCreateVoiceDataRenameDialogFragment = this.mCreator.createVoiceDataRenameDialogFragment();
        Activity activity2 = this.mActivity;
        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ((AppCompatActivity) activity2).getSupportFragmentManager().beginTransaction().add(dialogFragmentCreateVoiceDataRenameDialogFragment, getTag()).commitAllowingStateLoss();
        Activity activity3 = this.mActivity;
        Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ((AppCompatActivity) activity3).getSupportFragmentManager().executePendingTransactions();
        this.mClickListener = clickListener;
        AlertDialogWrapper.setAnchorView(dialogFragmentCreateVoiceDataRenameDialogFragment.getDialog(), anchorView);
        AlertDialogWrapper.anchorLayoutStyle(dialogFragmentCreateVoiceDataRenameDialogFragment.getDialog());
    }
}
