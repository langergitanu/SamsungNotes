package uk.p245ac.p246ed.p247ph.snuggletex.utilities;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class ClassPathURIResolver implements URIResolver {
    public static final String URI_SCHEME = "classpath";
    private static final ClassPathURIResolver singletonInstance = new ClassPathURIResolver();

    private ClassPathURIResolver() {
    }

    public static ClassPathURIResolver getInstance() {
        return singletonInstance;
    }

    @Override // javax.xml.transform.URIResolver
    public Source resolve(String str, String str2) throws TransformerException {
        if (str.equals("")) {
            return null;
        }
        try {
            URI uriResolve = new URI(str2).resolve(str);
            if (!URI_SCHEME.equals(uriResolve.getScheme())) {
                return null;
            }
            String strSubstring = uriResolve.getPath().substring(1);
            InputStream resourceAsStream = ClassPathURIResolver.class.getClassLoader().getResourceAsStream(strSubstring);
            if (resourceAsStream != null) {
                return new StreamSource(resourceAsStream, uriResolve.toString());
            }
            throw new TransformerException(AbstractC0541b.m773o("Could not load resource at ", strSubstring, " via ClassLoader"));
        } catch (URISyntaxException e) {
            throw new TransformerException(AbstractC0541b.m773o("Could not convert base=", str2, " into a URI"), e);
        }
    }
}
