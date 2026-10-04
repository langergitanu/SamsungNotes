package com.samsung.android.support.senl.p148nt.app.common;

import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderConstants {
    public static final int FOLDER_MARK_COLOR_NONE = -1;
    public static final int HOLDER_MAX_DEPTH = 5;
    public static final String KEY_FOLDER_MODE_INDEX = "folder_mode";
    public static final String KEY_SOM_FOLDER_HAS_BADGE = "key_som_folder_has_badge";
    public static final String KEY_SOM_RECOGNIZE_MODIFIED_TIME = "key_som_modified_time";
    public static final int PAYLOAD_CHANGE_BADGE = 3;
    public static final int PAYLOAD_CHANGE_COUNT = 2;
    public static final int PAYLOAD_CHANGE_ICON = 0;
    public static final int PAYLOAD_CHANGE_TITLE = 1;
    public static final String PREF_FOLDER_INFO = "FolderInfo";
    public static final String PREF_MYFOLDERS_HAS_CHILD = "myfolders_has_child";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AddFolder {
        public static final String DISPLAY_NAME = "Add Folder";
        public static final String PATH = "addFolder:///";
        public static final String UUID = "addFolder:///";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AllNotes {
        public static final String DISPLAY_NAME;
        public static final String PATH;
        public static final String UUID;

        static {
            PredefinedCategory predefinedCategory = PredefinedCategory.ALL;
            UUID = predefinedCategory.getUuid();
            PATH = predefinedCategory.getPath();
            DISPLAY_NAME = predefinedCategory.getDisplayName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Coedit {
        public static final String DISPLAY_NAME;
        public static final String PATH;
        public static final String UUID;

        static {
            PredefinedCategory predefinedCategory = PredefinedCategory.COEDIT_NOTES;
            UUID = predefinedCategory.getUuid();
            PATH = predefinedCategory.getPath();
            DISPLAY_NAME = predefinedCategory.getDisplayName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ConvertedNotes {
        public static final String UUID = "old_converted_notes";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DialogTag {
        public static final String CHANGE_COLOR = "change_color_dialog";
        public static final String DELETE_FOLDER = "delete_confirm_dialog";
        public static final String FOLDER_NAME = "folder_name_dialog";
        public static final String MOVE_CONFIRM_FOLDER = "move_confirm_dialog";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Divider {
        public static final String DISPLAY_NAME = "Divider";
        public static final String PATH = "divider:///";
        public static final String UUID = "divider:///";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Favorite {
        public static final String DISPLAY_NAME = "Favorite";
        public static final String PATH = "favorite:///";
        public static final String UUID = "favorite:///";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface FolderManage {
        public static final String DISPLAY_NAME = "Folder Manage";
        public static final String PATH = "folderManage:///";
        public static final String UUID = "folderManage:///";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface FolderMove {
        public static final int ERROR = 1;
        public static final int MAX_DEPTH = 2;
        public static final int NONE = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FragmentTag {
        public static final String FOLDERLIST_FRAGMENT = "FolderListFragment";
        public static final String PHONE_DRAWER_FRAGMENT = "PhoneDrawerFragment";
        public static final String TABLET_DRAWER_FRAGMENT = "TabletDrawerFragment";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HolderType {
        public static final int ADD_FOLDER = 4;
        public static final int ALL_NOTES = 1002;
        public static final int COEDIT = 1008;
        public static final int DIVIDER = 1010;
        public static final int FAVOURITES = 1004;
        public static final int FOLDERS_MANAGE = 5;
        public static final int LOCKED_NOTES = 1005;
        public static final int MATH_NOTES = 2;
        public static final int MY_FOLDERS = 3;
        public static final int NORMAL = 0;
        public static final int OLD_NOTES = 1003;
        public static final int RECENTLY_IMPORTED = 1006;
        public static final int RECYCLE_BIN = 1009;
        public static final int SCREEN_OFF_MEMO = 1;
        public static final int SETTING = 1001;
        public static final int SHARED_NOTEBOOK = 1007;
        public static final int TYPE_DRAWER_PHONE = 2048;
        public static final int TYPE_DRAWER_PHONE_FREE_FORM_WINDOW = 4096;
        public static final int TYPE_DRAWER_TABLET = 1024;

        public static boolean isDefaultFolderType(int i) {
            if (i == 3) {
                return true;
            }
            switch (i) {
                case 1001:
                case 1002:
                case 1003:
                case 1004:
                case 1005:
                case 1006:
                case 1007:
                case 1008:
                case 1009:
                case 1010:
                    return true;
                default:
                    return false;
            }
        }

        public static boolean isExecuteType(int i) {
            return i == 5 || i == 1001;
        }

        public static boolean isRequireServerSyncType(int i) {
            return i == 1007;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Lock {
        public static final String DISPLAY_NAME = "Lock";
        public static final String PATH = "lock:///";
        public static final String UUID = "lock:///";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MathNotes {
        public static final String DISPLAY_NAME;
        public static final String UUID;

        static {
            PredefinedCategory predefinedCategory = PredefinedCategory.MATH_NOTES;
            UUID = predefinedCategory.getUuid();
            DISPLAY_NAME = predefinedCategory.getDisplayName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Mode {
        public static final int BASE = -1;
        public static final int MANAGE = 2;
        public static final int MANAGE_EDIT = 3;
        public static final int MANAGE_SYNC = 4;
        public static final int PICK = 1;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MyFolders {
        public static final String DISPLAY_NAME = "Folders";
        public static final String PATH;
        public static final String UUID;

        static {
            PredefinedCategory predefinedCategory = PredefinedCategory.UNCATEGORIZED;
            UUID = predefinedCategory.getUuid();
            PATH = predefinedCategory.getPath();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OldNotes {
        public static final String DISPLAY_NAME;
        public static final String PATH;
        public static final String UUID;

        static {
            PredefinedCategory predefinedCategory = PredefinedCategory.OLD_NOTES;
            UUID = predefinedCategory.getUuid();
            PATH = predefinedCategory.getPath();
            DISPLAY_NAME = predefinedCategory.getDisplayName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OldScreenOffMemo {
        public static final String UUID = "2";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OldUncategorized {
        public static final String UUID = "1";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface RecentlyImported {
        public static final String DISPLAY_NAME = "Recently Imported";
        public static final String PATH = "recentlyImported:///";
        public static final String UUID = "recentlyImported:///";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface RecycleBin {
        public static final String DISPLAY_NAME;
        public static final String PATH;
        public static final String UUID;

        static {
            PredefinedCategory predefinedCategory = PredefinedCategory.RECYCLE_BIN;
            UUID = predefinedCategory.getUuid();
            PATH = predefinedCategory.getPath();
            DISPLAY_NAME = predefinedCategory.getDisplayName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ScreenOffMemo {
        public static final String DISPLAY_NAME;
        public static final String UUID;

        static {
            PredefinedCategory predefinedCategory = PredefinedCategory.SCREEN_OFF_MEMO;
            UUID = predefinedCategory.getUuid();
            DISPLAY_NAME = predefinedCategory.getDisplayName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Settings {
        public static final String DISPLAY_NAME = "Settings";
        public static final String PATH = "settings:///";
        public static final String UUID = "settings:///";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SharedNotes {
        public static final String DISPLAY_NAME;
        public static final String PATH;
        public static final String UUID;

        static {
            PredefinedCategory predefinedCategory = PredefinedCategory.SHARED_NOTE_BOOK;
            UUID = predefinedCategory.getUuid();
            PATH = predefinedCategory.getPath();
            DISPLAY_NAME = predefinedCategory.getDisplayName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Tag {
        public static final String DISPLAY_NAME = "Tag";
        public static final String PATH = "tag:///";
        public static final String UUID = "tag:///";
    }
}
