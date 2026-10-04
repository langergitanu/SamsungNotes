package androidx.compose.p109ui.graphics;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/graphics/PathEffect;", "", "Companion", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface PathEffect {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\tJ0\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, m13886d2 = {"Landroidx/compose/ui/graphics/PathEffect$Companion;", "", "()V", "chainPathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "outer", "inner", "cornerPathEffect", "radius", "", "dashPathEffect", "intervals", "", TypedValues.Cycle.S_WAVE_PHASE, "stampedPathEffect", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Path;", "advance", "style", "Landroidx/compose/ui/graphics/StampedPathEffectStyle;", "stampedPathEffect-7aD1DOk", "(Landroidx/compose/ui/graphics/Path;FFI)Landroidx/compose/ui/graphics/PathEffect;", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ PathEffect dashPathEffect$default(Companion companion, float[] fArr, float f, int i, Object obj) {
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            return companion.dashPathEffect(fArr, f);
        }

        @NotNull
        public final PathEffect chainPathEffect(@NotNull PathEffect outer, @NotNull PathEffect inner) {
            return AndroidPathEffect_androidKt.actualChainPathEffect(outer, inner);
        }

        @NotNull
        public final PathEffect cornerPathEffect(float radius) {
            return AndroidPathEffect_androidKt.actualCornerPathEffect(radius);
        }

        @NotNull
        public final PathEffect dashPathEffect(@NotNull float[] intervals, float phase) {
            return AndroidPathEffect_androidKt.actualDashPathEffect(intervals, phase);
        }

        @NotNull
        /* JADX INFO: renamed from: stampedPathEffect-7aD1DOk, reason: not valid java name */
        public final PathEffect m18799stampedPathEffect7aD1DOk(@NotNull Path shape, float advance, float phase, int style) {
            return AndroidPathEffect_androidKt.m18421actualStampedPathEffect7aD1DOk(shape, advance, phase, style);
        }
    }
}
