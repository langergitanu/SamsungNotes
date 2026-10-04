package opennlp.tools.formats.p216ad;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import opennlp.tools.commons.Internal;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ADSentenceStream extends FilterObjectStream<String, Sentence> {
    private boolean isBox;
    private boolean isTitle;
    private int paraID;
    private final SentenceParser parser;
    private static final Pattern SENT_START = Pattern.compile("<s[^>]*>");
    private static final Pattern SENT_END = Pattern.compile("</s>");
    private static final Pattern EXT_END = Pattern.compile("</ext>");
    private static final Pattern TITLE_START = Pattern.compile("<t[^>]*>");
    private static final Pattern TITLE_END = Pattern.compile("</t>");
    private static final Pattern BOX_START = Pattern.compile("<caixa[^>]*>");
    private static final Pattern BOX_END = Pattern.compile("</caixa>");
    private static final Pattern PARA_START = Pattern.compile("<p[^>]*>");
    private static final Pattern TEXT_START = Pattern.compile("<ext[^>]*>");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Sentence {
        public static final String META_LABEL_FINAL = "final";
        private String metadata;
        private SentenceParser.Node root;
        private String text;

        public String getMetadata() {
            return this.metadata;
        }

        public SentenceParser.Node getRoot() {
            return this.root;
        }

        public String getText() {
            return this.text;
        }

        public void setMetadata(String str) {
            this.metadata = str;
        }

        public void setRoot(SentenceParser.Node node) {
            this.root = node;
        }

        public void setText(String str) {
            this.text = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SentenceParser {
        private String meta;
        private String text;
        private static final Logger logger = LoggerFactory.getLogger((Class<?>) SentenceParser.class);
        private static final Pattern NODE_PATTERN = Pattern.compile("([=-]*)([^:=]+:[^\\(\\s]+)(\\(([^\\)]+)\\))?\\s*(?:(\\((<.+>)\\))*)\\s*$");
        private static final Pattern LEAF_PATTERN = Pattern.compile("^([=-]*)([^:=]+):([^\\(\\s]+)\\([\"'](.+)[\"']\\s*((?:<.+>)*)\\s*([^\\)]+)?\\)\\s+(.+)");
        private static final Pattern BIZARRE_LEAF_PATTERN = Pattern.compile("^([=-]*)([^:=]+=[^\\(\\s]+)\\(([\"'].+[\"'])?\\s*([^\\)]+)?\\)\\s+(.+)");
        private static final Pattern PUNCTUATION_PATTERN = Pattern.compile("^(=*)(\\W+)$");
        private static final Pattern PUNCTUATION_DOT_PATTERN = Pattern.compile("\\»\\s+\\.");
        private static final Pattern PUNCTUATION_COMMA_PATTERN = Pattern.compile("\\»\\s+\\,");

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Leaf extends TreeElement {
            private String functionalTag;
            private String lemma;
            private String secondaryTag;
            private String word;

            private String emptyOrString(String str, String str2, String str3) {
                return str == null ? "" : AbstractC0541b.m757C(str2, str, str3);
            }

            public String getFunctionalTag() {
                return this.functionalTag;
            }

            public String getLemma() {
                return this.lemma;
            }

            public String getLexeme() {
                return this.word;
            }

            public String getSecondaryTag() {
                return this.secondaryTag;
            }

            @Override // opennlp.tools.formats.ad.ADSentenceStream.SentenceParser.TreeElement
            public boolean isLeaf() {
                return true;
            }

            public void setFunctionalTag(String str) {
                this.functionalTag = str;
            }

            public void setLemma(String str) {
                this.lemma = str;
            }

            public void setLexeme(String str) {
                this.word = str;
            }

            public void setSecondaryTag(String str) {
                this.secondaryTag = str;
            }

            public String toString() {
                String string;
                StringBuilder sb = new StringBuilder();
                int iMax = Math.max(0, getLevel());
                if (iMax < 0) {
                    throw new IllegalArgumentException(AbstractC0000a.m11h(iMax, "count is negative: "));
                }
                if (iMax != 0) {
                    string = MarketingConstants.REFERRER_DELIMITER_U003D;
                    if (iMax != 1) {
                        if (1 > Integer.MAX_VALUE / iMax) {
                            throw new OutOfMemoryError(AbstractC0541b.m767i(iMax, "Repeating 1 bytes String ", " times will produce a String exceeding maximum size."));
                        }
                        StringBuilder sb2 = new StringBuilder(iMax);
                        for (int i = 0; i < iMax; i++) {
                            sb2.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                        }
                        string = sb2.toString();
                    }
                } else {
                    string = "";
                }
                sb.append(string);
                if (getSyntacticTag() != null) {
                    sb.append(getSyntacticTag());
                    sb.append(":");
                    sb.append(getFunctionalTag());
                    sb.append("(");
                    sb.append(emptyOrString(getLemma(), "'", "' "));
                    sb.append(emptyOrString(getSecondaryTag(), "", " "));
                    sb.append(getMorphologicalTag());
                    sb.append(") ");
                }
                return AbstractC0622a.m1170p(this.word, "\n", sb);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Node extends TreeElement {
            private final List<TreeElement> elems = new ArrayList();

            public void addElement(TreeElement treeElement) {
                this.elems.add(treeElement);
            }

            public TreeElement[] getElements() {
                return (TreeElement[]) this.elems.toArray(new TreeElement[0]);
            }

            public String toString() {
                String string;
                StringBuilder sb = new StringBuilder();
                int iMax = Math.max(0, getLevel());
                if (iMax < 0) {
                    throw new IllegalArgumentException(AbstractC0000a.m11h(iMax, "count is negative: "));
                }
                if (iMax != 0) {
                    string = MarketingConstants.REFERRER_DELIMITER_U003D;
                    if (iMax != 1) {
                        if (1 > Integer.MAX_VALUE / iMax) {
                            throw new OutOfMemoryError(AbstractC0541b.m767i(iMax, "Repeating 1 bytes String ", " times will produce a String exceeding maximum size."));
                        }
                        StringBuilder sb2 = new StringBuilder(iMax);
                        for (int i = 0; i < iMax; i++) {
                            sb2.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                        }
                        string = sb2.toString();
                    }
                } else {
                    string = "";
                }
                sb.append(string);
                sb.append(getSyntacticTag());
                if (getMorphologicalTag() != null) {
                    sb.append(getMorphologicalTag());
                }
                sb.append("\n");
                Iterator<TreeElement> it = this.elems.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().toString());
                }
                return sb.toString();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static abstract class TreeElement {
            private int level;
            private String morphologicalTag;
            private String syntacticTag;

            public int getLevel() {
                return this.level;
            }

            public String getMorphologicalTag() {
                return this.morphologicalTag;
            }

            public String getSyntacticTag() {
                return this.syntacticTag;
            }

            public boolean isLeaf() {
                return false;
            }

            public void setLevel(int i) {
                this.level = i;
            }

            public void setMorphologicalTag(String str) {
                this.morphologicalTag = str;
            }

            public void setSyntacticTag(String str) {
                this.syntacticTag = str;
            }
        }

        private String fixPunctuation(String str) {
            return PUNCTUATION_COMMA_PATTERN.matcher(PUNCTUATION_DOT_PATTERN.matcher(str).replaceAll("».")).replaceAll("»,");
        }

        public TreeElement getElement(String str) {
            Matcher matcher = NODE_PATTERN.matcher(str);
            if (matcher.matches()) {
                int length = matcher.group(1).length() + 1;
                String strGroup = matcher.group(2);
                Node node = new Node();
                node.setLevel(length);
                node.setSyntacticTag(strGroup);
                return node;
            }
            Matcher matcher2 = LEAF_PATTERN.matcher(str);
            if (matcher2.matches()) {
                int length2 = matcher2.group(1).length() + 1;
                String strGroup2 = matcher2.group(2);
                String strGroup3 = matcher2.group(3);
                String strGroup4 = matcher2.group(4);
                String strGroup5 = matcher2.group(5);
                String strGroup6 = matcher2.group(6);
                String strGroup7 = matcher2.group(7);
                Leaf leaf = new Leaf();
                leaf.setLevel(length2);
                leaf.setSyntacticTag(strGroup2);
                leaf.setFunctionalTag(strGroup3);
                leaf.setSecondaryTag(strGroup5);
                leaf.setMorphologicalTag(strGroup6);
                leaf.setLexeme(strGroup7);
                leaf.setLemma(strGroup4);
                return leaf;
            }
            Matcher matcher3 = PUNCTUATION_PATTERN.matcher(str);
            if (matcher3.matches()) {
                int length3 = matcher3.group(1).length() + 1;
                String strGroup8 = matcher3.group(2);
                Leaf leaf2 = new Leaf();
                leaf2.setLevel(length3);
                leaf2.setLexeme(strGroup8);
                return leaf2;
            }
            if (str.equals("_") || str.startsWith("<lixo") || str.startsWith("pause")) {
                return null;
            }
            if (!str.startsWith(MarketingConstants.REFERRER_DELIMITER_U003D)) {
                logger.warn("Couldn't parse leaf: {}", str);
                Leaf leaf3 = new Leaf();
                leaf3.setLevel(1);
                leaf3.setSyntacticTag("");
                leaf3.setMorphologicalTag("");
                leaf3.setFunctionalTag("");
                leaf3.setLexeme(str);
                return leaf3;
            }
            Matcher matcher4 = BIZARRE_LEAF_PATTERN.matcher(str);
            if (!matcher4.matches()) {
                int iLastIndexOf = str.lastIndexOf(MarketingConstants.REFERRER_DELIMITER_U003D) + 2;
                String strSubstring = str.substring(iLastIndexOf);
                if (strSubstring.matches("\\w.*?[\\.<>].*")) {
                    return null;
                }
                Leaf leaf4 = new Leaf();
                leaf4.setLevel(iLastIndexOf);
                leaf4.setSyntacticTag("");
                leaf4.setMorphologicalTag("");
                leaf4.setFunctionalTag("");
                leaf4.setLexeme(strSubstring);
                return leaf4;
            }
            int length4 = matcher4.group(1).length() + 1;
            String strGroup9 = matcher4.group(2);
            String strGroup10 = matcher4.group(3);
            String strGroup11 = matcher4.group(4);
            String strGroup12 = matcher4.group(5);
            Leaf leaf5 = new Leaf();
            leaf5.setLevel(length4);
            leaf5.setSyntacticTag(strGroup9);
            leaf5.setMorphologicalTag(strGroup11);
            leaf5.setLexeme(strGroup12);
            if (strGroup10 != null) {
                if (strGroup10.length() > 2) {
                    strGroup10 = AbstractC2322a.m1614d(1, 1, strGroup10);
                }
                leaf5.setLemma(strGroup10);
            }
            return leaf5;
        }

        public Sentence parse(String str, int i, boolean z, boolean z2) {
            Sentence sentence = new Sentence();
            Node node = new Node();
            try {
                BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
                try {
                    String line = bufferedReader.readLine();
                    do {
                        if (line.startsWith("SOURCE")) {
                            String strSubstring = line.substring(7);
                            String line2 = bufferedReader.readLine();
                            int iIndexOf = line2.indexOf(" ");
                            String strTrim = line2.substring(iIndexOf + 1).trim();
                            this.text = strTrim;
                            this.text = fixPunctuation(strTrim);
                            String str2 = z ? " title" : "";
                            String str3 = z2 ? " box" : "";
                            if (iIndexOf > 0) {
                                this.meta = line2.substring(0, iIndexOf) + " p=" + i + str2 + str3 + strSubstring;
                            }
                        } else if (!line.equals("&&")) {
                            line = bufferedReader.readLine();
                        }
                        sentence.setText(this.text);
                        sentence.setMetadata(this.meta);
                        String line3 = bufferedReader.readLine();
                        while (line3 != null && line3.startsWith("###")) {
                            line3 = bufferedReader.readLine();
                        }
                        Stack stack = new Stack();
                        node.setSyntacticTag(Logger.ROOT_LOGGER_NAME);
                        node.setLevel(0);
                        stack.add(node);
                        while (line3 != null) {
                            if (line3.length() == 0 || line3.startsWith("</s>") || line3.equals("&&")) {
                                break;
                            }
                            TreeElement element = getElement(line3);
                            if (element != null) {
                                while (!stack.isEmpty() && element.getLevel() > 0 && element.getLevel() <= ((Node) stack.peek()).getLevel()) {
                                }
                                if (!element.isLeaf()) {
                                    if (stack.isEmpty() || ((Node) stack.peek()).getLevel() >= element.getLevel()) {
                                        logger.warn("should not happen!");
                                    } else {
                                        ((Node) stack.peek()).addElement(element);
                                    }
                                    stack.push((Node) element);
                                } else if (stack.isEmpty()) {
                                    node.addElement(element);
                                } else {
                                    Node node2 = (Node) stack.peek();
                                    if (element.level == 0) {
                                        ((Node) stack.firstElement()).addElement(element);
                                    } else {
                                        int size = stack.size() - 1;
                                        Node node3 = null;
                                        while (node3 == null) {
                                            if (node2.getLevel() < element.getLevel()) {
                                                node3 = node2;
                                            } else {
                                                size--;
                                                if (size > -1) {
                                                    node2 = (Node) stack.get(size);
                                                } else {
                                                    node3 = (Node) stack.firstElement();
                                                }
                                            }
                                        }
                                        node3.addElement(element);
                                    }
                                }
                            }
                            line3 = bufferedReader.readLine();
                        }
                        bufferedReader.close();
                        sentence.setRoot(node);
                        return sentence;
                    } while (line != null);
                    bufferedReader.close();
                    return null;
                } finally {
                }
            } catch (Exception e) {
                logger.warn("Caught exception for the given sentence: '{}'", str, e);
                return sentence;
            }
        }
    }

    public ADSentenceStream(ObjectStream<String> objectStream) {
        super(objectStream);
        this.paraID = 0;
        this.isTitle = false;
        this.isBox = false;
        this.parser = new SentenceParser();
    }

    @Override // opennlp.tools.util.ObjectStream
    public Sentence read() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (true) {
            String str = (String) this.samples.read();
            if (str != null) {
                if (z) {
                    if (SENT_END.matcher(str).matches() || EXT_END.matcher(str).matches()) {
                        z = false;
                    } else if (!str.startsWith("A1")) {
                        sb.append(str);
                        sb.append('\n');
                    }
                } else if (SENT_START.matcher(str).matches()) {
                    z = true;
                } else if (PARA_START.matcher(str).matches()) {
                    this.paraID++;
                } else if (TITLE_START.matcher(str).matches()) {
                    this.isTitle = true;
                } else if (TITLE_END.matcher(str).matches()) {
                    this.isTitle = false;
                } else if (TEXT_START.matcher(str).matches()) {
                    this.paraID = 0;
                } else if (BOX_START.matcher(str).matches()) {
                    this.isBox = true;
                } else if (BOX_END.matcher(str).matches()) {
                    this.isBox = false;
                }
                if (!z && sb.length() > 0) {
                    return this.parser.parse(sb.toString(), this.paraID, this.isTitle, this.isBox);
                }
            } else {
                if (!z) {
                    return null;
                }
                if (sb.length() > 0) {
                    return this.parser.parse(sb.toString(), this.paraID, this.isTitle, this.isBox);
                }
            }
        }
    }
}
