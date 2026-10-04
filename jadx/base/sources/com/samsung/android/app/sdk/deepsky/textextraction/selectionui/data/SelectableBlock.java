package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableBlock;", "", "data", "", "poly", "", "Landroid/graphics/Point;", "(Ljava/lang/String;[Landroid/graphics/Point;)V", "getData", "()Ljava/lang/String;", "getPoly", "()[Landroid/graphics/Point;", "setPoly", "([Landroid/graphics/Point;)V", "[Landroid/graphics/Point;", "selectableLines", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableLine;", "getSelectableLines", "()Ljava/util/List;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SelectableBlock {

    @NotNull
    private final String data;

    @NotNull
    private Point[] poly;

    @NotNull
    private final List<SelectableLine> selectableLines;

    public SelectableBlock(@NotNull String data, @NotNull Point[] poly) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(poly, "poly");
        this.data = data;
        this.poly = poly;
        this.selectableLines = new ArrayList();
    }

    @NotNull
    public final String getData() {
        return this.data;
    }

    @NotNull
    public final Point[] getPoly() {
        return this.poly;
    }

    @NotNull
    public final List<SelectableLine> getSelectableLines() {
        return this.selectableLines;
    }

    public final void setPoly(@NotNull Point[] pointArr) {
        Intrinsics.checkNotNullParameter(pointArr, "<set-?>");
        this.poly = pointArr;
    }
}
