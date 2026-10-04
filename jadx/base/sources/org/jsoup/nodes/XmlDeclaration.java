package org.jsoup.nodes;

import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.client.internal.MsalUtils;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XmlDeclaration extends Node {
    static final String DECL_KEY = "declaration";
    private final boolean isProcessingInstruction;

    public XmlDeclaration(String str, String str2, boolean z) {
        super(str2);
        this.attributes.put(DECL_KEY, str);
        this.isProcessingInstruction = z;
    }

    public String getWholeDeclaration() {
        String str = this.attributes.get(DECL_KEY);
        if (!str.equals("xml") || this.attributes.size() <= 1) {
            return this.attributes.get(DECL_KEY);
        }
        StringBuilder sb = new StringBuilder(str);
        String str2 = this.attributes.get("version");
        if (str2 != null) {
            AbstractC1974b.m1332y(sb, " version=\"", str2, "\"");
        }
        String str3 = this.attributes.get(XMLWriter.ENCODING);
        if (str3 != null) {
            AbstractC1974b.m1332y(sb, " encoding=\"", str3, "\"");
        }
        return sb.toString();
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#declaration";
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlHead(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
        sb.append("<");
        sb.append(this.isProcessingInstruction ? "!" : MsalUtils.QUERY_STRING_SYMBOL);
        sb.append(getWholeDeclaration());
        sb.append(">");
    }

    @Override // org.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlTail(StringBuilder sb, int i, Document.OutputSettings outputSettings) {
    }
}
