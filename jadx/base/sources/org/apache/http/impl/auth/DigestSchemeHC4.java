package org.apache.http.impl.auth;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.internal.p131ui.webview.ProcessUtil;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.ChallengeState;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.message.BasicHeaderValueFormatterHC4;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.BufferedHeader;
import org.apache.http.protocol.BasicHttpContextHC4;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EncodingUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class DigestSchemeHC4 extends RFC2617SchemeHC4 {
    private static final char[] HEXADECIMAL = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', DeviceInfoUtil.FLAVOR_TYPE_C, 'd', 'e', 'f'};
    private static final int QOP_AUTH = 2;
    private static final int QOP_AUTH_INT = 1;
    private static final int QOP_MISSING = 0;
    private static final int QOP_UNKNOWN = -1;

    /* JADX INFO: renamed from: a1 */
    private String f10017a1;

    /* JADX INFO: renamed from: a2 */
    private String f10018a2;
    private String cnonce;
    private boolean complete;
    private String lastNonce;
    private long nounceCount;

    public DigestSchemeHC4(Charset charset) {
        super(charset);
        this.complete = false;
    }

    public static String createCnonce() {
        byte[] bArr = new byte[8];
        new SecureRandom().nextBytes(bArr);
        return encode(bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private Header createDigestHeader(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        String str;
        byte b;
        String str2;
        int i;
        String string;
        String str3;
        String parameter = getParameter("uri");
        String parameter2 = getParameter("realm");
        String parameter3 = getParameter("nonce");
        String parameter4 = getParameter("opaque");
        String parameter5 = getParameter("methodname");
        String parameter6 = getParameter("algorithm");
        if (parameter6 == null) {
            parameter6 = "MD5";
        }
        HashSet hashSet = new HashSet(8);
        String parameter7 = getParameter("qop");
        if (parameter7 != null) {
            str = "algorithm";
            for (StringTokenizer stringTokenizer = new StringTokenizer(parameter7, ","); stringTokenizer.hasMoreTokens(); stringTokenizer = stringTokenizer) {
                hashSet.add(stringTokenizer.nextToken().trim().toLowerCase(Locale.ENGLISH));
            }
            b = ((httpRequest instanceof HttpEntityEnclosingRequest) && hashSet.contains("auth-int")) ? (byte) 1 : hashSet.contains(ProcessUtil.AuthServiceProcess) ? (byte) 2 : (byte) -1;
        } else {
            str = "algorithm";
            b = 0;
        }
        if (b == -1) {
            throw new AuthenticationException(AbstractC0541b.m772n("None of the qop methods is supported: ", parameter7));
        }
        String parameter8 = getParameter("charset");
        if (parameter8 == null) {
            parameter8 = "ISO-8859-1";
        }
        String str4 = parameter6.equalsIgnoreCase("MD5-sess") ? "MD5" : parameter6;
        try {
            MessageDigest messageDigestCreateMessageDigest = createMessageDigest(str4);
            String name = credentials.getUserPrincipal().getName();
            String password = credentials.getPassword();
            if (parameter3.equals(this.lastNonce)) {
                this.nounceCount++;
            } else {
                this.nounceCount = 1L;
                this.cnonce = null;
                this.lastNonce = parameter3;
            }
            StringBuilder sb = new StringBuilder(256);
            Formatter formatter = new Formatter(sb, Locale.US);
            byte b5 = b;
            formatter.format("%08x", Long.valueOf(this.nounceCount));
            formatter.close();
            String string2 = sb.toString();
            if (this.cnonce == null) {
                this.cnonce = createCnonce();
            }
            this.f10017a1 = null;
            this.f10018a2 = null;
            if (parameter6.equalsIgnoreCase("MD5-sess")) {
                sb.setLength(0);
                sb.append(name);
                sb.append(':');
                sb.append(parameter2);
                sb.append(':');
                sb.append(password);
                String strEncode = encode(messageDigestCreateMessageDigest.digest(EncodingUtils.getBytes(sb.toString(), parameter8)));
                sb.setLength(0);
                sb.append(strEncode);
                sb.append(':');
                sb.append(parameter3);
                sb.append(':');
                sb.append(this.cnonce);
                this.f10017a1 = sb.toString();
            } else {
                sb.setLength(0);
                sb.append(name);
                sb.append(':');
                sb.append(parameter2);
                sb.append(':');
                sb.append(password);
                this.f10017a1 = sb.toString();
            }
            String strEncode2 = encode(messageDigestCreateMessageDigest.digest(EncodingUtils.getBytes(this.f10017a1, parameter8)));
            byte b6 = b5;
            if (b6 == 2) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(parameter5));
                sb2.append(':');
                str2 = parameter;
                sb2.append(str2);
                this.f10018a2 = sb2.toString();
            } else {
                str2 = parameter;
                if (b6 == 1) {
                    HttpEntity entity = httpRequest instanceof HttpEntityEnclosingRequest ? ((HttpEntityEnclosingRequest) httpRequest).getEntity() : null;
                    if (entity == null || entity.isRepeatable()) {
                        HttpEntityDigester httpEntityDigester = new HttpEntityDigester(messageDigestCreateMessageDigest);
                        if (entity != null) {
                            try {
                                entity.writeTo(httpEntityDigester);
                            } catch (IOException e) {
                                throw new AuthenticationException("I/O error reading entity content", e);
                            }
                        }
                        httpEntityDigester.close();
                        this.f10018a2 = String.valueOf(parameter5) + ':' + str2 + ':' + encode(httpEntityDigester.getDigest());
                    } else {
                        if (!hashSet.contains(ProcessUtil.AuthServiceProcess)) {
                            throw new AuthenticationException("Qop auth-int cannot be used with a non-repeatable entity");
                        }
                        this.f10018a2 = String.valueOf(parameter5) + ':' + str2;
                        b6 = 2;
                    }
                } else {
                    this.f10018a2 = String.valueOf(parameter5) + ':' + str2;
                }
            }
            String strEncode3 = encode(messageDigestCreateMessageDigest.digest(EncodingUtils.getBytes(this.f10018a2, parameter8)));
            if (b6 == 0) {
                i = 0;
                sb.setLength(0);
                sb.append(strEncode2);
                sb.append(':');
                sb.append(parameter3);
                sb.append(':');
                sb.append(strEncode3);
                string = sb.toString();
            } else {
                i = 0;
                sb.setLength(0);
                sb.append(strEncode2);
                sb.append(':');
                sb.append(parameter3);
                sb.append(':');
                sb.append(string2);
                sb.append(':');
                sb.append(this.cnonce);
                sb.append(':');
                sb.append(b6 == 1 ? "auth-int" : ProcessUtil.AuthServiceProcess);
                sb.append(':');
                sb.append(strEncode3);
                string = sb.toString();
            }
            String strEncode4 = encode(messageDigestCreateMessageDigest.digest(EncodingUtils.getAsciiBytes(string)));
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(128);
            if (isProxy()) {
                charArrayBuffer.append("Proxy-Authorization");
            } else {
                charArrayBuffer.append("Authorization");
            }
            charArrayBuffer.append(": Digest ");
            ArrayList arrayList = new ArrayList(20);
            arrayList.add(new BasicNameValuePair("username", name));
            arrayList.add(new BasicNameValuePair("realm", parameter2));
            arrayList.add(new BasicNameValuePair("nonce", parameter3));
            arrayList.add(new BasicNameValuePair("uri", str2));
            arrayList.add(new BasicNameValuePair("response", strEncode4));
            if (b6 != 0) {
                str3 = "qop";
                arrayList.add(new BasicNameValuePair(str3, b6 == 1 ? "auth-int" : ProcessUtil.AuthServiceProcess));
                arrayList.add(new BasicNameValuePair("nc", string2));
                arrayList.add(new BasicNameValuePair("cnonce", this.cnonce));
            } else {
                str3 = "qop";
            }
            String str5 = str;
            arrayList.add(new BasicNameValuePair(str5, parameter6));
            if (parameter4 != null) {
                arrayList.add(new BasicNameValuePair("opaque", parameter4));
            }
            for (int i2 = i; i2 < arrayList.size(); i2++) {
                BasicNameValuePair basicNameValuePair = (BasicNameValuePair) arrayList.get(i2);
                if (i2 > 0) {
                    charArrayBuffer.append(SQLKeyword.COMMA);
                }
                String name2 = basicNameValuePair.getName();
                BasicHeaderValueFormatterHC4.INSTANCE.formatNameValuePair(charArrayBuffer, basicNameValuePair, (("nc".equals(name2) || str3.equals(name2) || str5.equals(name2)) ? 1 : i) ^ 1);
            }
            return new BufferedHeader(charArrayBuffer);
        } catch (UnsupportedDigestAlgorithmException unused) {
            throw new AuthenticationException("Unsuppported digest algorithm: ".concat(str4));
        }
    }

    private static MessageDigest createMessageDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (Exception unused) {
            throw new UnsupportedDigestAlgorithmException(AbstractC0541b.m772n("Unsupported algorithm in HTTP Digest authentication: ", str));
        }
    }

    public static String encode(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = b & 15;
            int i4 = (b & CtapException.ERR_VENDOR_FIRST) >> 4;
            int i5 = i * 2;
            char[] cArr2 = HEXADECIMAL;
            cArr[i5] = cArr2[i4];
            cArr[i5 + 1] = cArr2[i2];
        }
        return new String(cArr);
    }

    @Override // org.apache.http.auth.AuthScheme
    @Deprecated
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) {
        return authenticate(credentials, httpRequest, new BasicHttpContextHC4());
    }

    public String getA1() {
        return this.f10017a1;
    }

    public String getA2() {
        return this.f10018a2;
    }

    public String getCnonce() {
        return this.cnonce;
    }

    @Override // org.apache.http.auth.AuthScheme
    public String getSchemeName() {
        return "digest";
    }

    @Override // org.apache.http.auth.AuthScheme
    public boolean isComplete() {
        if ("true".equalsIgnoreCase(getParameter("stale"))) {
            return false;
        }
        return this.complete;
    }

    @Override // org.apache.http.auth.AuthScheme
    public boolean isConnectionBased() {
        return false;
    }

    public void overrideParamter(String str, String str2) {
        getParameters().put(str, str2);
    }

    @Override // org.apache.http.impl.auth.AuthSchemeBaseHC4, org.apache.http.auth.AuthScheme
    public void processChallenge(Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        this.complete = true;
    }

    @Override // org.apache.http.impl.auth.AuthSchemeBaseHC4
    public String toString() {
        StringBuilder sb = new StringBuilder("DIGEST [complete=");
        sb.append(this.complete);
        sb.append(", nonce=");
        sb.append(this.lastNonce);
        sb.append(", nc=");
        return AbstractC2821a.m2224o(sb, "]", this.nounceCount);
    }

    @Override // org.apache.http.impl.auth.AuthSchemeBaseHC4, org.apache.http.auth.ContextAwareAuthScheme
    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        Args.notNull(credentials, "Credentials");
        Args.notNull(httpRequest, "HTTP request");
        if (getParameter("realm") == null) {
            throw new AuthenticationException("missing realm in challenge");
        }
        if (getParameter("nonce") == null) {
            throw new AuthenticationException("missing nonce in challenge");
        }
        getParameters().put("methodname", httpRequest.getRequestLine().getMethod());
        getParameters().put("uri", httpRequest.getRequestLine().getUri());
        if (getParameter("charset") == null) {
            getParameters().put("charset", getCredentialsCharset(httpRequest));
        }
        return createDigestHeader(credentials, httpRequest);
    }

    @Deprecated
    public DigestSchemeHC4(ChallengeState challengeState) {
        super(challengeState);
    }

    public DigestSchemeHC4() {
        this(Consts.ASCII);
    }
}
