package com.samsung.android.sdk.pen.engine.pointericon;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/pointericon/ControlIcon;", "", "<init>", "()V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "drawableName", "", "getDrawableName", "()Ljava/lang/String;", "setDrawableName", "(Ljava/lang/String;)V", "rotationDegree", "", "getRotationDegree", "()F", "setRotationDegree", "(F)V", "hotSpot", "Landroid/graphics/Point;", "getHotSpot", "()Landroid/graphics/Point;", "setHotSpot", "(Landroid/graphics/Point;)V", "equals", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ControlIcon {

    @Nullable
    private Drawable drawable;

    @Nullable
    private String drawableName = "";

    @NotNull
    private Point hotSpot = new Point(0, 0);
    private float rotationDegree;

    public final boolean equals(@NotNull String drawableName, float rotationDegree) {
        Intrinsics.checkNotNullParameter(drawableName, "drawableName");
        String str = this.drawableName;
        return str != null && Intrinsics.areEqual(str, drawableName) && Float.compare(this.rotationDegree, rotationDegree) == 0;
    }

    @Nullable
    public final Drawable getDrawable() {
        return this.drawable;
    }

    @Nullable
    public final String getDrawableName() {
        return this.drawableName;
    }

    @NotNull
    public final Point getHotSpot() {
        return this.hotSpot;
    }

    public final float getRotationDegree() {
        return this.rotationDegree;
    }

    public final void setDrawable(@Nullable Drawable drawable) {
        this.drawable = drawable;
    }

    public final void setDrawableName(@Nullable String str) {
        this.drawableName = str;
    }

    public final void setHotSpot(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.hotSpot = point;
    }

    public final void setRotationDegree(float f) {
        this.rotationDegree = f;
    }
}
