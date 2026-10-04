package com.samsung.android.support.senl.p148nt.app.main.picker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.glance.AbstractC2821a;
import androidx.lifecycle.Observer;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.widget.AppWidgetUtils;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.util.ProviderUtils;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.AppTaskCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.task.ShareToOtherAppsTask;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.IntentFactory;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.NotesFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.UnlockConfirmDialogHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.UnlockedConfirmDialog;
import com.samsung.android.support.senl.p148nt.app.nativecomposer.ComposerActivity;
import com.samsung.android.support.senl.p148nt.app.trigger.OpaqueDocOpenTriggerActivity;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.util.PopupNoteUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotePickerActivity extends AbsAppCompatActivity {
    private static final String KEY_NOTE_OPEN_TYPE = "key_note_open_type";
    private static final String KEY_SELECTED_FOLDER_UUID = "folder_uuid";
    private static final String KEY_SELECTED_UUID = "note_uuid";
    private static final int OPEN_TYPE_NEW_NOTE = 1;
    private static final int OPEN_TYPE_OPENED_NOTE = 2;
    private static final int OPEN_TYPE_PICK_DEFAULT = 0;
    private static final String TAG = "NotesPickerActivity";
    private int mCaller;
    private final Runnable mInitializeRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.picker.NotePickerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (NotePickerActivity.this.isNotePickerPermissionGrantedWithoutNotice()) {
                MainLogger.m7254d(NotePickerActivity.TAG, "InitializeRunnable run");
                if (NotePickerActivity.this.shareSDocToComposer()) {
                    return;
                }
                NotePickerActivity.this.openNoteDirectly();
            }
        }
    };
    private String mMimeType;
    private NotePickerModel mModel;
    private boolean mNewMemoDirectlyDone;
    private int mNoteOpenType;
    private NotesFragment mNotesFragment;
    private String mSelectedFolderUUID;
    private String mSelectedUuid;
    private int mWidgetId;

    private void createNewNotes(String str, int i) {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) ComposerActivity.class);
        intent.setAction(ComposerConstants.ACTION_NEW_MEMO);
        intent.putExtra("category_id", str);
        intent.putExtra(ComposerConstants.NEW_MEMO_FROM_PICKER, this.mWidgetId);
        intent.putExtra("tool_type", i);
        intent.putExtra(ComposerConstants.ARG_PAGE_TYPE, SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1));
        if (getIntent().getBooleanExtra(WidgetConstant.EXTRA_KEY_WIDGET_SETTING_PICK_MEMO, false) || this.mCaller == 2) {
            intent.putExtra(ComposerConstants.EXTRA_KEY_PICK_NOTE, true);
        }
        try {
            startActivityForResult(intent, 7);
            if (WindowManagerCompat.getInstance().isFreeFormWindow(this) || DesktopModeCompat.INSTANCE.getInstance().isDexMode(this)) {
                return;
            }
            overridePendingTransition(C8003R.anim.new_activity_from_bottom_to_top, C8003R.anim.prev_activity_exit_with_dim);
        } catch (ActivityNotFoundException | SecurityException e) {
            MainLogger.m7256e(TAG, "onNewNote : ", e);
            ToastHandler.show(this, C8003R.string.base_string_failed_to_load_image, 1);
        }
    }

    private void initSystemUi() {
        ContextUtils.setTaskDescription(this, C8003R.color.task_description_title_color);
        WindowManagerCompat.getInstance().controllIndicatorBar(this, getResources().getConfiguration().orientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNotePickerPermissionGrantedWithoutNotice() {
        return PermissionHelper.isPermissionGrantedWithoutNotice(this, PermissionCompat.getStoragePermissions(4));
    }

    private boolean isNotePickerPermissionNotGranted(String str) {
        final String[] storagePermissions = PermissionCompat.getStoragePermissions(4);
        if (PermissionHelper.isPermissionGranted(this, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.picker.NotePickerActivity.4
            @Override // java.lang.Runnable
            public void run() {
                PermissionHelper.requestPermissions((Activity) NotePickerActivity.this, 102, true, storagePermissions);
            }
        }, storagePermissions)) {
            return false;
        }
        MainLogger.m7259w(TAG, "isNotePickerPermissionNotGranted, caller: " + str + ", not Granted");
        return true;
    }

    private boolean isShareIntent(Intent intent) {
        return "android.intent.action.SEND".equals(intent.getAction()) || "android.intent.action.SEND_MULTIPLE".equals(intent.getAction());
    }

    @SuppressLint({"WrongConstant"})
    private void onNoteSelectedFromShare(MainEntryParam mainEntryParam) {
        int lockType = mainEntryParam.getLockType();
        MainLogger.m7258i(TAG, "onNoteSelectedFromShare# lockType : " + lockType);
        Intent intent = getIntent();
        intent.putExtra("sdoc_uuid", this.mSelectedUuid);
        intent.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, mainEntryParam.getGuid());
        if (lockType == 5) {
            intent.setFlags(1);
            this.mNotesFragment.verifyLockedNote(101, intent, this.mSelectedUuid);
            return;
        }
        if (LockUtils.isLockedOtherDocType(lockType)) {
            intent.putExtra("mode", mainEntryParam.getModeIndex());
            this.mNotesFragment.verifyLockedNote(110, intent, this.mSelectedUuid);
            return;
        }
        try {
            intent.setClass(getApplicationContext(), ComposerActivity.class);
            intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
            intent.addFlags(1);
            startActivity(intent);
            finish();
        } catch (SecurityException e) {
            ToastHandler.show(this, C8003R.string.base_string_failed_to_load_image, 1);
            MainLogger.m7255e(TAG, "onNoteSelectedFromShare# e : " + e.getMessage());
            finish();
        }
    }

    @SuppressLint({"WrongConstant"})
    private void onNoteSelectedFromWidget(MainEntryParam mainEntryParam) {
        int lockType = mainEntryParam.getLockType();
        MainLogger.m7258i(TAG, "onNoteSelectedFromWidget# lockType : " + lockType);
        if (AppWidgetUtils.isAvailableToAddWidget(getApplicationContext(), this.mSelectedUuid, this.mWidgetId)) {
            if (lockType == 5) {
                showUnlockedConfirmDialog(mainEntryParam);
                return;
            }
            if (LockUtils.isLockedOtherDocType(lockType)) {
                this.mNotesFragment.verifyLockedNote(110, IntentFactory.makeIntent(6, this, mainEntryParam), this.mSelectedUuid);
                return;
            }
            Intent intent = this.mNotesFragment.getActivity().getIntent();
            Intent intent2 = new Intent();
            if (getIntent().getBooleanExtra(WidgetConstant.EXTRA_KEY_WIDGET_SETTING_PICK_MEMO, false)) {
                intent2.putExtra("note_uuid", this.mSelectedUuid);
            } else {
                WidgetBroadcast.sendPickWidgetBroadcast(this, this.mSelectedUuid, this.mWidgetId, intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, BaseWidgetUtils.isSupportedNewWidget() ? 75 : 100), null, intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, -1), intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, -1), intent.getBooleanExtra(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, true), intent.getIntExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, 0), intent.getBooleanExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, true));
            }
            setResult(-1, intent2);
            finish();
            return;
        }
        MainLogger.m7258i(TAG, "onNoteSelectedFromWidget# not availableToAddWidget");
        String stringExtra = this.mNotesFragment.getActivity().getIntent().getStringExtra(WidgetConstant.WIDGET_PROVIDER_NAME);
        if (DisplayUtils.getScreenSize(getApplicationContext()).height() <= 1048) {
            ToastHandler.showToastOnFlipCoverScreen(ProviderUtils.createWidgetCoverContext(getApplicationContext()), getApplicationContext().getResources().getString(C8003R.string.widget_already_saved_on_cover_screen), 0);
            return;
        }
        if (stringExtra != null && (stringExtra.equals(BaseWidgetConstant.WIDGET_SINGLE_MEDIUM_COVER_PROVIDER_NAME) || stringExtra.equals("WidgetSingleLargeCoverProvider") || stringExtra.equals("WidgetSingleExtraLargeCoverProvider"))) {
            WidgetUtils.showWidgetAlreadyPinToast(getApplicationContext(), getApplicationContext().getResources().getString(C8003R.string.widget_already_saved_on_cover_screen));
        } else if (stringExtra == null || !stringExtra.equals(BaseWidgetConstant.WIDGET_SINGLE_LOCK_BRIEF_PROVIDER_NAME)) {
            WidgetUtils.showWidgetAlreadyPinToast(getApplicationContext());
        } else {
            WidgetUtils.showWidgetAlreadyPinToast(getApplicationContext(), getApplicationContext().getResources().getString(C8003R.string.widget_already_saved_on_lock_brief_screen));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openNoteDirectly() {
        MainLogger.m7258i(TAG, "openNoteDirectly# NoteOpenType : " + this.mNoteOpenType + ", NewMemoDirectlyDone : " + this.mNewMemoDirectlyDone);
        int i = this.mNoteOpenType;
        if (i == 1) {
            if (this.mNewMemoDirectlyDone) {
                return;
            }
            onNewNote(FolderConstants.MyFolders.UUID, 1);
        } else {
            if (i != 2) {
                return;
            }
            boolean zSendToComposer = sendToComposer();
            if (zSendToComposer) {
                finish();
            }
            AbstractC8014b.m7210l("openNoteDirectly# OPEN_TYPE_OPENED_NOTE : ", TAG, zSendToComposer);
        }
    }

    private boolean sendToComposer() {
        ActivityManager.AppTask appTask;
        String str = this.mMimeType;
        if (str != null && str.startsWith(Constants.MIME_SDOC)) {
            return false;
        }
        Intent intent = getIntent();
        Activity composerForActionSend = ComposerManager.getInstance().getComposerForActionSend();
        if (composerForActionSend != null) {
            intent.setComponent(composerForActionSend.getComponentName());
            intent.setFlags(536870913);
            intent.putExtra(Bixby2Constants.BIXBY_ACTION, Bixby2Constants.BIXBY_ACTION_ADD_CONTENT_TO_EDITING_NOTE);
            if (ComposerAccessHandler.getCreateNoteActivityClass() == null) {
                PostLaunchManager.getInstance().executeBaseLogic(1);
            } else if (!composerForActionSend.getComponentName().getClassName().equals(ComposerAccessHandler.getCreateNoteActivityClass().getName()) && (appTask = AppTaskCompat.getInstance().getAppTask(getApplicationContext(), composerForActionSend.getTaskId())) != null) {
                appTask.startActivity(getApplicationContext(), intent, null);
            }
            composerForActionSend.startActivity(intent);
        } else {
            if (!intent.hasExtra(ComposerConstants.ACTION_SEND_ADDITION)) {
                return false;
            }
            onNewNote(FolderConstants.MyFolders.UUID, 0);
        }
        return true;
    }

    private void setTheme(Intent intent) {
        boolean zIsShareIntent = isShareIntent(intent);
        boolean zHasExtra = intent.hasExtra(ComposerConstants.ACTION_SEND_ADDITION);
        boolean z = ComposerManager.getInstance().getComposerForActionSend() != null;
        boolean zIsNotePickerPermissionGrantedWithoutNotice = isNotePickerPermissionGrantedWithoutNotice();
        StringBuilder sbM2230u = AbstractC2821a.m2230u("setTheme, isShareIntent : ", ", isActionSendAddition: ", ", hasComposerForActionSend: ", zIsShareIntent, zHasExtra);
        sbM2230u.append(z);
        sbM2230u.append(", isNotePickerPermissionGrantedWithoutNotice: ");
        sbM2230u.append(zIsNotePickerPermissionGrantedWithoutNotice);
        MainLogger.m7258i(TAG, sbM2230u.toString());
        if (zIsShareIntent) {
            if ((zHasExtra || z) && zIsNotePickerPermissionGrantedWithoutNotice) {
                setTheme(C8003R.style.AppMainThemeNoChunkingTransparent);
                setTranslucent(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shareSDocToComposer() throws Throwable {
        Intent intent = getIntent();
        MainLogger.m7258i(TAG, "shareSDocToComposer# action : " + intent.getAction());
        if (!isShareIntent(intent)) {
            return false;
        }
        if (!StorageUtils.isAvailableMemoryForNewMemo()) {
            DialogUtils.showNotEnoughStorageDialog(this, getString(C8003R.string.not_enough_space_content_for_open, getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.composer_save_to_image_dir_galaxy : C8003R.string.composer_save_to_image_dir)), new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.picker.NotePickerActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    NotePickerActivity.this.finish();
                }
            });
            return false;
        }
        if (!this.mModel.hasOnlySDocShare(getApplicationContext(), intent)) {
            this.mModel.importSdocHandler(getApplicationContext(), intent);
            return false;
        }
        MainLogger.m7258i(TAG, "shareSDocToComposer# start OpaqueDocOpenTriggerActivity");
        intent.setComponent(new ComponentName(this, (Class<?>) OpaqueDocOpenTriggerActivity.class));
        startActivity(intent);
        finish();
        return true;
    }

    private void showUnlockedConfirmDialog(final MainEntryParam mainEntryParam) {
        new UnlockedConfirmDialog(this, new UnlockConfirmDialogHelper(this, UnlockConfirmDialogHelper.Caller.PICKER, 0, false), new DialogViewContract.IUnlockConfirmDialog() { // from class: com.samsung.android.support.senl.nt.app.main.picker.NotePickerActivity.5
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IUnlockConfirmDialog
            public void unLock() {
                Intent intent = new Intent();
                intent.putExtra("sdoc_uuid", NotePickerActivity.this.mSelectedUuid);
                intent.putExtra("category_id", mainEntryParam.getFolderUuid());
                intent.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, mainEntryParam.getGuid());
                intent.putExtra("doc_path", mainEntryParam.getFilePath());
                NotePickerActivity.this.mNotesFragment.unlockNote(108, intent, NotePickerActivity.this.mSelectedUuid);
            }
        }).show();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public View getNoteParentView() {
        return findViewById(C8003R.id.main_view_container);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        int formatVersion;
        super.onActivityResult(i, i2, intent);
        AbstractC8014b.m7200b(i, i2, "onActivityResult# requestCode : ", ", resultCode : ", TAG);
        if (PermissionHelper.onActivityResult(i, i2, this.mInitializeRunnable)) {
            finish();
            return;
        }
        if (this.mNotesFragment.onActivityResultFromLockManager(i, i2, intent)) {
            return;
        }
        if (FeatureUtils.isMainListRequestCode(i, 7)) {
            if (i2 == -1 && intent.hasExtra("sdoc_uuid")) {
                String stringExtra = intent.getStringExtra("sdoc_uuid");
                String stringExtra2 = intent.getStringExtra("doc_path");
                int i4 = this.mCaller;
                if (i4 != 1) {
                    if (i4 == 2) {
                        MainListDocumentData noteData = this.mNotesFragment.getNoteData(stringExtra);
                        new ShareToOtherAppsTask(this, noteData != null ? new MainEntryParam.Builder().setDocumentData(noteData).build() : new MainEntryParam.Builder().setUuid(stringExtra).setFilePath(stringExtra2).setTitle("").setLastModifiedAt(System.currentTimeMillis()).build(), getCallingPackage(), this.mMimeType).execute(new Void[0]);
                        return;
                    }
                    if (i4 != 8) {
                        if (i4 == 9) {
                            MainListDocumentData noteData2 = this.mNotesFragment.getNoteData(stringExtra);
                            if (noteData2.getPageMode() == 2 && (formatVersion = noteData2.getFormatVersion()) <= 4000) {
                                if ((formatVersion == 0 && SpenWNoteFile.getFormatVersion(stringExtra2) > 4000) || UUIDUtils.isGenUuid(stringExtra) || UUIDUtils.isDynamicTemplateUuid(stringExtra)) {
                                    return;
                                }
                                this.mNotesFragment.addCheckedNote(stringExtra);
                                this.mNotesFragment.importNoteToSpace();
                                this.mNotesFragment.clearCheckedNote();
                                return;
                            }
                            return;
                        }
                        if (i4 != 13) {
                            if (i4 != 14) {
                                finish();
                                return;
                            }
                        }
                    }
                    if (this.mNotesFragment.getCheckedNotesCount() < 10) {
                        this.mNotesFragment.addCheckedNote(stringExtra);
                        return;
                    }
                    return;
                }
                Intent intent2 = new Intent();
                if (stringExtra2 != null && getIntent().getBooleanExtra(WidgetConstant.EXTRA_KEY_WIDGET_SETTING_PICK_MEMO, false)) {
                    intent2.putExtra("note_uuid", stringExtra);
                    intent2.putExtra(WidgetConstant.EXTRA_KEY_FILE_PATH, stringExtra2);
                }
                setResult(i2, intent2);
                finish();
                return;
            }
        } else if (!FeatureUtils.isMainListRequestCode(i, 12)) {
            this.mNotesFragment.onActivityResultAfterVerify(i, i2, intent);
            return;
        } else {
            setResult(i2, intent);
            finish();
        }
        if (this.mNoteOpenType != 0) {
            this.mNoteOpenType = 0;
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WindowManagerCompat.getInstance().controllIndicatorBar(this, getResources().getConfiguration().orientation);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        setTheme(intent);
        super.onCreate(bundle);
        this.mModel = new NotePickerModel();
        if (((ActivityManager) getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY)).getLockTaskModeState() == 2) {
            showLockTaskEscapeMessage();
            finish();
            return;
        }
        setContentView(C8003R.layout.notes_picker_activity);
        setTitle(getString(C8003R.string.select_notes));
        setSupportActionBar((Toolbar) findViewById(C8003R.id.toolbar));
        String action = intent.getAction();
        this.mWidgetId = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
        this.mMimeType = intent.getType();
        int intExtra = intent.getIntExtra("mode", 7);
        int i = FeatureUtils.isPickMode(intExtra) ? intExtra : 7;
        if ("android.intent.action.PICK".equals(action)) {
            this.mCaller = 2;
        } else if (isShareIntent(intent)) {
            this.mCaller = 3;
        } else if (WidgetConstant.ACTION_MEMO_PICK.equals(action)) {
            this.mCaller = 1;
        } else if (NotesConstants.ACTION_PICK_NOTES_FROM_SPACE.equals(action)) {
            this.mCaller = 6;
        } else if (NotesConstants.ACTION_PICK_NOTES_FROM_COEDIT_SPACE.equals(action)) {
            this.mCaller = 9;
        } else if (NotesConstants.ACTION_PICK_NOTES_FROM_MEETING.equals(action)) {
            this.mCaller = 10;
        } else if (WidgetConstant.ACTION_MEMO_PICK_FROM_NOTE_LIST.equals(action)) {
            this.mCaller = 8;
            i = 25;
        } else if (WidgetConstant.ACTION_MEMO_PICK_COVER.equals(action)) {
            this.mCaller = 13;
            i = 27;
        } else if (WidgetConstant.ACTION_MEMO_PICK_FROM_NOTE_LIST_COVER.equals(action)) {
            this.mCaller = 14;
            i = 28;
        } else {
            this.mCaller = 1;
            AbstractC6670b.m4738C("unknown action:", action, TAG);
        }
        if (bundle == null) {
            String str = FolderConstants.AllNotes.UUID;
            this.mSelectedFolderUUID = str;
            NotesUtils.setLastSelectedFolder(str);
        } else {
            this.mSelectedFolderUUID = bundle.getString("folder_uuid");
            this.mNoteOpenType = bundle.getInt(KEY_NOTE_OPEN_TYPE);
            this.mSelectedUuid = bundle.getString("note_uuid");
            this.mNotesFragment = (NotesFragment) getSupportFragmentManager().findFragmentByTag(NotesFragment.TAG);
        }
        if (this.mNotesFragment == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("mode", i);
            bundle2.putString(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.KEY_SPACE_ID, intent.getStringExtra("spaceId"));
            bundle2.putInt(NotesConstants.KEY_CALLER, this.mCaller);
            bundle2.putStringArrayList(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST, intent.getStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST));
            bundle2.putString(NotesConstants.KEY_FOLDER_UUID, this.mSelectedFolderUUID);
            this.mNotesFragment = new NotesFragment(bundle2);
            getSupportFragmentManager().beginTransaction().replace(C8003R.id.notes_fragment_container, this.mNotesFragment, NotesFragment.TAG).commitAllowingStateLoss();
        }
        this.mNotesFragment.setContract(this);
        FolderManager.getInstance().getAllDocumentCategoryTree_LiveData(true).observe(this.mNotesFragment, new Observer<DocumentCategoryTree>() { // from class: com.samsung.android.support.senl.nt.app.main.picker.NotePickerActivity.2
            @Override // androidx.lifecycle.Observer
            public void onChanged(DocumentCategoryTree documentCategoryTree) {
                MainLogger.m7258i(NotePickerActivity.TAG, "Drawer LiveData onChanged# childCount : " + documentCategoryTree.getFolderCount());
                NotePickerActivity.this.mModel.updateDrawerData(documentCategoryTree);
                if (NotePickerActivity.this.mNotesFragment != null) {
                    NotePickerActivity.this.mNotesFragment.updateNoteViewByDrawerObserver(false);
                }
            }
        });
        int allUsedNoteCount = DataManager.getInstance().getAllUsedNoteCount(false);
        this.mNewMemoDirectlyDone = false;
        if (allUsedNoteCount == 0) {
            this.mNoteOpenType = 1;
        } else if (getIntent().hasExtra(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.EXTRA_DOC)) {
            this.mNoteOpenType = 1;
            onNewNote(FolderConstants.MyFolders.UUID, 1);
        } else if (this.mCaller == 3) {
            this.mNoteOpenType = 2;
        } else {
            this.mNoteOpenType = 0;
        }
        initSystemUi();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MainLogger.m7258i(TAG, "onDestroy");
        DataManager.getInstance().saveCurrentFolderExpandState();
        AiCommonUtil.releaseActionStatus(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onFolderSelected(String str) {
        AbstractC8014b.m7209k("onFolderSelected# uuid : ", str, TAG);
        NotesFragment notesFragment = this.mNotesFragment;
        if (notesFragment == null || str == null) {
            return;
        }
        this.mSelectedFolderUUID = str;
        notesFragment.onFolderSelected(str);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return onKeyDown(i, keyEvent, NotesFragment.TAG);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return onKeyUp(i, keyEvent, NotesFragment.TAG);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mWidgetId = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0149  */
    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNewNote(String str, int i) {
        MainLogger.m7254d(TAG, "onNewNote# caller: " + this.mCaller);
        int i2 = this.mCaller;
        if (i2 == 1) {
            if (isNotePickerPermissionNotGranted("onNewNote-from Widget")) {
                return;
            } else {
                createNewNotes(str, i);
            }
        } else if (i2 == 2) {
            createNewNotes(str, i);
        } else if (i2 == 3) {
            if (!isNotePickerPermissionGrantedWithoutNotice()) {
                MainLogger.m7258i(TAG, "onNewNote# caller: from share, ignore, permission is not granted");
                return;
            }
            Intent intent = getIntent();
            intent.setClass(getApplicationContext(), ComposerActivity.class);
            intent.putExtra("category_id", str);
            intent.putExtra("tool_type", i);
            intent.putExtra(ComposerConstants.ARG_PAGE_TYPE, SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1));
            intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
            intent.addFlags(1);
            if (intent.hasExtra("sdoc_uuid")) {
                intent.removeExtra("sdoc_uuid");
            }
            if (intent.hasExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID)) {
                intent.removeExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID);
            }
            try {
                if (!intent.hasExtra(ComposerConstants.ACTION_SEND_ADDITION) || DesktopModeCompat.INSTANCE.getInstance().isDexMode(getApplicationContext())) {
                    startActivity(intent);
                    if (!WindowManagerCompat.getInstance().isFreeFormWindow(this)) {
                        overridePendingTransition(C8003R.anim.new_activity_from_bottom_to_top, C8003R.anim.prev_activity_exit_with_dim);
                    }
                } else {
                    intent.setFlags(134742016);
                    ActivityOptions popupNoteInfo = PopupNoteUtils.getPopupNoteInfo(getApplicationContext());
                    startActivity(intent, popupNoteInfo == null ? null : popupNoteInfo.toBundle());
                }
            } catch (ActivityNotFoundException e) {
                e = e;
                MainLogger.m7256e(TAG, "onNewNote : ", e);
                ToastHandler.show(this, C8003R.string.base_string_failed_to_load_image, 1);
            } catch (SecurityException e2) {
                e = e2;
                MainLogger.m7256e(TAG, "onNewNote : ", e);
                ToastHandler.show(this, C8003R.string.base_string_failed_to_load_image, 1);
            }
            finish();
        } else if (i2 != 13 && i2 != 14) {
            switch (i2) {
                case 9:
                    if (isNotePickerPermissionNotGranted("onNewNote-from Coedit")) {
                        return;
                    }
                    Intent intent2 = new Intent(getApplicationContext(), (Class<?>) ComposerActivity.class);
                    intent2.setAction(ComposerConstants.ACTION_NEW_MEMO);
                    intent2.putExtra("category_id", str);
                    intent2.putExtra("tool_type", i);
                    intent2.putExtra(ComposerConstants.ARG_PAGE_TYPE, SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1));
                    intent2.putExtra(ComposerConstants.EXTRA_KEY_PICK_NOTE, true);
                    try {
                        startActivityForResult(intent2, 7);
                        if (!WindowManagerCompat.getInstance().isFreeFormWindow(this) && !DesktopModeCompat.INSTANCE.getInstance().isDexMode(this)) {
                            overridePendingTransition(C8003R.anim.new_activity_from_bottom_to_top, C8003R.anim.prev_activity_exit_with_dim);
                        }
                    } catch (ActivityNotFoundException | SecurityException e3) {
                        MainLogger.m7256e(TAG, "onNewNote : ", e3);
                        ToastHandler.show(this, C8003R.string.base_string_failed_to_load_image, 1);
                    }
                    break;
                case 10:
                    setResult(-1, new Intent());
                    finish();
                    break;
            }
        }
        this.mNewMemoDirectlyDone = true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        MainLogger.m7258i(TAG, "onNoteSelected# caller: " + this.mCaller);
        String uuid = mainEntryParam.getUuid();
        this.mSelectedUuid = uuid;
        int i = this.mCaller;
        if (i != 1) {
            if (i == 2) {
                new ShareToOtherAppsTask(this, mainEntryParam, getCallingPackage(), this.mMimeType).execute(new Void[0]);
                return;
            }
            if (i == 3) {
                if (isNotePickerPermissionGrantedWithoutNotice()) {
                    onNoteSelectedFromShare(mainEntryParam);
                    return;
                } else {
                    MainLogger.m7258i(TAG, "onNoteSelected# caller: from share, ignore, permission is not granted");
                    return;
                }
            }
            if (i == 9) {
                this.mNotesFragment.addCheckedNote(uuid);
                this.mNotesFragment.importNoteToSpace();
                this.mNotesFragment.clearCheckedNote();
                return;
            } else {
                if (i == 10) {
                    Intent intent = new Intent();
                    intent.putExtra("sdoc_uuid", mainEntryParam.getUuid());
                    setResult(-1, intent);
                    finish();
                    return;
                }
                if (i != 13) {
                    return;
                }
            }
        }
        if (isNotePickerPermissionNotGranted("onNoteSelected-from Widget")) {
            return;
        }
        if (!PermissionHelper.getNoticeAppPermissionNeededs()) {
            this.mInitializeRunnable.run();
        }
        onNoteSelectedFromWidget(mainEntryParam);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 102) {
            AbstractC8014b.m7201c(i, "unexpected requestCode: ", TAG);
            return;
        }
        if (!PermissionHelper.verifyRequestResult(this, i, iArr, strArr)) {
            MainLogger.m7258i(TAG, "onRequestPermissionsResult# denied");
            finish();
        } else {
            Runnable runnable = this.mInitializeRunnable;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("note_uuid", this.mSelectedUuid);
        bundle.putString("folder_uuid", this.mSelectedFolderUUID);
        bundle.putInt(KEY_NOTE_OPEN_TYPE, this.mNoteOpenType);
        NotesFragment notesFragment = this.mNotesFragment;
        if (notesFragment != null) {
            notesFragment.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (isNotePickerPermissionNotGranted("onStart") || PermissionHelper.getNoticeAppPermissionNeededs()) {
            return;
        }
        this.mInitializeRunnable.run();
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean z) {
        if (Build.VERSION.SDK_INT < 30) {
            return false;
        }
        return super.setTranslucent(z);
    }
}
