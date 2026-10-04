package androidx.glance.appwidget.unit;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.annotation.ColorRes;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.core.content.ContextCompat;
import androidx.glance.oneui.common.GlanceLog;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a5\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\u0010\u0011\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003¨\u0006\u0012"}, m13886d2 = {"CheckedStateSet", "", "getCheckedStateSet", "()[I", SearchConstants.TargetContents.TAG, "", "UncheckedStateSet", "getUncheckedStateSet", "resolveCheckedColor", "Landroidx/compose/ui/graphics/Color;", "context", "Landroid/content/Context;", "resId", "", "isChecked", "", "isNightMode", "(Landroid/content/Context;IZLjava/lang/Boolean;)Landroidx/compose/ui/graphics/Color;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ColorProviderKt {

    @NotNull
    private static final String TAG = "GWT:ColorProvider";

    @NotNull
    private static final int[] CheckedStateSet = {R.attr.state_checked};

    @NotNull
    private static final int[] UncheckedStateSet = {-16842912};

    @NotNull
    public static final int[] getCheckedStateSet() {
        return CheckedStateSet;
    }

    @NotNull
    public static final int[] getUncheckedStateSet() {
        return UncheckedStateSet;
    }

    @Nullable
    public static final Color resolveCheckedColor(@NotNull Context context, @ColorRes int i, boolean z, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i == 0) {
            return null;
        }
        if (bool != null) {
            Configuration configuration = new Configuration();
            configuration.uiMode = bool.booleanValue() ? 32 : 16;
            context = context.createConfigurationContext(configuration);
        }
        try {
            ColorStateList colorStateList = ContextCompat.getColorStateList(context, i);
            if (colorStateList == null) {
                return null;
            }
            return Color.m18515boximpl(ColorKt.Color(colorStateList.getColorForState(z ? CheckedStateSet : UncheckedStateSet, colorStateList.getDefaultColor())));
        } catch (Resources.NotFoundException e) {
            GlanceLog.INSTANCE.m2306w(TAG, "Could not resolve the checked color", e);
            return null;
        }
    }

    public static /* synthetic */ Color resolveCheckedColor$default(Context context, int i, boolean z, Boolean bool, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            bool = null;
        }
        return resolveCheckedColor(context, i, z, bool);
    }
}
