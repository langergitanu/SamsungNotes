package com.samsung.android.support.senl.p148nt.base.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ByteArrayInOutStream;", "Ljava/io/ByteArrayOutputStream;", "<init>", "()V", "inputStream", "Ljava/io/ByteArrayInputStream;", "getInputStream", "()Ljava/io/ByteArrayInputStream;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ByteArrayInOutStream extends ByteArrayOutputStream {
    @NotNull
    public final ByteArrayInputStream getInputStream() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
        ((ByteArrayOutputStream) this).buf = null;
        return byteArrayInputStream;
    }
}
