package com.samsung.android.sdk.pen.engine.writingview.document;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/writingview/document/SpenWritingWNoteDocument;", "Lcom/samsung/android/sdk/pen/engine/writingview/document/SpenWritingDocument;", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "<init>", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;)V", "mHandle", "", "mWNote", "close", "", "handle", "getHandle", "()J", "isValid", "", "()Z", "width", "", "getWidth", "()I", "height", "getHeight", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenWritingWNoteDocument implements SpenWritingDocument {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private long mHandle;

    @Nullable
    private final SpenWNote mWNote;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0083 J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0083 ¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/writingview/document/SpenWritingWNoteDocument$Companion;", "", "<init>", "()V", "Native_init", "", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "Native_finalize", "", "handle", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long handle) {
            SpenWritingWNoteDocument.Native_finalize(handle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(SpenWNote wNote) {
            return SpenWritingWNoteDocument.Native_init(wNote);
        }

        private Companion() {
        }
    }

    public SpenWritingWNoteDocument(@Nullable SpenWNote spenWNote) {
        this.mHandle = INSTANCE.Native_init(spenWNote);
        this.mWNote = spenWNote;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(SpenWNote spenWNote);

    @Override // com.samsung.android.sdk.pen.engine.writingview.document.SpenWritingDocument
    public void close() {
        long j = this.mHandle;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
        }
        this.mHandle = 0L;
    }

    @Override // com.samsung.android.sdk.pen.engine.writingview.document.SpenWritingDocument
    /* JADX INFO: renamed from: getHandle, reason: from getter */
    public long getMHandle() {
        return this.mHandle;
    }

    @Override // com.samsung.android.sdk.pen.engine.writingview.document.SpenWritingDocument
    public int getHeight() {
        SpenWNote spenWNote = this.mWNote;
        if (spenWNote != null) {
            return spenWNote.getHeight();
        }
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.engine.writingview.document.SpenWritingDocument
    public int getWidth() {
        SpenWNote spenWNote = this.mWNote;
        if (spenWNote != null) {
            return spenWNote.getWidth();
        }
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.engine.writingview.document.SpenWritingDocument
    public boolean isValid() {
        return true;
    }
}
