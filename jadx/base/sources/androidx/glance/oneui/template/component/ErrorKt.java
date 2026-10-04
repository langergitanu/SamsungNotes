package androidx.glance.oneui.template.component;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.BackgroundKt;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.TemplateCompositor;
import androidx.glance.text.TextStyle;
import androidx.glance.unit.ColorProviderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m13886d2 = {"ErrorBox", "", "message", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nError.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Error.kt\nandroidx/glance/oneui/template/component/ErrorKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,47:1\n74#2:48\n76#2:56\n67#3,6:49\n73#3:81\n77#3:86\n75#4:55\n76#4,11:57\n89#4:85\n460#5,13:68\n473#5,3:82\n*S KotlinDebug\n*F\n+ 1 Error.kt\nandroidx/glance/oneui/template/component/ErrorKt\n*L\n22#1:48\n35#1:56\n35#1:49,6\n35#1:81\n35#1:86\n35#1:55\n35#1:57,11\n35#1:85\n35#1:68,13\n35#1:82,3\n*E\n"})
public final class ErrorKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ErrorBox(@NotNull final String message, @Nullable Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(message, "message");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1388493682);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(message) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1388493682, i2, -1, "androidx.glance.oneui.template.component.ErrorBox (Error.kt:20)");
            }
            if (Intrinsics.areEqual(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
                composerStartRestartGroup.startReplaceableGroup(1295277196);
                BoxKt.Box(BackgroundKt.m21250background4WTKRHQ(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), ColorKt.Color(581959712)), Alignment.INSTANCE.getCenter(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1812427271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.ErrorKt.ErrorBox.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i4) {
                        if ((i4 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1812427271, i4, -1, "androidx.glance.oneui.template.component.ErrorBox.<anonymous> (Error.kt:26)");
                        }
                        androidx.glance.text.TextKt.Text(AbstractC0541b.m772n("Err: ", message), SizeModifiersKt.wrapContentSize(GlanceModifier.INSTANCE), new TextStyle(ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(4289724448L)), null, null, null, null, null, null, 0, false, null, null, 0, null, null, 0, 32766, null), 3, 0.0f, composer2, 3072, 16);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, (Alignment.$stable << 3) | 384, 0);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(1295277660);
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier modifierM15409backgroundbw27NRU$default = androidx.compose.foundation.BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), ColorKt.Color(581959712), null, 2, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion2 = androidx.compose.p109ui.Alignment.INSTANCE;
                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composerStartRestartGroup, 0, -1323940314);
                Density density = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15409backgroundbw27NRU$default);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
                androidx.compose.material3.TextKt.m17400TextfLXpl1I(AbstractC0541b.m772n("Err: ", message), BoxScopeInstance.INSTANCE.align(SizeKt.wrapContentSize$default(companion, null, false, 3, null), companion2.getCenter()), ColorKt.Color(4289724448L), 0L, null, null, null, 0L, null, null, 0L, 0, false, 3, null, null, composerStartRestartGroup, 384, 3072, 57336);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.ErrorKt.ErrorBox.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    ErrorKt.ErrorBox(message, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
