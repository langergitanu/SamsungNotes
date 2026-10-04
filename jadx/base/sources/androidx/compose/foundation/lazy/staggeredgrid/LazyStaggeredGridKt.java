package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.GraphicsContext;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.collection.MutableVector;
import com.google.android.gms.drive.DriveFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0089\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, m13886d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyStaggeredGrid-LJWHXA8", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZFFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyStaggeredGrid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyStaggeredGrid.kt\nandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Effects.kt\nandroidx/compose/runtime/EffectsKt\n+ 4 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 5 Effects.kt\nandroidx/compose/runtime/EffectsKt$rememberCoroutineScope$1\n+ 6 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,118:1\n149#2:119\n149#2:120\n149#2:121\n481#3:122\n480#3,4:123\n484#3,2:130\n488#3:136\n1225#4,3:127\n1228#4,3:133\n480#5:132\n77#6:137\n77#6:138\n*S KotlinDebug\n*F\n+ 1 LazyStaggeredGrid.kt\nandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridKt\n*L\n48#1:119\n56#1:120\n58#1:121\n63#1:122\n63#1:123,4\n63#1:130,2\n63#1:136\n63#1:127,3\n63#1:133,3\n63#1:132\n64#1:137\n94#1:138\n*E\n"})
public final class LazyStaggeredGridKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0100  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: LazyStaggeredGrid-LJWHXA8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16055LazyStaggeredGridLJWHXA8(@NotNull final LazyStaggeredGridState lazyStaggeredGridState, @NotNull final Orientation orientation, @NotNull final LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, @Nullable Modifier modifier, @Nullable PaddingValues paddingValues, boolean z, @Nullable FlingBehavior flingBehavior, boolean z2, float f, float f4, @NotNull final Function1<? super LazyStaggeredGridScope, Unit> function1, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        int i6;
        Modifier modifier2;
        int i7;
        PaddingValues paddingValues2;
        int i8;
        boolean z3;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        FlingBehavior flingBehavior2;
        int i16;
        float fM20968constructorimpl;
        boolean z4;
        FlingBehavior flingBehavior3;
        int i17;
        float f5;
        Modifier modifier3;
        PaddingValues paddingValues3;
        Object objRememberedValue;
        final boolean z5;
        final FlingBehavior flingBehavior4;
        Composer composer2;
        final Modifier modifier4;
        final PaddingValues paddingValues4;
        final float f6;
        final float f7;
        final boolean z6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(288295126);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 6) == 0) {
            i5 = (composerStartRestartGroup.changedInstance(lazyStaggeredGridState) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else {
            if ((i & 48) == 0) {
                i5 |= composerStartRestartGroup.changed(orientation) ? 32 : 16;
            }
            if ((i4 & 4) == 0) {
                i5 |= 384;
            } else if ((i & 384) == 0) {
                i5 |= (i & 512) == 0 ? composerStartRestartGroup.changed(lazyGridStaggeredGridSlotsProvider) : composerStartRestartGroup.changedInstance(lazyGridStaggeredGridSlotsProvider) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    modifier2 = modifier;
                    i5 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        paddingValues2 = paddingValues;
                        i5 |= composerStartRestartGroup.changed(paddingValues2) ? 16384 : 8192;
                    }
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= 196608;
                        z3 = z;
                    } else {
                        z3 = z;
                        if ((i & 196608) == 0) {
                            i5 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
                        }
                    }
                    if ((i & 1572864) == 0) {
                        i5 |= ((i4 & 64) == 0 && composerStartRestartGroup.changed(flingBehavior)) ? 1048576 : 524288;
                    }
                    i9 = i4 & 128;
                    if (i9 == 0) {
                        i5 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i5 |= composerStartRestartGroup.changed(z2) ? 8388608 : 4194304;
                    }
                    i10 = i4 & 256;
                    if (i10 == 0) {
                        i5 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i11 = i10;
                            i5 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
                        }
                        i12 = i4 & 512;
                        if (i12 == 0) {
                            if ((i & DriveFile.MODE_READ_WRITE) == 0) {
                                i13 = i12;
                                i5 |= composerStartRestartGroup.changed(f4) ? 536870912 : 268435456;
                            }
                            if ((i4 & 1024) == 0) {
                                i14 = i2 | 6;
                            } else if ((i2 & 6) == 0) {
                                i14 = i2 | (composerStartRestartGroup.changedInstance(function1) ? 4 : 2);
                            } else {
                                i14 = i2;
                            }
                            i15 = i5;
                            if ((i15 & 306783379) != 306783378 && (i14 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                flingBehavior4 = flingBehavior;
                                f7 = f4;
                                z5 = z3;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier2;
                                paddingValues4 = paddingValues2;
                                z6 = z2;
                                f6 = f;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier modifier5 = i6 == 0 ? Modifier.INSTANCE : modifier2;
                                    PaddingValues paddingValuesM15847PaddingValues0680j_4 = i7 == 0 ? PaddingKt.m15847PaddingValues0680j_4(C2256Dp.m20968constructorimpl(0)) : paddingValues2;
                                    if (i8 != 0) {
                                        z3 = false;
                                    }
                                    if ((i4 & 64) == 0) {
                                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                        i16 = i15 & (-3670017);
                                    } else {
                                        flingBehavior2 = flingBehavior;
                                        i16 = i15;
                                    }
                                    boolean z7 = i9 == 0 ? true : z2;
                                    float fM20968constructorimpl2 = i11 == 0 ? C2256Dp.m20968constructorimpl(0) : f;
                                    if (i13 == 0) {
                                        z4 = z7;
                                        fM20968constructorimpl = C2256Dp.m20968constructorimpl(0);
                                    } else {
                                        fM20968constructorimpl = f4;
                                        z4 = z7;
                                    }
                                    flingBehavior3 = flingBehavior2;
                                    i17 = i16;
                                    f5 = fM20968constructorimpl2;
                                    modifier3 = modifier5;
                                    paddingValues3 = paddingValuesM15847PaddingValues0680j_4;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i4 & 64) != 0) {
                                        flingBehavior3 = flingBehavior;
                                        z4 = z2;
                                        f5 = f;
                                        fM20968constructorimpl = f4;
                                        i17 = i15 & (-3670017);
                                    } else {
                                        flingBehavior3 = flingBehavior;
                                        z4 = z2;
                                        f5 = f;
                                        fM20968constructorimpl = f4;
                                        i17 = i15;
                                    }
                                    modifier3 = modifier2;
                                    paddingValues3 = paddingValues2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(288295126, i17, i14, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:60)");
                                }
                                int i18 = i17 & 14;
                                Function0<LazyStaggeredGridItemProvider> function0RememberStaggeredGridItemProviderLambda = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, function1, composerStartRestartGroup, ((i14 << 3) & 112) | i18);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup), composerStartRestartGroup);
                                }
                                int i19 = i17 >> 6;
                                int i20 = (i19 & 896) | i18;
                                int i21 = i19 & 7168;
                                int i22 = i17 >> 9;
                                int i23 = i20 | i21 | ((i17 << 9) & 57344) | (i22 & 458752) | (i22 & 3670016) | ((i17 << 18) & 234881024);
                                boolean z8 = z3;
                                int i24 = i17;
                                Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function2M16066rememberStaggeredGridMeasurePolicyqKj4JfE = LazyStaggeredGridMeasurePolicyKt.m16066rememberStaggeredGridMeasurePolicyqKj4JfE(lazyStaggeredGridState, function0RememberStaggeredGridItemProviderLambda, paddingValues3, z8, orientation, f5, fM20968constructorimpl, ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope(), lazyGridStaggeredGridSlotsProvider, (GraphicsContext) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), composerStartRestartGroup, i23);
                                PaddingValues paddingValues5 = paddingValues3;
                                float f8 = f5;
                                float f9 = fM20968constructorimpl;
                                int i25 = i24 >> 12;
                                boolean z9 = z4;
                                int i26 = i24 >> 3;
                                FlingBehavior flingBehavior5 = flingBehavior3;
                                LazyLayoutKt.LazyLayout(function0RememberStaggeredGridItemProviderLambda, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyStaggeredGridState.getRemeasurementModifier()).then(lazyStaggeredGridState.getAwaitLayoutModifier()), function0RememberStaggeredGridItemProviderLambda, LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, z8, composerStartRestartGroup, (i25 & 112) | i18), orientation, z9, z8, composerStartRestartGroup, ((i24 << 6) & 7168) | (i22 & 57344) | (i24 & 458752)), LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState, composerStartRestartGroup, i18), lazyStaggeredGridState.getBeyondBoundsInfo(), z8, (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation, z9, composerStartRestartGroup, (3670016 & i26) | (MutableVector.$stable << 6) | i21 | ((i24 << 12) & 458752)).then(lazyStaggeredGridState.getItemAnimator$foundation_release().getModifier()), lazyStaggeredGridState, orientation, z9, z8, flingBehavior5, lazyStaggeredGridState.getMutableInteractionSource(), null, composerStartRestartGroup, ((i24 << 3) & 1008) | (i25 & 7168) | (i26 & 57344) | (i26 & 458752), 64), lazyStaggeredGridState.getPrefetchState(), function2M16066rememberStaggeredGridMeasurePolicyqKj4JfE, composerStartRestartGroup, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z5 = z8;
                                flingBehavior4 = flingBehavior5;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                paddingValues4 = paddingValues5;
                                f6 = f8;
                                f7 = f9;
                                z6 = z9;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$LazyStaggeredGrid$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@Nullable Composer composer3, int i27) {
                                        LazyStaggeredGridKt.m16055LazyStaggeredGridLJWHXA8(lazyStaggeredGridState, orientation, lazyGridStaggeredGridSlotsProvider, modifier4, paddingValues4, z5, flingBehavior4, z6, f6, f7, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i4);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i5 |= DriveFile.MODE_READ_WRITE;
                        i13 = i12;
                        if ((i4 & 1024) == 0) {
                        }
                        i15 = i5;
                        if ((i15 & 306783379) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i6 == 0) {
                                }
                                if (i7 == 0) {
                                }
                                if (i8 != 0) {
                                }
                                if ((i4 & 64) == 0) {
                                }
                                if (i9 == 0) {
                                }
                                if (i11 == 0) {
                                }
                                if (i13 == 0) {
                                }
                                flingBehavior3 = flingBehavior2;
                                i17 = i16;
                                f5 = fM20968constructorimpl2;
                                modifier3 = modifier5;
                                paddingValues3 = paddingValuesM15847PaddingValues0680j_4;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i182 = i17 & 14;
                                Function0<LazyStaggeredGridItemProvider> function0RememberStaggeredGridItemProviderLambda2 = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, function1, composerStartRestartGroup, ((i14 << 3) & 112) | i182);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                }
                                int i192 = i17 >> 6;
                                int i202 = (i192 & 896) | i182;
                                int i212 = i192 & 7168;
                                int i222 = i17 >> 9;
                                int i232 = i202 | i212 | ((i17 << 9) & 57344) | (i222 & 458752) | (i222 & 3670016) | ((i17 << 18) & 234881024);
                                boolean z82 = z3;
                                int i242 = i17;
                                Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function2M16066rememberStaggeredGridMeasurePolicyqKj4JfE2 = LazyStaggeredGridMeasurePolicyKt.m16066rememberStaggeredGridMeasurePolicyqKj4JfE(lazyStaggeredGridState, function0RememberStaggeredGridItemProviderLambda2, paddingValues3, z82, orientation, f5, fM20968constructorimpl, ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope(), lazyGridStaggeredGridSlotsProvider, (GraphicsContext) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), composerStartRestartGroup, i232);
                                PaddingValues paddingValues52 = paddingValues3;
                                float f82 = f5;
                                float f92 = fM20968constructorimpl;
                                int i252 = i242 >> 12;
                                boolean z92 = z4;
                                int i262 = i242 >> 3;
                                FlingBehavior flingBehavior52 = flingBehavior3;
                                LazyLayoutKt.LazyLayout(function0RememberStaggeredGridItemProviderLambda2, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyStaggeredGridState.getRemeasurementModifier()).then(lazyStaggeredGridState.getAwaitLayoutModifier()), function0RememberStaggeredGridItemProviderLambda2, LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, z82, composerStartRestartGroup, (i252 & 112) | i182), orientation, z92, z82, composerStartRestartGroup, ((i242 << 6) & 7168) | (i222 & 57344) | (i242 & 458752)), LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState, composerStartRestartGroup, i182), lazyStaggeredGridState.getBeyondBoundsInfo(), z82, (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation, z92, composerStartRestartGroup, (3670016 & i262) | (MutableVector.$stable << 6) | i212 | ((i242 << 12) & 458752)).then(lazyStaggeredGridState.getItemAnimator$foundation_release().getModifier()), lazyStaggeredGridState, orientation, z92, z82, flingBehavior52, lazyStaggeredGridState.getMutableInteractionSource(), null, composerStartRestartGroup, ((i242 << 3) & 1008) | (i252 & 7168) | (i262 & 57344) | (i262 & 458752), 64), lazyStaggeredGridState.getPrefetchState(), function2M16066rememberStaggeredGridMeasurePolicyqKj4JfE2, composerStartRestartGroup, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                z5 = z82;
                                flingBehavior4 = flingBehavior52;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                paddingValues4 = paddingValues52;
                                f6 = f82;
                                f7 = f92;
                                z6 = z92;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i11 = i10;
                    i12 = i4 & 512;
                    if (i12 == 0) {
                    }
                    i13 = i12;
                    if ((i4 & 1024) == 0) {
                    }
                    i15 = i5;
                    if ((i15 & 306783379) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                paddingValues2 = paddingValues;
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                i9 = i4 & 128;
                if (i9 == 0) {
                }
                i10 = i4 & 256;
                if (i10 == 0) {
                }
                i11 = i10;
                i12 = i4 & 512;
                if (i12 == 0) {
                }
                i13 = i12;
                if ((i4 & 1024) == 0) {
                }
                i15 = i5;
                if ((i15 & 306783379) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            paddingValues2 = paddingValues;
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i9 = i4 & 128;
            if (i9 == 0) {
            }
            i10 = i4 & 256;
            if (i10 == 0) {
            }
            i11 = i10;
            i12 = i4 & 512;
            if (i12 == 0) {
            }
            i13 = i12;
            if ((i4 & 1024) == 0) {
            }
            i15 = i5;
            if ((i15 & 306783379) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i4 & 4) == 0) {
        }
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        modifier2 = modifier;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        paddingValues2 = paddingValues;
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i9 = i4 & 128;
        if (i9 == 0) {
        }
        i10 = i4 & 256;
        if (i10 == 0) {
        }
        i11 = i10;
        i12 = i4 & 512;
        if (i12 == 0) {
        }
        i13 = i12;
        if ((i4 & 1024) == 0) {
        }
        i15 = i5;
        if ((i15 & 306783379) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
