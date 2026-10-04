package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.GraphicsContext;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.p109ui.node.DrawModifierNode;
import androidx.compose.p109ui.node.DrawModifierNodeKt;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntOffsetKt;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0003IJKB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010(\u001a\u0004\u0018\u00010\u00072\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u000bJ1\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\u000b2\u0012\b\u0002\u0010.\u001a\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002¢\u0006\u0002\u0010/J\u0082\u0001\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\f\u001a\u00020\r2\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000062\u0006\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@J\u0010\u0010A\u001a\u00020,2\u0006\u0010)\u001a\u00020\u0003H\u0002J\u0006\u0010B\u001a\u00020,J\u001f\u0010C\u001a\u00020,2\u0006\u0010-\u001a\u00028\u00002\b\b\u0002\u0010D\u001a\u00020#H\u0002¢\u0006\u0002\u0010EJ\u0019\u0010F\u001a\u00020\u000b*\u00020G2\u0006\u0010-\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010HR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\u00020\u00128Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\u00020\u000b*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\u00020#*\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0018\u0010&\u001a\u00020\u000b*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006L"}, m13886d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "T", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "()V", "disappearingItems", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "displayingNode", "Landroidx/compose/ui/node/DrawModifierNode;", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "minSizeToFitDisappearingItems", "Landroidx/compose/ui/unit/IntSize;", "getMinSizeToFitDisappearingItems-YbymL2g", "()J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingAwayToEndBound", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "crossAxisOffset", "getCrossAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)Z", "mainAxisOffset", "getMainAxisOffset", "getAnimation", "key", "placeableIndex", "initializeAnimation", "", "item", "itemInfo", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;ILandroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;)V", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "isVertical", "isLookingAhead", "laneCount", "hasLookaheadOccurred", "layoutMinOffset", "layoutMaxOffset", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "removeInfoForKey", "reset", "startPlacementAnimationsIfNeeded", "isMovingAway", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Z)V", "updateAndReturnOffsetFor", "", "([ILandroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "DisplayingDisappearingItemsElement", "DisplayingDisappearingItemsNode", "ItemInfo", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyLayoutItemAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyLayoutItemAnimator.kt\nandroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 4 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 7 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 8 ScatterSet.kt\nandroidx/collection/ScatterSet\n*L\n1#1,572:1\n101#2,2:573\n33#2,6:575\n103#2:581\n33#2,4:607\n38#2:618\n33#2,6:621\n33#2,6:629\n33#2,6:669\n33#2,6:677\n33#2,6:718\n405#3,3:582\n363#3,6:585\n373#3,3:592\n376#3,2:596\n409#3,2:598\n379#3,6:600\n411#3:606\n418#3,3:685\n363#3,6:688\n373#3,3:695\n376#3,2:699\n422#3:701\n423#3:704\n379#3,6:705\n424#3:711\n1810#4:591\n1672#4:595\n1810#4:646\n1672#4:650\n1810#4:694\n1672#4:698\n1#5:611\n13579#6,2:612\n13579#6,2:614\n13579#6,2:616\n13644#6,3:654\n12744#6,2:657\n13579#6,2:683\n13579#6,2:702\n13644#6,3:712\n13644#6,3:715\n1011#7,2:619\n1002#7,2:627\n1011#7,2:667\n1002#7,2:675\n267#8,4:635\n237#8,7:639\n248#8,3:647\n251#8,2:651\n272#8:653\n273#8:659\n254#8,6:660\n274#8:666\n*S KotlinDebug\n*F\n+ 1 LazyLayoutItemAnimator.kt\nandroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator\n*L\n89#1:573,2\n89#1:575,6\n89#1:581\n112#1:607,4\n112#1:618\n189#1:621,6\n199#1:629,6\n286#1:669,6\n310#1:677,6\n424#1:718,6\n110#1:582,3\n110#1:585,6\n110#1:592,3\n110#1:596,2\n110#1:598,2\n110#1:600,6\n110#1:606\n357#1:685,3\n357#1:688,6\n357#1:695,3\n357#1:699,2\n357#1:701\n357#1:704\n357#1:705,6\n357#1:711\n110#1:591\n110#1:595\n210#1:646\n210#1:650\n357#1:694\n357#1:698\n144#1:612,2\n158#1:614,2\n166#1:616,2\n223#1:654,3\n261#1:657,2\n346#1:683,2\n358#1:702,2\n382#1:712,3\n393#1:715,3\n188#1:619,2\n198#1:627,2\n285#1:667,2\n309#1:675,2\n210#1:635,4\n210#1:639,7\n210#1:647,3\n210#1:651,2\n210#1:653\n210#1:659\n210#1:660,6\n210#1:666\n*E\n"})
public final class LazyLayoutItemAnimator<T extends LazyLayoutMeasuredItem> {
    public static final int $stable = 8;

    @Nullable
    private DrawModifierNode displayingNode;
    private int firstVisibleIndex;

    @Nullable
    private LazyLayoutKeyIndexMap keyIndexMap;

    @NotNull
    private final MutableScatterMap<Object, LazyLayoutItemAnimator<T>.ItemInfo> keyToItemInfoMap = ScatterMapKt.mutableScatterMapOf();

    @NotNull
    private final MutableScatterSet<Object> movingAwayKeys = ScatterSetKt.mutableScatterSetOf();

    @NotNull
    private final List<T> movingInFromStartBound = new ArrayList();

    @NotNull
    private final List<T> movingInFromEndBound = new ArrayList();

    @NotNull
    private final List<T> movingAwayToStartBound = new ArrayList();

    @NotNull
    private final List<T> movingAwayToEndBound = new ArrayList();

    @NotNull
    private final List<LazyLayoutItemAnimation> disappearingItems = new ArrayList();

