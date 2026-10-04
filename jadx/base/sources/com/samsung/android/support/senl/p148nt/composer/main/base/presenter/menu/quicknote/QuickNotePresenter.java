package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.quicknote;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.ActivityTaskManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsActivityTaskManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BOOLEAN;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.quicknote.MsgPermissionAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.quicknote.QuickNoteModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.quicknote.common.QuickNotePresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskQuickNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common.TaskContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Restriction;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.RunningChecker;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.WebCardUtil;
import com.samsung.android.support.senl.p148nt.model.contextawareness.ContextAwarenessController;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.ContextAwarenessFeature;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.ContextAwarenessParam;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.param.IContextAwarenessParam;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.permission.DeepSkyPermissionHelper;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.IContextAwarenessResult;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.MediaObjectSuggestionInfo;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.MessageSuggestionInfo;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.WebPageSuggestionInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class QuickNotePresenter implements QuickNoteModel.OnUpdateListener, QuickNoteDialogPresenter.ActionListener {
    private static final long SUBSCRIBE_SUGGESTION_DELAY = 1000;
    private Activity mActivity;
    private boolean mCanceled;
    private ComposerModel mComposerModel;
    private ComposerViewPresenter mComposerViewPresenter;
    private ControllerManager mControllerManager;
    private DialogPresenterManager mDialogManager;
    private boolean mEnabled;
    private QuickNotePresenterContract.IExternalListenerManager mExternalListenerManager;
    private Fragment mFragment;
    private final PreTouchListenerImpl mPreTouchListener;
    private QuickNoteModel mQuickNoteModel;
    private QuickNoteModel.SuggestedData mResultSuggested;
    private final TaskChangeCallbackImpl mTaskChangeCallback;
    private WaitingAction mWaitingAction;
    private int mWindowMode;
    private static final String KEY = "QuickNotePresenter";
    private static final String TAG = Logger.createTag(KEY);
    private final FrontTaskChecker mFrontTaskChecker = new FrontTaskChecker();
    private List<String> mInsertedIds = new ArrayList();
    private boolean mPendingStart = false;
    private boolean mPendingInit = false;
    private boolean mPendingChangeLayout = false;
    private boolean mPendingPermission = false;
    private final PostJobManager mPostJobManager = new PostJobManager();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AddContent extends WaitingAction {
        public AddContent(SuggestionInfo suggestionInfo, boolean z) {
            super(suggestionInfo, z, suggestionInfo instanceof WebPageSuggestionInfo);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.QuickNotePresenter.WaitingAction
        public TaskQuickNote.SuggestedContent createSuggestedContent(SuggestionInfo suggestionInfo) {
            return createSuggestedContent(suggestionInfo, 1);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.QuickNotePresenter.WaitingAction
        public void run() {
            Logger.m11003i(QuickNotePresenter.TAG, "addContent# " + this.mInfo.hashCode());
            executeTask();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AddLink extends WaitingAction {
        SuggestionInfo mExecuteActionParam;

        public AddLink(SuggestionInfo suggestionInfo, boolean z) {
            super(suggestionInfo, z, false);
        }

        private boolean checkPermission() {
            if (!(this.mSuggestedContent instanceof TaskQuickNote.MessageContent)) {
                return true;
            }
            MsgPermissionAction msgPermissionAction = new MsgPermissionAction();
            if (msgPermissionAction.hasAndroidId()) {
                return true;
            }
            if (msgPermissionAction.hasPermission(QuickNotePresenter.this.mFragment.getContext())) {
                msgPermissionAction.saveAndroidId(QuickNotePresenter.this.mActivity);
            }
            return msgPermissionAction.hasAndroidId();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.QuickNotePresenter.WaitingAction
        public TaskQuickNote.SuggestedContent createSuggestedContent(SuggestionInfo suggestionInfo) {
            return createSuggestedContent(suggestionInfo, 2);
        }

        public SuggestionInfo getExecuteActionParam() {
            return this.mExecuteActionParam;
        }

        public void memorize(SuggestionInfo suggestionInfo) {
            this.mExecuteActionParam = suggestionInfo;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.QuickNotePresenter.WaitingAction
        public void run() {
            Logger.m11003i(QuickNotePresenter.TAG, "addLink# " + this.mInfo.hashCode());
            if (checkPermission()) {
                executeTask();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PostJobManager {
        private Runnable mSubscribeRunnable;
        private final Handler mHandler = new Handler(Looper.getMainLooper());
        private final DialogRunnable mDialogRunnable = new DialogRunnable(0);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class DialogRunnable implements Runnable {
            volatile Runnable mDialogShowAction;

            public /* synthetic */ DialogRunnable(int i) {
                this();
            }

            public synchronized Runnable getDialogShowAction() {
                return this.mDialogShowAction;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.m10999d(QuickNotePresenter.TAG, "runDialogActionOnUiThread# post");
                Runnable dialogShowAction = getDialogShowAction();
                if (dialogShowAction != null) {
                    dialogShowAction.run();
                }
                setDialogShowAction(null);
            }

            public synchronized void setDialogShowAction(Runnable runnable) {
                this.mDialogShowAction = runnable;
            }

            private DialogRunnable() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void clear() {
            clearSubscribeRunnable();
            clearDialogRunnable();
        }

        private void clearDialogRunnable() {
            this.mHandler.removeCallbacks(this.mDialogRunnable);
            this.mDialogRunnable.setDialogShowAction(null);
        }

        public void clearSubscribeRunnable() {
            Runnable runnable = this.mSubscribeRunnable;
            if (runnable != null) {
                this.mHandler.removeCallbacks(runnable);
            }
            this.mSubscribeRunnable = null;
        }

        public void postSubscribe(final Runnable runnable) {
            Runnable runnable2 = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.QuickNotePresenter.PostJobManager.1
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                    PostJobManager.this.mSubscribeRunnable = null;
                }
            };
            this.mSubscribeRunnable = runnable2;
            this.mHandler.postDelayed(runnable2, 1000L);
        }

        public synchronized void runDialogActionOnUiThread(Runnable runnable) {
            try {
                clearDialogRunnable();
                if (CommonUtils.isOnMainUIThread()) {
                    runnable.run();
                } else {
                    this.mDialogRunnable.setDialogShowAction(runnable);
                    this.mHandler.post(this.mDialogRunnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PreTouchListenerImpl implements SpenPreTouchListenerImpl.PreTouchListener {
        public /* synthetic */ PreTouchListenerImpl(QuickNotePresenter quickNotePresenter, int i) {
            this();
        }

        private boolean isToolTypeToCheck(MotionEvent motionEvent) {
            if (motionEvent.getToolType(0) == 2) {
                return true;
            }
            return motionEvent.getToolType(0) == 1 && QuickNotePresenter.this.mComposerViewPresenter.getWritingToolManager().getToolTypeAction(1) != 1;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.PreTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!QuickNotePresenter.this.isNotInitialized() && QuickNotePresenter.this.mComposerModel.getModeManager().isMode(Mode.Writing) && QuickNotePresenter.this.mDialogManager.isShowingQuickNoteDialog() && isToolTypeToCheck(motionEvent)) {
                QuickNotePresenter.this.mDialogManager.hideQuickNoteDialog("hw drawing", null, false);
            }
            return false;
        }

        private PreTouchListenerImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TaskChangeCallbackImpl implements AbsActivityTaskManagerCompatImplFactory.TaskChangeCallback {
        QuickNotePresenter mQuickNotePresenter;

        public /* synthetic */ TaskChangeCallbackImpl(int i) {
            this();
        }

        public void clear() {
            this.mQuickNotePresenter = null;
        }

        public void init(QuickNotePresenter quickNotePresenter) {
            this.mQuickNotePresenter = quickNotePresenter;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsActivityTaskManagerCompatImplFactory.TaskChangeCallback
        @WorkerThread
        public void onTaskMovedToBack(ActivityManager.RunningTaskInfo runningTaskInfo) {
            QuickNoteModel quickNoteModel = this.mQuickNotePresenter.mQuickNoteModel;
            if (quickNoteModel == null || quickNoteModel.isEmptyResult()) {
                Logger.m11003i(QuickNotePresenter.TAG, "onTaskMovedToBack# isEmptyResult true");
                return;
            }
            Logger.m11003i(QuickNotePresenter.TAG, "onTaskMovedToBack# ");
            for (SuggestionInfo suggestionInfo : quickNoteModel.getResult().getSuggestionInfoList()) {
                if (runningTaskInfo.topActivity.getPackageName().equals(suggestionInfo.getPackageName())) {
                    this.mQuickNotePresenter.hideQuickNoteDialog("onTaskMovedToBack", Collections.singletonList(suggestionInfo.getId()), true);
                    return;
                }
            }
        }

        private TaskChangeCallbackImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public abstract class WaitingAction {
        boolean mHasActionCancelProgress;
        SuggestionInfo mInfo;
        TaskQuickNote.InputValues mInputValues;
        boolean mIsBodyTextSelected;
        TaskQuickNote.SuggestedContent mSuggestedContent;
        TaskQuickNote mTaskQuickNote;

        public WaitingAction(SuggestionInfo suggestionInfo, boolean z, boolean z2) {
            this.mInfo = suggestionInfo;
            this.mSuggestedContent = createSuggestedContent(suggestionInfo);
            this.mIsBodyTextSelected = z;
            this.mHasActionCancelProgress = z2;
        }

        private Task.Callback<TaskQuickNote.ResultValues> getResultValuesCallback() {
            SuggestionInfo suggestionInfo = this.mInfo;
            if (!(suggestionInfo instanceof WebPageSuggestionInfo)) {
                return this.mTaskQuickNote.getDefaultCallback();
            }
            final String packageName = suggestionInfo.getPackageName();
            return new Task.Callback<TaskQuickNote.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.QuickNotePresenter.WaitingAction.2
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onError(TaskQuickNote.ResultValues resultValues) {
                    resultValues.showErrorToast();
                    if (QuickNotePresenter.this.mActivity == null || !QuickNotePresenter.this.mFrontTaskChecker.isFrontTask(QuickNotePresenter.this.mActivity, packageName)) {
                        Logger.m11003i(QuickNotePresenter.TAG, "resultValuesCallback# WebPageSuggestionInfo task is not front");
                    } else {
                        QuickNotePresenter.this.showQuickNoteDialog();
                    }
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onSuccess(TaskQuickNote.ResultValues resultValues) {
                    resultValues.showErrorToast();
                }
            };
        }

        public synchronized boolean checkInvalid(SuggestionInfo suggestionInfo) {
            if (suggestionInfo == null) {
                return false;
            }
            if (suggestionInfo.isValidExecution()) {
                return false;
            }
            Logger.m11003i(QuickNotePresenter.TAG, "checkInvalid#");
            QuickNotePresenter.this.mActivity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.QuickNotePresenter.WaitingAction.3
                @Override // java.lang.Runnable
                public void run() {
                    ToastHandler.show(QuickNotePresenter.this.mActivity, C9086R.string.quick_note_link_fail, 0);
                }
            });
            TaskQuickNote taskQuickNote = this.mTaskQuickNote;
            if (taskQuickNote != null) {
                taskQuickNote.cancel(null);
            }
            return true;
        }

        public synchronized void clear() {
            this.mInfo = null;
            this.mTaskQuickNote = null;
            this.mInputValues = null;
            this.mSuggestedContent = null;
        }

        public abstract TaskQuickNote.SuggestedContent createSuggestedContent(SuggestionInfo suggestionInfo);

        public TaskQuickNote.SuggestedContent createSuggestedContent(SuggestionInfo suggestionInfo, int i) {
            if (suggestionInfo instanceof MediaObjectSuggestionInfo) {
                return new TaskQuickNote.GalleryContent(i);
            }
            if (suggestionInfo instanceof WebPageSuggestionInfo) {
                return new TaskQuickNote.SBrowserContent(i);
            }
            if (suggestionInfo instanceof MessageSuggestionInfo) {
                return new TaskQuickNote.MessageContent(i);
            }
            Logger.m11000e(QuickNotePresenter.TAG, "createSuggestedContent# " + suggestionInfo);
            return null;
        }

        public void executeTask() {
            this.mTaskQuickNote = new TaskQuickNote();
            this.mInputValues = new TaskQuickNote.InputValues(QuickNotePresenter.this.mActivity, QuickNotePresenter.this.mComposerViewPresenter.getNoteManager(), QuickNotePresenter.this.mComposerViewPresenter.getPdfManager(), QuickNotePresenter.this.mComposerViewPresenter.getPageManager(), QuickNotePresenter.this.mComposerViewPresenter.getTextManager(), QuickNotePresenter.this.mComposerViewPresenter.getObjectManager(), new TaskContract.IPageScroller() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.QuickNotePresenter.WaitingAction.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.common.TaskContract.IPageScroller
                public void goToPage(int i) {
                    QuickNotePresenter.this.mComposerViewPresenter.getComposerControllerManager().getScrollController().goToPage(i);
                }
            }, this.mSuggestedContent, QuickNotePresenter.this.mComposerViewPresenter.getPageManager().getDocPageInfo().getCurrentPageIndex(), this.mIsBodyTextSelected, QuickNotePresenter.this.mComposerViewPresenter.getComposerModel().getCoeditAdapter().isCoeditNote(), QuickNotePresenter.this.mComposerViewPresenter.getComposerModel());
            QuickNotePresenter.this.mControllerManager.getTaskController().execute(this.mTaskQuickNote, this.mInputValues, getResultValuesCallback(), false, this.mHasActionCancelProgress);
        }

        public synchronized boolean isUpdatedTask() {
            return this.mSuggestedContent.getSuggestionInfo() != null;
        }

        public abstract void run();

        public synchronized void updateTask(SuggestionInfo suggestionInfo) {
            this.mSuggestedContent.setSuggestionInfo(suggestionInfo);
            TaskQuickNote taskQuickNote = this.mTaskQuickNote;
            if (taskQuickNote != null) {
                taskQuickNote.wakeUp();
            }
        }
    }

    public QuickNotePresenter() {
        boolean z = false;
        z = false;
        this.mTaskChangeCallback = new TaskChangeCallbackImpl(z ? 1 : 0);
        this.mPreTouchListener = new PreTouchListenerImpl(this, z ? 1 : 0);
        if (ContextAwarenessFeature.isContextAwarenessEnabled() && !RunningChecker.INSTANCE.isScreenOffActivityRunning()) {
            z = true;
        }
        this.mEnabled = z;
    }

    private boolean canNotAdd(SuggestionInfo suggestionInfo) {
        if (!this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote() || !(suggestionInfo instanceof MediaObjectSuggestionInfo) || this.mComposerModel.getComposerSpenDocModel().getLargeSizeItemsCount() < 100) {
            return false;
        }
        Logger.m11003i(TAG, "canNotAdd#");
        Restriction.showToastCoeditErrorOverLargeMaxCount(this.mActivity);
        return true;
    }

    private List<String> checkDuplicatedIds(List<SuggestionInfo> list) {
        ArrayList arrayList = new ArrayList(list.size());
        StringBuilder sb = new StringBuilder();
        Iterator<SuggestionInfo> it = list.iterator();
        while (it.hasNext()) {
            SuggestionInfo next = it.next();
            if (this.mInsertedIds.contains(next.getId())) {
                arrayList.add(next.getId());
                sb.append(next.getId());
                it.remove();
            }
        }
        if (!arrayList.isEmpty()) {
            Logger.m10999d(TAG, "onSuggested# duplicated# " + ((Object) sb));
            if (list.isEmpty()) {
                hideQuickNoteDialog("onSuggested# duplicated# ", null, true);
                return arrayList;
            }
            hideQuickNoteDialog("onSuggested# duplicated# remove items", arrayList, true);
        }
        return arrayList;
    }

    private boolean checkMessagePermission(SuggestionInfo suggestionInfo) {
        if (!(suggestionInfo instanceof MessageSuggestionInfo)) {
            return true;
        }
        MsgPermissionAction msgPermissionAction = new MsgPermissionAction();
        if (msgPermissionAction.hasPermission(this.mFragment.getContext())) {
            return true;
        }
        Logger.m11003i(TAG, "checkMessagePermission# no permission");
        ((AddLink) this.mWaitingAction).memorize(suggestionInfo);
        msgPermissionAction.requestPermissions(this.mFragment, 200, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.QuickNotePresenter.4
            @Override // java.lang.Runnable
            public void run() {
                QuickNotePresenter.this.clearWaitingAction();
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWaitingAction() {
        Logger.m10999d(TAG, "clearWaitingAction# ");
        WaitingAction waitingAction = this.mWaitingAction;
        if (waitingAction != null) {
            waitingAction.clear();
            this.mWaitingAction = null;
        }
    }

    private boolean isBodyTextSelected() {
        ObjectManager objectManager = this.mComposerViewPresenter.getObjectManager();
        if (objectManager.isSelectedBodyText()) {
            return true;
        }
        return this.mComposerModel.getModeManager().isMode(Mode.Text) && objectManager.isSelectedObjectOfObjectSpan();
    }

    private boolean isFullWindowOnFreeform() {
        if (Build.VERSION.SDK_INT < 30 || !DesktopModeCompat.INSTANCE.getInstance().isSupportedWindowingMode() || WindowManagerCompat.getInstance().getMultiWindowMode(this.mActivity) != 1) {
            return false;
        }
        return this.mActivity.getWindow().getWindowManager().getCurrentWindowMetrics().getBounds().equals(this.mActivity.getWindow().getWindowManager().getMaximumWindowMetrics().getBounds());
    }

    private boolean isNotAvailableToUpdate() {
        if (this.mControllerManager.getViewState().isStopped()) {
            Logger.m11000e(TAG, "isNotAvailableToUpdate# view state is stopped");
            return true;
        }
        if (!this.mComposerModel.isEditable() || !this.mComposerModel.getMdeInfo().hasWritePermission()) {
            Logger.m11000e(TAG, "isNotAvailableToUpdate# not editable or mde member");
            return true;
        }
        if (WindowManagerCompat.getInstance().getMultiWindowMode(this.mActivity) == 0) {
            Logger.m11000e(TAG, "isNotAvailableToUpdate# full mode");
            return true;
        }
        if (this.mComposerModel.getModeManager().isSubModeEnabled()) {
            Logger.m11000e(TAG, "isNotAvailableToUpdate# in sub mode");
            return true;
        }
        if (!isFullWindowOnFreeform()) {
            return !this.mComposerModel.getModeManager().isEditModeWithoutReadOnly();
        }
        Logger.m11000e(TAG, "isNotAvailableToUpdate# full windowing");
        return true;
    }

    private boolean isNotEnabled() {
        return !this.mEnabled || this.mCanceled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNotInitialized() {
        return this.mDialogManager == null;
    }

    private boolean isOptionEnabled() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_CLIPPING_OPTIONS, true);
    }

    private void onPreAddAction(SuggestionInfo suggestionInfo, BOOLEAN r32) {
        r32.setValue(isBodyTextSelected());
        this.mComposerViewPresenter.getObjectManager().clearSelectObject();
        this.mInsertedIds.add(suggestionInfo.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestExecuteAction(SuggestionInfo suggestionInfo) {
        ContextAwarenessController.getInstance().postContextAwarenessTask(new ContextAwarenessParam.ContextAwarenessParamBuilder().setActivity(this.mActivity).setType(IContextAwarenessParam.Type.EXECUTE_ACTION).setSuggestionInfo(suggestionInfo).build());
    }

    private void requestSubscribeSuggestion() {
        if (ContextAwarenessFeature.needDelayWhenRequestSubscribe()) {
            this.mPostJobManager.postSubscribe(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.QuickNotePresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CommonUtil.isNotAvailableActivity(QuickNotePresenter.this.mActivity) || QuickNotePresenter.this.mFragment == null) {
                        return;
                    }
                    Lifecycle.State state = QuickNotePresenter.this.mFragment.getLifecycle().getState();
                    Logger.m10999d(QuickNotePresenter.TAG, "requestSubscribeSuggestion# state " + state);
                    if (state == Lifecycle.State.STARTED || state == Lifecycle.State.RESUMED) {
                        ContextAwarenessController.getInstance().postContextAwarenessTask(new ContextAwarenessParam.ContextAwarenessParamBuilder().setCaller(QuickNotePresenter.this.mActivity.hashCode()).setType(IContextAwarenessParam.Type.SUBSCRIBE_SUGGESTION).build());
                    }
                }
            });
        } else {
            ContextAwarenessController.getInstance().postContextAwarenessTask(new ContextAwarenessParam.ContextAwarenessParamBuilder().setCaller(this.mActivity.hashCode()).setType(IContextAwarenessParam.Type.SUBSCRIBE_SUGGESTION).build());
        }
    }

    private void requestSuggestion() {
        Activity activity;
        if (isNotEnabled() || !isOptionEnabled() || (activity = this.mActivity) == null || !this.mFrontTaskChecker.isFrontTask(activity, ContextAwarenessFeature.SUPPORTED_DONATED_APPS)) {
            return;
        }
        Logger.m11003i(TAG, "requestSuggestion#");
        ContextAwarenessController.getInstance().postContextAwarenessTask(new ContextAwarenessParam.ContextAwarenessParamBuilder().setType(IContextAwarenessParam.Type.REQUEST_SUGGESTION).build());
    }

    private void requestUnsubscribeSuggestion() {
        if (this.mActivity == null) {
            return;
        }
        this.mPostJobManager.clearSubscribeRunnable();
        ContextAwarenessController.getInstance().postContextAwarenessTask(new ContextAwarenessParam.ContextAwarenessParamBuilder().setCaller(this.mActivity.hashCode()).setType(IContextAwarenessParam.Type.UNSUBSCRIBE_SUGGESTION).build());
    }

    private boolean showOnlyFirstWebCardPreview(final SuggestionInfo suggestionInfo) {
        if (!(suggestionInfo instanceof WebPageSuggestionInfo) || WebCardUtil.isFirstCheckToShowWebPreviewsPopup() || WebCardUtil.isShowWebPreviewsSettingEnabled()) {
            return false;
        }
        WebCardUtil.showOnlyFirstWebCardPreviewDialog(this.mDialogManager, new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.QuickNotePresenter.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (QuickNotePresenter.this.mWaitingAction == null) {
                    return;
                }
                if (QuickNotePresenter.this.mWaitingAction.checkInvalid(QuickNotePresenter.this.mWaitingAction.mSuggestedContent.getSuggestionInfo())) {
                    QuickNotePresenter.this.clearWaitingAction();
                    return;
                }
                QuickNotePresenter.this.requestExecuteAction(suggestionInfo);
                QuickNotePresenter.this.mWaitingAction.run();
                if (QuickNotePresenter.this.mWaitingAction.isUpdatedTask()) {
                    QuickNotePresenter.this.clearWaitingAction();
                }
            }
        });
        return true;
    }

    private void start() {
        if (isNotEnabled()) {
            return;
        }
        if (isNotInitialized()) {
            Logger.m10999d(TAG, "start# not initialized");
            this.mPendingStart = true;
        } else {
            Logger.m10999d(TAG, "start# ");
            requestSubscribeSuggestion();
            requestSuggestion();
        }
    }

    public void doPendingAction() {
        if (this.mEnabled && this.mQuickNoteModel.hasResult()) {
            if (this.mPendingInit) {
                onSuggested(this.mQuickNoteModel.getResult());
            } else if (this.mPendingChangeLayout) {
                this.mPendingChangeLayout = false;
                showQuickNoteDialog();
            }
        }
    }

    public void hideQuickNoteDialog(final String str, @Nullable final List<String> list, final boolean z) {
        this.mPostJobManager.runDialogActionOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.QuickNotePresenter.3
            @Override // java.lang.Runnable
            public void run() {
                QuickNotePresenter.this.mDialogManager.hideQuickNoteDialog(str, list, z);
            }
        });
    }

    public void init(DialogPresenterManager dialogPresenterManager, ControllerManager controllerManager, ComposerModel composerModel, ComposerViewPresenter composerViewPresenter) {
        setEnabled(composerModel.isEditable());
        this.mDialogManager = dialogPresenterManager;
        this.mControllerManager = controllerManager;
        this.mComposerModel = composerModel;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mTaskChangeCallback.init(this);
        if (this.mPendingStart) {
            this.mPendingStart = false;
            if (controllerManager.getViewState().isStopped()) {
                Logger.m11000e(TAG, "init# stopped state");
            } else {
                start();
            }
        }
        if (this.mEnabled) {
            ActivityTaskManagerCompat.getInstance().registerTaskChangeCallback(this.mTaskChangeCallback);
        }
    }

    public void onActivityCreated(@NonNull Activity activity, @NonNull Fragment fragment, @NonNull QuickNotePresenterContract.IExternalListenerManager iExternalListenerManager) {
        if (this.mEnabled) {
            Logger.m10999d(TAG, "onActivityCreated");
            if (!CommonUtil.isLockTaskMode(activity) && DeepSkyPermissionHelper.needPermissionConfirm() && DeepSkyPermissionHelper.isAllGrantedPermission()) {
                DeepSkyPermissionHelper.showPermissionConfirmDialog();
            }
            this.mActivity = activity;
            this.mFragment = fragment;
            QuickNoteModel quickNoteModel = new QuickNoteModel();
            this.mQuickNoteModel = quickNoteModel;
            quickNoteModel.setOnUpdateListener(this);
            this.mExternalListenerManager = iExternalListenerManager;
            iExternalListenerManager.getContextAwarenessListener().deleteObservers();
            this.mExternalListenerManager.getContextAwarenessListener().addObserver(this.mQuickNoteModel);
            this.mWindowMode = WindowManagerCompat.getInstance().getMultiWindowMode(activity);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.ActionListener
    public void onAddContent(SuggestionInfo suggestionInfo) {
        Logger.m11003i(TAG, "onAddContent# id:" + suggestionInfo.getId() + " | " + hashCode());
        if (canNotAdd(suggestionInfo)) {
            return;
        }
        BOOLEAN r02 = new BOOLEAN(false);
        onPreAddAction(suggestionInfo, r02);
        requestExecuteAction(suggestionInfo);
        AddContent addContent = new AddContent(suggestionInfo, r02.isTrue());
        this.mWaitingAction = addContent;
        addContent.run();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.ActionListener
    public void onAddLink(SuggestionInfo suggestionInfo) {
        Logger.m11003i(TAG, "onAddLink# id:" + suggestionInfo.getId() + " | " + hashCode());
        BOOLEAN r02 = new BOOLEAN(false);
        onPreAddAction(suggestionInfo, r02);
        this.mWaitingAction = new AddLink(suggestionInfo, r02.isTrue());
        if (checkMessagePermission(suggestionInfo) && !showOnlyFirstWebCardPreview(suggestionInfo)) {
            requestExecuteAction(suggestionInfo);
            this.mWaitingAction.run();
        }
    }

    public void onAttachView() {
        if (this.mEnabled) {
            this.mComposerViewPresenter.getListenerManager().addPreTouchListener(this.mPreTouchListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.QuickNoteDialogPresenter.ActionListener
    public void onCancel() {
        Logger.m11003i(TAG, "onCancel");
        this.mCanceled = true;
    }

    public void onChangeLayoutBefore() {
        if (this.mDialogManager.isShowingQuickNoteDialog()) {
            this.mPendingChangeLayout = true;
            hideQuickNoteDialog("onChangeLayoutBefore", null, false);
        }
    }

    public void onChangedAvailableMode(@NonNull Mode mode) {
        if (isNotEnabled() || this.mComposerModel.getModeManager().isEditModeWithoutReadOnly(mode) || Mode.Init.equals(mode)) {
            return;
        }
        requestSuggestion();
    }

    public void onChangedNotAvailableMode(@NonNull Mode mode) {
        if (isNotEnabled()) {
            return;
        }
        hideQuickNoteDialog("onChangedNotAvailableMode# " + mode.name(), null, true);
    }

    public void onConfigurationChanged() {
        if (isNotEnabled() || isNotInitialized() || Build.VERSION.SDK_INT < 30 || !DesktopModeCompat.INSTANCE.getInstance().isSupportedWindowingMode()) {
            return;
        }
        if (isFullWindowOnFreeform()) {
            if (this.mDialogManager.isShowingQuickNoteDialog()) {
                hideQuickNoteDialog("onConfigurationChanged FullWindowOnFreeform", null, true);
            }
        } else {
            if (this.mDialogManager.isShowingQuickNoteDialog()) {
                return;
            }
            requestSuggestion();
        }
    }

    public void onDestroy() {
        ActivityTaskManagerCompat.getInstance().unregisterTaskChangeCallback(this.mTaskChangeCallback);
        if (this.mEnabled) {
            Logger.m10999d(TAG, "onDestroy");
            this.mPostJobManager.clear();
            if (this.mQuickNoteModel == null) {
                return;
            }
            this.mTaskChangeCallback.clear();
            clearWaitingAction();
            this.mQuickNoteModel.setOnUpdateListener(null);
            try {
                this.mExternalListenerManager.getContextAwarenessListener().deleteObserver(this.mQuickNoteModel);
            } catch (Exception e) {
                Logger.m10999d(TAG, "release#, error " + e.getMessage());
            }
            this.mActivity = null;
            this.mFragment = null;
        }
    }

    public void onDetachView() {
        if (!this.mEnabled || this.mActivity == null) {
            return;
        }
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter != null && composerViewPresenter.getListenerManager() != null) {
            this.mComposerViewPresenter.getListenerManager().removePreTouchListener(this.mPreTouchListener);
        }
        this.mPostJobManager.clear();
        this.mActivity = null;
        this.mFragment = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.quicknote.QuickNoteModel.OnUpdateListener
    @WorkerThread
    public void onReceivedData(IContextAwarenessResult iContextAwarenessResult) {
        if (!this.mEnabled) {
            Logger.m11000e(TAG, "onReceivedData# called in disabled state");
            return;
        }
        if (this.mWaitingAction == null) {
            Logger.m11000e(TAG, "onReceivedData# waiting action is null");
            return;
        }
        if (!iContextAwarenessResult.isResponseSuccess()) {
            Logger.m11000e(TAG, "onReceivedData# invalid response");
            return;
        }
        if (!isOptionEnabled()) {
            Logger.m11000e(TAG, "onReceivedData# called in disabled option state");
            return;
        }
        if (isNotAvailableToUpdate()) {
            return;
        }
        SuggestionInfo suggestionInfo = iContextAwarenessResult.getSuggestionInfoList().get(0);
        Logger.m11003i(TAG, "onReceivedData# " + suggestionInfo.hashCode() + " " + suggestionInfo);
        if (this.mWaitingAction.checkInvalid(suggestionInfo)) {
            clearWaitingAction();
            return;
        }
        this.mWaitingAction.updateTask(suggestionInfo);
        if (this.mControllerManager.getTaskController().isRunning(TaskQuickNote.class)) {
            clearWaitingAction();
        }
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i != 200) {
            return false;
        }
        if (!PermissionHelper.verifyRequestResult(this.mActivity, iArr, strArr)) {
            Logger.m10999d(TAG, "onRequestPermissionsResult# not granted");
            return true;
        }
        new MsgPermissionAction().saveAndroidId(this.mActivity);
        WaitingAction waitingAction = this.mWaitingAction;
        if (waitingAction == null) {
            return true;
        }
        if (waitingAction instanceof AddLink) {
            requestExecuteAction(((AddLink) waitingAction).getExecuteActionParam());
            ((AddLink) this.mWaitingAction).memorize(null);
        }
        this.mWaitingAction.run();
        if (this.mWaitingAction.isUpdatedTask()) {
            clearWaitingAction();
        }
        return true;
    }

    public void onResume() {
        if (this.mPendingPermission) {
            this.mPendingPermission = false;
            if (this.mWaitingAction != null && new MsgPermissionAction().hasPermission(this.mActivity)) {
                Logger.m10999d(TAG, "onResume# ");
                this.mWaitingAction.run();
                if (this.mWaitingAction.isUpdatedTask()) {
                    clearWaitingAction();
                }
            }
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        if (this.mInsertedIds.isEmpty()) {
            return;
        }
        bundle.putStringArrayList(KEY, new ArrayList<>(this.mInsertedIds));
    }

    public void onStart() {
        Logger.m10999d(TAG, "onStart#");
        start();
    }

    public void onStop() {
        Logger.m10999d(TAG, "onStop#");
        if (this.mEnabled) {
            requestUnsubscribeSuggestion();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.quicknote.QuickNoteModel.OnUpdateListener
    @WorkerThread
    public void onSuggested(IContextAwarenessResult iContextAwarenessResult) {
        this.mPendingInit = false;
        if (!this.mEnabled) {
            Logger.m11000e(TAG, "onSuggested# called in disabled state");
            return;
        }
        if (!isOptionEnabled()) {
            Logger.m11000e(TAG, "onSuggested# called in disabled option state");
            return;
        }
        ControllerManager controllerManager = this.mControllerManager;
        if (controllerManager == null) {
            this.mPendingInit = true;
            return;
        }
        if (this.mCanceled) {
            Logger.m11000e(TAG, "onSuggested# called in canceled state");
            return;
        }
        if (controllerManager.getTaskController().isRunning(TaskQuickNote.class)) {
            Logger.m11000e(TAG, "onSuggested# TaskQuickNote is running");
            return;
        }
        if (!iContextAwarenessResult.isResponseSuccess()) {
            hideQuickNoteDialog("onSuggested# response fail", null, true);
            return;
        }
        if (isNotAvailableToUpdate()) {
            hideQuickNoteDialog("onSuggested# not available to update", null, true);
            return;
        }
        QuickNoteModel.SuggestedData suggestedData = new QuickNoteModel.SuggestedData(iContextAwarenessResult);
        suggestedData.addExcludedIds(this.mFrontTaskChecker.removeNoFrontTask(this.mActivity, suggestedData.getSuggestionInfoList()));
        if (suggestedData.getSuggestionInfoList().isEmpty()) {
            hideQuickNoteDialog("onSuggested# no exist donation app on foreground", null, true);
            return;
        }
        suggestedData.addExcludedIds(checkDuplicatedIds(suggestedData.getSuggestionInfoList()));
        if (suggestedData.getSuggestionInfoList().isEmpty()) {
            return;
        }
        if (iContextAwarenessResult.getResponse() == IContextAwarenessResult.Response.DRAW_SUGGESTION_FAIL) {
            Logger.m11004w(TAG, "onSuggested# fail");
        } else {
            this.mResultSuggested = suggestedData;
            showQuickNoteDialog();
        }
    }

    public void onWindowModeChanged(int i) {
        if (isNotEnabled() || isNotInitialized()) {
            return;
        }
        boolean z = this.mWindowMode == 0;
        this.mWindowMode = i;
        if (i == 0) {
            hideQuickNoteDialog("full mode", null, true);
        } else if (z) {
            requestSuggestion();
        }
    }

    public void restoreState(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY);
        if (stringArrayList != null) {
            this.mInsertedIds = stringArrayList;
        }
    }

    public void setEnabled(boolean z) {
        if (this.mEnabled) {
            this.mEnabled = z;
        }
    }

    public void showQuickNoteDialog() {
        this.mPostJobManager.runDialogActionOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.QuickNotePresenter.2
            @Override // java.lang.Runnable
            public void run() {
                Logger.m11003i(QuickNotePresenter.TAG, "showQuickNoteDialog#");
                QuickNotePresenter.this.mDialogManager.showQuickNoteDialog(QuickNotePresenter.this.mResultSuggested, QuickNotePresenter.this);
            }
        });
    }
}
