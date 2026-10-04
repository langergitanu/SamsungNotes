package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.dex;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DoPControlClipData {
    private static final String DOP_DRAGNDROP_DST_FOLDER = "dstFolderUri";
    private static final String DOP_DRAGNDROP_DST_FOLDER_NAME = "SamsungNotes's temp folder";
    private static final String DOP_DRAGNDROP_LABEL = "startDoPDrag";
    private static final String PACKAGE_NAME_DEXONPC = "com.sec.android.app.dexonpc.dstFolder";
    public static final String PERMISSION_NAME_DEXONPC = "dexonpc.app.action.permission.KMS_FILETRANSFER_DRAG_FILEINFO";
    private static final String TAG = Logger.createTag("DoPControlClipData");

    public static void clearDownloadDir() {
        Logger.m10999d(TAG, "clearDownloadDir# ");
        File downloadDir = getDownloadDir(false);
        if (downloadDir == null) {
            return;
        }
        File[] fileArrListFiles = downloadDir.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }
        downloadDir.delete();
    }

    private static ArrayList<ClipData.Item> convertItems(ArrayList<String> arrayList) {
        ArrayList<ClipData.Item> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new ClipData.Item(getUri(it.next().replace("//", "/"))));
        }
        return arrayList2;
    }

    public static ClipData convertUriToClipItem(Intent intent) {
        ArrayList<String> stringArrayListExtra;
        Logger.m10999d(TAG, "convertUriToClipItem# " + intent);
        String stringExtra = intent.getStringExtra("fileUri");
        if (TextUtils.isEmpty(stringExtra)) {
            stringArrayListExtra = intent.getStringArrayListExtra("fileUriList");
        } else {
            stringArrayListExtra = new ArrayList<>(1);
            stringArrayListExtra.add(stringExtra);
        }
        ArrayList<ClipData.Item> arrayListConvertItems = convertItems(stringArrayListExtra);
        ClipData clipData = new ClipData("DoP", new String[]{"application/octet-stream"}, arrayListConvertItems.get(0));
        for (int i = 1; i < stringArrayListExtra.size(); i++) {
            clipData.addItem(arrayListConvertItems.get(i));
        }
        return clipData;
    }

    public static void getDoPDataFromClipData(ClipData clipData) {
        PersistableBundle extras = clipData.getDescription().getExtras();
        int i = extras != null ? extras.getInt("id", -1) : -1;
        ArrayList arrayList = new ArrayList();
        int itemCount = clipData.getItemCount();
        for (int i2 = 0; i2 < itemCount; i2++) {
            arrayList.add(clipData.getItemAt(i2).getUri().getPath());
        }
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "getDoPDataFromClipData : ", " : ");
        sbM778t.append(Logger.getEncode(arrayList.toString()));
        Logger.m10999d(str, sbM778t.toString());
    }

    private static File getDownloadDir(boolean z) {
        if (CommonUtil.isSos()) {
            Logger.m10999d(TAG, "getDownloadDir# Platform is more than S os. return null");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath());
        File file = new File(AbstractC0622a.m1170p(File.separator, DOP_DRAGNDROP_DST_FOLDER_NAME, sb));
        if (!file.exists()) {
            if (!z) {
                return null;
            }
            if (!file.mkdir()) {
                Logger.m11000e(TAG, "fail to mkdir ");
                return null;
            }
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                if (!file2.createNewFile()) {
                    Logger.m11000e(TAG, "fail to create noMediaFile");
                    return null;
                }
            } catch (IOException unused) {
                Logger.m10999d(TAG, "getDownloadDir, failed to create .nomedia");
                return null;
            }
        }
        return file;
    }

    public static int getEventIdInClipData(ClipData clipData) {
        PersistableBundle extras = clipData.getDescription().getExtras();
        if (extras != null) {
            return extras.getInt("id", -1);
        }
        return -1;
    }

    @Nullable
    private static Uri getUri(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        return Uri.parse("file://" + file.getAbsolutePath());
    }

    public static boolean isDoPDrop(String str) {
        boolean z = !TextUtils.isEmpty(str) && DOP_DRAGNDROP_LABEL.equalsIgnoreCase(str);
        Logger.m10999d(TAG, "isDoPDrop, clipLabel: " + str + ", result: " + z);
        return z;
    }

    public static void sendResponseBroadcast(Context context, ClipData clipData) {
        int eventIdInClipData = getEventIdInClipData(clipData);
        Intent intent = new Intent(PACKAGE_NAME_DEXONPC);
        intent.putExtra("id", eventIdInClipData);
        File downloadDir = getDownloadDir(true);
        if (downloadDir != null) {
            intent.putExtra(DOP_DRAGNDROP_DST_FOLDER, downloadDir.getPath());
        }
        String str = TAG;
        Logger.m10999d(str, intent.toString());
        context.sendBroadcast(intent, PERMISSION_NAME_DEXONPC);
        AbstractC0000a.m3D(eventIdInClipData, "sendResponseBroadcast, id: ", str);
    }
}
