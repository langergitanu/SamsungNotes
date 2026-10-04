package com.samsung.android.sdk.pen.setting.patternpalette;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ6\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u0011J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J8\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternDataManager;", "", "<init>", "()V", "mPatternInfoList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternInfo;", "Lkotlin/collections/ArrayList;", "close", "", "setPatternInfo", "", "penName", "", "resourceList", "", "sizeList", "", "needBitmap", "getResourceList", "getSizeList", "getResource", "size", "getPatternInfo", "addInfo", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPatternDataManager {

    @NotNull
    private ArrayList<SpenPatternInfo> mPatternInfoList = new ArrayList<>();

    private final boolean addInfo(String penName, List<String> resourceList, List<Float> sizeList, boolean needBitmap) {
        return this.mPatternInfoList.add(new SpenPatternInfo(penName, resourceList, sizeList, needBitmap));
    }

    private final SpenPatternInfo getPatternInfo(String penName) {
        if (penName == null) {
            return null;
        }
        Iterator<SpenPatternInfo> it = this.mPatternInfoList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenPatternInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenPatternInfo spenPatternInfo = next;
            String penName2 = spenPatternInfo.getPenName();
            if (penName2 != null && penName2.compareTo(penName) == 0) {
                return spenPatternInfo;
            }
        }
        return null;
    }

    public final void close() {
        Iterator<SpenPatternInfo> it = this.mPatternInfoList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenPatternInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.close();
        }
        this.mPatternInfoList.clear();
    }

    @Nullable
    public final String getResource(@Nullable String penName, float size) {
        SpenPatternInfo patternInfo = getPatternInfo(penName);
        if (patternInfo == null) {
            return null;
        }
        List<Float> sizeList = patternInfo.getSizeList();
        int size2 = sizeList.size();
        for (int i = 0; i < size2; i++) {
            if (Float.compare(sizeList.get(i).floatValue(), size) == 0) {
                return patternInfo.getResource(i);
            }
        }
        return null;
    }

    @Nullable
    public final List<String> getResourceList(@NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        SpenPatternInfo patternInfo = getPatternInfo(penName);
        if (patternInfo != null) {
            return patternInfo.getResourceList();
        }
        return null;
    }

    @Nullable
    public final List<Float> getSizeList(@NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        SpenPatternInfo patternInfo = getPatternInfo(penName);
        if (patternInfo != null) {
            return patternInfo.getSizeList();
        }
        return null;
    }

    public final boolean needBitmap(@NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        SpenPatternInfo patternInfo = getPatternInfo(penName);
        if (patternInfo != null) {
            return patternInfo.getMNeedBitmap();
        }
        return false;
    }

    public final boolean setPatternInfo(@NotNull String penName, @Nullable List<String> resourceList, @Nullable List<Float> sizeList, boolean needBitmap) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        SpenPatternInfo patternInfo = getPatternInfo(penName);
        return patternInfo != null ? patternInfo.setPatternList(resourceList, sizeList) : addInfo(penName, resourceList, sizeList, needBitmap);
    }
}
