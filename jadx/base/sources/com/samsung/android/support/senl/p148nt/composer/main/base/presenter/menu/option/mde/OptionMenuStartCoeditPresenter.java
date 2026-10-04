package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.mde;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.snackbar.SnackbarHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.DocPageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.CallbackWithActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakeCoeditNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuStartCoeditPresenter {
    private static final String TAG = Logger.createTag("OptionMenuStartCoeditPresenter");
    private final ComposerModel mComposerModel;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ControllerManager mControllerManager;
    private final DialogPresenterManager mDialogPresenterManager;
    private final MenuPresenterContract.IMenuManager mMenuManager;

    public OptionMenuStartCoeditPresenter(MenuPresenterContract.IMenuManager iMenuManager, ControllerManager controllerManager, ComposerViewPresenter composerViewPresenter, ComposerModel composerModel, DialogPresenterManager dialogPresenterManager) {
        this.mMenuManager = iMenuManager;
        this.mControllerManager = controllerManager;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mComposerModel = composerModel;
        this.mDialogPresenterManager = dialogPresenterManager;
    }

    private boolean canAllowToChangeCoedit(Context context) {
        if (this.mComposerModel.getComposerSpenDocModel().canAllowToChangeCoedit()) {
            return true;
        }
        ToastHandler.show(context, C9086R.string.coedit_fail_to_share_as_too_big, 0);
        return false;
    }

    private void copyNoteToCoedit(Activity activity, Intent intent) {
        Logger.m10999d(TAG, "copyNoteToCoedit");
        ToastHandler.show(activity, C9086R.string.coedit_sharing_note_ing, 0);
        String stringExtra = intent.getStringExtra(ComposerConstants.ARG_MDE_SPACE_ID);
        String stringExtra2 = intent.getStringExtra(ComposerConstants.ARG_MDE_COEDIT_INVITE_URL);
        if (!TextUtils.isEmpty(stringExtra2)) {
            activity.getIntent().putExtra(ComposerConstants.ARG_MDE_COEDIT_INVITE_URL, stringExtra2);
        }
        this.mControllerManager.getTaskController().execute(new TaskMakeCoeditNote(), new TaskMakeCoeditNote.InputValues(activity, this.mComposerModel, stringExtra), new CallbackWithActivity<TaskMakeCoeditNote.ResultValues>(activity) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.mde.OptionMenuStartCoeditPresenter.4
            private void changeNote(TaskMakeCoeditNote.ResultValues resultValues) {
                if (getActivity() == null) {
                    OptionMenuStartCoeditPresenter.this.mMenuManager.finish("changeNote");
                    return;
                }
                Logger.m10999d(OptionMenuStartCoeditPresenter.TAG, "copyNoteToCoedit# changeNote");
                OptionMenuStartCoeditPresenter.this.mComposerModel.getCoeditAdapter().readyCoedit(getActivity(), resultValues.getUuid());
                saveState();
                OptionMenuStartCoeditPresenter.this.mComposerModel.getComposerSaveModel().changeDocument(resultValues.getUuid(), resultValues.getPath());
                OptionMenuStartCoeditPresenter.this.mControllerManager.getProgressController().showProgress(0, 3);
                if (resultValues.isChangedToLightMode()) {
                    ToastHandler.show(getActivity(), C9086R.string.coedit_swiched_to_light_mode, 0);
                }
            }

            private void saveState() {
                MdeManager.SavedState savedState = new MdeManager.SavedState();
                DocPageInfo docPageInfo = OptionMenuStartCoeditPresenter.this.mComposerViewPresenter.getPageManager().getDocPageInfo();
                savedState.setPageSetting(docPageInfo.getPageLayoutColumn(), docPageInfo.getPageLayoutRow(), docPageInfo.isPageLayoutFitToScreen(), docPageInfo.isScrollVertical());
                OptionMenuStartCoeditPresenter.this.mComposerModel.getMdeManager().setSavedState(savedState);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskMakeCoeditNote.ResultValues resultValues) {
                Logger.m11000e(OptionMenuStartCoeditPresenter.TAG, "onError# " + resultValues.getResult());
                if (resultValues.getResult() == 203) {
                    ToastHandler.show(getActivity(), C9086R.string.composer_sync_network_connection_error, 0);
                    return;
                }
                if (resultValues.getResult() == 202 || resultValues.getResult() == 204) {
                    ToastHandler.show(getActivity(), C9086R.string.composer_failed_to_copy, 0);
                } else if (resultValues.getResult() == 205) {
                    ToastHandler.show(getActivity(), C9086R.string.coedit_fail_to_share_as_too_big, 0);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskMakeCoeditNote.ResultValues resultValues) {
                changeNote(resultValues);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void inviteCollaborators(Activity activity) {
        preAction();
        Intent intent = new Intent(activity, NoteListAccessHandler.getSocialPickerClass());
        intent.putExtra("view_mode", this.mComposerModel.getModeManager().isMode(Mode.View) ? 1 : 2);
        activity.startActivityForResult(intent, ComposerRequestCode.StartCoedit.getId());
    }

    private boolean isNeededSaveConfirm() {
        return !this.mComposerModel.getComposerSaveModel().isAutoSaveOptionEnabled() && this.mComposerModel.getModeManager().isEditModeWithReadOnly() && this.mComposerModel.isChangedDocStateWithSnapSavedData();
    }

    public static boolean isNetworkAvailable(Context context) {
        RequestToSyncManager.Companion companion = RequestToSyncManager.INSTANCE;
        return companion.isDataNetworkAvailable(context) && !companion.isCoeditWiFiSyncOnlyAndNotWiFiConnected(context);
    }

    private void preAction() {
        this.mMenuManager.onEvent(5);
        this.mMenuManager.hideOverlayTranslation();
        this.mComposerModel.getVoiceModel().stopRecording();
        this.mComposerModel.getVoiceModel().stopPlaying();
        this.mComposerViewPresenter.setContextMenu(false);
        this.mComposerViewPresenter.getObjectManager().clearSelectObject(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectGroup(Activity activity) {
        preAction();
        Intent intent = new Intent(activity, NoteListAccessHandler.getCoeditSpacePickerClass());
        ComposerRequestCode composerRequestCode = ComposerRequestCode.StartCoedit;
        PopOverActivityWrapper.startActivityForResult(activity, intent, composerRequestCode.getId(), 101);
        this.mComposerModel.getComposerState().setLastRequestCode(composerRequestCode.getId());
    }

    private boolean showNetworkErrorMsg(final Activity activity) {
        RequestToSyncManager.Companion companion = RequestToSyncManager.INSTANCE;
        if (!companion.isDataNetworkAvailable(activity)) {
            ToastHandler.show(activity, C9086R.string.composer_sync_network_connection_error, 0);
            return true;
        }
        if (!companion.isCoeditWiFiSyncOnlyAndNotWiFiConnected(activity)) {
            return false;
        }
        SnackbarHelper.show(activity, activity.getResources().getString(C9086R.string.co_edit_connect_to_wifi_or_allow_mobile_data_in_settings), activity.getResources().getString(C9086R.string.co_edit_go_to_settings), 0, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.mde.OptionMenuStartCoeditPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.m11003i(OptionMenuStartCoeditPresenter.TAG, "showNetworkErrorMsg# onClick ");
                UserInputSkipper.Tag tag = UserInputSkipper.Tag.Default;
                if (UserInputSkipper.isValidEvent(tag)) {
                    UserInputSkipper.setHoldingEventTime(300L, tag);
                    Intent intent = new Intent(BaseUtils.getApplicationContext(), NoteListAccessHandler.getSettingsActivity());
                    intent.putExtra(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_COMPOSER);
                    intent.putExtra(SettingsConstants.EXTRA_FRAGMENT_ARG_KEY, SettingsConstants.SETTINGS_COEDIT_NOTES_SYNC_TYPE);
                    activity.startActivity(intent);
                }
            }
        });
        return true;
    }

    private void startCoedit(Activity activity, Runnable runnable, boolean z) {
        if (this.mComposerModel.isEmptyOnNewNote()) {
            Logger.m10999d(TAG, "startCoedit# empty note");
            ToastHandler.show(activity, activity.getResources().getString(C9086R.string.coedit_fail_empty_note), 0, true);
        } else if (isNeededSaveConfirm()) {
            this.mDialogPresenterManager.showManualSaveConfirmDialog(runnable, z);
        } else {
            runnable.run();
        }
    }

    public void addToSharedNotebook(Activity activity, @NonNull Fragment fragment) {
        if (checkPermission(activity, fragment, 132)) {
            return;
        }
        addToSharedNotebook(activity);
    }

    public boolean checkPermission(Activity activity, @NonNull final Fragment fragment, final int i) {
        return Build.VERSION.SDK_INT <= 28 && !PermissionHelper.isPermissionGranted(activity, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.mde.OptionMenuStartCoeditPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                PermissionHelper.requestPermissions(fragment, i, "android.permission.READ_PHONE_STATE");
            }
        }, "android.permission.READ_PHONE_STATE");
    }

    public boolean onActivityResult(int i, int i2, Intent intent, Fragment fragment) {
        if (i != ComposerRequestCode.StartCoedit.getId()) {
            return false;
        }
        if (this.mComposerModel.getModeManager().getMode() == Mode.ReadOnly) {
            this.mComposerModel.getModeManager().setMode(this.mComposerModel.getModeManager().getPrevMode(), "get Prev mode", true);
        }
        if (i2 != -1) {
            if (isNeededSaveConfirm()) {
                this.mComposerModel.saveAsync(true, true);
            }
            return true;
        }
        ComposerManager.getInstance().closeCoeditComposer(fragment, null);
        copyNoteToCoedit(fragment.getActivity(), intent);
        return true;
    }

    public boolean onRequestPermissionsResult(Activity activity, int i) {
        if (i == 131) {
            shareWithCollaborators(activity);
            return true;
        }
        if (i != 132) {
            return false;
        }
        addToSharedNotebook(activity);
        return true;
    }

    public void shareWithCollaborators(Activity activity, @NonNull Fragment fragment) {
        if (checkPermission(activity, fragment, 131)) {
            return;
        }
        shareWithCollaborators(activity);
    }

    private void addToSharedNotebook(final Activity activity) {
        if (!showNetworkErrorMsg(activity) && canAllowToChangeCoedit(activity)) {
            startCoedit(activity, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.mde.OptionMenuStartCoeditPresenter.2
                @Override // java.lang.Runnable
                public void run() {
                    OptionMenuStartCoeditPresenter.this.selectGroup(activity);
                }
            }, false);
        }
    }

    private void shareWithCollaborators(final Activity activity) {
        if (!showNetworkErrorMsg(activity) && canAllowToChangeCoedit(activity)) {
            startCoedit(activity, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.mde.OptionMenuStartCoeditPresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    OptionMenuStartCoeditPresenter.this.inviteCollaborators(activity);
                }
            }, true);
        }
    }
}
