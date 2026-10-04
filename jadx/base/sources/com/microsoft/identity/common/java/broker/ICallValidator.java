package com.microsoft.identity.common.java.broker;

import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ICallValidator {
    void throwIfNotInvokedByAcceptableApp(@NonNull String str, int i, @NonNull Map<String, Iterable<String>> map);
}
