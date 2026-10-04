package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.SpenPatternControl;
import com.samsung.android.sdk.pen.setting.patternpalette.SpenRectPatternLayout;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u0000 62\u00020\u00012\u00020\u0002:\u000267B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\nH\u0016J\b\u0010%\u001a\u00020\u001aH\u0016J\u0006\u0010&\u001a\u00020\u001aJ\u0018\u0010'\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010\f2\u0006\u0010)\u001a\u00020\u000eJ\u0010\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010\u0018J\b\u0010,\u001a\u00020\u001aH\u0002J\b\u00102\u001a\u00020\u001aH\u0002J\b\u00103\u001a\u00020\u001aH\u0002J\u0010\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u0010/¨\u00068"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniPatternControl;", "Lcom/samsung/android/sdk/pen/setting/SpenPenMiniViewControl;", "Lcom/samsung/android/sdk/pen/setting/SpenPenMiniViewModeInterface;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mViewMode", "", "mInitComplete", "", "mPenName", "", "mSize", "", "mNormalView", "Landroid/widget/FrameLayout;", "mPatternItem", "Landroid/widget/ImageView;", "mPatternPopup", "Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenRectPatternLayout;", "mPatternControl", "Lcom/samsung/android/sdk/pen/setting/SpenPatternControl;", "mPatternChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPatternControl$OnPatternChangedListener;", "setViewMode", "", "viewMode", "needAnimation", "getViewMode", "getNormalView", "Landroid/view/View;", "itemClickListener", "Landroid/view/View$OnClickListener;", "getPopupView", "setNormalViewTooltip", "enable", "clearView", "close", "setPatternInfo", "penName", "size", "setOnPatternChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initControl", "itemResource", "getItemResource", "()I", "popupResource", "getPopupResource", "updatePatternItem", "updatePatternPopup", "getDrawableId", "drawable", "Companion", "OnPatternChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMiniPatternControl extends SpenPenMiniViewControl implements SpenPenMiniViewModeInterface {

    @NotNull
    private static final String TAG = "SpenMiniPatternControl";

    @NotNull
    private Context mContext;
    private boolean mInitComplete;

    @Nullable
    private FrameLayout mNormalView;

    @Nullable
    private OnPatternChangedListener mPatternChangedListener;
    private SpenPatternControl mPatternControl;

    @Nullable
    private ImageView mPatternItem;

    @Nullable
    private SpenRectPatternLayout mPatternPopup;

    @Nullable
    private String mPenName;
    private float mSize;
    private int mViewMode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniPatternControl$OnPatternChangedListener;", "Lcom/samsung/android/sdk/pen/setting/SpenPatternControl$OnPatternChangeListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnPatternChangedListener extends SpenPatternControl.OnPatternChangeListener {
    }

    public SpenMiniPatternControl(@NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        initControl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getDrawableId(String drawable) {
        int identifier = this.mContext.getResources().getIdentifier(drawable, "drawable", this.mContext.getPackageName());
        if (identifier == 0) {
            Log.e(TAG, "Resource is not founded");
        }
        return identifier;
    }

    private final int getItemResource() {
        return getMViewOrientation() == 0 ? C7932R.layout.setting_pen_color_attr_mini_land_layout : C7932R.layout.setting_pen_color_attr_mini_layout;
    }

    private final int getPopupResource() {
        return getMViewOrientation() == 0 ? C7932R.layout.setting_mini_color_land_layout : C7932R.layout.setting_mini_color_layout;
    }

    private final void initControl() {
        SpenPatternControl spenPatternControl = new SpenPatternControl();
        this.mPatternControl = spenPatternControl;
        spenPatternControl.setOnPatternChangedListener(new SpenPatternControl.OnPatternChangeListener() { // from class: com.samsung.android.sdk.pen.setting.SpenMiniPatternControl.initControl.1
            @Override // com.samsung.android.sdk.pen.setting.SpenPatternControl.OnPatternChangeListener
            public void onPatternChanged(String resName, float size) {
                if (resName == null) {
                    return;
                }
                SpenMiniPatternControl.this.mSize = size;
                ImageView imageView = SpenMiniPatternControl.this.mPatternItem;
                if (imageView != null) {
                    imageView.setBackgroundResource(SpenMiniPatternControl.this.getDrawableId(resName));
                }
                OnPatternChangedListener onPatternChangedListener = SpenMiniPatternControl.this.mPatternChangedListener;
                if (onPatternChangedListener != null) {
                    onPatternChangedListener.onPatternChanged(resName, size);
                }
            }
        });
        this.mInitComplete = true;
    }

    private final void updatePatternItem() {
        ImageView imageView;
        if (this.mPenName == null || this.mPatternItem == null) {
            return;
        }
        SpenPatternControl spenPatternControl = this.mPatternControl;
        if (spenPatternControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPatternControl");
            spenPatternControl = null;
        }
        String resourceString = spenPatternControl.getResourceString(this.mPenName, this.mSize);
        if (resourceString == null || (imageView = this.mPatternItem) == null) {
            return;
        }
        imageView.setBackgroundResource(getDrawableId(resourceString));
    }

    private final void updatePatternPopup() {
        if (this.mPatternPopup == null || this.mPenName == null) {
            return;
        }
        SpenPatternControl spenPatternControl = this.mPatternControl;
        SpenPatternControl spenPatternControl2 = null;
        if (spenPatternControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPatternControl");
            spenPatternControl = null;
        }
        spenPatternControl.setPattern(this.mPenName);
        SpenPatternControl spenPatternControl3 = this.mPatternControl;
        if (spenPatternControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPatternControl");
        } else {
            spenPatternControl2 = spenPatternControl3;
        }
        spenPatternControl2.setSize(this.mSize, false);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewControl
    public void clearView() {
        SpenRectPatternLayout spenRectPatternLayout = this.mPatternPopup;
        if (spenRectPatternLayout != null) {
            spenRectPatternLayout.close();
        }
        this.mPatternPopup = null;
        this.mPatternItem = null;
        this.mNormalView = null;
    }

    public final void close() {
        this.mViewMode = 0;
        if (this.mInitComplete) {
            SpenRectPatternLayout spenRectPatternLayout = this.mPatternPopup;
            if (spenRectPatternLayout != null) {
                spenRectPatternLayout.close();
            }
            this.mPatternPopup = null;
            this.mPatternItem = null;
            this.mInitComplete = false;
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    @Nullable
    public View getNormalView(@Nullable View.OnClickListener itemClickListener) {
        if (!this.mInitComplete) {
            return null;
        }
        if (this.mNormalView == null) {
            Object systemService = this.mContext.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            View viewInflate = ((LayoutInflater) systemService).inflate(getItemResource(), (ViewGroup) null);
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.FrameLayout");
            FrameLayout frameLayout = (FrameLayout) viewInflate;
            ImageView imageView = (ImageView) frameLayout.findViewById(C7932R.id.color_item);
            this.mPatternItem = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(itemClickListener);
            }
            this.mNormalView = frameLayout;
        }
        updatePatternItem();
        return this.mNormalView;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    @Nullable
    public View getPopupView() {
        SpenPatternControl spenPatternControl = null;
        if (!this.mInitComplete) {
            return null;
        }
        if (this.mPatternPopup == null) {
            SpenRectPatternLayout spenRectPatternLayout = new SpenRectPatternLayout(this.mContext, getPopupResource());
            this.mPatternPopup = spenRectPatternLayout;
            spenRectPatternLayout.setBackgroundResource(C7932R.drawable.setting_mini_sub_popup_bg);
            SpenPatternControl spenPatternControl2 = this.mPatternControl;
            if (spenPatternControl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPatternControl");
            } else {
                spenPatternControl = spenPatternControl2;
            }
            spenPatternControl.setPatternLayout(this.mPatternPopup);
        }
        updatePatternPopup();
        return this.mPatternPopup;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    /* JADX INFO: renamed from: getViewMode, reason: from getter */
    public int getMViewMode() {
        return this.mViewMode;
    }

    public final void setOnPatternChangedListener(@Nullable OnPatternChangedListener listener) {
        this.mPatternChangedListener = listener;
    }

    public final void setPatternInfo(@Nullable String penName, float size) {
        if (this.mInitComplete) {
            this.mPenName = penName;
            this.mSize = size;
            if (this.mViewMode == 1) {
                updatePatternItem();
                updatePatternPopup();
            } else {
                updatePatternPopup();
                updatePatternItem();
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    public void setViewMode(int viewMode, boolean needAnimation) {
        if (this.mInitComplete && this.mViewMode != viewMode) {
            SpenRectPatternLayout spenRectPatternLayout = this.mPatternPopup;
            if (spenRectPatternLayout != null) {
                spenRectPatternLayout.setVisibility(viewMode == 2 ? 0 : 8);
            }
            this.mViewMode = viewMode;
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    public void setNormalViewTooltip(boolean enable) {
    }
}
