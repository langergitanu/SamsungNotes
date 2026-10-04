package com.samsung.android.support.senl.p148nt.base.common.sync;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/EncryptUtil;", "", "<init>", "()V", "mKeyAlias", "", "mKey", "Ljavax/crypto/SecretKey;", "generateKeyFromKeystore", "", "strAlias", "decrypt", "value", "encrypt", "keyFromKeystore", "getKeyFromKeystore", "()Ljavax/crypto/SecretKey;", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nEncryptUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EncryptUtil.kt\ncom/samsung/android/support/senl/nt/base/common/sync/EncryptUtil\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,129:1\n37#2:130\n36#2,3:131\n*S KotlinDebug\n*F\n+ 1 EncryptUtil.kt\ncom/samsung/android/support/senl/nt/base/common/sync/EncryptUtil\n*L\n56#1:130\n56#1:131,3\n*E\n"})
public final class EncryptUtil {

    @NotNull
    private static final String ANDROID_KEYSTORE = "AndroidKeyStore";

    @NotNull
    private static final String CIPHER_VALUE = "AES/CBC/PKCS7Padding";

    /* JADX INFO: renamed from: IV */
    @NotNull
    private static final String f6447IV = "IV";

    @NotNull
    private static final String TAG = "EncryptUtil";

    @NotNull
    private static final String packageName = "com.samsung.android.support.notes.sync";

    @NotNull
    private final String mKeyAlias = "com.samsung.android.support.notes.sync_EncryptUtil";

    @Nullable
    private final SecretKey mKey = getKeyFromKeystore();

    private final void generateKeyFromKeystore(String strAlias) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES256KeyLoader.AES_ALGORITHM, ANDROID_KEYSTORE);
        keyGenerator.init(new KeyGenParameterSpec.Builder(strAlias, 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setRandomizedEncryptionRequired(false).build());
        keyGenerator.generateKey();
    }

    private final SecretKey getKeyFromKeystore() {
        try {
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEYSTORE);
            keyStore.load(null);
            Key key = keyStore.getKey(this.mKeyAlias, null);
            if ((key instanceof SecretKey ? (SecretKey) key : null) == null) {
                generateKeyFromKeystore(this.mKeyAlias);
            }
            Key key2 = keyStore.getKey(this.mKeyAlias, null);
            Intrinsics.checkNotNull(key2, "null cannot be cast to non-null type javax.crypto.SecretKey");
            return (SecretKey) key2;
        } catch (Exception e) {
            Debugger.INSTANCE.m8621e(TAG, e.getMessage());
            return null;
        }
    }

    @Nullable
    public final String decrypt(@Nullable String value) {
        String str;
        String str2;
        if (value == null) {
            return null;
        }
        String[] strArr = (String[]) AbstractC12991c.m13999t(0, ",", value).toArray(new String[0]);
        if (strArr.length == 2) {
            str2 = strArr[0];
            str = strArr[1];
        } else {
            str = null;
            str2 = null;
        }
        if (str2 != null && str != null) {
            try {
                byte[] bArrDecode = Base64.decode(str2, 0);
                byte[] bArrDecode2 = Base64.decode(str, 0);
                Cipher cipher = Cipher.getInstance(CIPHER_VALUE);
                cipher.init(2, this.mKey, new IvParameterSpec(bArrDecode2));
                byte[] bArrDoFinal = cipher.doFinal(bArrDecode);
                if (bArrDoFinal == null) {
                    return null;
                }
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                return new String(bArrDoFinal, UTF_8);
            } catch (Exception e) {
                Debugger.INSTANCE.m8619d(TAG, "getEncryptString : " + e);
            }
        }
        return null;
    }

    @NotNull
    public final String encrypt(@Nullable String value) {
        String strEncodeToString;
        String strEncodeToString2;
        byte[] iv;
        String str = "";
        if (value != null) {
            try {
                Cipher cipher = Cipher.getInstance(CIPHER_VALUE);
                cipher.init(1, this.mKey);
                iv = ((IvParameterSpec) cipher.getParameters().getParameterSpec(IvParameterSpec.class)).getIV();
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                byte[] bytes = value.getBytes(UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                strEncodeToString = Base64.encodeToString(cipher.doFinal(bytes), 0);
                Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
            } catch (Exception e) {
                e = e;
                strEncodeToString = "";
            }
            try {
                strEncodeToString2 = Base64.encodeToString(iv, 0);
                Intrinsics.checkNotNullExpressionValue(strEncodeToString2, "encodeToString(...)");
            } catch (Exception e2) {
                e = e2;
                Debugger.INSTANCE.m8619d(TAG, "putEncryptString : " + e);
                strEncodeToString2 = "";
            }
            str = strEncodeToString;
        } else {
            strEncodeToString2 = "";
        }
        return AbstractC0541b.m757C(str, ",", strEncodeToString2);
    }
}
