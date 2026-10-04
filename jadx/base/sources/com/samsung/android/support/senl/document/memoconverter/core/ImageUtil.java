package com.samsung.android.support.senl.document.memoconverter.core;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.Display;
import android.view.WindowManager;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.document.delegator.AppDelegator;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ImageUtil {
    private static final String DEFAULT_BLOB_EXTENSSION = ".blob";
    public static final int DEFAULT_JPEG_COMPRESS_LEVEL = 80;
    public static final int DRAWING_BORDER_WIDTH = 2;
    private static final int GRACE_WIDTH = 1440;
    public static final String KEY_DISPLAYNAME = "ImageUtil_displayname";
    public static final String KEY_MIMETYPE = "ImageUtil_mimetype";
    public static final String KEY_ORIENTATION = "ImageUtil_orientation";
    public static final int MAX_IMAGE_SAVE_SIZE = 4096;
    private static final String MEMO_DRAWING = "drawing_image";
    public static final String MEMO_DRAWING_PREFIX = "MemoDraw_";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    public static final String MIME_TYPE_WBMP = "image/vnd.wap.wbmp";
    public static final String PNG_FILE_EXTENSION = ".png";
    private static final String TAG = "ImageUtil";

    private ImageUtil() {
        DocumentLogger.m7178d(TAG, TAG);
    }

    public static int calculateInSampleSize(int i, int i2) {
        int i4 = 1;
        while (i / (i2 * i4) != 0) {
            i4 *= 2;
        }
        return i4 / 2;
    }

    public static Bitmap createRecycleBitmap(Bitmap bitmap, Matrix matrix) {
        Bitmap bitmapCreateBitmap = null;
        if (bitmap != null) {
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                DocumentLogger.m7178d(TAG, "decodeImageScaledIf() passed through post processing");
                bitmap.recycle();
                return bitmapCreateBitmap;
            } catch (NullPointerException e) {
                DocumentLogger.m7180e(TAG, "NullPointerException", e);
            }
        }
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006b A[Catch: IOException -> 0x006f, PHI: r0
      0x006b: PHI (r0v7 java.io.InputStream) = (r0v19 java.io.InputStream), (r0v20 java.io.InputStream) binds: [B:35:0x007a, B:27:0x0069] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #6 {IOException -> 0x006f, blocks: (B:44:0x008a, B:28:0x006b), top: B:79:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x008d -> B:83:0x008d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeImageScaledIf(Context context, Uri uri, int i, int i2, int i4) throws Throwable {
        InputStream inputStreamOpenInputStream;
        SecurityException e;
        InputStream inputStream;
        InputStream inputStream2;
        IllegalArgumentException e2;
        InputStream inputStream3;
        ?? r02 = "Uri=";
        if (i == -1) {
            i = getActualImageWidth(context, uri, i2);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = calculateInSampleSize(i, i4);
        Bitmap bitmapCreateRecycleBitmap = null;
        bitmapCreateRecycleBitmap = null;
        bitmapCreateRecycleBitmap = null;
        bitmapCreateRecycleBitmap = null;
        ?? r2 = 0;
        bitmapCreateRecycleBitmap = null;
        try {
            try {
                if (uri == null || context == null) {
                    inputStreamOpenInputStream = null;
                } else {
                    try {
                        inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                    } catch (IllegalArgumentException e3) {
                        e2 = e3;
                        inputStream3 = null;
                        DocumentLogger.m7180e(TAG, " decodeImageScaledIf : ", e2);
                        inputStream2 = inputStream3;
                        r02 = inputStream3;
                        if (inputStream3 != null) {
                        }
                        if (bitmapCreateRecycleBitmap == null) {
                        }
                    } catch (SecurityException e5) {
                        e = e5;
                        inputStream = null;
                        DocumentLogger.m7180e(TAG, " decodeImageScaledIf : ", e);
                        inputStream2 = inputStream;
                        r02 = inputStream;
                        if (inputStream != null) {
                        }
                        if (bitmapCreateRecycleBitmap == null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (r2 != 0) {
                        }
                        throw th;
                    }
                }
                if (inputStreamOpenInputStream != null) {
                    try {
                        r02 = "Uri=" + uri + ", size in bytes: " + inputStreamOpenInputStream.available();
                        DocumentLogger.m7178d(TAG, r02);
                        bitmapCreateRecycleBitmap = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                    } catch (IllegalArgumentException e6) {
                        inputStream3 = inputStreamOpenInputStream;
                        e2 = e6;
                        DocumentLogger.m7180e(TAG, " decodeImageScaledIf : ", e2);
                        inputStream2 = inputStream3;
                        r02 = inputStream3;
                        if (inputStream3 != null) {
                            inputStream2.close();
                            r02 = inputStream2;
                        }
                    } catch (SecurityException e7) {
                        inputStream = inputStreamOpenInputStream;
                        e = e7;
                        DocumentLogger.m7180e(TAG, " decodeImageScaledIf : ", e);
                        inputStream2 = inputStream;
                        r02 = inputStream;
                        if (inputStream != null) {
                        }
                    } catch (Throwable th2) {
                        r2 = inputStreamOpenInputStream;
                        th = th2;
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (IOException e8) {
                                DocumentLogger.m7180e(TAG, "decodeImageScaledIf()", e8);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                r2 = r02;
            }
        } catch (IOException e9) {
            DocumentLogger.m7180e(TAG, "decodeImageScaledIf()", e9);
            r02 = r02;
        }
        if (inputStreamOpenInputStream != null) {
            inputStreamOpenInputStream.close();
        }
        if (bitmapCreateRecycleBitmap == null) {
            throw new IOException(AbstractC0541b.m771m("fail to decode: ", uri));
        }
        int width = bitmapCreateRecycleBitmap.getWidth();
        if (i2 == 90 || i2 == 270) {
            width = bitmapCreateRecycleBitmap.getHeight();
        } else if (isPanorama(bitmapCreateRecycleBitmap.getHeight(), bitmapCreateRecycleBitmap.getWidth()) && bitmapCreateRecycleBitmap.getHeight() > bitmapCreateRecycleBitmap.getWidth()) {
            width = bitmapCreateRecycleBitmap.getHeight();
        }
        if (i2 != 0 || width > i4) {
            Matrix matrix = new Matrix();
            if (width > i4) {
                float f = i4 / width;
                if (bitmapCreateRecycleBitmap.getWidth() * f > 1.0f && bitmapCreateRecycleBitmap.getHeight() * f > 1.0f) {
                    matrix.postScale(f, f);
                } else if (bitmapCreateRecycleBitmap.getHeight() * f > 1.0f) {
                    matrix.postScale(1.0f, f);
                } else {
                    matrix.postScale(f, 1.0f);
                }
            }
            matrix.postRotate(i2);
            bitmapCreateRecycleBitmap = createRecycleBitmap(bitmapCreateRecycleBitmap, matrix);
        } else if (width < i4) {
            Matrix matrix2 = new Matrix();
            float f4 = i4 / width;
            matrix2.postScale(f4, f4);
            bitmapCreateRecycleBitmap = createRecycleBitmap(bitmapCreateRecycleBitmap, matrix2);
        }
        DocumentLogger.m7178d(TAG, "decodeImageScaledIf() width=" + width);
        return bitmapCreateRecycleBitmap;
    }

    public static int getActualImageHeight(Context context, Uri uri, int i) throws Throwable {
        BitmapFactory.Options imageSize = getImageSize(context, uri);
        return (i == 90 || i == 270) ? imageSize.outWidth : imageSize.outHeight;
    }

    public static int getActualImageWidth(Context context, Uri uri, int i) throws Throwable {
        BitmapFactory.Options imageSize = getImageSize(context, uri);
        return (i == 90 || i == 270) ? imageSize.outHeight : imageSize.outWidth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        ?? r7 = 0;
        try {
            try {
                cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                            cursorQuery.close();
                            return string;
                        }
                    } catch (Exception unused) {
                        DocumentLogger.m7179e(TAG, "getDataColumn() Exception");
                        if (cursorQuery != null) {
                        }
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                r7 = context;
                if (r7 != 0) {
                    throw th;
                }
                r7.close();
                throw th;
            }
        } catch (Exception unused2) {
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (r7 != 0) {
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0045 A[PHI: r3
      0x0045: PHI (r3v7 java.io.InputStream) = (r3v0 java.io.InputStream), (r3v0 java.io.InputStream), (r3v6 java.io.InputStream) binds: [B:3:0x000d, B:4:0x000f, B:13:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0047 A[Catch: IOException -> 0x0035, TRY_ENTER, TRY_LEAVE, TryCatch #1 {IOException -> 0x0035, blocks: (B:19:0x0031, B:30:0x0047), top: B:33:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BitmapFactory.Options getImageSize(Context context, Uri uri) throws Throwable {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            if (uri != null) {
                try {
                    if (context != null) {
                        try {
                            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                            if (inputStreamOpenInputStream != null) {
                                try {
                                    BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                                } catch (SecurityException e) {
                                    e = e;
                                    inputStream = inputStreamOpenInputStream;
                                    DocumentLogger.m7180e(TAG, " getImageSize : ", e);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    return options;
                                } catch (Throwable th) {
                                    th = th;
                                    inputStream = inputStreamOpenInputStream;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e2) {
                                            DocumentLogger.m7180e(TAG, "IOException Error", e2);
                                        }
                                    }
                                    throw th;
                                }
                            }
                            inputStream = inputStreamOpenInputStream;
                        } catch (SecurityException e3) {
                            e = e3;
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } else if (inputStream != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (IOException e5) {
            DocumentLogger.m7180e(TAG, "IOException Error", e5);
        }
        return options;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v4, types: [long] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getResizedImagePathFitingToScreen(Context context, String str, int i) throws Throwable {
        FileOutputStream fileOutputStream;
        Exception e;
        int screenMinSize = getScreenMinSize(context);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int iMin = Math.min(options.outHeight, options.outWidth);
        int i2 = options.outWidth;
        int i4 = options.outHeight;
        if (iMin > screenMinSize) {
            float f = screenMinSize / iMin;
            i2 = (int) (i2 * f);
            i4 = (int) (i4 * f);
        }
        int iMax = Math.max(i2, i4);
        if (iMax > i) {
            float f4 = i / iMax;
            i2 = (int) (i2 * f4);
            i4 = (int) (i4 * f4);
        }
        if (i2 == options.outWidth && i4 == options.outHeight) {
            return str;
        }
        StringBuilder sb = new StringBuilder("getResizeImagePathFitingToScreen : ");
        sb.append(options.outWidth);
        sb.append("/");
        AbstractC2821a.m2235z(sb, options.outHeight, i2, " to ", "/");
        sb.append(i4);
        DocumentLogger.m7181i(TAG, sb.toString());
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        if (bitmapDecodeFile == null) {
            throw new RuntimeException(AbstractC0541b.m772n("getResizedImagePathFitingToScreen - orgBitmap is null , ", str));
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeFile, i2, i4, true);
        String strSubstring = str.substring(str.lastIndexOf(Extension.DOT));
        ?? sb2 = new StringBuilder();
        sb2.append(context.getCacheDir());
        sb2.append("/scrapBook_resized_");
        ?? time = new Date().getTime();
        sb2.append(time);
        sb2.append(strSubstring);
        String string = sb2.toString();
        ?? r9 = 0;
        try {
            try {
                File file = new File(string);
                file.createNewFile();
                fileOutputStream = new FileOutputStream(file);
                try {
                    bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    time = fileOutputStream;
                } catch (Exception e2) {
                    e = e2;
                    DocumentLogger.m7179e(TAG, "Exception :" + e);
                    time = fileOutputStream;
                    if (fileOutputStream != null) {
                    }
                    bitmapDecodeFile.recycle();
                    bitmapCreateScaledBitmap.recycle();
                    DocumentLogger.m7181i(TAG, "getResizeImagePathFitingToScreen : " + string);
                    return string;
                }
            } catch (Throwable th) {
                th = th;
                r9 = time;
                if (r9 != 0) {
                    try {
                        r9.close();
                    } catch (IOException e3) {
                        AbstractC6670b.m4755p("Exception :", e3, TAG);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileOutputStream = null;
            e = e5;
        } catch (Throwable th2) {
            th = th2;
            if (r9 != 0) {
            }
            throw th;
        }
        try {
            time.close();
        } catch (IOException e6) {
            AbstractC6670b.m4755p("Exception :", e6, TAG);
        }
        bitmapDecodeFile.recycle();
        bitmapCreateScaledBitmap.recycle();
        DocumentLogger.m7181i(TAG, "getResizeImagePathFitingToScreen : " + string);
        return string;
    }

    public static int getScreenMinSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return Math.max(1440, Math.min(point.x, point.y));
    }

    public static boolean isDrawingMemo(Context context, Uri uri) {
        boolean z = false;
        if (uri != null) {
            String string = lookupImageInfo(context, uri).getString(KEY_DISPLAYNAME);
            if (string != null && string.startsWith(MEMO_DRAWING_PREFIX)) {
                z = true;
            }
            if (!z) {
                try {
                    return MEMO_DRAWING.equals(new ExifInterface(AppDelegator.getInstance().getPrivateFile(context, uri.getLastPathSegment()).getAbsolutePath()).getAttribute(androidx.exifinterface.media.ExifInterface.TAG_MAKE));
                } catch (IOException e) {
                    DocumentLogger.m7180e(TAG, "isDrawingMemo()", e);
                }
            }
        }
        return z;
    }

    private static boolean isPanorama(int i, int i2) {
        return (i > i2 ? ((float) i) / ((float) i2) : ((float) i2) / ((float) i)) > 2.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00aa A[Catch: all -> 0x0061, SecurityException -> 0x00b0, SQLException -> 0x00b6, TRY_LEAVE, TryCatch #2 {all -> 0x0061, blocks: (B:26:0x004d, B:28:0x0053, B:30:0x005b, B:39:0x0077, B:41:0x007f, B:52:0x00a2, B:54:0x00aa, B:61:0x00bd, B:63:0x00c5, B:50:0x009c), top: B:114:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c5 A[Catch: all -> 0x0061, SecurityException -> 0x00ca, SQLException -> 0x00d0, TRY_LEAVE, TryCatch #2 {all -> 0x0061, blocks: (B:26:0x004d, B:28:0x0053, B:30:0x005b, B:39:0x0077, B:41:0x007f, B:52:0x00a2, B:54:0x00aa, B:61:0x00bd, B:63:0x00c5, B:50:0x009c), top: B:114:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e9 A[PHI: r0 r5 r6 r7 r8
      0x00e9: PHI (r0v7 java.lang.String) = (r0v9 java.lang.String), (r0v16 java.lang.String) binds: [B:77:0x0101, B:71:0x00e7] A[DONT_GENERATE, DONT_INLINE]
      0x00e9: PHI (r5v2 android.database.Cursor) = (r5v4 android.database.Cursor), (r5v6 android.database.Cursor) binds: [B:77:0x0101, B:71:0x00e7] A[DONT_GENERATE, DONT_INLINE]
      0x00e9: PHI (r6v1 android.net.Uri) = (r6v3 android.net.Uri), (r6v9 android.net.Uri) binds: [B:77:0x0101, B:71:0x00e7] A[DONT_GENERATE, DONT_INLINE]
      0x00e9: PHI (r7v1 int) = (r7v3 int), (r7v5 int) binds: [B:77:0x0101, B:71:0x00e7] A[DONT_GENERATE, DONT_INLINE]
      0x00e9: PHI (r8v1 java.lang.String) = (r8v3 java.lang.String), (r8v5 java.lang.String) binds: [B:77:0x0101, B:71:0x00e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bundle lookupImageInfo(Context context, Uri uri) throws Throwable {
        Throwable th;
        SQLException sQLException;
        int orientation;
        String dataColumn;
        Cursor cursor;
        String string;
        Uri uri2;
        String str;
        SecurityException securityException;
        Cursor cursorQuery;
        String string2;
        String string3;
        Context applicationContext = context.getApplicationContext();
        Cursor cursor2 = null;
        if ("content".equals(uri.getScheme())) {
            try {
                try {
                    try {
                        if (applicationContext != null) {
                            try {
                                uri2 = uri;
                                try {
                                    cursorQuery = applicationContext.getContentResolver().query(uri2, null, null, null, null);
                                } catch (NullPointerException unused) {
                                    cursorQuery = null;
                                } catch (SecurityException e) {
                                    e = e;
                                    try {
                                        DocumentLogger.m7180e(TAG, " lookupImageInfo : ", e);
                                        cursorQuery = null;
                                    } catch (SecurityException e2) {
                                        securityException = e2;
                                        orientation = -1;
                                        dataColumn = null;
                                        cursor = null;
                                        string = null;
                                        DocumentLogger.m7180e(TAG, "lookupImageInfo() uri: " + uri2, securityException);
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        str = null;
                                        if (DocumentsContract.isDocumentUri(applicationContext, uri2)) {
                                            String[] strArrSplit = DocumentsContract.getDocumentId(uri2).split(":");
                                            dataColumn = getDataColumn(applicationContext, "image".equals(strArrSplit[0]) ? MediaStore.Images.Media.EXTERNAL_CONTENT_URI : null, "_id=?", new String[]{strArrSplit[1]});
                                        }
                                        if (orientation == -1) {
                                        }
                                        if (string == null) {
                                        }
                                        Bundle bundle = new Bundle();
                                        bundle.putInt(KEY_ORIENTATION, orientation);
                                        bundle.putString(KEY_DISPLAYNAME, string);
                                        bundle.putString(KEY_MIMETYPE, str);
                                        return bundle;
                                    }
                                }
                            } catch (SQLException e3) {
                                e = e3;
                                uri2 = uri;
                                sQLException = e;
                                orientation = -1;
                                dataColumn = null;
                                cursor = null;
                                string = null;
                                DocumentLogger.m7180e(TAG, "lookupImageInfo() uri: " + uri2, sQLException);
                                if (cursor != null) {
                                }
                                str = null;
                                if (DocumentsContract.isDocumentUri(applicationContext, uri2)) {
                                }
                                if (orientation == -1) {
                                }
                                if (string == null) {
                                }
                                Bundle bundle2 = new Bundle();
                                bundle2.putInt(KEY_ORIENTATION, orientation);
                                bundle2.putString(KEY_DISPLAYNAME, string);
                                bundle2.putString(KEY_MIMETYPE, str);
                                return bundle2;
                            } catch (NullPointerException unused2) {
                                uri2 = uri;
                            } catch (SecurityException e5) {
                                e = e5;
                                uri2 = uri;
                            }
                            if (cursorQuery != null) {
                                try {
                                    try {
                                        if (cursorQuery.moveToNext()) {
                                            int columnIndex = cursorQuery.getColumnIndex("_data");
                                            string2 = columnIndex != -1 ? cursorQuery.getString(columnIndex) : null;
                                            try {
                                                int columnIndex2 = cursorQuery.getColumnIndex("orientation");
                                                if (columnIndex2 != -1) {
                                                    try {
                                                        orientation = Integer.parseInt(cursorQuery.getString(columnIndex2));
                                                    } catch (NumberFormatException e6) {
                                                        DocumentLogger.m7180e(TAG, "orientation error", e6);
                                                        orientation = -1;
                                                    }
                                                    try {
                                                        int columnIndex3 = cursorQuery.getColumnIndex("_display_name");
                                                        string = columnIndex3 == -1 ? cursorQuery.getString(columnIndex3) : null;
                                                    } catch (SQLException e7) {
                                                        String str2 = string2;
                                                        cursor = cursorQuery;
                                                        sQLException = e7;
                                                        dataColumn = str2;
                                                        string = null;
                                                        DocumentLogger.m7180e(TAG, "lookupImageInfo() uri: " + uri2, sQLException);
                                                        if (cursor != null) {
                                                        }
                                                        str = null;
                                                        if (DocumentsContract.isDocumentUri(applicationContext, uri2)) {
                                                        }
                                                        if (orientation == -1) {
                                                        }
                                                        if (string == null) {
                                                        }
                                                        Bundle bundle22 = new Bundle();
                                                        bundle22.putInt(KEY_ORIENTATION, orientation);
                                                        bundle22.putString(KEY_DISPLAYNAME, string);
                                                        bundle22.putString(KEY_MIMETYPE, str);
                                                        return bundle22;
                                                    } catch (SecurityException e8) {
                                                        String str3 = string2;
                                                        cursor = cursorQuery;
                                                        securityException = e8;
                                                        dataColumn = str3;
                                                        string = null;
                                                        DocumentLogger.m7180e(TAG, "lookupImageInfo() uri: " + uri2, securityException);
                                                        if (cursor != null) {
                                                        }
                                                        str = null;
                                                        if (DocumentsContract.isDocumentUri(applicationContext, uri2)) {
                                                        }
                                                        if (orientation == -1) {
                                                        }
                                                        if (string == null) {
                                                        }
                                                        Bundle bundle222 = new Bundle();
                                                        bundle222.putInt(KEY_ORIENTATION, orientation);
                                                        bundle222.putString(KEY_DISPLAYNAME, string);
                                                        bundle222.putString(KEY_MIMETYPE, str);
                                                        return bundle222;
                                                    }
                                                    try {
                                                        int columnIndex4 = cursorQuery.getColumnIndex("mime_type");
                                                        string3 = columnIndex4 == -1 ? cursorQuery.getString(columnIndex4) : null;
                                                    } catch (SQLException e9) {
                                                        String str4 = string2;
                                                        cursor = cursorQuery;
                                                        sQLException = e9;
                                                        dataColumn = str4;
                                                        DocumentLogger.m7180e(TAG, "lookupImageInfo() uri: " + uri2, sQLException);
                                                        if (cursor != null) {
                                                        }
                                                        str = null;
                                                    } catch (SecurityException e10) {
                                                        String str5 = string2;
                                                        cursor = cursorQuery;
                                                        securityException = e10;
                                                        dataColumn = str5;
                                                        DocumentLogger.m7180e(TAG, "lookupImageInfo() uri: " + uri2, securityException);
                                                        if (cursor != null) {
                                                        }
                                                        str = null;
                                                    }
                                                } else {
                                                    orientation = -1;
                                                    int columnIndex32 = cursorQuery.getColumnIndex("_display_name");
                                                    if (columnIndex32 == -1) {
                                                    }
                                                    int columnIndex42 = cursorQuery.getColumnIndex("mime_type");
                                                    if (columnIndex42 == -1) {
                                                    }
                                                }
                                            } catch (SQLException e11) {
                                                String str6 = string2;
                                                cursor = cursorQuery;
                                                sQLException = e11;
                                                dataColumn = str6;
                                                orientation = -1;
                                            } catch (SecurityException e12) {
                                                String str7 = string2;
                                                cursor = cursorQuery;
                                                securityException = e12;
                                                dataColumn = str7;
                                                orientation = -1;
                                            }
                                        } else {
                                            orientation = -1;
                                            string3 = null;
                                            string2 = null;
                                            string = null;
                                        }
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        str = string3;
                                        dataColumn = string2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cursor2 = cursorQuery;
                                        if (cursor2 == null) {
                                            throw th;
                                        }
                                        cursor2.close();
                                        throw th;
                                    }
                                } catch (SQLException e13) {
                                    cursor = cursorQuery;
                                    sQLException = e13;
                                    orientation = -1;
                                    dataColumn = null;
                                    string = null;
                                } catch (SecurityException e14) {
                                    cursor = cursorQuery;
                                    securityException = e14;
                                    orientation = -1;
                                    dataColumn = null;
                                    string = null;
                                }
                            }
                        } else {
                            uri2 = uri;
                            if ("file".equals(uri2.getScheme())) {
                                dataColumn = uri2.getPath();
                                orientation = -1;
                                str = null;
                                string = null;
                            } else {
                                orientation = -1;
                                str = null;
                                dataColumn = null;
                                string = null;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cursor2 = cursor;
                }
            } catch (SQLException e15) {
                e = e15;
            }
        }
        if (DocumentsContract.isDocumentUri(applicationContext, uri2) && "com.android.providers.media.documents".equals(uri2.getAuthority())) {
            String[] strArrSplit2 = DocumentsContract.getDocumentId(uri2).split(":");
            dataColumn = getDataColumn(applicationContext, "image".equals(strArrSplit2[0]) ? MediaStore.Images.Media.EXTERNAL_CONTENT_URI : null, "_id=?", new String[]{strArrSplit2[1]});
        }
        if (orientation == -1) {
            if (dataColumn == null) {
                orientation = 0;
            } else {
                try {
                    orientation = setOrientation(dataColumn);
                } catch (Exception e16) {
                    DocumentLogger.m7180e(TAG, "orientation-ExifInterface", e16);
                    orientation = 0;
                }
            }
        }
        if (string == null) {
            string = uri2.getLastPathSegment();
        }
        Bundle bundle2222 = new Bundle();
        bundle2222.putInt(KEY_ORIENTATION, orientation);
        bundle2222.putString(KEY_DISPLAYNAME, string);
        bundle2222.putString(KEY_MIMETYPE, str);
        return bundle2222;
    }

    private static int setOrientation(String str) {
        int i = Integer.parseInt(new ExifInterface(str).getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION));
        if (i == 3) {
            return 180;
        }
        if (i != 6) {
            return i != 8 ? 0 : 270;
        }
        return 90;
    }

    public static void updateExifInterface(Context context, String str, int i, boolean z) {
        File privateFile = AppDelegator.getInstance().getPrivateFile(context, str);
        if (privateFile == null) {
            return;
        }
        try {
            ExifInterface exifInterface = new ExifInterface(privateFile.getAbsolutePath());
            exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, String.valueOf(i));
            if (z) {
                exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_MAKE, MEMO_DRAWING);
            }
            if (i == 90) {
                exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, String.valueOf(6));
            } else if (i == 180) {
                exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, String.valueOf(3));
            } else if (i != 270) {
                exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, String.valueOf(0));
            } else {
                exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, String.valueOf(8));
            }
            exifInterface.saveAttributes();
        } catch (IOException e) {
            AbstractC6670b.m4755p("IOException :", e, TAG);
        }
    }
}
