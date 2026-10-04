package com.microsoft.identity.common.java.util;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.exception.ClientException;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/microsoft/identity/common/java/util/ArgUtils;", "", "()V", "validateNonNullArg", "", "o", "argName", "", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ArgUtils {

    @NotNull
    public static final ArgUtils INSTANCE = new ArgUtils();

    private ArgUtils() {
    }

    public final void validateNonNullArg(@Nullable Object o, @NotNull String argName) throws ClientException {
        Intrinsics.checkNotNullParameter(argName, "argName");
        if (o == null || (((o instanceof char[]) && ((char[]) o).length == 0) || (((o instanceof CharSequence) && StringsKt.isBlank((CharSequence) o)) || (((o instanceof String) && StringsKt.isBlank((CharSequence) o)) || (((o instanceof List) && ((List) o).isEmpty()) || ((o instanceof Map) && ((Map) o).isEmpty())))))) {
            throw new ClientException(argName, AbstractC0541b.m756B(argName, " cannot be null or empty"));
        }
    }
}
