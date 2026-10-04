package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenMiniLayout;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenResource;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenBaseView;
import com.samsung.android.sdk.pen.setting.pencommon.SpenSettingPenResource;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0000\u0018\u0000 <2\u00020\u0001:\u0002<=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020\u001aH\u0016J\u0006\u0010&\u001a\u00020\u001aJ\u001c\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0*J.\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0011J\u0010\u00102\u001a\u00020\u001a2\b\u00103\u001a\u0004\u0018\u00010\u0018J\u0016\u00104\u001a\u00020\u001a2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010*J\u001e\u00106\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\t2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00150*H\u0002J0\u00107\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0011H\u0002J\u0012\u00108\u001a\u0004\u0018\u00010\u00152\u0006\u0010,\u001a\u00020\tH\u0002J\b\u00109\u001a\u00020\u001aH\u0002J\b\u0010:\u001a\u00020\u001aH\u0002J\u0012\u0010;\u001a\u00020\u001a2\b\u0010,\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniPenControl;", "Lcom/samsung/android/sdk/pen/setting/SpenPenMiniViewControl;", "<init>", "()V", "mContext", "Landroid/content/Context;", "mViewMode", "", "mItemString", "", "mItemGroup", "Landroid/widget/FrameLayout;", "mPenItem", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenBaseView;", "mPenPopup", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenMiniLayout;", "mInitComplete", "", "mPenList", "", "mPenInfoList", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "mCurrentPen", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPenControl$OnDataChangedListener;", "setViewMode", "", "viewMode", "needAnimation", "getViewMode", "getNormalView", "Landroid/view/View;", "itemClickListener", "Landroid/view/View$OnClickListener;", "getPopupView", "setNormalViewTooltip", "enable", "clearView", "close", "initView", "context", "penNames", "", "setPenInfo", "penName", "color", "sizeLevel", "particleSize", "", "isFixedWidth", "setDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListPenInfo", "penInfoList", "makeMatchedPenInfo", "setCurrentPenInfo", "findMatchedPenInfo", "updatePenItem", "updatePenPopup", "notifyDataChanged", "Companion", "OnDataChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMiniPenControl extends SpenPenMiniViewControl {

    @NotNull
    private static final String TAG = "SpenPenControl";
    private Context mContext;

    @Nullable
    private SpenSettingPenInfo mCurrentPen;

    @Nullable
    private OnDataChangedListener mDataChangedListener;
    private boolean mInitComplete;

    @Nullable
    private FrameLayout mItemGroup;

    @Nullable
    private String mItemString;

    @Nullable
    private List<SpenSettingPenInfo> mPenInfoList;

    @Nullable
    private SpenPenBaseView mPenItem;

    @Nullable
    private List<String> mPenList;

    @Nullable
    private SpenPenMiniLayout mPenPopup;
    private int mViewMode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniPenControl$OnDataChangedListener;", "", "onPenChanged", "", "penName", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnDataChangedListener {
        void onPenChanged(@Nullable String penName);
    }

    private final SpenSettingPenInfo findMatchedPenInfo(String penName) {
        List<SpenSettingPenInfo> list = this.mPenInfoList;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            SpenSettingPenInfo spenSettingPenInfo = list.get(i);
            if (spenSettingPenInfo.name.compareTo(penName) == 0) {
                return spenSettingPenInfo;
            }
        }
        return null;
    }

    private final SpenSettingPenInfo makeMatchedPenInfo(String penName, List<? extends SpenSettingPenInfo> penInfoList) {
        for (SpenSettingPenInfo spenSettingPenInfo : penInfoList) {
            if (spenSettingPenInfo.name.compareTo(penName) == 0) {
                return new SpenSettingPenInfo(spenSettingPenInfo);
            }
        }
        SpenSettingPenInfo spenSettingPenInfo2 = new SpenSettingPenInfo();
        spenSettingPenInfo2.name = penName;
        return spenSettingPenInfo2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyDataChanged(String penName) {
        OnDataChangedListener onDataChangedListener = this.mDataChangedListener;
        if (onDataChangedListener != null) {
            onDataChangedListener.onPenChanged(penName);
        }
    }

    private final void setCurrentPenInfo(String penName, int color, int sizeLevel, float particleSize, boolean isFixedWidth) {
        if (this.mCurrentPen == null) {
            this.mCurrentPen = new SpenSettingUIPenInfo();
        }
        SpenSettingPenInfo spenSettingPenInfo = this.mCurrentPen;
        if (spenSettingPenInfo != null) {
            spenSettingPenInfo.name = penName;
            spenSettingPenInfo.color = color;
            spenSettingPenInfo.sizeLevel = sizeLevel;
            spenSettingPenInfo.particleSize = particleSize;
            spenSettingPenInfo.isFixedWidth = isFixedWidth;
        }
        SpenSettingPenInfo spenSettingPenInfoFindMatchedPenInfo = findMatchedPenInfo(penName);
        if (spenSettingPenInfoFindMatchedPenInfo != null) {
            spenSettingPenInfoFindMatchedPenInfo.color = color;
            spenSettingPenInfoFindMatchedPenInfo.sizeLevel = sizeLevel;
            spenSettingPenInfoFindMatchedPenInfo.particleSize = particleSize;
            spenSettingPenInfoFindMatchedPenInfo.isFixedWidth = isFixedWidth;
        }
    }

    private final void updatePenItem() {
        SpenPenBaseView spenPenBaseView;
        SpenSettingPenInfo spenSettingPenInfo = this.mCurrentPen;
        if (spenSettingPenInfo == null || (spenPenBaseView = this.mPenItem) == null) {
            return;
        }
        if (spenPenBaseView.getTag() == null || !Intrinsics.areEqual(spenSettingPenInfo.name, spenPenBaseView.getTag().toString())) {
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            SpenSettingPenResource penSettingResource = SpenPenResource.getPenSettingResource(context, spenSettingPenInfo.name);
            if (penSettingResource == null) {
                Log.i(TAG, "Not support Pen.");
                return;
            }
            spenPenBaseView.setPenResourceInfo(penSettingResource);
        }
        spenPenBaseView.setPenInfo(spenSettingPenInfo);
    }

    private final void updatePenPopup() {
        SpenPenMiniLayout spenPenMiniLayout;
        SpenSettingPenInfo spenSettingPenInfo = this.mCurrentPen;
        if (spenSettingPenInfo == null || (spenPenMiniLayout = this.mPenPopup) == null) {
            return;
        }
        spenPenMiniLayout.setPenInfo(spenSettingPenInfo);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewControl
    public void clearView() {
        Log.i(TAG, "clearView()");
        this.mPenItem = null;
        this.mItemGroup = null;
        SpenPenMiniLayout spenPenMiniLayout = this.mPenPopup;
        if (spenPenMiniLayout != null) {
            spenPenMiniLayout.close();
        }
        this.mPenPopup = null;
    }

    public final void close() {
        clearView();
        this.mInitComplete = false;
        this.mDataChangedListener = null;
        this.mPenList = null;
        this.mPenInfoList = null;
        this.mCurrentPen = null;
        this.mItemString = null;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    @Nullable
    public View getNormalView(@Nullable View.OnClickListener itemClickListener) {
        SpenPenBaseView spenPenBaseView;
        if (!this.mInitComplete) {
            return null;
        }
        if (this.mItemGroup == null) {
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            Object systemService = context.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            View viewInflate = ((LayoutInflater) systemService).inflate(getMViewOrientation() == 1 ? C7932R.layout.setting_mini_home_pen : C7932R.layout.setting_mini_home_pen_land, (ViewGroup) null);
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.FrameLayout");
            FrameLayout frameLayout = (FrameLayout) viewInflate;
            this.mPenItem = (SpenPenBaseView) frameLayout.findViewById(C7932R.id.mini_pen_item);
            this.mItemGroup = frameLayout;
            setNormalViewTooltip(true);
            SpenPenBaseView spenPenBaseView2 = this.mPenItem;
            if (spenPenBaseView2 != null) {
                spenPenBaseView2.setContentDescription(this.mItemString);
            }
            if (itemClickListener != null && (spenPenBaseView = this.mPenItem) != null) {
                spenPenBaseView.setOnClickListener(itemClickListener);
            }
        }
        updatePenItem();
        return this.mItemGroup;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    @Nullable
    public View getPopupView() {
        Context context = null;
        if (!this.mInitComplete) {
            return null;
        }
        if (this.mPenPopup == null) {
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context2;
            }
            SpenPenMiniLayout spenPenMiniLayout = new SpenPenMiniLayout(context, getMViewOrientation());
            this.mPenPopup = spenPenMiniLayout;
            spenPenMiniLayout.setPenList(this.mPenList);
            spenPenMiniLayout.setPenInfoList(this.mPenInfoList);
            spenPenMiniLayout.setActionListener(new SpenPenLayoutInterface.OnActionListener() { // from class: com.samsung.android.sdk.pen.setting.SpenMiniPenControl$getPopupView$1$1
                @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface.OnActionListener
                public void onPenClicked(String name, boolean isSelected) {
                    if (isSelected) {
                        return;
                    }
                    this.this$0.notifyDataChanged(name);
                }
            });
            updatePenPopup();
        }
        return this.mPenPopup;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    /* JADX INFO: renamed from: getViewMode, reason: from getter */
    public int getMViewMode() {
        return this.mViewMode;
    }

    public final void initView(@NotNull Context context, @NotNull List<String> penNames) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(penNames, "penNames");
        this.mContext = context;
        ArrayList arrayList = new ArrayList();
        this.mPenList = arrayList;
        arrayList.addAll(penNames);
        this.mItemString = context.getResources().getString(C7932R.string.pen_string_pen_type);
        this.mInitComplete = true;
    }

    public final void setDataChangedListener(@Nullable OnDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    public final void setListPenInfo(@Nullable List<? extends SpenSettingPenInfo> penInfoList) {
        List<? extends SpenSettingPenInfo> list;
        if (this.mPenInfoList == null) {
            this.mPenInfoList = new ArrayList();
        }
        List<SpenSettingPenInfo> list2 = this.mPenInfoList;
        if (list2 != null) {
            list2.clear();
        }
        if (this.mPenList == null || (list = penInfoList) == null || list.isEmpty()) {
            Log.i(TAG, "setListPenInfo() invalid status.");
            return;
        }
        List<String> list3 = this.mPenList;
        Intrinsics.checkNotNull(list3);
        for (String str : list3) {
            Intrinsics.checkNotNullExpressionValue(str, "next(...)");
            String str2 = str;
            List<SpenSettingPenInfo> list4 = this.mPenInfoList;
            if (list4 != null) {
                list4.add(makeMatchedPenInfo(str2, penInfoList));
            }
        }
        SpenPenMiniLayout spenPenMiniLayout = this.mPenPopup;
        if (spenPenMiniLayout != null) {
            spenPenMiniLayout.setPenInfoList(this.mPenInfoList);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    public void setNormalViewTooltip(boolean enable) {
        SpenPenBaseView spenPenBaseView = this.mPenItem;
        if (spenPenBaseView != null) {
            SpenSettingUtilHover.setHoverText(spenPenBaseView, enable ? this.mItemString : null);
        }
    }

    public final void setPenInfo(@NotNull String penName, int color, int sizeLevel, float particleSize, boolean isFixedWidth) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        if (this.mInitComplete) {
            setCurrentPenInfo(penName, color, sizeLevel, particleSize, isFixedWidth);
            if (this.mViewMode == 1) {
                updatePenItem();
                updatePenPopup();
            } else {
                updatePenPopup();
                updatePenItem();
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    public void setViewMode(int viewMode, boolean needAnimation) {
        if (this.mInitComplete && this.mViewMode != viewMode) {
            SpenPenMiniLayout spenPenMiniLayout = this.mPenPopup;
            if (spenPenMiniLayout != null) {
                spenPenMiniLayout.setVisibility(viewMode == 2 ? 0 : 8);
            }
            this.mViewMode = viewMode;
        }
    }
}
