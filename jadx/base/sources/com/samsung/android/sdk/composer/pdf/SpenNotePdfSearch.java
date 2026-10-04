package com.samsung.android.sdk.composer.pdf;

import android.util.Log;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfSearch;", "", "<init>", "()V", "mNativeHandle", "", "text", "", "getText", "()Ljava/lang/String;", "close", "", "setDocument", "wnote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "getPageText", "page", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "getPdfPageTextLength", "", "pdfPageIndex", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenNotePdfSearch {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenNotePdfSearch";
    private long mNativeHandle = INSTANCE.Native_init();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0007H\u0083 J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0083 J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0083 J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0083 J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0083 J!\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfSearch$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "Native_finalize", "", "nativeHandle", "Native_setDocument", "", "nativeWNote", "Native_getText", "Native_getPageText", "page", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "Native_getPdfPageTextLength", "", "pdfPageIndex", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenNotePdfSearch.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String Native_getPageText(long nativeHandle, SpenWPage page) {
            return SpenNotePdfSearch.Native_getPageText(nativeHandle, page);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPdfPageTextLength(long nativeHandle, SpenWPage page, int pdfPageIndex) {
            return SpenNotePdfSearch.Native_getPdfPageTextLength(nativeHandle, page, pdfPageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String Native_getText(long nativeHandle) {
            return SpenNotePdfSearch.Native_getText(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init() {
            return SpenNotePdfSearch.Native_init();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setDocument(long nativeHandle, long nativeWNote) {
            return SpenNotePdfSearch.Native_setDocument(nativeHandle, nativeWNote);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String Native_getPageText(long j, SpenWPage spenWPage);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPdfPageTextLength(long j, SpenWPage spenWPage, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String Native_getText(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setDocument(long j, long j2);

    public final void close() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_finalize(j);
        this.mNativeHandle = 0L;
        Log.d(TAG, "SpenNotePdfSearch close: " + this);
    }

    @Nullable
    public final String getPageText(@NotNull SpenWPage page) {
        Intrinsics.checkNotNullParameter(page, "page");
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageText(j, page);
    }

    public final int getPdfPageTextLength(@NotNull SpenWPage page, int pdfPageIndex) {
        Intrinsics.checkNotNullParameter(page, "page");
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getPdfPageTextLength(j, page, pdfPageIndex);
    }

    @Nullable
    public final String getText() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getText(j);
    }

    public final void setDocument(@NotNull SpenWNote wnote) {
        Intrinsics.checkNotNullParameter(wnote, "wnote");
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setDocument(j, wnote.getMHandle());
    }
}
