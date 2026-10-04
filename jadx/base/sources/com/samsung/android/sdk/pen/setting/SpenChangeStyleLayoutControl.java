package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.common.SpenTabGroup;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fJ\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J,\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u000fJ\u0010\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010\u0005J\u0012\u0010&\u001a\u0004\u0018\u00010\u00072\b\u0010'\u001a\u0004\u0018\u00010(J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006."}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenChangeStyleLayoutControl;", "", "<init>", "()V", "mModeChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenChangeStyleLayoutControl$ModeChangedListener;", "mSizeView", "Landroid/view/View;", "mColorView", "mNoFillView", "mTabGroup", "Lcom/samsung/android/sdk/pen/setting/common/SpenTabGroup;", "mTabParent", "Landroid/widget/LinearLayout;", "mViewMode", "", "mActionButtonManager", "Lcom/samsung/android/sdk/pen/setting/SpenActionButtonManager;", "mModeSupportTopMargin", "mModeNotSupportTopMargin", "close", "", "changeViewMode", "", "viewMode", "adjustMargin", "setContentView", "contentBody", "sizeView", "colorView", "noFillView", "setMode", "mode", "setModeChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "actionButtonCount", "getActionButtonCount", "()I", "addActionButton", "text", "", "initTabView", "parent", "Landroid/view/ViewGroup;", "Companion", "ModeChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
@SourceDebugExtension({"SMAP\nSpenChangeStyleLayoutControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenChangeStyleLayoutControl.kt\ncom/samsung/android/sdk/pen/setting/SpenChangeStyleLayoutControl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,170:1\n1#2:171\n*E\n"})
public final class SpenChangeStyleLayoutControl {
    public static final int NOT_SUPPORT_MODE_CHANGE = 2;
    public static final int SUPPORT_MODE_CHANGE = 1;

    @NotNull
    private static final String TAG = "SpenChangeStyleLayoutControl";

    @NotNull
    private final SpenActionButtonManager mActionButtonManager = new SpenActionButtonManager();

    @Nullable
    private View mColorView;

    @Nullable
    private ModeChangedListener mModeChangedListener;
    private int mModeNotSupportTopMargin;
    private int mModeSupportTopMargin;

    @Nullable
    private View mNoFillView;

    @Nullable
    private View mSizeView;

    @Nullable
    private SpenTabGroup mTabGroup;

