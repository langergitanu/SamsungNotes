package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.GraphicsContext;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.ConstraintsKt;
import androidx.compose.p109ui.unit.IntOffsetKt;
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
import androidx.compose.runtime.snapshots.Snapshot;
import com.google.android.gms.drive.DriveFile;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u001bH\u0001¢\u0006\u0002\u0010\u001c\u001a\u009a\u0001\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001e¢\u0006\u0002\b\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\tH\u0003¢\u0006\u0002\u0010*¨\u0006+"}, m13886d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyHeadersEnabled", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;ZLandroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyList.kt\nandroidx/compose/foundation/lazy/LazyListKt\n+ 2 Effects.kt\nandroidx/compose/runtime/EffectsKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 Effects.kt\nandroidx/compose/runtime/EffectsKt$rememberCoroutineScope$1\n+ 5 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,365:1\n481#2:366\n480#2,4:367\n484#2,2:374\n488#2:380\n1225#3,3:371\n1228#3,3:377\n1225#3,6:384\n480#4:376\n77#5:381\n77#5:382\n77#5:383\n*S KotlinDebug\n*F\n+ 1 LazyList.kt\nandroidx/compose/foundation/lazy/LazyListKt\n*L\n85#1:366\n85#1:367,4\n85#1:374,2\n85#1:380\n85#1:371,3\n85#1:377,3\n171#1:384,6\n85#1:376\n86#1:381\n87#1:382\n124#1:383\n*E\n"})
public final class LazyListKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0114  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyList(@NotNull final Modifier modifier, @NotNull final LazyListState lazyListState, @NotNull final PaddingValues paddingValues, final boolean z, final boolean z2, @NotNull final FlingBehavior flingBehavior, final boolean z3, int i, @Nullable Alignment.Horizontal horizontal, @Nullable Arrangement.Vertical vertical, @Nullable Alignment.Vertical vertical2, @Nullable Arrangement.Horizontal horizontal2, @NotNull final Function1<? super LazyListScope, Unit> function1, @Nullable Composer composer, final int i2, final int i4, final int i5) {
        int i6;
        PaddingValues paddingValues2;
        boolean z4;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Object objRememberedValue;
        final int i18;
        final Alignment.Horizontal horizontal3;
        final Arrangement.Vertical vertical3;
        final Alignment.Vertical vertical4;
        final Arrangement.Horizontal horizontal4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(620764179);
        if ((i5 & 1) != 0) {
            i6 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i6 = i2;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i2 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i5 & 4) != 0) {
            i6 |= 384;
        } else {
            if ((i2 & 384) == 0) {
                paddingValues2 = paddingValues;
                i6 |= composerStartRestartGroup.changed(paddingValues2) ? 256 : 128;
            }
            if ((i5 & 8) == 0) {
                i6 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    z4 = z;
                    i6 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                if ((i5 & 16) != 0) {
                    i6 |= 24576;
                } else if ((i2 & 24576) == 0) {
                    i6 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
                }
                if ((i5 & 32) != 0) {
                    i6 |= 196608;
                } else {
                    if ((i2 & 196608) == 0) {
                        i6 |= composerStartRestartGroup.changed(flingBehavior) ? 131072 : 65536;
                    }
                    if ((i5 & 64) == 0) {
                        i6 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i6 |= composerStartRestartGroup.changed(z3) ? 1048576 : 524288;
                    }
                    i7 = i5 & 128;
                    if (i7 == 0) {
                        i6 |= 12582912;
                        i8 = i;
                    } else {
                        i8 = i;
                        if ((i2 & 12582912) == 0) {
                            i6 |= composerStartRestartGroup.changed(i8) ? 8388608 : 4194304;
                        }
                    }
                    i9 = i5 & 256;
                    if (i9 == 0) {
                        i6 |= 100663296;
                    } else if ((i2 & 100663296) == 0) {
                        i6 |= composerStartRestartGroup.changed(horizontal) ? 67108864 : 33554432;
                    }
                    i10 = i5 & 512;
                    if (i10 != 0) {
                        if ((i2 & DriveFile.MODE_READ_WRITE) == 0) {
                            i11 = i10;
                            i6 |= composerStartRestartGroup.changed(vertical) ? 536870912 : 268435456;
                        }
                        i12 = i5 & 1024;
                        if (i12 != 0) {
                            i14 = i4 | 6;
                            i13 = i12;
                        } else if ((i4 & 6) == 0) {
                            i13 = i12;
                            i14 = i4 | (composerStartRestartGroup.changed(vertical2) ? 4 : 2);
                        } else {
                            i13 = i12;
                            i14 = i4;
                        }
                        i15 = i5 & 2048;
                        if (i15 != 0) {
                            i14 |= 48;
                            i16 = i15;
                        } else if ((i4 & 48) == 0) {
                            i16 = i15;
                            i14 |= composerStartRestartGroup.changed(horizontal2) ? 32 : 16;
                        } else {
                            i16 = i15;
                        }
                        i17 = i14;
                        if ((i5 & 4096) != 0) {
                            i17 |= 384;
                        } else if ((i4 & 384) == 0) {
                            i17 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
                        }
                        if ((306783379 & i6) == 306783378 && (i17 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            horizontal3 = horizontal;
                            vertical3 = vertical;
                            vertical4 = vertical2;
                            horizontal4 = horizontal2;
                            i18 = i8;
                        } else {
                            int i19 = i7 == 0 ? 0 : i8;
                            Alignment.Horizontal horizontal5 = i9 == 0 ? null : horizontal;
                            Arrangement.Vertical vertical5 = i11 == 0 ? null : vertical;
                            Alignment.Vertical vertical6 = i13 == 0 ? null : vertical2;
                            Arrangement.Horizontal horizontal6 = i16 == 0 ? horizontal2 : null;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(620764179, i6, i17, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                            }
                            int i20 = (i6 >> 3) & 14;
                            Function0<LazyListItemProvider> function0RememberLazyListItemProviderLambda = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, composerStartRestartGroup, i20 | ((i17 >> 3) & 112));
                            int i21 = i6 >> 9;
                            LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyListSemanticState = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, composerStartRestartGroup, i20 | (i21 & 112));
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            int i22 = i17;
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup), composerStartRestartGroup);
                            }
                            int i23 = i6 & 112;
                            int i24 = i6 & 7168;
                            int i25 = i6 >> 6;
                            int i26 = i22 << 21;
                            int i27 = (i6 & 65520) | (i25 & 458752) | (i25 & 3670016) | (i26 & 29360128) | (i26 & 234881024) | (i6 & 1879048192);
                            Arrangement.Vertical vertical7 = vertical5;
                            int i28 = i6;
                            Alignment.Horizontal horizontal7 = horizontal5;
                            boolean z5 = z4;
                            Alignment.Vertical vertical8 = vertical6;
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyListMeasurePolicy = rememberLazyListMeasurePolicy(function0RememberLazyListItemProviderLambda, lazyListState, paddingValues2, z5, z2, i19, horizontal7, vertical8, horizontal6, vertical7, ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope(), (GraphicsContext) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), !((Boolean) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalScrollCaptureInProgress())).booleanValue(), composerStartRestartGroup, i27, 0);
                            int i29 = i19;
                            Orientation orientation = !z2 ? Orientation.Vertical : Orientation.Horizontal;
                            Modifier modifierLazyLayoutSemantics = LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier()).then(lazyListState.getAwaitLayoutModifier()), function0RememberLazyListItemProviderLambda, lazyLayoutSemanticStateRememberLazyListSemanticState, orientation, z3, z, composerStartRestartGroup, (i25 & 57344) | ((i28 << 6) & 458752));
                            composerStartRestartGroup = composerStartRestartGroup;
                            Orientation orientation2 = orientation;
                            LazyLayoutKt.LazyLayout(function0RememberLazyListItemProviderLambda, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(modifierLazyLayoutSemantics, LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(lazyListState, i29, composerStartRestartGroup, i20 | ((i28 >> 18) & 112)), lazyListState.getBeyondBoundsInfo(), z, (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation2, z3, composerStartRestartGroup, (MutableVector.$stable << 6) | i24 | (i28 & 3670016)).then(lazyListState.getItemAnimator$foundation_release().getModifier()), lazyListState, orientation2, z3, z, flingBehavior, lazyListState.getInternalInteractionSource(), null, composerStartRestartGroup, i23 | (i21 & 7168) | (57344 & (i28 << 3)) | (i28 & 458752), 64), lazyListState.getPrefetchState(), function2RememberLazyListMeasurePolicy, composerStartRestartGroup, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i18 = i29;
                            horizontal3 = horizontal7;
                            vertical3 = vertical7;
                            vertical4 = vertical8;
                            horizontal4 = horizontal6;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt.LazyList.1
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

                                public final void invoke(@Nullable Composer composer2, int i30) {
                                    LazyListKt.LazyList(modifier, lazyListState, paddingValues, z, z2, flingBehavior, z3, i18, horizontal3, vertical3, vertical4, horizontal4, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i6 |= DriveFile.MODE_READ_WRITE;
                    i11 = i10;
                    i12 = i5 & 1024;
                    if (i12 != 0) {
                    }
                    i15 = i5 & 2048;
                    if (i15 != 0) {
                    }
                    i17 = i14;
                    if ((i5 & 4096) != 0) {
                    }
                    if ((306783379 & i6) == 306783378) {
                        if (i7 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        Arrangement.Horizontal horizontal62 = i16 == 0 ? horizontal2 : null;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i202 = (i6 >> 3) & 14;
                        Function0<LazyListItemProvider> function0RememberLazyListItemProviderLambda2 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, composerStartRestartGroup, i202 | ((i17 >> 3) & 112));
                        int i212 = i6 >> 9;
                        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyListSemanticState2 = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, composerStartRestartGroup, i202 | (i212 & 112));
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        int i222 = i17;
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        int i232 = i6 & 112;
                        int i242 = i6 & 7168;
                        int i252 = i6 >> 6;
                        int i262 = i222 << 21;
                        int i272 = (i6 & 65520) | (i252 & 458752) | (i252 & 3670016) | (i262 & 29360128) | (i262 & 234881024) | (i6 & 1879048192);
                        Arrangement.Vertical vertical72 = vertical5;
                        int i282 = i6;
                        Alignment.Horizontal horizontal72 = horizontal5;
                        boolean z52 = z4;
                        Alignment.Vertical vertical82 = vertical6;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyListMeasurePolicy2 = rememberLazyListMeasurePolicy(function0RememberLazyListItemProviderLambda2, lazyListState, paddingValues2, z52, z2, i19, horizontal72, vertical82, horizontal62, vertical72, ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope(), (GraphicsContext) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), !((Boolean) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalScrollCaptureInProgress())).booleanValue(), composerStartRestartGroup, i272, 0);
                        int i292 = i19;
                        if (!z2) {
                        }
                        Modifier modifierLazyLayoutSemantics2 = LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier()).then(lazyListState.getAwaitLayoutModifier()), function0RememberLazyListItemProviderLambda2, lazyLayoutSemanticStateRememberLazyListSemanticState2, orientation, z3, z, composerStartRestartGroup, (i252 & 57344) | ((i282 << 6) & 458752));
                        composerStartRestartGroup = composerStartRestartGroup;
                        Orientation orientation22 = orientation;
                        LazyLayoutKt.LazyLayout(function0RememberLazyListItemProviderLambda2, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(modifierLazyLayoutSemantics2, LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(lazyListState, i292, composerStartRestartGroup, i202 | ((i282 >> 18) & 112)), lazyListState.getBeyondBoundsInfo(), z, (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation22, z3, composerStartRestartGroup, (MutableVector.$stable << 6) | i242 | (i282 & 3670016)).then(lazyListState.getItemAnimator$foundation_release().getModifier()), lazyListState, orientation22, z3, z, flingBehavior, lazyListState.getInternalInteractionSource(), null, composerStartRestartGroup, i232 | (i212 & 7168) | (57344 & (i282 << 3)) | (i282 & 458752), 64), lazyListState.getPrefetchState(), function2RememberLazyListMeasurePolicy2, composerStartRestartGroup, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        i18 = i292;
                        horizontal3 = horizontal72;
                        vertical3 = vertical72;
                        vertical4 = vertical82;
                        horizontal4 = horizontal62;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                if ((i5 & 64) == 0) {
                }
                i7 = i5 & 128;
                if (i7 == 0) {
                }
                i9 = i5 & 256;
                if (i9 == 0) {
                }
                i10 = i5 & 512;
                if (i10 != 0) {
                }
                i11 = i10;
                i12 = i5 & 1024;
                if (i12 != 0) {
                }
                i15 = i5 & 2048;
                if (i15 != 0) {
                }
                i17 = i14;
                if ((i5 & 4096) != 0) {
                }
                if ((306783379 & i6) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z;
            if ((i5 & 16) != 0) {
            }
            if ((i5 & 32) != 0) {
            }
            if ((i5 & 64) == 0) {
            }
            i7 = i5 & 128;
            if (i7 == 0) {
            }
            i9 = i5 & 256;
            if (i9 == 0) {
            }
            i10 = i5 & 512;
            if (i10 != 0) {
            }
            i11 = i10;
            i12 = i5 & 1024;
            if (i12 != 0) {
            }
            i15 = i5 & 2048;
            if (i15 != 0) {
            }
            i17 = i14;
            if ((i5 & 4096) != 0) {
            }
            if ((306783379 & i6) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        paddingValues2 = paddingValues;
        if ((i5 & 8) == 0) {
        }
        z4 = z;
        if ((i5 & 16) != 0) {
        }
        if ((i5 & 32) != 0) {
        }
        if ((i5 & 64) == 0) {
        }
        i7 = i5 & 128;
        if (i7 == 0) {
        }
        i9 = i5 & 256;
        if (i9 == 0) {
        }
        i10 = i5 & 512;
        if (i10 != 0) {
        }
        i11 = i10;
        i12 = i5 & 1024;
        if (i12 != 0) {
        }
        i15 = i5 & 2048;
        if (i15 != 0) {
        }
        i17 = i14;
        if ((i5 & 4096) != 0) {
        }
        if ((306783379 & i6) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0075 A[PHI: r4
      0x0075: PHI (r4v17 boolean) = (r4v15 boolean), (r4v18 boolean) binds: [B:36:0x0073, B:32:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091 A[PHI: r9
      0x0091: PHI (r9v11 androidx.compose.ui.Alignment$Horizontal) = (r9v8 androidx.compose.ui.Alignment$Horizontal), (r9v12 androidx.compose.ui.Alignment$Horizontal) binds: [B:46:0x008f, B:42:0x0089] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ad A[PHI: r12
      0x00ad: PHI (r12v12 androidx.compose.ui.Alignment$Vertical) = (r12v9 androidx.compose.ui.Alignment$Vertical), (r12v13 androidx.compose.ui.Alignment$Vertical) binds: [B:56:0x00ab, B:52:0x00a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c9 A[PHI: r13
      0x00c9: PHI (r13v12 androidx.compose.foundation.layout.Arrangement$Horizontal) = 
      (r13v9 androidx.compose.foundation.layout.Arrangement$Horizontal)
      (r13v13 androidx.compose.foundation.layout.Arrangement$Horizontal)
     binds: [B:66:0x00c7, B:62:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e5 A[PHI: r14
      0x00e5: PHI (r14v12 androidx.compose.foundation.layout.Arrangement$Vertical) = 
      (r14v9 androidx.compose.foundation.layout.Arrangement$Vertical)
      (r14v13 androidx.compose.foundation.layout.Arrangement$Vertical)
     binds: [B:76:0x00e3, B:72:0x00dd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0137  */
    @Composable
    @ExperimentalFoundationApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(final Function0<? extends LazyListItemProvider> function0, final LazyListState lazyListState, final PaddingValues paddingValues, final boolean z, boolean z2, final int i, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Arrangement.Horizontal horizontal2, Arrangement.Vertical vertical2, final CoroutineScope coroutineScope, final GraphicsContext graphicsContext, final boolean z3, Composer composer, int i2, int i4) {
        boolean z4;
        boolean z5;
        Alignment.Horizontal horizontal3;
        boolean z6;
        Alignment.Vertical vertical3;
        boolean z7;
        Arrangement.Horizontal horizontal4;
        boolean z8;
        Arrangement.Vertical vertical4;
        boolean z9;
        boolean zChanged;
        Object objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1972347046, i2, i4, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:170)");
        }
        boolean z10 = ((((i2 & 112) ^ 48) > 32 && composer.changed(lazyListState)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(paddingValues)) || (i2 & 384) == 256) | ((((i2 & 7168) ^ 3072) > 2048 && composer.changed(z)) || (i2 & 3072) == 2048);
        if (((57344 & i2) ^ 24576) > 16384) {
            z4 = z2;
            if (composer.changed(z4)) {
                z5 = true;
            }
            boolean z11 = z10 | z5;
            if (((3670016 & i2) ^ 1572864) <= 1048576) {
                horizontal3 = horizontal;
                if (composer.changed(horizontal3)) {
                    z6 = true;
                }
                boolean z12 = z11 | z6;
                if (((29360128 & i2) ^ 12582912) > 8388608) {
                    vertical3 = vertical;
                    if (composer.changed(vertical3)) {
                        z7 = true;
                    }
                    boolean z13 = z12 | z7;
                    if (((234881024 & i2) ^ 100663296) <= 67108864) {
                        horizontal4 = horizontal2;
                        if (composer.changed(horizontal4)) {
                            z8 = true;
                        }
                        boolean z14 = z13 | z8;
                        if (((1879048192 & i2) ^ DriveFile.MODE_READ_WRITE) > 536870912) {
                            vertical4 = vertical2;
                            if (composer.changed(vertical4)) {
                                z9 = true;
                            }
                            zChanged = z9 | z14 | composer.changed(graphicsContext) | ((((i4 & 896) ^ 384) <= 256 && composer.changed(z3)) || (i4 & 384) == 256);
                            objRememberedValue = composer.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                final Arrangement.Vertical vertical5 = vertical4;
                                final Arrangement.Horizontal horizontal5 = horizontal4;
                                final Alignment.Horizontal horizontal6 = horizontal3;
                                final Alignment.Vertical vertical6 = vertical3;
                                final boolean z15 = z4;
                                Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult> function2 = new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                                        return m15956invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                                    }

                                    @NotNull
                                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                    public final LazyListMeasureResult m15956invoke0kLqBqw(@NotNull final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                                        float spacing;
                                        final long jIntOffset;
                                        ObservableScopeInvalidator.m16028attachToScopeimpl(lazyListState.m15971getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                                        boolean z16 = lazyListState.getHasLookaheadPassOccurred() || lazyLayoutMeasureScope.isLookingAhead();
                                        CheckScrollableContainerConstraintsKt.m15437checkScrollableContainerConstraintsK40F9xA(j, z15 ? Orientation.Vertical : Orientation.Horizontal);
                                        int iMo15540roundToPx0680j_4 = z15 ? lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.mo15805calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo15540roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                        int iMo15540roundToPx0680j_42 = z15 ? lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.mo15806calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo15540roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                        int iMo15540roundToPx0680j_43 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.getTop());
                                        int iMo15540roundToPx0680j_44 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.getBottom());
                                        final int i5 = iMo15540roundToPx0680j_43 + iMo15540roundToPx0680j_44;
                                        final int i6 = iMo15540roundToPx0680j_4 + iMo15540roundToPx0680j_42;
                                        boolean z17 = z15;
                                        int i7 = z17 ? i5 : i6;
                                        final int i8 = (!z17 || z) ? (z17 && z) ? iMo15540roundToPx0680j_44 : (z17 || z) ? iMo15540roundToPx0680j_42 : iMo15540roundToPx0680j_4 : iMo15540roundToPx0680j_43;
                                        final int i9 = i7 - i8;
                                        final long jM20940offsetNN6EwU = ConstraintsKt.m20940offsetNN6EwU(j, -i6, -i5);
                                        final LazyListItemProvider lazyListItemProviderInvoke = function0.invoke();
                                        lazyListItemProviderInvoke.getItemScope().setMaxSize(Constraints.m20921getMaxWidthimpl(jM20940offsetNN6EwU), Constraints.m20920getMaxHeightimpl(jM20940offsetNN6EwU));
                                        if (z15) {
                                            Arrangement.Vertical vertical7 = vertical5;
                                            if (vertical7 == null) {
                                                throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                                            }
                                            spacing = vertical7.getSpacing();
                                        } else {
                                            Arrangement.Horizontal horizontal7 = horizontal5;
                                            if (horizontal7 == null) {
                                                throw new IllegalArgumentException("null horizontalAlignment when isVertical == false");
                                            }
                                            spacing = horizontal7.getSpacing();
                                        }
                                        final int iMo15540roundToPx0680j_45 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(spacing);
                                        final int itemCount = lazyListItemProviderInvoke.getItemCount();
                                        int iM20920getMaxHeightimpl = z15 ? Constraints.m20920getMaxHeightimpl(j) - i5 : Constraints.m20921getMaxWidthimpl(j) - i6;
                                        if (!z || iM20920getMaxHeightimpl > 0) {
                                            jIntOffset = IntOffsetKt.IntOffset(iMo15540roundToPx0680j_4, iMo15540roundToPx0680j_43);
                                        } else {
                                            boolean z18 = z15;
                                            if (!z18) {
                                                iMo15540roundToPx0680j_4 += iM20920getMaxHeightimpl;
                                            }
                                            if (z18) {
                                                iMo15540roundToPx0680j_43 += iM20920getMaxHeightimpl;
                                            }
                                            jIntOffset = IntOffsetKt.IntOffset(iMo15540roundToPx0680j_4, iMo15540roundToPx0680j_43);
                                        }
                                        final boolean z19 = z15;
                                        final Alignment.Horizontal horizontal8 = horizontal6;
                                        final Alignment.Vertical vertical8 = vertical6;
                                        final boolean z20 = z;
                                        final LazyListState lazyListState2 = lazyListState;
                                        LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(jM20940offsetNN6EwU, z19, lazyListItemProviderInvoke, lazyLayoutMeasureScope, itemCount, iMo15540roundToPx0680j_45, horizontal8, vertical8, z20, i8, i9, jIntOffset, lazyListState2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                                            final /* synthetic */ int $afterContentPadding;
                                            final /* synthetic */ int $beforeContentPadding;
                                            final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                                            final /* synthetic */ boolean $isVertical;
                                            final /* synthetic */ int $itemsCount;
                                            final /* synthetic */ boolean $reverseLayout;
                                            final /* synthetic */ int $spaceBetweenItems;
                                            final /* synthetic */ LazyListState $state;
                                            final /* synthetic */ LazyLayoutMeasureScope $this_null;
                                            final /* synthetic */ Alignment.Vertical $verticalAlignment;
                                            final /* synthetic */ long $visualItemOffset;

                                            {
                                                this.$isVertical = z19;
                                                this.$this_null = lazyLayoutMeasureScope;
                                                this.$itemsCount = itemCount;
                                                this.$spaceBetweenItems = iMo15540roundToPx0680j_45;
                                                this.$horizontalAlignment = horizontal8;
                                                this.$verticalAlignment = vertical8;
                                                this.$reverseLayout = z20;
                                                this.$beforeContentPadding = i8;
                                                this.$afterContentPadding = i9;
                                                this.$visualItemOffset = jIntOffset;
                                                this.$state = lazyListState2;
                                            }

                                            @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                                            @NotNull
                                            /* JADX INFO: renamed from: createItem-X9ElhV4, reason: not valid java name */
                                            public LazyListMeasuredItem mo15957createItemX9ElhV4(int index, @NotNull Object key, @Nullable Object contentType, @NotNull List<? extends Placeable> placeables, long constraints) {
                                                return new LazyListMeasuredItem(index, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, index == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, key, contentType, this.$state.getItemAnimator$foundation_release(), constraints, null);
                                            }
                                        };
                                        Snapshot.Companion companion = Snapshot.INSTANCE;
                                        LazyListState lazyListState3 = lazyListState;
                                        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                                        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                                        try {
                                            int iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProviderInvoke, lazyListState3.getFirstVisibleItemIndex());
                                            int firstVisibleItemScrollOffset = lazyListState3.getFirstVisibleItemScrollOffset();
                                            Unit unit = Unit.INSTANCE;
                                            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                            LazyListMeasureResult lazyListMeasureResultM15961measureLazyListx0Ok8Vo = LazyListMeasureKt.m15961measureLazyListx0Ok8Vo(itemCount, lazyListMeasuredItemProvider, iM20920getMaxHeightimpl, i8, i9, iMo15540roundToPx0680j_45, iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, (lazyLayoutMeasureScope.isLookingAhead() || !z16) ? lazyListState.getScrollToBeConsumed() : lazyListState.getScrollDeltaBetweenPasses$foundation_release(), jM20940offsetNN6EwU, z15, z3 ? lazyListItemProviderInvoke.getHeaderIndexes() : CollectionsKt.emptyList(), vertical5, horizontal5, z, lazyLayoutMeasureScope, lazyListState.getItemAnimator$foundation_release(), i, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProviderInvoke, lazyListState.getPinnedItems(), lazyListState.getBeyondBoundsInfo()), z16, lazyLayoutMeasureScope.isLookingAhead(), lazyListState.getPostLookaheadLayoutInfo(), coroutineScope, lazyListState.m15972getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                                }

                                                @NotNull
                                                public final MeasureResult invoke(int i10, int i11, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1) {
                                                    return lazyLayoutMeasureScope.layout(ConstraintsKt.m20938constrainWidthK40F9xA(j, i10 + i6), ConstraintsKt.m20937constrainHeightK40F9xA(j, i11 + i5), MapsKt.emptyMap(), function1);
                                                }
                                            });
                                            LazyListState.applyMeasureResult$foundation_release$default(lazyListState, lazyListMeasureResultM15961measureLazyListx0Ok8Vo, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                                            return lazyListMeasureResultM15961measureLazyListx0Ok8Vo;
                                        } catch (Throwable th) {
                                            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                            throw th;
                                        }
                                    }
                                };
                                composer.updateRememberedValue(function2);
                                objRememberedValue = function2;
                            }
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22 = (Function2) objRememberedValue;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            return function22;
                        }
                        vertical4 = vertical2;
                        if ((i2 & DriveFile.MODE_READ_WRITE) != 536870912) {
                            z9 = false;
                        }
                        zChanged = z9 | z14 | composer.changed(graphicsContext) | ((((i4 & 896) ^ 384) <= 256 && composer.changed(z3)) || (i4 & 384) == 256);
                        objRememberedValue = composer.rememberedValue();
                        if (!zChanged) {
                            final Arrangement.Vertical vertical52 = vertical4;
                            final Arrangement.Horizontal horizontal52 = horizontal4;
                            final Alignment.Horizontal horizontal62 = horizontal3;
                            final Alignment.Vertical vertical62 = vertical3;
                            final boolean z152 = z4;
                            Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult> function23 = new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                                    return m15956invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                                }

                                @NotNull
                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final LazyListMeasureResult m15956invoke0kLqBqw(@NotNull final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                                    float spacing;
                                    final long jIntOffset;
                                    ObservableScopeInvalidator.m16028attachToScopeimpl(lazyListState.m15971getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                                    boolean z16 = lazyListState.getHasLookaheadPassOccurred() || lazyLayoutMeasureScope.isLookingAhead();
                                    CheckScrollableContainerConstraintsKt.m15437checkScrollableContainerConstraintsK40F9xA(j, z152 ? Orientation.Vertical : Orientation.Horizontal);
                                    int iMo15540roundToPx0680j_4 = z152 ? lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.mo15805calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo15540roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                    int iMo15540roundToPx0680j_42 = z152 ? lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.mo15806calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo15540roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                    int iMo15540roundToPx0680j_43 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.getTop());
                                    int iMo15540roundToPx0680j_44 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(paddingValues.getBottom());
                                    final int i5 = iMo15540roundToPx0680j_43 + iMo15540roundToPx0680j_44;
                                    final int i6 = iMo15540roundToPx0680j_4 + iMo15540roundToPx0680j_42;
                                    boolean z17 = z152;
                                    int i7 = z17 ? i5 : i6;
                                    final int i8 = (!z17 || z) ? (z17 && z) ? iMo15540roundToPx0680j_44 : (z17 || z) ? iMo15540roundToPx0680j_42 : iMo15540roundToPx0680j_4 : iMo15540roundToPx0680j_43;
                                    final int i9 = i7 - i8;
                                    final long jM20940offsetNN6EwU = ConstraintsKt.m20940offsetNN6EwU(j, -i6, -i5);
                                    final LazyListItemProvider lazyListItemProviderInvoke = function0.invoke();
                                    lazyListItemProviderInvoke.getItemScope().setMaxSize(Constraints.m20921getMaxWidthimpl(jM20940offsetNN6EwU), Constraints.m20920getMaxHeightimpl(jM20940offsetNN6EwU));
                                    if (z152) {
                                        Arrangement.Vertical vertical7 = vertical52;
                                        if (vertical7 == null) {
                                            throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                                        }
                                        spacing = vertical7.getSpacing();
                                    } else {
                                        Arrangement.Horizontal horizontal7 = horizontal52;
                                        if (horizontal7 == null) {
                                            throw new IllegalArgumentException("null horizontalAlignment when isVertical == false");
                                        }
                                        spacing = horizontal7.getSpacing();
                                    }
                                    final int iMo15540roundToPx0680j_45 = lazyLayoutMeasureScope.mo15540roundToPx0680j_4(spacing);
                                    final int itemCount = lazyListItemProviderInvoke.getItemCount();
                                    int iM20920getMaxHeightimpl = z152 ? Constraints.m20920getMaxHeightimpl(j) - i5 : Constraints.m20921getMaxWidthimpl(j) - i6;
                                    if (!z || iM20920getMaxHeightimpl > 0) {
                                        jIntOffset = IntOffsetKt.IntOffset(iMo15540roundToPx0680j_4, iMo15540roundToPx0680j_43);
                                    } else {
                                        boolean z18 = z152;
                                        if (!z18) {
                                            iMo15540roundToPx0680j_4 += iM20920getMaxHeightimpl;
                                        }
                                        if (z18) {
                                            iMo15540roundToPx0680j_43 += iM20920getMaxHeightimpl;
                                        }
                                        jIntOffset = IntOffsetKt.IntOffset(iMo15540roundToPx0680j_4, iMo15540roundToPx0680j_43);
                                    }
                                    final boolean z19 = z152;
                                    final Alignment.Horizontal horizontal8 = horizontal62;
                                    final Alignment.Vertical vertical8 = vertical62;
                                    final boolean z20 = z;
                                    final LazyListState lazyListState2 = lazyListState;
                                    LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(jM20940offsetNN6EwU, z19, lazyListItemProviderInvoke, lazyLayoutMeasureScope, itemCount, iMo15540roundToPx0680j_45, horizontal8, vertical8, z20, i8, i9, jIntOffset, lazyListState2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                                        final /* synthetic */ int $afterContentPadding;
                                        final /* synthetic */ int $beforeContentPadding;
                                        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                                        final /* synthetic */ boolean $isVertical;
                                        final /* synthetic */ int $itemsCount;
                                        final /* synthetic */ boolean $reverseLayout;
                                        final /* synthetic */ int $spaceBetweenItems;
                                        final /* synthetic */ LazyListState $state;
                                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                                        final /* synthetic */ Alignment.Vertical $verticalAlignment;
                                        final /* synthetic */ long $visualItemOffset;

                                        {
                                            this.$isVertical = z19;
                                            this.$this_null = lazyLayoutMeasureScope;
                                            this.$itemsCount = itemCount;
                                            this.$spaceBetweenItems = iMo15540roundToPx0680j_45;
                                            this.$horizontalAlignment = horizontal8;
                                            this.$verticalAlignment = vertical8;
                                            this.$reverseLayout = z20;
                                            this.$beforeContentPadding = i8;
                                            this.$afterContentPadding = i9;
                                            this.$visualItemOffset = jIntOffset;
                                            this.$state = lazyListState2;
                                        }

                                        @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                                        @NotNull
                                        /* JADX INFO: renamed from: createItem-X9ElhV4, reason: not valid java name */
                                        public LazyListMeasuredItem mo15957createItemX9ElhV4(int index, @NotNull Object key, @Nullable Object contentType, @NotNull List<? extends Placeable> placeables, long constraints) {
                                            return new LazyListMeasuredItem(index, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, index == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, key, contentType, this.$state.getItemAnimator$foundation_release(), constraints, null);
                                        }
                                    };
                                    Snapshot.Companion companion = Snapshot.INSTANCE;
                                    LazyListState lazyListState3 = lazyListState;
                                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                    Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                                    try {
                                        int iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProviderInvoke, lazyListState3.getFirstVisibleItemIndex());
                                        int firstVisibleItemScrollOffset = lazyListState3.getFirstVisibleItemScrollOffset();
                                        Unit unit = Unit.INSTANCE;
                                        companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                        LazyListMeasureResult lazyListMeasureResultM15961measureLazyListx0Ok8Vo = LazyListMeasureKt.m15961measureLazyListx0Ok8Vo(itemCount, lazyListMeasuredItemProvider, iM20920getMaxHeightimpl, i8, i9, iMo15540roundToPx0680j_45, iUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, (lazyLayoutMeasureScope.isLookingAhead() || !z16) ? lazyListState.getScrollToBeConsumed() : lazyListState.getScrollDeltaBetweenPasses$foundation_release(), jM20940offsetNN6EwU, z152, z3 ? lazyListItemProviderInvoke.getHeaderIndexes() : CollectionsKt.emptyList(), vertical52, horizontal52, z, lazyLayoutMeasureScope, lazyListState.getItemAnimator$foundation_release(), i, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProviderInvoke, lazyListState.getPinnedItems(), lazyListState.getBeyondBoundsInfo()), z16, lazyLayoutMeasureScope.isLookingAhead(), lazyListState.getPostLookaheadLayoutInfo(), coroutineScope, lazyListState.m15972getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                            }

                                            @NotNull
                                            public final MeasureResult invoke(int i10, int i11, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1) {
                                                return lazyLayoutMeasureScope.layout(ConstraintsKt.m20938constrainWidthK40F9xA(j, i10 + i6), ConstraintsKt.m20937constrainHeightK40F9xA(j, i11 + i5), MapsKt.emptyMap(), function1);
                                            }
                                        });
                                        LazyListState.applyMeasureResult$foundation_release$default(lazyListState, lazyListMeasureResultM15961measureLazyListx0Ok8Vo, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                                        return lazyListMeasureResultM15961measureLazyListx0Ok8Vo;
                                    } catch (Throwable th) {
                                        companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                        throw th;
                                    }
                                }
                            };
                            composer.updateRememberedValue(function23);
                            objRememberedValue = function23;
                        }
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function222 = (Function2) objRememberedValue;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        return function222;
                    }
                    horizontal4 = horizontal2;
                    if ((100663296 & i2) == 67108864) {
                        z8 = false;
                    }
                    boolean z142 = z13 | z8;
                    if (((1879048192 & i2) ^ DriveFile.MODE_READ_WRITE) > 536870912) {
                    }
                    if ((i2 & DriveFile.MODE_READ_WRITE) != 536870912) {
                    }
                    zChanged = z9 | z142 | composer.changed(graphicsContext) | ((((i4 & 896) ^ 384) <= 256 && composer.changed(z3)) || (i4 & 384) == 256);
                    objRememberedValue = composer.rememberedValue();
                    if (!zChanged) {
                    }
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2222 = (Function2) objRememberedValue;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    return function2222;
                }
                vertical3 = vertical;
                if ((12582912 & i2) != 8388608) {
                    z7 = false;
                }
                boolean z132 = z12 | z7;
                if (((234881024 & i2) ^ 100663296) <= 67108864) {
                }
                if ((100663296 & i2) == 67108864) {
                }
                boolean z1422 = z132 | z8;
                if (((1879048192 & i2) ^ DriveFile.MODE_READ_WRITE) > 536870912) {
                }
                if ((i2 & DriveFile.MODE_READ_WRITE) != 536870912) {
                }
                zChanged = z9 | z1422 | composer.changed(graphicsContext) | ((((i4 & 896) ^ 384) <= 256 && composer.changed(z3)) || (i4 & 384) == 256);
                objRememberedValue = composer.rememberedValue();
                if (!zChanged) {
                }
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22222 = (Function2) objRememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                }
                return function22222;
            }
            horizontal3 = horizontal;
            if ((1572864 & i2) == 1048576) {
                z6 = false;
            }
            boolean z122 = z11 | z6;
            if (((29360128 & i2) ^ 12582912) > 8388608) {
            }
            if ((12582912 & i2) != 8388608) {
            }
            boolean z1322 = z122 | z7;
            if (((234881024 & i2) ^ 100663296) <= 67108864) {
            }
            if ((100663296 & i2) == 67108864) {
            }
            boolean z14222 = z1322 | z8;
            if (((1879048192 & i2) ^ DriveFile.MODE_READ_WRITE) > 536870912) {
            }
            if ((i2 & DriveFile.MODE_READ_WRITE) != 536870912) {
            }
            zChanged = z9 | z14222 | composer.changed(graphicsContext) | ((((i4 & 896) ^ 384) <= 256 && composer.changed(z3)) || (i4 & 384) == 256);
            objRememberedValue = composer.rememberedValue();
            if (!zChanged) {
            }
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function222222 = (Function2) objRememberedValue;
            if (ComposerKt.isTraceInProgress()) {
            }
            return function222222;
        }
        z4 = z2;
        if ((i2 & 24576) != 16384) {
            z5 = false;
        }
        boolean z112 = z10 | z5;
        if (((3670016 & i2) ^ 1572864) <= 1048576) {
        }
        if ((1572864 & i2) == 1048576) {
        }
        boolean z1222 = z112 | z6;
        if (((29360128 & i2) ^ 12582912) > 8388608) {
        }
        if ((12582912 & i2) != 8388608) {
        }
        boolean z13222 = z1222 | z7;
        if (((234881024 & i2) ^ 100663296) <= 67108864) {
        }
        if ((100663296 & i2) == 67108864) {
        }
        boolean z142222 = z13222 | z8;
        if (((1879048192 & i2) ^ DriveFile.MODE_READ_WRITE) > 536870912) {
        }
        if ((i2 & DriveFile.MODE_READ_WRITE) != 536870912) {
        }
        zChanged = z9 | z142222 | composer.changed(graphicsContext) | ((((i4 & 896) ^ 384) <= 256 && composer.changed(z3)) || (i4 & 384) == 256);
        objRememberedValue = composer.rememberedValue();
        if (!zChanged) {
        }
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2222222 = (Function2) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
        }
        return function2222222;
    }
}
