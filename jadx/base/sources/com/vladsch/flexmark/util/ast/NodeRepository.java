package com.vladsch.flexmark.util.ast;

import androidx.appcompat.widget.AbstractC0541b;
import com.vladsch.flexmark.ext.gfm.strikethrough.C11785a;
import com.vladsch.flexmark.util.data.DataKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class NodeRepository<T> implements Map<String, T> {
    protected final KeepType keepType;
    protected final ArrayList<T> nodeList = new ArrayList<>();
    protected final Map<String, T> nodeMap = new HashMap();

    public NodeRepository(@Nullable KeepType keepType) {
        this.keepType = keepType == null ? KeepType.LOCKED : keepType;
    }

    public static <T> boolean transferReferences(@NotNull NodeRepository<T> nodeRepository, @NotNull NodeRepository<T> nodeRepository2, boolean z, @Nullable Map<String, String> map) {
        boolean z2 = false;
        for (Map.Entry<String, T> entry : nodeRepository2.entrySet()) {
            String key = entry.getKey();
            if (map != null) {
                map.getOrDefault(key, key);
            }
            if (!z || !nodeRepository.containsKey(key)) {
                nodeRepository.put(key, (Object) entry.getValue());
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.Map
    public void clear() {
        if (this.keepType == KeepType.LOCKED) {
            throw new IllegalStateException("Not allowed to modify LOCKED repository");
        }
        this.nodeMap.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@NotNull Object obj) {
        return this.nodeMap.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.nodeMap.containsValue(obj);
    }

    @Override // java.util.Map
    @NotNull
    public Set<Map.Entry<String, T>> entrySet() {
        return this.nodeMap.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.nodeMap.equals(obj);
    }

    @Override // java.util.Map
    @Nullable
    public T get(@NotNull Object obj) {
        return this.nodeMap.get(obj);
    }

    @NotNull
    public abstract DataKey<? extends NodeRepository<T>> getDataKey();

    @Nullable
    public T getFromRaw(@NotNull CharSequence charSequence) {
        return this.nodeMap.get(normalizeKey(charSequence));
    }

    @NotNull
    public abstract DataKey<KeepType> getKeepDataKey();

    @NotNull
    public abstract Set<T> getReferencedElements(Node node);

    @NotNull
    public Collection<T> getValues() {
        return this.nodeMap.values();
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.nodeMap.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.nodeMap.isEmpty();
    }

    @Override // java.util.Map
    @NotNull
    public Set<String> keySet() {
        return this.nodeMap.keySet();
    }

    @NotNull
    public String normalizeKey(@NotNull CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends String, ? extends T> map) {
        KeepType keepType = this.keepType;
        if (keepType == KeepType.LOCKED) {
            throw new IllegalStateException("Not allowed to modify LOCKED repository");
        }
        if (keepType == KeepType.LAST) {
            this.nodeMap.putAll(map);
            return;
        }
        for (String str : map.keySet()) {
            this.nodeMap.put(str, map.get(str));
        }
    }

    @Nullable
    public T putRawKey(@NotNull CharSequence charSequence, @NotNull T t) {
        return put(normalizeKey(charSequence), (Object) t);
    }

    @Override // java.util.Map
    @Nullable
    public T remove(@NotNull Object obj) {
        if (this.keepType != KeepType.LOCKED) {
            return this.nodeMap.remove(obj);
        }
        throw new IllegalStateException("Not allowed to modify LOCKED repository");
    }

    @Override // java.util.Map
    public int size() {
        return this.nodeMap.size();
    }

    @SafeVarargs
    public final void visitNodes(@NotNull Node node, @NotNull Consumer<Node> consumer, @NotNull Class<? extends Node>... clsArr) {
        NodeVisitor nodeVisitor = new NodeVisitor();
        for (Class<? extends Node> cls : clsArr) {
            Objects.requireNonNull(consumer);
            nodeVisitor.addHandler(new VisitHandler(cls, new C11785a(consumer, 3)));
        }
        nodeVisitor.visit(node);
    }

    @Override // java.util.Map
    @Nullable
    public T put(@NotNull String str, @NotNull T t) {
        T t2;
        this.nodeList.add(t);
        KeepType keepType = this.keepType;
        if (keepType == KeepType.LOCKED) {
            throw new IllegalStateException("Not allowed to modify LOCKED repository");
        }
        if (keepType == KeepType.LAST || (t2 = this.nodeMap.get(str)) == null) {
            return this.nodeMap.put(str, t);
        }
        if (this.keepType != KeepType.FAIL) {
            return t2;
        }
        throw new IllegalStateException(AbstractC0541b.m772n("Duplicate key ", str));
    }

    @Override // java.util.Map
    @NotNull
    public List<T> values() {
        return this.nodeList;
    }
}
