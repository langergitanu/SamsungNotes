package org.jsoup.nodes;

import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Comment extends Node {
    private static final String COMMENT_KEY = "comment";

    public Comment(String str, String str2) {
        super(str2);
        this.attributes.put("comment", str);
    }

    public String getData() {
        return this.attributes.get("comment");
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#comment";
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlHead(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
        if (outputSettings.prettyPrint()) {
            indent(sb, i, outputSettings);
        }
        sb.append("<!--");
        sb.append(getData());
        sb.append("-->");
    }

    @Override // org.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlTail(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
    }
}
