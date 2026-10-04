package uk.p245ac.p246ed.p247ph.snuggletex;

import java.util.Properties;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.XMLUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class DOMOutputOptions implements Cloneable {
    public static final String DEFAULT_MATHML_PREFIX = "m";
    public static final String DEFAULT_SNUGGLETEX_XML_PREFIX = "s";
    public static final String DEFAULT_XHTML_PREFIX = "h";
    private ErrorOutputOptions errorOutputOptions = ErrorOutputOptions.NO_OUTPUT;
    private DOMPostProcessor[] domPostProcessors = null;
    private boolean inliningCSS = false;
    private Properties inlineCSSProperties = null;
    private boolean prefixingXHTML = false;
    private boolean prefixingMathML = false;
    private boolean prefixingSnuggleXML = false;
    private String xhtmlPrefix = "h";
    private String mathMLPrefix = "m";
    private String snuggleXMLPrefix = "s";
    private boolean addingMathSourceAnnotations = false;
    private boolean applyingFirefox3SemanticsWorkaround = false;
    private boolean mathVariantMapping = false;
    private LinkResolver linkResolver = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ErrorOutputOptions {
        NO_OUTPUT,
        XML_SHORT,
        XML_FULL,
        XHTML
    }

    public void addDOMPostProcessors(DOMPostProcessor... dOMPostProcessorArr) {
        this.domPostProcessors = (DOMPostProcessor[]) ObjectUtilities.concat(this.domPostProcessors, dOMPostProcessorArr, DOMPostProcessor.class);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new SnuggleLogicException(e);
        }
    }

    public DOMPostProcessor[] getDOMPostProcessors() {
        return this.domPostProcessors;
    }

    public ErrorOutputOptions getErrorOutputOptions() {
        return this.errorOutputOptions;
    }

    public Properties getInlineCSSProperties() {
        return this.inlineCSSProperties;
    }

    public LinkResolver getLinkResolver() {
        return this.linkResolver;
    }

    public String getMathMLPrefix() {
        return this.mathMLPrefix;
    }

    public String getSnuggleXMLPrefix() {
        return this.snuggleXMLPrefix;
    }

    public String getXHTMLPrefix() {
        return this.xhtmlPrefix;
    }

    @Deprecated
    public boolean isAddingMathAnnotations() {
        return isAddingMathSourceAnnotations();
    }

    public boolean isAddingMathSourceAnnotations() {
        return this.addingMathSourceAnnotations;
    }

    public boolean isApplyingFirefox3SemanticsWorkaround() {
        return this.applyingFirefox3SemanticsWorkaround;
    }

    public boolean isInliningCSS() {
        return this.inliningCSS;
    }

    public boolean isMathVariantMapping() {
        return this.mathVariantMapping;
    }

    public boolean isPrefixingMathML() {
        return this.prefixingMathML;
    }

    public boolean isPrefixingSnuggleXML() {
        return this.prefixingSnuggleXML;
    }

    public boolean isPrefixingXHTML() {
        return this.prefixingXHTML;
    }

    @Deprecated
    public void setAddingMathAnnotations(boolean z) {
        setAddingMathSourceAnnotations(z);
    }

    public void setAddingMathSourceAnnotations(boolean z) {
        this.addingMathSourceAnnotations = z;
    }

    public void setApplyingFirefox3SemanticsWorkaround(boolean z) {
        this.applyingFirefox3SemanticsWorkaround = z;
    }

    public void setDOMPostProcessors(DOMPostProcessor... dOMPostProcessorArr) {
        this.domPostProcessors = dOMPostProcessorArr;
    }

    public void setErrorOutputOptions(ErrorOutputOptions errorOutputOptions) {
        if (errorOutputOptions == null) {
            throw new IllegalArgumentException("ErrorOutputOptions must not be null");
        }
        this.errorOutputOptions = errorOutputOptions;
    }

    public void setInlineCSSProperties(Properties properties) {
        this.inlineCSSProperties = properties;
    }

    public void setInliningCSS(boolean z) {
        this.inliningCSS = z;
    }

    public void setLinkResolver(LinkResolver linkResolver) {
        this.linkResolver = linkResolver;
    }

    public void setMathMLPrefix(String str) {
        if (!XMLUtilities.isXMLNCName(str)) {
            throw new IllegalArgumentException("MathML prefix must be a valid NCName");
        }
        this.mathMLPrefix = str;
    }

    public void setMathVariantMapping(boolean z) {
        this.mathVariantMapping = z;
    }

    public void setPrefixingMathML(boolean z) {
        this.prefixingMathML = z;
    }

    public void setPrefixingSnuggleXML(boolean z) {
        this.prefixingSnuggleXML = z;
    }

    public void setPrefixingXHTML(boolean z) {
        this.prefixingXHTML = z;
    }

    public void setSnuggleXMLPrefix(String str) {
        if (!XMLUtilities.isXMLNCName(str)) {
            throw new IllegalArgumentException("SnuggleTeX XML prefix must be a valid NCName");
        }
        this.snuggleXMLPrefix = str;
    }

    public void setXHTMLPrefix(String str) {
        if (!XMLUtilities.isXMLNCName(str)) {
            throw new IllegalArgumentException("XHTML prefix must be a valid NCName");
        }
        this.xhtmlPrefix = str;
    }
}
