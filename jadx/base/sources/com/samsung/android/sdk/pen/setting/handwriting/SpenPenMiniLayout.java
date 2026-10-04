package com.samsung.android.sdk.pen.setting.handwriting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.setting.common.SpenRoundLayout;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenMiniAdapter;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenPopupControl;
import com.samsung.android.spen.C7932R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u00152\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0015H\u0016J\u0012\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u001eH\u0002J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u0006H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenMiniLayout;", "Lcom/samsung/android/sdk/pen/setting/common/SpenRoundLayout;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenLayoutInterface;", "context", "Landroid/content/Context;", "orientation", "", "<init>", "(Landroid/content/Context;I)V", "mPenPopupControl", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenPopupControl;", "mPenList", "Landroidx/recyclerview/widget/RecyclerView;", "mPenAdapter", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenMiniAdapter;", "mPenLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mOrientation", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenLayoutInterface$OnActionListener;", "close", "", "setPenList", "penNames", "", "", "setPenInfoList", "penInfoList", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setPenInfo", "", "penInfo", "getSelectedPenPosition", "setUnselectedPen", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "construct", "notifyPenClicked", "penName", "isSelected", "getLayoutId", "decideRadiusDir", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenPopupControl$RadiusDir;", "getItemId", "setPenFocus", "index", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public final class SpenPenMiniLayout extends SpenRoundLayout implements SpenPenLayoutInterface {
    public static final int HORIZONTAL = 0;

    @NotNull
    private static final String TAG = "SpenPenMiniLayout";
    public static final int VERTICAL = 1;

    @Nullable
    private SpenPenLayoutInterface.OnActionListener mActionListener;
    private int mOrientation;

    @Nullable
    private SpenPenMiniAdapter mPenAdapter;

    @Nullable
    private LinearLayoutManager mPenLayoutManager;

    @Nullable
    private RecyclerView mPenList;

    @Nullable
    private SpenPenPopupControl mPenPopupControl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenMiniLayout(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context, i);
    }

    private final void construct(Context context, int orientation) {
        this.mOrientation = orientation;
        LayoutInflater.from(context).inflate(getLayoutId(orientation), (ViewGroup) this, true);
        SpenPenPopupControl spenPenPopupControl = new SpenPenPopupControl(context);
        this.mPenPopupControl = spenPenPopupControl;
        Intrinsics.checkNotNull(spenPenPopupControl);
        spenPenPopupControl.initView(this, null, decideRadiusDir(orientation));
        SpenPenPopupControl spenPenPopupControl2 = this.mPenPopupControl;
        Intrinsics.checkNotNull(spenPenPopupControl2);
        float topLeftRadius = spenPenPopupControl2.getTopLeftRadius();
        SpenPenPopupControl spenPenPopupControl3 = this.mPenPopupControl;
        Intrinsics.checkNotNull(spenPenPopupControl3);
        float topRightRadius = spenPenPopupControl3.getTopRightRadius();
        SpenPenPopupControl spenPenPopupControl4 = this.mPenPopupControl;
        Intrinsics.checkNotNull(spenPenPopupControl4);
        float bottomRightRadius = spenPenPopupControl4.getBottomRightRadius();
        Intrinsics.checkNotNull(this.mPenPopupControl);
        setRadius(topLeftRadius, topRightRadius, bottomRightRadius, r3.getBottomLeftRadius());
        this.mPenList = (RecyclerView) findViewById(C7932R.id.mini_pen_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, orientation, false);
        this.mPenLayoutManager = linearLayoutManager;
        RecyclerView recyclerView = this.mPenList;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
    }

    private final SpenPenPopupControl.RadiusDir decideRadiusDir(int orientation) {
        return orientation == 0 ? SpenPenPopupControl.RadiusDir.RADIUS_DIR_START : SpenPenPopupControl.RadiusDir.RADIUS_DIR_TOP;
    }

    private final int getItemId(int orientation) {
        return orientation == 0 ? C7932R.layout.setting_mini_pen_item_land_view : C7932R.layout.setting_mini_pen_item_view;
    }

    private final int getLayoutId(int orientation) {
        return orientation == 0 ? C7932R.layout.setting_mini_pen_land_layout : C7932R.layout.setting_mini_pen_layout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyPenClicked(String penName, boolean isSelected) {
        SpenPenLayoutInterface.OnActionListener onActionListener = this.mActionListener;
        if (onActionListener != null) {
            onActionListener.onPenClicked(penName, isSelected);
        }
    }

    private final void setPenFocus(int index) {
        RecyclerView recyclerView;
        AbstractC2322a.m1631u(index, "setPenFocus() index=", TAG);
        if (index == -1) {
            return;
        }
        LinearLayoutManager linearLayoutManager = this.mPenLayoutManager;
        int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager != null ? linearLayoutManager.findFirstCompletelyVisibleItemPosition() : -1;
        LinearLayoutManager linearLayoutManager2 = this.mPenLayoutManager;
        int iFindLastCompletelyVisibleItemPosition = linearLayoutManager2 != null ? linearLayoutManager2.findLastCompletelyVisibleItemPosition() : -1;
        Log.i(TAG, AbstractC0622a.m1164j(iFindFirstCompletelyVisibleItemPosition, iFindLastCompletelyVisibleItemPosition, "Visible[", "~", "]"));
        if (iFindFirstCompletelyVisibleItemPosition == -1 || iFindLastCompletelyVisibleItemPosition == -1) {
            return;
        }
        if ((iFindFirstCompletelyVisibleItemPosition > index || index > iFindLastCompletelyVisibleItemPosition) && (recyclerView = this.mPenList) != null) {
            recyclerView.smoothScrollToPosition(index);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface
    public void close() {
        Log.i(TAG, "close()");
        SpenPenPopupControl spenPenPopupControl = this.mPenPopupControl;
        if (spenPenPopupControl != null) {
            spenPenPopupControl.close();
        }
        this.mPenPopupControl = null;
        this.mPenList = null;
        this.mPenAdapter = null;
        this.mPenLayoutManager = null;
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface
    public int getSelectedPenPosition() {
        Log.i(TAG, "getSelectedPenPosition()");
        SpenPenMiniAdapter spenPenMiniAdapter = this.mPenAdapter;
        if (spenPenMiniAdapter != null) {
            return spenPenMiniAdapter.getMSelectIdx();
        }
        return -1;
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface
    public void setActionListener(@Nullable SpenPenLayoutInterface.OnActionListener listener) {
        Log.i(TAG, "setActionListener()");
        this.mActionListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface
    public boolean setPenInfo(@NotNull SpenSettingPenInfo penInfo) {
        Intrinsics.checkNotNullParameter(penInfo, "penInfo");
        Log.i(TAG, "setPenInfo()");
        SpenPenMiniAdapter spenPenMiniAdapter = this.mPenAdapter;
        if (spenPenMiniAdapter != null) {
            spenPenMiniAdapter.setPenInfo(penInfo);
        }
        if (!isShown()) {
            return true;
        }
        setPenFocus(getSelectedPenPosition());
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface
    public void setPenInfoList(@Nullable List<? extends SpenSettingPenInfo> penInfoList) {
        Log.i(TAG, "setPenInfoList()");
        SpenPenMiniAdapter spenPenMiniAdapter = this.mPenAdapter;
        if (spenPenMiniAdapter != null) {
            spenPenMiniAdapter.setListPenInfo(penInfoList);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface
    public void setPenList(@Nullable List<String> penNames) {
        Log.i(TAG, "setPenList()");
        if (this.mPenAdapter == null) {
            SpenPenMiniAdapter spenPenMiniAdapter = new SpenPenMiniAdapter(penNames, getItemId(this.mOrientation));
            this.mPenAdapter = spenPenMiniAdapter;
            Intrinsics.checkNotNull(spenPenMiniAdapter);
            spenPenMiniAdapter.setOnItemClickListener(new SpenPenMiniAdapter.OnItemClickListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenPenMiniLayout.setPenList.1
                @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenMiniAdapter.OnItemClickListener
                public void onItemClick(View view, int position) {
                    SpenPenMiniAdapter spenPenMiniAdapter2 = SpenPenMiniLayout.this.mPenAdapter;
                    Intrinsics.checkNotNull(spenPenMiniAdapter2);
                    String penName = spenPenMiniAdapter2.getPenName(position);
                    SpenPenMiniAdapter spenPenMiniAdapter3 = SpenPenMiniLayout.this.mPenAdapter;
                    Intrinsics.checkNotNull(spenPenMiniAdapter3);
                    boolean z = spenPenMiniAdapter3.getMSelectIdx() == position;
                    SpenPenMiniLayout spenPenMiniLayout = SpenPenMiniLayout.this;
                    Intrinsics.checkNotNull(penName);
                    spenPenMiniLayout.notifyPenClicked(penName, z);
                }
            });
        }
        RecyclerView recyclerView = this.mPenList;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.mPenAdapter);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface
    public void setUnselectedPen() {
        Log.i(TAG, "setUnselectedPen()");
    }

    public /* synthetic */ SpenPenMiniLayout(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 1 : i);
    }
}
