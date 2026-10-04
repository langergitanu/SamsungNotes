package org.jsoup.examples;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import com.samsung.scsp.common.Header;
import io.netty.handler.ssl.ApplicationProtocolNames;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class HtmlToPlainText {
    private static final int timeout = 5000;
    private static final String userAgent = "Mozilla/5.0 (jsoup)";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class FormattingVisitor implements NodeVisitor {
        private static final int maxWidth = 80;
        private StringBuilder accum;
        private int width;

        private FormattingVisitor() {
            this.width = 0;
            this.accum = new StringBuilder();
        }

        private void append(String str) {
            if (str.startsWith("\n")) {
                this.width = 0;
            }
            if (str.equals(" ")) {
                if (this.accum.length() == 0) {
                    return;
                }
                if (StringUtil.m14986in(this.accum.substring(r3.length() - 1), " ", "\n")) {
                    return;
                }
            }
            if (str.length() + this.width <= 80) {
                this.accum.append(str);
                this.width = str.length() + this.width;
                return;
            }
            String[] strArrSplit = str.split("\\s+");
            for (int i = 0; i < strArrSplit.length; i++) {
                String strM756B = strArrSplit[i];
                if (i != strArrSplit.length - 1) {
                    strM756B = AbstractC0541b.m756B(strM756B, " ");
                }
                if (strM756B.length() + this.width > 80) {
                    StringBuilder sb = this.accum;
                    sb.append("\n");
                    sb.append(strM756B);
                    this.width = strM756B.length();
                } else {
                    this.accum.append(strM756B);
                    this.width = strM756B.length() + this.width;
                }
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            String strNodeName = node.nodeName();
            if (node instanceof TextNode) {
                append(((TextNode) node).text());
                return;
            }
            if (strNodeName.equals("li")) {
                append("\n * ");
            } else if (strNodeName.equals("dt")) {
                append(Constant.WHITE_SPACE_FOR_LINK_ICON);
            } else if (StringUtil.m14986in(strNodeName, "p", "h1", ApplicationProtocolNames.HTTP_2, "h3", "h4", "h5", "tr")) {
                append("\n");
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
            String strNodeName = node.nodeName();
            if (StringUtil.m14986in(strNodeName, Header.f8126BR, "dd", "dt", "p", "h1", ApplicationProtocolNames.HTTP_2, "h3", "h4", "h5")) {
                append("\n");
            } else if (strNodeName.equals("a")) {
                append(AbstractC0541b.m773o(" <", node.absUrl("href"), ">"));
            }
        }

        public String toString() {
            return this.accum.toString();
        }
    }

    public static void main(String... strArr) {
        Validate.isTrue(strArr.length == 1 || strArr.length == 2, "usage: java -cp jsoup.jar org.jsoup.examples.HtmlToPlainText url [selector]");
        String str = strArr[0];
        String str2 = strArr.length == 2 ? strArr[1] : null;
        Document document = Jsoup.connect(str).userAgent(userAgent).timeout(5000).get();
        HtmlToPlainText htmlToPlainText = new HtmlToPlainText();
        if (str2 == null) {
            System.out.println(htmlToPlainText.getPlainText(document));
            return;
        }
        Iterator<Element> it = document.select(str2).iterator();
        while (it.hasNext()) {
            System.out.println(htmlToPlainText.getPlainText(it.next()));
        }
    }

    public String getPlainText(Element element) {
        FormattingVisitor formattingVisitor = new FormattingVisitor();
        new NodeTraversor(formattingVisitor).traverse(element);
        return formattingVisitor.toString();
    }
}
