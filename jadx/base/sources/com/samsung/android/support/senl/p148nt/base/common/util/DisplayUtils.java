package com.samsung.android.support.senl.p148nt.base.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.collection.AbstractC0622a;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u000e\u0010\"\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 J\b\u0010#\u001a\u00020\bH\u0007J\u0010\u0010$\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u000e\u0010%\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 J\u0018\u0010&\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010'\u001a\u00020(H\u0007J\u0018\u0010)\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010*\u001a\u00020\bH\u0002J\u0010\u0010+\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010,\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0019\u0010-\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u001a\u00100\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010'\u001a\u00020(H\u0007J\u0018\u00101\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u00102\u001a\u00020\u0005H\u0007J\b\u00103\u001a\u00020\nH\u0007J\u001c\u00104\u001a\u00020\u001e2\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0007J\u0012\u00104\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u000108H\u0007J\u001c\u00109\u001a\u00020\u001e2\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0007J\u0010\u0010:\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010:\u001a\u00020\b2\u0006\u00107\u001a\u000208H\u0007J\u0010\u0010;\u001a\u00020\b2\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010<\u001a\u00020\b2\u0006\u00107\u001a\u000208H\u0007J\u0018\u0010:\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010=\u001a\u00020>H\u0007J\u001c\u0010?\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u00107\u001a\u0004\u0018\u000108H\u0007J&\u0010@\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u00107\u001a\u0004\u0018\u0001082\b\b\u0002\u0010A\u001a\u00020\u0018H\u0007J$\u0010B\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010A\u001a\u00020\u0018H\u0007J$\u0010B\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010C\u001a\u00020>2\b\b\u0002\u0010A\u001a\u00020\u0018H\u0007J$\u0010D\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010A\u001a\u00020\u0018H\u0007J$\u0010D\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010C\u001a\u00020>2\b\b\u0002\u0010A\u001a\u00020\u0018H\u0007J\u0010\u0010E\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u001c\u0010F\u001a\u00020\u001e2\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0007J\u000e\u0010G\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 J\u0018\u0010G\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010=\u001a\u00020>H\u0002J\u001c\u0010H\u001a\u00020\u001e2\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0007J\u0010\u0010I\u001a\u00020>2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010J\u001a\u00020>2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010K\u001a\u00020>2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010L\u001a\u00020>2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003R$\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R$\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u0017\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006O"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/DisplayUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DISPLAY_CATEGORY_BUILTIN", "EXTRA_BUILT_IN_DISPLAY", "", "mScreenSize", "Landroid/graphics/Rect;", "mMainScreenSize", "getMMainScreenSize$annotations", "screenOrientation", "getScreenOrientation$annotations", "getScreenOrientation", "()I", "setScreenOrientation", "(I)V", "displayCount", "getDisplayCount$annotations", "getDisplayCount", "setDisplayCount", "isIsMainDisplay", "", "isIsMainDisplay$annotations", "()Z", "setIsMainDisplay", "(Z)V", "init", "", "context", "Landroid/content/Context;", "getScreenDimension", "getScreenResolution", "getMainScreenResolution", "getScreenMinSize", "getScreenMaxSize", "onConfigurationChanged", "configuration", "Landroid/content/res/Configuration;", "configureScreenSize", "orientation", "getScreenSize", "getPhysicalScreenSize", "getWindowHeight", "(Landroid/content/Context;)Ljava/lang/Integer;", "getWindowWidth", "getWindowSize", "updateMainScreenSize", NotesConstants.KEY_CALLER, "getMainScreenSize", "updateListWidthByScreenSize", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "view", "Landroid/view/View;", "updateViewMarginByFlexibleSpacing", "getSpaceForFlexibleSpacing", "getDisplayCutoutHeightIfVisible", "getNavigationBarHeightIfVisible", "widthDp", "", "updateViewMarginByFlexibleSpacingForVst", "updateViewPaddingByFlexibleSpacingForVst", "fromOtherApps", "getStartSpaceForFlexibleSpacingForVst", "listWidthDp", "getEndSpaceForFlexibleSpacingForVst", "getMinFlexibleSpacing", "updateOnboardingPageWidthByScreenSize", "getSpaceForOnboardingPage", "updateOnboardingPageWidthByScreenSizeForVst", "getWidthDp", "getWidthPx", "getHeightDp", "getHeightPx", "getExtraBuiltInDisplay", "Landroid/view/Display;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDisplayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DisplayUtils.kt\ncom/samsung/android/support/senl/nt/base/common/util/DisplayUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,495:1\n1#2:496\n*E\n"})
public final class DisplayUtils {

