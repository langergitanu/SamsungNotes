package uk.p245ac.p246ed.p247ph.snuggletex.utilities;

import java.util.Map;
import java.util.Properties;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.URIResolver;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import uk.p245ac.p246ed.p247ph.snuggletex.DOMOutputOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleConstants;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleRuntimeException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.Globals;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.XMLUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MathMLDownConverter {
    private final Properties cssProperties;
    private final StylesheetManager stylesheetManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CSSPropertiesURIResolver implements URIResolver {
        private final Source cssPropertiesSource;

        public CSSPropertiesURIResolver(Document document) {
            this.cssPropertiesSource = new DOMSource(document, Globals.CSS_PROPERTIES_DOCUMENT_URN);
        }

        @Override // javax.xml.transform.URIResolver
        public Source resolve(String str, String str2) {
            if (str.equals(Globals.CSS_PROPERTIES_DOCUMENT_URN)) {
                return this.cssPropertiesSource;
            }
            return null;
        }
    }

    public MathMLDownConverter() {
        this((StylesheetManager) null, (Properties) null);
    }

    public void buildCSSPropertiesDocument(Document document, Properties properties) {
        Element elementCreateElementNS = document.createElementNS(SnuggleConstants.SNUGGLETEX_NAMESPACE, StringLookupFactory.KEY_PROPERTIES);
        document.appendChild(elementCreateElementNS);
        for (Map.Entry entry : properties.entrySet()) {
            Element elementCreateElementNS2 = document.createElementNS(SnuggleConstants.SNUGGLETEX_NAMESPACE, "property");
            elementCreateElementNS2.setAttribute("name", (String) entry.getKey());
            elementCreateElementNS2.setAttribute("value", (String) entry.getValue());
            elementCreateElementNS.appendChild(elementCreateElementNS2);
        }
    }

    public Document downConvertDOM(Document document) {
        Document documentNewDocument = XMLUtilities.createNSAwareDocumentBuilder().newDocument();
        Properties properties = this.cssProperties;
        if (properties != null) {
            buildCSSPropertiesDocument(documentNewDocument, properties);
        }
        CSSPropertiesURIResolver cSSPropertiesURIResolver = new CSSPropertiesURIResolver(documentNewDocument);
        Templates compiledStylesheet = this.stylesheetManager.getCompiledStylesheet(Globals.MATHML_TO_XHTML_XSL_RESOURCE_NAME);
        Document documentNewDocument2 = XMLUtilities.createNSAwareDocumentBuilder().newDocument();
        try {
            Transformer transformerNewTransformer = compiledStylesheet.newTransformer();
            transformerNewTransformer.setURIResolver(cSSPropertiesURIResolver);
            transformerNewTransformer.transform(new DOMSource(document), new DOMResult(documentNewDocument2));
            return documentNewDocument2;
        } catch (Exception e) {
            throw new SnuggleRuntimeException("Unexpected Exception down-converting DOM", e);
        }
    }

    public MathMLDownConverter(Properties properties) {
        this((StylesheetManager) null, properties);
    }

    public MathMLDownConverter(StylesheetCache stylesheetCache) {
        this(new StylesheetManager(stylesheetCache), (Properties) null);
    }

    public MathMLDownConverter(StylesheetManager stylesheetManager, DOMOutputOptions dOMOutputOptions) {
        this(stylesheetManager, (dOMOutputOptions == null || !dOMOutputOptions.isInliningCSS()) ? null : CSSUtilities.readInlineCSSProperties(dOMOutputOptions));
    }

    public MathMLDownConverter(StylesheetManager stylesheetManager, Properties properties) {
        this.stylesheetManager = stylesheetManager == null ? new StylesheetManager() : stylesheetManager;
        this.cssProperties = properties;
    }
}
