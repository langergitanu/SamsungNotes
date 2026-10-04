package androidx.glance.appwidget;

import android.os.Bundle;
import androidx.annotation.FloatRange;
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
@Metadata(m13885d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001aK\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"CircularProgressIndicator", "", "modifier", "Landroidx/glance/GlanceModifier;", "color", "Landroidx/glance/unit/ColorProvider;", "(Landroidx/glance/GlanceModifier;Landroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;II)V", "progress", "", "backgroundColor", "contentScale", "Landroidx/glance/appwidget/ContentScale;", "progressDrawable", "Landroid/os/Bundle;", "(FLandroidx/glance/GlanceModifier;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/appwidget/ContentScale;Landroid/os/Bundle;Landroidx/compose/runtime/Composer;II)V", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCircularProgressIndicator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircularProgressIndicator.kt\nandroidx/glance/appwidget/CircularProgressIndicatorKt\n+ 2 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,118:1\n33#2:119\n34#2:130\n33#2:131\n34#2:142\n251#3,10:120\n251#3,10:132\n*S KotlinDebug\n*F\n+ 1 CircularProgressIndicator.kt\nandroidx/glance/appwidget/CircularProgressIndicatorKt\n*L\n39#1:119\n39#1:130\n67#1:131\n67#1:142\n39#1:120,10\n67#1:132,10\n*E\n"})
public final class CircularProgressIndicatorKt {

    /* JADX INFO: renamed from: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class C28431 extends FunctionReferenceImpl implements Function0<EmittableCircularProgressIndicator> {
        public static final C28431 INSTANCE = new C28431();

        public C28431() {
            super(0, EmittableCircularProgressIndicator.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EmittableCircularProgressIndicator invoke() {
            return new EmittableCircularProgressIndicator();
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class C28454 extends FunctionReferenceImpl implements Function0<EmittableCircularProgressIndicator> {
        public static final C28454 INSTANCE = new C28454();

        public C28454() {
            super(0, EmittableCircularProgressIndicator.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EmittableCircularProgressIndicator invoke() {
            return new EmittableCircularProgressIndicator();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b0  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CircularProgressIndicator(@Nullable final GlanceModifier glanceModifier, @Nullable final ColorProvider colorProvider, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-525156579);
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
        if (i6 == 2 && (i4 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i5 != 0) {
                    glanceModifier = GlanceModifier.INSTANCE;
                }
                if (i6 != 0) {
                    colorProvider = ProgressIndicatorDefaults.INSTANCE.getIndicatorColorProvider();
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-525156579, i4, -1, "androidx.glance.appwidget.CircularProgressIndicator (CircularProgressIndicator.kt:37)");
                }
                final C28431 c28431 = C28431.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(new Function0<EmittableCircularProgressIndicator>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$$inlined$GlanceNode$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.glance.appwidget.EmittableCircularProgressIndicator, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final EmittableCircularProgressIndicator invoke() {
                            return c28431.invoke();
                        }
                    });
                }
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier, new Function2<EmittableCircularProgressIndicator, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, GlanceModifier glanceModifier2) {
                        invoke2(emittableCircularProgressIndicator, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableCircularProgressIndicator set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, colorProvider, new Function2<EmittableCircularProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, ColorProvider colorProvider2) {
                        invoke2(emittableCircularProgressIndicator, colorProvider2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableCircularProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setColor(it);
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
                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function0 c284312 = C28431.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                }
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, glanceModifier, new Function2<EmittableCircularProgressIndicator, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, GlanceModifier glanceModifier2) {
                        invoke2(emittableCircularProgressIndicator, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableCircularProgressIndicator set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, colorProvider, new Function2<EmittableCircularProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, ColorProvider colorProvider2) {
                        invoke2(emittableCircularProgressIndicator, colorProvider2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableCircularProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setColor(it);
                    }
                });
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt.CircularProgressIndicator.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    CircularProgressIndicatorKt.CircularProgressIndicator(glanceModifier, colorProvider, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CircularProgressIndicator(@FloatRange(from = 0.0d, m705to = 1.0d) final float f, @Nullable GlanceModifier glanceModifier, @Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, @Nullable ContentScale contentScale, @Nullable Bundle bundle, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        ContentScale contentScale2;
        int i5;
        GlanceModifier glanceModifier2;
        ColorProvider indicatorColorProvider;
        ColorProvider indicatorColorProvider2;
        ContentScale contentScale3;
        Bundle bundle2;
        final Bundle bundle3;
        final ContentScale contentScale4;
        final ColorProvider colorProvider3;
        final ColorProvider colorProvider4;
        final GlanceModifier glanceModifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1886827820);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = i | (composerStartRestartGroup.changed(f) ? 4 : 2);
        } else {
            i4 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(glanceModifier) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i4 |= 128;
        }
        int i8 = i2 & 8;
        if (i8 != 0) {
            i4 |= 1024;
        }
        int i9 = i2 & 16;
        if (i9 == 0) {
            if ((i & 57344) == 0) {
                contentScale2 = contentScale;
                i4 |= composerStartRestartGroup.changed(contentScale2) ? 16384 : 8192;
            }
            i5 = i2 & 32;
            if (i5 != 0) {
                i4 |= 65536;
            }
            if ((i2 & 44) != 44 && (374491 & i4) == 74898 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
                glanceModifier3 = glanceModifier;
                colorProvider4 = colorProvider;
                colorProvider3 = colorProvider2;
                contentScale4 = contentScale2;
                bundle3 = bundle;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    if (i7 != 0) {
                        i4 &= -897;
                    }
                    if (i8 != 0) {
                        i4 &= -7169;
                    }
                    glanceModifier2 = glanceModifier;
                    indicatorColorProvider = colorProvider;
                    indicatorColorProvider2 = colorProvider2;
                    bundle2 = bundle;
                    contentScale3 = contentScale2;
                } else {
                    glanceModifier2 = i6 == 0 ? GlanceModifier.INSTANCE : glanceModifier;
                    if (i7 == 0) {
                        indicatorColorProvider = ProgressIndicatorDefaults.INSTANCE.getIndicatorColorProvider();
                        i4 &= -897;
                    } else {
                        indicatorColorProvider = colorProvider;
                    }
                    if (i8 == 0) {
                        indicatorColorProvider2 = ProgressIndicatorDefaults.INSTANCE.getIndicatorColorProvider();
                        i4 &= -7169;
                    } else {
                        indicatorColorProvider2 = colorProvider2;
                    }
                    contentScale3 = i9 == 0 ? ContentScale.Medium : contentScale2;
                    bundle2 = i5 == 0 ? null : bundle;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1886827820, i4, -1, "androidx.glance.appwidget.CircularProgressIndicator (CircularProgressIndicator.kt:65)");
                }
                final C28454 c28454 = C28454.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (!composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new Function0<EmittableCircularProgressIndicator>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$$inlined$GlanceNode$2
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.glance.appwidget.EmittableCircularProgressIndicator, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final EmittableCircularProgressIndicator invoke() {
                            return c28454.invoke();
                        }
                    });
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier2, new Function2<EmittableCircularProgressIndicator, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$5$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, GlanceModifier glanceModifier4) {
                        invoke2(emittableCircularProgressIndicator, glanceModifier4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableCircularProgressIndicator set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f), new Function2<EmittableCircularProgressIndicator, Float, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$5$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, Float f4) {
                        invoke(emittableCircularProgressIndicator, f4.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableCircularProgressIndicator set, float f4) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setProgress(f4);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, indicatorColorProvider, new Function2<EmittableCircularProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$5$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, ColorProvider colorProvider5) {
                        invoke2(emittableCircularProgressIndicator, colorProvider5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableCircularProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, indicatorColorProvider2, new Function2<EmittableCircularProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$5$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, ColorProvider colorProvider5) {
                        invoke2(emittableCircularProgressIndicator, colorProvider5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableCircularProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setBackgroundColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, Boolean.FALSE, new Function2<EmittableCircularProgressIndicator, Boolean, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$5$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, Boolean bool) {
                        invoke(emittableCircularProgressIndicator, bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableCircularProgressIndicator set, boolean z) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setIndeterminate(z);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, bundle2, new Function2<EmittableCircularProgressIndicator, Bundle, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$5$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, Bundle bundle4) {
                        invoke2(emittableCircularProgressIndicator, bundle4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableCircularProgressIndicator set, @Nullable Bundle bundle4) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setProgressDrawable(bundle4);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, contentScale3, new Function2<EmittableCircularProgressIndicator, ContentScale, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$5$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, ContentScale contentScale5) {
                        invoke2(emittableCircularProgressIndicator, contentScale5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableCircularProgressIndicator set, @NotNull ContentScale it) {
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
                bundle3 = bundle2;
                contentScale4 = contentScale3;
                colorProvider3 = indicatorColorProvider2;
                colorProvider4 = indicatorColorProvider;
                glanceModifier3 = glanceModifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt.CircularProgressIndicator.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer2, int i10) {
                        CircularProgressIndicatorKt.CircularProgressIndicator(f, glanceModifier3, colorProvider4, colorProvider3, contentScale4, bundle3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i4 |= 24576;
        contentScale2 = contentScale;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        if ((i2 & 44) != 44) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (i5 == 0) {
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function0 c284542 = C28454.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                }
                composerStartRestartGroup.startNode();
                if (!composerStartRestartGroup.getInserting()) {
                }
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, glanceModifier2, new Function2<EmittableCircularProgressIndicator, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$5$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, GlanceModifier glanceModifier4) {
                        invoke2(emittableCircularProgressIndicator, glanceModifier4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableCircularProgressIndicator set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f), new Function2<EmittableCircularProgressIndicator, Float, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$5$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, Float f4) {
                        invoke(emittableCircularProgressIndicator, f4.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableCircularProgressIndicator set, float f4) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setProgress(f4);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, indicatorColorProvider, new Function2<EmittableCircularProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$5$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, ColorProvider colorProvider5) {
                        invoke2(emittableCircularProgressIndicator, colorProvider5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableCircularProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, indicatorColorProvider2, new Function2<EmittableCircularProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$5$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, ColorProvider colorProvider5) {
                        invoke2(emittableCircularProgressIndicator, colorProvider5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableCircularProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setBackgroundColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, Boolean.FALSE, new Function2<EmittableCircularProgressIndicator, Boolean, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$5$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, Boolean bool) {
                        invoke(emittableCircularProgressIndicator, bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableCircularProgressIndicator set, boolean z) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setIndeterminate(z);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, bundle2, new Function2<EmittableCircularProgressIndicator, Bundle, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$5$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, Bundle bundle4) {
                        invoke2(emittableCircularProgressIndicator, bundle4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableCircularProgressIndicator set, @Nullable Bundle bundle4) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setProgressDrawable(bundle4);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, contentScale3, new Function2<EmittableCircularProgressIndicator, ContentScale, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$5$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableCircularProgressIndicator emittableCircularProgressIndicator, ContentScale contentScale5) {
                        invoke2(emittableCircularProgressIndicator, contentScale5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableCircularProgressIndicator set, @NotNull ContentScale it) {
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
                bundle3 = bundle2;
                contentScale4 = contentScale3;
                colorProvider3 = indicatorColorProvider2;
                colorProvider4 = indicatorColorProvider;
                glanceModifier3 = glanceModifier2;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
