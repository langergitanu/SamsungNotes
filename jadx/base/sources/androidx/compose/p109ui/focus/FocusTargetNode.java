package androidx.compose.p109ui.focus;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.layout.BeyondBoundsLayout;
import androidx.compose.p109ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.p109ui.modifier.ModifierLocalModifierNode;
import androidx.compose.p109ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.DelegatingNode;
import androidx.compose.p109ui.node.LayoutNode;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.node.NodeChain;
import androidx.compose.p109ui.node.NodeKind;
import androidx.compose.p109ui.node.ObserverModifierNode;
import androidx.compose.p109ui.node.ObserverModifierNodeKt;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u00015B\u0005¢\u0006\u0002\u0010\u0006J\r\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b\"J/\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020!0'H\u0080\bø\u0001\u0000¢\u0006\u0004\b)\u0010*J/\u0010+\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020!0'H\u0080\bø\u0001\u0000¢\u0006\u0004\b,\u0010*J\r\u0010-\u001a\u00020.H\u0000¢\u0006\u0002\b/J\b\u00100\u001a\u00020!H\u0002J\r\u00101\u001a\u00020!H\u0000¢\u0006\u0002\b2J\b\u00103\u001a\u00020!H\u0016J\b\u00104\u001a\u00020!H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u0015X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, m13886d2 = {"Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "beyondBoundsLayoutParent", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "getBeyondBoundsLayoutParent", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "committedFocusState", "Landroidx/compose/ui/focus/FocusStateImpl;", "value", "focusState", "getFocusState$annotations", "getFocusState", "()Landroidx/compose/ui/focus/FocusStateImpl;", "setFocusState", "(Landroidx/compose/ui/focus/FocusStateImpl;)V", "isProcessingCustomEnter", "", "isProcessingCustomExit", "previouslyFocusedChildHash", "", "getPreviouslyFocusedChildHash", "()I", "setPreviouslyFocusedChildHash", "(I)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "commitFocusState", "", "commitFocusState$ui_release", "fetchCustomEnter", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusRequester;", "fetchCustomEnter-aToIllA$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "fetchCustomExit", "fetchCustomExit-aToIllA$ui_release", "fetchFocusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "fetchFocusProperties$ui_release", "initializeFocusState", "invalidateFocus", "invalidateFocus$ui_release", "onDetach", "onObservedReadsChanged", "FocusTargetElement", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFocusTargetNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FocusTargetNode.kt\nandroidx/compose/ui/focus/FocusTargetNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 FocusTransactionManager.kt\nandroidx/compose/ui/focus/FocusTransactionManager\n+ 4 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 5 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n+ 6 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n+ 7 Modifier.kt\nandroidx/compose/ui/Modifier$Node\n+ 8 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n+ 9 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 10 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n*L\n1#1,268:1\n1#2:269\n1#2:277\n1#2:289\n1#2:373\n1#2:387\n40#3,7:270\n47#3,4:280\n40#3,7:366\n47#3,4:376\n728#4,2:278\n728#4,2:374\n98#5:284\n96#5:285\n96#5:380\n96#5:446\n262#6,2:286\n62#6:288\n63#6,8:290\n264#6:298\n265#6,2:300\n432#6,12:302\n444#6,8:317\n452#6,9:328\n461#6,8:340\n268#6:348\n72#6,7:349\n269#6:356\n251#6,5:381\n62#6:386\n63#6,8:388\n432#6,6:396\n442#6,2:403\n444#6,8:408\n452#6,9:419\n461#6,8:431\n72#6,7:439\n310#6:447\n167#6:448\n168#6:456\n169#6,12:460\n311#6:472\n432#6,5:473\n312#6,2:478\n437#6:480\n442#6,2:482\n444#6,17:487\n461#6,8:507\n314#6:515\n181#6,8:516\n315#6:524\n249#7:299\n249#7:402\n249#7:481\n245#8,3:314\n248#8,3:337\n245#8,3:405\n248#8,3:428\n245#8,3:484\n248#8,3:504\n1208#9:325\n1187#9,2:326\n1208#9:416\n1187#9,2:417\n1208#9:457\n1187#9,2:458\n66#10,9:357\n42#10,7:449\n*S KotlinDebug\n*F\n+ 1 FocusTargetNode.kt\nandroidx/compose/ui/focus/FocusTargetNode\n*L\n105#1:277\n119#1:289\n250#1:373\n225#1:387\n105#1:270,7\n105#1:280,4\n250#1:366,7\n250#1:376,4\n105#1:278,2\n250#1:374,2\n119#1:284\n119#1:285\n225#1:380\n237#1:446\n119#1:286,2\n119#1:288\n119#1:290,8\n119#1:298\n119#1:300,2\n119#1:302,12\n119#1:317,8\n119#1:328,9\n119#1:340,8\n119#1:348\n119#1:349,7\n119#1:356\n225#1:381,5\n225#1:386\n225#1:388,8\n225#1:396,6\n225#1:403,2\n225#1:408,8\n225#1:419,9\n225#1:431,8\n225#1:439,7\n237#1:447\n237#1:448\n237#1:456\n237#1:460,12\n237#1:472\n237#1:473,5\n237#1:478,2\n237#1:480\n237#1:482,2\n237#1:487,17\n237#1:507,8\n237#1:515\n237#1:516,8\n237#1:524\n119#1:299\n225#1:402\n237#1:481\n119#1:314,3\n119#1:337,3\n225#1:405,3\n225#1:428,3\n237#1:484,3\n237#1:504,3\n119#1:325\n119#1:326,2\n225#1:416\n225#1:417,2\n237#1:457\n237#1:458,2\n181#1:357,9\n237#1:449,7\n*E\n"})
public final class FocusTargetNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, FocusTargetModifierNode, ObserverModifierNode, ModifierLocalModifierNode {
    public static final int $stable = 8;

