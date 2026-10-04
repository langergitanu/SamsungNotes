package com.samsung.android.sdk.pen.setting.colorpicker;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006J \u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenPickerColorEventManager;", "", "<init>", "()V", "mListeners", "", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenPickerColorEventListener;", "getMListeners", "()Ljava/util/List;", "setMListeners", "(Ljava/util/List;)V", "close", "", "subscribe", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unsubscribe", "notify", "who", "", "color", "", "hsvColor", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPickerColorEventManager {

    @NotNull
    private List<SpenPickerColorEventListener> mListeners = new ArrayList();

    public final void close() {
        this.mListeners.clear();
    }

    @NotNull
    public final List<SpenPickerColorEventListener> getMListeners() {
        return this.mListeners;
    }

    public final void notify(@Nullable String who, int color, @NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        Iterator<SpenPickerColorEventListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().update(who, color, hsvColor[0], hsvColor[1], hsvColor[2]);
        }
    }

    public final void setMListeners(@NotNull List<SpenPickerColorEventListener> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mListeners = list;
    }

    public final void subscribe(@NotNull SpenPickerColorEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListeners.add(listener);
    }

    public final void unsubscribe(@NotNull SpenPickerColorEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListeners.remove(listener);
    }
}
