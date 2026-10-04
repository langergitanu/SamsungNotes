package com.samsung.android.support.senl.p148nt.model.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.AndroidInstanceConstructor;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.C10065b;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class OldDocumentThumbnailUtils {
    private static final int BITMAP_SAMPLE_SIZE_LARGE = 4;
    private static final int BITMAP_SAMPLE_SIZE_ORIGINAL = 1;
    private static final int BITMAP_SAMPLE_SIZE_SMALL = 2;
    private static final String TAG = ModelLogger.createTag("OldDocumentThumbnailUtils");
    private static final String THUMBNAIL_JPG_EXTENSION = ".jpg";
    private static final String THUMBNAIL_PNG_EXTENSION = ".png";

    private static File createHWThumbnailFile(Context context, String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        File file = new File(getThumbnailDirectory(context, str), AbstractC2821a.m2221l(str3, str, str2, ".png"));
        DataLogger.m12302d(TAG, "createHWThumbnailFile# " + DataLogger.getEncode(file.getAbsolutePath()));
        return file;
    }

    public static String createHWThumbnailFiles(Context context, List<Bitmap> list, String str, List<String> list2, String str2, boolean z) throws IOException {
        boolean zCompress;
        createHWThumbnailPath(context, str, list2, str2);
        ArrayList arrayList = new ArrayList();
        int size = list2.size();
        StringBuilder sb = new StringBuilder();
        String hWThumbnailFilePath = null;
        for (int i = 0; i < size; i++) {
            hWThumbnailFilePath = getHWThumbnailFilePath(context, str, list2.get(i));
            FileOutputStream fileOutputStream = new FileOutputStream(hWThumbnailFilePath);
            try {
                arrayList.add(fileOutputStream);
                if (z) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(list.get(i).getWidth(), list.get(i).getHeight(), list.get(i).getConfig());
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    canvas.drawColor(Color.parseColor("#fcfcfc"));
                    canvas.drawBitmap(list.get(i), 0.0f, 0.0f, (Paint) null);
                    zCompress = bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream) arrayList.get(i));
                } else {
                    zCompress = list.get(i).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream) arrayList.get(i));
                }
                ((FileOutputStream) arrayList.get(i)).close();
                sb.append("createHWThumbnailFiles, thumbnailPath : ");
                sb.append(DataLogger.getEncode(hWThumbnailFilePath));
                sb.append(" result: ");
                sb.append(zCompress);
                sb.append('\n');
                fileOutputStream.close();
            } finally {
            }
        }
        DataLogger.m12307i(TAG, sb.toString());
        return hWThumbnailFilePath;
    }

    private static void createHWThumbnailPath(Context context, String str, List<String> list, String str2) {
        StringBuilder sb = new StringBuilder("createThumbnailPath() failed list : ");
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                File fileCreateHWThumbnailFile = createHWThumbnailFile(context, str, it.next(), str2);
                if (fileCreateHWThumbnailFile != null) {
                    if (!fileCreateHWThumbnailFile.mkdirs()) {
                        sb.append("mkdir:");
                        sb.append(str);
                        sb.append('/');
                    }
                    if (fileCreateHWThumbnailFile.exists() && !fileCreateHWThumbnailFile.delete()) {
                        sb.append("delete:");
                        sb.append(str);
                        sb.append('/');
                    }
                    if (fileCreateHWThumbnailFile.getParentFile() != null && !fileCreateHWThumbnailFile.getParentFile().mkdirs()) {
                        DataLogger.m12307i(TAG, "createHWThumbnailPath, mkdirs fail");
                    }
                    if (!fileCreateHWThumbnailFile.createNewFile()) {
                        DataLogger.m12309w(TAG, "createHWThumbnailPath, createNewFile fail");
                    }
                }
            }
            DataLogger.m12309w(TAG, sb.toString());
        } catch (IOException e) {
            DataLogger.m12304e(TAG, "createHWThumbnailPath() uuid: " + str, e);
        }
    }

    private static File createImageThumbnailFile(Context context, String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        String strValueOf = String.valueOf(str.charAt(length - 2));
        File file = new File(new File(new File(getAttachFolder(context), strValueOf), String.valueOf(str.charAt(length - 1))), str.concat(".jpg"));
        DataLogger.m12302d(TAG, "createImageThumbnailFile# " + file);
        return file;
    }

    public static String createThumbnailFile(Context context, Bitmap bitmap, String str) throws IOException {
        createThumbnailFile(context, str);
        String thumbnailFilePath = getThumbnailFilePath(context, str);
        FileOutputStream fileOutputStream = new FileOutputStream(thumbnailFilePath);
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawColor(-1);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            boolean zCompress = bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            bitmap.recycle();
            bitmapCreateBitmap.recycle();
            DataLogger.m12302d(TAG, "createThumbnailFile, thumbnailPath : " + thumbnailFilePath + " result: " + zCompress);
            fileOutputStream.close();
            return thumbnailFilePath;
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static Bitmap decodeSampledBitmapFromFile(Context context, String str) {
        int i;
        BitmapFactory.Options optionsMakeBitmapFactoryOptions = AndroidInstanceConstructor.makeBitmapFactoryOptions();
        optionsMakeBitmapFactoryOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, optionsMakeBitmapFactoryOptions);
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        int i4 = context.getResources().getDisplayMetrics().heightPixels;
        int i5 = optionsMakeBitmapFactoryOptions.outWidth;
        if (i5 < i2 / 2 || (i = optionsMakeBitmapFactoryOptions.outHeight) < i4 / 4) {
            optionsMakeBitmapFactoryOptions.inSampleSize = 1;
        } else if (i5 < i2 * 2 || i < i4 * 4) {
            optionsMakeBitmapFactoryOptions.inSampleSize = 2;
        } else {
            optionsMakeBitmapFactoryOptions.inSampleSize = 4;
        }
        optionsMakeBitmapFactoryOptions.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, optionsMakeBitmapFactoryOptions);
    }

    public static void deleteThumbnailFiles(Context context, List<String> list) {
        StringBuilder sb = new StringBuilder("deleteThumbnailFiles, failed list : ");
        for (String str : list) {
            File thumbnailFile = getThumbnailFile(context, str);
            if (thumbnailFile != null) {
                deleteThumbnails(str, thumbnailFile);
                File parentFile = thumbnailFile.getParentFile();
                if (parentFile != null) {
                    if (!parentFile.delete()) {
                        sb.append("delete:");
                        sb.append(str);
                        sb.append('/');
                    }
                    File parentFile2 = parentFile.getParentFile();
                    if (parentFile2 != null && !parentFile2.delete()) {
                        sb.append("parent delete:");
                        sb.append(str);
                        sb.append('/');
                    }
                }
            }
        }
        DataLogger.m12309w(TAG, sb.toString());
    }

    private static void deleteThumbnails(String str, File file) {
        File[] fileArrListFiles;
        if (file == null) {
            return;
        }
        if (!file.isFile()) {
            DataLogger.m12302d(TAG, "deleteThumbnails, delete dir: " + file.delete());
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null || (fileArrListFiles = parentFile.listFiles(new C10065b(str, 3))) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (File file2 : fileArrListFiles) {
            if (!file2.delete()) {
                sb.append("failed to delete:");
                sb.append(DataLogger.getEncode(file2.getPath()));
                sb.append('\n');
            }
        }
        if (sb.toString().isEmpty()) {
            return;
        }
        DataLogger.m12302d(TAG, "deleteThumbnails, " + ((Object) sb));
    }

    private static File getAttachFolder(Context context) {
        return PageCacheUtils.getRootCacheDirectory(context);
    }

    private static File getHWThumbnailFile(Context context, String str, String str2) {
        File parentFile;
        boolean z;
        File parentFile2 = null;
        if (str == null) {
            return null;
        }
        File thumbnailDirectory = getThumbnailDirectory(context, str);
        String[] strArr = {AbstractC0541b.m756B(str2, ".png"), ".png", ".jpg"};
        int i = 0;
        while (true) {
            if (i >= 3) {
                parentFile = parentFile2;
                z = false;
                break;
            }
            parentFile = new File(thumbnailDirectory, AbstractC0541b.m756B(str, strArr[i]));
            if (parentFile.exists()) {
                z = true;
                break;
            }
            parentFile2 = parentFile.getParentFile();
            i++;
        }
        if (z) {
            return parentFile;
        }
        for (int i2 = 0; i2 < 3; i2++) {
            File file = new File(thumbnailDirectory, AbstractC0541b.m773o("d_", str, strArr[i2]));
            if (file.exists()) {
                return file;
            }
            parentFile = file.getParentFile();
        }
        return parentFile;
    }

    public static String getHWThumbnailFilePath(Context context, String str, String str2) {
        File hWThumbnailFile = getHWThumbnailFile(context, str, str2);
        if (hWThumbnailFile == null) {
            return null;
        }
        return hWThumbnailFile.getAbsolutePath();
    }

    private static File getThumbnailDirectory(Context context, String str) {
        int length = str.length();
        return new File(new File(getAttachFolder(context), String.valueOf(str.charAt(length - 2))), String.valueOf(str.charAt(length - 1)));
    }

    private static File getThumbnailFile(Context context, String str) {
        File parentFile = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File thumbnailDirectory = getThumbnailDirectory(context, str);
        String[] strArr = {AbstractC0541b.m756B(str, ".jpg"), AbstractC0541b.m756B(str, ".png"), AbstractC0541b.m773o("d_", str, ".png")};
        for (int i = 0; i < 3; i++) {
            File file = new File(thumbnailDirectory, strArr[i]);
            if (file.exists()) {
                return file;
            }
            parentFile = file.getParentFile();
        }
        return parentFile;
    }

    public static String getThumbnailFilePath(Context context, String str) {
        File thumbnailFile = getThumbnailFile(context, str);
        if (thumbnailFile == null) {
            return null;
        }
        return thumbnailFile.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$deleteThumbnails$0(String str, File file, String str2) {
        return str2.contains(str);
    }

    private static void createThumbnailFile(Context context, String str) {
        try {
            File fileCreateImageThumbnailFile = createImageThumbnailFile(context, str);
            if (fileCreateImageThumbnailFile != null) {
                if (!fileCreateImageThumbnailFile.mkdirs()) {
                    DataLogger.m12303e(TAG, "createThumbnailFile() failed mkdirs() : " + str);
                }
                if (fileCreateImageThumbnailFile.exists() && !fileCreateImageThumbnailFile.delete()) {
                    DataLogger.m12303e(TAG, "createThumbnailFile() failed delete() : " + str);
                }
                if (fileCreateImageThumbnailFile.getParentFile() != null && !fileCreateImageThumbnailFile.getParentFile().mkdirs()) {
                    DataLogger.m12307i(TAG, "createThumbnailFile() mkdirs fail");
                }
                if (fileCreateImageThumbnailFile.createNewFile()) {
                    return;
                }
                DataLogger.m12307i(TAG, "createThumbnailFile() mkdirs fail");
            }
        } catch (IOException e) {
            DataLogger.m12304e(TAG, "createThumbnailFile() uuid: " + str, e);
        }
    }
}
