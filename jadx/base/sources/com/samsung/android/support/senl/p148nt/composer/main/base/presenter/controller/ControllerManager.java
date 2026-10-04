package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.ViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.search.SearchEngine;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag.HashTagController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import com.samsung.android.support.senl.p148nt.composer.main.common.factory.ConfigurationFactory;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ControllerManager {
    private static final String TAG = Logger.createTag("ControllerManager");
    private ClipboardController mClipboardController;
    private ExecuteOtherActivityController mExecuteOtherActivityController;
    private HashTagController mHashTagController;
    private QuickSaveTimerController mQuickSaveTimerController;
    private SearchController mSearchController;
    private StorageChecker mStorageChecker;
    private TaskController mTaskController;
    private final ViewState mViewState;
    private VoiceRecordingController mVoiceRecordingController;
    private final SoftInputManager mSoftInputManager = new SoftInputManager();
    private final ExternalKeyboardManager mExternalKeyboardManager = new ExternalKeyboardManager();
    private final ProgressController mProgressController = new ProgressController();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory extends ConfigurationFactory {
        @NonNull
        QuickSaveTimerController creteQuickSaveTimerController();
    }

    public ControllerManager(ViewState viewState) {
        this.mViewState = viewState;
    }

    public void createController(@NonNull ComponentFactory componentFactory) {
        this.mStorageChecker = new StorageChecker(componentFactory.getConfig().getMaxDocumentSize());
        this.mClipboardController = new ClipboardController();
        this.mTaskController = new TaskController(this.mProgressController, this.mStorageChecker);
        this.mHashTagController = new HashTagController();
        this.mExecuteOtherActivityController = new ExecuteOtherActivityController();
        this.mQuickSaveTimerController = componentFactory.creteQuickSaveTimerController();
        this.mVoiceRecordingController = new VoiceRecordingController();
        this.mSearchController = new SearchController();
    }

    public ClipboardController getClipboardController() {
        return this.mClipboardController;
    }

    public ExecuteOtherActivityController getExecuteOtherActivityController() {
        return this.mExecuteOtherActivityController;
    }

    public ExternalKeyboardManager getExternalKeyboardManager() {
        return this.mExternalKeyboardManager;
    }

    public HashTagController getHashTagController() {
        return this.mHashTagController;
    }

    public ProgressController getProgressController() {
        return this.mProgressController;
    }

    public QuickSaveTimerController getQuickSaveTimer() {
        return this.mQuickSaveTimerController;
    }

    public SearchController getSearchController() {
        return this.mSearchController;
    }

    public SoftInputManager getSoftInputManager() {
        return this.mSoftInputManager;
    }

    public StorageChecker getStorageChecker() {
        return this.mStorageChecker;
    }

    public TaskController getTaskController() {
        return this.mTaskController;
    }

    public ViewState getViewState() {
        return this.mViewState;
    }

    public VoiceRecordingController getVoiceRecordingController() {
        return this.mVoiceRecordingController;
    }

    public void init(SearchEngine.SearchContract searchContract, ObjectManager objectManager, NoteManager noteManager, TextManager textManager, PdfManager pdfManager, PageManager pageManager, ComposerModel composerModel, AiMenuManager aiMenuManager) {
        Logger.m10999d(TAG, "init#");
        this.mTaskController.init(composerModel.getMdeManager());
        this.mClipboardController.init(this.mTaskController, objectManager, noteManager, pageManager, textManager, pdfManager, composerModel, this.mSoftInputManager, aiMenuManager);
        this.mHashTagController.init(composerModel);
        this.mSearchController.init(searchContract);
        this.mStorageChecker.setNote(composerModel.getDoc());
        this.mExecuteOtherActivityController.init(composerModel, pageManager);
    }

    public void initQuickSaveTimer(final ComposerModel composerModel) {
        this.mQuickSaveTimerController.setAutoSaveOptionEnabled(composerModel.getComposerSaveModel().isAutoSaveOptionEnabled());
        this.mQuickSaveTimerController.setTimeListener(new QuickSaveTimerController.OnTimeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ControllerManager.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.QuickSaveTimerController.OnTimeListener
            public void onTime() {
                if (composerModel.getDocState() == null || composerModel.getDocState().getDoc() == null || ((SpenWordDocument) composerModel.getDocState().getDoc()).isClosed()) {
                    Logger.m11004w(ControllerManager.TAG, "onTime# doc close");
                    ControllerManager.this.mQuickSaveTimerController.cancel("doc close");
                } else {
                    if (ControllerManager.this.getTaskController().isAvailableToSave()) {
                        composerModel.saveCache(false);
                    }
                    ControllerManager.this.mQuickSaveTimerController.reset("onTimeListener$onTime");
                }
            }
        });
    }

    public void onActivityCreated(Activity activity) {
        this.mProgressController.init(activity);
    }

    public void onAttachView(Activity activity, Fragment fragment, View view) {
        Logger.m10999d(TAG, "onAttachView#");
        this.mSoftInputManager.onAttachView(activity, view);
        this.mExternalKeyboardManager.onAttachView(activity);
        this.mClipboardController.onAttachView(activity);
        this.mTaskController.onAttachView(activity);
        this.mHashTagController.onAttachView(activity);
        this.mExecuteOtherActivityController.onAttachView(activity);
        this.mStorageChecker.setContext(activity);
        this.mVoiceRecordingController.onAttachView(fragment);
    }

    public void onChangeLayoutBefore() {
        this.mProgressController.onChangeLayoutBefore();
    }

    public void onDestroy() {
        TaskController taskController = this.mTaskController;
        if (taskController != null) {
            taskController.onDestroy();
        }
    }

    public void onDetachView() {
        Logger.m10999d(TAG, "onDetachView#");
        this.mSoftInputManager.onDetachView();
        this.mExternalKeyboardManager.onDetachView();
        ClipboardController clipboardController = this.mClipboardController;
        if (clipboardController != null) {
            clipboardController.onDetachView();
        }
        TaskController taskController = this.mTaskController;
        if (taskController != null) {
            taskController.onDetachView();
        }
        HashTagController hashTagController = this.mHashTagController;
        if (hashTagController != null) {
            hashTagController.onDetachView();
        }
        ExecuteOtherActivityController executeOtherActivityController = this.mExecuteOtherActivityController;
        if (executeOtherActivityController != null) {
            executeOtherActivityController.onDetachView();
        }
        StorageChecker storageChecker = this.mStorageChecker;
        if (storageChecker != null) {
            storageChecker.setContext(null);
        }
        QuickSaveTimerController quickSaveTimerController = this.mQuickSaveTimerController;
        if (quickSaveTimerController != null) {
            quickSaveTimerController.cancel("release");
        }
        this.mProgressController.onDetachView();
    }

    public void onPause() {
        QuickSaveTimerController quickSaveTimerController = this.mQuickSaveTimerController;
        if (quickSaveTimerController != null) {
            quickSaveTimerController.pause("onPause");
        }
        this.mSoftInputManager.onPause();
    }

    public boolean onRequestPermissionsResult(int i) {
        if (this.mTaskController.onRequestPermissionsResult(i)) {
            return true;
        }
        return (i == 112 || i == 123 || i == 124) ? this.mTaskController.executePendingTask() : this.mVoiceRecordingController.onRequestPermissionsResult(i);
    }

    public void onResume() {
        QuickSaveTimerController quickSaveTimerController = this.mQuickSaveTimerController;
        if (quickSaveTimerController != null) {
            quickSaveTimerController.reset("onResume");
        }
        this.mSoftInputManager.onResume();
    }
}
