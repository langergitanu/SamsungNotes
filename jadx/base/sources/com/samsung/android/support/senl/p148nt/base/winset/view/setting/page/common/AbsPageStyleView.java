package com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.winset.view.common.ImageViewRadioButton;
import com.samsung.android.support.senl.p148nt.base.winset.view.common.ImageViewRadioButtonContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u0000 #2\u00020\u0001:\u0001#B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J0\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0014J\b\u0010 \u001a\u00020\u0018H\u0016J\b\u0010!\u001a\u00020\u0018H&J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/setting/page/common/AbsPageStyleView;", "Lcom/samsung/android/support/senl/nt/base/winset/view/common/ImageViewRadioButtonContainer;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mSplitPagesRadioButton", "Lcom/samsung/android/support/senl/nt/base/winset/view/common/ImageViewRadioButton;", "getMSplitPagesRadioButton", "()Lcom/samsung/android/support/senl/nt/base/winset/view/common/ImageViewRadioButton;", "setMSplitPagesRadioButton", "(Lcom/samsung/android/support/senl/nt/base/winset/view/common/ImageViewRadioButton;)V", "mInfiniteScrollRadioButton", "getMInfiniteScrollRadioButton", "setMInfiniteScrollRadioButton", "mLayoutStyleViewContainer", "Landroid/widget/LinearLayout;", "init", "", "onLayout", "changed", "", "left", "top", "right", "bottom", "initRadioButton", "updateRadioButton", "pageType", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAbsPageStyleView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbsPageStyleView.kt\ncom/samsung/android/support/senl/nt/base/winset/view/setting/page/common/AbsPageStyleView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,87:1\n1#2:88\n*E\n"})
public abstract class AbsPageStyleView extends ImageViewRadioButtonContainer {

    @NotNull
    private static final String TAG = "PagesStyleView";

    @Nullable
    private ImageViewRadioButton mInfiniteScrollRadioButton;

    @Nullable
    private LinearLayout mLayoutStyleViewContainer;

    @Nullable
    private ImageViewRadioButton mSplitPagesRadioButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPageStyleView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    private final void init(Context context) {
        LayoutInflater.from(context).inflate(C8875R.layout.page_style_settings_view, (ViewGroup) this, true);
        initRadioButton();
        updateRadioButton();
    }

    @Nullable
    public final ImageViewRadioButton getMInfiniteScrollRadioButton() {
        return this.mInfiniteScrollRadioButton;
    }

    @Nullable
    public final ImageViewRadioButton getMSplitPagesRadioButton() {
        return this.mSplitPagesRadioButton;
    }

    public void initRadioButton() {
        ImageViewRadioButton imageViewRadioButton = (ImageViewRadioButton) findViewById(C8875R.id.fixed_size_radio_button);
        if (imageViewRadioButton == null) {
            return;
        }
        this.mSplitPagesRadioButton = imageViewRadioButton;
        ImageViewRadioButton imageViewRadioButton2 = (ImageViewRadioButton) findViewById(C8875R.id.infinite_scrolling_radio_button);
        if (imageViewRadioButton2 == null) {
            return;
        }
        this.mInfiniteScrollRadioButton = imageViewRadioButton2;
        LinearLayout linearLayout = (LinearLayout) findViewById(C8875R.id.layout_style_page_container);
        if (linearLayout == null) {
            return;
        }
        this.mLayoutStyleViewContainer = linearLayout;
        ImageViewRadioButton imageViewRadioButton3 = this.mSplitPagesRadioButton;
        if (imageViewRadioButton3 != null) {
            imageViewRadioButton3.setTag(1);
            if (ModelFeature.getFeature().isFoldableModel() || DeviceUtils.isTabletModel()) {
                imageViewRadioButton3.setImageResource(C8875R.drawable.ic_page_style_individual_foldable_tablet);
            } else {
                imageViewRadioButton3.setImageResource(C8875R.drawable.ic_page_style_individual);
            }
            setRecoilStateListAnimator(imageViewRadioButton3);
        }
        ImageViewRadioButton imageViewRadioButton4 = this.mInfiniteScrollRadioButton;
        if (imageViewRadioButton4 != null) {
            imageViewRadioButton4.setTag(0);
            if (ModelFeature.getFeature().isFoldableModel() || DeviceUtils.isTabletModel()) {
                imageViewRadioButton4.setImageResource(C8875R.drawable.ic_page_style_infinite_foldable_tablet);
            } else {
                imageViewRadioButton4.setImageResource(C8875R.drawable.ic_page_style_infinite);
            }
            setRecoilStateListAnimator(imageViewRadioButton4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        LinearLayout linearLayout;
        super.onLayout(changed, left, top, right, bottom);
        if (!changed || (linearLayout = this.mLayoutStyleViewContainer) == null) {
            return;
        }
        updateButtonWidth(linearLayout);
    }

    public final void setMInfiniteScrollRadioButton(@Nullable ImageViewRadioButton imageViewRadioButton) {
        this.mInfiniteScrollRadioButton = imageViewRadioButton;
    }

    public final void setMSplitPagesRadioButton(@Nullable ImageViewRadioButton imageViewRadioButton) {
        this.mSplitPagesRadioButton = imageViewRadioButton;
    }

    public abstract void updateRadioButton();

    public final void updateRadioButton(int pageType) {
        boolean z = 1 == pageType;
        ImageViewRadioButton imageViewRadioButton = this.mSplitPagesRadioButton;
        if (imageViewRadioButton != null) {
            imageViewRadioButton.setChecked(z);
        }
        ImageViewRadioButton imageViewRadioButton2 = this.mInfiniteScrollRadioButton;
        if (imageViewRadioButton2 != null) {
            imageViewRadioButton2.setChecked(!z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPageStyleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPageStyleView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }
}
