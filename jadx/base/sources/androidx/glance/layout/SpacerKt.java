package androidx.glance.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.Applier;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceNodeKt$GlanceNode$$inlined$ComposeNode$1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m13886d2 = {"Spacer", "", "modifier", "Landroidx/glance/GlanceModifier;", "(Landroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;II)V", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpacer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Spacer.kt\nandroidx/glance/layout/SpacerKt\n+ 2 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,51:1\n33#2:52\n34#2:63\n251#3,10:53\n*S KotlinDebug\n*F\n+ 1 Spacer.kt\nandroidx/glance/layout/SpacerKt\n*L\n44#1:52\n44#1:63\n44#1:53,10\n*E\n"})
public final class SpacerKt {

    /* JADX INFO: renamed from: androidx.glance.layout.SpacerKt$Spacer$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class C30781 extends FunctionReferenceImpl implements Function0<EmittableSpacer> {
        public static final C30781 INSTANCE = new C30781();

        public C30781() {
            super(0, EmittableSpacer.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EmittableSpacer invoke() {
            return new EmittableSpacer();
        }
    }

    @Composable
    public static final void Spacer(@Nullable final GlanceModifier glanceModifier, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1380468206);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(glanceModifier) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i4 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                glanceModifier = GlanceModifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1380468206, i4, -1, "androidx.glance.layout.Spacer (Spacer.kt:42)");
            }
            C30781 c30781 = C30781.INSTANCE;
            if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(new GlanceNodeKt$GlanceNode$$inlined$ComposeNode$1(c30781));
            } else {
                composerStartRestartGroup.useNode();
            }
            Updater.m18025setimpl(Updater.m18018constructorimpl(composerStartRestartGroup), glanceModifier, new Function2<EmittableSpacer, GlanceModifier, Unit>() { // from class: androidx.glance.layout.SpacerKt$Spacer$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(EmittableSpacer emittableSpacer, GlanceModifier glanceModifier2) {
                    invoke2(emittableSpacer, glanceModifier2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull EmittableSpacer set, @NotNull GlanceModifier it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    set.setModifier(it);
                }
            });
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.layout.SpacerKt.Spacer.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i6) {
                    SpacerKt.Spacer(glanceModifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
