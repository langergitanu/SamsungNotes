package com.samsung.android.support.senl.p145cm.base.framework.constructor;

import android.os.Build;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013C2.AbstractC0053a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/constructor/JavaInstanceConstructor;", "", "<init>", "()V", "sSecureRandom", "Ljava/security/SecureRandom;", "createFileWriter", "Ljava/io/FileWriter;", "file", "Ljava/io/File;", "fileName", "", "createFileReader", "Ljava/io/FileReader;", "filePath", "secureRandom", "getSecureRandom$annotations", "getSecureRandom", "()Ljava/security/SecureRandom;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class JavaInstanceConstructor {

    @NotNull
    public static final JavaInstanceConstructor INSTANCE = new JavaInstanceConstructor();

    @Nullable
    private static SecureRandom sSecureRandom;

    private JavaInstanceConstructor() {
    }

    @JvmStatic
    @NotNull
    public static final FileReader createFileReader(@Nullable String filePath) {
        if (Build.VERSION.SDK_INT < 33) {
            return new FileReader(filePath);
        }
        Charset charset = StandardCharsets.UTF_8;
        return AbstractC0053a.m119k(filePath);
    }

    @JvmStatic
    @NotNull
    public static final FileWriter createFileWriter(@Nullable File file) {
        if (Build.VERSION.SDK_INT < 33) {
            return new FileWriter(file);
        }
        Charset charset = StandardCharsets.UTF_8;
        return AbstractC0053a.m120l(file);
    }

    @NotNull
    public static final synchronized SecureRandom getSecureRandom() {
        SecureRandom secureRandom;
        try {
            if (sSecureRandom == null) {
                sSecureRandom = new SecureRandom();
            }
            secureRandom = sSecureRandom;
            Intrinsics.checkNotNull(secureRandom, "null cannot be cast to non-null type java.security.SecureRandom");
        } catch (Throwable th) {
            throw th;
        }
        return secureRandom;
    }

    @JvmStatic
    @NotNull
    public static final FileWriter createFileWriter(@Nullable String fileName) {
        if (Build.VERSION.SDK_INT < 33) {
            return new FileWriter(fileName);
        }
        Charset charset = StandardCharsets.UTF_8;
        return AbstractC0053a.m121m(fileName);
    }

    @JvmStatic
    public static /* synthetic */ void getSecureRandom$annotations() {
    }
}
