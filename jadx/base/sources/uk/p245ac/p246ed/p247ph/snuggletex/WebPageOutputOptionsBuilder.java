package uk.p245ac.p246ed.p247ph.snuggletex;

import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import uk.p245ac.p246ed.p247ph.snuggletex.DOMOutputOptions;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.W3CConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class WebPageOutputOptionsBuilder {
    public static final WebPageOutputOptions createHTML4Options() {
        WebPageOutputOptions webPageOutputOptions = new WebPageOutputOptions();
        webPageOutputOptions.setSerializationMethod(SerializationMethod.HTML);
        return webPageOutputOptions;
    }

    public static final WebPageOutputOptions createHTML5MathJaxOptions() {
        WebPageOutputOptions webPageOutputOptionsCreateHTML5Options = createHTML5Options();
        webPageOutputOptionsCreateHTML5Options.setMathJax(true);
        return webPageOutputOptionsCreateHTML5Options;
    }

    public static final WebPageOutputOptions createHTML5Options() {
        WebPageOutputOptions webPageOutputOptions = new WebPageOutputOptions();
        webPageOutputOptions.setSerializationMethod(SerializationMethod.STRICTLY_HTML);
        webPageOutputOptions.setErrorOutputOptions(DOMOutputOptions.ErrorOutputOptions.XHTML);
        webPageOutputOptions.setHtml5(true);
        return webPageOutputOptions;
    }

    public static final WebPageOutputOptions createIEMathPlayerSpecificOptions() {
        WebPageOutputOptions webPageOutputOptions = new WebPageOutputOptions();
        webPageOutputOptions.setSerializationMethod(SerializationMethod.HTML);
        webPageOutputOptions.setContentType(Constants.MIME_HTML);
        webPageOutputOptions.setPrefixingMathML(true);
        webPageOutputOptions.setAddingMathPlayerImport(true);
        return webPageOutputOptions;
    }

    public static final WebPageOutputOptions createLegacyCrossBrowserOptions() {
        WebPageOutputOptions webPageOutputOptions = new WebPageOutputOptions();
        webPageOutputOptions.setMathJax(false);
        webPageOutputOptions.setSerializationMethod(SerializationMethod.XHTML);
        webPageOutputOptions.setIncludingXMLDeclaration(true);
        webPageOutputOptions.setContentType("application/xhtml+xml");
        webPageOutputOptions.setNoCharsetInContentTypeHeader(true);
        webPageOutputOptions.setXHTMLPrefix("");
        webPageOutputOptions.setMathMLPrefix("");
        webPageOutputOptions.setDoctypePublic(W3CConstants.XHTML_11_MATHML_20_PUBLIC_IDENTIFIER);
        webPageOutputOptions.setDoctypeSystem(W3CConstants.XHTML_11_MATHML_20_SYSTEM_IDENTIFIER);
        return webPageOutputOptions;
    }

    public static final WebPageOutputOptions createMozillaSpecificOptions() {
        WebPageOutputOptions webPageOutputOptions = new WebPageOutputOptions();
        webPageOutputOptions.setMathJax(false);
        webPageOutputOptions.setSerializationMethod(SerializationMethod.XHTML);
        webPageOutputOptions.setIncludingXMLDeclaration(false);
        webPageOutputOptions.setContentType("application/xhtml+xml");
        return webPageOutputOptions;
    }

    public static final WebPageOutputOptions createUniversalStylesheetOptions(String str) {
        return createUniversalStylesheetOptions(str, "mathplayer-dl");
    }

    public static final WebPageOutputOptions createXHTMLMathJaxOptions() {
        WebPageOutputOptions webPageOutputOptions = new WebPageOutputOptions();
        webPageOutputOptions.setSerializationMethod(SerializationMethod.XHTML);
        webPageOutputOptions.setIncludingXMLDeclaration(false);
        webPageOutputOptions.setMathJax(true);
        return webPageOutputOptions;
    }

    public static final WebPageOutputOptions createXHTMLOptions() {
        WebPageOutputOptions webPageOutputOptions = new WebPageOutputOptions();
        webPageOutputOptions.setSerializationMethod(SerializationMethod.XHTML);
        return webPageOutputOptions;
    }

    public static final WebPageOutputOptions createUniversalStylesheetOptions(String str, String str2) {
        WebPageOutputOptions webPageOutputOptions = new WebPageOutputOptions();
        webPageOutputOptions.setSerializationMethod(SerializationMethod.XML);
        webPageOutputOptions.setIncludingXMLDeclaration(true);
        webPageOutputOptions.setMathPrefRenderer(str2);
        webPageOutputOptions.setClientSideXSLTStylesheetURLs(str);
        return webPageOutputOptions;
    }

    public static final WebPageOutputOptions createHTML5MathJaxOptions(String str) {
        WebPageOutputOptions webPageOutputOptionsCreateHTML5MathJaxOptions = createHTML5MathJaxOptions();
        webPageOutputOptionsCreateHTML5MathJaxOptions.setCustomMathJaxUrl(str);
        return webPageOutputOptionsCreateHTML5MathJaxOptions;
    }

    public static final WebPageOutputOptions createXHTMLMathJaxOptions(String str) {
        WebPageOutputOptions webPageOutputOptionsCreateXHTMLMathJaxOptions = createXHTMLMathJaxOptions();
        webPageOutputOptionsCreateXHTMLMathJaxOptions.setCustomMathJaxUrl(str);
        return webPageOutputOptionsCreateXHTMLMathJaxOptions;
    }
}
