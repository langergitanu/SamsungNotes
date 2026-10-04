package com.samsung.android.support.senl.p145cm.base.common.util;

import android.text.TextUtils;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/HashUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "ALGORITHM_SHA256", "HASHED_LENGTH", "", "emptyHashedString", "getEmptyHashedString$annotations", "getEmptyHashedString", "()Ljava/lang/String;", "isHashed", "", "src", "generateSha256", "generateSha1", "executeHashing", "", "alogrithm", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHashUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HashUtils.kt\ncom/samsung/android/support/senl/cm/base/common/util/HashUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n1#2:58\n*E\n"})
public final class HashUtils {

    @NotNull
    private static final String ALGORITHM_SHA256 = "SHA-256";
    private static final int HASHED_LENGTH = 64;

    @NotNull
    private static final String TAG = "HashUtils";

    @NotNull
    public static final HashUtils INSTANCE = new HashUtils();

    @Nullable
    private static final String emptyHashedString = generateSha256("");

    private HashUtils() {
    }

    private final byte[] executeHashing(String alogrithm, String src) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(alogrithm);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = src.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return messageDigest.digest(bytes);
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String generateSha1(@NotNull String src) {
        Intrinsics.checkNotNullParameter(src, "src");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(IDevicePopManager.SHA_1);
            Charset charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            byte[] bytes = src.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            messageDigest.update(bytes, 0, bytes.length);
            byte[] bArrDigest = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
            return ConvertUtil.bytesToHex(bArrDigest);
        } catch (UnsupportedEncodingException e) {
            LoggerBase.INSTANCE.m7133e(TAG, e.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e2) {
            LoggerBase.INSTANCE.m7133e(TAG, e2.getMessage());
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String generateSha256(@Nullable String src) {
        byte[] bArrExecuteHashing;
        if (src == null || (bArrExecuteHashing = INSTANCE.executeHashing("SHA-256", src)) == null) {
            return null;
        }
        return ConvertUtil.bytesToHex(bArrExecuteHashing);
    }

    @Nullable
    public static final String getEmptyHashedString() {
        return emptyHashedString;
    }

    @JvmStatic
    public static final boolean isHashed(@Nullable String src) {
        return (TextUtils.isEmpty(src) || src == null || src.length() != 64) ? false : true;
    }

    @JvmStatic
    public static /* synthetic */ void getEmptyHashedString$annotations() {
    }
}
