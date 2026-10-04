package androidx.compose.p109ui.focus;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.focus.FocusRequester;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.DelegatingNode;
import androidx.compose.p109ui.node.LayoutNode;
import androidx.compose.p109ui.node.NodeChain;
import androidx.compose.p109ui.node.NodeKind;
import androidx.compose.p109ui.node.ObserverModifierNodeKt;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a \u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u001e\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001e\u0010\u000f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u001e\u0010\u0011\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000e\u001a\u001e\u0010\u0013\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000e\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0016\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a \u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0002\u001a\f\u0010\u001b\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u001c\u001a\u00020\u0002*\u00020\u0002H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, m13886d2 = {"captureFocus", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "clearChildFocus", "forced", "refreshFocusEvents", "clearFocus", "freeFocus", "grantFocus", "performCustomClearFocus", "Landroidx/compose/ui/focus/CustomDestinationResult;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "performCustomClearFocus-Mxy_nc0", "(Landroidx/compose/ui/focus/FocusTargetNode;I)Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomEnter", "performCustomEnter-Mxy_nc0", "performCustomExit", "performCustomExit-Mxy_nc0", "performCustomRequestFocus", "performCustomRequestFocus-Mxy_nc0", "performRequestFocus", "requestFocus", "requestFocus-Mxy_nc0", "(Landroidx/compose/ui/focus/FocusTargetNode;I)Ljava/lang/Boolean;", "requestFocusForChild", "childNode", "requestFocusForOwner", "requireActiveChild", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFocusTransactions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FocusTransactions.kt\nandroidx/compose/ui/focus/FocusTransactionsKt\n+ 2 FocusTransactionManager.kt\nandroidx/compose/ui/focus/FocusTransactionManager\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 5 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n+ 6 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n+ 7 Modifier.kt\nandroidx/compose/ui/Modifier$Node\n+ 8 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n+ 9 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 10 FocusTargetNode.kt\nandroidx/compose/ui/focus/FocusTargetNode\n*L\n1#1,312:1\n43#2,4:313\n47#2,4:320\n40#2,7:393\n47#2,4:403\n40#2,7:407\n47#2,4:417\n1#3:317\n1#3:332\n1#3:400\n1#3:414\n1#3:429\n1#3:498\n1#3:559\n1#3:568\n1#3:629\n728#4,2:318\n728#4,2:401\n728#4,2:415\n96#5:324\n96#5:421\n96#5:490\n96#5:560\n283#6:325\n251#6,5:326\n62#6:331\n63#6,8:333\n432#6,5:341\n284#6:346\n437#6:347\n442#6,2:349\n444#6,8:354\n452#6,9:365\n461#6,8:377\n72#6,7:385\n286#6:392\n283#6:422\n251#6,5:423\n62#6:428\n63#6,8:430\n432#6,5:438\n284#6:443\n437#6:444\n442#6,2:446\n444#6,8:451\n452#6,9:462\n461#6,8:474\n72#6,7:482\n286#6:489\n283#6:491\n251#6,5:492\n62#6:497\n63#6,8:499\n432#6,5:507\n284#6:512\n437#6:513\n442#6,2:515\n444#6,8:520\n452#6,9:531\n461#6,8:543\n72#6,7:551\n286#6:558\n283#6:561\n251#6,5:562\n62#6:567\n63#6,8:569\n432#6,5:577\n284#6:582\n437#6:583\n442#6,2:585\n444#6,8:590\n452#6,9:601\n461#6,8:613\n72#6,7:621\n286#6:628\n249#7:348\n249#7:445\n249#7:514\n249#7:584\n245#8,3:351\n248#8,3:374\n245#8,3:448\n248#8,3:471\n245#8,3:517\n248#8,3:540\n245#8,3:587\n248#8,3:610\n1208#9:362\n1187#9,2:363\n1208#9:459\n1187#9,2:460\n1208#9:528\n1187#9,2:529\n1208#9:598\n1187#9,2:599\n139#10,12:630\n166#10,12:642\n*S KotlinDebug\n*F\n+ 1 FocusTransactions.kt\nandroidx/compose/ui/focus/FocusTransactionsKt\n*L\n46#1:313,4\n46#1:320,4\n94#1:393,7\n94#1:403,4\n113#1:407,7\n113#1:417,4\n46#1:317\n69#1:332\n94#1:400\n113#1:414\n202#1:429\n220#1:498\n268#1:568\n46#1:318,2\n94#1:401,2\n113#1:415,2\n69#1:324\n202#1:421\n220#1:490\n268#1:560\n69#1:325\n69#1:326,5\n69#1:331\n69#1:333,8\n69#1:341,5\n69#1:346\n69#1:347\n69#1:349,2\n69#1:354,8\n69#1:365,9\n69#1:377,8\n69#1:385,7\n69#1:392\n202#1:422\n202#1:423,5\n202#1:428\n202#1:430,8\n202#1:438,5\n202#1:443\n202#1:444\n202#1:446,2\n202#1:451,8\n202#1:462,9\n202#1:474,8\n202#1:482,7\n202#1:489\n220#1:491\n220#1:492,5\n220#1:497\n220#1:499,8\n220#1:507,5\n220#1:512\n220#1:513\n220#1:515,2\n220#1:520,8\n220#1:531,9\n220#1:543,8\n220#1:551,7\n220#1:558\n268#1:561\n268#1:562,5\n268#1:567\n268#1:569,8\n268#1:577,5\n268#1:582\n268#1:583\n268#1:585,2\n268#1:590,8\n268#1:601,9\n268#1:613,8\n268#1:621,7\n268#1:628\n69#1:348\n202#1:445\n220#1:514\n268#1:584\n69#1:351,3\n69#1:374,3\n202#1:448,3\n202#1:471,3\n220#1:517,3\n220#1:540,3\n268#1:587,3\n268#1:610,3\n69#1:362\n69#1:363,2\n202#1:459\n202#1:460,2\n220#1:528\n220#1:529,2\n268#1:598\n268#1:599,2\n295#1:630,12\n306#1:642,12\n*E\n"})
public final class FocusTransactionsKt {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final boolean captureFocus(@NotNull FocusTargetNode focusTargetNode) {
        FocusTransactionManager focusTransactionManagerRequireTransactionManager = FocusTargetNodeKt.requireTransactionManager(focusTargetNode);
        try {
            if (focusTransactionManagerRequireTransactionManager.ongoingTransaction) {
                focusTransactionManagerRequireTransactionManager.cancelTransaction();
            }
            focusTransactionManagerRequireTransactionManager.beginTransaction();
            int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
            boolean z = true;
            if (i == 1) {
                focusTargetNode.setFocusState(FocusStateImpl.Captured);
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            } else if (i != 2) {
                if (i != 3 && i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                z = false;
            }
            return z;
        } finally {
            focusTransactionManagerRequireTransactionManager.commitTransaction();
        }
    }

