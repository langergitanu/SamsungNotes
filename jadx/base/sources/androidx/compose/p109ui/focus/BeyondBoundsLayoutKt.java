package androidx.compose.p109ui.focus;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.focus.FocusDirection;
import androidx.compose.p109ui.layout.BeyondBoundsLayout;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.DelegatingNode;
import androidx.compose.p109ui.node.LayoutNode;
import androidx.compose.p109ui.node.NodeChain;
import androidx.compose.p109ui.node.NodeKind;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\b\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, m13886d2 = {"searchBeyondBounds", "T", "Landroidx/compose/ui/focus/FocusTargetNode;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBeyondBoundsLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BeyondBoundsLayout.kt\nandroidx/compose/ui/focus/BeyondBoundsLayoutKt\n+ 2 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n+ 3 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Modifier.kt\nandroidx/compose/ui/Modifier$Node\n+ 6 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n+ 7 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n*L\n1#1,58:1\n96#2:59\n283#3:60\n251#3,5:61\n62#3:66\n63#3,8:68\n432#3,5:76\n284#3:81\n437#3:82\n442#3,2:84\n444#3,8:89\n452#3,9:100\n461#3,8:112\n72#3,7:120\n286#3:127\n1#4:67\n249#5:83\n245#6,3:86\n248#6,3:109\n1208#7:97\n1187#7,2:98\n*S KotlinDebug\n*F\n+ 1 BeyondBoundsLayout.kt\nandroidx/compose/ui/focus/BeyondBoundsLayoutKt\n*L\n39#1:59\n39#1:60\n39#1:61,5\n39#1:66\n39#1:68,8\n39#1:76,5\n39#1:81\n39#1:82\n39#1:84,2\n39#1:89,8\n39#1:100,9\n39#1:112,8\n39#1:120,7\n39#1:127\n39#1:67\n39#1:83\n39#1:86,3\n39#1:109,3\n39#1:97\n39#1:98,2\n*E\n"})
public final class BeyondBoundsLayoutKt {
    @Nullable
    /* JADX INFO: renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final <T> T m18192searchBeyondBoundsOMvw8(@NotNull FocusTargetNode focusTargetNode, int i, @NotNull Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> function1) {
        Modifier.Node nodePop;
        BeyondBoundsLayout beyondBoundsLayoutParent;
        int iM19841getBeforehoxUOeE;
        NodeChain nodes;
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = focusTargetNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        loop0: while (true) {
            if (layoutNodeRequireLayoutNode == null) {
                nodePop = null;
                break;
            }
            if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & iM20090constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM20090constructorimpl) != 0) {
                        nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
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
                                if (i2 == 1) {
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
        FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
        if ((focusTargetNode2 != null && Intrinsics.areEqual(focusTargetNode2.getBeyondBoundsLayoutParent(), focusTargetNode.getBeyondBoundsLayoutParent())) || (beyondBoundsLayoutParent = focusTargetNode.getBeyondBoundsLayoutParent()) == null) {
            return null;
        }
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m18196equalsimpl0(i, companion.m18209getUpdhqQ8s())) {
            iM19841getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m19839getAbovehoxUOeE();
        } else if (FocusDirection.m18196equalsimpl0(i, companion.m18202getDowndhqQ8s())) {
            iM19841getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m19842getBelowhoxUOeE();
        } else if (FocusDirection.m18196equalsimpl0(i, companion.m18205getLeftdhqQ8s())) {
            iM19841getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m19843getLefthoxUOeE();
        } else if (FocusDirection.m18196equalsimpl0(i, companion.m18208getRightdhqQ8s())) {
            iM19841getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m19844getRighthoxUOeE();
        } else if (FocusDirection.m18196equalsimpl0(i, companion.m18206getNextdhqQ8s())) {
            iM19841getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m19840getAfterhoxUOeE();
        } else {
            if (!FocusDirection.m18196equalsimpl0(i, companion.m18207getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout");
            }
            iM19841getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m19841getBeforehoxUOeE();
        }
        return (T) beyondBoundsLayoutParent.mo16007layouto7g1Pn8(iM19841getBeforehoxUOeE, function1);
    }
}
