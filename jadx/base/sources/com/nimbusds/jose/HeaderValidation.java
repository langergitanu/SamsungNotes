package com.nimbusds.jose;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class HeaderValidation {
    private HeaderValidation() {
    }

    public static void ensureDisjoint(Header header, UnprotectedHeader unprotectedHeader) {
        if (header == null || unprotectedHeader == null) {
            return;
        }
        Iterator<String> it = unprotectedHeader.getIncludedParams().iterator();
        while (it.hasNext()) {
            if (header.getIncludedParams().contains(it.next())) {
                throw new IllegalHeaderException("The parameters in the protected header and the unprotected header must be disjoint");
            }
        }
    }
}
