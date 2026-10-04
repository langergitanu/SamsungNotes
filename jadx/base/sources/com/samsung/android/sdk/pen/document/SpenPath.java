package com.samsung.android.sdk.pen.document;

import android.graphics.Path;
import android.graphics.RectF;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataPredefinedShape;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J6\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012J&\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012J6\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0012J\u001e\u0010\u001d\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0012J\u0006\u0010&\u001a\u00020\u0010J&\u0010'\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012J\u0010\u0010'\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010%J\u0006\u0010(\u001a\u00020\u0010J\u0010\u0010)\u001a\u00020\u00102\b\u0010*\u001a\u0004\u0018\u00010\u0000J\u0006\u0010+\u001a\u00020,R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006."}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenPath;", "", "<init>", "()V", "segmentList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenPath$Segment;", "Lkotlin/collections/ArrayList;", "segment", "", "getSegment", "()[Lcom/samsung/android/sdk/pen/document/SpenPath$Segment;", "equals", "", "other", "lineTo", "", "x", "", "y", "moveTo", "cubicTo", "x1", "y1", "x2", "y2", "x3", "y3", "quadTo", "arcTo", "left", "top", "right", "bottom", "startAngle", "sweepAngle", VMetaDataPredefinedShape.OVAL, "Landroid/graphics/RectF;", "close", "addOval", "clear", "copy", "source", "copyToAndroidPath", "Landroid/graphics/Path;", "Segment", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPath.kt\ncom/samsung/android/sdk/pen/document/SpenPath\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,376:1\n1#2:377\n*E\n"})
public final class SpenPath {

    @Nullable
    private ArrayList<Segment> segmentList = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenPath$Segment;", "", "<init>", "()V", "type", "", "x", "", "y", "x1", "y1", "x2", "y2", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Segment {
        public static final int TYPE_ADDOVAL = 7;
        public static final int TYPE_ARCTO = 5;
        public static final int TYPE_CLOSE = 6;
        public static final int TYPE_CUBICTO = 4;
        public static final int TYPE_LINETO = 2;
        public static final int TYPE_MOVETO = 1;
        public static final int TYPE_QUADTO = 3;

        @JvmField
        public int type;

        @JvmField
        public float x;

        @JvmField
        public float x1;

        @JvmField
        public float x2;

        @JvmField
        public float y;

        @JvmField
        public float y1;

