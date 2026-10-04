package com.nimbusds.jose;

import com.microsoft.identity.common.java.jwt.JwtRequestHeader;
import com.nimbusds.jose.util.ArrayUtils;
import java.util.Collection;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class JWSAlgorithm extends Algorithm {
    public static final JWSAlgorithm ES256;
    public static final JWSAlgorithm ES256K;
    public static final JWSAlgorithm ES384;
    public static final JWSAlgorithm ES512;
    public static final JWSAlgorithm EdDSA;
    public static final JWSAlgorithm HS256 = new JWSAlgorithm(JwtRequestHeader.ALG_VALUE_HS256, Requirement.REQUIRED);
    public static final JWSAlgorithm HS384;
    public static final JWSAlgorithm HS512;
    public static final JWSAlgorithm PS256;
    public static final JWSAlgorithm PS384;
    public static final JWSAlgorithm PS512;
    public static final JWSAlgorithm RS256;
    public static final JWSAlgorithm RS384;
    public static final JWSAlgorithm RS512;
    private static final long serialVersionUID = 1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Family extends AlgorithmFamily<JWSAlgorithm> {

        /* JADX INFO: renamed from: EC */
        public static final Family f3624EC;

        /* JADX INFO: renamed from: ED */
        public static final Family f3625ED;
        public static final Family HMAC_SHA = new Family(JWSAlgorithm.HS256, JWSAlgorithm.HS384, JWSAlgorithm.HS512);
        public static final Family RSA;
        public static final Family SIGNATURE;
        private static final long serialVersionUID = 1;

        static {
            Family family = new Family(JWSAlgorithm.RS256, JWSAlgorithm.RS384, JWSAlgorithm.RS512, JWSAlgorithm.PS256, JWSAlgorithm.PS384, JWSAlgorithm.PS512);
            RSA = family;
            Family family2 = new Family(JWSAlgorithm.ES256, JWSAlgorithm.ES256K, JWSAlgorithm.ES384, JWSAlgorithm.ES512);
            f3624EC = family2;
            Family family3 = new Family(JWSAlgorithm.EdDSA);
            f3625ED = family3;
            SIGNATURE = new Family((JWSAlgorithm[]) ArrayUtils.concat(family.toArray(new JWSAlgorithm[0]), (JWSAlgorithm[]) family2.toArray(new JWSAlgorithm[0]), (JWSAlgorithm[]) family3.toArray(new JWSAlgorithm[0])));
        }

        public Family(JWSAlgorithm... jWSAlgorithmArr) {
            super(jWSAlgorithmArr);
        }

        @Override // com.nimbusds.jose.AlgorithmFamily
        public /* bridge */ /* synthetic */ boolean add(Algorithm algorithm) {
            return super.add(algorithm);
        }

        @Override // com.nimbusds.jose.AlgorithmFamily, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return super.addAll(collection);
        }

        @Override // com.nimbusds.jose.AlgorithmFamily, java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return super.remove(obj);
        }

        @Override // com.nimbusds.jose.AlgorithmFamily, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return super.removeAll(collection);
        }

        @Override // com.nimbusds.jose.AlgorithmFamily, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return super.retainAll(collection);
        }
    }

    static {
        Requirement requirement = Requirement.OPTIONAL;
        HS384 = new JWSAlgorithm("HS384", requirement);
        HS512 = new JWSAlgorithm("HS512", requirement);
        Requirement requirement2 = Requirement.RECOMMENDED;
        RS256 = new JWSAlgorithm(JwtRequestHeader.ALG_VALUE_RS256, requirement2);
        RS384 = new JWSAlgorithm("RS384", requirement);
        RS512 = new JWSAlgorithm("RS512", requirement);
        ES256 = new JWSAlgorithm("ES256", requirement2);
        ES256K = new JWSAlgorithm("ES256K", requirement);
        ES384 = new JWSAlgorithm("ES384", requirement);
        ES512 = new JWSAlgorithm("ES512", requirement);
        PS256 = new JWSAlgorithm("PS256", requirement);
        PS384 = new JWSAlgorithm("PS384", requirement);
        PS512 = new JWSAlgorithm("PS512", requirement);
        EdDSA = new JWSAlgorithm("EdDSA", requirement);
    }

    public JWSAlgorithm(String str, Requirement requirement) {
        super(str, requirement);
    }

    public static JWSAlgorithm parse(String str) {
        JWSAlgorithm jWSAlgorithm = HS256;
        if (str.equals(jWSAlgorithm.getName())) {
            return jWSAlgorithm;
        }
        JWSAlgorithm jWSAlgorithm2 = HS384;
        if (str.equals(jWSAlgorithm2.getName())) {
            return jWSAlgorithm2;
        }
        JWSAlgorithm jWSAlgorithm3 = HS512;
        if (str.equals(jWSAlgorithm3.getName())) {
            return jWSAlgorithm3;
        }
        JWSAlgorithm jWSAlgorithm4 = RS256;
        if (str.equals(jWSAlgorithm4.getName())) {
            return jWSAlgorithm4;
        }
        JWSAlgorithm jWSAlgorithm5 = RS384;
        if (str.equals(jWSAlgorithm5.getName())) {
            return jWSAlgorithm5;
        }
        JWSAlgorithm jWSAlgorithm6 = RS512;
        if (str.equals(jWSAlgorithm6.getName())) {
            return jWSAlgorithm6;
        }
        JWSAlgorithm jWSAlgorithm7 = ES256;
        if (str.equals(jWSAlgorithm7.getName())) {
            return jWSAlgorithm7;
        }
        JWSAlgorithm jWSAlgorithm8 = ES256K;
        if (str.equals(jWSAlgorithm8.getName())) {
            return jWSAlgorithm8;
        }
        JWSAlgorithm jWSAlgorithm9 = ES384;
        if (str.equals(jWSAlgorithm9.getName())) {
            return jWSAlgorithm9;
        }
        JWSAlgorithm jWSAlgorithm10 = ES512;
        if (str.equals(jWSAlgorithm10.getName())) {
            return jWSAlgorithm10;
        }
        JWSAlgorithm jWSAlgorithm11 = PS256;
        if (str.equals(jWSAlgorithm11.getName())) {
            return jWSAlgorithm11;
        }
        JWSAlgorithm jWSAlgorithm12 = PS384;
        if (str.equals(jWSAlgorithm12.getName())) {
            return jWSAlgorithm12;
        }
        JWSAlgorithm jWSAlgorithm13 = PS512;
        if (str.equals(jWSAlgorithm13.getName())) {
            return jWSAlgorithm13;
        }
        JWSAlgorithm jWSAlgorithm14 = EdDSA;
        return str.equals(jWSAlgorithm14.getName()) ? jWSAlgorithm14 : new JWSAlgorithm(str);
    }

    public JWSAlgorithm(String str) {
        super(str, null);
    }
}
