package androidx.compose.p109ui.unit;

import androidx.compose.p109ui.unit.fontscaling.FontScaleConverter;
import androidx.compose.p109ui.unit.fontscaling.FontScaleConverterFactory;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\r\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, m13886d2 = {"Landroidx/compose/ui/unit/FontScaling;", "", "fontScale", "", "getFontScale$annotations", "()V", "getFontScale", "()F", "toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "toSp", "toSp-0xMU5do", "(F)J", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFontScaling.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontScaling.android.kt\nandroidx/compose/ui/unit/FontScaling\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/unit/InlineClassHelperKt\n*L\n1#1,68:1\n54#2,7:69\n*S KotlinDebug\n*F\n+ 1 FontScaling.android.kt\nandroidx/compose/ui/unit/FontScaling\n*L\n59#1:69,7\n*E\n"})
public interface FontScaling {
    float getFontScale();

    @Stable
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    default float mo15541toDpGaN1DYA(long j) {
        if (!TextUnitType.m21189equalsimpl0(TextUnit.m21160getTypeUIouoOA(j), TextUnitType.INSTANCE.m21194getSpUIouoOA())) {
            InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
        }
        FontScaleConverterFactory fontScaleConverterFactory = FontScaleConverterFactory.INSTANCE;
        if (!fontScaleConverterFactory.isNonLinearFontScalingActive(getFontScale())) {
            return C2256Dp.m20968constructorimpl(getFontScale() * TextUnit.m21161getValueimpl(j));
        }
        FontScaleConverter fontScaleConverterForScale = fontScaleConverterFactory.forScale(getFontScale());
        float fM21161getValueimpl = TextUnit.m21161getValueimpl(j);
        return fontScaleConverterForScale == null ? C2256Dp.m20968constructorimpl(getFontScale() * fM21161getValueimpl) : C2256Dp.m20968constructorimpl(fontScaleConverterForScale.convertSpToDp(fM21161getValueimpl));
    }

    @Stable
    /* JADX INFO: renamed from: toSp-0xMU5do */
    default long mo15548toSp0xMU5do(float f) {
        FontScaleConverterFactory fontScaleConverterFactory = FontScaleConverterFactory.INSTANCE;
        if (!fontScaleConverterFactory.isNonLinearFontScalingActive(getFontScale())) {
            return TextUnitKt.getSp(f / getFontScale());
        }
        FontScaleConverter fontScaleConverterForScale = fontScaleConverterFactory.forScale(getFontScale());
        return TextUnitKt.getSp(fontScaleConverterForScale != null ? fontScaleConverterForScale.convertDpToSp(f) : f / getFontScale());
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m21079toDpGaN1DYA(@NotNull FontScaling fontScaling, long j) {
            return FontScaling.super.mo15541toDpGaN1DYA(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m21080toSp0xMU5do(@NotNull FontScaling fontScaling, float f) {
            return FontScaling.super.mo15548toSp0xMU5do(f);
        }

        @Stable
        public static /* synthetic */ void getFontScale$annotations() {
        }
    }
}
