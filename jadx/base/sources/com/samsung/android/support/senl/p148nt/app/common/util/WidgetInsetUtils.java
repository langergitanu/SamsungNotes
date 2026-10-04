package com.samsung.android.support.senl.p148nt.app.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingBottomLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.C7857i;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.RunnableC4199v;
import p123b3.C4201a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J`\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u001c2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J\u001a\u0010(\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010)\u001a\u00020\u001cH\u0002JD\u0010*\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J:\u0010-\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010.\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u001c\u0010/\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007JB\u00100\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u00101\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J\u001c\u00102\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u00103\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J$\u00104\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u001a\u00105\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J&\u00106\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u001cH\u0007J\b\u00107\u001a\u00020\u0007H\u0007J\u001c\u00108\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001cH\u0007J(\u00108\u001a\u00020\u00182\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>H\u0007J&\u00108\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010;\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u00138GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016¨\u0006?"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/util/WidgetInsetUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "insetsTop", "", "insetsBottom", "insetsStart", "insetsEnd", "settingInsetsBottom", "getSettingInsetsBottom", "()I", "setSettingInsetsBottom", "(I)V", "drawerInsetsTop", "drawerInsetsBottom", "canUseWindowInsets", "", "getCanUseWindowInsets$annotations", "getCanUseWindowInsets", "()Z", "applyWindowInsetsForList", "", "window", "Landroid/view/Window;", "container", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "drawerView", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "noteFab", "noteFakeFab", "floatingToolbarLayout", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout;", "floatingBottomLayout", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingBottomLayout;", "calculateInsets", "itemListView", "applyWindowInsetsForSetting", "settingContents", "Landroid/view/ViewGroup;", "applyWindowInsetsForImportList", "importList", "applyWindowInsetsForMs", "applyWindowInsetsForFolderList", "folderList", "applyWindowInsetsToContainer", "applyWindowInsetsToGoToTop", "applyWindowInsetsToToolbarLayout", "applyWindowInsetsToBottomContainer", "applyWindowInsetsToNoteFab", "getTopBottomInsets", "applyWindowInsetsToDrawer", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", ActionHandler.PARAMS, "Landroid/view/ViewGroup$MarginLayoutParams;", "endAction", "Ljava/lang/Runnable;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetInsetUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetInsetUtils.kt\ncom/samsung/android/support/senl/nt/app/common/util/WidgetInsetUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,575:1\n1#2:576\n*E\n"})
public final class WidgetInsetUtils {

    @NotNull
    public static final WidgetInsetUtils INSTANCE = new WidgetInsetUtils();

    @NotNull
    private static final String TAG = "WidgetInsetUtils";
    private static int drawerInsetsBottom;
    private static int drawerInsetsTop;
    private static int insetsBottom;
    private static int insetsEnd;
    private static int insetsStart;
    private static int insetsTop;
    private static int settingInsetsBottom;

    private WidgetInsetUtils() {
    }

    @JvmStatic
    public static final void applyWindowInsetsForFolderList(@Nullable Window window, @Nullable View container, @NotNull RecyclerView folderList, @Nullable AppBarLayout appBarLayout, @Nullable FloatingToolbarLayout floatingToolbarLayout, @Nullable FloatingBottomLayout floatingBottomLayout) throws Exception {
        View decorView;
        Intrinsics.checkNotNullParameter(folderList, "folderList");
        if (getCanUseWindowInsets()) {
            WindowInsetsManager.Companion companion = WindowInsetsManager.INSTANCE;
            if (companion.getInstance().hasInvalidWindowInset()) {
                companion.getInstance().requestAndGetInsets(container, new C8038a(window, container, folderList, appBarLayout, floatingToolbarLayout, floatingBottomLayout, 0));
                return;
            }
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext == null) {
                return;
            }
            int multiWindowMode = WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(folderList.getResources().getConfiguration());
            boolean z = true;
            boolean z2 = multiWindowMode == 0;
            int[] iArr = new int[2];
            if (window != null && (decorView = window.getDecorView()) != null) {
                decorView.getLocationOnScreen(iArr);
            }
            int iHeight = DisplayUtils.getScreenSize(applicationContext).height() / 2;
            boolean z3 = z2 || (multiWindowMode == 2 && iArr[1] <= iHeight);
            if (!z2 && (multiWindowMode != 2 || iArr[1] <= iHeight)) {
                z = false;
            }
            boolean zIsRTLMode = LocaleUtils.isRTLMode();
            Insets systemBarInsets = companion.getInstance().getSystemBarInsets();
            Insets displayCutoutInsets = companion.getInstance().getDisplayCutoutInsets();
            int iCoerceAtLeast = z3 ? RangesKt.coerceAtLeast(systemBarInsets.top, displayCutoutInsets.top) : 0;
            int dimensionPixelSize = applicationContext.getResources().getDimensionPixelSize(C8003R.dimen.notes_list_floating_bottom_padding) + ((z || (FoldStateCompat.INSTANCE.getInstance().isFoldableDevice() && DisplayDeviceTypeCompat.INSTANCE.getInstance().isSubDisplay(folderList.getResources().getConfiguration()))) ? RangesKt.coerceAtLeast(systemBarInsets.bottom, displayCutoutInsets.bottom) : 0);
            StringBuilder sbM2230u = AbstractC2821a.m2230u("applyWindowInsetsForFolderList, isFullScreen:", ", isRTLMode:", ", insetsTop:", z2, zIsRTLMode);
            AbstractC2821a.m2235z(sbM2230u, iCoerceAtLeast, dimensionPixelSize, ", insetsBottom:", ", windowMode:");
            AbstractC8014b.m7212n(sbM2230u, TAG, multiWindowMode);
            WidgetInsetUtils widgetInsetUtils = INSTANCE;
            widgetInsetUtils.applyWindowInsetsToContainer(window, container);
            if (floatingToolbarLayout != null) {
                if (appBarLayout != null) {
                    appBarLayout.seslSetCollapsedHeight(appBarLayout.seslGetDefaultCollapsedHeight() + iCoerceAtLeast);
                }
                if (appBarLayout != null) {
                    appBarLayout.seslSetProportionExtraHeight(iCoerceAtLeast);
                }
                floatingToolbarLayout.setPaddingRelative(floatingToolbarLayout.getPaddingStart(), iCoerceAtLeast, floatingToolbarLayout.getPaddingEnd(), floatingToolbarLayout.getPaddingBottom());
                floatingToolbarLayout.setRecyclerView(folderList);
            }
            if (floatingBottomLayout != null) {
                floatingBottomLayout.setPaddingRelative(floatingBottomLayout.getPaddingStart(), 0, floatingBottomLayout.getPaddingEnd(), dimensionPixelSize);
                floatingBottomLayout.setRecyclerView(folderList);
            }
            folderList.setPadding(folderList.getPaddingStart(), folderList.getPaddingTop(), folderList.getPaddingEnd(), applicationContext.getResources().getDimensionPixelSize(C8003R.dimen.folder_recyclerview_padding_bottom) + dimensionPixelSize);
            widgetInsetUtils.applyWindowInsetsToGoToTop(floatingBottomLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyWindowInsetsForFolderList$lambda$11(Window window, View view, RecyclerView recyclerView, AppBarLayout appBarLayout, FloatingToolbarLayout floatingToolbarLayout, FloatingBottomLayout floatingBottomLayout, WindowInsetsCompat it) throws Exception {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.m8702i(TAG, "applyWindowInsetsForFolderList, requestAndGet");
        applyWindowInsetsForFolderList(window, view, recyclerView, appBarLayout, floatingToolbarLayout, floatingBottomLayout);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void applyWindowInsetsForImportList(@Nullable final Window window, @Nullable final View container, @Nullable final RecyclerView importList, @Nullable final AppBarLayout appBarLayout, @Nullable final FloatingToolbarLayout floatingToolbarLayout) throws Exception {
        View decorView;
        if (getCanUseWindowInsets()) {
            WindowInsetsManager.Companion companion = WindowInsetsManager.INSTANCE;
            if (companion.getInstance().hasInvalidWindowInset()) {
                companion.getInstance().requestAndGetInsets(container, new Function1() { // from class: com.samsung.android.support.senl.nt.app.common.util.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WidgetInsetUtils.applyWindowInsetsForImportList$lambda$6(window, container, importList, appBarLayout, floatingToolbarLayout, (WindowInsetsCompat) obj);
                    }
                });
                return;
            }
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext == null || window == null || (decorView = window.getDecorView()) == null) {
                return;
            }
            int multiWindowMode = WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(decorView.getResources().getConfiguration());
            int iCoerceAtLeast = 0;
            boolean z = true;
            boolean z2 = multiWindowMode == 0;
            boolean z3 = multiWindowMode == 2;
            int[] iArr = new int[2];
            decorView.getLocationOnScreen(iArr);
            int iHeight = DisplayUtils.getScreenSize(applicationContext).height() / 2;
            boolean z4 = z2 || (z3 && iArr[1] <= iHeight);
            if (!z2 && (!z3 || iArr[1] <= iHeight)) {
                z = false;
            }
            boolean zIsRTLMode = LocaleUtils.isRTLMode();
            Insets systemBarInsets = companion.getInstance().getSystemBarInsets();
            Insets displayCutoutInsets = companion.getInstance().getDisplayCutoutInsets();
            int iCoerceAtLeast2 = z4 ? RangesKt.coerceAtLeast(systemBarInsets.top, displayCutoutInsets.top) : 0;
            if (z || (FoldStateCompat.INSTANCE.getInstance().isFoldableDevice() && DisplayDeviceTypeCompat.INSTANCE.getInstance().isSubDisplay(decorView.getResources().getConfiguration()))) {
                iCoerceAtLeast = RangesKt.coerceAtLeast(systemBarInsets.bottom, displayCutoutInsets.bottom);
            }
            StringBuilder sbM2230u = AbstractC2821a.m2230u("applyWindowInsetsForImportList, isFullScreen:", ", isRTLMode:", ", insetsTop:", z2, zIsRTLMode);
            AbstractC2821a.m2235z(sbM2230u, iCoerceAtLeast2, iCoerceAtLeast, ", insetsBottom:", ", windowMode:");
            AbstractC8014b.m7212n(sbM2230u, TAG, multiWindowMode);
            INSTANCE.applyWindowInsetsToContainer(window, container);
            if (floatingToolbarLayout != null) {
                if (appBarLayout != null) {
                    appBarLayout.seslSetCollapsedHeight(appBarLayout.seslGetDefaultCollapsedHeight() + iCoerceAtLeast2);
                }
                if (appBarLayout != null) {
                    appBarLayout.seslSetProportionExtraHeight(iCoerceAtLeast2);
                }
                floatingToolbarLayout.setWindowBottomInset(iCoerceAtLeast);
                floatingToolbarLayout.setPaddingRelative(floatingToolbarLayout.getPaddingStart(), iCoerceAtLeast2, floatingToolbarLayout.getPaddingEnd(), floatingToolbarLayout.getPaddingBottom());
            }
            if (importList != null) {
                if (floatingToolbarLayout != null) {
                    floatingToolbarLayout.setRecyclerView(importList);
                }
                importList.setPaddingRelative(importList.getPaddingStart(), importList.getPaddingTop(), importList.getPaddingEnd(), iCoerceAtLeast);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyWindowInsetsForImportList$lambda$6(Window window, View view, RecyclerView recyclerView, AppBarLayout appBarLayout, FloatingToolbarLayout floatingToolbarLayout, WindowInsetsCompat it) throws Exception {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.m8702i(TAG, "applyWindowInsetsForImportList, requestAndGet");
        applyWindowInsetsForImportList(window, view, recyclerView, appBarLayout, floatingToolbarLayout);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void applyWindowInsetsForList(@Nullable final Window window, @Nullable final View container, @NotNull final RecyclerView recyclerView, @Nullable final View drawerView, @Nullable final AppBarLayout appBarLayout, @Nullable final View noteFab, @Nullable final View noteFakeFab, @Nullable final FloatingToolbarLayout floatingToolbarLayout, @Nullable final FloatingBottomLayout floatingBottomLayout) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (getCanUseWindowInsets()) {
            WindowInsetsManager.Companion companion = WindowInsetsManager.INSTANCE;
            if (companion.getInstance().hasInvalidWindowInset()) {
                companion.getInstance().requestAndGetInsets(container, new Function1() { // from class: com.samsung.android.support.senl.nt.app.common.util.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WidgetInsetUtils.applyWindowInsetsForList$lambda$0(window, container, recyclerView, drawerView, appBarLayout, noteFab, noteFakeFab, floatingToolbarLayout, floatingBottomLayout, (WindowInsetsCompat) obj);
                    }
                });
                return;
            }
            WidgetInsetUtils widgetInsetUtils = INSTANCE;
            widgetInsetUtils.calculateInsets(window, recyclerView);
            widgetInsetUtils.applyWindowInsetsToContainer(window, container);
            widgetInsetUtils.applyWindowInsetsToToolbarLayout(recyclerView, appBarLayout, floatingToolbarLayout);
            widgetInsetUtils.applyWindowInsetsToBottomContainer(recyclerView, floatingBottomLayout);
            widgetInsetUtils.applyWindowInsetsToGoToTop(floatingBottomLayout);
            applyWindowInsetsToNoteFab(window, noteFab, noteFakeFab);
            applyWindowInsetsToDrawer(window, drawerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyWindowInsetsForList$lambda$0(Window window, View view, RecyclerView recyclerView, View view2, AppBarLayout appBarLayout, View view3, View view4, FloatingToolbarLayout floatingToolbarLayout, FloatingBottomLayout floatingBottomLayout, WindowInsetsCompat it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.m8702i(TAG, "applyWindowInsetsForList, requestNGet");
        applyWindowInsetsForList(window, view, recyclerView, view2, appBarLayout, view3, view4, floatingToolbarLayout, floatingBottomLayout);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void applyWindowInsetsForMs(@Nullable Window window, @Nullable View container) {
        View decorView;
        if (getCanUseWindowInsets()) {
            WindowInsetsManager.Companion companion = WindowInsetsManager.INSTANCE;
            if (companion.getInstance().hasInvalidWindowInset()) {
                companion.getInstance().requestAndGetInsets(container, new C4201a(window, container, 2));
                return;
            }
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext == null || window == null || (decorView = window.getDecorView()) == null) {
                return;
            }
            int multiWindowMode = WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(decorView.getResources().getConfiguration());
            int iCoerceAtLeast = 0;
            boolean z = true;
            boolean z2 = multiWindowMode == 0;
            boolean z3 = multiWindowMode == 2;
            int[] iArr = new int[2];
            decorView.getLocationOnScreen(iArr);
            int iHeight = DisplayUtils.getScreenSize(applicationContext).height() / 2;
            boolean z4 = z2 || (z3 && iArr[1] <= iHeight);
            if (!z2 && (!z3 || iArr[1] <= iHeight)) {
                z = false;
            }
            boolean zIsRTLMode = LocaleUtils.isRTLMode();
            Insets systemBarInsets = companion.getInstance().getSystemBarInsets();
            Insets displayCutoutInsets = companion.getInstance().getDisplayCutoutInsets();
            int iCoerceAtLeast2 = z4 ? RangesKt.coerceAtLeast(systemBarInsets.top, displayCutoutInsets.top) : 0;
            if (z || (FoldStateCompat.INSTANCE.getInstance().isFoldableDevice() && DisplayDeviceTypeCompat.INSTANCE.getInstance().isSubDisplay(decorView.getResources().getConfiguration()))) {
                iCoerceAtLeast = RangesKt.coerceAtLeast(systemBarInsets.bottom, displayCutoutInsets.bottom);
            }
            StringBuilder sbM2230u = AbstractC2821a.m2230u("applyWindowInsetsForMs, isFullScreen:", ", isRTLMode:", ", insetsTop:", z2, zIsRTLMode);
            AbstractC2821a.m2235z(sbM2230u, iCoerceAtLeast2, iCoerceAtLeast, ", insetsBottom:", ", windowMode:");
            AbstractC8014b.m7212n(sbM2230u, TAG, multiWindowMode);
            INSTANCE.applyWindowInsetsToContainer(window, container);
            if (container != null) {
                container.setPaddingRelative(container.getPaddingStart(), container.getPaddingTop(), container.getPaddingEnd(), iCoerceAtLeast);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyWindowInsetsForMs$lambda$9(Window window, View view, WindowInsetsCompat it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.m8702i(TAG, "applyWindowInsetsForMs, requestAndGet");
        applyWindowInsetsForMs(window, view);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void applyWindowInsetsForSetting(@Nullable Window window, @Nullable View container, @Nullable ViewGroup settingContents, @Nullable AppBarLayout appBarLayout, @Nullable FloatingToolbarLayout floatingToolbarLayout, @Nullable FloatingBottomLayout floatingBottomLayout) {
        View decorView;
        if (getCanUseWindowInsets()) {
            WindowInsetsManager.Companion companion = WindowInsetsManager.INSTANCE;
            if (companion.getInstance().hasInvalidWindowInset()) {
                companion.getInstance().requestAndGetInsets(container, new C8038a(window, container, settingContents, appBarLayout, floatingToolbarLayout, floatingBottomLayout, 1));
                return;
            }
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext == null || window == null || (decorView = window.getDecorView()) == null) {
                return;
            }
            int multiWindowMode = WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(decorView.getResources().getConfiguration());
            boolean z = true;
            boolean z2 = multiWindowMode == 0;
            boolean z3 = multiWindowMode == 2;
            int[] iArr = new int[2];
            decorView.getLocationOnScreen(iArr);
            int iHeight = DisplayUtils.getScreenSize(applicationContext).height() / 2;
            boolean z4 = z2 || (z3 && iArr[1] <= iHeight);
            if (!z2 && (!z3 || iArr[1] <= iHeight)) {
                z = false;
            }
            boolean zIsRTLMode = LocaleUtils.isRTLMode();
            Insets systemBarInsets = companion.getInstance().getSystemBarInsets();
            Insets displayCutoutInsets = companion.getInstance().getDisplayCutoutInsets();
            int iCoerceAtLeast = z4 ? RangesKt.coerceAtLeast(systemBarInsets.top, displayCutoutInsets.top) : 0;
            int iCoerceAtLeast2 = (z || (FoldStateCompat.INSTANCE.getInstance().isFoldableDevice() && DisplayDeviceTypeCompat.INSTANCE.getInstance().isSubDisplay(decorView.getResources().getConfiguration()))) ? RangesKt.coerceAtLeast(systemBarInsets.bottom, displayCutoutInsets.bottom) : 0;
            settingInsetsBottom = iCoerceAtLeast2;
            int dimensionPixelSize = applicationContext.getResources().getDimensionPixelSize(C8003R.dimen.notes_list_floating_bottom_padding) + iCoerceAtLeast2;
            settingInsetsBottom = dimensionPixelSize;
            StringBuilder sbM2230u = AbstractC2821a.m2230u("applyWindowInsetsForSetting, isFullScreen:", ", isRTLMode:", ", insetsTop:", z2, zIsRTLMode);
            AbstractC2821a.m2235z(sbM2230u, iCoerceAtLeast, dimensionPixelSize, ", insetsBottom:", ", windowMode:");
            AbstractC8014b.m7212n(sbM2230u, TAG, multiWindowMode);
            INSTANCE.applyWindowInsetsToContainer(window, container);
            if (floatingToolbarLayout != null) {
                if (appBarLayout != null) {
                    appBarLayout.seslSetCollapsedHeight(appBarLayout.seslGetDefaultCollapsedHeight() + iCoerceAtLeast);
                }
                if (appBarLayout != null) {
                    appBarLayout.seslSetProportionExtraHeight(iCoerceAtLeast);
                }
                floatingToolbarLayout.setWindowBottomInset(settingInsetsBottom);
                floatingToolbarLayout.setPaddingRelative(floatingToolbarLayout.getPaddingStart(), iCoerceAtLeast, floatingToolbarLayout.getPaddingEnd(), floatingToolbarLayout.getPaddingBottom());
            }
            if (floatingBottomLayout != null) {
                floatingBottomLayout.setPaddingRelative(floatingBottomLayout.getPaddingStart(), floatingBottomLayout.getPaddingTop(), floatingBottomLayout.getPaddingEnd(), settingInsetsBottom);
            }
            if (settingContents instanceof RecyclerView) {
                if (floatingToolbarLayout != null) {
                    floatingToolbarLayout.setRecyclerView((RecyclerView) settingContents);
                }
                if (floatingBottomLayout != null) {
                    floatingBottomLayout.setRecyclerView((RecyclerView) settingContents);
                    return;
                }
                return;
            }
            if (!(settingContents instanceof NestedScrollView)) {
                if (floatingBottomLayout != null) {
                    floatingBottomLayout.post(new RunnableC4199v(settingContents, floatingBottomLayout, 17));
                }
            } else {
                if (floatingToolbarLayout != null) {
                    floatingToolbarLayout.setNestedScrollView((NestedScrollView) settingContents);
                }
                if (floatingBottomLayout != null) {
                    floatingBottomLayout.setNestedScrollView((NestedScrollView) settingContents);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyWindowInsetsForSetting$lambda$2(Window window, View view, ViewGroup viewGroup, AppBarLayout appBarLayout, FloatingToolbarLayout floatingToolbarLayout, FloatingBottomLayout floatingBottomLayout, WindowInsetsCompat it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.m8702i(TAG, "applyWindowInsetsForSetting, requestAndGet");
        applyWindowInsetsForSetting(window, view, viewGroup, appBarLayout, floatingToolbarLayout, floatingBottomLayout);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyWindowInsetsForSetting$lambda$5(ViewGroup viewGroup, FloatingBottomLayout floatingBottomLayout) {
        if (viewGroup != null) {
            viewGroup.setPaddingRelative(viewGroup.getPaddingStart(), viewGroup.getPaddingTop(), viewGroup.getPaddingEnd(), floatingBottomLayout.getMeasuredHeight());
        }
    }

    private final void applyWindowInsetsToBottomContainer(RecyclerView recyclerView, FloatingBottomLayout floatingBottomLayout) throws Exception {
        if (getCanUseWindowInsets()) {
            if (floatingBottomLayout != null) {
                floatingBottomLayout.setPaddingRelative(floatingBottomLayout.getPaddingStart(), 0, floatingBottomLayout.getPaddingEnd(), insetsBottom);
            }
            if (floatingBottomLayout != null) {
                floatingBottomLayout.setRecyclerView(recyclerView);
            }
        }
    }

    private final void applyWindowInsetsToContainer(Window window, View container) {
        View decorView;
        Resources resources;
        Configuration configuration;
        if (!getCanUseWindowInsets() || container == null) {
            return;
        }
        boolean zIsRTLMode = LocaleUtils.isRTLMode();
        int multiWindowMode = WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(container.getResources().getConfiguration());
        boolean z = multiWindowMode == 0;
        WindowInsetsManager.Companion companion = WindowInsetsManager.INSTANCE;
        Insets systemBarInsets = companion.getInstance().getSystemBarInsets();
        Insets displayCutoutInsets = companion.getInstance().getDisplayCutoutInsets();
        boolean z2 = (window == null || (decorView = window.getDecorView()) == null || (resources = decorView.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2 || multiWindowMode != 2) ? false : true;
        int iCoerceAtLeast = (z || z2) ? RangesKt.coerceAtLeast(systemBarInsets.left, displayCutoutInsets.left) : 0;
        int iCoerceAtLeast2 = (z || z2) ? RangesKt.coerceAtLeast(systemBarInsets.right, displayCutoutInsets.right) : 0;
        int i = zIsRTLMode ? iCoerceAtLeast2 : iCoerceAtLeast;
        if (!zIsRTLMode) {
            iCoerceAtLeast = iCoerceAtLeast2;
        }
        container.setPaddingRelative(i, container.getPaddingTop(), iCoerceAtLeast, container.getPaddingBottom());
    }

    @JvmStatic
    public static final void applyWindowInsetsToDrawer(@Nullable Window window, @Nullable View drawerView) {
        if (window == null || !getCanUseWindowInsets() || drawerView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = drawerView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        INSTANCE.applyWindowInsetsToDrawer(window, marginLayoutParams, new RunnableC4199v(drawerView, marginLayoutParams, 16));
    }

    public static /* synthetic */ void applyWindowInsetsToDrawer$default(Activity activity, ViewGroup.MarginLayoutParams marginLayoutParams, Runnable runnable, int i, Object obj) {
        if ((i & 4) != 0) {
            runnable = null;
        }
        applyWindowInsetsToDrawer(activity, marginLayoutParams, runnable);
    }

    private final void applyWindowInsetsToGoToTop(FloatingBottomLayout floatingBottomLayout) {
        if (getCanUseWindowInsets()) {
            boolean z = false;
            if (floatingBottomLayout != null && floatingBottomLayout.getVisibility() == 0) {
                z = true;
            }
            ViewModeUtils.updateGoToTopButtonPosition(floatingBottomLayout, z);
        }
    }

    @JvmStatic
    public static final void applyWindowInsetsToNoteFab(@Nullable Window window, @Nullable View noteFab, @Nullable View noteFakeFab) {
        if (window == null || noteFab == null) {
            return;
        }
        WindowInsetsManager.Companion companion = WindowInsetsManager.INSTANCE;
        if (companion.getInstance().hasInvalidWindowInset()) {
            Logger.m8702i(TAG, "applyWindowInsetsToNoteFab, requestAndGet");
            companion.getInstance().requestAndGetInsets(noteFab, new C7857i(window, 2, noteFab, noteFakeFab));
            return;
        }
        float dimension = noteFab.getResources().getDimension(C8003R.dimen.noteslist_fab_layout_marin_start_end);
        float dimension2 = noteFab.getResources().getDimension(C8003R.dimen.noteslist_fab_layout_marin_top_bottom);
        if (getCanUseWindowInsets()) {
            dimension2 += WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(noteFab.getResources().getConfiguration()) == 0 ? RangesKt.coerceAtLeast(companion.getInstance().getSystemBarInsets().bottom, companion.getInstance().getDisplayCutoutInsets().bottom) : 0;
        }
        ViewGroup.LayoutParams layoutParams = noteFab.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            return;
        }
        int i = (int) dimension2;
        marginLayoutParams.bottomMargin = i;
        if (LocaleUtils.isRTLMode()) {
            marginLayoutParams.leftMargin = (int) dimension;
        } else {
            marginLayoutParams.rightMargin = (int) dimension;
        }
        noteFab.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams2 = noteFakeFab != null ? noteFakeFab.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        if (marginLayoutParams2 == null) {
            return;
        }
        marginLayoutParams2.bottomMargin = i;
        if (LocaleUtils.isRTLMode()) {
            marginLayoutParams2.leftMargin = (int) dimension;
        } else {
            marginLayoutParams2.rightMargin = (int) dimension;
        }
        noteFakeFab.setLayoutParams(marginLayoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyWindowInsetsToNoteFab$lambda$17(Window window, View view, View view2, WindowInsetsCompat it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.m8702i(TAG, "applyWindowInsetsToNoteFab, requestAndGet onReady");
        applyWindowInsetsToNoteFab(window, view, view2);
        return Unit.INSTANCE;
    }

    private final void applyWindowInsetsToToolbarLayout(RecyclerView recyclerView, AppBarLayout appBarLayout, FloatingToolbarLayout floatingToolbarLayout) throws Exception {
        if (getCanUseWindowInsets()) {
            if (appBarLayout != null) {
                appBarLayout.seslSetCollapsedHeight(appBarLayout.seslGetDefaultCollapsedHeight() + insetsTop);
            }
            if (appBarLayout != null) {
                appBarLayout.seslSetProportionExtraHeight(insetsTop);
            }
            if (floatingToolbarLayout != null) {
                floatingToolbarLayout.setPaddingRelative(floatingToolbarLayout.getPaddingStart(), insetsTop, floatingToolbarLayout.getPaddingEnd(), floatingToolbarLayout.getPaddingBottom());
            }
            if (floatingToolbarLayout != null) {
                floatingToolbarLayout.setRecyclerView(recyclerView);
            }
        }
    }

    private final void calculateInsets(Window window, View itemListView) {
        View decorView;
        View decorView2;
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        int multiWindowMode = WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(itemListView.getResources().getConfiguration());
        int iCoerceAtLeast = 0;
        boolean z = true;
        boolean z2 = multiWindowMode == 0;
        int[] iArr = new int[2];
        if (window != null && (decorView2 = window.getDecorView()) != null) {
            decorView2.getLocationOnScreen(iArr);
        }
        int iHeight = DisplayUtils.getScreenSize(applicationContext).height() / 2;
        Integer numValueOf = (window == null || (decorView = window.getDecorView()) == null) ? null : Integer.valueOf(iArr[1] + decorView.getHeight());
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(iArr[1]);
        }
        boolean z3 = z2 || (multiWindowMode == 2 && iArr[1] <= iHeight);
        if (!z2 && (multiWindowMode != 2 || numValueOf.intValue() <= ((double) iHeight) * 0.95d)) {
            z = false;
        }
        boolean zIsRTLMode = LocaleUtils.isRTLMode();
        WindowInsetsManager.Companion companion = WindowInsetsManager.INSTANCE;
        Insets systemBarInsets = companion.getInstance().getSystemBarInsets();
        Insets displayCutoutInsets = companion.getInstance().getDisplayCutoutInsets();
        Insets captionBarInsets = companion.getInstance().getCaptionBarInsets();
        insetsTop = z3 ? RangesKt.coerceAtLeast(systemBarInsets.top, displayCutoutInsets.top) : 0;
        if (z || (FoldStateCompat.INSTANCE.getInstance().isFoldableDevice() && DisplayDeviceTypeCompat.INSTANCE.getInstance().isSubDisplay(itemListView.getResources().getConfiguration()))) {
            iCoerceAtLeast = RangesKt.coerceAtLeast(systemBarInsets.bottom, displayCutoutInsets.bottom);
        }
        insetsBottom = iCoerceAtLeast;
        int dimensionPixelSize = applicationContext.getResources().getDimensionPixelSize(C8003R.dimen.notes_list_floating_bottom_padding) + iCoerceAtLeast;
        insetsBottom = dimensionPixelSize;
        if (z2) {
            if (zIsRTLMode) {
                insetsStart = systemBarInsets.right;
                insetsEnd = systemBarInsets.left;
            } else {
                insetsStart = systemBarInsets.left;
                insetsEnd = systemBarInsets.right;
            }
        } else if (zIsRTLMode) {
            insetsStart = captionBarInsets.right;
            insetsEnd = captionBarInsets.left;
        } else {
            insetsStart = captionBarInsets.left;
            insetsEnd = captionBarInsets.right;
        }
        int i = insetsTop;
        int i2 = insetsStart;
        int i4 = insetsEnd;
        StringBuilder sbM2230u = AbstractC2821a.m2230u("applyWindowInsetsForList, isFullScreen:", ", isRTLMode:", ", insetsTop:", z2, zIsRTLMode);
        AbstractC2821a.m2235z(sbM2230u, i, dimensionPixelSize, ", insetsBottom:", ", insetsStart:");
        AbstractC2821a.m2235z(sbM2230u, i2, i4, ", insetsEnd:", ", windowMode:");
        AbstractC8014b.m7212n(sbM2230u, TAG, multiWindowMode);
    }

    @ChecksSdkIntAtLeast(api = 35)
    public static final boolean getCanUseWindowInsets() {
        return Build.VERSION.SDK_INT > 34;
    }

    @JvmStatic
    public static /* synthetic */ void getCanUseWindowInsets$annotations() {
    }

    @JvmStatic
    public static final int getTopBottomInsets() {
        return insetsTop + insetsBottom;
    }

    public final int getSettingInsetsBottom() {
        return settingInsetsBottom;
    }

    public final void setSettingInsetsBottom(int i) {
        settingInsetsBottom = i;
    }

    public static /* synthetic */ void applyWindowInsetsToDrawer$default(WidgetInsetUtils widgetInsetUtils, Window window, ViewGroup.MarginLayoutParams marginLayoutParams, Runnable runnable, int i, Object obj) {
        if ((i & 4) != 0) {
            runnable = null;
        }
        widgetInsetUtils.applyWindowInsetsToDrawer(window, marginLayoutParams, runnable);
    }

    @JvmStatic
    public static final void applyWindowInsetsToDrawer(@Nullable Activity activity, @Nullable ViewGroup.MarginLayoutParams params, @Nullable Runnable endAction) {
        if (!getCanUseWindowInsets() || activity == null || params == null || CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        WidgetInsetUtils widgetInsetUtils = INSTANCE;
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        widgetInsetUtils.applyWindowInsetsToDrawer(window, params, endAction);
    }

    private final void applyWindowInsetsToDrawer(Window window, ViewGroup.MarginLayoutParams params, Runnable endAction) {
        if (getCanUseWindowInsets()) {
            int multiWindowMode = WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(window.getDecorView().getResources().getConfiguration());
            boolean z = true;
            boolean z2 = multiWindowMode == 0;
            if (!z2 && multiWindowMode != 2) {
                z = false;
            }
            boolean zIsRTLMode = LocaleUtils.isRTLMode();
            WindowInsetsManager.Companion companion = WindowInsetsManager.INSTANCE;
            Insets systemBarInsets = companion.getInstance().getSystemBarInsets();
            Insets displayCutoutInsets = companion.getInstance().getDisplayCutoutInsets();
            drawerInsetsTop = z ? RangesKt.coerceAtLeast(systemBarInsets.top, displayCutoutInsets.top) : 0;
            int iCoerceAtLeast = z2 ? RangesKt.coerceAtLeast(systemBarInsets.bottom, displayCutoutInsets.bottom) : 0;
            drawerInsetsBottom = iCoerceAtLeast;
            int i = drawerInsetsTop;
            StringBuilder sb = new StringBuilder("applyWindowInsetsToDrawer, isRTLMode:");
            sb.append(zIsRTLMode);
            sb.append(", drawerInsetsTop:");
            sb.append(i);
            sb.append(", drawerInsetsBottom:");
            AbstractC8014b.m7212n(sb, TAG, iCoerceAtLeast);
            if (params != null) {
                params.topMargin = drawerInsetsTop;
            }
            if (params != null) {
                params.bottomMargin = drawerInsetsBottom;
            }
        }
    }
}
