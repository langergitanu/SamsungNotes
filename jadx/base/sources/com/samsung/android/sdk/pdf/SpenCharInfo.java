package com.samsung.android.sdk.pdf;

import android.graphics.Point;
import android.graphics.Rect;
import androidx.collection.AbstractC0622a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenCharInfo;", "", "text", "", "rect", "Landroid/graphics/Rect;", "poly", "", "Landroid/graphics/Point;", "<init>", "(Ljava/lang/String;Landroid/graphics/Rect;[Landroid/graphics/Point;)V", "getText", "()Ljava/lang/String;", "getRect", "()Landroid/graphics/Rect;", "getPoly", "()[Landroid/graphics/Point;", "[Landroid/graphics/Point;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Landroid/graphics/Rect;[Landroid/graphics/Point;)Lcom/samsung/android/sdk/pdf/SpenCharInfo;", "equals", "", "other", "hashCode", "", "toString", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class SpenCharInfo {

    @NotNull
    private final Point[] poly;

    @NotNull
    private final Rect rect;

    @NotNull
    private final String text;

    public SpenCharInfo(@NotNull String text, @NotNull Rect rect, @NotNull Point[] poly) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(poly, "poly");
        this.text = text;
        this.rect = rect;
        this.poly = poly;
    }

    public static /* synthetic */ SpenCharInfo copy$default(SpenCharInfo spenCharInfo, String str, Rect rect, Point[] pointArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = spenCharInfo.text;
        }
        if ((i & 2) != 0) {
            rect = spenCharInfo.rect;
        }
        if ((i & 4) != 0) {
            pointArr = spenCharInfo.poly;
        }
        return spenCharInfo.copy(str, rect, pointArr);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
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
    public final SpenCharInfo copy(@NotNull String text, @NotNull Rect rect, @NotNull Point[] poly) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(poly, "poly");
        return new SpenCharInfo(text, rect, poly);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpenCharInfo)) {
            return false;
        }
        SpenCharInfo spenCharInfo = (SpenCharInfo) other;
        return Intrinsics.areEqual(this.text, spenCharInfo.text) && Intrinsics.areEqual(this.rect, spenCharInfo.rect) && Intrinsics.areEqual(this.poly, spenCharInfo.poly);
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
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return ((this.rect.hashCode() + (this.text.hashCode() * 31)) * 31) + Arrays.hashCode(this.poly);
    }

    @NotNull
    public String toString() {
        String str = this.text;
        Rect rect = this.rect;
        String string = Arrays.toString(this.poly);
        StringBuilder sb = new StringBuilder("SpenCharInfo(text=");
        sb.append(str);
        sb.append(", rect=");
        sb.append(rect);
        sb.append(", poly=");
        return AbstractC0622a.m1170p(string, ")", sb);
    }
}
