package com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common;

import android.animation.StateListAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.winset.view.common.ImageRadioButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020\u001aH\u0002J\b\u0010!\u001a\u00020\"H&J\b\u0010#\u001a\u00020\"H&J\b\u0010$\u001a\u00020\"H&R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/setting/page/common/AbsPageScrollDirectionSettingsView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mVerticalRadioButton", "Lcom/samsung/android/support/senl/nt/base/winset/view/common/ImageRadioButton;", "getMVerticalRadioButton", "()Lcom/samsung/android/support/senl/nt/base/winset/view/common/ImageRadioButton;", "setMVerticalRadioButton", "(Lcom/samsung/android/support/senl/nt/base/winset/view/common/ImageRadioButton;)V", "mHorizontalRadioButton", "getMHorizontalRadioButton", "setMHorizontalRadioButton", "mTwoPageButton", "getMTwoPageButton", "setMTwoPageButton", "init", "", "initLayout", "setRecoilStateListAnimator", "view", "Landroid/view/View;", "updatePageScrollStyle", "updateTwoPageButtonVisible", "isVerticalScroll", "", "isSinglePage", "isTwoPageButtonVisible", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsPageScrollDirectionSettingsView extends FrameLayout implements View.OnClickListener {

    @Nullable
    private ImageRadioButton mHorizontalRadioButton;

    @Nullable
    private ImageRadioButton mTwoPageButton;

    @Nullable
    private ImageRadioButton mVerticalRadioButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPageScrollDirectionSettingsView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    private final void initLayout() {
        ImageRadioButton imageRadioButton = (ImageRadioButton) findViewById(C8875R.id.page_scroll_vertical_radio_button);
        if (imageRadioButton == null) {
            return;
        }
        this.mVerticalRadioButton = imageRadioButton;
        ImageRadioButton imageRadioButton2 = (ImageRadioButton) findViewById(C8875R.id.page_scroll_horizontal_radio_button);
        if (imageRadioButton2 == null) {
            return;
        }
        this.mHorizontalRadioButton = imageRadioButton2;
        ImageRadioButton imageRadioButton3 = (ImageRadioButton) findViewById(C8875R.id.page_scroll_two_page_radio_button);
        if (imageRadioButton3 == null) {
            return;
        }
        this.mTwoPageButton = imageRadioButton3;
        ImageRadioButton imageRadioButton4 = this.mVerticalRadioButton;
        Intrinsics.checkNotNull(imageRadioButton4);
        imageRadioButton4.setOnClickListener(this);
        ImageRadioButton imageRadioButton5 = this.mHorizontalRadioButton;
        Intrinsics.checkNotNull(imageRadioButton5);
        imageRadioButton5.setOnClickListener(this);
        ImageRadioButton imageRadioButton6 = this.mTwoPageButton;
        Intrinsics.checkNotNull(imageRadioButton6);
        imageRadioButton6.setOnClickListener(this);
        updateTwoPageButtonVisible();
        ImageRadioButton imageRadioButton7 = this.mVerticalRadioButton;
        Intrinsics.checkNotNull(imageRadioButton7);
        setRecoilStateListAnimator(imageRadioButton7);
        ImageRadioButton imageRadioButton8 = this.mHorizontalRadioButton;
        Intrinsics.checkNotNull(imageRadioButton8);
        setRecoilStateListAnimator(imageRadioButton8);
        ImageRadioButton imageRadioButton9 = this.mTwoPageButton;
        Intrinsics.checkNotNull(imageRadioButton9);
        setRecoilStateListAnimator(imageRadioButton9);
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

    private final void updateTwoPageButtonVisible() {
        if (isTwoPageButtonVisible()) {
            ImageRadioButton imageRadioButton = this.mTwoPageButton;
            Intrinsics.checkNotNull(imageRadioButton);
            imageRadioButton.setVisibility(0);
        } else {
            ImageRadioButton imageRadioButton2 = this.mTwoPageButton;
            Intrinsics.checkNotNull(imageRadioButton2);
            imageRadioButton2.setVisibility(8);
        }
    }

    @Nullable
    public final ImageRadioButton getMHorizontalRadioButton() {
        return this.mHorizontalRadioButton;
    }

    @Nullable
    public final ImageRadioButton getMTwoPageButton() {
        return this.mTwoPageButton;
    }

    @Nullable
    public final ImageRadioButton getMVerticalRadioButton() {
        return this.mVerticalRadioButton;
    }

    public final void init(@Nullable Context context) {
        LayoutInflater.from(context).inflate(C8875R.layout.page_scroll_direction_settings_view, (ViewGroup) this, true);
        initLayout();
        updatePageScrollStyle();
    }

    public abstract boolean isSinglePage();

    public abstract boolean isTwoPageButtonVisible();

    public abstract boolean isVerticalScroll();

    public final void setMHorizontalRadioButton(@Nullable ImageRadioButton imageRadioButton) {
        this.mHorizontalRadioButton = imageRadioButton;
    }

    public final void setMTwoPageButton(@Nullable ImageRadioButton imageRadioButton) {
        this.mTwoPageButton = imageRadioButton;
    }

    public final void setMVerticalRadioButton(@Nullable ImageRadioButton imageRadioButton) {
        this.mVerticalRadioButton = imageRadioButton;
    }

    public void updatePageScrollStyle() {
        if (this.mVerticalRadioButton == null || this.mHorizontalRadioButton == null || this.mTwoPageButton == null) {
            return;
        }
        boolean zIsVerticalScroll = isVerticalScroll();
        boolean zIsSinglePage = isSinglePage();
        ImageRadioButton imageRadioButton = this.mVerticalRadioButton;
        Intrinsics.checkNotNull(imageRadioButton);
        imageRadioButton.setChecked(zIsVerticalScroll);
        ImageRadioButton imageRadioButton2 = this.mHorizontalRadioButton;
        Intrinsics.checkNotNull(imageRadioButton2);
        imageRadioButton2.setChecked(!zIsVerticalScroll && zIsSinglePage);
        ImageRadioButton imageRadioButton3 = this.mTwoPageButton;
        Intrinsics.checkNotNull(imageRadioButton3);
        imageRadioButton3.setChecked(!zIsSinglePage);
        updateTwoPageButtonVisible();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPageScrollDirectionSettingsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPageScrollDirectionSettingsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }
}
