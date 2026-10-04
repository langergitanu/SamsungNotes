package org.apache.poi.common.usermodel;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.util.Internal;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum HyperlinkType {
    NONE(-1),
    URL(1),
    DOCUMENT(2),
    EMAIL(3),
    FILE(4);

    private static final Map<Integer, HyperlinkType> map = new HashMap();

    @Internal(since = "3.15 beta 3")
    @Deprecated
    private final int code;

    static {
        for (HyperlinkType hyperlinkType : values()) {
            map.put(Integer.valueOf(hyperlinkType.getCode()), hyperlinkType);
        }
    }

    @Internal(since = "3.15 beta 3")
    @Deprecated
    HyperlinkType(int i) {
        this.code = i;
    }

    @Internal(since = "3.15 beta 3")
    @Deprecated
    public static HyperlinkType forInt(int i) {
        HyperlinkType hyperlinkType = map.get(Integer.valueOf(i));
        if (hyperlinkType != null) {
            return hyperlinkType;
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Invalid type: "));
    }

    @Internal(since = "3.15 beta 3")
    @Deprecated
    public int getCode() {
        return this.code;
    }
}
