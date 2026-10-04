package androidx.glance.appwidget;

import android.widget.RemoteViews;
import androidx.annotation.IdRes;
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
@Metadata(m13885d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a<\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, m13886d2 = {"AndroidRemoteViews", "", "remoteViews", "Landroid/widget/RemoteViews;", "modifier", "Landroidx/glance/GlanceModifier;", "(Landroid/widget/RemoteViews;Landroidx/glance/GlanceModifier;Landroidx/compose/runtime/Composer;II)V", "containerViewId", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroid/widget/RemoteViews;ILandroidx/glance/GlanceModifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidRemoteViews.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidRemoteViews.kt\nandroidx/glance/appwidget/AndroidRemoteViewsKt\n+ 2 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 4 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,92:1\n43#2:93\n44#2:111\n325#3,8:94\n333#3,3:108\n3737#4,6:102\n*S KotlinDebug\n*F\n+ 1 AndroidRemoteViews.kt\nandroidx/glance/appwidget/AndroidRemoteViewsKt\n*L\n60#1:93\n60#1:111\n60#1:94,8\n60#1:108,3\n64#1:102,6\n*E\n"})
public final class AndroidRemoteViewsKt {

    /* JADX INFO: renamed from: androidx.glance.appwidget.AndroidRemoteViewsKt$AndroidRemoteViews$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class C28232 extends FunctionReferenceImpl implements Function0<EmittableAndroidRemoteViews> {
        public static final C28232 INSTANCE = new C28232();

        public C28232() {
            super(0, EmittableAndroidRemoteViews.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EmittableAndroidRemoteViews invoke() {
            return new EmittableAndroidRemoteViews();
        }
    }

    @Composable
    public static final void AndroidRemoteViews(@NotNull final RemoteViews remoteViews, @Nullable GlanceModifier glanceModifier, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Composer composerStartRestartGroup = composer.startRestartGroup(-647353345);
        if ((i2 & 2) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-647353345, i, -1, "androidx.glance.appwidget.AndroidRemoteViews (AndroidRemoteViews.kt:37)");
        }
        AndroidRemoteViews(remoteViews, -1, glanceModifier2, ComposableSingletons$AndroidRemoteViewsKt.INSTANCE.m21278getLambda1$glance_appwidget_release(), composerStartRestartGroup, ((i << 3) & 896) | 3128, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.AndroidRemoteViewsKt.AndroidRemoteViews.1
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
                    AndroidRemoteViewsKt.AndroidRemoteViews(remoteViews, glanceModifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void AndroidRemoteViews(@NotNull final RemoteViews remoteViews, @IdRes final int i, @Nullable GlanceModifier glanceModifier, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1388408952);
        if ((i4 & 4) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1388408952, i2, -1, "androidx.glance.appwidget.AndroidRemoteViews (AndroidRemoteViews.kt:58)");
        }
        C28232 c28232 = C28232.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(578571862);
        int i5 = (i2 >> 3) & 896;
        composerStartRestartGroup.startReplaceableGroup(-548224868);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(c28232);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, remoteViews, new Function2<EmittableAndroidRemoteViews, RemoteViews, Unit>() { // from class: androidx.glance.appwidget.AndroidRemoteViewsKt$AndroidRemoteViews$3$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableAndroidRemoteViews emittableAndroidRemoteViews, RemoteViews remoteViews2) {
                invoke2(emittableAndroidRemoteViews, remoteViews2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableAndroidRemoteViews set, @NotNull RemoteViews it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setRemoteViews(it);
            }
        });
        AndroidRemoteViewsKt$AndroidRemoteViews$3$2 androidRemoteViewsKt$AndroidRemoteViews$3$2 = new Function2<EmittableAndroidRemoteViews, Integer, Unit>() { // from class: androidx.glance.appwidget.AndroidRemoteViewsKt$AndroidRemoteViews$3$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableAndroidRemoteViews emittableAndroidRemoteViews, Integer num) {
                invoke(emittableAndroidRemoteViews, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull EmittableAndroidRemoteViews set, int i6) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setContainerViewId(i6);
            }
        };
        if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(i))) {
            composerM18018constructorimpl.updateRememberedValue(Integer.valueOf(i));
            composerM18018constructorimpl.apply(Integer.valueOf(i), androidRemoteViewsKt$AndroidRemoteViews$3$2);
        }
        Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier2, new Function2<EmittableAndroidRemoteViews, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.AndroidRemoteViewsKt$AndroidRemoteViews$3$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableAndroidRemoteViews emittableAndroidRemoteViews, GlanceModifier glanceModifier3) {
                invoke2(emittableAndroidRemoteViews, glanceModifier3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableAndroidRemoteViews set, @NotNull GlanceModifier it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setModifier(it);
            }
        });
        content.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 6) & 14));
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.AndroidRemoteViewsKt.AndroidRemoteViews.4
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

                public final void invoke(@Nullable Composer composer2, int i6) {
                    AndroidRemoteViewsKt.AndroidRemoteViews(remoteViews, i, glanceModifier2, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }
}
