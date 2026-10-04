package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog;

import android.app.Activity;
import android.net.Uri;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog.PinNoteDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog.SaveNoteDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog.SelectNoteDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0019\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\u000fJ\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogPresenterManager;", "", "<init>", "()V", "mActivity", "Landroid/app/Activity;", "mCreator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$IDialogCreator;", "mSaveNoteDialogPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/SaveNoteDialogPresenter;", "mSelectNoteDialogPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/SelectNoteDialogPresenter;", "mPinNoteDialogPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/PinNoteDialogPresenter;", "init", "", "creator", "saveNoteDialogNavigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/SaveNoteDialogPresenter$ISaveNoteDialogNavigator;", "selectNoteDialogNavigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/SelectNoteDialogPresenter$ISelectNoteDialogNavigator;", "pinNoteDialogPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/PinNoteDialogPresenter$IPinNoteDialogPresenter;", "onAttachView", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "onDetachView", "showSaveNoteDialog", "showSelectNoteDialog", "showPinNoteDialog", "pinnedNoteUri", "Landroid/net/Uri;", "onConfigurationChanged", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DialogPresenterManager {

    @NotNull
    private static final String TAG = SOLogger.createTag("DialogPresenterManager");

    @Nullable
    private Activity mActivity;

    @Nullable
    private DialogContract.IDialogCreator mCreator;

    @Nullable
    private PinNoteDialogPresenter mPinNoteDialogPresenter;

    @Nullable
    private SaveNoteDialogPresenter mSaveNoteDialogPresenter;

    @Nullable
    private SelectNoteDialogPresenter mSelectNoteDialogPresenter;

    public final void init(@Nullable DialogContract.IDialogCreator creator, @NotNull SaveNoteDialogPresenter.ISaveNoteDialogNavigator saveNoteDialogNavigator, @NotNull SelectNoteDialogPresenter.ISelectNoteDialogNavigator selectNoteDialogNavigator, @NotNull PinNoteDialogPresenter.IPinNoteDialogPresenter pinNoteDialogPresenter) {
        Intrinsics.checkNotNullParameter(saveNoteDialogNavigator, "saveNoteDialogNavigator");
        Intrinsics.checkNotNullParameter(selectNoteDialogNavigator, "selectNoteDialogNavigator");
        Intrinsics.checkNotNullParameter(pinNoteDialogPresenter, "pinNoteDialogPresenter");
        SOLogger.INSTANCE.SOLoggerD(TAG, "init#");
        this.mCreator = creator;
        this.mSaveNoteDialogPresenter = new SaveNoteDialogPresenter(this.mCreator, saveNoteDialogNavigator);
        this.mSelectNoteDialogPresenter = new SelectNoteDialogPresenter(this.mCreator, selectNoteDialogNavigator);
        this.mPinNoteDialogPresenter = new PinNoteDialogPresenter(this.mCreator, pinNoteDialogPresenter);
    }

    public final void onAttachView(@Nullable Activity activity) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onAttachView#");
        this.mActivity = activity;
        SaveNoteDialogPresenter saveNoteDialogPresenter = this.mSaveNoteDialogPresenter;
        if (saveNoteDialogPresenter != null) {
            saveNoteDialogPresenter.onAttachView(activity);
        }
        SelectNoteDialogPresenter selectNoteDialogPresenter = this.mSelectNoteDialogPresenter;
        if (selectNoteDialogPresenter != null) {
            selectNoteDialogPresenter.onAttachView(this.mActivity);
        }
        PinNoteDialogPresenter pinNoteDialogPresenter = this.mPinNoteDialogPresenter;
        if (pinNoteDialogPresenter != null) {
            pinNoteDialogPresenter.onAttachView(this.mActivity);
        }
    }

    public final void onConfigurationChanged(@NotNull Uri pinnedNoteUri) {
        Intrinsics.checkNotNullParameter(pinnedNoteUri, "pinnedNoteUri");
        PinNoteDialogPresenter pinNoteDialogPresenter = this.mPinNoteDialogPresenter;
        if (pinNoteDialogPresenter == null || pinNoteDialogPresenter == null || !pinNoteDialogPresenter.isShowing()) {
            return;
        }
        PinNoteDialogPresenter pinNoteDialogPresenter2 = this.mPinNoteDialogPresenter;
        if (pinNoteDialogPresenter2 != null) {
            pinNoteDialogPresenter2.dismiss();
        }
        showPinNoteDialog(pinnedNoteUri);
    }

    public final void onDetachView() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDetachView#");
        this.mActivity = null;
        if (this.mCreator == null) {
            return;
        }
        SaveNoteDialogPresenter saveNoteDialogPresenter = this.mSaveNoteDialogPresenter;
        if (saveNoteDialogPresenter != null) {
            saveNoteDialogPresenter.onDetachView();
        }
        SelectNoteDialogPresenter selectNoteDialogPresenter = this.mSelectNoteDialogPresenter;
        if (selectNoteDialogPresenter != null) {
            selectNoteDialogPresenter.onDetachView();
        }
        PinNoteDialogPresenter pinNoteDialogPresenter = this.mPinNoteDialogPresenter;
        if (pinNoteDialogPresenter != null) {
            pinNoteDialogPresenter.onDetachView();
        }
    }

    public final void showPinNoteDialog(@NotNull Uri pinnedNoteUri) {
        PinNoteDialogPresenter pinNoteDialogPresenter;
        Intrinsics.checkNotNullParameter(pinnedNoteUri, "pinnedNoteUri");
        SOLogger.INSTANCE.SOLoggerD(TAG, "showPinNoteDialog#");
        PinNoteDialogPresenter pinNoteDialogPresenter2 = this.mPinNoteDialogPresenter;
        if (pinNoteDialogPresenter2 == null || pinNoteDialogPresenter2.isShowing() || (pinNoteDialogPresenter = this.mPinNoteDialogPresenter) == null) {
            return;
        }
        pinNoteDialogPresenter.showPinNoteDialog(pinnedNoteUri);
    }

    public final void showSaveNoteDialog() {
        SaveNoteDialogPresenter saveNoteDialogPresenter;
        SOLogger.INSTANCE.SOLoggerD(TAG, "showSaveNoteDialog#");
        SaveNoteDialogPresenter saveNoteDialogPresenter2 = this.mSaveNoteDialogPresenter;
        if (saveNoteDialogPresenter2 == null || saveNoteDialogPresenter2.isShowing() || (saveNoteDialogPresenter = this.mSaveNoteDialogPresenter) == null) {
            return;
        }
        saveNoteDialogPresenter.showSaveNoteDialog();
    }

    public final void showSelectNoteDialog() {
        SelectNoteDialogPresenter selectNoteDialogPresenter;
        SOLogger.INSTANCE.SOLoggerD(TAG, "showSelectNoteDialog#");
        SelectNoteDialogPresenter selectNoteDialogPresenter2 = this.mSelectNoteDialogPresenter;
        if (selectNoteDialogPresenter2 == null || selectNoteDialogPresenter2.isShowing() || (selectNoteDialogPresenter = this.mSelectNoteDialogPresenter) == null) {
            return;
        }
        selectNoteDialogPresenter.showSelectNoteDialog();
    }
}
