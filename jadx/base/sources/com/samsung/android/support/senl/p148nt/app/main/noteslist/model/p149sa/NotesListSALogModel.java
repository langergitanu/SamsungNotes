package com.samsung.android.support.senl.p148nt.app.main.noteslist.model.p149sa;

import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesListSALogModel {
    private static void addSAStatusLogOnNewNotes(int i, String str) {
        if (FolderConstants.AllNotes.UUID.equals(str)) {
            if (i == 1) {
                CommonSamsungAnalytics.insertStatusLog("9985", "In App_Tab All_Finger");
                return;
            } else {
                CommonSamsungAnalytics.insertStatusLog("9985", "In App_Tab All_Spen");
                return;
            }
        }
        if (i == 1) {
            CommonSamsungAnalytics.insertStatusLog("9985", "In Category_Tab Collection_Finger");
        } else {
            CommonSamsungAnalytics.insertStatusLog("9985", "In Category_Tab Collection_Spen");
        }
    }

    public static void addSAlogOnBackKeyDown(String str) {
        if (StorageUtils.isAvailableMinimumMemory()) {
            if (FolderConstants.AllNotes.UUID.equals(str)) {
                CommonSamsungAnalytics.insertLog("101");
                return;
            }
            if ("favorite:///".equals(str)) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_FAVORITES);
                return;
            }
            if ("lock:///".equals(str)) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_LOCKED_NOTES);
                return;
            }
            if ("recentlyImported:///".equals(str)) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_RECENTLY_IMPORTED);
                return;
            }
            if (FolderConstants.RecycleBin.UUID.equals(str)) {
                CommonSamsungAnalytics.insertLog("531");
                return;
            }
            if (FolderConstants.ScreenOffMemo.UUID.equals(str)) {
                CommonSamsungAnalytics.insertLog("202");
                return;
            }
            if ("tag:///".equals(str)) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_HASHTAG_NOTES);
                return;
            }
            if (FolderConstants.SharedNotes.UUID.equals(str)) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_SPACE_SELECT);
            } else if (FolderConstants.OldNotes.UUID.equals(str)) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_OLDNOTE_SELECT);
            } else {
                CommonSamsungAnalytics.insertLog("201");
            }
        }
    }

    public static void addSAlogOnItemLongPressedForFilterFolder(String str) {
        if (FolderConstants.AllNotes.UUID.equals(str)) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MAIN_EDIT);
            return;
        }
        if ("favorite:///".equals(str)) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_FAVORITES_EDIT);
            return;
        }
        if ("lock:///".equals(str)) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_LOCKED_NOTES_EDIT);
        } else if (FolderConstants.ScreenOffMemo.UUID.equals(str)) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_SCREEN_OFF_MEMO_EDIT);
        } else {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MAIN_EDIT);
        }
    }

    public static void addSAlogOnNewNote(boolean z, int i, int i2, String str) {
        CommonSamsungAnalytics.insertLog(i == 1 ? getSAScreenIDInSelectModeForFilterFolder(str) : i == 7 ? NotesSAConstants.SCREEN_PICK : i == 10 ? NotesSAConstants.SCREEN_GCS_SPACE_SELECT : "101", z ? NotesSAConstants.EVENT_TABLET_CREATE_NOTE : "0003", i2 == 1 ? "1" : "2");
        addSAStatusLogOnNewNotes(i2, str);
    }

    public static void addSAlogOnOptionsItemSelected(int i, int i2, boolean z, int i4, String str) {
        String sALogScreenIdOnEditMode = getSALogScreenIdOnEditMode(i, str);
        if (i != 2) {
            if (i == 4) {
                if (i2 == C8003R.id.action_delete) {
                    CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_SEARCH_DELETE, i4);
                    return;
                }
                if (i2 == C8003R.id.action_save_as_file) {
                    CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_SEARCH_SAVE_AS_FILE, i4);
                    return;
                }
                if (i2 == C8003R.id.action_share) {
                    CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_SEARCH_SHARE, i4);
                    return;
                }
                if (i2 == C8003R.id.action_move) {
                    CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_SEARCH_MOVE, i4);
                    return;
                }
                if (i2 != C8003R.id.action_lock) {
                    if (i2 == C8003R.id.action_secure_folder_move) {
                        CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_SEARCH_MOVE_TO_SECURE_FOLDER);
                        return;
                    }
                    return;
                } else if (z) {
                    CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_SEARCH_LOCK, "0");
                    return;
                } else {
                    CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_SEARCH_LOCK, "1");
                    return;
                }
            }
            if (i != 19) {
                return;
            }
        }
        if (i2 == C8003R.id.action_delete) {
            CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_NOTESLIST_DELETE, i4);
            return;
        }
        if (i2 == C8003R.id.action_save_as_file) {
            CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_NOTESLIST_SAVE_AS_FILE, i4);
            return;
        }
        if (i2 == C8003R.id.action_share) {
            CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_NOTESLIST_SHARE, i4);
            return;
        }
        if (i2 == C8003R.id.action_rename) {
            CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_NOTESLIST_RENAME);
            return;
        }
        if (i2 == C8003R.id.action_move) {
            CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_NOTESLIST_MOVE, i4);
            return;
        }
        if (i2 == C8003R.id.action_lock) {
            if (z) {
                CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, "2035", "0");
                return;
            } else {
                CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, "2035", "1");
                return;
            }
        }
        if (i2 == C8003R.id.action_secure_folder_move) {
            CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_NOTESLIST_MOVE_TO_SECURE_FOLDER);
            return;
        }
        if (i2 == C8003R.id.action_duplicate) {
            CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVNET_NOTESLIST_DUPLICATE);
            return;
        }
        if (i2 == C8003R.id.action_add_to_favorites) {
            CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_NOTESLIST_SET_FAVORITES, "a");
        } else if (i2 == C8003R.id.action_remove_from_favorites) {
            CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_NOTESLIST_SET_FAVORITES, "b");
        } else if (i2 == C8003R.id.action_change_color) {
            CommonSamsungAnalytics.insertLog(sALogScreenIdOnEditMode, NotesSAConstants.EVENT_NOTESLIST_FOLDER_COLOR);
        }
    }

    public static void addSAlogOnResume(int i, String str) {
        if (StorageUtils.isAvailableMinimumMemory()) {
            if (FeatureUtils.isCoeditMode(i)) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN);
                return;
            }
            if (FeatureUtils.isCoeditSpaceMode(i)) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE);
                return;
            }
            if (FeatureUtils.isEditMode(i)) {
                if (i == 6) {
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_RECYCLEBIN_EDIT);
                    return;
                }
                if (i == 4) {
                    CommonSamsungAnalytics.insertLog("222");
                    return;
                }
                if (i == 22) {
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_OLDNOTE_EDIT);
                    return;
                }
                if (i == 11) {
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_SPACE_EDIT);
                    return;
                }
                if (i == 8) {
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_PICK_EDIT);
                    return;
                } else if (i == 19) {
                    CommonSamsungAnalytics.insertLog("122");
                    return;
                } else {
                    CommonSamsungAnalytics.insertLog(getSAScreenIDInEditModeForFilterFolder(str));
                    return;
                }
            }
            if (i == 5) {
                CommonSamsungAnalytics.insertLog("531");
                return;
            }
            if (i == 3) {
                CommonSamsungAnalytics.insertLog("221");
                return;
            }
            if (i == 21) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_OLDNOTE_SELECT);
                return;
            }
            if (i == 10) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_SPACE_SELECT);
                return;
            }
            if (i == 7) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_PICK);
            } else if (i == 18) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_HASHTAG_NOTES);
            } else {
                CommonSamsungAnalytics.insertLog(getSAScreenIDInSelectModeForFilterFolder(str));
            }
        }
    }

    public static void addSAlogOnSelectAll(int i, boolean z, String str) {
        if (i == 6) {
            CommonSamsungAnalytics.insertLog("531", NotesSAConstants.EVENT_RECYCLEBIN_SELECT_ALL, z ? "1" : "0");
            return;
        }
        if (i == 4) {
            CommonSamsungAnalytics.insertLog("222", NotesSAConstants.EVENT_SEARCH_SELECT_ALL, z ? "1" : "0");
            return;
        }
        if (i == 22) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_OLDNOTE_EDIT, NotesSAConstants.EVENT_OLDNOTES_SELECT_ALL, z ? "1" : "0");
            return;
        }
        if (i == 11) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_SPACE_EDIT, NotesSAConstants.EVENT_GCS_SPACE_SELECT_ALL, z ? "1" : "0");
            return;
        }
        if (i == 8) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_PICK_EDIT, NotesSAConstants.EVENT_PICK_EDIT_SELECT_ALL, z ? "1" : "0");
        } else if (i == 19) {
            CommonSamsungAnalytics.insertLog("122", NotesSAConstants.EVENT_NOTESLIST_SELECT_ALL, z ? "1" : "0");
        } else {
            CommonSamsungAnalytics.insertLog(getSAScreenIDInEditModeForFilterFolder(str), NotesSAConstants.EVENT_NOTESLIST_SELECT_ALL, z ? "1" : "0");
        }
    }

    public static String getSALogScreenIdOnEditMode(int i, String str) {
        return i == 2 ? getSAScreenIDInEditModeForFilterFolder(str) : i == 4 ? "222" : i == 19 ? "122" : NotesSAConstants.SCREEN_MAIN_EDIT;
    }

    public static String getSAScreenIDInEditModeForFilterFolder(String str) {
        return FolderConstants.AllNotes.UUID.equals(str) ? NotesSAConstants.SCREEN_MAIN_EDIT : "favorite:///".equals(str) ? NotesSAConstants.SCREEN_FAVORITES_EDIT : "lock:///".equals(str) ? NotesSAConstants.SCREEN_LOCKED_NOTES_EDIT : FolderConstants.ScreenOffMemo.UUID.equals(str) ? NotesSAConstants.SCREEN_SCREEN_OFF_MEMO_EDIT : NotesSAConstants.SCREEN_MAIN_EDIT;
    }

    public static String getSAScreenIDInSelectModeForFilterFolder(String str) {
        return FolderConstants.AllNotes.UUID.equals(str) ? "101" : "favorite:///".equals(str) ? NotesSAConstants.SCREEN_FAVORITES : "lock:///".equals(str) ? NotesSAConstants.SCREEN_LOCKED_NOTES : "recentlyImported:///".equals(str) ? NotesSAConstants.SCREEN_RECENTLY_IMPORTED : FolderConstants.ScreenOffMemo.UUID.equals(str) ? "202" : "201";
    }
}
