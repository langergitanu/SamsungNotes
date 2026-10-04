package com.samsung.android.support.senl.p148nt.app.common.util;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditUserThumbnailUtils {
    public static boolean loadThumbnailFromUri(ImageView imageView, String str) {
        return loadThumbnailFromUri(imageView, TextUtils.isEmpty(str) ? null : Uri.parse(str));
    }

    public static boolean loadThumbnailFromUri(ImageView imageView, Uri uri) {
        if (uri == null) {
            MainCoeditLogger.m7250d("CoeditUserThumbnailUtils", "loadThumbnailFromUri# setImageURI fail : Uri empty");
            return false;
        }
        try {
            imageView.setImageURI(uri);
            if (imageView.getDrawable() != null) {
                return true;
            }
            MainCoeditLogger.m7250d("CoeditUserThumbnailUtils", "loadThumbnailFromUri# setImageURI fail : Drawable empty");
            return false;
        } catch (Exception e) {
            MainCoeditLogger.m7251e("CoeditUserThumbnailUtils", "loadThumbnailFromUri# setImageURI fail : " + e.getMessage());
            imageView.setImageURI(null);
            return false;
        }
    }
}
