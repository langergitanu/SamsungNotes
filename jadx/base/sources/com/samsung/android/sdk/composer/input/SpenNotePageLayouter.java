package com.samsung.android.sdk.composer.input;

import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/input/SpenNotePageLayouter;", "Lcom/samsung/android/sdk/composer/input/ISpenNotePageLayouter;", "<init>", "()V", "mNativeHandle", "", "setPageLayoutAll", "", "column", "", "row", "fitScreen", "", "vertical", "requestPageLayout", "setPageLayoutMarginBottom", "marginBottom", "", "setNativeHandle", "nativeHandle", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenNotePageLayouter implements ISpenNotePageLayouter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenNotePageLayouter";
    private long mNativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0083 J\u0011\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/input/SpenNotePageLayouter$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_setLayoutAll", "", "nativeHandle", "", "column", "", "row", "fitScreen", "", "vertical", "Native_requestLayout", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_requestLayout(long nativeHandle) {
            SpenNotePageLayouter.Native_requestLayout(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setLayoutAll(long nativeHandle, int column, int row, boolean fitScreen, boolean vertical) {
            SpenNotePageLayouter.Native_setLayoutAll(nativeHandle, column, row, fitScreen, vertical);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_requestLayout(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setLayoutAll(long j, int i, int i2, boolean z, boolean z2);

    @Override // com.samsung.android.sdk.composer.input.ISpenNotePageLayouter
    public void requestPageLayout() {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_requestLayout(j);
        }
    }

    @Override // com.samsung.android.sdk.composer.input.ISpenNotePageLayouter
    public void setNativeHandle(long nativeHandle) {
        this.mNativeHandle = nativeHandle;
    }

    @Override // com.samsung.android.sdk.composer.input.ISpenNotePageLayouter
    public void setPageLayoutAll(int column, int row, boolean fitScreen, boolean vertical) {
        long j = this.mNativeHandle;
        if (j != 0) {
            INSTANCE.Native_setLayoutAll(j, column, row, fitScreen, vertical);
        }
    }

    @Override // com.samsung.android.sdk.composer.input.ISpenNotePageLayouter
    @Deprecated(message = "")
    public void setPageLayoutMarginBottom(float marginBottom) {
    }
}
