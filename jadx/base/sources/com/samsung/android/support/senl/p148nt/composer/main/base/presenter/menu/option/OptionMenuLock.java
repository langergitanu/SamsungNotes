package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManager;
import com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener;
import com.samsung.android.support.senl.p148nt.base.common.access.lock.LockAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.AppWidgetResolverConstructor;
import com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskLock;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.HashMap;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class OptionMenuLock {
    private static final String TAG = "OptionMenuLock";
    private Activity mActivity;
    private ComposerModel mComposerModel;
    private Fragment mFragment;
    private ILockManager mLockManager;
    private MenuPresenterContract.IMenuManager mMenuManager;
    private Task.Callback<TaskLock.ResultValues> mResultCallback;
    private TaskController mTaskController;
    private final Map<String, Boolean> mVerifiedMap = new HashMap();

    public OptionMenuLock(MenuPresenterContract.IMenuManager iMenuManager, ComposerModel composerModel, TaskController taskController) {
        this.mMenuManager = iMenuManager;
        this.mComposerModel = composerModel;
        this.mTaskController = taskController;
    }

    private void lock(final MenuPresenterContract.IMenuManager iMenuManager) {
        if (PermissionHelper.isPermissionGranted(this.mActivity, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuLock.3
            @Override // java.lang.Runnable
            public void run() {
                Logger.m10999d(OptionMenuLock.TAG, "to get GET_ACCOUNTS || READ_PHONE_STATE permission");
                PermissionHelper.requestPermissions(OptionMenuLock.this.mFragment, 125, "android.permission.GET_ACCOUNTS");
            }
        }, "android.permission.GET_ACCOUNTS") && this.mLockManager != null) {
            setResultCallback(new Task.Callback<TaskLock.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuLock.4
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onError(TaskLock.ResultValues resultValues) {
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onSuccess(TaskLock.ResultValues resultValues) {
                    if (iMenuManager != null) {
                        Logger.addFileLog(OptionMenuLock.TAG, FolderConstants.Lock.DISPLAY_NAME, 0);
                        iMenuManager.finish("lock done");
                    }
                }
            });
            this.mLockManager.lock(this.mActivity, ComposerRequestCode.LockDocument.getId(), this.mComposerModel.getDocInfo().getUuid());
        }
    }

    private void setLockManager() {
        if (this.mLockManager != null) {
            return;
        }
        if (LockAccessHandler.getLockActivityClass() == null) {
            PostLaunchManager.getInstance().executeBaseLogic(1);
        }
        ILockManager iLockManagerCreateLockManager = LockAccessHandler.createLockManager(new ILockManagerListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuLock.1
            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onCreatePasswordFail(int i, int i2, Intent intent) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onCreatePasswordSuccess(int i, Intent intent) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onLockFail(int i, int i2, String... strArr) {
                AbstractC0000a.m3D(i2, "onLockFail#", OptionMenuLock.TAG);
                if (i2 == 8) {
                    PermissionHelper.requestPermissions(OptionMenuLock.this.mFragment, 125, "android.permission.GET_ACCOUNTS");
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onLockSuccess(int i, String... strArr) {
                if (OptionMenuLock.this.mActivity == null || OptionMenuLock.this.mComposerModel == null || OptionMenuLock.this.mTaskController == null) {
                    Logger.m10999d(OptionMenuLock.TAG, "onLockSuccess but error");
                    return;
                }
                Logger.m10999d(OptionMenuLock.TAG, "onLockSuccess");
                OptionMenuLock.this.mTaskController.execute(new TaskLock(), new TaskLock.InputValues(OptionMenuLock.this.mActivity, OptionMenuLock.this.mComposerModel.getDoc(), OptionMenuLock.this.mComposerModel.getComposerSaveModel(), OptionMenuLock.this.mComposerModel.getDocInfo(), OptionMenuLock.this.mComposerModel.getNotesDocEntityManager(), true), OptionMenuLock.this.mResultCallback, false);
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onUnlockFail(int i, int i2, String... strArr) {
                Logger.m10999d(OptionMenuLock.TAG, "onUnlockFail");
                OptionMenuLock.this.setStateToUnlockLockManger(false);
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onUnlockSuccess(int i, Intent intent, String... strArr) {
                if (OptionMenuLock.this.mActivity == null || OptionMenuLock.this.mComposerModel == null || OptionMenuLock.this.mTaskController == null) {
                    Logger.m10999d(OptionMenuLock.TAG, "onUnlockSuccess but error");
                    return;
                }
                Logger.m10999d(OptionMenuLock.TAG, "onUnlockSuccess");
                OptionMenuLock.this.setStateToUnlockLockManger(false);
                OptionMenuLock.this.mTaskController.execute(new TaskLock(), new TaskLock.InputValues(OptionMenuLock.this.mActivity, OptionMenuLock.this.mComposerModel.getDoc(), OptionMenuLock.this.mComposerModel.getComposerSaveModel(), OptionMenuLock.this.mComposerModel.getDocInfo(), OptionMenuLock.this.mComposerModel.getNotesDocEntityManager(), false), OptionMenuLock.this.mResultCallback, false);
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onVerifyFail(int i, int i2, String... strArr) {
                Logger.m10999d(OptionMenuLock.TAG, "onVerifyFail");
                if (i == 109) {
                    OptionMenuLock.this.mMenuManager.finish("onVerifyFail");
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onVerifySuccess(int i, Intent intent, String... strArr) {
                Logger.m10999d(OptionMenuLock.TAG, "onVerifySuccess");
                for (String str : strArr) {
                    OptionMenuLock.this.mVerifiedMap.put(str, Boolean.TRUE);
                }
            }
        });
        this.mLockManager = iLockManagerCreateLockManager;
        if (iLockManagerCreateLockManager != null) {
            iLockManagerCreateLockManager.enableLockOperation(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStateToUnlockLockManger(boolean z) {
        this.mActivity.getIntent().putExtra(ComposerConstants.ARG_REQUEST_TO_LOCKMANAGER, z);
    }

    private void unlock() {
        unlock(new Task.Callback<TaskLock.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuLock.5
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskLock.ResultValues resultValues) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskLock.ResultValues resultValues) {
                if (OptionMenuLock.this.mActivity != null) {
                    Logger.addFileLog(OptionMenuLock.TAG, "UnLock", 0);
                    OptionMenuLock.this.mMenuManager.invalidateOptionsMenu();
                    OptionMenuLock.this.mActivity.getWindow().clearFlags(8192);
                }
            }
        });
    }

    public boolean isLockVerified() {
        return Boolean.TRUE.equals(this.mVerifiedMap.get(this.mComposerModel.getDocInfo().getUuid()));
    }

    public boolean isSupportedLockMenu() {
        Activity activity = this.mActivity;
        return (activity == null || !LockUtils.isLockMenuEnabled(activity) || DeviceUtils.isDemoDevice(this.mActivity) || DeviceInfo.isOtherCorpDevice()) ? false : true;
    }

    public boolean onActivityResult(Context context, int i, int i2, Intent intent) {
        ILockManager iLockManager = this.mLockManager;
        if (iLockManager == null || !iLockManager.isRequestCodeActivityResult(i)) {
            return false;
        }
        return this.mLockManager.onActivityResult((AppCompatActivity) context, i, i2, intent);
    }

    public void onAttachView(Activity activity, Fragment fragment) {
        this.mActivity = activity;
        this.mFragment = fragment;
        setLockManager();
    }

    public void onClickLockUnlock(MenuPresenterContract.IMenuManager iMenuManager) {
        IAppWidgetResolver appWidgetResolver;
        if (this.mComposerModel.isEmpty() && !this.mComposerModel.isExistInDB(this.mActivity)) {
            Activity activity = this.mActivity;
            ToastHandler.show(activity, activity.getResources().getString(C9086R.string.lock_fail_with_empty), 1, true);
            return;
        }
        try {
            appWidgetResolver = AppWidgetResolverConstructor.getAppWidgetResolver();
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("lock menu widget exception. "), TAG);
        }
        if (appWidgetResolver == null) {
            Logger.m11000e(TAG, "lock menu widget: cannot get the WidgetResolver class");
            return;
        }
        if (appWidgetResolver.hasWidget(this.mActivity, this.mComposerModel.getDocInfo().getUuid())) {
            AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(this.mActivity);
            alertDialogBuilderForAppCompat.setTitle(C9086R.string.widget_dialog_try_to_lock_title);
            alertDialogBuilderForAppCompat.setMessage(C9086R.string.widget_dialog_try_to_lock);
            alertDialogBuilderForAppCompat.setPositiveButton(C9086R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuLock.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            alertDialogBuilderForAppCompat.show();
            return;
        }
        iMenuManager.stopVoice();
        if (this.mComposerModel.getNotesDocEntityManager().isLocked()) {
            unlock();
        } else {
            lock(iMenuManager);
        }
    }

    public void onDetachView() {
        this.mActivity = null;
        this.mFragment = null;
        this.mVerifiedMap.clear();
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i != 125) {
            return false;
        }
        lock(this.mMenuManager);
        return true;
    }

    public void resetLockVerified() {
        this.mVerifiedMap.remove(this.mComposerModel.getDocInfo().getUuid());
    }

    public void setResultCallback(Task.Callback<TaskLock.ResultValues> callback) {
        this.mResultCallback = callback;
    }

    public boolean verifyScreenLock() {
        Activity activity;
        ILockManager iLockManager = this.mLockManager;
        if (iLockManager == null || (activity = this.mActivity) == null) {
            return false;
        }
        iLockManager.verify(activity, 109, null, this.mComposerModel.getDocInfo().getUuid());
        return true;
    }

    public void unlock(Task.Callback<TaskLock.ResultValues> callback) {
        if (this.mLockManager != null) {
            setResultCallback(callback);
            setStateToUnlockLockManger(true);
            this.mLockManager.unlock(this.mActivity, ComposerRequestCode.LockDocument.getId(), null, this.mComposerModel.getDocInfo().getUuid());
        }
    }
}
