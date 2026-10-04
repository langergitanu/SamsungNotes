package org.apache.http.conn.ssl;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.util.InetAddressUtilsHC4;
import org.apache.http.util.TextUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public abstract class AbstractVerifierHC4 implements X509HostnameVerifier {
    private static final String[] BAD_COUNTRY_2LDS;
    private static final String TAG = "HttpClient";

    static {
        String[] strArr = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        BAD_COUNTRY_2LDS = strArr;
        Arrays.sort(strArr);
    }

    @Deprecated
    public static boolean acceptableCountryWildcard(String str) {
        String[] strArrSplit = str.split(RemoteConstant.VERSION_DIVIDE);
        return (strArrSplit.length == 3 && strArrSplit[2].length() == 2 && Arrays.binarySearch(BAD_COUNTRY_2LDS, strArrSplit[1]) >= 0) ? false : true;
    }

    public static int countDots(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '.') {
                i++;
            }
        }
        return i;
    }

    public static String[] extractCNs(String str) throws SSLException {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<NameValuePair> list = DistinguishedNameParser.INSTANCE.parse(str);
        for (int i = 0; i < list.size(); i++) {
            NameValuePair nameValuePair = list.get(i);
            String name = nameValuePair.getName();
            String value = nameValuePair.getValue();
            if (TextUtils.isBlank(value)) {
                throw new SSLException(str.concat(" is not a valid X500 distinguished name"));
            }
            if (name.equalsIgnoreCase("cn")) {
                arrayList.add(value);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] getCNs(X509Certificate x509Certificate) {
        try {
            return extractCNs(x509Certificate.getSubjectX500Principal().toString());
        } catch (SSLException unused) {
            return null;
        }
    }

    public static String[] getDNSSubjectAlts(X509Certificate x509Certificate) {
        return getSubjectAlts(x509Certificate, null);
    }

    private static String[] getSubjectAlts(X509Certificate x509Certificate, String str) {
        Collection<List<?>> subjectAlternativeNames;
        int i = isIPAddress(str) ? 7 : 2;
        LinkedList linkedList = new LinkedList();
        try {
            subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException unused) {
            subjectAlternativeNames = null;
        }
        if (subjectAlternativeNames != null) {
            for (List<?> list : subjectAlternativeNames) {
                if (((Integer) list.get(0)).intValue() == i) {
                    linkedList.add((String) list.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    private static boolean isIPAddress(String str) {
        if (str != null) {
            return InetAddressUtilsHC4.isIPv4Address(str) || InetAddressUtilsHC4.isIPv6Address(str);
        }
        return false;
    }

    private String normaliseIPv6Address(String str) {
        if (str != null && InetAddressUtilsHC4.isIPv6Address(str)) {
            try {
                return InetAddress.getByName(str).getHostAddress();
            } catch (UnknownHostException e) {
                Log.e(TAG, "Unexpected error converting ".concat(str), e);
            }
        }
        return str;
    }

    public boolean validCountryWildcard(String str) {
        String[] strArrSplit = str.split(RemoteConstant.VERSION_DIVIDE);
        return (strArrSplit.length == 3 && strArrSplit[2].length() == 2 && Arrays.binarySearch(BAD_COUNTRY_2LDS, strArrSplit[1]) >= 0) ? false : true;
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier
    public final void verify(String str, SSLSocket sSLSocket) throws IOException {
        if (str == null) {
            throw new NullPointerException("host to verify is null");
        }
        SSLSession session = sSLSocket.getSession();
        if (session == null) {
            sSLSocket.getInputStream().available();
            session = sSLSocket.getSession();
            if (session == null) {
                sSLSocket.startHandshake();
                session = sSLSocket.getSession();
            }
        }
        verify(str, (X509Certificate) session.getPeerCertificates()[0]);
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier, javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            verify(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
            return true;
        } catch (SSLException unused) {
            return false;
        }
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier
    public final void verify(String str, X509Certificate x509Certificate) throws SSLException {
        verify(str, getCNs(x509Certificate), getSubjectAlts(x509Certificate, str));
    }

    public final void verify(String str, String[] strArr, String[] strArr2, boolean z) throws SSLException {
        boolean zEndsWith;
        String str2;
        LinkedList linkedList = new LinkedList();
        if (strArr != null && strArr.length > 0 && (str2 = strArr[0]) != null) {
            linkedList.add(str2);
        }
        if (strArr2 != null) {
            for (String str3 : strArr2) {
                if (str3 != null) {
                    linkedList.add(str3);
                }
            }
        }
        if (!linkedList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            String strNormaliseIPv6Address = normaliseIPv6Address(str.trim().toLowerCase(Locale.ENGLISH));
            Iterator it = linkedList.iterator();
            boolean zEquals = false;
            while (it.hasNext()) {
                String lowerCase = ((String) it.next()).toLowerCase(Locale.ENGLISH);
                sb.append(" <");
                sb.append(lowerCase);
                sb.append('>');
                if (it.hasNext()) {
                    sb.append(" OR");
                }
                String[] strArrSplit = lowerCase.split(RemoteConstant.VERSION_DIVIDE);
                if (strArrSplit.length >= 3 && strArrSplit[0].endsWith("*") && validCountryWildcard(lowerCase) && !isIPAddress(str)) {
                    String str4 = strArrSplit[0];
                    if (str4.length() > 1) {
                        String strM1614d = AbstractC2322a.m1614d(1, 0, str4);
                        zEndsWith = strNormaliseIPv6Address.startsWith(strM1614d) && strNormaliseIPv6Address.substring(strM1614d.length()).endsWith(lowerCase.substring(str4.length()));
                    } else {
                        zEndsWith = strNormaliseIPv6Address.endsWith(lowerCase.substring(1));
                    }
                    if (zEndsWith && z) {
                        zEquals = countDots(strNormaliseIPv6Address) == countDots(lowerCase);
                    } else {
                        zEquals = zEndsWith;
                    }
                } else {
                    zEquals = strNormaliseIPv6Address.equals(normaliseIPv6Address(lowerCase));
                }
                if (zEquals) {
                    break;
                }
            }
            if (zEquals) {
                return;
            }
            throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + ((Object) sb));
        }
        throw new SSLException(AbstractC0541b.m773o("Certificate for <", str, "> doesn't contain CN or DNS subjectAlt"));
    }
}
