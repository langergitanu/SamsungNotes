package com.samsung.android.sdk.composer.text;

import android.content.Context;
import android.graphics.RectF;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.engine.resource.SpenResources;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 12\u00020\u0001:\u00011B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0015J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015J\u000e\u0010#\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015J\u0010\u0010$\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010&J\u0010\u0010'\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010&J\u0006\u0010*\u001a\u00020\u001fJ\u0006\u0010+\u001a\u00020\rJ\u001e\u0010,\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0015J\u000e\u00100\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010(\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b)\u0010\u0018¨\u00062"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mNativeHandle", "", "mDisplay", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "mConfiguration", "Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "close", "", "setDocument", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "cancel", "measureText", "measureTextToPage", "pageIndex", "", "measuredHeight", "getMeasuredHeight", "()I", "getMeasuredFitRect", "Landroid/graphics/RectF;", "getLineCountFromTextBottom", "y", "", "toNext", "", "getLinePosition", "line", "getLineStartIndex", "getLineEndIndex", "getObjectRect", "obj", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "getObjectDrawnRect", "lineCount", "getLineCount", "lockBodyTextPage", "unlockBodyTextPage", "insertBodyTextTo", "insertObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "textSizeDelta", "insertEmptyBodyTextTo", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBodyTextContext {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenBodyTextContext";

    @NotNull
    private final SpenConfiguration mConfiguration;

    @NotNull
    private final SpenDisplay mDisplay;
    private long mNativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0083 J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0083 J\u001b\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0083 J\u0011\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0083 J\u0019\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0083 J\u0011\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0007H\u0083 J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0083 J!\u0010\u0017\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0083 J\u0019\u0010\u001c\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0013H\u0083 J\u0019\u0010\u001e\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0013H\u0083 J\u0019\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0013H\u0083 J\u0011\u0010 \u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0007H\u0083 J\u001b\u0010!\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#H\u0083 J\u001b\u0010$\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#H\u0083 J\u0011\u0010%\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0083 J\u0011\u0010&\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u0007H\u0083 J\u0011\u0010'\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0083 J)\u0010(\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0013H\u0083 J\u0019\u0010+\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "display", "configuration", "Native_finalize", "", "nativeHandle", "Native_setDocument", "wnote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "Native_measureText", "Native_measureTextToPage", "pageIndex", "", "Native_getMeasuredHeight", "Native_getMeasuredFitRect", "Landroid/graphics/RectF;", "Native_getLineCountFromTextBottom", "y", "", "toNext", "", "Native_getLinePosition", "line", "Native_getLineStartIndex", "Native_getLineEndIndex", "Native_getLineCount", "Native_getObjectRect", "obj", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Native_getObjectDrawnRect", "Native_cancel", "Native_lockBodyTextPage", "Native_unlockBodyTextPage", "Native_insertBodyTextTo", "insertObject", "textSizeDelta", "Native_insertEmptyBodyTextTo", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_cancel(long nativeHandle) {
            SpenBodyTextContext.Native_cancel(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenBodyTextContext.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getLineCount(long nativeHandle) {
            return SpenBodyTextContext.Native_getLineCount(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getLineCountFromTextBottom(long nativeHandle, float y2, boolean toNext) {
            return SpenBodyTextContext.Native_getLineCountFromTextBottom(nativeHandle, y2, toNext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getLineEndIndex(long nativeHandle, int line) {
            return SpenBodyTextContext.Native_getLineEndIndex(nativeHandle, line);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getLinePosition(long nativeHandle, int line) {
            return SpenBodyTextContext.Native_getLinePosition(nativeHandle, line);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getLineStartIndex(long nativeHandle, int line) {
            return SpenBodyTextContext.Native_getLineStartIndex(nativeHandle, line);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getMeasuredFitRect(long nativeHandle, int pageIndex) {
            return SpenBodyTextContext.Native_getMeasuredFitRect(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getMeasuredHeight(long nativeHandle) {
            return SpenBodyTextContext.Native_getMeasuredHeight(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getObjectDrawnRect(long nativeHandle, SpenObjectBase obj) {
            return SpenBodyTextContext.Native_getObjectDrawnRect(nativeHandle, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getObjectRect(long nativeHandle, SpenObjectBase obj) {
            return SpenBodyTextContext.Native_getObjectRect(nativeHandle, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(long display, long configuration) {
            return SpenBodyTextContext.Native_init(display, configuration);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_insertBodyTextTo(long nativeHandle, int pageIndex, SpenObjectBase insertObject, int textSizeDelta) {
            return SpenBodyTextContext.Native_insertBodyTextTo(nativeHandle, pageIndex, insertObject, textSizeDelta);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_insertEmptyBodyTextTo(long nativeHandle, int pageIndex) {
            return SpenBodyTextContext.Native_insertEmptyBodyTextTo(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_lockBodyTextPage(long nativeHandle) {
            return SpenBodyTextContext.Native_lockBodyTextPage(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_measureText(long nativeHandle) {
            SpenBodyTextContext.Native_measureText(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_measureTextToPage(long nativeHandle, int pageIndex) {
            SpenBodyTextContext.Native_measureTextToPage(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setDocument(long nativeHandle, SpenWNote wnote) {
            SpenBodyTextContext.Native_setDocument(nativeHandle, wnote);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_unlockBodyTextPage(long nativeHandle) {
            SpenBodyTextContext.Native_unlockBodyTextPage(nativeHandle);
        }

        private Companion() {
        }
    }

    public SpenBodyTextContext(@Nullable Context context) {
        SpenDisplay spenDisplay = new SpenDisplay(context);
        this.mDisplay = spenDisplay;
        SpenConfiguration spenConfiguration = new SpenConfiguration(context);
        this.mConfiguration = spenConfiguration;
        this.mNativeHandle = INSTANCE.Native_init(spenDisplay.handle, spenConfiguration.getNativeHandle());
        SpenResources.INSTANCE.setResources(context != null ? context.getResources() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_cancel(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getLineCount(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getLineCountFromTextBottom(long j, float f, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getLineEndIndex(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getLinePosition(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getLineStartIndex(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getMeasuredFitRect(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getMeasuredHeight(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getObjectDrawnRect(long j, SpenObjectBase spenObjectBase);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getObjectRect(long j, SpenObjectBase spenObjectBase);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_insertBodyTextTo(long j, int i, SpenObjectBase spenObjectBase, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_insertEmptyBodyTextTo(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_lockBodyTextPage(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_measureText(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_measureTextToPage(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setDocument(long j, SpenWNote spenWNote);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_unlockBodyTextPage(long j);

    public final void cancel() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_cancel(j);
    }

    public final void close() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
            this.mNativeHandle = 0L;
        }
        this.mConfiguration.close();
        this.mDisplay.close();
    }

    public final int getLineCount() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getLineCount(j);
    }

    public final int getLineCountFromTextBottom(float y2, boolean toNext) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getLineCountFromTextBottom(j, y2, toNext);
    }

    public final int getLineEndIndex(int line) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -1;
        }
        return INSTANCE.Native_getLineEndIndex(j, line);
    }

    @NotNull
    public final RectF getLinePosition(int line) {
        long j = this.mNativeHandle;
        return j == 0 ? new RectF() : INSTANCE.Native_getLinePosition(j, line);
    }

    public final int getLineStartIndex(int line) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -1;
        }
        return INSTANCE.Native_getLineStartIndex(j, line);
    }

    @NotNull
    public final RectF getMeasuredFitRect(int pageIndex) {
        long j = this.mNativeHandle;
        return j == 0 ? new RectF() : INSTANCE.Native_getMeasuredFitRect(j, pageIndex);
    }

    public final int getMeasuredHeight() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getMeasuredHeight(j);
    }

    @NotNull
    public final RectF getObjectDrawnRect(@Nullable SpenObjectBase obj) {
        long j = this.mNativeHandle;
        return j == 0 ? new RectF() : INSTANCE.Native_getObjectDrawnRect(j, obj);
    }

    @NotNull
    public final RectF getObjectRect(@Nullable SpenObjectBase obj) {
        long j = this.mNativeHandle;
        return j == 0 ? new RectF() : INSTANCE.Native_getObjectRect(j, obj);
    }

    public final boolean insertBodyTextTo(int pageIndex, @NotNull SpenObjectTextBox insertObject, int textSizeDelta) {
        Intrinsics.checkNotNullParameter(insertObject, "insertObject");
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_insertBodyTextTo(j, pageIndex, insertObject, textSizeDelta);
    }

    public final boolean insertEmptyBodyTextTo(int pageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_insertEmptyBodyTextTo(j, pageIndex);
    }

    public final boolean lockBodyTextPage() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_lockBodyTextPage(j);
    }

    public final void measureText() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_measureText(j);
    }

    public final void measureTextToPage(int pageIndex) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_measureTextToPage(j, pageIndex);
    }

    public final void setDocument(@Nullable SpenWNote note) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setDocument(j, note);
    }

    public final void unlockBodyTextPage() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_unlockBodyTextPage(j);
    }
}
