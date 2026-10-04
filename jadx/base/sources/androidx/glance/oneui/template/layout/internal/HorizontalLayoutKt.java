package androidx.glance.oneui.template.layout.internal;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpKt;
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
import androidx.glance.BackgroundKt;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.FuturePublicApi;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.EmittableRow;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.WeightValue;
import androidx.glance.oneui.template.component.padding.Padding;
import androidx.glance.oneui.template.component.padding.PaddingKt;
import androidx.glance.oneui.template.utils.SizeUtilsKt;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH\u0003ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aL\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132)\u0010\b\u001a%\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u000b0\u00150\u0014H\u0001¢\u0006\u0002\u0010\u0018\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, m13886d2 = {"HorizontalLayout", "", "modifier", "Landroidx/glance/GlanceModifier;", "horizontalAlignment", "Landroidx/glance/layout/Alignment$Horizontal;", "verticalAlignment", "Landroidx/glance/layout/Alignment$Vertical;", "content", "Lkotlin/Function1;", "Landroidx/glance/oneui/template/layout/internal/HorizontalScopeImplInstance;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalLayout-lMAjyxE", "(Landroidx/glance/GlanceModifier;IILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "HorizontalRatioLayout", "padding", "Landroidx/glance/oneui/template/component/padding/Padding;", "backgroundColor", "Landroidx/glance/unit/ColorProvider;", "", "Lkotlin/Triple;", "Landroidx/glance/layout/WeightValue;", "Lkotlin/Function0;", "(Landroidx/glance/oneui/template/component/padding/Padding;Landroidx/glance/unit/ColorProvider;Ljava/util/List;Landroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHorizontalLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HorizontalLayout.kt\nandroidx/glance/oneui/template/layout/internal/HorizontalLayoutKt\n+ 2 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,112:1\n43#2:113\n44#2:125\n325#3,11:114\n*S KotlinDebug\n*F\n+ 1 HorizontalLayout.kt\nandroidx/glance/oneui/template/layout/internal/HorizontalLayoutKt\n*L\n61#1:113\n61#1:125\n61#1:114,11\n*E\n"})
public final class HorizontalLayoutKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0116  */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* JADX INFO: renamed from: HorizontalLayout-lMAjyxE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21873HorizontalLayoutlMAjyxE(GlanceModifier glanceModifier, int i, int i2, final Function3<? super HorizontalScopeImplInstance, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i4, final int i5) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(1201438136);
        int i7 = i5 & 1;
        if (i7 != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i6 = (composerStartRestartGroup.changed(glanceModifier) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 112) == 0) {
            i6 |= ((i5 & 2) == 0 && composerStartRestartGroup.changed(i)) ? 32 : 16;
        }
        if ((i4 & 896) == 0) {
            i6 |= ((i5 & 4) == 0 && composerStartRestartGroup.changed(i2)) ? 256 : 128;
        }
        if ((i5 & 8) != 0) {
            i6 |= 3072;
        } else if ((i4 & 7168) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i6 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i4 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i7 != 0) {
                    glanceModifier = GlanceModifier.INSTANCE;
                }
                if ((i5 & 2) != 0) {
                    i = Alignment.INSTANCE.m21433getStartPGIyAqw();
                    i6 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                if ((i5 & 4) != 0) {
                    i2 = Alignment.INSTANCE.m21434getTopmnfRV0w();
                    i6 &= -897;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1201438136, i6, -1, "androidx.glance.oneui.template.layout.internal.HorizontalLayout (HorizontalLayout.kt:59)");
                }
                HorizontalLayoutKt$HorizontalLayout$1 horizontalLayoutKt$HorizontalLayout$1 = HorizontalLayoutKt$HorizontalLayout$1.INSTANCE;
                if (!(AbstractC2322a.m1613c(578571862, composerStartRestartGroup, -548224868) instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(horizontalLayoutKt$HorizontalLayout$1);
                }
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier, new Function2<EmittableRow, GlanceModifier, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.HorizontalLayoutKt$HorizontalLayout$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableRow emittableRow, GlanceModifier glanceModifier2) {
                        invoke2(emittableRow, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableRow set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, Alignment.Vertical.m21445boximpl(i2), new Function2<EmittableRow, Alignment.Vertical, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.HorizontalLayoutKt$HorizontalLayout$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableRow emittableRow, Alignment.Vertical vertical) {
                        m21875invokeUKyfEZk(emittableRow, vertical.getValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-UKyfEZk, reason: not valid java name */
                    public final void m21875invokeUKyfEZk(@NotNull EmittableRow set, int i8) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.m21475setVerticalAlignmentJe2gTW8(i8);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, Alignment.Horizontal.m21435boximpl(i), new Function2<EmittableRow, Alignment.Horizontal, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.HorizontalLayoutKt$HorizontalLayout$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableRow emittableRow, Alignment.Horizontal horizontal) {
                        m21876invokeh_Kf0XE(emittableRow, horizontal.getValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-h_Kf0XE, reason: not valid java name */
                    public final void m21876invokeh_Kf0XE(@NotNull EmittableRow set, int i8) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.m21474setHorizontalAlignmentuMT220(i8);
                    }
                });
                function3.invoke(HorizontalScopeImplInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i6 >> 6) & 112) | 6));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i5 & 2) != 0) {
                    i6 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                if ((i5 & 4) != 0) {
                    i6 &= -897;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                HorizontalLayoutKt$HorizontalLayout$1 horizontalLayoutKt$HorizontalLayout$12 = HorizontalLayoutKt$HorizontalLayout$1.INSTANCE;
                if (!(AbstractC2322a.m1613c(578571862, composerStartRestartGroup, -548224868) instanceof Applier)) {
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                }
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, glanceModifier, new Function2<EmittableRow, GlanceModifier, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.HorizontalLayoutKt$HorizontalLayout$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableRow emittableRow, GlanceModifier glanceModifier2) {
                        invoke2(emittableRow, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableRow set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, Alignment.Vertical.m21445boximpl(i2), new Function2<EmittableRow, Alignment.Vertical, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.HorizontalLayoutKt$HorizontalLayout$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableRow emittableRow, Alignment.Vertical vertical) {
                        m21875invokeUKyfEZk(emittableRow, vertical.getValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-UKyfEZk, reason: not valid java name */
                    public final void m21875invokeUKyfEZk(@NotNull EmittableRow set, int i8) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.m21475setVerticalAlignmentJe2gTW8(i8);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, Alignment.Horizontal.m21435boximpl(i), new Function2<EmittableRow, Alignment.Horizontal, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.HorizontalLayoutKt$HorizontalLayout$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableRow emittableRow, Alignment.Horizontal horizontal) {
                        m21876invokeh_Kf0XE(emittableRow, horizontal.getValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-h_Kf0XE, reason: not valid java name */
                    public final void m21876invokeh_Kf0XE(@NotNull EmittableRow set, int i8) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.m21474setHorizontalAlignmentuMT220(i8);
                    }
                });
                function3.invoke(HorizontalScopeImplInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i6 >> 6) & 112) | 6));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        final int i8 = i;
        final int i9 = i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.HorizontalLayoutKt$HorizontalLayout$4
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

                public final void invoke(@Nullable Composer composer2, int i10) {
                    HorizontalLayoutKt.m21873HorizontalLayoutlMAjyxE(glanceModifier2, i8, i9, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    @Composable
    @FuturePublicApi
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void HorizontalRatioLayout(@Nullable Padding padding, @Nullable ColorProvider colorProvider, @NotNull final List<? extends Triple<WeightValue, Padding, ? extends Function2<? super Composer, ? super Integer, Unit>>> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1841682536);
        if ((i2 & 1) != 0) {
            padding = Padding.INSTANCE.getNone();
            i4 = i & (-15);
        } else {
            i4 = i;
        }
        final Padding padding2 = padding;
        if ((i2 & 2) != 0) {
            colorProvider = ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU());
            i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
        }
        final ColorProvider colorProvider2 = colorProvider;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1841682536, i4, -1, "androidx.glance.oneui.template.layout.internal.HorizontalRatioLayout (HorizontalLayout.kt:86)");
        }
        CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalSize().provides(DpSize.m21054boximpl(SizeUtilsKt.m21968getLocalSizeWithoutPaddingeVKgIn8(padding2, 0L, composerStartRestartGroup, i4 & 14, 2))), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 736230488, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.HorizontalLayoutKt.HorizontalRatioLayout.1
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
            public final void invoke(@Nullable Composer composer2, int i5) {
                if ((i5 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(736230488, i5, -1, "androidx.glance.oneui.template.layout.internal.HorizontalRatioLayout.<anonymous> (HorizontalLayout.kt:88)");
                }
                GlanceModifier glanceModifierPadding = PaddingKt.padding(BackgroundKt.background(SizeModifiersKt.fillMaxSize(GlanceModifier.INSTANCE), colorProvider2), padding2, composer2, 0);
                final List<Triple<WeightValue, Padding, Function2<Composer, Integer, Unit>>> list = content;
                HorizontalLayoutKt.m21873HorizontalLayoutlMAjyxE(glanceModifierPadding, 0, 0, ComposableLambdaKt.composableLambda(composer2, 2102557261, true, new Function3<HorizontalScopeImplInstance, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.HorizontalLayoutKt.HorizontalRatioLayout.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(HorizontalScopeImplInstance horizontalScopeImplInstance, Composer composer3, Integer num) {
                        invoke(horizontalScopeImplInstance, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(@NotNull HorizontalScopeImplInstance HorizontalLayout, @Nullable Composer composer3, int i6) {
                        int i7;
                        Composer composer4 = composer3;
                        Intrinsics.checkNotNullParameter(HorizontalLayout, "$this$HorizontalLayout");
                        if ((i6 & 14) == 0) {
                            i7 = i6 | (composer3.changed(HorizontalLayout) ? 4 : 2);
                        } else {
                            i7 = i6;
                        }
                        if ((i7 & 91) == 18 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2102557261, i7, -1, "androidx.glance.oneui.template.layout.internal.HorizontalRatioLayout.<anonymous>.<anonymous> (HorizontalLayout.kt:91)");
                        }
                        long packedValue = ((DpSize) composer3.consume(CompositionLocalsKt.getLocalSize())).getPackedValue();
                        List<Triple<WeightValue, Padding, Function2<Composer, Integer, Unit>>> list2 = list;
                        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list2));
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Integer.valueOf(((WeightValue) ((Triple) it.next()).getFirst()).getValue()));
                        }
                        Iterator it2 = arrayList.iterator();
                        int iIntValue = 0;
                        while (it2.hasNext()) {
                            iIntValue += ((Number) it2.next()).intValue();
                        }
                        Iterator<T> it3 = list.iterator();
                        while (it3.hasNext()) {
                            Triple triple = (Triple) it3.next();
                            WeightValue weightValue = (WeightValue) triple.component1();
                            final Padding padding3 = (Padding) triple.component2();
                            final Function2 function2 = (Function2) triple.component3();
                            final long jM20990DpSizeYgX7TsA = DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(packedValue) * weightValue.getValue()) / iIntValue), DpSize.m21064getHeightD9Ej5fM(packedValue));
                            FullLayoutKt.FullLayout(PaddingKt.padding(HorizontalLayout.weight(GlanceModifier.INSTANCE, weightValue), padding3, composer3, 0), null, ComposableLambdaKt.composableLambda(composer3, -1747891454, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.HorizontalLayoutKt$HorizontalRatioLayout$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @Composable
                                public final void invoke(@Nullable Composer composer5, int i8) {
                                    if ((i8 & 11) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1747891454, i8, -1, "androidx.glance.oneui.template.layout.internal.HorizontalRatioLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HorizontalLayout.kt:101)");
                                    }
                                    ProvidedValue<DpSize> providedValueProvides = CompositionLocalsKt.getLocalSize().provides(DpSize.m21054boximpl(SizeUtilsKt.m21968getLocalSizeWithoutPaddingeVKgIn8(padding3, jM20990DpSizeYgX7TsA, composer5, 0, 0)));
                                    final Function2<Composer, Integer, Unit> function22 = function2;
                                    CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.composableLambda(composer5, -1825227198, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.HorizontalLayoutKt$HorizontalRatioLayout$1$1$1$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                            invoke(composer6, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        @Composable
                                        public final void invoke(@Nullable Composer composer6, int i9) {
                                            if ((i9 & 11) == 2 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1825227198, i9, -1, "androidx.glance.oneui.template.layout.internal.HorizontalRatioLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HorizontalLayout.kt:104)");
                                            }
                                            if (AbstractC1038a.m1196A(composer6, 0, function22)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer5, ProvidedValue.$stable | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer4, 384, 2);
                            composer4 = composer3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composerStartRestartGroup, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.internal.HorizontalLayoutKt.HorizontalRatioLayout.2
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
                    HorizontalLayoutKt.HorizontalRatioLayout(padding2, colorProvider2, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
