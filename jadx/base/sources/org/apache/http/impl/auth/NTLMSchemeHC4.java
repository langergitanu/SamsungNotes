package org.apache.http.impl.auth;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.InvalidCredentialsException;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.NTCredentials;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@NotThreadSafe
public class NTLMSchemeHC4 extends AuthSchemeBaseHC4 {
    private String challenge;
    private final NTLMEngine engine;
    private State state;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        UNINITIATED,
        CHALLENGE_RECEIVED,
        MSG_TYPE1_GENERATED,
        MSG_TYPE2_RECEVIED,
        MSG_TYPE3_GENERATED,
        FAILED;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] stateArrValuesCustom = values();
            int length = stateArrValuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(stateArrValuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    public NTLMSchemeHC4(NTLMEngine nTLMEngine) {
        Args.notNull(nTLMEngine, "NTLM engine");
        this.engine = nTLMEngine;
        this.state = State.UNINITIATED;
        this.challenge = null;
    }

    @Override // org.apache.http.auth.AuthScheme
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        String strGenerateType3Msg;
        try {
            NTCredentials nTCredentials = (NTCredentials) credentials;
            State state = this.state;
            if (state == State.FAILED) {
                throw new AuthenticationException("NTLM authentication failed");
            }
            if (state == State.CHALLENGE_RECEIVED) {
                strGenerateType3Msg = this.engine.generateType1Msg(nTCredentials.getDomain(), nTCredentials.getWorkstation());
                this.state = State.MSG_TYPE1_GENERATED;
            } else {
                if (state != State.MSG_TYPE2_RECEVIED) {
                    throw new AuthenticationException("Unexpected state: " + this.state);
                }
                strGenerateType3Msg = this.engine.generateType3Msg(nTCredentials.getUserName(), nTCredentials.getPassword(), nTCredentials.getDomain(), nTCredentials.getWorkstation(), this.challenge);
                this.state = State.MSG_TYPE3_GENERATED;
            }
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
            if (isProxy()) {
                charArrayBuffer.append("Proxy-Authorization");
            } else {
                charArrayBuffer.append("Authorization");
            }
            charArrayBuffer.append(": NTLM ");
            charArrayBuffer.append(strGenerateType3Msg);
            return new BufferedHeader(charArrayBuffer);
        } catch (ClassCastException unused) {
            throw new InvalidCredentialsException("Credentials cannot be used for NTLM authentication: ".concat(credentials.getClass().getName()));
        }
    }

    @Override // org.apache.http.auth.AuthScheme
    public String getParameter(String str) {
        return null;
    }

    @Override // org.apache.http.auth.AuthScheme
    public String getRealm() {
        return null;
    }

    @Override // org.apache.http.auth.AuthScheme
    public String getSchemeName() {
        return "ntlm";
    }

    @Override // org.apache.http.auth.AuthScheme
    public boolean isComplete() {
        State state = this.state;
        return state == State.MSG_TYPE3_GENERATED || state == State.FAILED;
    }

    @Override // org.apache.http.auth.AuthScheme
    public boolean isConnectionBased() {
        return true;
    }

    @Override // org.apache.http.impl.auth.AuthSchemeBaseHC4
    public void parseChallenge(CharArrayBuffer charArrayBuffer, int i, int i2) throws MalformedChallengeException {
        String strSubstringTrimmed = charArrayBuffer.substringTrimmed(i, i2);
        this.challenge = strSubstringTrimmed;
        if (strSubstringTrimmed.length() == 0) {
            if (this.state == State.UNINITIATED) {
                this.state = State.CHALLENGE_RECEIVED;
                return;
            } else {
                this.state = State.FAILED;
                return;
            }
        }
        State state = this.state;
        State state2 = State.MSG_TYPE1_GENERATED;
        if (state.compareTo(state2) < 0) {
            this.state = State.FAILED;
            throw new MalformedChallengeException("Out of sequence NTLM response message");
        }
        if (this.state == state2) {
            this.state = State.MSG_TYPE2_RECEVIED;
        }
    }

    public NTLMSchemeHC4() {
        this(new NTLMEngineImpl());
    }
}
