package com.samsung.android.support.senl.addons.brush.model.pen;

import com.samsung.android.sdk.pen.pen.SpenPen;
import com.samsung.android.sdk.pen.pen.SpenPenInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/pen/PenPluginInfo;", "", "<init>", "()V", "value", "", "penName", "getPenName", "()Ljava/lang/String;", "penObject", "Lcom/samsung/android/sdk/pen/pen/SpenPen;", "getPenObject", "()Lcom/samsung/android/sdk/pen/pen/SpenPen;", "setPenObject", "(Lcom/samsung/android/sdk/pen/pen/SpenPen;)V", "close", "", "setName", "penInfo", "Lcom/samsung/android/sdk/pen/pen/SpenPenInfo;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PenPluginInfo {

    @Nullable
    private String penName;

    @Nullable
    private SpenPen penObject;

    public final void close() {
        this.penName = null;
        this.penObject = null;
    }

    @Nullable
    public final String getPenName() {
        return this.penName;
    }

    @Nullable
    public final SpenPen getPenObject() {
        return this.penObject;
    }

    public final void setName(@NotNull SpenPenInfo penInfo) {
        Intrinsics.checkNotNullParameter(penInfo, "penInfo");
        this.penName = penInfo.className;
    }

    public final void setPenObject(@Nullable SpenPen spenPen) {
        this.penObject = spenPen;
    }
}
