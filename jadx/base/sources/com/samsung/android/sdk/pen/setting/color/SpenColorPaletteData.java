package com.samsung.android.sdk.pen.setting.color;

import com.samsung.android.sdk.mobileservice.profile.Privacy;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "", "<init>", "()V", "source", "(Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;)V", "valueId", "", "nameId", "index", "values", "", Privacy.KEY_NAMES, "", "", "[Ljava/lang/String;", "themeValues", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorPaletteData {
    public static final int TABLE_SIZE = 8;

    @JvmField
    public int index;

    @JvmField
    public int nameId;

    @JvmField
    @NotNull
    public String[] names;

    @JvmField
    @NotNull
    public int[] themeValues;

    @JvmField
    public int valueId;

    @JvmField
    @NotNull
    public int[] values;

    public SpenColorPaletteData() {
        this.values = new int[8];
        this.names = new String[8];
        this.themeValues = new int[8];
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenColorPaletteData(@NotNull SpenColorPaletteData source) {
        this();
        Intrinsics.checkNotNullParameter(source, "source");
        this.index = source.index;
        this.valueId = source.valueId;
        this.nameId = source.nameId;
        System.arraycopy(source.values, 0, this.values, 0, 8);
        System.arraycopy(source.names, 0, this.names, 0, 8);
        System.arraycopy(source.themeValues, 0, this.themeValues, 0, 8);
    }
}
