package com.microsoft.identity.common.java.crypto;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/microsoft/identity/common/java/crypto/IKeyAccessorStringAdapter;", "", "decrypt", "", "cipherText", "encrypt", "plainText", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface IKeyAccessorStringAdapter {
    @NotNull
    String decrypt(@NotNull String cipherText);

    @NotNull
    String encrypt(@NotNull String plainText);
}
