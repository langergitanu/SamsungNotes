package com.samsung.android.support.senl.p148nt.app.common.util;

import android.content.Context;
import android.os.Environment;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.importer.data.ImportDocument;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import p084U0.C0312d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DemoUtils {
    private static final String LDU_OUTPUT_DIR = "/RetailMedia/SamsungNotes/3";
    private static final String LDU_PREFIX = "LDU_";
    private static final String LDU_TAG = "DemoUtils$LDU";
    private static final String TAG = "DemoUtils$";
    private static final String UNPACK_ASSET_SDOC = "unpack_sdoc";
    private static final String UNPACK_OUTPUT_DIR = "/LiveDemo/SamsungNotes/0";
    private static final String UNPACK_PREFIX = "UNPACK_";
    private static final String UNPACK_TAG = "DemoUtils$UNPACK";

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean compareFileExtension(String str) {
        return str.substring(str.lastIndexOf(46) + 1).equalsIgnoreCase("sdocx");
    }

    private static boolean copyDocFromAsset(Context context, File file) {
        boolean z;
        boolean z2 = false;
        if (!file.exists() && !file.mkdirs()) {
            MainLogger.m7258i(UNPACK_TAG, "not found and not made dir : " + file.getAbsolutePath());
            return false;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        try {
            z = false;
            for (String str : context.getResources().getAssets().list(UNPACK_ASSET_SDOC)) {
                try {
                    if (compareFileExtension(str)) {
                        File file2 = new File(file, str);
                        z = true;
                        try {
                            InputStream inputStreamOpen = context.getResources().getAssets().open("unpack_sdoc/" + str);
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                try {
                                    byte[] bArr = new byte[4096];
                                    while (true) {
                                        int i = inputStreamOpen.read(bArr);
                                        if (i == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, i);
                                    }
                                    sb2.append(file2);
                                    sb2.append(" ");
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                    inputStreamOpen.close();
                                } catch (Throwable th) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                if (inputStreamOpen != null) {
                                    try {
                                        inputStreamOpen.close();
                                    } catch (Throwable th4) {
                                        th3.addSuppressed(th4);
                                    }
                                }
                                throw th3;
                            }
                        } catch (FileNotFoundException e) {
                            MainLogger.m7255e(UNPACK_TAG, "can't copy doc from asset : " + e.getMessage());
                        }
                    } else {
                        sb.append(str);
                        sb.append(" ");
                    }
                } catch (IOException e2) {
                    e = e2;
                    z2 = z;
                    MainLogger.m7255e(UNPACK_TAG, "can't access doc at asset : " + e.getMessage());
                    z = z2;
                    MainLogger.m7258i(UNPACK_TAG, "file extension not matched : " + ((Object) sb));
                    MainLogger.m7258i(UNPACK_TAG, "copy from asset : " + ((Object) sb2));
                    return z;
                }
            }
        } catch (IOException e3) {
            e = e3;
        }
        MainLogger.m7258i(UNPACK_TAG, "file extension not matched : " + ((Object) sb));
        MainLogger.m7258i(UNPACK_TAG, "copy from asset : " + ((Object) sb2));
        return z;
    }

    private static void enrollSDocx(Context context, File[] fileArr, String str, String str2) {
        if (fileArr == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (File file : fileArr) {
            String absolutePath = file.getAbsolutePath();
            String str3 = WDocUtils.getNoteFilePath(context) + str + new File(absolutePath).getName();
            try {
            } catch (IOException e) {
                MainLogger.m7255e(str2, "enrollSDocx# " + e.getMessage());
            }
            if (new File(str3).exists()) {
                sb.append(str3);
                sb.append(' ');
            } else {
                BaseUtils.copyFile(absolutePath, str3);
                arrayList.add(new ImportDocument(str3, null));
                sb2.append(str3);
                sb2.append(' ');
            }
        }
        MainLogger.m7258i(str2, "enrollSDocx# # exist file - [ " + MainLogger.getEncode(sb.toString()) + " ]\n");
        MainLogger.m7258i(str2, "enrollSDocx# [ " + MainLogger.getEncode(sb2.toString()) + " ]\n");
        if (arrayList.isEmpty()) {
            return;
        }
        C0312d c0312d = new C0312d(context, arrayList, str2);
        c0312d.f806k = true;
        c0312d.m664c(false);
    }

    private static String[] getSdocxFileNames(File file) {
        return file.list(new FilenameFilter() { // from class: com.samsung.android.support.senl.nt.app.common.util.DemoUtils.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return DemoUtils.compareFileExtension(str);
            }
        });
    }

    public static void loadLDUFile(Context context) {
        MainLogger.m7258i(LDU_TAG, "loadLDUFile#");
        if (!PermissionHelper.isPermissionGrantedWithoutNotice(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            MainLogger.m7258i(LDU_TAG, "loadLDUFile# no permission");
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + LDU_OUTPUT_DIR);
        String[] sdocxFileNames = getSdocxFileNames(file);
        if (!file.exists() || sdocxFileNames == null || sdocxFileNames.length <= 0) {
            return;
        }
        MainLogger.m7258i(LDU_TAG, "load sdocx");
        enrollSDocx(context, file.listFiles(), LDU_PREFIX, LDU_TAG);
    }

    public static void loadUnpackFile(Context context) {
        MainLogger.m7258i(UNPACK_TAG, "load unpack file");
        if (!PermissionHelper.isPermissionGrantedWithoutNotice(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            MainLogger.m7258i(LDU_TAG, "loadUnpackFile# no permission");
            return;
        }
        File file = new File(AbstractC0541b.m756B(Environment.getExternalStorageDirectory().getAbsolutePath(), UNPACK_OUTPUT_DIR));
        String[] sdocxFileNames = getSdocxFileNames(file);
        if ((!file.exists() || sdocxFileNames == null || sdocxFileNames.length <= 0) && !copyDocFromAsset(context, file)) {
            return;
        }
        MainLogger.m7258i(UNPACK_TAG, "load sdocx");
        enrollSDocx(context, file.listFiles(), UNPACK_PREFIX, UNPACK_TAG);
    }
}
