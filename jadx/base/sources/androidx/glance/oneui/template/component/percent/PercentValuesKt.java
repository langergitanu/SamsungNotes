package androidx.glance.oneui.template.component.percent;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.appwidget.percent.PercentSizePolicy;
import com.nimbusds.jose.jwk.JWKParameterNames;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m13886d2 = {JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "Landroidx/compose/ui/unit/Dp;", "Landroidx/glance/oneui/template/component/percent/PercentValues;", "getDp", "(Landroidx/glance/oneui/template/component/percent/PercentValues;Landroidx/compose/runtime/Composer;I)F", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPercentValues.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PercentValues.kt\nandroidx/glance/oneui/template/component/percent/PercentValuesKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,29:1\n74#2:30\n88#3:31\n88#3:32\n*S KotlinDebug\n*F\n+ 1 PercentValues.kt\nandroidx/glance/oneui/template/component/percent/PercentValuesKt\n*L\n23#1:30\n25#1:31\n26#1:32\n*E\n"})
public final class PercentValuesKt {
    @Composable
    @JvmName(name = "getDp")
    public static final float getDp(@NotNull PercentValues percentValues, @Nullable Composer composer, int i) {
        float fM20968constructorimpl;
        Intrinsics.checkNotNullParameter(percentValues, "<this>");
        composer.startReplaceableGroup(2027306);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2027306, i, -1, "androidx.glance.oneui.template.component.percent.<get-dp> (PercentValues.kt:20)");
        }
        long packedValue = ((DpSize) composer.consume(CompositionLocalsKt.getLocalSize())).getPackedValue();
        if (PercentSizePolicy.m21375equalsimpl0(percentValues.getPolicy(), PercentSizePolicy.INSTANCE.m21382getWidth3SpTkPA())) {
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(percentValues.getPercent() * DpSize.m21066getWidthD9Ej5fM(packedValue));
        } else {
            fM20968constructorimpl = C2256Dp.m20968constructorimpl(percentValues.getPercent() * DpSize.m21064getHeightD9Ej5fM(packedValue));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fM20968constructorimpl;
    }
}
