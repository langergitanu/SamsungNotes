package com.samsung.android.support.senl.p148nt.base.common.util;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/Base64Utils;", "", "<init>", "()V", "encodeBase64", "", "text", "bytes", "", "decodeBase64", "decodeBase64ToByteArray", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Base64Utils {

    @NotNull
    public static final Base64Utils INSTANCE = new Base64Utils();

    private Base64Utils() {
    }

    @JvmStatic
    @NotNull
    public static final String decodeBase64(@Nullable String text) {
        byte[] bArrDecode = Base64.decode(text, 2);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return new String(bArrDecode, UTF_8);
    }

    @JvmStatic
    @NotNull
    public static final byte[] decodeBase64ToByteArray(@Nullable String text) {
        byte[] bArrDecode = Base64.decode(text, 2);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return bArrDecode;
    }

    @JvmStatic
    @NotNull
    public static final String encodeBase64(@Nullable String text) {
        byte[] bytes;
        if (text != null) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            bytes = text.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        } else {
            bytes = null;
        }
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    @JvmStatic
    @NotNull
    public static final String encodeBase64(@Nullable byte[] bytes) {
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }
}