        @JvmField
        public float y2;
    }

    public final void addOval(float left, float top, float right, float bottom) {
        Segment segment = new Segment();
        segment.type = 7;
        segment.x = left;
        segment.y = top;
        segment.x1 = right;
        segment.y1 = bottom;
        ArrayList<Segment> arrayList = this.segmentList;
        Intrinsics.checkNotNull(arrayList);
        arrayList.add(segment);
    }

    public final void arcTo(float left, float top, float right, float bottom, float startAngle, float sweepAngle) {
        Segment segment = new Segment();
        segment.type = 5;
        segment.x = left;
        segment.y = top;
        segment.x1 = right;
        segment.y1 = bottom;
        segment.x2 = startAngle;
        segment.y2 = sweepAngle;
        ArrayList<Segment> arrayList = this.segmentList;
        Intrinsics.checkNotNull(arrayList);
        arrayList.add(segment);
    }

    public final void clear() {
        ArrayList<Segment> arrayList = this.segmentList;
        Intrinsics.checkNotNull(arrayList);
        arrayList.clear();
    }

    public final void close() {
        Segment segment = new Segment();
        segment.type = 6;
        ArrayList<Segment> arrayList = this.segmentList;
        Intrinsics.checkNotNull(arrayList);
        arrayList.add(segment);
    }

    public final void copy(@Nullable SpenPath source) {
        if (source == null) {
            throw new IllegalArgumentException("Parameter is null");
        }
        ArrayList<Segment> arrayList = this.segmentList;
        Intrinsics.checkNotNull(arrayList);
        arrayList.clear();
        ArrayList<Segment> arrayList2 = source.segmentList;
        this.segmentList = arrayList2 != null ? new ArrayList<>(arrayList2) : null;
    }

    @NotNull
    public final Path copyToAndroidPath() {
        Path path = new Path();
        ArrayList<Segment> arrayList = this.segmentList;
        Intrinsics.checkNotNull(arrayList);
        Iterator<Segment> it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Segment next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Segment segment = next;
            switch (segment.type) {
                case 1:
                    path.moveTo(segment.x, segment.y);
                    break;
                case 2:
                    path.lineTo(segment.x, segment.y);
                    break;
                case 3:
                    path.quadTo(segment.x, segment.y, segment.x2, segment.y2);
                    break;
                case 4:
                    path.cubicTo(segment.x, segment.y, segment.x1, segment.y1, segment.x2, segment.y2);
                    break;
                case 5:
                    RectF rectF = new RectF();
                    rectF.left = segment.x;
                    rectF.top = segment.y;
                    rectF.right = segment.x1;
                    rectF.bottom = segment.y1;
                    path.arcTo(rectF, segment.x2, segment.y2);
                    break;
                case 6:
                    path.close();
                    break;
                case 7:
                    RectF rectF2 = new RectF();
                    rectF2.left = segment.x;
                    rectF2.top = segment.y;
                    rectF2.right = segment.x1;
                    rectF2.bottom = segment.y1;
                    path.addOval(rectF2, Path.Direction.CW);
                    break;
            }
        }
        return path;
    }

    public final void cubicTo(float x12, float y1, float x2, float y2, float x32, float y3) {
        Segment segment = new Segment();
        segment.type = 4;
        segment.x = x12;
        segment.y = y1;
        segment.x1 = x2;
        segment.y1 = y2;
        segment.x2 = x32;
        segment.y2 = y3;
        ArrayList<Segment> arrayList = this.segmentList;
        Intrinsics.checkNotNull(arrayList);
        arrayList.add(segment);
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof SpenPath) {
            SpenPath spenPath = (SpenPath) other;
            ArrayList<Segment> arrayList = spenPath.segmentList;
            if (arrayList == null && this.segmentList == null) {
                return true;
            }
            if (arrayList != null && this.segmentList != null) {
                Intrinsics.checkNotNull(arrayList);
                int size = arrayList.size();
                ArrayList<Segment> arrayList2 = this.segmentList;
                Intrinsics.checkNotNull(arrayList2);
                if (size != arrayList2.size()) {
                    return false;
                }
                ArrayList<Segment> arrayList3 = this.segmentList;
                Intrinsics.checkNotNull(arrayList3);
                Iterator<Segment> it = arrayList3.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                int i = 0;
                while (it.hasNext()) {
                    Segment next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    Segment segment = next;
                    ArrayList<Segment> arrayList4 = spenPath.segmentList;
                    Intrinsics.checkNotNull(arrayList4);
                    Segment segment2 = arrayList4.get(i);
                    Intrinsics.checkNotNullExpressionValue(segment2, "get(...)");
                    Segment segment3 = segment2;
                    int i2 = segment.type;
                    if (i2 != segment3.type) {
                        return false;
                    }
                    if (i2 == 1 || i2 == 2) {
                        if (segment.x != segment3.x || segment.y != segment3.y) {
                            return false;
                        }
                    } else if (i2 != 3) {
                        if (i2 == 4 || i2 == 5) {
                            if (segment.x != segment3.x || segment.y != segment3.y || segment.x1 != segment3.x1 || segment.y1 != segment3.y1 || segment.x2 != segment3.x2 || segment.y2 != segment3.y2) {
                                return false;
                            }
                        } else if (i2 == 7 && (segment.x != segment3.x || segment.y != segment3.y || segment.x1 != segment3.x1 || segment.y1 != segment3.y1)) {
                            return false;
                        }
                    } else if (segment.x != segment3.x || segment.y != segment3.y || segment.x2 != segment3.x2 || segment.y2 != segment3.y2) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final Segment[] getSegment() {
        ArrayList<Segment> arrayList = this.segmentList;
        Intrinsics.checkNotNull(arrayList);
        Object[] array = arrayList.toArray(new Segment[0]);
        Intrinsics.checkNotNullExpressionValue(array, "toArray(...)");
        return (Segment[]) array;
    }

    public final void lineTo(float x, float y2) {
        Segment segment = new Segment();
        segment.type = 2;
        segment.x = x;
        segment.y = y2;
        ArrayList<Segment> arrayList = this.segmentList;
        Intrinsics.checkNotNull(arrayList);
        arrayList.add(segment);
    }

    public final void moveTo(float x, float y2) {
        Segment segment = new Segment();
        segment.type = 1;
        segment.x = x;
        segment.y = y2;
        ArrayList<Segment> arrayList = this.segmentList;
        Intrinsics.checkNotNull(arrayList);
        arrayList.add(segment);
    }

    public final void quadTo(float x12, float y1, float x2, float y2) {
        Segment segment = new Segment();
        segment.type = 3;
        segment.x = x12;
        segment.y = y1;
        segment.x2 = x2;
        segment.y2 = y2;
        ArrayList<Segment> arrayList = this.segmentList;
        Intrinsics.checkNotNull(arrayList);
        arrayList.add(segment);
    }

    public final void addOval(@Nullable RectF oval) {
        if (oval != null) {
            addOval(oval.left, oval.top, oval.right, oval.bottom);
            return;
        }
        throw new NullPointerException("oval is null.");
    }

    public final void arcTo(@NotNull RectF oval, float startAngle, float sweepAngle) {
        Intrinsics.checkNotNullParameter(oval, "oval");
        arcTo(oval.left, oval.top, oval.right, oval.bottom, startAngle, sweepAngle);
    }
}
