package com.samsung.android.support.senl.p148nt.composer.main.base.model.share;

import android.content.Context;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.p145cm.base.common.util.BaseImageUtils;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.base.composer.share.BaseShareUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Restriction;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShareUtils {
    public static final String DEFAULT_PREFIX_TITLE = "Notes";
    private static final String TAG = Logger.createTag("ShareUtils");
    public static String DEFAULT_NOTE_FILE_PATH = "";
    public static String INTENT_RESOLVER_PACKAGE_NAME = "com.android.intentresolver";

    public static Uri attachUserIdToAuthority(Uri uri, int i) {
        String authority = uri.getAuthority();
        if (authority == null || authority.contains(Log.TAG_SEPARATOR)) {
            return uri;
        }
        return Uri.parse(uri.toString().replace(authority, i + Log.TAG_SEPARATOR + authority));
    }

    private static int calculateHeightOfThumbnail(int i) {
        int height = DocumentPageRatio.PAGE_RATIO.getHeight(i);
        int maxTextureSize = BaseImageUtils.getMaxTextureSize() / height;
        return height * (maxTextureSize > 0 ? Math.min(maxTextureSize, 3) : 3);
    }

    private static int calculatePdfRect(SpenWPage spenWPage, List<RectF> list) {
        int i = 0;
        if (!spenWPage.hasPDF()) {
            return 0;
        }
        for (SpenWPage.PDFData pDFData : spenWPage.getPDFData()) {
            list.add(pDFData.rect);
            i = (int) pDFData.rect.bottom;
        }
        return i;
    }

    public static String generateNewFileName(String str, long j) {
        String cleanTitle = BaseShareUtil.getCleanTitle(str);
        Date date = j <= 0 ? new Date() : new Date(j);
        StringBuilder sbM781w = AbstractC0541b.m781w(cleanTitle, "_");
        sbM781w.append(new SimpleDateFormat("yyMMdd_HHmmss", Locale.ENGLISH).format(date));
        return sbM781w.toString();
    }

    public static String generateNewFilePath(String str, String str2, long j, String str3) {
        String titleForFileName = Restriction.getTitleForFileName(str2);
        return TextUtils.isEmpty(str) ? getDocumentTimeName(titleForFileName, j) : FileUtils.generateUniqueFilePath(str, generateNewFileName(titleForFileName, j), str3);
    }

    public static String getDefaultNoteFilePath() {
        return DEFAULT_NOTE_FILE_PATH;
    }

    public static String getDocumentTimeName(String str) {
        return BaseShareUtil.getDocumentTimeName(str);
    }

    public static ArrayList<RectF> getPageThumbnailRect(SpenWNote spenWNote, RectF rectF) {
        ArrayList<RectF> arrayList = new ArrayList<>();
        int pageDefaultWidth = spenWNote.getPageDefaultWidth();
        if (spenWNote.getPageMode() == SpenWNote.PageMode.SINGLE && pageDefaultWidth != 0) {
            int iCalculateHeightOfThumbnail = calculateHeightOfThumbnail(pageDefaultWidth);
            SpenWPage page = spenWNote.getPage(0);
            int iCalculatePdfRect = calculatePdfRect(page, arrayList);
            int iMax = (int) Math.max(page.getDrawnRectOfAllObject().bottom, rectF.bottom);
            while (iCalculatePdfRect < iMax) {
                iCalculatePdfRect += iCalculateHeightOfThumbnail;
                arrayList.add(new RectF(0.0f, iCalculatePdfRect, spenWNote.getWidth(), Math.min(iMax, iCalculatePdfRect)));
            }
            Logger.m10999d(TAG, "getPageThumbnailRect# " + arrayList.size());
        }
        return arrayList;
    }

    @Nullable
    public static File getSaveAsFixedDir(Context context) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), context.getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C9086R.string.composer_save_to_image_dir_galaxy : C9086R.string.composer_save_to_image_dir));
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static String getShareType(List<Integer> list) {
        int[] iArr = new int[3];
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (iIntValue != 1) {
                if (iIntValue != 2) {
                    if (iIntValue != 3 && iIntValue != 7 && iIntValue != 8) {
                        if (iIntValue == 10) {
                            iArr[2] = iArr[2] + 1;
                        } else if (iIntValue == 13 || iIntValue == 17) {
                        }
                    }
                }
                iArr[0] = iArr[0] + 1;
            }
            iArr[1] = iArr[1] + 1;
        }
        int i = iArr[1];
        return (i == 0 && iArr[2] == 0) ? "text/plain" : (i <= 0 || iArr[2] != 0) ? (i != 0 || iArr[2] <= 0) ? "*/*" : "audio/mp4" : Constants.MIME_IMAGE;
    }

    public static Uri grantUriPermissionForChooser(Context context, Uri uri) {
        context.grantUriPermission(INTENT_RESOLVER_PACKAGE_NAME, uri, 1);
        return uri;
    }

    public static boolean isNotSupportedFileProviderForChina() {
        return BaseShareUtil.isNotSupportedFileProviderForChina();
    }

    public static void setDefaultNoteFilePath(Context context) {
        DEFAULT_NOTE_FILE_PATH = WDocUtils.getNoteFilePath(context);
    }

    public static String getDocumentTimeName(String str, long j) {
        String cleanTitle = BaseShareUtil.getCleanTitle(str);
        if (j <= 0) {
            return getDocumentTimeName(cleanTitle);
        }
        String strSubstring = UUID.randomUUID().toString().substring(r0.length() - 3);
        StringBuilder sbM781w = AbstractC0541b.m781w(cleanTitle, "_");
        sbM781w.append(new SimpleDateFormat("yyMMdd_HHmmss", Locale.ENGLISH).format(new Date(j)));
        sbM781w.append("_");
        sbM781w.append(strSubstring);
        return sbM781w.toString();
    }
}
