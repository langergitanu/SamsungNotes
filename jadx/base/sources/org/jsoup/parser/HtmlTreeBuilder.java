package org.jsoup.parser;

import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.scsp.common.Header;
import io.netty.handler.ssl.ApplicationProtocolNames;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Token;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class HtmlTreeBuilder extends TreeBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Element contextElement;
    private FormElement formElement;
    private Element headElement;
    private HtmlTreeBuilderState originalState;
    private HtmlTreeBuilderState state;
    private static final String[] TagsScriptStyle = {StringLookupFactory.KEY_SCRIPT, "style"};
    public static final String[] TagsSearchInScope = {"applet", "caption", "html", "table", "td", "th", "marquee", CoeditServiceConstants.Element.NAME_OBJECT};
    private static final String[] TagSearchList = {"ol", "ul"};
    private static final String[] TagSearchButton = {MarketingConstants.BUTTON};
    private static final String[] TagSearchTableScope = {"html", "table"};
    private static final String[] TagSearchSelectScope = {"optgroup", "option"};
    private static final String[] TagSearchEndTags = {"dd", "dt", "li", "option", "optgroup", "p", "rp", "rt"};
    private static final String[] TagSearchSpecial = {"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", Header.f8126BR, MarketingConstants.BUTTON, "caption", "center", "col", "colgroup", Contract.COMMAND, "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", TypedValues.Attributes.S_FRAME, "frameset", "h1", ApplicationProtocolNames.HTTP_2, "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", ExternalSettingsProvider.EXTRA_MENU, "meta", "nav", "noembed", "noframes", "noscript", CoeditServiceConstants.Element.NAME_OBJECT, "ol", "p", "param", "plaintext", "pre", StringLookupFactory.KEY_SCRIPT, "section", Bixby2Constants.BIXBY_PARAM_SELECT, "style", DBSchema.DocumentCover.SUMMARY, "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};
    private boolean baseUriSetFromDoc = false;
    private ArrayList<Element> formattingElements = new ArrayList<>();
    private List<String> pendingTableCharacters = new ArrayList();
    private Token.EndTag emptyEnd = new Token.EndTag();
    private boolean framesetOk = true;
    private boolean fosterInserts = false;
    private boolean fragmentParsing = false;
    private String[] specificScopeTarget = {null};

    private void clearStackToContext(String... strArr) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            if (StringUtil.m14986in(element.nodeName(), strArr) || element.nodeName().equals("html")) {
                return;
            }
            this.stack.remove(size);
        }
    }

    private boolean inSpecificScope(String str, String[] strArr, String[] strArr2) {
        String[] strArr3 = this.specificScopeTarget;
        strArr3[0] = str;
        return inSpecificScope(strArr3, strArr, strArr2);
    }

    private void insertNode(Node node) {
        FormElement formElement;
        if (this.stack.size() == 0) {
            this.doc.appendChild(node);
        } else if (isFosterInserts()) {
            insertInFosterParent(node);
        } else {
            currentElement().appendChild(node);
        }
        if (node instanceof Element) {
            Element element = (Element) node;
            if (!element.tag().isFormListed() || (formElement = this.formElement) == null) {
                return;
            }
            formElement.addElement(element);
        }
    }

    private boolean isElementInQueue(ArrayList<Element> arrayList, Element element) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == element) {
                return true;
            }
        }
        return false;
    }

    private boolean isSameFormattingElement(Element element, Element element2) {
        return element.nodeName().equals(element2.nodeName()) && element.attributes().equals(element2.attributes());
    }

    private void replaceInQueue(ArrayList<Element> arrayList, Element element, Element element2) {
        int iLastIndexOf = arrayList.lastIndexOf(element);
        Validate.isTrue(iLastIndexOf != -1);
        arrayList.set(iLastIndexOf, element2);
    }

    public Element aboveOnStack(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (this.stack.get(size) == element) {
                return this.stack.get(size - 1);
            }
        }
        return null;
    }

    public void clearFormattingElementsToLastMarker() {
        while (!this.formattingElements.isEmpty() && removeLastFormattingElement() != null) {
        }
    }

    public void clearStackToTableBodyContext() {
        clearStackToContext("tbody", "tfoot", "thead");
    }

    public void clearStackToTableContext() {
        clearStackToContext("table");
    }

    public void clearStackToTableRowContext() {
        clearStackToContext("tr");
    }

    public void error(HtmlTreeBuilderState htmlTreeBuilderState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpected token [%s] when in state [%s]", this.currentToken.tokenType(), htmlTreeBuilderState));
        }
    }

    public void framesetOk(boolean z) {
        this.framesetOk = z;
    }

    public void generateImpliedEndTags(String str) {
        while (str != null && !currentElement().nodeName().equals(str) && StringUtil.m14986in(currentElement().nodeName(), TagSearchEndTags)) {
            pop();
        }
    }

    public Element getActiveFormattingElement(String str) {
        for (int size = this.formattingElements.size() - 1; size >= 0; size--) {
            Element element = this.formattingElements.get(size);
            if (element == null) {
                return null;
            }
            if (element.nodeName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    public String getBaseUri() {
        return this.baseUri;
    }

    public Document getDocument() {
        return this.doc;
    }

    public FormElement getFormElement() {
        return this.formElement;
    }

    public Element getFromStack(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            if (element.nodeName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    public Element getHeadElement() {
        return this.headElement;
    }

    public List<String> getPendingTableCharacters() {
        return this.pendingTableCharacters;
    }

    public ArrayList<Element> getStack() {
        return this.stack;
    }

    public boolean inButtonScope(String str) {
        return inScope(str, TagSearchButton);
    }

    public boolean inListItemScope(String str) {
        return inScope(str, TagSearchList);
    }

    public boolean inScope(String[] strArr) {
        return inSpecificScope(strArr, TagsSearchInScope, (String[]) null);
    }

    public boolean inSelectScope(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            String strNodeName = this.stack.get(size).nodeName();
            if (strNodeName.equals(str)) {
                return true;
            }
            if (!StringUtil.m14986in(strNodeName, TagSearchSelectScope)) {
                return false;
            }
        }
        Validate.fail("Should not be reachable");
        return false;
    }

    public boolean inTableScope(String str) {
        return inSpecificScope(str, TagSearchTableScope, (String[]) null);
    }

    public Element insert(Token.StartTag startTag) {
        if (!startTag.isSelfClosing()) {
            Element element = new Element(Tag.valueOf(startTag.name()), this.baseUri, startTag.attributes);
            insert(element);
            return element;
        }
        Element elementInsertEmpty = insertEmpty(startTag);
        this.stack.add(elementInsertEmpty);
        this.tokeniser.transition(TokeniserState.Data);
        this.tokeniser.emit(this.emptyEnd.reset().name(elementInsertEmpty.tagName()));
        return elementInsertEmpty;
    }

    public Element insertEmpty(Token.StartTag startTag) {
        Tag tagValueOf = Tag.valueOf(startTag.name());
        Element element = new Element(tagValueOf, this.baseUri, startTag.attributes);
        insertNode(element);
        if (startTag.isSelfClosing()) {
            if (!tagValueOf.isKnownTag()) {
                tagValueOf.setSelfClosing();
                this.tokeniser.acknowledgeSelfClosingFlag();
            } else if (tagValueOf.isSelfClosing()) {
                this.tokeniser.acknowledgeSelfClosingFlag();
                return element;
            }
        }
        return element;
    }

    public FormElement insertForm(Token.StartTag startTag, boolean z) {
        FormElement formElement = new FormElement(Tag.valueOf(startTag.name()), this.baseUri, startTag.attributes);
        setFormElement(formElement);
        insertNode(formElement);
        if (z) {
            this.stack.add(formElement);
        }
        return formElement;
    }

    public void insertInFosterParent(Node node) {
        Element elementAboveOnStack;
        Element fromStack = getFromStack("table");
        boolean z = false;
        if (fromStack == null) {
            elementAboveOnStack = this.stack.get(0);
        } else if (fromStack.parent() != null) {
            elementAboveOnStack = fromStack.parent();
            z = true;
        } else {
            elementAboveOnStack = aboveOnStack(fromStack);
        }
        if (!z) {
            elementAboveOnStack.appendChild(node);
        } else {
            Validate.notNull(fromStack);
            fromStack.before(node);
        }
    }

    public void insertMarkerToFormattingElements() {
        this.formattingElements.add(null);
    }

    public void insertOnStackAfter(Element element, Element element2) {
        int iLastIndexOf = this.stack.lastIndexOf(element);
        Validate.isTrue(iLastIndexOf != -1);
        this.stack.add(iLastIndexOf + 1, element2);
    }

    public Element insertStartTag(String str) {
        Element element = new Element(Tag.valueOf(str), this.baseUri);
        insert(element);
        return element;
    }

    public boolean isFosterInserts() {
        return this.fosterInserts;
    }

    public boolean isFragmentParsing() {
        return this.fragmentParsing;
    }

    public boolean isInActiveFormattingElements(Element element) {
        return isElementInQueue(this.formattingElements, element);
    }

    public boolean isSpecial(Element element) {
        return StringUtil.m14986in(element.nodeName(), TagSearchSpecial);
    }

    public Element lastFormattingElement() {
        if (this.formattingElements.size() > 0) {
            return (Element) AbstractC1974b.m1313f(1, this.formattingElements);
        }
        return null;
    }

    public void markInsertionMode() {
        this.originalState = this.state;
    }

    public void maybeSetBaseUri(Element element) {
        if (this.baseUriSetFromDoc) {
            return;
        }
        String strAbsUrl = element.absUrl("href");
        if (strAbsUrl.length() != 0) {
            this.baseUri = strAbsUrl;
            this.baseUriSetFromDoc = true;
            this.doc.setBaseUri(strAbsUrl);
        }
    }

    public void newPendingTableCharacters() {
        this.pendingTableCharacters = new ArrayList();
    }

    public boolean onStack(Element element) {
        return isElementInQueue(this.stack, element);
    }

    public HtmlTreeBuilderState originalState() {
        return this.originalState;
    }

    @Override // org.jsoup.parser.TreeBuilder
    public Document parse(String str, String str2, ParseErrorList parseErrorList) {
        this.state = HtmlTreeBuilderState.Initial;
        this.baseUriSetFromDoc = false;
        return super.parse(str, str2, parseErrorList);
    }

    public List<Node> parseFragment(String str, Element element, String str2, ParseErrorList parseErrorList) {
        Element element2;
        this.state = HtmlTreeBuilderState.Initial;
        initialiseParse(str, str2, parseErrorList);
        this.contextElement = element;
        this.fragmentParsing = true;
        if (element != null) {
            if (element.ownerDocument() != null) {
                this.doc.quirksMode(element.ownerDocument().quirksMode());
            }
            String strTagName = element.tagName();
            if (StringUtil.m14986in(strTagName, "title", "textarea")) {
                this.tokeniser.transition(TokeniserState.Rcdata);
            } else if (StringUtil.m14986in(strTagName, "iframe", "noembed", "noframes", "style", "xmp")) {
                this.tokeniser.transition(TokeniserState.Rawtext);
            } else if (strTagName.equals(StringLookupFactory.KEY_SCRIPT)) {
                this.tokeniser.transition(TokeniserState.ScriptData);
            } else if (!strTagName.equals("noscript") && strTagName.equals("plaintext")) {
                this.tokeniser.transition(TokeniserState.Data);
            } else {
                this.tokeniser.transition(TokeniserState.Data);
            }
            element2 = new Element(Tag.valueOf("html"), str2);
            this.doc.appendChild(element2);
            this.stack.add(element2);
            resetInsertionMode();
            Elements elementsParents = element.parents();
            elementsParents.add(0, element);
            Iterator<Element> it = elementsParents.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Element next = it.next();
                if (next instanceof FormElement) {
                    this.formElement = (FormElement) next;
                    break;
                }
            }
        } else {
            element2 = null;
        }
        runParser();
        return (element == null || element2 == null) ? this.doc.childNodes() : element2.childNodes();
    }

    public Element pop() {
        return this.stack.remove(this.stack.size() - 1);
    }

    public void popStackToBefore(String str) {
        for (int size = this.stack.size() - 1; size >= 0 && !this.stack.get(size).nodeName().equals(str); size--) {
            this.stack.remove(size);
        }
    }

    public void popStackToClose(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            this.stack.remove(size);
            if (element.nodeName().equals(str)) {
                return;
            }
        }
    }

    @Override // org.jsoup.parser.TreeBuilder
    public boolean process(Token token) {
        this.currentToken = token;
        return this.state.process(token, this);
    }

    @Override // org.jsoup.parser.TreeBuilder
    public /* bridge */ /* synthetic */ boolean processStartTag(String str, Attributes attributes) {
        return super.processStartTag(str, attributes);
    }

    public void push(Element element) {
        this.stack.add(element);
    }

    public void pushActiveFormattingElements(Element element) {
        int size = this.formattingElements.size() - 1;
        int i = 0;
        while (true) {
            if (size >= 0) {
                Element element2 = this.formattingElements.get(size);
                if (element2 == null) {
                    break;
                }
                if (isSameFormattingElement(element, element2)) {
                    i++;
                }
                if (i == 3) {
                    this.formattingElements.remove(size);
                    break;
                }
                size--;
            } else {
                break;
            }
        }
        this.formattingElements.add(element);
    }

    public void reconstructFormattingElements() {
        Element elementLastFormattingElement = lastFormattingElement();
        if (elementLastFormattingElement == null || onStack(elementLastFormattingElement)) {
            return;
        }
        boolean z = true;
        int size = this.formattingElements.size() - 1;
        int i = size;
        while (i != 0) {
            i--;
            elementLastFormattingElement = this.formattingElements.get(i);
            if (elementLastFormattingElement == null || onStack(elementLastFormattingElement)) {
                z = false;
                break;
            }
        }
        while (true) {
            if (!z) {
                i++;
                elementLastFormattingElement = this.formattingElements.get(i);
            }
            Validate.notNull(elementLastFormattingElement);
            Element elementInsertStartTag = insertStartTag(elementLastFormattingElement.nodeName());
            elementInsertStartTag.attributes().addAll(elementLastFormattingElement.attributes());
            this.formattingElements.set(i, elementInsertStartTag);
            if (i == size) {
                return;
            } else {
                z = false;
            }
        }
    }

    public void removeFromActiveFormattingElements(Element element) {
        for (int size = this.formattingElements.size() - 1; size >= 0; size--) {
            if (this.formattingElements.get(size) == element) {
                this.formattingElements.remove(size);
                return;
            }
        }
    }

    public boolean removeFromStack(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (this.stack.get(size) == element) {
                this.stack.remove(size);
                return true;
            }
        }
        return false;
    }

    public Element removeLastFormattingElement() {
        int size = this.formattingElements.size();
        if (size > 0) {
            return this.formattingElements.remove(size - 1);
        }
        return null;
    }

    public void replaceActiveFormattingElement(Element element, Element element2) {
        replaceInQueue(this.formattingElements, element, element2);
    }

    public void replaceOnStack(Element element, Element element2) {
        replaceInQueue(this.stack, element, element2);
    }

    public void resetInsertionMode() {
        boolean z = false;
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            if (size == 0) {
                element = this.contextElement;
                z = true;
            }
            String strNodeName = element.nodeName();
            if (Bixby2Constants.BIXBY_PARAM_SELECT.equals(strNodeName)) {
                transition(HtmlTreeBuilderState.InSelect);
                return;
            }
            if ("td".equals(strNodeName) || ("th".equals(strNodeName) && !z)) {
                transition(HtmlTreeBuilderState.InCell);
                return;
            }
            if ("tr".equals(strNodeName)) {
                transition(HtmlTreeBuilderState.InRow);
                return;
            }
            if ("tbody".equals(strNodeName) || "thead".equals(strNodeName) || "tfoot".equals(strNodeName)) {
                transition(HtmlTreeBuilderState.InTableBody);
                return;
            }
            if ("caption".equals(strNodeName)) {
                transition(HtmlTreeBuilderState.InCaption);
                return;
            }
            if ("colgroup".equals(strNodeName)) {
                transition(HtmlTreeBuilderState.InColumnGroup);
                return;
            }
            if ("table".equals(strNodeName)) {
                transition(HtmlTreeBuilderState.InTable);
                return;
            }
            if ("head".equals(strNodeName)) {
                transition(HtmlTreeBuilderState.InBody);
                return;
            }
            if ("body".equals(strNodeName)) {
                transition(HtmlTreeBuilderState.InBody);
                return;
            }
            if ("frameset".equals(strNodeName)) {
                transition(HtmlTreeBuilderState.InFrameset);
                return;
            } else if ("html".equals(strNodeName)) {
                transition(HtmlTreeBuilderState.BeforeHead);
                return;
            } else {
                if (z) {
                    transition(HtmlTreeBuilderState.InBody);
                    return;
                }
            }
        }
    }

    public void setFormElement(FormElement formElement) {
        this.formElement = formElement;
    }

    public void setFosterInserts(boolean z) {
        this.fosterInserts = z;
    }

    public void setHeadElement(Element element) {
        this.headElement = element;
    }

    public void setPendingTableCharacters(List<String> list) {
        this.pendingTableCharacters = list;
    }

    public HtmlTreeBuilderState state() {
        return this.state;
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.currentToken + ", state=" + this.state + ", currentElement=" + currentElement() + '}';
    }

    public void transition(HtmlTreeBuilderState htmlTreeBuilderState) {
        this.state = htmlTreeBuilderState;
    }

    public boolean framesetOk() {
        return this.framesetOk;
    }

    public boolean inScope(String str) {
        return inScope(str, null);
    }

    private boolean inSpecificScope(String[] strArr, String[] strArr2, String[] strArr3) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            String strNodeName = this.stack.get(size).nodeName();
            if (StringUtil.m14986in(strNodeName, strArr)) {
                return true;
            }
            if (StringUtil.m14986in(strNodeName, strArr2)) {
                return false;
            }
            if (strArr3 != null && StringUtil.m14986in(strNodeName, strArr3)) {
                return false;
            }
        }
        Validate.fail("Should not be reachable");
        return false;
    }

    public boolean inScope(String str, String[] strArr) {
        return inSpecificScope(str, TagsSearchInScope, strArr);
    }

    public boolean process(Token token, HtmlTreeBuilderState htmlTreeBuilderState) {
        this.currentToken = token;
        return htmlTreeBuilderState.process(token, this);
    }

    public void generateImpliedEndTags() {
        generateImpliedEndTags(null);
    }

    public void popStackToClose(String... strArr) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            this.stack.remove(size);
            if (StringUtil.m14986in(element.nodeName(), strArr)) {
                return;
            }
        }
    }

    public void insert(Element element) {
        insertNode(element);
        this.stack.add(element);
    }

    public void insert(Token.Comment comment) {
        insertNode(new Comment(comment.getData(), this.baseUri));
    }

    public void insert(Token.Character character) {
        Node dataNode;
        String strTagName = currentElement().tagName();
        if (!strTagName.equals(StringLookupFactory.KEY_SCRIPT) && !strTagName.equals("style")) {
            dataNode = new TextNode(character.getData(), this.baseUri);
        } else {
            dataNode = new DataNode(character.getData(), this.baseUri);
        }
        currentElement().appendChild(dataNode);
    }
}
