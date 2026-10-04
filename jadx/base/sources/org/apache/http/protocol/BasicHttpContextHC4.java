package org.apache.http.protocol;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.util.Args;
import org.apache.poi.openxml4j.opc.PackageRelationship;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@ThreadSafe
public class BasicHttpContextHC4 implements HttpContext {
    private final Map<String, Object> map;
    private final HttpContext parentContext;

    public BasicHttpContextHC4() {
        this(null);
    }

    public void clear() {
        this.map.clear();
    }

    @Override // org.apache.http.protocol.HttpContext
    public Object getAttribute(String str) {
        HttpContext httpContext;
        Args.notNull(str, PackageRelationship.ID_ATTRIBUTE_NAME);
        Object obj = this.map.get(str);
        return (obj != null || (httpContext = this.parentContext) == null) ? obj : httpContext.getAttribute(str);
    }

    @Override // org.apache.http.protocol.HttpContext
    public Object removeAttribute(String str) {
        Args.notNull(str, PackageRelationship.ID_ATTRIBUTE_NAME);
        return this.map.remove(str);
    }

    @Override // org.apache.http.protocol.HttpContext
    public void setAttribute(String str, Object obj) {
        Args.notNull(str, PackageRelationship.ID_ATTRIBUTE_NAME);
        if (obj != null) {
            this.map.put(str, obj);
        } else {
            this.map.remove(str);
        }
    }

    public String toString() {
        return this.map.toString();
    }

    public BasicHttpContextHC4(HttpContext httpContext) {
        this.map = new ConcurrentHashMap();
        this.parentContext = httpContext;
    }
}