    @Nullable
    private FocusStateImpl committedFocusState;
    private boolean isProcessingCustomEnter;
    private boolean isProcessingCustomExit;
    private int previouslyFocusedChildHash;
    private final boolean shouldAutoInvalidate;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\f\u0010\u000e\u001a\u00020\f*\u00020\u000fH\u0016¨\u0006\u0010"}, m13886d2 = {"Landroidx/compose/ui/focus/FocusTargetNode$FocusTargetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusTargetNode;", "()V", "create", "equals", "", "other", "", "hashCode", "", Constants.ARG_UPDATE, "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class FocusTargetElement extends ModifierNodeElement<FocusTargetNode> {
        public static final int $stable = 0;

        @NotNull
        public static final FocusTargetElement INSTANCE = new FocusTargetElement();

        private FocusTargetElement() {
        }

        @Override // androidx.compose.p109ui.node.ModifierNodeElement
        public boolean equals(@Nullable Object other) {
            return other == this;
        }

        @Override // androidx.compose.p109ui.node.ModifierNodeElement
        public int hashCode() {
            return 1739042953;
        }

        @Override // androidx.compose.p109ui.node.ModifierNodeElement
        public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
            inspectorInfo.setName("focusTarget");
        }

        @Override // androidx.compose.p109ui.node.ModifierNodeElement
        public void update(@NotNull FocusTargetNode node) {
        }

