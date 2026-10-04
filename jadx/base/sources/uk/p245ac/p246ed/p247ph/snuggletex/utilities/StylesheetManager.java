package uk.p245ac.p246ed.p247ph.snuggletex.utilities;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import org.ccil.cowan.tagsoup.XMLWriter;
import uk.p245ac.p246ed.p247ph.snuggletex.SerializationMethod;
import uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleRuntimeException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.Globals;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ConstraintUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.StringUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.XMLUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class StylesheetManager {
    private StylesheetCache stylesheetCache;
    private TransformerFactoryChooser transformerFactoryChooser;

    public StylesheetManager() {
        this(DefaultTransformerFactoryChooser.getInstance(), null);
    }

    private Templates compileStylesheet(String str, boolean z) {
        TransformerFactory transformerFactory = getTransformerFactory(z);
        try {
            Source sourceResolve = transformerFactory.getURIResolver().resolve(str, "");
            if (sourceResolve != null) {
                return transformerFactory.newTemplates(sourceResolve);
            }
            throw new SnuggleRuntimeException("Not a ClassPath URI: " + str);
        } catch (TransformerConfigurationException e) {
            throw new SnuggleRuntimeException(AbstractC0541b.m772n("Could not compile internal stylesheet at ", str), e);
        } catch (TransformerException e2) {
            throw new SnuggleRuntimeException(AbstractC0541b.m772n("Could not resolve internal stylesheet location ", str), e2);
        }
    }

    private Templates compileStylesheetDriver(List<String> list, boolean z) {
        TransformerFactory transformerFactory = getTransformerFactory(z);
        StringBuilder sb = new StringBuilder("<stylesheet version='");
        sb.append(z ? "2.0" : "1.0");
        sb.append("' xmlns='http://www.w3.org/1999/XSL/Transform'>\n");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            AbstractC1974b.m1332y(sb, "<import href='", it.next(), "'/>\n");
        }
        sb.append("</stylesheet>");
        String string = sb.toString();
        try {
            return transformerFactory.newTemplates(new StreamSource(new StringReader(string)));
        } catch (TransformerConfigurationException e) {
            throw new SnuggleRuntimeException(AbstractC0541b.m772n("Could not compile stylesheet driver ", string), e);
        }
    }

    private void ensureChooserSpecified() {
        if (this.transformerFactoryChooser == null) {
            throw new SnuggleRuntimeException("No TransformerFactoryChooser set on this StylesheetManager");
        }
    }

    public Templates getCompiledStylesheet(String str) {
        return getCompiledStylesheet(str, false);
    }

    public Templates getCompiledStylesheetDriver(List<String> list, boolean z) {
        Templates stylesheet;
        if (this.stylesheetCache == null) {
            return compileStylesheetDriver(list, z);
        }
        String str = "xslt-driver(" + StringUtilities.join(list, ",") + ")";
        synchronized (this.stylesheetCache) {
            try {
                stylesheet = this.stylesheetCache.getStylesheet(str);
                if (stylesheet == null) {
                    stylesheet = compileStylesheetDriver(list, z);
                    this.stylesheetCache.putStylesheet(str, stylesheet);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return stylesheet;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Transformer getSerializer(String str, SerializationSpecifier serializationSpecifier) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(str);
        }
        boolean zSupportsXSLT20 = supportsXSLT20();
        if (serializationSpecifier == null) {
            z = false;
        } else {
            if (serializationSpecifier.getSerializationMethod() == SerializationMethod.HTML) {
                arrayList.add(Globals.STRIP_XHTML_NAMESPACE_XSL_RESOURCE_NAME);
            } else if (serializationSpecifier.getSerializationMethod() == SerializationMethod.STRICTLY_HTML) {
                arrayList.add(Globals.STRIP_ALL_NAMESPACES_XSL_RESOURCE_NAME);
            }
            if (serializationSpecifier.isUsingNamedEntities() && zSupportsXSLT20) {
                arrayList.add(Globals.MATHML_ENTITIES_MAP_XSL_RESOURCE_NAME);
                z = true;
            }
        }
        try {
            Transformer transformerNewTransformer = arrayList.isEmpty() ? getTransformerFactory(false).newTransformer() : arrayList.size() == 1 ? getCompiledStylesheet((String) arrayList.get(0), z).newTransformer() : getCompiledStylesheetDriver(arrayList, z).newTransformer();
            if (serializationSpecifier != null) {
                SerializationMethod serializationMethod = serializationSpecifier.getSerializationMethod();
                if (serializationMethod == SerializationMethod.XHTML && !zSupportsXSLT20) {
                    serializationMethod = SerializationMethod.XML;
                }
                transformerNewTransformer.setOutputProperty("method", serializationMethod.getName());
                transformerNewTransformer.setOutputProperty(XMLWriter.INDENT, StringUtilities.toYesNo(serializationSpecifier.isIndenting()));
                if (serializationSpecifier.isIndenting()) {
                    XMLUtilities.setIndentation(transformerNewTransformer, serializationSpecifier.getIndent());
                }
                transformerNewTransformer.setOutputProperty(XMLWriter.ENCODING, serializationSpecifier.getEncoding());
                transformerNewTransformer.setOutputProperty(XMLWriter.OMIT_XML_DECLARATION, StringUtilities.toYesNo(!serializationSpecifier.isIncludingXMLDeclaration()));
                if (serializationSpecifier.getDoctypePublic() != null) {
                    transformerNewTransformer.setOutputProperty(XMLWriter.DOCTYPE_PUBLIC, serializationSpecifier.getDoctypePublic());
                }
                if (serializationSpecifier.getDoctypeSystem() != null) {
                    transformerNewTransformer.setOutputProperty(XMLWriter.DOCTYPE_SYSTEM, serializationSpecifier.getDoctypeSystem());
                }
            }
            return transformerNewTransformer;
        } catch (TransformerConfigurationException e) {
            throw new SnuggleRuntimeException("Unexpected failure to create serializer", e);
        }
    }

    public StylesheetCache getStylesheetCache() {
        return this.stylesheetCache;
    }

    public TransformerFactory getTransformerFactory(boolean z) {
        ensureChooserSpecified();
        TransformerFactory suitableXSLT20TransformerFactory = z ? this.transformerFactoryChooser.getSuitableXSLT20TransformerFactory() : this.transformerFactoryChooser.getSuitableXSLT10TransformerFactory();
        suitableXSLT20TransformerFactory.setURIResolver(ClassPathURIResolver.getInstance());
        return suitableXSLT20TransformerFactory;
    }

    public TransformerFactoryChooser getTransformerFactoryChooser() {
        return this.transformerFactoryChooser;
    }

    public void setStylesheetCache(StylesheetCache stylesheetCache) {
        this.stylesheetCache = stylesheetCache;
    }

    public void setTransformerFactoryChooser(TransformerFactoryChooser transformerFactoryChooser) {
        ConstraintUtilities.ensureNotNull(transformerFactoryChooser, "transformerFactoryChooser");
        this.transformerFactoryChooser = transformerFactoryChooser;
    }

    public boolean supportsXSLT20() {
        ensureChooserSpecified();
        return this.transformerFactoryChooser.isXSLT20SupportAvailable();
    }

    public StylesheetManager(StylesheetCache stylesheetCache) {
        this(DefaultTransformerFactoryChooser.getInstance(), stylesheetCache);
    }

    public Templates getCompiledStylesheet(String str, boolean z) {
        Templates stylesheet;
        StylesheetCache stylesheetCache = this.stylesheetCache;
        if (stylesheetCache == null) {
            return compileStylesheet(str, z);
        }
        synchronized (stylesheetCache) {
            try {
                stylesheet = this.stylesheetCache.getStylesheet(str);
                if (stylesheet == null) {
                    stylesheet = compileStylesheet(str, z);
                    this.stylesheetCache.putStylesheet(str, stylesheet);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return stylesheet;
    }

    public StylesheetManager(TransformerFactoryChooser transformerFactoryChooser, StylesheetCache stylesheetCache) {
        ConstraintUtilities.ensureNotNull(transformerFactoryChooser, "transformerFactoryChooser");
        this.transformerFactoryChooser = transformerFactoryChooser;
        this.stylesheetCache = stylesheetCache;
    }
}
