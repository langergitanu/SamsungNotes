package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TextNodeMergingList {
    private ArrayList<Node> list = new ArrayList<>();
    private boolean isMerged = true;

    private void mergeList() {
        if (this.isMerged) {
            return;
        }
        Node node = null;
        ArrayList<Node> arrayList = null;
        for (Node node2 : this.list) {
            if (!(node2 instanceof Text)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                if (node != null) {
                    arrayList.add(node);
                    node = null;
                }
                arrayList.add(node2);
            } else if (!node2.getChars().isEmpty()) {
                if (node != null) {
                    if (node.getChars().isContinuedBy(node2.getChars())) {
                        node.setChars(node.getChars().spliceAtEnd(node2.getChars()));
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        arrayList.add(node);
                    }
                }
                node = node2;
            }
        }
        if (node != null) {
            if (arrayList == null) {
                this.list.clear();
                this.list.add(node);
            } else {
                arrayList.add(node);
            }
        }
        if (arrayList != null) {
            this.list = arrayList;
        }
    }

    public void add(Node node) {
        this.list.add(node);
        if (node instanceof Text) {
            this.isMerged = false;
        }
    }

    public void addChildrenOf(Node node) {
        Node firstChild = node.getFirstChild();
        while (firstChild != null) {
            Node next = firstChild.getNext();
            firstChild.unlink();
            add(firstChild);
            firstChild = next;
        }
    }

    public void appendMergedTo(Node node) {
        mergeList();
        Iterator<Node> it = this.list.iterator();
        while (it.hasNext()) {
            node.appendChild(it.next());
        }
    }

    public void clear() {
        this.list.clear();
        this.isMerged = true;
    }

    public List<Node> getMergedList() {
        mergeList();
        return this.list;
    }

    public void insertMergedAfter(Node node) {
        mergeList();
        for (Node node2 : this.list) {
            node.insertAfter(node2);
            node = node2;
        }
        clear();
    }

    public void insertMergedBefore(Node node) {
        mergeList();
        Iterator<Node> it = this.list.iterator();
        while (it.hasNext()) {
            node.insertBefore(it.next());
        }
        clear();
    }

    public void add(BasedSequence basedSequence) {
        if (basedSequence.isEmpty()) {
            return;
        }
        add(new Text(basedSequence));
    }
}
