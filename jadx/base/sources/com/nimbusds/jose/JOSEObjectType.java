package com.nimbusds.jose;

import com.nimbusds.jose.util.JSONStringUtils;
import java.io.Serializable;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class JOSEObjectType implements Serializable {
    public static final JOSEObjectType JOSE = new JOSEObjectType("JOSE");
    public static final JOSEObjectType JOSE_JSON = new JOSEObjectType("JOSE+JSON");
    public static final JOSEObjectType JWT = new JOSEObjectType("JWT");
    private static final long serialVersionUID = 1;
    private final String type;

    public JOSEObjectType(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The object type must not be null");
        }
        this.type = str;
    }

    public boolean equals(Object obj) {
        return (obj instanceof JOSEObjectType) && this.type.equalsIgnoreCase(((JOSEObjectType) obj).type);
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.toLowerCase().hashCode();
    }

    public String toJSONString() {
        return JSONStringUtils.toJSONString(this.type);
    }

    public String toString() {
        return this.type;
    }
}
