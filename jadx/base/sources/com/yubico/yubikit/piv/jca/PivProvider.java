package com.yubico.yubikit.piv.jca;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import com.yubico.yubikit.android.transport.usb.C11894b;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.KeyType;
import com.yubico.yubikit.piv.PivSession;
import com.yubico.yubikit.piv.jca.PivEcSignatureSpi;
import com.yubico.yubikit.piv.jca.PivKeyPairGeneratorSpi;
import com.yubico.yubikit.piv.jca.PivPrivateKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.crypto.NoSuchPaddingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PivProvider extends Provider {
    private final Map<KeyType, KeyPair> rsaDummyKeys;
    private final Callback<Callback<Result<PivSession, Exception>>> sessionRequester;
    private static final Map<String, String> ecAttributes = Collections.singletonMap("SupportedKeyClasses", PivPrivateKey.EcKey.class.getName());
    private static final Map<String, String> rsaAttributes = Collections.singletonMap("SupportedKeyClasses", PivPrivateKey.RsaKey.class.getName());
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) PivProvider.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PivEcSignatureService extends Provider.Service {
        private final String digest;

        public PivEcSignatureService(String str, String str2, @Nullable List<String> list) {
            super(PivProvider.this, "Signature", str, PivEcSignatureSpi.Hashed.class.getName(), list, PivProvider.ecAttributes);
            this.digest = str2;
        }

        @Override // java.security.Provider.Service
        public Object newInstance(Object obj) {
            return new PivEcSignatureSpi.Hashed(PivProvider.this.sessionRequester, this.digest);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PivRsaCipherService extends Provider.Service {
        public PivRsaCipherService() {
            super(PivProvider.this, "Cipher", AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA, PivCipherSpi.class.getName(), null, PivProvider.rsaAttributes);
        }

        @Override // java.security.Provider.Service
        public Object newInstance(Object obj) throws NoSuchAlgorithmException {
            try {
                return new PivCipherSpi(PivProvider.this.sessionRequester, PivProvider.this.rsaDummyKeys);
            } catch (NoSuchPaddingException e) {
                throw new NoSuchAlgorithmException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PivRsaSignatureService extends Provider.Service {
        public PivRsaSignatureService(String str) {
            super(PivProvider.this, "Signature", str, PivRsaSignatureSpi.class.getName(), null, PivProvider.rsaAttributes);
        }

        @Override // java.security.Provider.Service
        public Object newInstance(Object obj) throws NoSuchAlgorithmException {
            try {
                return new PivRsaSignatureSpi(PivProvider.this.sessionRequester, PivProvider.this.rsaDummyKeys, getAlgorithm());
            } catch (NoSuchPaddingException unused) {
                throw new NoSuchAlgorithmException("No underlying Provider supporting " + getAlgorithm() + " available.");
            }
        }
    }

    public PivProvider(PivSession pivSession) {
        this(new C11894b(pivSession, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(PivSession pivSession, Callback callback) {
        callback.invoke(Result.success(pivSession));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000f  */
    @Override // java.util.Hashtable, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean equals(Object obj) {
        boolean z;
        if (obj instanceof PivProvider) {
            z = super.equals(obj);
        }
        return z;
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized int hashCode() {
        return super.hashCode();
    }

    public PivProvider(final Callback<Callback<Result<PivSession, Exception>>> callback) {
        super("YKPiv", 1.0d, "JCA Provider for YubiKey PIV");
        this.rsaDummyKeys = new HashMap();
        this.sessionRequester = callback;
        Logger logger2 = logger;
        Map<String, String> map = ecAttributes;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "EC attributes: {}", map);
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "RSA attributes: {}", rsaAttributes);
        putService(new Provider.Service(this, "Signature", "NONEwithECDSA", PivEcSignatureSpi.Prehashed.class.getName(), null, map) { // from class: com.yubico.yubikit.piv.jca.PivProvider.1
            @Override // java.security.Provider.Service
            public Object newInstance(Object obj) {
                return new PivEcSignatureSpi.Prehashed(callback);
            }
        });
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA);
            long jCurrentTimeMillis = System.currentTimeMillis();
            KeyType[] keyTypeArr = {KeyType.RSA1024, KeyType.RSA2048};
            for (int i = 0; i < 2; i++) {
                KeyType keyType = keyTypeArr[i];
                keyPairGenerator.initialize(keyType.params.bitLength);
                this.rsaDummyKeys.put(keyType, keyPairGenerator.generateKeyPair());
            }
            com.yubico.yubikit.core.internal.Logger.debug(logger, "Time taken to generate dummy RSA keys: {}ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            putService(new PivRsaCipherService());
        } catch (NoSuchAlgorithmException e) {
            com.yubico.yubikit.core.internal.Logger.error(logger, "Unable to support RSA, no underlying Provider with RSA capability", e);
        }
        Set<String> algorithms = Security.getAlgorithms("MessageDigest");
        Iterator<String> it = Security.getAlgorithms("Signature").iterator();
        while (it.hasNext()) {
            String upperCase = it.next().toUpperCase();
            if (upperCase.endsWith("WITHECDSA")) {
                String strM1614d = AbstractC2322a.m1614d(9, 0, upperCase);
                strM1614d = algorithms.contains(strM1614d) ? strM1614d : strM1614d.replace("SHA", "SHA-");
                if (algorithms.contains(strM1614d)) {
                    putService(new PivEcSignatureService(upperCase, strM1614d, null));
                }
            } else if (!this.rsaDummyKeys.isEmpty() && upperCase.endsWith("WITHRSA")) {
                putService(new PivRsaSignatureService(upperCase));
            } else if (!this.rsaDummyKeys.isEmpty() && upperCase.endsWith("PSS")) {
                putService(new PivRsaSignatureService(upperCase));
            } else if (upperCase.equals("ECDSA")) {
                putService(new PivEcSignatureService("ECDSA", IDevicePopManager.SHA_1, Collections.singletonList("SHA1withECDSA")));
            }
        }
        List list = null;
        Map map2 = null;
        putService(new Provider.Service(this, "KeyPairGenerator", "YKPivRSA", PivKeyPairGeneratorSpi.Rsa.class.getName(), list, map2) { // from class: com.yubico.yubikit.piv.jca.PivProvider.2
            @Override // java.security.Provider.Service
            public Object newInstance(Object obj) {
                return new PivKeyPairGeneratorSpi.Rsa(callback);
            }
        });
        putService(new Provider.Service(this, "KeyPairGenerator", "YKPivEC", PivKeyPairGeneratorSpi.C11913Ec.class.getName(), list, map2) { // from class: com.yubico.yubikit.piv.jca.PivProvider.3
            @Override // java.security.Provider.Service
            public Object newInstance(Object obj) {
                return new PivKeyPairGeneratorSpi.C11913Ec(callback);
            }
        });
        putService(new Provider.Service(this, "KeyStore", "YKPiv", PivKeyStoreSpi.class.getName(), list, map2) { // from class: com.yubico.yubikit.piv.jca.PivProvider.4
            @Override // java.security.Provider.Service
            public Object newInstance(Object obj) {
                return new PivKeyStoreSpi(callback);
            }
        });
        putService(new Provider.Service(this, "KeyAgreement", "ECDH", PivKeyAgreementSpi.class.getName(), list, ecAttributes) { // from class: com.yubico.yubikit.piv.jca.PivProvider.5
            @Override // java.security.Provider.Service
            public Object newInstance(Object obj) {
                return new PivKeyAgreementSpi(callback);
            }
        });
    }
}
