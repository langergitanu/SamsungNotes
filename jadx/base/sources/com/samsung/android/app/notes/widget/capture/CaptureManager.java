package com.samsung.android.app.notes.widget.capture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.theme.ThemeInfo;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.SpenOpenModeManager;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\fJ\b\u0010$\u001a\u00020%H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010&\u001a\u00020%H\u0002J\u0010\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0012H\u0002J\"\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010.J \u0010/\u001a\n\u0012\u0004\u0012\u00020*\u0018\u0001002\u0006\u0010\u0016\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010.J*\u00101\u001a\u00020%2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010+\u001a\u00020\u00122\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J \u00106\u001a\u00020\t2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u0010+\u001a\u00020\u0012H\u0002J\u0006\u0010:\u001a\u00020%R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u000e\u0010#\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00107\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b7\u0010\u001eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/capture/CaptureManager;", "", "context", "Landroid/content/Context;", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "filePath", "", "closeDoc", "", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;Ljava/lang/String;Z)V", "(Landroid/content/Context;Ljava/lang/String;)V", "mContext", "mFilePath", "mCaptureEngine", "Lcom/samsung/android/support/senl/nt/base/common/NoteCaptureControl;", "mPageLoadWidth", "", "mPageLoadHeight", "mWNote", "value", "pageCount", "getPageCount", "()I", "pageColor", "getPageColor", "mPageMode", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$PageMode;", "isTextOnlyNote", "()Z", "mPageRectList", "", "Landroid/graphics/RectF;", "isBackgroundImage", "mCloseDoc", "init", "", "initListPage", "initSinglePageCaptureRect", "defaultPageHeight", "captureListPage", "Landroid/graphics/Bitmap;", "pageIndex", "targetViewWidth", "themeInfo", "Lcom/samsung/android/app/notes/widget/theme/ThemeInfo;", "captureSinglePage", "", "setContents", "page", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", ExternalDataConstants.Column.BODY_TEXT, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "isContentExistPage", "isListPageMode", "getNote", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "release", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CaptureManager {

    @NotNull
    private static final String TAG = "CaptureManager";
    private boolean isBackgroundImage;
    private boolean isTextOnlyNote;

    @Nullable
    private NoteCaptureControl mCaptureEngine;
    private boolean mCloseDoc;

    @Nullable
    private Context mContext;

    @Nullable
    private String mFilePath;
    private int mPageLoadHeight;
    private int mPageLoadWidth;

    @Nullable
    private SpenWNote.PageMode mPageMode;

    @Nullable
    private List<RectF> mPageRectList;

    @Nullable
    private SpenWNote mWNote;
    private int pageColor;
    private int pageCount;
    public static final int $stable = 8;

    public CaptureManager(@NotNull Context context, @NotNull SpenWNote note, @NotNull String filePath, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Logger.m10999d(TAG, "CaptureManager# with note");
        this.mContext = context;
        this.mCloseDoc = z;
        this.mWNote = note;
        this.mFilePath = filePath;
        this.mPageMode = note.getPageMode();
        this.mPageLoadWidth = note.getWidth();
        this.mPageLoadHeight = isListPageMode() ? note.getPageDefaultHeight() : DocumentPageRatio.PAGE_RATIO.getHeight(this.mPageLoadWidth);
        SpenWNote spenWNote = this.mWNote;
        Intrinsics.checkNotNull(spenWNote);
        init(spenWNote);
    }

    private final void init() {
        try {
            DocumentFileManager documentFileManager = DocumentFileManager.getInstance();
            Context context = this.mContext;
            Intrinsics.checkNotNull(context);
            String str = this.mFilePath;
            Intrinsics.checkNotNull(str);
            SpenWNote spenWNoteOpen = documentFileManager.open(context, str, this.mPageLoadWidth, SpenOpenModeManager.INSTANCE.getInstance().use(4000, this.mFilePath), true, false, false);
            this.mWNote = spenWNoteOpen;
            this.mCloseDoc = true;
            Intrinsics.checkNotNull(spenWNoteOpen);
            init(spenWNoteOpen);
            Logger.m10999d(TAG, "init# Initialized, page count is " + this.pageCount);
        } catch (Exception e) {
            Logger.m11001e(TAG, "init# Failed to open a SpenWNote " + e.getMessage(), e);
        }
    }

    private final void initListPage() {
        ArrayList<SpenWPage.PDFData> pdfData;
        int iMin = (int) Math.min(this.pageCount, 2.0d);
        SpenWNote spenWNote = this.mWNote;
        SpenObjectTextBox bodyText = spenWNote != null ? spenWNote.getBodyText() : null;
        int textSectionStart = 0;
        int textSectionLength = 0;
        for (int i = 0; i < iMin; i++) {
            SpenWNote spenWNote2 = this.mWNote;
            SpenWPage page = spenWNote2 != null ? spenWNote2.getPage(i) : null;
            Integer numValueOf = page != null ? Integer.valueOf(page.getObjectCount(false)) : null;
            Intrinsics.checkNotNull(numValueOf);
            if (numValueOf.intValue() > 0 || !(page == null || (pdfData = page.getPdfData()) == null || pdfData.isEmpty())) {
                this.isTextOnlyNote = false;
                return;
            }
            if (page == null || page.getTemplateType() != 0) {
                this.isTextOnlyNote = false;
                return;
            }
            if (bodyText != null) {
                textSectionStart = bodyText.getTextSectionStart(i);
            }
            if (bodyText != null) {
                textSectionLength = bodyText.getTextSectionLength(i) + textSectionStart;
            }
            ArrayList<SpenObjectSpan> arrayListFindObjectSpan = bodyText != null ? bodyText.findObjectSpan(textSectionStart, textSectionLength) : null;
            if (arrayListFindObjectSpan != null && !arrayListFindObjectSpan.isEmpty()) {
                this.isTextOnlyNote = false;
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initSinglePageCaptureRect(int defaultPageHeight) {
        float f;
        float f4;
        int lineEndIndex;
        this.mPageRectList = new ArrayList();
        SpenWNote spenWNote = this.mWNote;
        SpenWPage page = spenWNote != null ? spenWNote.getPage(0) : null;
        if (page == null || !page.hasPDF()) {
            f = 0.0f;
            f4 = 0.0f;
        } else {
            ArrayList<SpenWPage.PDFData> pdfData = page.getPdfData();
            Intrinsics.checkNotNull(pdfData);
            for (SpenWPage.PDFData pDFData : pdfData) {
                List<RectF> list = this.mPageRectList;
                Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<android.graphics.RectF>");
                ((ArrayList) list).add(new RectF(pDFData.rect));
            }
            f4 = pdfData.get(0).rect.top;
            f = pdfData.get(pdfData.size() - 1).rect.bottom;
        }
        RectF drawnRectOfAllObject = page != null ? page.getDrawnRectOfAllObject() : null;
        SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(this.mContext);
        spenBodyTextContext.setDocument(this.mWNote);
        spenBodyTextContext.measureText();
        RectF measuredFitRect = spenBodyTextContext.getMeasuredFitRect(0);
        int i = defaultPageHeight * 2;
        if (f4 < 0.0f || f4 > i || f <= 0.0f) {
            Float fValueOf = drawnRectOfAllObject != null ? Float.valueOf(drawnRectOfAllObject.height()) : null;
            Intrinsics.checkNotNull(fValueOf);
            if (fValueOf.floatValue() > 0.0f) {
                Float fValueOf2 = drawnRectOfAllObject != null ? Float.valueOf(drawnRectOfAllObject.top) : null;
                Intrinsics.checkNotNull(fValueOf2);
                if (fValueOf2.floatValue() > i) {
                }
            } else if (measuredFitRect.height() > 0.0f && measuredFitRect.top >= i) {
                this.isTextOnlyNote = false;
            }
        }
        if (this.isTextOnlyNote) {
            int lineCount = spenBodyTextContext.getLineCount();
            int i2 = lineCount - 1;
            float f5 = i;
            if (spenBodyTextContext.getLinePosition(i2).bottom > f5) {
                int i4 = 0;
                while (true) {
                    if (i4 >= lineCount) {
                        lineEndIndex = 0;
                        break;
                    } else {
                        if (spenBodyTextContext.getLinePosition(i4).bottom > f5) {
                            lineEndIndex = spenBodyTextContext.getLineEndIndex(i4);
                            break;
                        }
                        i4++;
                    }
                }
            } else {
                lineEndIndex = spenBodyTextContext.getLineEndIndex(i2);
            }
            SpenWNote spenWNote2 = this.mWNote;
            Intrinsics.checkNotNull(spenWNote2);
            ArrayList<SpenObjectSpan> arrayListFindObjectSpan = spenWNote2.getBodyText().findObjectSpan(0, lineEndIndex);
            if (arrayListFindObjectSpan != null && !arrayListFindObjectSpan.isEmpty()) {
                this.isTextOnlyNote = false;
            }
        }
        spenBodyTextContext.close();
        Intrinsics.checkNotNull(drawnRectOfAllObject != null ? Float.valueOf(drawnRectOfAllObject.bottom) : null);
        float fMax = (float) Math.max(r1.floatValue(), measuredFitRect.bottom);
        float fMax2 = (float) ((page == null || page.getTemplateType() == 0) ? Math.max(10.0d, fMax) : Math.max(defaultPageHeight, fMax));
        if (f < fMax2) {
            float f6 = fMax2 - f;
            float f7 = defaultPageHeight;
            int i5 = f6 > f7 ? (int) (f6 / f7) : 0;
            List<RectF> list2 = this.mPageRectList;
            Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type java.util.ArrayList<android.graphics.RectF>");
            int size = ((ArrayList) list2).size();
            int i6 = size + i5;
            while (size < i6) {
                if (size == 0) {
                    List<RectF> list3 = this.mPageRectList;
                    Intrinsics.checkNotNull(list3, "null cannot be cast to non-null type java.util.ArrayList<android.graphics.RectF>");
                    Intrinsics.checkNotNull(this.mWNote);
                    ((ArrayList) list3).add(new RectF(0.0f, 0.0f, r10.getWidth(), f7));
                } else {
                    List<RectF> list4 = this.mPageRectList;
                    Intrinsics.checkNotNull(list4, "null cannot be cast to non-null type java.util.ArrayList<android.graphics.RectF>");
                    Object obj = ((ArrayList) list4).get(size - 1);
                    Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                    RectF rectF = (RectF) obj;
                    List<RectF> list5 = this.mPageRectList;
                    Intrinsics.checkNotNull(list5, "null cannot be cast to non-null type java.util.ArrayList<android.graphics.RectF>");
                    float f8 = rectF.bottom;
                    ((ArrayList) list5).add(new RectF(0.0f, f8, rectF.right, f8 + f7));
                }
                size++;
            }
            List<RectF> list6 = this.mPageRectList;
            Intrinsics.checkNotNull(list6, "null cannot be cast to non-null type java.util.ArrayList<android.graphics.RectF>");
            if (((ArrayList) list6).isEmpty()) {
                Intrinsics.checkNotNull(this.mWNote);
                RectF rectF2 = new RectF(0.0f, 0.0f, r1.getWidth(), f6);
                if (((int) rectF2.height()) < 1) {
                    rectF2.bottom += 1.0f;
                }
                List<RectF> list7 = this.mPageRectList;
                Intrinsics.checkNotNull(list7, "null cannot be cast to non-null type java.util.ArrayList<android.graphics.RectF>");
                ((ArrayList) list7).add(rectF2);
                return;
            }
            List<RectF> list8 = this.mPageRectList;
            Intrinsics.checkNotNull(list8, "null cannot be cast to non-null type java.util.ArrayList<android.graphics.RectF>");
            List<RectF> list9 = this.mPageRectList;
            Intrinsics.checkNotNull(list9, "null cannot be cast to non-null type java.util.ArrayList<android.graphics.RectF>");
            Object obj2 = ((ArrayList) list8).get(((ArrayList) list9).size() - 1);
            Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
            RectF rectF3 = (RectF) obj2;
            float f9 = rectF3.bottom;
            RectF rectF4 = new RectF(0.0f, f9, rectF3.right, (f6 - (i5 * defaultPageHeight)) + f9);
            if (((int) rectF4.height()) < 1) {
                rectF3.bottom += 1.0f;
                return;
            }
            List<RectF> list10 = this.mPageRectList;
            Intrinsics.checkNotNull(list10, "null cannot be cast to non-null type java.util.ArrayList<android.graphics.RectF>");
            ((ArrayList) list10).add(rectF4);
        }
    }

    private final boolean isContentExistPage(SpenWPage page, SpenObjectTextBox bodyText, int pageIndex) {
        int textSectionStart = bodyText.getTextSectionStart(pageIndex);
        int textSectionLength = bodyText.getTextSectionLength(pageIndex);
        if (page.getObjectCount(false) > 0 || page.hasPDF()) {
            return true;
        }
        return textSectionStart >= 0 && textSectionLength > 0;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void setContents(ThemeInfo themeInfo, int pageIndex, SpenWPage page, SpenObjectTextBox bodyText) {
        if (themeInfo == null) {
            AbstractC0000a.m3D(pageIndex, "setContents# theme is null, ", TAG);
        } else {
            Logger.m10999d(TAG, "setContents# " + themeInfo + SQLKeyword.COMMA + pageIndex);
        }
        NoteCaptureControl noteCaptureControl = this.mCaptureEngine;
        if (noteCaptureControl != null) {
            noteCaptureControl.setContents(page, bodyText, pageIndex);
        }
        NoteCaptureControl noteCaptureControl2 = this.mCaptureEngine;
        if (noteCaptureControl2 != null) {
            noteCaptureControl2.setBackgroundColorEnabled(false);
        }
        if (themeInfo != null) {
            NoteCaptureControl noteCaptureControl3 = this.mCaptureEngine;
            if (noteCaptureControl3 != null) {
                noteCaptureControl3.setColorTheme(themeInfo.isDarkMode() ? 1 : 0);
                return;
            }
            return;
        }
        NoteCaptureControl noteCaptureControl4 = this.mCaptureEngine;
        if (noteCaptureControl4 != null) {
            noteCaptureControl4.setColorTheme(0);
        }
    }

    @Nullable
    public final Bitmap captureListPage(int pageIndex, int targetViewWidth, @Nullable ThemeInfo themeInfo) {
        Bitmap bitmapCapturePage;
        Logger.startTime(String.valueOf(hashCode()));
        float f = targetViewWidth / this.mPageLoadWidth;
        Logger.m10999d(TAG, "captureListPage# pageIndex : " + pageIndex + " , ratio : " + f);
        SpenWNote spenWNote = this.mWNote;
        Intrinsics.checkNotNull(spenWNote);
        SpenWPage page = spenWNote.getPage(pageIndex);
        SpenWNote spenWNote2 = this.mWNote;
        Intrinsics.checkNotNull(spenWNote2);
        SpenObjectTextBox bodyText = spenWNote2.getBodyText();
        int i = this.pageCount;
        boolean zIsContentExistPage = false;
        for (int i2 = pageIndex == 0 ? 1 : 2; i2 < i; i2++) {
            SpenWNote spenWNote3 = this.mWNote;
            Intrinsics.checkNotNull(spenWNote3);
            zIsContentExistPage = isContentExistPage(spenWNote3.getPage(i2), bodyText, i2);
            if (zIsContentExistPage) {
                break;
            }
        }
        boolean zIsContentExistPage2 = isContentExistPage(page, bodyText, pageIndex);
        boolean z = page.getTemplateType() != 0;
        if (((pageIndex == 0 && !zIsContentExistPage2 && z) ? true : zIsContentExistPage2) || zIsContentExistPage) {
            setContents(themeInfo, pageIndex, page, bodyText);
            if (pageIndex != 0 || zIsContentExistPage || z || page.hasPDF()) {
                Logger.m10999d(TAG, "captureListPage# page.");
                NoteCaptureControl noteCaptureControl = this.mCaptureEngine;
                Intrinsics.checkNotNull(noteCaptureControl);
                bitmapCapturePage = noteCaptureControl.capturePage(f);
            } else {
                RectF drawnRectOfAllObject = page.getDrawnRectOfAllObject();
                SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(this.mContext);
                spenBodyTextContext.setDocument(this.mWNote);
                spenBodyTextContext.measureText();
                RectF rectF = new RectF(0.0f, 0.0f, page.getWidth(), (float) Math.min(((float) Math.max(drawnRectOfAllObject.bottom, spenBodyTextContext.getMeasuredFitRect(pageIndex).bottom)) + 10, page.getHeight()));
                spenBodyTextContext.close();
                Logger.m10999d(TAG, "captureListPage# rect: " + rectF);
                NoteCaptureControl noteCaptureControl2 = this.mCaptureEngine;
                Intrinsics.checkNotNull(noteCaptureControl2);
                bitmapCapturePage = noteCaptureControl2.captureRect(rectF);
            }
            if (bitmapCapturePage == null) {
                Logger.m11000e(TAG, "captureListPage# result of capture is null");
            }
        } else {
            Logger.m11000e(TAG, "captureListPage# It's not initialized or page count is 0");
            bitmapCapturePage = null;
        }
        Logger.endTime(String.valueOf(hashCode()), TAG, "captureListPage# " + pageIndex);
        return bitmapCapturePage;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f5  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Bitmap> captureSinglePage(int pageCount, @Nullable ThemeInfo themeInfo) {
        Bitmap bitmapCaptureRect;
        List<RectF> list = this.mPageRectList;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            if (!list.isEmpty()) {
                Intrinsics.checkNotNull(this.mPageRectList);
                int iMin = (int) Math.min(r0.size(), 2.0d);
                Logger.startTime(String.valueOf(hashCode()), TAG, "captureSinglePage# start" + pageCount);
                List<RectF> list2 = this.mPageRectList;
                Intrinsics.checkNotNull(list2);
                int i = iMin - 1;
                RectF rectF = list2.get(i);
                RectF rectF2 = new RectF(0.0f, 0.0f, rectF.right, rectF.bottom);
                int iWidth = (int) rectF2.width();
                int height = DocumentPageRatio.PAGE_RATIO.getHeight(iWidth) * 2;
                Context context = this.mContext;
                Intrinsics.checkNotNull(context);
                double d = context.getResources().getDisplayMetrics().widthPixels;
                Intrinsics.checkNotNull(this.mContext);
                int iMin2 = (int) Math.min(d, r10.getResources().getDisplayMetrics().heightPixels);
                List<RectF> list3 = this.mPageRectList;
                Intrinsics.checkNotNull(list3);
                if (pageCount > list3.size() && iMin2 > iWidth) {
                    float f = height;
                    if (f > rectF2.bottom) {
                        rectF2.bottom = f;
                        List<RectF> list4 = this.mPageRectList;
                        Intrinsics.checkNotNull(list4);
                        list4.get(i).bottom = f;
                    }
                }
                Logger.m10999d(TAG, "captureSinglePage# " + rectF2);
                if (!rectF2.isEmpty() && rectF2.height() > 0.0f) {
                    SpenWNote spenWNote = this.mWNote;
                    Intrinsics.checkNotNull(spenWNote);
                    SpenWPage page = spenWNote.getPage(0);
                    SpenWNote spenWNote2 = this.mWNote;
                    Intrinsics.checkNotNull(spenWNote2);
                    setContents(themeInfo, 0, page, spenWNote2.getBodyText());
                    NoteCaptureControl noteCaptureControl = this.mCaptureEngine;
                    bitmapCaptureRect = noteCaptureControl != null ? noteCaptureControl.captureRect(rectF2) : null;
                    if (bitmapCaptureRect != null) {
                        Logger.m10999d(TAG, "captureSinglePage# bitmap is null");
                        return null;
                    }
                    ArrayList arrayList = new ArrayList(iMin);
                    if (iMin > 1) {
                        int i2 = 0;
                        for (int i4 = 0; i4 < iMin; i4++) {
                            List<RectF> list5 = this.mPageRectList;
                            Intrinsics.checkNotNull(list5);
                            RectF rectF3 = list5.get(i4);
                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCaptureRect, 0, i2, (int) rectF3.width(), (int) rectF3.height());
                            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                            arrayList.add(bitmapCreateBitmap);
                            i2 = (int) rectF3.bottom;
                        }
                        bitmapCaptureRect.recycle();
                    } else {
                        arrayList.add(bitmapCaptureRect);
                    }
                    Logger.endTime(String.valueOf(hashCode()), TAG, "captureSinglePage# end");
                    return arrayList;
                }
                Logger.m11000e(TAG, "captureSinglePage# It's not initialized or page count is 0");
                if (bitmapCaptureRect != null) {
                }
            }
        }
        Logger.m11000e(TAG, "captureSinglePage empty pageRect. " + pageCount);
        return new ArrayList(1);
    }

    @Nullable
    public final SpenWNote getNote() {
        SpenWNote spenWNote = this.mWNote;
        if (spenWNote == null || spenWNote == null || spenWNote.isClosed()) {
            return null;
        }
        return this.mWNote;
    }

    public final int getPageColor() {
        return this.pageColor;
    }

    public final int getPageCount() {
        return this.pageCount;
    }

    /* JADX INFO: renamed from: isBackgroundImage, reason: from getter */
    public final boolean getIsBackgroundImage() {
        return this.isBackgroundImage;
    }

    public final boolean isListPageMode() {
        return this.mPageMode == SpenWNote.PageMode.LIST;
    }

    /* JADX INFO: renamed from: isTextOnlyNote, reason: from getter */
    public final boolean getIsTextOnlyNote() {
        return this.isTextOnlyNote;
    }

    public final void release() {
        this.mContext = null;
        try {
            NoteCaptureControl noteCaptureControl = this.mCaptureEngine;
            if (noteCaptureControl != null) {
                noteCaptureControl.close();
            }
        } catch (Exception e) {
            Logger.m11001e(TAG, e.getMessage(), e);
        }
        try {
            try {
                if (this.mCloseDoc) {
                    DocumentFileManager documentFileManager = DocumentFileManager.getInstance();
                    String str = this.mFilePath;
                    Intrinsics.checkNotNull(str);
                    documentFileManager.close(str, this.mWNote, true);
                }
                this.mWNote = null;
                Logger.m10999d(TAG, "release");
                if (TextUtils.isEmpty(this.mFilePath)) {
                    return;
                }
            } catch (Exception e2) {
                Logger.m11001e(TAG, e2.getMessage(), e2);
                if (TextUtils.isEmpty(this.mFilePath)) {
                    return;
                }
            }
            SpenOpenModeManager.INSTANCE.getInstance().disuse(this.mFilePath);
        } catch (Throwable th) {
            if (!TextUtils.isEmpty(this.mFilePath)) {
                SpenOpenModeManager.INSTANCE.getInstance().disuse(this.mFilePath);
            }
            throw th;
        }
    }

    private final void init(SpenWNote note) {
        this.mCaptureEngine = new NoteCaptureControl(this.mContext);
        if (note.getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW && note.getPageDefaultHeight() <= 0) {
            note.setPageDefaultHeight((int) (note.getPageDefaultWidth() / 1.4142857f));
            AbstractC0000a.m3D(note.getPageDefaultHeight(), "Note orientation ", TAG);
        }
        NoteCaptureControl noteCaptureControl = this.mCaptureEngine;
        if (noteCaptureControl != null) {
            noteCaptureControl.setWNote(note);
        }
        this.pageCount = (int) Math.max(1.0d, note.getPageCount() - 1);
        this.mPageMode = note.getPageMode();
        this.pageColor = note.getPage(0).getBackgroundColor();
        this.isTextOnlyNote = true;
        this.isBackgroundImage = BackgroundColorUtil.hasBackgroundImage(note.getPageList());
        if (this.mPageMode == SpenWNote.PageMode.SINGLE) {
            initSinglePageCaptureRect(this.mPageLoadHeight);
            List<RectF> list = this.mPageRectList;
            Integer numValueOf = list != null ? Integer.valueOf(list.size()) : null;
            Intrinsics.checkNotNull(numValueOf);
            this.pageCount = numValueOf.intValue();
        } else {
            initListPage();
        }
        AbstractC0000a.m3D(note.getPageDefaultHeight(), "Note pageDefaultHeight: ", TAG);
    }

    public CaptureManager(@NotNull Context context, @NotNull String filePath) {
        Resources resources;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.mContext = context;
        this.mFilePath = filePath;
        if (((context == null || (resources = context.getResources()) == null) ? null : resources.getDisplayMetrics()) != null) {
            this.mPageLoadWidth = (int) Math.min(r3.widthPixels, r3.heightPixels);
        }
        this.mPageLoadHeight = DocumentPageRatio.PAGE_RATIO.getHeight(this.mPageLoadWidth);
        init();
    }
}
