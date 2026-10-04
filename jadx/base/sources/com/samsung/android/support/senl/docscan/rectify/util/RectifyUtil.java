package com.samsung.android.support.senl.docscan.rectify.util;

import android.graphics.PointF;
import android.util.Pair;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\bJ6\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ6\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006J&\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006J\u0016\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006J\"\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00062\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001cJ\u0016\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006J&\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006J\u001e\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\fJ\u001e\u0010\"\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\fJ1\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00062\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010#\u001a\u00020\f¢\u0006\u0002\u0010)J&\u0010*\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\f¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/util/RectifyUtil;", "", "<init>", "()V", "getCalibratedVertexList", "", "Landroid/graphics/PointF;", "vertexList", "([Landroid/graphics/PointF;)[Landroid/graphics/PointF;", "getRealPositionFromRatio", "vertex", "x", "", "y", "width", "height", "interpolation", "getRatioFromRealPosition", "pos", "isCounterClockwise", "", "p1", "p2", "p3", "getCrossingPosition", "p4", "getDistance", "line", "Landroid/util/Pair;", "getGradient", "isParallel", "getNotOverlappedPosition", "dst", "limit", "isHandlerAreaIsOverlapped", "size", "isOverlappedWithTouchPos", "targetIdx", "", "touchPos", "posList", "(ILandroid/graphics/PointF;[Landroid/graphics/PointF;F)Z", "isOverlappedOnLine", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRectifyUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RectifyUtil.kt\ncom/samsung/android/support/senl/docscan/rectify/util/RectifyUtil\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,196:1\n37#2:197\n36#2,3:198\n*S KotlinDebug\n*F\n+ 1 RectifyUtil.kt\ncom/samsung/android/support/senl/docscan/rectify/util/RectifyUtil\n*L\n54#1:197\n54#1:198,3\n*E\n"})
public final class RectifyUtil {

    @NotNull
    public static final RectifyUtil INSTANCE = new RectifyUtil();

    private RectifyUtil() {
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0082  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final PointF[] getCalibratedVertexList(@Nullable PointF[] vertexList) {
        PointF pointF;
        PointF pointF2;
        ArrayList arrayList = new ArrayList();
        if (vertexList != null) {
            int length = vertexList.length;
            for (int i = 0; i < length; i++) {
                PointF pointF3 = vertexList[i];
                if (pointF3 != null) {
                    float f = pointF3.x;
                    if (f < 0.0f && pointF3.y < 0.0f) {
                        arrayList.add(new PointF(0.0f, 0.0f));
                    } else if (1.0f < f && pointF3.y < 0.0f) {
                        arrayList.add(new PointF(1.0f, 0.0f));
                    } else if (1.0f < f && 1.0f < pointF3.y) {
                        arrayList.add(new PointF(1.0f, 1.0f));
                    } else if (f >= 0.0f || 1.0f >= pointF3.y) {
                        double d = f;
                        if (0.0d > d || d > 1.0d) {
                            PointF pointF4 = vertexList[((i + length) - 1) % length];
                            PointF pointF5 = vertexList[(i + 1) % length];
                            if (f < 0.0f) {
                                pointF = new PointF(0.0f, 0.0f);
                                pointF2 = new PointF(0.0f, 1.0f);
                            } else if (1.0f < f) {
                                pointF = new PointF(1.0f, 0.0f);
                                pointF2 = new PointF(1.0f, 1.0f);
                            } else if (pointF3.y < 0.0f) {
                                pointF = new PointF(1.0f, 0.0f);
                                pointF2 = new PointF(0.0f, 0.0f);
                            } else {
                                pointF = new PointF(1.0f, 1.0f);
                                pointF2 = new PointF(0.0f, 1.0f);
                            }
                            RectifyUtil rectifyUtil = INSTANCE;
                            Intrinsics.checkNotNull(pointF4);
                            arrayList.add(rectifyUtil.getCrossingPosition(pointF, pointF2, pointF4, pointF3));
                            Intrinsics.checkNotNull(pointF5);
                            arrayList.add(rectifyUtil.getCrossingPosition(pointF, pointF2, pointF3, pointF5));
                        } else {
                            float f4 = pointF3.y;
                            if (0.0f <= f4 && f4 <= 1.0f) {
                                arrayList.add(pointF3);
                            }
                        }
                    } else {
                        arrayList.add(new PointF(0.0f, 1.0f));
                    }
                }
            }
        }
        return (PointF[]) arrayList.toArray(new PointF[0]);
    }

    @NotNull
    public final PointF getCrossingPosition(@NotNull PointF p1, @NotNull PointF p2, @NotNull PointF p3, @NotNull PointF p4) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(p3, "p3");
        Intrinsics.checkNotNullParameter(p4, "p4");
        float f = p1.x;
        float f4 = p2.x;
        if (f == f4) {
            float f5 = p3.y;
            float f6 = p4.y;
            float f7 = p3.x;
            float f8 = p4.x;
            float f9 = ((f5 - f6) / (f7 - f8)) * f;
            return new PointF(p1.x, (((f6 * f7) - (f5 * f8)) / (f7 - f8)) + f9);
        }
        float f10 = p3.x;
        if (f10 == p4.x) {
            float f11 = p1.y;
            float f12 = p2.y;
            float f13 = ((f11 - f12) / (f - f4)) * f10;
            return new PointF(p3.x, (((f12 * f) - (f11 * f4)) / (f - f4)) + f13);
        }
        float gradient = getGradient(p1, p2);
        float f14 = p2.y - (p2.x * gradient);
        float gradient2 = getGradient(p3, p4);
        float f15 = ((p4.y - (p4.x * gradient2)) - f14) / (gradient - gradient2);
        return new PointF(f15, (gradient * f15) + f14);
    }

