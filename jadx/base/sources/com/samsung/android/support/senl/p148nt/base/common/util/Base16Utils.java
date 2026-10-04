package com.samsung.android.support.senl.p148nt.base.common.util;

import com.google.common.p130io.BaseEncoding;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/Base16Utils;", "", "<init>", "()V", "encode", "", "bytes", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBase16Utils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Base16Utils.kt\ncom/samsung/android/support/senl/nt/base/common/util/Base16Utils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,13:1\n1#2:14\n*E\n"})
public final class Base16Utils {

    @NotNull
    public static final Base16Utils INSTANCE = new Base16Utils();

    private Base16Utils() {
    }

    @JvmStatic
    @Nullable
    public static final String encode(@Nullable byte[] bytes) {
        if (bytes != null) {
            return BaseEncoding.base16().encode(bytes);
        }
        return null;
    }
}
