package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntOffsetKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultMeetingParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0091\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ\u0016\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\tJ\u001d\u00106\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u0012\u0010K\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010L\u001a\u00020F2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\tJ\u001e\u0010P\u001a\u00020F2\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004J(\u0010P\u001a\u00020F2\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004H\u0016J\u000e\u0010U\u001a\u00020F2\u0006\u0010+\u001a\u00020\u0004J+\u0010V\u001a\u00020\u0015*\u00020\u00152\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040XH\u0082\bø\u0001\u0000¢\u0006\u0004\bY\u0010ZR\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u00020\u001cX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010'R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0014\u0010)\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u000e\u0010.\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010'\"\u0004\b2\u00103R\u001e\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010%R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010%R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b>\u0010%R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u00020\u0015X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010 R\u0018\u0010?\u001a\u00020\u0004*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0018\u0010B\u001a\u00020\u0004*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006["}, m13886d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "beforeContentPadding", "afterContentPadding", "spacing", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(ILjava/util/List;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIIIJLjava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "getContentType", "()Ljava/lang/Object;", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "()Z", "getKey", "lane", "getLane", "mainAxisLayoutSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "maxMainAxisOffset", "minMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "<set-?>", TypedValues.Cycle.S_WAVE_OFFSET, "getOffset", "placeableOffsets", "", "placeablesCount", "getPlaceablesCount", "size", "getSize", "span", "getSpan", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "applyScrollDelta", "", "delta", "updateAnimations", "getOffset-Bjo55l4", "(I)J", "getParentData", ServerResultMeetingParser.PLACE, "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "isLookingAhead", "position", "mainAxisOffset", "layoutWidth", "layoutHeight", "crossAxisOffset", "updateMainAxisLayoutSize", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyListMeasuredItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyListMeasuredItem.kt\nandroidx/compose/foundation/lazy/LazyListMeasuredItem\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,262:1\n258#1:275\n258#1:277\n33#2,6:263\n69#2,6:269\n1#3:276\n*S KotlinDebug\n*F\n+ 1 LazyListMeasuredItem.kt\nandroidx/compose/foundation/lazy/LazyListMeasuredItem\n*L\n187#1:275\n231#1:277\n101#1:263,6\n137#1:269,6\n*E\n"})
public final class LazyListMeasuredItem implements LazyListItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;

    @NotNull
    private final LazyLayoutItemAnimator<LazyListMeasuredItem> animator;
    private final int beforeContentPadding;
    private final long constraints;

    @Nullable
    private final Object contentType;
    private final int crossAxisSize;

    @Nullable
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;

    @NotNull
    private final Object key;
    private final int lane;

    @NotNull
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private int offset;

    @NotNull
    private final int[] placeableOffsets;

    @NotNull
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final int spacing;
    private final int span;

    @Nullable
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    @ExperimentalFoundationApi
    public /* synthetic */ LazyListMeasuredItem(int i, List list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i4, int i5, long j, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, z, horizontal, vertical, layoutDirection, z2, i2, i4, i5, j, obj, obj2, lazyLayoutItemAnimator, j2);
    }

    /* JADX INFO: renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m15963copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        int iM21096getXimpl = getIsVertical() ? IntOffset.m21096getXimpl(j) : function1.invoke(Integer.valueOf(IntOffset.m21096getXimpl(j))).intValue();
        boolean isVertical = getIsVertical();
        int iM21097getYimpl = IntOffset.m21097getYimpl(j);
        if (isVertical) {
            iM21097getYimpl = function1.invoke(Integer.valueOf(iM21097getYimpl)).intValue();
        }
        return IntOffsetKt.IntOffset(iM21096getXimpl, iM21097getYimpl);
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m15964getMainAxisgyyYBs(long j) {
        return getIsVertical() ? IntOffset.m21097getYimpl(j) : IntOffset.m21096getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return getIsVertical() ? placeable.getHeight() : placeable.getWidth();
    }

    public final void applyScrollDelta(int delta, boolean updateAnimations) {
        if (getNonScrollableItem()) {
            return;
        }
        this.offset = getOffset() + delta;
        int length = this.placeableOffsets.length;
        for (int i = 0; i < length; i++) {
            if ((getIsVertical() && i % 2 == 1) || (!getIsVertical() && i % 2 == 0)) {
                int[] iArr = this.placeableOffsets;
                iArr[i] = iArr[i] + delta;
            }
        }
        if (updateAnimations) {
            int placeablesCount = getPlaceablesCount();
            for (int i2 = 0; i2 < placeablesCount; i2++) {
                LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i2);
                if (animation != null) {
                    long rawOffset = animation.getRawOffset();
                    int iM21096getXimpl = getIsVertical() ? IntOffset.m21096getXimpl(rawOffset) : Integer.valueOf(IntOffset.m21096getXimpl(rawOffset) + delta).intValue();
                    boolean isVertical = getIsVertical();
                    int iM21097getYimpl = IntOffset.m21097getYimpl(rawOffset);
                    if (isVertical) {
                        iM21097getYimpl += delta;
                    }
                    animation.m16017setRawOffsetgyyYBs(IntOffsetKt.IntOffset(iM21096getXimpl, iM21097getYimpl));
                }
            }
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: not valid java name and from getter */
    public long getConstraints() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    @Nullable
    public Object getContentType() {
        return this.contentType;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    @NotNull
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getLane() {
        return this.lane;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public long mo15966getOffsetBjo55l4(int index) {
        int[] iArr = this.placeableOffsets;
        int i = index * 2;
        return IntOffsetKt.IntOffset(iArr[i], iArr[i + 1]);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    @Nullable
    public Object getParentData(int index) {
        return this.placeables.get(index).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getSize() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: isVertical, reason: from getter */
    public boolean getIsVertical() {
        return this.isVertical;
    }

    public final void place(@NotNull Placeable.PlacementScope scope, boolean isLookingAhead) {
        GraphicsLayer layer;
        Placeable.PlacementScope placementScope;
        int iM21096getXimpl;
        int iM21097getYimpl;
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("position() should be called first");
        }
        int placeablesCount = getPlaceablesCount();
        int i = 0;
        while (i < placeablesCount) {
            Placeable placeable = this.placeables.get(i);
            int mainAxisSize = this.minMainAxisOffset - getMainAxisSize(placeable);
            int i2 = this.maxMainAxisOffset;
            long jMo15966getOffsetBjo55l4 = mo15966getOffsetBjo55l4(i);
            LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i);
            if (animation != null) {
                if (isLookingAhead) {
                    animation.m16016setLookaheadOffsetgyyYBs(jMo15966getOffsetBjo55l4);
                } else {
                    if (!IntOffset.m21095equalsimpl0(animation.getLookaheadOffset(), LazyLayoutItemAnimation.INSTANCE.m16018getNotInitializednOccac())) {
                        jMo15966getOffsetBjo55l4 = animation.getLookaheadOffset();
                    }
                    long jM21100plusqkQi6aY = IntOffset.m21100plusqkQi6aY(jMo15966getOffsetBjo55l4, animation.m16013getPlacementDeltanOccac());
                    if ((m15964getMainAxisgyyYBs(jMo15966getOffsetBjo55l4) <= mainAxisSize && m15964getMainAxisgyyYBs(jM21100plusqkQi6aY) <= mainAxisSize) || (m15964getMainAxisgyyYBs(jMo15966getOffsetBjo55l4) >= i2 && m15964getMainAxisgyyYBs(jM21100plusqkQi6aY) >= i2)) {
                        animation.cancelPlacementAnimation();
                    }
                    jMo15966getOffsetBjo55l4 = jM21100plusqkQi6aY;
                }
                layer = animation.getLayer();
            } else {
                layer = null;
            }
            if (this.reverseLayout) {
                if (getIsVertical()) {
                    iM21096getXimpl = IntOffset.m21096getXimpl(jMo15966getOffsetBjo55l4);
                } else {
                    iM21096getXimpl = (this.mainAxisLayoutSize - IntOffset.m21096getXimpl(jMo15966getOffsetBjo55l4)) - getMainAxisSize(placeable);
                }
                if (getIsVertical()) {
                    iM21097getYimpl = (this.mainAxisLayoutSize - IntOffset.m21097getYimpl(jMo15966getOffsetBjo55l4)) - getMainAxisSize(placeable);
                } else {
                    iM21097getYimpl = IntOffset.m21097getYimpl(jMo15966getOffsetBjo55l4);
                }
                jMo15966getOffsetBjo55l4 = IntOffsetKt.IntOffset(iM21096getXimpl, iM21097getYimpl);
            }
            long jM21100plusqkQi6aY2 = IntOffset.m21100plusqkQi6aY(jMo15966getOffsetBjo55l4, this.visualOffset);
            if (!isLookingAhead && animation != null) {
                animation.m16015setFinalOffsetgyyYBs(jM21100plusqkQi6aY2);
            }
            if (!getIsVertical()) {
                placementScope = scope;
                GraphicsLayer graphicsLayer = layer;
                if (graphicsLayer != null) {
                    Placeable.PlacementScope.m19922placeRelativeWithLayeraW9wM$default(placementScope, placeable, jM21100plusqkQi6aY2, graphicsLayer, 0.0f, 4, (Object) null);
                } else {
                    Placeable.PlacementScope.m19921placeRelativeWithLayeraW9wM$default(placementScope, placeable, jM21100plusqkQi6aY2, 0.0f, (Function1) null, 6, (Object) null);
                }
            } else if (layer != null) {
                placementScope = scope;
                Placeable.PlacementScope.m19924placeWithLayeraW9wM$default(placementScope, placeable, jM21100plusqkQi6aY2, layer, 0.0f, 4, (Object) null);
            } else {
                placementScope = scope;
                Placeable.PlacementScope.m19923placeWithLayeraW9wM$default(placementScope, placeable, jM21100plusqkQi6aY2, 0.0f, (Function1) null, 6, (Object) null);
            }
            i++;
            scope = placementScope;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight) {
        position(mainAxisOffset, layoutWidth, layoutHeight);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void setNonScrollableItem(boolean z) {
        this.nonScrollableItem = z;
    }

    public final void updateMainAxisLayoutSize(int mainAxisLayoutSize) {
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.maxMainAxisOffset = mainAxisLayoutSize + this.afterContentPadding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyListMeasuredItem(int i, List<? extends Placeable> list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i4, int i5, long j, Object obj, Object obj2, LazyLayoutItemAnimator<LazyListMeasuredItem> lazyLayoutItemAnimator, long j2) {
        this.index = i;
        this.placeables = list;
        this.isVertical = z;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z2;
        this.beforeContentPadding = i2;
        this.afterContentPadding = i4;
        this.spacing = i5;
        this.visualOffset = j;
        this.key = obj;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j2;
        this.span = 1;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int size = list.size();
        int height = 0;
        int iMax = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Placeable placeable = (Placeable) list.get(i6);
            height += getIsVertical() ? placeable.getHeight() : placeable.getWidth();
            iMax = Math.max(iMax, !getIsVertical() ? placeable.getHeight() : placeable.getWidth());
        }
        this.size = height;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(getSize() + this.spacing, 0);
        this.crossAxisSize = iMax;
        this.placeableOffsets = new int[this.placeables.size() * 2];
    }

    public final void position(int mainAxisOffset, int layoutWidth, int layoutHeight) {
        int width;
        this.offset = mainAxisOffset;
        this.mainAxisLayoutSize = getIsVertical() ? layoutHeight : layoutWidth;
        List<Placeable> list = this.placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable placeable = list.get(i);
            int i2 = i * 2;
            if (getIsVertical()) {
                int[] iArr = this.placeableOffsets;
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalAlignment when isVertical == true");
                }
                iArr[i2] = horizontal.align(placeable.getWidth(), layoutWidth, this.layoutDirection);
                this.placeableOffsets[i2 + 1] = mainAxisOffset;
                width = placeable.getHeight();
            } else {
                int[] iArr2 = this.placeableOffsets;
                iArr2[i2] = mainAxisOffset;
                int i4 = i2 + 1;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalAlignment when isVertical == false");
                }
                iArr2[i4] = vertical.align(placeable.getHeight(), layoutHeight);
                width = placeable.getWidth();
            }
            mainAxisOffset = width + mainAxisOffset;
        }
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }
}
