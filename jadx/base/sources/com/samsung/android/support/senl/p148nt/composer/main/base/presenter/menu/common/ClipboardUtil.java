package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipboardCacheManager;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.HtmlUtils;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ClipDataContentProvider;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.assist.common.C2paHandler;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ClipboardUtil {
    private static final String TAG = Logger.createTag("ClipboardUtil");

    public static void copyImageToClipboard(Bitmap bitmap) {
        copyImageToClipboard(bitmap, Bitmap.CompressFormat.JPEG, false);
    }

    public static void copyTextToClipboard(String str) {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        ((ClipboardManager) applicationContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Copied Text", str));
    }

    public static void copyImageToClipboard(Bitmap bitmap, boolean z) {
        copyImageToClipboard(bitmap, Bitmap.CompressFormat.JPEG, z);
    }

    public static void copyImageToClipboard(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        copyImageToClipboard(bitmap, compressFormat, false);
    }

    public static void copyImageToClipboard(Bitmap bitmap, Bitmap.CompressFormat compressFormat, boolean z) {
        AbstractC8014b.m7215q(new StringBuilder("copyImageToClipboard, resultImage is null? "), bitmap == null, TAG);
        if (bitmap == null) {
            return;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        String clipboardFileName = ClipboardCacheManager.getClipboardFileName(applicationContext, Constant.CLIPBOARD_COPY_FOLDER_NAME, Constant.CLIPBOARD_COPY_FILE_PREFIX + System.currentTimeMillis() + ".jpg");
        ImageUtil.saveBitmapToFileCache(bitmap, clipboardFileName, compressFormat, 95);
        if (z) {
            ImageUtil.addGenerativeEditData(clipboardFileName);
            C2paHandler.getInstance().addC2paCreateManifest(clipboardFileName);
        }
        ImageSpan imageSpan = new ImageSpan(applicationContext, ClipDataContentProvider.getUri(clipboardFileName));
        SpannableString spannableString = new SpannableString(" ");
        spannableString.setSpan(imageSpan, 0, 1, 33);
        ClipboardManagerCompat.INSTANCE.getInstance().setClip(BaseUtils.getApplicationContext(), new ClipData.Item(spannableString.toString().trim(), HtmlUtils.toHtml(spannableString)), new String[]{Constants.MIME_HTML}, Constant.CLIPBOARD_COPY_FOLDER_NAME);
    }
}