    @Nullable
    private LinearLayout mTabParent;
    private int mViewMode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenChangeStyleLayoutControl$ModeChangedListener;", "", "onModeChanged", "", "mode", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ModeChangedListener {
        void onModeChanged(int mode);
    }

    private final void adjustMargin(int viewMode) {
        View view;
        View view2 = this.mSizeView;
        if (view2 == null || (view = this.mNoFillView) == null) {
            return;
        }
        int i = viewMode == 1 ? this.mModeSupportTopMargin : this.mModeNotSupportTopMargin;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = i;
        view2.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
        layoutParams4.topMargin = i;
        view.setLayoutParams(layoutParams4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initTabView(ViewGroup parent) {
        LinearLayout linearLayout;
        Object systemService = parent.getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(C7932R.layout.setting_change_style_mode_tab, parent, true);
        this.mTabParent = (LinearLayout) parent.findViewById(C7932R.id.change_style_mode_tabs);
        this.mTabGroup = new SpenTabGroup();
        LinearLayout linearLayout2 = this.mTabParent;
        View viewFindViewById = linearLayout2 != null ? linearLayout2.findViewById(C7932R.id.tab_stroke) : null;
        LinearLayout linearLayout3 = this.mTabParent;
        View viewFindViewById2 = linearLayout3 != null ? linearLayout3.findViewById(C7932R.id.tab_fill) : null;
        Context context = parent.getContext();
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        SpenSettingUtilText.applyUpToLargeLevel(context, 15.0f, viewFindViewById, viewFindViewById2);
        SpenTabGroup spenTabGroup = this.mTabGroup;
        if (spenTabGroup != null) {
            spenTabGroup.addTab(viewFindViewById);
        }
        SpenTabGroup spenTabGroup2 = this.mTabGroup;
        if (spenTabGroup2 != null) {
            spenTabGroup2.addTab(viewFindViewById2);
        }
        SpenTabGroup spenTabGroup3 = this.mTabGroup;
        if (spenTabGroup3 != null) {
            spenTabGroup3.setOnTabSelectedListener(new SpenTabGroup.OnTabSelectedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenChangeStyleLayoutControl.initTabView.1
                @Override // com.samsung.android.sdk.pen.setting.common.SpenTabGroup.OnTabSelectedListener
                public void onTabSelected(View tab) {
                    ModeChangedListener modeChangedListener;
                    Log.i(SpenChangeStyleLayoutControl.TAG, "(1) onTabSelected() ");
                    if (tab == null || (modeChangedListener = SpenChangeStyleLayoutControl.this.mModeChangedListener) == null) {
                        return;
                    }
                    modeChangedListener.onModeChanged(tab.getId() == C7932R.id.tab_stroke ? 0 : 1);
                }

                @Override // com.samsung.android.sdk.pen.setting.common.SpenTabGroup.OnTabSelectedListener
                public void onTabReselected(View tab) {
                }

                @Override // com.samsung.android.sdk.pen.setting.common.SpenTabGroup.OnTabSelectedListener
                public void onTabUnselected(View tab) {
                }
            });
        }
        int i = this.mViewMode;
        if (i == 0 || (linearLayout = this.mTabParent) == null) {
            return;
        }
        linearLayout.setVisibility(i != 1 ? 8 : 0);
    }

    @Nullable
    public final View addActionButton(@Nullable CharSequence text) {
        Log.i(TAG, "addActionButton()");
        if (text != null) {
            return this.mActionButtonManager.addButton(text);
        }
        return null;
    }

    public final boolean changeViewMode(int viewMode) {
        if ((viewMode != 1 && viewMode != 2) || this.mViewMode == viewMode) {
            return false;
        }
        this.mViewMode = viewMode;
        LinearLayout linearLayout = this.mTabParent;
        if (linearLayout != null) {
            linearLayout.setVisibility(viewMode != 1 ? 8 : 0);
        }
        adjustMargin(viewMode);
        return true;
    }

    public final void close() {
        SpenTabGroup spenTabGroup = this.mTabGroup;
        if (spenTabGroup != null) {
            spenTabGroup.close();
        }
        this.mTabGroup = null;
        this.mSizeView = null;
        this.mColorView = null;
        this.mNoFillView = null;
    }

    public final int getActionButtonCount() {
        return this.mActionButtonManager.getButtonCount();
    }

    public final void setContentView(@NotNull LinearLayout contentBody, @Nullable View sizeView, @Nullable View colorView, @Nullable View noFillView) {
        Intrinsics.checkNotNullParameter(contentBody, "contentBody");
        initTabView(contentBody);
        this.mSizeView = sizeView;
        this.mColorView = colorView;
        this.mNoFillView = noFillView;
        Resources resources = contentBody.getContext().getResources();
        this.mModeSupportTopMargin = resources.getDimensionPixelSize(C7932R.dimen.setting_change_style_view_mode_extend_margin_top);
        this.mModeNotSupportTopMargin = resources.getDimensionPixelSize(C7932R.dimen.setting_change_style_view_mode_basic_margin_top);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mModeNotSupportTopMargin;
        contentBody.addView(this.mSizeView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(C7932R.dimen.setting_change_style_black_shape_height));
        layoutParams2.topMargin = this.mModeNotSupportTopMargin;
        contentBody.addView(this.mNoFillView, layoutParams2);
        contentBody.addView(this.mColorView, new LinearLayout.LayoutParams(-1, -2));
        this.mActionButtonManager.setContentView(contentBody);
        contentBody.setPadding(contentBody.getPaddingLeft(), contentBody.getPaddingTop(), contentBody.getPaddingRight(), resources.getDimensionPixelSize(C7932R.dimen.setting_pen_layout_content_padding_bottom));
    }

    public final void setMode(int mode) {
        int i;
        int i2 = C7932R.id.tab_stroke;
        int i4 = 8;
        if (mode == 1) {
            i2 = C7932R.id.tab_fill;
            i = 0;
        } else {
            i = 8;
            i4 = 0;
        }
        SpenTabGroup spenTabGroup = this.mTabGroup;
        if (spenTabGroup != null) {
            spenTabGroup.select(i2);
        }
        View view = this.mSizeView;
        if (view != null) {
            view.setVisibility(i4);
        }
        View view2 = this.mNoFillView;
        if (view2 != null) {
            view2.setVisibility(i);
        }
        View view3 = this.mColorView;
        if (view3 != null) {
            view3.setVisibility(0);
        }
    }

    public final void setModeChangedListener(@Nullable ModeChangedListener listener) {
        this.mModeChangedListener = listener;
    }
}
