package com.microsoft.identity.common.java.challengehandlers;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.AuthenticationSettings;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.JWSBuilder;
import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PKeyAuthChallenge {
    private static final String TAG = "PKeyAuthChallenge";

    @Nullable
    private final List<String> mCertAuthorities;
    private final String mContext;
    private final JWSBuilder mJwsBuilder;
    private final String mNonce;
    private final String mSubmitUrl;

    @Nullable
    private final String mTenantId;

    @Nullable
    private final String mThumbprint;
    private final String mVersion;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PKeyAuthChallengeBuilder {
        private List<String> certAuthorities;
        private String context;
        private boolean jwsBuilder$set;
        private JWSBuilder jwsBuilder$value;
        private String nonce;
        private String submitUrl;
        private String tenantId;
        private String thumbprint;
        private String version;

        public PKeyAuthChallenge build() {
            JWSBuilder jWSBuilder$default$jwsBuilder = this.jwsBuilder$value;
            if (!this.jwsBuilder$set) {
                jWSBuilder$default$jwsBuilder = PKeyAuthChallenge.$default$jwsBuilder();
            }
            return new PKeyAuthChallenge(this.nonce, this.context, this.certAuthorities, this.thumbprint, this.version, this.submitUrl, jWSBuilder$default$jwsBuilder, this.tenantId);
        }

        public PKeyAuthChallengeBuilder certAuthorities(@Nullable List<String> list) {
            this.certAuthorities = list;
            return this;
        }

        public PKeyAuthChallengeBuilder context(String str) {
            this.context = str;
            return this;
        }

        public PKeyAuthChallengeBuilder jwsBuilder(JWSBuilder jWSBuilder) {
            this.jwsBuilder$value = jWSBuilder;
            this.jwsBuilder$set = true;
            return this;
        }

        public PKeyAuthChallengeBuilder nonce(String str) {
            this.nonce = str;
            return this;
        }

        public PKeyAuthChallengeBuilder submitUrl(String str) {
            this.submitUrl = str;
            return this;
        }

        public PKeyAuthChallengeBuilder tenantId(@Nullable String str) {
            this.tenantId = str;
            return this;
        }

        public PKeyAuthChallengeBuilder thumbprint(@Nullable String str) {
            this.thumbprint = str;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("PKeyAuthChallenge.PKeyAuthChallengeBuilder(nonce=");
            sb.append(this.nonce);
            sb.append(", context=");
            sb.append(this.context);
            sb.append(", certAuthorities=");
            sb.append(this.certAuthorities);
            sb.append(", thumbprint=");
            sb.append(this.thumbprint);
            sb.append(", version=");
            sb.append(this.version);
            sb.append(", submitUrl=");
            sb.append(this.submitUrl);
            sb.append(", jwsBuilder$value=");
            sb.append(this.jwsBuilder$value);
            sb.append(", tenantId=");
            return AbstractC0622a.m1170p(this.tenantId, ")", sb);
        }

        public PKeyAuthChallengeBuilder version(String str) {
            this.version = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum RequestField {
        Nonce,
        CertAuthorities,
        Version,
        SubmitUrl,
        Context,
        CertThumbprint,
        TenantId
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JWSBuilder $default$jwsBuilder() {
        return new JWSBuilder();
    }

    public PKeyAuthChallenge(String str, String str2, @Nullable List<String> list, @Nullable String str3, String str4, String str5, JWSBuilder jWSBuilder, @Nullable String str6) {
        this.mNonce = str;
        this.mContext = str2;
        this.mCertAuthorities = list;
        this.mThumbprint = str3;
        this.mVersion = str4;
        this.mSubmitUrl = str5;
        this.mJwsBuilder = jWSBuilder;
        this.mTenantId = str6;
    }

    public static PKeyAuthChallengeBuilder builder() {
        return new PKeyAuthChallengeBuilder();
    }

    private Map<String, String> getChallengeHeaderWithSignedJwt(@NonNull IDeviceCertificate iDeviceCertificate) throws ClientException {
        if (!StringUtil.equalsIgnoreCase(this.mVersion, "1.0")) {
            Logger.warn(AbstractC0622a.m1170p(TAG, ":getChallengeHeaderWithSignedJwt", new StringBuilder()), "PKeyAuth version mismatch, server provides: " + this.mVersion + "We support: 1.0Proceed anyway with 1.0");
        }
        String strGenerateSignedJWT = this.mJwsBuilder.generateSignedJWT(this.mNonce, this.mSubmitUrl, iDeviceCertificate);
        Logger.info(TAG + ":getChallengeHeaderWithSignedJwt", "Generated a signed challenge response.");
        HashMap map = new HashMap();
        map.put("Authorization", AbstractC0541b.m775q("PKeyAuth AuthToken=\"", strGenerateSignedJWT, "\",Context=\"", this.mContext, "\",Version=\"1.0\""));
        return map;
    }

    private Map<String, String> getChallengeHeaderWithoutSignedJwt() {
        HashMap map = new HashMap();
        map.put("Authorization", "PKeyAuth Context=\"" + this.mContext + "\",Version=\"1.0\"");
        return map;
    }

    @Nullable
    public List<String> getCertAuthorities() {
        return this.mCertAuthorities;
    }

    public Map<String, String> getChallengeHeader() {
        List<String> list = this.mCertAuthorities;
        if ((list == null || list.size() == 0) && StringUtil.isNullOrEmpty(this.mThumbprint)) {
            Logger.info(TAG + ":getChallengeHeader", "Both cert Authorities and Thumbprint are not provided.Sending a response which is equivalent to no certificate present on client.");
            return getChallengeHeaderWithoutSignedJwt();
        }
        IDeviceCertificateLoader certificateLoader = AuthenticationSettings.INSTANCE.getCertificateLoader();
        if (certificateLoader == null) {
            AbstractC4539a.m3189C(new StringBuilder(), TAG, ":getChallengeHeader", "Device Certificate loader is not initialized.");
            return getChallengeHeaderWithoutSignedJwt();
        }
        IDeviceCertificate iDeviceCertificateLoadCertificate = certificateLoader.loadCertificate(this.mTenantId);
        if (iDeviceCertificateLoadCertificate == null) {
            AbstractC4539a.m3189C(new StringBuilder(), TAG, ":getChallengeHeader", "Device Certificate not found.");
            return getChallengeHeaderWithoutSignedJwt();
        }
        if (!iDeviceCertificateLoadCertificate.isValidIssuer(this.mCertAuthorities)) {
            return getChallengeHeaderWithoutSignedJwt();
        }
        Logger.info(TAG + ":getChallengeHeader", "Found a certificate matching the provided authority.");
        return getChallengeHeaderWithSignedJwt(iDeviceCertificateLoadCertificate);
    }

    public String getContext() {
        return this.mContext;
    }

    public JWSBuilder getJwsBuilder() {
        return this.mJwsBuilder;
    }

    public String getNonce() {
        return this.mNonce;
    }

    public String getSubmitUrl() {
        return this.mSubmitUrl;
    }

    @Nullable
    public String getTenantId() {
        return this.mTenantId;
    }

    @Nullable
    public String getThumbprint() {
        return this.mThumbprint;
    }

    public String getVersion() {
        return this.mVersion;
    }
}
