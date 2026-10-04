package com.samsung.scsp.framework.core.api;

import android.util.Pair;
import com.samsung.scsp.framework.core.listeners.Listeners;
import com.samsung.scsp.framework.core.network.HttpRequest;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface Job {
    default void attachHeaderFunction(Function<ApiContext, Pair<String, String>[]> function) {
    }

    default void attachJournalSupplier(Supplier<Pair<String, String>> supplier) {
    }

    default void attachProperties(Property[] propertyArr) {
    }

    default void attachUrlFunction(BiFunction<ApiContext, String, String> biFunction) {
    }

    HttpRequest createRequest(ApiContext apiContext, Listeners listeners);

    void execute(ApiContext apiContext, Listeners listeners);

    String getName();
}
