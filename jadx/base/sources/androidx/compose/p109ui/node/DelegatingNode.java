package androidx.compose.p109ui.node;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\rH\u0004¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\rH\u0000¢\u0006\u0004\b\u0012\u0010\u0010J\"\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0016H\u0080\b¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u0019J\r\u0010\u001a\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\u0014H\u0010¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0001H\u0010¢\u0006\u0002\b$J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u000eH\u0004J\u0015\u0010'\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u000eH\u0000¢\u0006\u0002\b(J\u0017\u0010)\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010+H\u0010¢\u0006\u0002\b,J\u0018\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u000200H\u0002J\u0018\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0001H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f¨\u00064"}, m13886d2 = {"Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "delegate", "getDelegate$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "setDelegate$ui_release", "(Landroidx/compose/ui/Modifier$Node;)V", "selfKindSet", "", "getSelfKindSet$ui_release$annotations", "getSelfKindSet$ui_release", "()I", "T", "Landroidx/compose/ui/node/DelegatableNode;", "delegatableNode", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/node/DelegatableNode;", "delegateUnprotected", "delegateUnprotected$ui_release", "forEachImmediateDelegate", "", "block", "Lkotlin/Function1;", "forEachImmediateDelegate$ui_release", "markAsAttached", "markAsAttached$ui_release", "markAsDetached", "markAsDetached$ui_release", "reset", "reset$ui_release", "runAttachLifecycle", "runAttachLifecycle$ui_release", "runDetachLifecycle", "runDetachLifecycle$ui_release", "setAsDelegateTo", "owner", "setAsDelegateTo$ui_release", "undelegate", "instance", "undelegateUnprotected", "undelegateUnprotected$ui_release", "updateCoordinator", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "updateCoordinator$ui_release", "updateNodeKindSet", "newKindSet", "recalculateOwner", "", "validateDelegateKindSet", "delegateKindSet", "delegateNode", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDelegatingNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n+ 3 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n+ 4 NodeKind.kt\nandroidx/compose/ui/node/NodeKindKt\n*L\n1#1,288:1\n245#1,6:289\n245#1,6:295\n245#1,6:321\n245#1,6:327\n245#1,6:333\n245#1,6:339\n245#1,6:345\n42#2,7:301\n42#2,7:314\n78#3:308\n78#3:310\n78#3:312\n61#4:309\n61#4:311\n61#4:313\n*S KotlinDebug\n*F\n+ 1 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n*L\n45#1:289,6\n64#1:295,6\n254#1:321,6\n265#1:327,6\n273#1:333,6\n279#1:339,6\n285#1:345,6\n95#1:301,7\n192#1:314,7\n117#1:308\n173#1:310\n187#1:312\n117#1:309\n173#1:311\n187#1:313\n*E\n"})
public abstract class DelegatingNode extends Modifier.Node {
    public static final int $stable = 8;

    @Nullable
    private Modifier.Node delegate;
    private final int selfKindSet = NodeKindKt.calculateNodeKindSetFrom(this);

    private final void updateNodeKindSet(int newKindSet, boolean recalculateOwner) {
        Modifier.Node child;
        int kindSet = getKindSet();
        setKindSet$ui_release(newKindSet);
        if (kindSet != newKindSet) {
            if (DelegatableNodeKt.isDelegationRoot(this)) {
                setAggregateChildKindSet$ui_release(newKindSet);
            }
            if (getIsAttached()) {
                Modifier.Node node = getNode();
                Modifier.Node parent = this;
                while (parent != null) {
                    newKindSet |= parent.getKindSet();
                    parent.setKindSet$ui_release(newKindSet);
                    if (parent == node) {
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (recalculateOwner && parent == node) {
                    newKindSet = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node);
                    node.setKindSet$ui_release(newKindSet);
                }
                int aggregateChildKindSet = newKindSet | ((parent == null || (child = parent.getChild()) == null) ? 0 : child.getAggregateChildKindSet());
                while (parent != null) {
                    aggregateChildKindSet |= parent.getKindSet();
                    parent.setAggregateChildKindSet$ui_release(aggregateChildKindSet);
                    parent = parent.getParent();
                }
            }
        }
    }

    private final void validateDelegateKindSet(int delegateKindSet, Modifier.Node delegateNode) {
        int kindSet = getKindSet();
        if ((delegateKindSet & NodeKind.m20090constructorimpl(2)) == 0 || (NodeKind.m20090constructorimpl(2) & kindSet) == 0 || (this instanceof LayoutModifierNode)) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + delegateNode);
    }

