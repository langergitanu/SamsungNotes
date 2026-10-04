package com.samsung.android.sdk.pen.recoguifeature.spentotext;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0018H\u0016¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/SpenSTTManagerNoOp;", "Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/ISPenSTTManager;", "<init>", "()V", "setNativeHandle", "", "context", "Landroid/content/Context;", "handle", "", "close", "setListener", "l", "Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/SPenSTTListener;", "setTextListener", "Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/SPenSTTTextListener;", "updateRecognitionLanguage", "", "text", "", "setEnabled", "enable", "requestSPenToTextAction", "action", "", "setTextColor", "textColor", "bgColor", "setTargetMode", "mode", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSTTManagerNoOp implements ISPenSTTManager {
    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void close() {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void requestSPenToTextAction(int action) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void setEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void setListener(@Nullable SPenSTTListener l) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void setNativeHandle(@Nullable Context context, long handle) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void setTargetMode(int mode) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void setTextColor(int textColor, int bgColor) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public void setTextListener(@Nullable SPenSTTTextListener l) {
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager
    public boolean updateRecognitionLanguage(@Nullable CharSequence text) {
        return false;
    }
}
