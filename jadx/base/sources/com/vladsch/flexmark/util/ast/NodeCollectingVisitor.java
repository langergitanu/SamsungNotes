package com.vladsch.flexmark.util.ast;

import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.vladsch.flexmark.util.collection.ClassificationBag;
import com.vladsch.flexmark.util.collection.SubClassingBag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NodeCollectingVisitor {

    @NotNull
    private final Class<?>[] classes;

    @NotNull
    private final HashSet<Class<?>> excluded;

    @NotNull
    private final HashSet<Class<?>> included;

    @NotNull
    private final ClassificationBag<Class<?>, Node> nodes;

    @NotNull
    private final HashMap<Class<?>, List<Class<?>>> subClassMap = new HashMap<>();
    public static final Function<Node, Class<?>> NODE_CLASSIFIER = new C11419a(12);
    private static final Class<?>[] EMPTY_CLASSES = new Class[0];

    public NodeCollectingVisitor(@NotNull Set<Class<?>> set) {
        this.classes = (Class[]) set.toArray(EMPTY_CLASSES);
        HashSet<Class<?>> hashSet = new HashSet<>();
        this.included = hashSet;
        hashSet.addAll(set);
        for (Class<?> cls : set) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(cls);
            this.subClassMap.put(cls, arrayList);
        }
        this.excluded = new HashSet<>();
        this.nodes = new ClassificationBag<>(NODE_CLASSIFIER);
    }

    private void visit(@NotNull Node node) {
        Class<?> cls = node.getClass();
        if (this.included.contains(cls)) {
            this.nodes.add(node);
        } else if (!this.excluded.contains(cls)) {
            for (Class<?> cls2 : this.classes) {
                if (cls2.isInstance(node)) {
                    this.included.add(cls);
                    List<Class<?>> list = this.subClassMap.get(cls2);
                    if (list == null) {
                        ArrayList arrayList = new ArrayList(2);
                        arrayList.add(cls2);
                        arrayList.add(cls);
                        this.subClassMap.put(cls2, arrayList);
                    } else {
                        list.add(cls);
                    }
                    this.nodes.add(node);
                    visitChildren(node);
                    return;
                }
            }
            this.excluded.add(cls);
        }
        visitChildren(node);
    }

    private void visitChildren(@NotNull Node node) {
        Node firstChild = node.getFirstChild();
        while (firstChild != null) {
            Node next = firstChild.getNext();
            visit(firstChild);
            firstChild = next;
        }
    }

    public void collect(@NotNull Node node) {
        visit(node);
    }

    public SubClassingBag<Node> getSubClassingBag() {
        return new SubClassingBag<>(this.nodes, this.subClassMap);
    }
}
