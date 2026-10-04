package com.samsung.android.support.senl.p148nt.base.winset.view.toolbar;

import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.annotation.GravityInt;
import androidx.annotation.StringRes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0003'()J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\u001a\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\u0012H&J\u001a\u0010\u001c\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\u0012H&J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&J\u0012\u0010 \u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010!H&J\u0012\u0010\"\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010#H&J\u0012\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\nH&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&R\u0012\u0010\r\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/ICustomToolbar;", "", "setTitle", "", "resId", "", "title", "", "addCustomView", "view", "Landroid/view/View;", "horizontalGravity", "removeCustomView", "customViewWidth", "getCustomViewWidth", "()I", "setDisplayHomeAsUpEnabled", "enabled", "", "getVisibility", "setVisibility", "visibility", "setVisibilityAsResult", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/ICustomToolbar$TitleCallback;", "showToolbar", "contentView", "animate", "hideToolbar", "setAnimationListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/animation/AnimatorListenerAdapter;", "setVisibilityChangedListener", "Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/ICustomToolbar$VisibilityChangedListener;", "setToolbarHeightChangedListener", "Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/ICustomToolbar$ToolbarHeightChangedListener;", "setTitleBottomView", "titleBottomView", "setNaviUpEnabled", "TitleCallback", "VisibilityChangedListener", "ToolbarHeightChangedListener", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ICustomToolbar {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/ICustomToolbar$TitleCallback;", "", "updateDone", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface TitleCallback {
        void updateDone();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/ICustomToolbar$ToolbarHeightChangedListener;", "", "defaultToolbarHeight", "", "getDefaultToolbarHeight", "()I", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ToolbarHeightChangedListener {
        int getDefaultToolbarHeight();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&R\u0012\u0010\b\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/ICustomToolbar$VisibilityChangedListener;", "", "onVisibilityChanged", "", "visibility", "", "isShowing", "", "isRecording", "()Z", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface VisibilityChangedListener {
        boolean isRecording();

        void onVisibilityChanged(int visibility, boolean isShowing);
    }

    void addCustomView(@NotNull View view, @GravityInt int horizontalGravity);

    int getCustomViewWidth();

    int getVisibility();

    void hideToolbar(@Nullable View contentView, boolean animate);

    void removeCustomView(@NotNull View view);

    void setAnimationListener(@Nullable AnimatorListenerAdapter listener);

    void setDisplayHomeAsUpEnabled(boolean enabled);

    void setNaviUpEnabled(boolean enabled);

    void setTitle(@StringRes int resId);

    void setTitle(@NotNull CharSequence title);

    void setTitle(@NotNull CharSequence title, @Nullable TitleCallback callback);

    void setTitleBottomView(@Nullable View titleBottomView);

    void setToolbarHeightChangedListener(@Nullable ToolbarHeightChangedListener listener);

    void setVisibility(int visibility);

    void setVisibilityAsResult(int visibility);

    void setVisibilityChangedListener(@Nullable VisibilityChangedListener listener);

    void showToolbar(@Nullable View contentView, boolean animate);
}
