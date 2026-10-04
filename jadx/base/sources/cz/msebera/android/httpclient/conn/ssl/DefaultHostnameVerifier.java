package cz.msebera.android.httpclient.conn.ssl;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.util.DomainType;
import cz.msebera.android.httpclient.conn.util.InetAddressUtils;
import cz.msebera.android.httpclient.conn.util.PublicSuffixMatcher;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public final class DefaultHostnameVerifier implements HostnameVerifier {
    public HttpClientAndroidLog log;
    private final PublicSuffixMatcher publicSuffixMatcher;

    /* JADX INFO: renamed from: cz.msebera.android.httpclient.conn.ssl.DefaultHostnameVerifier$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C119351 {

        /* JADX INFO: renamed from: $SwitchMap$cz$msebera$android$httpclient$conn$ssl$DefaultHostnameVerifier$HostNameType */
        static final /* synthetic */ int[] f8485xb03ce59b;

        static {
            int[] iArr = new int[HostNameType.values().length];
            f8485xb03ce59b = iArr;
            try {
                iArr[HostNameType.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8485xb03ce59b[HostNameType.IPv6.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum HostNameType {
        IPv4(7),
        IPv6(7),
        DNS(2);

        final int subjectType;

        HostNameType(int i) {
            this.subjectType = i;
        }
    }

    public DefaultHostnameVerifier(PublicSuffixMatcher publicSuffixMatcher) {
        this.log = new HttpClientAndroidLog(DefaultHostnameVerifier.class);
        this.publicSuffixMatcher = publicSuffixMatcher;
    }

    public static HostNameType determineHostFormat(String str) {
        if (InetAddressUtils.isIPv4Address(str)) {
            return HostNameType.IPv4;
        }
        if (str.startsWith("[") && str.endsWith("]")) {
            str = AbstractC2322a.m1614d(1, 1, str);
        }
        return InetAddressUtils.isIPv6Address(str) ? HostNameType.IPv6 : HostNameType.DNS;
    }

    public static List<SubjectName> getSubjectAltNames(X509Certificate x509Certificate) {
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                Integer num = list.size() >= 2 ? (Integer) list.get(0) : null;
                if (num != null && (num.intValue() == 2 || num.intValue() == 7)) {
                    Object obj = list.get(1);
                    if (obj instanceof String) {
                        arrayList.add(new SubjectName((String) obj, num.intValue()));
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.EMPTY_LIST;
        }
    }

    public static void matchCN(String str, String str2, PublicSuffixMatcher publicSuffixMatcher) throws SSLPeerUnverifiedException {
        Locale locale = Locale.ROOT;
        if (!matchIdentityStrict(str.toLowerCase(locale), str2.toLowerCase(locale), publicSuffixMatcher)) {
            throw new SSLPeerUnverifiedException(AbstractC0541b.m774p("Certificate for <", str, "> doesn't match common name of the certificate subject: ", str2));
        }
    }

    public static void matchDNSName(String str, List<SubjectName> list, PublicSuffixMatcher publicSuffixMatcher) throws SSLPeerUnverifiedException {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        for (int i = 0; i < list.size(); i++) {
            SubjectName subjectName = list.get(i);
            if (subjectName.getType() == 2 && matchIdentityStrict(lowerCase, subjectName.getValue().toLowerCase(Locale.ROOT), publicSuffixMatcher)) {
                return;
            }
        }
        throw new SSLPeerUnverifiedException("Certificate for <" + str + "> doesn't match any of the subject alternative names: " + list);
    }

    public static boolean matchDomainRoot(String str, String str2) {
        return str2 != null && str.endsWith(str2) && (str.length() == str2.length() || str.charAt((str.length() - str2.length()) - 1) == '.');
    }

    public static void matchIPAddress(String str, List<SubjectName> list) throws SSLPeerUnverifiedException {
        for (int i = 0; i < list.size(); i++) {
            SubjectName subjectName = list.get(i);
            if (subjectName.getType() == 7 && str.equals(subjectName.getValue())) {
                return;
            }
        }
        throw new SSLPeerUnverifiedException("Certificate for <" + str + "> doesn't match any of the subject alternative names: " + list);
    }

    public static void matchIPv6Address(String str, List<SubjectName> list) throws SSLPeerUnverifiedException {
        String strNormaliseAddress = normaliseAddress(str);
        for (int i = 0; i < list.size(); i++) {
            SubjectName subjectName = list.get(i);
            if (subjectName.getType() == 7 && strNormaliseAddress.equals(normaliseAddress(subjectName.getValue()))) {
                return;
            }
        }
        throw new SSLPeerUnverifiedException("Certificate for <" + str + "> doesn't match any of the subject alternative names: " + list);
    }

    private static boolean matchIdentity(String str, String str2, PublicSuffixMatcher publicSuffixMatcher, boolean z) {
        if (publicSuffixMatcher != null && str.contains(Extension.DOT) && !matchDomainRoot(str, publicSuffixMatcher.getDomainRoot(str2, DomainType.ICANN))) {
            return false;
        }
        int iIndexOf = str2.indexOf(42);
        if (iIndexOf == -1) {
            return str.equalsIgnoreCase(str2);
        }
        String strSubstring = str2.substring(0, iIndexOf);
        String strSubstring2 = str2.substring(iIndexOf + 1);
        if (!strSubstring.isEmpty() && !str.startsWith(strSubstring)) {
            return false;
        }
        if (strSubstring2.isEmpty() || str.endsWith(strSubstring2)) {
            return (z && str.substring(strSubstring.length(), str.length() - strSubstring2.length()).contains(Extension.DOT)) ? false : true;
        }
        return false;
    }

    public static boolean matchIdentityStrict(String str, String str2, PublicSuffixMatcher publicSuffixMatcher) {
        return matchIdentity(str, str2, publicSuffixMatcher, true);
    }

    public static String normaliseAddress(String str) {
        if (str == null) {
            return str;
        }
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException unused) {
            return str;
        }
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            verify(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
            return true;
        } catch (SSLException e) {
            if (this.log.isDebugEnabled()) {
                this.log.debug(e.getMessage(), e);
            }
            return false;
        }
    }

    public static boolean matchIdentityStrict(String str, String str2) {
        return matchIdentity(str, str2, null, true);
    }

    public DefaultHostnameVerifier() {
        this(null);
    }

    public void verify(String str, X509Certificate x509Certificate) throws SSLException {
        HostNameType hostNameTypeDetermineHostFormat = determineHostFormat(str);
        List<SubjectName> subjectAltNames = getSubjectAltNames(x509Certificate);
        if (subjectAltNames != null && !subjectAltNames.isEmpty()) {
            int i = C119351.f8485xb03ce59b[hostNameTypeDetermineHostFormat.ordinal()];
            if (i == 1) {
                matchIPAddress(str, subjectAltNames);
                return;
            } else if (i != 2) {
                matchDNSName(str, subjectAltNames, this.publicSuffixMatcher);
                return;
            } else {
                matchIPv6Address(str, subjectAltNames);
                return;
            }
        }
        String strFindMostSpecific = new DistinguishedNameParser(x509Certificate.getSubjectX500Principal()).findMostSpecific("cn");
        if (strFindMostSpecific != null) {
            matchCN(str, strFindMostSpecific, this.publicSuffixMatcher);
            return;
        }
        throw new SSLException(AbstractC0541b.m773o("Certificate subject for <", str, "> doesn't contain a common name and does not have alternative names"));
    }

    public static boolean matchIdentity(String str, String str2, PublicSuffixMatcher publicSuffixMatcher) {
        return matchIdentity(str, str2, publicSuffixMatcher, false);
    }

    public static boolean matchIdentity(String str, String str2) {
        return matchIdentity(str, str2, null, false);
    }
}
