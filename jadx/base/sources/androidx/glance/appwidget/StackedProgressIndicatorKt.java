package androidx.glance.appwidget;

import androidx.annotation.RestrictTo;
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
import androidx.glance.unit.ColorProvider;
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
@Metadata(m13885d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, m13886d2 = {"StackedProgressIndicator", "", "progress", "", "modifier", "Landroidx/glance/GlanceModifier;", "color", "Landroidx/glance/unit/ColorProvider;", "backgroundColor", "(FLandroidx/glance/GlanceModifier;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;II)V", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nStackedProgressIndicator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StackedProgressIndicator.kt\nandroidx/glance/appwidget/StackedProgressIndicatorKt\n+ 2 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,63:1\n33#2:64\n34#2:75\n251#3,10:65\n*S KotlinDebug\n*F\n+ 1 StackedProgressIndicator.kt\nandroidx/glance/appwidget/StackedProgressIndicatorKt\n*L\n29#1:64\n29#1:75\n29#1:65,10\n*E\n"})
public final class StackedProgressIndicatorKt {

    /* JADX INFO: renamed from: androidx.glance.appwidget.StackedProgressIndicatorKt$StackedProgressIndicator$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class C29131 extends FunctionReferenceImpl implements Function0<EmittableStackedProgressIndicator> {
        public static final C29131 INSTANCE = new C29131();

        public C29131() {
            super(0, EmittableStackedProgressIndicator.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EmittableStackedProgressIndicator invoke() {
            return new EmittableStackedProgressIndicator();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ef  */
    @Composable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StackedProgressIndicator(final float f, @Nullable GlanceModifier glanceModifier, @Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(832270967);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(glanceModifier) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i4 |= 128;
        }
        int i7 = i2 & 8;
        if (i7 != 0) {
            i4 |= 1024;
        }
        if ((i2 & 12) == 12 && (i4 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i5 != 0) {
                    glanceModifier = GlanceModifier.INSTANCE;
                }
                if (i6 != 0) {
                    colorProvider = ProgressIndicatorDefaults.INSTANCE.getIndicatorColorProvider();
                    i4 &= -897;
                }
                if (i7 != 0) {
                    colorProvider2 = ProgressIndicatorDefaults.INSTANCE.getBackgroundColorProvider();
                    i4 &= -7169;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(832270967, i4, -1, "androidx.glance.appwidget.StackedProgressIndicator (StackedProgressIndicator.kt:27)");
                }
                final C29131 c29131 = C29131.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(new Function0<EmittableStackedProgressIndicator>() { // from class: androidx.glance.appwidget.StackedProgressIndicatorKt$StackedProgressIndicator$$inlined$GlanceNode$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.glance.appwidget.EmittableStackedProgressIndicator, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final EmittableStackedProgressIndicator invoke() {
                            return c29131.invoke();
                        }
                    });
                }
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier, new Function2<EmittableStackedProgressIndicator, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.StackedProgressIndicatorKt$StackedProgressIndicator$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableStackedProgressIndicator emittableStackedProgressIndicator, GlanceModifier glanceModifier2) {
                        invoke2(emittableStackedProgressIndicator, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableStackedProgressIndicator set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f), new Function2<EmittableStackedProgressIndicator, Float, Unit>() { // from class: androidx.glance.appwidget.StackedProgressIndicatorKt$StackedProgressIndicator$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableStackedProgressIndicator emittableStackedProgressIndicator, Float f4) {
                        invoke(emittableStackedProgressIndicator, f4.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableStackedProgressIndicator set, float f4) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setProgress(f4);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, colorProvider, new Function2<EmittableStackedProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.StackedProgressIndicatorKt$StackedProgressIndicator$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableStackedProgressIndicator emittableStackedProgressIndicator, ColorProvider colorProvider3) {
                        invoke2(emittableStackedProgressIndicator, colorProvider3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableStackedProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, colorProvider2, new Function2<EmittableStackedProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.StackedProgressIndicatorKt$StackedProgressIndicator$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableStackedProgressIndicator emittableStackedProgressIndicator, ColorProvider colorProvider3) {
                        invoke2(emittableStackedProgressIndicator, colorProvider3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableStackedProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setBackgroundColor(it);
                    }
                });
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if (i6 != 0) {
                    i4 &= -897;
                }
                if (i7 != 0) {
                    i4 &= -7169;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function0 c291312 = C29131.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                }
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, glanceModifier, new Function2<EmittableStackedProgressIndicator, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.StackedProgressIndicatorKt$StackedProgressIndicator$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableStackedProgressIndicator emittableStackedProgressIndicator, GlanceModifier glanceModifier2) {
                        invoke2(emittableStackedProgressIndicator, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableStackedProgressIndicator set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f), new Function2<EmittableStackedProgressIndicator, Float, Unit>() { // from class: androidx.glance.appwidget.StackedProgressIndicatorKt$StackedProgressIndicator$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableStackedProgressIndicator emittableStackedProgressIndicator, Float f4) {
                        invoke(emittableStackedProgressIndicator, f4.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableStackedProgressIndicator set, float f4) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setProgress(f4);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, colorProvider, new Function2<EmittableStackedProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.StackedProgressIndicatorKt$StackedProgressIndicator$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableStackedProgressIndicator emittableStackedProgressIndicator, ColorProvider colorProvider3) {
                        invoke2(emittableStackedProgressIndicator, colorProvider3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableStackedProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, colorProvider2, new Function2<EmittableStackedProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.StackedProgressIndicatorKt$StackedProgressIndicator$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableStackedProgressIndicator emittableStackedProgressIndicator, ColorProvider colorProvider3) {
                        invoke2(emittableStackedProgressIndicator, colorProvider3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableStackedProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setBackgroundColor(it);
                    }
                });
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        final ColorProvider colorProvider3 = colorProvider;
        final ColorProvider colorProvider4 = colorProvider2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.StackedProgressIndicatorKt.StackedProgressIndicator.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i8) {
                    StackedProgressIndicatorKt.StackedProgressIndicator(f, glanceModifier2, colorProvider3, colorProvider4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