    public final float getDistance(@NotNull PointF p1, @NotNull PointF p2) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        float f = p1.x;
        float f4 = p2.x;
        float f5 = (f - f4) * (f - f4);
        float f6 = p1.y;
        float f7 = p2.y;
        return (float) Math.sqrt(AbstractC0000a.m29z(f6, f7, f6 - f7, f5));
    }

    public final float getGradient(@NotNull PointF p1, @NotNull PointF p2) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        return (p1.y - p2.y) / (p1.x - p2.x);
    }

    @NotNull
    public final PointF getNotOverlappedPosition(@NotNull PointF dst, @NotNull PointF pos, float limit) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        Intrinsics.checkNotNullParameter(pos, "pos");
        float distance = getDistance(dst, pos);
        float f = dst.x;
        float f4 = f - (((pos.x - f) * limit) / distance);
        float f5 = dst.y;
        return new PointF(f4, f5 - (((pos.y - f5) * limit) / distance));
    }

    @NotNull
    public final PointF getRatioFromRealPosition(@NotNull PointF pos, float x, float y2, float width, float height, float interpolation) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        return new PointF(((pos.x + interpolation) - x) / width, ((pos.y + interpolation) - y2) / height);
    }

    @NotNull
    public final PointF getRealPositionFromRatio(@NotNull PointF vertex, float x, float y2, float width, float height, float interpolation) {
        Intrinsics.checkNotNullParameter(vertex, "vertex");
        return new PointF(((width * vertex.x) + x) - interpolation, ((height * vertex.y) + y2) - interpolation);
    }

    public final boolean isCounterClockwise(@NotNull PointF p1, @NotNull PointF p2, @NotNull PointF p3) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(p3, "p3");
        int i = (int) p1.x;
        int i2 = (int) p1.y;
        int i4 = (int) p2.x;
        int i5 = (int) p2.y;
        return ((((int) p3.y) - i2) * (i4 - i)) - ((((int) p3.x) - i) * (i5 - i2)) > 0;
    }

    public final boolean isHandlerAreaIsOverlapped(@NotNull PointF p1, @NotNull PointF p2, float size) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        return size >= Math.abs(p1.x - p2.x) && size >= Math.abs(p1.y - p2.y) && getDistance(p1, p2) < size;
    }

    public final boolean isOverlappedOnLine(@NotNull PointF dst, @NotNull PointF p1, @NotNull PointF p2, float size) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        float f = dst.x;
        float f4 = p2.y;
        PointF crossingPosition = getCrossingPosition(dst, new PointF(f - (f4 - p1.y), f - (f4 - p1.x)), p1, p2);
        float fMin = Math.min(p1.x, p2.x);
        float fMax = Math.max(p1.x, p2.x);
        float fMin2 = Math.min(p1.y, p2.y);
        float fMax2 = Math.max(p1.y, p2.y);
        float f5 = crossingPosition.x;
        if (f5 >= fMin) {
            float f6 = crossingPosition.y;
            if (f6 >= fMin2 && fMax >= f5 && fMax2 >= f6 && getDistance(dst, new Pair<>(p1, p2)) < size) {
                return true;
            }
        }
        return false;
    }

    public final boolean isOverlappedWithTouchPos(int targetIdx, @NotNull PointF touchPos, @NotNull PointF[] posList, float size) {
        Intrinsics.checkNotNullParameter(touchPos, "touchPos");
        Intrinsics.checkNotNullParameter(posList, "posList");
        if (!isHandlerAreaIsOverlapped(touchPos, posList[targetIdx], size)) {
            return false;
        }
        int length = posList.length;
        int i = length - 1;
        PointF[] pointFArr = new PointF[i];
        for (int i2 = 0; i2 < i; i2++) {
            pointFArr[i2] = posList[((1 + targetIdx) + i2) % length];
        }
        int i4 = 0;
        while (i4 + 2 < i) {
            PointF pointF = pointFArr[i4];
            Intrinsics.checkNotNull(pointF);
            i4++;
            PointF pointF2 = pointFArr[i4];
            Intrinsics.checkNotNull(pointF2);
            if (!isCounterClockwise(pointF, pointF2, touchPos)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isParallel(@NotNull PointF p1, @NotNull PointF p2, @NotNull PointF p3, @NotNull PointF p4) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(p3, "p3");
        Intrinsics.checkNotNullParameter(p4, "p4");
        return ((float) Math.rint((double) getGradient(p1, p2))) == ((float) Math.rint((double) getGradient(p3, p4)));
    }

    public final float getDistance(@NotNull PointF p1, @NotNull Pair<PointF, PointF> line) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(line, "line");
        Object obj = line.first;
        float f = ((PointF) obj).y;
        Object obj2 = line.second;
        float f4 = -((((PointF) obj).x * (f - ((PointF) obj2).y)) + (((PointF) obj).y * (((PointF) obj2).x - ((PointF) obj).x)));
        float f5 = p1.x;
        float f6 = p1.y;
        return (float) Math.sqrt(((((f6 * r7) + (f5 * r1)) + f4) * (((r7 * f6) + (r1 * f5)) + f4)) / ((r7 * r7) + (r1 * r1)));
    }
}
