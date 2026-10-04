package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.xmlbeans.ResourceLoader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PathResourceLoader implements ResourceLoader {
    private ResourceLoader[] _path;

    public PathResourceLoader(ResourceLoader[] resourceLoaderArr) {
        ResourceLoader[] resourceLoaderArr2 = new ResourceLoader[resourceLoaderArr.length];
        this._path = resourceLoaderArr2;
        System.arraycopy(resourceLoaderArr, 0, resourceLoaderArr2, 0, resourceLoaderArr2.length);
    }

    @Override // org.apache.xmlbeans.ResourceLoader
    public void close() {
        int i = 0;
        while (true) {
            ResourceLoader[] resourceLoaderArr = this._path;
            if (i >= resourceLoaderArr.length) {
                return;
            }
            try {
                resourceLoaderArr[i].close();
            } catch (Exception unused) {
            }
            i++;
        }
    }

    @Override // org.apache.xmlbeans.ResourceLoader
    public InputStream getResourceAsStream(String str) {
        int i = 0;
        while (true) {
            ResourceLoader[] resourceLoaderArr = this._path;
            if (i >= resourceLoaderArr.length) {
                return null;
            }
            InputStream resourceAsStream = resourceLoaderArr[i].getResourceAsStream(str);
            if (resourceAsStream != null) {
                return resourceAsStream;
            }
            i++;
        }
    }

    public PathResourceLoader(File[] fileArr) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            try {
                arrayList.add(new FileResourceLoader(file));
            } catch (IOException unused) {
            }
        }
        this._path = (ResourceLoader[]) arrayList.toArray(new ResourceLoader[arrayList.size()]);
    }
}
