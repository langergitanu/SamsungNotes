package com.samsung.android.support.notes.bixby.bixby2.action;

import android.os.Build;
import android.util.Base64;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.bixby2.action.ResponseCallback;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/action/AbsBixbyAction;", "", "mCallback", "Lcom/samsung/android/sdk/bixby2/action/ResponseCallback;", "<init>", "(Lcom/samsung/android/sdk/bixby2/action/ResponseCallback;)V", "decodeString", "", "str", "Companion", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsBixbyAction {

    @NotNull
    private static final String TAG = "AbsBixbyAction";

    @JvmField
    @NotNull
    public ResponseCallback mCallback;

    public AbsBixbyAction(@NotNull ResponseCallback mCallback) {
        Intrinsics.checkNotNullParameter(mCallback, "mCallback");
        this.mCallback = mCallback;
    }

    @NotNull
    public final String decodeString(@Nullable String str) {
        if (Build.VERSION.SDK_INT <= 26) {
            byte[] bArrDecode = Base64.decode(str, 0);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return new String(bArrDecode, UTF_8);
        }
        try {
            byte[] bArrDecode2 = Base64.decode(str, 0);
            Intrinsics.checkNotNullExpressionValue(bArrDecode2, "decode(...)");
            Charset charsetForName = Charset.forName("CESU-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            return new String(bArrDecode2, charsetForName);
        } catch (UnsupportedEncodingException e) {
            AbstractC4539a.m3214x("decodeString() Error : ", e.getMessage(), TAG);
            return "";
        }
    }
}
