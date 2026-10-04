package com.nimbusds.jose;

import com.nimbusds.jose.util.JSONStringUtils;
import java.io.Serializable;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public class Algorithm implements Serializable {
    public static final Algorithm NONE = new Algorithm("none", Requirement.REQUIRED);
    private static final long serialVersionUID = 1;
    private final String name;
    private final Requirement requirement;

    public Algorithm(String str, Requirement requirement) {
        if (str == null) {
            throw new IllegalArgumentException("The algorithm name must not be null");
        }
        this.name = str;
        this.requirement = requirement;
    }

    public static Algorithm parse(String str) {
        if (str == null) {
            return null;
        }
        return new Algorithm(str);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Algorithm) && toString().equals(obj.toString());
    }

    public final String getName() {
        return this.name;
    }

    public final Requirement getRequirement() {
        return this.requirement;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final String toJSONString() {
        return JSONStringUtils.toJSONString(this.name);
    }

    public final String toString() {
        return this.name;
    }

    public Algorithm(String str) {
        this(str, null);
    }
}
