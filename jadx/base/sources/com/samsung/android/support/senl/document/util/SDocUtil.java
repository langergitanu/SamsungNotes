package com.samsung.android.support.senl.document.util;

import android.content.Context;
import android.os.Build;
import com.samsung.android.support.senl.document.delegator.AppDelegator;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SDocUtil {
    private static final String STR_USER_MODE = "[##### User mode]";
    private static final boolean mIsEngineerMode = "eng".equals(Build.TYPE);

    private SDocUtil() {
    }

    public static int getNoteCount(Context context) {
        return getNoteList(context).size();
    }

    private static List<String> getNoteList(Context context) {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = new File(AppDelegator.getInstance().getNoteFilePath(context)).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                String name = file.getName();
                String strSubstring = name.substring(name.lastIndexOf(Extension.DOT) + 1);
                if (strSubstring.equals("sdoc") || strSubstring.equals("snb") || strSubstring.equals("spd")) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
        }
        return arrayList;
    }

    public static String logPath(String str) {
        return mIsEngineerMode ? str : STR_USER_MODE;
    }
}
