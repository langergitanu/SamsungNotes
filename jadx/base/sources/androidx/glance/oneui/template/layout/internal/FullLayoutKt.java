package androidx.glance.oneui.template.layout.internal;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.glance.Applier;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.EmittableBox;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
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
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, m13886d2 = {"FullLayout", "", "modifier", "Landroidx/glance/GlanceModifier;", "contentAlignment", "Landroidx/glance/layout/Alignment;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/glance/GlanceModifier;Landroidx/glance/layout/Alignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFullLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FullLayout.kt\nandroidx/glance/oneui/template/layout/internal/FullLayoutKt\n+ 2 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,40:1\n43#2:41\n44#2:53\n325#3,11:42\n*S KotlinDebug\n*F\n+ 1 FullLayout.kt\nandroidx/glance/oneui/template/layout/internal/FullLayoutKt\n*L\n31#1:41\n31#1:53\n31#1:42,11\n*E\n"})
public final class FullLayoutKt {

    /* JADX INFO: renamed from: androidx.glance.oneui.template.layout.internal.FullLayoutKt$FullLayout$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class C34241 extends FunctionReferenceImpl implements Function0<EmittableBox> {
        public static final C34241 INSTANCE = new C34241();

        public C34241() {
            super(0, EmittableBox.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EmittableBox invoke() {
            return new EmittableBox();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00eb  */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FullLayout(@Nullable GlanceModifier glanceModifier, @Nullable Alignment alignment, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(830195860);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(glanceModifier) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 112) == 0) {
            i4 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(alignment)) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(content) ? 256 : 128;
        }
        if ((i4 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i5 != 0) {
                    glanceModifier = GlanceModifier.INSTANCE;
                }
                if ((i2 & 2) != 0) {
                    alignment = Alignment.INSTANCE.getTopStart();
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(830195860, i4, -1, "androidx.glance.oneui.template.layout.internal.FullLayout (FullLayout.kt:29)");
                }
                C34241 c34241 = C34241.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(578571862);
                int i6 = i4 & 896;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(c34241);
                }
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier, new Function2<EmittableBox, GlanceModifier, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.FullLayoutKt$FullLayout$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableBox emittableBox, GlanceModifier glanceModifier2) {
                        invoke2(emittableBox, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableBox set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, alignment, new Function2<EmittableBox, Alignment, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.FullLayoutKt$FullLayout$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableBox emittableBox, Alignment alignment2) {
                        invoke2(emittableBox, alignment2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableBox set, @NotNull Alignment it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setContentAlignment(it);
                    }
                });
                content.invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 6) & 14));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                C34241 c342412 = C34241.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(578571862);
                int i62 = i4 & 896;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                }
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, glanceModifier, new Function2<EmittableBox, GlanceModifier, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.FullLayoutKt$FullLayout$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableBox emittableBox, GlanceModifier glanceModifier2) {
                        invoke2(emittableBox, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableBox set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, alignment, new Function2<EmittableBox, Alignment, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.FullLayoutKt$FullLayout$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableBox emittableBox, Alignment alignment2) {
                        invoke2(emittableBox, alignment2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableBox set, @NotNull Alignment it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setContentAlignment(it);
                    }
                });
                content.invoke(composerStartRestartGroup, Integer.valueOf((i62 >> 6) & 14));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        final Alignment alignment2 = alignment;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.FullLayoutKt.FullLayout.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    FullLayoutKt.FullLayout(glanceModifier2, alignment2, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
