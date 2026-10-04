package com.samsung.android.sdk.pen.engine.writingview.document;

import com.samsung.android.sdk.pen.document.SpenPageDoc;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/writingview/document/SpenWritingPageDocDocument;", "Lcom/samsung/android/sdk/pen/engine/writingview/document/SpenWritingDocument;", "mPageDoc", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "<init>", "(Lcom/samsung/android/sdk/pen/document/SpenPageDoc;)V", "value", "", "handle", "getHandle", "()J", "isValid", "", "()Z", "width", "", "getWidth", "()I", "height", "getHeight", "close", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenWritingPageDocDocument implements SpenWritingDocument {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private long handle;

    @Nullable
    private final SpenPageDoc mPageDoc;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0083 J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0083 ¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/writingview/document/SpenWritingPageDocDocument$Companion;", "", "<init>", "()V", "Native_init", "", "pageDoc", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "Native_finalize", "", "handle", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long handle) {
            SpenWritingPageDocDocument.Native_finalize(handle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(SpenPageDoc pageDoc) {
            return SpenWritingPageDocDocument.Native_init(pageDoc);
        }

        private Companion() {
        }
    }

    public SpenWritingPageDocDocument(@Nullable SpenPageDoc spenPageDoc) {
        this.mPageDoc = spenPageDoc;
        this.handle = INSTANCE.Native_init(spenPageDoc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(SpenPageDoc spenPageDoc);

    @Override // com.samsung.android.sdk.pen.engine.writingview.document.SpenWritingDocument
    public void close() {
        if (getHandle() != 0) {
            INSTANCE.Native_finalize(getHandle());
        }
        this.handle = 0L;
    }

    @Override // com.samsung.android.sdk.pen.engine.writingview.document.SpenWritingDocument
    public long getHandle() {
        return this.handle;
    }

    @Override // com.samsung.android.sdk.pen.engine.writingview.document.SpenWritingDocument
    public int getHeight() {
        SpenPageDoc spenPageDoc = this.mPageDoc;
        if (spenPageDoc != null) {
            return spenPageDoc.getHeight();
        }
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.engine.writingview.document.SpenWritingDocument
    public int getWidth() {
        SpenPageDoc spenPageDoc = this.mPageDoc;
        if (spenPageDoc != null) {
            return spenPageDoc.getWidth();
        }
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.engine.writingview.document.SpenWritingDocument
    public boolean isValid() {
        SpenPageDoc spenPageDoc = this.mPageDoc;
        if (spenPageDoc != null) {
            return spenPageDoc.isValid();
        }
        return false;
    }
}
