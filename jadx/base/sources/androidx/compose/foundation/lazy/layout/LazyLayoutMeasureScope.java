package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p109ui.geometry.InlineClassHelperKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpKt;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.p109ui.unit.TextUnitKt;
import androidx.compose.p109ui.unit.TextUnitType;
import androidx.compose.runtime.Stable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u000b\u001a\u00020\f*\u00020\u0010H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u000b\u001a\u00020\f*\u00020\u0006H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0018J\u0016\u0010\u001b\u001a\u00020\r*\u00020\fH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001b\u001a\u00020\r*\u00020\u0010H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001dJ\u0019\u0010\u001b\u001a\u00020\r*\u00020\u0006H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u0082\u0001\u0001 ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006!À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "measure", "", "Landroidx/compose/ui/layout/Placeable;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Stable
@ExperimentalFoundationApi
@SourceDebugExtension({"SMAP\nLazyLayoutMeasureScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyLayoutMeasureScope.kt\nandroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 Size.kt\nandroidx/compose/ui/geometry/SizeKt\n*L\n1#1,154:1\n1#2:155\n169#3:156\n169#3:157\n483#3:158\n198#4:159\n*S KotlinDebug\n*F\n+ 1 LazyLayoutMeasureScope.kt\nandroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope\n*L\n74#1:156\n77#1:157\n89#1:158\n96#1:159\n*E\n"})
public interface LazyLayoutMeasureScope extends MeasureScope {
    @NotNull
    /* JADX INFO: renamed from: measure-0kLqBqw, reason: not valid java name */
    List<Placeable> mo16025measure0kLqBqw(int index, long constraints);

    @Override // androidx.compose.p109ui.unit.FontScaling
    @Stable
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    default float mo15541toDpGaN1DYA(long j) {
        if (!TextUnitType.m21189equalsimpl0(TextUnit.m21160getTypeUIouoOA(j), TextUnitType.INSTANCE.m21194getSpUIouoOA())) {
            throw new IllegalStateException("Only Sp can convert to Px");
        }
        return C2256Dp.m20968constructorimpl(getFontScale() * TextUnit.m21161getValueimpl(j));
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo15543toDpu2uoSUM(int i) {
        return C2256Dp.m20968constructorimpl(i / getDensity());
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    default long mo15544toDpSizekrfVVM(long j) {
        return j != InlineClassHelperKt.UnspecifiedPackedFloats ? DpKt.m20990DpSizeYgX7TsA(mo15542toDpu2uoSUM(Size.m18353getWidthimpl(j)), mo15542toDpu2uoSUM(Size.m18350getHeightimpl(j))) : DpSize.INSTANCE.m21075getUnspecifiedMYxV2XQ();
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    default long mo15547toSizeXkaWNTQ(long j) {
        return j != InlineClassHelperKt.UnspecifiedPackedFloats ? SizeKt.Size(mo15546toPx0680j_4(DpSize.m21066getWidthD9Ej5fM(j)), mo15546toPx0680j_4(DpSize.m21064getHeightD9Ej5fM(j))) : Size.INSTANCE.m18361getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    @Stable
    /* JADX INFO: renamed from: toSp-0xMU5do */
    default long mo15548toSp0xMU5do(float f) {
        return TextUnitKt.getSp(f / getFontScale());
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo15549toSpkPz2Gy4(float f) {
        return TextUnitKt.getSp(f / (getDensity() * getFontScale()));
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo15550toSpkPz2Gy4(int i) {
        return TextUnitKt.getSp(i / (getDensity() * getFontScale()));
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo15542toDpu2uoSUM(float f) {
        return C2256Dp.m20968constructorimpl(f / getDensity());
    }
}
