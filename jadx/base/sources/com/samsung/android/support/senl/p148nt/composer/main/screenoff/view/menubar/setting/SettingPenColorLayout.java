package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenColorPaletteModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenInfoModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenPairedColorModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0003J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\tH\u0002J0\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010 \u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\f\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingPenColorLayout;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingLayout;", "container", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mPlayAnimation", "", "mOrientation", "", "mSettingLayout", "Landroid/view/ViewGroup;", "mPenColorPaletteMap", "Ljava/util/HashMap;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingPenColor;", "Lkotlin/collections/HashMap;", "initPenColorPalette", "", "updatePenColorPalette", "init", Constants.IntentExtraValue.SHOW, "hide", "isVisible", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE, "initialize", "startAnimation", "visibility", "startChildAnimation", "child", "translateAnimationId", "alphaAnimationId", TypedValues.Cycle.S_WAVE_OFFSET, "cancelChildAnimation", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingPenColorLayout extends SettingLayout {
    private static final float ALPHA_ANIMATION_INVISIBLE = 0.0f;
    private static final float ALPHA_ANIMATION_VISIBLE = 1.0f;
    private static final int COLOR_ITEM_ANIMATION_MAX_OFFSET = 90;
    private static final int COLOR_ITEM_ANIMATION_OFFSET = 30;

    @NotNull
    private static final String PREFIX_PEN_COLOR_ITEM = "pen_color_";
    private final int mOrientation;

    @Nullable
    private HashMap<Integer, SettingPenColor> mPenColorPaletteMap;
    private boolean mPlayAnimation;

    @Nullable
    private ViewGroup mSettingLayout;

    @NotNull
    private static final String TAG = SOLogger.createTag("SettingPenColorLayout");

    public SettingPenColorLayout(@NotNull View container) {
        ViewGroup.LayoutParams layoutParams;
        FrameLayout.LayoutParams layoutParams2;
        Intrinsics.checkNotNullParameter(container, "container");
        Resources resources = container.getContext().getResources();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(container.getContext());
        int i = container.getContext().getResources().getConfiguration().orientation;
        this.mOrientation = i;
        AbstractC8014b.m7206h("SettingPenColorLayout# orientation ", i, SOLogger.INSTANCE, TAG);
        if (container instanceof ViewGroup) {
            if (i == 1 || ConfigurationModel.INSTANCE.isSupportNavigationRotation()) {
                View viewInflate = layoutInflaterFrom.inflate(C9086R.layout.screenoff_pen_color_setting_layout_portrait, (ViewGroup) container, false);
                Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) viewInflate;
                this.mSettingLayout = viewGroup;
                layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = 8388659;
                layoutParams2.setMarginStart((int) resources.getDimension(C9086R.dimen.screenoff_pen_color_setting_view_margin_start_portrait));
                layoutParams2.topMargin = (int) resources.getDimension(C9086R.dimen.screenoff_pen_color_setting_view_margin_top_portrait);
            } else {
                ViewGroup viewGroup2 = (ViewGroup) container;
                Object systemService = viewGroup2.getContext().getSystemService("window");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                int rotation = ((WindowManager) systemService).getDefaultDisplay().getRotation();
                boolean zIsRTLMode = LocaleUtils.isRTLMode();
                View viewInflate2 = layoutInflaterFrom.inflate(C9086R.layout.screenoff_pen_color_setting_layout_landscape, viewGroup2, false);
                Intrinsics.checkNotNull(viewInflate2, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup3 = (ViewGroup) viewInflate2;
                this.mSettingLayout = viewGroup3;
                layoutParams = viewGroup3 != null ? viewGroup3.getLayoutParams() : null;
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = 80;
                int dimension = (int) resources.getDimension(C9086R.dimen.screenoff_pen_color_setting_view_margin_start_landscape);
                int navigationBarHeightIgnoreHasSoftKey = InputMethodCompat.INSTANCE.getInstance().getNavigationBarHeightIgnoreHasSoftKey(container.getContext());
                if (zIsRTLMode) {
                    if (rotation == 3) {
                        layoutParams2.setMarginEnd(dimension + navigationBarHeightIgnoreHasSoftKey);
                    } else {
                        layoutParams2.setMarginEnd(dimension);
                    }
                } else if (rotation == 3) {
                    layoutParams2.setMarginStart(dimension + navigationBarHeightIgnoreHasSoftKey);
                } else {
                    layoutParams2.setMarginStart(dimension);
                }
                layoutParams2.bottomMargin = (int) resources.getDimension(C9086R.dimen.screenoff_pen_color_setting_view_margin_bottom_landscape);
            }
            ((ViewGroup) container).addView(this.mSettingLayout, layoutParams2);
        }
    }

    private final void cancelChildAnimation() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "cancelChildAnimation#");
        ViewGroup viewGroup = this.mSettingLayout;
        View childAt = viewGroup != null ? viewGroup.getChildAt(0) : null;
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) childAt;
        int childCount = viewGroup2.getChildCount();
        for (int i = 0; i < childCount; i += 2) {
            viewGroup2.getChildAt(i).clearAnimation();
        }
        this.mPlayAnimation = false;
    }

    @SuppressLint({"DiscouragedApi"})
    private final void initPenColorPalette() {
        Integer numValueOf;
        View viewFindViewById;
        Context context;
        Context context2;
        int i = 1;
        int settingPenColorPaletteSize = PenColorPaletteModel.INSTANCE.getSettingPenColorPaletteSize() - 1;
        AbstractC8014b.m7206h("initPenColorPalette# penColorPaletteSize ", settingPenColorPaletteSize, SOLogger.INSTANCE, TAG);
        ViewGroup viewGroup = this.mSettingLayout;
        Resources resources = (viewGroup == null || (context2 = viewGroup.getContext()) == null) ? null : context2.getResources();
        ViewGroup viewGroup2 = this.mSettingLayout;
        String packageName = (viewGroup2 == null || (context = viewGroup2.getContext()) == null) ? null : context.getPackageName();
        this.mPenColorPaletteMap = new HashMap<>(settingPenColorPaletteSize);
        if (1 > settingPenColorPaletteSize) {
            return;
        }
        while (true) {
            if (resources != null) {
                numValueOf = Integer.valueOf(resources.getIdentifier(PREFIX_PEN_COLOR_ITEM + i, "id", packageName));
            } else {
                numValueOf = null;
            }
            ViewGroup viewGroup3 = this.mSettingLayout;
            if (viewGroup3 != null) {
                viewFindViewById = viewGroup3.findViewById(numValueOf != null ? numValueOf.intValue() : -1);
            } else {
                viewFindViewById = null;
            }
            SettingPenColor settingPenColor = new SettingPenColor();
            settingPenColor.setPenColorView(viewFindViewById);
            settingPenColor.setSettingViewManager(getMSettingViewManager());
            if (viewFindViewById != null) {
                HashMap<Integer, SettingPenColor> map = this.mPenColorPaletteMap;
                Intrinsics.checkNotNull(map);
                map.put(Integer.valueOf(viewFindViewById.getId()), settingPenColor);
            }
            if (i == settingPenColorPaletteSize) {
                return;
            } else {
                i++;
            }
        }
    }

    private final void startAnimation(int visibility) {
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        int i = this.mOrientation;
        boolean z = this.mPlayAnimation;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(visibility, i, "startAnimation# visibility/orientation/playAnimation ", "/", "/");
        sbM1173s.append(z);
        sOLogger.SOLoggerD(str, sbM1173s.toString());
        if (this.mPlayAnimation) {
            cancelChildAnimation();
        }
        ViewGroup viewGroup = this.mSettingLayout;
        View childAt = viewGroup != null ? viewGroup.getChildAt(0) : null;
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) childAt;
        if (visibility != 0) {
            int i2 = 0;
            for (int childCount = viewGroup2.getChildCount() - 1; childCount >= 0; childCount -= 2) {
                if (this.mOrientation == 1 || ConfigurationModel.INSTANCE.isSupportNavigationRotation()) {
                    View childAt2 = viewGroup2.getChildAt(childCount);
                    Intrinsics.checkNotNullExpressionValue(childAt2, "getChildAt(...)");
                    startChildAnimation(childAt2, C9086R.anim.screenoff_pen_color_layout_hide_portrait, C9086R.anim.screenoff_pen_color_layout_hide_alpha, i2, visibility);
                } else {
                    View childAt3 = viewGroup2.getChildAt(childCount);
                    Intrinsics.checkNotNullExpressionValue(childAt3, "getChildAt(...)");
                    startChildAnimation(childAt3, C9086R.anim.screenoff_pen_color_layout_hide_landscape, C9086R.anim.screenoff_pen_color_layout_hide_alpha, i2, visibility);
                }
                i2 += 30;
            }
            return;
        }
        ViewGroup viewGroup3 = this.mSettingLayout;
        if (viewGroup3 != null) {
            viewGroup3.setVisibility(visibility);
        }
        viewGroup2.setVisibility(visibility);
        int i4 = 0;
        for (int i5 = 1; i5 < viewGroup2.getChildCount(); i5 += 2) {
            if (this.mOrientation == 1 || ConfigurationModel.INSTANCE.isSupportNavigationRotation()) {
                View childAt4 = viewGroup2.getChildAt(i5);
                Intrinsics.checkNotNullExpressionValue(childAt4, "getChildAt(...)");
                startChildAnimation(childAt4, C9086R.anim.screenoff_pen_color_layout_show_portrait, C9086R.anim.screenoff_pen_color_layout_show_alpha, i4, visibility);
            } else {
                View childAt5 = viewGroup2.getChildAt(i5);
                Intrinsics.checkNotNullExpressionValue(childAt5, "getChildAt(...)");
                startChildAnimation(childAt5, C9086R.anim.screenoff_pen_color_layout_show_landscape, C9086R.anim.screenoff_pen_color_layout_show_alpha, i4, visibility);
            }
            i4 += 30;
        }
    }

    private final void startChildAnimation(final View child, int translateAnimationId, int alphaAnimationId, final int offset, final int visibility) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "startChildAnimation#");
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setStartOffset(offset);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(child.getContext(), translateAnimationId);
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(child.getContext(), alphaAnimationId);
        animationLoadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.view.menubar.setting.SettingPenColorLayout.startChildAnimation.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (visibility == 0) {
                    child.setAlpha(1.0f);
                } else {
                    child.setAlpha(0.0f);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SettingPenColorLayout.this.mPlayAnimation = true;
            }
        });
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.view.menubar.setting.SettingPenColorLayout.startChildAnimation.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                child.setEnabled(true);
                if (visibility == 0 || 90 > offset) {
                    return;
                }
                Object parent = child.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                ((View) parent).setVisibility(8);
                ViewGroup viewGroup = this.mSettingLayout;
                if (viewGroup != null) {
                    viewGroup.setVisibility(visibility);
                }
                this.mPlayAnimation = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        animationSet.addAnimation(animationLoadAnimation);
        animationSet.addAnimation(animationLoadAnimation2);
        if (visibility == 0) {
            child.setAlpha(0.0f);
        } else {
            child.setAlpha(1.0f);
        }
        child.setEnabled(false);
        child.startAnimation(animationSet);
    }

    private final void updatePenColorPalette() {
        ViewGroup viewGroup = this.mSettingLayout;
        View childAt = viewGroup != null ? viewGroup.getChildAt(0) : null;
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) childAt;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        HashMap<Integer, SettingPenColor> map = this.mPenColorPaletteMap;
        Intrinsics.checkNotNull(map);
        int i = 1;
        for (Map.Entry<Integer, SettingPenColor> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            SettingPenColor value = entry.getValue();
            sb.append(i);
            sb.append(SQLKeyword.COMMA);
            PenColorPaletteModel penColorPaletteModel = PenColorPaletteModel.INSTANCE;
            sb2.append(Integer.toHexString(penColorPaletteModel.getSettingPenColorData(i).getColor()));
            sb2.append(SQLKeyword.COMMA);
            sb3.append(penColorPaletteModel.getSettingPenColorData(i).getDescription());
            sb3.append(SQLKeyword.COMMA);
            View viewFindViewById = viewGroup2.findViewById(iIntValue);
            viewGroup2.removeView(viewFindViewById);
            viewGroup2.addView(viewFindViewById, (i * 2) - 1);
            value.setPenColorData(penColorPaletteModel.getSettingPenColorData(i));
            value.update();
            i++;
        }
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "updatePenColorPalette# lSettingPenColorDataIndex " + ((Object) sb));
        sOLogger.SOLoggerD(str, "updatePenColorPalette# lColor " + ((Object) sb2));
        sOLogger.SOLoggerD(str, "updatePenColorPalette# lDescription " + ((Object) sb3));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingLayout
    public void hide() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "hide#");
        startAnimation(8);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingLayout
    public void init() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "init#");
        initPenColorPalette();
        updatePenColorPalette();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingLayout
    public boolean isVisible() {
        ViewGroup viewGroup = this.mSettingLayout;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingLayout
    public void show() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "show#");
        startAnimation(0);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.SettingLayout
    public void update(boolean initialize) {
        PenColorPaletteModel penColorPaletteModel = PenColorPaletteModel.INSTANCE;
        PenInfoModel penInfoModel = PenInfoModel.INSTANCE;
        int iUpdatePairedPenColor = penColorPaletteModel.updatePairedPenColor(initialize, penInfoModel.getColor(), penInfoModel.getCurrentPairedColor(), penInfoModel.getCurrentPairedColorCode(), penInfoModel.getSavedPairedColorCode(), PenPairedColorModel.INSTANCE.getPairedColorCodeList());
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & iUpdatePairedPenColor)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        sOLogger.SOLoggerD(str, "update# color ".concat(str2));
        updatePenColorPalette();
        penInfoModel.setColor(iUpdatePairedPenColor);
    }
}
