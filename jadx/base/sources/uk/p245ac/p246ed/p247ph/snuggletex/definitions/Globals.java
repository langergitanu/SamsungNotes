package uk.p245ac.p246ed.p247ph.snuggletex.definitions;

import java.util.EnumSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class Globals {
    public static final EnumSet<LaTeXMode> ALL_MODES;
    public static final String CSS_PROPERTIES_DOCUMENT_URN = "urn:snuggletex-css-properties";
    public static final String CSS_PROPERTIES_NAME = "uk/ac/ed/ph/snuggletex/css.properties";
    public static final String EXTRACT_CHILD_NODES_XSL_RESOURCE_NAME = "classpath:/uk/ac/ed/ph/snuggletex/extract-child-nodes.xsl";
    public static final String GENERAL_MESSAGES_PROPERTIES_BASENAME = "uk/ac/ed/ph/snuggletex/general-messages";
    public static final String MATHML_ENTITIES_MAP_XSL_RESOURCE_NAME = "classpath:/uk/ac/ed/ph/snuggletex/mathml-entities-map.xsl";

    @Deprecated
    public static final String MATHML_NAMESPACE = "http://www.w3.org/1998/Math/MathML";

    @Deprecated
    public static final String MATHML_PREF_NAMESPACE = "http://www.w3.org/2002/Math/preference";
    public static final String MATHML_TO_XHTML_XSL_RESOURCE_NAME = "classpath:/uk/ac/ed/ph/snuggletex/mathml-to-xhtml.xsl";
    public static final EnumSet<LaTeXMode> MATH_MODE_ONLY;
    public static final EnumSet<LaTeXMode> PARA_MODE_ONLY;
    public static final String STRIP_ALL_NAMESPACES_XSL_RESOURCE_NAME = "classpath:/uk/ac/ed/ph/snuggletex/strip-all-namespaces.xsl";
    public static final String STRIP_XHTML_NAMESPACE_XSL_RESOURCE_NAME = "classpath:/uk/ac/ed/ph/snuggletex/strip-xhtml-namespace.xsl";
    public static final EnumSet<LaTeXMode> TEXT_MODE_ONLY;

    @Deprecated
    public static final String XHTML_NAMESPACE = "http://www.w3.org/1999/xhtml";

    @Deprecated
    public static final String XMLNS_NAMESPACE = "http://www.w3.org/2000/xmlns/";

    @Deprecated
    public static final String XML_NAMESPACE = "http://www.w3.org/XML/1998/namespace";

    static {
        LaTeXMode laTeXMode = LaTeXMode.MATH;
        MATH_MODE_ONLY = EnumSet.of(laTeXMode);
        LaTeXMode laTeXMode2 = LaTeXMode.PARAGRAPH;
        PARA_MODE_ONLY = EnumSet.of(laTeXMode2);
        LaTeXMode laTeXMode3 = LaTeXMode.LR;
        TEXT_MODE_ONLY = EnumSet.of(laTeXMode2, laTeXMode3);
        ALL_MODES = EnumSet.of(laTeXMode2, laTeXMode, laTeXMode3);
    }
}
