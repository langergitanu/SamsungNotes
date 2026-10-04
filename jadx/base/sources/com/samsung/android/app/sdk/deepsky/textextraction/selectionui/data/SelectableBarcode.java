package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data;

import android.graphics.Path;
import android.graphics.Point;
import com.samsung.android.app.sdk.deepsky.textextraction.util.PointUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0005¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableBarcode;", "", "poly", "", "Landroid/graphics/Point;", "([Landroid/graphics/Point;)V", "isSelected", "", "()Z", "setSelected", "(Z)V", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "setPath", "(Landroid/graphics/Path;)V", "value", "getPoly", "()[Landroid/graphics/Point;", "setPoly", "[Landroid/graphics/Point;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SelectableBarcode {
    private boolean isSelected;

    @NotNull
    private Path path;

    @NotNull
    private Point[] poly;

    public SelectableBarcode(@NotNull Point[] poly) {
        Intrinsics.checkNotNullParameter(poly, "poly");
        this.poly = poly;
        this.path = PointUtil.INSTANCE.createPathFromPoly(poly);
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
}
