package com.nimbusds.jose.proc;

import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.proc.SecurityContext;
import java.security.Key;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface JWSKeySelector<C extends SecurityContext> {
    List<? extends Key> selectJWSKeys(JWSHeader jWSHeader, C c);
}
