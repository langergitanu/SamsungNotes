package com.nimbusds.jose;

import com.nimbusds.jose.crypto.impl.AAD;
import com.nimbusds.jose.util.Base64URL;
import java.text.ParseException;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class JWEObject extends JOSEObject {
    private static final long serialVersionUID = 1;
    private Base64URL authTag;
    private Base64URL cipherText;
    private Base64URL encryptedKey;
    private JWEHeader header;

    /* JADX INFO: renamed from: iv */
    private Base64URL f3622iv;
    private State state;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        UNENCRYPTED,
        ENCRYPTED,
        DECRYPTED
    }

    public JWEObject(JWEHeader jWEHeader, Payload payload) {
        if (jWEHeader == null) {
            throw new IllegalArgumentException("The JWE header must not be null");
        }
        this.header = jWEHeader;
        if (payload == null) {
            throw new IllegalArgumentException("The payload must not be null");
        }
        setPayload(payload);
        this.encryptedKey = null;
        this.cipherText = null;
        this.state = State.UNENCRYPTED;
    }

    private void ensureEncryptedOrDecryptedState() {
        State state = this.state;
        if (state != State.ENCRYPTED && state != State.DECRYPTED) {
            throw new IllegalStateException("The JWE object must be in an encrypted or decrypted state");
        }
    }

    private void ensureEncryptedState() {
        if (this.state != State.ENCRYPTED) {
            throw new IllegalStateException("The JWE object must be in an encrypted state");
        }
    }

    private void ensureJWEEncrypterSupport(JWEEncrypter jWEEncrypter) throws JOSEException {
        if (!jWEEncrypter.supportedJWEAlgorithms().contains(getHeader().getAlgorithm())) {
            throw new JOSEException("The " + getHeader().getAlgorithm() + " algorithm is not supported by the JWE encrypter: Supported algorithms: " + jWEEncrypter.supportedJWEAlgorithms());
        }
        if (jWEEncrypter.supportedEncryptionMethods().contains(getHeader().getEncryptionMethod())) {
            return;
        }
        throw new JOSEException("The " + getHeader().getEncryptionMethod() + " encryption method or key size is not supported by the JWE encrypter: Supported methods: " + jWEEncrypter.supportedEncryptionMethods());
    }

    private void ensureUnencryptedState() {
        if (this.state != State.UNENCRYPTED) {
            throw new IllegalStateException("The JWE object must be in an unencrypted state");
        }
    }

    public static JWEObject parse(String str) throws ParseException {
        Base64URL[] base64URLArrSplit = JOSEObject.split(str);
        if (base64URLArrSplit.length == 5) {
            return new JWEObject(base64URLArrSplit[0], base64URLArrSplit[1], base64URLArrSplit[2], base64URLArrSplit[3], base64URLArrSplit[4]);
        }
        throw new ParseException("Unexpected number of Base64URL parts, must be five", 0);
    }

    public synchronized void decrypt(JWEDecrypter jWEDecrypter) {
        ensureEncryptedState();
        try {
            try {
                setPayload(new Payload(jWEDecrypter.decrypt(getHeader(), getEncryptedKey(), getIV(), getCipherText(), getAuthTag(), AAD.compute(getHeader()))));
                this.state = State.DECRYPTED;
            } catch (JOSEException e) {
                throw e;
            }
        } catch (Exception e2) {
            throw new JOSEException(e2.getMessage(), e2);
        }
    }

    public synchronized void encrypt(JWEEncrypter jWEEncrypter) {
        try {
            ensureUnencryptedState();
            ensureJWEEncrypterSupport(jWEEncrypter);
            try {
                JWECryptoParts jWECryptoPartsEncrypt = jWEEncrypter.encrypt(getHeader(), getPayload().toBytes(), AAD.compute(getHeader()));
                if (jWECryptoPartsEncrypt.getHeader() != null) {
                    this.header = jWECryptoPartsEncrypt.getHeader();
                }
                this.encryptedKey = jWECryptoPartsEncrypt.getEncryptedKey();
                this.f3622iv = jWECryptoPartsEncrypt.getInitializationVector();
                this.cipherText = jWECryptoPartsEncrypt.getCipherText();
                this.authTag = jWECryptoPartsEncrypt.getAuthenticationTag();
                this.state = State.ENCRYPTED;
            } catch (JOSEException e) {
                throw e;
            } catch (Exception e2) {
                throw new JOSEException(e2.getMessage(), e2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public Base64URL getAuthTag() {
        return this.authTag;
    }

    public Base64URL getCipherText() {
        return this.cipherText;
    }

    public Base64URL getEncryptedKey() {
        return this.encryptedKey;
    }

    public Base64URL getIV() {
        return this.f3622iv;
    }

    public State getState() {
        return this.state;
    }

    @Override // com.nimbusds.jose.JOSEObject
    public String serialize() {
        ensureEncryptedOrDecryptedState();
        StringBuilder sb = new StringBuilder(this.header.toBase64URL().toString());
        sb.append('.');
        Base64URL base64URL = this.encryptedKey;
        if (base64URL != null) {
            sb.append(base64URL);
        }
        sb.append('.');
        Base64URL base64URL2 = this.f3622iv;
        if (base64URL2 != null) {
            sb.append(base64URL2);
        }
        sb.append('.');
        sb.append(this.cipherText);
        sb.append('.');
        Base64URL base64URL3 = this.authTag;
        if (base64URL3 != null) {
            sb.append(base64URL3);
        }
        return sb.toString();
    }

    @Override // com.nimbusds.jose.JOSEObject
    public JWEHeader getHeader() {
        return this.header;
    }

    public JWEObject(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5) throws ParseException {
        if (base64URL != null) {
            try {
                this.header = JWEHeader.parse(base64URL);
                if (base64URL2 != null && !base64URL2.toString().isEmpty()) {
                    this.encryptedKey = base64URL2;
                } else {
                    this.encryptedKey = null;
                }
                if (base64URL3 != null && !base64URL3.toString().isEmpty()) {
                    this.f3622iv = base64URL3;
                } else {
                    this.f3622iv = null;
                }
                if (base64URL4 != null) {
                    this.cipherText = base64URL4;
                    if (base64URL5 != null && !base64URL5.toString().isEmpty()) {
                        this.authTag = base64URL5;
                    } else {
                        this.authTag = null;
                    }
                    this.state = State.ENCRYPTED;
                    setParsedParts(base64URL, base64URL2, base64URL3, base64URL4, base64URL5);
                    return;
                }
                throw new IllegalArgumentException("The fourth part must not be null");
            } catch (ParseException e) {
                throw new ParseException("Invalid JWE header: " + e.getMessage(), 0);
            }
        }
        throw new IllegalArgumentException("The first part must not be null");
    }
}
