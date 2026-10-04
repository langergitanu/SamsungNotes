package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.util.ast.BlockNodeVisitor;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeVisitor;
import com.vladsch.flexmark.util.ast.VisitHandler;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HeadingCollectingVisitor {
    private final ArrayList<Heading> headings;
    private final NodeVisitor myVisitor;

    public HeadingCollectingVisitor() {
        ArrayList<Heading> arrayList = new ArrayList<>();
        this.headings = arrayList;
        this.myVisitor = new BlockNodeVisitor(new VisitHandler(Heading.class, new C11779b(arrayList, 2)));
    }

    public void collect(Node node) {
        this.myVisitor.visit(node);
    }

    public ArrayList<Heading> collectAndGetHeadings(Node node) {
        this.myVisitor.visit(node);
        return this.headings;
    }

    public ArrayList<Heading> getHeadings() {
        return this.headings;
    }
}