    @NotNull
    public final <T extends DelegatableNode> T delegate(@NotNull T delegatableNode) {
        Modifier.Node node = delegatableNode.getNode();
        if (node != delegatableNode) {
            Modifier.Node node2 = delegatableNode instanceof Modifier.Node ? (Modifier.Node) delegatableNode : null;
            Modifier.Node parent = node2 != null ? node2.getParent() : null;
            if (node == getNode() && Intrinsics.areEqual(parent, this)) {
                return delegatableNode;
            }
            throw new IllegalStateException("Cannot delegate to an already delegated node");
        }
        if (node.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("Cannot delegate to an already attached node");
        }
        node.setAsDelegateTo$ui_release(getNode());
        int kindSet = getKindSet();
        int iCalculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node);
        node.setKindSet$ui_release(iCalculateNodeKindSetFromIncludingDelegates);
        validateDelegateKindSet(iCalculateNodeKindSetFromIncludingDelegates, node);
        node.setChild$ui_release(this.delegate);
        this.delegate = node;
        node.setParent$ui_release(this);
        updateNodeKindSet(getKindSet() | iCalculateNodeKindSetFromIncludingDelegates, false);
        if (getIsAttached()) {
            if ((iCalculateNodeKindSetFromIncludingDelegates & NodeKind.m20090constructorimpl(2)) == 0 || (kindSet & NodeKind.m20090constructorimpl(2)) != 0) {
                updateCoordinator$ui_release(getCoordinator());
            } else {
                NodeChain nodes = DelegatableNodeKt.requireLayoutNode(this).getNodes();
                getNode().updateCoordinator$ui_release(null);
                nodes.syncCoordinators();
            }
            node.markAsAttached$ui_release();
            node.runAttachLifecycle$ui_release();
            NodeKindKt.autoInvalidateInsertedNode(node);
        }
        return delegatableNode;
    }

    @NotNull
    public final <T extends DelegatableNode> T delegateUnprotected$ui_release(@NotNull T delegatableNode) {
        return (T) delegate(delegatableNode);
    }

    public final void forEachImmediateDelegate$ui_release(@NotNull Function1<? super Modifier.Node, Unit> block) {
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            block.invoke(delegate);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: getDelegate$ui_release, reason: from getter */
    public final Modifier.Node getDelegate() {
        return this.delegate;
    }

    /* JADX INFO: renamed from: getSelfKindSet$ui_release, reason: from getter */
    public final int getSelfKindSet() {
        return this.selfKindSet;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsAttached$ui_release() {
        super.markAsAttached$ui_release();
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.updateCoordinator$ui_release(getCoordinator());
            if (!delegate.getIsAttached()) {
                delegate.markAsAttached$ui_release();
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsDetached$ui_release() {
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.markAsDetached$ui_release();
        }
        super.markAsDetached$ui_release();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void reset$ui_release() {
        super.reset$ui_release();
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.reset$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runAttachLifecycle$ui_release() {
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.runAttachLifecycle$ui_release();
        }
        super.runAttachLifecycle$ui_release();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runDetachLifecycle$ui_release() {
        super.runDetachLifecycle$ui_release();
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.runDetachLifecycle$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void setAsDelegateTo$ui_release(@NotNull Modifier.Node owner) {
        super.setAsDelegateTo$ui_release(owner);
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.setAsDelegateTo$ui_release(owner);
        }
    }

    public final void setDelegate$ui_release(@Nullable Modifier.Node node) {
        this.delegate = node;
    }

    public final void undelegate(@NotNull DelegatableNode instance) {
        Modifier.Node node = null;
        for (Modifier.Node child = this.delegate; child != null; child = child.getChild()) {
            if (child == instance) {
                if (child.getIsAttached()) {
                    NodeKindKt.autoInvalidateRemovedNode(child);
                    child.runDetachLifecycle$ui_release();
                    child.markAsDetached$ui_release();
                }
                child.setAsDelegateTo$ui_release(child);
                child.setAggregateChildKindSet$ui_release(0);
                if (node == null) {
                    this.delegate = child.getChild();
                } else {
                    node.setChild$ui_release(child.getChild());
                }
                child.setChild$ui_release(null);
                child.setParent$ui_release(null);
                int kindSet = getKindSet();
                int iCalculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(this);
                updateNodeKindSet(iCalculateNodeKindSetFromIncludingDelegates, true);
                if (getIsAttached() && (kindSet & NodeKind.m20090constructorimpl(2)) != 0 && (NodeKind.m20090constructorimpl(2) & iCalculateNodeKindSetFromIncludingDelegates) == 0) {
                    NodeChain nodes = DelegatableNodeKt.requireLayoutNode(this).getNodes();
                    getNode().updateCoordinator$ui_release(null);
                    nodes.syncCoordinators();
                    return;
                }
                return;
            }
            node = child;
        }
        throw new IllegalStateException(("Could not find delegate: " + instance).toString());
    }

    public final void undelegateUnprotected$ui_release(@NotNull DelegatableNode instance) {
        undelegate(instance);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void updateCoordinator$ui_release(@Nullable NodeCoordinator coordinator) {
        super.updateCoordinator$ui_release(coordinator);
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild()) {
            delegate.updateCoordinator$ui_release(coordinator);
        }
    }

    public static /* synthetic */ void getSelfKindSet$ui_release$annotations() {
    }
}
