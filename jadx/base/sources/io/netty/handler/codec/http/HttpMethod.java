package io.netty.handler.codec.http;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.api.client.http.HttpMethods;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.util.AsciiString;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class HttpMethod implements Comparable<HttpMethod> {
    public static final HttpMethod CONNECT;
    public static final HttpMethod DELETE;
    public static final HttpMethod GET;
    public static final HttpMethod HEAD;
    public static final HttpMethod OPTIONS;
    public static final HttpMethod PATCH;
    public static final HttpMethod POST;
    public static final HttpMethod PUT;
    public static final HttpMethod TRACE;
    private static final EnumNameMap<HttpMethod> methodMap;
    private final AsciiString name;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class EnumNameMap<T> {
        private final Node<T>[] values;
        private final int valuesMask;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Node<T> {
            final String key;
            final T value;

            public Node(String str, T t) {
                this.key = str;
                this.value = t;
            }
        }

        public EnumNameMap(Node<T>... nodeArr) {
            this.values = new Node[MathUtil.findNextPositivePowerOfTwo(nodeArr.length)];
            this.valuesMask = r0.length - 1;
            for (Node<T> node : nodeArr) {
                int iHashCode = hashCode(node.key) & this.valuesMask;
                Node<T>[] nodeArr2 = this.values;
                if (nodeArr2[iHashCode] != null) {
                    StringBuilder sbM778t = AbstractC0541b.m778t(iHashCode, "index ", " collision between values: [");
                    sbM778t.append(this.values[iHashCode].key);
                    sbM778t.append(SQLKeyword.COMMA);
                    throw new IllegalArgumentException(AbstractC1038a.m1213n(PropertyUtils.INDEXED_DELIM2, node.key, sbM778t));
                }
                nodeArr2[iHashCode] = node;
            }
        }

        private static int hashCode(String str) {
            return str.hashCode() >>> 6;
        }

        public T get(String str) {
            Node<T> node = this.values[hashCode(str) & this.valuesMask];
            if (node == null || !node.key.equals(str)) {
                return null;
            }
            return node.value;
        }
    }

    static {
        HttpMethod httpMethod = new HttpMethod("OPTIONS");
        OPTIONS = httpMethod;
        HttpMethod httpMethod2 = new HttpMethod("GET");
        GET = httpMethod2;
        HttpMethod httpMethod3 = new HttpMethod("HEAD");
        HEAD = httpMethod3;
        HttpMethod httpMethod4 = new HttpMethod("POST");
        POST = httpMethod4;
        HttpMethod httpMethod5 = new HttpMethod("PUT");
        PUT = httpMethod5;
        HttpMethod httpMethod6 = new HttpMethod("PATCH");
        PATCH = httpMethod6;
        HttpMethod httpMethod7 = new HttpMethod("DELETE");
        DELETE = httpMethod7;
        HttpMethod httpMethod8 = new HttpMethod("TRACE");
        TRACE = httpMethod8;
        HttpMethod httpMethod9 = new HttpMethod(HttpMethods.CONNECT);
        CONNECT = httpMethod9;
        methodMap = new EnumNameMap<>(new EnumNameMap.Node(httpMethod.toString(), httpMethod), new EnumNameMap.Node(httpMethod2.toString(), httpMethod2), new EnumNameMap.Node(httpMethod3.toString(), httpMethod3), new EnumNameMap.Node(httpMethod4.toString(), httpMethod4), new EnumNameMap.Node(httpMethod5.toString(), httpMethod5), new EnumNameMap.Node(httpMethod6.toString(), httpMethod6), new EnumNameMap.Node(httpMethod7.toString(), httpMethod7), new EnumNameMap.Node(httpMethod8.toString(), httpMethod8), new EnumNameMap.Node(httpMethod9.toString(), httpMethod9));
    }

    public HttpMethod(String str) {
        String strCheckNonEmptyAfterTrim = ObjectUtil.checkNonEmptyAfterTrim(str, "name");
        for (int i = 0; i < strCheckNonEmptyAfterTrim.length(); i++) {
            char cCharAt = strCheckNonEmptyAfterTrim.charAt(i);
            if (Character.isISOControl(cCharAt) || Character.isWhitespace(cCharAt)) {
                throw new IllegalArgumentException("invalid character in name");
            }
        }
        this.name = AsciiString.cached(strCheckNonEmptyAfterTrim);
    }

    public static HttpMethod valueOf(String str) {
        HttpMethod httpMethod = GET;
        if (str == httpMethod.name()) {
            return httpMethod;
        }
        HttpMethod httpMethod2 = POST;
        if (str == httpMethod2.name()) {
            return httpMethod2;
        }
        HttpMethod httpMethod3 = methodMap.get(str);
        return httpMethod3 != null ? httpMethod3 : new HttpMethod(str);
    }

    public AsciiString asciiName() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HttpMethod) {
            return name().equals(((HttpMethod) obj).name());
        }
        return false;
    }

    public int hashCode() {
        return name().hashCode();
    }

    public String name() {
        return this.name.toString();
    }

    public String toString() {
        return this.name.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(HttpMethod httpMethod) {
        if (httpMethod == this) {
            return 0;
        }
        return name().compareTo(httpMethod.name());
    }
}
