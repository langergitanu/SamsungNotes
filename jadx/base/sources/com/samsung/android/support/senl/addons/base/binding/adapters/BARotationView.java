package com.samsung.android.support.senl.addons.base.binding.adapters;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.Key;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationEvent;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.AndroidInstanceConstructor;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\bH\u0007J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0007J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J.\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\bJ0\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J0\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J0\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J\u001a\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0018H\u0002J\u001a\u0010\"\u001a\u0004\u0018\u00010 2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0018H\u0002J0\u0010#\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J0\u0010$\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J\u001a\u0010%\u001a\u0004\u0018\u00010 2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0018H\u0002J\u001a\u0010&\u001a\u0004\u0018\u00010 2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0018H\u0002J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/adapters/BARotationView;", "", "<init>", "()V", "DEBUG", "", "mAnimationMap", "Landroid/util/ArrayMap;", "", "Landroid/animation/AnimatorSet;", "setRotation", "", "view", "Landroid/view/View;", "change", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationEvent;", "description", "", "pivotType", "animationMode", "hideAnimation", "animationType", "createRotateAnimation", "convertStartAngle", "", "startAngle", "targetAngle", "addTranslationXAnimator", "animatorSet", "diff", "addTranslationYAnimator", "getTranslationX", "Landroid/animation/ValueAnimator;", "target", "getTranslationY", "addXAnimator", "addYAnimator", "getX", "getY", SearchConstants.TargetContents.TAG, "debugLog", "content", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BARotationView {
    private static final boolean DEBUG = false;

    @NotNull
    public static final BARotationView INSTANCE = new BARotationView();

    @NotNull
    private static ArrayMap<Integer, AnimatorSet> mAnimationMap = new ArrayMap<>();

    @NotNull
    private static final String TAG = Logger.createTag("BARotationView");

    private BARotationView() {
    }

    private final void addTranslationXAnimator(View view, AnimatorSet animatorSet, int pivotType, float diff, float targetAngle) {
        ValueAnimator translationX;
        if ((pivotType & 4) != 0) {
            f = (targetAngle == 90.0f || targetAngle == 270.0f) ? -diff : 0.0f;
            translationX = getTranslationX(view, f);
        } else if ((pivotType & 8) != 0) {
            if (targetAngle != 90.0f && targetAngle != 270.0f) {
                diff = 0.0f;
            }
            translationX = getTranslationX(view, diff);
            f = diff;
        } else {
            translationX = null;
        }
        if (translationX != null) {
            debugLog(AbstractC0622a.m1166l("transX - ", f));
            animatorSet.playTogether(translationX);
        }
    }

    private final void addTranslationYAnimator(View view, AnimatorSet animatorSet, int pivotType, float diff, float targetAngle) {
        ValueAnimator translationY;
        if ((pivotType & 1) != 0) {
            if (targetAngle != 90.0f && targetAngle != 270.0f) {
                diff = 0.0f;
            }
            translationY = getTranslationY(view, diff);
            f = diff;
        } else if ((pivotType & 2) != 0) {
            f = (targetAngle == 90.0f || targetAngle == 270.0f) ? -diff : 0.0f;
            translationY = getTranslationY(view, f);
        } else {
            translationY = null;
        }
        if (translationY != null) {
            debugLog(AbstractC0622a.m1166l("transY - ", f));
            animatorSet.playTogether(translationY);
        }
    }

    private final void addXAnimator(View view, AnimatorSet animatorSet, int pivotType, float diff, float targetAngle) {
        ValueAnimator x;
        float f;
        if ((pivotType & 4) != 0) {
            f = (targetAngle == 90.0f || targetAngle == 270.0f) ? -diff : -view.getX();
            x = getX(view, f);
        } else if ((pivotType & 8) != 0) {
            if (targetAngle != 90.0f && targetAngle != 270.0f) {
                Intrinsics.checkNotNull(view.getParent(), "null cannot be cast to non-null type android.view.View");
                diff = (((View) r6).getWidth() - view.getWidth()) - view.getX();
            }
            x = getX(view, diff);
            f = diff;
        } else {
            x = null;
            f = 0.0f;
        }
        if (x != null) {
            debugLog(AbstractC0622a.m1166l("X - ", f));
            animatorSet.playTogether(x);
        }
    }

    private final void addYAnimator(View view, AnimatorSet animatorSet, int pivotType, float diff, float targetAngle) {
        ValueAnimator y2;
        if ((pivotType & 1) != 0) {
            if (targetAngle != 90.0f && targetAngle != 270.0f) {
                diff = 0.0f;
            }
            y2 = getY(view, diff);
            f = diff;
        } else if ((pivotType & 2) != 0) {
            f = (targetAngle == 90.0f || targetAngle == 270.0f) ? -diff : 0.0f;
            y2 = getY(view, f);
        } else {
            y2 = null;
        }
        if (y2 != null) {
            debugLog(AbstractC0622a.m1166l("Y - ", f));
            animatorSet.playTogether(y2);
        }
    }

    private final float convertStartAngle(float startAngle, float targetAngle) {
        boolean z;
        float f = targetAngle - startAngle;
        if (f < 0.0f) {
            f = -f;
            z = true;
        } else {
            z = false;
        }
        return f > 180.0f ? z ? startAngle - 360.0f : startAngle + 360.0f : startAngle;
    }

    private final void createRotateAnimation(View view, IRotationEvent change, int pivotType, boolean hideAnimation, int animationType) {
        final View view2;
        int width = view.getWidth();
        int height = view.getHeight();
        if (view.isLayoutRequested()) {
            debugLog("get requested size!");
            int i = view.getLayoutParams().width;
            int i2 = view.getLayoutParams().height;
            if (i > 0) {
                width = i;
            }
            if (i2 > 0) {
                height = i2;
            }
        }
        if (width == 0 || height == 0) {
            debugLog("zero size view!");
            view.measure(0, 0);
            if (width == 0) {
                width = view.getMeasuredWidth();
            }
            if (height == 0) {
                height = view.getMeasuredHeight();
            }
        }
        float mTarget = change.getMTarget();
        float fConvertStartAngle = convertStartAngle(view.getRotation(), mTarget);
        int iHashCode = view.hashCode();
        StringBuilder sbM1176v = AbstractC0622a.m1176v("rotation fr ", fConvertStartAngle, " to ", mTarget, " at ");
        sbM1176v.append(iHashCode);
        debugLog(sbM1176v.toString());
        StringBuilder sbM1173s = AbstractC0622a.m1173s(width, height, "w/h = ", "/", SQLKeyword.COMMA);
        sbM1173s.append(pivotType);
        debugLog(sbM1173s.toString());
        AnimatorSet animatorSetMakeAnimatorSet = AndroidInstanceConstructor.makeAnimatorSet();
        animatorSetMakeAnimatorSet.setDuration(hideAnimation ? 0L : 200L);
        float f = (width - height) / 2.0f;
        if (animationType == 1) {
            view2 = view;
            addXAnimator(view2, animatorSetMakeAnimatorSet, pivotType, f, mTarget);
            addYAnimator(view2, animatorSetMakeAnimatorSet, pivotType, f, mTarget);
        } else {
            view2 = view;
            addTranslationXAnimator(view2, animatorSetMakeAnimatorSet, pivotType, f, mTarget);
            addTranslationYAnimator(view2, animatorSetMakeAnimatorSet, pivotType, f, mTarget);
        }
        animatorSetMakeAnimatorSet.playTogether(ObjectAnimator.ofFloat(view2, Key.ROTATION, fConvertStartAngle, mTarget));
        animatorSetMakeAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.addons.base.binding.adapters.BARotationView.createRotateAnimation.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                BARotationView.mAnimationMap.remove(Integer.valueOf(view2.getId()));
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                BARotationView.mAnimationMap.remove(Integer.valueOf(view2.getId()));
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        mAnimationMap.put(Integer.valueOf(view2.getId()), animatorSetMakeAnimatorSet);
        animatorSetMakeAnimatorSet.start();
    }

    private final void debugLog(String content) {
    }

    private final ValueAnimator getTranslationX(View view, float target) {
        if (PlatformUtil.isRTLMode()) {
            target = -target;
        }
        float translationX = view.getTranslationX();
        if (Float.compare(translationX, target) != 0) {
            return ObjectAnimator.ofFloat(view, "translationX", translationX, target);
        }
        return null;
    }

    private final ValueAnimator getTranslationY(View view, float target) {
        float translationY = view.getTranslationY();
        if (Float.compare(translationY, target) != 0) {
            return ObjectAnimator.ofFloat(view, "translationY", translationY, target);
        }
        return null;
    }

    private final ValueAnimator getX(View view, float target) {
        float x = view.getX();
        float f = target + x;
        if (Float.compare(x, f) != 0) {
            return ObjectAnimator.ofFloat(view, "x", x, f);
        }
        return null;
    }

    private final ValueAnimator getY(View view, float target) {
        float y2 = view.getY();
        float f = target + y2;
        if (Float.compare(y2, f) != 0) {
            return ObjectAnimator.ofFloat(view, "y", y2, f);
        }
        return null;
    }

    public final void setRotation(@NotNull View view, @NotNull IRotationEvent change) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(change, "change");
        debugLog(AbstractC0000a.m11h(view.hashCode(), "rotation without pivot type : "));
        setRotation(view, change, 0, false, 0);
    }

    public final void setRotation(@NotNull View view, @NotNull IRotationEvent change, @Nullable String description) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(change, "change");
        debugLog(AbstractC0000a.m11h(view.hashCode(), "rotation without pivot type : "));
        if (!TextUtils.isEmpty(description)) {
            if (change.getMTarget() == 0) {
                ViewCompat.INSTANCE.getInstance().setTooltipText(view, description);
                debugLog(AbstractC0000a.m11h(view.hashCode(), "rotation - show description"));
            } else {
                ViewCompat.INSTANCE.getInstance().setTooltipText(view, "");
                debugLog(AbstractC0000a.m11h(view.hashCode(), "rotation - hide description"));
            }
        }
        setRotation(view, change, 0, false);
    }

    @JvmStatic
    public static final void setRotation(@NotNull View view, @NotNull IRotationEvent change, int pivotType) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(change, "change");
        setRotation(view, change, pivotType, false);
    }

    @JvmStatic
    public static final void setRotation(@NotNull View view, @NotNull IRotationEvent change, int pivotType, int animationMode) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(change, "change");
        INSTANCE.setRotation(view, change, pivotType, false, animationMode);
    }

    @JvmStatic
    public static final void setRotation(@NotNull View view, @NotNull IRotationEvent change, int pivotType, boolean hideAnimation) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(change, "change");
        INSTANCE.setRotation(view, change, pivotType, hideAnimation, 0);
    }

    public final void setRotation(@NotNull View view, @NotNull IRotationEvent change, int pivotType, boolean hideAnimation, int animationType) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(change, "change");
        if (mAnimationMap.get(Integer.valueOf(view.getId())) != null) {
            AnimatorSet animatorSet = mAnimationMap.get(Integer.valueOf(view.getId()));
            Intrinsics.checkNotNull(animatorSet);
            animatorSet.removeAllListeners();
            AnimatorSet animatorSet2 = mAnimationMap.get(Integer.valueOf(view.getId()));
            Intrinsics.checkNotNull(animatorSet2);
            animatorSet2.cancel();
            mAnimationMap.remove(Integer.valueOf(view.getId()));
        }
        createRotateAnimation(view, change, pivotType, hideAnimation, animationType);
    }
}
