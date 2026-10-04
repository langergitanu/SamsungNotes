package com.samsung.android.support.senl.p148nt.model.securefolder.common;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SecureFolderConstants {
    public static final String ACTION_NOTE_FILE_MOVED_DONE = "com.samsung.android.app.notes.model.ACTION_FILE_OPERATIONS_DONE";
    public static final String AUTHORITY = "com.samsung.android.app.notes.movenote";
    public static final String KEY_DELETE_FILE_PATH = "deletedFilePath";
    public static final String PREFIX_FROM_SECURE_FOLDER = "FromFS_";
    public static final String PREFIX_TO_SECURE_FOLDER = "FromPS_";
    public static final String SECURE_FOLDER_PACKAGE = "com.samsung.knox.securefolder";
    public static final String TEMP_FOLDER_NAME = "move";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ExportType {
        ToSecureFolder(SecureFolderConstants.PREFIX_TO_SECURE_FOLDER),
        ToNormalFolder(SecureFolderConstants.PREFIX_FROM_SECURE_FOLDER);

        private final String mExportFilePrefix;

        ExportType(String str) {
            this.mExportFilePrefix = str;
        }

        public String getPrefix() {
            return this.mExportFilePrefix;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ImportType {
        FromSecureFolder(SecureFolderConstants.PREFIX_FROM_SECURE_FOLDER, SecureFolderConstants.PREFIX_TO_SECURE_FOLDER),
        FromNormalFolder(SecureFolderConstants.PREFIX_TO_SECURE_FOLDER, SecureFolderConstants.PREFIX_FROM_SECURE_FOLDER);

        private final String mDeleteFilePrefix;
        private final String mImportFilePrefix;

        ImportType(String str, String str2) {
            this.mImportFilePrefix = str;
            this.mDeleteFilePrefix = str2;
        }

        public String getDeleteFilePrefix() {
            return this.mDeleteFilePrefix;
        }

        public String getImportFilePrefix() {
            return this.mImportFilePrefix;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface Result {
        public static final int ERROR_FAILED = 1;
        public static final int ERROR_SECURE_FOLDER_DISABLED = 2;
        public static final int SUCCESS = 0;
    }
}
