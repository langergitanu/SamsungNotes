package cz.msebera.android.httpclient.impl.auth;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.internal.p131ui.webview.ProcessUtil;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.yubico.yubikit.core.fido.CtapException;
import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ChallengeState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import cz.msebera.android.httpclient.util.EncodingUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DigestScheme extends RFC2617Scheme {
    private static final char[] HEXADECIMAL = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', DeviceInfoUtil.FLAVOR_TYPE_C, 'd', 'e', 'f'};
    private static final int QOP_AUTH = 2;
    private static final int QOP_AUTH_INT = 1;
    private static final int QOP_MISSING = 0;
    private static final int QOP_UNKNOWN = -1;
    private static final long serialVersionUID = 3883908186234566916L;

    /* JADX INFO: renamed from: a1 */
    private String f8492a1;

    /* JADX INFO: renamed from: a2 */
    private String f8493a2;
    private String cnonce;
    private boolean complete;
    private String lastNonce;
    private long nounceCount;

    public DigestScheme(Charset charset) {
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
        String str3;
        char c;
        byte b5;
        int i;
        String string;
        String str4;
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
            str = "qop";
            for (StringTokenizer stringTokenizer = new StringTokenizer(parameter7, ","); stringTokenizer.hasMoreTokens(); stringTokenizer = stringTokenizer) {
                hashSet.add(stringTokenizer.nextToken().trim().toLowerCase(Locale.ROOT));
            }
            b = ((httpRequest instanceof HttpEntityEnclosingRequest) && hashSet.contains("auth-int")) ? (byte) 1 : hashSet.contains(ProcessUtil.AuthServiceProcess) ? (byte) 2 : (byte) -1;
        } else {
            str = "qop";
            b = 0;
        }
        if (b == -1) {
            throw new AuthenticationException(AbstractC0541b.m772n("None of the qop methods is supported: ", parameter7));
        }
        String parameter8 = getParameter("charset");
        if (parameter8 == null) {
            parameter8 = "ISO-8859-1";
        }
        String str5 = parameter6.equalsIgnoreCase("MD5-sess") ? "MD5" : parameter6;
        try {
            MessageDigest messageDigestCreateMessageDigest = createMessageDigest(str5);
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
            formatter.format("%08x", Long.valueOf(this.nounceCount));
            formatter.close();
            String string2 = sb.toString();
            if (this.cnonce == null) {
                this.cnonce = createCnonce();
            }
            this.f8492a1 = null;
            this.f8493a2 = null;
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
                this.f8492a1 = sb.toString();
            } else {
                sb.setLength(0);
                sb.append(name);
                sb.append(':');
                sb.append(parameter2);
                sb.append(':');
                sb.append(password);
                this.f8492a1 = sb.toString();
            }
            String strEncode2 = encode(messageDigestCreateMessageDigest.digest(EncodingUtils.getBytes(this.f8492a1, parameter8)));
            if (b == 2) {
                str2 = parameter;
                this.f8493a2 = AbstractC1038a.m1212m(':', parameter5, str2);
                c = ':';
                str3 = ProcessUtil.AuthServiceProcess;
            } else {
                str2 = parameter;
                if (b == 1) {
                    HttpEntity entity = httpRequest instanceof HttpEntityEnclosingRequest ? ((HttpEntityEnclosingRequest) httpRequest).getEntity() : null;
                    if (entity == null || entity.isRepeatable()) {
                        str3 = ProcessUtil.AuthServiceProcess;
                        HttpEntityDigester httpEntityDigester = new HttpEntityDigester(messageDigestCreateMessageDigest);
                        if (entity != null) {
                            try {
                                entity.writeTo(httpEntityDigester);
                            } catch (IOException e) {
                                throw new AuthenticationException("I/O error reading entity content", e);
                            }
                        }
                        httpEntityDigester.close();
                        this.f8493a2 = parameter5 + ':' + str2 + ':' + encode(httpEntityDigester.getDigest());
                        b5 = b;
                    } else {
                        str3 = ProcessUtil.AuthServiceProcess;
                        if (!hashSet.contains(str3)) {
                            throw new AuthenticationException("Qop auth-int cannot be used with a non-repeatable entity");
                        }
                        this.f8493a2 = AbstractC1038a.m1212m(':', parameter5, str2);
                        b5 = 2;
                    }
                    b = b5;
                    c = ':';
                } else {
                    str3 = ProcessUtil.AuthServiceProcess;
                    c = ':';
                    this.f8493a2 = AbstractC1038a.m1212m(':', parameter5, str2);
                }
            }
            String strEncode3 = encode(messageDigestCreateMessageDigest.digest(EncodingUtils.getBytes(this.f8493a2, parameter8)));
            if (b == 0) {
                i = 0;
                sb.setLength(0);
                sb.append(strEncode2);
                sb.append(c);
                sb.append(parameter3);
                sb.append(c);
                sb.append(strEncode3);
                string = sb.toString();
            } else {
                i = 0;
                sb.setLength(0);
                sb.append(strEncode2);
                sb.append(c);
                sb.append(parameter3);
                sb.append(c);
                sb.append(string2);
                sb.append(c);
                sb.append(this.cnonce);
                sb.append(c);
                sb.append(b == 1 ? "auth-int" : str3);
                sb.append(c);
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
            if (b != 0) {
                str4 = str;
                arrayList.add(new BasicNameValuePair(str4, b == 1 ? "auth-int" : str3));
                arrayList.add(new BasicNameValuePair("nc", string2));
                arrayList.add(new BasicNameValuePair("cnonce", this.cnonce));
            } else {
                str4 = str;
            }
            arrayList.add(new BasicNameValuePair("algorithm", parameter6));
            if (parameter4 != null) {
                arrayList.add(new BasicNameValuePair("opaque", parameter4));
            }
            for (int i2 = i; i2 < arrayList.size(); i2++) {
                NameValuePair nameValuePair = (BasicNameValuePair) arrayList.get(i2);
                if (i2 > 0) {
                    charArrayBuffer.append(SQLKeyword.COMMA);
                }
                String name2 = nameValuePair.getName();
                BasicHeaderValueFormatter.INSTANCE.formatNameValuePair(charArrayBuffer, nameValuePair, (("nc".equals(name2) || str4.equals(name2) || "algorithm".equals(name2)) ? 1 : i) ^ 1);
            }
            return new BufferedHeader(charArrayBuffer);
        } catch (UnsupportedDigestAlgorithmException unused) {
            throw new AuthenticationException("Unsuppported digest algorithm: ".concat(str5));
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

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    @Deprecated
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) {
        return authenticate(credentials, httpRequest, new BasicHttpContext());
    }

    public String getA1() {
        return this.f8492a1;
    }

    public String getA2() {
        return this.f8493a2;
    }

    public String getCnonce() {
        return this.cnonce;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getSchemeName() {
        return "digest";
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isComplete() {
        if ("true".equalsIgnoreCase(getParameter("stale"))) {
            return false;
        }
        return this.complete;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isConnectionBased() {
        return false;
    }

    public void overrideParamter(String str, String str2) {
        getParameters().put(str, str2);
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase, cz.msebera.android.httpclient.auth.AuthScheme
    public void processChallenge(Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        this.complete = true;
        if (getParameters().isEmpty()) {
            throw new MalformedChallengeException("Authentication challenge is empty");
        }
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase
    public String toString() {
        StringBuilder sb = new StringBuilder("DIGEST [complete=");
        sb.append(this.complete);
        sb.append(", nonce=");
        sb.append(this.lastNonce);
        sb.append(", nc=");
        return AbstractC2821a.m2224o(sb, "]", this.nounceCount);
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase, cz.msebera.android.httpclient.auth.ContextAwareAuthScheme
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
    public DigestScheme(ChallengeState challengeState) {
        super(challengeState);
    }

    public DigestScheme() {
        this(Consts.ASCII);
    }
}
