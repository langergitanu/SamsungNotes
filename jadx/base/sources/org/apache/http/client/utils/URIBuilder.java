package org.apache.http.client.utils;

import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.util.InetAddressUtilsHC4;
import org.apache.http.message.BasicNameValuePair;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class URIBuilder {
    private String encodedAuthority;
    private String encodedFragment;
    private String encodedPath;
    private String encodedQuery;
    private String encodedSchemeSpecificPart;
    private String encodedUserInfo;
    private String fragment;
    private String host;
    private String path;
    private int port;
    private String query;
    private List<NameValuePair> queryParams;
    private String scheme;
    private String userInfo;

    public URIBuilder() {
        this.port = -1;
    }

    private String buildString() {
        StringBuilder sb = new StringBuilder();
        String str = this.scheme;
        if (str != null) {
            sb.append(str);
            sb.append(':');
        }
        String str2 = this.encodedSchemeSpecificPart;
        if (str2 != null) {
            sb.append(str2);
        } else {
            if (this.encodedAuthority != null) {
                sb.append("//");
                sb.append(this.encodedAuthority);
            } else if (this.host != null) {
                sb.append("//");
                String str3 = this.encodedUserInfo;
                if (str3 != null) {
                    sb.append(str3);
                    sb.append(Log.TAG_SEPARATOR);
                } else {
                    String str4 = this.userInfo;
                    if (str4 != null) {
                        sb.append(encodeUserInfo(str4));
                        sb.append(Log.TAG_SEPARATOR);
                    }
                }
                if (InetAddressUtilsHC4.isIPv6Address(this.host)) {
                    sb.append("[");
                    sb.append(this.host);
                    sb.append("]");
                } else {
                    sb.append(this.host);
                }
                if (this.port >= 0) {
                    sb.append(":");
                    sb.append(this.port);
                }
            }
            String str5 = this.encodedPath;
            if (str5 != null) {
                sb.append(normalizePath(str5));
            } else {
                String str6 = this.path;
                if (str6 != null) {
                    sb.append(encodePath(normalizePath(str6)));
                }
            }
            if (this.encodedQuery != null) {
                sb.append(MsalUtils.QUERY_STRING_SYMBOL);
                sb.append(this.encodedQuery);
            } else if (this.queryParams != null) {
                sb.append(MsalUtils.QUERY_STRING_SYMBOL);
                sb.append(encodeUrlForm(this.queryParams));
            } else if (this.query != null) {
                sb.append(MsalUtils.QUERY_STRING_SYMBOL);
                sb.append(encodeUric(this.query));
            }
        }
        if (this.encodedFragment != null) {
            sb.append(ContentUtils.HASH_SYMBOL);
            sb.append(this.encodedFragment);
        } else if (this.fragment != null) {
            sb.append(ContentUtils.HASH_SYMBOL);
            sb.append(encodeUric(this.fragment));
        }
        return sb.toString();
    }

    private void digestURI(URI uri) {
        this.scheme = uri.getScheme();
        this.encodedSchemeSpecificPart = uri.getRawSchemeSpecificPart();
        this.encodedAuthority = uri.getRawAuthority();
        this.host = uri.getHost();
        this.port = uri.getPort();
        this.encodedUserInfo = uri.getRawUserInfo();
        this.userInfo = uri.getUserInfo();
        this.encodedPath = uri.getRawPath();
        this.path = uri.getPath();
        this.encodedQuery = uri.getRawQuery();
        this.queryParams = parseQuery(uri.getRawQuery(), Consts.UTF_8);
        this.encodedFragment = uri.getRawFragment();
        this.fragment = uri.getFragment();
    }

    private String encodePath(String str) {
        return URLEncodedUtilsHC4.encPath(str, Consts.UTF_8);
    }

    private String encodeUric(String str) {
        return URLEncodedUtilsHC4.encUric(str, Consts.UTF_8);
    }

    private String encodeUrlForm(List<NameValuePair> list) {
        return URLEncodedUtilsHC4.format(list, Consts.UTF_8);
    }

    private String encodeUserInfo(String str) {
        return URLEncodedUtilsHC4.encUserInfo(str, Consts.UTF_8);
    }

    private static String normalizePath(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == '/') {
            i++;
        }
        return i > 1 ? str.substring(i - 1) : str;
    }

    private List<NameValuePair> parseQuery(String str, Charset charset) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return URLEncodedUtilsHC4.parse(str, charset);
    }

    public URIBuilder addParameter(String str, String str2) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        this.queryParams.add(new BasicNameValuePair(str, str2));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder addParameters(List<NameValuePair> list) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        this.queryParams.addAll(list);
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URI build() {
        return new URI(buildString());
    }

    public URIBuilder clearParameters() {
        this.queryParams = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public String getFragment() {
        return this.fragment;
    }

    public String getHost() {
        return this.host;
    }

    public String getPath() {
        return this.path;
    }

    public int getPort() {
        return this.port;
    }

    public List<NameValuePair> getQueryParams() {
        return this.queryParams != null ? new ArrayList(this.queryParams) : new ArrayList();
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public boolean isAbsolute() {
        return this.scheme != null;
    }

    public boolean isOpaque() {
        return this.path == null;
    }

    public URIBuilder removeQuery() {
        this.queryParams = null;
        this.query = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setCustomQuery(String str) {
        this.query = str;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.queryParams = null;
        return this;
    }

    public URIBuilder setFragment(String str) {
        this.fragment = str;
        this.encodedFragment = null;
        return this;
    }

    public URIBuilder setHost(String str) {
        this.host = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setParameter(String str, String str2) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        if (!this.queryParams.isEmpty()) {
            Iterator<NameValuePair> it = this.queryParams.iterator();
            while (it.hasNext()) {
                if (it.next().getName().equals(str)) {
                    it.remove();
                }
            }
        }
        this.queryParams.add(new BasicNameValuePair(str, str2));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setParameters(List<NameValuePair> list) {
        List<NameValuePair> list2 = this.queryParams;
        if (list2 == null) {
            this.queryParams = new ArrayList();
        } else {
            list2.clear();
        }
        this.queryParams.addAll(list);
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setPath(String str) {
        this.path = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedPath = null;
        return this;
    }

    public URIBuilder setPort(int i) {
        if (i < 0) {
            i = -1;
        }
        this.port = i;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    @Deprecated
    public URIBuilder setQuery(String str) {
        this.queryParams = parseQuery(str, Consts.UTF_8);
        this.query = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setScheme(String str) {
        this.scheme = str;
        return this;
    }

    public URIBuilder setUserInfo(String str) {
        this.userInfo = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        this.encodedUserInfo = null;
        return this;
    }

    public String toString() {
        return buildString();
    }

    public URIBuilder(String str) {
        digestURI(new URI(str));
    }

    public URIBuilder(URI uri) {
        digestURI(uri);
    }

    public URIBuilder setUserInfo(String str, String str2) {
        return setUserInfo(String.valueOf(str) + ':' + str2);
    }

    public URIBuilder setParameters(NameValuePair... nameValuePairArr) {
        List<NameValuePair> list = this.queryParams;
        if (list == null) {
            this.queryParams = new ArrayList();
        } else {
            list.clear();
        }
        for (NameValuePair nameValuePair : nameValuePairArr) {
            this.queryParams.add(nameValuePair);
        }
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }
}
