package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TextNodeConverter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ArrayList<Node> list = new ArrayList<>();
    private final BasedSequence nodeChars;
    private BasedSequence remainingChars;

    public TextNodeConverter(BasedSequence basedSequence) {
        this.nodeChars = basedSequence;
        this.remainingChars = basedSequence;
    }

    private void mergeList() {
        if (this.remainingChars.isEmpty()) {
            return;
        }
        this.list.add(new Text(this.remainingChars));
        this.remainingChars = BasedSequence.NULL;
    }

    public static void mergeTextNodes(Node node) {
        Node firstChild = node.getFirstChild();
        Node node2 = null;
        while (firstChild != null) {
            Node next = firstChild.getNext();
            if ((node2 instanceof Text) && (firstChild instanceof Text) && node2.getChars().isContinuedBy(firstChild.getChars())) {
                firstChild.setChars(node2.getChars().spliceAtEnd(firstChild.getChars()));
                node2.unlink();
            }
            node2 = firstChild;
            firstChild = next;
        }
    }

    public void addChildrenOf(Node node) {
        Node firstChild = node.getFirstChild();
        while (firstChild != null) {
            Node next = firstChild.getNext();
            appendChild(firstChild);
            firstChild = next;
        }
    }

    public void appendChild(Node node) {
        BasedSequence chars = node.getChars();
        node.unlink();
        if (node instanceof Text) {
            return;
        }
        if (this.remainingChars.getStartOffset() < chars.getStartOffset()) {
            this.list.add(new Text(this.remainingChars.subSequence(0, chars.getStartOffset() - this.remainingChars.getStartOffset())));
        }
        this.remainingChars = this.remainingChars.subSequence(chars.getEndOffset() - this.remainingChars.getStartOffset());
        this.list.add(node);
    }

    public void appendMergedTo(Node node) {
        mergeList();
        Iterator<Node> it = this.list.iterator();
        while (it.hasNext()) {
            node.appendChild(it.next());
        }
        clear();
    }

    public void clear() {
        this.list.clear();
        this.remainingChars = BasedSequence.NULL;
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
}
