package com.samsung.android.sdk.composer.document.capture;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.Log;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.engine.resource.SpenResources;
import com.samsung.android.sdk.pen.text.SpenFontManager;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.worddoc.SpenCustomObject;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 92\u00020\u0001:\u00019B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0016\u001a\u00020\u0017J\"\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\rJ\u0010\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"J\u0018\u0010#\u001a\u0004\u0018\u00010 2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u0004\u0018\u00010 2\u0006\u0010%\u001a\u00020&J\u0018\u0010\u001f\u001a\u0004\u0018\u00010(2\u0006\u0010!\u001a\u00020\"2\u0006\u0010)\u001a\u00020(J\u0010\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010%\u001a\u00020&J\u000e\u0010*\u001a\u00020+2\u0006\u0010)\u001a\u00020(J\u000e\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\rJ\u000e\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020+J \u00100\u001a\u0004\u0018\u00010 2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`4J\u0010\u00105\u001a\u0004\u0018\u00010 2\u0006\u00106\u001a\u000207J\u0010\u00108\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/capture/SpenNoteCapturePage;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mNativeCapture", "", "mDisplay", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "mConfiguration", "Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "mBitmapWidth", "", "mBitmapHeight", "mWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "mWNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "mBodyText", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "mPageIndex", "close", "", "setContents", "wpage", ExternalDataConstants.Column.BODY_TEXT, "pageIndex", "setWNote", "wNote", "createBitmap", "captureRect", "Landroid/graphics/Bitmap;", "rect", "Landroid/graphics/RectF;", "captureHandwritingRect", "handwritingRect", "ratio", "", "captureHandwritingPage", "", UriFileUtils.URI_COLUMN_EVERNOTE_FILENAME, "capturePage", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setBackgroundColorEnabled", "enabled", "captureObjects", "objectList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "captureStickyNoteObject", "customObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenCustomObject;", "findFirstVisibleContentTop", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenNoteCapturePage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenNoteCapturePage.kt\ncom/samsung/android/sdk/composer/document/capture/SpenNoteCapturePage\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,419:1\n1#2:420\n*E\n"})
public final class SpenNoteCapturePage {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenNoteCapturePage";

    @Nullable
    private Context context;
    private int mBitmapHeight;
    private int mBitmapWidth;

    @Nullable
    private SpenObjectTextBox mBodyText;

    @NotNull
    private SpenConfiguration mConfiguration;

    @NotNull
    private SpenDisplay mDisplay;
    private long mNativeCapture;
    private int mPageIndex;

    @Nullable
    private SpenWNote mWNote;

