package androidx.glance.appwidget;

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
@Metadata(m13885d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a=\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, m13886d2 = {"LinearProgressIndicator", "", "modifier", "Landroidx/glance/GlanceModifier;", "color", "Landroidx/glance/unit/ColorProvider;", "backgroundColor", "(Landroidx/glance/GlanceModifier;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;II)V", "progress", "", "contentScale", "Landroidx/glance/appwidget/ContentScale;", "(FLandroidx/glance/GlanceModifier;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/appwidget/ContentScale;Landroidx/compose/runtime/Composer;II)V", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLinearProgressIndicator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LinearProgressIndicator.kt\nandroidx/glance/appwidget/LinearProgressIndicatorKt\n+ 2 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,141:1\n33#2:142\n34#2:153\n33#2:154\n34#2:165\n251#3,10:143\n251#3,10:155\n*S KotlinDebug\n*F\n+ 1 LinearProgressIndicator.kt\nandroidx/glance/appwidget/LinearProgressIndicatorKt\n*L\n47#1:142\n47#1:153\n75#1:154\n75#1:165\n47#1:143,10\n75#1:155,10\n*E\n"})
public final class LinearProgressIndicatorKt {

    /* JADX INFO: renamed from: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class C28771 extends FunctionReferenceImpl implements Function0<EmittableLinearProgressIndicator> {
        public static final C28771 INSTANCE = new C28771();

        public C28771() {
            super(0, EmittableLinearProgressIndicator.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EmittableLinearProgressIndicator invoke() {
            return new EmittableLinearProgressIndicator();
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class C28794 extends FunctionReferenceImpl implements Function0<EmittableLinearProgressIndicator> {
        public static final C28794 INSTANCE = new C28794();

        public C28794() {
            super(0, EmittableLinearProgressIndicator.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EmittableLinearProgressIndicator invoke() {
            return new EmittableLinearProgressIndicator();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LinearProgressIndicator(final float f, @Nullable GlanceModifier glanceModifier, @Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, @Nullable ContentScale contentScale, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        ContentScale contentScale2;
        GlanceModifier glanceModifier2;
        ColorProvider indicatorColorProvider;
        ColorProvider backgroundColorProvider;
        final ColorProvider colorProvider3;
        final ColorProvider colorProvider4;
        final GlanceModifier glanceModifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1555021712);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = i | (composerStartRestartGroup.changed(f) ? 4 : 2);
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
        int i8 = i2 & 16;
        if (i8 == 0) {
            if ((i & 57344) == 0) {
                contentScale2 = contentScale;
                i4 |= composerStartRestartGroup.changed(contentScale2) ? 16384 : 8192;
            }
            if ((i2 & 12) != 12 && (46811 & i4) == 9362 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
                glanceModifier3 = glanceModifier;
                colorProvider4 = colorProvider;
                colorProvider3 = colorProvider2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    glanceModifier2 = i5 == 0 ? GlanceModifier.INSTANCE : glanceModifier;
                    if (i6 == 0) {
                        indicatorColorProvider = ProgressIndicatorDefaults.INSTANCE.getIndicatorColorProvider();
                        i4 &= -897;
                    } else {
                        indicatorColorProvider = colorProvider;
                    }
                    if (i7 == 0) {
                        backgroundColorProvider = ProgressIndicatorDefaults.INSTANCE.getBackgroundColorProvider();
                        i4 &= -7169;
                    } else {
                        backgroundColorProvider = colorProvider2;
                    }
                    if (i8 != 0) {
                        contentScale2 = ContentScale.Medium;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if (i6 != 0) {
                        i4 &= -897;
                    }
                    if (i7 != 0) {
                        i4 &= -7169;
                    }
                    glanceModifier2 = glanceModifier;
                    indicatorColorProvider = colorProvider;
                    backgroundColorProvider = colorProvider2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1555021712, i4, -1, "androidx.glance.appwidget.LinearProgressIndicator (LinearProgressIndicator.kt:45)");
                }
                final C28771 c28771 = C28771.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(new Function0<EmittableLinearProgressIndicator>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$$inlined$GlanceNode$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.glance.appwidget.EmittableLinearProgressIndicator, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final EmittableLinearProgressIndicator invoke() {
                            return c28771.invoke();
                        }
                    });
                }
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier2, new Function2<EmittableLinearProgressIndicator, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, GlanceModifier glanceModifier4) {
                        invoke2(emittableLinearProgressIndicator, glanceModifier4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLinearProgressIndicator set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f), new Function2<EmittableLinearProgressIndicator, Float, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, Float f4) {
                        invoke(emittableLinearProgressIndicator, f4.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableLinearProgressIndicator set, float f4) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setProgress(f4);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, indicatorColorProvider, new Function2<EmittableLinearProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, ColorProvider colorProvider5) {
                        invoke2(emittableLinearProgressIndicator, colorProvider5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLinearProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, backgroundColorProvider, new Function2<EmittableLinearProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, ColorProvider colorProvider5) {
                        invoke2(emittableLinearProgressIndicator, colorProvider5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLinearProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setBackgroundColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, contentScale2, new Function2<EmittableLinearProgressIndicator, ContentScale, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, ContentScale contentScale3) {
                        invoke2(emittableLinearProgressIndicator, contentScale3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLinearProgressIndicator set, @NotNull ContentScale it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setContentScale(it);
                    }
                });
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorProvider3 = backgroundColorProvider;
                colorProvider4 = indicatorColorProvider;
                glanceModifier3 = glanceModifier2;
            }
            final ContentScale contentScale3 = contentScale2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt.LinearProgressIndicator.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i9) {
                        LinearProgressIndicatorKt.LinearProgressIndicator(f, glanceModifier3, colorProvider4, colorProvider3, contentScale3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i4 |= 24576;
        contentScale2 = contentScale;
        if ((i2 & 12) != 12) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 != 0) {
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function0 c287712 = C28771.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                }
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, glanceModifier2, new Function2<EmittableLinearProgressIndicator, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, GlanceModifier glanceModifier4) {
                        invoke2(emittableLinearProgressIndicator, glanceModifier4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLinearProgressIndicator set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f), new Function2<EmittableLinearProgressIndicator, Float, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, Float f4) {
                        invoke(emittableLinearProgressIndicator, f4.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableLinearProgressIndicator set, float f4) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setProgress(f4);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, indicatorColorProvider, new Function2<EmittableLinearProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, ColorProvider colorProvider5) {
                        invoke2(emittableLinearProgressIndicator, colorProvider5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLinearProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, backgroundColorProvider, new Function2<EmittableLinearProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, ColorProvider colorProvider5) {
                        invoke2(emittableLinearProgressIndicator, colorProvider5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLinearProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setBackgroundColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, contentScale2, new Function2<EmittableLinearProgressIndicator, ContentScale, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, ContentScale contentScale32) {
                        invoke2(emittableLinearProgressIndicator, contentScale32);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLinearProgressIndicator set, @NotNull ContentScale it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setContentScale(it);
                    }
                });
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                colorProvider3 = backgroundColorProvider;
                colorProvider4 = indicatorColorProvider;
                glanceModifier3 = glanceModifier2;
            }
        }
        final ContentScale contentScale32 = contentScale2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d5  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LinearProgressIndicator(@Nullable GlanceModifier glanceModifier, @Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1130088971);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(glanceModifier) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i4 |= 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i4 |= 128;
        }
        if ((i2 & 6) == 6 && (i4 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if (i6 != 0) {
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                if (i7 != 0) {
                    i4 &= -897;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final C28794 c28794 = C28794.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                }
                composerStartRestartGroup.startNode();
                if (!composerStartRestartGroup.getInserting()) {
                }
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier, new Function2<EmittableLinearProgressIndicator, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$5$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, GlanceModifier glanceModifier2) {
                        invoke2(emittableLinearProgressIndicator, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLinearProgressIndicator set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, Boolean.TRUE, new Function2<EmittableLinearProgressIndicator, Boolean, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$5$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, Boolean bool) {
                        invoke(emittableLinearProgressIndicator, bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableLinearProgressIndicator set, boolean z) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setIndeterminate(z);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, colorProvider, new Function2<EmittableLinearProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$5$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, ColorProvider colorProvider3) {
                        invoke2(emittableLinearProgressIndicator, colorProvider3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLinearProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, colorProvider2, new Function2<EmittableLinearProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$5$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, ColorProvider colorProvider3) {
                        invoke2(emittableLinearProgressIndicator, colorProvider3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLinearProgressIndicator set, @NotNull ColorProvider it) {
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
            } else {
                if (i5 != 0) {
                    glanceModifier = GlanceModifier.INSTANCE;
                }
                if (i6 != 0) {
                    colorProvider = ProgressIndicatorDefaults.INSTANCE.getIndicatorColorProvider();
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                if (i7 != 0) {
                    colorProvider2 = ProgressIndicatorDefaults.INSTANCE.getBackgroundColorProvider();
                    i4 &= -897;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1130088971, i4, -1, "androidx.glance.appwidget.LinearProgressIndicator (LinearProgressIndicator.kt:73)");
                }
                final C28794 c287942 = C28794.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (!composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new Function0<EmittableLinearProgressIndicator>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$$inlined$GlanceNode$2
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.glance.appwidget.EmittableLinearProgressIndicator, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final EmittableLinearProgressIndicator invoke() {
                            return c287942.invoke();
                        }
                    });
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, glanceModifier, new Function2<EmittableLinearProgressIndicator, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$5$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, GlanceModifier glanceModifier2) {
                        invoke2(emittableLinearProgressIndicator, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLinearProgressIndicator set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, Boolean.TRUE, new Function2<EmittableLinearProgressIndicator, Boolean, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$5$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, Boolean bool) {
                        invoke(emittableLinearProgressIndicator, bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableLinearProgressIndicator set, boolean z) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setIndeterminate(z);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, colorProvider, new Function2<EmittableLinearProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$5$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, ColorProvider colorProvider3) {
                        invoke2(emittableLinearProgressIndicator, colorProvider3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLinearProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, colorProvider2, new Function2<EmittableLinearProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$5$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLinearProgressIndicator emittableLinearProgressIndicator, ColorProvider colorProvider3) {
                        invoke2(emittableLinearProgressIndicator, colorProvider3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLinearProgressIndicator set, @NotNull ColorProvider it) {
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
            }
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        final ColorProvider colorProvider3 = colorProvider;
        final ColorProvider colorProvider4 = colorProvider2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt.LinearProgressIndicator.6
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
                    LinearProgressIndicatorKt.LinearProgressIndicator(glanceModifier2, colorProvider3, colorProvider4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