    @NotNull
    private final Modifier modifier = new DisplayingDisappearingItemsElement(this);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\f\u0010\u0014\u001a\u00020\u0012*\u00020\u0015H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.ARG_UPDATE, "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class DisplayingDisappearingItemsElement extends ModifierNodeElement<DisplayingDisappearingItemsNode> {

        @NotNull
        private final LazyLayoutItemAnimator<?> animator;

        public DisplayingDisappearingItemsElement(@NotNull LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            this.animator = lazyLayoutItemAnimator;
        }

        private final LazyLayoutItemAnimator<?> component1() {
            return this.animator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DisplayingDisappearingItemsElement copy$default(DisplayingDisappearingItemsElement displayingDisappearingItemsElement, LazyLayoutItemAnimator lazyLayoutItemAnimator, int i, Object obj) {
            if ((i & 1) != 0) {
                lazyLayoutItemAnimator = displayingDisappearingItemsElement.animator;
            }
            return displayingDisappearingItemsElement.copy(lazyLayoutItemAnimator);
        }

        @NotNull
        public final DisplayingDisappearingItemsElement copy(@NotNull LazyLayoutItemAnimator<?> animator) {
            return new DisplayingDisappearingItemsElement(animator);
        }

        @Override // androidx.compose.p109ui.node.ModifierNodeElement
        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DisplayingDisappearingItemsElement) && Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsElement) other).animator);
        }

        @Override // androidx.compose.p109ui.node.ModifierNodeElement
        public int hashCode() {
            return this.animator.hashCode();
        }

        @Override // androidx.compose.p109ui.node.ModifierNodeElement
        public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
            inspectorInfo.setName("DisplayingDisappearingItemsElement");
        }

        @NotNull
        public String toString() {
            return "DisplayingDisappearingItemsElement(animator=" + this.animator + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // androidx.compose.p109ui.node.ModifierNodeElement
        @NotNull
        /* JADX INFO: renamed from: create */
        public DisplayingDisappearingItemsNode getNode() {
            return new DisplayingDisappearingItemsNode(this.animator);
        }

        @Override // androidx.compose.p109ui.node.ModifierNodeElement
        public void update(@NotNull DisplayingDisappearingItemsNode node) {
            node.setAnimator(this.animator);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\f\u0010\u0014\u001a\u00020\u000f*\u00020\u0015H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "onAttach", "", "onDetach", "setAnimator", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nLazyLayoutItemAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyLayoutItemAnimator.kt\nandroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n*L\n1#1,572:1\n33#2,4:573\n38#2:584\n128#3,7:577\n*S KotlinDebug\n*F\n+ 1 LazyLayoutItemAnimator.kt\nandroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode\n*L\n538#1:573,4\n538#1:584\n542#1:577,7\n*E\n"})
    public static final /* data */ class DisplayingDisappearingItemsNode extends Modifier.Node implements DrawModifierNode {

        @NotNull
        private LazyLayoutItemAnimator<?> animator;

        public DisplayingDisappearingItemsNode(@NotNull LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            this.animator = lazyLayoutItemAnimator;
        }

        private final LazyLayoutItemAnimator<?> component1() {
            return this.animator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DisplayingDisappearingItemsNode copy$default(DisplayingDisappearingItemsNode displayingDisappearingItemsNode, LazyLayoutItemAnimator lazyLayoutItemAnimator, int i, Object obj) {
            if ((i & 1) != 0) {
                lazyLayoutItemAnimator = displayingDisappearingItemsNode.animator;
            }
            return displayingDisappearingItemsNode.copy(lazyLayoutItemAnimator);
        }

        @NotNull
        public final DisplayingDisappearingItemsNode copy(@NotNull LazyLayoutItemAnimator<?> animator) {
            return new DisplayingDisappearingItemsNode(animator);
        }

        @Override // androidx.compose.p109ui.node.DrawModifierNode
        public void draw(@NotNull ContentDrawScope contentDrawScope) {
            List list = ((LazyLayoutItemAnimator) this.animator).disappearingItems;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimation = (LazyLayoutItemAnimation) list.get(i);
                GraphicsLayer layer = lazyLayoutItemAnimation.getLayer();
                if (layer != null) {
                    float fM21096getXimpl = IntOffset.m21096getXimpl(lazyLayoutItemAnimation.getFinalOffset());
                    float fM21096getXimpl2 = fM21096getXimpl - IntOffset.m21096getXimpl(layer.getTopLeft());
                    float fM21097getYimpl = IntOffset.m21097getYimpl(lazyLayoutItemAnimation.getFinalOffset()) - IntOffset.m21097getYimpl(layer.getTopLeft());
                    contentDrawScope.getDrawContext().getTransform().translate(fM21096getXimpl2, fM21097getYimpl);
                    try {
                        GraphicsLayerKt.drawLayer(contentDrawScope, layer);
                    } finally {
                        contentDrawScope.getDrawContext().getTransform().translate(-fM21096getXimpl2, -fM21097getYimpl);
                    }
                }
            }
            contentDrawScope.drawContent();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DisplayingDisappearingItemsNode) && Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsNode) other).animator);
        }

        public int hashCode() {
            return this.animator.hashCode();
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onAttach() {
            ((LazyLayoutItemAnimator) this.animator).displayingNode = this;
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onDetach() {
            this.animator.reset();
        }

        public final void setAnimator(@NotNull LazyLayoutItemAnimator<?> animator) {
            if (Intrinsics.areEqual(this.animator, animator) || !getNode().getIsAttached()) {
                return;
            }
            this.animator.reset();
            ((LazyLayoutItemAnimator) animator).displayingNode = this;
            this.animator = animator;
        }

        @NotNull
        public String toString() {
            return "DisplayingDisappearingItemsNode(animator=" + this.animator + PropertyUtils.MAPPED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J=\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00028\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010*R0\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u001e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u001a\u0010 \u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, m13886d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "<set-?>", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "animations", "getAnimations", "()[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "setConstraints-_Sx5XlM", "(Landroidx/compose/ui/unit/Constraints;)V", "crossAxisOffset", "", "getCrossAxisOffset", "()I", "setCrossAxisOffset", "(I)V", "isRunningPlacement", "", "()Z", "lane", "getLane", "setLane", "layoutMaxOffset", "getLayoutMaxOffset", "layoutMinOffset", "getLayoutMinOffset", "span", "getSpan", "setSpan", "updateAnimation", "", "positionedItem", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;III)V", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nLazyLayoutItemAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyLayoutItemAnimator.kt\nandroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,572:1\n12744#2,2:573\n*S KotlinDebug\n*F\n+ 1 LazyLayoutItemAnimator.kt\nandroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo\n*L\n468#1:573,2\n*E\n"})
    public final class ItemInfo {

        @Nullable
        private Constraints constraints;
        private int crossAxisOffset;
        private int lane;
        private int layoutMaxOffset;
        private int layoutMinOffset;

        @NotNull
        private LazyLayoutItemAnimation[] animations = LazyLayoutItemAnimatorKt.EmptyArray;
        private int span = 1;

        public ItemInfo() {
        }

        private final boolean isRunningPlacement() {
            for (LazyLayoutItemAnimation lazyLayoutItemAnimation : this.animations) {
                if (lazyLayoutItemAnimation != null && lazyLayoutItemAnimation.getIsRunningMovingAwayAnimation()) {
                    return true;
                }
            }
            return false;
        }

        public static /* synthetic */ void updateAnimation$default(ItemInfo itemInfo, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, CoroutineScope coroutineScope, GraphicsContext graphicsContext, int i, int i2, int i4, int i5, Object obj) {
            if ((i5 & 32) != 0) {
                i4 = LazyLayoutItemAnimator.this.getCrossAxisOffset(lazyLayoutMeasuredItem);
            }
            itemInfo.updateAnimation(lazyLayoutMeasuredItem, coroutineScope, graphicsContext, i, i2, i4);
        }

        @NotNull
        public final LazyLayoutItemAnimation[] getAnimations() {
            return this.animations;
        }

        @Nullable
        /* JADX INFO: renamed from: getConstraints-DWUhwKw, reason: not valid java name and from getter */
        public final Constraints getConstraints() {
            return this.constraints;
        }

        public final int getCrossAxisOffset() {
            return this.crossAxisOffset;
        }

        public final int getLane() {
            return this.lane;
        }

        public final int getLayoutMaxOffset() {
            return this.layoutMaxOffset;
        }

        public final int getLayoutMinOffset() {
            return this.layoutMinOffset;
        }

        public final int getSpan() {
            return this.span;
        }

        /* JADX INFO: renamed from: setConstraints-_Sx5XlM, reason: not valid java name */
        public final void m16021setConstraints_Sx5XlM(@Nullable Constraints constraints) {
            this.constraints = constraints;
        }

        public final void setCrossAxisOffset(int i) {
            this.crossAxisOffset = i;
        }

        public final void setLane(int i) {
            this.lane = i;
        }

        public final void setSpan(int i) {
            this.span = i;
        }

        public final void updateAnimation(@NotNull T positionedItem, @NotNull CoroutineScope coroutineScope, @NotNull GraphicsContext graphicsContext, int layoutMinOffset, int layoutMaxOffset, int crossAxisOffset) {
            if (!isRunningPlacement()) {
                this.layoutMinOffset = layoutMinOffset;
                this.layoutMaxOffset = layoutMaxOffset;
            }
            int length = this.animations.length;
            for (int placeablesCount = positionedItem.getPlaceablesCount(); placeablesCount < length; placeablesCount++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimation = this.animations[placeablesCount];
                if (lazyLayoutItemAnimation != null) {
                    lazyLayoutItemAnimation.release();
                }
            }
            if (this.animations.length != positionedItem.getPlaceablesCount()) {
                Object[] objArrCopyOf = Arrays.copyOf(this.animations, positionedItem.getPlaceablesCount());
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
                this.animations = (LazyLayoutItemAnimation[]) objArrCopyOf;
            }
            this.constraints = Constraints.m20909boximpl(positionedItem.getConstraints());
            this.crossAxisOffset = crossAxisOffset;
            this.lane = positionedItem.getLane();
            this.span = positionedItem.getSpan();
            int placeablesCount2 = positionedItem.getPlaceablesCount();
            final LazyLayoutItemAnimator<T> lazyLayoutItemAnimator = LazyLayoutItemAnimator.this;
            for (int i = 0; i < placeablesCount2; i++) {
                LazyLayoutAnimationSpecsNode specs = LazyLayoutItemAnimatorKt.getSpecs(positionedItem.getParentData(i));
                if (specs == null) {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation2 = this.animations[i];
                    if (lazyLayoutItemAnimation2 != null) {
                        lazyLayoutItemAnimation2.release();
                    }
                    this.animations[i] = null;
                } else {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation3 = this.animations[i];
                    if (lazyLayoutItemAnimation3 == null) {
                        lazyLayoutItemAnimation3 = new LazyLayoutItemAnimation(coroutineScope, graphicsContext, new Function0<Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo$updateAnimation$1$animation$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                DrawModifierNode drawModifierNode = ((LazyLayoutItemAnimator) lazyLayoutItemAnimator).displayingNode;
                                if (drawModifierNode != null) {
                                    DrawModifierNodeKt.invalidateDraw(drawModifierNode);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }
                        });
                        this.animations[i] = lazyLayoutItemAnimation3;
                    }
                    lazyLayoutItemAnimation3.setFadeInSpec(specs.getFadeInSpec());
                    lazyLayoutItemAnimation3.setPlacementSpec(specs.getPlacementSpec());
                    lazyLayoutItemAnimation3.setFadeOutSpec(specs.getFadeOutSpec());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCrossAxisOffset(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long jMo15966getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo15966getOffsetBjo55l4(0);
        return !lazyLayoutMeasuredItem.getIsVertical() ? IntOffset.m21097getYimpl(jMo15966getOffsetBjo55l4) : IntOffset.m21096getXimpl(jMo15966getOffsetBjo55l4);
    }

    private final boolean getHasAnimations(T t) {
        int placeablesCount = t.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (LazyLayoutItemAnimatorKt.getSpecs(t.getParentData(i)) != null) {
                return true;
            }
        }
        return false;
    }

    private final int getMainAxisOffset(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long jMo15966getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo15966getOffsetBjo55l4(0);
        return lazyLayoutMeasuredItem.getIsVertical() ? IntOffset.m21097getYimpl(jMo15966getOffsetBjo55l4) : IntOffset.m21096getXimpl(jMo15966getOffsetBjo55l4);
    }

    private final void initializeAnimation(T item, int mainAxisOffset, LazyLayoutItemAnimator<T>.ItemInfo itemInfo) {
        int i = 0;
        long jMo15966getOffsetBjo55l4 = item.mo15966getOffsetBjo55l4(0);
        long jM21092copyiSbpLlY$default = item.getIsVertical() ? IntOffset.m21092copyiSbpLlY$default(jMo15966getOffsetBjo55l4, 0, mainAxisOffset, 1, null) : IntOffset.m21092copyiSbpLlY$default(jMo15966getOffsetBjo55l4, mainAxisOffset, 0, 2, null);
        LazyLayoutItemAnimation[] animations = itemInfo.getAnimations();
        int length = animations.length;
        int i2 = 0;
        while (i < length) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = animations[i];
            int i4 = i2 + 1;
            if (lazyLayoutItemAnimation != null) {
                lazyLayoutItemAnimation.m16017setRawOffsetgyyYBs(IntOffset.m21100plusqkQi6aY(jM21092copyiSbpLlY$default, IntOffset.m21099minusqkQi6aY(item.mo15966getOffsetBjo55l4(i2), jMo15966getOffsetBjo55l4)));
            }
            i++;
            i2 = i4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void initializeAnimation$default(LazyLayoutItemAnimator lazyLayoutItemAnimator, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, int i, ItemInfo itemInfo, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            LazyLayoutItemAnimator<T>.ItemInfo itemInfo2 = lazyLayoutItemAnimator.keyToItemInfoMap.get(lazyLayoutMeasuredItem.getKey());
            Intrinsics.checkNotNull(itemInfo2);
            itemInfo = itemInfo2;
        }
        lazyLayoutItemAnimator.initializeAnimation(lazyLayoutMeasuredItem, i, itemInfo);
    }

    private final void removeInfoForKey(Object key) {
        LazyLayoutItemAnimation[] animations;
        LazyLayoutItemAnimator<T>.ItemInfo itemInfoRemove = this.keyToItemInfoMap.remove(key);
        if (itemInfoRemove == null || (animations = itemInfoRemove.getAnimations()) == null) {
            return;
        }
        for (LazyLayoutItemAnimation lazyLayoutItemAnimation : animations) {
            if (lazyLayoutItemAnimation != null) {
                lazyLayoutItemAnimation.release();
            }
        }
    }

    private final void startPlacementAnimationsIfNeeded(T item, boolean isMovingAway) {
        LazyLayoutItemAnimator<T>.ItemInfo itemInfo = this.keyToItemInfoMap.get(item.getKey());
        Intrinsics.checkNotNull(itemInfo);
        LazyLayoutItemAnimation[] animations = itemInfo.getAnimations();
        int length = animations.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = animations[i];
            int i4 = i2 + 1;
            if (lazyLayoutItemAnimation != null) {
                long jMo15966getOffsetBjo55l4 = item.mo15966getOffsetBjo55l4(i2);
                long rawOffset = lazyLayoutItemAnimation.getRawOffset();
                if (!IntOffset.m21095equalsimpl0(rawOffset, LazyLayoutItemAnimation.INSTANCE.m16018getNotInitializednOccac()) && !IntOffset.m21095equalsimpl0(rawOffset, jMo15966getOffsetBjo55l4)) {
                    lazyLayoutItemAnimation.m16010animatePlacementDeltaar5cAso(IntOffset.m21099minusqkQi6aY(jMo15966getOffsetBjo55l4, rawOffset), isMovingAway);
                }
                lazyLayoutItemAnimation.m16017setRawOffsetgyyYBs(jMo15966getOffsetBjo55l4);
            }
            i++;
            i2 = i4;
        }
    }

    public static /* synthetic */ void startPlacementAnimationsIfNeeded$default(LazyLayoutItemAnimator lazyLayoutItemAnimator, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        lazyLayoutItemAnimator.startPlacementAnimationsIfNeeded(lazyLayoutMeasuredItem, z);
    }

    private final int updateAndReturnOffsetFor(int[] iArr, T t) {
        int lane = t.getLane();
        int span = t.getSpan() + lane;
        int iMax = 0;
        while (lane < span) {
            int mainAxisSizeWithSpacings = t.getMainAxisSizeWithSpacings() + iArr[lane];
            iArr[lane] = mainAxisSizeWithSpacings;
            iMax = Math.max(iMax, mainAxisSizeWithSpacings);
            lane++;
        }
        return iMax;
    }

    @Nullable
    public final LazyLayoutItemAnimation getAnimation(@NotNull Object key, int placeableIndex) {
        LazyLayoutItemAnimation[] animations;
        LazyLayoutItemAnimator<T>.ItemInfo itemInfo = this.keyToItemInfoMap.get(key);
        if (itemInfo == null || (animations = itemInfo.getAnimations()) == null) {
            return null;
        }
        return animations[placeableIndex];
    }

    /* JADX INFO: renamed from: getMinSizeToFitDisappearingItems-YbymL2g, reason: not valid java name */
    public final long m16019getMinSizeToFitDisappearingItemsYbymL2g() {
        long jM21143getZeroYbymL2g = IntSize.INSTANCE.m21143getZeroYbymL2g();
        List<LazyLayoutItemAnimation> list = this.disappearingItems;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = list.get(i);
            GraphicsLayer layer = lazyLayoutItemAnimation.getLayer();
            if (layer != null) {
                jM21143getZeroYbymL2g = IntSizeKt.IntSize(Math.max(IntSize.m21138getWidthimpl(jM21143getZeroYbymL2g), IntSize.m21138getWidthimpl(layer.getSize()) + IntOffset.m21096getXimpl(lazyLayoutItemAnimation.getRawOffset())), Math.max(IntSize.m21137getHeightimpl(jM21143getZeroYbymL2g), IntSize.m21137getHeightimpl(layer.getSize()) + IntOffset.m21097getYimpl(lazyLayoutItemAnimation.getRawOffset())));
            }
        }
        return jM21143getZeroYbymL2g;
    }

    @NotNull
    public final Modifier getModifier() {
        return this.modifier;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v24, types: [androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r34v1, types: [androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo] */
    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, @NotNull List<T> positionedItems, @NotNull final LazyLayoutKeyIndexMap keyIndexMap, @NotNull LazyLayoutMeasuredItemProvider<T> itemProvider, boolean isVertical, boolean isLookingAhead, int laneCount, boolean hasLookaheadOccurred, int layoutMinOffset, int layoutMaxOffset, @NotNull CoroutineScope coroutineScope, @NotNull GraphicsContext graphicsContext) {
        int i;
        int i2;
        int i4;
        Object[] objArr;
        long[] jArr;
        int i5;
        Object[] objArr2;
        long[] jArr2;
        int i6;
        LazyLayoutItemAnimation[] lazyLayoutItemAnimationArr;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        long[] jArr3;
        long[] jArr4;
        int i12;
        int i13 = laneCount;
        final LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap = this.keyIndexMap;
        this.keyIndexMap = keyIndexMap;
        int size = positionedItems.size();
        int i14 = 0;
        while (true) {
            if (i14 >= size) {
                if (this.keyToItemInfoMap.isEmpty()) {
                    reset();
                    return;
                }
            } else if (getHasAnimations(positionedItems.get(i14))) {
                break;
            } else {
                i14++;
            }
        }
        int i15 = this.firstVisibleIndex;
        LazyLayoutMeasuredItem lazyLayoutMeasuredItem = (LazyLayoutMeasuredItem) CollectionsKt.firstOrNull((List) positionedItems);
        this.firstVisibleIndex = lazyLayoutMeasuredItem != null ? lazyLayoutMeasuredItem.getIndex() : 0;
        long jIntOffset = isVertical ? IntOffsetKt.IntOffset(0, consumedScroll) : IntOffsetKt.IntOffset(consumedScroll, 0);
        boolean z = isLookingAhead || !hasLookaheadOccurred;
        MutableScatterMap<Object, LazyLayoutItemAnimator<T>.ItemInfo> mutableScatterMap = this.keyToItemInfoMap;
        Object[] objArr3 = mutableScatterMap.keys;
        long[] jArr5 = mutableScatterMap.metadata;
        int length = jArr5.length - 2;
        if (length >= 0) {
            int i16 = 0;
            while (true) {
                long j = jArr5[i16];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i17 = 8 - ((~(i16 - length)) >>> 31);
                    int i18 = 0;
                    while (i18 < i17) {
                        if ((j & 255) < 128) {
                            jArr4 = jArr5;
                            i12 = i18;
                            this.movingAwayKeys.add(objArr3[(i16 << 3) + i18]);
                        } else {
                            jArr4 = jArr5;
                            i12 = i18;
                        }
                        j >>= 8;
                        i18 = i12 + 1;
                        jArr5 = jArr4;
                    }
                    jArr3 = jArr5;
                    if (i17 != 8) {
                        break;
                    }
                } else {
                    jArr3 = jArr5;
                }
                if (i16 == length) {
                    break;
                }
                i16++;
                jArr5 = jArr3;
            }
        }
        int size2 = positionedItems.size();
        int i19 = 0;
        while (i19 < size2) {
            T t = positionedItems.get(i19);
            this.movingAwayKeys.remove(t.getKey());
            if (getHasAnimations(t)) {
                LazyLayoutItemAnimator<T>.ItemInfo itemInfo = this.keyToItemInfoMap.get(t.getKey());
                int index = lazyLayoutKeyIndexMap != null ? lazyLayoutKeyIndexMap.getIndex(t.getKey()) : -1;
                boolean z2 = index == -1 && lazyLayoutKeyIndexMap != null;
                if (itemInfo == null) {
                    LazyLayoutItemAnimator<T>.ItemInfo itemInfo2 = new ItemInfo();
                    ItemInfo.updateAnimation$default(itemInfo2, t, coroutineScope, graphicsContext, layoutMinOffset, layoutMaxOffset, 0, 32, null);
                    i7 = size2;
                    this.keyToItemInfoMap.set(t.getKey(), itemInfo2);
                    if (t.getIndex() == index || index == -1) {
                        long jMo15966getOffsetBjo55l4 = t.mo15966getOffsetBjo55l4(0);
                        initializeAnimation(t, t.getIsVertical() ? IntOffset.m21097getYimpl(jMo15966getOffsetBjo55l4) : IntOffset.m21096getXimpl(jMo15966getOffsetBjo55l4), itemInfo2);
                        if (z2) {
                            LazyLayoutItemAnimation[] animations = itemInfo2.getAnimations();
                            for (LazyLayoutItemAnimation lazyLayoutItemAnimation : animations) {
                                if (lazyLayoutItemAnimation != null) {
                                    lazyLayoutItemAnimation.animateAppearance();
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                        }
                    } else if (index < i15) {
                        this.movingInFromStartBound.add(t);
                    } else {
                        this.movingInFromEndBound.add(t);
                    }
                } else {
                    i7 = size2;
                    if (z) {
                        ItemInfo.updateAnimation$default(itemInfo, t, coroutineScope, graphicsContext, layoutMinOffset, layoutMaxOffset, 0, 32, null);
                        LazyLayoutItemAnimation[] animations2 = itemInfo.getAnimations();
                        int length2 = animations2.length;
                        int i20 = 0;
                        while (i20 < length2) {
                            LazyLayoutItemAnimation lazyLayoutItemAnimation2 = animations2[i20];
                            LazyLayoutItemAnimation[] lazyLayoutItemAnimationArr2 = animations2;
                            int i21 = i15;
                            if (lazyLayoutItemAnimation2 != null) {
                                i10 = i19;
                                i11 = length2;
                                if (!IntOffset.m21095equalsimpl0(lazyLayoutItemAnimation2.getRawOffset(), LazyLayoutItemAnimation.INSTANCE.m16018getNotInitializednOccac())) {
                                    lazyLayoutItemAnimation2.m16017setRawOffsetgyyYBs(IntOffset.m21100plusqkQi6aY(lazyLayoutItemAnimation2.getRawOffset(), jIntOffset));
                                }
                            } else {
                                i10 = i19;
                                i11 = length2;
                            }
                            i20++;
                            animations2 = lazyLayoutItemAnimationArr2;
                            i15 = i21;
                            i19 = i10;
                            length2 = i11;
                        }
                        i8 = i15;
                        i9 = i19;
                        if (z2) {
                            for (LazyLayoutItemAnimation lazyLayoutItemAnimation3 : itemInfo.getAnimations()) {
                                if (lazyLayoutItemAnimation3 != null) {
                                    if (lazyLayoutItemAnimation3.isDisappearanceAnimationInProgress()) {
                                        this.disappearingItems.remove(lazyLayoutItemAnimation3);
                                        DrawModifierNode drawModifierNode = this.displayingNode;
                                        if (drawModifierNode != null) {
                                            DrawModifierNodeKt.invalidateDraw(drawModifierNode);
                                            Unit unit2 = Unit.INSTANCE;
                                        }
                                    }
                                    lazyLayoutItemAnimation3.animateAppearance();
                                }
                            }
                        }
                        startPlacementAnimationsIfNeeded$default(this, t, false, 2, null);
                    }
                }
                i8 = i15;
                i9 = i19;
            } else {
                i7 = size2;
                i8 = i15;
                i9 = i19;
                removeInfoForKey(t.getKey());
            }
            i19 = i9 + 1;
            i15 = i8;
            size2 = i7;
        }
        int i22 = 2;
        int[] iArr = new int[i13];
        for (int i23 = 0; i23 < i13; i23++) {
            iArr[i23] = 0;
        }
        if (!z || lazyLayoutKeyIndexMap == null) {
            i = 2;
        } else {
            if (this.movingInFromStartBound.isEmpty()) {
                i = 2;
            } else {
                List<T> list = this.movingInFromStartBound;
                if (list.size() > 1) {
                    CollectionsKt.sortWith(list, new Comparator() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$1
                        @Override // java.util.Comparator
                        public final int compare(T t2, T t5) {
                            return ComparisonsKt.compareValues(Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyLayoutMeasuredItem) t5).getKey())), Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyLayoutMeasuredItem) t2).getKey())));
                        }
                    });
                }
                List<T> list2 = this.movingInFromStartBound;
                int size3 = list2.size();
                int i24 = 0;
                while (i24 < size3) {
                    T t2 = list2.get(i24);
                    int i25 = i22;
                    initializeAnimation$default(this, t2, layoutMinOffset - updateAndReturnOffsetFor(iArr, t2), null, 4, null);
                    startPlacementAnimationsIfNeeded$default(this, t2, false, i25, null);
                    i24++;
                    i22 = i25;
                }
                i = i22;
                ArraysKt___ArraysJvmKt.fill$default(iArr, 0, 0, 0, 6, (Object) null);
            }
            if (!this.movingInFromEndBound.isEmpty()) {
                List<T> list3 = this.movingInFromEndBound;
                if (list3.size() > 1) {
                    CollectionsKt.sortWith(list3, new Comparator() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$1
                        @Override // java.util.Comparator
                        public final int compare(T t5, T t6) {
                            return ComparisonsKt.compareValues(Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyLayoutMeasuredItem) t5).getKey())), Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyLayoutMeasuredItem) t6).getKey())));
                        }
                    });
                }
                List<T> list4 = this.movingInFromEndBound;
                int size4 = list4.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    T t5 = list4.get(i26);
                    initializeAnimation$default(this, t5, (layoutMaxOffset + updateAndReturnOffsetFor(iArr, t5)) - t5.getMainAxisSizeWithSpacings(), null, 4, null);
                    startPlacementAnimationsIfNeeded$default(this, t5, false, i, null);
                }
                ArraysKt___ArraysJvmKt.fill$default(iArr, 0, 0, 0, 6, (Object) null);
            }
        }
        MutableScatterSet<Object> mutableScatterSet = this.movingAwayKeys;
        Object[] objArr4 = mutableScatterSet.elements;
        long[] jArr6 = mutableScatterSet.metadata;
        int length3 = jArr6.length - i;
        if (length3 >= 0) {
            int i27 = 0;
            while (true) {
                long j2 = jArr6[i27];
                long[] jArr7 = jArr6;
                Object[] objArr5 = objArr4;
                if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i28 = 8 - ((~(i27 - length3)) >>> 31);
                    int i29 = 0;
                    while (i29 < i28) {
                        if ((j2 & 255) < 128) {
                            Object obj = objArr5[(i27 << 3) + i29];
                            i5 = i29;
                            LazyLayoutItemAnimator<T>.ItemInfo itemInfo3 = this.keyToItemInfoMap.get(obj);
                            Intrinsics.checkNotNull(itemInfo3);
                            LazyLayoutItemAnimator<T>.ItemInfo itemInfo4 = itemInfo3;
                            objArr2 = objArr5;
                            int index2 = keyIndexMap.getIndex(obj);
                            jArr2 = jArr7;
                            itemInfo4.setSpan(Math.min(i13, itemInfo4.getSpan()));
                            itemInfo4.setLane(Math.min(i13 - itemInfo4.getSpan(), itemInfo4.getLane()));
                            if (index2 == -1) {
                                LazyLayoutItemAnimation[] animations3 = itemInfo4.getAnimations();
                                int length4 = animations3.length;
                                int i30 = 0;
                                boolean z3 = false;
                                int i31 = 0;
                                ?? r2 = itemInfo4;
                                while (i30 < length4) {
                                    ?? r34 = r2;
                                    LazyLayoutItemAnimation lazyLayoutItemAnimation4 = animations3[i30];
                                    int i32 = i31 + 1;
                                    if (lazyLayoutItemAnimation4 != null) {
                                        if (lazyLayoutItemAnimation4.isDisappearanceAnimationInProgress()) {
                                            lazyLayoutItemAnimationArr = animations3;
                                        } else if (lazyLayoutItemAnimation4.isDisappearanceAnimationFinished()) {
                                            lazyLayoutItemAnimation4.release();
                                            r34.getAnimations()[i31] = null;
                                            lazyLayoutItemAnimationArr = animations3;
                                            this.disappearingItems.remove(lazyLayoutItemAnimation4);
                                            DrawModifierNode drawModifierNode2 = this.displayingNode;
                                            if (drawModifierNode2 != null) {
                                                DrawModifierNodeKt.invalidateDraw(drawModifierNode2);
                                                Unit unit3 = Unit.INSTANCE;
                                            }
                                        } else {
                                            lazyLayoutItemAnimationArr = animations3;
                                            if (lazyLayoutItemAnimation4.getLayer() != null) {
                                                lazyLayoutItemAnimation4.animateDisappearance();
                                            }
                                            if (lazyLayoutItemAnimation4.isDisappearanceAnimationInProgress()) {
                                                this.disappearingItems.add(lazyLayoutItemAnimation4);
                                                DrawModifierNode drawModifierNode3 = this.displayingNode;
                                                if (drawModifierNode3 != null) {
                                                    DrawModifierNodeKt.invalidateDraw(drawModifierNode3);
                                                    Unit unit4 = Unit.INSTANCE;
                                                }
                                            } else {
                                                lazyLayoutItemAnimation4.release();
                                                r34.getAnimations()[i31] = null;
                                                i30++;
                                                i31 = i32;
                                                animations3 = lazyLayoutItemAnimationArr;
                                                r2 = r34;
                                            }
                                        }
                                        z3 = true;
                                        i30++;
                                        i31 = i32;
                                        animations3 = lazyLayoutItemAnimationArr;
                                        r2 = r34;
                                    } else {
                                        lazyLayoutItemAnimationArr = animations3;
                                    }
                                    i30++;
                                    i31 = i32;
                                    animations3 = lazyLayoutItemAnimationArr;
                                    r2 = r34;
                                }
                                if (!z3) {
                                    removeInfoForKey(obj);
                                }
                            } else {
                                Constraints constraints = itemInfo4.getConstraints();
                                Intrinsics.checkNotNull(constraints);
                                LazyLayoutMeasuredItem lazyLayoutMeasuredItemMo15968getAndMeasurehBUhpc = itemProvider.mo15968getAndMeasurehBUhpc(index2, itemInfo4.getLane(), itemInfo4.getSpan(), constraints.getValue());
                                lazyLayoutMeasuredItemMo15968getAndMeasurehBUhpc.setNonScrollableItem(true);
                                LazyLayoutItemAnimation[] animations4 = itemInfo4.getAnimations();
                                int length5 = animations4.length;
                                int i33 = 0;
                                while (true) {
                                    if (i33 < length5) {
                                        LazyLayoutItemAnimation lazyLayoutItemAnimation5 = animations4[i33];
                                        int i34 = i33;
                                        if (lazyLayoutItemAnimation5 != null) {
                                            boolean zIsPlacementAnimationInProgress = lazyLayoutItemAnimation5.isPlacementAnimationInProgress();
                                            i6 = length5;
                                            if (zIsPlacementAnimationInProgress) {
                                                break;
                                            }
                                        } else {
                                            i6 = length5;
                                        }
                                        i33 = i34 + 1;
                                        length5 = i6;
                                    } else if (lazyLayoutKeyIndexMap == null || index2 != lazyLayoutKeyIndexMap.getIndex(obj)) {
                                        break;
                                    } else {
                                        removeInfoForKey(obj);
                                    }
                                }
                                itemInfo4.updateAnimation(lazyLayoutMeasuredItemMo15968getAndMeasurehBUhpc, coroutineScope, graphicsContext, layoutMinOffset, layoutMaxOffset, itemInfo4.getCrossAxisOffset());
                                if (index2 < this.firstVisibleIndex) {
                                    this.movingAwayToStartBound.add((T) lazyLayoutMeasuredItemMo15968getAndMeasurehBUhpc);
                                } else {
                                    this.movingAwayToEndBound.add((T) lazyLayoutMeasuredItemMo15968getAndMeasurehBUhpc);
                                }
                            }
                        } else {
                            i5 = i29;
                            objArr2 = objArr5;
                            jArr2 = jArr7;
                        }
                        j2 >>= 8;
                        i13 = laneCount;
                        i29 = i5 + 1;
                        objArr5 = objArr2;
                        jArr7 = jArr2;
                    }
                    objArr = objArr5;
                    jArr = jArr7;
                    if (i28 != 8) {
                        break;
                    }
                } else {
                    objArr = objArr5;
                    jArr = jArr7;
                }
                if (i27 == length3) {
                    break;
                }
                i27++;
                i13 = laneCount;
                objArr4 = objArr;
                jArr6 = jArr;
            }
        }
        if (this.movingAwayToStartBound.isEmpty()) {
            i2 = layoutWidth;
            i4 = layoutHeight;
        } else {
            List<T> list5 = this.movingAwayToStartBound;
            if (list5.size() > 1) {
                CollectionsKt.sortWith(list5, new Comparator() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$2
                    @Override // java.util.Comparator
                    public final int compare(T t6, T t7) {
                        return ComparisonsKt.compareValues(Integer.valueOf(keyIndexMap.getIndex(((LazyLayoutMeasuredItem) t7).getKey())), Integer.valueOf(keyIndexMap.getIndex(((LazyLayoutMeasuredItem) t6).getKey())));
                    }
                });
            }
            List<T> list6 = this.movingAwayToStartBound;
            int size5 = list6.size();
            for (int i35 = 0; i35 < size5; i35++) {
                T t6 = list6.get(i35);
                LazyLayoutItemAnimator<T>.ItemInfo itemInfo5 = this.keyToItemInfoMap.get(t6.getKey());
                Intrinsics.checkNotNull(itemInfo5);
                LazyLayoutItemAnimator<T>.ItemInfo itemInfo6 = itemInfo5;
                t6.position((isLookingAhead ? getMainAxisOffset((LazyLayoutMeasuredItem) CollectionsKt.first((List) positionedItems)) : itemInfo6.getLayoutMinOffset()) - updateAndReturnOffsetFor(iArr, t6), itemInfo6.getCrossAxisOffset(), layoutWidth, layoutHeight);
                if (z) {
                    startPlacementAnimationsIfNeeded(t6, true);
                }
            }
            i2 = layoutWidth;
            i4 = layoutHeight;
            ArraysKt___ArraysJvmKt.fill$default(iArr, 0, 0, 0, 6, (Object) null);
        }
        if (!this.movingAwayToEndBound.isEmpty()) {
            List<T> list7 = this.movingAwayToEndBound;
            if (list7.size() > 1) {
                CollectionsKt.sortWith(list7, new Comparator() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$2
                    @Override // java.util.Comparator
                    public final int compare(T t7, T t8) {
                        return ComparisonsKt.compareValues(Integer.valueOf(keyIndexMap.getIndex(((LazyLayoutMeasuredItem) t7).getKey())), Integer.valueOf(keyIndexMap.getIndex(((LazyLayoutMeasuredItem) t8).getKey())));
                    }
                });
            }
            List<T> list8 = this.movingAwayToEndBound;
            int size6 = list8.size();
            for (int i36 = 0; i36 < size6; i36++) {
                T t7 = list8.get(i36);
                LazyLayoutItemAnimator<T>.ItemInfo itemInfo7 = this.keyToItemInfoMap.get(t7.getKey());
                Intrinsics.checkNotNull(itemInfo7);
                LazyLayoutItemAnimator<T>.ItemInfo itemInfo8 = itemInfo7;
                t7.position((isLookingAhead ? getMainAxisOffset((LazyLayoutMeasuredItem) CollectionsKt.last((List) positionedItems)) : itemInfo8.getLayoutMaxOffset() - t7.getMainAxisSizeWithSpacings()) + updateAndReturnOffsetFor(iArr, t7), itemInfo8.getCrossAxisOffset(), i2, i4);
                if (z) {
                    startPlacementAnimationsIfNeeded(t7, true);
                }
            }
        }
        List<T> list9 = this.movingAwayToStartBound;
        CollectionsKt.reverse(list9);
        Unit unit5 = Unit.INSTANCE;
        positionedItems.addAll(0, list9);
        positionedItems.addAll(this.movingAwayToEndBound);
        this.movingInFromStartBound.clear();
        this.movingInFromEndBound.clear();
        this.movingAwayToStartBound.clear();
        this.movingAwayToEndBound.clear();
        this.movingAwayKeys.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void reset() {
        if (this.keyToItemInfoMap.isNotEmpty()) {
            MutableScatterMap<Object, LazyLayoutItemAnimator<T>.ItemInfo> mutableScatterMap = this.keyToItemInfoMap;
            Object[] objArr = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i4 = 0; i4 < i2; i4++) {
                            if ((255 & j) < 128) {
                                for (LazyLayoutItemAnimation lazyLayoutItemAnimation : ((ItemInfo) objArr[(i << 3) + i4]).getAnimations()) {
                                    if (lazyLayoutItemAnimation != null) {
                                        lazyLayoutItemAnimation.release();
                                    }
                                }
                            }
                            j >>= 8;
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
            }
            this.keyToItemInfoMap.clear();
        }
        this.keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
        this.firstVisibleIndex = -1;
    }
}
