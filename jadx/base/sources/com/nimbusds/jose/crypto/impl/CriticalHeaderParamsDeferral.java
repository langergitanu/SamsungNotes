package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.Header;
import com.nimbusds.jose.HeaderParameterNames;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEHeader;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CriticalHeaderParamsDeferral {
    private Set<String> deferredParams = Collections.EMPTY_SET;

    public void ensureHeaderPasses(JWEHeader jWEHeader) throws JOSEException {
        if (!headerPasses(jWEHeader)) {
            throw new JOSEException("Unsupported critical header parameter(s)");
        }
    }

    public Set<String> getDeferredCriticalHeaderParams() {
        return Collections.unmodifiableSet(this.deferredParams);
    }

    public Set<String> getProcessedCriticalHeaderParams() {
        return Collections.singleton(HeaderParameterNames.BASE64_URL_ENCODE_PAYLOAD);
    }

    public boolean headerPasses(Header header) {
        if (header.getCriticalParams() == null) {
            return true;
        }
        for (String str : header.getCriticalParams()) {
            if (!getProcessedCriticalHeaderParams().contains(str) && !getDeferredCriticalHeaderParams().contains(str)) {
                return false;
            }
        }
        return true;
    }

    public void setDeferredCriticalHeaderParams(Set<String> set) {
        if (set == null) {
            this.deferredParams = Collections.EMPTY_SET;
        } else {
            this.deferredParams = set;
        }
    }
}