    @Nullable
    private SpenWPage mWPage;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0083 J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0083 J-\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0083 J\u0019\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0083 J\u001b\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0083 J\u0019\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0005H\u0083 J#\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0083 J#\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0083 J#\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u0005H\u0083 J\u0019\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0014H\u0083 J\u0019\u0010#\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u000eH\u0083 J;\u0010%\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2\u0006\u0010*\u001a\u00020\u001eH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/capture/SpenNoteCapturePage$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "display", "configuration", "Native_finalize", "", "nativeCapture", "Native_setPageContents", "", "wpage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", ExternalDataConstants.Column.BODY_TEXT, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "pageIndex", "", "Native_setWNote", "nativeWNote", "Native_capturePage", "bitmap", "Landroid/graphics/Bitmap;", "Native_capturePageFile", "fileName", "Native_captureRect", "rect", "Landroid/graphics/RectF;", "Native_captureHandwritingRect", "Native_captureRectFile", "Native_setColorTheme", BaseWidgetConstant.WIDGET_THEME, "Native_setBackgroundColorEnabled", "enabled", "Native_captureObjects", "objectList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "rectF", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_captureHandwritingRect(long nativeCapture, Bitmap bitmap, RectF rect) {
            return SpenNoteCapturePage.Native_captureHandwritingRect(nativeCapture, bitmap, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_captureObjects(long nativeCapture, Bitmap bitmap, ArrayList<SpenObjectBase> objectList, RectF rectF) {
            return SpenNoteCapturePage.Native_captureObjects(nativeCapture, bitmap, objectList, rectF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_capturePage(long nativeCapture, Bitmap bitmap) {
            return SpenNoteCapturePage.Native_capturePage(nativeCapture, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_capturePageFile(long nativeCapture, String fileName) {
            return SpenNoteCapturePage.Native_capturePageFile(nativeCapture, fileName);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_captureRect(long nativeCapture, Bitmap bitmap, RectF rect) {
            return SpenNoteCapturePage.Native_captureRect(nativeCapture, bitmap, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String Native_captureRectFile(long nativeCapture, RectF rect, String fileName) {
            return SpenNoteCapturePage.Native_captureRectFile(nativeCapture, rect, fileName);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeCapture) {
            SpenNoteCapturePage.Native_finalize(nativeCapture);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(long display, long configuration) {
            return SpenNoteCapturePage.Native_init(display, configuration);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setBackgroundColorEnabled(long nativeCapture, boolean enabled) {
            SpenNoteCapturePage.Native_setBackgroundColorEnabled(nativeCapture, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setColorTheme(long nativeCapture, int theme) {
            SpenNoteCapturePage.Native_setColorTheme(nativeCapture, theme);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setPageContents(long nativeCapture, SpenWPage wpage, SpenObjectTextBox bodyText, int pageIndex) {
            return SpenNoteCapturePage.Native_setPageContents(nativeCapture, wpage, bodyText, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setWNote(long nativeCapture, long nativeWNote) {
            return SpenNoteCapturePage.Native_setWNote(nativeCapture, nativeWNote);
        }

        private Companion() {
        }
    }

    public SpenNoteCapturePage(@Nullable Context context) {
        this.context = context;
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        this.mDisplay = new SpenDisplay(this.context);
        SpenConfiguration spenConfiguration = new SpenConfiguration(this.context);
        this.mConfiguration = spenConfiguration;
        this.mNativeCapture = INSTANCE.Native_init(this.mDisplay.handle, spenConfiguration.getNativeHandle());
        SpenResources.Companion companion = SpenResources.INSTANCE;
        Context context2 = this.context;
        companion.setResources(context2 != null ? context2.getResources() : null);
        SpenFontManager.setSystemFontPath(this.context);
        SpenFontManager.setLocaleList();
        Log.i(TAG, "SpenNoteCapturePage : " + this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_captureHandwritingRect(long j, Bitmap bitmap, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_captureObjects(long j, Bitmap bitmap, ArrayList<SpenObjectBase> arrayList, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_capturePage(long j, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_capturePageFile(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_captureRect(long j, Bitmap bitmap, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String Native_captureRectFile(long j, RectF rectF, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setBackgroundColorEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setColorTheme(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setPageContents(long j, SpenWPage spenWPage, SpenObjectTextBox spenObjectTextBox, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setWNote(long j, long j2);

    private final void createBitmap(SpenWPage wpage) {
        if (this.mNativeCapture == 0 || wpage == null || !wpage.isValid()) {
            return;
        }
        this.mBitmapWidth = wpage.getWidth();
        int height = wpage.getHeight();
        this.mBitmapHeight = height;
        if (this.mBitmapWidth == 0) {
            SpenError.ThrowUncheckedException(6, "The width of pageDoc is 0");
        } else if (height == 0) {
            SpenError.ThrowUncheckedException(6, "The height of pageDoc is 0");
        }
    }

    private final float findFirstVisibleContentTop(SpenWNote wNote) {
        RectF drawnRectOfAllObject = wNote.getPage(0).getDrawnRectOfAllObject();
        float f = !drawnRectOfAllObject.isEmpty() ? drawnRectOfAllObject.top : -1.0f;
        SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(this.context);
        spenBodyTextContext.setDocument(wNote);
        spenBodyTextContext.measureTextToPage(0);
        RectF measuredFitRect = spenBodyTextContext.getMeasuredFitRect(0);
        if (!measuredFitRect.isEmpty()) {
            float fMin = measuredFitRect.top;
            if (f != -1.0f) {
                fMin = Math.min(f, fMin);
            }
            f = fMin;
        }
        if (f == -1.0f) {
            return 0.0f;
        }
        return f;
    }

    @Nullable
    public final Bitmap captureHandwritingPage(float ratio) {
        SpenWPage spenWPage;
        SpenWNote spenWNote;
        if (this.mNativeCapture == 0 || ratio > 5.0f || (spenWPage = this.mWPage) == null || (spenWNote = this.mWNote) == null) {
            return null;
        }
        if (spenWNote.getPageMode() != SpenWNote.PageMode.SINGLE) {
            return captureHandwritingRect(new RectF(0.0f, 0.0f, spenWPage.getWidth(), spenWPage.getHeight()), ratio);
        }
        Log.e(TAG, "try to captureHandwritingPage on single mode uses captureHandwritingRect");
        return null;
    }

    @Nullable
    public final Bitmap captureHandwritingRect(@NotNull RectF handwritingRect, float ratio) {
        Intrinsics.checkNotNullParameter(handwritingRect, "handwritingRect");
        Log.i(TAG, "captureRect : " + handwritingRect);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (handwritingRect.width() * ratio), (int) (handwritingRect.height() * ratio), Bitmap.Config.ARGB_8888);
        if (INSTANCE.Native_captureHandwritingRect(this.mNativeCapture, bitmapCreateBitmap, handwritingRect)) {
            return bitmapCreateBitmap;
        }
        if (bitmapCreateBitmap == null) {
            return null;
        }
        bitmapCreateBitmap.recycle();
        return null;
    }

    @Nullable
    public final Bitmap captureObjects(@NotNull ArrayList<SpenObjectBase> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        if (this.mNativeCapture == 0) {
            return null;
        }
        RectF rectF = new RectF();
        Iterator<SpenObjectBase> it = objectList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenObjectBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            RectF drawnRect = next.getDrawnRect();
            Intrinsics.checkNotNull(drawnRect);
            rectF.union(drawnRect);
        }
        rectF.left = (int) Math.floor(rectF.left);
        rectF.top = (int) Math.floor(rectF.top);
        rectF.right = (int) Math.ceil(rectF.right);
        rectF.bottom = (int) Math.ceil(rectF.bottom);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) rectF.width(), (int) rectF.height(), Bitmap.Config.ARGB_8888);
        if (INSTANCE.Native_captureObjects(this.mNativeCapture, bitmapCreateBitmap, objectList, rectF)) {
            return bitmapCreateBitmap;
        }
        if (bitmapCreateBitmap != null) {
            bitmapCreateBitmap.recycle();
        }
        return null;
    }

    @Nullable
    public final Bitmap capturePage(float ratio) {
        SpenWNote spenWNote;
        if (this.mNativeCapture == 0 || ratio > 5.0f || (spenWNote = this.mWNote) == null) {
            return null;
        }
        if (spenWNote.getPageMode() == SpenWNote.PageMode.SINGLE) {
            Log.e(TAG, "try to capturePage on single mode uses captureRect");
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (this.mBitmapWidth * ratio), (int) (this.mBitmapHeight * ratio), Bitmap.Config.ARGB_8888);
        if (INSTANCE.Native_capturePage(this.mNativeCapture, bitmapCreateBitmap)) {
            return bitmapCreateBitmap;
        }
        if (bitmapCreateBitmap != null) {
            bitmapCreateBitmap.recycle();
        }
        return null;
    }

    @Nullable
    public final Bitmap captureRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Log.i(TAG, "captureRect : " + rect);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) rect.width(), (int) rect.height(), Bitmap.Config.ARGB_8888);
        if (INSTANCE.Native_captureRect(this.mNativeCapture, bitmapCreateBitmap, rect)) {
            return bitmapCreateBitmap;
        }
        if (bitmapCreateBitmap == null) {
            return null;
        }
        bitmapCreateBitmap.recycle();
        return null;
    }

    @Nullable
    public final Bitmap captureStickyNoteObject(@NotNull SpenCustomObject customObject) {
        Intrinsics.checkNotNullParameter(customObject, "customObject");
        if (this.mNativeCapture == 0) {
            return null;
        }
        if (customObject.getType() != 1) {
            Log.i(TAG, "captureStickyNoteObject - Not sticky note type");
            return null;
        }
        String attachedFile = customObject.getAttachedFile();
        if (attachedFile == null || !SpenWNoteFile.isValid(attachedFile)) {
            return null;
        }
        SpenWNote spenWNote = new SpenWNote(this.context, attachedFile, null);
        if (spenWNote.getPageCount() <= 0) {
            spenWNote.close(true);
            return null;
        }
        SpenWNote spenWNote2 = this.mWNote;
        SpenWPage spenWPage = this.mWPage;
        SpenObjectTextBox spenObjectTextBox = this.mBodyText;
        int i = this.mPageIndex;
        setWNote(spenWNote);
        setContents(spenWNote.getPage(0), spenWNote.getBodyText(), 0);
        float fMin = Math.min(r6.getWidth(), r6.getHeight());
        float fMin2 = Math.min(findFirstVisibleContentTop(spenWNote), r6.getHeight() - fMin);
        Bitmap bitmapCaptureRect = captureRect(new RectF(0.0f, fMin2, fMin, fMin2 + fMin));
        setWNote(spenWNote2);
        setContents(spenWPage, spenObjectTextBox, i);
        spenWNote.close(true);
        return bitmapCaptureRect;
    }

    public final void close() {
        long j = this.mNativeCapture;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_finalize(j);
        this.mNativeCapture = 0L;
        this.mConfiguration.close();
        this.mDisplay.close();
        Log.i(TAG, "SpenNoteCapturePage close: " + this);
    }

    public final void setBackgroundColorEnabled(boolean enabled) {
        long j = this.mNativeCapture;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setBackgroundColorEnabled(j, enabled);
    }

    public final void setColorTheme(int theme) {
        long j = this.mNativeCapture;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setColorTheme(j, theme);
    }

    public final void setContents(@Nullable SpenWPage wpage, @Nullable SpenObjectTextBox bodyText, int pageIndex) {
        if (this.mNativeCapture == 0) {
            return;
        }
        if (wpage != null && !wpage.isValid()) {
            Log.d(TAG, "WPage is closed");
            return;
        }
        createBitmap(wpage);
        this.mWPage = wpage;
        this.mBodyText = bodyText;
        this.mPageIndex = pageIndex;
        INSTANCE.Native_setPageContents(this.mNativeCapture, wpage, bodyText, pageIndex);
    }

    public final void setWNote(@Nullable SpenWNote wNote) {
        long j = this.mNativeCapture;
        if (j == 0) {
            return;
        }
        this.mWNote = wNote;
        INSTANCE.Native_setWNote(j, wNote != null ? wNote.getMHandle() : 0L);
    }

    @Nullable
    public final String captureRect(@NotNull RectF rect, @NotNull String filename) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(filename, "filename");
        long j = this.mNativeCapture;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_captureRectFile(j, rect, filename);
    }

    public final boolean capturePage(@NotNull String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        long j = this.mNativeCapture;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_capturePageFile(j, filename);
    }
}
