package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data;

import android.graphics.Path;
import android.graphics.Point;
import com.samsung.android.app.sdk.deepsky.textextraction.util.PointUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0013\"\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR2\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;", "", "data", "", "poly", "", "Landroid/graphics/Point;", "isVertical", "", "(Ljava/lang/String;[Landroid/graphics/Point;Z)V", "getData", "()Ljava/lang/String;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "isSelected", "()Z", "setSelected", "(Z)V", "setVertical", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "setPath", "(Landroid/graphics/Path;)V", "value", "getPoly", "()[Landroid/graphics/Point;", "setPoly", "([Landroid/graphics/Point;)V", "[Landroid/graphics/Point;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SelectableCharacter {

    @NotNull
    private final String data;
    private int index;
    private boolean isSelected;
    private boolean isVertical;

    @NotNull
    private Path path;

    @NotNull
    private Point[] poly;

    public SelectableCharacter(@NotNull String data, @NotNull Point[] poly, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(poly, "poly");
        this.data = data;
        this.isVertical = z;
        this.poly = poly;
        this.path = PointUtil.INSTANCE.createPathFromPoly(poly);
        this.index = -1;
    }

    @NotNull
    public final String getData() {
        return this.data;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final Path getPath() {
        return this.path;
    }

    @NotNull
    public final Point[] getPoly() {
        return this.poly;
    }

    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* JADX INFO: renamed from: isVertical, reason: from getter */
    public final boolean getIsVertical() {
        return this.isVertical;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setPath(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<set-?>");
        this.path = path;
    }

    public final void setPoly(@NotNull Point[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.poly = value;
        this.path = PointUtil.INSTANCE.createPathFromPoly(value);
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final void setVertical(boolean z) {
        this.isVertical = z;
    }
}
