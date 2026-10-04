package com.nimbusds.jose.jwk;

import com.nimbusds.jose.JOSEException;
import java.security.Key;
import java.security.KeyPair;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class KeyConverter {
    public static List<Key> toJavaKeys(List<JWK> list) {
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        LinkedList linkedList = new LinkedList();
        for (Object obj : list) {
            try {
                if (obj instanceof AsymmetricJWK) {
                    KeyPair keyPair = ((AsymmetricJWK) obj).toKeyPair();
                    linkedList.add(keyPair.getPublic());
                    if (keyPair.getPrivate() != null) {
                        linkedList.add(keyPair.getPrivate());
                    }
                } else if (obj instanceof SecretJWK) {
                    linkedList.add(((SecretJWK) obj).toSecretKey());
                }
            } catch (JOSEException unused) {
            }
        }
        return linkedList;
    }
}
