package com.vladsch.flexmark.util.collection;

import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TwoWayHashMap<F, S> {

    @NotNull
    private HashMap<F, S> fToSMap = new HashMap<>();

    @NotNull
    private HashMap<S, F> sToFMap = new HashMap<>();

    public void add(@Nullable F f, @Nullable S s) {
        this.fToSMap.put(f, s);
        this.sToFMap.put(s, f);
    }

    @Nullable
    public F getFirst(@Nullable S s) {
        return this.sToFMap.get(s);
    }

    @Nullable
    public S getSecond(@Nullable F f) {
        return this.fToSMap.get(f);
    }
}
