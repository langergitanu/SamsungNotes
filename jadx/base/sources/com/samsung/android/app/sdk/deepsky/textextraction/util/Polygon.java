package com.samsung.android.app.sdk.deepsky.textextraction.util;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/util/Polygon;", "", "()V", "pointList", "", "Landroid/graphics/PointF;", "addPoint", "", "x", "", "y", "containsPoint", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class Polygon {

    @NotNull
    private final List<PointF> pointList = new ArrayList();

    public final void addPoint(float x, float y2) {
        this.pointList.add(new PointF(x, y2));
    }

    public final boolean containsPoint(float x, float y2) {
        int i = 0;
        if (this.pointList.size() < 3) {
            return false;
        }
        int size = this.pointList.size() - 1;
        int size2 = this.pointList.size();
        boolean z = false;
        while (i < size2) {
            PointF pointF = this.pointList.get(i);
            PointF pointF2 = this.pointList.get(size);
            float f = pointF.y;
            if ((f < y2 && pointF2.y >= y2) || (pointF2.y < y2 && f >= y2)) {
                float f4 = pointF.x;
                if (AbstractC0000a.m29z(pointF2.x, f4, (y2 - f) / (pointF2.y - f), f4) < x) {
                    z = !z;
                }
            }
            int i2 = i;
            i++;
            size = i2;
        }
        return z;
    }
}
