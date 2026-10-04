package com.samsung.android.support.senl.p148nt.data.common.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentExtension;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import java.io.File;
import java.util.Objects;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesDocumentFileUtils {
    public static final String TAG = DataLogger.createTag("NotesDocumentFileUtils");
    private static String sPreviousUuid;

    private static synchronized String createFileName(Context context) {
        String strNewUUID;
        while (true) {
            String str = sPreviousUuid;
            strNewUUID = UUIDUtils.newUUID(context);
            if (Objects.equals(str, strNewUUID)) {
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    DataLogger.m12303e(TAG, "createFileName, e : " + e.getMessage());
                }
            } else {
                sPreviousUuid = strNewUUID;
            }
        }
        return strNewUUID;
    }

    @NonNull
    public static String createPdfWriterSavePath(String str, String str2) {
        String strM1626p = AbstractC2322a.m1626p(AbstractC1974b.m1324q(str), File.separator, str2, ".sdocx");
        String str3 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("createPdfWriterSavePath, uuid/savePath : ", str2, " / ");
        sbM15l.append(DataLogger.getEncode(strM1626p));
        DataLogger.m12307i(str3, sbM15l.toString());
        return strM1626p;
    }

    @NonNull
    public static String createSavePathWithPrefix(Context context, String str, @DocumentExtension String str2) {
        return createSavePathWithPrefix(context, WDocUtils.getNoteFilePath(context), str, str2);
    }

    @NonNull
    public static String createSavedPath(Context context, String str, String str2, @DocumentExtension String str3) {
        String str4 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("createSavedPath, uuid : ", str, ", savePath : ");
        sbM15l.append(DataLogger.getEncode(str2));
        DataLogger.m12307i(str4, sbM15l.toString());
        return !TextUtils.isEmpty(str2) ? str2 : createSavePathWithPrefix(context, "", str3);
    }

    public static String createSavedPathWithDir(Context context, @NonNull String str, @DocumentExtension String str2) {
        String str3 = File.separator;
        if (!str.endsWith(str3)) {
            str = AbstractC0541b.m756B(str, str3);
        }
        return createSavePathWithPrefix(context, str, "", str2);
    }

    @NonNull
    private static String createSavePathWithPrefix(Context context, String str, String str2, @DocumentExtension String str3) {
        String str4 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("createSavedPath, fileExtension : ", str3, " with prefix = ");
        sbM15l.append(DataLogger.getEncode(str2));
        DataLogger.m12307i(str4, sbM15l.toString());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        String strM1170p = AbstractC0622a.m1170p(createFileName(context), str3, sb);
        DataLogger.m12302d(str4, "createSavedPath, create new savePath : " + DataLogger.getEncode(strM1170p));
        return strM1170p;
    }

    @NonNull
    public static String createSavedPath(Context context, @DocumentExtension String str) {
        return createSavePathWithPrefix(context, "", str);
    }
}
