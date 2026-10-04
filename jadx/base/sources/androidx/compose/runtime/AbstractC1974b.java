package androidx.compose.runtime;

import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.node.LayoutNode;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateMapKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KMutableProperty1;

/* JADX INFO: renamed from: androidx.compose.runtime.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1974b {
    /* JADX INFO: renamed from: A */
    public static int m1304A(int i, int i2, int i4, int i5) {
        return ((i - i2) * i4) + i5;
    }

    /* JADX INFO: renamed from: B */
    public static void m1305B(StringBuilder sb, int i, String str, String str2, String str3) {
        sb.append(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        PreconditionsKt.throwIllegalStateException(sb.toString());
    }

    /* JADX INFO: renamed from: C */
    public static double m1306C(double d, double d2, double d3, double d4) {
        return ((d - d2) * d3) + d4;
    }

    /* JADX INFO: renamed from: D */
    public static double m1307D(double d, double d2, double d3, double d4) {
        return (d * d2) + d3 + d4;
    }

    /* JADX INFO: renamed from: a */
    public static double m1308a(double d, double d2, double d3, double d4) {
        return ((d * d2) + d3) / d4;
    }

    /* JADX INFO: renamed from: b */
    public static float m1309b(float f, float f4, float f5, float f6) {
        return (f5 - (f * f4)) * f6;
    }

    /* JADX INFO: renamed from: c */
    public static int m1310c(int i, int i2, int i4, int i5) {
        return (i * i2) + i4 + i5;
    }

    /* JADX INFO: renamed from: d */
    public static int m1311d(long j, int i, int i2) {
        return (Long.hashCode(j) + i) * i2;
    }

    /* JADX INFO: renamed from: e */
    public static int m1312e(LayoutNode layoutNode) {
        return layoutNode.getNodes().getHead().getAggregateChildKindSet();
    }

    /* JADX INFO: renamed from: f */
    public static Object m1313f(int i, ArrayList arrayList) {
        return arrayList.get(arrayList.size() - i);
    }

    /* JADX INFO: renamed from: g */
    public static Object m1314g(MutableVector mutableVector, int i) {
        return mutableVector.removeAt(mutableVector.getSize() - i);
    }

    /* JADX INFO: renamed from: h */
    public static String m1315h(char c, String str, String str2) {
        return str + str2 + c;
    }

    /* JADX INFO: renamed from: i */
    public static String m1316i(int i, StringBuilder sb) {
        sb.append(Integer.toHexString(i));
        return sb.toString();
    }

    /* JADX INFO: renamed from: j */
    public static String m1317j(long j, String str, String str2) {
        return str + j + str2;
    }

    /* JADX INFO: renamed from: k */
    public static String m1318k(String str, double d) {
        return str + d;
    }

    /* JADX INFO: renamed from: l */
    public static String m1319l(String str, int i, String str2, String str3, String str4) {
        return str + str2 + str3 + i + str4;
    }

    /* JADX INFO: renamed from: m */
    public static String m1320m(StringBuilder sb, Object obj, String str) {
        sb.append(obj);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: n */
    public static String m1321n(StringBuilder sb, List list, char c) {
        sb.append(list);
        sb.append(c);
        return sb.toString();
    }

    /* JADX INFO: renamed from: o */
    public static StringBuilder m1322o(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(str);
        return sb;
    }

    /* JADX INFO: renamed from: p */
    public static StringBuilder m1323p(long j, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(j);
        sb.append(str2);
        return sb;
    }

    /* JADX INFO: renamed from: q */
    public static StringBuilder m1324q(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    /* JADX INFO: renamed from: r */
    public static StringBuilder m1325r(String str, String str2) {
        Intrinsics.checkNotNullExpressionValue(str, str2);
        return new StringBuilder();
    }

    /* JADX INFO: renamed from: s */
    public static KotlinNothingValueException m1326s() {
        SnapshotStateMapKt.unsupported();
        return new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: t */
    public static KotlinNothingValueException m1327t(String str) {
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(str);
        return new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: u */
    public static KMutableProperty1 m1328u(Class cls, String str, String str2, int i) {
        return Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, str, str2, i));
    }

    /* JADX INFO: renamed from: v */
    public static void m1329v(int i, DrawContext drawContext, long j, int i2) {
        InlineMarker.finallyStart(i);
        drawContext.getCanvas().restore();
        drawContext.mo18998setSizeuvyYCjk(j);
        InlineMarker.finallyEnd(i2);
    }

    /* JADX INFO: renamed from: w */
    public static void m1330w(int i, String str, String str2, StringBuilder sb) {
        sb.append(str);
        sb.append(i);
        sb.append(str2);
    }

    /* JADX INFO: renamed from: x */
    public static void m1331x(StringBuilder sb, int i, String str, String str2, String str3) {
        sb.append(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
    }

    /* JADX INFO: renamed from: y */
    public static void m1332y(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
    }

    /* JADX INFO: renamed from: z */
    public static double m1333z(double d, double d2, double d3, double d4) {
        return (d3 - (d * d2)) / d4;
    }
}
