package com.nimbusds.jose;

import com.nimbusds.jose.util.JSONStringUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.io.Serializable;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class CompressionAlgorithm implements Serializable {
    public static final CompressionAlgorithm DEF = new CompressionAlgorithm(Constants.PairedColorCode.DEFAULT);
    private static final long serialVersionUID = 1;
    private final String name;

    public CompressionAlgorithm(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The compression algorithm name must not be null");
        }
        this.name = str;
    }

    public boolean equals(Object obj) {
        return (obj instanceof CompressionAlgorithm) && toString().equals(obj.toString());
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toJSONString() {
        return JSONStringUtils.toJSONString(this.name);
    }

    public String toString() {
        return this.name;
    }
}
