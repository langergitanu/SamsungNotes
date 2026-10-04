package com.nimbusds.jose;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.security.Key;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class KeyTypeException extends KeyException {
    public KeyTypeException(Class<? extends Key> cls) {
        super(AbstractC2322a.m1621k("Invalid key: Must be an instance of ", cls));
    }

    public KeyTypeException(Class<? extends Key> cls, Class<?>... clsArr) {
        super("Invalid key: Must be an instance of " + cls + " and implement all of the following interfaces " + Arrays.toString(clsArr));
    }
}
