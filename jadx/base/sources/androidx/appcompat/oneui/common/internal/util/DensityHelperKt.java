package androidx.appcompat.oneui.common.internal.util;

import android.content.res.Resources;
import androidx.annotation.RestrictTo;
import com.nimbusds.jose.jwk.JWKParameterNames;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018G¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "", "getDp", "(I)I", "appcompat_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DensityHelperKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int getDp(int i) {
        return (int) (i / Resources.getSystem().getDisplayMetrics().density);
    }
}
