package org.apache.commons.collections.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.collections.list.AbstractLinkedList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NodeCachingLinkedList extends AbstractLinkedList implements Serializable {
    protected static final int DEFAULT_MAXIMUM_CACHE_SIZE = 20;
    private static final long serialVersionUID = 6897789178562232073L;
    protected transient int cacheSize;
    protected transient AbstractLinkedList.Node firstCachedNode;
    protected int maximumCacheSize;

    public NodeCachingLinkedList() {
        this(20);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    public void addNodeToCache(AbstractLinkedList.Node node) {
        if (isCacheFull()) {
            return;
        }
        AbstractLinkedList.Node node2 = this.firstCachedNode;
        node.previous = null;
        node.next = node2;
        node.setValue(null);
        this.firstCachedNode = node;
        this.cacheSize++;
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    public AbstractLinkedList.Node createNode(Object obj) {
        AbstractLinkedList.Node nodeFromCache = getNodeFromCache();
        if (nodeFromCache == null) {
            return super.createNode(obj);
        }
        nodeFromCache.setValue(obj);
        return nodeFromCache;
    }

    public int getMaximumCacheSize() {
        return this.maximumCacheSize;
    }

    public AbstractLinkedList.Node getNodeFromCache() {
        int i = this.cacheSize;
        if (i == 0) {
            return null;
        }
        AbstractLinkedList.Node node = this.firstCachedNode;
        this.firstCachedNode = node.next;
        node.next = null;
        this.cacheSize = i - 1;
        return node;
    }

    public boolean isCacheFull() {
        return this.cacheSize >= this.maximumCacheSize;
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    public void removeAllNodes() {
        int iMin = Math.min(this.size, this.maximumCacheSize - this.cacheSize);
        AbstractLinkedList.Node node = this.header.next;
        int i = 0;
        while (i < iMin) {
            AbstractLinkedList.Node node2 = node.next;
            addNodeToCache(node);
            i++;
            node = node2;
        }
        super.removeAllNodes();
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    public void removeNode(AbstractLinkedList.Node node) {
        super.removeNode(node);
        addNodeToCache(node);
    }

    public void setMaximumCacheSize(int i) {
        this.maximumCacheSize = i;
        shrinkCacheToMaximumSize();
    }

    public void shrinkCacheToMaximumSize() {
        while (this.cacheSize > this.maximumCacheSize) {
            getNodeFromCache();
        }
    }

    public NodeCachingLinkedList(Collection collection) {
        super(collection);
        this.maximumCacheSize = 20;
    }

    public NodeCachingLinkedList(int i) {
        this.maximumCacheSize = i;
        init();
    }
}
