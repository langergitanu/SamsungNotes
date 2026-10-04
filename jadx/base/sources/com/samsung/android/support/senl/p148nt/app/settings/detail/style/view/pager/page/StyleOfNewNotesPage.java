package com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.framework.sem.widget.NestedScrollViewCustom;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u00014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\"\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u000fH&J\u0012\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J+\u0010'\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010+\u001a\u00020,H\u0016¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u000bH\u0016J\b\u00102\u001a\u00020\u000bH\u0002J\b\u00103\u001a\u00020*H&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u00065"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/page/StyleOfNewNotesPage;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "contract", "Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/page/StyleOfNewNotesPage$Contract;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/page/StyleOfNewNotesPage$Contract;)V", "getContract", "()Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/page/StyleOfNewNotesPage$Contract;", "value", "", "isIsInitialized", "()Z", "inflateLayout", "", "onConfigurationChanged", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "Landroid/os/Bundle;", "onViewStateRestored", "savedInstanceState", "initialize", "fragment", "Landroidx/fragment/app/Fragment;", "onResume", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "updateScrollStyle", "scrollView", "Lcom/samsung/android/support/senl/cm/base/framework/sem/widget/NestedScrollViewCustom;", "updateViewSpacing", "view", "Landroid/view/View;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onBackKeyDown", "isCallFromOtherApps", "getTAG", "Contract", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class StyleOfNewNotesPage extends FrameLayout {

    @NotNull
    private final Contract contract;
    private boolean isIsInitialized;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/page/StyleOfNewNotesPage$Contract;", "", "isCallFromOtherApps", "", "updateBackPressedCallBack", "", "isEnabled", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        boolean isCallFromOtherApps();

        void updateBackPressedCallBack(boolean isEnabled);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StyleOfNewNotesPage(@NotNull Context context, @NotNull Contract contract) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.contract = contract;
        inflateLayout(context);
    }

    private final boolean isCallFromOtherApps() {
        return this.contract.isCallFromOtherApps();
    }

    @NotNull
    public final Contract getContract() {
        return this.contract;
    }

    @NotNull
    public abstract String getTAG();

    public abstract void inflateLayout(@NotNull Context context);

    public void initialize(@Nullable Fragment fragment, @Nullable Bundle savedInstanceState) {
        this.isIsInitialized = true;
        updateScrollStyle();
    }

    /* JADX INFO: renamed from: isIsInitialized, reason: from getter */
    public final boolean getIsIsInitialized() {
        return this.isIsInitialized;
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    }

    public boolean onBackKeyDown() {
        return false;
    }

    public void onConfigurationChanged() {
        updateScrollStyle();
    }

    public void onDestroy() {
    }

    public boolean onOptionsItemSelected(@Nullable MenuItem item) {
        return false;
    }

    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
    }

    public void onResume() {
        updateScrollStyle();
    }

    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
    }

    public abstract void updateScrollStyle();

    public void updateScrollStyle(@Nullable NestedScrollViewCustom scrollView) {
        int spaceForFlexibleSpacing;
        if (scrollView != null) {
            if (DeviceInfo.isVSTModel()) {
                spaceForFlexibleSpacing = DisplayUtils.getStartSpaceForFlexibleSpacingForVst(scrollView.getContext(), scrollView, isCallFromOtherApps());
            } else {
                Context context = scrollView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                spaceForFlexibleSpacing = DisplayUtils.getSpaceForFlexibleSpacing(context);
            }
            Context context2 = scrollView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            if (DisplayUtils.getMinFlexibleSpacing(context2) < spaceForFlexibleSpacing) {
                scrollView.setScrollBarStyle(0);
            } else {
                scrollView.setScrollBarStyle(33554432);
            }
            scrollView.seslSetFillHorizontalPaddingEnabled(true, scrollView.getResources().getColor(C8003R.color.window_background_color, null));
            ViewCompat.Companion companion = ViewCompat.INSTANCE;
            ViewCompat companion2 = companion.getInstance();
            Pair<Integer, Integer> pairCreate = Pair.create(Integer.valueOf(scrollView.getPaddingStart()), Integer.valueOf(scrollView.getPaddingEnd()));
            Intrinsics.checkNotNullExpressionValue(pairCreate, "create(...)");
            companion2.setRoundedCorners(scrollView, 15, pairCreate);
            companion.getInstance().setRoundedCornerColor(scrollView, 15, getResources().getColor(C8003R.color.window_background_color, null));
        }
    }

    public void updateViewSpacing(@Nullable View view) {
        int spaceForFlexibleSpacing;
        int spaceForFlexibleSpacing2;
        if (view != null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            int minFlexibleSpacing = DisplayUtils.getMinFlexibleSpacing(context);
            if (DeviceInfo.isVSTModel()) {
                spaceForFlexibleSpacing = DisplayUtils.getStartSpaceForFlexibleSpacingForVst(view.getContext(), view, isCallFromOtherApps());
            } else {
                Context context2 = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                spaceForFlexibleSpacing = DisplayUtils.getSpaceForFlexibleSpacing(context2);
            }
            if (DeviceInfo.isVSTModel()) {
                spaceForFlexibleSpacing2 = DisplayUtils.getEndSpaceForFlexibleSpacingForVst(view.getContext(), view, isCallFromOtherApps());
            } else {
                Context context3 = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                spaceForFlexibleSpacing2 = DisplayUtils.getSpaceForFlexibleSpacing(context3);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (minFlexibleSpacing < spaceForFlexibleSpacing) {
                marginLayoutParams.leftMargin = spaceForFlexibleSpacing;
                marginLayoutParams.rightMargin = spaceForFlexibleSpacing2;
                view.setPadding(0, 0, 0, 0);
            } else {
                marginLayoutParams.leftMargin = spaceForFlexibleSpacing - minFlexibleSpacing;
                marginLayoutParams.rightMargin = spaceForFlexibleSpacing2 - minFlexibleSpacing;
                view.setPadding(minFlexibleSpacing, 0, minFlexibleSpacing, 0);
            }
            view.setLayoutParams(marginLayoutParams);
        }
    }
}
