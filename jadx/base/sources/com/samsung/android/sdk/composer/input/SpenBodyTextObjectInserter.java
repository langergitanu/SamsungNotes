package com.samsung.android.sdk.composer.input;

import android.content.Context;
import android.graphics.RectF;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
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
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0011\u001a\u00020\rJ\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/sdk/composer/input/SpenBodyTextObjectInserter;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mNativeHandle", "", "mDisplay", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "mConfiguration", "Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "close", "", "setDocument", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "measure", "getObjectRect", "Landroid/graphics/RectF;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "cursorIndex", "", "fitWidth", "", "autoFitTable", "objectSpan", "Lcom/samsung/android/sdk/pen/document/textspan/SpenObjectSpan;", "columnPerPage", "onlyFirstColumn", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBodyTextObjectInserter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenBodyTextObjectInserter";

    @NotNull
    private final SpenConfiguration mConfiguration;

    @NotNull
    private final SpenDisplay mDisplay;
    private long mNativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0083 J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0083 J\u001b\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0083 J)\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0083 J)\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0017H\u0083 J\u0011\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/input/SpenBodyTextObjectInserter$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "display", "configuration", "Native_finalize", "", "nativeHandle", "Native_setDocument", "wnote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "Native_getObjectRect", "Landroid/graphics/RectF;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "cursorIndex", "", "fitWidth", "", "Native_autoFitTable", "objectSpan", "Lcom/samsung/android/sdk/pen/document/textspan/SpenObjectSpan;", "columnPerPage", "onlyFirstColumn", "Native_measure", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_autoFitTable(long nativeHandle, SpenObjectSpan objectSpan, int columnPerPage, boolean onlyFirstColumn) {
            return SpenBodyTextObjectInserter.Native_autoFitTable(nativeHandle, objectSpan, columnPerPage, onlyFirstColumn);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenBodyTextObjectInserter.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getObjectRect(long nativeHandle, SpenObjectBase objectBase, int cursorIndex, boolean fitWidth) {
            return SpenBodyTextObjectInserter.Native_getObjectRect(nativeHandle, objectBase, cursorIndex, fitWidth);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(long display, long configuration) {
            return SpenBodyTextObjectInserter.Native_init(display, configuration);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_measure(long nativeHandle) {
            SpenBodyTextObjectInserter.Native_measure(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setDocument(long nativeHandle, SpenWNote wnote) {
            SpenBodyTextObjectInserter.Native_setDocument(nativeHandle, wnote);
        }

        private Companion() {
        }
    }

    public SpenBodyTextObjectInserter(@Nullable Context context) {
        SpenDisplay spenDisplay = new SpenDisplay(context);
        this.mDisplay = spenDisplay;
        SpenConfiguration spenConfiguration = new SpenConfiguration(context);
        this.mConfiguration = spenConfiguration;
        this.mNativeHandle = INSTANCE.Native_init(spenDisplay.handle, spenConfiguration.getNativeHandle());
        SpenResources.INSTANCE.setResources(context != null ? context.getResources() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_autoFitTable(long j, SpenObjectSpan spenObjectSpan, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getObjectRect(long j, SpenObjectBase spenObjectBase, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_measure(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setDocument(long j, SpenWNote spenWNote);

    public final boolean autoFitTable(@NotNull SpenObjectSpan objectSpan, int columnPerPage, boolean onlyFirstColumn) {
        Intrinsics.checkNotNullParameter(objectSpan, "objectSpan");
        return INSTANCE.Native_autoFitTable(this.mNativeHandle, objectSpan, columnPerPage, onlyFirstColumn);
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

    @NotNull
    public final RectF getObjectRect(@NotNull SpenObjectBase objectBase, int cursorIndex, boolean fitWidth) {
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        return INSTANCE.Native_getObjectRect(this.mNativeHandle, objectBase, cursorIndex, fitWidth);
    }

    public final void measure() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_measure(j);
    }

    public final void setDocument(@Nullable SpenWNote note) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setDocument(j, note);
    }
}
