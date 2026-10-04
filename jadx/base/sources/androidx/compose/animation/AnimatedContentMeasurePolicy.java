package androidx.compose.animation;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.p109ui.layout.IntrinsicMeasurable;
import androidx.compose.p109ui.layout.IntrinsicMeasureScope;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u000e\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J,\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u0019\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/animation/AnimatedContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "rootScope", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "(Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;)V", "getRootScope", "()Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAnimatedContent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimatedContent.kt\nandroidx/compose/animation/AnimatedContentMeasurePolicy\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,899:1\n69#2,6:900\n69#2,6:906\n317#2,8:940\n317#2,8:948\n317#2,8:956\n317#2,8:964\n14166#3,14:912\n14166#3,14:926\n*S KotlinDebug\n*F\n+ 1 AnimatedContent.kt\nandroidx/compose/animation/AnimatedContentMeasurePolicy\n*L\n833#1:900,6\n844#1:906,6\n882#1:940,8\n887#1:948,8\n892#1:956,8\n897#1:964,8\n852#1:912,14\n857#1:926,14\n*E\n"})
final class AnimatedContentMeasurePolicy implements MeasurePolicy {

    @NotNull
    private final AnimatedContentTransitionScopeImpl<?> rootScope;

    public AnimatedContentMeasurePolicy(@NotNull AnimatedContentTransitionScopeImpl<?> animatedContentTransitionScopeImpl) {
        this.rootScope = animatedContentTransitionScopeImpl;
    }

