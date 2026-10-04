package opennlp.tools.formats.frenchtreebank;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import opennlp.tools.parser.AbstractBottomUpParser;
import opennlp.tools.parser.Constituent;
import opennlp.tools.parser.Parse;
import opennlp.tools.util.Span;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class ConstitDocumentHandler extends DefaultHandler {
    private static final String SENT_ELEMENT_NAME = "SENT";
    private static final String SENT_TYPE_NAME = "S";
    private static final String WORD_ELEMENT_NAME = "w";
    private String cat;
    private boolean insideSentenceElement;
    private int offset;
    private final List<Parse> parses;
    private String subcat;
    private final StringBuilder tokenBuffer = new StringBuilder();
    private final StringBuilder text = new StringBuilder();
    private final Stack<Constituent> stack = new Stack<>();
    private final List<Constituent> cons = new LinkedList();

    public ConstitDocumentHandler(List<Parse> list) {
        this.parses = list;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        this.tokenBuffer.append(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        boolean z;
        int start;
        if (this.insideSentenceElement) {
            if (WORD_ELEMENT_NAME.equals(str3)) {
                String strTrim = this.tokenBuffer.toString().trim();
                if (strTrim.length() > 0) {
                    List<Constituent> list = this.cons;
                    int i = this.offset;
                    list.add(new Constituent(AbstractBottomUpParser.TOK_NODE, new Span(i, strTrim.length() + i)));
                    StringBuilder sb = this.text;
                    sb.append(strTrim);
                    sb.append(" ");
                    this.offset = AbstractC2821a.m2212c(1, this.offset, strTrim);
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = true;
            }
            Constituent constituentPop = this.stack.pop();
            if (z && (start = constituentPop.getSpan().getStart()) < this.offset) {
                this.cons.add(new Constituent(constituentPop.getLabel(), new Span(start, this.offset - 1)));
            }
            if ("SENT".equals(str3)) {
                String string = this.text.toString();
                Parse parse = new Parse(string, new Span(0, string.length()), AbstractBottomUpParser.TOP_NODE, 1.0d, 0);
                int i2 = -1;
                for (Constituent constituent : this.cons) {
                    String label = constituent.getLabel();
                    if (!label.equals(AbstractBottomUpParser.TOP_NODE)) {
                        if (AbstractBottomUpParser.TOK_NODE.equals(label)) {
                            i2++;
                        }
                        int i4 = i2;
                        parse.insert(new Parse(string, constituent.getSpan(), label, 1.0d, i4));
                        i2 = i4;
                    }
                }
                this.parses.add(parse);
                this.insideSentenceElement = false;
            }
            this.tokenBuffer.setLength(0);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if ("SENT".equals(str3)) {
            this.text.setLength(0);
            this.offset = 0;
            this.stack.clear();
            this.cons.clear();
            this.insideSentenceElement = true;
            str3 = "S";
        } else if (WORD_ELEMENT_NAME.equals(str3)) {
            String value = attributes.getValue("cat");
            if (value != null && value.length() > 0) {
                this.cat = value;
            }
            String value2 = attributes.getValue("subcat");
            if (value2 != null && value2.length() > 0) {
                this.subcat = value2;
            }
            String str4 = this.cat;
            if (str4 != null) {
                String str5 = this.subcat;
                if (str5 == null) {
                    str5 = "";
                }
                str3 = AbstractC0541b.m756B(str4, str5);
            } else {
                String value3 = attributes.getValue("catint");
                str3 = value3 != null ? AbstractC0541b.m756B(this.cat, value3) : AbstractC0541b.m756B(this.cat, this.subcat);
            }
        }
        Stack<Constituent> stack = this.stack;
        int i = this.offset;
        stack.push(new Constituent(str3, new Span(i, i)));
        this.tokenBuffer.setLength(0);
    }
}
