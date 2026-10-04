package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText;
import com.samsung.android.sdk.pen.setting.remover.SpenRemoverLayout;
import com.samsung.android.sdk.pen.setting.remover.SpenRemoverViewCore;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u0000 @2\u00020\u0001:\u0003@ABB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010$\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011J+\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00052\u0016\u0010'\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010(0\u001e\"\u0004\u0018\u00010(¢\u0006\u0002\u0010)J \u0010*\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010-\u001a\u00020\u00132\b\u0010.\u001a\u0004\u0018\u00010,H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0002J\b\u00102\u001a\u00020\u0005H\u0002J\u001a\u00103\u001a\u00020\u00132\b\u00104\u001a\u0004\u0018\u00010\f2\u0006\u00105\u001a\u00020\u0005H\u0002J\b\u00106\u001a\u00020\u0013H\u0002J\u0018\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209H\u0002J\u0018\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0005H\u0002J\u0010\u0010?\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0005H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR4\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001e2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006C"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingRemoverPanel;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "supportHighlighterOnly", "", "supportRemoverType", "<init>", "(Landroid/content/Context;ZZ)V", "mViewCore", "Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverViewCore;", "mClearAllButton", "Landroid/view/View;", "mClearAllDivider", "mRemoverInfoChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingRemoverPanel$RemoverInfoChangedListener;", "mEraseAllListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingRemoverPanel$EraseAllListener;", "close", "", "settingCutterInfo", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "info", "getInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "setInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;)V", "setRemoverInfoChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "value", "", "removerInfoList", "getRemoverInfoList", "()[Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "setRemoverInfoList", "([Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;)V", "setEraseAllListener", "setPageMenu", "isVisible", "menuList", "", "(Z[Ljava/lang/String;)V", "construct", "initView", "Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverLayout;", "setListener", "removerLayout", "getTransition", "Landroid/transition/TransitionSet;", "isNeedExpend", "initClearAll", "initEraseAllMenu", "menuView", "add", "notifyDataChanged", "notifyEraseAll", "type", "", "index", "updatePreview", "size", "", "animation", "setPreviewVisibility", "Companion", "RemoverInfoChangedListener", "EraseAllListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public final class SpenSettingRemoverPanel extends FrameLayout {
    public static final int ERASE_ALL_TYPE_CUSTOM_DEFINE = 1;
    public static final int ERASE_ALL_TYPE_TOTAL_PAGE = 0;

    @NotNull
    private static final String TAG = "SpenSettingRemoverPanel";

    @Nullable
    private View mClearAllButton;

    @Nullable
    private View mClearAllDivider;

    @Nullable
    private EraseAllListener mEraseAllListener;

    @Nullable
    private RemoverInfoChangedListener mRemoverInfoChangedListener;

    @Nullable
    private SpenRemoverViewCore mViewCore;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingRemoverPanel$EraseAllListener;", "", "onEraseAll", "", "type", "", "index", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface EraseAllListener {
        void onEraseAll(int type, int index);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingRemoverPanel$RemoverInfoChangedListener;", "", "onRemoverInfoChanged", "", "info", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface RemoverInfoChangedListener {
        void onRemoverInfoChanged(@Nullable SpenSettingRemoverInfo info);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingRemoverPanel(@NotNull Context context, boolean z, boolean z2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context, z, z2);
    }

    private final void construct(Context context, boolean supportHighlighterOnly, boolean supportRemoverType) {
        Log.i(TAG, "construct");
        this.mViewCore = new SpenRemoverViewCore(context, supportHighlighterOnly, supportRemoverType);
        setListener(initView(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TransitionSet getTransition(boolean isNeedExpend) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        if (isNeedExpend) {
            transitionSet.addTransition(new ChangeBounds().setDuration(333L).setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.3f, 1.0f)));
            return transitionSet;
        }
        transitionSet.addTransition(new ChangeBounds().setDuration(333L).setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.3f, 1.0f)).setStartDelay(150L));
        return transitionSet;
    }

    private final boolean initClearAll() {
        SpenRemoverViewCore spenRemoverViewCore;
        View viewFindViewById = findViewById(C7932R.id.remover_body_erase_all);
        this.mClearAllButton = viewFindViewById;
        if (viewFindViewById == null || (spenRemoverViewCore = this.mViewCore) == null) {
            return false;
        }
        if (spenRemoverViewCore != null) {
            View viewFindViewById2 = findViewById(C7932R.id.remover_body_erase_all_text);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText");
            spenRemoverViewCore.initClearAll(viewFindViewById, (SpenShowButtonShapeText) viewFindViewById2);
        }
        SpenRemoverViewCore spenRemoverViewCore2 = this.mViewCore;
        if (spenRemoverViewCore2 != null) {
            spenRemoverViewCore2.setEraseAllListener(new SpenRemoverViewCore.EraseAllListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingRemoverPanel.initClearAll.1
                @Override // com.samsung.android.sdk.pen.setting.remover.SpenRemoverViewCore.EraseAllListener
                public void onEraseAll(SpenRemoverViewCore.EraseType type, int index) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    int i = type == SpenRemoverViewCore.EraseType.CUSTOM_DEFINE ? 1 : 0;
                    SpenRemoverViewCore spenRemoverViewCore3 = SpenSettingRemoverPanel.this.mViewCore;
                    if (spenRemoverViewCore3 != null) {
                        spenRemoverViewCore3.hideEraseAllOption(true);
                    }
                    SpenSettingRemoverPanel.this.notifyEraseAll(i, index);
                }
            });
        }
        SpenRemoverViewCore spenRemoverViewCore3 = this.mViewCore;
        if (spenRemoverViewCore3 != null) {
            spenRemoverViewCore3.setCustomMenuListener(new SpenRemoverViewCore.CustomMenuListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingRemoverPanel.initClearAll.2
                @Override // com.samsung.android.sdk.pen.setting.remover.SpenRemoverViewCore.CustomMenuListener
                public void onCrateMenu(View view) {
                    SpenSettingRemoverPanel.this.initEraseAllMenu(view, true);
                }

                @Override // com.samsung.android.sdk.pen.setting.remover.SpenRemoverViewCore.CustomMenuListener
                public void onPrepareMenuPosition(View view) {
                    SpenSettingRemoverPanel.this.initEraseAllMenu(view, false);
                }
            });
        }
        View viewFindViewById3 = findViewById(C7932R.id.remover_body_erase_all_divider);
        this.mClearAllDivider = viewFindViewById3;
        if (viewFindViewById3 != null) {
            SpenRemoverViewCore spenRemoverViewCore4 = this.mViewCore;
            viewFindViewById3.setVisibility((spenRemoverViewCore4 == null || !spenRemoverViewCore4.getIsSupportHighlighterOnly()) ? 8 : 0);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initEraseAllMenu(View menuView, boolean add) {
        if (menuView == null) {
            return;
        }
        if (add) {
            addView(menuView, new FrameLayout.LayoutParams(getWidth(), getHeight()));
            menuView.setBackground(null);
            return;
        }
        ViewGroup.LayoutParams layoutParams = menuView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = getWidth();
        layoutParams2.height = getHeight();
        menuView.setLayoutParams(layoutParams2);
    }

    private final SpenRemoverLayout initView(Context context) {
        View.inflate(context, C7932R.layout.setting_remover_panel, this);
        TextView textView = (TextView) findViewById(C7932R.id.remover_title);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        SpenSettingUtilText.setDefaultButtonTextStyle(context2, textView);
        SpenSettingUtilText.applyUpToLargeLevel(getContext(), 19.0f, textView);
        SpenRemoverLayout spenRemoverLayout = (SpenRemoverLayout) findViewById(C7932R.id.setting_remover_body_layout);
        SpenRemoverViewCore spenRemoverViewCore = this.mViewCore;
        if (spenRemoverViewCore == null) {
            return null;
        }
        if (spenRemoverViewCore != null) {
            spenRemoverViewCore.initRemoverLayout(spenRemoverLayout, true);
        }
        Resources resources = context.getResources();
        SpenRemoverViewCore spenRemoverViewCore2 = this.mViewCore;
        View preview = spenRemoverViewCore2 != null ? spenRemoverViewCore2.getPreview() : null;
        if (preview != null) {
            preview.setPadding(0, resources.getDimensionPixelSize(C7932R.dimen.remover_preview_top_padding), 0, 0);
        }
        if (preview != null) {
            preview.setClipToOutline(true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(C7932R.dimen.remover_preview_height));
        ViewGroup viewGroup = (ViewGroup) findViewById(C7932R.id.remover_panel_content);
        if (viewGroup == null) {
            return null;
        }
        viewGroup.addView(preview, 2, layoutParams);
        setPreviewVisibility(false);
        return spenRemoverLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyDataChanged() {
        SpenRemoverViewCore spenRemoverViewCore;
        SpenSettingRemoverInfo info;
        Log.i(TAG, "notifyDataChanged() changedListener=".concat(this.mRemoverInfoChangedListener != null ? "NOT NULL" : "NULL"));
        if (this.mRemoverInfoChangedListener == null || (spenRemoverViewCore = this.mViewCore) == null || spenRemoverViewCore == null || (info = spenRemoverViewCore.getInfo()) == null) {
            return;
        }
        Log.i(TAG, "notifyDataChanged() to listener type=" + info.type + " size=" + info.size);
        RemoverInfoChangedListener removerInfoChangedListener = this.mRemoverInfoChangedListener;
        if (removerInfoChangedListener != null) {
            removerInfoChangedListener.onRemoverInfoChanged(info);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyEraseAll(int type, int index) {
        AbstractC11014a.m12328m(type, "==== onClearAll(", ")", TAG);
        EraseAllListener eraseAllListener = this.mEraseAllListener;
        if (eraseAllListener != null) {
            eraseAllListener.onEraseAll(type, index);
        }
    }

    private final void setListener(SpenRemoverLayout removerLayout) {
        if (removerLayout == null) {
            return;
        }
        removerLayout.setActionListener(new SpenRemoverLayout.OnActionListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingRemoverPanel.setListener.1
            @Override // com.samsung.android.sdk.pen.setting.remover.SpenRemoverLayout.OnActionListener
            public void onSizeChanged(float size) {
                AbstractC4539a.m3205o("onSizeChanged size=", SpenSettingRemoverPanel.TAG, size);
                SpenSettingRemoverPanel.this.updatePreview(size, true);
                SpenSettingRemoverPanel.this.notifyDataChanged();
            }

            @Override // com.samsung.android.sdk.pen.setting.remover.SpenRemoverLayout.OnActionListener
            public void onTargetChanged(int target) {
                AbstractC2322a.m1631u(target, "onTargetChanged target= ", SpenSettingRemoverPanel.TAG);
                SpenSettingRemoverPanel.this.notifyDataChanged();
            }

            @Override // com.samsung.android.sdk.pen.setting.remover.SpenRemoverLayout.OnActionListener
            public void onTypeChanged(int type) {
                AbstractC2322a.m1631u(type, "onTypeChanged typeId =", SpenSettingRemoverPanel.TAG);
                boolean z = type == 0;
                SpenSettingRemoverPanel.this.setPreviewVisibility(z);
                if (SpenSettingRemoverPanel.this.getParent() != null && SpenSettingRemoverPanel.this.getParent().getParent() != null) {
                    ViewParent parent = SpenSettingRemoverPanel.this.getParent().getParent();
                    Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    TransitionManager.beginDelayedTransition((ViewGroup) parent, SpenSettingRemoverPanel.this.getTransition(z));
                }
                SpenSettingRemoverPanel.this.notifyDataChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPreviewVisibility(boolean isVisible) {
        SpenRemoverViewCore spenRemoverViewCore = this.mViewCore;
        if (spenRemoverViewCore != null) {
            spenRemoverViewCore.setPreviewVisibility(isVisible);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePreview(float size, boolean animation) {
        SpenRemoverViewCore spenRemoverViewCore = this.mViewCore;
        if (spenRemoverViewCore != null) {
            spenRemoverViewCore.updatePreview(size, animation);
        }
    }

    public final void close() {
        SpenRemoverViewCore spenRemoverViewCore = this.mViewCore;
        if (spenRemoverViewCore != null) {
            spenRemoverViewCore.close();
        }
        this.mViewCore = null;
    }

    @Nullable
    public final SpenSettingRemoverInfo getInfo() {
        SpenSettingRemoverInfo info;
        SpenRemoverViewCore spenRemoverViewCore = this.mViewCore;
        return (spenRemoverViewCore == null || (info = spenRemoverViewCore.getInfo()) == null) ? new SpenSettingRemoverInfo() : info;
    }

    @Nullable
    public final SpenSettingRemoverInfo[] getRemoverInfoList() {
        SpenRemoverViewCore spenRemoverViewCore = this.mViewCore;
        if (spenRemoverViewCore != null) {
            return spenRemoverViewCore.getRemoverInfoList();
        }
        return null;
    }

    public final void setEraseAllListener(@Nullable EraseAllListener listener) {
        this.mEraseAllListener = listener;
        if (listener != null) {
            initClearAll();
        }
    }

    public final void setInfo(@Nullable SpenSettingRemoverInfo spenSettingRemoverInfo) {
        SpenRemoverViewCore spenRemoverViewCore;
        if (spenSettingRemoverInfo == null || (spenRemoverViewCore = this.mViewCore) == null) {
            return;
        }
        if (spenRemoverViewCore != null) {
            spenRemoverViewCore.setInfo(spenSettingRemoverInfo);
        }
        if (spenSettingRemoverInfo.type != 0) {
            setPreviewVisibility(false);
        } else {
            setPreviewVisibility(true);
            updatePreview(spenSettingRemoverInfo.size, false);
        }
    }

    public final void setPageMenu(boolean isVisible, @NotNull String... menuList) {
        Intrinsics.checkNotNullParameter(menuList, "menuList");
        SpenRemoverViewCore spenRemoverViewCore = this.mViewCore;
        if (spenRemoverViewCore != null) {
            spenRemoverViewCore.setPageMenu(isVisible, (String[]) Arrays.copyOf(menuList, menuList.length));
        }
    }

    public final void setRemoverInfoChangedListener(@Nullable RemoverInfoChangedListener listener) {
        this.mRemoverInfoChangedListener = listener;
    }

    public final void setRemoverInfoList(@Nullable SpenSettingRemoverInfo[] spenSettingRemoverInfoArr) {
        SpenRemoverViewCore spenRemoverViewCore = this.mViewCore;
        if (spenRemoverViewCore != null) {
            spenRemoverViewCore.setRemoverInfoList(spenSettingRemoverInfoArr);
        }
    }
}
