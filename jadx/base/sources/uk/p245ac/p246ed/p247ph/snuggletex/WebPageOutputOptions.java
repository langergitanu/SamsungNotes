package uk.p245ac.p246ed.p247ph.snuggletex;

import javax.xml.transform.Transformer;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ConstraintUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class WebPageOutputOptions extends XMLStringOutputOptions {
    public static final String DEFAULT_CONTENT_TYPE = "application/xhtml+xml";
    public static final String DEFAULT_LANG = "en";

    @Deprecated
    private WebPageType webPageType = WebPageType.MOZILLA;
    private String contentType = "application/xhtml+xml";
    private String lang = "en";
    private String title = null;
    private boolean addingTitleHeading = false;
    private boolean addingMathPlayerImport = false;
    private String mathPrefRenderer = null;
    private boolean includingStyleElement = true;
    private String[] cssStylesheetURLs = null;
    private String[] clientSideXSLTStylesheetURLs = null;
    private Transformer[] stylesheets = null;
    private boolean html5 = false;
    private boolean noCharsetInContentTypeHeader = false;
    private boolean mathJax = false;
    private String customMathJaxUrl = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public enum WebPageType {
        MOZILLA,
        CROSS_BROWSER_XHTML,
        MATHPLAYER_HTML,
        UNIVERSAL_STYLESHEET,
        CLIENT_SIDE_XSLT_STYLESHEET,
        PROCESSED_HTML
    }

    public void addCSSStylesheetURLs(String... strArr) {
        this.cssStylesheetURLs = (String[]) ObjectUtilities.concat(this.cssStylesheetURLs, strArr, String.class);
    }

    public void addClientSideXSLTStylesheetURLs(String... strArr) {
        this.clientSideXSLTStylesheetURLs = (String[]) ObjectUtilities.concat(this.clientSideXSLTStylesheetURLs, strArr, String.class);
    }

    public void addStylesheets(Transformer... transformerArr) {
        this.stylesheets = (Transformer[]) ObjectUtilities.concat(this.stylesheets, transformerArr, Transformer.class);
    }

    public String[] getCSSStylesheetURLs() {
        return this.cssStylesheetURLs;
    }

    public String[] getClientSideXSLTStylesheetURLs() {
        return this.clientSideXSLTStylesheetURLs;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getCustomMathJaxUrl() {
        return this.customMathJaxUrl;
    }

    public String getLang() {
        return this.lang;
    }

    public String getMathPrefRenderer() {
        return this.mathPrefRenderer;
    }

    public Transformer[] getStylesheets() {
        return this.stylesheets;
    }

    public String getTitle() {
        return this.title;
    }

    @Deprecated
    public WebPageType getWebPageType() {
        return WebPageType.MOZILLA;
    }

    public boolean isAddingMathPlayerImport() {
        return this.addingMathPlayerImport;
    }

    public boolean isAddingTitleHeading() {
        return this.addingTitleHeading;
    }

    public boolean isHtml5() {
        return this.html5;
    }

    public boolean isIncludingStyleElement() {
        return this.includingStyleElement;
    }

    public boolean isMathJax() {
        return this.mathJax;
    }

    public boolean isNoCharsetInContentTypeHeader() {
        return this.noCharsetInContentTypeHeader;
    }

    public void setAddingMathPlayerImport(boolean z) {
        this.addingMathPlayerImport = z;
    }

    public void setAddingTitleHeading(boolean z) {
        this.addingTitleHeading = z;
    }

    public void setCSSStylesheetURLs(String... strArr) {
        this.cssStylesheetURLs = strArr;
    }

    public void setClientSideXSLTStylesheetURLs(String... strArr) {
        this.clientSideXSLTStylesheetURLs = strArr;
    }

    public void setContentType(String str) {
        ConstraintUtilities.ensureNotNull(str, "contentType");
        this.contentType = str;
    }

    public void setCustomMathJaxUrl(String str) {
        this.customMathJaxUrl = str;
    }

    public void setHtml5(boolean z) {
        this.html5 = z;
    }

    public void setIncludingStyleElement(boolean z) {
        this.includingStyleElement = z;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setMathJax(boolean z) {
        this.mathJax = z;
    }

    public void setMathPrefRenderer(String str) {
        this.mathPrefRenderer = str;
    }

    public void setNoCharsetInContentTypeHeader(boolean z) {
        this.noCharsetInContentTypeHeader = z;
    }

    public void setStylesheets(Transformer... transformerArr) {
        this.stylesheets = transformerArr;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Deprecated
    public void setWebPageType(WebPageType webPageType) {
        ConstraintUtilities.ensureNotNull(webPageType, "webPageType");
        this.webPageType = webPageType;
    }
}
