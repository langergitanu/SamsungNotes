package com.samsung.android.support.senl.p148nt.model.base.utils.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.util.Pair;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.media.BitmapCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.BitmapInspector;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileExtensions;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.assist.common.C2paHandler;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.C11417a;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.DownloadBitmap;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class DownloadBitmap {
    private static final String TAG = ModelLogger.createTag("DownloadBitmap");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ICheckerToImageFile {
        void checkImageWithFile(File file);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i) {
        int i2 = options.outHeight;
        int i4 = options.outWidth;
        if (i4 <= i2) {
            i2 = i4;
            i4 = i2;
        }
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "calculateInSampleSize, reqWidth: ", ", width: ", ", height: ");
        sbM1173s.append(i4);
        DataLogger.m12307i(str, sbM1173s.toString());
        int i5 = 1;
        if (i2 > i) {
            int i6 = 1;
            while ((i2 / 2) / i6 > i) {
                i6 *= 2;
            }
            int i7 = i6 / 2;
            i5 = (i6 <= 1 || i4 / Math.max(1, i7) >= ImageUtils.getMaxTextureSize() || i2 / Math.max(1, i7) >= ImageUtils.getMaxTextureSize()) ? i6 : i7;
        }
        DataLogger.m12307i(TAG, "calculateInSampleSize, inSampleSize: " + i5);
        return i5;
    }

    private static Bitmap getBitmapAfterDecodeFile(Context context, BitmapFactory.Options options, String str, String str2) {
        if (str == null || !AbstractC2322a.m1607A(str)) {
            DataLogger.m12303e(TAG, "getBitmapAfterDecodeFile# Fail exists: ");
            return null;
        }
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        DataLogger.m12307i(TAG, "getBitmapFromUri options, width: " + options.outWidth + ", height: " + options.outHeight);
        options.inSampleSize = calculateInSampleSize(options, DisplayUtils.getScreenMinSize(context));
        options.inJustDecodeBounds = false;
        return BitmapCompat.getInstance().decodeFile(str, options, str2);
    }

    private static Bitmap getBitmapAfterDecodeFileWithUri(Context context, BitmapFactory.Options options, Uri uri, String str) {
        String path = uri.getPath();
        if (path == null) {
            return null;
        }
        boolean zM1607A = AbstractC2322a.m1607A(path);
        String str2 = TAG;
        AbstractC11014a.m12335t("getBitmapFromFile# uri get path is exists: ", str2, zM1607A);
        if (!zM1607A) {
            path = uri.toString().replace("file://", "");
            DataLogger.m12307i(str2, "getBitmapFromFile# retry with undecoded uri");
            boolean zM1607A2 = AbstractC2322a.m1607A(path);
            AbstractC11014a.m12335t("getBitmapFromFile# uri get string is exists: ", str2, zM1607A2);
            if (!zM1607A2) {
                return null;
            }
        }
        return getBitmapAfterDecodeFile(context, options, path, str);
    }

    private static Bitmap getBitmapAfterDecodeStreamWithUri(Context context, BitmapFactory.Options options, Uri uri, String str) {
        InputStream inputStreamOpenInputStream;
        if (!"application/octet-stream".equals(str)) {
            options.inJustDecodeBounds = true;
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                try {
                    if (inputStreamOpenInputStream == null) {
                        DataLogger.m12303e(TAG, "getBitmapAfterDecodeStreamWithUri# can not open input stream. first");
                        if (inputStreamOpenInputStream == null) {
                            return null;
                        }
                        inputStreamOpenInputStream.close();
                        return null;
                    }
                    BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                    inputStreamOpenInputStream.close();
                } finally {
                }
            } catch (Exception e) {
                DataLogger.m12304e(TAG, "getBitmapAfterDecodeStreamWithUri# first e:", e);
                return null;
            }
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                if (inputStreamOpenInputStream == null) {
                    DataLogger.m12303e(TAG, "getBitmapAfterDecodeStreamWithUri# can not open input stream. second");
                    if (inputStreamOpenInputStream == null) {
                        return null;
                    }
                    inputStreamOpenInputStream.close();
                    return null;
                }
                DataLogger.m12307i(TAG, "getBitmapFromUri options, width: " + options.outWidth + ", height: " + options.outHeight);
                options.inSampleSize = calculateInSampleSize(options, DisplayUtils.getScreenMinSize(context));
                options.inJustDecodeBounds = false;
                Bitmap bitmapDecodeStream = BitmapCompat.getInstance().decodeStream(inputStreamOpenInputStream, options, str);
                inputStreamOpenInputStream.close();
                return bitmapDecodeStream;
            } finally {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                }
            }
        } catch (Exception e2) {
            DataLogger.m12304e(TAG, "getBitmapAfterDecodeStreamWithUri# second e:", e2);
            return null;
        }
    }

    @Nullable
    private static Bitmap getBitmapFromHttpUri(final String str, final String str2, final int i) {
        ExecutorService executorServiceM3201k = AbstractC4539a.m3201k("getBitmapFromHttpUri");
        Bitmap bitmap = (Bitmap) executorServiceM3201k.submit(new Callable() { // from class: e4.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DownloadBitmap.lambda$getBitmapFromHttpUri$1(str, str2, i);
            }
        }).get(((long) i) * 3, TimeUnit.MILLISECONDS);
        executorServiceM3201k.shutdown();
        String str3 = TAG;
        StringBuilder sb = new StringBuilder("getBitmapFromHttpUri, bitmap byte: ");
        sb.append(bitmap == null ? "null" : Integer.valueOf(bitmap.getByteCount()));
        DataLogger.m12307i(str3, sb.toString());
        return bitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0061  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap getBitmapFromHttpUriTimeout(String str, String str2, int i) throws Throwable {
        HttpURLConnection httpURLConnection;
        ?? r02 = 0;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                if (httpURLConnection == null) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                }
                try {
                    httpURLConnection.setConnectTimeout(i);
                    httpURLConnection.setReadTimeout(i);
                    try {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        try {
                            Bitmap bitmapDecodeStream = BitmapCompat.getInstance().decodeStream(inputStream, null, str2);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            httpURLConnection.disconnect();
                            return bitmapDecodeStream;
                        } catch (Throwable th) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        DataLogger.m12304e(TAG, "getBitmapFromHttpUriTimeout# e:", e);
                        httpURLConnection.disconnect();
                        return null;
                    }
                } catch (IOException e2) {
                    e = e2;
                    DataLogger.m12304e(TAG, "getBitmapFromHttpUriTimeout# ", e);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                r02 = str;
                if (r02 != 0) {
                    r02.disconnect();
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th = th4;
            if (r02 != 0) {
            }
            throw th;
        }
    }

    @Nullable
    private static Bitmap getBitmapFromUri(Context context, BitmapFactory.Options options, Uri uri, String str) {
        Bitmap bitmapDecodeByteArray;
        if (uri == null) {
            DataLogger.m12303e(TAG, "getBitmapFromUri, uri is null.");
            return null;
        }
        if ("content".equals(uri.getScheme())) {
            bitmapDecodeByteArray = getBitmapAfterDecodeStreamWithUri(context, options, uri, str);
        } else if ("file".equals(uri.getScheme())) {
            bitmapDecodeByteArray = getBitmapAfterDecodeFileWithUri(context, options, uri, str);
        } else if (uri.getScheme() != null && uri.getScheme().startsWith("http")) {
            bitmapDecodeByteArray = getBitmapFromHttpUri(uri.toString(), str, 5000);
        } else {
            if (!uri.toString().startsWith("data:image")) {
                throw new RuntimeException("no handle to get bitmap scheme : " + uri.getScheme());
            }
            String string = uri.toString();
            byte[] bArrDecode = Base64.decode(string.substring(string.indexOf(44) + 1), 0);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        }
        if (bitmapDecodeByteArray == null) {
            DataLogger.m12303e(TAG, "getBitmapFromUri, bitmap is null");
        }
        return bitmapDecodeByteArray;
    }

    public static boolean isValidGif(Context context, Uri uri) {
        if (BitmapInspector.isValid(context, uri)) {
            return true;
        }
        DataLogger.m12303e(TAG, "isValidGif# bitmap is not valid");
        return false;
    }

    public static boolean isValidImage(Context context, Uri uri) {
        if (!BitmapInspector.isValid(context, uri)) {
            DataLogger.m12303e(TAG, "isValidImage# bitmap is not valid" + DataLogger.getEncode(uri.toString()));
            return false;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null || !lastPathSegment.toLowerCase().endsWith(".dcf")) {
            return true;
        }
        DataLogger.m12303e(TAG, "isValidImage# file format is unsupported. ".concat(lastPathSegment));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bitmap lambda$getBitmapFromHttpUri$1(String str, String str2, int i) {
        try {
            return getBitmapFromHttpUriTimeout(str, str2, i);
        } catch (Throwable th) {
            DataLogger.m12303e(TAG, "getBitmapFromHttpUri, " + th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveBitmapFromUri$0(Content.Image image, String str) {
        C2paHandler.getInstance().copyC2paManifestList(image.getPath(), str);
    }

    public static boolean saveBitmapFromUri(Context context, Content.Image image, ICheckerToImageFile iCheckerToImageFile) throws Throwable {
        Bitmap bitmapAfterDecodeFile;
        String filePathFromUri;
        boolean z;
        BitmapFactory.Options options = new BitmapFactory.Options();
        String str = "";
        boolean zSaveBitmapToFileCache = false;
        if ("application/octet-stream".equals(image.getMimeType())) {
            String str2 = context.getCacheDir() + "/temporaryFile";
            File file = new File(str2);
            if (file.exists() && !file.delete()) {
                DataLogger.m12303e(TAG, "can't delete file");
            }
            try {
                BaseUtils.copyFileFromContentUri(image.getUri(), str2);
                if (!file.exists() || file.length() < 10) {
                    DataLogger.m12303e(TAG, "saveBitmapFromUri# Fail to save with application mimeType");
                    return false;
                }
                bitmapAfterDecodeFile = getBitmapAfterDecodeFile(context, options, str2, image.getMimeType());
                if (bitmapAfterDecodeFile != null && iCheckerToImageFile != null) {
                    iCheckerToImageFile.checkImageWithFile(file);
                }
                z = true;
                filePathFromUri = "";
                str = str2;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                Bitmap bitmapFromUri = getBitmapFromUri(context, options, image.getUri(), image.getMimeType());
                if (bitmapFromUri == null || iCheckerToImageFile == null) {
                    bitmapAfterDecodeFile = bitmapFromUri;
                    filePathFromUri = "";
                } else {
                    filePathFromUri = UriFileUtils.getFilePathFromUri(context, image.getUri());
                    if (TextUtils.isEmpty(filePathFromUri)) {
                        filePathFromUri = UriFileUtils.getPathFromUri(context, image.getUri());
                        if (filePathFromUri.isEmpty()) {
                            String str3 = context.getCacheDir() + "/fileToCheck";
                            if (FileUtils.makeDirectory(str3)) {
                                String strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(str3, "fileToCheck." + FileExtensions.getImageExtension(image.getUri(), image.getMimeType()));
                                File file2 = new File(strGenerateUniqueFilePath);
                                try {
                                    BaseUtils.copyFileFromContentUri(image.getUri(), strGenerateUniqueFilePath);
                                } catch (Exception unused) {
                                }
                                if (file2.exists() && file2.length() >= 10) {
                                    iCheckerToImageFile.checkImageWithFile(file2);
                                }
                                if (file2.exists() && !file2.delete()) {
                                    DataLogger.m12303e(TAG, "can't delete file");
                                }
                            } else {
                                DataLogger.m12303e(TAG, "can't makeDirectory file");
                            }
                        } else {
                            iCheckerToImageFile.checkImageWithFile(new File(filePathFromUri));
                        }
                    } else {
                        iCheckerToImageFile.checkImageWithFile(new File(filePathFromUri));
                    }
                    bitmapAfterDecodeFile = bitmapFromUri;
                }
                z = false;
            } catch (Exception e2) {
                AbstractC11014a.m12333r(e2, new StringBuilder("saveBitmapFromUri# Exception - "), TAG);
                return false;
            }
        }
        if (bitmapAfterDecodeFile == null) {
            DataLogger.m12303e(TAG, "saveBitmapFromUri# bitmap is null");
            return false;
        }
        Bitmap bitmapResizeBitmapFitingToScreen = ImageUtils.resizeBitmapFitingToScreen(bitmapAfterDecodeFile, UtilImage.getScreenMinSizeBetterThanGRACE(context));
        if (bitmapResizeBitmapFitingToScreen != bitmapAfterDecodeFile) {
            if (!bitmapAfterDecodeFile.isRecycled()) {
                bitmapAfterDecodeFile.recycle();
            }
            bitmapAfterDecodeFile = bitmapResizeBitmapFitingToScreen;
        }
        Pair<Integer, Integer> imageRotation = z ? UtilImage.getImageRotation(str) : UtilImage.getImageRotation(context, image.getUri());
        Bitmap bitmapApplyFlipRotationBitmap = UtilImage.applyFlipRotationBitmap(bitmapAfterDecodeFile, imageRotation.first.intValue(), imageRotation.second.intValue());
        if (bitmapApplyFlipRotationBitmap != bitmapAfterDecodeFile) {
            if (!bitmapAfterDecodeFile.isRecycled()) {
                bitmapAfterDecodeFile.recycle();
            }
            bitmapAfterDecodeFile = bitmapApplyFlipRotationBitmap;
        }
        if (z) {
            File file3 = new File(str);
            if (file3.exists() && !file3.delete()) {
                DataLogger.m12303e(TAG, "can't delete file");
            }
        }
        if (!TextUtils.isEmpty(options.outMimeType) && !options.outMimeType.toLowerCase().equals(image.getMimeType())) {
            DataLogger.m12307i(TAG, "saveBitmapFromUri# change: from " + image.getMimeType() + " / to " + options.outMimeType);
            image.setMimeType(options.outMimeType);
        }
        DataLogger.m12307i(TAG, "saveBitmapFromUri# path: " + DataLogger.getEncode(image.getPath()) + " , width : " + bitmapAfterDecodeFile.getWidth() + " , height : " + bitmapAfterDecodeFile.getHeight() + " , mimeType :" + image.getMimeType());
        if (TextUtils.isEmpty(image.getMimeType()) || !image.getMimeType().contains(Constants.THUMBNAIL_GIF_EXTENSION)) {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            if (!TextUtils.isEmpty(image.getMimeType()) && image.getMimeType().contains(Constants.THUMBNAIL_PNG_EXTENSION)) {
                compressFormat = Bitmap.CompressFormat.PNG;
            }
            zSaveBitmapToFileCache = ImageUtil.saveBitmapToFileCache(bitmapAfterDecodeFile, image.getPath(), compressFormat, 95);
        } else {
            int iLastIndexOf = image.getPath().lastIndexOf(46);
            if (iLastIndexOf >= 0) {
                image.setPath(image.getPath().substring(0, iLastIndexOf + 1) + Constants.THUMBNAIL_GIF_EXTENSION);
                zSaveBitmapToFileCache = UriFileUtils.saveUriToFile(context, image.getUri(), image.getPath());
            }
        }
        C2paHandler.getInstance().executeForGenerativeImage(filePathFromUri, new C11417a(image, 1));
        bitmapAfterDecodeFile.recycle();
        return zSaveBitmapToFileCache;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00bb  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String saveImageFromUri(@NonNull Context context, @NonNull Uri uri, @Nullable String str, @NonNull String str2, @Nullable ICheckerToImageFile iCheckerToImageFile) {
        boolean zSaveBitmapFromUri;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (UriFileUtils.isUnsupportedUriContent(uri)) {
            DataLogger.m12303e(TAG, "saveImageFromUri# invalid uri");
            return "";
        }
        Content.Image image = new Content.Image(uri, "");
        image.setMimeType(str);
        if (str.contains(Constants.THUMBNAIL_GIF_EXTENSION)) {
            if (isValidGif(context, uri)) {
                StringBuilder sbM1324q = AbstractC1974b.m1324q(str2);
                sbM1324q.append(FileExtensions.getFileNameByTime("files", Constants.THUMBNAIL_GIF_EXTENSION));
                image.setPath(sbM1324q.toString());
                zSaveBitmapFromUri = UriFileUtils.saveUriToFile(context, uri, image.getPath());
            } else {
                zSaveBitmapFromUri = false;
            }
        } else if (!str.contains(Constants.THUMBNAIL_PNG_EXTENSION)) {
            if ((!str.startsWith(Constants.MIME_IMAGE_START) && !str.equals(Constants.MIME_IMAGE_DIR)) || !ImageUtil.isImageMimeType(str)) {
                DataLogger.m12303e(TAG, "saveImageFromUri# not supported mime type. : ".concat(str));
            } else if (isValidImage(context, uri)) {
                StringBuilder sbM1324q2 = AbstractC1974b.m1324q(str2);
                sbM1324q2.append(FileExtensions.getFileNameByTime("files", "jpg"));
                image.setPath(sbM1324q2.toString());
                zSaveBitmapFromUri = saveBitmapFromUri(context, image, iCheckerToImageFile);
            }
            zSaveBitmapFromUri = false;
        } else if (isValidImage(context, uri)) {
            StringBuilder sbM1324q3 = AbstractC1974b.m1324q(str2);
            sbM1324q3.append(FileExtensions.getFileNameByTime("files", Constants.THUMBNAIL_PNG_EXTENSION));
            image.setPath(sbM1324q3.toString());
            zSaveBitmapFromUri = saveBitmapFromUri(context, image, iCheckerToImageFile);
        }
        String str3 = TAG;
        StringBuilder sbM3200j = AbstractC4539a.m3200j("saveImageFromUri# result:", ", uri : ", zSaveBitmapFromUri);
        sbM3200j.append(DataLogger.getEncode(uri.toString()));
        DataLogger.m12307i(str3, sbM3200j.toString());
        return zSaveBitmapFromUri ? image.getPath() : "";
    }
}
