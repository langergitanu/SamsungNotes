package com.nimbusds.jwt.proc;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.factories.DefaultJWEDecrypterFactory;
import com.nimbusds.jose.crypto.factories.DefaultJWSVerifierFactory;
import com.nimbusds.jose.proc.BadJOSEException;
import com.nimbusds.jose.proc.BadJWEException;
import com.nimbusds.jose.proc.BadJWSException;
import com.nimbusds.jose.proc.DefaultJOSEObjectTypeVerifier;
import com.nimbusds.jose.proc.JOSEObjectTypeVerifier;
import com.nimbusds.jose.proc.JWEDecrypterFactory;
import com.nimbusds.jose.proc.JWEKeySelector;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerifierFactory;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.PlainJWT;
import com.nimbusds.jwt.SignedJWT;
import java.security.Key;
import java.text.ParseException;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DefaultJWTProcessor<C extends SecurityContext> implements ConfigurableJWTProcessor<C> {
    private JWTClaimsSetAwareJWSKeySelector<C> claimsSetAwareJWSKeySelector;
    private JWTClaimsSetVerifier<C> claimsVerifier;
    private JWEDecrypterFactory jweDecrypterFactory;
    private JWEKeySelector<C> jweKeySelector;
    private JOSEObjectTypeVerifier<C> jweTypeVerifier;
    private JWSKeySelector<C> jwsKeySelector;
    private JOSEObjectTypeVerifier<C> jwsTypeVerifier;
    private JWSVerifierFactory jwsVerifierFactory;

    public DefaultJWTProcessor() {
        DefaultJOSEObjectTypeVerifier defaultJOSEObjectTypeVerifier = DefaultJOSEObjectTypeVerifier.JWT;
        this.jwsTypeVerifier = defaultJOSEObjectTypeVerifier;
        this.jweTypeVerifier = defaultJOSEObjectTypeVerifier;
        this.jwsVerifierFactory = new DefaultJWSVerifierFactory();
        this.jweDecrypterFactory = new DefaultJWEDecrypterFactory();
        this.claimsVerifier = new DefaultJWTClaimsVerifier(null, null);
    }

    private JWTClaimsSet extractJWTClaimsSet(JWT jwt) throws BadJWTException {
        try {
            return jwt.getJWTClaimsSet();
        } catch (ParseException e) {
            throw new BadJWTException(e.getMessage(), e);
        }
    }

    private List<? extends Key> selectKeys(JWSHeader jWSHeader, JWTClaimsSet jWTClaimsSet, C c) throws BadJOSEException {
        if (getJWTClaimsSetAwareJWSKeySelector() != null) {
            return getJWTClaimsSetAwareJWSKeySelector().selectKeys(jWSHeader, jWTClaimsSet, c);
        }
        if (getJWSKeySelector() != null) {
            return getJWSKeySelector().selectJWSKeys(jWSHeader, c);
        }
        throw new BadJOSEException("Signed JWT rejected: No JWS key selector is configured");
    }

    private JWTClaimsSet verifyClaims(JWTClaimsSet jWTClaimsSet, C c) {
        if (getJWTClaimsSetVerifier() != null) {
            getJWTClaimsSetVerifier().verify(jWTClaimsSet, c);
        }
        return jWTClaimsSet;
    }

    @Override // com.nimbusds.jose.proc.JOSEProcessorConfiguration
    public JWEDecrypterFactory getJWEDecrypterFactory() {
        return this.jweDecrypterFactory;
    }

    @Override // com.nimbusds.jose.proc.JOSEProcessorConfiguration
    public JWEKeySelector<C> getJWEKeySelector() {
        return this.jweKeySelector;
    }

    @Override // com.nimbusds.jose.proc.JOSEProcessorConfiguration
    public JOSEObjectTypeVerifier<C> getJWETypeVerifier() {
        return this.jweTypeVerifier;
    }

    @Override // com.nimbusds.jose.proc.JOSEProcessorConfiguration
    public JWSKeySelector<C> getJWSKeySelector() {
        return this.jwsKeySelector;
    }

    @Override // com.nimbusds.jose.proc.JOSEProcessorConfiguration
    public JOSEObjectTypeVerifier<C> getJWSTypeVerifier() {
        return this.jwsTypeVerifier;
    }

    @Override // com.nimbusds.jose.proc.JOSEProcessorConfiguration
    public JWSVerifierFactory getJWSVerifierFactory() {
        return this.jwsVerifierFactory;
    }

    @Override // com.nimbusds.jwt.proc.JWTProcessorConfiguration
    public JWTClaimsSetAwareJWSKeySelector<C> getJWTClaimsSetAwareJWSKeySelector() {
        return this.claimsSetAwareJWSKeySelector;
    }

    @Override // com.nimbusds.jwt.proc.JWTProcessorConfiguration
    public JWTClaimsSetVerifier<C> getJWTClaimsSetVerifier() {
        return this.claimsVerifier;
    }

    @Override // com.nimbusds.jwt.proc.JWTProcessor
    public JWTClaimsSet process(String str, C c) {
        return process(JWTParser.parse(str), c);
    }

    @Override // com.nimbusds.jose.proc.JOSEProcessorConfiguration
    public void setJWEDecrypterFactory(JWEDecrypterFactory jWEDecrypterFactory) {
        this.jweDecrypterFactory = jWEDecrypterFactory;
    }

    @Override // com.nimbusds.jose.proc.JOSEProcessorConfiguration
    public void setJWEKeySelector(JWEKeySelector<C> jWEKeySelector) {
        this.jweKeySelector = jWEKeySelector;
    }

    @Override // com.nimbusds.jose.proc.JOSEProcessorConfiguration
    public void setJWETypeVerifier(JOSEObjectTypeVerifier<C> jOSEObjectTypeVerifier) {
        this.jweTypeVerifier = jOSEObjectTypeVerifier;
    }

    @Override // com.nimbusds.jose.proc.JOSEProcessorConfiguration
    public void setJWSKeySelector(JWSKeySelector<C> jWSKeySelector) {
        this.jwsKeySelector = jWSKeySelector;
    }

    @Override // com.nimbusds.jose.proc.JOSEProcessorConfiguration
    public void setJWSTypeVerifier(JOSEObjectTypeVerifier<C> jOSEObjectTypeVerifier) {
        this.jwsTypeVerifier = jOSEObjectTypeVerifier;
    }

    @Override // com.nimbusds.jose.proc.JOSEProcessorConfiguration
    public void setJWSVerifierFactory(JWSVerifierFactory jWSVerifierFactory) {
        this.jwsVerifierFactory = jWSVerifierFactory;
    }

    @Override // com.nimbusds.jwt.proc.JWTProcessorConfiguration
    public void setJWTClaimsSetAwareJWSKeySelector(JWTClaimsSetAwareJWSKeySelector<C> jWTClaimsSetAwareJWSKeySelector) {
        this.claimsSetAwareJWSKeySelector = jWTClaimsSetAwareJWSKeySelector;
    }

    @Override // com.nimbusds.jwt.proc.JWTProcessorConfiguration
    public void setJWTClaimsSetVerifier(JWTClaimsSetVerifier<C> jWTClaimsSetVerifier) {
        this.claimsVerifier = jWTClaimsSetVerifier;
    }

    @Override // com.nimbusds.jwt.proc.JWTProcessor
    public JWTClaimsSet process(JWT jwt, C c) throws JOSEException {
        if (jwt instanceof SignedJWT) {
            return process((SignedJWT) jwt, (SecurityContext) c);
        }
        if (jwt instanceof EncryptedJWT) {
            return process((EncryptedJWT) jwt, (SecurityContext) c);
        }
        if (jwt instanceof PlainJWT) {
            return process((PlainJWT) jwt, (SecurityContext) c);
        }
        throw new JOSEException("Unexpected JWT object type: " + jwt.getClass());
    }

    @Override // com.nimbusds.jwt.proc.JWTProcessor
    public JWTClaimsSet process(PlainJWT plainJWT, C c) throws BadJOSEException {
        JOSEObjectTypeVerifier<C> jOSEObjectTypeVerifier = this.jwsTypeVerifier;
        if (jOSEObjectTypeVerifier == null) {
            throw new BadJOSEException("Plain JWT rejected: No JWS header typ (type) verifier is configured");
        }
        jOSEObjectTypeVerifier.verify(plainJWT.getHeader().getType(), c);
        throw new BadJOSEException("Unsecured (plain) JWTs are rejected, extend class to handle");
    }

    @Override // com.nimbusds.jwt.proc.JWTProcessor
    public JWTClaimsSet process(SignedJWT signedJWT, C c) throws BadJOSEException, JOSEException {
        JOSEObjectTypeVerifier<C> jOSEObjectTypeVerifier = this.jwsTypeVerifier;
        if (jOSEObjectTypeVerifier != null) {
            jOSEObjectTypeVerifier.verify(signedJWT.getHeader().getType(), c);
            if (getJWSKeySelector() == null && getJWTClaimsSetAwareJWSKeySelector() == null) {
                throw new BadJOSEException("Signed JWT rejected: No JWS key selector is configured");
            }
            if (getJWSVerifierFactory() != null) {
                JWTClaimsSet jWTClaimsSetExtractJWTClaimsSet = extractJWTClaimsSet(signedJWT);
                List<? extends Key> listSelectKeys = selectKeys(signedJWT.getHeader(), jWTClaimsSetExtractJWTClaimsSet, c);
                if (listSelectKeys != null && !listSelectKeys.isEmpty()) {
                    ListIterator<? extends Key> listIterator = listSelectKeys.listIterator();
                    while (listIterator.hasNext()) {
                        JWSVerifier jWSVerifierCreateJWSVerifier = getJWSVerifierFactory().createJWSVerifier(signedJWT.getHeader(), listIterator.next());
                        if (jWSVerifierCreateJWSVerifier != null) {
                            if (signedJWT.verify(jWSVerifierCreateJWSVerifier)) {
                                return verifyClaims(jWTClaimsSetExtractJWTClaimsSet, c);
                            }
                            if (!listIterator.hasNext()) {
                                throw new BadJWSException("Signed JWT rejected: Invalid signature");
                            }
                        }
                    }
                    throw new BadJOSEException("JWS object rejected: No matching verifier(s) found");
                }
                throw new BadJOSEException("Signed JWT rejected: Another algorithm expected, or no matching key(s) found");
            }
            throw new JOSEException("No JWS verifier is configured");
        }
        throw new BadJOSEException("Signed JWT rejected: No JWS header typ (type) verifier is configured");
    }

    @Override // com.nimbusds.jwt.proc.JWTProcessor
    public JWTClaimsSet process(EncryptedJWT encryptedJWT, C c) throws BadJOSEException, JOSEException {
        JOSEObjectTypeVerifier<C> jOSEObjectTypeVerifier = this.jweTypeVerifier;
        if (jOSEObjectTypeVerifier != null) {
            jOSEObjectTypeVerifier.verify(encryptedJWT.getHeader().getType(), c);
            if (getJWEKeySelector() != null) {
                if (getJWEDecrypterFactory() != null) {
                    List<? extends Key> listSelectJWEKeys = getJWEKeySelector().selectJWEKeys(encryptedJWT.getHeader(), c);
                    if (listSelectJWEKeys != null && !listSelectJWEKeys.isEmpty()) {
                        ListIterator<? extends Key> listIterator = listSelectJWEKeys.listIterator();
                        while (listIterator.hasNext()) {
                            JWEDecrypter jWEDecrypterCreateJWEDecrypter = getJWEDecrypterFactory().createJWEDecrypter(encryptedJWT.getHeader(), listIterator.next());
                            if (jWEDecrypterCreateJWEDecrypter != null) {
                                try {
                                    encryptedJWT.decrypt(jWEDecrypterCreateJWEDecrypter);
                                    if ("JWT".equalsIgnoreCase(encryptedJWT.getHeader().getContentType())) {
                                        SignedJWT signedJWT = encryptedJWT.getPayload().toSignedJWT();
                                        if (signedJWT != null) {
                                            return process(signedJWT, (SecurityContext) c);
                                        }
                                        throw new BadJWTException("The payload is not a nested signed JWT");
                                    }
                                    return verifyClaims(extractJWTClaimsSet(encryptedJWT), c);
                                } catch (JOSEException e) {
                                    if (!listIterator.hasNext()) {
                                        throw new BadJWEException("Encrypted JWT rejected: " + e.getMessage(), e);
                                    }
                                }
                            }
                        }
                        throw new BadJOSEException("Encrypted JWT rejected: No matching decrypter(s) found");
                    }
                    throw new BadJOSEException("Encrypted JWT rejected: Another algorithm expected, or no matching key(s) found");
                }
                throw new JOSEException("No JWE decrypter is configured");
            }
            throw new BadJOSEException("Encrypted JWT rejected: No JWE key selector is configured");
        }
        throw new BadJOSEException("Encrypted JWT rejected: No JWE header typ (type) verifier is configured");
    }
}
