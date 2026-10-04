package androidx.compose.p109ui.platform;

import android.annotation.SuppressLint;
import android.graphics.Region;
import android.view.View;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.layout.LayoutInfo;
import androidx.compose.p109ui.node.LayoutNode;
import androidx.compose.p109ui.semantics.AccessibilityAction;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.semantics.SemanticsActions;
import androidx.compose.p109ui.semantics.SemanticsConfiguration;
import androidx.compose.p109ui.semantics.SemanticsConfigurationKt;
import androidx.compose.p109ui.semantics.SemanticsNode;
import androidx.compose.p109ui.semantics.SemanticsOwner;
import androidx.compose.p109ui.semantics.SemanticsProperties;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.viewinterop.AndroidViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\f\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\b\u0012\u0004\u0012\u00020\u00100\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0012\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015*\u00020\u0017H\u0000\u001a\f\u0010\u0018\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u00020\u001eH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, m13886d2 = {"DefaultFakeNodeBounds", "Landroidx/compose/ui/geometry/Rect;", "getDefaultFakeNodeBounds", "()Landroidx/compose/ui/geometry/Rect;", "isVisible", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "getScrollViewportLength", "", "configuration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;)Ljava/lang/Float;", "getTextLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "findById", "Landroidx/compose/ui/platform/ScrollObservationScope;", "", "id", "", "getAllUncoveredSemanticsNodesToIntObjectMap", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "isImportantForAccessibility", "semanticsIdToView", "Landroid/view/View;", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "toLegacyClassName", "", "Landroidx/compose/ui/semantics/Role;", "toLegacyClassName-V4PA4sw", "(I)Ljava/lang/String;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSemanticsUtils.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SemanticsUtils.android.kt\nandroidx/compose/ui/platform/SemanticsUtils_androidKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,233:1\n288#2,2:234\n26#3:236\n26#3:237\n26#3:238\n26#3:239\n26#3:240\n26#3:241\n26#3:242\n26#3:243\n26#3:244\n26#3:245\n26#3:246\n26#3:247\n*S KotlinDebug\n*F\n+ 1 SemanticsUtils.android.kt\nandroidx/compose/ui/platform/SemanticsUtils_androidKt\n*L\n141#1:234,2\n161#1:236\n162#1:237\n163#1:238\n164#1:239\n177#1:240\n178#1:241\n179#1:242\n180#1:243\n214#1:244\n215#1:245\n216#1:246\n217#1:247\n*E\n"})
public final class SemanticsUtils_androidKt {

    @NotNull
    private static final Rect DefaultFakeNodeBounds = new Rect(0.0f, 0.0f, 10.0f, 10.0f);

    @Nullable
    public static final ScrollObservationScope findById(@NotNull List<ScrollObservationScope> list, int i) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2).getSemanticsNodeId() == i) {
                return list.get(i2);
            }
        }
        return null;
    }

    @NotNull
    public static final IntObjectMap<SemanticsNodeWithAdjustedBounds> getAllUncoveredSemanticsNodesToIntObjectMap(@NotNull SemanticsOwner semanticsOwner) {
        SemanticsNode unmergedRootSemanticsNode = semanticsOwner.getUnmergedRootSemanticsNode();
        MutableIntObjectMap mutableIntObjectMapMutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        if (unmergedRootSemanticsNode.getLayoutNode().isPlaced() && unmergedRootSemanticsNode.getLayoutNode().isAttached()) {
            Rect boundsInRoot = unmergedRootSemanticsNode.getBoundsInRoot();
            m1525x1b6f0f0a(new Region(Math.round(boundsInRoot.getLeft()), Math.round(boundsInRoot.getTop()), Math.round(boundsInRoot.getRight()), Math.round(boundsInRoot.getBottom())), unmergedRootSemanticsNode, mutableIntObjectMapMutableIntObjectMapOf, unmergedRootSemanticsNode, new Region());
        }
        return mutableIntObjectMapMutableIntObjectMapOf;
    }

    /* JADX INFO: renamed from: getAllUncoveredSemanticsNodesToIntObjectMap$findAllSemanticNodesRecursive */
    private static final void m1525x1b6f0f0a(Region region, SemanticsNode semanticsNode, MutableIntObjectMap<SemanticsNodeWithAdjustedBounds> mutableIntObjectMap, SemanticsNode semanticsNode2, Region region2) {
        LayoutInfo layoutInfo;
        boolean z = (semanticsNode2.getLayoutNode().isPlaced() && semanticsNode2.getLayoutNode().isAttached()) ? false : true;
        if (!region.isEmpty() || semanticsNode2.getId() == semanticsNode.getId()) {
            if (!z || semanticsNode2.getIsFake()) {
                Rect touchBoundsInRoot = semanticsNode2.getTouchBoundsInRoot();
                int iRound = Math.round(touchBoundsInRoot.getLeft());
                int iRound2 = Math.round(touchBoundsInRoot.getTop());
                int iRound3 = Math.round(touchBoundsInRoot.getRight());
                int iRound4 = Math.round(touchBoundsInRoot.getBottom());
                region2.set(iRound, iRound2, iRound3, iRound4);
                int id = semanticsNode2.getId() == semanticsNode.getId() ? -1 : semanticsNode2.getId();
                if (!region2.op(region, Region.Op.INTERSECT)) {
                    if (semanticsNode2.getIsFake()) {
                        SemanticsNode parent = semanticsNode2.getParent();
                        Rect boundsInRoot = (parent == null || (layoutInfo = parent.getLayoutInfo()) == null || !layoutInfo.isPlaced()) ? DefaultFakeNodeBounds : parent.getBoundsInRoot();
                        mutableIntObjectMap.set(id, new SemanticsNodeWithAdjustedBounds(semanticsNode2, new android.graphics.Rect(Math.round(boundsInRoot.getLeft()), Math.round(boundsInRoot.getTop()), Math.round(boundsInRoot.getRight()), Math.round(boundsInRoot.getBottom()))));
                        return;
                    } else {
                        if (id == -1) {
                            mutableIntObjectMap.set(id, new SemanticsNodeWithAdjustedBounds(semanticsNode2, region2.getBounds()));
                            return;
                        }
                        return;
                    }
                }
                mutableIntObjectMap.set(id, new SemanticsNodeWithAdjustedBounds(semanticsNode2, region2.getBounds()));
                List<SemanticsNode> replacedChildren$ui_release = semanticsNode2.getReplacedChildren$ui_release();
                for (int size = replacedChildren$ui_release.size() - 1; -1 < size; size--) {
                    m1525x1b6f0f0a(region, semanticsNode, mutableIntObjectMap, replacedChildren$ui_release.get(size), region2);
                }
                if (isImportantForAccessibility(semanticsNode2)) {
                    region.op(iRound, iRound2, iRound3, iRound4, Region.Op.DIFFERENCE);
                }
            }
        }
    }

    @NotNull
    public static final Rect getDefaultFakeNodeBounds() {
        return DefaultFakeNodeBounds;
    }

    @SuppressLint({"PrimitiveInCollection"})
    @Nullable
    public static final Float getScrollViewportLength(@NotNull SemanticsConfiguration semanticsConfiguration) {
        Function1 function1;
        ArrayList arrayList = new ArrayList();
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.INSTANCE.getGetScrollViewportLength());
        if (accessibilityAction == null || (function1 = (Function1) accessibilityAction.getAction()) == null || !((Boolean) function1.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (Float) arrayList.get(0);
    }

    @Nullable
    public static final TextLayoutResult getTextLayoutResult(@NotNull SemanticsConfiguration semanticsConfiguration) {
        Function1 function1;
        ArrayList arrayList = new ArrayList();
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.INSTANCE.getGetTextLayoutResult());
        if (accessibilityAction == null || (function1 = (Function1) accessibilityAction.getAction()) == null || !((Boolean) function1.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (TextLayoutResult) arrayList.get(0);
    }

    public static final boolean isImportantForAccessibility(@NotNull SemanticsNode semanticsNode) {
        if (isVisible(semanticsNode)) {
            return semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || semanticsNode.getUnmergedConfig().containsImportantForAccessibility$ui_release();
        }
        return false;
    }

    public static final boolean isVisible(@NotNull SemanticsNode semanticsNode) {
        return (semanticsNode.isTransparent$ui_release() || semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getInvisibleToUser())) ? false : true;
    }

    @Nullable
    public static final View semanticsIdToView(@NotNull AndroidViewsHandler androidViewsHandler, int i) {
        Object next;
        Iterator<T> it = androidViewsHandler.getLayoutNodeToHolder().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((LayoutNode) ((Map.Entry) next).getKey()).getSemanticsId() == i) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (AndroidViewHolder) entry.getValue();
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: toLegacyClassName-V4PA4sw, reason: not valid java name */
    public static final String m20241toLegacyClassNameV4PA4sw(int i) {
        Role.Companion companion = Role.INSTANCE;
        if (Role.m20262equalsimpl0(i, companion.m20266getButtono7Vup1c())) {
            return "android.widget.Button";
        }
        if (Role.m20262equalsimpl0(i, companion.m20267getCheckboxo7Vup1c())) {
            return "android.widget.CheckBox";
        }
        if (Role.m20262equalsimpl0(i, companion.m20270getRadioButtono7Vup1c())) {
            return "android.widget.RadioButton";
        }
        if (Role.m20262equalsimpl0(i, companion.m20269getImageo7Vup1c())) {
            return "android.widget.ImageView";
        }
        if (Role.m20262equalsimpl0(i, companion.m20268getDropdownListo7Vup1c())) {
            return "android.widget.Spinner";
        }
        return null;
    }
}
