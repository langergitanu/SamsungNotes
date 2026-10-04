package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.AlertDialogWrapper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0018\u001a\u00020\u000fJ\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/VoiceDataDeleteConfirmDialogPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/AbsDialogFragmentPresenter;", "mCreator", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogContract$IDialogCreator;", "mVoiceModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogContract$IDialogCreator;Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel;)V", "mClickListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/VoiceDataDeleteConfirmDialogPresenter$OnClickListener;", "findFragmentByTag", "Landroidx/fragment/app/DialogFragment;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "hide", "", "showDialog", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "anchorView", "Landroid/view/View;", "itemCount", "", "getItemCount", "()I", OpenSessionApi.ITEM_LIMIT_DELETE, "isShowing", "", "OnClickListener", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceDataDeleteConfirmDialogPresenter extends AbsDialogFragmentPresenter {

    @NotNull
    private static final String TAG;

    @Nullable
    private OnClickListener mClickListener;

    @NotNull
    private final DialogContract.IDialogCreator mCreator;

    @NotNull
    private final VoiceModel mVoiceModel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/VoiceDataDeleteConfirmDialogPresenter$OnClickListener;", "", "onClick", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnClickListener {
        void onClick();
    }

    static {
        String strCreateTag = Logger.createTag("VoiceDataDeleteConfirmDialogPresenter");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public VoiceDataDeleteConfirmDialogPresenter(@NotNull DialogContract.IDialogCreator mCreator, @NotNull VoiceModel mVoiceModel) {
        Intrinsics.checkNotNullParameter(mCreator, "mCreator");
        Intrinsics.checkNotNullParameter(mVoiceModel, "mVoiceModel");
        this.mCreator = mCreator;
        this.mVoiceModel = mVoiceModel;
    }

    public final void delete() {
        OnClickListener onClickListener = this.mClickListener;
        if (onClickListener != null) {
            onClickListener.onClick();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    @NotNull
    public DialogFragment findFragmentByTag(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        DialogFragment dialogFragmentFindFragmentByTag = findFragmentByTag(activity, TAG);
        Intrinsics.checkNotNullExpressionValue(dialogFragmentFindFragmentByTag, "findFragmentByTag(...)");
        return dialogFragmentFindFragmentByTag;
    }

    public final int getItemCount() {
        return this.mVoiceModel.getSelectedVoiceListSize();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public void hide() {
        DialogFragment dialogFragmentFindFragmentByTag = findFragmentByTag(this.mActivity, TAG);
        if (dialogFragmentFindFragmentByTag != null) {
            dialogFragmentFindFragmentByTag.dismiss();
        }
    }

    public final boolean isShowing() {
        return findFragmentByTag(this.mActivity, TAG) != null;
    }

    public final void showDialog(@Nullable OnClickListener listener, @Nullable View anchorView) {
        if (CommonUtil.isNotAvailableActivity(this.mActivity)) {
            Logger.m10999d(TAG, "showDialog# " + this.mActivity);
            return;
        }
        this.mClickListener = listener;
        DialogFragment dialogFragmentCreateVoiceDeleteConfirmDialog = this.mCreator.createVoiceDeleteConfirmDialog();
        Activity activity = this.mActivity;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ((AppCompatActivity) activity).getSupportFragmentManager().beginTransaction().add(dialogFragmentCreateVoiceDeleteConfirmDialog, TAG).commitAllowingStateLoss();
        Activity activity2 = this.mActivity;
        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ((AppCompatActivity) activity2).getSupportFragmentManager().executePendingTransactions();
        AlertDialogWrapper.setAnchorView(dialogFragmentCreateVoiceDeleteConfirmDialog.getDialog(), anchorView);
        AlertDialogWrapper.anchorLayoutStyle(dialogFragmentCreateVoiceDeleteConfirmDialog.getDialog());
    }
}
