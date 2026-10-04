package org.apache.xmlbeans.impl.values;

import androidx.compose.runtime.AbstractC1974b;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Map;
import kotlin.collections.AbstractC12991c;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.xml.stream.StartElement;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NamespaceContext implements PrefixResolver {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int MAP = 3;
    private static final int RESOLVER = 5;
    private static final int START_ELEMENT = 4;
    private static final int TYPE_STORE = 1;
    private static final int XML_OBJECT = 2;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$values$NamespaceContext;
    private static ThreadLocal tl_namespaceContextStack;
    private int _code = 3;
    private Object _obj;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NamespaceContextStack {
        NamespaceContext current;
        ArrayList stack;

        private NamespaceContextStack() {
            this.stack = new ArrayList();
        }

        public final void pop() {
            this.current = (NamespaceContext) AbstractC1974b.m1313f(1, this.stack);
            ArrayList arrayList = this.stack;
            arrayList.remove(arrayList.size() - 1);
        }

        public final void push(NamespaceContext namespaceContext) {
            this.stack.add(this.current);
            this.current = namespaceContext;
        }
    }

    static {
        if (class$org$apache$xmlbeans$impl$values$NamespaceContext == null) {
            class$org$apache$xmlbeans$impl$values$NamespaceContext = class$("org.apache.xmlbeans.impl.values.NamespaceContext");
        }
        $assertionsDisabled = true;
        tl_namespaceContextStack = new ThreadLocal();
    }

    public NamespaceContext(Map map) {
        this._obj = map;
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static PrefixResolver getCurrent() {
        return getNamespaceContextStack().current;
    }

    private static NamespaceContextStack getNamespaceContextStack() {
        NamespaceContextStack namespaceContextStack = (NamespaceContextStack) tl_namespaceContextStack.get();
        if (namespaceContextStack != null) {
            return namespaceContextStack;
        }
        NamespaceContextStack namespaceContextStack2 = new NamespaceContextStack();
        tl_namespaceContextStack.set(namespaceContextStack2);
        return namespaceContextStack2;
    }

    public static void pop() {
        NamespaceContextStack namespaceContextStack = getNamespaceContextStack();
        namespaceContextStack.pop();
        if (namespaceContextStack.stack.size() == 0) {
            tl_namespaceContextStack.set(null);
        }
    }

    public static void push(NamespaceContext namespaceContext) {
        getNamespaceContextStack().push(namespaceContext);
    }

    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
    public String getNamespaceForPrefix(String str) {
        if (str != null && str.equals("xml")) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        int i = this._code;
        if (i == 1) {
            return ((TypeStore) this._obj).getNamespaceForPrefix(str);
        }
        if (i == 2) {
            Object invocationHandler = this._obj;
            if (Proxy.isProxyClass(invocationHandler.getClass())) {
                invocationHandler = Proxy.getInvocationHandler(invocationHandler);
            }
            if (invocationHandler instanceof TypeStoreUser) {
                return ((TypeStoreUser) invocationHandler).get_store().getNamespaceForPrefix(str);
            }
            XmlCursor xmlCursorNewCursor = ((XmlObject) this._obj).newCursor();
            if (xmlCursorNewCursor != null) {
                if (xmlCursorNewCursor.currentTokenType() == XmlCursor.TokenType.ATTR) {
                    xmlCursorNewCursor.toParent();
                }
                try {
                    return xmlCursorNewCursor.namespaceForPrefix(str);
                } finally {
                    xmlCursorNewCursor.dispose();
                }
            }
        } else if (i != 3) {
            if (i == 4) {
                return ((StartElement) this._obj).getNamespaceUri(str);
            }
            if (i == 5) {
                return ((PrefixResolver) this._obj).getNamespaceForPrefix(str);
            }
            if ($assertionsDisabled) {
                return null;
            }
            throw new AssertionError("Improperly initialized NamespaceContext.");
        }
        return (String) ((Map) this._obj).get(str);
    }

    public NamespaceContext(TypeStore typeStore) {
        this._obj = typeStore;
    }

    public NamespaceContext(XmlObject xmlObject) {
        this._obj = xmlObject;
    }

    public NamespaceContext(StartElement startElement) {
        this._obj = startElement;
    }

    public NamespaceContext(PrefixResolver prefixResolver) {
        this._obj = prefixResolver;
    }
}
