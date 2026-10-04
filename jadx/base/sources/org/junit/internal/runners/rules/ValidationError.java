package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import org.junit.runners.model.FrameworkMember;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
class ValidationError extends Exception {
    private static final long serialVersionUID = 3176511008672645574L;

    /* JADX WARN: Illegal instructions before constructor call */
    public ValidationError(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, String str) {
        StringBuilder sbM16m = AbstractC0000a.m16m("The @", cls.getSimpleName(), " '", frameworkMember.getName(), "' ");
        sbM16m.append(str);
        super(sbM16m.toString());
    }
}
