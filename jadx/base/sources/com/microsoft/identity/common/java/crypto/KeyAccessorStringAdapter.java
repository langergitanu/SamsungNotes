package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.AuthenticationConstants;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/microsoft/identity/common/java/crypto/KeyAccessorStringAdapter;", "Lcom/microsoft/identity/common/java/crypto/IKeyAccessorStringAdapter;", "mKeyAccessor", "Lcom/microsoft/identity/common/java/crypto/IKeyAccessor;", "(Lcom/microsoft/identity/common/java/crypto/IKeyAccessor;)V", "decrypt", "", "cipherText", "encrypt", "plainText", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class KeyAccessorStringAdapter implements IKeyAccessorStringAdapter {

    @NotNull
    private final IKeyAccessor mKeyAccessor;

    public KeyAccessorStringAdapter(@NotNull IKeyAccessor mKeyAccessor) {
        Intrinsics.checkNotNullParameter(mKeyAccessor, "mKeyAccessor");
        this.mKeyAccessor = mKeyAccessor;
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessorStringAdapter
    @NotNull
    public String decrypt(@NotNull String cipherText) {
        Intrinsics.checkNotNullParameter(cipherText, "cipherText");
        IKeyAccessor iKeyAccessor = this.mKeyAccessor;
        Charset CHARSET_UTF8 = AuthenticationConstants.CHARSET_UTF8;
        Intrinsics.checkNotNullExpressionValue(CHARSET_UTF8, "CHARSET_UTF8");
        byte[] bytes = cipherText.getBytes(CHARSET_UTF8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] result = iKeyAccessor.decrypt(bytes);
        Intrinsics.checkNotNullExpressionValue(result, "result");
        Intrinsics.checkNotNullExpressionValue(CHARSET_UTF8, "CHARSET_UTF8");
        return new String(result, CHARSET_UTF8);
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessorStringAdapter
    @NotNull
    public String encrypt(@NotNull String plainText) {
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        IKeyAccessor iKeyAccessor = this.mKeyAccessor;
        Charset CHARSET_UTF8 = AuthenticationConstants.CHARSET_UTF8;
        Intrinsics.checkNotNullExpressionValue(CHARSET_UTF8, "CHARSET_UTF8");
        byte[] bytes = plainText.getBytes(CHARSET_UTF8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] result = iKeyAccessor.encrypt(bytes);
        Intrinsics.checkNotNullExpressionValue(result, "result");
        Intrinsics.checkNotNullExpressionValue(CHARSET_UTF8, "CHARSET_UTF8");
        return new String(result, CHARSET_UTF8);
    }
}
