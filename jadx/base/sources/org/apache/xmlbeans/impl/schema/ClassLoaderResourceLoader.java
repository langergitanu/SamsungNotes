package org.apache.xmlbeans.impl.schema;

import java.io.InputStream;
import org.apache.xmlbeans.ResourceLoader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ClassLoaderResourceLoader implements ResourceLoader {
    ClassLoader _classLoader;

    public ClassLoaderResourceLoader(ClassLoader classLoader) {
        this._classLoader = classLoader;
    }

    @Override // org.apache.xmlbeans.ResourceLoader
    public InputStream getResourceAsStream(String str) {
        return this._classLoader.getResourceAsStream(str);
    }

    @Override // org.apache.xmlbeans.ResourceLoader
    public void close() {
    }
}
