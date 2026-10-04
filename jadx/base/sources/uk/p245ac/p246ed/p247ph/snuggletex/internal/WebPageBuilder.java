package uk.p245ac.p246ed.p247ph.snuggletex.internal;

import androidx.appcompat.widget.AbstractC0541b;
import com.adobe.internal.xmp.XMPConst;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.context.sdk.samsunganalytics.internal.policy.Constants;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Properties;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import uk.p245ac.p246ed.p247ph.snuggletex.SerializationMethod;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleRuntimeException;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleSession;
import uk.p245ac.p246ed.p247ph.snuggletex.WebPageOutputOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.W3CConstants;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.XMLUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.tokens.FlowToken;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.CSSUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.StylesheetManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class WebPageBuilder {
    public static final String DEFAULT_MATHJAX_URL = "http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=MML_HTMLorMML-full";
    private final WebPageOutputOptions options;
    private final SessionContext sessionContext;

    public WebPageBuilder(SessionContext sessionContext, WebPageOutputOptions webPageOutputOptions) {
        this.sessionContext = sessionContext;
        this.options = webPageOutputOptions;
    }

    private String computeContentTypeHeader() {
        if (this.options.isNoCharsetInContentTypeHeader()) {
            return this.options.getContentType();
        }
        return this.options.getContentType() + HTTP.CHARSET_PARAM + this.options.getEncoding();
    }

    private String computeMetaContentType() {
        return this.options.getContentType() + HTTP.CHARSET_PARAM + this.options.getEncoding();
    }

    private final Transformer createSerializer() {
        StylesheetManager stylesheetManager = this.sessionContext.getStylesheetManager();
        boolean zSupportsXSLT20 = stylesheetManager.supportsXSLT20();
        Transformer serializer = stylesheetManager.getSerializer(null, this.options);
        serializer.setOutputProperty(XMLWriter.MEDIA_TYPE, this.options.getContentType());
        Properties outputProperties = serializer.getOutputProperties();
        if (this.options.isHtml5()) {
            outputProperties.remove(XMLWriter.DOCTYPE_PUBLIC);
            outputProperties.remove(XMLWriter.DOCTYPE_SYSTEM);
        }
        if (this.options.getSerializationMethod() != SerializationMethod.XML) {
            if (zSupportsXSLT20) {
                serializer.setOutputProperty("include-content-type", BooleanUtils.f9757NO);
                return serializer;
            }
            serializer.setOutputProperty("{http://xml.apache.org/xalan}omit-meta-tag", BooleanUtils.YES);
        }
        return serializer;
    }

    private Element createXHTMLElement(Document document, String str) {
        return createXHTMLElement(document, str, null);
    }

    public final Document buildWebPage(List<FlowToken> list) {
        Document documentNewDocument = XMLUtilities.createNSAwareDocumentBuilder().newDocument();
        String[] clientSideXSLTStylesheetURLs = this.options.getClientSideXSLTStylesheetURLs();
        if (clientSideXSLTStylesheetURLs != null) {
            for (String str : clientSideXSLTStylesheetURLs) {
                documentNewDocument.appendChild(documentNewDocument.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"" + str + "\""));
            }
        }
        Element elementCreateXHTMLElement = createXHTMLElement(documentNewDocument, "body");
        String title = this.options.getTitle();
        if (title != null && this.options.isAddingTitleHeading()) {
            Node nodeCreateXHTMLElement = createXHTMLElement(documentNewDocument, "h1");
            nodeCreateXHTMLElement.appendChild(documentNewDocument.createTextNode(title));
            elementCreateXHTMLElement.appendChild(nodeCreateXHTMLElement);
        }
        new DOMBuildingController(this.sessionContext, this.options).buildDOMSubtree(elementCreateXHTMLElement, list);
        Element elementCreateXHTMLElement2 = createXHTMLElement(documentNewDocument, "head");
        if (this.options.isAddingMathPlayerImport()) {
            Element elementCreateXHTMLElement3 = createXHTMLElement(documentNewDocument, CoeditServiceConstants.Element.NAME_OBJECT);
            elementCreateXHTMLElement3.setAttribute("id", "MathPlayer");
            elementCreateXHTMLElement3.setAttribute("classid", "clsid:32F66A20-7614-11D4-BD11-00104BD3F987");
            elementCreateXHTMLElement2.appendChild(elementCreateXHTMLElement3);
            elementCreateXHTMLElement2.appendChild(documentNewDocument.createProcessingInstruction("import", "namespace=\"" + this.options.getMathMLPrefix() + "\" implementation=\"#MathPlayer\" ?"));
        }
        Element elementCreateXHTMLElement4 = createXHTMLElement(documentNewDocument, "meta");
        if (this.options.isHtml5()) {
            elementCreateXHTMLElement4.setAttribute("charset", this.options.getEncoding());
        } else {
            elementCreateXHTMLElement4.setAttribute("http-equiv", "Content-Type");
            elementCreateXHTMLElement4.setAttribute("content", computeMetaContentType());
        }
        elementCreateXHTMLElement2.appendChild(elementCreateXHTMLElement4);
        Element elementCreateXHTMLElement5 = createXHTMLElement(documentNewDocument, "meta");
        elementCreateXHTMLElement5.setAttribute("name", "Generator");
        elementCreateXHTMLElement5.setAttribute("content", "SnuggleTeX");
        elementCreateXHTMLElement2.appendChild(elementCreateXHTMLElement5);
        Node nodeCreateXHTMLElement2 = createXHTMLElement(documentNewDocument, "title");
        if (title == null) {
            title = "SnuggleTeX Generated Page";
        }
        nodeCreateXHTMLElement2.appendChild(documentNewDocument.createTextNode(title));
        elementCreateXHTMLElement2.appendChild(nodeCreateXHTMLElement2);
        String[] cSSStylesheetURLs = this.options.getCSSStylesheetURLs();
        if (cSSStylesheetURLs != null) {
            for (String str2 : cSSStylesheetURLs) {
                Element elementCreateXHTMLElement6 = createXHTMLElement(documentNewDocument, "link");
                elementCreateXHTMLElement6.setAttribute(Constants.VALUE_LOG_TYPE_REL, "stylesheet");
                elementCreateXHTMLElement6.setAttribute("href", str2);
                elementCreateXHTMLElement2.appendChild(elementCreateXHTMLElement6);
            }
        }
        if (this.options.isIncludingStyleElement() && !this.options.isInliningCSS()) {
            Element elementCreateXHTMLElement7 = createXHTMLElement(documentNewDocument, "style");
            elementCreateXHTMLElement7.setAttribute("type", "text/css");
            elementCreateXHTMLElement7.appendChild(documentNewDocument.createTextNode(CSSUtilities.writeStylesheet(CSSUtilities.readInlineCSSProperties(this.options))));
            elementCreateXHTMLElement2.appendChild(elementCreateXHTMLElement7);
        }
        if (this.options.isMathJax()) {
            String customMathJaxUrl = this.options.getCustomMathJaxUrl();
            if (customMathJaxUrl == null) {
                customMathJaxUrl = DEFAULT_MATHJAX_URL;
            }
            Element elementCreateXHTMLElement8 = createXHTMLElement(documentNewDocument, StringLookupFactory.KEY_SCRIPT);
            elementCreateXHTMLElement8.setAttribute("type", "text/javascript");
            elementCreateXHTMLElement8.setAttribute("src", customMathJaxUrl);
            elementCreateXHTMLElement2.appendChild(elementCreateXHTMLElement8);
        }
        Element elementCreateXHTMLElement9 = createXHTMLElement(documentNewDocument, "html");
        if (this.options.getMathPrefRenderer() != null) {
            elementCreateXHTMLElement9.setAttributeNS("http://www.w3.org/2002/Math/preference", "pref:renderer", "mathplayer-dl");
        }
        String lang = this.options.getLang();
        if (lang != null) {
            if (this.options.getSerializationMethod() == SerializationMethod.HTML || this.options.getSerializationMethod() == SerializationMethod.STRICTLY_HTML) {
                elementCreateXHTMLElement9.setAttribute("lang", lang);
            } else {
                elementCreateXHTMLElement9.setAttributeNS("http://www.w3.org/XML/1998/namespace", XMPConst.XML_LANG, lang);
            }
        }
        if (this.options.isPrefixingMathML() && this.options.getSerializationMethod() != SerializationMethod.HTML && this.options.getSerializationMethod() != SerializationMethod.STRICTLY_HTML) {
            elementCreateXHTMLElement9.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:" + this.options.getMathMLPrefix(), "http://www.w3.org/1998/Math/MathML");
        }
        elementCreateXHTMLElement9.appendChild(elementCreateXHTMLElement2);
        elementCreateXHTMLElement9.appendChild(elementCreateXHTMLElement);
        documentNewDocument.appendChild(elementCreateXHTMLElement9);
        Transformer[] stylesheets = this.options.getStylesheets();
        if (!ObjectUtilities.isNullOrEmpty(stylesheets)) {
            for (Transformer transformer : stylesheets) {
                DOMSource dOMSource = new DOMSource(documentNewDocument);
                documentNewDocument = XMLUtilities.createNSAwareDocumentBuilder().newDocument();
                try {
                    transformer.transform(dOMSource, new DOMResult(documentNewDocument));
                } catch (TransformerException unused) {
                    throw new SnuggleRuntimeException("Could not apply stylesheet " + transformer);
                }
            }
        }
        return documentNewDocument;
    }

    public final String buildWebPageString(List<FlowToken> list) {
        Document documentBuildWebPage = buildWebPage(list);
        StringWriter stringWriter = new StringWriter();
        if (this.options.isHtml5()) {
            stringWriter.append((CharSequence) W3CConstants.HTML5_DOCTYPE_HEADER);
        }
        try {
            createSerializer().transform(new DOMSource(documentBuildWebPage), new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (TransformerException e) {
            throw new SnuggleRuntimeException("Could not serialize web page", e);
        }
    }

    public final void setWebPageContentType(Object obj) {
        try {
            obj.getClass().getMethod("setContentType", String.class).invoke(obj, computeContentTypeHeader());
        } catch (Exception e) {
            throw new SnuggleRuntimeException(AbstractC0541b.m769k(obj, "Could not find and call setContentType() on Object "), e);
        }
    }

    public final void writeWebPage(List<FlowToken> list, Object obj, OutputStream outputStream, SnuggleSession.EndOutputAction endOutputAction) {
        if (obj != null) {
            setWebPageContentType(obj);
        }
        if (this.options.isHtml5()) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, this.options.getEncoding());
            outputStreamWriter.write(W3CConstants.HTML5_DOCTYPE_HEADER);
            outputStreamWriter.flush();
        }
        Document documentBuildWebPage = buildWebPage(list);
        try {
            try {
                createSerializer().transform(new DOMSource(documentBuildWebPage), new StreamResult(outputStream));
                if (endOutputAction == SnuggleSession.EndOutputAction.CLOSE) {
                    outputStream.close();
                } else if (endOutputAction == SnuggleSession.EndOutputAction.FLUSH) {
                    outputStream.flush();
                }
            } catch (TransformerException e) {
                throw new SnuggleRuntimeException("Could not serialize web page", e);
            }
        } catch (Throwable th) {
            if (endOutputAction == SnuggleSession.EndOutputAction.CLOSE) {
                outputStream.close();
            } else if (endOutputAction == SnuggleSession.EndOutputAction.FLUSH) {
                outputStream.flush();
            }
            throw th;
        }
    }

    private Element createXHTMLElement(Document document, String str, String str2) {
        if (this.options.isPrefixingXHTML()) {
            str = this.options.getXHTMLPrefix() + ":" + str;
        }
        Element elementCreateElementNS = document.createElementNS("http://www.w3.org/1999/xhtml", str);
        if (str2 != null) {
            elementCreateElementNS.appendChild(document.createTextNode(str2));
        }
        return elementCreateElementNS;
    }
}
