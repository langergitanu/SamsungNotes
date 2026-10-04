package com.samsung.android.sdk.pdf;

import android.graphics.Point;
import android.graphics.Rect;
import androidx.glance.AbstractC2821a;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010\u001c\u001a\u00020\fHÆ\u0003JR\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0017¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenLineInfo;", "", "wordList", "", "Lcom/samsung/android/sdk/pdf/SpenWordInfo;", "rect", "Landroid/graphics/Rect;", "poly", "", "Landroid/graphics/Point;", "curvedPoly", "isCurved", "", "<init>", "(Ljava/util/List;Landroid/graphics/Rect;[Landroid/graphics/Point;[Landroid/graphics/Point;Z)V", "getWordList", "()Ljava/util/List;", "getRect", "()Landroid/graphics/Rect;", "getPoly", "()[Landroid/graphics/Point;", "[Landroid/graphics/Point;", "getCurvedPoly", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Landroid/graphics/Rect;[Landroid/graphics/Point;[Landroid/graphics/Point;Z)Lcom/samsung/android/sdk/pdf/SpenLineInfo;", "equals", "other", "hashCode", "", "toString", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class SpenLineInfo {

    @NotNull
    private final Point[] curvedPoly;
    private final boolean isCurved;

    @NotNull
    private final Point[] poly;

    @NotNull
    private final Rect rect;

    @NotNull
    private final List<SpenWordInfo> wordList;

    public SpenLineInfo(@NotNull List<SpenWordInfo> wordList, @NotNull Rect rect, @NotNull Point[] poly, @NotNull Point[] curvedPoly, boolean z) {
        Intrinsics.checkNotNullParameter(wordList, "wordList");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(poly, "poly");
        Intrinsics.checkNotNullParameter(curvedPoly, "curvedPoly");
        this.wordList = wordList;
        this.rect = rect;
        this.poly = poly;
        this.curvedPoly = curvedPoly;
        this.isCurved = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpenLineInfo copy$default(SpenLineInfo spenLineInfo, List list, Rect rect, Point[] pointArr, Point[] pointArr2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = spenLineInfo.wordList;
        }
        if ((i & 2) != 0) {
            rect = spenLineInfo.rect;
        }
        if ((i & 4) != 0) {
            pointArr = spenLineInfo.poly;
        }
        if ((i & 8) != 0) {
            pointArr2 = spenLineInfo.curvedPoly;
        }
        if ((i & 16) != 0) {
            z = spenLineInfo.isCurved;
        }
        boolean z2 = z;
        Point[] pointArr3 = pointArr;
        return spenLineInfo.copy(list, rect, pointArr3, pointArr2, z2);
    }

    @NotNull
    public final List<SpenWordInfo> component1() {
        return this.wordList;
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

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsCurved() {
        return this.isCurved;
    }

    @NotNull
    public final SpenLineInfo copy(@NotNull List<SpenWordInfo> wordList, @NotNull Rect rect, @NotNull Point[] poly, @NotNull Point[] curvedPoly, boolean isCurved) {
        Intrinsics.checkNotNullParameter(wordList, "wordList");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(poly, "poly");
        Intrinsics.checkNotNullParameter(curvedPoly, "curvedPoly");
        return new SpenLineInfo(wordList, rect, poly, curvedPoly, isCurved);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpenLineInfo)) {
            return false;
        }
        SpenLineInfo spenLineInfo = (SpenLineInfo) other;
        return Intrinsics.areEqual(this.wordList, spenLineInfo.wordList) && Intrinsics.areEqual(this.rect, spenLineInfo.rect) && Intrinsics.areEqual(this.poly, spenLineInfo.poly) && Intrinsics.areEqual(this.curvedPoly, spenLineInfo.curvedPoly) && this.isCurved == spenLineInfo.isCurved;
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

    @NotNull
    public final List<SpenWordInfo> getWordList() {
        return this.wordList;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isCurved) + ((((((this.rect.hashCode() + (this.wordList.hashCode() * 31)) * 31) + Arrays.hashCode(this.poly)) * 31) + Arrays.hashCode(this.curvedPoly)) * 31);
    }

    public final boolean isCurved() {
        return this.isCurved;
    }

    @NotNull
    public String toString() {
        List<SpenWordInfo> list = this.wordList;
        Rect rect = this.rect;
        String string = Arrays.toString(this.poly);
        String string2 = Arrays.toString(this.curvedPoly);
        boolean z = this.isCurved;
        StringBuilder sb = new StringBuilder("SpenLineInfo(wordList=");
        sb.append(list);
        sb.append(", rect=");
        sb.append(rect);
        sb.append(", poly=");
        AbstractC2821a.m2207B(sb, string, ", curvedPoly=", string2, ", isCurved=");
        return AbstractC0000a.m14k(sb, z, ")");
    }
}
