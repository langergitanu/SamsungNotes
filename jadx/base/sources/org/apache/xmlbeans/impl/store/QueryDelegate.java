package org.apache.xmlbeans.impl.store;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.AbstractC12991c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class QueryDelegate {
    private static HashMap _constructors = new HashMap();
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$java$lang$String;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface QueryInterface {
        List execQuery(Object obj, Map map);
    }

    private QueryDelegate() {
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static synchronized QueryInterface createInstance(String str, String str2, String str3, int i) {
        try {
            if (_constructors.get(str) == null) {
                init(str);
            }
            if (_constructors.get(str) == null) {
                return null;
            }
            try {
                return (QueryInterface) ((Constructor) _constructors.get(str)).newInstance(str2, str3, new Integer(i));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static synchronized void init(String str) {
        if (str == null) {
            str = "org.apache.xmlbeans.impl.xquery.saxon.XBeansXQuery";
        }
        boolean z = false;
        Class<?> cls = null;
        try {
            cls = Class.forName(str);
            z = true;
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        if (z) {
            try {
                Class clsClass$ = class$java$lang$String;
                if (clsClass$ == null) {
                    clsClass$ = class$("java.lang.String");
                    class$java$lang$String = clsClass$;
                }
                Class clsClass$2 = class$java$lang$String;
                if (clsClass$2 == null) {
                    clsClass$2 = class$("java.lang.String");
                    class$java$lang$String = clsClass$2;
                }
                Class clsClass$3 = class$java$lang$Integer;
                if (clsClass$3 == null) {
                    clsClass$3 = class$("java.lang.Integer");
                    class$java$lang$Integer = clsClass$3;
                }
                _constructors.put(str, cls.getConstructor(clsClass$, clsClass$2, clsClass$3));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
