package com.samsung.android.sdk.composer.pdf;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfListener;", "", "<init>", "()V", "onProgressChanged", "", "progress", "", "onCompleted", "onMaxSelectionTextLengthReached", "onLoadPdfPage", "pdfPageIndex", "onUnLoadPdfPage", "onCursorChanged", "start", "Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfCursorPosition;", "end", "onSelectionAreaLongPressed", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class SpenNotePdfListener {
    public void onCompleted() {
    }

    public void onCursorChanged(@NotNull SpenNotePdfCursorPosition start, @NotNull SpenNotePdfCursorPosition end) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
    }

    public void onLoadPdfPage(int pdfPageIndex) {
    }

    public void onMaxSelectionTextLengthReached() {
    }

    public void onProgressChanged(int progress) {
    }

    public void onSelectionAreaLongPressed() {
    }

    public void onUnLoadPdfPage(int pdfPageIndex) {
    }
}
