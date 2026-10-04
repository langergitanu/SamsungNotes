package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.AndroidPath_androidKt;
import androidx.compose.p109ui.graphics.OutlineKt;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.LookaheadScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalSharedTransitionApi
@Metadata(m13885d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002:\u0001uB\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0015\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u000202H\u0000¢\u0006\u0002\b3J\u0015\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001eH\u0000¢\u0006\u0002\b6J\u0015\u00107\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001eH\u0000¢\u0006\u0002\b8J\u0015\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020;H\u0000¢\u0006\u0002\b<J\u0015\u0010=\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020;H\u0000¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020$H\u0017¢\u0006\u0002\u0010BJM\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020@2\u0006\u0010K\u001a\u00020-2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\nH\u0003¢\u0006\u0002\u0010OJ\u0010\u0010P\u001a\u00020%2\u0006\u0010A\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J3\u0010Q\u001a\u00020R*\u00020\u00122\u0006\u0010S\u001a\u00020\u00122\b\b\u0002\u0010T\u001a\u00020R2\b\b\u0002\u0010U\u001a\u00020\nH\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ>\u0010X\u001a\u00020Y*\u00020Y2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\n0\u001a2\u0006\u0010L\u001a\u00020M2\u001a\u0010K\u001a\u0016\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020]\u0012\u0006\u0012\u0004\u0018\u00010^0[H\u0016J\\\u0010_\u001a\u00020Y*\u00020Y2\u0006\u0010J\u001a\u00020@2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\u0006\u0010G\u001a\u00020H2\u0006\u0010N\u001a\u00020\n2\u0006\u0010L\u001a\u00020M2\u0006\u0010K\u001a\u00020-H\u0016Jp\u0010j\u001a\u00020Y\"\u0004\b\u0000\u0010k*\u00020Y2\u0006\u0010J\u001a\u00020@2\u000e\u0010l\u001a\n\u0012\u0004\u0012\u0002Hk\u0018\u00010m2\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u0002Hk\u0012\u0004\u0012\u00020\n0'2\u0006\u0010f\u001a\u00020g2\b\b\u0002\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\u0006\u0010L\u001a\u00020M2\u0006\u0010K\u001a\u00020-H\u0002JS\u0010o\u001a\u00020Y*\u00020Y2\u0006\u0010J\u001a\u00020@2\u0006\u0010n\u001a\u00020\n2\b\b\u0002\u0010f\u001a\u00020g2\b\b\u0002\u0010G\u001a\u00020H2\b\b\u0002\u0010N\u001a\u00020\n2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010K\u001a\u00020-H\u0000¢\u0006\u0002\bpJD\u0010D\u001a\u00020Y*\u00020Y2\u0006\u0010q\u001a\u00020@2\u0006\u0010`\u001a\u00020a2\u0006\u0010f\u001a\u00020g2\u0006\u0010G\u001a\u00020H2\u0006\u0010N\u001a\u00020\n2\u0006\u0010L\u001a\u00020M2\u0006\u0010K\u001a\u00020-H\u0016JD\u0010r\u001a\u00020Y*\u00020Y2\u0006\u0010J\u001a\u00020@2\u0006\u0010n\u001a\u00020\n2\u0006\u0010f\u001a\u00020g2\u0006\u0010G\u001a\u00020H2\u0006\u0010N\u001a\u00020\n2\u0006\u0010L\u001a\u00020M2\u0006\u0010K\u001a\u00020-H\u0016J\f\u0010s\u001a\u00020Y*\u00020YH\u0016J\r\u0010t\u001a\u00020\u0012*\u00020\u0012H\u0096\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0014\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0012X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0018R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001b0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\u00020\u0012*\u00020)X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006v"}, m13886d2 = {"Landroidx/compose/animation/SharedTransitionScopeImpl;", "Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "lookaheadScope", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/layout/LookaheadScope;Lkotlinx/coroutines/CoroutineScope;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "", "isTransitionActive", "()Z", "setTransitionActive", "(Z)V", "isTransitionActive$delegate", "Landroidx/compose/runtime/MutableState;", "lookaheadRoot", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLookaheadRoot$animation_release", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "nullableLookaheadRoot", "getNullableLookaheadRoot$animation_release", "setNullableLookaheadRoot$animation_release", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "observeAnimatingBlock", "Lkotlin/Function0;", "", "renderers", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/LayerRenderer;", "root", "getRoot$animation_release", "setRoot$animation_release", "sharedElements", "Landroidx/collection/MutableScatterMap;", "", "Landroidx/compose/animation/SharedElement;", "updateTransitionActiveness", "Lkotlin/Function1;", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "OverlayClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "drawInOverlay", "scope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawInOverlay$animation_release", "onLayerRendererCreated", "renderer", "onLayerRendererCreated$animation_release", "onLayerRendererRemoved", "onLayerRendererRemoved$animation_release", "onStateAdded", "sharedElementState", "Landroidx/compose/animation/SharedElementInternalState;", "onStateAdded$animation_release", "onStateRemoved", "onStateRemoved$animation_release", "rememberSharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "key", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "rememberSharedElementState", "sharedElement", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "placeHolderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "renderOnlyWhenVisible", "sharedContentState", "clipInOverlayDuringTransition", "zIndexInOverlay", "", "renderInOverlayDuringTransition", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsAnimation;Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;ZLandroidx/compose/animation/SharedTransitionScope$SharedContentState;Landroidx/compose/animation/SharedTransitionScope$OverlayClip;FZLandroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedElementInternalState;", "sharedElementsFor", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "sourceCoordinates", "relativeToSource", "includeMotionFrameOfReference", "localLookaheadPositionOf-au-aQtc", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "renderInSharedTransitionScopeOverlay", "Landroidx/compose/ui/Modifier;", "renderInOverlay", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "sharedBounds", "animatedVisibilityScope", "Landroidx/compose/animation/AnimatedVisibilityScope;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "resizeMode", "Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "sharedBoundsImpl", "T", "parentTransition", "Landroidx/compose/animation/core/Transition;", "visible", "sharedBoundsWithCallerManagedVisibility", "sharedBoundsWithCallerManagedVisibility$animation_release", "state", "sharedElementWithCallerManagedVisibility", "skipToLookaheadSize", "toLookaheadCoordinates", "ShapeBasedClip", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Stable
@SourceDebugExtension({"SMAP\nSharedTransitionScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedTransitionScope.kt\nandroidx/compose/animation/SharedTransitionScopeImpl\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 5 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 7 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,1337:1\n81#2:1338\n107#2,2:1339\n1225#3,6:1341\n1225#3,6:1429\n440#4:1347\n391#4,4:1348\n363#4,6:1352\n373#4,3:1359\n376#4,2:1363\n396#4:1365\n441#4,2:1366\n397#4:1368\n379#4,6:1369\n398#4:1375\n443#4:1376\n391#4,4:1377\n363#4,6:1381\n373#4,3:1388\n376#4,2:1392\n396#4,2:1394\n379#4,6:1396\n398#4:1402\n391#4,4:1403\n363#4,6:1407\n373#4,3:1414\n376#4,2:1418\n396#4,2:1420\n379#4,6:1422\n398#4:1428\n1810#5:1358\n1672#5:1362\n1810#5:1387\n1672#5:1391\n1810#5:1413\n1672#5:1417\n1002#6,2:1435\n350#6,7:1443\n33#7,6:1437\n*S KotlinDebug\n*F\n+ 1 SharedTransitionScope.kt\nandroidx/compose/animation/SharedTransitionScopeImpl\n*L\n706#1:1338\n706#1:1339,2\n913#1:1341,6\n1033#1:1429,6\n929#1:1347\n929#1:1348,4\n929#1:1352,6\n929#1:1359,3\n929#1:1363,2\n929#1:1365\n929#1:1366,2\n929#1:1368\n929#1:1369,6\n929#1:1375\n929#1:1376\n935#1:1377,4\n935#1:1381,6\n935#1:1388,3\n935#1:1392,2\n935#1:1394,2\n935#1:1396,6\n935#1:1402\n940#1:1403,4\n940#1:1407,6\n940#1:1414,3\n940#1:1418,2\n940#1:1420,2\n940#1:1422,6\n940#1:1428\n929#1:1358\n929#1:1362\n935#1:1387\n935#1:1391\n940#1:1413\n940#1:1417\n1080#1:1435,2\n1119#1:1443,7\n1085#1:1437,6\n*E\n"})
public final class SharedTransitionScopeImpl implements SharedTransitionScope, LookaheadScope {
    public static final int $stable = 0;
    private final /* synthetic */ LookaheadScope $$delegate_0;

    @NotNull
    private final CoroutineScope coroutineScope;

    @Nullable
    private LayoutCoordinates nullableLookaheadRoot;
    public LayoutCoordinates root;

    /* JADX INFO: renamed from: isTransitionActive$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState isTransitionActive = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);

    @NotNull
    private final Function0<Unit> observeAnimatingBlock = new Function0<Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$observeAnimatingBlock$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MutableScatterMap mutableScatterMap = this.this$0.sharedElements;
            Object[] objArr = mutableScatterMap.keys;
            Object[] objArr2 = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            Object obj = objArr[i5];
                            if (((SharedElement) objArr2[i5]).isAnimating()) {
                                return;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        }
    };

    @NotNull
    private final Function1<SharedTransitionScope, Unit> updateTransitionActiveness = new Function1<SharedTransitionScope, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl.updateTransitionActiveness.1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SharedTransitionScope sharedTransitionScope) {
            invoke2(sharedTransitionScope);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SharedTransitionScope sharedTransitionScope) {
            SharedTransitionScopeImpl.this.updateTransitionActiveness();
        }
    };

    @NotNull
    private final SnapshotStateList<LayerRenderer> renderers = SnapshotStateKt.mutableStateListOf();

    @NotNull
    private final MutableScatterMap<Object, SharedElement> sharedElements = new MutableScatterMap<>(0, 1, null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/animation/SharedTransitionScopeImpl$ShapeBasedClip;", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/compose/ui/graphics/Shape;)V", "getClipShape", "()Landroidx/compose/ui/graphics/Shape;", "path", "Landroidx/compose/ui/graphics/Path;", "getClipPath", "state", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class ShapeBasedClip implements SharedTransitionScope.OverlayClip {

        @NotNull
        private final Shape clipShape;

        @NotNull
        private final Path path = AndroidPath_androidKt.Path();

        public ShapeBasedClip(@NotNull Shape shape) {
            this.clipShape = shape;
        }

        @Override // androidx.compose.animation.SharedTransitionScope.OverlayClip
        @NotNull
        public Path getClipPath(@NotNull SharedTransitionScope.SharedContentState state, @NotNull Rect bounds, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
            this.path.reset();
            OutlineKt.addOutline(this.path, this.clipShape.mo15457createOutlinePq9zytI(bounds.m18317getSizeNHjbRc(), layoutDirection, density));
            this.path.mo18420translatek4lQ0M(bounds.m18319getTopLeftF1C5BW0());
            return this.path;
        }

        @NotNull
        public final Shape getClipShape() {
            return this.clipShape;
        }
    }

    public SharedTransitionScopeImpl(@NotNull LookaheadScope lookaheadScope, @NotNull CoroutineScope coroutineScope) {
        this.coroutineScope = coroutineScope;
        this.$$delegate_0 = lookaheadScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public final SharedElementInternalState rememberSharedElementState(SharedElement sharedElement, BoundsAnimation boundsAnimation, SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z, SharedTransitionScope.SharedContentState sharedContentState, SharedTransitionScope.OverlayClip overlayClip, float f, boolean z2, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2066772852, i, -1, "androidx.compose.animation.SharedTransitionScopeImpl.rememberSharedElementState (SharedTransitionScope.kt:1032)");
        }
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new SharedElementInternalState(sharedElement, boundsAnimation, placeHolderSize, z, overlayClip, z2, sharedContentState, f);
            composer.updateRememberedValue(objRememberedValue);
        }
        SharedElementInternalState sharedElementInternalState = (SharedElementInternalState) objRememberedValue;
        sharedContentState.setInternalState$animation_release(sharedElementInternalState);
        sharedElementInternalState.setSharedElement(sharedElement);
        sharedElementInternalState.setRenderOnlyWhenVisible(z);
        sharedElementInternalState.setBoundsAnimation(boundsAnimation);
        sharedElementInternalState.setPlaceHolderSize(placeHolderSize);
        sharedElementInternalState.setOverlayClip(overlayClip);
        sharedElementInternalState.setZIndex(f);
        sharedElementInternalState.setRenderInOverlayDuringTransition(z2);
        sharedElementInternalState.setUserState(sharedContentState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return sharedElementInternalState;
    }

    private void setTransitionActive(boolean z) {
        this.isTransitionActive.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Modifier sharedBoundsImpl(Modifier modifier, final SharedTransitionScope.SharedContentState sharedContentState, final Transition<T> transition, final Function1<? super T, Boolean> function1, final BoundsTransform boundsTransform, final SharedTransitionScope.PlaceHolderSize placeHolderSize, final boolean z, final boolean z2, final float f, final SharedTransitionScope.OverlayClip overlayClip) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Transition transitionRememberTransition;
                Composer composer2 = composer;
                composer.startReplaceGroup(-1843478929);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1843478929, i, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous> (SharedTransitionScope.kt:968)");
                }
                Object key = sharedContentState.getKey();
                composer.startMovableGroup(-359675295, key);
                SharedTransitionScopeImpl sharedTransitionScopeImpl = this;
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = sharedTransitionScopeImpl.sharedElementsFor(key);
                    composer.updateRememberedValue(objRememberedValue);
                }
                SharedElement sharedElement = (SharedElement) objRememberedValue;
                composer.startMovableGroup(-359672306, transition);
                boolean z3 = false;
                if (transition != 0) {
                    composer.startReplaceGroup(1735101820);
                    Transition<T> transition2 = transition;
                    String string = key.toString();
                    Function1<T, Boolean> function12 = function1;
                    boolean zChanged = composer.changed(transition2);
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = transition2.getCurrentState();
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    if (transition2.isSeeking()) {
                        objRememberedValue2 = transition2.getCurrentState();
                    }
                    composer.startReplaceGroup(1329676753);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1329676753, 0, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SharedTransitionScope.kt:974)");
                    }
                    Boolean boolInvoke = function12.invoke((T) objRememberedValue2);
                    boolInvoke.getClass();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    Object targetState = transition2.getTargetState();
                    composer.startReplaceGroup(1329676753);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1329676753, 0, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SharedTransitionScope.kt:974)");
                    }
                    Boolean boolInvoke2 = function12.invoke((T) targetState);
                    boolInvoke2.getClass();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    transitionRememberTransition = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition2, boolInvoke, boolInvoke2, string, composer2, 0);
                    composer2 = composer2;
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1735245009);
                    Function1<T, Boolean> function13 = function1;
                    Intrinsics.checkNotNull(function13, "null cannot be cast to non-null type kotlin.Function1<kotlin.Unit, kotlin.Boolean>");
                    Boolean bool = (Boolean) ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function13, 1)).invoke(Unit.INSTANCE);
                    boolean zBooleanValue = bool.booleanValue();
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (objRememberedValue3 == companion.getEmpty()) {
                        if (sharedElement.getCurrentBounds() == null) {
                            z3 = zBooleanValue;
                        } else if (!zBooleanValue) {
                            z3 = true;
                        }
                        objRememberedValue3 = new MutableTransitionState(Boolean.valueOf(z3));
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    MutableTransitionState mutableTransitionState = (MutableTransitionState) objRememberedValue3;
                    mutableTransitionState.setTargetState$animation_core_release(bool);
                    transitionRememberTransition = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, null, composer, MutableTransitionState.$stable, 2);
                    composer.endReplaceGroup();
                }
                composer.startMovableGroup(-359633642, Boolean.valueOf(this.isTransitionActive()));
                Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> deferredAnimationCreateDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transitionRememberTransition, VectorConvertersKt.getVectorConverter(Rect.INSTANCE), null, composer2, 0, 2);
                composer.endMovableGroup();
                boolean zChanged2 = composer.changed(transitionRememberTransition);
                SharedTransitionScopeImpl sharedTransitionScopeImpl2 = this;
                BoundsTransform boundsTransform2 = boundsTransform;
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new BoundsAnimation(sharedTransitionScopeImpl2, transitionRememberTransition, deferredAnimationCreateDeferredAnimation, boundsTransform2);
                    composer.updateRememberedValue(objRememberedValue4);
                }
                BoundsAnimation boundsAnimation = (BoundsAnimation) objRememberedValue4;
                boundsAnimation.updateAnimation(deferredAnimationCreateDeferredAnimation, boundsTransform);
                composer.endMovableGroup();
                SharedElementInternalState sharedElementInternalStateRememberSharedElementState = this.rememberSharedElementState(sharedElement, boundsAnimation, placeHolderSize, z, sharedContentState, overlayClip, f, z2, composer, 0);
                composer.endMovableGroup();
                Modifier modifierThen = modifier2.then(new SharedBoundsNodeElement(sharedElementInternalStateRememberSharedElementState));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierThen;
            }
        }, 1, null);
    }

    /* JADX INFO: renamed from: sharedBoundsWithCallerManagedVisibility$animation_release$default */
    public static /* synthetic */ Modifier m1182x75365d0b(SharedTransitionScopeImpl sharedTransitionScopeImpl, Modifier modifier, SharedTransitionScope.SharedContentState sharedContentState, boolean z, BoundsTransform boundsTransform, SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z2, float f, SharedTransitionScope.OverlayClip overlayClip, int i, Object obj) {
        if ((i & 4) != 0) {
            boundsTransform = SharedTransitionScopeKt.DefaultBoundsTransform;
        }
        BoundsTransform boundsTransform2 = boundsTransform;
        if ((i & 8) != 0) {
            placeHolderSize = SharedTransitionScope.PlaceHolderSize.INSTANCE.getContentSize();
        }
        return sharedTransitionScopeImpl.sharedBoundsWithCallerManagedVisibility$animation_release(modifier, sharedContentState, z, boundsTransform2, placeHolderSize, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? 0.0f : f, (i & 64) != 0 ? SharedTransitionScopeKt.ParentClip : overlayClip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedElement sharedElementsFor(Object key) {
        SharedElement sharedElement = this.sharedElements.get(key);
        if (sharedElement != null) {
            return sharedElement;
        }
        SharedElement sharedElement2 = new SharedElement(key, this);
        this.sharedElements.set(key, sharedElement2);
        return sharedElement2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateTransitionActiveness() {
        long j;
        long j2;
        boolean z;
        char c;
        long j3;
        MutableScatterMap<Object, SharedElement> mutableScatterMap = this.sharedElements;
        Object[] objArr = mutableScatterMap.keys;
        Object[] objArr2 = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        char c2 = 7;
        long j5 = -9187201950435737472L;
        if (length >= 0) {
            int i = 0;
            j = 128;
            loop0: while (true) {
                long j6 = jArr[i];
                j2 = 255;
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((j6 & 255) < 128) {
                            int i5 = (i << 3) + i4;
                            Object obj = objArr[i5];
                            if (((SharedElement) objArr2[i5]).isAnimating()) {
                                z = true;
                                break loop0;
                            }
                        }
                        j6 >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    } else if (i == length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        } else {
            j = 128;
            j2 = 255;
        }
        z = false;
        if (z != isTransitionActive()) {
            setTransitionActive(z);
            if (!z) {
                MutableScatterMap<Object, SharedElement> mutableScatterMap2 = this.sharedElements;
                Object[] objArr3 = mutableScatterMap2.keys;
                Object[] objArr4 = mutableScatterMap2.values;
                long[] jArr2 = mutableScatterMap2.metadata;
                int length2 = jArr2.length - 2;
                if (length2 >= 0) {
                    int i6 = 0;
                    while (true) {
                        long j7 = jArr2[i6];
                        c = c2;
                        j3 = j5;
                        if ((((~j7) << c) & j7 & j3) != j3) {
                            int i7 = 8 - ((~(i6 - length2)) >>> 31);
                            for (int i8 = 0; i8 < i7; i8++) {
                                if ((j7 & j2) < j) {
                                    int i9 = (i6 << 3) + i8;
                                    Object obj2 = objArr3[i9];
                                    ((SharedElement) objArr4[i9]).onSharedTransitionFinished();
                                }
                                j7 >>= 8;
                            }
                            if (i7 != 8) {
                                break;
                            }
                            if (i6 == length2) {
                                break;
                            }
                            i6++;
                            c2 = c;
                            j5 = j3;
                        }
                    }
                } else {
                    c = 7;
                    j3 = -9187201950435737472L;
                }
            }
        }
        MutableScatterMap<Object, SharedElement> mutableScatterMap3 = this.sharedElements;
        Object[] objArr5 = mutableScatterMap3.keys;
        Object[] objArr6 = mutableScatterMap3.values;
        long[] jArr3 = mutableScatterMap3.metadata;
        int length3 = jArr3.length - 2;
        if (length3 >= 0) {
            int i10 = 0;
            while (true) {
                long j8 = jArr3[i10];
                if ((((~j8) << c) & j8 & j3) != j3) {
                    int i11 = 8 - ((~(i10 - length3)) >>> 31);
                    for (int i12 = 0; i12 < i11; i12++) {
                        if ((j8 & j2) < j) {
                            int i13 = (i10 << 3) + i12;
                            Object obj3 = objArr5[i13];
                            ((SharedElement) objArr6[i13]).updateMatch();
                        }
                        j8 >>= 8;
                    }
                    if (i11 != 8) {
                        break;
                    } else if (i10 == length3) {
                        break;
                    } else {
                        i10++;
                    }
                }
            }
        }
        SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(this, this.updateTransitionActiveness, this.observeAnimatingBlock);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    @NotNull
    public SharedTransitionScope.OverlayClip OverlayClip(@NotNull Shape clipShape) {
        return new ShapeBasedClip(clipShape);
    }

    public final void drawInOverlay$animation_release(@NotNull ContentDrawScope scope) {
        SnapshotStateList<LayerRenderer> snapshotStateList = this.renderers;
        if (snapshotStateList.size() > 1) {
            CollectionsKt.sortWith(snapshotStateList, new Comparator() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$drawInOverlay$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    LayerRenderer layerRenderer = (LayerRenderer) t;
                    LayerRenderer layerRenderer2 = (LayerRenderer) t2;
                    return ComparisonsKt.compareValues(Float.valueOf((layerRenderer.getZIndex() == 0.0f && (layerRenderer instanceof SharedElementInternalState) && ((SharedElementInternalState) layerRenderer).getParentState() == null) ? -1.0f : layerRenderer.getZIndex()), Float.valueOf((layerRenderer2.getZIndex() == 0.0f && (layerRenderer2 instanceof SharedElementInternalState) && ((SharedElementInternalState) layerRenderer2).getParentState() == null) ? -1.0f : layerRenderer2.getZIndex()));
                }
            });
        }
        SnapshotStateList<LayerRenderer> snapshotStateList2 = this.renderers;
        int size = snapshotStateList2.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList2.get(i).drawInOverlay(scope);
        }
    }

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @NotNull
    public final LayoutCoordinates getLookaheadRoot$animation_release() {
        LayoutCoordinates layoutCoordinates = this.nullableLookaheadRoot;
        if (layoutCoordinates != null) {
            return layoutCoordinates;
        }
        throw new IllegalArgumentException("Error: Uninitialized LayoutCoordinates. Please make sure when using the SharedTransitionScope composable function, the modifier passed to the child content is being used, or use SharedTransitionLayout instead.");
    }

    @Override // androidx.compose.p109ui.layout.LookaheadScope
    @NotNull
    public LayoutCoordinates getLookaheadScopeCoordinates(@NotNull Placeable.PlacementScope placementScope) {
        return this.$$delegate_0.getLookaheadScopeCoordinates(placementScope);
    }

    @Nullable
    /* JADX INFO: renamed from: getNullableLookaheadRoot$animation_release, reason: from getter */
    public final LayoutCoordinates getNullableLookaheadRoot() {
        return this.nullableLookaheadRoot;
    }

    @NotNull
    public final LayoutCoordinates getRoot$animation_release() {
        LayoutCoordinates layoutCoordinates = this.root;
        if (layoutCoordinates != null) {
            return layoutCoordinates;
        }
        Intrinsics.throwUninitializedPropertyAccessException("root");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.animation.SharedTransitionScope
    public boolean isTransitionActive() {
        return ((Boolean) this.isTransitionActive.getValue()).booleanValue();
    }

    @Override // androidx.compose.p109ui.layout.LookaheadScope
    /* JADX INFO: renamed from: localLookaheadPositionOf-au-aQtc, reason: not valid java name */
    public long mo15284localLookaheadPositionOfauaQtc(@NotNull LayoutCoordinates layoutCoordinates, @NotNull LayoutCoordinates layoutCoordinates2, long j, boolean z) {
        return this.$$delegate_0.mo15284localLookaheadPositionOfauaQtc(layoutCoordinates, layoutCoordinates2, j, z);
    }

    public final void onLayerRendererCreated$animation_release(@NotNull LayerRenderer renderer) {
        this.renderers.add(renderer);
    }

    public final void onLayerRendererRemoved$animation_release(@NotNull LayerRenderer renderer) {
        this.renderers.remove(renderer);
    }

    public final void onStateAdded$animation_release(@NotNull SharedElementInternalState sharedElementState) {
        SharedElement sharedElement = sharedElementState.getSharedElement();
        sharedElement.addState(sharedElementState);
        this.updateTransitionActiveness.invoke(this);
        SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(sharedElement.getScope(), this.updateTransitionActiveness, this.observeAnimatingBlock);
        Iterator<LayerRenderer> it = this.renderers.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            LayerRenderer next = it.next();
            SharedElementInternalState sharedElementInternalState = next instanceof SharedElementInternalState ? (SharedElementInternalState) next : null;
            if (Intrinsics.areEqual(sharedElementInternalState != null ? sharedElementInternalState.getSharedElement() : null, sharedElementState.getSharedElement())) {
                break;
            } else {
                i++;
            }
        }
        if (i == this.renderers.size() - 1 || i == -1) {
            this.renderers.add(sharedElementState);
        } else {
            this.renderers.add(i + 1, sharedElementState);
        }
    }

    public final void onStateRemoved$animation_release(@NotNull SharedElementInternalState sharedElementState) {
        SharedElement sharedElement = sharedElementState.getSharedElement();
        sharedElement.removeState(sharedElementState);
        this.updateTransitionActiveness.invoke(this);
        SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(sharedElement.getScope(), this.updateTransitionActiveness, this.observeAnimatingBlock);
        this.renderers.remove(sharedElementState);
        if (sharedElement.getStates().isEmpty()) {
            BuildersKt__Builders_commonKt.launch$default(sharedElement.getScope().coroutineScope, null, null, new SharedTransitionScopeImpl$onStateRemoved$1$1(sharedElement, null), 3, null);
        }
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    @Composable
    @NotNull
    public SharedTransitionScope.SharedContentState rememberSharedContentState(@NotNull Object obj, @Nullable Composer composer, int i) {
        composer.startReplaceGroup(799702514);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(799702514, i, -1, "androidx.compose.animation.SharedTransitionScopeImpl.rememberSharedContentState (SharedTransitionScope.kt:912)");
        }
        boolean zChanged = composer.changed(obj);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new SharedTransitionScope.SharedContentState(obj);
            composer.updateRememberedValue(objRememberedValue);
        }
        SharedTransitionScope.SharedContentState sharedContentState = (SharedTransitionScope.SharedContentState) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return sharedContentState;
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    @NotNull
    public Modifier renderInSharedTransitionScopeOverlay(@NotNull Modifier modifier, @NotNull Function0<Boolean> function0, float f, @NotNull Function2<? super LayoutDirection, ? super Density, ? extends Path> function2) {
        return modifier.then(new RenderInTransitionOverlayNodeElement(this, function0, f, function2));
    }

    public final void setNullableLookaheadRoot$animation_release(@Nullable LayoutCoordinates layoutCoordinates) {
        this.nullableLookaheadRoot = layoutCoordinates;
    }

    public final void setRoot$animation_release(@NotNull LayoutCoordinates layoutCoordinates) {
        this.root = layoutCoordinates;
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    @NotNull
    public Modifier sharedBounds(@NotNull Modifier modifier, @NotNull final SharedTransitionScope.SharedContentState sharedContentState, @NotNull final AnimatedVisibilityScope animatedVisibilityScope, @NotNull final EnterTransition enterTransition, @NotNull final ExitTransition exitTransition, @NotNull BoundsTransform boundsTransform, @NotNull final SharedTransitionScope.ResizeMode resizeMode, @NotNull SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z, float f, @NotNull SharedTransitionScope.OverlayClip overlayClip) {
        return ComposedModifierKt.composed$default(sharedBoundsImpl(modifier, sharedContentState, animatedVisibilityScope.getTransition(), new Function1<EnterExitState, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl.sharedBounds.1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull EnterExitState enterExitState) {
                return Boolean.valueOf(enterExitState == EnterExitState.Visible);
            }
        }, boundsTransform, placeHolderSize, false, z, f, overlayClip), null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl.sharedBounds.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Modifier modifierCreateContentScaleModifier;
                composer.startReplaceGroup(-419341573);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-419341573, i, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBounds.<anonymous> (SharedTransitionScope.kt:770)");
                }
                Transition<EnterExitState> transition = animatedVisibilityScope.getTransition();
                EnterTransition enterTransition2 = enterTransition;
                ExitTransition exitTransition2 = exitTransition;
                boolean zChangedInstance = composer.changedInstance(sharedContentState);
                final SharedTransitionScope.SharedContentState sharedContentState2 = sharedContentState;
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0<Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final Boolean invoke() {
                            return Boolean.valueOf(sharedContentState2.isMatchFound());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierCreateModifier = EnterExitTransitionKt.createModifier(transition, enterTransition2, exitTransition2, (Function0) objRememberedValue, "enter/exit for " + sharedContentState.getKey(), composer, 0, 0);
                if (resizeMode instanceof ScaleToBoundsImpl) {
                    composer.startReplaceGroup(-805247216);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ScaleToBoundsImpl scaleToBoundsImpl = (ScaleToBoundsImpl) resizeMode;
                    boolean zChangedInstance2 = composer.changedInstance(sharedContentState);
                    final SharedTransitionScope.SharedContentState sharedContentState3 = sharedContentState;
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0<Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2$2$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final Boolean invoke() {
                                return Boolean.valueOf(sharedContentState3.isMatchFound());
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    modifierCreateContentScaleModifier = SharedTransitionScopeKt.createContentScaleModifier(companion, scaleToBoundsImpl, (Function0) objRememberedValue2);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-804630006);
                    composer.endReplaceGroup();
                    modifierCreateContentScaleModifier = Modifier.INSTANCE;
                }
                Modifier modifierThen = modifierCreateModifier.then(modifierCreateContentScaleModifier);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierThen;
            }
        }, 1, null);
    }

    @NotNull
    public final Modifier sharedBoundsWithCallerManagedVisibility$animation_release(@NotNull Modifier modifier, @NotNull SharedTransitionScope.SharedContentState sharedContentState, final boolean z, @NotNull BoundsTransform boundsTransform, @NotNull SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z2, float f, @NotNull SharedTransitionScope.OverlayClip overlayClip) {
        return sharedBoundsImpl(modifier, sharedContentState, null, new Function1<Unit, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBoundsWithCallerManagedVisibility$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Unit unit) {
                return Boolean.valueOf(z);
            }
        }, boundsTransform, placeHolderSize, false, z2, f, overlayClip);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    @NotNull
    public Modifier sharedElement(@NotNull Modifier modifier, @NotNull SharedTransitionScope.SharedContentState sharedContentState, @NotNull AnimatedVisibilityScope animatedVisibilityScope, @NotNull BoundsTransform boundsTransform, @NotNull SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z, float f, @NotNull SharedTransitionScope.OverlayClip overlayClip) {
        return sharedBoundsImpl(modifier, sharedContentState, animatedVisibilityScope.getTransition(), new Function1<EnterExitState, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl.sharedElement.1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull EnterExitState enterExitState) {
                return Boolean.valueOf(enterExitState == EnterExitState.Visible);
            }
        }, boundsTransform, placeHolderSize, true, z, f, overlayClip);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    @NotNull
    public Modifier sharedElementWithCallerManagedVisibility(@NotNull Modifier modifier, @NotNull SharedTransitionScope.SharedContentState sharedContentState, final boolean z, @NotNull BoundsTransform boundsTransform, @NotNull SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z2, float f, @NotNull SharedTransitionScope.OverlayClip overlayClip) {
        return sharedBoundsImpl(modifier, sharedContentState, null, new Function1<Unit, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl.sharedElementWithCallerManagedVisibility.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Unit unit) {
                return Boolean.valueOf(z);
            }
        }, boundsTransform, placeHolderSize, true, z2, f, overlayClip);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.animation.SharedTransitionScope
    @NotNull
    public Modifier skipToLookaheadSize(@NotNull Modifier modifier) {
        return modifier.then(new SkipToLookaheadElement(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    @Override // androidx.compose.p109ui.layout.LookaheadScope
    @NotNull
    public LayoutCoordinates toLookaheadCoordinates(@NotNull LayoutCoordinates layoutCoordinates) {
        return this.$$delegate_0.toLookaheadCoordinates(layoutCoordinates);
    }
}
