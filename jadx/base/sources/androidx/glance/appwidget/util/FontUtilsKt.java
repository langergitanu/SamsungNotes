package androidx.glance.appwidget.util;

import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import androidx.compose.p109ui.unit.TextUnit;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a \u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t\u001a \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "dpToPx", "", "context", "Landroid/content/Context;", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "Landroidx/compose/ui/unit/Dp;", "density", "", "dpToPx-lG28NQ4", "(Landroid/content/Context;FF)I", "pxToDp", "px", "pxToSp", "spToPx", "sp", "Landroidx/compose/ui/unit/TextUnit;", "spToPx-mpE4wyQ", "(Landroid/content/Context;J)I", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class FontUtilsKt {

    @NotNull
    private static final String TAG = "GWT:FontUtils";

    /* JADX INFO: renamed from: dpToPx-lG28NQ4, reason: not valid java name */
    public static final int m21412dpToPxlG28NQ4(@NotNull Context context, float f, float f4) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f4 == -1.0f ? (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics()) : (int) (f * f4);
    }

    /* JADX INFO: renamed from: dpToPx-lG28NQ4$default, reason: not valid java name */
    public static /* synthetic */ int m21413dpToPxlG28NQ4$default(Context context, float f, float f4, int i, Object obj) {
        if ((i & 4) != 0) {
            f4 = -1.0f;
        }
        return m21412dpToPxlG28NQ4(context, f, f4);
    }

    public static final float pxToDp(@NotNull Context context, float f, float f4) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT >= 34 ? f4 == -1.0f ? TypedValue.deriveDimension(1, f, context.getResources().getDisplayMetrics()) : f / f4 : f / context.getResources().getDisplayMetrics().density;
    }

    public static /* synthetic */ float pxToDp$default(Context context, float f, float f4, int i, Object obj) {
        if ((i & 4) != 0) {
            f4 = -1.0f;
        }
        return pxToDp(context, f, f4);
    }

    public static final float pxToSp(@NotNull Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT >= 34 ? TypedValue.deriveDimension(2, f, context.getResources().getDisplayMetrics()) : f / context.getResources().getDisplayMetrics().scaledDensity;
    }

    /* JADX INFO: renamed from: spToPx-mpE4wyQ, reason: not valid java name */
    public static final int m21414spToPxmpE4wyQ(@NotNull Context context, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) TypedValue.applyDimension(2, TextUnit.m21161getValueimpl(j), context.getResources().getDisplayMetrics());
    }
}
