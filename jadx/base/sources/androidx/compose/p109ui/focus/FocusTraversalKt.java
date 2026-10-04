package androidx.compose.p109ui.focus;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.focus.FocusDirection;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.layout.LayoutCoordinatesKt;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.DelegatingNode;
import androidx.compose.p109ui.node.LayoutNode;
import androidx.compose.p109ui.node.NodeChain;
import androidx.compose.p109ui.node.NodeCoordinator;
import androidx.compose.p109ui.node.NodeKind;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0007\u001a\u00020\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0001H\u0000\u001aF\u0010\u0013\u001a\u0004\u0018\u00010\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0016H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, m13886d2 = {"activeChild", "Landroidx/compose/ui/focus/FocusTargetNode;", "getActiveChild", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusTargetNode;", "isEligibleForFocusSearch", "", "(Landroidx/compose/ui/focus/FocusTargetNode;)Z", "customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "findActiveFocusNode", "findNonDeactivatedParent", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "focusSearch", "previouslyFocusedRect", "onFound", "Lkotlin/Function1;", "focusSearch-0X8WOeE", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFocusTraversal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FocusTraversal.kt\nandroidx/compose/ui/focus/FocusTraversalKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n+ 4 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n+ 5 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 6 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 7 Modifier.kt\nandroidx/compose/ui/Modifier$Node\n+ 8 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n*L\n1#1,173:1\n1#2:174\n1#2:178\n1#2:249\n1#2:324\n96#3:175\n96#3:246\n96#3:317\n297#4:176\n137#4:177\n138#4:179\n139#4,7:183\n146#4,9:191\n432#4,6:200\n442#4,2:207\n444#4,17:212\n461#4,8:232\n155#4,6:240\n297#4:247\n137#4:248\n138#4:250\n139#4,7:254\n146#4,9:262\n432#4,6:271\n442#4,2:278\n444#4,17:283\n461#4,8:303\n155#4,6:311\n251#4,5:318\n62#4:323\n63#4,8:325\n432#4,6:333\n442#4,2:340\n444#4,8:345\n452#4,9:356\n461#4,8:368\n72#4,7:376\n1208#5:180\n1187#5,2:181\n1208#5:251\n1187#5,2:252\n1208#5:353\n1187#5,2:354\n48#6:190\n48#6:261\n249#7:206\n249#7:277\n249#7:339\n245#8,3:209\n248#8,3:229\n245#8,3:280\n248#8,3:300\n245#8,3:342\n248#8,3:365\n*S KotlinDebug\n*F\n+ 1 FocusTraversal.kt\nandroidx/compose/ui/focus/FocusTraversalKt\n*L\n143#1:178\n157#1:249\n168#1:324\n143#1:175\n157#1:246\n168#1:317\n143#1:176\n143#1:177\n143#1:179\n143#1:183,7\n143#1:191,9\n143#1:200,6\n143#1:207,2\n143#1:212,17\n143#1:232,8\n143#1:240,6\n157#1:247\n157#1:248\n157#1:250\n157#1:254,7\n157#1:262,9\n157#1:271,6\n157#1:278,2\n157#1:283,17\n157#1:303,8\n157#1:311,6\n168#1:318,5\n168#1:323\n168#1:325,8\n168#1:333,6\n168#1:340,2\n168#1:345,8\n168#1:356,9\n168#1:368,8\n168#1:376,7\n143#1:180\n143#1:181,2\n157#1:251\n157#1:252,2\n168#1:353\n168#1:354,2\n143#1:190\n157#1:261\n143#1:206\n157#1:277\n168#1:339\n143#1:209,3\n143#1:229,3\n157#1:280,3\n157#1:300,3\n168#1:342,3\n168#1:365,3\n*E\n"})
public final class FocusTraversalKt {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: customFocusSearch--OM-vw8, reason: not valid java name */
    public static final FocusRequester m18236customFocusSearchOMvw8(@NotNull FocusTargetNode focusTargetNode, int i, @NotNull LayoutDirection layoutDirection) {
        FocusRequester end;
        FocusRequester focusRequester;
        FocusRequester start;
        FocusProperties focusPropertiesFetchFocusProperties$ui_release = focusTargetNode.fetchFocusProperties$ui_release();
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m18196equalsimpl0(i, companion.m18206getNextdhqQ8s())) {
            return focusPropertiesFetchFocusProperties$ui_release.getNext();
        }
        if (FocusDirection.m18196equalsimpl0(i, companion.m18207getPreviousdhqQ8s())) {
            return focusPropertiesFetchFocusProperties$ui_release.getPrevious();
        }
        if (FocusDirection.m18196equalsimpl0(i, companion.m18209getUpdhqQ8s())) {
            return focusPropertiesFetchFocusProperties$ui_release.getUp();
        }
        if (FocusDirection.m18196equalsimpl0(i, companion.m18202getDowndhqQ8s())) {
            return focusPropertiesFetchFocusProperties$ui_release.getDown();
        }
        if (FocusDirection.m18196equalsimpl0(i, companion.m18205getLeftdhqQ8s())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                start = focusPropertiesFetchFocusProperties$ui_release.getStart();
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                start = focusPropertiesFetchFocusProperties$ui_release.getEnd();
            }
            focusRequester = start != FocusRequester.INSTANCE.getDefault() ? start : null;
            return focusRequester == null ? focusPropertiesFetchFocusProperties$ui_release.getLeft() : focusRequester;
        }
        if (!FocusDirection.m18196equalsimpl0(i, companion.m18208getRightdhqQ8s())) {
            if (FocusDirection.m18196equalsimpl0(i, companion.m18203getEnterdhqQ8s())) {
                return focusPropertiesFetchFocusProperties$ui_release.getEnter().invoke(FocusDirection.m18193boximpl(i));
            }
            if (FocusDirection.m18196equalsimpl0(i, companion.m18204getExitdhqQ8s())) {
                return focusPropertiesFetchFocusProperties$ui_release.getExit().invoke(FocusDirection.m18193boximpl(i));
            }
            throw new IllegalStateException("invalid FocusDirection");
        }
        int i4 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        if (i4 == 1) {
            end = focusPropertiesFetchFocusProperties$ui_release.getEnd();
        } else {
            if (i4 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            end = focusPropertiesFetchFocusProperties$ui_release.getStart();
        }
        focusRequester = end != FocusRequester.INSTANCE.getDefault() ? end : null;
        return focusRequester == null ? focusPropertiesFetchFocusProperties$ui_release.getRight() : focusRequester;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x004f, code lost:
    
        continue;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final FocusTargetNode findActiveFocusNode(@NotNull FocusTargetNode focusTargetNode) {
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i != 1) {
            if (i == 2) {
                int iM20090constructorimpl = NodeKind.m20090constructorimpl(1024);
                if (!focusTargetNode.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitChildren called on an unattached node");
                }
                MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child = focusTargetNode.getNode().getChild();
                if (child == null) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode.getNode());
                } else {
                    mutableVector.add(child);
                }
                while (mutableVector.isNotEmpty()) {
                    Modifier.Node nodePop = (Modifier.Node) AbstractC1974b.m1314g(mutableVector, 1);
                    if ((nodePop.getAggregateChildKindSet() & iM20090constructorimpl) == 0) {
                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector, nodePop);
                    } else {
                        while (true) {
                            if (nodePop == null) {
                                break;
                            }
                            if ((nodePop.getKindSet() & iM20090constructorimpl) != 0) {
                                MutableVector mutableVector2 = null;
                                while (nodePop != null) {
                                    if (nodePop instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNodeFindActiveFocusNode = findActiveFocusNode((FocusTargetNode) nodePop);
                                        if (focusTargetNodeFindActiveFocusNode != null) {
                                            return focusTargetNodeFindActiveFocusNode;
                                        }
                                    } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                        int i2 = 0;
                                        for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                            if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    nodePop = delegate;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (nodePop != null) {
                                                        mutableVector2.add(nodePop);
                                                        nodePop = null;
                                                    }
                                                    mutableVector2.add(delegate);
                                                }
                                            }
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                    nodePop = DelegatableNodeKt.pop(mutableVector2);
                                }
                            } else {
                                nodePop = nodePop.getChild();
                            }
                        }
                    }
                }
                return null;
            }
            if (i != 3) {
                if (i == 4) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return focusTargetNode;
    }

    private static final FocusTargetNode findNonDeactivatedParent(FocusTargetNode focusTargetNode) {
        NodeChain nodes;
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = focusTargetNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & iM20090constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM20090constructorimpl) != 0) {
                        Modifier.Node nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                if (focusTargetNode2.fetchFocusProperties$ui_release().getCanFocus()) {
                                    return focusTargetNode2;
                                }
                            } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                mutableVector.add(nodePop);
                                                nodePop = null;
                                            }
                                            mutableVector.add(delegate);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    @NotNull
    public static final Rect focusRect(@NotNull FocusTargetNode focusTargetNode) {
        Rect rectLocalBoundingBoxOf;
        NodeCoordinator coordinator = focusTargetNode.getCoordinator();
        return (coordinator == null || (rectLocalBoundingBoxOf = LayoutCoordinatesKt.findRootCoordinates(coordinator).localBoundingBoxOf(coordinator, false)) == null) ? Rect.INSTANCE.getZero() : rectLocalBoundingBoxOf;
    }

    @Nullable
    /* JADX INFO: renamed from: focusSearch-0X8WOeE, reason: not valid java name */
    public static final Boolean m18237focusSearch0X8WOeE(@NotNull FocusTargetNode focusTargetNode, int i, @NotNull LayoutDirection layoutDirection, @Nullable Rect rect, @NotNull Function1<? super FocusTargetNode, Boolean> function1) {
        int iM18208getRightdhqQ8s;
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m18196equalsimpl0(i, companion.m18206getNextdhqQ8s()) ? true : FocusDirection.m18196equalsimpl0(i, companion.m18207getPreviousdhqQ8s())) {
            return Boolean.valueOf(OneDimensionalFocusSearchKt.m18240oneDimensionalFocusSearchOMvw8(focusTargetNode, i, function1));
        }
        if (FocusDirection.m18196equalsimpl0(i, companion.m18205getLeftdhqQ8s()) ? true : FocusDirection.m18196equalsimpl0(i, companion.m18208getRightdhqQ8s()) ? true : FocusDirection.m18196equalsimpl0(i, companion.m18209getUpdhqQ8s()) ? true : FocusDirection.m18196equalsimpl0(i, companion.m18202getDowndhqQ8s())) {
            return TwoDimensionalFocusSearchKt.m18249twoDimensionalFocusSearchsMXa3k8(focusTargetNode, i, rect, function1);
        }
        if (!FocusDirection.m18196equalsimpl0(i, companion.m18203getEnterdhqQ8s())) {
            if (FocusDirection.m18196equalsimpl0(i, companion.m18204getExitdhqQ8s())) {
                FocusTargetNode focusTargetNodeFindActiveFocusNode = findActiveFocusNode(focusTargetNode);
                FocusTargetNode focusTargetNodeFindNonDeactivatedParent = focusTargetNodeFindActiveFocusNode != null ? findNonDeactivatedParent(focusTargetNodeFindActiveFocusNode) : null;
                return Boolean.valueOf((focusTargetNodeFindNonDeactivatedParent == null || Intrinsics.areEqual(focusTargetNodeFindNonDeactivatedParent, focusTargetNode)) ? false : function1.invoke(focusTargetNodeFindNonDeactivatedParent).booleanValue());
            }
            throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + ((Object) FocusDirection.m18198toStringimpl(i))).toString());
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        if (i2 == 1) {
            iM18208getRightdhqQ8s = companion.m18208getRightdhqQ8s();
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            iM18208getRightdhqQ8s = companion.m18205getLeftdhqQ8s();
        }
        FocusTargetNode focusTargetNodeFindActiveFocusNode2 = findActiveFocusNode(focusTargetNode);
        if (focusTargetNodeFindActiveFocusNode2 != null) {
            return TwoDimensionalFocusSearchKt.m18249twoDimensionalFocusSearchsMXa3k8(focusTargetNodeFindActiveFocusNode2, iM18208getRightdhqQ8s, rect, function1);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x003b, code lost:
    
        continue;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final FocusTargetNode getActiveChild(@NotNull FocusTargetNode focusTargetNode) {
        if (!focusTargetNode.getNode().getIsAttached()) {
            return null;
        }
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode.getNode());
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node nodePop = (Modifier.Node) AbstractC1974b.m1314g(mutableVector, 1);
            if ((nodePop.getAggregateChildKindSet() & iM20090constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, nodePop);
            } else {
                while (true) {
                    if (nodePop == null) {
                        break;
                    }
                    if ((nodePop.getKindSet() & iM20090constructorimpl) != 0) {
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                if (focusTargetNode2.getNode().getIsAttached()) {
                                    int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode2.getFocusState().ordinal()];
                                    if (i == 1 || i == 2 || i == 3) {
                                        return focusTargetNode2;
                                    }
                                }
                            } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                mutableVector2.add(nodePop);
                                                nodePop = null;
                                            }
                                            mutableVector2.add(delegate);
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                        }
                    } else {
                        nodePop = nodePop.getChild();
                    }
                }
            }
        }
        return null;
    }

    public static final boolean isEligibleForFocusSearch(@NotNull FocusTargetNode focusTargetNode) {
        LayoutNode layoutNode;
        NodeCoordinator coordinator;
        LayoutNode layoutNode2;
        NodeCoordinator coordinator2 = focusTargetNode.getCoordinator();
        return (coordinator2 == null || (layoutNode = coordinator2.getLayoutNode()) == null || !layoutNode.isPlaced() || (coordinator = focusTargetNode.getCoordinator()) == null || (layoutNode2 = coordinator.getLayoutNode()) == null || !layoutNode2.isAttached()) ? false : true;
    }
}