        @Override // androidx.compose.p109ui.node.ModifierNodeElement
        @NotNull
        public FocusTargetNode create() {
            return new FocusTargetNode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void initializeFocusState() {
        if (initializeFocusState$isInitialized(this)) {
            throw new IllegalStateException("Re-initializing focus target node.");
        }
        FocusTransactionManager focusTransactionManagerRequireTransactionManager = FocusTargetNodeKt.requireTransactionManager(this);
        try {
            if (focusTransactionManagerRequireTransactionManager.ongoingTransaction) {
                focusTransactionManagerRequireTransactionManager.cancelTransaction();
            }
            focusTransactionManagerRequireTransactionManager.beginTransaction();
            setFocusState((initializeFocusState$isInActiveSubTree(this) && initializeFocusState$hasActiveChild(this)) ? FocusStateImpl.ActiveParent : FocusStateImpl.Inactive);
            Unit unit = Unit.INSTANCE;
            focusTransactionManagerRequireTransactionManager.commitTransaction();
        } catch (Throwable th) {
            focusTransactionManagerRequireTransactionManager.commitTransaction();
            throw th;
        }
    }

    private static final boolean initializeFocusState$hasActiveChild(FocusTargetNode focusTargetNode) {
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode.getNode());
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
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                if (initializeFocusState$isInitialized(focusTargetNode2)) {
                                    int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode2.getFocusState().ordinal()];
                                    if (i == 1 || i == 2 || i == 3) {
                                        return true;
                                    }
                                    if (i == 4) {
                                        return false;
                                    }
                                    throw new NoWhenBranchMatchedException();
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
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
        }
        return false;
    }

    private static final boolean initializeFocusState$isInActiveSubTree(FocusTargetNode focusTargetNode) {
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
                                if (initializeFocusState$isInitialized(focusTargetNode2)) {
                                    int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode2.getFocusState().ordinal()];
                                    if (i != 1 && i != 2) {
                                        if (i == 3) {
                                            return true;
                                        }
                                        if (i != 4) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                    }
                                    return false;
                                }
                            } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
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
        return false;
    }

    private static final boolean initializeFocusState$isInitialized(FocusTargetNode focusTargetNode) {
        return focusTargetNode.committedFocusState != null;
    }

    public final void commitFocusState$ui_release() {
        FocusStateImpl uncommittedFocusState = FocusTargetNodeKt.requireTransactionManager(this).getUncommittedFocusState(this);
        if (uncommittedFocusState == null) {
            throw AbstractC1974b.m1327t("committing a node that was not updated in the current transaction");
        }
        this.committedFocusState = uncommittedFocusState;
    }

    /* JADX INFO: renamed from: fetchCustomEnter-aToIllA$ui_release, reason: not valid java name */
    public final void m18229fetchCustomEnteraToIllA$ui_release(int focusDirection, @NotNull Function1<? super FocusRequester, Unit> block) {
        if (this.isProcessingCustomEnter) {
            return;
        }
        this.isProcessingCustomEnter = true;
        try {
            FocusRequester focusRequesterInvoke = fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m18193boximpl(focusDirection));
            if (focusRequesterInvoke != FocusRequester.INSTANCE.getDefault()) {
                block.invoke(focusRequesterInvoke);
            }
        } finally {
            InlineMarker.finallyStart(1);
            this.isProcessingCustomEnter = false;
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: fetchCustomExit-aToIllA$ui_release, reason: not valid java name */
    public final void m18230fetchCustomExitaToIllA$ui_release(int focusDirection, @NotNull Function1<? super FocusRequester, Unit> block) {
        if (this.isProcessingCustomExit) {
            return;
        }
        this.isProcessingCustomExit = true;
        try {
            FocusRequester focusRequesterInvoke = fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.m18193boximpl(focusDirection));
            if (focusRequesterInvoke != FocusRequester.INSTANCE.getDefault()) {
                block.invoke(focusRequesterInvoke);
            }
        } finally {
            InlineMarker.finallyStart(1);
            this.isProcessingCustomExit = false;
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12 */
    @NotNull
    public final FocusProperties fetchFocusProperties$ui_release() {
        NodeChain nodes;
        FocusPropertiesImpl focusPropertiesImpl = new FocusPropertiesImpl();
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(2048);
        int iM20090constructorimpl2 = NodeKind.m20090constructorimpl(1024);
        Modifier.Node node = getNode();
        int i = iM20090constructorimpl | iM20090constructorimpl2;
        if (!getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = getNode();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(this);
        while (layoutNodeRequireLayoutNode != null) {
            if ((AbstractC1974b.m1312e(layoutNodeRequireLayoutNode) & i) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet() & i) != 0) {
                        if (node2 != node && (node2.getKindSet() & iM20090constructorimpl2) != 0) {
                            return focusPropertiesImpl;
                        }
                        if ((node2.getKindSet() & iM20090constructorimpl) != 0) {
                            Modifier.Node nodePop = node2;
                            MutableVector mutableVector = null;
                            while (nodePop != 0) {
                                if (nodePop instanceof FocusPropertiesModifierNode) {
                                    ((FocusPropertiesModifierNode) nodePop).applyFocusProperties(focusPropertiesImpl);
                                } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                    int i2 = 0;
                                    nodePop = nodePop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                            i2++;
                                            if (i2 == 1) {
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
                                    if (i2 == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                    }
                    node2 = node2.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            node2 = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return focusPropertiesImpl;
    }

    @Nullable
    public final BeyondBoundsLayout getBeyondBoundsLayoutParent() {
        return (BeyondBoundsLayout) getCurrent(BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
    }

    public final int getPreviouslyFocusedChildHash() {
        return this.previouslyFocusedChildHash;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public final void invalidateFocus$ui_release() {
        FocusProperties focusProperties;
        if (this.committedFocusState == null) {
            initializeFocusState();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[getFocusState().ordinal()];
        if (i == 1 || i == 2) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTargetNode$invalidateFocus$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [T, androidx.compose.ui.focus.FocusProperties] */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    objectRef.element = this.fetchFocusProperties$ui_release();
                }
            });
            T t = objectRef.element;
            if (t == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
                focusProperties = null;
            } else {
                focusProperties = (FocusProperties) t;
            }
            if (focusProperties.getCanFocus()) {
                return;
            }
            DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        int i = WhenMappings.$EnumSwitchMapping$0[getFocusState().ordinal()];
        if (i == 1 || i == 2) {
            DelegatableNodeKt.requireOwner(this).getFocusOwner().mo18213clearFocusI7lrPNg(true, true, false, FocusDirection.INSTANCE.m18204getExitdhqQ8s());
            FocusTargetNodeKt.invalidateFocusTarget(this);
        } else if (i == 3) {
            FocusTransactionManager focusTransactionManagerRequireTransactionManager = FocusTargetNodeKt.requireTransactionManager(this);
            try {
                if (focusTransactionManagerRequireTransactionManager.ongoingTransaction) {
                    focusTransactionManagerRequireTransactionManager.cancelTransaction();
                }
                focusTransactionManagerRequireTransactionManager.beginTransaction();
                setFocusState(FocusStateImpl.Inactive);
                Unit unit = Unit.INSTANCE;
                focusTransactionManagerRequireTransactionManager.commitTransaction();
            } catch (Throwable th) {
                focusTransactionManagerRequireTransactionManager.commitTransaction();
                throw th;
            }
        }
        this.committedFocusState = null;
    }

    @Override // androidx.compose.p109ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        FocusStateImpl focusState = getFocusState();
        invalidateFocus$ui_release();
        if (focusState != getFocusState()) {
            FocusEventModifierNodeKt.refreshFocusEventNodes(this);
        }
    }

    public void setFocusState(@NotNull FocusStateImpl focusStateImpl) {
        FocusTargetNodeKt.requireTransactionManager(this).setUncommittedFocusState(this, focusStateImpl);
    }

    public final void setPreviouslyFocusedChildHash(int i) {
        this.previouslyFocusedChildHash = i;
    }

    @Override // androidx.compose.p109ui.focus.FocusTargetModifierNode
    @NotNull
    public FocusStateImpl getFocusState() {
        FocusStateImpl uncommittedFocusState;
        FocusTransactionManager focusTransactionManager = FocusTargetNodeKt.getFocusTransactionManager(this);
        if (focusTransactionManager != null && (uncommittedFocusState = focusTransactionManager.getUncommittedFocusState(this)) != null) {
            return uncommittedFocusState;
        }
        FocusStateImpl focusStateImpl = this.committedFocusState;
        return focusStateImpl == null ? FocusStateImpl.Inactive : focusStateImpl;
    }

    public static /* synthetic */ void getFocusState$annotations() {
    }
}
