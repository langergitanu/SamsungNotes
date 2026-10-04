package com.samsung.android.app.sdk.deepsky.textextraction.entity;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/Underline;", "", "start", "Landroid/graphics/PointF;", "stop", "(Landroid/graphics/PointF;Landroid/graphics/PointF;)V", "getStart", "()Landroid/graphics/PointF;", "getStop", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class Underline {

    @NotNull
    private final PointF start;

    @NotNull
    private final PointF stop;

    public Underline(@NotNull PointF start, @NotNull PointF stop) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        this.start = start;
        this.stop = stop;
    }

    public static /* synthetic */ Underline copy$default(Underline underline, PointF pointF, PointF pointF2, int i, Object obj) {
        if ((i & 1) != 0) {
            pointF = underline.start;
        }
        if ((i & 2) != 0) {
            pointF2 = underline.stop;
        }
        return underline.copy(pointF, pointF2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PointF getStart() {
        return this.start;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PointF getStop() {
        return this.stop;
    }

    @NotNull
    public final Underline copy(@NotNull PointF start, @NotNull PointF stop) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        return new Underline(start, stop);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Underline)) {
            return false;
        }
        Underline underline = (Underline) other;
        return Intrinsics.areEqual(this.start, underline.start) && Intrinsics.areEqual(this.stop, underline.stop);
    }

    @NotNull
    public final PointF getStart() {
        return this.start;
    }

    @NotNull
    public final PointF getStop() {
        return this.stop;
    }

    public int hashCode() {
        return this.stop.hashCode() + (this.start.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "Underline(start=" + this.start + ", stop=" + this.stop + ")";
    }
}
