package com.samsung.android.support.senl.p148nt.model.securefolder.common;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.constants.Constants;
import com.samsung.android.support.senl.p145cm.base.common.util.SystemVersionComparator;
import com.samsung.android.support.senl.p145cm.base.framework.emergencymode.EmergencyManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.securefolder.SecureFolderCompat;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.C11397R;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SecureFolderUtils {
    private static final String TAG = ModelLogger.createSecureFolderTag("SecureFolderUtils");
    private static SecureFolderInfo sSecureFolderInfo = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SecureFolderInfo {
        private final int mContainerId;
        private final String mMenuName;

        public SecureFolderInfo(int i, @NonNull String str) {
            this.mContainerId = i;
            this.mMenuName = str;
        }
    }

    public static void detachLockedSNote(Context context, String str) {
        IOException iOException;
        String str2;
        StringBuilder sb;
        SpenWNote spenWNoteOpen = null;
        try {
            try {
                spenWNoteOpen = DocumentFileManager.getInstance().open(context, str, SpenDocumentDisplayUtils.getScreenWidth(context), 9000, false, false);
                if (spenWNoteOpen.hasAttachedFile(Constants.SNote.WNOTE_LOCKED_FILE_KEY)) {
                    spenWNoteOpen.detachFile(Constants.SNote.WNOTE_LOCKED_FILE_KEY);
                    DocumentFileManager.getInstance().saveAsDirectory(spenWNoteOpen, str);
                }
                if (spenWNoteOpen.isClosed()) {
                    return;
                }
                try {
                    spenWNoteOpen.close(true);
                } catch (IOException e) {
                    iOException = e;
                    str2 = TAG;
                    sb = new StringBuilder("detachLockedSNote, close, e: ");
                    AbstractC11014a.m12332q(iOException, sb, str2);
                }
            } catch (Throwable th) {
                if (0 == 0 || spenWNoteOpen.isClosed()) {
                    throw th;
                }
                try {
                    spenWNoteOpen.close(true);
                    throw th;
                } catch (IOException e2) {
                    AbstractC11014a.m12332q(e2, new StringBuilder("detachLockedSNote, close, e: "), TAG);
                    throw th;
                }
            }
        } catch (SpenUnsupportedTypeException | SpenUnsupportedVersionException | IOException e3) {
            DataLogger.m12303e(TAG, "detachLockedSNote, e: " + e3.getMessage());
            if (spenWNoteOpen == null || spenWNoteOpen.isClosed()) {
                return;
            }
            try {
                spenWNoteOpen.close(true);
            } catch (IOException e5) {
                iOException = e5;
                str2 = TAG;
                sb = new StringBuilder("detachLockedSNote, close, e: ");
                AbstractC11014a.m12332q(iOException, sb, str2);
            }
        }
    }

    @NonNull
    public static synchronized String getMenuName(Context context) {
        if (!isActivated(context)) {
            DataLogger.m12302d(TAG, "getMenuName, not activated");
            return "";
        }
        SecureFolderInfo secureFolderInfo = sSecureFolderInfo;
        if (secureFolderInfo == null) {
            DataLogger.m12302d(TAG, "getMenuName, wrong info");
            return "";
        }
        return secureFolderInfo.mMenuName;
    }

    @NonNull
    public static String getTempDirPath(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath(), SecureFolderConstants.TEMP_FOLDER_NAME);
        if (file.exists() || file.mkdirs()) {
            return file.getAbsolutePath();
        }
        DataLogger.m12303e(TAG, "tempDir was not created");
        return "";
    }

    private static synchronized boolean isActivated(final Context context) {
        return SecureFolderCompat.isSupported(context, new SecureFolderCompat.SupportChecker() { // from class: com.samsung.android.support.senl.nt.model.securefolder.common.SecureFolderUtils.1
            private String getContainerName(String str) {
                return TextUtils.isEmpty(str) ? context.getString(C11397R.string.secure_folder) : str;
            }

            @Override // com.samsung.android.support.senl.cm.base.framework.securefolder.SecureFolderCompat.SupportChecker
            public void onContainerTypeSupported(int i, String str) {
                SecureFolderUtils.sSecureFolderInfo = new SecureFolderInfo(i, context.getString(C11397R.string.action_move_to, getContainerName(str)));
            }

            @Override // com.samsung.android.support.senl.cm.base.framework.securefolder.SecureFolderCompat.SupportChecker
            public void onPersonalTypeSupported(int i, String str) {
                SecureFolderUtils.sSecureFolderInfo = new SecureFolderInfo(i, context.getString(C11397R.string.action_move_out_of, getContainerName(str)));
            }
        });
    }

    public static boolean isEnabled(Context context) {
        return isMenuSupported(context) && isActivated(context);
    }

    public static boolean isMenuSupported(Context context) {
        if (SystemVersionComparator.isLessThan(29)) {
            DataLogger.m12302d(TAG, "isMenuSupported, less than Q OS");
            return false;
        }
        if (EmergencyManagerCompat.INSTANCE.getInstance().isEmergencyMode(context)) {
            DataLogger.m12302d(TAG, "isMenuSupported, Emergency Mode!");
            return false;
        }
        if (!UserManagerCompat.getInstance().isDigitalLegacyMode(context)) {
            return true;
        }
        DataLogger.m12302d(TAG, "isMenuSupported, isDigitalLegacyMode Mode!");
        return false;
    }

    public static boolean isSecureFolderMode() {
        return UserHandleCompat.getInstance().isSecureFolderMode();
    }

    public static synchronized boolean moveFiles(Context context, @NonNull List<String> list) {
        if (sSecureFolderInfo != null && !list.isEmpty()) {
            if (context == null) {
                DataLogger.m12309w(TAG, "moveFiles, context is null");
                return false;
            }
            return SecureFolderCompat.moveFiles(context, list, sSecureFolderInfo.mContainerId);
        }
        DataLogger.m12302d(TAG, "moveFiles, disabled");
        return false;
    }
}
