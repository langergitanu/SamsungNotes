package p080T0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.util.BaseImageUtils;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: T0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0300a {
    /* JADX WARN: Removed duplicated region for block: B:53:0x018e A[PHI: r14
      0x018e: PHI (r14v1 java.lang.String) = (r14v0 java.lang.String), (r14v3 java.lang.String), (r14v3 java.lang.String) binds: [B:33:0x0133, B:37:0x0141, B:38:0x0143] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList m656a(Context context, SpenWNote wNote, String destPath) {
        int i;
        int pageCount;
        Bitmap bitmapCapturePage;
        int i2;
        int i4;
        Intrinsics.checkNotNullParameter(wNote, "wNote");
        Intrinsics.checkNotNullParameter(destPath, "destPath");
        NoteCaptureControl noteCaptureControl = new NoteCaptureControl(context);
        noteCaptureControl.setWNote(wNote);
        SpenWNote.PageMode pageMode = wNote.getPageMode();
        ArrayList arrayList = new ArrayList();
        SpenWNote.PageMode pageMode2 = SpenWNote.PageMode.SINGLE;
        if (pageMode == pageMode2) {
            SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(context);
            spenBodyTextContext.setDocument(wNote);
            spenBodyTextContext.measureText();
            RectF measuredFitRect = spenBodyTextContext.getMeasuredFitRect(0);
            spenBodyTextContext.close();
            arrayList = new ArrayList();
            int pageDefaultWidth = wNote.getPageDefaultWidth();
            if (wNote.getPageMode() == pageMode2 && pageDefaultWidth != 0) {
                int height = DocumentPageRatio.PAGE_RATIO.getHeight(pageDefaultWidth);
                int maxTextureSize = BaseImageUtils.getMaxTextureSize() / height;
                int iMin = height * (maxTextureSize > 0 ? (int) Math.min(maxTextureSize, 3) : 3);
                SpenWPage page = wNote.getPage(0);
                if (page.hasPDF()) {
                    ArrayList<SpenWPage.PDFData> pdfData = page.getPdfData();
                    Intrinsics.checkNotNull(pdfData);
                    Iterator<SpenWPage.PDFData> it = pdfData.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    i4 = 0;
                    while (it.hasNext()) {
                        SpenWPage.PDFData next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        SpenWPage.PDFData pDFData = next;
                        arrayList.add(pDFData.rect);
                        i4 = (int) pDFData.rect.bottom;
                    }
                } else {
                    i4 = 0;
                }
                int iMax = (int) Math.max(page.getDrawnRectOfAllObject().bottom, measuredFitRect.bottom);
                while (i4 < iMax) {
                    i4 += iMin;
                    arrayList.add(new RectF(0.0f, i4, wNote.getWidth(), (float) Math.min(iMax, i4)));
                }
            }
            if (arrayList.isEmpty()) {
                i = 0;
                pageCount = 0;
            } else {
                pageCount = arrayList.size();
                i = 0;
                noteCaptureControl.setContents(wNote.getPage(0), wNote.getBodyText(), 0);
            }
        } else {
            i = 0;
            pageCount = wNote.getPageCount() - 1;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList<SpenWPage> pageList = wNote.getPageList();
        File file = new File(destPath);
        String strExtractFileName = FileUtils.extractFileName(file.getName());
        while (i < pageCount) {
            if (pageMode == SpenWNote.PageMode.SINGLE) {
                bitmapCapturePage = noteCaptureControl.captureRect((RectF) arrayList.get(i));
            } else {
                noteCaptureControl.setContents(pageList.get(i), wNote.getBodyText(), i);
                bitmapCapturePage = noteCaptureControl.capturePage(1.0f);
            }
            i++;
            String strM2218i = AbstractC2821a.m2218i(i, strExtractFileName, "_");
            if (file.getParent() == null) {
                i2 = pageCount;
            } else {
                String parent = file.getParent();
                strGenerateUniqueFilePath = parent != null ? FileUtils.generateUniqueFilePath(parent, strM2218i, "datafile") : null;
                if (strGenerateUniqueFilePath != null && bitmapCapturePage != null) {
                    int width = bitmapCapturePage.getWidth() > 0 ? bitmapCapturePage.getWidth() : 1000;
                    int height2 = bitmapCapturePage.getHeight() > 0 ? bitmapCapturePage.getHeight() : 4000;
                    if (height2 <= 300) {
                        height2 = 300;
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height2, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    canvas.drawColor(-1);
                    i2 = pageCount;
                    canvas.drawBitmap(bitmapCapturePage, 0.0f, 0.0f, new Paint());
                    bitmapCapturePage.recycle();
                    ImageUtils.makeJpg(bitmapCreateBitmap, new File(strGenerateUniqueFilePath), 100);
                }
            }
            if (strGenerateUniqueFilePath != null && AbstractC2322a.m1607A(strGenerateUniqueFilePath)) {
                arrayList2.add(strGenerateUniqueFilePath);
                arrayList3.add("image/jpeg");
            }
            pageCount = i2;
        }
        noteCaptureControl.close();
        return arrayList2;
    }
}
