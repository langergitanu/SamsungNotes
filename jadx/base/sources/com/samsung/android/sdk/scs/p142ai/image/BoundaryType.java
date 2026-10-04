package com.samsung.android.sdk.scs.p142ai.image;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum BoundaryType {
    UNKNOWN(0),
    IMAGE(1),
    TEXT(2),
    OUTER_BLOCK(3);

    private static final Map<Integer, BoundaryType> mEnumMap;
    private int mType;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (BoundaryType boundaryType : values()) {
            concurrentHashMap.put(Integer.valueOf(boundaryType.getType()), boundaryType);
        }
        mEnumMap = Collections.unmodifiableMap(concurrentHashMap);
    }

    BoundaryType(int i) {
        this.mType = i;
    }

    public static BoundaryType get(int i) {
        return mEnumMap.get(Integer.valueOf(i));
    }

    public int getType() {
        return this.mType;
    }
}
