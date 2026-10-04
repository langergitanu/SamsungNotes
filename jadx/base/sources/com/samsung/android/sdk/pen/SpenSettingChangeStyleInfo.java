package com.samsung.android.sdk.pen;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\rB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/SpenSettingChangeStyleInfo;", "", "<init>", "()V", "info", "(Lcom/samsung/android/sdk/pen/SpenSettingChangeStyleInfo;)V", "type", "", "sizeLevel", "color", "fillColor", "isBlankShape", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenSettingChangeStyleInfo {
    public static final int STYLE_TYPE_FILL = 1;
    public static final int STYLE_TYPE_STROKE = 0;

    @JvmField
    public int color;

    @JvmField
    public int fillColor;

    @JvmField
    public boolean isBlankShape;

    @JvmField
    public int sizeLevel;

    @JvmField
    public int type;

    public SpenSettingChangeStyleInfo() {
        this.color = -16777216;
        this.fillColor = -16777216;
    }

    public SpenSettingChangeStyleInfo(@NotNull SpenSettingChangeStyleInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.color = -16777216;
        this.fillColor = -16777216;
        this.type = info.type;
        this.sizeLevel = info.sizeLevel;
        this.color = info.color;
        this.fillColor = info.fillColor;
        this.isBlankShape = info.isBlankShape;
    }
}
