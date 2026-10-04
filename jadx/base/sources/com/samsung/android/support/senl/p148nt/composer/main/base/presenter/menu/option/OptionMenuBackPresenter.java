package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.content.ContextCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.MultiTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.GlobalShareData;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuBackPresenter {
    private static final String TAG = Logger.createTag("OptionMenuBackPresenter");
    private AppWidgetThumbnailTask mAppWidgetThumbnailTask;
    protected final ComposerModel mComposerModel;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ControllerManager mControllerManager;
    private final DialogPresenterManager mDialogPresenterManager;
    private final MenuPresenterContract.IMenuManager mMenuManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface Caller {
        public static final String BACK_KEY = "backPressed";
        public static final String DONE_BUTTON = "doneBtn";
        public static final String NAVI_UP_BUTTON = "naviUpBtn";
    }

    public OptionMenuBackPresenter(ControllerManager controllerManager, ComposerViewPresenter composerViewPresenter, ComposerModel composerModel, DialogPresenterManager dialogPresenterManager, MenuPresenterContract.IMenuManager iMenuManager) {
        this.mControllerManager = controllerManager;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mComposerModel = composerModel;
        this.mDialogPresenterManager = dialogPresenterManager;
        this.mMenuManager = iMenuManager;
    }

    private boolean canFinishAfterSave(Activity activity, boolean z, @NonNull @Caller String str) {
        boolean zSaveOnManualSave;
        this.mMenuManager.clearRecommendedCover();
        if (!this.mComposerModel.getModeManager().isEditModeWithReadOnly()) {
            clearCurrentState();
            this.mComposerModel.saveAsync(false, false);
            return true;
        }
        clearCurrentState();
        if (z && this.mComposerModel.getModeManager().isMode(Mode.Writing)) {
            this.mComposerViewPresenter.requestCancelTouch();
        }
        this.mControllerManager.getClipboardController().closeClipboard();
        if (this.mComposerModel.isSupportedViewMode()) {
            zSaveOnManualSave = saveOnEditMode(activity, z, str);
        } else {
            if (Caller.DONE_BUTTON.equals(str) || this.mComposerModel.getComposerSaveModel().isAutoSaveOptionEnabled()) {
                saveOnAutoSave(activity);
                return true;
            }
            zSaveOnManualSave = saveOnManualSave(activity, z, str);
        }
        return !zSaveOnManualSave;
    }

    private boolean isUsingMultiMainList(ComponentName componentName) {
        if (componentName != null && componentName.getClassName().contains(NoteListAccessHandler.getNoteListClass().getName())) {
            return false;
        }
        Logger.m11003i(TAG, "isUsingMultiMainList is true");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveOnEditMode$0(Activity activity, boolean z, String str) {
        makeAppWidgetThumbnailTask(activity);
        if (this.mComposerModel.isEmptyOnNewNote()) {
            finishComposer(activity, z, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveOnManualSave$1(Activity activity, boolean z, String str) {
        makeAppWidgetThumbnailTask(activity);
        finishComposer(activity, z, str);
    }

    private void makeAppWidgetThumbnailTask(Context context) {
        this.mAppWidgetThumbnailTask = AppWidgetThumbnailTask.makeTask(context, this.mComposerModel, this.mAppWidgetThumbnailTask);
    }

    private void navigateUpToMain(Activity activity, boolean z) {
        Intent intent;
        AbstractC8014b.m7220v("navigateUpToMain, disableAnimation: ", TAG, z);
        try {
            if (activity.getIntent().getIntExtra(ComposerConstants.ARG_FROM_LIST_TYPE, 0) != 0) {
                return;
            }
            ComponentName callingActivity = activity.getCallingActivity();
            boolean zIsUsingMultiMainList = isUsingMultiMainList(callingActivity);
            if (zIsUsingMultiMainList) {
                intent = new Intent(activity, NoteListAccessHandler.getNoteListMultiInstanceClass());
                intent.setFlags(134742016);
            } else {
                Intent intent2 = new Intent();
                intent2.setClassName(activity, callingActivity.getClassName());
                intent = intent2;
            }
            intent.putExtra(Constants.ARG_UPDATE, true);
            intent.putExtra("sdoc_uuid", this.mComposerModel.getDocState().getUuid());
            putExtraForMdeInfo(intent);
            if (PredefinedCategory.MATH_NOTES.getUuid().equals(this.mComposerModel.getNotesDocEntityManager().getFolderUuid())) {
                intent.setAction(ComposerConstants.ACTION_MOVE_TO_MATH_FOLDER);
            }
            startMainActivity(activity, intent, zIsUsingMultiMainList);
            if (z) {
                if (Build.VERSION.SDK_INT >= 34) {
                    activity.overrideActivityTransition(0, 0, C9086R.anim.activity_open_exit);
                } else {
                    activity.overridePendingTransition(0, C9086R.anim.activity_open_exit);
                }
            }
        } catch (ActivityNotFoundException e) {
            Logger.m11001e(TAG, "navigateUpToMain", e);
        }
    }

    private void putExtraForMdeInfo(Intent intent) {
        if (this.mComposerModel.getMdeInfo().isMde()) {
            intent.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, this.mComposerModel.getMdeInfo().getSpaceId());
            intent.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, this.mComposerModel.getMdeInfo().getGroupId());
            intent.putExtra(ComposerConstants.ARG_MDE_COEDIT_STAND_ALONE, this.mComposerModel.getMdeInfo().isStandAlone());
        }
    }

    private void saveOnAutoSave(Activity activity) {
        boolean zIsChangedRealContent = this.mComposerModel.isChangedRealContent();
        if (!this.mComposerModel.save(true, true)) {
            this.mComposerModel.updateBackgroundData();
        } else if (zIsChangedRealContent) {
            this.mComposerModel.updateActionLinkData();
            makeAppWidgetThumbnailTask(activity);
        }
    }

    private boolean saveOnEditMode(Activity activity, boolean z, @NonNull @Caller String str) {
        OptionMenuBackPresenter optionMenuBackPresenter;
        if (this.mComposerModel.getComposerSaveModel().isAutoSaveOptionEnabled()) {
            this.mComposerModel.getModeManager().setMode(Mode.View, str, true);
            boolean zIsChangedRealContent = this.mComposerModel.isChangedRealContent();
            if (!this.mComposerModel.save(true, true)) {
                this.mComposerModel.updateBackgroundData();
            } else if (zIsChangedRealContent) {
                this.mComposerModel.updateActionLinkData();
                makeAppWidgetThumbnailTask(activity);
            }
            optionMenuBackPresenter = this;
        } else {
            if (this.mComposerModel.isChangedDocStateWithSnapSavedData()) {
                return showSaveNoteConfirmDialog(new RunnableC9843b(this, activity, z, str, 0));
            }
            optionMenuBackPresenter = this;
            optionMenuBackPresenter.mComposerModel.getModeManager().setMode(Mode.View, str, true);
            optionMenuBackPresenter.mComposerModel.updateBackgroundData();
        }
        return !optionMenuBackPresenter.mComposerModel.isEmptyOnNewNote();
    }

    private boolean saveOnManualSave(Activity activity, boolean z, @NonNull @Caller String str) {
        if (!this.mComposerModel.isChangedDocStateWithSnapSavedData()) {
            return false;
        }
        showSaveNoteConfirmDialog(new RunnableC9843b(this, activity, z, str, 1));
        return true;
    }

    public boolean canSkipBackPressed() {
        boolean zEquals;
        if (!this.mComposerViewPresenter.getComponentFactory().getConfig().isBackKeyBlockingSupported() || !this.mComposerModel.getModeManager().isEditModeWithoutReadOnly()) {
            return false;
        }
        boolean z = SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING, false);
        String str = TAG;
        AbstractC8014b.m7220v("canSkipBackPressed# ", str, z);
        GlobalShareData globalShareData = this.mComposerViewPresenter.getComponentFactory().getConfig().getGlobalShareData();
        if (globalShareData == null || !(zEquals = Boolean.TRUE.equals(globalShareData.getFlagBoolMap().get(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING)))) {
            return z;
        }
        globalShareData.getFlagBoolMap().remove(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING);
        Logger.m10999d(str, "canSkipBackPressed# " + zEquals);
        return false;
    }

    public void clearCurrentState() {
        this.mMenuManager.hideStickyMemo("8");
        this.mComposerModel.getVoiceModel().stopRecordingOrPlaying();
        this.mComposerViewPresenter.setContextMenu(false);
        this.mComposerViewPresenter.getObjectManager().clearSelectObject(true);
        if (this.mComposerModel.getComposerSaveModel().getSubData() != null) {
            this.mComposerModel.getComposerSaveModel().getSubData().release();
        }
    }

    public void finishComposer(Activity activity, boolean z, @NonNull @Caller String str) {
        if (!this.mComposerModel.isEmpty()) {
            Intent intent = activity.getIntent();
            intent.putExtra("category_id", this.mComposerModel.getNotesDocEntityManager().getFolderUuid());
            putExtraForMdeInfo(intent);
            setActivityResult(activity, intent);
        }
        if (needFinishActivity(activity, z)) {
            this.mMenuManager.finish(str);
        }
    }

    public ActivityOptions getActivityOptions(Activity activity) {
        int[] iArr = new int[2];
        activity.getWindow().getDecorView().getLocationOnScreen(iArr);
        ContextCompat companion = ContextCompat.INSTANCE.getInstance();
        int i = iArr[0];
        return companion.makeLaunchBoundOption(i, iArr[1], activity.getResources().getDisplayMetrics().widthPixels + i, iArr[1] + activity.getResources().getDisplayMetrics().heightPixels);
    }

    public AppWidgetThumbnailTask getAppWidgetThumbnailTask() {
        return this.mAppWidgetThumbnailTask;
    }

    public String getScenario(boolean z) {
        return z ? Caller.BACK_KEY : Caller.NAVI_UP_BUTTON;
    }

    public boolean goBackComposer(Activity activity, @NonNull @Caller String str) {
        boolean zEquals = Caller.BACK_KEY.equals(str);
        if ((zEquals && canSkipBackPressed()) || !canFinishAfterSave(activity, zEquals, str)) {
            return true;
        }
        finishComposer(activity, zEquals, str);
        return true;
    }

    public boolean needFinishActivity(Activity activity, boolean z) {
        if (z) {
            return true;
        }
        boolean zIsTaskRoot = activity.isTaskRoot();
        boolean zIsLockTaskMode = CommonUtil.isLockTaskMode(activity);
        if (zIsTaskRoot && zIsLockTaskMode) {
            activity.showLockTaskEscapeMessage();
            return false;
        }
        if (!this.mComposerModel.isSimpleMode() && this.mComposerModel.getNotesDocEntityManager().getNotesDocumentEntity().getWidgetId() == -1 && !this.mComposerModel.getComposerState().isFinishAfterSave()) {
            navigateUpToMain(activity, zIsTaskRoot);
        }
        return true;
    }

    public void setActivityResult(Activity activity, Intent intent) {
        activity.setResult(-1, intent);
    }

    public boolean showSaveNoteConfirmDialog(Runnable runnable) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.ComposerActivity;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return true;
        }
        UserInputSkipper.setHoldingEventTime(tag);
        this.mMenuManager.hideStickyMemo("8");
        this.mDialogPresenterManager.showSaveNoteConfirmDialog(runnable);
        return true;
    }

    public void startMainActivity(Activity activity, Intent intent, boolean z) {
        intent.addFlags(131072);
        if (!z) {
            activity.startActivity(intent);
        } else if (WindowManagerCompat.getInstance().isFreeFormWindow(activity)) {
            MultiTaskManager.getInstance().startActivity(activity, intent, getActivityOptions(activity).toBundle());
        } else {
            MultiTaskManager.getInstance().startActivity(activity, intent);
        }
    }
}
