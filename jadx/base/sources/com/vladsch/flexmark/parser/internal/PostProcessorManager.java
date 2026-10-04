package com.vladsch.flexmark.parser.internal;

import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.vladsch.flexmark.parser.PostProcessor;
import com.vladsch.flexmark.parser.PostProcessorFactory;
import com.vladsch.flexmark.util.ast.ClassifyingNodeTracker;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeClassifierVisitor;
import com.vladsch.flexmark.util.collection.OrderedSet;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.dependency.DependencyResolver;
import com.vladsch.flexmark.util.dependency.DependentItem;
import com.vladsch.flexmark.util.dependency.DependentItemMap;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p005A3.C0016a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PostProcessorManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final OrderedSet<Node> allPostProcessNodes = new OrderedSet<>();
    private final List<PostProcessorDependencyStage> postProcessorDependencies;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PostProcessorDependencyStage {
        final List<PostProcessorFactory> dependents;
        final Map<Class<? extends Node>, Set<Class<?>>> myNodeMap;

        public PostProcessorDependencyStage(List<PostProcessorFactory> list) {
            HashMap map = new HashMap();
            for (PostProcessorFactory postProcessorFactory : list) {
                Map<Class<?>, Set<Class<?>>> nodeTypes = postProcessorFactory.getNodeTypes();
                if ((nodeTypes == null || nodeTypes.isEmpty()) && !postProcessorFactory.affectsGlobalScope()) {
                    throw new IllegalStateException("PostProcessorFactory " + postProcessorFactory + " is not document post processor and has empty node map, does nothing, should not be registered.");
                }
                if (nodeTypes != null) {
                    for (Map.Entry<Class<?>, Set<Class<?>>> entry : nodeTypes.entrySet()) {
                        if (Node.class.isAssignableFrom(entry.getKey())) {
                            Set set = (Set) map.get(entry.getKey());
                            Set<Class<?>> value = entry.getValue();
                            if (set == null) {
                                map.put(entry.getKey(), new HashSet(value));
                            } else {
                                try {
                                    set.addAll(value);
                                } catch (UnsupportedOperationException unused) {
                                    new HashSet(set).addAll(value);
                                }
                            }
                        }
                    }
                }
            }
            this.dependents = list;
            this.myNodeMap = map;
        }
    }

    public PostProcessorManager(List<PostProcessorDependencyStage> list) {
        this.postProcessorDependencies = list;
    }

    public static List<PostProcessorDependencyStage> calculatePostProcessors(DataHolder dataHolder, List<PostProcessorFactory> list) {
        List listResolveDependencies = DependencyResolver.resolveDependencies(list, new C11419a(10), null);
        ArrayList arrayList = new ArrayList(listResolveDependencies.size());
        Iterator it = listResolveDependencies.iterator();
        while (it.hasNext()) {
            arrayList.add(new PostProcessorDependencyStage((List) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$prioritizePostProcessors$0(Map.Entry entry, Map.Entry entry2) {
        return (((DependentItem) entry.getValue()).isGlobalScope ? 1 : 0) - (((DependentItem) entry2.getValue()).isGlobalScope ? 1 : 0);
    }

    public static DependentItemMap<PostProcessorFactory> prioritizePostProcessors(DependentItemMap<PostProcessorFactory> dependentItemMap) {
        List<Map.Entry<Class<?>, DependentItem<D>>> listEntries = dependentItemMap.entries();
        listEntries.sort(new C0016a(16));
        if (dependentItemMap.keySet().keyDifferenceBitSet(listEntries).isEmpty()) {
            return dependentItemMap;
        }
        DependentItemMap<PostProcessorFactory> dependentItemMap2 = new DependentItemMap<>(listEntries.size());
        dependentItemMap2.addAll(listEntries);
        return dependentItemMap2;
    }

    public static Document processDocument(Document document, List<PostProcessorDependencyStage> list) {
        return !list.isEmpty() ? new PostProcessorManager(list).postProcess(document) : document;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Document postProcess(Document document) {
        int iIndexOf;
        BitSet bitSet;
        ClassifyingNodeTracker classifyingNodeTrackerClassify = null;
        for (PostProcessorDependencyStage postProcessorDependencyStage : this.postProcessorDependencies) {
            for (PostProcessorFactory postProcessorFactory : postProcessorDependencyStage.dependents) {
                if (postProcessorFactory.affectsGlobalScope()) {
                    document = postProcessorFactory.apply(document).processDocument(document);
                    classifyingNodeTrackerClassify = null;
                } else {
                    if (classifyingNodeTrackerClassify == null) {
                        classifyingNodeTrackerClassify = new NodeClassifierVisitor(postProcessorDependencyStage.myNodeMap).classify(document);
                    }
                    Map<Class<?>, Set<Class<?>>> nodeTypes = postProcessorFactory.getNodeTypes();
                    PostProcessor postProcessorApply = postProcessorFactory.apply(document);
                    BitSet bitSet2 = new BitSet();
                    if (nodeTypes != null) {
                        Iterator<Set<Class<?>>> it = nodeTypes.values().iterator();
                        while (it.hasNext()) {
                            bitSet2.or(classifyingNodeTrackerClassify.getExclusionSet().indexBitSet(it.next()));
                        }
                        ReversibleIterator it2 = classifyingNodeTrackerClassify.getCategoryItems(Node.class, nodeTypes.keySet()).iterator();
                        while (it2.hasNext()) {
                            Node node = (Node) it2.next();
                            if (node.getParent() != null) {
                                Set<Class<?>> set = nodeTypes.get(node.getClass());
                                if (set != null && (iIndexOf = classifyingNodeTrackerClassify.getItems().indexOf(node)) != -1 && (bitSet = classifyingNodeTrackerClassify.getNodeAncestryMap().get(Integer.valueOf(iIndexOf))) != null) {
                                    BitSet bitSetIndexBitSet = classifyingNodeTrackerClassify.getExclusionSet().indexBitSet(set);
                                    bitSetIndexBitSet.and(bitSet);
                                    if (!bitSetIndexBitSet.isEmpty()) {
                                    }
                                }
                                postProcessorApply.process(classifyingNodeTrackerClassify, node);
                            }
                        }
                    }
                }
            }
        }
        return document;
    }
}
