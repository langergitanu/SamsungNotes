package com.samsung.android.support.senl.p148nt.model.document.save;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.data.C6636R;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class PageThumbnailSaver {
    private static final String CONTENT_DIR = "/media";
    private static final float LAYOUT_CAPTURE_AREA = 0.8f;
    private static final float LAYOUT_CAPTURE_AREA_RATIO = 0.7f;
    private static final float MAX_IMAGE_THUMBNAIL_RATIO = 2.0f;
    private static final float MINIMUM_CAPTURE_AREA = 0.3f;
    private static final float MINIMUM_CAPTURE_AREA_RATIO = 1.0f;
    private static final int MIN_IMAGE_THUMBNAIL_HEIGHT_DP = 130;
    private static final float MIN_THUMBNAIL_HEIGHT = 200.0f;
    private static final int THUMBNAIL_COMPRESS_HIGH_QUALITY = 100;
    private static final int THUMBNAIL_COMPRESS_QUALITY = 90;
    private final RectF mBodyTextRectF;
    private float mBottom;
    private NoteCaptureControl mCaptureControl;
    private Context mContext;
    private float mCropBottom;
    private float mCropLeft;
    private float mCropRight;
    private float mCropTop;
    private final int mEditedPageIndex;
    private boolean mHasBackground;
    private final boolean mHasTextWithObjectSpan;
    private SpenWNote mNote;
    private SpenWPage mPage;
    private int mPageHeight;
    private int mPageWidth;
    private float mTop;
    private float mTotalBottom;
    private final String mUuid;
    private static final String TAG = DataLogger.createTag("PageThumbnailSaver");
    private static float sMinImageHeightForThumbnail = 0.0f;
    private float mRatio = 0.7f;
    StringBuilder mFullFileNameBuilder = new StringBuilder(Constants.MAIN_FULL_THUMBNAIL_FILE_NAME);
    StringBuilder mCropFileNameBuilder = new StringBuilder("thumbnail");

    public PageThumbnailSaver(Context context, SpenWNote spenWNote, String str, int i, RectF rectF, boolean z) {
        this.mContext = context;
        this.mNote = spenWNote;
        this.mUuid = str;
        this.mEditedPageIndex = i;
        this.mBodyTextRectF = rectF;
        this.mPage = spenWNote.getPage(i);
        this.mHasTextWithObjectSpan = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap[] capture(List<String> list) {
        DataLogger.m12308p(TAG, "create bitmap - start");
        NoteCaptureControl noteCaptureControl = new NoteCaptureControl(this.mContext);
        this.mCaptureControl = noteCaptureControl;
        noteCaptureControl.setWNote(this.mNote);
        this.mCaptureControl.setContents(this.mPage, this.mNote.getBodyText(), this.mEditedPageIndex);
        Bitmap[] bitmapArr = new Bitmap[2];
        for (int i = 0; i <= 1; i++) {
            StringBuilder sb = new StringBuilder();
            this.mCaptureControl.setColorTheme(i);
            String str = TAG;
            DataLogger.m12308p(str, "PageThumbnailSaver#capture start theme : " + i);
            if (this.mNote.getPageMode() == SpenWNote.PageMode.SINGLE) {
                float dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C6636R.dimen.note_list_thumbnail_offset);
                this.mTop -= dimensionPixelSize;
                this.mTotalBottom -= dimensionPixelSize;
                RectF rectF = new RectF(0.0f, this.mTop, this.mPageWidth, this.mTotalBottom);
                float f = rectF.top;
                float f4 = this.mRatio;
                Rect rect = new Rect(0, (int) (f * f4), (int) (rectF.right * f4), (int) (rectF.bottom * f4));
                Bitmap bitmapCaptureRect = this.mCaptureControl.captureRect(rectF);
                if (bitmapCaptureRect == null) {
                    sb.append(" capture# SINGLE mode, fail\n");
                } else {
                    bitmapArr[i] = Bitmap.createScaledBitmap(bitmapCaptureRect, rect.width(), rect.height(), true);
                    sb.append("capture# SINGLE mode, finalRect : ");
                    sb.append(rect);
                    DataLogger.m12308p(str, "PageThumbnailSaver#capture end theme " + i);
                    if (ImageUtils.makeJpg(bitmapArr[i], PageCacheUtils.getCacheDirectory(this.mContext, this.mUuid, Constants.MAIN_THUMBNAIL_PATH) + File.separator + list.get(i), this.mRatio != 1.0f ? 100 : 90, false)) {
                        sb.append(" fail\n");
                    } else {
                        sb.append(" success, theme : ");
                        sb.append(i);
                        sb.append('\n');
                    }
                    DataLogger.m12307i(str, sb.toString());
                }
            } else {
                RectF rectF2 = new RectF(0.0f, 0.0f, this.mPageWidth, this.mTotalBottom);
                float f5 = this.mPageWidth;
                float f6 = this.mRatio;
                Rect rect2 = new Rect(0, 0, (int) (f5 * f6), (int) (this.mTotalBottom * f6));
                Bitmap bitmapCaptureRect2 = this.mCaptureControl.captureRect(rectF2);
                if (bitmapCaptureRect2 == null) {
                    sb.append(" capture# LIST mode, fail\n");
                } else {
                    bitmapArr[i] = Bitmap.createScaledBitmap(bitmapCaptureRect2, rect2.width(), rect2.height(), true);
                    sb.append("capture# LIST mode, finalRect : ");
                    sb.append(rect2);
                    DataLogger.m12308p(str, "PageThumbnailSaver#capture end theme " + i);
                    if (ImageUtils.makeJpg(bitmapArr[i], PageCacheUtils.getCacheDirectory(this.mContext, this.mUuid, Constants.MAIN_THUMBNAIL_PATH) + File.separator + list.get(i), this.mRatio != 1.0f ? 100 : 90, false)) {
                    }
                    DataLogger.m12307i(str, sb.toString());
                }
            }
        }
        DataLogger.m12308p(TAG, "create bitmap - end");
        releaseCaptureControl();
        return bitmapArr;
    }

    private void cropCapture(Bitmap[] bitmapArr, String[] strArr) {
        float f = this.mTop;
        float f4 = this.mRatio;
        Rect rect = new Rect(0, (int) (f * f4), (int) (this.mPageWidth * f4), (int) (this.mBottom * f4));
        SpenWNote.PageMode pageMode = this.mNote.getPageMode();
        for (int i = 0; i < 2; i++) {
            if (ImageUtils.makeJpg(Bitmap.createBitmap(bitmapArr[i], 0, pageMode == SpenWNote.PageMode.SINGLE ? 0 : rect.top, rect.width(), Math.min(rect.height(), bitmapArr[i].getHeight())), PageCacheUtils.getCacheDirectory(this.mContext, this.mUuid, Constants.MAIN_THUMBNAIL_PATH) + File.separator + strArr[i], this.mRatio == 1.0f ? 100 : 90, true)) {
                DataLogger.m12302d(TAG, "cropCapture# success");
            }
            if (!bitmapArr[i].isRecycled()) {
                bitmapArr[i].recycle();
            }
        }
    }

    public static boolean hasTemplate(SpenWPage spenWPage) {
        return spenWPage.getTemplateType() != 0;
    }

    private void releaseCaptureControl() {
        NoteCaptureControl noteCaptureControl = this.mCaptureControl;
        if (noteCaptureControl != null) {
            noteCaptureControl.close();
            this.mCaptureControl = null;
        }
    }

    private void roundCropCapture(List<String> list) {
        DataLogger.m12308p(TAG, "create bitmap - start");
        NoteCaptureControl noteCaptureControl = new NoteCaptureControl(this.mContext);
        this.mCaptureControl = noteCaptureControl;
        noteCaptureControl.setWNote(this.mNote);
        this.mCaptureControl.setContents(this.mPage, this.mNote.getBodyText(), this.mEditedPageIndex);
        Bitmap[] bitmapArr = new Bitmap[2];
        for (int i = 0; i <= 1; i++) {
            StringBuilder sb = new StringBuilder();
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C6636R.dimen.note_list_thumbnail_offset);
            if (this.mCropLeft == 0.0f || Float.compare(this.mCropRight, this.mPageWidth) == 0) {
                this.mCropTop -= dimensionPixelSize;
            } else {
                float f = dimensionPixelSize;
                this.mCropLeft -= f;
                this.mCropTop -= f;
                this.mCropRight += f;
                this.mCropBottom += f;
            }
            this.mCaptureControl.setColorTheme(i);
            String str = TAG;
            DataLogger.m12308p(str, "PageThumbnailSaver#roundCropCapture start theme : " + i);
            RectF rectF = new RectF(this.mCropLeft, this.mCropTop, this.mCropRight, this.mCropBottom);
            Rect rect = new Rect((int) this.mCropLeft, (int) this.mCropTop, (int) this.mCropRight, (int) this.mCropBottom);
            Bitmap bitmapCaptureRect = this.mCaptureControl.captureRect(rectF);
            if (bitmapCaptureRect == null) {
                sb.append(" roundCropCapture#, fail\n");
            } else {
                bitmapArr[i] = Bitmap.createScaledBitmap(bitmapCaptureRect, rect.width(), rect.height(), true);
                if (ImageUtils.makeJpg(bitmapArr[i], PageCacheUtils.getCacheDirectory(this.mContext, this.mUuid, Constants.MAIN_THUMBNAIL_PATH) + File.separator + list.get(i), this.mRatio == 1.0f ? 100 : 90, true)) {
                    sb.append(" success, theme : ");
                    sb.append(i);
                    sb.append('\n');
                } else {
                    sb.append(" fail\n");
                }
                DataLogger.m12307i(str, sb.toString());
            }
        }
        DataLogger.m12308p(TAG, "create bitmap - end");
        releaseCaptureControl();
    }

    private boolean setPageSize() {
        this.mPageWidth = this.mPage.getWidth();
        this.mPageHeight = this.mPage.getHeight();
        if (this.mNote.getPageMode() == SpenWNote.PageMode.SINGLE) {
            this.mPageHeight = (int) (this.mPageWidth * 1.4142857f);
        } else {
            if (this.mEditedPageIndex == this.mNote.getPageCount() - 1) {
                DataLogger.m12302d(TAG, "PageThumbnailSaver#setPageSize editPageIndex : " + this.mEditedPageIndex + " dummy page. no thumbnail");
                return false;
            }
            int i = (int) (this.mPageWidth * 2.0f);
            if (this.mPageHeight > i) {
                this.mPageHeight = i;
            }
        }
        DataLogger.m12302d(TAG, "PageThumbnailSaver#setPageSize pageWidth : " + this.mPageWidth + ", pageHeight : " + this.mPageHeight);
        return true;
    }

    private boolean setTopBottom() {
        RectF drawnRectOfAllObject = this.mPage.getDrawnRectOfAllObject();
        this.mTop = 0.0f;
        int i = this.mPageHeight;
        this.mBottom = i;
        this.mCropTop = 0.0f;
        this.mCropBottom = i;
        this.mCropLeft = 0.0f;
        this.mCropRight = this.mPageWidth;
        String str = TAG;
        DataLogger.m12302d(str, "setTopBottom# objectRectF : " + drawnRectOfAllObject + ", bodyTextRectF : " + this.mBodyTextRectF + ", top : " + this.mTop + ", bottom " + this.mBottom);
        boolean z = this.mPage.hasPDF() || hasTemplate(this.mPage);
        this.mHasBackground = z;
        if (z) {
            DataLogger.m12302d(str, "setTopBottom# has PDF or Template");
        } else {
            if (drawnRectOfAllObject.isEmpty() && this.mBodyTextRectF.isEmpty()) {
                DataLogger.m12302d(str, "setTopBottom# has only title");
                return false;
            }
            if (drawnRectOfAllObject.isEmpty()) {
                if (this.mHasTextWithObjectSpan) {
                    DataLogger.m12302d(str, "setTopBottom# has only text with object span");
                } else {
                    DataLogger.m12302d(str, "setTopBottom# has only text");
                    this.mCropFileNameBuilder.append(Constants.MAIN_THUMBNAIL_FILE_NAME_TEXT);
                    this.mFullFileNameBuilder.append(Constants.MAIN_THUMBNAIL_FILE_NAME_TEXT);
                }
                float fMax = Math.max(0.0f, this.mBodyTextRectF.top);
                this.mTop = fMax;
                RectF rectF = this.mBodyTextRectF;
                float f = rectF.bottom;
                this.mBottom = f;
                this.mCropTop = fMax;
                this.mCropBottom = f;
                this.mCropLeft = Math.max(0.0f, rectF.left);
                this.mCropRight = Math.min(this.mPageWidth, this.mBodyTextRectF.right);
                DataLogger.m12302d(str, "setTopBottom# objectRectF is empty - top : " + this.mTop + ", bottom : " + this.mBottom);
            } else if (this.mBodyTextRectF.isEmpty()) {
                float fMax2 = Math.max(0.0f, drawnRectOfAllObject.top);
                this.mTop = fMax2;
                float f4 = drawnRectOfAllObject.bottom;
                this.mBottom = f4;
                this.mCropTop = fMax2;
                this.mCropBottom = f4;
                this.mCropLeft = Math.max(0.0f, drawnRectOfAllObject.left);
                this.mCropRight = Math.min(this.mPageWidth, drawnRectOfAllObject.right);
                DataLogger.m12302d(str, "setTopBottom# has only handwriting or image - top : " + this.mTop + ", bottom : " + this.mBottom);
            } else {
                this.mTop = Math.max(0.0f, Math.min(drawnRectOfAllObject.top, this.mBodyTextRectF.top));
                float fMax3 = Math.max(drawnRectOfAllObject.bottom, this.mBodyTextRectF.bottom);
                this.mBottom = fMax3;
                this.mCropTop = this.mTop;
                this.mCropBottom = fMax3;
                this.mCropLeft = Math.max(0.0f, Math.min(drawnRectOfAllObject.left, this.mBodyTextRectF.left));
                this.mCropRight = Math.min(this.mPageWidth, Math.max(drawnRectOfAllObject.right, this.mBodyTextRectF.right));
                DataLogger.m12302d(str, "setTopBottom# everything - top : " + this.mTop + ", bottom : " + this.mBottom);
            }
        }
        if (this.mNote.getPageMode() == SpenWNote.PageMode.LIST) {
            float f5 = this.mBottom;
            int i2 = this.mPageHeight;
            if (f5 > i2) {
                this.mBottom = i2;
            }
            this.mTotalBottom = i2;
        } else {
            float f6 = this.mBottom - this.mTop;
            int i4 = this.mPageHeight;
            if (f6 > i4) {
                this.mBottom = (float) Math.floor(r3 + i4);
            } else if (f6 < 0.0f) {
                this.mTop = 0.0f;
                this.mBottom = i4;
            }
            this.mTotalBottom = this.mTop + this.mPageHeight;
        }
        if (this.mBottom < 200.0f) {
            this.mBottom = 200.0f;
        }
        DataLogger.m12302d(str, "setTopBottom# final - top : " + this.mTop + ", bottom : " + this.mBottom + ", totalBottom : " + this.mTotalBottom);
        if (!this.mHasBackground) {
            this.mCropTop = Math.min(this.mCropTop, this.mTop);
            float fMin = Math.min(this.mCropBottom, this.mBottom);
            this.mCropBottom = fMin;
            float f7 = this.mCropRight - this.mCropLeft;
            float f8 = this.mCropTop;
            float f9 = fMin - f8;
            int i5 = this.mPageWidth;
            float f10 = i5 * 0.3f;
            float f11 = i5 * 0.8f;
            this.mRatio = 0.7f;
            if (f7 < f10) {
                float f12 = (f10 - f7) / 2.0f;
                float fMax4 = Math.max(f8 - ((f10 - f9) / 2.0f), 0.0f);
                this.mCropTop = fMax4;
                float f13 = fMax4 + f10;
                this.mCropBottom = f13;
                int i6 = this.mPageHeight;
                if (f13 > i6) {
                    float f14 = i6;
                    this.mCropBottom = f14;
                    this.mCropTop = f14 - f10;
                }
                float fMax5 = Math.max(this.mCropLeft - f12, 0.0f);
                this.mCropLeft = fMax5;
                float f15 = fMax5 + f10;
                this.mCropRight = f15;
                int i7 = this.mPageWidth;
                if (f15 > i7) {
                    float f16 = i7;
                    this.mCropRight = f16;
                    this.mCropLeft = f16 - f10;
                }
                this.mRatio = 1.0f;
            } else if (f7 > f11) {
                this.mCropLeft = 0.0f;
                this.mCropRight = i5;
            }
        }
        return true;
    }

    public void release() {
        releaseCaptureControl();
        this.mContext = null;
        this.mNote = null;
        this.mPage = null;
    }

    public List<String> run() {
        if (!setPageSize() || !setTopBottom()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        String string = this.mFullFileNameBuilder.toString();
        arrayList.add(string);
        arrayList.add("d_" + string);
        Bitmap[] bitmapArrCapture = capture(arrayList);
        String string2 = this.mCropFileNameBuilder.toString();
        String[] strArr = {string2, AbstractC0541b.m772n("d_", string2)};
        cropCapture(bitmapArrCapture, strArr);
        arrayList.add(strArr[0]);
        arrayList.add(strArr[1]);
        if (!this.mHasBackground) {
            roundCropCapture(arrayList);
        }
        return arrayList;
    }
}
