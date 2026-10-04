package com.samsung.android.sdk.pen.setting.util;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilHover;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "HOVER_TAG", "SUPPORT_TOOLTIP", "", "setHoverText", "", "target", "Landroid/view/View;", "description", "", "onlyOfficialSupport", "getHoverText", "setHoverEffect", "view", "hoverEnterValue", "", "hoverExitValue", "findChildButton", "Landroid/widget/ImageButton;", "parent", "Landroid/view/ViewGroup;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingUtilHover {

    @NotNull
    private static final String HOVER_TAG = "SupportTag";

    @NotNull
    public static final SpenSettingUtilHover INSTANCE = new SpenSettingUtilHover();
    private static final boolean SUPPORT_TOOLTIP;

    @NotNull
    private static final String TAG = "SpenSettingUtilHover";

    static {
        SUPPORT_TOOLTIP = Build.VERSION.SDK_INT > 26;
    }

    private SpenSettingUtilHover() {
    }

    private final ImageButton findChildButton(ViewGroup parent) {
        int childCount = parent.getChildCount();
        ImageButton imageButton = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            if (childAt instanceof ImageButton) {
                if (imageButton != null) {
                    return null;
                }
                imageButton = (ImageButton) childAt;
            }
        }
        return imageButton;
    }

    @JvmStatic
    @Nullable
    public static final CharSequence getHoverText(@NotNull View target) {
        ImageButton imageButtonFindChildButton;
        Intrinsics.checkNotNullParameter(target, "target");
        if (SUPPORT_TOOLTIP) {
            return target.getTooltipText();
        }
        if (!(target instanceof ViewGroup) || (imageButtonFindChildButton = INSTANCE.findChildButton((ViewGroup) target)) == null) {
            return null;
        }
        return imageButtonFindChildButton.getContentDescription();
    }

    @JvmStatic
    public static final void setHoverEffect(@NotNull View view, final float hoverEnterValue, final float hoverExitValue) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOnHoverListener(new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.setting.util.a
            @Override // android.view.View.OnHoverListener
            public final boolean onHover(View view2, MotionEvent motionEvent) {
                return SpenSettingUtilHover.setHoverEffect$lambda$1(hoverEnterValue, hoverExitValue, view2, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setHoverEffect$lambda$1(float f, float f4, View v, MotionEvent event) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 9) {
            v.setElevation(f);
            return false;
        }
        if (action != 10) {
            return false;
        }
        v.setElevation(f4);
        return false;
    }

    @JvmStatic
    public static final void setHoverText(@Nullable View target, @Nullable CharSequence description) {
        if (SUPPORT_TOOLTIP) {
            if (target != null) {
                target.setTooltipText(description);
                return;
            }
            return;
        }
        if (target instanceof Button) {
            ((Button) target).setContentDescription(description);
            return;
        }
        if (target instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) target;
            ImageButton imageButtonFindChildButton = INSTANCE.findChildButton(viewGroup);
            if (description != null) {
                if (imageButtonFindChildButton == null) {
                    imageButtonFindChildButton = new ImageButton(viewGroup.getContext());
                    imageButtonFindChildButton.setBackground(null);
                    imageButtonFindChildButton.setClickable(false);
                    imageButtonFindChildButton.setFocusable(false);
                    imageButtonFindChildButton.setTag(HOVER_TAG);
                    viewGroup.addView(imageButtonFindChildButton, new ViewGroup.LayoutParams(-1, -1));
                }
                imageButtonFindChildButton.setContentDescription(description);
                return;
            }
            if (imageButtonFindChildButton != null) {
                if (imageButtonFindChildButton.getTag() == null || !Intrinsics.areEqual(imageButtonFindChildButton.getTag(), HOVER_TAG)) {
                    imageButtonFindChildButton.setContentDescription(description);
                } else {
                    viewGroup.removeView(imageButtonFindChildButton);
                    viewGroup.invalidate();
                }
            }
        }
    }

    @JvmStatic
    public static final void setHoverText(@NotNull View target, @Nullable CharSequence description, boolean onlyOfficialSupport) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (!onlyOfficialSupport) {
            setHoverText(target, description);
        } else if (SUPPORT_TOOLTIP) {
            target.setTooltipText(description);
        }
    }
}
