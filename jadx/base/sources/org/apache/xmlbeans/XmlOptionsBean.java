package org.apache.xmlbeans;

import java.util.Map;
import java.util.Set;
import org.apache.poi.javax.xml.namespace.QName;
import org.xml.sax.EntityResolver;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XmlOptionsBean extends XmlOptions {
    public XmlOptionsBean() {
    }

    public String getCharacterEncoding() {
        return (String) get(XmlOptions.CHARACTER_ENCODING);
    }

    public Set getCompileMdefNamespaces() {
        return (Set) get(XmlOptions.COMPILE_MDEF_NAMESPACES);
    }

    public Map getCompileSubstituteNames() {
        return (Map) get(XmlOptions.COMPILE_SUBSTITUTE_NAMES);
    }

    public String getDocumentSourceName() {
        return (String) get(XmlOptions.DOCUMENT_SOURCE_NAME);
    }

    public SchemaType getDocumentType() {
        return (SchemaType) get(XmlOptions.DOCUMENT_TYPE);
    }

    public EntityResolver getEntityResolver() {
        return (EntityResolver) get(XmlOptions.ENTITY_RESOLVER);
    }

    public String getGenerateJavaVersion() {
        return (String) get(XmlOptions.GENERATE_JAVA_VERSION);
    }

    public Map getLoadAdditionalNamespaces() {
        return (Map) get(XmlOptions.LOAD_ADDITIONAL_NAMESPACES);
    }

    public QName getLoadReplaceDocumentElement() {
        return (QName) get(XmlOptions.LOAD_REPLACE_DOCUMENT_ELEMENT);
    }

    public Map getLoadSubstituteNamespaces() {
        return (Map) get(XmlOptions.LOAD_SUBSTITUTE_NAMESPACES);
    }

    public Integer getSaveCDataEntityCountThreshold() {
        return (Integer) get(XmlOptions.SAVE_CDATA_ENTITY_COUNT_THRESHOLD);
    }

    public Integer getSaveCDataLengthThreshold() {
        return (Integer) get(XmlOptions.SAVE_CDATA_LENGTH_THRESHOLD);
    }

    public String getSaveFilterProcinst() {
        return (String) get(XmlOptions.SAVE_FILTER_PROCINST);
    }

    public Map getSaveImplicitNamespaces() {
        return (Map) get(XmlOptions.SAVE_IMPLICIT_NAMESPACES);
    }

    public Integer getSavePrettyPrintIndent() {
        return (Integer) get(XmlOptions.SAVE_PRETTY_PRINT_INDENT);
    }

    public Integer getSavePrettyPrintOffset() {
        return (Integer) get(XmlOptions.SAVE_PRETTY_PRINT_OFFSET);
    }

    public XmlOptionCharEscapeMap getSaveSubstituteCharacters() {
        return (XmlOptionCharEscapeMap) get(XmlOptions.SAVE_SUBSTITUTE_CHARACTERS);
    }

    public Map getSaveSuggestedPrefixes() {
        return (Map) get(XmlOptions.SAVE_SUGGESTED_PREFIXES);
    }

    public QName getSaveSyntheticDocumentElement() {
        return (QName) get(XmlOptions.SAVE_SYNTHETIC_DOCUMENT_ELEMENT);
    }

    public String getXqueryCurrentNodeVar() {
        return (String) get(XmlOptions.XQUERY_CURRENT_NODE_VAR);
    }

    public Map getXqueryVariables() {
        return (Map) get(XmlOptions.XQUERY_VARIABLE_MAP);
    }

    public boolean isCompileDownloadUrls() {
        return hasOption(XmlOptions.COMPILE_DOWNLOAD_URLS);
    }

    public boolean isCompileNoAnnotations() {
        return hasOption(XmlOptions.COMPILE_NO_ANNOTATIONS);
    }

    public boolean isCompileNoPvrRule() {
        return hasOption(XmlOptions.COMPILE_NO_PVR_RULE);
    }

    public boolean isCompileNoUpaRule() {
        return hasOption(XmlOptions.COMPILE_NO_UPA_RULE);
    }

    public boolean isLoadLineNumbers() {
        return hasOption(XmlOptions.LOAD_LINE_NUMBERS);
    }

    public boolean isLoadMessageDigest() {
        return hasOption(XmlOptions.LOAD_MESSAGE_DIGEST);
    }

    public boolean isLoadStripComments() {
        return hasOption(XmlOptions.LOAD_STRIP_COMMENTS);
    }

    public boolean isLoadStripProcinsts() {
        return hasOption(XmlOptions.LOAD_STRIP_PROCINSTS);
    }

    public boolean isLoadTrimTextBuffer() {
        return hasOption(XmlOptions.LOAD_TRIM_TEXT_BUFFER);
    }

    public boolean isLoadUseDefaultResolver() {
        return hasOption(XmlOptions.LOAD_USE_DEFAULT_RESOLVER);
    }

    public boolean isSaveAggressiveNamespaces() {
        return hasOption(XmlOptions.SAVE_AGGRESSIVE_NAMESPACES);
    }

    public boolean isSaveInner() {
        return hasOption(XmlOptions.SAVE_INNER);
    }

    public boolean isSaveNamespacesFirst() {
        return hasOption(XmlOptions.SAVE_NAMESPACES_FIRST);
    }

    public boolean isSaveNoXmlDecl() {
        return hasOption(XmlOptions.SAVE_NO_XML_DECL);
    }

    public boolean isSaveOuter() {
        return hasOption(XmlOptions.SAVE_OUTER);
    }

    public boolean isSavePrettyPrint() {
        return hasOption(XmlOptions.SAVE_PRETTY_PRINT);
    }

    public boolean isSaveSaxNoNSDeclsInAttributes() {
        return hasOption(XmlOptions.SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES);
    }

    public boolean isSaveUseOpenFrag() {
        return hasOption(XmlOptions.SAVE_USE_OPEN_FRAGMENT);
    }

    public boolean isSetLoadStripWhitespace() {
        return hasOption(XmlOptions.LOAD_STRIP_WHITESPACE);
    }

    public boolean isUnsynchronized() {
        return hasOption(XmlOptions.UNSYNCHRONIZED);
    }

    public boolean isUseDefaultNamespace() {
        return hasOption(XmlOptions.SAVE_USE_DEFAULT_NAMESPACE);
    }

    public boolean isValidateOnSet() {
        return hasOption(XmlOptions.VALIDATE_ON_SET);
    }

    public boolean isValidateStrict() {
        return hasOption(XmlOptions.VALIDATE_STRICT);
    }

    public boolean isValidateTreatLaxAsSkip() {
        return hasOption(XmlOptions.VALIDATE_TREAT_LAX_AS_SKIP);
    }

    public void setCompileDownloadUrls(boolean z) {
        if (z) {
            super.setCompileDownloadUrls();
        } else {
            remove(XmlOptions.COMPILE_DOWNLOAD_URLS);
        }
    }

    public void setCompileNoAnnotations(boolean z) {
        if (z) {
            super.setCompileNoAnnotations();
        } else {
            remove(XmlOptions.COMPILE_NO_ANNOTATIONS);
        }
    }

    public void setCompileNoPvrRule(boolean z) {
        if (z) {
            super.setCompileNoPvrRule();
        } else {
            remove(XmlOptions.COMPILE_NO_PVR_RULE);
        }
    }

    public void setCompileNoUpaRule(boolean z) {
        if (z) {
            super.setCompileNoUpaRule();
        } else {
            remove(XmlOptions.COMPILE_NO_UPA_RULE);
        }
    }

    public void setLoadLineNumbers(boolean z) {
        if (z) {
            super.setLoadLineNumbers();
        } else {
            remove(XmlOptions.LOAD_LINE_NUMBERS);
        }
    }

    public void setLoadMessageDigest(boolean z) {
        if (z) {
            super.setLoadMessageDigest();
        } else {
            remove(XmlOptions.LOAD_MESSAGE_DIGEST);
        }
    }

    public void setLoadStripComments(boolean z) {
        if (z) {
            super.setLoadStripComments();
        } else {
            remove(XmlOptions.LOAD_STRIP_COMMENTS);
        }
    }

    public void setLoadStripProcinsts(boolean z) {
        if (z) {
            super.setLoadStripProcinsts();
        } else {
            remove(XmlOptions.LOAD_STRIP_PROCINSTS);
        }
    }

    public void setLoadStripWhitespace(boolean z) {
        if (z) {
            super.setLoadStripWhitespace();
        } else {
            remove(XmlOptions.LOAD_STRIP_WHITESPACE);
        }
    }

    public void setLoadTrimTextBuffer(boolean z) {
        if (z) {
            super.setLoadTrimTextBuffer();
        } else {
            remove(XmlOptions.LOAD_TRIM_TEXT_BUFFER);
        }
    }

    public void setLoadUseDefaultResolver(boolean z) {
        if (z) {
            super.setLoadUseDefaultResolver();
        } else {
            remove(XmlOptions.LOAD_USE_DEFAULT_RESOLVER);
        }
    }

    public void setSaveAggressiveNamespaces(boolean z) {
        if (z) {
            super.setSaveAggressiveNamespaces();
        } else {
            remove(XmlOptions.SAVE_AGGRESSIVE_NAMESPACES);
        }
    }

    public void setSaveInner(boolean z) {
        if (z) {
            super.setSaveInner();
        } else {
            remove(XmlOptions.SAVE_INNER);
        }
    }

    public void setSaveNamespacesFirst(boolean z) {
        if (z) {
            super.setSaveNamespacesFirst();
        } else {
            remove(XmlOptions.SAVE_NAMESPACES_FIRST);
        }
    }

    public void setSaveNoXmlDecl(boolean z) {
        if (z) {
            super.setSaveNoXmlDecl();
        } else {
            remove(XmlOptions.SAVE_NO_XML_DECL);
        }
    }

    public void setSaveOuter(boolean z) {
        if (z) {
            super.setSaveOuter();
        } else {
            remove(XmlOptions.SAVE_OUTER);
        }
    }

    public void setSavePrettyPrint(boolean z) {
        if (z) {
            super.setSavePrettyPrint();
        } else {
            remove(XmlOptions.SAVE_PRETTY_PRINT);
        }
    }

    public void setSaveSaxNoNSDeclsInAttributes(boolean z) {
        if (z) {
            super.setSaveSaxNoNSDeclsInAttributes();
        } else {
            remove(XmlOptions.SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES);
        }
    }

    public void setSaveUseOpenFrag(boolean z) {
        if (z) {
            super.setSaveUseOpenFrag();
        } else {
            remove(XmlOptions.SAVE_USE_OPEN_FRAGMENT);
        }
    }

    public void setUnsynchronized(boolean z) {
        if (z) {
            super.setUnsynchronized();
        } else {
            remove(XmlOptions.UNSYNCHRONIZED);
        }
    }

    public void setUseDefaultNamespace(boolean z) {
        if (z) {
            super.setUseDefaultNamespace();
        } else {
            remove(XmlOptions.SAVE_USE_DEFAULT_NAMESPACE);
        }
    }

    public void setValidateOnSet(boolean z) {
        if (z) {
            super.setValidateOnSet();
        } else {
            remove(XmlOptions.VALIDATE_ON_SET);
        }
    }

    public void setValidateStrict(boolean z) {
        if (z) {
            super.setValidateStrict();
        } else {
            remove(XmlOptions.VALIDATE_STRICT);
        }
    }

    public void setValidateTreatLaxAsSkip(boolean z) {
        if (z) {
            super.setValidateTreatLaxAsSkip();
        } else {
            remove(XmlOptions.VALIDATE_TREAT_LAX_AS_SKIP);
        }
    }

    public XmlOptionsBean(XmlOptions xmlOptions) {
        super(xmlOptions);
    }
}
