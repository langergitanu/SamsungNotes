package androidx.glance.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.Applier;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.Alignment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aN\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, m13886d2 = {"Column", "", "modifier", "Landroidx/glance/GlanceModifier;", "verticalAlignment", "Landroidx/glance/layout/Alignment$Vertical;", "horizontalAlignment", "Landroidx/glance/layout/Alignment$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/glance/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Column-K4GKKTE", "(Landroidx/glance/GlanceModifier;IILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nColumn.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Column.kt\nandroidx/glance/layout/ColumnKt\n+ 2 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,99:1\n43#2:100\n44#2:112\n325#3,11:101\n*S KotlinDebug\n*F\n+ 1 Column.kt\nandroidx/glance/layout/ColumnKt\n*L\n89#1:100\n89#1:112\n89#1:101,11\n*E\n"})
public final class ColumnKt {
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* JADX INFO: renamed from: Column-K4GKKTE, reason: not valid java name */
    public static final void m21455ColumnK4GKKTE(@Nullable GlanceModifier glanceModifier, int i, int i2, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i4, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1883910253);
        int i7 = i5 & 1;
        if (i7 != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i6 = (composerStartRestartGroup.changed(glanceModifier) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i8 = i5 & 2;
        if (i8 != 0) {
            i6 |= 48;
        } else if ((i4 & 112) == 0) {
            i6 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        int i9 = i5 & 4;
        if (i9 != 0) {
            i6 |= 384;
        } else if ((i4 & 896) == 0) {
            i6 |= composerStartRestartGroup.changed(i2) ? 256 : 128;
        }
        if ((i5 & 8) != 0) {
            i6 |= 3072;
        } else if ((i4 & 7168) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(content) ? 2048 : 1024;
        }
        if ((i6 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i7 != 0) {
                glanceModifier = GlanceModifier.INSTANCE;
            }
            if (i8 != 0) {
                i = Alignment.INSTANCE.m21434getTopmnfRV0w();
            }
            if (i9 != 0) {
                i2 = Alignment.INSTANCE.m21433getStartPGIyAqw();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1883910253, i6, -1, "androidx.glance.layout.Column (Column.kt:87)");
            }
            ColumnKt$Column$1 columnKt$Column$1 = ColumnKt$Column$1.INSTANCE;
            if (!(AbstractC2322a.m1613c(578571862, composerStartRestartGroup, -548224868) instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(columnKt$Column$1);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier, new Function2<EmittableColumn, GlanceModifier, Unit>() { // from class: androidx.glance.layout.ColumnKt$Column$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(EmittableColumn emittableColumn, GlanceModifier glanceModifier2) {
                    invoke2(emittableColumn, glanceModifier2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull EmittableColumn set, @NotNull GlanceModifier it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    set.setModifier(it);
                }
            });
            Updater.m18025setimpl(composerM18018constructorimpl, Alignment.Horizontal.m21435boximpl(i2), new Function2<EmittableColumn, Alignment.Horizontal, Unit>() { // from class: androidx.glance.layout.ColumnKt$Column$2$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(EmittableColumn emittableColumn, Alignment.Horizontal horizontal) {
                    m21456invokeh_Kf0XE(emittableColumn, horizontal.getValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-h_Kf0XE, reason: not valid java name */
                public final void m21456invokeh_Kf0XE(@NotNull EmittableColumn set, int i10) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.m21470setHorizontalAlignmentuMT220(i10);
                }
            });
            Updater.m18025setimpl(composerM18018constructorimpl, Alignment.Vertical.m21445boximpl(i), new Function2<EmittableColumn, Alignment.Vertical, Unit>() { // from class: androidx.glance.layout.ColumnKt$Column$2$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(EmittableColumn emittableColumn, Alignment.Vertical vertical) {
                    m21457invokeUKyfEZk(emittableColumn, vertical.getValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-UKyfEZk, reason: not valid java name */
                public final void m21457invokeUKyfEZk(@NotNull EmittableColumn set, int i10) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.m21471setVerticalAlignmentJe2gTW8(i10);
                }
            });
            content.invoke(ColumnScopeImplInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i6 >> 6) & 112) | 6));
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        final int i10 = i;
        final int i11 = i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.layout.ColumnKt$Column$4
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

                public final void invoke(@Nullable Composer composer2, int i12) {
                    ColumnKt.m21455ColumnK4GKKTE(glanceModifier2, i10, i11, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }
}
