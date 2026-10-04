package com.samsung.android.sdk.pen.setting.colorpalette;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u0007R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteResInfo;", "", "<init>", "()V", "info", "(Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteResInfo;)V", "value", "", "resourceId", "getResourceId", "()I", "", "hoverDescription", "getHoverDescription", "()Ljava/lang/CharSequence;", "selectorResourceId", "getSelectorResourceId", "setRes", "", "resId", "selectorResId", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPaletteResInfo {

    @Nullable
    private CharSequence hoverDescription;
    private int resourceId;
    private int selectorResourceId;

    public SpenPaletteResInfo() {
        setRes(0, null, 0);
    }

    public static /* synthetic */ void setRes$default(SpenPaletteResInfo spenPaletteResInfo, int i, CharSequence charSequence, int i2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        spenPaletteResInfo.setRes(i, charSequence, i2);
    }

    @Nullable
    public final CharSequence getHoverDescription() {
        return this.hoverDescription;
    }

    public final int getResourceId() {
        return this.resourceId;
    }

    public final int getSelectorResourceId() {
        return this.selectorResourceId;
    }

    public final void setRes(int resId, @Nullable CharSequence hoverDescription, int selectorResId) {
        this.resourceId = resId;
        this.hoverDescription = hoverDescription;
        this.selectorResourceId = selectorResId;
    }

    public SpenPaletteResInfo(@NotNull SpenPaletteResInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        setRes(info.resourceId, info.hoverDescription, info.selectorResourceId);
    }
}
