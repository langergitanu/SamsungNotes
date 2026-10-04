package androidx.compose.p109ui.unit;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\r\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, m13886d2 = {"Landroidx/compose/ui/unit/FontScalingLinear;", "", "fontScale", "", "getFontScale$annotations", "()V", "getFontScale", "()F", "toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "toSp", "toSp-0xMU5do", "(F)J", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Immutable
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nFontScaling.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontScaling.kt\nandroidx/compose/ui/unit/FontScalingLinear\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,84:1\n1#2:85\n*E\n"})
public interface FontScalingLinear {
    float getFontScale();

    @Stable
    /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
    default float m21083toDpGaN1DYA(long j) {
        if (!TextUnitType.m21189equalsimpl0(TextUnit.m21160getTypeUIouoOA(j), TextUnitType.INSTANCE.m21194getSpUIouoOA())) {
            throw new IllegalStateException("Only Sp can convert to Px");
        }
        return C2256Dp.m20968constructorimpl(getFontScale() * TextUnit.m21161getValueimpl(j));
    }

    @Stable
    /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
    default long m21084toSp0xMU5do(float f) {
        return TextUnitKt.getSp(f / getFontScale());
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m21085toDpGaN1DYA(@NotNull FontScalingLinear fontScalingLinear, long j) {
            return FontScalingLinear.super.m21083toDpGaN1DYA(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m21086toSp0xMU5do(@NotNull FontScalingLinear fontScalingLinear, float f) {
            return FontScalingLinear.super.m21084toSp0xMU5do(f);
        }

        @Stable
        public static /* synthetic */ void getFontScale$annotations() {
        }
    }
}
