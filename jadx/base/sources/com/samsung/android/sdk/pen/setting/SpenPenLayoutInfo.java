package com.samsung.android.sdk.pen.setting;

import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nBG\b\u0017\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u000eJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0014\u0010\u0015\u001a\u00020\u00142\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003R\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPenLayoutInfo;", "", "paletteList", "", "", "recentList", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "supportEyedropper", "", "<init>", "(Ljava/util/List;Ljava/util/List;Z)V", "customizedPenList", "", "supportDynamicPenWeight", "(Ljava/util/List;Ljava/util/List;ZLjava/util/List;Z)V", "supportDynamicPenWeightByTextSize", "supportFixedOpacity", "getPaletteList", "getRecentList", "setPaletteList", "", "setRecentList", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenLayoutInfo {

    @JvmField
    @Nullable
    public List<String> customizedPenList;

    @Nullable
    private List<Integer> paletteList;

    @Nullable
    private List<SpenHSVColor> recentList;

    @JvmField
    public boolean supportDynamicPenWeightByTextSize;

    @JvmField
    public boolean supportEyedropper;

    @JvmField
    public boolean supportFixedOpacity;

    public /* synthetic */ SpenPenLayoutInfo(List list, List list2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, (i & 4) != 0 ? true : z);
    }

    @NotNull
    public final List<Integer> getPaletteList() {
        List<Integer> list = this.paletteList;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @NotNull
    public final List<SpenHSVColor> getRecentList() {
        List<SpenHSVColor> list = this.recentList;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final void setPaletteList(@NotNull List<Integer> paletteList) {
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        this.paletteList = paletteList;
    }

    public final void setRecentList(@NotNull List<SpenHSVColor> recentList) {
        Intrinsics.checkNotNullParameter(recentList, "recentList");
        this.recentList = recentList;
    }

    public SpenPenLayoutInfo(@NotNull List<Integer> paletteList, @Nullable List<SpenHSVColor> list, boolean z) {
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        this.supportFixedOpacity = true;
        this.paletteList = paletteList;
        this.recentList = list;
        this.supportEyedropper = z;
    }

    @Deprecated(message = "This creator is deprecated. Use (palette, recent, supportEyedropper) instead. The other variables(customizedPenList ..) set is available separately if necessary.")
    public SpenPenLayoutInfo(@NotNull List<Integer> paletteList, @Nullable List<SpenHSVColor> list, boolean z, @Nullable List<String> list2, boolean z2) {
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        this.supportFixedOpacity = true;
        this.paletteList = paletteList;
        this.recentList = list;
        this.supportEyedropper = z;
        this.customizedPenList = list2;
        this.supportDynamicPenWeightByTextSize = z2;
    }
}
