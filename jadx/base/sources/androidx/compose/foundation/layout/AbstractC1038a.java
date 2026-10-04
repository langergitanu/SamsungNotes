package androidx.compose.foundation.layout;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.BaseTextPreparedSelection;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: androidx.compose.foundation.layout.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1038a {
    /* JADX INFO: renamed from: A */
    public static boolean m1196A(Composer composer, int i, Function2 function2) {
        function2.invoke(composer, Integer.valueOf(i));
        return ComposerKt.isTraceInProgress();
    }

    /* JADX INFO: renamed from: B */
    public static int m1197B(Placeable placeable, int i, int i2) {
        return (i - placeable.getHeight()) / i2;
    }

    /* JADX INFO: renamed from: C */
    public static void m1198C(Composer composer, int i, Function2 function2) {
        function2.invoke(composer, Integer.valueOf(i));
        composer.endReplaceableGroup();
    }

    /* JADX INFO: renamed from: D */
    public static boolean m1199D(Composer composer, int i, Function2 function2) {
        function2.invoke(composer, Integer.valueOf(i));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return ComposerKt.isTraceInProgress();
    }

    /* JADX INFO: renamed from: a */
    public static int m1200a(int i, int i2, int i4, ArrayList arrayList) {
        arrayList.add(Integer.valueOf(i));
        return i2 + i4;
    }

    /* JADX INFO: renamed from: b */
    public static int m1201b(int i, int i2, TextStyle textStyle) {
        return (textStyle.hashCode() + i) * i2;
    }

    /* JADX INFO: renamed from: c */
    public static int m1202c(int i, int i2, String str) {
        return (str.hashCode() + i) * i2;
    }

    /* JADX INFO: renamed from: d */
    public static int m1203d(TextFieldPreparedSelection textFieldPreparedSelection, TextFieldPreparedSelection textFieldPreparedSelection2) {
        textFieldPreparedSelection.textPreparedSelectionState.resetCachedX();
        return textFieldPreparedSelection2.text.length();
    }

    /* JADX INFO: renamed from: e */
    public static int m1204e(BaseTextPreparedSelection baseTextPreparedSelection) {
        baseTextPreparedSelection.getState().resetCachedX();
        return baseTextPreparedSelection.getText$foundation_release().length();
    }

    /* JADX INFO: renamed from: f */
    public static int m1205f(Placeable placeable, int i, int i2) {
        return (i - placeable.getWidth()) / i2;
    }

    /* JADX INFO: renamed from: g */
    public static SkippableUpdater m1206g(ComposeUiNode.Companion companion, Composer composer, ViewConfiguration viewConfiguration, Composer composer2, Composer composer3) {
        Updater.m18025setimpl(composer, viewConfiguration, companion.getSetViewConfiguration());
        composer2.enableReusing();
        return SkippableUpdater.m18009boximpl(SkippableUpdater.m18010constructorimpl(composer3));
    }

    /* JADX INFO: renamed from: h */
    public static MeasurePolicy m1207h(Arrangement arrangement, Alignment.Vertical vertical, Composer composer, int i, int i2) {
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), vertical, composer, i);
        composer.startReplaceableGroup(i2);
        return measurePolicyRowMeasurePolicy;
    }

    /* JADX INFO: renamed from: i */
    public static MeasurePolicy m1208i(Alignment.Companion companion, Arrangement.Horizontal horizontal, Composer composer, int i, int i2) {
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, companion.getTop(), composer, i);
        composer.startReplaceableGroup(i2);
        return measurePolicyRowMeasurePolicy;
    }

    /* JADX INFO: renamed from: j */
    public static MeasurePolicy m1209j(Alignment.Companion companion, Arrangement.Vertical vertical, Composer composer, int i, int i2) {
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, companion.getStart(), composer, i);
        composer.startReplaceableGroup(i2);
        return measurePolicyColumnMeasurePolicy;
    }

    /* JADX INFO: renamed from: k */
    public static MeasurePolicy m1210k(Alignment.Companion companion, boolean z, Composer composer, int i, int i2) {
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), z, composer, i);
        composer.startReplaceableGroup(i2);
        return measurePolicyRememberBoxMeasurePolicy;
    }

    /* JADX INFO: renamed from: l */
    public static Object m1211l(Composer composer, int i) {
        composer.startReplaceableGroup(i);
        return composer.consume(CompositionLocalsKt.getLocalDensity());
    }

    /* JADX INFO: renamed from: m */
    public static String m1212m(char c, String str, String str2) {
        return str + c + str2;
    }

    /* JADX INFO: renamed from: n */
    public static String m1213n(char c, String str, StringBuilder sb) {
        sb.append(str);
        sb.append(c);
        return sb.toString();
    }

    /* JADX INFO: renamed from: o */
    public static String m1214o(int i, int i2, String str, String str2) {
        return str + i + str2 + i2;
    }

    /* JADX INFO: renamed from: p */
    public static String m1215p(Object obj, String str, char c) {
        return str + obj + c;
    }

    /* JADX INFO: renamed from: q */
    public static String m1216q(StringBuilder sb, float f, String str, float f4, String str2) {
        sb.append(f);
        sb.append(str);
        sb.append(f4);
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: r */
    public static String m1217r(StringBuilder sb, String str, float f) {
        sb.append(f);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: s */
    public static ArrayList m1218s(Map map, Object obj) {
        ArrayList arrayList = new ArrayList();
        map.put(obj, arrayList);
        return arrayList;
    }

    /* JADX INFO: renamed from: t */
    public static Function2 m1219t(ComposeUiNode.Companion companion, Composer composer, MeasurePolicy measurePolicy, Composer composer2, Density density) {
        Updater.m18025setimpl(composer, measurePolicy, companion.getSetMeasurePolicy());
        Updater.m18025setimpl(composer2, density, companion.getSetDensity());
        return companion.getSetLayoutDirection();
    }

    /* JADX INFO: renamed from: u */
    public static void m1220u(int i, int i2, Composer composer, int i4) {
        composer.startReplaceableGroup(i);
        composer.startReplaceableGroup(i2);
        composer.startReplaceableGroup(i4);
    }

    /* JADX INFO: renamed from: v */
    public static void m1221v(int i, Function3 function3, SkippableUpdater skippableUpdater, Composer composer, int i2) {
        function3.invoke(skippableUpdater, composer, Integer.valueOf(i));
        composer.startReplaceableGroup(i2);
    }

    /* JADX INFO: renamed from: w */
    public static void m1222w(Composer composer, int i, Function2 function2) {
        function2.invoke(composer, Integer.valueOf(i));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    /* JADX INFO: renamed from: x */
    public static void m1223x(StringBuilder sb, String str, long j, String str2) {
        sb.append(str);
        sb.append(j);
        sb.append(str2);
    }

    /* JADX INFO: renamed from: y */
    public static boolean m1224y(InteractionSource interactionSource, String str, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(interactionSource, str);
        composer.startReplaceableGroup(i);
        return ComposerKt.isTraceInProgress();
    }

    /* JADX INFO: renamed from: z */
    public static boolean m1225z(Composer composer) {
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return ComposerKt.isTraceInProgress();
    }
}
