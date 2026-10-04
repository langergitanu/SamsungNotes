package com.samsung.android.sdk.pen.recoguifeature.spentotext;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000fH&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0016H&¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/ISPenSTTManager;", "", "setNativeHandle", "", "context", "Landroid/content/Context;", "handle", "", "close", "setListener", "l", "Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/SPenSTTListener;", "setTextListener", "Lcom/samsung/android/sdk/pen/recoguifeature/spentotext/SPenSTTTextListener;", "updateRecognitionLanguage", "", "text", "", "setEnabled", "enable", "requestSPenToTextAction", "action", "", "setTextColor", "textColor", "bgColor", "setTargetMode", "mode", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface ISPenSTTManager {
    void close();

    void requestSPenToTextAction(int action);

    void setEnabled(boolean enable);

    void setListener(@Nullable SPenSTTListener l);

    void setNativeHandle(@Nullable Context context, long handle);

    void setTargetMode(int mode);

    void setTextColor(int textColor, int bgColor);

    void setTextListener(@Nullable SPenSTTTextListener l);

    boolean updateRecognitionLanguage(@Nullable CharSequence text);
}
