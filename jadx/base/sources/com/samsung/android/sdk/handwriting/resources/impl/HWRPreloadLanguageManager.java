package com.samsung.android.sdk.handwriting.resources.impl;

import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p009B3.C0035a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HWRPreloadLanguageManager {
    private static final String RM_RES_DATA_DIRNAME = "data";
    private static final String TAG = "HWRPreloadLanguageManager";
    private static final String RM_PRELOAD_ROOT_DIR_PRISM_PATH = "/prism/HWRDB/";
    private static final String RM_PRELOAD_ROOT_DIR_PRODUCT_PATH = "/product/HWRDB/";
    private static final String RM_PRELOAD_ROOT_DIR_ODM_PATH = "/odm/HWRDB/";
    private static final String RM_PRELOAD_ROOT_DIR_OMC_PATH = "/system/omc/HWRDB/";
    private static final String RM_PRELOAD_ROOT_DIR_PATH = "/system/HWRDB/";
    private static final String[] PRELOAD_PATHS = {RM_PRELOAD_ROOT_DIR_PRISM_PATH, RM_PRELOAD_ROOT_DIR_PRODUCT_PATH, RM_PRELOAD_ROOT_DIR_ODM_PATH, RM_PRELOAD_ROOT_DIR_OMC_PATH, RM_PRELOAD_ROOT_DIR_PATH};
    private static String mPreloadRootDirPath = "";

    private static String getLocaleFromFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strM1614d = AbstractC2322a.m1614d(4, 4, str);
        return "sr_Latn_RS".equals(strM1614d) ? "sr_RS" : strM1614d;
    }

    public static List<String> getPreloadedLanguages() {
        setPreloadRootDirectoryPath();
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(mPreloadRootDirPath)) {
            Log.e(TAG, "getPreloadedLanguages : mPreloadRootDirPath is empty!");
            return arrayList;
        }
        if (!readExistingPreloadedResList(new File(mPreloadRootDirPath), arrayList)) {
            Log.e(TAG, "getPreloadedLanguages : Cannot read preload languages!");
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$readExistingPreloadedResList$0(File file, String str) {
        return str.startsWith("data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$readExistingPreloadedResList$1(File file, String str) {
        return str.endsWith(".dat");
    }

    private static boolean readExistingPreloadedResList(File file, List<String> list) {
        String[] list2;
        if (!file.isDirectory()) {
            return false;
        }
        String[] list3 = file.list(new C0035a(2));
        if (list3 == null || list3.length <= 0) {
            return true;
        }
        for (String str : list3) {
            File file2 = new File(file, str);
            if (file2.isDirectory() && (list2 = file2.list(new C0035a(3))) != null && list2.length > 0) {
                for (String str2 : list2) {
                    list.add(getLocaleFromFileName(str2));
                }
            }
        }
        return true;
    }

    private static void setPreloadRootDirectoryPath() {
        if (!TextUtils.isEmpty(mPreloadRootDirPath)) {
            AbstractC11014a.m12338w(new StringBuilder("setPreloadRootDirectoryPath : mPreloadRootDirPath is "), mPreloadRootDirPath, TAG);
            return;
        }
        String[] strArr = PRELOAD_PATHS;
        if (strArr == null) {
            Log.e(TAG, "setPreloadRootDirectoryPath : predefined path list is not set!");
            return;
        }
        for (String str : strArr) {
            Log.i(TAG, "setPreloadRootDirectoryPath : checking preload path : " + str);
            File file = new File(str);
            if (file.isDirectory() && file.exists()) {
                mPreloadRootDirPath = str;
                AbstractC11014a.m12338w(new StringBuilder("setPreloadRootDirectoryPath : mPreloadRootDirPath is set with "), mPreloadRootDirPath, TAG);
                return;
            }
        }
        Log.e(TAG, "setPreloadRootDirectoryPath : There are no preload paths in anywhere!");
    }
}
