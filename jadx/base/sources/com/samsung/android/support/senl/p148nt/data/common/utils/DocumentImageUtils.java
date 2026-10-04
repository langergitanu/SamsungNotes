package com.samsung.android.support.senl.p148nt.data.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.support.senl.document.memoconverter.core.ImageUtil;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentImageUtils {
    private static final String TAG = DataLogger.createTag("DocumentImageUtils");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Creator {
        public static ExifInterface createExif(InputStream inputStream) {
            return new ExifInterface(inputStream);
        }
    }

    public static Bitmap decodeScaled(@NonNull Context context, @NonNull Uri uri, @NonNull InputStream inputStream, int i, int i2) {
        return ImageUtil.decodeImageScaledIf(context, uri, i, getOrientation(inputStream), i2);
    }

    private static int exifToDegrees(int i) {
        if (i == 3) {
            return 180;
        }
        if (i != 6) {
            return i != 8 ? 0 : 270;
        }
        return 90;
    }

    private static int getOrientation(InputStream inputStream) {
        int iExifToDegrees = 0;
        try {
            iExifToDegrees = exifToDegrees(Creator.createExif(inputStream).getAttributeInt(ExifInterface.TAG_ORIENTATION, 0));
        } catch (IOException e) {
            AbstractC11014a.m12332q(e, new StringBuilder("getOrientation, e : "), TAG);
        }
        DataLogger.m12303e(TAG, "getOrientation, orientation : " + iExifToDegrees);
        return iExifToDegrees;
    }
}
