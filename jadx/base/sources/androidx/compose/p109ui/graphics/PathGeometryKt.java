package androidx.compose.p109ui.graphics;

import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.PathSegment;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b*\u00020\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u001a\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006¨\u0006\f"}, m13886d2 = {"floatCountForType", "", "type", "Landroidx/compose/ui/graphics/PathSegment$Type;", "computeDirection", "Landroidx/compose/ui/graphics/Path$Direction;", "Landroidx/compose/ui/graphics/Path;", "divide", "", "contours", "reverse", RtspHeaders.Values.DESTINATION, "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPathGeometry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathGeometry.kt\nandroidx/compose/ui/graphics/PathGeometryKt\n+ 2 Bezier.kt\nandroidx/compose/ui/graphics/BezierKt\n*L\n1#1,362:1\n563#2:363\n*S KotlinDebug\n*F\n+ 1 PathGeometry.kt\nandroidx/compose/ui/graphics/PathGeometryKt\n*L\n148#1:363\n*E\n"})
public final class PathGeometryKt {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PathSegment.Type.values().length];
            try {
                iArr[PathSegment.Type.Move.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PathSegment.Type.Line.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PathSegment.Type.Quadratic.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PathSegment.Type.Conic.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PathSegment.Type.Cubic.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PathSegment.Type.Close.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PathSegment.Type.Done.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fa  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Path.Direction computeDirection(@NotNull Path path) {
        float f;
        char c;
        PathIterator it = path.iterator();
        float[] fArr = new float[8];
        PathSegment.Type typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
        char c2 = 1;
        boolean z = true;
        float fCubicArea = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (typeNext$default != PathSegment.Type.Done) {
            switch (WhenMappings.$EnumSwitchMapping$0[typeNext$default.ordinal()]) {
                case 1:
                    c = c2;
                    f = 0.0f;
                    if (z) {
                        z = false;
                        f6 = fArr[0];
                        f7 = fArr[c];
                        typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
                        c2 = c;
                    }
                    break;
                case 2:
                    c = c2;
                    float f8 = fArr[0];
                    float f9 = fArr[c];
                    float f10 = fArr[2];
                    float f11 = fArr[3];
                    fCubicArea += BezierKt.cubicArea(f8, f9, f8, f9, f10, f11, f10, f11);
                    f4 = f10;
                    f5 = f11;
                    typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    c2 = c;
                    break;
                case 3:
                    float f12 = fArr[0];
                    float f13 = fArr[c2];
                    float f14 = fArr[2];
                    float f15 = fArr[3];
                    c = c2;
                    float f16 = fArr[4];
                    float f17 = fArr[5];
                    fCubicArea += BezierKt.cubicArea(f12, f13, AbstractC0000a.m29z(f14, f12, 0.6666667f, f12), AbstractC0000a.m29z(f15, f13, 0.6666667f, f13), AbstractC0000a.m29z(f14, f16, 0.6666667f, f16), AbstractC0000a.m29z(f15, f17, 0.6666667f, f17), f16, f17);
                    f4 = f16;
                    f5 = f17;
                    typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    c2 = c;
                    break;
                case 4:
                    break;
                case 5:
                    fCubicArea += BezierKt.cubicArea(fArr[0], fArr[c2], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]);
                    float f18 = fArr[6];
                    c = c2;
                    f5 = fArr[7];
                    f4 = f18;
                    typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    c2 = c;
                    break;
                case 6:
                    if (Math.abs(f4 - f6) >= 8.34465E-7f || Math.abs(f5 - f7) >= 8.34465E-7f) {
                        fCubicArea += BezierKt.cubicArea(f4, f5, f4, f5, f6, f7, f6, f7);
                        c = c2;
                        f4 = f6;
                        f5 = f7;
                    } else {
                        c = c2;
                    }
                    typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    c2 = c;
                    break;
                case 7:
                    f = 0.0f;
                    break;
                default:
                    c = c2;
                    typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    c2 = c;
                    break;
            }
            return fCubicArea < f ? Path.Direction.Clockwise : Path.Direction.CounterClockwise;
        }
        f = 0.0f;
        if (fCubicArea < f) {
        }
    }

    @NotNull
    public static final List<Path> divide(@NotNull Path path, @NotNull List<Path> list) {
        Path Path = AndroidPath_androidKt.Path();
        PathIterator it = path.iterator();
        float[] fArr = new float[8];
        PathSegment.Type typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
        Path Path2 = Path;
        boolean z = true;
        boolean z2 = true;
        while (typeNext$default != PathSegment.Type.Done) {
            switch (WhenMappings.$EnumSwitchMapping$0[typeNext$default.ordinal()]) {
                case 1:
                    if (!z && !z2) {
                        list.add(Path2);
                        Path2 = AndroidPath_androidKt.Path();
                    }
                    Path2.moveTo(fArr[0], fArr[1]);
                    z = false;
                    z2 = true;
                    typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    break;
                case 2:
                    Path2.lineTo(fArr[2], fArr[3]);
                    z2 = false;
                    typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    break;
                case 3:
                    Path2.quadraticTo(fArr[2], fArr[3], fArr[4], fArr[5]);
                    z2 = false;
                    typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    break;
                case 4:
                case 7:
                    break;
                case 5:
                    Path2.cubicTo(fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]);
                    z2 = false;
                    typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    break;
                case 6:
                    Path2.close();
                    typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    break;
                default:
                    typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
                    break;
            }
        }
        if (!z && !z2) {
            list.add(Path2);
        }
        return list;
    }

    public static /* synthetic */ List divide$default(Path path, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return divide(path, list);
    }

    private static final int floatCountForType(PathSegment.Type type) {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 6;
            case 4:
            case 5:
                return 8;
            case 6:
            case 7:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public static final Path reverse(@NotNull Path path, @NotNull Path path2) {
        boolean z;
        float[] fArr;
        PathIterator it = path.iterator();
        int iCalculateSize = it.calculateSize(false);
        ArrayList arrayList = new ArrayList(iCalculateSize);
        ArrayList arrayList2 = new ArrayList(iCalculateSize);
        float[] fArr2 = new float[8];
        for (PathSegment.Type typeNext$default = PathIterator.next$default(it, fArr2, 0, 2, null); typeNext$default != PathSegment.Type.Done; typeNext$default = PathIterator.next$default(it, fArr2, 0, 2, null)) {
            arrayList.add(typeNext$default);
            if (typeNext$default != PathSegment.Type.Close) {
                float[] fArrCopyOf = Arrays.copyOf(fArr2, floatCountForType(typeNext$default));
                Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(this, newSize)");
                arrayList2.add(fArrCopyOf);
            }
        }
        int size = arrayList2.size();
        boolean z2 = false;
        boolean z3 = true;
        for (int size2 = arrayList.size() - 1; -1 < size2; size2--) {
            if (z3) {
                size--;
                fArr = (float[]) arrayList2.get(size);
                int lastIndex = ArraysKt.getLastIndex(fArr);
                path2.moveTo(fArr[lastIndex - 1], fArr[lastIndex]);
                z = false;
            } else {
                z = z3;
                fArr = (float[]) arrayList2.get(size);
            }
            int i = size;
            int i2 = WhenMappings.$EnumSwitchMapping$0[((PathSegment.Type) arrayList.get(size2)).ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    float[] fArr3 = fArr;
                    path2.lineTo(fArr3[0], fArr3[1]);
                } else if (i2 == 3) {
                    float[] fArr4 = fArr;
                    path2.quadraticTo(fArr4[2], fArr4[3], fArr4[0], fArr4[1]);
                } else if (i2 != 5) {
                    if (i2 == 6) {
                        z2 = true;
                    }
                    size = i;
                    z3 = z;
                } else {
                    float[] fArr5 = fArr;
                    path2.cubicTo(fArr[4], fArr[5], fArr[2], fArr5[3], fArr5[0], fArr5[1]);
                }
                i--;
                size = i;
                z3 = z;
            } else {
                if (z2) {
                    path2.close();
                    z2 = false;
                }
                z3 = true;
                size = i;
            }
        }
        if (z2) {
            path2.close();
        }
        return path2;
    }

    public static /* synthetic */ Path reverse$default(Path path, Path path2, int i, Object obj) {
        if ((i & 1) != 0) {
            path2 = AndroidPath_androidKt.Path();
        }
        return reverse(path, path2);
    }
}