    @NotNull
    private static final String DISPLAY_CATEGORY_BUILTIN = "com.samsung.android.hardware.display.category.BUILTIN";
    private static final int EXTRA_BUILT_IN_DISPLAY = 1;

    @NotNull
    private static final String TAG = "DisplayUtils";

    @NotNull
    public static final DisplayUtils INSTANCE = new DisplayUtils();

    @NotNull
    private static final Rect mScreenSize = new Rect();

    @NotNull
    private static final Rect mMainScreenSize = new Rect();
    private static int screenOrientation = 1;
    private static int displayCount = 1;
    private static boolean isIsMainDisplay = true;

    private DisplayUtils() {
    }

    private final boolean configureScreenSize(Context context, int orientation) {
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Rect rect = mScreenSize;
        defaultDisplay.getRectSize(rect);
        Logger.m8697d(TAG, "configureScreenSize, rect : " + rect);
        screenOrientation = orientation;
        return updateMainScreenSize(context, "configureScreenSize");
    }

    public static final int getDisplayCount() {
        return displayCount;
    }

    @JvmStatic
    public static /* synthetic */ void getDisplayCount$annotations() {
    }

    private final int getDisplayCutoutHeightIfVisible(View view) {
        int safeInsetTop;
        DisplayCutoutCompat displayCutout;
        DisplayCutoutCompat displayCutout2;
        DisplayCutoutCompat displayCutout3;
        DisplayCutoutCompat displayCutout4;
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        int safeInsetBottom = 0;
        if (view.getContext().getResources().getConfiguration().orientation == 2) {
            safeInsetTop = (rootWindowInsets == null || (displayCutout4 = rootWindowInsets.getDisplayCutout()) == null) ? 0 : displayCutout4.getSafeInsetLeft();
            if (rootWindowInsets != null && (displayCutout3 = rootWindowInsets.getDisplayCutout()) != null) {
                safeInsetBottom = displayCutout3.getSafeInsetRight();
            }
        } else {
            safeInsetTop = (rootWindowInsets == null || (displayCutout2 = rootWindowInsets.getDisplayCutout()) == null) ? 0 : displayCutout2.getSafeInsetTop();
            if (rootWindowInsets != null && (displayCutout = rootWindowInsets.getDisplayCutout()) != null) {
                safeInsetBottom = displayCutout.getSafeInsetBottom();
            }
        }
        int i = safeInsetTop + safeInsetBottom;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return ResourceUtils.convertPxToDp(context, i);
    }

