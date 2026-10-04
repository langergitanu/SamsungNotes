package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.view;

import android.R;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 22\u00020\u00012\u00020\u0002:\u000212B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0017J\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0017J\u0010\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010\"\u001a\u00020\u001aJ\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020%H\u0016J\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0014J\u0006\u0010*\u001a\u00020\u000bJ\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u000bH\u0002J\u0012\u0010.\u001a\u00020\u001a2\b\u0010/\u001a\u0004\u0018\u000100H\u0014R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/view/LayoutSettingsMiniView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLayoutStyle", "Landroid/widget/TextView;", "mNormal", "Landroid/widget/ImageView;", "mLandscape", "mLong", "mSettingChangeListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/view/LayoutSettingsMiniView$SettingChangeListener;", "mPageSize", "mIsLongEnabled", "", "mIsLandscapeEnabled", "init", "", "initLayout", "setLongEnable", "enable", "setLandscapeEnable", "initialize", "savedInstanceState", "Landroid/os/Bundle;", "updateLayoutStyle", "setRippleNRecoilEffect", "view", "Landroid/view/View;", "onClick", VPathDataCmd.RCurveTo, "setSettingChangeListener", "settingChangeListener", "getPageSize", "setPageSize", "pageSize", "getInitialPageSize", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "SettingChangeListener", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LayoutSettingsMiniView extends FrameLayout implements View.OnClickListener {

    @NotNull
    public static final String TAG = "LayoutSettingsMiniView";
    private boolean mIsLandscapeEnabled;
    private boolean mIsLongEnabled;

    @Nullable
    private ImageView mLandscape;

    @Nullable
    private TextView mLayoutStyle;

    @Nullable
    private ImageView mLong;

    @Nullable
    private ImageView mNormal;
    private int mPageSize;

    @Nullable
    private SettingChangeListener mSettingChangeListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/view/LayoutSettingsMiniView$SettingChangeListener;", "", "onLayoutSettingChanged", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface SettingChangeListener {
        void onLayoutSettingChanged();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutSettingsMiniView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPageSize = -1;
        this.mIsLongEnabled = true;
        this.mIsLandscapeEnabled = true;
        init(context);
    }

    private final int getInitialPageSize() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_SIZE, 0);
    }

    private final void init(Context context) {
        LayoutInflater.from(context).inflate(C9086R.layout.layout_settings_mini_view, (ViewGroup) this, true);
        this.mPageSize = getInitialPageSize();
        initLayout();
        updateLayoutStyle();
    }

    private final void initLayout() {
        TextView textView = (TextView) findViewById(C9086R.id.layout_style);
        if (textView == null) {
            return;
        }
        this.mLayoutStyle = textView;
        ImageView imageView = (ImageView) findViewById(C9086R.id.layout_settings_normal);
        if (imageView == null) {
            return;
        }
        this.mNormal = imageView;
        ImageView imageView2 = (ImageView) findViewById(C9086R.id.layout_settings_landscape);
        if (imageView2 == null) {
            return;
        }
        this.mLandscape = imageView2;
        ImageView imageView3 = (ImageView) findViewById(C9086R.id.layout_settings_long);
        if (imageView3 == null) {
            return;
        }
        this.mLong = imageView3;
        ImageView imageView4 = this.mNormal;
        Intrinsics.checkNotNull(imageView4);
        imageView4.setOnClickListener(this);
        ImageView imageView5 = this.mLandscape;
        Intrinsics.checkNotNull(imageView5);
        imageView5.setOnClickListener(this);
        ImageView imageView6 = this.mLong;
        Intrinsics.checkNotNull(imageView6);
        imageView6.setOnClickListener(this);
        if (this.mIsLandscapeEnabled) {
            ImageView imageView7 = this.mLandscape;
            Intrinsics.checkNotNull(imageView7);
            imageView7.setVisibility(0);
        } else {
            ImageView imageView8 = this.mLandscape;
            Intrinsics.checkNotNull(imageView8);
            imageView8.setVisibility(8);
        }
        if (this.mIsLongEnabled) {
            ImageView imageView9 = this.mLong;
            Intrinsics.checkNotNull(imageView9);
            imageView9.setVisibility(0);
        } else {
            ImageView imageView10 = this.mLong;
            Intrinsics.checkNotNull(imageView10);
            imageView10.setVisibility(8);
        }
    }

    private final void setPageSize(int pageSize) {
        this.mPageSize = pageSize;
    }

    private final void setRippleNRecoilEffect(View view) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, ResourcesCompat.getDrawable(getContext().getResources(), C9086R.drawable.layout_setting_mini_view_item_fg, getContext().getTheme()));
        view.setForeground(stateListDrawable);
        ViewCompat companion = ViewCompat.INSTANCE.getInstance();
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        StateListAnimator recoilStateListAnimator = companion.getRecoilStateListAnimator(context, 0);
        if (recoilStateListAnimator != null) {
            view.setStateListAnimator(recoilStateListAnimator);
        }
    }

    public final int getPageSize() {
        if (this.mPageSize < 0) {
            this.mPageSize = getInitialPageSize();
        }
        return this.mPageSize;
    }

    public final void initialize(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return;
        }
        this.mPageSize = savedInstanceState.getInt(SettingsConstants.SETTINGS_PAGE_SIZE, 0);
        updateLayoutStyle();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id = v.getId();
        if (id == C9086R.id.layout_settings_normal) {
            setPageSize(0);
            SettingChangeListener settingChangeListener = this.mSettingChangeListener;
            if (settingChangeListener != null) {
                Intrinsics.checkNotNull(settingChangeListener);
                settingChangeListener.onLayoutSettingChanged();
                return;
            }
            return;
        }
        if (id == C9086R.id.layout_settings_landscape) {
            setPageSize(2);
            SettingChangeListener settingChangeListener2 = this.mSettingChangeListener;
            if (settingChangeListener2 != null) {
                Intrinsics.checkNotNull(settingChangeListener2);
                settingChangeListener2.onLayoutSettingChanged();
                return;
            }
            return;
        }
        if (id == C9086R.id.layout_settings_long) {
            setPageSize(1);
            SettingChangeListener settingChangeListener3 = this.mSettingChangeListener;
            if (settingChangeListener3 != null) {
                Intrinsics.checkNotNull(settingChangeListener3);
                settingChangeListener3.onLayoutSettingChanged();
            }
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateLayoutStyle();
    }

    public final void setLandscapeEnable(boolean enable) {
        if (this.mIsLandscapeEnabled == enable) {
            return;
        }
        this.mIsLandscapeEnabled = enable;
        if (enable) {
            ImageView imageView = this.mLandscape;
            Intrinsics.checkNotNull(imageView);
            imageView.setVisibility(0);
        } else {
            ImageView imageView2 = this.mLandscape;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setVisibility(8);
        }
        if (getPageSize() == 2) {
            setPageSize(0);
            updateLayoutStyle();
        }
    }

    public final void setLongEnable(boolean enable) {
        if (this.mIsLongEnabled == enable) {
            return;
        }
        this.mIsLongEnabled = enable;
        if (enable) {
            ImageView imageView = this.mLong;
            Intrinsics.checkNotNull(imageView);
            imageView.setVisibility(0);
        } else {
            ImageView imageView2 = this.mLong;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setVisibility(8);
        }
        if (getPageSize() == 1) {
            setPageSize(0);
            updateLayoutStyle();
        }
    }

    public final void setSettingChangeListener(@NotNull SettingChangeListener settingChangeListener) {
        Intrinsics.checkNotNullParameter(settingChangeListener, "settingChangeListener");
        this.mSettingChangeListener = settingChangeListener;
    }

    public final void updateLayoutStyle() {
        if (this.mLayoutStyle == null || this.mNormal == null || this.mLandscape == null || this.mLong == null) {
            return;
        }
        Logger.m11000e(TAG, "updateLayoutStyle " + getPageSize());
        int pageSize = getPageSize();
        if (pageSize == 0) {
            TextView textView = this.mLayoutStyle;
            Intrinsics.checkNotNull(textView);
            textView.setText(getResources().getString(C9086R.string.page_layout_setting_portrait));
            ImageView imageView = this.mNormal;
            Intrinsics.checkNotNull(imageView);
            imageView.setSelected(true);
            ImageView imageView2 = this.mLandscape;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setSelected(false);
            ImageView imageView3 = this.mLong;
            Intrinsics.checkNotNull(imageView3);
            imageView3.setSelected(false);
        } else if (pageSize == 1) {
            TextView textView2 = this.mLayoutStyle;
            Intrinsics.checkNotNull(textView2);
            textView2.setText(getResources().getString(C9086R.string.page_layout_setting_long));
            ImageView imageView4 = this.mLong;
            Intrinsics.checkNotNull(imageView4);
            imageView4.setSelected(true);
            ImageView imageView5 = this.mNormal;
            Intrinsics.checkNotNull(imageView5);
            imageView5.setSelected(false);
            ImageView imageView6 = this.mLandscape;
            Intrinsics.checkNotNull(imageView6);
            imageView6.setSelected(false);
        } else if (pageSize == 2) {
            TextView textView3 = this.mLayoutStyle;
            Intrinsics.checkNotNull(textView3);
            textView3.setText(getResources().getString(C9086R.string.page_layout_setting_landscape));
            ImageView imageView7 = this.mLandscape;
            Intrinsics.checkNotNull(imageView7);
            imageView7.setSelected(true);
            ImageView imageView8 = this.mNormal;
            Intrinsics.checkNotNull(imageView8);
            imageView8.setSelected(false);
            ImageView imageView9 = this.mLong;
            Intrinsics.checkNotNull(imageView9);
            imageView9.setSelected(false);
        }
        ImageView imageView10 = this.mNormal;
        Intrinsics.checkNotNull(imageView10);
        setRippleNRecoilEffect(imageView10);
        ImageView imageView11 = this.mLandscape;
        Intrinsics.checkNotNull(imageView11);
        setRippleNRecoilEffect(imageView11);
        ImageView imageView12 = this.mLong;
        Intrinsics.checkNotNull(imageView12);
        setRippleNRecoilEffect(imageView12);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutSettingsMiniView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPageSize = -1;
        this.mIsLongEnabled = true;
        this.mIsLandscapeEnabled = true;
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutSettingsMiniView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPageSize = -1;
        this.mIsLongEnabled = true;
        this.mIsLandscapeEnabled = true;
        init(context);
    }
}