    private static final boolean clearChildFocus(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            return clearFocus(activeChild, z, z2);
        }
        return true;
    }

    public static /* synthetic */ boolean clearChildFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return clearChildFocus(focusTargetNode, z, z2);
    }

    public static final boolean clearFocus(@NotNull FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i == 1) {
            focusTargetNode.setFocusState(FocusStateImpl.Inactive);
            if (z2) {
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            }
            return true;
        }
        if (i == 2) {
            if (z) {
                focusTargetNode.setFocusState(FocusStateImpl.Inactive);
                if (z2) {
                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                }
            }
            return z;
        }
        if (i != 3) {
            if (i == 4) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!clearChildFocus(focusTargetNode, z, z2)) {
            return false;
        }
        focusTargetNode.setFocusState(FocusStateImpl.Inactive);
        if (z2) {
            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
        }
        return true;
    }

    public static /* synthetic */ boolean clearFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return clearFocus(focusTargetNode, z, z2);
    }

    public static final boolean freeFocus(@NotNull FocusTargetNode focusTargetNode) {
        FocusTransactionManager focusTransactionManagerRequireTransactionManager = FocusTargetNodeKt.requireTransactionManager(focusTargetNode);
        try {
            if (focusTransactionManagerRequireTransactionManager.ongoingTransaction) {
                focusTransactionManagerRequireTransactionManager.cancelTransaction();
            }
            focusTransactionManagerRequireTransactionManager.beginTransaction();
            int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
            boolean z = true;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3 && i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    z = false;
                } else {
                    focusTargetNode.setFocusState(FocusStateImpl.Active);
                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                }
            }
            return z;
        } finally {
            focusTransactionManagerRequireTransactionManager.commitTransaction();
        }
    }

    private static final boolean grantFocus(final FocusTargetNode focusTargetNode) {
        ObserverModifierNodeKt.observeReads(focusTargetNode, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt.grantFocus.1
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
                focusTargetNode.fetchFocusProperties$ui_release();
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i != 3 && i != 4) {
            return true;
        }
        focusTargetNode.setFocusState(FocusStateImpl.Active);
        return true;
    }

    @NotNull
    /* JADX INFO: renamed from: performCustomClearFocus-Mxy_nc0, reason: not valid java name */
    public static final CustomDestinationResult m18231performCustomClearFocusMxy_nc0(@NotNull FocusTargetNode focusTargetNode, int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return CustomDestinationResult.Cancelled;
            }
            if (i2 == 3) {
                CustomDestinationResult customDestinationResultM18231performCustomClearFocusMxy_nc0 = m18231performCustomClearFocusMxy_nc0(requireActiveChild(focusTargetNode), i);
                if (customDestinationResultM18231performCustomClearFocusMxy_nc0 == CustomDestinationResult.None) {
                    customDestinationResultM18231performCustomClearFocusMxy_nc0 = null;
                }
                return customDestinationResultM18231performCustomClearFocusMxy_nc0 == null ? m18233performCustomExitMxy_nc0(focusTargetNode, i) : customDestinationResultM18231performCustomClearFocusMxy_nc0;
            }
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return CustomDestinationResult.None;
    }

    /* JADX INFO: renamed from: performCustomEnter-Mxy_nc0, reason: not valid java name */
    private static final CustomDestinationResult m18232performCustomEnterMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.isProcessingCustomEnter) {
            focusTargetNode.isProcessingCustomEnter = true;
            try {
                FocusRequester focusRequesterInvoke = focusTargetNode.fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m18193boximpl(i));
                FocusRequester.Companion companion = FocusRequester.INSTANCE;
                if (focusRequesterInvoke != companion.getDefault()) {
                    if (focusRequesterInvoke == companion.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    return focusRequesterInvoke.focus$ui_release() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomEnter = false;
            }
        }
        return CustomDestinationResult.None;
    }

    /* JADX INFO: renamed from: performCustomExit-Mxy_nc0, reason: not valid java name */
    private static final CustomDestinationResult m18233performCustomExitMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.isProcessingCustomExit) {
            focusTargetNode.isProcessingCustomExit = true;
            try {
                FocusRequester focusRequesterInvoke = focusTargetNode.fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.m18193boximpl(i));
                FocusRequester.Companion companion = FocusRequester.INSTANCE;
                if (focusRequesterInvoke != companion.getDefault()) {
                    if (focusRequesterInvoke == companion.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    return focusRequesterInvoke.focus$ui_release() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomExit = false;
            }
        }
        return CustomDestinationResult.None;
    }

    @NotNull
    /* JADX INFO: renamed from: performCustomRequestFocus-Mxy_nc0, reason: not valid java name */
    public static final CustomDestinationResult m18234performCustomRequestFocusMxy_nc0(@NotNull FocusTargetNode focusTargetNode, int i) {
        Modifier.Node nodePop;
        NodeChain nodes;
        int i2 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i2 == 1 || i2 == 2) {
            return CustomDestinationResult.None;
        }
        if (i2 == 3) {
            return m18231performCustomClearFocusMxy_nc0(requireActiveChild(focusTargetNode), i);
        }
        if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
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
                                int i4 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                        i4++;
                                        if (i4 == 1) {
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
                                if (i4 == 1) {
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
        if (focusTargetNode2 == null) {
            return CustomDestinationResult.None;
        }
        int i5 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode2.getFocusState().ordinal()];
        if (i5 == 1) {
            return m18232performCustomEnterMxy_nc0(focusTargetNode2, i);
        }
        if (i5 == 2) {
            return CustomDestinationResult.Cancelled;
        }
        if (i5 == 3) {
            return m18234performCustomRequestFocusMxy_nc0(focusTargetNode2, i);
        }
        if (i5 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        CustomDestinationResult customDestinationResultM18234performCustomRequestFocusMxy_nc0 = m18234performCustomRequestFocusMxy_nc0(focusTargetNode2, i);
        CustomDestinationResult customDestinationResult = customDestinationResultM18234performCustomRequestFocusMxy_nc0 != CustomDestinationResult.None ? customDestinationResultM18234performCustomRequestFocusMxy_nc0 : null;
        return customDestinationResult == null ? m18232performCustomEnterMxy_nc0(focusTargetNode2, i) : customDestinationResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean performRequestFocus(@NotNull FocusTargetNode focusTargetNode) {
        NodeChain nodes;
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        boolean zRequestFocusForChild = true;
        if (i != 1 && i != 2) {
            Modifier.Node node = null;
            if (i != 3) {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                int iM20090constructorimpl = NodeKind.m20090constructorimpl(1024);
                if (!focusTargetNode.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node parent = focusTargetNode.getNode().getParent();
                LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                loop0: while (true) {
                    if (layoutNodeRequireLayoutNode == null) {
                        break;
                    }
                    if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & iM20090constructorimpl) != 0) {
                        while (parent != null) {
                            if ((parent.getKindSet() & iM20090constructorimpl) != 0) {
                                Modifier.Node nodePop = parent;
                                MutableVector mutableVector = null;
                                while (nodePop != null) {
                                    if (nodePop instanceof FocusTargetNode) {
                                        node = nodePop;
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
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) node;
                if (focusTargetNode2 != null) {
                    FocusStateImpl focusState = focusTargetNode2.getFocusState();
                    zRequestFocusForChild = requestFocusForChild(focusTargetNode2, focusTargetNode);
                    if (zRequestFocusForChild && focusState != focusTargetNode2.getFocusState()) {
                        FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode2);
                    }
                } else if (!requestFocusForOwner(focusTargetNode) || !grantFocus(focusTargetNode)) {
                    zRequestFocusForChild = false;
                }
            } else if (!clearChildFocus$default(focusTargetNode, false, false, 3, null) || !grantFocus(focusTargetNode)) {
            }
        }
        if (zRequestFocusForChild) {
            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
        }
        return zRequestFocusForChild;
    }

    public static final boolean requestFocus(@NotNull FocusTargetNode focusTargetNode) {
        Boolean boolM18235requestFocusMxy_nc0 = m18235requestFocusMxy_nc0(focusTargetNode, FocusDirection.INSTANCE.m18203getEnterdhqQ8s());
        if (boolM18235requestFocusMxy_nc0 != null) {
            return boolM18235requestFocusMxy_nc0.booleanValue();
        }
        return false;
    }

    @Nullable
    /* JADX INFO: renamed from: requestFocus-Mxy_nc0, reason: not valid java name */
    public static final Boolean m18235requestFocusMxy_nc0(@NotNull final FocusTargetNode focusTargetNode, int i) {
        Boolean boolValueOf;
        FocusTransactionManager focusTransactionManagerRequireTransactionManager = FocusTargetNodeKt.requireTransactionManager(focusTargetNode);
        Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt.requestFocus.1
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
                if (focusTargetNode.getNode().getIsAttached()) {
                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                }
            }
        };
        try {
            if (focusTransactionManagerRequireTransactionManager.ongoingTransaction) {
                focusTransactionManagerRequireTransactionManager.cancelTransaction();
            }
            focusTransactionManagerRequireTransactionManager.beginTransaction();
            focusTransactionManagerRequireTransactionManager.cancellationListener.add(function0);
            int i2 = WhenMappings.$EnumSwitchMapping$0[m18234performCustomRequestFocusMxy_nc0(focusTargetNode, i).ordinal()];
            if (i2 == 1) {
                boolValueOf = Boolean.valueOf(performRequestFocus(focusTargetNode));
            } else if (i2 != 2) {
                if (i2 != 3 && i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.TRUE;
            }
            return boolValueOf;
        } finally {
            focusTransactionManagerRequireTransactionManager.commitTransaction();
        }
    }

    private static final boolean requestFocusForChild(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        Modifier.Node node;
        Modifier.Node nodePop;
        NodeChain nodes;
        NodeChain nodes2;
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(1024);
        if (!focusTargetNode2.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = focusTargetNode2.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
        loop0: while (true) {
            node = null;
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
            parent = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
        }
        if (!Intrinsics.areEqual(nodePop, focusTargetNode)) {
            throw new IllegalStateException("Non child node cannot request focus.");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i2 == 1) {
            boolean zGrantFocus = grantFocus(focusTargetNode2);
            if (zGrantFocus) {
                focusTargetNode.setFocusState(FocusStateImpl.ActiveParent);
            }
            return zGrantFocus;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                int iM20090constructorimpl2 = NodeKind.m20090constructorimpl(1024);
                if (!focusTargetNode.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node parent2 = focusTargetNode.getNode().getParent();
                LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                loop4: while (true) {
                    if (layoutNodeRequireLayoutNode2 == null) {
                        break;
                    }
                    if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode2) & iM20090constructorimpl2) != 0) {
                        while (parent2 != null) {
                            if ((parent2.getKindSet() & iM20090constructorimpl2) != 0) {
                                Modifier.Node nodePop2 = parent2;
                                MutableVector mutableVector2 = null;
                                while (nodePop2 != null) {
                                    if (nodePop2 instanceof FocusTargetNode) {
                                        node = nodePop2;
                                        break loop4;
                                    }
                                    if ((nodePop2.getKindSet() & iM20090constructorimpl2) != 0 && (nodePop2 instanceof DelegatingNode)) {
                                        int i4 = 0;
                                        for (Modifier.Node delegate2 = ((DelegatingNode) nodePop2).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                            if ((delegate2.getKindSet() & iM20090constructorimpl2) != 0) {
                                                i4++;
                                                if (i4 == 1) {
                                                    nodePop2 = delegate2;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (nodePop2 != null) {
                                                        mutableVector2.add(nodePop2);
                                                        nodePop2 = null;
                                                    }
                                                    mutableVector2.add(delegate2);
                                                }
                                            }
                                        }
                                        if (i4 == 1) {
                                        }
                                    }
                                    nodePop2 = DelegatableNodeKt.pop(mutableVector2);
                                }
                            }
                            parent2 = parent2.getParent();
                        }
                    }
                    layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui_release();
                    parent2 = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
                }
                FocusTargetNode focusTargetNode3 = (FocusTargetNode) node;
                if (focusTargetNode3 == null && requestFocusForOwner(focusTargetNode)) {
                    boolean zGrantFocus2 = grantFocus(focusTargetNode2);
                    if (zGrantFocus2) {
                        focusTargetNode.setFocusState(FocusStateImpl.ActiveParent);
                    }
                    return zGrantFocus2;
                }
                if (focusTargetNode3 == null || !requestFocusForChild(focusTargetNode3, focusTargetNode)) {
                    return false;
                }
                boolean zRequestFocusForChild = requestFocusForChild(focusTargetNode, focusTargetNode2);
                if (focusTargetNode.getFocusState() != FocusStateImpl.ActiveParent) {
                    throw new IllegalStateException("Deactivated node is focused");
                }
                if (zRequestFocusForChild) {
                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode3);
                }
                return zRequestFocusForChild;
            }
            requireActiveChild(focusTargetNode);
            if (clearChildFocus$default(focusTargetNode, false, false, 3, null) && grantFocus(focusTargetNode2)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean requestFocusForOwner(FocusTargetNode focusTargetNode) {
        return DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().mo18217requestFocusForOwner7o62pno(null, null);
    }

    private static final FocusTargetNode requireActiveChild(FocusTargetNode focusTargetNode) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            return activeChild;
        }
        throw new IllegalArgumentException("ActiveParent with no focused child");
    }
}
