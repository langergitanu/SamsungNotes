package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.option;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/option/ScribbleWeight;", "", "<init>", "()V", "DEFAULT_CODE", "", "DEFAULT_VALUE", "", "mValueToCode", "", "mCodeToValue", "getValue", "code", "getCode", "value", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScribbleWeight {

    @NotNull
    private static final String DEFAULT_CODE = "strong";
    public static final float DEFAULT_VALUE = 0.8f;

    @NotNull
    public static final ScribbleWeight INSTANCE = new ScribbleWeight();

    @NotNull
    private static final Map<String, Float> mCodeToValue;

    @NotNull
    private static final Map<Float, String> mValueToCode;

    static {
        HashMap map = new HashMap();
        mValueToCode = map;
        HashMap map2 = new HashMap();
        mCodeToValue = map2;
        Float fValueOf = Float.valueOf(0.95f);
        map.put(fValueOf, "extreme");
        Float fValueOf2 = Float.valueOf(0.8f);
        map.put(fValueOf2, DEFAULT_CODE);
        Float fValueOf3 = Float.valueOf(0.6f);
        map.put(fValueOf3, "mild");
        Float fValueOf4 = Float.valueOf(0.4f);
        map.put(fValueOf4, "weak");
        map2.put("extreme", fValueOf);
        map2.put(DEFAULT_CODE, fValueOf2);
        map2.put("mild", fValueOf3);
        map2.put("weak", fValueOf4);
    }

    private ScribbleWeight() {
    }

    @NotNull
    public final String getCode(float value) {
        String str = mValueToCode.get(Float.valueOf(value));
        return str == null ? DEFAULT_CODE : str;
    }

    public final float getValue(@NotNull String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        Float f = mCodeToValue.get(code);
        if (f != null) {
            return f.floatValue();
        }
        return 0.8f;
    }
}
