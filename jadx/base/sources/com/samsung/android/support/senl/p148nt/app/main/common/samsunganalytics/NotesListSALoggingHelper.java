package com.samsung.android.support.senl.p148nt.app.main.common.samsunganalytics;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingsMenuUtils;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatus;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import java.lang.ref.WeakReference;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import p042J1.AbstractC0146d;
import p042J1.C0145c;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesListSALoggingHelper {
    private static final long ONE_DAY_MS = 86400000;
    private static final String TAG = "NotesListSALoggingHelper";
    private Context mContext;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SALoggingTask extends AsyncTask<Void, Void, Void> {
        private static final String TAG = "SALoggingTask";
        private final WeakReference<Map<String, NotesFolder>> folderData;
        private NotesListSALoggingHelper helper;
        private final WeakReference<Map<String, MainListDocumentData>> noteData;

        public SALoggingTask(NotesListSALoggingHelper notesListSALoggingHelper, Map<String, NotesFolder> map, Map<String, MainListDocumentData> map2) {
            this.helper = notesListSALoggingHelper;
            this.folderData = new WeakReference<>(map);
            this.noteData = new WeakReference<>(map2);
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            MainLogger.m7258i(TAG, "onDestroy doInBackground - start");
            Thread.currentThread().setName("onDestroy_GSIMThread");
            this.helper.logging(this.folderData.get(), this.noteData.get());
            MainLogger.m7258i(TAG, "onDestroy doInBackground - end");
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Void r12) {
            super.onPostExecute(r12);
            this.helper = null;
            this.folderData.clear();
            this.noteData.clear();
        }
    }

    private void SACoeditStatus() {
        CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_COEDIT_NUMBER_OF_SHARED_NOTEBOOKS, getCoeditSpaceCount());
        CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_COEDIT_NUMBER_OF_SHARED_NOTES, getCoeditNoteCount());
    }

    private void SACustomToolBarStatus() {
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.EVENT_SETTINGS_CUSTOMIZE_TOOLBAR_ITEM_COUNT, getCustomToolbarItemCount());
    }

    private void SAFoldersCount(Map<String, NotesFolder> map) {
        if (map == null) {
            return;
        }
        int size = map.size();
        int i = 0;
        for (NotesFolder notesFolder : new CopyOnWriteArrayList(map.values())) {
            String uuid = notesFolder.getUuid();
            uuid.getClass();
            switch (uuid) {
                case "shared:///":
                case "divider:///":
                case "folderManage:///":
                case "old:///":
                case "all:///":
                case "1":
                case "2":
                case "math:///":
                case "favorite:///":
                case "settings:///":
                case "screenOffMemo:///":
                case "trash:///":
                case "lock:///":
                case "recentlyImported:///":
                    size--;
                    break;
            }
            if (notesFolder.isSyncWithMS() == 1) {
                i++;
            }
        }
        NotesFolder notesFolder2 = map.get(FolderConstants.MyFolders.UUID);
        int size2 = notesFolder2 != null ? notesFolder2.getChildren().size() : 0;
        CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_FOLDERS, size - 1);
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_COUNT_FOLDER_TO_SYNC_MS, i);
        CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.STATUS_COUNT_ROOT_FOLDER_CHILDREN, size2);
        MainLogger.m7254d(TAG, "SAFoldersCount# folderCount exclude predefine : " + size + ", folderToSyncToMsCount : " + i + ", rootFolderChildren : " + size2);
        SAMsFeedStatus(i);
    }

    private void SAGetSamsungAccountAndSyncState() {
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_SET_SAMSUNG_ACCOUNT_AND_SYNC, ((C13540g) C13541h.m14287e().f9588a).m14285a() ? SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SYNC_NOTES, AbstractC0146d.m345d(this.mContext)) ? "1" : "2" : "3");
    }

    private void SAGetUseFingerprint() {
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_SET_FINGERPRINTS, LockPrefUtils.getPrefAvailableFingerprint(this.mContext) ? LockPrefUtils.getPrefUseFingerprint(this.mContext) ? "1" : "2" : "3");
    }

    private void SAGetUseIris() {
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_SET_IRIS, LockPrefUtils.getPrefAvailableIris(this.mContext) ? LockPrefUtils.getPrefUseIris(this.mContext) ? "1" : "2" : "3");
    }

    private void SAGetUsePassword() {
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_SET_LOCK_PASSWORD, LockUtils.isSetPassword(this.mContext) ? "1" : "0");
    }

    private void SAGetUseSPenOnlyMode() {
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_SPEN_ONLY_MODE, !DeviceUtils.isSpenModel() ? "3" : SharedPreferencesCompat.getInstance("Settings").getBoolean("settings_spen_only_mode", true) ? "1" : "2");
    }

    private void SAGetUseSyncOnlyWifi() {
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_SET_SYNC_VIA_WIFI_ONLY, C0158a.m407a().m417k() ? C0145c.m299G(this.mContext) ? "1" : "2" : ((C13540g) C13541h.m14287e().f9588a).m14285a() ? "3" : "4");
    }

    private void SAListSortType() {
        int i = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt(NotesConstants.KEY_SORT_BY, 2);
        int i2 = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt(NotesConstants.KEY_ORDER_BY, 5);
        boolean z = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getBoolean(NotesConstants.KEY_PIN_FAVORITES, false);
        CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_SORT_BY, getSortTypeDetail(i, i2));
        CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_PIN_FAVORITES_TO_TOP, z ? "1" : "0");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void SAListViewMode() {
        String str;
        int viewMode = ContentUtils.getViewMode();
        if (viewMode == 1) {
            str = "c";
        } else if (viewMode == 2) {
            str = "a";
        } else if (viewMode == 3) {
            str = "d";
        } else if (viewMode == 4) {
            str = "b";
        } else if (viewMode != 6) {
            str = "";
        }
        CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_VIEW_TYPE, str);
    }

    private void SAMsFeedStatus(int i) {
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_SYNC_MS_USE_STATUS, (SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC, C0158a.m407a().m417k()) && SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_MICROSOFT_SYNC, false)) ? i > 0 ? "c" : "a" : i > 0 ? "d" : "b");
    }

    private void SANotesCount(Map<String, MainListDocumentData> map) {
        Iterator<MainListDocumentData> it;
        int i;
        if (map == null) {
            return;
        }
        int size = map.size();
        int all_ConvertedCount = NotesDataRepositoryFactory.newInstance(this.mContext).createNotesConvertedDocumentRepository().getAll_ConvertedCount(0);
        try {
            Iterator<MainListDocumentData> it2 = map.values().iterator();
            int i2 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (it2.hasNext()) {
                MainListDocumentData next = it2.next();
                if (next != null) {
                    String categoryUuid = next.getCategoryUuid();
                    if (FolderConstants.MyFolders.UUID.equals(categoryUuid)) {
                        i2++;
                    } else if (FolderConstants.ScreenOffMemo.UUID.equals(categoryUuid)) {
                        i4++;
                    }
                    if (next.getIsFavorite() == 1) {
                        i5++;
                    }
                    if (next.getIsLock() == 5) {
                        i10++;
                    }
                    if (next.isSDoc()) {
                        i6++;
                    }
                    if (next.getContentUuid() != null) {
                        i7++;
                    }
                    if (next.isSDocX()) {
                        it = it2;
                        i = i2;
                        if (next.getBackgroundColor() != this.mContext.getResources().getColor(C8003R.color.base_background_color_white, null)) {
                            i8++;
                        }
                    } else {
                        it = it2;
                        i = i2;
                    }
                    if (NotesUtils.isWarning(next.getCorrupted())) {
                        i9++;
                    }
                    it2 = it;
                    i2 = i;
                }
            }
            StringBuilder sbM1173s = AbstractC0622a.m1173s(size, all_ConvertedCount, "SANotesCount# allNotesCount : ", ", convertedNotesCount : ", ", rootFolderNotesCount : ");
            AbstractC2821a.m2235z(sbM1173s, i2, i4, ", screenOffMemoCount : ", ", favoriteCount : ");
            AbstractC2821a.m2235z(sbM1173s, i5, i6, ", oldNotesCount : ", ", hasImageCount : ");
            AbstractC2821a.m2235z(sbM1173s, i7, i8, ", hasBgCount : ", ", corruptCount : ");
            sbM1173s.append(i9);
            MainLogger.m7254d(TAG, sbM1173s.toString());
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_SAVED_NOTES_TOTAL, size);
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_SAVED_NOTES_IN_ROOT_FOLDER, i2);
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_SAVED_NOTES_IN_OVER_2_DEPTH_FOLDERS, size - i2);
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_SCREEN_OFF_NOTES, i4);
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_SAVED_NOTES_SET_FAVORITE, i5);
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_HAS_IMAGE_FILE_NOTES, i7);
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_CREATED_NEW_SDOCX_NOTES, size - i6);
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_CONVERTED_SDOCX_NOTES, all_ConvertedCount);
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_NOT_CONVERTED_SDOC_NOTES, i6);
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_HAS_BG_SDOCX_NOTES, i8);
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_SAVED_NOTES_SET_LOCK, i10);
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_CORRUPT_STATS, i9 > 0 ? "1" : "0");
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_NUMBER_OF_CORRUPT_NOTES, i9);
            int size2 = NotesDataRepositoryFactory.newInstance(this.mContext).createMainListDocumentDataRepository().getAllRecycleBinDataList(NotesUtils.getDeleteSortParam()).size();
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_RECYCLE_BIN_CONTENTS, size2);
            AbstractC6670b.m4736A(size2, "SANotesCount# trashCount : ", TAG);
            int notesCountUsingTag = NotesDataRepositoryFactory.newInstance(this.mContext).createDocumentTagRepository().getNotesCountUsingTag();
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_TAGS_NOTES, notesCountUsingTag);
            MainLogger.m7254d(TAG, "SANotesCount# usingTagCount : " + notesCountUsingTag);
            int sharedItemCount = NotesUtils.isMDEFeatureEnabled() ? SesShareReadResolver.getInstance().getSharedItemCount() : 0;
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_SHARED_NOTEBOOKS, sharedItemCount);
            MainLogger.m7254d(TAG, "SANotesCount# sharedItemCount : " + sharedItemCount);
            MainListDocumentDataRepository mainListDocumentDataRepositoryCreateMainListDocumentDataRepository = NotesDataRepositoryFactory.newInstance(this.mContext).createMainListDocumentDataRepository();
            int noteCountWithTitle = mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.getNoteCountWithTitle();
            int noteCountWithVoiceData = mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.getNoteCountWithVoiceData();
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_HAS_TITLE_NOTES, noteCountWithTitle);
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_COUNT_HAS_VOICE_RECORDING_NOTES, noteCountWithVoiceData);
            MainLogger.m7254d(TAG, "SANotesCount# hasTitleNoteCount : " + noteCountWithTitle + ", hasVoiceNoteCount : " + noteCountWithVoiceData);
        } catch (ConcurrentModificationException e) {
            MainLogger.m7255e(TAG, "SANotesCount# ConcurrentModificationException#" + e.getMessage());
        }
    }

    private void SASettingActionIcons() {
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_ACTION_ICON, SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ACTION_ICONS, true) ? "1" : "0");
    }

    private void SASettingsMainStatus() {
        boolean z = SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC, C0158a.m407a().m417k());
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_SYNC_STATUS, z ? C0145c.m299G(BaseUtils.getApplicationContext()) ? "a" : "b" : ((C13540g) C13541h.m14287e().f9588a).m14285a() ? "c" : "d");
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_SHOW_LINKS_IN_NOTES, SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES, true) ? "a" : "b");
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_SHOW_WEB_PREVIEW, SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS, false) ? "a" : "b");
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_SHOW_ACTION_ICON, SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ACTION_ICONS, true) ? "a" : "b");
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_HIDE_NAVIGATION_BAR, SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING, CommonUtils.isDefaultHideNavigationOptionEnabled()) ? "a" : "b");
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_SYNC_MS_ENABLED, (z && SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_MICROSOFT_SYNC, false)) ? "a" : "b");
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_AUTO_SAVE_NOTES, SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_AUTO_SAVE_NOTES, true) ? "a" : "b");
        if (SettingsMenuUtils.isClippingOptionsSupported() && SettingsMenuUtils.isClippingOptionsEnabled()) {
            CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_CLIPPING_OPTIONS, SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_CLIPPING_OPTIONS, true) ? "a" : "b");
        }
        if (SettingsMenuUtils.isUsePhoneAsToolbarSupported() && SettingsMenuUtils.isUsePhoneAsToolbarVisible()) {
            CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_SHOW_OPTIONS_TO_MOVE_PEN_TOOLS, SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_USE_PHONE_AS_TOOLBAR, true) ? "a" : "b");
        }
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING, SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING, false) ? "a" : "b");
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING, SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING, false) ? "a" : "b");
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_UNLOCK_METHOD, getNoteUnlockMethod());
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_QUICK_TOOLS, SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_QUICK_TOOLS, true) ? "1" : "2");
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_USE_PHONE_AS_TOOLBAR, SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_USE_PHONE_AS_TOOLBAR, true) ? "1" : "2");
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_DEFAULT_EDITING_MODE, getDefaultEditingModeDetail());
        CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_HANDWRITING_RECOGNITION, SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION, true) ? "1" : "2");
    }

    private void SASettingsNoteStyleStatus() {
        if (SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1) == 0) {
            CommonSamsungAnalytics.insertStatusLog("5850", "a");
        } else {
            boolean z = SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_SIZE, 0) == 0;
            boolean z2 = 1 == SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_SIZE, 0);
            boolean z3 = SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_PAGE_SCROLL_DIRECTION, true);
            boolean z4 = SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_LAYOUT_COLUMN, 1) == 1;
            if (z) {
                if (z3) {
                    CommonSamsungAnalytics.insertStatusLog("5850", "b");
                } else if (z4) {
                    CommonSamsungAnalytics.insertStatusLog("5850", "c");
                } else {
                    CommonSamsungAnalytics.insertStatusLog("5850", "d");
                }
            } else if (z2) {
                if (z3) {
                    CommonSamsungAnalytics.insertStatusLog("5850", "e");
                } else if (z4) {
                    CommonSamsungAnalytics.insertStatusLog("5850", "f");
                }
            } else if (z3) {
                CommonSamsungAnalytics.insertStatusLog("5850", "g");
            } else if (z4) {
                CommonSamsungAnalytics.insertStatusLog("5850", "h");
            }
        }
        if (SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_COLOR, BaseUtils.getContext().getColor(C8003R.color.background_color_white)) == BaseUtils.getContext().getColor(C8003R.color.background_color_white)) {
            CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_NEW_NOTE_PAGE_COLOR, "a");
        } else {
            CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_NEW_NOTE_PAGE_COLOR, "b");
        }
    }

    private void SASettingsNotesAssistStatus() {
        if (Features.isSupportAiFunction()) {
            CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_NOTES_ASSIST_SWITCH, AiActionStatus.isAiFeatureEnable() ? 1 : 0);
            String string = SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_NOTES_ASSIST_LANGUAGE_PACK_FOR_DOWNLOAD, "");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_NOTES_ASSIST_LANGUAGE_PACK, string);
        }
    }

    private void SASettingsScreenOffMemoStyleStatus() {
        int i = SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE, 0);
        if (i == 0) {
            CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_LOOK_WHEN_SAVED, "a");
        } else if (1 == i) {
            CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_LOOK_WHEN_SAVED, "b");
        } else if (2 == i) {
            CommonSamsungAnalytics.insertStatusLog(SettingsSAConstants.STATUS_SETTINGS_LOOK_WHEN_SAVED, "c");
        }
    }

    private void SASyncErrorStatus() {
        try {
            CommonSamsungAnalytics.insertStatusLog("5038", AbstractC0299q.m641m("5038"));
            AbstractC0299q.m629g("5038");
            CommonSamsungAnalytics.insertStatusLog("5039", SharedPreferencesCompat.getInstance("pref_sync_sa_logging_time").contains("5039") ? 1 : 0);
            C0145c.m302J("pref_sync_sa_logging_time", "5039");
            CommonSamsungAnalytics.insertStatusLog("5040", AbstractC0299q.m641m("5040"));
            AbstractC0299q.m629g("5040");
            CommonSamsungAnalytics.insertStatusLog("5041", AbstractC0299q.m641m("5041"));
            AbstractC0299q.m629g("5041");
            CommonSamsungAnalytics.insertStatusLog("5042", SharedPreferencesCompat.getInstance("pref_sync_sa_logging_time").contains("5042") ? 1 : 0);
            C0145c.m302J("pref_sync_sa_logging_time", "5042");
        } catch (Exception e) {
            Logger.m8702i("SyncSALoggingHelper", e.toString());
        }
        try {
            boolean zIsPowerSavingMode = DeviceUtils.isPowerSavingMode(BaseUtils.getApplicationContext());
            CommonSamsungAnalytics.insertStatusLog("5046", ((C13540g) C13541h.m14287e().f9588a).m14285a() ? SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SYNC_NOTES, AbstractC0146d.m345d(BaseUtils.getApplicationContext())) : false ? zIsPowerSavingMode ? "a" : "b" : zIsPowerSavingMode ? "c" : "d");
        } catch (Exception e2) {
            Logger.m8698e("SyncSALoggingHelper", e2.toString());
        }
    }

    private String getDefaultEditingModeDetail() {
        String string = SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE, SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE_AUTO);
        return SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE_AUTO.equals(string) ? "a" : SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE_HANDWRITING.equals(string) ? "b" : "c";
    }

    private String getNoteUnlockMethod() {
        return !LockUtils.isSetPassword(this.mContext) ? "1" : !SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_LOCK_BIOMETRICS_FINGERPRINT, false) ? "2" : "3";
    }

    public static String getSortTypeDetail(int i, int i2) {
        return i2 == 4 ? i == 0 ? "e" : i == 1 ? "a" : "c" : i == 0 ? "f" : i == 1 ? "b" : "d";
    }

    private boolean isAvailableSendLog() {
        return System.currentTimeMillis() > SharedPreferencesCompat.getInstance().getLong(Constants.PREF_KEY_SA_SEND_LOG_DATE, 0L) + 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logging(Map<String, NotesFolder> map, Map<String, MainListDocumentData> map2) {
        MainLogger.m7258i(TAG, "NotesListSALoggingHelper logging start");
        this.mContext = BaseUtils.getApplicationContext();
        SAGetUseSPenOnlyMode();
        SAGetUseFingerprint();
        SAGetUseIris();
        SASettingActionIcons();
        SAGetUsePassword();
        SAGetSamsungAccountAndSyncState();
        SAGetUseSyncOnlyWifi();
        SAFoldersCount(map);
        SANotesCount(map2);
        SAListSortType();
        SAListViewMode();
        SASettingsMainStatus();
        SASettingsNotesAssistStatus();
        SASettingsScreenOffMemoStyleStatus();
        SASettingsNoteStyleStatus();
        SASyncErrorStatus();
        SACoeditStatus();
        SACustomToolBarStatus();
        MainLogger.m7258i(TAG, "NotesListSALoggingHelper logging end");
    }

    private void writeSendLogDate() {
        SharedPreferencesCompat.getInstance().putLong(Constants.PREF_KEY_SA_SEND_LOG_DATE, System.currentTimeMillis());
    }

    public int getCoeditNoteCount() {
        return SharedPreferencesCompat.getInstance(Constants.PREF_FILE_SA_STATUS).getInt(Constants.PREF_KEY_SA_COEDIT_NOTE_COUNT, 0);
    }

    public int getCoeditSpaceCount() {
        return SharedPreferencesCompat.getInstance(Constants.PREF_FILE_SA_STATUS).getInt(Constants.PREF_KEY_SA_COEDIT_SPACE_COUNT, 0);
    }

    public int getCustomToolbarItemCount() {
        return SharedPreferencesCompat.getInstance(Constants.PREF_FILE_SA_STATUS).getInt(Constants.PREF_KEY_SA_CUSTOM_TOOLBAR_ITEM_COUNT, 0);
    }

    public void setCoeditNoteCount(int i) {
        SharedPreferencesCompat.getInstance(Constants.PREF_FILE_SA_STATUS).putInt(Constants.PREF_KEY_SA_COEDIT_NOTE_COUNT, i);
    }

    public void setCoeditSpaceCount(int i) {
        SharedPreferencesCompat.getInstance(Constants.PREF_FILE_SA_STATUS).putInt(Constants.PREF_KEY_SA_COEDIT_SPACE_COUNT, i);
    }

    public void setCustomToolbarItemCount(int i) {
        SharedPreferencesCompat.getInstance(Constants.PREF_FILE_SA_STATUS).putInt(Constants.PREF_KEY_SA_CUSTOM_TOOLBAR_ITEM_COUNT, i);
    }

    public void startStatusLogging(Map<String, NotesFolder> map, Map<String, MainListDocumentData> map2) {
        if (isAvailableSendLog()) {
            writeSendLogDate();
            new SALoggingTask(this, map, map2).execute(new Void[0]);
        }
    }
}
