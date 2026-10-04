package com.nimbusds.jose.crypto.factories;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.KeyTypeException;
import com.nimbusds.jose.crypto.AESDecrypter;
import com.nimbusds.jose.crypto.DirectDecrypter;
import com.nimbusds.jose.crypto.ECDHDecrypter;
import com.nimbusds.jose.crypto.PasswordBasedDecrypter;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.impl.AESCryptoProvider;
import com.nimbusds.jose.crypto.impl.DirectCryptoProvider;
import com.nimbusds.jose.crypto.impl.ECDHCryptoProvider;
import com.nimbusds.jose.crypto.impl.PasswordBasedCryptoProvider;
import com.nimbusds.jose.crypto.impl.RSACryptoProvider;
import com.nimbusds.jose.jca.JWEJCAContext;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.proc.JWEDecrypterFactory;
import java.security.Key;
import java.security.PrivateKey;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
public class DefaultJWEDecrypterFactory implements JWEDecrypterFactory {
    public static final Set<JWEAlgorithm> SUPPORTED_ALGORITHMS;
    public static final Set<EncryptionMethod> SUPPORTED_ENCRYPTION_METHODS;
    private final JWEJCAContext jcaContext = new JWEJCAContext();

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(RSACryptoProvider.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(ECDHCryptoProvider.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(DirectCryptoProvider.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(AESCryptoProvider.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(PasswordBasedCryptoProvider.SUPPORTED_ALGORITHMS);
        SUPPORTED_ALGORITHMS = Collections.unmodifiableSet(linkedHashSet);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        linkedHashSet2.addAll(RSACryptoProvider.SUPPORTED_ENCRYPTION_METHODS);
        linkedHashSet2.addAll(ECDHCryptoProvider.SUPPORTED_ENCRYPTION_METHODS);
        linkedHashSet2.addAll(DirectCryptoProvider.SUPPORTED_ENCRYPTION_METHODS);
        linkedHashSet2.addAll(AESCryptoProvider.SUPPORTED_ENCRYPTION_METHODS);
        linkedHashSet2.addAll(PasswordBasedCryptoProvider.SUPPORTED_ENCRYPTION_METHODS);
        SUPPORTED_ENCRYPTION_METHODS = Collections.unmodifiableSet(linkedHashSet2);
    }

    @Override // com.nimbusds.jose.proc.JWEDecrypterFactory
    public JWEDecrypter createJWEDecrypter(JWEHeader jWEHeader, Key key) throws JOSEException {
        JWEDecrypter passwordBasedDecrypter;
        JWEDecrypter aESDecrypter;
        if (!RSACryptoProvider.SUPPORTED_ALGORITHMS.contains(jWEHeader.getAlgorithm()) || !RSACryptoProvider.SUPPORTED_ENCRYPTION_METHODS.contains(jWEHeader.getEncryptionMethod())) {
            if (ECDHCryptoProvider.SUPPORTED_ALGORITHMS.contains(jWEHeader.getAlgorithm()) && ECDHCryptoProvider.SUPPORTED_ENCRYPTION_METHODS.contains(jWEHeader.getEncryptionMethod())) {
                if (!(key instanceof PrivateKey) || !(key instanceof ECKey)) {
                    throw new KeyTypeException(PrivateKey.class, ECKey.class);
                }
                aESDecrypter = new ECDHDecrypter((PrivateKey) key, null, Curve.forECParameterSpec(((ECKey) key).getParams()));
            } else if (DirectCryptoProvider.SUPPORTED_ALGORITHMS.contains(jWEHeader.getAlgorithm()) && DirectCryptoProvider.SUPPORTED_ENCRYPTION_METHODS.contains(jWEHeader.getEncryptionMethod())) {
                if (!(key instanceof SecretKey)) {
                    throw new KeyTypeException(SecretKey.class);
                }
                aESDecrypter = new DirectDecrypter((SecretKey) key);
                if (!aESDecrypter.supportedEncryptionMethods().contains(jWEHeader.getEncryptionMethod())) {
                    throw new KeyLengthException(jWEHeader.getEncryptionMethod().cekBitLength(), jWEHeader.getEncryptionMethod());
                }
            } else if (AESCryptoProvider.SUPPORTED_ALGORITHMS.contains(jWEHeader.getAlgorithm()) && AESCryptoProvider.SUPPORTED_ENCRYPTION_METHODS.contains(jWEHeader.getEncryptionMethod())) {
                if (!(key instanceof SecretKey)) {
                    throw new KeyTypeException(SecretKey.class);
                }
                aESDecrypter = new AESDecrypter((SecretKey) key);
                if (!aESDecrypter.supportedJWEAlgorithms().contains(jWEHeader.getAlgorithm())) {
                    throw new KeyLengthException(jWEHeader.getAlgorithm());
                }
            } else {
                if (!PasswordBasedCryptoProvider.SUPPORTED_ALGORITHMS.contains(jWEHeader.getAlgorithm()) || !PasswordBasedCryptoProvider.SUPPORTED_ENCRYPTION_METHODS.contains(jWEHeader.getEncryptionMethod())) {
                    throw new JOSEException("Unsupported JWE algorithm or encryption method");
                }
                if (!(key instanceof SecretKey)) {
                    throw new KeyTypeException(SecretKey.class);
                }
                passwordBasedDecrypter = new PasswordBasedDecrypter(key.getEncoded());
            }
            passwordBasedDecrypter = aESDecrypter;
        } else {
            if (!(key instanceof PrivateKey) || !(key instanceof RSAKey)) {
                throw new KeyTypeException(PrivateKey.class, RSAKey.class);
            }
            passwordBasedDecrypter = new RSADecrypter((PrivateKey) key);
        }
        passwordBasedDecrypter.getJCAContext().setSecureRandom(this.jcaContext.getSecureRandom());
        passwordBasedDecrypter.getJCAContext().setProvider(this.jcaContext.getProvider());
        passwordBasedDecrypter.getJCAContext().setKeyEncryptionProvider(this.jcaContext.getKeyEncryptionProvider());
        passwordBasedDecrypter.getJCAContext().setMACProvider(this.jcaContext.getMACProvider());
        passwordBasedDecrypter.getJCAContext().setContentEncryptionProvider(this.jcaContext.getContentEncryptionProvider());
        return passwordBasedDecrypter;
    }

    @Override // com.nimbusds.jose.JWEProvider
    public Set<EncryptionMethod> supportedEncryptionMethods() {
        return SUPPORTED_ENCRYPTION_METHODS;
    }

    @Override // com.nimbusds.jose.JWEProvider
    public Set<JWEAlgorithm> supportedJWEAlgorithms() {
        return SUPPORTED_ALGORITHMS;
    }

    @Override // com.nimbusds.jose.jca.JCAAware
    public JWEJCAContext getJCAContext() {
        return this.jcaContext;
    }
}
