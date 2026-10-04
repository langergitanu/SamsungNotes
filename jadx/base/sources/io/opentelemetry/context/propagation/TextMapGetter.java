package io.opentelemetry.context.propagation;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface TextMapGetter<C> {
    @Nullable
    String get(@Nullable C c, String str);

    Iterable<String> keys(C c);
}
