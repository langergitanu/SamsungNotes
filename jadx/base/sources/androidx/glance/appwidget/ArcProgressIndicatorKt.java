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
@Metadata(m13885d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m13886d2 = {"ArcProgressIndicator", "", "progress", "", "modifier", "Landroidx/glance/GlanceModifier;", "color", "Landroidx/glance/unit/ColorProvider;", "backgroundColor", "contentScale", "Landroidx/glance/appwidget/ContentScale;", "progressDrawable", "Landroid/os/Bundle;", "(FLandroidx/glance/GlanceModifier;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/appwidget/ContentScale;Landroid/os/Bundle;Landroidx/compose/runtime/Composer;II)V", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nArcProgressIndicator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArcProgressIndicator.kt\nandroidx/glance/appwidget/ArcProgressIndicatorKt\n+ 2 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,85:1\n33#2:86\n34#2:97\n251#3,10:87\n*S KotlinDebug\n*F\n+ 1 ArcProgressIndicator.kt\nandroidx/glance/appwidget/ArcProgressIndicatorKt\n*L\n45#1:86\n45#1:97\n45#1:87,10\n*E\n"})
public final class ArcProgressIndicatorKt {

    /* JADX INFO: renamed from: androidx.glance.appwidget.ArcProgressIndicatorKt$ArcProgressIndicator$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class C28351 extends FunctionReferenceImpl implements Function0<EmittableArcProgressIndicator> {
        public static final C28351 INSTANCE = new C28351();

        public C28351() {
            super(0, EmittableArcProgressIndicator.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EmittableArcProgressIndicator invoke() {
            return new EmittableArcProgressIndicator();
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
    /* JADX WARN: Removed duplicated region for block: B:89:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ArcProgressIndicator(@FloatRange(from = 0.0d, m705to = 1.0d) final float f, @Nullable GlanceModifier glanceModifier, @Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, @Nullable ContentScale contentScale, @Nullable Bundle bundle, @Nullable Composer composer, final int i, final int i2) {
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
        Composer composerStartRestartGroup = composer.startRestartGroup(-576988386);
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
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
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
                } else {
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
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-576988386, i4, -1, "androidx.glance.appwidget.ArcProgressIndicator (ArcProgressIndicator.kt:43)");
                }
                final C28351 c28351 = C28351.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(new Function0<EmittableArcProgressIndicator>() { // from class: androidx.glance.appwidget.ArcProgressIndicatorKt$ArcProgressIndicator$$inlined$GlanceNode$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.glance.appwidget.EmittableArcProgressIndicator, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final EmittableArcProgressIndicator invoke() {
                            return c28351.invoke();
                        }
                    });
                }
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier2, new Function2<EmittableArcProgressIndicator, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.ArcProgressIndicatorKt$ArcProgressIndicator$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableArcProgressIndicator emittableArcProgressIndicator, GlanceModifier glanceModifier4) {
                        invoke2(emittableArcProgressIndicator, glanceModifier4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableArcProgressIndicator set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, Float.valueOf(f), new Function2<EmittableArcProgressIndicator, Float, Unit>() { // from class: androidx.glance.appwidget.ArcProgressIndicatorKt$ArcProgressIndicator$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableArcProgressIndicator emittableArcProgressIndicator, Float f4) {
                        invoke(emittableArcProgressIndicator, f4.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableArcProgressIndicator set, float f4) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setProgress(f4);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, indicatorColorProvider, new Function2<EmittableArcProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.ArcProgressIndicatorKt$ArcProgressIndicator$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableArcProgressIndicator emittableArcProgressIndicator, ColorProvider colorProvider5) {
                        invoke2(emittableArcProgressIndicator, colorProvider5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableArcProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, indicatorColorProvider2, new Function2<EmittableArcProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.ArcProgressIndicatorKt$ArcProgressIndicator$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableArcProgressIndicator emittableArcProgressIndicator, ColorProvider colorProvider5) {
                        invoke2(emittableArcProgressIndicator, colorProvider5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableArcProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setBackgroundColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, bundle2, new Function2<EmittableArcProgressIndicator, Bundle, Unit>() { // from class: androidx.glance.appwidget.ArcProgressIndicatorKt$ArcProgressIndicator$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableArcProgressIndicator emittableArcProgressIndicator, Bundle bundle4) {
                        invoke2(emittableArcProgressIndicator, bundle4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableArcProgressIndicator set, @Nullable Bundle bundle4) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setProgressDrawable(bundle4);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, contentScale3, new Function2<EmittableArcProgressIndicator, ContentScale, Unit>() { // from class: androidx.glance.appwidget.ArcProgressIndicatorKt$ArcProgressIndicator$2$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableArcProgressIndicator emittableArcProgressIndicator, ContentScale contentScale5) {
                        invoke2(emittableArcProgressIndicator, contentScale5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableArcProgressIndicator set, @NotNull ContentScale it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setContentScale(ContentScale.Small);
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.ArcProgressIndicatorKt.ArcProgressIndicator.3
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
                        ArcProgressIndicatorKt.ArcProgressIndicator(f, glanceModifier3, colorProvider4, colorProvider3, contentScale4, bundle3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
            if ((i & 1) != 0) {
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
                final Function0 c283512 = C28351.INSTANCE;
                if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                }
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, glanceModifier2, new Function2<EmittableArcProgressIndicator, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.ArcProgressIndicatorKt$ArcProgressIndicator$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableArcProgressIndicator emittableArcProgressIndicator, GlanceModifier glanceModifier4) {
                        invoke2(emittableArcProgressIndicator, glanceModifier4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableArcProgressIndicator set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, Float.valueOf(f), new Function2<EmittableArcProgressIndicator, Float, Unit>() { // from class: androidx.glance.appwidget.ArcProgressIndicatorKt$ArcProgressIndicator$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableArcProgressIndicator emittableArcProgressIndicator, Float f4) {
                        invoke(emittableArcProgressIndicator, f4.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull EmittableArcProgressIndicator set, float f4) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setProgress(f4);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, indicatorColorProvider, new Function2<EmittableArcProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.ArcProgressIndicatorKt$ArcProgressIndicator$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableArcProgressIndicator emittableArcProgressIndicator, ColorProvider colorProvider5) {
                        invoke2(emittableArcProgressIndicator, colorProvider5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableArcProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, indicatorColorProvider2, new Function2<EmittableArcProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.ArcProgressIndicatorKt$ArcProgressIndicator$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableArcProgressIndicator emittableArcProgressIndicator, ColorProvider colorProvider5) {
                        invoke2(emittableArcProgressIndicator, colorProvider5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableArcProgressIndicator set, @NotNull ColorProvider it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setBackgroundColor(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, bundle2, new Function2<EmittableArcProgressIndicator, Bundle, Unit>() { // from class: androidx.glance.appwidget.ArcProgressIndicatorKt$ArcProgressIndicator$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableArcProgressIndicator emittableArcProgressIndicator, Bundle bundle4) {
                        invoke2(emittableArcProgressIndicator, bundle4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableArcProgressIndicator set, @Nullable Bundle bundle4) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setProgressDrawable(bundle4);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, contentScale3, new Function2<EmittableArcProgressIndicator, ContentScale, Unit>() { // from class: androidx.glance.appwidget.ArcProgressIndicatorKt$ArcProgressIndicator$2$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableArcProgressIndicator emittableArcProgressIndicator, ContentScale contentScale5) {
                        invoke2(emittableArcProgressIndicator, contentScale5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableArcProgressIndicator set, @NotNull ContentScale it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setContentScale(ContentScale.Small);
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
