package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.sem.recoil.CustomLinearLayoutCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.HolderAnimation;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistAsButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u001c\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/adapter/holder/FolderExpandBarHolder;", "Lcom/samsung/android/support/senl/nt/app/main/common/adapter/CommonHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "viewMode", "", "<init>", "(Landroid/view/View;I)V", "mHolderInfo", "Lcom/samsung/android/support/senl/nt/app/main/common/adapter/CommonHolderInfo;", "mLayout", "Lcom/samsung/android/support/senl/cm/base/framework/sem/recoil/CustomLinearLayoutCompat;", "mTitle", "Landroid/widget/TextView;", "mArrow", "Landroid/widget/ImageView;", "onClick", "", VPathDataCmd.RCurveTo, "onBindViewHolder", "position", "decorate", "holderData", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/Common;", "stateInfo", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/StateInfo;", "decorateTitle", "decorateArrowLayout", "getArrowDescription", "", "res", "Landroid/content/res/Resources;", "isCollapse", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FolderExpandBarHolder extends CommonHolder implements View.OnClickListener {

    @Nullable
    private final ImageView mArrow;

    @NotNull
    private final CommonHolderInfo mHolderInfo;

    @Nullable
    private final CustomLinearLayoutCompat mLayout;

    @NotNull
    private final TextView mTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderExpandBarHolder(@NotNull View itemView, int i) {
        super(itemView, i);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        setHolderType(4194304);
        CustomLinearLayoutCompat customLinearLayoutCompat = (CustomLinearLayoutCompat) itemView.findViewById(C8003R.id.expand_bar_layout);
        this.mLayout = customLinearLayoutCompat;
        View viewFindViewById = itemView.findViewById(C8003R.id.expand_bar_header);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mTitle = (TextView) viewFindViewById;
        ImageView imageView = (ImageView) itemView.findViewById(C8003R.id.expand_bar_arrow);
        this.mArrow = imageView;
        CommonHolderInfo commonHolderInfo = new CommonHolderInfo();
        this.mHolderInfo = commonHolderInfo;
        commonHolderInfo.setRootCardView(customLinearLayoutCompat);
        commonHolderInfo.setHolderType(getMHolderType());
        customLinearLayoutCompat.setOnClickListener(this);
        imageView.setOnClickListener(this);
    }

    private final void decorateArrowLayout(StateInfo stateInfo) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator interpolator;
        boolean zIsExpandedFolderBar = stateInfo.isExpandedFolderBar();
        boolean z = !zIsExpandedFolderBar;
        ImageView imageView = this.mArrow;
        if (imageView != null && (viewPropertyAnimatorAnimate = imageView.animate()) != null) {
            ViewPropertyAnimator viewPropertyAnimatorRotation = viewPropertyAnimatorAnimate.rotation(!zIsExpandedFolderBar ? 180 : 0);
            if (viewPropertyAnimatorRotation != null && (duration = viewPropertyAnimatorRotation.setDuration(400L)) != null && (interpolator = duration.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f))) != null) {
                interpolator.start();
            }
        }
        CustomLinearLayoutCompat customLinearLayoutCompat = this.mLayout;
        Intrinsics.checkNotNull(customLinearLayoutCompat);
        Resources resources = customLinearLayoutCompat.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        String arrowDescription = getArrowDescription(resources, z);
        this.mLayout.setContentDescription(arrowDescription);
        this.mLayout.setAccessibilityDelegate(new VoiceAssistAsButton());
        ViewCompat.INSTANCE.getInstance().setTooltipText(this.mArrow, arrowDescription);
    }

    private final void decorateTitle(StateInfo stateInfo) {
        CustomLinearLayoutCompat customLinearLayoutCompat = this.mLayout;
        Intrinsics.checkNotNull(customLinearLayoutCompat);
        Resources resources = customLinearLayoutCompat.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        String arrowDescription = getArrowDescription(resources, !stateInfo.isExpandedFolderBar());
        if (this.mTitle.getText().equals(arrowDescription)) {
            return;
        }
        if (stateInfo.isExpandedFolderBarStatusChanged()) {
            HolderAnimation.updateTextViewWidthAnimation(this.mTitle, arrowDescription);
        } else {
            this.mTitle.setText(arrowDescription);
            this.mTitle.requestLayout();
        }
        this.mLayout.setContentDescription(this.mTitle.getText());
        this.mLayout.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.FolderExpandBarHolder.decorateTitle.1
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(event, "event");
                super.onInitializeAccessibilityEvent(host, event);
                event.setClassName("android.widget.Spinner");
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                info.setClassName("android.widget.Spinner");
            }
        });
    }

    private final String getArrowDescription(Resources res, boolean isCollapse) {
        if (!isCollapse) {
            String string = res.getString(C8003R.string.subfolder_expand);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        AdapterContract mAdapterContract = getMAdapterContract();
        if (!FeatureUtils.isEditMode(mAdapterContract != null ? mAdapterContract.getModeIndex() : 1)) {
            String string2 = res.getString(C8003R.string.subfolder_collapse);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        AdapterContract mAdapterContract2 = getMAdapterContract();
        int checkedFoldersCount = mAdapterContract2 != null ? mAdapterContract2.getCheckedFoldersCount() : 0;
        if (checkedFoldersCount == 0) {
            String string3 = res.getString(C8003R.string.subfolder_collapse);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        String quantityString = res.getQuantityString(C8003R.plurals.plurals_subfolder_collapse_with_n_count, checkedFoldersCount, Integer.valueOf(checkedFoldersCount));
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        return quantityString;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void decorate(@Nullable Common holderData, @Nullable StateInfo stateInfo) {
        decorate(stateInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void onBindViewHolder(int position) {
        AdapterContract mAdapterContract = getMAdapterContract();
        if (mAdapterContract != null) {
            mAdapterContract.setDragListener(this.mHolderInfo);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.MemoList;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(300L, tag);
            AdapterContract mAdapterContract = getMAdapterContract();
            if (mAdapterContract != null) {
                mAdapterContract.toggleFolderExpandCollapseState();
            }
        }
    }

    public final void decorate(@Nullable StateInfo stateInfo) {
        if (this.mLayout == null || stateInfo == null) {
            return;
        }
        decorateTitle(stateInfo);
        decorateArrowLayout(stateInfo);
    }
}
