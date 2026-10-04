package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\u001a\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0016\u001a\u00020\rJ\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016J\u001c\u0010\u001a\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010\u001f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001d¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/VoiceDialogPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogContract$IVoiceDialogPresenter;", "mCreator", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogContract$IDialogCreator;", "mObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogContract$IDialogCreator;Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;)V", "mActivity", "Landroid/app/Activity;", "mDialog", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogContract$IDialog;", "onAttachView", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "onDetachView", "showConfirmRemoveRecordingDialog", "showConfirmRemoveItemDialog", "page", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "content", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "showConfirmCancelVoiceDialog", "onDismiss", "cancelRecording", "stopRecording", "removeItem", "isAvailableToShow", "", "()Z", "isShowing", "hide", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceDialogPresenter implements DialogContract.IVoiceDialogPresenter {

    @NotNull
    private static final String TAG;

    @Nullable
    private Activity mActivity;

    @NotNull
    private final DialogContract.IDialogCreator mCreator;

    @Nullable
    private DialogContract.IDialog mDialog;

    @NotNull
    private final ObjectManager mObjectManager;

    static {
        String strCreateTag = Logger.createTag("VoiceDialogPresenter");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public VoiceDialogPresenter(@NotNull DialogContract.IDialogCreator mCreator, @NotNull ObjectManager mObjectManager) {
        Intrinsics.checkNotNullParameter(mCreator, "mCreator");
        Intrinsics.checkNotNullParameter(mObjectManager, "mObjectManager");
        this.mCreator = mCreator;
        this.mObjectManager = mObjectManager;
    }

    private final boolean isAvailableToShow() {
        Activity activity = this.mActivity;
        if (activity != null) {
            Intrinsics.checkNotNull(activity);
            if (!activity.isFinishing()) {
                Activity activity2 = this.mActivity;
                Intrinsics.checkNotNull(activity2);
                if (!activity2.isDestroyed()) {
                    DialogContract.IDialog iDialog = this.mDialog;
                    if (iDialog == null || !iDialog.isShowing()) {
                        return true;
                    }
                    Logger.m10999d(TAG, "isAvailableToShow# dialog is showing");
                    return false;
                }
            }
        }
        Logger.m10999d(TAG, "isAvailableToShow# mActivity is null or finishing or destroyed");
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IVoiceDialogPresenter
    public void cancelRecording() {
        VoiceManager.cancelRecording();
    }

    public final void hide() {
        DialogContract.IDialog iDialog = this.mDialog;
        if (iDialog != null) {
            iDialog.dismiss();
        }
    }

    public final boolean isShowing() {
        DialogContract.IDialog iDialog = this.mDialog;
        return iDialog != null && iDialog.isShowing();
    }

    public final void onAttachView(@Nullable Activity activity) {
        this.mActivity = activity;
    }

    public final void onDetachView() {
        this.mActivity = null;
        if (this.mDialog != null) {
            Logger.m11004w(TAG, "release# dialog is not null");
            DialogContract.IDialog iDialog = this.mDialog;
            Intrinsics.checkNotNull(iDialog);
            iDialog.dismiss();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IPresenter
    public void onDismiss() {
        this.mDialog = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IVoiceDialogPresenter
    public void removeItem(@Nullable SpenWPage page, @Nullable SpenObjectBase content) {
        if (page == null || content == null) {
            Logger.m10999d(TAG, "removeItem# page or content is null");
        } else {
            this.mObjectManager.deleteObject(page, content, true);
        }
    }

    public final void showConfirmCancelVoiceDialog() {
        if (isAvailableToShow()) {
            DialogContract.IDialog iDialogCreateConfirmCancelVoiceDialog = this.mCreator.createConfirmCancelVoiceDialog(this.mActivity, this);
            this.mDialog = iDialogCreateConfirmCancelVoiceDialog;
            if (iDialogCreateConfirmCancelVoiceDialog != null) {
                iDialogCreateConfirmCancelVoiceDialog.show();
            }
        }
    }

    public final void showConfirmRemoveItemDialog(@Nullable SpenWPage page, @Nullable SpenObjectBase content) {
        if (isAvailableToShow()) {
            DialogContract.IDialog iDialogCreateConfirmRemoveItemDialog = this.mCreator.createConfirmRemoveItemDialog(this.mActivity, this, page, content);
            this.mDialog = iDialogCreateConfirmRemoveItemDialog;
            if (iDialogCreateConfirmRemoveItemDialog != null) {
                iDialogCreateConfirmRemoveItemDialog.show();
            }
        }
    }

    public final void showConfirmRemoveRecordingDialog() {
        if (isAvailableToShow()) {
            DialogContract.IDialog iDialogCreateConfirmRemoveRecordingDialog = this.mCreator.createConfirmRemoveRecordingDialog(this.mActivity, this);
            this.mDialog = iDialogCreateConfirmRemoveRecordingDialog;
            if (iDialogCreateConfirmRemoveRecordingDialog != null) {
                iDialogCreateConfirmRemoveRecordingDialog.show();
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IVoiceDialogPresenter
    public void stopRecording() {
        VoiceManager.stopRecording();
    }
}
