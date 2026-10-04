package com.samsung.android.support.senl.p148nt.composer.main.cover.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import p009B3.C0035a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoverStickerDownloadUtils {
    private static final int BUFFER_SIZE = 10240;
    private static final int COVER_STICKER_DOWNLOAD_VERSION_1_FIRST_INDEX = 12;
    private static final int COVER_STICKER_DOWNLOAD_VERSION_1_SIZE = 72;
    private static final String COVER_STICKER_FILE_NAME = "sticker.zip";
    private static final String COVER_STICKER_FILE_PREFIX = "sticker_";
    public static final String COVER_STICKER_FOLDER_ROOT = "stickers";
    public static final String COVER_STICKER_FOLDER_UNZIP = "unzip";
    public static final String COVER_STICKER_FOLDER_ZIP = "zip";
    public static final int ERROR_CONVERT_DRAWABLE = 8;
    public static final int ERROR_DOWNLOAD = 6;
    public static final int ERROR_NOT_ENOUGH_MEMORY = 1;
    public static final int ERROR_OVER_SIZE = 2;
    public static final int ERROR_STICKER_FORMAT = 4;
    public static final int ERROR_STICKER_TYPE = 5;
    public static final int ERROR_STICKER_UNKNOWN = 3;
    public static final int ERROR_UNZIP = 7;
    private static final long MAXIMUM_STICKER_SIZE_MB = 1;
    private static final String SVG_EXTENSION = ".svg";
    private static final String TAG = Logger.createCoverTag("CoverStickerDownloadUtils");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DownloadFileResult {
        public final String filePath;
        public final int resultCode;

        public DownloadFileResult(String str, int i) {
            this.filePath = str;
            this.resultCode = i;
        }
    }

    private static PictureDrawable convertSvgToDrawable(File file) {
        try {
            new FileInputStream(file).close();
            return null;
        } catch (Exception e) {
            AbstractC8014b.m7207i("convertSvgToDrawable# exception : ", e, TAG);
            return null;
        }
    }

    public static DownloadFileResult downloadFile(Context context, String str, Uri uri) {
        String str2 = str;
        try {
            String str3 = TAG;
            Logger.m11003i(str3, "downloadFile# start");
            String str4 = COVER_STICKER_FILE_PREFIX + System.currentTimeMillis() + Constants.ZIP_EXTENSION_WITH_DOT;
            long availableInternalMemorySize = StorageUtils.getAvailableInternalMemorySize() - 10485760;
            long jMin = Math.min(availableInternalMemorySize, 1L);
            long fileSize = FileUtils.getFileSize(context, uri);
            if (jMin < fileSize) {
                Logger.m11003i(str3, "downloadFile# too large file: " + fileSize + " / " + jMin);
                return new DownloadFileResult(null, availableInternalMemorySize < 1 ? 3 : 2);
            }
            String str5 = File.separator;
            if (!str2.endsWith(str5)) {
                str2 = str2 + str5;
            }
            String str6 = str2 + str4;
            boolean zSaveUriToFile = UriFileUtils.saveUriToFile(context, uri, str6);
            DownloadFileResult downloadFileResult = zSaveUriToFile ? new DownloadFileResult(str6, 0) : new DownloadFileResult(null, 6);
            Logger.m11003i(str3, "downloadFile# end " + zSaveUriToFile);
            return downloadFileResult;
        } catch (Exception e) {
            Logger.m11001e(TAG, "downloadFile# exception : ", e);
            return null;
        }
    }

    public static Drawable getDownloadedStickerDrawable(Context context, String str) {
        int stickerIndex = CoverStickerUtils.getStickerIndex(str);
        int i = stickerIndex - 12;
        File[] fileArrListFiles = getDownloadedStickerUnZipFolder(context).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0 || fileArrListFiles.length <= i) {
            Logger.m11000e(TAG, "getDownloadedStickerDrawable# sticker is not exists");
            return null;
        }
        String str2 = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(stickerIndex, i, "getDownloadedStickerDrawable# stickerIndex : ", ", downloadIndex : ", ", fileName : ");
        sbM1173s.append(fileArrListFiles[stickerIndex].getName());
        Logger.m10999d(str2, sbM1173s.toString());
        if (stickerIndex == Integer.parseInt(fileArrListFiles[i].getName().split("_")[0])) {
            return convertSvgToDrawable(fileArrListFiles[i]);
        }
        Logger.m11000e(str2, "getDownloadedStickerDrawable# sticker index is not match");
        return null;
    }

    public static List<Pair<Drawable, String>> getDownloadedStickerDrawableList(Context context, int i) {
        File[] fileArrListFiles = getDownloadedStickerUnZipFolder(context).listFiles(new C0035a(0));
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            Logger.m11000e(TAG, "getDownloadedStickerDrawableList# sticker is not exists");
            return null;
        }
        Logger.m10999d(TAG, "getDownloadedStickerDrawableList# sticker list size : " + fileArrListFiles.length + ", downloadedStickerCount : " + i);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            File file = fileArrListFiles[i2];
            arrayList.add(new Pair(convertSvgToDrawable(file), file.getPath()));
        }
        return arrayList;
    }

    public static int getDownloadedStickerFirstIndex() {
        return 12;
    }

    public static int getDownloadedStickerSize() {
        return 72;
    }

    public static File getDownloadedStickerUnZipFolder(Context context) {
        File file = new File(context.getDir(COVER_STICKER_FOLDER_ROOT, 0), COVER_STICKER_FOLDER_UNZIP);
        if (!file.exists() && !file.mkdir()) {
            Logger.m11000e(TAG, "getDownloadedStickerUnZipFolder# fail");
        }
        return file;
    }

    public static File getDownloadedStickerZipFolder(Context context) {
        File file = new File(context.getDir(COVER_STICKER_FOLDER_ROOT, 0), "zip");
        if (!file.exists() && !file.mkdir()) {
            Logger.m11000e(TAG, "getDownloadedStickerZipFolder# fail");
        }
        return file;
    }

    public static String getFileNameFromUri(Uri uri) {
        if (uri == null) {
            return "";
        }
        String[] strArrSplit = uri.toString().split("/");
        return strArrSplit.length >= 2 ? AbstractC0541b.m756B(strArrSplit[strArrSplit.length - 2], "_sticker.zip") : "";
    }

    public static boolean isStickerDownloaded(Context context) {
        File[] fileArrListFiles = getDownloadedStickerUnZipFolder(context).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            Logger.m11000e(TAG, "isStickerDownloaded# sticker is not exists");
            return false;
        }
        AbstractC8014b.m7221w(new StringBuilder("isStickerDownloaded# count : "), TAG, fileArrListFiles.length);
        return fileArrListFiles.length == 72;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getDownloadedStickerDrawableList$0(File file, String str) {
        return str.toLowerCase().endsWith(SVG_EXTENSION);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void showErrorToast(Context context, int i, boolean z) {
        String string;
        if (context == null) {
            Logger.m11000e(TAG, "showErrorToast# context is null");
            return;
        }
        if (i == 1) {
            showErrorToastLowMemory(context, z);
        } else {
            if (i != 2) {
                if (i == 3 || i == 4 || i == 5) {
                    string = context.getResources().getString(C9086R.string.composer_can_not_open_file);
                } else if (i == 6) {
                    string = context.getResources().getString(C9086R.string.composer_failed_to_download_file);
                } else if (i == 7) {
                    string = "Failed to unzip file";
                } else if (i == 8) {
                    string = "Failed to convert file";
                }
                if (TextUtils.isEmpty(string)) {
                    Logger.m11004w(TAG, string);
                    ToastHandler.show(context, string, 0);
                    return;
                }
                return;
            }
            showErrorToastOverSize(context, z, 1L);
        }
        string = null;
        if (TextUtils.isEmpty(string)) {
        }
    }

    private static void showErrorToastLowMemory(Context context, boolean z) {
        if (z) {
            ToastHandler.show(context, DialogUtils.getNotEnoughStorageString(context), 0);
        } else {
            StorageChecker.showErrorDialog(context, 1);
        }
    }

    private static void showErrorToastOverSize(Context context, boolean z, long j) {
        Logger.m10999d(TAG, "showErrorToastOverSize# " + j);
        if (z) {
            ToastHandler.show(context, DialogUtils.getOverSizeString(context, j), 0);
        } else {
            StorageChecker.showErrorDialog(context, 2, j);
        }
    }

    public static void unZipFile(String str, File file) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return;
                }
                File file2 = new File(file.getPath(), nextEntry.getName());
                if (nextEntry.isDirectory()) {
                    FileUtils.makeDirectory(file2.getPath());
                } else {
                    String parent = file2.getParent();
                    if (parent != null) {
                        FileUtils.makeDirectory(parent);
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    try {
                        byte[] bArr = new byte[10240];
                        while (true) {
                            int i = zipInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            } else {
                                bufferedOutputStream.write(bArr, 0, i);
                            }
                        }
                        bufferedOutputStream.close();
                    } finally {
                    }
                }
                zipInputStream.closeEntry();
            } catch (Throwable th) {
                try {
                    zipInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }
}
