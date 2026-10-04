package androidx.glance.appwidget;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.Applier;
import androidx.glance.appwidget.SizeMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, m13886d2 = {"ForEachSize", "", "sizeMode", "Landroidx/glance/appwidget/SizeMode;", "minSize", "Landroidx/compose/ui/unit/DpSize;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "ForEachSize-eVKgIn8", "(Landroidx/glance/appwidget/SizeMode;JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SizeBox", "size", "SizeBox-IbIYxLY", "(JLandroidx/glance/appwidget/SizeMode;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSizeBox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SizeBox.kt\nandroidx/glance/appwidget/SizeBoxKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,126:1\n74#2:127\n74#2:134\n74#2:136\n1116#3,6:128\n1#4:135\n1549#5:137\n1620#5,3:138\n1549#5:141\n1620#5,3:142\n*S KotlinDebug\n*F\n+ 1 SizeBox.kt\nandroidx/glance/appwidget/SizeBoxKt\n*L\n108#1:127\n110#1:134\n117#1:136\n108#1:128,6\n118#1:137\n118#1:138,3\n122#1:141\n122#1:142,3\n*E\n"})
public final class SizeBoxKt {
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* JADX INFO: renamed from: ForEachSize-eVKgIn8, reason: not valid java name */
    public static final void m21318ForEachSizeeVKgIn8(@NotNull final SizeMode sizeMode, final long j, @NotNull final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, final int i) {
        int i2;
        Set<DpSize> sizes;
        List<DpSize> listExtractAllSizes;
        Function2<? super Composer, ? super Integer, Unit> content = function2;
        Intrinsics.checkNotNullParameter(sizeMode, "sizeMode");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1526030150);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(sizeMode) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(content) ? 256 : 128;
        }
        int i4 = i2;
        if ((i4 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1526030150, i4, -1, "androidx.glance.appwidget.ForEachSize (SizeBox.kt:103)");
            }
            if (sizeMode instanceof SizeMode.Single) {
                composerStartRestartGroup.startReplaceableGroup(1209070159);
                composerStartRestartGroup.endReplaceableGroup();
                sizes = CollectionsKt.listOf(DpSize.m21054boximpl(j));
            } else if (sizeMode instanceof SizeMode.Exact) {
                composerStartRestartGroup.startReplaceableGroup(1209070204);
                if (Build.VERSION.SDK_INT >= 31) {
                    composerStartRestartGroup.startReplaceableGroup(1209070256);
                    Bundle bundle = (Bundle) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalAppWidgetOptions());
                    composerStartRestartGroup.startReplaceableGroup(-272429502);
                    boolean zChanged = composerStartRestartGroup.changed(j);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0<DpSize>() { // from class: androidx.glance.appwidget.SizeBoxKt$ForEachSize$sizes$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ DpSize invoke() {
                                return DpSize.m21054boximpl(m21320invokeMYxV2XQ());
                            }

                            /* JADX INFO: renamed from: invoke-MYxV2XQ, reason: not valid java name */
                            public final long m21320invokeMYxV2XQ() {
                                return j;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    listExtractAllSizes = AppWidgetUtilsKt.extractAllSizes(bundle, (Function0) objRememberedValue);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(1209070343);
                    List<DpSize> listExtractOrientationSizes = AppWidgetUtilsKt.extractOrientationSizes((Bundle) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalAppWidgetOptions()));
                    if (listExtractOrientationSizes.isEmpty()) {
                        listExtractOrientationSizes = CollectionsKt.listOf(DpSize.m21054boximpl(j));
                    }
                    listExtractAllSizes = listExtractOrientationSizes;
                    composerStartRestartGroup.endReplaceableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                sizes = listExtractAllSizes;
            } else {
                if (!(sizeMode instanceof SizeMode.Responsive)) {
                    composerStartRestartGroup.startReplaceableGroup(1209066450);
                    composerStartRestartGroup.endReplaceableGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceableGroup(1209070502);
                if (Build.VERSION.SDK_INT >= 31) {
                    sizes = ((SizeMode.Responsive) sizeMode).getSizes();
                } else {
                    SizeMode.Responsive responsive = (SizeMode.Responsive) sizeMode;
                    long packedValue = AppWidgetUtilsKt.sortedBySize(responsive.getSizes()).get(0).getPackedValue();
                    List<DpSize> listExtractOrientationSizes2 = AppWidgetUtilsKt.extractOrientationSizes((Bundle) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalAppWidgetOptions()));
                    ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(listExtractOrientationSizes2));
                    Iterator<T> it = listExtractOrientationSizes2.iterator();
                    while (it.hasNext()) {
                        DpSize dpSizeM21264findBestSizeitqla9I = AppWidgetUtilsKt.m21264findBestSizeitqla9I(((DpSize) it.next()).getPackedValue(), responsive.getSizes());
                        arrayList.add(DpSize.m21054boximpl(dpSizeM21264findBestSizeitqla9I != null ? dpSizeM21264findBestSizeitqla9I.getPackedValue() : packedValue));
                    }
                    boolean zIsEmpty = arrayList.isEmpty();
                    List listListOf = arrayList;
                    if (zIsEmpty) {
                        listListOf = CollectionsKt.listOf((Object[]) new DpSize[]{DpSize.m21054boximpl(packedValue), DpSize.m21054boximpl(packedValue)});
                    }
                    sizes = listListOf;
                }
                composerStartRestartGroup.endReplaceableGroup();
            }
            List listDistinct = CollectionsKt.distinct(sizes);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(listDistinct));
            Iterator it2 = listDistinct.iterator();
            while (it2.hasNext()) {
                m21319SizeBoxIbIYxLY(((DpSize) it2.next()).getPackedValue(), sizeMode, content, composerStartRestartGroup, (i4 & 896) | ((i4 << 3) & 112));
                arrayList2.add(Unit.INSTANCE);
                content = function2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.SizeBoxKt$ForEachSize$2
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

                public final void invoke(@Nullable Composer composer2, int i5) {
                    SizeBoxKt.m21318ForEachSizeeVKgIn8(sizeMode, j, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* JADX INFO: renamed from: SizeBox-IbIYxLY, reason: not valid java name */
    public static final void m21319SizeBoxIbIYxLY(final long j, @NotNull final SizeMode sizeMode, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(sizeMode, "sizeMode");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-53921383);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(sizeMode) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(content) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-53921383, i2, -1, "androidx.glance.appwidget.SizeBox (SizeBox.kt:81)");
            }
            CompositionLocalKt.CompositionLocalProvider(androidx.glance.CompositionLocalsKt.getLocalSize().provides(DpSize.m21054boximpl(j)), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1209815847, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.SizeBoxKt$SizeBox$1

                /* JADX INFO: renamed from: androidx.glance.appwidget.SizeBoxKt$SizeBox$1$1 */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
                public /* synthetic */ class C29111 extends FunctionReferenceImpl implements Function0<EmittableSizeBox> {
                    public static final C29111 INSTANCE = new C29111();

                    public C29111() {
                        super(0, EmittableSizeBox.class, "<init>", "<init>()V", 0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final EmittableSizeBox invoke() {
                        return new EmittableSizeBox();
                    }
                }

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

                @Composable
                public final void invoke(@Nullable Composer composer2, int i4) {
                    if ((i4 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1209815847, i4, -1, "androidx.glance.appwidget.SizeBox.<anonymous> (SizeBox.kt:83)");
                    }
                    C29111 c29111 = C29111.INSTANCE;
                    long j2 = j;
                    SizeMode sizeMode2 = sizeMode;
                    Function2<Composer, Integer, Unit> function2 = content;
                    if (!(AbstractC2322a.m1613c(578571862, composer2, -548224868) instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(c29111);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                    Updater.m18025setimpl(composerM18018constructorimpl, DpSize.m21054boximpl(j2), new Function2<EmittableSizeBox, DpSize, Unit>() { // from class: androidx.glance.appwidget.SizeBoxKt$SizeBox$1$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(EmittableSizeBox emittableSizeBox, DpSize dpSize) {
                            m21321invoke6HolHcs(emittableSizeBox, dpSize.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-6HolHcs, reason: not valid java name */
                        public final void m21321invoke6HolHcs(@NotNull EmittableSizeBox set, long j3) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            set.m21288setSizeEaSLcWc(j3);
                        }
                    });
                    Updater.m18025setimpl(composerM18018constructorimpl, sizeMode2, new Function2<EmittableSizeBox, SizeMode, Unit>() { // from class: androidx.glance.appwidget.SizeBoxKt$SizeBox$1$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(EmittableSizeBox emittableSizeBox, SizeMode sizeMode3) {
                            invoke2(emittableSizeBox, sizeMode3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull EmittableSizeBox set, @NotNull SizeMode it) {
                            Intrinsics.checkNotNullParameter(set, "$this$set");
                            Intrinsics.checkNotNullParameter(it, "it");
                            set.setSizeMode(it);
                        }
                    });
                    function2.invoke(composer2, 0);
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.SizeBoxKt$SizeBox$2
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

                public final void invoke(@Nullable Composer composer2, int i4) {
                    SizeBoxKt.m21319SizeBoxIbIYxLY(j, sizeMode, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
