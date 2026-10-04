package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.application.BadResponseException;
import com.yubico.yubikit.core.smartcard.ApduException;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.PinPolicy;
import com.yubico.yubikit.piv.PivSession;
import com.yubico.yubikit.piv.Slot;
import com.yubico.yubikit.piv.SlotMetadata;
import com.yubico.yubikit.piv.TouchPolicy;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PivKeyStoreSpi extends KeyStoreSpi {
    private final Callback<Callback<Result<PivSession, Exception>>> provider;

    public PivKeyStoreSpi(Callback<Callback<Result<PivSession, Exception>>> callback) {
        this.provider = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$engineDeleteEntry$8(Result result, Slot slot) {
        ((PivSession) result.getValue()).deleteCertificate(slot);
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$engineDeleteEntry$9(BlockingQueue blockingQueue, Slot slot, Result result) {
        blockingQueue.add(Result.m13504of(new CallableC11920a(result, slot, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ X509Certificate lambda$engineGetCertificate$4(Result result, Slot slot) {
        return ((PivSession) result.getValue()).getCertificate(slot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$engineGetCertificate$5(BlockingQueue blockingQueue, Slot slot, Result result) {
        blockingQueue.add(Result.m13504of(new CallableC11920a(result, slot, 1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ KeyStore.Entry lambda$engineGetEntry$6(Result result, Slot slot, KeyStore.ProtectionParameter protectionParameter) {
        PivPrivateKey pivPrivateKeyFrom;
        PivSession pivSession = (PivSession) result.getValue();
        X509Certificate certificate = pivSession.getCertificate(slot);
        char[] password = protectionParameter instanceof KeyStore.PasswordProtection ? ((KeyStore.PasswordProtection) protectionParameter).getPassword() : null;
        if (pivSession.supports(PivSession.FEATURE_METADATA)) {
            SlotMetadata slotMetadata = pivSession.getSlotMetadata(slot);
            pivPrivateKeyFrom = PivPrivateKey.from(slotMetadata.getPublicKey(), slot, slotMetadata.getPinPolicy(), slotMetadata.getTouchPolicy(), password);
        } else {
            pivPrivateKeyFrom = PivPrivateKey.from(certificate.getPublicKey(), slot, null, null, password);
        }
        return new KeyStore.PrivateKeyEntry(pivPrivateKeyFrom, new Certificate[]{certificate});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$engineGetEntry$7(BlockingQueue blockingQueue, Slot slot, KeyStore.ProtectionParameter protectionParameter, Result result) {
        blockingQueue.add(Result.m13504of(new CallableC11925f(result, slot, protectionParameter, 2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PivPrivateKey lambda$engineGetKey$2(Result result, Slot slot, char[] cArr) {
        PivSession pivSession = (PivSession) result.getValue();
        if (!pivSession.supports(PivSession.FEATURE_METADATA)) {
            return PivPrivateKey.from(pivSession.getCertificate(slot).getPublicKey(), slot, null, null, cArr);
        }
        SlotMetadata slotMetadata = pivSession.getSlotMetadata(slot);
        return PivPrivateKey.from(slotMetadata.getPublicKey(), slot, slotMetadata.getPinPolicy(), slotMetadata.getTouchPolicy(), cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$engineGetKey$3(BlockingQueue blockingQueue, Slot slot, char[] cArr, Result result) {
        blockingQueue.add(Result.m13504of(new CallableC11925f(result, slot, cArr, 1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$putEntry$0(Result result, PrivateKey privateKey, Slot slot, PinPolicy pinPolicy, TouchPolicy touchPolicy, X509Certificate x509Certificate) {
        PivSession pivSession = (PivSession) result.getValue();
        if (privateKey != null) {
            pivSession.putKey(slot, privateKey, pinPolicy, touchPolicy);
        }
        if (x509Certificate != null) {
            pivSession.putCertificate(slot, x509Certificate);
        }
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$putEntry$1(BlockingQueue blockingQueue, final PrivateKey privateKey, final Slot slot, final PinPolicy pinPolicy, final TouchPolicy touchPolicy, final X509Certificate x509Certificate, final Result result) {
        blockingQueue.add(Result.m13504of(new Callable() { // from class: com.yubico.yubikit.piv.jca.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PivKeyStoreSpi.lambda$putEntry$0(result, privateKey, slot, pinPolicy, touchPolicy, x509Certificate);
            }
        }));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    private void putEntry(final Slot slot, @Nullable final PrivateKey privateKey, final PinPolicy pinPolicy, final TouchPolicy touchPolicy, @Nullable final X509Certificate x509Certificate) throws E {
        final ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        this.provider.invoke(new Callback() { // from class: com.yubico.yubikit.piv.jca.d
            @Override // com.yubico.yubikit.core.util.Callback
            public final void invoke(Object obj) {
                PivKeyStoreSpi.lambda$putEntry$1(arrayBlockingQueue, privateKey, slot, pinPolicy, touchPolicy, x509Certificate, (Result) obj);
            }
        });
        ((Result) arrayBlockingQueue.take()).getValue();
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration<String> engineAliases() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        try {
            Slot.fromStringAlias(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) throws E, KeyStoreException {
        Slot slotFromStringAlias = Slot.fromStringAlias(str);
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        this.provider.invoke(new C11922c(arrayBlockingQueue, slotFromStringAlias, 0));
        try {
            ((Result) arrayBlockingQueue.take()).getValue();
        } catch (Exception e) {
            throw new KeyStoreException(e);
        }
    }

    @Override // java.security.KeyStoreSpi
    @Nullable
    public Certificate engineGetCertificate(String str) {
        Slot slotFromStringAlias = Slot.fromStringAlias(str);
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        this.provider.invoke(new C11922c(arrayBlockingQueue, slotFromStringAlias, 1));
        try {
            return (Certificate) ((Result) arrayBlockingQueue.take()).getValue();
        } catch (BadResponseException unused) {
            return null;
        } catch (ApduException e) {
            if (e.getSw() == 27266) {
                return null;
            }
            throw new RuntimeException(e);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // java.security.KeyStoreSpi
    @Nullable
    public String engineGetCertificateAlias(Certificate certificate) {
        for (Slot slot : Slot.values()) {
            String stringAlias = slot.getStringAlias();
            if (certificate.equals(engineGetCertificate(stringAlias))) {
                return stringAlias;
            }
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String str) {
        return new Certificate[]{engineGetCertificate(str)};
    }

    @Override // java.security.KeyStoreSpi
    @Nullable
    public Date engineGetCreationDate(String str) {
        return null;
    }

    @Override // java.security.KeyStoreSpi
    @Nullable
    public KeyStore.Entry engineGetEntry(String str, KeyStore.ProtectionParameter protectionParameter) throws UnrecoverableEntryException {
        Slot slotFromStringAlias = Slot.fromStringAlias(str);
        try {
            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
            this.provider.invoke(new C11924e(arrayBlockingQueue, slotFromStringAlias, protectionParameter, 1));
            return (KeyStore.Entry) ((Result) arrayBlockingQueue.take()).getValue();
        } catch (BadResponseException unused) {
            throw new UnrecoverableEntryException("Make sure the matching certificate is stored");
        } catch (ApduException e) {
            if (e.getSw() == 27266) {
                return null;
            }
            throw new RuntimeException(e);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // java.security.KeyStoreSpi
    @Nullable
    public Key engineGetKey(String str, char[] cArr) throws UnrecoverableKeyException {
        Slot slotFromStringAlias = Slot.fromStringAlias(str);
        try {
            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
            this.provider.invoke(new C11924e(arrayBlockingQueue, slotFromStringAlias, cArr, 2));
            return (Key) ((Result) arrayBlockingQueue.take()).getValue();
        } catch (BadResponseException unused) {
            throw new UnrecoverableKeyException("No way to infer KeyType, make sure the matching certificate is stored");
        } catch (ApduException e) {
            if (e.getSw() == 27266) {
                return null;
            }
            throw new RuntimeException(e);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        return engineGetCertificate(str) != null;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        return engineContainsAlias(str);
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream inputStream, char[] cArr) {
        throw new InvalidParameterException("KeyStore must be loaded with a null LoadStoreParameter");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) throws E, KeyStoreException {
        Slot slotFromStringAlias = Slot.fromStringAlias(str);
        if (!(certificate instanceof X509Certificate)) {
            throw new KeyStoreException("Certificate must be X509Certificate");
        }
        try {
            putEntry(slotFromStringAlias, null, PinPolicy.DEFAULT, TouchPolicy.DEFAULT, (X509Certificate) certificate);
        } catch (Exception e) {
            throw new KeyStoreException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    @Override // java.security.KeyStoreSpi
    public void engineSetEntry(String str, KeyStore.Entry entry, @Nullable KeyStore.ProtectionParameter protectionParameter) throws E, KeyStoreException {
        Certificate certificate;
        PrivateKey privateKey;
        Slot slotFromStringAlias = Slot.fromStringAlias(str);
        if (entry instanceof KeyStore.TrustedCertificateEntry) {
            if (protectionParameter != null) {
                throw new KeyStoreException("Certificate cannot use protParam");
            }
            certificate = ((KeyStore.TrustedCertificateEntry) entry).getTrustedCertificate();
            privateKey = null;
        } else {
            if (!(entry instanceof KeyStore.PrivateKeyEntry)) {
                throw new KeyStoreException("Unsupported KeyStore entry.");
            }
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) entry;
            certificate = privateKeyEntry.getCertificate();
            privateKey = privateKeyEntry.getPrivateKey();
        }
        PrivateKey privateKey2 = privateKey;
        if (certificate != null && !(certificate instanceof X509Certificate)) {
            throw new KeyStoreException("Certificate must be X509Certificate");
        }
        PinPolicy pinPolicy = PinPolicy.DEFAULT;
        TouchPolicy touchPolicy = TouchPolicy.DEFAULT;
        if (privateKey2 != null && protectionParameter != null) {
            if (!(protectionParameter instanceof PivKeyStoreKeyParameters)) {
                throw new KeyStoreException("protParam must be an instance of PivKeyStoreKeyParameters");
            }
            PivKeyStoreKeyParameters pivKeyStoreKeyParameters = (PivKeyStoreKeyParameters) protectionParameter;
            pinPolicy = pivKeyStoreKeyParameters.pinPolicy;
            touchPolicy = pivKeyStoreKeyParameters.touchPolicy;
        }
        try {
            putEntry(slotFromStringAlias, privateKey2, pinPolicy, touchPolicy, (X509Certificate) certificate);
        } catch (Exception e) {
            throw new KeyStoreException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, @Nullable char[] cArr, Certificate[] certificateArr) throws E, KeyStoreException {
        Slot slotFromStringAlias = Slot.fromStringAlias(str);
        if (cArr != null) {
            throw new KeyStoreException("Password can not be set");
        }
        if (certificateArr.length != 1) {
            throw new KeyStoreException("Certificate chain must be a single certificate, or empty");
        }
        Certificate certificate = certificateArr[0];
        if (!(certificate instanceof X509Certificate)) {
            throw new KeyStoreException("Certificate must be X509Certificate");
        }
        try {
            putEntry(slotFromStringAlias, (PrivateKey) key, PinPolicy.DEFAULT, TouchPolicy.DEFAULT, (X509Certificate) certificate);
        } catch (Exception e) {
            throw new KeyStoreException(e);
        }
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        return Slot.values().length;
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(@Nullable KeyStore.LoadStoreParameter loadStoreParameter) {
        if (loadStoreParameter != null) {
            throw new InvalidParameterException("KeyStore must be loaded with null");
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new KeyStoreException("Use setKeyEntry with a PrivateKey instance instead of byte[]");
    }
}
