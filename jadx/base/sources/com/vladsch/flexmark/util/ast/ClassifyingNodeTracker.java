package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.collection.ClassificationBag;
import com.vladsch.flexmark.util.collection.OrderedMap;
import com.vladsch.flexmark.util.collection.OrderedSet;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIterable;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable;
import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ClassifyingNodeTracker implements NodeTracker {

    @NotNull
    private final OrderedMap<Class<?>, Set<Class<?>>> exclusionMap;

    @NotNull
    private final OrderedSet<Class<?>> exclusionSet;

    @Nullable
    private final NodeTracker host;

    @NotNull
    private final HashMap<Integer, BitSet> nodeAncestryMap;

    @NotNull
    protected final ClassificationBag<Class<?>, Node> nodeClassifier = new ClassificationBag<>(NodeClassifier.INSTANCE);

    public ClassifyingNodeTracker(@Nullable NodeTracker nodeTracker, @NotNull Map<Class<? extends Node>, Set<Class<?>>> map) {
        this.host = nodeTracker;
        OrderedMap<Class<?>, Set<Class<?>>> orderedMap = new OrderedMap<>(map.size());
        this.exclusionMap = orderedMap;
        orderedMap.putAll(map);
        this.exclusionSet = new OrderedSet<>();
        ReversibleIterator<Set<Class<?>>> it = orderedMap.valueIterable().iterator();
        while (it.hasNext()) {
            this.exclusionSet.addAll(it.next());
        }
        this.nodeAncestryMap = new HashMap<>();
    }

    private void addNodes(@NotNull ReversiblePeekingIterable<Node> reversiblePeekingIterable) {
        ReversiblePeekingIterator<Node> it = reversiblePeekingIterable.iterator();
        while (it.hasNext()) {
            this.nodeClassifier.add(it.next());
        }
    }

    private void removeNodes(@NotNull ReversiblePeekingIterable<Node> reversiblePeekingIterable) {
        ReversiblePeekingIterator<Node> it = reversiblePeekingIterable.iterator();
        while (it.hasNext()) {
            this.nodeClassifier.add(it.next());
        }
    }

    private void validateLinked(Node node) {
        if (node.getNext() == null && node.getParent() == null) {
            throw new IllegalStateException("Added block " + node + " is not linked into the AST");
        }
    }

    private void validateUnlinked(@NotNull Node node) {
        if (node.getNext() == null && node.getParent() == null) {
            return;
        }
        throw new IllegalStateException("Removed block " + node + " is still linked in the AST");
    }

    @NotNull
    public <X> ReversibleIterable<X> getCategoryItems(@NotNull Class<? extends X> cls, @NotNull Set<Class<?>> set) {
        return this.nodeClassifier.getCategoryItems(cls, set);
    }

    @NotNull
    public OrderedMap<Class<?>, Set<Class<?>>> getExclusionMap() {
        return this.exclusionMap;
    }

    @NotNull
    public OrderedSet<Class<?>> getExclusionSet() {
        return this.exclusionSet;
    }

    @NotNull
    public OrderedSet<Node> getItems() {
        return this.nodeClassifier.getItems();
    }

    @NotNull
    public HashMap<Integer, BitSet> getNodeAncestryMap() {
        return this.nodeAncestryMap;
    }

    @NotNull
    public ClassificationBag<Class<?>, Node> getNodeClassifier() {
        return this.nodeClassifier;
    }

    @Override // com.vladsch.flexmark.util.ast.NodeTracker
    public void nodeAdded(@NotNull Node node) {
        validateLinked(node);
        this.nodeClassifier.add(node);
        NodeTracker nodeTracker = this.host;
        if (nodeTracker != null) {
            nodeTracker.nodeAdded(node);
        }
    }

    @Override // com.vladsch.flexmark.util.ast.NodeTracker
    public void nodeAddedWithChildren(@NotNull Node node) {
        validateLinked(node);
        this.nodeClassifier.add(node);
        addNodes(node.getChildren());
        NodeTracker nodeTracker = this.host;
        if (nodeTracker != null) {
            nodeTracker.nodeAddedWithChildren(node);
        }
    }

    @Override // com.vladsch.flexmark.util.ast.NodeTracker
    public void nodeAddedWithDescendants(@NotNull Node node) {
        validateLinked(node);
        this.nodeClassifier.add(node);
        addNodes(node.getDescendants());
        NodeTracker nodeTracker = this.host;
        if (nodeTracker != null) {
            nodeTracker.nodeAddedWithDescendants(node);
        }
    }

    @Override // com.vladsch.flexmark.util.ast.NodeTracker
    public void nodeRemoved(@NotNull Node node) {
        nodeRemovedWithDescendants(node);
    }

    @Override // com.vladsch.flexmark.util.ast.NodeTracker
    public void nodeRemovedWithChildren(@NotNull Node node) {
        nodeRemovedWithDescendants(node);
    }

    @Override // com.vladsch.flexmark.util.ast.NodeTracker
    public void nodeRemovedWithDescendants(@NotNull Node node) {
        validateUnlinked(node);
        this.nodeClassifier.add(node);
        removeNodes(node.getDescendants());
        NodeTracker nodeTracker = this.host;
        if (nodeTracker != null) {
            nodeTracker.nodeRemovedWithDescendants(node);
        }
    }
}