    @NotNull
    public final AnimatedContentTransitionScopeImpl<?> getRootScope() {
        return this.rootScope;
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Integer numValueOf;
        if (list.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(list.get(0).maxIntrinsicHeight(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(list.get(i2).maxIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Integer numValueOf;
        if (list.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(list.get(0).maxIntrinsicWidth(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(list.get(i2).maxIntrinsicWidth(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0101  */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        Placeable placeable;
        Placeable placeable2;
        final int i;
        int width;
        int size = list.size();
        final Placeable[] placeableArr = new Placeable[size];
        long jM21143getZeroYbymL2g = IntSize.INSTANCE.m21143getZeroYbymL2g();
        int size2 = list.size();
        int height = 0;
        int i2 = 0;
        while (true) {
            placeable = null;
            if (i2 >= size2) {
                break;
            }
            Measurable measurable = list.get(i2);
            Object parentData = measurable.getParentData();
            AnimatedContentTransitionScopeImpl.ChildData childData = parentData instanceof AnimatedContentTransitionScopeImpl.ChildData ? (AnimatedContentTransitionScopeImpl.ChildData) parentData : null;
            if (childData != null && childData.isTarget()) {
                Placeable placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(j);
                long jIntSize = IntSizeKt.IntSize(placeableMo19855measureBRTryo0.getWidth(), placeableMo19855measureBRTryo0.getHeight());
                Unit unit = Unit.INSTANCE;
                placeableArr[i2] = placeableMo19855measureBRTryo0;
                jM21143getZeroYbymL2g = jIntSize;
            }
            i2++;
        }
        int size3 = list.size();
        for (int i4 = 0; i4 < size3; i4++) {
            Measurable measurable2 = list.get(i4);
            if (placeableArr[i4] == null) {
                placeableArr[i4] = measurable2.mo19855measureBRTryo0(j);
            }
        }
        if (measureScope.isLookingAhead()) {
            width = IntSize.m21138getWidthimpl(jM21143getZeroYbymL2g);
        } else {
            if (size == 0) {
                placeable2 = null;
            } else {
                placeable2 = placeableArr[0];
                int lastIndex = ArraysKt.getLastIndex(placeableArr);
                if (lastIndex != 0) {
                    int width2 = placeable2 != null ? placeable2.getWidth() : 0;
                    ?? it = new IntRange(1, lastIndex).iterator();
                    while (it.hasNext()) {
                        Placeable placeable3 = placeableArr[it.nextInt()];
                        int width3 = placeable3 != null ? placeable3.getWidth() : 0;
                        if (width2 < width3) {
                            placeable2 = placeable3;
                            width2 = width3;
                        }
                    }
                }
            }
            if (placeable2 == null) {
                i = 0;
                if (measureScope.isLookingAhead()) {
                    if (size != 0) {
                        placeable = placeableArr[0];
                        int lastIndex2 = ArraysKt.getLastIndex(placeableArr);
                        if (lastIndex2 != 0) {
                            int height2 = placeable != null ? placeable.getHeight() : 0;
                            ?? it2 = new IntRange(1, lastIndex2).iterator();
                            while (it2.hasNext()) {
                                Placeable placeable4 = placeableArr[it2.nextInt()];
                                int height3 = placeable4 != null ? placeable4.getHeight() : 0;
                                if (height2 < height3) {
                                    placeable = placeable4;
                                    height2 = height3;
                                }
                            }
                        }
                    }
                    if (placeable != null) {
                        height = placeable.getHeight();
                    }
                } else {
                    height = IntSize.m21137getHeightimpl(jM21143getZeroYbymL2g);
                }
                final int i5 = height;
                if (!measureScope.isLookingAhead()) {
                    this.rootScope.m15239setMeasuredSizeozmzZPI$animation_release(IntSizeKt.IntSize(i, i5));
                }
                return MeasureScope.layout$default(measureScope, i, i5, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentMeasurePolicy$measure$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                        Placeable.PlacementScope placementScope2;
                        Placeable[] placeableArr2 = placeableArr;
                        AnimatedContentMeasurePolicy animatedContentMeasurePolicy = this;
                        int i6 = i;
                        int i7 = i5;
                        int length = placeableArr2.length;
                        int i8 = 0;
                        while (i8 < length) {
                            Placeable placeable5 = placeableArr2[i8];
                            if (placeable5 != null) {
                                long jMo18130alignKFBX0sM = animatedContentMeasurePolicy.getRootScope().getContentAlignment().mo18130alignKFBX0sM(IntSizeKt.IntSize(placeable5.getWidth(), placeable5.getHeight()), IntSizeKt.IntSize(i6, i7), LayoutDirection.Ltr);
                                placementScope2 = placementScope;
                                Placeable.PlacementScope.place$default(placementScope2, placeable5, IntOffset.m21096getXimpl(jMo18130alignKFBX0sM), IntOffset.m21097getYimpl(jMo18130alignKFBX0sM), 0.0f, 4, null);
                            } else {
                                placementScope2 = placementScope;
                            }
                            i8++;
                            placementScope = placementScope2;
                        }
                    }
                }, 4, null);
            }
            width = placeable2.getWidth();
        }
        i = width;
        if (measureScope.isLookingAhead()) {
        }
        final int i52 = height;
        if (!measureScope.isLookingAhead()) {
        }
        return MeasureScope.layout$default(measureScope, i, i52, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentMeasurePolicy$measure$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope placementScope2;
                Placeable[] placeableArr2 = placeableArr;
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy = this;
                int i6 = i;
                int i7 = i52;
                int length = placeableArr2.length;
                int i8 = 0;
                while (i8 < length) {
                    Placeable placeable5 = placeableArr2[i8];
                    if (placeable5 != null) {
                        long jMo18130alignKFBX0sM = animatedContentMeasurePolicy.getRootScope().getContentAlignment().mo18130alignKFBX0sM(IntSizeKt.IntSize(placeable5.getWidth(), placeable5.getHeight()), IntSizeKt.IntSize(i6, i7), LayoutDirection.Ltr);
                        placementScope2 = placementScope;
                        Placeable.PlacementScope.place$default(placementScope2, placeable5, IntOffset.m21096getXimpl(jMo18130alignKFBX0sM), IntOffset.m21097getYimpl(jMo18130alignKFBX0sM), 0.0f, 4, null);
                    } else {
                        placementScope2 = placementScope;
                    }
                    i8++;
                    placementScope = placementScope2;
                }
            }
        }, 4, null);
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Integer numValueOf;
        if (list.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(list.get(0).minIntrinsicHeight(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(list.get(i2).minIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.p109ui.layout.MeasurePolicy
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Integer numValueOf;
        if (list.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(list.get(0).minIntrinsicWidth(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(list.get(i2).minIntrinsicWidth(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }
}
