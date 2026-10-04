package com.nimbusds.jose.proc;

import com.nimbusds.jose.JOSEObject;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.PlainObject;
import com.nimbusds.jose.proc.SecurityContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface JOSEProcessor<C extends SecurityContext> {
    Payload process(JOSEObject jOSEObject, C c);

    Payload process(JWEObject jWEObject, C c);

    Payload process(JWSObject jWSObject, C c);

    Payload process(PlainObject plainObject, C c);

    Payload process(String str, C c);
}
