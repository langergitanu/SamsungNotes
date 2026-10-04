package com.samsung.android.support.senl.p148nt.model.base.utils.image;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class UtilImage {
    public static final int FLIP_HORIZONTAL = 1;
    public static final int FLIP_NONE = 0;
    public static final int FLIP_VERTICAL = 2;
    private static final int GRACE_WIDTH = 1440;
    private static final String TAG = ModelLogger.createTag("UtilImage");

    public static Bitmap applyFlipRotationBitmap(Bitmap bitmap, int i, int i2) {
        Matrix matrix = new Matrix();
        if (i2 != 0 || i != 0) {
            if (i2 == 1) {
                matrix.setScale(-1.0f, 1.0f);
            } else if (i2 == 2) {
                matrix.setScale(1.0f, -1.0f);
            }
            if (i != 0) {
                matrix.preRotate(i);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (!bitmap.equals(bitmapCreateBitmap) && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                return bitmapCreateBitmap;
            }
        }
        return bitmap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Pair<Integer, Integer> convertDegreesNFlip(int i) {
        int i2 = 1;
        int i4 = 90;
        switch (i) {
            case 2:
                i4 = 0;
                break;
            case 3:
                i4 = 180;
                i2 = 0;
                break;
            case 4:
                i2 = 2;
                i4 = 0;
                break;
            case 5:
                i4 = 270;
                break;
            case 6:
                i2 = 0;
                break;
            case 7:
                i2 = 2;
                break;
            case 8:
                i4 = 270;
                i2 = 0;
                break;
            default:
                i2 = 0;
                i4 = 0;
                break;
        }
        return new Pair<>(Integer.valueOf(i4), Integer.valueOf(i2));
    }

    public static Pair<Integer, Integer> getImageRotation(Context context, Uri uri) {
        try {
            if (uri.getPath() == null) {
                return new Pair<>(0, 0);
            }
            int attributeInt = new ExifInterface(uri.getPath()).getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
            return attributeInt == 0 ? getRotationFromMediaStore(context, uri) : convertDegreesNFlip(attributeInt);
        } catch (IOException unused) {
            int rotationFromUri = getRotationFromUri(context, uri);
            return rotationFromUri != 0 ? convertDegreesNFlip(rotationFromUri) : getRotationFromMediaStore(context, uri);
        }
    }

    private static Pair<Integer, Integer> getRotationFromMediaStore(Context context, Uri uri) {
        String[] strArr;
        int i = 0;
        Cursor cursorQuery = null;
        try {
            try {
                strArr = new String[]{"_data", "orientation"};
                cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
            } catch (Exception e) {
                DataLogger.m12303e(TAG, "getRotationFromMediaStore, e: " + e.getMessage());
                if (0 != 0) {
                }
                return new Pair<>(Integer.valueOf(i), 0);
            }
            if (cursorQuery == null) {
                DataLogger.m12302d(TAG, "getRotationFromMediaStore, cursor is null");
                Pair<Integer, Integer> pair = new Pair<>(0, 0);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return pair;
            }
            if (cursorQuery.moveToFirst()) {
                i = cursorQuery.getInt(cursorQuery.getColumnIndex(strArr[1]));
                DataLogger.m12302d(TAG, "getRotationFromMediaStore, ret: " + i);
            }
            cursorQuery.close();
            return new Pair<>(Integer.valueOf(i), 0);
        } finally {
        }
    }

    public static int getRotationFromUri(Context context, Uri uri) {
        int attributeInt = 0;
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                attributeInt = new ExifInterface(inputStreamOpenInputStream).getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
            } finally {
            }
        } catch (Exception e) {
            DataLogger.m12304e(TAG, "getRotationFromUri", e);
        }
        DataLogger.m12302d(TAG, "getRotationFromUri, rotation: " + attributeInt);
        return attributeInt;
    }

    public static int getScreenMinSizeBetterThanGRACE(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return Math.max(1440, Math.min(point.x, point.y));
    }

    public static Pair<Integer, Integer> getImageRotation(String str) {
        try {
            return convertDegreesNFlip(new ExifInterface(str).getAttributeInt(ExifInterface.TAG_ORIENTATION, 0));
        } catch (IOException unused) {
            return new Pair<>(0, 0);
        }
    }
}
