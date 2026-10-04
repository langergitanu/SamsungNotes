package com.samsung.android.sdk.pdf;

import android.graphics.Point;
import android.graphics.Rect;
import androidx.appcompat.widget.AbstractC0541b;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0002\u0010\u0012JH\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenWordInfo;", "", "charList", "", "Lcom/samsung/android/sdk/pdf/SpenCharInfo;", "rect", "Landroid/graphics/Rect;", "poly", "", "Landroid/graphics/Point;", "curvedPoly", "<init>", "(Ljava/util/List;Landroid/graphics/Rect;[Landroid/graphics/Point;[Landroid/graphics/Point;)V", "getCharList", "()Ljava/util/List;", "getRect", "()Landroid/graphics/Rect;", "getPoly", "()[Landroid/graphics/Point;", "[Landroid/graphics/Point;", "getCurvedPoly", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Landroid/graphics/Rect;[Landroid/graphics/Point;[Landroid/graphics/Point;)Lcom/samsung/android/sdk/pdf/SpenWordInfo;", "equals", "", "other", "hashCode", "", "toString", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class SpenWordInfo {

    @NotNull
    private final List<SpenCharInfo> charList;

    @NotNull
    private final Point[] curvedPoly;

    @NotNull
    private final Point[] poly;

    @NotNull
    private final Rect rect;

    public SpenWordInfo(@NotNull List<SpenCharInfo> charList, @NotNull Rect rect, @NotNull Point[] poly, @NotNull Point[] curvedPoly) {
        Intrinsics.checkNotNullParameter(charList, "charList");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(poly, "poly");
        Intrinsics.checkNotNullParameter(curvedPoly, "curvedPoly");
        this.charList = charList;
        this.rect = rect;
        this.poly = poly;
        this.curvedPoly = curvedPoly;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpenWordInfo copy$default(SpenWordInfo spenWordInfo, List list, Rect rect, Point[] pointArr, Point[] pointArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = spenWordInfo.charList;
        }
        if ((i & 2) != 0) {
            rect = spenWordInfo.rect;
        }
        if ((i & 4) != 0) {
            pointArr = spenWordInfo.poly;
        }
        if ((i & 8) != 0) {
            pointArr2 = spenWordInfo.curvedPoly;
        }
        return spenWordInfo.copy(list, rect, pointArr, pointArr2);
    }

    @NotNull
    public final List<SpenCharInfo> component1() {
        return this.charList;
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

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Point[] getCurvedPoly() {
        return this.curvedPoly;
    }

    @NotNull
    public final SpenWordInfo copy(@NotNull List<SpenCharInfo> charList, @NotNull Rect rect, @NotNull Point[] poly, @NotNull Point[] curvedPoly) {
        Intrinsics.checkNotNullParameter(charList, "charList");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(poly, "poly");
        Intrinsics.checkNotNullParameter(curvedPoly, "curvedPoly");
        return new SpenWordInfo(charList, rect, poly, curvedPoly);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpenWordInfo)) {
            return false;
        }
        SpenWordInfo spenWordInfo = (SpenWordInfo) other;
        return Intrinsics.areEqual(this.charList, spenWordInfo.charList) && Intrinsics.areEqual(this.rect, spenWordInfo.rect) && Intrinsics.areEqual(this.poly, spenWordInfo.poly) && Intrinsics.areEqual(this.curvedPoly, spenWordInfo.curvedPoly);
    }

    @NotNull
    public final List<SpenCharInfo> getCharList() {
        return this.charList;
    }

    @NotNull
    public final Point[] getCurvedPoly() {
        return this.curvedPoly;
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
        return ((((this.rect.hashCode() + (this.charList.hashCode() * 31)) * 31) + Arrays.hashCode(this.poly)) * 31) + Arrays.hashCode(this.curvedPoly);
    }

    @NotNull
    public String toString() {
        List<SpenCharInfo> list = this.charList;
        Rect rect = this.rect;
        String string = Arrays.toString(this.poly);
        String string2 = Arrays.toString(this.curvedPoly);
        StringBuilder sb = new StringBuilder("SpenWordInfo(charList=");
        sb.append(list);
        sb.append(", rect=");
        sb.append(rect);
        sb.append(", poly=");
        return AbstractC0541b.m776r(sb, string, ", curvedPoly=", string2, ")");
    }
}
