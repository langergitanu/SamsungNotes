package com.samsung.android.sdk.pen.setting.pencommon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000b\u001a\u00020\f2\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenColorSettingInfo;", "", "swatchList", "", "", "maxSelectCount", "<init>", "(Ljava/util/List;I)V", "mSwatchList", "", "mMaxSelectCount", "setSwatchList", "", "getSwatchList", "()Ljava/util/List;", "getMaxSelectCount", "()I", "setMaxSelectCount", "(I)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorSettingInfo {
    private int mMaxSelectCount;

    @NotNull
    private final List<Integer> mSwatchList;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SpenColorSettingInfo() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: getMaxSelectCount, reason: from getter */
    public final int getMMaxSelectCount() {
        return this.mMaxSelectCount;
    }

    @NotNull
    public final List<Integer> getSwatchList() {
        return this.mSwatchList;
    }

    public final void setMaxSelectCount(int i) {
        this.mMaxSelectCount = i;
    }

    public final boolean setSwatchList(@Nullable List<Integer> swatchList) {
        List<Integer> list = swatchList;
        if (list == null || list.isEmpty()) {
            return false;
        }
        this.mSwatchList.clear();
        Iterator<Integer> it = swatchList.iterator();
        while (it.hasNext()) {
            this.mSwatchList.add(Integer.valueOf(it.next().intValue()));
        }
        return true;
    }

    @JvmOverloads
    public SpenColorSettingInfo(@Nullable List<Integer> list) {
        this(list, 0, 2, null);
    }

    @JvmOverloads
    public SpenColorSettingInfo(@Nullable List<Integer> list, int i) {
        this.mSwatchList = new ArrayList();
        setSwatchList(list);
        this.mMaxSelectCount = i;
    }

    public /* synthetic */ SpenColorSettingInfo(List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? 0 : i);
    }
}
