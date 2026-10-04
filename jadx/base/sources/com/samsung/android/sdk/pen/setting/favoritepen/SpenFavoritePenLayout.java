package com.samsung.android.sdk.pen.setting.favoritepen;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteItemDragManager;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenAdapter;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayout;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayoutControl;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.sdk.pen.setting.widget.SpenRecyclerView;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p012C1.RunnableC0050f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0000\u0018\u0000 o2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004opqrB/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ0\u00107\u001a\u0002082\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0006\u00109\u001a\u000208J\u0010\u0010:\u001a\u0002082\b\u0010;\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010<\u001a\u0002082\b\u0010;\u001a\u0004\u0018\u00010\u0013J\u0010\u0010=\u001a\u0002082\b\u0010;\u001a\u0004\u0018\u00010\u0015J\u000e\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020.J\u000e\u0010@\u001a\u0002082\u0006\u0010?\u001a\u00020.J\u0012\u0010A\u001a\u0002082\b\u0010;\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010B\u001a\u00020.2\b\u0010C\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020\u00072\b\u0010C\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010F\u001a\u0002082\b\u0010;\u001a\u0004\u0018\u00010GJ\u000e\u0010H\u001a\u0002082\u0006\u0010I\u001a\u00020.J\u0018\u0010N\u001a\u0002082\u000e\u0010O\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001fH\u0016J\u0016\u0010P\u001a\u0002082\u0006\u0010E\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020.J\u000e\u0010V\u001a\u0002082\u0006\u0010W\u001a\u00020,J\u000e\u0010X\u001a\u0002082\u0006\u0010Y\u001a\u00020\u0007J\u0010\u0010b\u001a\u0002082\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010c\u001a\u0002082\u0006\u0010d\u001a\u00020\u00072\u0006\u0010e\u001a\u00020.H\u0002J\u0010\u0010f\u001a\u00020.2\u0006\u0010d\u001a\u00020\u0007H\u0002J\b\u0010g\u001a\u000208H\u0002J\u0018\u0010h\u001a\u0002082\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0018\u0010i\u001a\u0002082\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010j\u001a\u0002082\u0006\u0010k\u001a\u00020.H\u0002J\u0010\u0010l\u001a\u0002082\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010m\u001a\u0002082\u0006\u0010n\u001a\u00020\u0007H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0011\u0010R\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bS\u0010KR\u0011\u0010T\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bU\u0010KR\u0011\u0010Z\u001a\u00020[8F¢\u0006\u0006\u001a\u0004\b\\\u0010]R$\u0010_\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u0010K\"\u0004\ba\u0010M¨\u0006s"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayout;", "Landroid/widget/RelativeLayout;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteData;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMode;", "context", "Landroid/content/Context;", "mode", "", "maxCount", "favoriteList", "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "<init>", "(Landroid/content/Context;IILjava/util/List;)V", "mViewItemClickListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteViewItemClickListener;", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDataChangedListener;", "mEventListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayout$OnEventListener;", "mEditItemClickListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayout$OnEditItemClickListener;", "mPenViewListAdapter", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenAdapter;", "mLayoutControl", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayoutControl;", "mDoneLayout", "mCancelLayout", "mPenViewList", "Lcom/samsung/android/sdk/pen/setting/widget/SpenRecyclerView;", "mFavoriteList", "", "mItemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "mFavoriteItemDragManager", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragManager;", "mFavoriteGridLayoutManager", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteGridLayoutManager;", "mDividerItemDecoration", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDecoration;", "mSelectedIndex", "mMode", "mDividerColor", "mListRadius", "", "mIsDataChangedByUser", "", "mItemEventListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenAdapter$OnItemEventListener;", "mDoneButtonClickListener", "Landroid/view/View$OnClickListener;", "mFavoriteDragListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDragListener;", "mOnItemDropListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragManager$OnItemDropListener;", "construct", "", "close", "setOnViewItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnEventListener", "setOnEditItemClickListener", "setAddButtonEnabled", "enabled", "setPanelModeEnabled", "setFavoriteDataChangedListener", "addFavorite", "info", "updateFavorite", "index", "setOnFavoritePenAnimationListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayout$OnFavoritePenAnimationListener;", "setShowAnimation", "hasAnimation", "getMode", "()I", "setMode", "(I)V", "setFavoriteList", XmlErrorCodes.LIST, "setSelectedItem", "focused", "selectedItem", "getSelectedItem", "favoriteCount", "getFavoriteCount", "setListRadius", "radius", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "favoriteContainer", "Landroid/view/View;", "getFavoriteContainer", "()Landroid/view/View;", "orientation", "layoutOrientation", "getLayoutOrientation", "setLayoutOrientation", "initView", "moveToPosition", "position", "needAnimation", "isCompleteVisibleChild", "notifyUpdateFavoriteList", "updateFavoriteList", "initAdapter", "setItemAnimator", "animated", "applyFavoriteListRadius", "updateDividerItemDecorationColor", "color", "Companion", "OnEditItemClickListener", "OnEventListener", "OnFavoritePenAnimationListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenFavoritePenLayout extends RelativeLayout implements SpenFavoriteData, SpenFavoritePenMode {
    private static final int COLUMN_NUMBER = 4;

    @NotNull
    private static final String TAG = "SpenFavoritePenLayout";
    private RelativeLayout mCancelLayout;

    @Nullable
    private SpenFavoriteDataChangedListener mDataChangedListener;
    private int mDividerColor;
    private SpenFavoriteItemDecoration mDividerItemDecoration;

    @NotNull
    private final View.OnClickListener mDoneButtonClickListener;
    private RelativeLayout mDoneLayout;

    @Nullable
    private OnEditItemClickListener mEditItemClickListener;

    @Nullable
    private OnEventListener mEventListener;

    @NotNull
    private final SpenFavoriteDragListener mFavoriteDragListener;
    private SpenFavoriteGridLayoutManager mFavoriteGridLayoutManager;
    private SpenFavoriteItemDragManager mFavoriteItemDragManager;
    private List<SpenSettingUIPenInfo> mFavoriteList;
    private boolean mIsDataChangedByUser;

    @NotNull
    private final SpenFavoritePenAdapter.OnItemEventListener mItemEventListener;
    private ItemTouchHelper mItemTouchHelper;
    private SpenFavoritePenLayoutControl mLayoutControl;
    private float mListRadius;
    private int mMode;

    @NotNull
    private final SpenFavoriteItemDragManager.OnItemDropListener mOnItemDropListener;
    private SpenRecyclerView mPenViewList;

    @Nullable
    private SpenFavoritePenAdapter mPenViewListAdapter;
    private int mSelectedIndex;

    @Nullable
    private SpenFavoriteViewItemClickListener mViewItemClickListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayout$OnEditItemClickListener;", "", "onEditItemClick", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnEditItemClickListener {
        void onEditItemClick();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayout$OnEventListener;", "", "onEditComplete", "", "isDone", "", "onAddItemClick", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnEventListener {
        void onAddItemClick();

        void onEditComplete(boolean isDone);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayout$OnFavoritePenAnimationListener;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayoutControl$OnFavoritePenLayoutAnimationListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnFavoritePenAnimationListener extends SpenFavoritePenLayoutControl.OnFavoritePenLayoutAnimationListener {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenFavoritePenLayout(@NotNull Context context, int i, int i2, @Nullable List<? extends SpenSettingUIPenInfo> list) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mItemEventListener = new SpenFavoritePenAdapter.OnItemEventListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayout$mItemEventListener$1
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenAdapter.OnItemEventListener
            public void onAddItemClick() {
                SpenFavoritePenLayout.OnEventListener onEventListener = this.this$0.mEventListener;
                if (onEventListener != null) {
                    onEventListener.onAddItemClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenAdapter.OnItemEventListener
            public void onItemClick(int mode, int position) {
                if (mode == 2) {
                    if (this.this$0.mPenViewListAdapter != null) {
                        SpenFavoritePenAdapter spenFavoritePenAdapter = this.this$0.mPenViewListAdapter;
                        if (spenFavoritePenAdapter != null) {
                            spenFavoritePenAdapter.deletePen(position);
                        }
                        this.this$0.mIsDataChangedByUser = true;
                    }
                    SpenFavoritePenLayout.OnEditItemClickListener onEditItemClickListener = this.this$0.mEditItemClickListener;
                    if (onEditItemClickListener != null) {
                        onEditItemClickListener.onEditItemClick();
                        return;
                    }
                    return;
                }
                if (mode != 1 || this.this$0.mViewItemClickListener == null) {
                    return;
                }
                this.this$0.mSelectedIndex = position;
                SpenFavoritePenAdapter spenFavoritePenAdapter2 = this.this$0.mPenViewListAdapter;
                SpenSettingUIPenInfo penInfo = spenFavoritePenAdapter2 != null ? spenFavoritePenAdapter2.getPenInfo(position) : null;
                SpenFavoriteViewItemClickListener spenFavoriteViewItemClickListener = this.this$0.mViewItemClickListener;
                if (spenFavoriteViewItemClickListener != null) {
                    Intrinsics.checkNotNull(penInfo);
                    spenFavoriteViewItemClickListener.onViewItemClick(penInfo);
                }
            }
        };
        this.mDoneButtonClickListener = new ViewOnClickListenerC7580a(this, 0);
        this.mFavoriteDragListener = new SpenFavoriteDragListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayout$mFavoriteDragListener$1
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteDragListener
            public void onStartDrag(RecyclerView.ViewHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                this.this$0.setItemAnimator(true);
                SpenFavoriteItemDragManager spenFavoriteItemDragManager = this.this$0.mFavoriteItemDragManager;
                ItemTouchHelper itemTouchHelper = null;
                if (spenFavoriteItemDragManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFavoriteItemDragManager");
                    spenFavoriteItemDragManager = null;
                }
                spenFavoriteItemDragManager.setIsLongPressDragEnabled(true);
                ItemTouchHelper itemTouchHelper2 = this.this$0.mItemTouchHelper;
                if (itemTouchHelper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mItemTouchHelper");
                } else {
                    itemTouchHelper = itemTouchHelper2;
                }
                itemTouchHelper.startDrag(holder);
            }
        };
        this.mOnItemDropListener = new SpenFavoriteItemDragManager.OnItemDropListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayout$mOnItemDropListener$1
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteItemDragManager.OnItemDropListener
            public void OnItemDrop() {
                Log.i("SpenFavoritePenLayout", "Favorite Item was dropped");
                if (this.this$0.mDataChangedListener == null || this.this$0.mPenViewListAdapter == null) {
                    return;
                }
                this.this$0.notifyUpdateFavoriteList();
            }
        };
        construct(context, i, i2, list);
    }

    private final void applyFavoriteListRadius(int mode) {
        SpenRecyclerView spenRecyclerView = null;
        if (mode == 2) {
            SpenRecyclerView spenRecyclerView2 = this.mPenViewList;
            if (spenRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
            } else {
                spenRecyclerView = spenRecyclerView2;
            }
            float f = this.mListRadius;
            spenRecyclerView.setRadius(f, f, 0.0f, 0.0f);
            return;
        }
        SpenRecyclerView spenRecyclerView3 = this.mPenViewList;
        if (spenRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
        } else {
            spenRecyclerView = spenRecyclerView3;
        }
        float f4 = this.mListRadius;
        spenRecyclerView.setRadius(0.0f, 0.0f, f4, f4);
    }

    private final void construct(Context context, int mode, int maxCount, List<? extends SpenSettingUIPenInfo> favoriteList) {
        initView(context);
        this.mFavoriteList = new ArrayList();
        this.mSelectedIndex = -1;
        this.mListRadius = 0.0f;
        this.mDividerColor = SpenSettingUtil.getColor(getContext(), C7932R.color.setting_favorite_line_divider_color);
        updateFavoriteList(favoriteList);
        initAdapter(context, maxCount);
        setMode(mode);
        setLayoutOrientation(1);
    }

    private final void initAdapter(Context context, int maxCount) {
        SpenRecyclerView spenRecyclerView = null;
        if (this.mPenViewListAdapter != null) {
            this.mPenViewListAdapter = null;
        }
        List<SpenSettingUIPenInfo> list = this.mFavoriteList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteList");
            list = null;
        }
        SpenFavoritePenAdapter spenFavoritePenAdapter = new SpenFavoritePenAdapter(context, maxCount, list, this.mFavoriteDragListener);
        this.mPenViewListAdapter = spenFavoritePenAdapter;
        spenFavoritePenAdapter.setOnItemEventListener(this.mItemEventListener);
        this.mFavoriteGridLayoutManager = new SpenFavoriteGridLayoutManager(context, 4);
        SpenFavoriteItemDragManager spenFavoriteItemDragManager = new SpenFavoriteItemDragManager(context, this.mPenViewListAdapter);
        this.mFavoriteItemDragManager = spenFavoriteItemDragManager;
        spenFavoriteItemDragManager.setOnItemDropListener(this.mOnItemDropListener);
        SpenFavoriteItemDragManager spenFavoriteItemDragManager2 = this.mFavoriteItemDragManager;
        if (spenFavoriteItemDragManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteItemDragManager");
            spenFavoriteItemDragManager2 = null;
        }
        this.mItemTouchHelper = new ItemTouchHelper(spenFavoriteItemDragManager2);
        SpenRecyclerView spenRecyclerView2 = this.mPenViewList;
        if (spenRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
            spenRecyclerView2 = null;
        }
        spenRecyclerView2.setAdapter(this.mPenViewListAdapter);
        SpenRecyclerView spenRecyclerView3 = this.mPenViewList;
        if (spenRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
            spenRecyclerView3 = null;
        }
        SpenFavoriteGridLayoutManager spenFavoriteGridLayoutManager = this.mFavoriteGridLayoutManager;
        if (spenFavoriteGridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteGridLayoutManager");
            spenFavoriteGridLayoutManager = null;
        }
        spenRecyclerView3.setLayoutManager(spenFavoriteGridLayoutManager);
        this.mDividerItemDecoration = new SpenFavoriteItemDecoration(context);
        SpenRecyclerView spenRecyclerView4 = this.mPenViewList;
        if (spenRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
            spenRecyclerView4 = null;
        }
        SpenFavoriteItemDecoration spenFavoriteItemDecoration = this.mDividerItemDecoration;
        if (spenFavoriteItemDecoration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDividerItemDecoration");
            spenFavoriteItemDecoration = null;
        }
        spenRecyclerView4.addItemDecoration(spenFavoriteItemDecoration);
        SpenRecyclerView spenRecyclerView5 = this.mPenViewList;
        if (spenRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
            spenRecyclerView5 = null;
        }
        spenRecyclerView5.setHasFixedSize(true);
        SpenRecyclerView spenRecyclerView6 = this.mPenViewList;
        if (spenRecyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
            spenRecyclerView6 = null;
        }
        spenRecyclerView6.setItemViewCacheSize(maxCount);
        ItemTouchHelper itemTouchHelper = this.mItemTouchHelper;
        if (itemTouchHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemTouchHelper");
            itemTouchHelper = null;
        }
        SpenRecyclerView spenRecyclerView7 = this.mPenViewList;
        if (spenRecyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
        } else {
            spenRecyclerView = spenRecyclerView7;
        }
        itemTouchHelper.attachToRecyclerView(spenRecyclerView);
    }

    private final void initView(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        int i = 1;
        ((LayoutInflater) systemService).inflate(C7932R.layout.setting_favorite_layout, (ViewGroup) this, true);
        this.mLayoutControl = new SpenFavoritePenLayoutControl(context, this);
        View viewFindViewById = findViewById(C7932R.id.action_positive_layout);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.mDoneLayout = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(C7932R.id.done);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText");
        SpenShowButtonShapeText spenShowButtonShapeText = (SpenShowButtonShapeText) viewFindViewById2;
        RelativeLayout relativeLayout = this.mDoneLayout;
        SpenRecyclerView spenRecyclerView = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDoneLayout");
            relativeLayout = null;
        }
        relativeLayout.setOnClickListener(this.mDoneButtonClickListener);
        View viewFindViewById3 = findViewById(C7932R.id.action_negative_layout);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.mCancelLayout = (RelativeLayout) viewFindViewById3;
        View viewFindViewById4 = findViewById(C7932R.id.cancel);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText");
        SpenShowButtonShapeText spenShowButtonShapeText2 = (SpenShowButtonShapeText) viewFindViewById4;
        RelativeLayout relativeLayout2 = this.mCancelLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelLayout");
            relativeLayout2 = null;
        }
        relativeLayout2.setOnClickListener(new ViewOnClickListenerC7580a(this, i));
        SpenSettingUtilText.setDefaultButtonTextStyle(context, spenShowButtonShapeText2, spenShowButtonShapeText);
        SpenSettingUtilText.applyUpToLargeLevel(context, 16.0f, spenShowButtonShapeText2, spenShowButtonShapeText);
        spenShowButtonShapeText.setButtonShapeEnabled(true);
        spenShowButtonShapeText.setButtonShapeAssistantAsButton();
        spenShowButtonShapeText2.setButtonShapeEnabled(true);
        spenShowButtonShapeText2.setButtonShapeAssistantAsButton();
        this.mPenViewList = new SpenRecyclerView(new ContextThemeWrapper(context, C7932R.style.SettingVerticalScrollBarStyle));
        SpenFavoritePenLayoutControl spenFavoritePenLayoutControl = this.mLayoutControl;
        if (spenFavoritePenLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenFavoritePenLayoutControl = null;
        }
        SpenRecyclerView spenRecyclerView2 = this.mPenViewList;
        if (spenRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
        } else {
            spenRecyclerView = spenRecyclerView2;
        }
        spenFavoritePenLayoutControl.addPenView$SDK_fullRelease(spenRecyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(SpenFavoritePenLayout spenFavoritePenLayout, View view) {
        OnEventListener onEventListener = spenFavoritePenLayout.mEventListener;
        if (onEventListener != null) {
            onEventListener.onEditComplete(false);
        }
    }

    private final boolean isCompleteVisibleChild(int position) {
        SpenFavoriteGridLayoutManager spenFavoriteGridLayoutManager = this.mFavoriteGridLayoutManager;
        SpenFavoriteGridLayoutManager spenFavoriteGridLayoutManager2 = null;
        if (spenFavoriteGridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteGridLayoutManager");
            spenFavoriteGridLayoutManager = null;
        }
        if (spenFavoriteGridLayoutManager.findFirstCompletelyVisibleItemPosition() > position) {
            return false;
        }
        SpenFavoriteGridLayoutManager spenFavoriteGridLayoutManager3 = this.mFavoriteGridLayoutManager;
        if (spenFavoriteGridLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteGridLayoutManager");
        } else {
            spenFavoriteGridLayoutManager2 = spenFavoriteGridLayoutManager3;
        }
        return position <= spenFavoriteGridLayoutManager2.findLastCompletelyVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mDoneButtonClickListener$lambda$0(SpenFavoritePenLayout spenFavoritePenLayout, View view) {
        spenFavoritePenLayout.mIsDataChangedByUser = false;
        spenFavoritePenLayout.notifyUpdateFavoriteList();
        OnEventListener onEventListener = spenFavoritePenLayout.mEventListener;
        if (onEventListener != null) {
            onEventListener.onEditComplete(true);
        }
    }

    private final void moveToPosition(int position, boolean needAnimation) {
        if (isCompleteVisibleChild(position)) {
            AbstractC11014a.m12328m(position, "moveToPosition(", ") already visible", TAG);
            return;
        }
        if (needAnimation) {
            new Handler().post(new RunnableC0050f(this, position, 10));
            return;
        }
        SpenRecyclerView spenRecyclerView = this.mPenViewList;
        if (spenRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
            spenRecyclerView = null;
        }
        spenRecyclerView.scrollToPosition(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moveToPosition$lambda$9(SpenFavoritePenLayout spenFavoritePenLayout, int i) {
        SpenRecyclerView spenRecyclerView = spenFavoritePenLayout.mPenViewList;
        if (spenRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
            spenRecyclerView = null;
        }
        spenRecyclerView.smoothScrollToPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyUpdateFavoriteList() {
        SpenFavoritePenAdapter spenFavoritePenAdapter;
        if (this.mDataChangedListener == null || (spenFavoritePenAdapter = this.mPenViewListAdapter) == null) {
            return;
        }
        int penCount = spenFavoritePenAdapter.getPenCount();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < penCount; i2++) {
            SpenSettingUIPenInfo penInfo = spenFavoritePenAdapter.getPenInfo(i2);
            if (penInfo != null) {
                arrayList.add(new SpenSettingUIPenInfo(penInfo));
            }
        }
        List<SpenSettingUIPenInfo> list = this.mFavoriteList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteList");
            list = null;
        }
        boolean z = true;
        boolean z2 = list.size() != arrayList.size();
        while (true) {
            if (i >= penCount) {
                z = z2;
                break;
            }
            List<SpenSettingUIPenInfo> list2 = this.mFavoriteList;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteList");
                list2 = null;
            }
            if (!Intrinsics.areEqual(list2.get(i), arrayList.get(i))) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            updateFavoriteList(arrayList);
            this.mSelectedIndex = spenFavoritePenAdapter.getMSelectedPosition();
            SpenFavoriteDataChangedListener spenFavoriteDataChangedListener = this.mDataChangedListener;
            if (spenFavoriteDataChangedListener != null) {
                spenFavoriteDataChangedListener.onFavoriteDataChanged(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setItemAnimator(boolean animated) {
        SpenRecyclerView spenRecyclerView = null;
        if (!animated) {
            SpenRecyclerView spenRecyclerView2 = this.mPenViewList;
            if (spenRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
                spenRecyclerView2 = null;
            }
            spenRecyclerView2.setItemAnimator(null);
            return;
        }
        SpenRecyclerView spenRecyclerView3 = this.mPenViewList;
        if (spenRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
            spenRecyclerView3 = null;
        }
        if (spenRecyclerView3.getItemAnimator() == null) {
            SpenRecyclerView spenRecyclerView4 = this.mPenViewList;
            if (spenRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
            } else {
                spenRecyclerView = spenRecyclerView4;
            }
            spenRecyclerView.setItemAnimator(new DefaultItemAnimator());
        }
    }

    private final void updateDividerItemDecorationColor(int color) {
        SpenFavoriteItemDecoration spenFavoriteItemDecoration = this.mDividerItemDecoration;
        SpenRecyclerView spenRecyclerView = null;
        if (spenFavoriteItemDecoration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDividerItemDecoration");
            spenFavoriteItemDecoration = null;
        }
        spenFavoriteItemDecoration.setColor(color);
        SpenRecyclerView spenRecyclerView2 = this.mPenViewList;
        if (spenRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
        } else {
            spenRecyclerView = spenRecyclerView2;
        }
        spenRecyclerView.invalidateItemDecorations();
    }

    private final void updateFavoriteList(List<? extends SpenSettingUIPenInfo> info) {
        List<SpenSettingUIPenInfo> list = this.mFavoriteList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteList");
            list = null;
        }
        list.clear();
        if (info != null) {
            int size = info.size();
            for (int i = 0; i < size; i++) {
                List<SpenSettingUIPenInfo> list2 = this.mFavoriteList;
                if (list2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFavoriteList");
                    list2 = null;
                }
                list2.add(new SpenSettingUIPenInfo(info.get(i)));
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public boolean addFavorite(@Nullable SpenSettingUIPenInfo info) {
        Log.i(TAG, "addFavorite() ");
        if (this.mPenViewListAdapter != null && info != null) {
            setItemAnimator(true);
            List<SpenSettingUIPenInfo> list = this.mFavoriteList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteList");
                list = null;
            }
            int size = list.size();
            SpenFavoritePenAdapter spenFavoritePenAdapter = this.mPenViewListAdapter;
            if (spenFavoritePenAdapter != null && spenFavoritePenAdapter.addPen(size, info)) {
                updateFavoriteList(spenFavoritePenAdapter.getFavoriteList());
                moveToPosition(spenFavoritePenAdapter.getPenCount(), true);
                return true;
            }
        }
        return false;
    }

    public final void close() {
        SpenFavoritePenAdapter spenFavoritePenAdapter = this.mPenViewListAdapter;
        if (spenFavoritePenAdapter != null) {
            spenFavoritePenAdapter.close();
        }
        SpenFavoritePenLayoutControl spenFavoritePenLayoutControl = null;
        this.mPenViewListAdapter = null;
        List<SpenSettingUIPenInfo> list = this.mFavoriteList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteList");
            list = null;
        }
        list.clear();
        SpenFavoriteItemDragManager spenFavoriteItemDragManager = this.mFavoriteItemDragManager;
        if (spenFavoriteItemDragManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteItemDragManager");
            spenFavoriteItemDragManager = null;
        }
        spenFavoriteItemDragManager.close();
        this.mViewItemClickListener = null;
        this.mEventListener = null;
        this.mEditItemClickListener = null;
        this.mDataChangedListener = null;
        SpenRecyclerView spenRecyclerView = this.mPenViewList;
        if (spenRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
            spenRecyclerView = null;
        }
        spenRecyclerView.removeAllViews();
        SpenFavoriteItemDecoration spenFavoriteItemDecoration = this.mDividerItemDecoration;
        if (spenFavoriteItemDecoration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDividerItemDecoration");
            spenFavoriteItemDecoration = null;
        }
        spenFavoriteItemDecoration.close();
        SpenFavoritePenLayoutControl spenFavoritePenLayoutControl2 = this.mLayoutControl;
        if (spenFavoritePenLayoutControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
        } else {
            spenFavoritePenLayoutControl = spenFavoritePenLayoutControl2;
        }
        spenFavoritePenLayoutControl.close$SDK_fullRelease();
    }

    @NotNull
    public final View getFavoriteContainer() {
        Log.i(TAG, "getFavoriteContainer()");
        SpenRecyclerView spenRecyclerView = this.mPenViewList;
        if (spenRecyclerView != null) {
            return spenRecyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPenViewList");
        return null;
    }

    public final int getFavoriteCount() {
        List<SpenSettingUIPenInfo> list = this.mFavoriteList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteList");
            list = null;
        }
        return list.size();
    }

    public final int getLayoutOrientation() {
        SpenFavoritePenLayoutControl spenFavoritePenLayoutControl = this.mLayoutControl;
        if (spenFavoritePenLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenFavoritePenLayoutControl = null;
        }
        return spenFavoritePenLayoutControl.getLayoutOrientation();
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMode
    public int getMode() {
        return this.mMode;
    }

    public final int getSelectedItem() {
        SpenFavoritePenAdapter spenFavoritePenAdapter = this.mPenViewListAdapter;
        if (spenFavoritePenAdapter != null) {
            return getMode() == 2 ? this.mSelectedIndex : spenFavoritePenAdapter.getMSelectedPosition();
        }
        return -1;
    }

    public final void setAddButtonEnabled(boolean enabled) {
        SpenFavoritePenAdapter spenFavoritePenAdapter = this.mPenViewListAdapter;
        if (spenFavoritePenAdapter != null) {
            spenFavoritePenAdapter.setAddButtonEnabled(enabled);
        }
    }

    public final void setColorTheme(int theme) {
        SpenFavoritePenAdapter spenFavoritePenAdapter = this.mPenViewListAdapter;
        if (spenFavoritePenAdapter != null) {
            spenFavoritePenAdapter.setColorTheme(theme);
            spenFavoritePenAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public void setFavoriteDataChangedListener(@Nullable SpenFavoriteDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public void setFavoriteList(@Nullable List<SpenSettingUIPenInfo> list) {
        updateFavoriteList(list);
        this.mSelectedIndex = -1;
        SpenFavoritePenAdapter spenFavoritePenAdapter = this.mPenViewListAdapter;
        if (spenFavoritePenAdapter != null) {
            setItemAnimator(false);
            List<SpenSettingUIPenInfo> list2 = this.mFavoriteList;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteList");
                list2 = null;
            }
            spenFavoritePenAdapter.setFavoriteList(list2, true);
        }
    }

    public final void setLayoutOrientation(int i) {
        AbstractC2322a.m1631u(i, "setLayoutOrientation() orientation=", TAG);
        SpenFavoritePenLayoutControl spenFavoritePenLayoutControl = this.mLayoutControl;
        SpenFavoriteGridLayoutManager spenFavoriteGridLayoutManager = null;
        if (spenFavoritePenLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenFavoritePenLayoutControl = null;
        }
        if (spenFavoritePenLayoutControl.getLayoutOrientation() != i) {
            int i2 = i == 2 ? 8 : 4;
            SpenFavoritePenLayoutControl spenFavoritePenLayoutControl2 = this.mLayoutControl;
            if (spenFavoritePenLayoutControl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
                spenFavoritePenLayoutControl2 = null;
            }
            spenFavoritePenLayoutControl2.setLayoutOrientation$SDK_fullRelease(i, i2, this.mMode);
            SpenFavoriteGridLayoutManager spenFavoriteGridLayoutManager2 = this.mFavoriteGridLayoutManager;
            if (spenFavoriteGridLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteGridLayoutManager");
            } else {
                spenFavoriteGridLayoutManager = spenFavoriteGridLayoutManager2;
            }
            spenFavoriteGridLayoutManager.setSpanCount(i2);
        }
    }

    public final void setListRadius(float radius) {
        this.mListRadius = radius;
        applyFavoriteListRadius(this.mMode);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMode
    public void setMode(int i) {
        AbstractC6670b.m4744e(i, this.mMode, "setMode() mode=", "old=", TAG);
        SpenFavoritePenAdapter spenFavoritePenAdapter = this.mPenViewListAdapter;
        if (spenFavoritePenAdapter == null || spenFavoritePenAdapter == null) {
            return;
        }
        SpenFavoritePenLayoutControl spenFavoritePenLayoutControl = this.mLayoutControl;
        SpenFavoritePenLayoutControl spenFavoritePenLayoutControl2 = null;
        if (spenFavoritePenLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenFavoritePenLayoutControl = null;
        }
        spenFavoritePenAdapter.setItemAnimation(spenFavoritePenLayoutControl.getMHasAnimation());
        if (this.mMode == 2 && this.mIsDataChangedByUser) {
            this.mIsDataChangedByUser = false;
            List<SpenSettingUIPenInfo> list = this.mFavoriteList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteList");
                list = null;
            }
            spenFavoritePenAdapter.setFavoriteList(list);
            spenFavoritePenAdapter.setSelectedPosition(this.mSelectedIndex);
        }
        boolean z = this.mMode != i;
        this.mMode = i;
        SpenFavoritePenLayoutControl spenFavoritePenLayoutControl3 = this.mLayoutControl;
        if (spenFavoritePenLayoutControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
        } else {
            spenFavoritePenLayoutControl2 = spenFavoritePenLayoutControl3;
        }
        spenFavoritePenLayoutControl2.setMode$SDK_fullRelease(this.mMode, spenFavoritePenAdapter.getPenCount(), z);
        if (z) {
            applyFavoriteListRadius(this.mMode);
            setItemAnimator(isShown());
            updateDividerItemDecorationColor(this.mMode != 2 ? this.mDividerColor : 0);
            spenFavoritePenAdapter.setMode(this.mMode);
            spenFavoritePenAdapter.notifyDataSetChanged();
        }
    }

    public final void setOnEditItemClickListener(@Nullable OnEditItemClickListener listener) {
        this.mEditItemClickListener = listener;
    }

    public final void setOnEventListener(@Nullable OnEventListener listener) {
        this.mEventListener = listener;
    }

    public final void setOnFavoritePenAnimationListener(@Nullable OnFavoritePenAnimationListener listener) {
        SpenFavoritePenLayoutControl spenFavoritePenLayoutControl = this.mLayoutControl;
        if (spenFavoritePenLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenFavoritePenLayoutControl = null;
        }
        spenFavoritePenLayoutControl.setOnFavoritePenAnimationListener$SDK_fullRelease(listener);
    }

    public final void setOnViewItemClickListener(@Nullable SpenFavoriteViewItemClickListener listener) {
        this.mViewItemClickListener = listener;
    }

    public final void setPanelModeEnabled(boolean enabled) {
        SpenFavoritePenLayoutControl spenFavoritePenLayoutControl = this.mLayoutControl;
        if (spenFavoritePenLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenFavoritePenLayoutControl = null;
        }
        spenFavoritePenLayoutControl.setPanelModeEnabled$SDK_fullRelease(enabled);
    }

    public final void setSelectedItem(int index, boolean focused) {
        SpenFavoritePenAdapter spenFavoritePenAdapter = this.mPenViewListAdapter;
        if (spenFavoritePenAdapter != null) {
            this.mSelectedIndex = index;
            if (getMode() == 2) {
                return;
            }
            int selectedPosition = spenFavoritePenAdapter.getMSelectedPosition();
            if (selectedPosition != index) {
                spenFavoritePenAdapter.setSelectedPosition(index);
                if (selectedPosition != -1) {
                    spenFavoritePenAdapter.notifyItemChanged(selectedPosition);
                }
                if (index != -1) {
                    spenFavoritePenAdapter.notifyItemChanged(index);
                }
            }
            if (!focused || index == -1) {
                return;
            }
            moveToPosition(index, isShown());
        }
    }

    public final void setShowAnimation(boolean hasAnimation) {
        SpenFavoritePenLayoutControl spenFavoritePenLayoutControl = this.mLayoutControl;
        if (spenFavoritePenLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenFavoritePenLayoutControl = null;
        }
        spenFavoritePenLayoutControl.setAnimation$SDK_fullRelease(hasAnimation);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public boolean updateFavorite(int index, @Nullable SpenSettingUIPenInfo info) {
        Log.i(TAG, "updateFavorite() ");
        SpenFavoritePenAdapter spenFavoritePenAdapter = this.mPenViewListAdapter;
        if (spenFavoritePenAdapter == null || info == null || !spenFavoritePenAdapter.updatePen(index, info)) {
            return false;
        }
        List<SpenSettingUIPenInfo> list = this.mFavoriteList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteList");
            list = null;
        }
        list.set(index, info);
        this.mSelectedIndex = spenFavoritePenAdapter.getMSelectedPosition();
        return true;
    }
}
