package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B#\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0014J\u0006\u0010\u0016\u001a\u00020\u0017J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/VoiceRenameDialogPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/RenameDialogCommonPresenter;", "creator", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogContract$IDialogCreator;", "mCompViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "controllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogContract$IDialogCreator;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;)V", "mObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "mModeManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/mode/ModeManager;", "mTextManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/TextManager;", "mSoftInputManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager;", "mSpenObjectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "getTag", "", "showRenameDialog", "", "getDefaultName", "isExistName", "", "newName", "setNewName", "dismiss", "view", "Landroid/view/View;", "hideSoftInput", "setBlockContextMenu", "block", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceRenameDialogPresenter extends RenameDialogCommonPresenter {

    @NotNull
    private static final String TAG;

    @NotNull
    private final ComposerViewPresenter mCompViewPresenter;

    @NotNull
    private final ModeManager mModeManager;

    @NotNull
    private final ObjectManager mObjectManager;

    @NotNull
    private final SoftInputManager mSoftInputManager;

    @Nullable
    private SpenObjectVoice mSpenObjectVoice;

    @NotNull
    private final TextManager mTextManager;

    static {
        String strCreateTag = Logger.createTag("VoiceRenameDialogPresenter");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceRenameDialogPresenter(@Nullable DialogContract.IDialogCreator iDialogCreator, @NotNull ComposerViewPresenter mCompViewPresenter, @NotNull ControllerManager controllerManager) {
        super(iDialogCreator);
        Intrinsics.checkNotNullParameter(mCompViewPresenter, "mCompViewPresenter");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        this.mCompViewPresenter = mCompViewPresenter;
        ObjectManager objectManager = mCompViewPresenter.getObjectManager();
        Intrinsics.checkNotNullExpressionValue(objectManager, "getObjectManager(...)");
        this.mObjectManager = objectManager;
        ModeManager modeManager = mCompViewPresenter.getComposerModel().getModeManager();
        Intrinsics.checkNotNullExpressionValue(modeManager, "getModeManager(...)");
        this.mModeManager = modeManager;
        TextManager textManager = mCompViewPresenter.getTextManager();
        Intrinsics.checkNotNullExpressionValue(textManager, "getTextManager(...)");
        this.mTextManager = textManager;
        SoftInputManager softInputManager = controllerManager.getSoftInputManager();
        Intrinsics.checkNotNullExpressionValue(softInputManager, "getSoftInputManager(...)");
        this.mSoftInputManager = softInputManager;
    }

    private final void hideSoftInput(View view) {
        if (this.mModeManager.isMode(Mode.Text)) {
            return;
        }
        this.mSoftInputManager.hide(view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public void dismiss(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.mModeManager.isMode(Mode.Text)) {
            this.mObjectManager.selectObject(this.mTextManager.getTextBox());
        } else {
            this.mObjectManager.clearSelectObject(false);
            hideSoftInput(view);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    @Nullable
    public String getDefaultName() {
        List<SpenObjectBase> selectedObjectList = this.mObjectManager.getSelectedObjectList();
        if (selectedObjectList == null) {
            return "";
        }
        for (SpenObjectBase spenObjectBase : selectedObjectList) {
            if (spenObjectBase != null && spenObjectBase.getType() == 10) {
                SpenObjectVoice spenObjectVoice = (SpenObjectVoice) spenObjectBase;
                this.mSpenObjectVoice = spenObjectVoice;
                return spenObjectVoice.getTitle();
            }
        }
        return "";
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public boolean isExistName(@NotNull String newName) {
        Intrinsics.checkNotNullParameter(newName, "newName");
        return this.mObjectManager.getNote() != null && this.mObjectManager.getNote().findVoiceName(newName);
    }

    public final void setBlockContextMenu(boolean block) {
        this.mCompViewPresenter.getListenerManager().getContextMenuListener().blockContextMenu(getTag(), block);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public void setNewName(@NotNull String newName) {
        Intrinsics.checkNotNullParameter(newName, "newName");
        if (this.mSpenObjectVoice == null) {
            Logger.m11000e(getTag(), "setNewName# mSpenObjectVoice is null");
            return;
        }
        Logger.addFileLog(getTag(), "VoiceRename", 0);
        SpenObjectVoice spenObjectVoice = this.mSpenObjectVoice;
        Intrinsics.checkNotNull(spenObjectVoice);
        spenObjectVoice.setTitle(newName);
        this.mObjectManager.commitHistory();
        this.mSpenObjectVoice = null;
    }

    public final void showRenameDialog() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing() || this.mActivity.isDestroyed()) {
            Logger.m10999d(getTag(), "showRenameDialog# mActivity is null or finishing or destroyed");
            return;
        }
        DialogFragment dialogFragmentCreateRenameDialogFragment = this.mCreator.createRenameDialogFragment();
        Activity activity2 = this.mActivity;
        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ((AppCompatActivity) activity2).getSupportFragmentManager().beginTransaction().add(dialogFragmentCreateRenameDialogFragment, getTag()).commitAllowingStateLoss();
        Activity activity3 = this.mActivity;
        Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ((AppCompatActivity) activity3).getSupportFragmentManager().executePendingTransactions();
    }
}
