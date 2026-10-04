package com.samsung.android.sdk.pdf;

import android.graphics.Point;
import android.graphics.Rect;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u0019\u001a\u00020\u000bHÆ\u0003JB\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0015¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenBlockInfo;", "", "lineList", "", "Lcom/samsung/android/sdk/pdf/SpenLineInfo;", "rect", "Landroid/graphics/Rect;", "poly", "", "Landroid/graphics/Point;", "isTabular", "", "<init>", "(Ljava/util/List;Landroid/graphics/Rect;[Landroid/graphics/Point;I)V", "getLineList", "()Ljava/util/List;", "getRect", "()Landroid/graphics/Rect;", "getPoly", "()[Landroid/graphics/Point;", "[Landroid/graphics/Point;", "()I", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Landroid/graphics/Rect;[Landroid/graphics/Point;I)Lcom/samsung/android/sdk/pdf/SpenBlockInfo;", "equals", "", "other", "hashCode", "toString", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class SpenBlockInfo {
    private final int isTabular;

    @NotNull
    private final List<SpenLineInfo> lineList;

    @NotNull
    private final Point[] poly;

    @NotNull
    private final Rect rect;

    public SpenBlockInfo(@NotNull List<SpenLineInfo> lineList, @NotNull Rect rect, @NotNull Point[] poly, int i) {
        Intrinsics.checkNotNullParameter(lineList, "lineList");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(poly, "poly");
        this.lineList = lineList;
        this.rect = rect;
        this.poly = poly;
        this.isTabular = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpenBlockInfo copy$default(SpenBlockInfo spenBlockInfo, List list, Rect rect, Point[] pointArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = spenBlockInfo.lineList;
        }
        if ((i2 & 2) != 0) {
            rect = spenBlockInfo.rect;
        }
        if ((i2 & 4) != 0) {
            pointArr = spenBlockInfo.poly;
        }
        if ((i2 & 8) != 0) {
            i = spenBlockInfo.isTabular;
        }
        return spenBlockInfo.copy(list, rect, pointArr, i);
    }

    @NotNull
    public final List<SpenLineInfo> component1() {
        return this.lineList;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Rect getRect() {
        return this.rect;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Point[] getPoly() {
        return this.poly;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getIsTabular() {
        return this.isTabular;
    }

    @NotNull
    public final SpenBlockInfo copy(@NotNull List<SpenLineInfo> lineList, @NotNull Rect rect, @NotNull Point[] poly, int isTabular) {
        Intrinsics.checkNotNullParameter(lineList, "lineList");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(poly, "poly");
        return new SpenBlockInfo(lineList, rect, poly, isTabular);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpenBlockInfo)) {
            return false;
        }
        SpenBlockInfo spenBlockInfo = (SpenBlockInfo) other;
        return Intrinsics.areEqual(this.lineList, spenBlockInfo.lineList) && Intrinsics.areEqual(this.rect, spenBlockInfo.rect) && Intrinsics.areEqual(this.poly, spenBlockInfo.poly) && this.isTabular == spenBlockInfo.isTabular;
    }

    @NotNull
    public final List<SpenLineInfo> getLineList() {
        return this.lineList;
    }

    @NotNull
    public final Point[] getPoly() {
        return this.poly;
    }

    @NotNull
    public final Rect getRect() {
        return this.rect;
    }

    public int hashCode() {
        return Integer.hashCode(this.isTabular) + ((((this.rect.hashCode() + (this.lineList.hashCode() * 31)) * 31) + Arrays.hashCode(this.poly)) * 31);
    }

    public final int isTabular() {
        return this.isTabular;
    }

    @NotNull
    public String toString() {
        return "SpenBlockInfo(lineList=" + this.lineList + ", rect=" + this.rect + ", poly=" + Arrays.toString(this.poly) + ", isTabular=" + this.isTabular + ")";
    }
}
