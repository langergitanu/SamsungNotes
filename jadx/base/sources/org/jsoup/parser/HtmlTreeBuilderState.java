package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.scsp.common.Header;
import io.netty.handler.ssl.ApplicationProtocolNames;
import java.util.ArrayList;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Token;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
enum HtmlTreeBuilderState {
    Initial { // from class: org.jsoup.parser.HtmlTreeBuilderState.1
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (!token.isDoctype()) {
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHtml);
                    return htmlTreeBuilder.process(token);
                }
                Token.Doctype doctypeAsDoctype = token.asDoctype();
                htmlTreeBuilder.getDocument().appendChild(new DocumentType(doctypeAsDoctype.getName(), doctypeAsDoctype.getPublicIdentifier(), doctypeAsDoctype.getSystemIdentifier(), htmlTreeBuilder.getBaseUri()));
                if (doctypeAsDoctype.isForceQuirks()) {
                    htmlTreeBuilder.getDocument().quirksMode(Document.QuirksMode.quirks);
                }
                htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHtml);
            }
            return true;
        }
    },
    BeforeHtml { // from class: org.jsoup.parser.HtmlTreeBuilderState.2
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.insertStartTag("html");
            htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHead);
            return htmlTreeBuilder.process(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (HtmlTreeBuilderState.isWhitespace(token)) {
                    return true;
                }
                if (!token.isStartTag() || !token.asStartTag().name().equals("html")) {
                    if (token.isEndTag() && StringUtil.m14986in(token.asEndTag().name(), "head", "body", "html", Header.f8126BR)) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    if (!token.isEndTag()) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.insert(token.asStartTag());
                htmlTreeBuilder.transition(HtmlTreeBuilderState.BeforeHead);
            }
            return true;
        }
    },
    BeforeHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.3
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (token.isDoctype()) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                    return HtmlTreeBuilderState.InBody.process(token, htmlTreeBuilder);
                }
                if (!token.isStartTag() || !token.asStartTag().name().equals("head")) {
                    if (token.isEndTag() && StringUtil.m14986in(token.asEndTag().name(), "head", "body", "html", Header.f8126BR)) {
                        htmlTreeBuilder.processStartTag("head");
                        return htmlTreeBuilder.process(token);
                    }
                    if (token.isEndTag()) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.processStartTag("head");
                    return htmlTreeBuilder.process(token);
                }
                htmlTreeBuilder.setHeadElement(htmlTreeBuilder.insert(token.asStartTag()));
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InHead);
            }
            return true;
        }
    },
    InHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.4
        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            treeBuilder.processEndTag("head");
            return treeBuilder.process(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i = C1427624.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (i == 2) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (i == 3) {
                    Token.StartTag startTagAsStartTag = token.asStartTag();
                    String strName = startTagAsStartTag.name();
                    if (strName.equals("html")) {
                        return HtmlTreeBuilderState.InBody.process(token, htmlTreeBuilder);
                    }
                    if (StringUtil.m14986in(strName, "base", "basefont", "bgsound", Contract.COMMAND, "link")) {
                        Element elementInsertEmpty = htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                        if (strName.equals("base") && elementInsertEmpty.hasAttr("href")) {
                            htmlTreeBuilder.maybeSetBaseUri(elementInsertEmpty);
                        }
                    } else if (strName.equals("meta")) {
                        htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                    } else if (strName.equals("title")) {
                        HtmlTreeBuilderState.handleRcData(startTagAsStartTag, htmlTreeBuilder);
                    } else if (StringUtil.m14986in(strName, "noframes", "style")) {
                        HtmlTreeBuilderState.handleRawtext(startTagAsStartTag, htmlTreeBuilder);
                    } else if (strName.equals("noscript")) {
                        htmlTreeBuilder.insert(startTagAsStartTag);
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.InHeadNoscript);
                    } else {
                        if (!strName.equals(StringLookupFactory.KEY_SCRIPT)) {
                            if (!strName.equals("head")) {
                                return anythingElse(token, htmlTreeBuilder);
                            }
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.tokeniser.transition(TokeniserState.ScriptData);
                        htmlTreeBuilder.markInsertionMode();
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.Text);
                        htmlTreeBuilder.insert(startTagAsStartTag);
                    }
                } else {
                    if (i != 4) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    String strName2 = token.asEndTag().name();
                    if (!strName2.equals("head")) {
                        if (StringUtil.m14986in(strName2, "body", "html", Header.f8126BR)) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterHead);
                }
            }
            return true;
        }
    },
    InHeadNoscript { // from class: org.jsoup.parser.HtmlTreeBuilderState.5
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.insert(new Token.Character().data(token.toString()));
            return true;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            }
            if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (token.isEndTag() && token.asEndTag().name().equals("noscript")) {
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InHead);
                return true;
            }
            if (HtmlTreeBuilderState.isWhitespace(token) || token.isComment() || (token.isStartTag() && StringUtil.m14986in(token.asStartTag().name(), "basefont", "bgsound", "link", "meta", "noframes", "style"))) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
            }
            if (token.isEndTag() && token.asEndTag().name().equals(Header.f8126BR)) {
                return anythingElse(token, htmlTreeBuilder);
            }
            if ((!token.isStartTag() || !StringUtil.m14986in(token.asStartTag().name(), "head", "noscript")) && !token.isEndTag()) {
                return anythingElse(token, htmlTreeBuilder);
            }
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    AfterHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.6
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.processStartTag("body");
            htmlTreeBuilder.framesetOk(true);
            return htmlTreeBuilder.process(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            }
            if (!token.isStartTag()) {
                if (!token.isEndTag()) {
                    anythingElse(token, htmlTreeBuilder);
                    return true;
                }
                if (StringUtil.m14986in(token.asEndTag().name(), "body", "html")) {
                    anythingElse(token, htmlTreeBuilder);
                    return true;
                }
                htmlTreeBuilder.error(this);
                return false;
            }
            Token.StartTag startTagAsStartTag = token.asStartTag();
            String strName = startTagAsStartTag.name();
            if (strName.equals("html")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (strName.equals("body")) {
                htmlTreeBuilder.insert(startTagAsStartTag);
                htmlTreeBuilder.framesetOk(false);
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InBody);
                return true;
            }
            if (strName.equals("frameset")) {
                htmlTreeBuilder.insert(startTagAsStartTag);
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InFrameset);
                return true;
            }
            if (!StringUtil.m14986in(strName, "base", "basefont", "bgsound", "link", "meta", "noframes", StringLookupFactory.KEY_SCRIPT, "style", "title")) {
                if (strName.equals("head")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                anythingElse(token, htmlTreeBuilder);
                return true;
            }
            htmlTreeBuilder.error(this);
            Element headElement = htmlTreeBuilder.getHeadElement();
            htmlTreeBuilder.push(headElement);
            htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
            htmlTreeBuilder.removeFromStack(headElement);
            return true;
        }
    },
    InBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.7
        /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
        
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean anyOtherEndTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String strName = token.asEndTag().name();
            ArrayList<Element> stack = htmlTreeBuilder.getStack();
            int size = stack.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Element element = stack.get(size);
                if (element.nodeName().equals(strName)) {
                    htmlTreeBuilder.generateImpliedEndTags(strName);
                    if (!strName.equals(htmlTreeBuilder.currentElement().nodeName())) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(strName);
                } else {
                    if (htmlTreeBuilder.isSpecial(element)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    size--;
                }
            }
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Element element;
            int i = C1427624.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (i == 2) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                int i2 = 3;
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            Token.Character characterAsCharacter = token.asCharacter();
                            if (characterAsCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                                htmlTreeBuilder.error(this);
                                return false;
                            }
                            if (htmlTreeBuilder.framesetOk() && HtmlTreeBuilderState.isWhitespace(characterAsCharacter)) {
                                htmlTreeBuilder.reconstructFormattingElements();
                                htmlTreeBuilder.insert(characterAsCharacter);
                            } else {
                                htmlTreeBuilder.reconstructFormattingElements();
                                htmlTreeBuilder.insert(characterAsCharacter);
                                htmlTreeBuilder.framesetOk(false);
                            }
                        }
                        return true;
                    }
                    Token.EndTag endTagAsEndTag = token.asEndTag();
                    String strName = endTagAsEndTag.name();
                    if (StringUtil.inSorted(strName, Constants.InBodyEndAdoptionFormatters)) {
                        int i4 = 0;
                        while (i4 < 8) {
                            Element activeFormattingElement = htmlTreeBuilder.getActiveFormattingElement(strName);
                            if (activeFormattingElement == null) {
                                return anyOtherEndTag(token, htmlTreeBuilder);
                            }
                            if (!htmlTreeBuilder.onStack(activeFormattingElement)) {
                                htmlTreeBuilder.error(this);
                                htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                                return true;
                            }
                            if (!htmlTreeBuilder.inScope(activeFormattingElement.nodeName())) {
                                htmlTreeBuilder.error(this);
                                return false;
                            }
                            if (htmlTreeBuilder.currentElement() != activeFormattingElement) {
                                htmlTreeBuilder.error(this);
                            }
                            ArrayList<Element> stack = htmlTreeBuilder.getStack();
                            int size = stack.size();
                            Element element2 = null;
                            boolean z = false;
                            for (int i5 = 0; i5 < size && i5 < 64; i5++) {
                                element = stack.get(i5);
                                if (element != activeFormattingElement) {
                                    if (z && htmlTreeBuilder.isSpecial(element)) {
                                        break;
                                    }
                                } else {
                                    element2 = stack.get(i5 - 1);
                                    z = true;
                                }
                            }
                            element = null;
                            if (element == null) {
                                htmlTreeBuilder.popStackToClose(activeFormattingElement.nodeName());
                                htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                                return true;
                            }
                            int i6 = 0;
                            Element elementAboveOnStack = element;
                            Element element3 = elementAboveOnStack;
                            while (i6 < i2) {
                                if (htmlTreeBuilder.onStack(elementAboveOnStack)) {
                                    elementAboveOnStack = htmlTreeBuilder.aboveOnStack(elementAboveOnStack);
                                }
                                if (!htmlTreeBuilder.isInActiveFormattingElements(elementAboveOnStack)) {
                                    htmlTreeBuilder.removeFromStack(elementAboveOnStack);
                                } else {
                                    if (elementAboveOnStack == activeFormattingElement) {
                                        break;
                                    }
                                    Element element4 = new Element(Tag.valueOf(elementAboveOnStack.nodeName()), htmlTreeBuilder.getBaseUri());
                                    htmlTreeBuilder.replaceActiveFormattingElement(elementAboveOnStack, element4);
                                    htmlTreeBuilder.replaceOnStack(elementAboveOnStack, element4);
                                    if (element3.parent() != null) {
                                        element3.remove();
                                    }
                                    element4.appendChild(element3);
                                    elementAboveOnStack = element4;
                                    element3 = elementAboveOnStack;
                                }
                                i6++;
                                i2 = 3;
                            }
                            if (StringUtil.inSorted(element2.nodeName(), Constants.InBodyEndTableFosters)) {
                                if (element3.parent() != null) {
                                    element3.remove();
                                }
                                htmlTreeBuilder.insertInFosterParent(element3);
                            } else {
                                if (element3.parent() != null) {
                                    element3.remove();
                                }
                                element2.appendChild(element3);
                            }
                            Element element5 = new Element(activeFormattingElement.tag(), htmlTreeBuilder.getBaseUri());
                            element5.attributes().addAll(activeFormattingElement.attributes());
                            for (Node node : (Node[]) element.childNodes().toArray(new Node[element.childNodeSize()])) {
                                element5.appendChild(node);
                            }
                            element.appendChild(element5);
                            htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                            htmlTreeBuilder.removeFromStack(activeFormattingElement);
                            htmlTreeBuilder.insertOnStackAfter(element, element5);
                            i4++;
                            i2 = 3;
                        }
                        return true;
                    }
                    if (StringUtil.inSorted(strName, Constants.InBodyEndClosers)) {
                        if (!htmlTreeBuilder.inScope(strName)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(strName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(strName);
                        return true;
                    }
                    if (strName.equals("span")) {
                        return anyOtherEndTag(token, htmlTreeBuilder);
                    }
                    if (strName.equals("li")) {
                        if (!htmlTreeBuilder.inListItemScope(strName)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags(strName);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(strName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(strName);
                        return true;
                    }
                    if (strName.equals("body")) {
                        if (htmlTreeBuilder.inScope("body")) {
                            htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterBody);
                            return true;
                        }
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    if (strName.equals("html")) {
                        if (htmlTreeBuilder.processEndTag("body")) {
                            return htmlTreeBuilder.process(endTagAsEndTag);
                        }
                        return true;
                    }
                    if (strName.equals("form")) {
                        FormElement formElement = htmlTreeBuilder.getFormElement();
                        htmlTreeBuilder.setFormElement(null);
                        if (formElement == null || !htmlTreeBuilder.inScope(strName)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(strName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.removeFromStack(formElement);
                        return true;
                    }
                    if (strName.equals("p")) {
                        if (!htmlTreeBuilder.inButtonScope(strName)) {
                            htmlTreeBuilder.error(this);
                            htmlTreeBuilder.processStartTag(strName);
                            return htmlTreeBuilder.process(endTagAsEndTag);
                        }
                        htmlTreeBuilder.generateImpliedEndTags(strName);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(strName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(strName);
                        return true;
                    }
                    if (StringUtil.inSorted(strName, Constants.DdDt)) {
                        if (!htmlTreeBuilder.inScope(strName)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags(strName);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(strName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(strName);
                        return true;
                    }
                    if (StringUtil.inSorted(strName, Constants.Headings)) {
                        if (!htmlTreeBuilder.inScope(Constants.Headings)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags(strName);
                        if (!htmlTreeBuilder.currentElement().nodeName().equals(strName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(Constants.Headings);
                        return true;
                    }
                    if (strName.equals("sarcasm")) {
                        return anyOtherEndTag(token, htmlTreeBuilder);
                    }
                    if (!StringUtil.inSorted(strName, Constants.InBodyStartApplets)) {
                        if (!strName.equals(Header.f8126BR)) {
                            return anyOtherEndTag(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processStartTag(Header.f8126BR);
                        return false;
                    }
                    if (htmlTreeBuilder.inScope("name")) {
                        return true;
                    }
                    if (!htmlTreeBuilder.inScope(strName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElement().nodeName().equals(strName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(strName);
                    htmlTreeBuilder.clearFormattingElementsToLastMarker();
                    return true;
                }
                Token.StartTag startTagAsStartTag = token.asStartTag();
                String strName2 = startTagAsStartTag.name();
                if (strName2.equals("a")) {
                    if (htmlTreeBuilder.getActiveFormattingElement("a") != null) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag("a");
                        Element fromStack = htmlTreeBuilder.getFromStack("a");
                        if (fromStack != null) {
                            htmlTreeBuilder.removeFromActiveFormattingElements(fromStack);
                            htmlTreeBuilder.removeFromStack(fromStack);
                        }
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(startTagAsStartTag));
                    return true;
                }
                if (StringUtil.inSorted(strName2, Constants.InBodyStartEmptyFormatters)) {
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    return true;
                }
                if (StringUtil.inSorted(strName2, Constants.InBodyStartPClosers)) {
                    if (htmlTreeBuilder.inButtonScope("p")) {
                        htmlTreeBuilder.processEndTag("p");
                    }
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    return true;
                }
                if (strName2.equals("span")) {
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    return true;
                }
                if (strName2.equals("li")) {
                    htmlTreeBuilder.framesetOk(false);
                    ArrayList<Element> stack2 = htmlTreeBuilder.getStack();
                    int size2 = stack2.size() - 1;
                    while (true) {
                        if (size2 <= 0) {
                            break;
                        }
                        Element element6 = stack2.get(size2);
                        if (element6.nodeName().equals("li")) {
                            htmlTreeBuilder.processEndTag("li");
                            break;
                        }
                        if (htmlTreeBuilder.isSpecial(element6) && !StringUtil.inSorted(element6.nodeName(), Constants.InBodyStartLiBreakers)) {
                            break;
                        }
                        size2--;
                    }
                    if (htmlTreeBuilder.inButtonScope("p")) {
                        htmlTreeBuilder.processEndTag("p");
                    }
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    return true;
                }
                if (strName2.equals("html")) {
                    htmlTreeBuilder.error(this);
                    Element element7 = htmlTreeBuilder.getStack().get(0);
                    for (Attribute attribute : startTagAsStartTag.getAttributes()) {
                        if (!element7.hasAttr(attribute.getKey())) {
                            element7.attributes().put(attribute);
                        }
                    }
                    return true;
                }
                if (StringUtil.inSorted(strName2, Constants.InBodyStartToHead)) {
                    return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                }
                if (strName2.equals("body")) {
                    htmlTreeBuilder.error(this);
                    ArrayList<Element> stack3 = htmlTreeBuilder.getStack();
                    if (stack3.size() == 1 || (stack3.size() > 2 && !stack3.get(1).nodeName().equals("body"))) {
                        return false;
                    }
                    htmlTreeBuilder.framesetOk(false);
                    Element element8 = stack3.get(1);
                    for (Attribute attribute2 : startTagAsStartTag.getAttributes()) {
                        if (!element8.hasAttr(attribute2.getKey())) {
                            element8.attributes().put(attribute2);
                        }
                    }
                } else if (strName2.equals("frameset")) {
                    htmlTreeBuilder.error(this);
                    ArrayList<Element> stack4 = htmlTreeBuilder.getStack();
                    if (stack4.size() == 1 || ((stack4.size() > 2 && !stack4.get(1).nodeName().equals("body")) || !htmlTreeBuilder.framesetOk())) {
                        return false;
                    }
                    Element element9 = stack4.get(1);
                    if (element9.parent() != null) {
                        element9.remove();
                    }
                    for (int i7 = 1; stack4.size() > i7; i7 = 1) {
                        stack4.remove(stack4.size() - i7);
                    }
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InFrameset);
                } else if (StringUtil.inSorted(strName2, Constants.Headings)) {
                    if (htmlTreeBuilder.inButtonScope("p")) {
                        htmlTreeBuilder.processEndTag("p");
                    }
                    if (StringUtil.inSorted(htmlTreeBuilder.currentElement().nodeName(), Constants.Headings)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.pop();
                    }
                    htmlTreeBuilder.insert(startTagAsStartTag);
                } else if (StringUtil.inSorted(strName2, Constants.InBodyStartPreListing)) {
                    if (htmlTreeBuilder.inButtonScope("p")) {
                        htmlTreeBuilder.processEndTag("p");
                    }
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.framesetOk(false);
                } else {
                    if (strName2.equals("form")) {
                        if (htmlTreeBuilder.getFormElement() != null) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        if (htmlTreeBuilder.inButtonScope("p")) {
                            htmlTreeBuilder.processEndTag("p");
                        }
                        htmlTreeBuilder.insertForm(startTagAsStartTag, true);
                        return true;
                    }
                    if (StringUtil.inSorted(strName2, Constants.DdDt)) {
                        htmlTreeBuilder.framesetOk(false);
                        ArrayList<Element> stack5 = htmlTreeBuilder.getStack();
                        int size3 = stack5.size() - 1;
                        while (true) {
                            if (size3 <= 0) {
                                break;
                            }
                            Element element10 = stack5.get(size3);
                            if (StringUtil.inSorted(element10.nodeName(), Constants.DdDt)) {
                                htmlTreeBuilder.processEndTag(element10.nodeName());
                                break;
                            }
                            if (htmlTreeBuilder.isSpecial(element10) && !StringUtil.inSorted(element10.nodeName(), Constants.InBodyStartLiBreakers)) {
                                break;
                            }
                            size3--;
                        }
                        if (htmlTreeBuilder.inButtonScope("p")) {
                            htmlTreeBuilder.processEndTag("p");
                        }
                        htmlTreeBuilder.insert(startTagAsStartTag);
                    } else if (strName2.equals("plaintext")) {
                        if (htmlTreeBuilder.inButtonScope("p")) {
                            htmlTreeBuilder.processEndTag("p");
                        }
                        htmlTreeBuilder.insert(startTagAsStartTag);
                        htmlTreeBuilder.tokeniser.transition(TokeniserState.PLAINTEXT);
                    } else if (strName2.equals(MarketingConstants.BUTTON)) {
                        if (htmlTreeBuilder.inButtonScope(MarketingConstants.BUTTON)) {
                            htmlTreeBuilder.error(this);
                            htmlTreeBuilder.processEndTag(MarketingConstants.BUTTON);
                            htmlTreeBuilder.process(startTagAsStartTag);
                        } else {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(startTagAsStartTag);
                            htmlTreeBuilder.framesetOk(false);
                        }
                    } else if (StringUtil.inSorted(strName2, Constants.Formatters)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(startTagAsStartTag));
                    } else if (strName2.equals("nobr")) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        if (htmlTreeBuilder.inScope("nobr")) {
                            htmlTreeBuilder.error(this);
                            htmlTreeBuilder.processEndTag("nobr");
                            htmlTreeBuilder.reconstructFormattingElements();
                        }
                        htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(startTagAsStartTag));
                    } else if (StringUtil.inSorted(strName2, Constants.InBodyStartApplets)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(startTagAsStartTag);
                        htmlTreeBuilder.insertMarkerToFormattingElements();
                        htmlTreeBuilder.framesetOk(false);
                    } else if (strName2.equals("table")) {
                        if (htmlTreeBuilder.getDocument().quirksMode() != Document.QuirksMode.quirks && htmlTreeBuilder.inButtonScope("p")) {
                            htmlTreeBuilder.processEndTag("p");
                        }
                        htmlTreeBuilder.insert(startTagAsStartTag);
                        htmlTreeBuilder.framesetOk(false);
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.InTable);
                    } else if (strName2.equals("input")) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        if (!htmlTreeBuilder.insertEmpty(startTagAsStartTag).attr("type").equalsIgnoreCase("hidden")) {
                            htmlTreeBuilder.framesetOk(false);
                        }
                    } else if (StringUtil.inSorted(strName2, Constants.InBodyStartMedia)) {
                        htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                    } else if (strName2.equals("hr")) {
                        if (htmlTreeBuilder.inButtonScope("p")) {
                            htmlTreeBuilder.processEndTag("p");
                        }
                        htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                        htmlTreeBuilder.framesetOk(false);
                    } else if (strName2.equals("image")) {
                        if (htmlTreeBuilder.getFromStack("svg") == null) {
                            return htmlTreeBuilder.process(startTagAsStartTag.name("img"));
                        }
                        htmlTreeBuilder.insert(startTagAsStartTag);
                    } else if (strName2.equals("isindex")) {
                        htmlTreeBuilder.error(this);
                        if (htmlTreeBuilder.getFormElement() != null) {
                            return false;
                        }
                        htmlTreeBuilder.tokeniser.acknowledgeSelfClosingFlag();
                        htmlTreeBuilder.processStartTag("form");
                        if (startTagAsStartTag.attributes.hasKey("action")) {
                            htmlTreeBuilder.getFormElement().attr("action", startTagAsStartTag.attributes.get("action"));
                        }
                        htmlTreeBuilder.processStartTag("hr");
                        htmlTreeBuilder.processStartTag("label");
                        htmlTreeBuilder.process(new Token.Character().data(startTagAsStartTag.attributes.hasKey(AuthenticationConstants.AAD.QUERY_PROMPT) ? startTagAsStartTag.attributes.get(AuthenticationConstants.AAD.QUERY_PROMPT) : "This is a searchable index. Enter search keywords: "));
                        Attributes attributes = new Attributes();
                        for (Attribute attribute3 : startTagAsStartTag.attributes) {
                            if (!StringUtil.inSorted(attribute3.getKey(), Constants.InBodyStartInputAttribs)) {
                                attributes.put(attribute3);
                            }
                        }
                        attributes.put("name", "isindex");
                        htmlTreeBuilder.processStartTag("input", attributes);
                        htmlTreeBuilder.processEndTag("label");
                        htmlTreeBuilder.processStartTag("hr");
                        htmlTreeBuilder.processEndTag("form");
                    } else if (strName2.equals("textarea")) {
                        htmlTreeBuilder.insert(startTagAsStartTag);
                        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
                        htmlTreeBuilder.markInsertionMode();
                        htmlTreeBuilder.framesetOk(false);
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.Text);
                    } else if (strName2.equals("xmp")) {
                        if (htmlTreeBuilder.inButtonScope("p")) {
                            htmlTreeBuilder.processEndTag("p");
                        }
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.framesetOk(false);
                        HtmlTreeBuilderState.handleRawtext(startTagAsStartTag, htmlTreeBuilder);
                    } else if (strName2.equals("iframe")) {
                        htmlTreeBuilder.framesetOk(false);
                        HtmlTreeBuilderState.handleRawtext(startTagAsStartTag, htmlTreeBuilder);
                    } else if (strName2.equals("noembed")) {
                        HtmlTreeBuilderState.handleRawtext(startTagAsStartTag, htmlTreeBuilder);
                    } else if (strName2.equals(Bixby2Constants.BIXBY_PARAM_SELECT)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(startTagAsStartTag);
                        htmlTreeBuilder.framesetOk(false);
                        HtmlTreeBuilderState htmlTreeBuilderStateState = htmlTreeBuilder.state();
                        if (htmlTreeBuilderStateState.equals(HtmlTreeBuilderState.InTable) || htmlTreeBuilderStateState.equals(HtmlTreeBuilderState.InCaption) || htmlTreeBuilderStateState.equals(HtmlTreeBuilderState.InTableBody) || htmlTreeBuilderStateState.equals(HtmlTreeBuilderState.InRow) || htmlTreeBuilderStateState.equals(HtmlTreeBuilderState.InCell)) {
                            htmlTreeBuilder.transition(HtmlTreeBuilderState.InSelectInTable);
                        } else {
                            htmlTreeBuilder.transition(HtmlTreeBuilderState.InSelect);
                        }
                    } else if (StringUtil.inSorted(strName2, Constants.InBodyStartOptions)) {
                        if (htmlTreeBuilder.currentElement().nodeName().equals("option")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(startTagAsStartTag);
                    } else if (StringUtil.inSorted(strName2, Constants.InBodyStartRuby)) {
                        if (htmlTreeBuilder.inScope("ruby")) {
                            htmlTreeBuilder.generateImpliedEndTags();
                            if (!htmlTreeBuilder.currentElement().nodeName().equals("ruby")) {
                                htmlTreeBuilder.error(this);
                                htmlTreeBuilder.popStackToBefore("ruby");
                            }
                            htmlTreeBuilder.insert(startTagAsStartTag);
                        }
                    } else if (strName2.equals("math") || strName2.equals("svg")) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(startTagAsStartTag);
                        htmlTreeBuilder.tokeniser.acknowledgeSelfClosingFlag();
                    } else {
                        if (StringUtil.inSorted(strName2, Constants.InBodyStartDrop)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(startTagAsStartTag);
                    }
                }
            }
            return true;
        }
    },
    Text { // from class: org.jsoup.parser.HtmlTreeBuilderState.8
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isEOF()) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return htmlTreeBuilder.process(token);
            }
            if (!token.isEndTag()) {
                return true;
            }
            htmlTreeBuilder.pop();
            htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
            return true;
        }
    },
    InTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.9
        public boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            if (!StringUtil.m14986in(htmlTreeBuilder.currentElement().nodeName(), "table", "tbody", "tfoot", "thead", "tr")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            htmlTreeBuilder.setFosterInserts(true);
            boolean zProcess = htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            htmlTreeBuilder.setFosterInserts(false);
            return zProcess;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.newPendingTableCharacters();
                htmlTreeBuilder.markInsertionMode();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InTableText);
                return htmlTreeBuilder.process(token);
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (!token.isStartTag()) {
                if (!token.isEndTag()) {
                    if (!token.isEOF()) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                        htmlTreeBuilder.error(this);
                    }
                    return true;
                }
                String strName = token.asEndTag().name();
                if (!strName.equals("table")) {
                    if (!StringUtil.m14986in(strName, "body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (!htmlTreeBuilder.inTableScope(strName)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.popStackToClose("table");
                htmlTreeBuilder.resetInsertionMode();
                return true;
            }
            Token.StartTag startTagAsStartTag = token.asStartTag();
            String strName2 = startTagAsStartTag.name();
            if (strName2.equals("caption")) {
                htmlTreeBuilder.clearStackToTableContext();
                htmlTreeBuilder.insertMarkerToFormattingElements();
                htmlTreeBuilder.insert(startTagAsStartTag);
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InCaption);
            } else if (strName2.equals("colgroup")) {
                htmlTreeBuilder.clearStackToTableContext();
                htmlTreeBuilder.insert(startTagAsStartTag);
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InColumnGroup);
            } else {
                if (strName2.equals("col")) {
                    htmlTreeBuilder.processStartTag("colgroup");
                    return htmlTreeBuilder.process(token);
                }
                if (StringUtil.m14986in(strName2, "tbody", "tfoot", "thead")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InTableBody);
                } else {
                    if (StringUtil.m14986in(strName2, "td", "th", "tr")) {
                        htmlTreeBuilder.processStartTag("tbody");
                        return htmlTreeBuilder.process(token);
                    }
                    if (strName2.equals("table")) {
                        htmlTreeBuilder.error(this);
                        if (htmlTreeBuilder.processEndTag("table")) {
                            return htmlTreeBuilder.process(token);
                        }
                    } else {
                        if (StringUtil.m14986in(strName2, "style", StringLookupFactory.KEY_SCRIPT)) {
                            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
                        }
                        if (strName2.equals("input")) {
                            if (!startTagAsStartTag.attributes.get("type").equalsIgnoreCase("hidden")) {
                                return anythingElse(token, htmlTreeBuilder);
                            }
                            htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                        } else {
                            if (!strName2.equals("form")) {
                                return anythingElse(token, htmlTreeBuilder);
                            }
                            htmlTreeBuilder.error(this);
                            if (htmlTreeBuilder.getFormElement() != null) {
                                return false;
                            }
                            htmlTreeBuilder.insertForm(startTagAsStartTag, false);
                        }
                    }
                }
            }
            return true;
        }
    },
    InTableText { // from class: org.jsoup.parser.HtmlTreeBuilderState.10
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (C1427624.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()] == 5) {
                Token.Character characterAsCharacter = token.asCharacter();
                if (characterAsCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.getPendingTableCharacters().add(characterAsCharacter.getData());
                return true;
            }
            if (htmlTreeBuilder.getPendingTableCharacters().size() > 0) {
                for (String str : htmlTreeBuilder.getPendingTableCharacters()) {
                    if (HtmlTreeBuilderState.isWhitespace(str)) {
                        htmlTreeBuilder.insert(new Token.Character().data(str));
                    } else {
                        htmlTreeBuilder.error(this);
                        if (StringUtil.m14986in(htmlTreeBuilder.currentElement().nodeName(), "table", "tbody", "tfoot", "thead", "tr")) {
                            htmlTreeBuilder.setFosterInserts(true);
                            htmlTreeBuilder.process(new Token.Character().data(str), HtmlTreeBuilderState.InBody);
                            htmlTreeBuilder.setFosterInserts(false);
                        } else {
                            htmlTreeBuilder.process(new Token.Character().data(str), HtmlTreeBuilderState.InBody);
                        }
                    }
                }
                htmlTreeBuilder.newPendingTableCharacters();
            }
            htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
            return htmlTreeBuilder.process(token);
        }
    },
    InCaption { // from class: org.jsoup.parser.HtmlTreeBuilderState.11
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag() && token.asEndTag().name().equals("caption")) {
                if (!htmlTreeBuilder.inTableScope(token.asEndTag().name())) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.generateImpliedEndTags();
                if (!htmlTreeBuilder.currentElement().nodeName().equals("caption")) {
                    htmlTreeBuilder.error(this);
                }
                htmlTreeBuilder.popStackToClose("caption");
                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InTable);
                return true;
            }
            if ((token.isStartTag() && StringUtil.m14986in(token.asStartTag().name(), "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) || (token.isEndTag() && token.asEndTag().name().equals("table"))) {
                htmlTreeBuilder.error(this);
                if (htmlTreeBuilder.processEndTag("caption")) {
                    return htmlTreeBuilder.process(token);
                }
                return true;
            }
            if (!token.isEndTag() || !StringUtil.m14986in(token.asEndTag().name(), "body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    InColumnGroup { // from class: org.jsoup.parser.HtmlTreeBuilderState.12
        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("colgroup")) {
                return treeBuilder.process(token);
            }
            return true;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i = C1427624.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (i == 2) {
                htmlTreeBuilder.error(this);
            } else if (i == 3) {
                Token.StartTag startTagAsStartTag = token.asStartTag();
                String strName = startTagAsStartTag.name();
                if (strName.equals("html")) {
                    return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
                }
                if (!strName.equals("col")) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.insertEmpty(startTagAsStartTag);
            } else {
                if (i != 4) {
                    if (i != 6) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                        return true;
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
                if (!token.asEndTag().name().equals("colgroup")) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InTable);
            }
            return true;
        }
    },
    InTableBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.13
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InTable);
        }

        private boolean exitTableBody(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!htmlTreeBuilder.inTableScope("tbody") && !htmlTreeBuilder.inTableScope("thead") && !htmlTreeBuilder.inScope("tfoot")) {
                htmlTreeBuilder.error(this);
                return false;
            }
            htmlTreeBuilder.clearStackToTableBodyContext();
            htmlTreeBuilder.processEndTag(htmlTreeBuilder.currentElement().nodeName());
            return htmlTreeBuilder.process(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            int i = C1427624.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 3) {
                Token.StartTag startTagAsStartTag = token.asStartTag();
                String strName = startTagAsStartTag.name();
                if (strName.equals("tr")) {
                    htmlTreeBuilder.clearStackToTableBodyContext();
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.transition(HtmlTreeBuilderState.InRow);
                    return true;
                }
                if (!StringUtil.m14986in(strName, "th", "td")) {
                    return StringUtil.m14986in(strName, "caption", "col", "colgroup", "tbody", "tfoot", "thead") ? exitTableBody(token, htmlTreeBuilder) : anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.processStartTag("tr");
                return htmlTreeBuilder.process(startTagAsStartTag);
            }
            if (i != 4) {
                return anythingElse(token, htmlTreeBuilder);
            }
            String strName2 = token.asEndTag().name();
            if (!StringUtil.m14986in(strName2, "tbody", "tfoot", "thead")) {
                if (strName2.equals("table")) {
                    return exitTableBody(token, htmlTreeBuilder);
                }
                if (!StringUtil.m14986in(strName2, "body", "caption", "col", "colgroup", "html", "td", "th", "tr")) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.error(this);
                return false;
            }
            if (!htmlTreeBuilder.inTableScope(strName2)) {
                htmlTreeBuilder.error(this);
                return false;
            }
            htmlTreeBuilder.clearStackToTableBodyContext();
            htmlTreeBuilder.pop();
            htmlTreeBuilder.transition(HtmlTreeBuilderState.InTable);
            return true;
        }
    },
    InRow { // from class: org.jsoup.parser.HtmlTreeBuilderState.14
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InTable);
        }

        private boolean handleMissingTr(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("tr")) {
                return treeBuilder.process(token);
            }
            return false;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag()) {
                Token.StartTag startTagAsStartTag = token.asStartTag();
                String strName = startTagAsStartTag.name();
                if (!StringUtil.m14986in(strName, "th", "td")) {
                    return StringUtil.m14986in(strName, "caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr") ? handleMissingTr(token, htmlTreeBuilder) : anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.clearStackToTableRowContext();
                htmlTreeBuilder.insert(startTagAsStartTag);
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InCell);
                htmlTreeBuilder.insertMarkerToFormattingElements();
                return true;
            }
            if (!token.isEndTag()) {
                return anythingElse(token, htmlTreeBuilder);
            }
            String strName2 = token.asEndTag().name();
            if (strName2.equals("tr")) {
                if (!htmlTreeBuilder.inTableScope(strName2)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.clearStackToTableRowContext();
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InTableBody);
                return true;
            }
            if (strName2.equals("table")) {
                return handleMissingTr(token, htmlTreeBuilder);
            }
            if (!StringUtil.m14986in(strName2, "tbody", "tfoot", "thead")) {
                if (!StringUtil.m14986in(strName2, "body", "caption", "col", "colgroup", "html", "td", "th")) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.error(this);
                return false;
            }
            if (htmlTreeBuilder.inTableScope(strName2)) {
                htmlTreeBuilder.processEndTag("tr");
                return htmlTreeBuilder.process(token);
            }
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    InCell { // from class: org.jsoup.parser.HtmlTreeBuilderState.15
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
        }

        private void closeCell(HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.inTableScope("td")) {
                htmlTreeBuilder.processEndTag("td");
            } else {
                htmlTreeBuilder.processEndTag("th");
            }
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!token.isEndTag()) {
                if (!token.isStartTag() || !StringUtil.m14986in(token.asStartTag().name(), "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                if (htmlTreeBuilder.inTableScope("td") || htmlTreeBuilder.inTableScope("th")) {
                    closeCell(htmlTreeBuilder);
                    return htmlTreeBuilder.process(token);
                }
                htmlTreeBuilder.error(this);
                return false;
            }
            String strName = token.asEndTag().name();
            if (!StringUtil.m14986in(strName, "td", "th")) {
                if (StringUtil.m14986in(strName, "body", "caption", "col", "colgroup", "html")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (!StringUtil.m14986in(strName, "table", "tbody", "tfoot", "thead", "tr")) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                if (htmlTreeBuilder.inTableScope(strName)) {
                    closeCell(htmlTreeBuilder);
                    return htmlTreeBuilder.process(token);
                }
                htmlTreeBuilder.error(this);
                return false;
            }
            if (!htmlTreeBuilder.inTableScope(strName)) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.transition(HtmlTreeBuilderState.InRow);
                return false;
            }
            htmlTreeBuilder.generateImpliedEndTags();
            if (!htmlTreeBuilder.currentElement().nodeName().equals(strName)) {
                htmlTreeBuilder.error(this);
            }
            htmlTreeBuilder.popStackToClose(strName);
            htmlTreeBuilder.clearFormattingElementsToLastMarker();
            htmlTreeBuilder.transition(HtmlTreeBuilderState.InRow);
            return true;
        }
    },
    InSelect { // from class: org.jsoup.parser.HtmlTreeBuilderState.16
        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            return false;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (C1427624.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 1:
                    htmlTreeBuilder.insert(token.asComment());
                    return true;
                case 2:
                    htmlTreeBuilder.error(this);
                    return false;
                case 3:
                    Token.StartTag startTagAsStartTag = token.asStartTag();
                    String strName = startTagAsStartTag.name();
                    if (strName.equals("html")) {
                        return htmlTreeBuilder.process(startTagAsStartTag, HtmlTreeBuilderState.InBody);
                    }
                    if (strName.equals("option")) {
                        htmlTreeBuilder.processEndTag("option");
                        htmlTreeBuilder.insert(startTagAsStartTag);
                        return true;
                    }
                    if (strName.equals("optgroup")) {
                        if (htmlTreeBuilder.currentElement().nodeName().equals("option")) {
                            htmlTreeBuilder.processEndTag("option");
                        } else if (htmlTreeBuilder.currentElement().nodeName().equals("optgroup")) {
                            htmlTreeBuilder.processEndTag("optgroup");
                        }
                        htmlTreeBuilder.insert(startTagAsStartTag);
                        return true;
                    }
                    if (strName.equals(Bixby2Constants.BIXBY_PARAM_SELECT)) {
                        htmlTreeBuilder.error(this);
                        return htmlTreeBuilder.processEndTag(Bixby2Constants.BIXBY_PARAM_SELECT);
                    }
                    if (!StringUtil.m14986in(strName, "input", "keygen", "textarea")) {
                        return strName.equals(StringLookupFactory.KEY_SCRIPT) ? htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead) : anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    if (!htmlTreeBuilder.inSelectScope(Bixby2Constants.BIXBY_PARAM_SELECT)) {
                        return false;
                    }
                    htmlTreeBuilder.processEndTag(Bixby2Constants.BIXBY_PARAM_SELECT);
                    return htmlTreeBuilder.process(startTagAsStartTag);
                case 4:
                    String strName2 = token.asEndTag().name();
                    if (strName2.equals("optgroup")) {
                        if (htmlTreeBuilder.currentElement().nodeName().equals("option") && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()) != null && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()).nodeName().equals("optgroup")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        if (htmlTreeBuilder.currentElement().nodeName().equals("optgroup")) {
                            htmlTreeBuilder.pop();
                            return true;
                        }
                        htmlTreeBuilder.error(this);
                        return true;
                    }
                    if (strName2.equals("option")) {
                        if (htmlTreeBuilder.currentElement().nodeName().equals("option")) {
                            htmlTreeBuilder.pop();
                            return true;
                        }
                        htmlTreeBuilder.error(this);
                        return true;
                    }
                    if (!strName2.equals(Bixby2Constants.BIXBY_PARAM_SELECT)) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    if (!htmlTreeBuilder.inSelectScope(strName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.popStackToClose(strName2);
                    htmlTreeBuilder.resetInsertionMode();
                    return true;
                case 5:
                    Token.Character characterAsCharacter = token.asCharacter();
                    if (characterAsCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.insert(characterAsCharacter);
                    return true;
                case 6:
                    if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                        return true;
                    }
                    htmlTreeBuilder.error(this);
                    return true;
                default:
                    return anythingElse(token, htmlTreeBuilder);
            }
        }
    },
    InSelectInTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.17
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag() && StringUtil.m14986in(token.asStartTag().name(), "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.processEndTag(Bixby2Constants.BIXBY_PARAM_SELECT);
                return htmlTreeBuilder.process(token);
            }
            if (!token.isEndTag() || !StringUtil.m14986in(token.asEndTag().name(), "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InSelect);
            }
            htmlTreeBuilder.error(this);
            if (!htmlTreeBuilder.inTableScope(token.asEndTag().name())) {
                return false;
            }
            htmlTreeBuilder.processEndTag(Bixby2Constants.BIXBY_PARAM_SELECT);
            return htmlTreeBuilder.process(token);
        }
    },
    AfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.18
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (token.isEndTag() && token.asEndTag().name().equals("html")) {
                if (htmlTreeBuilder.isFragmentParsing()) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterAfterBody);
                return true;
            }
            if (token.isEOF()) {
                return true;
            }
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.transition(HtmlTreeBuilderState.InBody);
            return htmlTreeBuilder.process(token);
        }
    },
    InFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.19
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (token.isDoctype()) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (token.isStartTag()) {
                    Token.StartTag startTagAsStartTag = token.asStartTag();
                    String strName = startTagAsStartTag.name();
                    if (strName.equals("html")) {
                        return htmlTreeBuilder.process(startTagAsStartTag, HtmlTreeBuilderState.InBody);
                    }
                    if (strName.equals("frameset")) {
                        htmlTreeBuilder.insert(startTagAsStartTag);
                    } else {
                        if (!strName.equals(TypedValues.Attributes.S_FRAME)) {
                            if (strName.equals("noframes")) {
                                return htmlTreeBuilder.process(startTagAsStartTag, HtmlTreeBuilderState.InHead);
                            }
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                    }
                } else if (token.isEndTag() && token.asEndTag().name().equals("frameset")) {
                    if (htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.pop();
                    if (!htmlTreeBuilder.isFragmentParsing() && !htmlTreeBuilder.currentElement().nodeName().equals("frameset")) {
                        htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterFrameset);
                    }
                } else {
                    if (!token.isEOF()) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    if (!htmlTreeBuilder.currentElement().nodeName().equals("html")) {
                        htmlTreeBuilder.error(this);
                    }
                }
            }
            return true;
        }
    },
    AfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.20
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isStartTag() && token.asStartTag().name().equals("html")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (token.isEndTag() && token.asEndTag().name().equals("html")) {
                htmlTreeBuilder.transition(HtmlTreeBuilderState.AfterAfterFrameset);
                return true;
            }
            if (token.isStartTag() && token.asStartTag().name().equals("noframes")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
            }
            if (token.isEOF()) {
                return true;
            }
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    AfterAfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.21
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype() || HtmlTreeBuilderState.isWhitespace(token) || (token.isStartTag() && token.asStartTag().name().equals("html"))) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (token.isEOF()) {
                return true;
            }
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.transition(HtmlTreeBuilderState.InBody);
            return htmlTreeBuilder.process(token);
        }
    },
    AfterAfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.22
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype() || HtmlTreeBuilderState.isWhitespace(token) || (token.isStartTag() && token.asStartTag().name().equals("html"))) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InBody);
            }
            if (token.isEOF()) {
                return true;
            }
            if (token.isStartTag() && token.asStartTag().name().equals("noframes")) {
                return htmlTreeBuilder.process(token, HtmlTreeBuilderState.InHead);
            }
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    ForeignContent { // from class: org.jsoup.parser.HtmlTreeBuilderState.23
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return true;
        }
    };

    private static String nullString = String.valueOf((char) 0);

    /* JADX INFO: renamed from: org.jsoup.parser.HtmlTreeBuilderState$24 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C1427624 {
        static final /* synthetic */ int[] $SwitchMap$org$jsoup$parser$Token$TokenType;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            $SwitchMap$org$jsoup$parser$Token$TokenType = iArr;
            try {
                iArr[Token.TokenType.Comment.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Doctype.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.StartTag.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EndTag.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Character.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Constants {
        private static final String[] InBodyStartToHead = {"base", "basefont", "bgsound", Contract.COMMAND, "link", "meta", "noframes", StringLookupFactory.KEY_SCRIPT, "style", "title"};
        private static final String[] InBodyStartPClosers = {"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", ExternalSettingsProvider.EXTRA_MENU, "nav", "ol", "p", "section", DBSchema.DocumentCover.SUMMARY, "ul"};
        private static final String[] Headings = {"h1", ApplicationProtocolNames.HTTP_2, "h3", "h4", "h5", "h6"};
        private static final String[] InBodyStartPreListing = {"pre", "listing"};
        private static final String[] InBodyStartLiBreakers = {"address", "div", "p"};
        private static final String[] DdDt = {"dd", "dt"};
        private static final String[] Formatters = {"b", "big", "code", "em", "font", "i", "s", "small", "strike", "strong", "tt", CoeditServiceConstants.CacheFilePath.UPDATE_CACHE};
        private static final String[] InBodyStartApplets = {"applet", "marquee", CoeditServiceConstants.Element.NAME_OBJECT};
        private static final String[] InBodyStartEmptyFormatters = {"area", Header.f8126BR, "embed", "img", "keygen", "wbr"};
        private static final String[] InBodyStartMedia = {"param", "source", "track"};
        private static final String[] InBodyStartInputAttribs = {"name", "action", AuthenticationConstants.AAD.QUERY_PROMPT};
        private static final String[] InBodyStartOptions = {"optgroup", "option"};
        private static final String[] InBodyStartRuby = {"rp", "rt"};
        private static final String[] InBodyStartDrop = {"caption", "col", "colgroup", TypedValues.Attributes.S_FRAME, "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
        private static final String[] InBodyEndClosers = {"address", "article", "aside", "blockquote", MarketingConstants.BUTTON, "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", ExternalSettingsProvider.EXTRA_MENU, "nav", "ol", "pre", "section", DBSchema.DocumentCover.SUMMARY, "ul"};
        private static final String[] InBodyEndAdoptionFormatters = {"a", "b", "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", CoeditServiceConstants.CacheFilePath.UPDATE_CACHE};
        private static final String[] InBodyEndTableFosters = {"table", "tbody", "tfoot", "thead", "tr"};

        private Constants() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRawtext(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.insert(startTag);
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rawtext);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRcData(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.insert(startTag);
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(Token token) {
        if (token.isCharacter()) {
            return isWhitespace(token.asCharacter().getData());
        }
        return false;
    }

    public abstract boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder);

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!StringUtil.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