    @JvmStatic
    public static final int getEndSpaceForFlexibleSpacingForVst(@Nullable Context context, @NotNull View view, boolean fromOtherApps) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return getEndSpaceForFlexibleSpacingForVst(context, marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart() + view.getMeasuredWidth(), fromOtherApps);
    }

    public static /* synthetic */ int getEndSpaceForFlexibleSpacingForVst$default(Context context, View view, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return getEndSpaceForFlexibleSpacingForVst(context, view, z);
    }

    @JvmStatic
    public static final float getHeightDp(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ResourceUtils.convertPxToDp(context, context.getResources().getDisplayMetrics().heightPixels);
    }

    @JvmStatic
    public static final float getHeightPx(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    @JvmStatic
    private static /* synthetic */ void getMMainScreenSize$annotations() {
    }

    @JvmStatic
    public static final int getMainScreenResolution() {
        Rect rect = mMainScreenSize;
        return rect.height() * rect.width();
    }

    @JvmStatic
    @NotNull
    public static final Rect getMainScreenSize() {
        return new Rect(mMainScreenSize);
    }

    @JvmStatic
    public static final int getMinFlexibleSpacing(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) ResourceUtils.convertDpToPixel(context, 10.0f);
    }

    @JvmStatic
    public static final int getNavigationBarHeightIfVisible(@NotNull View view) {
        int i;
        Insets insets;
        Insets insets2;
        Insets insets3;
        Insets insets4;
        Intrinsics.checkNotNullParameter(view, "view");
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        int i2 = 0;
        if (view.getContext().getResources().getConfiguration().orientation == 2) {
            i = (rootWindowInsets == null || (insets4 = rootWindowInsets.getInsets(WindowInsetsCompat.Type.navigationBars())) == null) ? 0 : insets4.left;
            if (rootWindowInsets != null && (insets3 = rootWindowInsets.getInsets(WindowInsetsCompat.Type.navigationBars())) != null) {
                i2 = insets3.right;
            }
        } else {
            i = (rootWindowInsets == null || (insets2 = rootWindowInsets.getInsets(WindowInsetsCompat.Type.navigationBars())) == null) ? 0 : insets2.top;
            if (rootWindowInsets != null && (insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.navigationBars())) != null) {
                i2 = insets.bottom;
            }
        }
        int i4 = i + i2;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return ResourceUtils.convertPxToDp(context, i4);
    }

    @JvmStatic
    @NotNull
    public static final Rect getScreenDimension(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Rect rect = mScreenSize;
        synchronized (rect) {
            try {
                if (rect.isEmpty()) {
                    INSTANCE.configureScreenSize(context, context.getResources().getConfiguration().orientation);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Logger.m8697d(TAG, "getScreenDimension, screen: " + rect);
        return rect;
    }

    @JvmStatic
    public static final int getScreenMinSize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Rect screenDimension = getScreenDimension(context);
        return (int) Math.min(screenDimension.width(), screenDimension.height());
    }

    public static final int getScreenOrientation() {
        return screenOrientation;
    }

    @JvmStatic
    public static /* synthetic */ void getScreenOrientation$annotations() {
    }

    @JvmStatic
    @NotNull
    public static final Rect getScreenSize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        Rect rect = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        Logger.m8697d(TAG, "getScreenSize, rect: " + rect);
        return rect;
    }

    @JvmStatic
    public static final int getSpaceForFlexibleSpacing(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getSpaceForFlexibleSpacing(context, getWidthDp(context));
    }

    @JvmStatic
    public static final int getStartSpaceForFlexibleSpacingForVst(@Nullable Context context, @NotNull View view, boolean fromOtherApps) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return getStartSpaceForFlexibleSpacingForVst(context, marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart() + view.getMeasuredWidth(), fromOtherApps);
    }

    public static /* synthetic */ int getStartSpaceForFlexibleSpacingForVst$default(Context context, View view, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return getStartSpaceForFlexibleSpacingForVst(context, view, z);
    }

    @JvmStatic
    public static final float getWidthDp(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ResourceUtils.convertPxToDp(context, context.getResources().getDisplayMetrics().widthPixels);
    }

    @JvmStatic
    public static final float getWidthPx(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    @JvmStatic
    @Nullable
    public static final Integer getWindowHeight(@Nullable Context context) {
        Resources resources;
        Configuration configuration;
        Rect windowSize = (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? null : getWindowSize(context, configuration);
        if (windowSize != null) {
            return Integer.valueOf(windowSize.height());
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final Rect getWindowSize(@Nullable Context context, @NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Rect rect = new Rect(0, 0, (int) ResourceUtils.convertDpToPixel(context, configuration.screenWidthDp), (int) ResourceUtils.convertDpToPixel(context, configuration.screenHeightDp));
        Logger.m8697d(TAG, "getWindowSize, rect: " + rect);
        return rect;
    }

    @JvmStatic
    public static final int getWindowWidth(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Configuration configuration = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        return getWindowSize(context, configuration).width();
    }

    public static final boolean isIsMainDisplay() {
        return isIsMainDisplay;
    }

    @JvmStatic
    public static /* synthetic */ void isIsMainDisplay$annotations() {
    }

    @JvmStatic
    public static final boolean onConfigurationChanged(@NotNull Context context, @NotNull Configuration configuration) {
        boolean zConfigureScreenSize;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        int i = configuration.orientation;
        int i2 = screenOrientation;
        int i4 = configuration.densityDpi;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "onConfigurationChanged, orientation : ", ", pre : ", ", dpi : ");
        sbM1173s.append(i4);
        Logger.m8697d(TAG, sbM1173s.toString());
        synchronized (mScreenSize) {
            zConfigureScreenSize = INSTANCE.configureScreenSize(context, configuration.orientation);
        }
        return zConfigureScreenSize;
    }

    public static final void setDisplayCount(int i) {
        displayCount = i;
    }

    public static final void setIsMainDisplay(boolean z) {
        isIsMainDisplay = z;
    }

    public static final void setScreenOrientation(int i) {
        screenOrientation = i;
    }

    @JvmStatic
    public static final void updateListWidthByScreenSize(@Nullable Activity activity, @Nullable View view) {
        if (activity == null || view == null) {
            return;
        }
        int spaceForFlexibleSpacing = getSpaceForFlexibleSpacing(activity);
        view.setPadding(spaceForFlexibleSpacing, view.getPaddingTop(), spaceForFlexibleSpacing, view.getPaddingBottom());
    }

    @JvmStatic
    public static final boolean updateMainScreenSize(@NotNull Context context, @NotNull String caller) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(caller, "caller");
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int i4 = i < i2 ? i : i2;
        Logger.m8697d(TAG, "display info WidthPixels : " + i + ", HeightPixels : " + i2);
        Object systemService2 = context.getSystemService("display");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        isIsMainDisplay = true;
        displayCount = 1;
        Display[] displays = ((DisplayManager) systemService2).getDisplays(DISPLAY_CATEGORY_BUILTIN);
        if (displays != null && displays.length > 1) {
            int length = displays.length;
            displayCount = length;
            int i5 = i4;
            for (int i6 = 0; i6 < length; i6++) {
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                displays[i6].getRealMetrics(displayMetrics2);
                int i7 = displayMetrics2.widthPixels;
                int i8 = displayMetrics2.heightPixels;
                int i9 = i7 < i8 ? i7 : i8;
                if (i4 != i9) {
                    i4 = 0;
                } else if (i6 == displayCount - 1) {
                    Logger.m8698e(TAG, "updateMainScreenSize: sameWidth = " + i4);
                    return false;
                }
                if (i5 < i9) {
                    isIsMainDisplay = false;
                    i2 = i8;
                    i = i7;
                    i5 = i9;
                }
            }
        }
        int i10 = displayCount;
        boolean z = isIsMainDisplay;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "Apply display info WidthPixels : ", ", HeightPixels : ", ", count : ");
        sbM1173s.append(i10);
        sbM1173s.append(" / is Main ? ");
        sbM1173s.append(z);
        sbM1173s.append(" / ");
        sbM1173s.append(caller);
        Logger.m8697d(TAG, sbM1173s.toString());
        mMainScreenSize.set(0, 0, i, i2);
        DeviceUtils.resetDeviceMemoryLevel();
        return true;
    }

    @JvmStatic
    public static final void updateOnboardingPageWidthByScreenSize(@Nullable Activity activity, @Nullable View view) {
        if (activity == null || view == null) {
            return;
        }
        int spaceForOnboardingPage = INSTANCE.getSpaceForOnboardingPage(activity);
        view.setPadding(spaceForOnboardingPage, view.getPaddingTop(), spaceForOnboardingPage, view.getPaddingBottom());
    }

    @JvmStatic
    public static final void updateOnboardingPageWidthByScreenSizeForVst(@Nullable Activity activity, @Nullable View view) {
        if (activity == null || view == null) {
            return;
        }
        int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(activity, 64.0f);
        view.setPadding(iConvertDpToPixel, view.getPaddingTop(), iConvertDpToPixel, view.getPaddingBottom());
    }

    @JvmStatic
    public static final void updateViewMarginByFlexibleSpacing(@Nullable Activity activity, @Nullable View view) {
        if (activity == null || view == null) {
            return;
        }
        int spaceForFlexibleSpacing = getSpaceForFlexibleSpacing(activity);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMarginStart(spaceForFlexibleSpacing);
        marginLayoutParams.setMarginEnd(spaceForFlexibleSpacing);
        view.setLayoutParams(marginLayoutParams);
    }

    @JvmStatic
    public static final void updateViewMarginByFlexibleSpacingForVst(@Nullable Context context, @Nullable View view) {
        if (context == null || view == null) {
            return;
        }
        int startSpaceForFlexibleSpacingForVst$default = getStartSpaceForFlexibleSpacingForVst$default(context, getWidthPx(context), false, 4, (Object) null);
        int endSpaceForFlexibleSpacingForVst$default = getEndSpaceForFlexibleSpacingForVst$default(context, getWidthPx(context), false, 4, (Object) null);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMarginStart(startSpaceForFlexibleSpacingForVst$default);
        marginLayoutParams.setMarginEnd(endSpaceForFlexibleSpacingForVst$default);
        view.setLayoutParams(marginLayoutParams);
    }

    @JvmStatic
    public static final void updateViewPaddingByFlexibleSpacingForVst(@Nullable Context context, @Nullable View view, boolean fromOtherApps) {
        if (context == null || view == null) {
            return;
        }
        view.setPadding(getStartSpaceForFlexibleSpacingForVst(context, getWidthPx(context), fromOtherApps), view.getPaddingTop(), getEndSpaceForFlexibleSpacingForVst(context, getWidthPx(context), fromOtherApps), view.getPaddingBottom());
    }

    public static /* synthetic */ void updateViewPaddingByFlexibleSpacingForVst$default(Context context, View view, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        updateViewPaddingByFlexibleSpacingForVst(context, view, z);
    }

    @Nullable
    public final Display getExtraBuiltInDisplay(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("display");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        Iterator it = ArrayIteratorKt.iterator(((DisplayManager) systemService).getDisplays(DISPLAY_CATEGORY_BUILTIN));
        while (it.hasNext()) {
            Display display = (Display) it.next();
            if (display.getDisplayId() == 1) {
                return display;
            }
        }
        return null;
    }

    @NotNull
    public final Rect getPhysicalScreenSize(@Nullable Context context) {
        Object systemService = context != null ? context.getSystemService("window") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        Logger.m8697d(TAG, "getPhysicalScreenSize, realMetrics: " + displayMetrics);
        int physicalWidth = displayMetrics.widthPixels;
        int physicalHeight = displayMetrics.heightPixels;
        Display.Mode[] supportedModes = windowManager.getDefaultDisplay().getSupportedModes();
        Iterator it = ArrayIteratorKt.iterator(supportedModes);
        while (it.hasNext()) {
            Display.Mode mode = (Display.Mode) it.next();
            if (mode.getPhysicalWidth() > physicalWidth) {
                physicalWidth = mode.getPhysicalWidth();
            }
            if (mode.getPhysicalHeight() > physicalHeight) {
                physicalHeight = mode.getPhysicalHeight();
            }
        }
        Rect rect = new Rect(0, 0, physicalWidth, physicalHeight);
        Logger.m8697d(TAG, "getPhysicalScreenSize, rect: " + rect + " with " + supportedModes.length);
        return rect;
    }

    public final int getScreenMaxSize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Rect screenDimension = getScreenDimension(context);
        return (int) Math.max(screenDimension.width(), screenDimension.height());
    }

    public final int getScreenResolution(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Rect screenDimension = getScreenDimension(context);
        return screenDimension.height() * screenDimension.width();
    }

    public final int getSpaceForOnboardingPage(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getSpaceForOnboardingPage(context, getWidthDp(context));
    }

    public final void init() {
        Rect rect = mScreenSize;
        synchronized (rect) {
            rect.setEmpty();
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ int getEndSpaceForFlexibleSpacingForVst$default(Context context, float f, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return getEndSpaceForFlexibleSpacingForVst(context, f, z);
    }

    public static /* synthetic */ int getStartSpaceForFlexibleSpacingForVst$default(Context context, float f, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return getStartSpaceForFlexibleSpacingForVst(context, f, z);
    }

    @JvmStatic
    public static final int getSpaceForFlexibleSpacing(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        float widthDp = getWidthDp(context);
        if (view.getContext().getResources().getConfiguration().orientation == 2) {
            widthDp -= getNavigationBarHeightIfVisible(view) + INSTANCE.getDisplayCutoutHeightIfVisible(view);
        }
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        return getSpaceForFlexibleSpacing(context2, widthDp);
    }

    private final int getSpaceForOnboardingPage(Context context, float widthDp) {
        double dMin;
        int i;
        float f = context.getResources().getConfiguration().smallestScreenWidthDp;
        if (f < 751.0f) {
            if (f >= 600.0f) {
                dMin = Math.min((int) (((double) widthDp) * 0.17d), 100.0d);
            } else if (context.getResources().getConfiguration().orientation == 1) {
                i = 32;
            } else {
                dMin = ((double) widthDp) * 0.14d;
            }
            i = (int) dMin;
        } else if (context.getResources().getConfiguration().orientation == 1) {
            dMin = (((double) widthDp) * 0.1d) + ((double) 108);
            i = (int) dMin;
        } else {
            i = (int) (f >= 960.0f ? (((double) widthDp) * 0.25d) + ((double) 80) : ((double) widthDp) * 0.25d);
        }
        return (int) ResourceUtils.convertDpToPixel(context, i);
    }

    @JvmStatic
    public static final void updateListWidthByScreenSize(@Nullable View view) {
        if (view == null) {
            return;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int spaceForFlexibleSpacing = getSpaceForFlexibleSpacing(context);
        view.setPadding(spaceForFlexibleSpacing, view.getPaddingTop(), spaceForFlexibleSpacing, view.getPaddingBottom());
    }

    @JvmStatic
    public static final int getEndSpaceForFlexibleSpacingForVst(@Nullable Context context, float listWidthDp, boolean fromOtherApps) {
        float f = 10.0f;
        if (context != null) {
            float dimension = context.getResources().getDimension(C8875R.dimen.vst_list_default_width);
            if (fromOtherApps) {
                f = 32.0f;
            } else if (listWidthDp > dimension) {
                f = (listWidthDp - dimension) / 2;
            }
        }
        return (int) f;
    }

    @JvmStatic
    public static final int getStartSpaceForFlexibleSpacingForVst(@Nullable Context context, float listWidthDp, boolean fromOtherApps) {
        float f = 10.0f;
        if (context != null) {
            float dimension = context.getResources().getDimension(C8875R.dimen.vst_list_default_width);
            if (!fromOtherApps && listWidthDp > dimension) {
                f = (listWidthDp - dimension) / 2;
            }
        }
        return (int) f;
    }

    @JvmStatic
    public static final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Rect rect = mScreenSize;
        synchronized (rect) {
            try {
                if (rect.isEmpty()) {
                    INSTANCE.configureScreenSize(context, context.getResources().getConfiguration().orientation);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    public static final int getSpaceForFlexibleSpacing(@NotNull Context context, float widthDp) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) ResourceUtils.convertDpToPixel(context, widthDp >= 960.0f ? (widthDp - 840) / 2 : (widthDp < 589.0f || getHeightDp(context) <= 411.0f) ? 10.0f : (int) (((double) widthDp) * 0.07d));
    }
}
