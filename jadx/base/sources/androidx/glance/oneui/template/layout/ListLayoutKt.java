package androidx.glance.oneui.template.layout;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.ListData;
import androidx.glance.oneui.template.TemplateCompositor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aV\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, m13886d2 = {"ListLayout", "", "data", "Landroidx/glance/oneui/template/ListData;", "fillMaxWidth", "", "fillMaxHeight", "listPaddingTop", "Landroidx/compose/ui/unit/Dp;", "listPaddingBottom", "hasItemPaddingStart", "hasItemPaddingEnd", "ListLayout-YlGCr2M", "(Landroidx/glance/oneui/template/ListData;ZZFFZZLandroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nListLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListLayout.kt\nandroidx/glance/oneui/template/layout/ListLayoutKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,44:1\n154#2:45\n154#2:46\n74#3:47\n*S KotlinDebug\n*F\n+ 1 ListLayout.kt\nandroidx/glance/oneui/template/layout/ListLayoutKt\n*L\n17#1:45\n18#1:46\n22#1:47\n*E\n"})
public final class ListLayoutKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ListLayout-YlGCr2M, reason: not valid java name */
    public static final void m21785ListLayoutYlGCr2M(@NotNull final ListData data, boolean z, boolean z2, float f, float f4, boolean z3, boolean z4, @Nullable Composer composer, final int i, final int i2) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1066934309);
        boolean z5 = (i2 & 2) != 0 ? true : z;
        boolean z6 = (i2 & 4) != 0 ? true : z2;
        float fM20968constructorimpl = (i2 & 8) != 0 ? C2256Dp.m20968constructorimpl(0) : f;
        float fM20968constructorimpl2 = (i2 & 16) != 0 ? C2256Dp.m20968constructorimpl(0) : f4;
        boolean z7 = (i2 & 32) != 0 ? true : z3;
        boolean z8 = (i2 & 64) != 0 ? true : z4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1066934309, i, -1, "androidx.glance.oneui.template.layout.ListLayout (ListLayout.kt:20)");
        }
        if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
            composerStartRestartGroup.startReplaceableGroup(-1161407502);
            composer2 = composerStartRestartGroup;
            androidx.glance.oneui.template.layout.glance.ListLayoutKt.m21844GlanceListLayoutYlGCr2M(data, z5, z6, fM20968constructorimpl, fM20968constructorimpl2, z7, z8, composer2, (i & 112) | 8 | (i & 896) | (i & 7168) | (57344 & i) | (458752 & i) | (3670016 & i), 0);
            composer2.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1161407259);
            composer2 = composerStartRestartGroup;
            androidx.glance.oneui.template.layout.compose.ListLayoutKt.m21804ComposeListLayoutYlGCr2M(data, z5, z6, fM20968constructorimpl, fM20968constructorimpl2, z7, z8, composer2, (i & 112) | 8 | (i & 896) | (i & 7168) | (57344 & i) | (458752 & i) | (3670016 & i), 0);
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z9 = z5;
            final boolean z10 = z6;
            final float f5 = fM20968constructorimpl;
            final float f6 = fM20968constructorimpl2;
            final boolean z11 = z7;
            final boolean z12 = z8;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.ListLayoutKt$ListLayout$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer3, int i4) {
                    ListLayoutKt.m21785ListLayoutYlGCr2M(data, z9, z10, f5, f6, z11, z12, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
