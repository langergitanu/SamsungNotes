package com.samsung.android.support.senl.p148nt.model.base.utils;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.C11397R;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class PositionUtil {
    public static final int NEXT_LINE_MARGIN = 1;
    private static final String TAG = ModelLogger.createTag("PositionUtil");

    private static void adjustPositionWithObjectRect(Context context, SpenWPage spenWPage, PointF pointF) {
        pointF.y = (int) Math.max(spenWPage.getDrawnRectOfAllObject().bottom + context.getResources().getDimensionPixelOffset(C11397R.dimen.insert_object_margin), pointF.y);
    }

    private static void adjustPositionWithPdfRect(SpenWPage spenWPage, PointF pointF) {
        if (!spenWPage.hasPDF() || spenWPage.getTemplateType() == 16) {
            return;
        }
        RectF rectF = ((SpenWPage.PDFData) AbstractC1974b.m1313f(1, spenWPage.getPDFData())).rect;
        pointF.x = (int) Math.max(rectF.left, pointF.x);
        pointF.y = (int) Math.max(rectF.bottom + 1.0f, pointF.y);
    }

    private static PointF getBodyTextRect(Context context, SpenWNote spenWNote, int i) throws Throwable {
        SpenBodyTextContext spenBodyTextContext;
        PointF pointF = new PointF();
        SpenBodyTextContext spenBodyTextContext2 = null;
        try {
            try {
                spenBodyTextContext = new SpenBodyTextContext(context);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            spenBodyTextContext.setDocument(spenWNote);
            spenBodyTextContext.measureText();
            RectF measuredFitRect = spenBodyTextContext.getMeasuredFitRect(i);
            pointF.x = measuredFitRect.left;
            pointF.y = measuredFitRect.bottom + 1.0f;
            spenBodyTextContext.close();
            return pointF;
        } catch (Exception e2) {
            e = e2;
            spenBodyTextContext2 = spenBodyTextContext;
            DataLogger.m12303e(TAG, "getBodyTextRect, e: " + e.getMessage());
            if (spenBodyTextContext2 != null) {
                spenBodyTextContext2.close();
            }
            return pointF;
        } catch (Throwable th2) {
            th = th2;
            spenBodyTextContext2 = spenBodyTextContext;
            if (spenBodyTextContext2 != null) {
                spenBodyTextContext2.close();
            }
            throw th;
        }
    }

    public static PointF getInsertedPosition(Context context, SpenWNote spenWNote, int i) {
        return getInsertedPosition(context, spenWNote, i, true);
    }

    public static PointF getInsertedPosition(Context context, SpenWNote spenWNote, int i, boolean z) throws Throwable {
        PointF bodyTextRect = getBodyTextRect(context, spenWNote, i);
        SpenWPage page = spenWNote.getPage(i);
        if (z) {
            adjustPositionWithPdfRect(page, bodyTextRect);
        }
        adjustPositionWithObjectRect(context, page, bodyTextRect);
        Point offset = page.getOffset();
        bodyTextRect.offset(offset.x, offset.y);
        return bodyTextRect;
    }
}
