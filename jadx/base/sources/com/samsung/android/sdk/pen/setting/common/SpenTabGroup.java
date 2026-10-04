package com.samsung.android.sdk.pen.setting.common;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAccessibility;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0014\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\nJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\u0003J\u0018\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001e\u001a\u00020\bJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\bJ\u0010\u0010$\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010\u0010J\"\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u001a\u0010\u001f\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010'\u001a\u00020\u0003H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\r2\u0006\u0010 \u001a\u00020\bH\u0002J\u001a\u0010)\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0012\u0010+\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010\rH\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006."}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenTabGroup;", "", "applyDefaultBackground", "", "<init>", "(Z)V", "()V", "defaultBg", "", "defaultBgHighContrast", "(II)V", "mTabs", "", "Landroid/view/View;", "mSelectView", "mSelectedListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenTabGroup$OnTabSelectedListener;", "mSelectedFontName", "Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilText$FontName;", "mUnSelectedFontName", "mChildClickListener", "Landroid/view/View$OnClickListener;", "mIsAppliedDefaultBackground", "mDefaultBg", "mDefaultBgHighContrast", "close", "", "addTab", "child", "selected", "position", Bixby2Constants.BIXBY_PARAM_SELECT, "id", "selectId", "getSelectId", "()I", "setOnTabSelectedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "selectView", "notify", "getChild", "applyFont", "view", "applyBackgroundResource", "Companion", "OnTabSelectedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenTabGroup {

    @NotNull
    private static final String TAG = "TabGroup";

    @NotNull
    private final View.OnClickListener mChildClickListener;
    private int mDefaultBg;
    private int mDefaultBgHighContrast;
    private boolean mIsAppliedDefaultBackground;

    @Nullable
    private View mSelectView;

    @NotNull
    private final SpenSettingUtilText.FontName mSelectedFontName;

    @Nullable
    private OnTabSelectedListener mSelectedListener;

    @NotNull
    private List<View> mTabs;

    @NotNull
    private final SpenSettingUtilText.FontName mUnSelectedFontName;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenTabGroup$OnTabSelectedListener;", "", "onTabSelected", "", "tab", "Landroid/view/View;", "onTabUnselected", "onTabReselected", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnTabSelectedListener {
        void onTabReselected(@Nullable View tab);

        void onTabSelected(@Nullable View tab);

        void onTabUnselected(@Nullable View tab);
    }

    public SpenTabGroup(boolean z) {
        this.mTabs = new ArrayList();
        this.mSelectedFontName = SpenSettingUtilText.FontName.MEDIUM;
        this.mUnSelectedFontName = SpenSettingUtilText.FontName.REGULAR;
        this.mChildClickListener = new ViewOnClickListenerC7538b(this, 8);
        this.mDefaultBg = C7932R.drawable.setting_pen_width_item_background;
        this.mDefaultBgHighContrast = C7932R.drawable.setting_item_background_high_contrast;
        this.mIsAppliedDefaultBackground = z;
    }

    private final void applyBackgroundResource(View view) {
        if (view == null || !this.mIsAppliedDefaultBackground) {
            return;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        view.setBackgroundResource(!SpenSettingUtilAccessibility.isHighContrast(context) ? this.mDefaultBg : this.mDefaultBgHighContrast);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void applyFont(View view, boolean selected) {
        if (view == null || !(view instanceof TextView)) {
            return;
        }
        SpenSettingUtilText.setTypeFace(((TextView) view).getContext(), selected ? this.mSelectedFontName : this.mUnSelectedFontName, view);
    }

    private final View getChild(int id) {
        for (View view : this.mTabs) {
            if (view.getId() == id) {
                return view;
            }
        }
        return null;
    }

    public final void addTab(@Nullable View child) {
        if (child != null) {
            addTab(child, false);
        }
    }

    public final void close() {
        this.mTabs.clear();
        this.mSelectView = null;
        this.mSelectedListener = null;
    }

    public final int getSelectId() {
        View view = this.mSelectView;
        if (view != null) {
            return view.getId();
        }
        return 0;
    }

    public final void select(int id) {
        View child = getChild(id);
        if (child != null) {
            select(child, false);
        }
    }

    public final void setOnTabSelectedListener(@Nullable OnTabSelectedListener listener) {
        this.mSelectedListener = listener;
    }

    public final void addTab(@Nullable View child, boolean selected) {
        addTab(child, this.mTabs.size(), selected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void select(View selectView, boolean notify) {
        OnTabSelectedListener onTabSelectedListener;
        OnTabSelectedListener onTabSelectedListener2;
        OnTabSelectedListener onTabSelectedListener3;
        if (selectView == null) {
            return;
        }
        View view = this.mSelectView;
        if (view != null) {
            if (Intrinsics.areEqual(view, selectView)) {
                Log.i(TAG, "Already Selected");
                if (!notify || (onTabSelectedListener3 = this.mSelectedListener) == null) {
                    return;
                }
                onTabSelectedListener3.onTabReselected(this.mSelectView);
                return;
            }
            View view2 = this.mSelectView;
            if (view2 != null) {
                view2.setSelected(false);
            }
            applyFont(this.mSelectView, false);
            if (notify && (onTabSelectedListener2 = this.mSelectedListener) != null) {
                onTabSelectedListener2.onTabUnselected(this.mSelectView);
            }
        }
        selectView.setSelected(true);
        applyFont(selectView, true);
        if (notify && (onTabSelectedListener = this.mSelectedListener) != null) {
            onTabSelectedListener.onTabSelected(selectView);
        }
        this.mSelectView = selectView;
    }

    public final void addTab(@Nullable View child, int position) {
        addTab(child, position, false);
    }

    private final void addTab(View child, int position, boolean selected) {
        if (child != null) {
            this.mTabs.add(position, child);
            if (selected) {
                View view = this.mSelectView;
                if (view != null) {
                    view.setSelected(false);
                }
                this.mSelectView = child;
            }
            child.setSelected(selected);
            applyFont(child, selected);
            applyBackgroundResource(child);
            child.setOnClickListener(this.mChildClickListener);
        }
    }

    public SpenTabGroup() {
        this.mTabs = new ArrayList();
        this.mSelectedFontName = SpenSettingUtilText.FontName.MEDIUM;
        this.mUnSelectedFontName = SpenSettingUtilText.FontName.REGULAR;
        this.mChildClickListener = new ViewOnClickListenerC7538b(this, 8);
        this.mDefaultBg = C7932R.drawable.setting_pen_width_item_background;
        this.mDefaultBgHighContrast = C7932R.drawable.setting_item_background_high_contrast;
        this.mIsAppliedDefaultBackground = true;
    }

    public SpenTabGroup(int i, int i2) {
        this.mTabs = new ArrayList();
        this.mSelectedFontName = SpenSettingUtilText.FontName.MEDIUM;
        this.mUnSelectedFontName = SpenSettingUtilText.FontName.REGULAR;
        this.mChildClickListener = new ViewOnClickListenerC7538b(this, 8);
        this.mDefaultBg = i;
        this.mDefaultBgHighContrast = i2;
        this.mIsAppliedDefaultBackground = true;
    }
}
