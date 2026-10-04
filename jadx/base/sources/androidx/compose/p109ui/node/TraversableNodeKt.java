package androidx.compose.p109ui.node;

import androidx.compose.p109ui.Actual_jvmKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.node.TraversableNode;
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
@Metadata(m13885d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u0001¢\u0006\u0002\u0010\u0003\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0002*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a-\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a(\u0010\u0007\u001a\u00020\b*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\r\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a(\u0010\r\u001a\u00020\b*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\u000e\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0002\u0010\f\u001a(\u0010\u000e\u001a\u00020\b*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\n¨\u0006\u0010"}, m13886d2 = {"findNearestAncestor", "T", "Landroidx/compose/ui/node/TraversableNode;", "(Landroidx/compose/ui/node/TraversableNode;)Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/DelegatableNode;", "key", "", "traverseAncestors", "", "block", "Lkotlin/Function1;", "", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)V", "traverseChildren", "traverseDescendants", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTraversableNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TraversableNode.kt\nandroidx/compose/ui/node/TraversableNodeKt\n+ 2 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n+ 3 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Modifier.kt\nandroidx/compose/ui/Modifier$Node\n+ 6 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n+ 7 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 8 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 9 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n*L\n1#1,230:1\n112#2:231\n112#2:297\n112#2:363\n112#2:429\n112#2:495\n112#2:566\n112#2:637\n112#2:716\n251#3,5:232\n62#3:237\n63#3,8:239\n432#3,6:247\n442#3,2:254\n444#3,8:259\n452#3,9:270\n461#3,8:282\n72#3,7:290\n251#3,5:298\n62#3:303\n63#3,8:305\n432#3,6:313\n442#3,2:320\n444#3,8:325\n452#3,9:336\n461#3,8:348\n72#3,7:356\n251#3,5:364\n62#3:369\n63#3,8:371\n432#3,6:379\n442#3,2:386\n444#3,8:391\n452#3,9:402\n461#3,8:414\n72#3,7:422\n251#3,5:430\n62#3:435\n63#3,8:437\n432#3,6:445\n442#3,2:452\n444#3,8:457\n452#3,9:468\n461#3,8:480\n72#3,7:488\n297#3:496\n137#3:497\n138#3:499\n139#3,7:503\n146#3,9:511\n432#3,6:520\n442#3,2:527\n444#3,17:532\n461#3,8:552\n155#3,6:560\n297#3:567\n137#3:568\n138#3:570\n139#3,7:574\n146#3,9:582\n432#3,6:591\n442#3,2:598\n444#3,17:603\n461#3,8:623\n155#3,6:631\n310#3:638\n167#3:639\n168#3:647\n169#3,12:651\n311#3:663\n432#3,5:664\n312#3,2:669\n437#3:671\n442#3,2:673\n444#3,17:678\n461#3,8:698\n314#3:706\n181#3,8:707\n315#3:715\n310#3:717\n167#3:718\n168#3:726\n169#3,12:730\n311#3:742\n432#3,5:743\n312#3,2:748\n437#3:750\n442#3,2:752\n444#3,17:757\n461#3,8:777\n314#3:785\n181#3,8:786\n315#3:794\n1#4:238\n1#4:304\n1#4:370\n1#4:436\n1#4:498\n1#4:569\n249#5:253\n249#5:319\n249#5:385\n249#5:451\n249#5:526\n249#5:597\n249#5:672\n249#5:751\n245#6,3:256\n248#6,3:279\n245#6,3:322\n248#6,3:345\n245#6,3:388\n248#6,3:411\n245#6,3:454\n248#6,3:477\n245#6,3:529\n248#6,3:549\n245#6,3:600\n248#6,3:620\n245#6,3:675\n248#6,3:695\n245#6,3:754\n248#6,3:774\n1208#7:267\n1187#7,2:268\n1208#7:333\n1187#7,2:334\n1208#7:399\n1187#7,2:400\n1208#7:465\n1187#7,2:466\n1208#7:500\n1187#7,2:501\n1208#7:571\n1187#7,2:572\n1208#7:648\n1187#7,2:649\n1208#7:727\n1187#7,2:728\n48#8:510\n48#8:581\n42#9,7:640\n42#9,7:719\n*S KotlinDebug\n*F\n+ 1 TraversableNode.kt\nandroidx/compose/ui/node/TraversableNodeKt\n*L\n58#1:231\n70#1:297\n92#1:363\n111#1:429\n138#1:495\n159#1:566\n187#1:637\n214#1:716\n58#1:232,5\n58#1:237\n58#1:239,8\n58#1:247,6\n58#1:254,2\n58#1:259,8\n58#1:270,9\n58#1:282,8\n58#1:290,7\n70#1:298,5\n70#1:303\n70#1:305,8\n70#1:313,6\n70#1:320,2\n70#1:325,8\n70#1:336,9\n70#1:348,8\n70#1:356,7\n92#1:364,5\n92#1:369\n92#1:371,8\n92#1:379,6\n92#1:386,2\n92#1:391,8\n92#1:402,9\n92#1:414,8\n92#1:422,7\n111#1:430,5\n111#1:435\n111#1:437,8\n111#1:445,6\n111#1:452,2\n111#1:457,8\n111#1:468,9\n111#1:480,8\n111#1:488,7\n138#1:496\n138#1:497\n138#1:499\n138#1:503,7\n138#1:511,9\n138#1:520,6\n138#1:527,2\n138#1:532,17\n138#1:552,8\n138#1:560,6\n159#1:567\n159#1:568\n159#1:570\n159#1:574,7\n159#1:582,9\n159#1:591,6\n159#1:598,2\n159#1:603,17\n159#1:623,8\n159#1:631,6\n187#1:638\n187#1:639\n187#1:647\n187#1:651,12\n187#1:663\n187#1:664,5\n187#1:669,2\n187#1:671\n187#1:673,2\n187#1:678,17\n187#1:698,8\n187#1:706\n187#1:707,8\n187#1:715\n214#1:717\n214#1:718\n214#1:726\n214#1:730,12\n214#1:742\n214#1:743,5\n214#1:748,2\n214#1:750\n214#1:752,2\n214#1:757,17\n214#1:777,8\n214#1:785\n214#1:786,8\n214#1:794\n58#1:238\n70#1:304\n92#1:370\n111#1:436\n138#1:498\n159#1:569\n58#1:253\n70#1:319\n92#1:385\n111#1:451\n138#1:526\n159#1:597\n187#1:672\n214#1:751\n58#1:256,3\n58#1:279,3\n70#1:322,3\n70#1:345,3\n92#1:388,3\n92#1:411,3\n111#1:454,3\n111#1:477,3\n138#1:529,3\n138#1:549,3\n159#1:600,3\n159#1:620,3\n187#1:675,3\n187#1:695,3\n214#1:754,3\n214#1:774,3\n58#1:267\n58#1:268,2\n70#1:333\n70#1:334,2\n92#1:399\n92#1:400,2\n111#1:465\n111#1:466,2\n138#1:500\n138#1:501,2\n159#1:571\n159#1:572,2\n187#1:648\n187#1:649,2\n214#1:727\n214#1:728,2\n138#1:510\n159#1:581\n187#1:640,7\n214#1:719,7\n*E\n"})
public final class TraversableNodeKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    @Nullable
    public static final TraversableNode findNearestAncestor(@NotNull DelegatableNode delegatableNode, @Nullable Object obj) {
        NodeChain nodes;
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(262144);
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & iM20090constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM20090constructorimpl) != 0) {
                        Modifier.Node nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != 0) {
                            if (nodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) nodePop;
                                if (Intrinsics.areEqual(obj, traversableNode.getTraverseKey())) {
                                    return traversableNode;
                                }
                            } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                int i = 0;
                                nodePop = nodePop;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != 0) {
                                                mutableVector.add(nodePop);
                                                nodePop = 0;
                                            }
                                            mutableVector.add(delegate);
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    nodePop = nodePop;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12 */
    public static final void traverseAncestors(@NotNull DelegatableNode delegatableNode, @Nullable Object obj, @NotNull Function1<? super TraversableNode, Boolean> function1) {
        NodeChain nodes;
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(262144);
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & iM20090constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM20090constructorimpl) != 0) {
                        Modifier.Node nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != 0) {
                            if (nodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) nodePop;
                                if (!(Intrinsics.areEqual(obj, traversableNode.getTraverseKey()) ? function1.invoke(traversableNode).booleanValue() : true)) {
                                    return;
                                }
                            } else {
                                if (((nodePop.getKindSet() & iM20090constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                    int i = 0;
                                    nodePop = nodePop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != 0) {
                                                    mutableVector.add(nodePop);
                                                    nodePop = 0;
                                                }
                                                mutableVector.add(delegate);
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        nodePop = nodePop;
                                    }
                                    if (i == 1) {
                                    }
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
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x002f, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v16 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void traverseChildren(@NotNull DelegatableNode delegatableNode, @Nullable Object obj, @NotNull Function1<? super TraversableNode, Boolean> function1) {
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(262144);
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node nodePop = (Modifier.Node) AbstractC1974b.m1314g(mutableVector, 1);
            if ((nodePop.getAggregateChildKindSet() & iM20090constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, nodePop);
            } else {
                while (true) {
                    if (nodePop == 0) {
                        break;
                    }
                    if ((nodePop.getKindSet() & iM20090constructorimpl) != 0) {
                        MutableVector mutableVector2 = null;
                        while (nodePop != 0) {
                            if (nodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) nodePop;
                                if (!(Intrinsics.areEqual(obj, traversableNode.getTraverseKey()) ? function1.invoke(traversableNode).booleanValue() : true)) {
                                    return;
                                }
                            } else {
                                if (((nodePop.getKindSet() & iM20090constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                    int i = 0;
                                    nodePop = nodePop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = delegate;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != 0) {
                                                    mutableVector2.add(nodePop);
                                                    nodePop = 0;
                                                }
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        nodePop = nodePop;
                                    }
                                    if (i == 1) {
                                    }
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
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    public static final void traverseDescendants(@NotNull DelegatableNode delegatableNode, @Nullable Object obj, @NotNull Function1<? super TraversableNode, ? extends TraversableNode.Companion.TraverseDescendantsAction> function1) {
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(262144);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) AbstractC1974b.m1314g(mutableVector, 1);
            if ((node.getAggregateChildKindSet() & iM20090constructorimpl) != 0) {
                for (Modifier.Node child2 = node; child2 != null; child2 = child2.getChild()) {
                    if ((child2.getKindSet() & iM20090constructorimpl) != 0) {
                        Modifier.Node nodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (nodePop != 0) {
                            if (nodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) nodePop;
                                TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsActionInvoke = Intrinsics.areEqual(obj, traversableNode.getTraverseKey()) ? function1.invoke(traversableNode) : TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                                if (traverseDescendantsActionInvoke == TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal) {
                                    return;
                                }
                                if (traverseDescendantsActionInvoke == TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                    break;
                                }
                            } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                int i = 0;
                                nodePop = nodePop;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != 0) {
                                                mutableVector2.add(nodePop);
                                                nodePop = 0;
                                            }
                                            mutableVector2.add(delegate);
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    nodePop = nodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    @Nullable
    public static final <T extends TraversableNode> T findNearestAncestor(@NotNull T t) {
        NodeChain nodes;
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(262144);
        if (t.getNode().getIsAttached()) {
            Modifier.Node parent = t.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(t);
            while (layoutNodeRequireLayoutNode != null) {
                if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & iM20090constructorimpl) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM20090constructorimpl) != 0) {
                            Modifier.Node nodePop = parent;
                            MutableVector mutableVector = null;
                            while (nodePop != 0) {
                                if (nodePop instanceof TraversableNode) {
                                    T t2 = (T) nodePop;
                                    if (Intrinsics.areEqual(t.getTraverseKey(), t2.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(t, t2)) {
                                        return t2;
                                    }
                                } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                    int i = 0;
                                    nodePop = nodePop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != 0) {
                                                    mutableVector.add(nodePop);
                                                    nodePop = 0;
                                                }
                                                mutableVector.add(delegate);
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        nodePop = nodePop;
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
        throw new IllegalStateException("visitAncestors called on an unattached node");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12 */
    public static final <T extends TraversableNode> void traverseAncestors(@NotNull T t, @NotNull Function1<? super T, Boolean> function1) {
        NodeChain nodes;
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(262144);
        if (t.getNode().getIsAttached()) {
            Modifier.Node parent = t.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(t);
            while (layoutNodeRequireLayoutNode != null) {
                if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & iM20090constructorimpl) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM20090constructorimpl) != 0) {
                            Modifier.Node nodePop = parent;
                            MutableVector mutableVector = null;
                            while (nodePop != 0) {
                                boolean zBooleanValue = true;
                                if (nodePop instanceof TraversableNode) {
                                    TraversableNode traversableNode = (TraversableNode) nodePop;
                                    if (Intrinsics.areEqual(t.getTraverseKey(), traversableNode.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(t, traversableNode)) {
                                        zBooleanValue = function1.invoke(traversableNode).booleanValue();
                                    }
                                    if (!zBooleanValue) {
                                        return;
                                    }
                                } else {
                                    if (((nodePop.getKindSet() & iM20090constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                                        Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                        int i = 0;
                                        nodePop = nodePop;
                                        while (delegate != null) {
                                            if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                                i++;
                                                if (i == 1) {
                                                    nodePop = delegate;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (nodePop != 0) {
                                                        mutableVector.add(nodePop);
                                                        nodePop = 0;
                                                    }
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                            delegate = delegate.getChild();
                                            nodePop = nodePop;
                                        }
                                        if (i == 1) {
                                        }
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
            return;
        }
        throw new IllegalStateException("visitAncestors called on an unattached node");
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x002f, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T extends TraversableNode> void traverseChildren(@NotNull T t, @NotNull Function1<? super T, Boolean> function1) {
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(262144);
        if (t.getNode().getIsAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child = t.getNode().getChild();
            if (child == null) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, t.getNode());
            } else {
                mutableVector.add(child);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node nodePop = (Modifier.Node) AbstractC1974b.m1314g(mutableVector, 1);
                if ((nodePop.getAggregateChildKindSet() & iM20090constructorimpl) == 0) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector, nodePop);
                } else {
                    while (true) {
                        if (nodePop == 0) {
                            break;
                        }
                        if ((nodePop.getKindSet() & iM20090constructorimpl) != 0) {
                            MutableVector mutableVector2 = null;
                            while (nodePop != 0) {
                                if (nodePop instanceof TraversableNode) {
                                    TraversableNode traversableNode = (TraversableNode) nodePop;
                                    if (!((Intrinsics.areEqual(t.getTraverseKey(), traversableNode.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(t, traversableNode)) ? function1.invoke(traversableNode).booleanValue() : true)) {
                                        return;
                                    }
                                } else {
                                    if (((nodePop.getKindSet() & iM20090constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                                        Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                        int i = 0;
                                        nodePop = nodePop;
                                        while (delegate != null) {
                                            if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                                i++;
                                                if (i == 1) {
                                                    nodePop = delegate;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (nodePop != 0) {
                                                        mutableVector2.add(nodePop);
                                                        nodePop = 0;
                                                    }
                                                    mutableVector2.add(delegate);
                                                }
                                            }
                                            delegate = delegate.getChild();
                                            nodePop = nodePop;
                                        }
                                        if (i == 1) {
                                        }
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
            return;
        }
        throw new IllegalStateException("visitChildren called on an unattached node");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10 */
    public static final <T extends TraversableNode> void traverseDescendants(@NotNull T t, @NotNull Function1<? super T, ? extends TraversableNode.Companion.TraverseDescendantsAction> function1) {
        TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsActionInvoke;
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(262144);
        if (!t.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = t.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, t.getNode());
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) AbstractC1974b.m1314g(mutableVector, 1);
            if ((node.getAggregateChildKindSet() & iM20090constructorimpl) != 0) {
                for (Modifier.Node child2 = node; child2 != null; child2 = child2.getChild()) {
                    if ((child2.getKindSet() & iM20090constructorimpl) != 0) {
                        Modifier.Node nodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (nodePop != 0) {
                            if (nodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) nodePop;
                                if (Intrinsics.areEqual(t.getTraverseKey(), traversableNode.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(t, traversableNode)) {
                                    traverseDescendantsActionInvoke = function1.invoke(traversableNode);
                                } else {
                                    traverseDescendantsActionInvoke = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                                }
                                if (traverseDescendantsActionInvoke == TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal) {
                                    return;
                                }
                                if (traverseDescendantsActionInvoke == TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                    break;
                                }
                            } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                int i = 0;
                                nodePop = nodePop;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != 0) {
                                                mutableVector2.add(nodePop);
                                                nodePop = 0;
                                            }
                                            mutableVector2.add(delegate);
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    nodePop = nodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
        }
    }
}
