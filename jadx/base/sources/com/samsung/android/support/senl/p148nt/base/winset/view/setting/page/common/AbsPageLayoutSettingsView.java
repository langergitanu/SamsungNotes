package com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common;

import android.animation.StateListAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.winset.view.common.ImageRadioButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\b\u0010 \u001a\u00020\u001fH\u0016J\u0006\u0010!\u001a\u00020\u001fJ\b\u0010\"\u001a\u00020#H&J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0002R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/setting/page/common/AbsPageLayoutSettingsView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mNormalRadioButton", "Lcom/samsung/android/support/senl/nt/base/winset/view/common/ImageRadioButton;", "getMNormalRadioButton", "()Lcom/samsung/android/support/senl/nt/base/winset/view/common/ImageRadioButton;", "setMNormalRadioButton", "(Lcom/samsung/android/support/senl/nt/base/winset/view/common/ImageRadioButton;)V", "mLandscapeRadioButton", "getMLandscapeRadioButton", "setMLandscapeRadioButton", "mLongRadioButton", "getMLongRadioButton", "setMLongRadioButton", "mLayoutContainer", "Landroid/widget/LinearLayout;", "getMLayoutContainer", "()Landroid/widget/LinearLayout;", "setMLayoutContainer", "(Landroid/widget/LinearLayout;)V", "init", "", "initLayout", "updatePageSize", "isA4LandscapeSupported", "", "setRecoilStateListAnimator", "view", "Landroid/view/View;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsPageLayoutSettingsView extends FrameLayout {

    @Nullable
    private ImageRadioButton mLandscapeRadioButton;

    @Nullable
    private LinearLayout mLayoutContainer;

    @Nullable
    private ImageRadioButton mLongRadioButton;

    @Nullable
    private ImageRadioButton mNormalRadioButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPageLayoutSettingsView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    private final void setRecoilStateListAnimator(View view) {
        ViewCompat companion = ViewCompat.INSTANCE.getInstance();
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        StateListAnimator recoilStateListAnimator = companion.getRecoilStateListAnimator(context, 0);
        if (recoilStateListAnimator != null) {
            view.setStateListAnimator(recoilStateListAnimator);
        }
    }

    @Nullable
    public final ImageRadioButton getMLandscapeRadioButton() {
        return this.mLandscapeRadioButton;
    }

    @Nullable
    public final LinearLayout getMLayoutContainer() {
        return this.mLayoutContainer;
    }

    @Nullable
    public final ImageRadioButton getMLongRadioButton() {
        return this.mLongRadioButton;
    }

    @Nullable
    public final ImageRadioButton getMNormalRadioButton() {
        return this.mNormalRadioButton;
    }

    public final void init(@Nullable Context context) {
        LayoutInflater.from(context).inflate(C8875R.layout.page_layout_settings_view, (ViewGroup) this, true);
        initLayout();
        updatePageSize();
    }

    public void initLayout() {
        ImageRadioButton imageRadioButton = (ImageRadioButton) findViewById(C8875R.id.normal_radio_button);
        if (imageRadioButton == null) {
            return;
        }
        this.mNormalRadioButton = imageRadioButton;
        ImageRadioButton imageRadioButton2 = (ImageRadioButton) findViewById(C8875R.id.long_radio_button);
        if (imageRadioButton2 == null) {
            return;
        }
        this.mLongRadioButton = imageRadioButton2;
        ImageRadioButton imageRadioButton3 = (ImageRadioButton) findViewById(C8875R.id.landscape_radio_button);
        if (imageRadioButton3 == null) {
            return;
        }
        this.mLandscapeRadioButton = imageRadioButton3;
        if (isA4LandscapeSupported()) {
            ImageRadioButton imageRadioButton4 = this.mLandscapeRadioButton;
            Intrinsics.checkNotNull(imageRadioButton4);
            imageRadioButton4.setVisibility(0);
        } else {
            ImageRadioButton imageRadioButton5 = this.mLandscapeRadioButton;
            Intrinsics.checkNotNull(imageRadioButton5);
            imageRadioButton5.setVisibility(8);
        }
        ImageRadioButton imageRadioButton6 = this.mNormalRadioButton;
        Intrinsics.checkNotNull(imageRadioButton6);
        imageRadioButton6.setImageResource(C8875R.drawable.ic_page_layout_setting_ratio_portrait);
        ImageRadioButton imageRadioButton7 = this.mLandscapeRadioButton;
        Intrinsics.checkNotNull(imageRadioButton7);
        imageRadioButton7.setImageResource(C8875R.drawable.ic_page_layout_setting_ratio_landscape);
        ImageRadioButton imageRadioButton8 = this.mLongRadioButton;
        Intrinsics.checkNotNull(imageRadioButton8);
        imageRadioButton8.setImageResource(C8875R.drawable.ic_page_layout_setting_ratio_long);
        this.mLayoutContainer = (LinearLayout) findViewById(C8875R.id.layout_settings_layout_container);
    }

    public abstract boolean isA4LandscapeSupported();

    public final void setMLandscapeRadioButton(@Nullable ImageRadioButton imageRadioButton) {
        this.mLandscapeRadioButton = imageRadioButton;
    }

    public final void setMLayoutContainer(@Nullable LinearLayout linearLayout) {
        this.mLayoutContainer = linearLayout;
    }

    public final void setMLongRadioButton(@Nullable ImageRadioButton imageRadioButton) {
        this.mLongRadioButton = imageRadioButton;
    }

    public final void setMNormalRadioButton(@Nullable ImageRadioButton imageRadioButton) {
        this.mNormalRadioButton = imageRadioButton;
    }

    public final void updatePageSize() {
        if (this.mNormalRadioButton == null || this.mLongRadioButton == null || this.mLandscapeRadioButton == null) {
            return;
        }
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        int i = companion.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_SIZE, 0);
        if (!isA4LandscapeSupported() && 2 == i) {
            companion.getInstance("Settings").putInt(SettingsConstants.SETTINGS_PAGE_SIZE, 0);
            i = 0;
        }
        ImageRadioButton imageRadioButton = this.mNormalRadioButton;
        Intrinsics.checkNotNull(imageRadioButton);
        imageRadioButton.setChecked(i == 0);
        ImageRadioButton imageRadioButton2 = this.mLongRadioButton;
        Intrinsics.checkNotNull(imageRadioButton2);
        imageRadioButton2.setChecked(1 == i);
        ImageRadioButton imageRadioButton3 = this.mLandscapeRadioButton;
        Intrinsics.checkNotNull(imageRadioButton3);
        imageRadioButton3.setChecked(2 == i);
        ImageRadioButton imageRadioButton4 = this.mNormalRadioButton;
        Intrinsics.checkNotNull(imageRadioButton4);
        setRecoilStateListAnimator(imageRadioButton4);
        ImageRadioButton imageRadioButton5 = this.mLongRadioButton;
        Intrinsics.checkNotNull(imageRadioButton5);
        setRecoilStateListAnimator(imageRadioButton5);
        ImageRadioButton imageRadioButton6 = this.mLandscapeRadioButton;
        Intrinsics.checkNotNull(imageRadioButton6);
        setRecoilStateListAnimator(imageRadioButton6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPageLayoutSettingsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPageLayoutSettingsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }
}
