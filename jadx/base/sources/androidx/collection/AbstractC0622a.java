package androidx.collection;

import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.platform.ValueElementSequence;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import java.util.List;
import kotlin.ULong;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: androidx.collection.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0622a {
    /* JADX INFO: renamed from: A */
    public static void m1151A(StringBuilder sb, String str, float f) {
        sb.append((Object) C2256Dp.m20979toStringimpl(f));
        sb.append(str);
    }

    /* JADX INFO: renamed from: B */
    public static float m1152B(float f, float f4, float f5, float f6) {
        return ((f * f4) + f5) * f6;
    }

    /* JADX INFO: renamed from: C */
    public static int m1153C(float f, int i, int i2) {
        return (C2256Dp.m20974hashCodeimpl(f) + i) * i2;
    }

    /* JADX INFO: renamed from: D */
    public static float m1154D(float f, float f4, float f5, float f6) {
        return (f * f4 * f5) + f6;
    }

    /* JADX INFO: renamed from: a */
    public static float m1155a(float f, float f4, float f5, float f6) {
        return ((f - f4) / f5) + f6;
    }

    /* JADX INFO: renamed from: b */
    public static int m1156b(float f, int i, int i2) {
        return (Float.hashCode(f) + i) * i2;
    }

    /* JADX INFO: renamed from: c */
    public static int m1157c(int i, int i2, int i4) {
        return (Integer.hashCode(i) + i2) * i4;
    }

    /* JADX INFO: renamed from: d */
    public static int m1158d(long j, int i, int i2) {
        return (Color.m18532hashCodeimpl(j) + i) * i2;
    }

    /* JADX INFO: renamed from: e */
    public static int m1159e(List list, int i, int i2) {
        return (list.hashCode() + i) * i2;
    }

    /* JADX INFO: renamed from: f */
    public static int m1160f(boolean z, int i, int i2) {
        return (Boolean.hashCode(z) + i) * i2;
    }

    /* JADX INFO: renamed from: g */
    public static long m1161g(long j, long j2) {
        return ULong.m22389constructorimpl(ULong.m22389constructorimpl(j) * j2);
    }

    /* JADX INFO: renamed from: h */
    public static ValueElementSequence m1162h(float f, ValueElementSequence valueElementSequence, String str, InspectorInfo inspectorInfo) {
        valueElementSequence.set(str, C2256Dp.m20966boximpl(f));
        return inspectorInfo.getProperties();
    }

    /* JADX INFO: renamed from: i */
    public static ValueElementSequence m1163i(boolean z, ValueElementSequence valueElementSequence, String str, InspectorInfo inspectorInfo) {
        valueElementSequence.set(str, Boolean.valueOf(z));
        return inspectorInfo.getProperties();
    }

    /* JADX INFO: renamed from: j */
    public static String m1164j(int i, int i2, String str, String str2, String str3) {
        return str + i + str2 + i2 + str3;
    }

    /* JADX INFO: renamed from: k */
    public static String m1165k(Object obj, String str, String str2) {
        return str + obj + str2;
    }

    /* JADX INFO: renamed from: l */
    public static String m1166l(String str, float f) {
        return str + f;
    }

    /* JADX INFO: renamed from: m */
    public static String m1167m(String str, int i, char c) {
        return str + i + c;
    }

    /* JADX INFO: renamed from: n */
    public static String m1168n(String str, int i, String str2, int i2, char c) {
        return str + i + str2 + i2 + c;
    }

    /* JADX INFO: renamed from: o */
    public static String m1169o(String str, long j) {
        return str + j;
    }

    /* JADX INFO: renamed from: p */
    public static String m1170p(String str, String str2, StringBuilder sb) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: q */
    public static String m1171q(StringBuilder sb, float f, char c) {
        sb.append(f);
        sb.append(c);
        return sb.toString();
    }

    /* JADX INFO: renamed from: r */
    public static String m1172r(StringBuilder sb, boolean z, char c) {
        sb.append(z);
        sb.append(c);
        return sb.toString();
    }

    /* JADX INFO: renamed from: s */
    public static StringBuilder m1173s(int i, int i2, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    /* JADX INFO: renamed from: t */
    public static StringBuilder m1174t(CharSequence charSequence, String str, CharSequence charSequence2, String str2, CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, str);
        Intrinsics.checkNotNullParameter(charSequence2, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence3);
        return sb;
    }

    /* JADX INFO: renamed from: u */
    public static StringBuilder m1175u(CharSequence charSequence, String str, Function1 function1, String str2, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, str);
        Intrinsics.checkNotNullParameter(function1, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        return sb;
    }

    /* JADX INFO: renamed from: v */
    public static StringBuilder m1176v(String str, float f, String str2, float f4, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(f);
        sb.append(str2);
        sb.append(f4);
        sb.append(str3);
        return sb;
    }

    /* JADX INFO: renamed from: w */
    public static Function2 m1177w(ComposeUiNode.Companion companion, Composer composer, MeasurePolicy measurePolicy, Composer composer2, CompositionLocalMap compositionLocalMap) {
        Updater.m18025setimpl(composer, measurePolicy, companion.getSetMeasurePolicy());
        Updater.m18025setimpl(composer2, compositionLocalMap, companion.getSetResolvedCompositionLocals());
        return companion.getSetCompositeKeyHash();
    }

    /* JADX INFO: renamed from: x */
    public static void m1178x(int i, Function2 function2, Composer composer, int i2) {
        composer.updateRememberedValue(Integer.valueOf(i));
        composer.apply(Integer.valueOf(i2), function2);
    }

    /* JADX INFO: renamed from: y */
    public static void m1179y(DrawContext drawContext, long j) {
        drawContext.getCanvas().restore();
        drawContext.mo18998setSizeuvyYCjk(j);
    }

    /* JADX INFO: renamed from: z */
    public static void m1180z(StringBuilder sb, int i, int i2, String str, String str2) {
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
    }
}
