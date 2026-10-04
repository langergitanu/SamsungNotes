package org.jsoup.nodes;

import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DocumentType extends Node {
    private static final String NAME = "name";
    private static final String PUBLIC_ID = "publicId";
    private static final String SYSTEM_ID = "systemId";

    public DocumentType(String str, String str2, String str3, String str4) {
        super(str4);
        attr("name", str);
        attr(PUBLIC_ID, str2);
        attr(SYSTEM_ID, str3);
    }

    private boolean has(String str) {
        return !StringUtil.isBlank(attr(str));
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#doctype";
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlHead(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
        if (outputSettings.syntax() != Document.OutputSettings.Syntax.html || has(PUBLIC_ID) || has(SYSTEM_ID)) {
            sb.append("<!DOCTYPE");
        } else {
            sb.append("<!doctype");
        }
        if (has("name")) {
            sb.append(" ");
            sb.append(attr("name"));
        }
        if (has(PUBLIC_ID)) {
            sb.append(" PUBLIC \"");
            sb.append(attr(PUBLIC_ID));
            sb.append('\"');
        }
        if (has(SYSTEM_ID)) {
            sb.append(" \"");
            sb.append(attr(SYSTEM_ID));
            sb.append('\"');
        }
        sb.append('>');
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlTail(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
    }
}
