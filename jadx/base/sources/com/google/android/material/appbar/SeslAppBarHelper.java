package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.C4548R;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/google/android/material/appbar/SeslAppBarHelper;", "", "()V", "Companion", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SeslAppBarHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int SUGGESTION_VIEW_HEIGHT_DP_LARGE = 200;
    private static final int SUGGESTION_VIEW_HEIGHT_DP_MEDIUM = 164;
    private static final int SUGGESTION_VIEW_HEIGHT_DP_SMALL = 150;
    private static final int SUGGESTION_VIEW_MATCH_PARENT = 0;
    private static final int SUGGESTION_VIEW_WIDTH_DP_LARGE = 440;
    private static final int SUGGESTION_VIEW_WIDTH_DP_MEDIUM = 360;
    private static final int SUGGESTION_VIEW_WIDTH_DP_SMALL = 272;
    private static final int SUGGESTION_WIN_HEIGHT_DP_THRESHOLD = 411;
    private static final int SUGGESTION_WIN_WIDTH_DP_LARGE_MAX = 1580;
    private static final int SUGGESTION_WIN_WIDTH_DP_MEDIUM_MAX = 599;
    private static final int SUGGESTION_WIN_WIDTH_DP_SMALL_MAX = 291;

    @NotNull
    public static final String TAG = "SeslAppBarHelper";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aJ\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/google/android/material/appbar/SeslAppBarHelper$Companion;", "", "()V", "SUGGESTION_VIEW_HEIGHT_DP_LARGE", "", "SUGGESTION_VIEW_HEIGHT_DP_MEDIUM", "SUGGESTION_VIEW_HEIGHT_DP_SMALL", "SUGGESTION_VIEW_MATCH_PARENT", "SUGGESTION_VIEW_WIDTH_DP_LARGE", "SUGGESTION_VIEW_WIDTH_DP_MEDIUM", "SUGGESTION_VIEW_WIDTH_DP_SMALL", "SUGGESTION_WIN_HEIGHT_DP_THRESHOLD", "SUGGESTION_WIN_WIDTH_DP_LARGE_MAX", "SUGGESTION_WIN_WIDTH_DP_MEDIUM_MAX", "SUGGESTION_WIN_WIDTH_DP_SMALL_MAX", SearchConstants.TargetContents.TAG, "", "dpToPx", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "getAppBarProPortion", "", "context", "Landroid/content/Context;", "getFullWindowHeightDp", "getScreenHeight", "view", "Landroid/view/View;", "getSuggestionAppBarSize", "Lkotlin/Pair;", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int dpToPx(int dp) {
            return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
        }

        public final float getAppBarProPortion(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Resources resources = context.getResources();
            Configuration configuration = resources.getConfiguration();
            if (Build.VERSION.SDK_INT < 35) {
                return ResourcesCompat.getFloat(resources, C4548R.dimen.sesl_appbar_height_proportion);
            }
            float fullWindowHeightDp = getFullWindowHeightDp(context);
            Log.d(SeslAppBarHelper.TAG, "orientation=" + configuration.orientation + ", fullWindowHeightDp=" + fullWindowHeightDp);
            if (configuration.orientation != 2) {
                if (fullWindowHeightDp < 639.0f) {
                    return 0.0f;
                }
                if (fullWindowHeightDp < 696.0f) {
                    return 0.48f;
                }
                if (fullWindowHeightDp < 780.0f) {
                    return 0.43f;
                }
                return fullWindowHeightDp < 960.0f ? 0.38f : 0.305f;
            }
            if (fullWindowHeightDp < 580.0f) {
                return 0.0f;
            }
            if (fullWindowHeightDp < 640.0f) {
                return 0.51f;
            }
            if (fullWindowHeightDp < 670.0f) {
                return 0.475f;
            }
            if (fullWindowHeightDp < 710.0f) {
                return 0.45f;
            }
            if (fullWindowHeightDp < 750.0f) {
                return 0.425f;
            }
            if (fullWindowHeightDp < 800.0f) {
                return 0.4f;
            }
            return fullWindowHeightDp < 1080.0f ? 0.37f : 0.27f;
        }

        @RequiresApi(34)
        public final float getFullWindowHeightDp(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            WindowMetrics currentWindowMetrics = ((WindowManager) systemService).getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "wm.currentWindowMetrics");
            int iHeight = currentWindowMetrics.getBounds().height();
            float fDeriveDimension = TypedValue.deriveDimension(1, iHeight, displayMetrics);
            Log.d(SeslAppBarHelper.TAG, "fullWindowHeight(dp)=" + fDeriveDimension + ", fullWindowHeight(px)=" + iHeight + ", screenHeightDp=" + context.getResources().getConfiguration().screenHeightDp);
            return fDeriveDimension;
        }

        public final int getScreenHeight(@NotNull View view) {
            Insets insets;
            Intrinsics.checkNotNullParameter(view, "view");
            Context context = view.getContext();
            if (Build.VERSION.SDK_INT < 35) {
                return context.getResources().getDisplayMetrics().heightPixels;
            }
            Object systemService = context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            WindowMetrics currentWindowMetrics = ((WindowManager) systemService).getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "wm.currentWindowMetrics");
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
            if (rootWindowInsets == null || (insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.systemBars())) == null) {
                insets = Insets.NONE;
            }
            Intrinsics.checkNotNullExpressionValue(insets, "rootInsets?.getInsets(Wi…temBars()) ?: Insets.NONE");
            int i = insets.top;
            int i2 = insets.bottom;
            int iHeight = (currentWindowMetrics.getBounds().height() - i) - i2;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(iHeight, i, "screenHeight(px)=", ", status=", ", navi=");
            sbM1173s.append(i2);
            Log.d(SeslAppBarHelper.TAG, sbM1173s.toString());
            return iHeight;
        }

        @NotNull
        public final Pair<Integer, Integer> getSuggestionAppBarSize(@NotNull Context context, @NotNull View view) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            int screenHeight = getScreenHeight(view);
            int i = context.getResources().getDisplayMetrics().widthPixels;
            return screenHeight >= dpToPx(411) ? i <= dpToPx(SeslAppBarHelper.SUGGESTION_WIN_WIDTH_DP_SMALL_MAX) ? new Pair<>(0, Integer.valueOf(context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_appbar_viewpager_height))) : i <= dpToPx(SeslAppBarHelper.SUGGESTION_WIN_WIDTH_DP_MEDIUM_MAX) ? new Pair<>(Integer.valueOf(dpToPx(SeslAppBarHelper.SUGGESTION_VIEW_WIDTH_DP_SMALL)), Integer.valueOf(dpToPx(150))) : i <= dpToPx(SeslAppBarHelper.SUGGESTION_WIN_WIDTH_DP_LARGE_MAX) ? new Pair<>(Integer.valueOf(dpToPx(360)), Integer.valueOf(dpToPx(164))) : new Pair<>(Integer.valueOf(dpToPx(SeslAppBarHelper.SUGGESTION_VIEW_WIDTH_DP_LARGE)), Integer.valueOf(dpToPx(200))) : new Pair<>(0, Integer.valueOf(context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_appbar_viewpager_height)));
        }

        private Companion() {
        }
    }
}
