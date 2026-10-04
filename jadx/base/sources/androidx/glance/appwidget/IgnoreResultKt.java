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
import androidx.glance.Emittable;
import androidx.glance.EmittableWithChildren;
import androidx.glance.GlanceComposable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0007¨\u0006\u0006"}, m13886d2 = {"IgnoreResult", "", "(Landroidx/compose/runtime/Composer;I)V", "shouldIgnoreResult", "", "Landroidx/glance/Emittable;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nIgnoreResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IgnoreResult.kt\nandroidx/glance/appwidget/IgnoreResultKt\n+ 2 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,61:1\n33#2:62\n34#2:73\n251#3,10:63\n1747#4,3:74\n*S KotlinDebug\n*F\n+ 1 IgnoreResult.kt\nandroidx/glance/appwidget/IgnoreResultKt\n*L\n38#1:62\n38#1:73\n38#1:63,10\n57#1:74,3\n*E\n"})
public final class IgnoreResultKt {

    /* JADX INFO: renamed from: androidx.glance.appwidget.IgnoreResultKt$IgnoreResult$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class C28681 extends FunctionReferenceImpl implements Function0<EmittableIgnoreResult> {
        public static final C28681 INSTANCE = new C28681();

        public C28681() {
            super(0, EmittableIgnoreResult.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EmittableIgnoreResult invoke() {
            return new EmittableIgnoreResult();
        }
    }

    @Composable
    @GlanceComposable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void IgnoreResult(@Nullable Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1257244356);
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1257244356, i, -1, "androidx.glance.appwidget.IgnoreResult (IgnoreResult.kt:36)");
            }
            final C28681 c28681 = C28681.INSTANCE;
            if (!(AbstractC2322a.m1613c(-1115894518, composerStartRestartGroup, 1886828752) instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(new Function0<EmittableIgnoreResult>() { // from class: androidx.glance.appwidget.IgnoreResultKt$IgnoreResult$$inlined$GlanceNode$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.glance.appwidget.EmittableIgnoreResult, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final EmittableIgnoreResult invoke() {
                        return c28681.invoke();
                    }
                });
            } else {
                composerStartRestartGroup.useNode();
            }
            Updater.m18018constructorimpl(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.IgnoreResultKt.IgnoreResult.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    IgnoreResultKt.IgnoreResult(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean shouldIgnoreResult(@NotNull Emittable emittable) {
        Intrinsics.checkNotNullParameter(emittable, "<this>");
        if (emittable instanceof EmittableIgnoreResult) {
            return true;
        }
        if (!(emittable instanceof EmittableWithChildren)) {
            return false;
        }
        List<Emittable> children = ((EmittableWithChildren) emittable).getChildren();
        if ((children instanceof Collection) && children.isEmpty()) {
            return false;
        }
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            if (shouldIgnoreResult((Emittable) it.next())) {
                return true;
            }
        }
        return false;
    }
}
