package com.google.api.client.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Maps {
    private Maps() {
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    public static <K extends Comparable<?>, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap<>();
    }
}
