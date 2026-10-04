package com.vladsch.flexmark.util.ast;

import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.vladsch.flexmark.util.collection.CopyOnWriteRef;
import com.vladsch.flexmark.util.collection.OrderedMap;
import com.vladsch.flexmark.util.collection.OrderedSet;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NodeClassifierVisitor extends NodeVisitorBase implements NodeTracker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final BitSet EMPTY_SET = new BitSet();
    private final ClassifyingNodeTracker classifyingNodeTracker;
    private final OrderedMap<Class<?>, Set<Class<?>>> exclusionMap;
    private final OrderedSet<Class<?>> exclusionSet;
    private final HashMap<Integer, BitSet> nodeAncestryMap;
    private final Stack<BitSet> nodeAncestryBitSetStack = new Stack<>();
    private final CopyOnWriteRef<BitSet> nodeAncestryBitSet = new CopyOnWriteRef<>(new BitSet(), new C11419a(11));
    private boolean isClassificationDone = false;

    public NodeClassifierVisitor(Map<Class<? extends Node>, Set<Class<?>>> map) {
        ClassifyingNodeTracker classifyingNodeTracker = new ClassifyingNodeTracker(this, map);
        this.classifyingNodeTracker = classifyingNodeTracker;
        this.exclusionMap = classifyingNodeTracker.getExclusionMap();
        this.nodeAncestryMap = classifyingNodeTracker.getNodeAncestryMap();
        this.exclusionSet = classifyingNodeTracker.getExclusionSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BitSet lambda$new$0(BitSet bitSet) {
        return bitSet != null ? (BitSet) bitSet.clone() : new BitSet();
    }

    @NotNull
    public ClassifyingNodeTracker classify(@NotNull Node node) {
        visit(node);
        this.isClassificationDone = true;
        return this.classifyingNodeTracker;
    }

    @Override // com.vladsch.flexmark.util.ast.NodeTracker
    public void nodeAdded(@NotNull Node node) {
        if (this.isClassificationDone) {
            if (node.getParent() == null) {
                throw new IllegalStateException("Node must be inserted into the document before calling node tracker nodeAdded functions");
            }
            if (!(node.getParent() instanceof Document)) {
                int iIndexOf = this.classifyingNodeTracker.getItems().indexOf(node.getParent());
                if (iIndexOf == -1) {
                    throw new IllegalStateException("Parent node: " + node.getParent() + " of " + node + " is not tracked, some post processor forgot to call tracker.nodeAdded().");
                }
                this.nodeAncestryBitSet.setValue(this.nodeAncestryMap.get(Integer.valueOf(iIndexOf)));
            }
            this.nodeAncestryBitSetStack.clear();
            visit(node);
        }
    }

    @Override // com.vladsch.flexmark.util.ast.NodeTracker
    public void nodeAddedWithChildren(@NotNull Node node) {
        nodeAdded(node);
    }

    @Override // com.vladsch.flexmark.util.ast.NodeTracker
    public void nodeAddedWithDescendants(@NotNull Node node) {
        nodeAdded(node);
    }

    @Override // com.vladsch.flexmark.util.ast.NodeTracker
    public void nodeRemoved(@NotNull Node node) {
    }

    @Override // com.vladsch.flexmark.util.ast.NodeTracker
    public void nodeRemovedWithChildren(@NotNull Node node) {
    }

    @Override // com.vladsch.flexmark.util.ast.NodeTracker
    public void nodeRemovedWithDescendants(@NotNull Node node) {
    }

    public void popNodeAncestry() {
        this.nodeAncestryBitSet.setValue(this.nodeAncestryBitSetStack.pop());
    }

    public void pushNodeAncestry() {
        if (this.exclusionMap.isEmpty()) {
            return;
        }
        this.nodeAncestryBitSetStack.push(this.nodeAncestryBitSet.getImmutable());
    }

    public boolean updateNodeAncestry(Node node, CopyOnWriteRef<BitSet> copyOnWriteRef) {
        BitSet bitSet;
        if (!this.exclusionMap.isEmpty() && !(node instanceof Document)) {
            BitSet peek = copyOnWriteRef.getPeek();
            int iIndexOf = this.classifyingNodeTracker.getItems().indexOf(node);
            if (iIndexOf == -1) {
                throw new IllegalStateException("Node: " + node + " is not tracked, some post processor forgot to call tracker.nodeAdded().");
            }
            OrderedSet<Class<?>> orderedSet = this.exclusionSet;
            if (orderedSet != null && !orderedSet.isEmpty()) {
                for (Class<?> cls : this.exclusionSet) {
                    if (cls.isInstance(node)) {
                        int iIndexOf2 = this.exclusionSet.indexOf(cls);
                        if (!peek.get(iIndexOf2)) {
                            peek = copyOnWriteRef.getMutable();
                            peek.set(iIndexOf2);
                        }
                    }
                }
            }
            if (this.isClassificationDone && this.nodeAncestryBitSetStack.size() > 1 && (bitSet = this.nodeAncestryMap.get(Integer.valueOf(iIndexOf))) != null && bitSet.equals(peek)) {
                return false;
            }
            if (!peek.isEmpty()) {
                this.nodeAncestryMap.put(Integer.valueOf(iIndexOf), copyOnWriteRef.getImmutable());
            }
        }
        return true;
    }

    @Override // com.vladsch.flexmark.util.ast.NodeVisitorBase
    public void visit(@NotNull Node node) {
        visitChildren(node);
    }

    @Override // com.vladsch.flexmark.util.ast.NodeVisitorBase
    public void visitChildren(@NotNull Node node) {
        if (!this.isClassificationDone && !(node instanceof Document)) {
            this.classifyingNodeTracker.nodeAdded(node);
        }
        if (node.getFirstChild() == null) {
            updateNodeAncestry(node, this.nodeAncestryBitSet);
            return;
        }
        pushNodeAncestry();
        if (updateNodeAncestry(node, this.nodeAncestryBitSet)) {
            super.visitChildren(node);
        }
        popNodeAncestry();
    }
}
