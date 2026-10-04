package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.samsung.android.support.senl.docscan.common.FileDeleteTask;
import com.samsung.android.support.senl.p145cm.base.common.method.CloseableActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerCacheFileUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerCloser {
    private static final String TAG = Logger.createTag("BaseComposerPresenter$ComposerCloser");
    private final ComposerLifeState mComposerLifeState;
    private final ComposerModel mComposerModel;
    private final ControllerManager mControllerManager;
    private String mLastCause;
    private Runnable mPendingActionAfterOnActivityResult;
    private Runnable mPendingActionAfterOnDestroy;
    private String mUuid;

    public ComposerCloser(BaseSubManager baseSubManager) {
        this.mComposerLifeState = baseSubManager.getComposerLifeState();
        this.mControllerManager = baseSubManager.getControllerManager();
        this.mComposerModel = baseSubManager.getComposerModel();
    }

    private boolean canCloseDrawingActivity() {
        return this.mComposerModel.isRunningDrawing() && this.mControllerManager.getExecuteOtherActivityController() != null;
    }

    private boolean closeCoverEditorActivity() {
        if (!this.mComposerModel.isRunningCoverEditor() || this.mControllerManager.getExecuteOtherActivityController() == null) {
            return false;
        }
        return this.mControllerManager.getExecuteOtherActivityController().finishCoverEditor();
    }

    private void closeDialogFragment(Activity activity) {
        FragmentManager supportFragmentManager;
        Fragment fragmentFindFragmentByTag;
        if ((activity instanceof AppCompatActivity) && (fragmentFindFragmentByTag = (supportFragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager()).findFragmentByTag("Composer")) != null) {
            for (Fragment fragment : supportFragmentManager.getFragments()) {
                if (!fragmentFindFragmentByTag.equals(fragment) && (fragment instanceof DialogFragment)) {
                    FragmentTransaction fragmentTransactionBeginTransaction = fragment.getParentFragmentManager().beginTransaction();
                    fragmentTransactionBeginTransaction.remove(fragment);
                    fragmentTransactionBeginTransaction.commitAllowingStateLoss();
                }
            }
        }
    }

    private boolean closeDrawingActivity(@Nullable CloseableActivity.Callback callback) {
        if (!canCloseDrawingActivity()) {
            return false;
        }
        this.mControllerManager.getExecuteOtherActivityController().finishBrush(callback);
        return true;
    }

    private boolean closeSubMenuActivity(final Activity activity, final Runnable runnable) {
        if (closeCoverEditorActivity()) {
            this.mPendingActionAfterOnActivityResult = runnable;
            return true;
        }
        if (!canCloseDrawingActivity()) {
            return false;
        }
        this.mPendingActionAfterOnActivityResult = runnable;
        this.mControllerManager.getExecuteOtherActivityController().finishBrush(new CloseableActivity.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerCloser.2
            @Override // com.samsung.android.support.senl.cm.base.common.method.CloseableActivity.Callback
            public void onClosed(@Nullable Intent intent) {
                if (intent == null) {
                    runnable.run();
                    return;
                }
                try {
                    Class cls = Integer.TYPE;
                    Method declaredMethod = Activity.class.getDeclaredMethod("onActivityResult", cls, cls, Intent.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(activity, Integer.valueOf(ComposerRequestCode.BrushDrawing.getId()), -1, intent);
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    Logger.m11001e(ComposerCloser.TAG, "closeSubMenuActivity#onClosed ", e);
                }
            }
        });
        return true;
    }

    private void deleteCacheDir(String str) {
        new FileDeleteTask().execute(str);
    }

    private void deleteDocumentScanCacheFiles(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(ComposerCacheFileUtil.getScanDir(context));
        String str = File.separator;
        sb.append(str);
        sb.append(this.mComposerModel.getDocInfo().getUuid());
        sb.append(str);
        String string = sb.toString();
        String str2 = ComposerCacheFileUtil.getDocScanDir(context) + str + this.mComposerModel.getDocInfo().getUuid() + str;
        deleteCacheDir(string);
        deleteCacheDir(str2);
    }

    private boolean isTaskRunning() {
        return this.mControllerManager.getTaskController() != null && this.mControllerManager.getTaskController().isRunning();
    }

    private void printFinishCause() {
        Logger.m11003i(TAG, "finishCause: " + this.mLastCause);
    }

    private boolean setPendingActionToTask(final Runnable runnable) {
        if (!isTaskRunning()) {
            return false;
        }
        Logger.m11003i(TAG, "closeTopWindow# task is running");
        this.mControllerManager.getTaskController().addPendingJob(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerCloser.3
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, 0);
        return true;
    }

    public void closeComposer(Activity activity, String str, Runnable runnable) {
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("closeComposer uuid:", str, " pendingAction: ");
        sbM15l.append(runnable != null);
        Logger.m11002f(str2, sbM15l.toString());
        this.mUuid = str;
        this.mPendingActionAfterOnDestroy = runnable;
        closeTopWindow(activity, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerCloser.1
            @Override // java.lang.Runnable
            public void run() {
                ComposerCloser.this.finish("closeComposer");
            }
        });
    }

    public void closeTopWindow(Activity activity, Runnable runnable) {
        Logger.m11003i(TAG, "closeTopWindow#");
        if (closeSubMenuActivity(activity, runnable) || setPendingActionToTask(runnable)) {
            return;
        }
        int lastRequestCode = this.mComposerModel.getComposerState().getLastRequestCode();
        if (lastRequestCode != -1) {
            if (lastRequestCode == ComposerRequestCode.DocumentScan.getId()) {
                deleteDocumentScanCacheFiles(activity.getApplicationContext());
            }
            activity.finishActivity(lastRequestCode);
        } else {
            closeDialogFragment(activity);
        }
        runnable.run();
    }

    public boolean finish(String str) {
        Activity activity = this.mComposerLifeState.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            Logger.m11000e(TAG, "finish : " + str + ", activity is null");
            return false;
        }
        String str2 = TAG;
        Logger.m11004w(str2, "finish : " + str + ", this: " + activity);
        boolean z = (activity.isTaskRoot() && CommonUtil.isLockTaskMode(activity)) ? false : true;
        if (!activity.isFinishing()) {
            this.mLastCause = str;
        }
        activity.finish();
        Logger.m10999d(str2, "finish: f: " + activity.isFinishing() + " d:" + activity.isDestroyed());
        return z;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public void onActivityResult() {
        Runnable runnable = this.mPendingActionAfterOnActivityResult;
        if (runnable == null) {
            return;
        }
        runnable.run();
        this.mPendingActionAfterOnActivityResult = null;
    }

    public void onDestroy() {
        printFinishCause();
        Runnable runnable = this.mPendingActionAfterOnDestroy;
        if (runnable == null) {
            return;
        }
        runnable.run();
        this.mPendingActionAfterOnDestroy = null;
    }
}
