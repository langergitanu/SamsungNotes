package com.microsoft.identity.common.java.platform;

import androidx.collection.AbstractC0622a;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager;
import com.microsoft.identity.common.java.crypto.SecureHardwareState;
import com.microsoft.identity.common.java.crypto.SigningAlgorithm;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.marker.CodeMarkerManager;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.samsung.android.sdk.smp.common.database.DBContract;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import cz.msebera.android.httpclient.extras.Base64;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import lombok.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractDevicePopManager implements IDevicePopManager {
    private static final String ANDROID_KEYSTORE = "AndroidKeyStore";
    public static final String DEFAULT_KEYSTORE_ENTRY_ALIAS = "microsoft-device-pop";
    public static final String NEGATIVE_THIRTY_THREE_INTERNAL_ERROR_MSG = "internal Keystore code: -33";
    private static final String PRIVATE_KEY_NOT_FOUND = "Not an instance of a PrivateKeyEntry";
    private static final int RSA_KEY_SIZE = 2048;
    public static final String STRONG_BOX_UNAVAILABLE_EXCEPTION = "StrongBoxUnavailableException";
    private static final String TAG = "AbstractDevicePopManager";
    protected final IKeyStoreKeyManager<KeyStore.PrivateKeyEntry> mKeyManager;
    private static final Charset UTF8 = Charset.forName("UTF-8");
    public static final Type MAP_STRING_STRING_TYPE = TypeToken.getParameterized(Map.class, String.class, String.class).getType();
    public static final Gson GSON = new Gson();
    private static final ExecutorService sThreadExecutor = Executors.newFixedThreadPool(5);
    private static final CodeMarkerManager sCodeMarkerManager = CodeMarkerManager.getInstance();

    /* JADX INFO: renamed from: com.microsoft.identity.common.java.platform.AbstractDevicePopManager$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C64334 {

        /* JADX INFO: renamed from: $SwitchMap$com$microsoft$identity$common$java$crypto$IDevicePopManager$PublicKeyFormat */
        static final /* synthetic */ int[] f3603x8bb10b97;

        static {
            int[] iArr = new int[IDevicePopManager.PublicKeyFormat.values().length];
            f3603x8bb10b97 = iArr;
            try {
                iArr[IDevicePopManager.PublicKeyFormat.X_509_SubjectPublicKeyInfo_ASN_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3603x8bb10b97[IDevicePopManager.PublicKeyFormat.JWK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CertificateProperties {
        public static final int CERTIFICATE_VALIDITY_YEARS = 99;
        public static final String COMMON_NAME = "CN=device-pop";
        public static final String COUNTRY = "US";
        public static final String ORGANIZATION_NAME = "Microsoft Corporation";
        public static final String ORGANIZATION_UNIT = "Identity";
        public static final BigInteger SERIAL_NUMBER = BigInteger.ONE;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class KeyPairGeneratorAlgorithms {
        public static final String RSA = "RSA";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SignedHttpRequestJwtClaims {
        private static final String ACCESS_TOKEN = "at";
        private static final String CLIENT_CLAIMS = "client_claims";
        private static final String CNF = "cnf";
        private static final String HTTP_HOST = "u";
        private static final String HTTP_METHOD = "m";
        private static final String HTTP_PATH = "p";
        public static final String JWK = "jwk";
        private static final String NONCE = "nonce";
        private static final String TIMESTAMP = "ts";

        private SignedHttpRequestJwtClaims() {
        }
    }

    public AbstractDevicePopManager(@NonNull IKeyStoreKeyManager<KeyStore.PrivateKeyEntry> iKeyStoreKeyManager) {
        if (iKeyStoreKeyManager == null) {
            throw new NullPointerException("keyManager is marked non-null but is null");
        }
        this.mKeyManager = iKeyStoreKeyManager;
    }

    private static String base64UrlEncode(@NonNull String str) {
        if (str != null) {
            return Base64.encodeToString(str.getBytes(UTF8), 11);
        }
        throw new NullPointerException("input is marked non-null but is null");
    }

    private Map<String, Object> getDevicePopJwkMinifiedJson() {
        Map<String, Object> jSONObject = AbstractKeyStoreKeyManager.getRsaKeyForKeyPair(AbstractKeyStoreKeyManager.getKeyPairForEntry((KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry())).toPublicJWK().toJSONObject();
        HashMap map = new HashMap();
        map.put("jwk", jSONObject);
        return map;
    }

    @NonNull
    private String getJwkPublicKey() throws ClientException {
        String str;
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getJwkPublicKey", new StringBuilder());
        try {
            return GSON.toJson(getDevicePopJwkMinifiedJson().get("jwk"), MAP_STRING_STRING_TYPE);
        } catch (KeyStoreException e) {
            e = e;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            ClientException clientException = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, clientException.getMessage(), clientException);
            throw clientException;
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            str = "no_such_algorithm";
            ClientException clientException2 = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, clientException2.getMessage(), clientException2);
            throw clientException2;
        } catch (UnrecoverableEntryException e3) {
            e = e3;
            str = ClientException.INVALID_PROTECTION_PARAMS;
            ClientException clientException22 = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, clientException22.getMessage(), clientException22);
            throw clientException22;
        }
    }

    public static Date getNow(@NonNull Calendar calendar) {
        if (calendar != null) {
            return calendar.getTime();
        }
        throw new NullPointerException("calendar is marked non-null but is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getReqCnfForRsaKey(@NonNull RSAKey rSAKey) {
        if (rSAKey == null) {
            throw new NullPointerException("rsaKey is marked non-null but is null");
        }
        return base64UrlEncode(new JSONObject().put("kid", AbstractKeyStoreKeyManager.getThumbprintForRsaKey(rSAKey)).toString());
    }

    private String getX509SubjectPublicKeyInfo() throws ClientException {
        String str;
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getX509SubjectPublicKeyInfo", new StringBuilder());
        try {
            return new String(Base64.encode(AbstractKeyStoreKeyManager.getKeyPairForEntry((KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry()).getPublic().getEncoded(), 0), AuthenticationConstants.CHARSET_UTF8);
        } catch (KeyStoreException e) {
            e = e;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            ClientException clientException = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, clientException.getMessage(), clientException);
            throw clientException;
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            str = "no_such_algorithm";
            ClientException clientException2 = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, clientException2.getMessage(), clientException2);
            throw clientException2;
        } catch (UnrecoverableEntryException e3) {
            e = e3;
            str = ClientException.INVALID_PROTECTION_PARAMS;
            ClientException clientException22 = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, clientException22.getMessage(), clientException22);
            throw clientException22;
        }
    }

    private static boolean isNegativeInternalError(@NonNull Throwable th) {
        if (th == null) {
            throw new NullPointerException("t is marked non-null but is null");
        }
        if (th.getMessage() == null || !th.getMessage().contains(NEGATIVE_THIRTY_THREE_INTERNAL_ERROR_MSG)) {
            return false;
        }
        Logger.info(TAG, "Found internal Keystore code: -33 error.");
        return true;
    }

    private String mintSignedHttpRequestInternal(@Nullable String str, long j, @NonNull URL url, @Nullable String str2, @Nullable String str3, @Nullable String str4) throws ClientException {
        String str5;
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":mintSignedHttpRequestInternal", new StringBuilder());
        try {
            JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
            if (!StringUtil.isNullOrEmpty(str2)) {
                builder.claim(VPathDataCmd.ArcTo, str2);
            }
            builder.claim(DBContract.AckColumns.TIMESTAMP, Long.valueOf(j));
            builder.claim(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE, url.getAuthority());
            builder.claim("cnf", getDevicePopJwkMinifiedJson());
            if (!StringUtil.isNullOrEmpty(url.getPath())) {
                builder.claim("p", url.getPath());
            }
            if (!StringUtil.isNullOrEmpty(str)) {
                builder.claim("m", str);
            }
            if (!StringUtil.isNullOrEmpty(str3)) {
                builder.claim("nonce", str3);
            }
            if (!StringUtil.isNullOrEmpty(str4)) {
                builder.claim(PopAuthenticationSchemeInternal.SerializedNames.CLIENT_CLAIMS, str4);
            }
            JWTClaimsSet jWTClaimsSetBuild = builder.build();
            RSASSASigner rSASSASigner = new RSASSASigner(((KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry()).getPrivateKey());
            SignedJWT signedJWT = new SignedJWT(new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(getAsymmetricKeyThumbprint()).build(), jWTClaimsSetBuild);
            signedJWT.sign(rSASSASigner);
            return signedJWT.serialize();
        } catch (JOSEException e) {
            e = e;
            if (isNegativeInternalError(e) || ((e.getCause() != null && isNegativeInternalError(e.getCause())) || (e.getCause().getCause() != null && isNegativeInternalError(e.getCause().getCause())))) {
                Logger.error(strM1170p, "Getting Invalid key blob, Invalid private RSA key.", e);
                Logger.info(strM1170p, "Unable to access asymmetric key, clearing the key.");
                clearAsymmetricKey();
                Logger.info(strM1170p, "Generating new PoP asymmetric key.");
                String strGenerateAsymmetricKey = generateAsymmetricKey();
                Logger.info(strM1170p, "Generated new PoP asymmetric key.");
                Logger.verbosePII(strM1170p, "Generated new PoP asymmetric key with thumbprint: " + strGenerateAsymmetricKey);
            }
            str5 = ClientException.JWT_SIGNING_FAILURE;
            performCleanupIfMintShrFails(e);
            ClientException clientException = new ClientException(str5, e.getMessage(), e);
            Logger.error(strM1170p, clientException.getMessage(), clientException);
            throw clientException;
        } catch (KeyStoreException e2) {
            e = e2;
            str5 = ClientException.KEYSTORE_NOT_INITIALIZED;
            performCleanupIfMintShrFails(e);
            ClientException clientException2 = new ClientException(str5, e.getMessage(), e);
            Logger.error(strM1170p, clientException2.getMessage(), clientException2);
            throw clientException2;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            str5 = "no_such_algorithm";
            performCleanupIfMintShrFails(e);
            ClientException clientException22 = new ClientException(str5, e.getMessage(), e);
            Logger.error(strM1170p, clientException22.getMessage(), clientException22);
            throw clientException22;
        } catch (UnrecoverableEntryException e5) {
            e = e5;
            str5 = ClientException.INVALID_PROTECTION_PARAMS;
            performCleanupIfMintShrFails(e);
            ClientException clientException222 = new ClientException(str5, e.getMessage(), e);
            Logger.error(strM1170p, clientException222.getMessage(), clientException222);
            throw clientException222;
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public boolean asymmetricKeyExists() {
        return this.mKeyManager.exists();
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public boolean clearAsymmetricKey() {
        return this.mKeyManager.clear();
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String decrypt(@NonNull IDevicePopManager.Cipher cipher, @NonNull String str) {
        if (cipher == null) {
            throw new NullPointerException("cipher is marked non-null but is null");
        }
        if (str != null) {
            return new String(decrypt(cipher, Base64.decode(str, 3)), UTF8);
        }
        throw new NullPointerException("ciphertext is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String encrypt(@NonNull IDevicePopManager.Cipher cipher, @NonNull String str) {
        if (cipher == null) {
            throw new NullPointerException("cipher is marked non-null but is null");
        }
        if (str != null) {
            return Base64.encodeToString(encrypt(cipher, str.getBytes(UTF8)), 3);
        }
        throw new NullPointerException("plaintext is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public void generateAsymmetricKey(@NonNull final TaskCompletedCallbackWithError<String, ClientException> taskCompletedCallbackWithError) {
        if (taskCompletedCallbackWithError == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        sThreadExecutor.submit(new Runnable() { // from class: com.microsoft.identity.common.java.platform.AbstractDevicePopManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    taskCompletedCallbackWithError.onTaskCompleted(AbstractDevicePopManager.this.generateAsymmetricKey());
                } catch (ClientException e) {
                    taskCompletedCallbackWithError.onError(e);
                }
            }
        });
    }

    public abstract KeyPair generateNewRsaKeyPair(int i);

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    @Nullable
    public Date getAsymmetricKeyCreationDate() {
        return this.mKeyManager.getCreationDate();
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String getAsymmetricKeyThumbprint() {
        return new String(this.mKeyManager.getThumbprint(), UTF8);
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public Certificate[] getCertificateChain() {
        return this.mKeyManager.getCertificateChain();
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public IKeyStoreKeyManager<KeyStore.PrivateKeyEntry> getKeyManager() {
        return this.mKeyManager;
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    @NonNull
    public String getPublicKey(@NonNull IDevicePopManager.PublicKeyFormat publicKeyFormat) throws ClientException {
        if (publicKeyFormat == null) {
            throw new NullPointerException("format is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getPublicKey", new StringBuilder());
        int i = C64334.f3603x8bb10b97[publicKeyFormat.ordinal()];
        if (i == 1) {
            return getX509SubjectPublicKeyInfo();
        }
        if (i == 2) {
            return getJwkPublicKey();
        }
        String str = "Unrecognized or unsupported key format: " + publicKeyFormat;
        ClientException clientException = new ClientException(ClientException.UNKNOWN_EXPORT_FORMAT, str);
        Logger.error(strM1170p, str, clientException);
        throw clientException;
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String getRequestConfirmation() throws ClientException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getRequestConfirmation", new StringBuilder());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final String[] strArr = new String[1];
        final ClientException[] clientExceptionArr = new ClientException[1];
        getRequestConfirmation(new TaskCompletedCallbackWithError<String, ClientException>() { // from class: com.microsoft.identity.common.java.platform.AbstractDevicePopManager.2
            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
            public void onError(@NonNull ClientException clientException) {
                if (clientException == null) {
                    throw new NullPointerException("error is marked non-null but is null");
                }
                clientExceptionArr[0] = clientException;
                countDownLatch.countDown();
            }

            @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
            public void onTaskCompleted(@NonNull String str) {
                if (str == null) {
                    throw new NullPointerException("reqCnf is marked non-null but is null");
                }
                strArr[0] = str;
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
            String str = strArr[0];
            if (str != null) {
                return str;
            }
            throw clientExceptionArr[0];
        } catch (InterruptedException e) {
            Logger.error(strM1170p, "Interrupted while waiting on callback.", e);
            throw new ClientException(ClientException.INTERRUPTED_OPERATION, e.getMessage(), e);
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public SecureHardwareState getSecureHardwareState() throws ClientException {
        String str;
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getSecureHardwareState", new StringBuilder());
        try {
            return getSecureHardwareState(AbstractKeyStoreKeyManager.getKeyPairForEntry((KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry()));
        } catch (KeyStoreException e) {
            e = e;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            ClientException clientException = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, str, e);
            throw clientException;
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            str = "no_such_algorithm";
            ClientException clientException2 = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, str, e);
            throw clientException2;
        } catch (UnrecoverableEntryException e3) {
            e = e3;
            str = ClientException.INVALID_PROTECTION_PARAMS;
            ClientException clientException22 = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, str, e);
            throw clientException22;
        }
    }

    public abstract SecureHardwareState getSecureHardwareState(@NonNull KeyPair keyPair);

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String mintSignedAccessToken(@Nullable String str, long j, @NonNull URL url, @NonNull String str2, @Nullable String str3) {
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (str2 != null) {
            return mintSignedAccessToken(str, j, url, str2, str3, null);
        }
        throw new NullPointerException("accessToken is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String mintSignedHttpRequest(@Nullable String str, long j, @NonNull URL url, @Nullable String str2, @Nullable String str3) {
        if (url != null) {
            return mintSignedHttpRequestInternal(str, j, url, null, str2, str3);
        }
        throw new NullPointerException("requestUrl is marked non-null but is null");
    }

    public abstract void performCleanupIfMintShrFails(@NonNull Exception exc);

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    @NonNull
    public String sign(@NonNull SigningAlgorithm signingAlgorithm, @NonNull String str) {
        if (signingAlgorithm == null) {
            throw new NullPointerException("alg is marked non-null but is null");
        }
        if (str != null) {
            return Base64.encodeToString(sign(signingAlgorithm, str.getBytes(UTF8)), 2);
        }
        throw new NullPointerException("input is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public boolean verify(@NonNull SigningAlgorithm signingAlgorithm, @NonNull String str, @NonNull String str2) {
        if (signingAlgorithm == null) {
            throw new NullPointerException("alg is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("plainText is marked non-null but is null");
        }
        if (str2 != null) {
            return verify(signingAlgorithm, str.getBytes(UTF8), Base64.decode(str2, 2));
        }
        throw new NullPointerException("signatureStr is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public boolean asymmetricKeyExists(@NonNull String str) {
        if (str != null) {
            return this.mKeyManager.hasThumbprint(str.getBytes(UTF8));
        }
        throw new NullPointerException("thumbprint is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String generateAsymmetricKey() throws ClientException {
        String str;
        String strM1170p = AbstractC0622a.m1170p(TAG, ":generateAsymmetricKey", new StringBuilder());
        try {
            CodeMarkerManager codeMarkerManager = sCodeMarkerManager;
            codeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_START);
            String thumbprintForRsaKey = AbstractKeyStoreKeyManager.getThumbprintForRsaKey(AbstractKeyStoreKeyManager.getRsaKeyForKeyPair(generateNewRsaKeyPair(2048)));
            codeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            return thumbprintForRsaKey;
        } catch (JOSEException e) {
            e = e;
            str = ClientException.THUMBPRINT_COMPUTATION_FAILURE;
            sCodeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            ClientException clientException = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, clientException.getMessage(), clientException);
            throw clientException;
        } catch (UnsupportedOperationException e2) {
            e = e2;
            str = ClientException.BAD_KEY_SIZE;
            sCodeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            ClientException clientException2 = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, clientException2.getMessage(), clientException2);
            throw clientException2;
        } catch (InvalidAlgorithmParameterException e3) {
            e = e3;
            str = ClientException.INVALID_ALG;
            sCodeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            ClientException clientException22 = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, clientException22.getMessage(), clientException22);
            throw clientException22;
        } catch (KeyStoreException e5) {
            e = e5;
            str = ClientException.KEYSTORE_NOT_INITIALIZED;
            sCodeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            ClientException clientException222 = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, clientException222.getMessage(), clientException222);
            throw clientException222;
        } catch (NoSuchAlgorithmException e6) {
            e = e6;
            str = "no_such_algorithm";
            sCodeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            ClientException clientException2222 = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, clientException2222.getMessage(), clientException2222);
            throw clientException2222;
        } catch (NoSuchProviderException e7) {
            e = e7;
            str = ClientException.ANDROID_KEYSTORE_UNAVAILABLE;
            sCodeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            ClientException clientException22222 = new ClientException(str, e.getMessage(), e);
            Logger.error(strM1170p, clientException22222.getMessage(), clientException22222);
            throw clientException22222;
        } catch (Throwable th) {
            sCodeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.GENERATE_AT_POP_ASYMMETRIC_KEYPAIR_END);
            throw th;
        }
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public byte[] decrypt(@NonNull IDevicePopManager.Cipher cipher, byte[] bArr) throws ClientException {
        String str = "no_such_algorithm";
        if (cipher != null) {
            String strM1170p = AbstractC0622a.m1170p(TAG, ":decrypt", new StringBuilder());
            try {
                PrivateKey privateKey = ((KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry()).getPrivateKey();
                Cipher cipher2 = Cipher.getInstance(cipher.toString());
                if (cipher.getParameters() != null) {
                    cipher2.init(2, privateKey, cipher.getParameters());
                } else {
                    cipher2.init(2, privateKey);
                }
                return cipher2.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e) {
                e = e;
                str = ClientException.INVALID_ALG_PARAMETER;
                ClientException clientException = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException;
            } catch (InvalidKeyException e2) {
                e = e2;
                str = ClientException.INVALID_KEY;
                ClientException clientException2 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException2;
            } catch (KeyStoreException e3) {
                e = e3;
                str = ClientException.KEYSTORE_NOT_INITIALIZED;
                ClientException clientException22 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException22;
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
                ClientException clientException222 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException222;
            } catch (UnrecoverableEntryException e6) {
                e = e6;
                str = ClientException.INVALID_PROTECTION_PARAMS;
                ClientException clientException2222 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException2222;
            } catch (BadPaddingException e7) {
                e = e7;
                str = ClientException.BAD_PADDING;
                ClientException clientException22222 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException22222;
            } catch (IllegalBlockSizeException e8) {
                e = e8;
                str = ClientException.INVALID_BLOCK_SIZE;
                ClientException clientException222222 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException222222;
            } catch (NoSuchPaddingException e9) {
                e = e9;
                ClientException clientException2222222 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException2222222;
            }
        }
        throw new NullPointerException("cipher is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public byte[] encrypt(@NonNull IDevicePopManager.Cipher cipher, @NonNull byte[] bArr) throws ClientException {
        String str;
        if (cipher == null) {
            throw new NullPointerException("cipher is marked non-null but is null");
        }
        if (bArr != null) {
            String strM1170p = AbstractC0622a.m1170p(TAG, ":encrypt", new StringBuilder());
            try {
                PublicKey publicKey = ((KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry()).getCertificate().getPublicKey();
                Cipher cipher2 = Cipher.getInstance(cipher.toString());
                if (cipher.getParameters() != null) {
                    cipher2.init(1, publicKey, cipher.getParameters());
                } else {
                    cipher2.init(1, publicKey);
                }
                return cipher2.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e) {
                e = e;
                str = ClientException.INVALID_ALG_PARAMETER;
                ClientException clientException = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException;
            } catch (InvalidKeyException e2) {
                e = e2;
                str = ClientException.INVALID_KEY;
                ClientException clientException2 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException2;
            } catch (KeyStoreException e3) {
                e = e3;
                str = ClientException.KEYSTORE_NOT_INITIALIZED;
                ClientException clientException22 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException22;
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
                str = "no_such_algorithm";
                ClientException clientException222 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException222;
            } catch (UnrecoverableEntryException e6) {
                e = e6;
                str = ClientException.INVALID_PROTECTION_PARAMS;
                ClientException clientException2222 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException2222;
            } catch (BadPaddingException e7) {
                e = e7;
                str = ClientException.BAD_PADDING;
                ClientException clientException22222 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException22222;
            } catch (IllegalBlockSizeException e8) {
                e = e8;
                str = ClientException.INVALID_BLOCK_SIZE;
                ClientException clientException222222 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException222222;
            } catch (NoSuchPaddingException e9) {
                e = e9;
                str = ClientException.NO_SUCH_PADDING;
                ClientException clientException2222222 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, str, e);
                throw clientException2222222;
            }
        }
        throw new NullPointerException("plaintext is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public String mintSignedAccessToken(@Nullable String str, long j, @NonNull URL url, @NonNull String str2, @Nullable String str3, @Nullable String str4) {
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (str2 != null) {
            return mintSignedHttpRequestInternal(str, j, url, str2, str3, str4);
        }
        throw new NullPointerException("accessToken is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public byte[] sign(@NonNull SigningAlgorithm signingAlgorithm, @NonNull byte[] bArr) throws ClientException {
        String str;
        if (signingAlgorithm == null) {
            throw new NullPointerException("alg is marked non-null but is null");
        }
        if (bArr != null) {
            String strM1170p = AbstractC0622a.m1170p(TAG, ":sign", new StringBuilder());
            try {
                KeyStore.Entry entry = this.mKeyManager.getEntry();
                if (entry instanceof KeyStore.PrivateKeyEntry) {
                    Signature signature = Signature.getInstance(signingAlgorithm.toString());
                    signature.initSign(((KeyStore.PrivateKeyEntry) entry).getPrivateKey());
                    signature.update(bArr);
                    return signature.sign();
                }
                Logger.warn(strM1170p, PRIVATE_KEY_NOT_FOUND);
                throw new ClientException(ClientException.INVALID_KEY_MISSING);
            } catch (InvalidKeyException e) {
                e = e;
                str = ClientException.INVALID_KEY;
                ClientException clientException = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, clientException.getMessage(), clientException);
                throw clientException;
            } catch (KeyStoreException e2) {
                e = e2;
                str = ClientException.KEYSTORE_NOT_INITIALIZED;
                ClientException clientException2 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, clientException2.getMessage(), clientException2);
                throw clientException2;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                str = "no_such_algorithm";
                ClientException clientException22 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, clientException22.getMessage(), clientException22);
                throw clientException22;
            } catch (SignatureException e5) {
                e = e5;
                str = ClientException.SIGNING_FAILURE;
                ClientException clientException222 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, clientException222.getMessage(), clientException222);
                throw clientException222;
            } catch (UnrecoverableEntryException e6) {
                e = e6;
                str = ClientException.INVALID_PROTECTION_PARAMS;
                ClientException clientException2222 = new ClientException(str, e.getMessage(), e);
                Logger.error(strM1170p, clientException2222.getMessage(), clientException2222);
                throw clientException2222;
            }
        }
        throw new NullPointerException("inputBytesToSign is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public boolean verify(@NonNull SigningAlgorithm signingAlgorithm, @NonNull byte[] bArr, @NonNull byte[] bArr2) {
        String str;
        if (signingAlgorithm == null) {
            throw new NullPointerException("alg is marked non-null but is null");
        }
        if (bArr == null) {
            throw new NullPointerException("inputBytesToVerify is marked non-null but is null");
        }
        if (bArr2 != null) {
            String strM1170p = AbstractC0622a.m1170p(TAG, ":verify", new StringBuilder());
            try {
                KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry();
                if (privateKeyEntry == null) {
                    Logger.warn(strM1170p, PRIVATE_KEY_NOT_FOUND);
                    return false;
                }
                Signature signature = Signature.getInstance(signingAlgorithm.toString());
                signature.initVerify(privateKeyEntry.getCertificate());
                signature.update(bArr);
                return signature.verify(bArr2);
            } catch (InvalidKeyException e) {
                e = e;
                str = ClientException.INVALID_KEY;
                Logger.error(strM1170p, str, e);
                return false;
            } catch (KeyStoreException e2) {
                e = e2;
                str = ClientException.KEYSTORE_NOT_INITIALIZED;
                Logger.error(strM1170p, str, e);
                return false;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                str = "no_such_algorithm";
                Logger.error(strM1170p, str, e);
                return false;
            } catch (SignatureException e5) {
                e = e5;
                str = ClientException.SIGNING_FAILURE;
                Logger.error(strM1170p, str, e);
                return false;
            } catch (UnrecoverableEntryException e6) {
                e = e6;
                str = ClientException.INVALID_PROTECTION_PARAMS;
                Logger.error(strM1170p, str, e);
                return false;
            }
        }
        throw new NullPointerException("signatureBytes is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public PublicKey getPublicKey() {
        return ((KeyStore.PrivateKeyEntry) this.mKeyManager.getEntry()).getCertificate().getPublicKey();
    }

    @Override // com.microsoft.identity.common.java.crypto.IDevicePopManager
    public void getRequestConfirmation(@NonNull final TaskCompletedCallbackWithError<String, ClientException> taskCompletedCallbackWithError) {
        if (taskCompletedCallbackWithError != null) {
            final String strM1170p = AbstractC0622a.m1170p(TAG, ":getRequestConfirmation", new StringBuilder());
            sThreadExecutor.submit(new Runnable() { // from class: com.microsoft.identity.common.java.platform.AbstractDevicePopManager.3
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    try {
                        taskCompletedCallbackWithError.onTaskCompleted(AbstractDevicePopManager.getReqCnfForRsaKey(AbstractKeyStoreKeyManager.getRsaKeyForKeyPair(AbstractKeyStoreKeyManager.getKeyPairForEntry((KeyStore.PrivateKeyEntry) AbstractDevicePopManager.this.mKeyManager.getEntry()))));
                    } catch (JOSEException e) {
                        e = e;
                        str = ClientException.THUMBPRINT_COMPUTATION_FAILURE;
                        ClientException clientException = new ClientException(str, e.getMessage(), e);
                        Logger.error(strM1170p, clientException.getMessage(), clientException);
                        taskCompletedCallbackWithError.onError(clientException);
                    } catch (KeyStoreException e2) {
                        e = e2;
                        str = ClientException.KEYSTORE_NOT_INITIALIZED;
                        ClientException clientException2 = new ClientException(str, e.getMessage(), e);
                        Logger.error(strM1170p, clientException2.getMessage(), clientException2);
                        taskCompletedCallbackWithError.onError(clientException2);
                    } catch (NoSuchAlgorithmException e3) {
                        e = e3;
                        str = "no_such_algorithm";
                        ClientException clientException22 = new ClientException(str, e.getMessage(), e);
                        Logger.error(strM1170p, clientException22.getMessage(), clientException22);
                        taskCompletedCallbackWithError.onError(clientException22);
                    } catch (UnrecoverableEntryException e5) {
                        e = e5;
                        str = ClientException.INVALID_PROTECTION_PARAMS;
                        ClientException clientException222 = new ClientException(str, e.getMessage(), e);
                        Logger.error(strM1170p, clientException222.getMessage(), clientException222);
                        taskCompletedCallbackWithError.onError(clientException222);
                    } catch (JSONException e6) {
                        e = e6;
                        str = ClientException.JSON_CONSTRUCTION_FAILED;
                        ClientException clientException2222 = new ClientException(str, e.getMessage(), e);
                        Logger.error(strM1170p, clientException2222.getMessage(), clientException2222);
                        taskCompletedCallbackWithError.onError(clientException2222);
                    }
                }
            });
            return;
        }
        throw new NullPointerException("callback is marked non-null but is null");
    }
}
