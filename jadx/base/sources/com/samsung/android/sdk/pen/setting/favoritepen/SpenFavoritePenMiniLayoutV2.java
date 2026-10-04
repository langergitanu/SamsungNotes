package com.samsung.android.sdk.pen.setting.favoritepen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteItemDragHelper;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniAdapter;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniLayoutV2;
import com.samsung.android.sdk.pen.setting.widget.SpenRecyclerView;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 X2\u00020\u0001:\u0002XYB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0005H\u0007J\u001e\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001bJ.\u00107\u001a\u00020\u001b2\u000e\u00108\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001002\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010:2\u0006\u0010;\u001a\u00020\u0005J\u0010\u0010<\u001a\u00020%2\b\u0010=\u001a\u0004\u0018\u00010\u0016J\u0018\u0010>\u001a\u00020\u001b2\b\u0010?\u001a\u0004\u0018\u0001012\u0006\u0010@\u001a\u00020\u001bJ\u0016\u0010A\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010?\u001a\u000201J\u000e\u0010C\u001a\u00020%2\u0006\u0010B\u001a\u00020\u0005J\u0010\u0010D\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020%2\b\u0010=\u001a\u0004\u0018\u00010\u0018J\u0016\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u001bJ\u0010\u0010O\u001a\u00020%2\b\u0010=\u001a\u0004\u0018\u00010PJ\u0006\u0010@\u001a\u00020\u001bJ \u0010Q\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010R\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010S\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010T\u001a\u00020%H\u0002J\u0018\u0010U\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u001bH\u0002J\u0010\u0010V\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010W\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u001bH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b-\u0010.R4\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001002\u000e\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008F@GX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0011\u0010I\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bJ\u0010.R\u0011\u0010K\u001a\u00020L8F¢\u0006\u0006\u001a\u0004\bM\u0010N¨\u0006Z"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniLayoutV2;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "maxCount", "", "orientation", "<init>", "(Landroid/content/Context;II)V", "mFavoriteView", "Lcom/samsung/android/sdk/pen/setting/widget/SpenRecyclerView;", "mLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mAdapter", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniAdapter;", "mItemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "mFavoriteItemDragHelper", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper;", "mLayoutHelper", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniLayoutHelper;", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDataChangedListener;", "mItemEventListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniLayoutV2$ItemEventListener;", "mToolType", "mInitComplete", "", "mFavoriteDragListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniAdapter$OnItemDragStartListener;", "mOnItemDropListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper$OnItemDropListener;", "mOnItemEventListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniAdapter$OnItemEventListener;", "mRecyclerViewListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "close", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setSelectedItem", "position", "focused", "needAnimation", "selectedItem", "getSelectedItem", "()I", XmlErrorCodes.LIST, "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "favoriteList", "getFavoriteList", "()Ljava/util/List;", "setFavoriteList", "(Ljava/util/List;)V", "restoreFavoriteList", "totalList", "insertIndexList", "", "selectedIndex", "setFavoriteDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addFavorite", "info", "needScroll", "updateFavorite", "index", "deleteFavorite", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "setItemEventListener", "setMode", "mode", "getMode", "favoriteContainer", "Landroid/view/View;", "getFavoriteContainer", "()Landroid/view/View;", "setOnPenMiniDragListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/OnFavoritePenMiniViewDragListener;", "construct", "initView", "initAdapter", "initDecorator", "setScrollToPosition", "getItemId", "moveToPosition", "Companion", "ItemEventListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag", "ViewConstructor"})
public final class SpenFavoritePenMiniLayoutV2 extends RelativeLayout {

    @NotNull
    private static final String TAG = "SpenFavoritePenMiniLayoutV2";
    private SpenFavoritePenMiniAdapter mAdapter;

    @Nullable
    private SpenFavoriteDataChangedListener mDataChangedListener;

    @NotNull
    private final SpenFavoritePenMiniAdapter.OnItemDragStartListener mFavoriteDragListener;
    private SpenFavoriteItemDragHelper mFavoriteItemDragHelper;
    private SpenRecyclerView mFavoriteView;
    private boolean mInitComplete;

    @Nullable
    private ItemEventListener mItemEventListener;
    private ItemTouchHelper mItemTouchHelper;
    private SpenFavoritePenMiniLayoutHelper mLayoutHelper;
    private LinearLayoutManager mLayoutManager;

    @NotNull
    private final SpenFavoriteItemDragHelper.OnItemDropListener mOnItemDropListener;

    @NotNull
    private final SpenFavoritePenMiniAdapter.OnItemEventListener mOnItemEventListener;

    @NotNull
    private final ViewTreeObserver.OnGlobalLayoutListener mRecyclerViewListener;
    private int mToolType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniLayoutV2$ItemEventListener;", "", "onItemClick", "", "mode", "", "position", "info", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "onAddItemClick", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ItemEventListener {
        void onAddItemClick();

        void onItemClick(int mode, int position, @NotNull SpenSettingUIPenInfo info);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenFavoritePenMiniLayoutV2(@NotNull Context context, int i, int i2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mToolType = 1;
        this.mFavoriteDragListener = new SpenFavoritePenMiniAdapter.OnItemDragStartListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniLayoutV2$mFavoriteDragListener$1
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniAdapter.OnItemDragStartListener
            public void onItemDragStart(RecyclerView.ViewHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Log.i("SpenFavoritePenMiniLayoutV2", "onItemDragStart()");
                SpenFavoriteItemDragHelper spenFavoriteItemDragHelper = this.this$0.mFavoriteItemDragHelper;
                ItemTouchHelper itemTouchHelper = null;
                if (spenFavoriteItemDragHelper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFavoriteItemDragHelper");
                    spenFavoriteItemDragHelper = null;
                }
                spenFavoriteItemDragHelper.setToolType(this.this$0.mToolType);
                ItemTouchHelper itemTouchHelper2 = this.this$0.mItemTouchHelper;
                if (itemTouchHelper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mItemTouchHelper");
                } else {
                    itemTouchHelper = itemTouchHelper2;
                }
                itemTouchHelper.startDrag(holder);
            }
        };
        this.mOnItemDropListener = new SpenFavoriteItemDragHelper.OnItemDropListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniLayoutV2$mOnItemDropListener$1
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteItemDragHelper.OnItemDropListener
            public void onItemDrop(RecyclerView.ViewHolder viewHolder) {
                SpenFavoriteDataChangedListener spenFavoriteDataChangedListener;
                if (this.this$0.mInitComplete && (spenFavoriteDataChangedListener = this.this$0.mDataChangedListener) != null) {
                    SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = this.this$0.mAdapter;
                    if (spenFavoritePenMiniAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        spenFavoritePenMiniAdapter = null;
                    }
                    List<SpenSettingUIPenInfo> favoriteList = spenFavoritePenMiniAdapter.getFavoriteList();
                    spenFavoriteDataChangedListener.onFavoriteDataChanged(favoriteList != null ? new ArrayList(favoriteList) : null);
                }
            }
        };
        this.mOnItemEventListener = new SpenFavoritePenMiniAdapter.OnItemEventListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniLayoutV2$mOnItemEventListener$1
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniAdapter.OnItemEventListener
            public void onAddItemClick() {
                SpenFavoritePenMiniLayoutV2.ItemEventListener itemEventListener = this.this$0.mItemEventListener;
                if (itemEventListener != null) {
                    itemEventListener.onAddItemClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniAdapter.OnItemEventListener
            public void onItemClick(int mode, int position) {
                SpenFavoritePenMiniLayoutV2.ItemEventListener itemEventListener;
                if (this.this$0.mInitComplete) {
                    AbstractC6670b.m4744e(mode, position, "onItemClick() mode=", " position=", "SpenFavoritePenMiniLayoutV2");
                    SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = this.this$0.mAdapter;
                    if (spenFavoritePenMiniAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        spenFavoritePenMiniAdapter = null;
                    }
                    SpenSettingUIPenInfo penInfo = spenFavoritePenMiniAdapter.getPenInfo(position);
                    if (penInfo == null || (itemEventListener = this.this$0.mItemEventListener) == null) {
                        return;
                    }
                    itemEventListener.onItemClick(mode, position, penInfo);
                }
            }
        };
        this.mRecyclerViewListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniLayoutV2$mRecyclerViewListener$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SpenRecyclerView spenRecyclerView = this.this$0.mFavoriteView;
                if (spenRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFavoriteView");
                    spenRecyclerView = null;
                }
                spenRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int selectedItem = this.this$0.getSelectedItem();
                if (selectedItem != -1) {
                    this.this$0.moveToPosition(selectedItem, true);
                }
            }
        };
        construct(context, i, i2);
    }

    private final void construct(Context context, int maxCount, int orientation) {
        this.mLayoutHelper = new SpenFavoritePenMiniLayoutHelper(context, orientation);
        initView(context);
        initAdapter(context, maxCount);
        initDecorator();
        this.mInitComplete = true;
    }

    private final int getItemId(int orientation) {
        return orientation == 0 ? C7932R.layout.setting_mini_favorite_item_land_view : C7932R.layout.setting_mini_favorite_item_view;
    }

    private final void initAdapter(Context context, int maxCount) {
        SpenFavoritePenMiniLayoutHelper spenFavoritePenMiniLayoutHelper = this.mLayoutHelper;
        SpenRecyclerView spenRecyclerView = null;
        if (spenFavoritePenMiniLayoutHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutHelper");
            spenFavoritePenMiniLayoutHelper = null;
        }
        int layoutOrientation = spenFavoritePenMiniLayoutHelper.getLayoutOrientation();
        SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = new SpenFavoritePenMiniAdapter(context, maxCount, null, getItemId(layoutOrientation));
        this.mAdapter = spenFavoritePenMiniAdapter;
        spenFavoritePenMiniAdapter.setOnItemEventListener(this.mOnItemEventListener);
        SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter2 = this.mAdapter;
        if (spenFavoritePenMiniAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            spenFavoritePenMiniAdapter2 = null;
        }
        spenFavoritePenMiniAdapter2.setOnItemDragStartListener(this.mFavoriteDragListener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.mLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(layoutOrientation);
        SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter3 = this.mAdapter;
        if (spenFavoritePenMiniAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            spenFavoritePenMiniAdapter3 = null;
        }
        SpenFavoriteItemDragHelper spenFavoriteItemDragHelper = new SpenFavoriteItemDragHelper(context, spenFavoritePenMiniAdapter3);
        this.mFavoriteItemDragHelper = spenFavoriteItemDragHelper;
        spenFavoriteItemDragHelper.setOrientation(layoutOrientation);
        SpenFavoriteItemDragHelper spenFavoriteItemDragHelper2 = this.mFavoriteItemDragHelper;
        if (spenFavoriteItemDragHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteItemDragHelper");
            spenFavoriteItemDragHelper2 = null;
        }
        spenFavoriteItemDragHelper2.setOnItemDropListener(this.mOnItemDropListener);
        SpenFavoriteItemDragHelper spenFavoriteItemDragHelper3 = this.mFavoriteItemDragHelper;
        if (spenFavoriteItemDragHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteItemDragHelper");
            spenFavoriteItemDragHelper3 = null;
        }
        this.mItemTouchHelper = new ItemTouchHelper(spenFavoriteItemDragHelper3);
        SpenRecyclerView spenRecyclerView2 = this.mFavoriteView;
        if (spenRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteView");
            spenRecyclerView2 = null;
        }
        LinearLayoutManager linearLayoutManager2 = this.mLayoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
            linearLayoutManager2 = null;
        }
        spenRecyclerView2.setLayoutManager(linearLayoutManager2);
        SpenRecyclerView spenRecyclerView3 = this.mFavoriteView;
        if (spenRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteView");
            spenRecyclerView3 = null;
        }
        SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter4 = this.mAdapter;
        if (spenFavoritePenMiniAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            spenFavoritePenMiniAdapter4 = null;
        }
        spenRecyclerView3.setAdapter(spenFavoritePenMiniAdapter4);
        ItemTouchHelper itemTouchHelper = this.mItemTouchHelper;
        if (itemTouchHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemTouchHelper");
            itemTouchHelper = null;
        }
        SpenRecyclerView spenRecyclerView4 = this.mFavoriteView;
        if (spenRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteView");
        } else {
            spenRecyclerView = spenRecyclerView4;
        }
        itemTouchHelper.attachToRecyclerView(spenRecyclerView);
    }

    private final void initDecorator() {
        SpenFavoritePenMiniLayoutHelper spenFavoritePenMiniLayoutHelper = this.mLayoutHelper;
        SpenRecyclerView spenRecyclerView = null;
        if (spenFavoritePenMiniLayoutHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutHelper");
            spenFavoritePenMiniLayoutHelper = null;
        }
        RecyclerView.ItemDecoration itemDecoration = spenFavoritePenMiniLayoutHelper.getItemDecoration();
        if (itemDecoration == null) {
            return;
        }
        SpenRecyclerView spenRecyclerView2 = this.mFavoriteView;
        if (spenRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteView");
        } else {
            spenRecyclerView = spenRecyclerView2;
        }
        spenRecyclerView.addItemDecoration(itemDecoration);
    }

    private final void initView(Context context) {
        SpenRecyclerView spenRecyclerView = new SpenRecyclerView(context);
        this.mFavoriteView = spenRecyclerView;
        spenRecyclerView.setFocusable(false);
        spenRecyclerView.setHasFixedSize(true);
        spenRecyclerView.setClipChildren(false);
        SpenFavoritePenMiniLayoutHelper spenFavoritePenMiniLayoutHelper = this.mLayoutHelper;
        SpenFavoritePenMiniLayoutHelper spenFavoritePenMiniLayoutHelper2 = null;
        if (spenFavoritePenMiniLayoutHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutHelper");
            spenFavoritePenMiniLayoutHelper = null;
        }
        SpenRecyclerView spenRecyclerView2 = this.mFavoriteView;
        if (spenRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteView");
            spenRecyclerView2 = null;
        }
        spenFavoritePenMiniLayoutHelper.setFavoriteView(spenRecyclerView2);
        spenFavoritePenMiniLayoutHelper.updateFavoriteMinSize(this, null);
        spenFavoritePenMiniLayoutHelper.setRadius(1);
        SpenRecyclerView spenRecyclerView3 = this.mFavoriteView;
        if (spenRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteView");
            spenRecyclerView3 = null;
        }
        SpenFavoritePenMiniLayoutHelper spenFavoritePenMiniLayoutHelper3 = this.mLayoutHelper;
        if (spenFavoritePenMiniLayoutHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutHelper");
        } else {
            spenFavoritePenMiniLayoutHelper2 = spenFavoritePenMiniLayoutHelper3;
        }
        addView(spenRecyclerView3, spenFavoritePenMiniLayoutHelper2.getFavoriteParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean moveToPosition(int position, boolean needAnimation) {
        SpenRecyclerView spenRecyclerView = null;
        if (!needAnimation) {
            SpenRecyclerView spenRecyclerView2 = this.mFavoriteView;
            if (spenRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteView");
            } else {
                spenRecyclerView = spenRecyclerView2;
            }
            spenRecyclerView.scrollToPosition(position);
            return true;
        }
        LinearLayoutManager linearLayoutManager = this.mLayoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
            linearLayoutManager = null;
        }
        int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        LinearLayoutManager linearLayoutManager2 = this.mLayoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
            linearLayoutManager2 = null;
        }
        int iFindLastCompletelyVisibleItemPosition = linearLayoutManager2.findLastCompletelyVisibleItemPosition();
        if (iFindFirstCompletelyVisibleItemPosition == -1 || iFindLastCompletelyVisibleItemPosition == -1) {
            return false;
        }
        if (iFindFirstCompletelyVisibleItemPosition <= position && position <= iFindLastCompletelyVisibleItemPosition) {
            return true;
        }
        SpenRecyclerView spenRecyclerView3 = this.mFavoriteView;
        if (spenRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteView");
        } else {
            spenRecyclerView = spenRecyclerView3;
        }
        spenRecyclerView.smoothScrollToPosition(position);
        return true;
    }

    private final void setScrollToPosition(int position, boolean needAnimation) {
        AbstractC6670b.m4754o("setScrollToPosition() [", position, SQLKeyword.COMMA, needAnimation, TAG);
        if (position < 0) {
            return;
        }
        SpenRecyclerView spenRecyclerView = null;
        if (needAnimation) {
            SpenRecyclerView spenRecyclerView2 = this.mFavoriteView;
            if (spenRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteView");
            } else {
                spenRecyclerView = spenRecyclerView2;
            }
            spenRecyclerView.smoothScrollToPosition(position);
            return;
        }
        SpenRecyclerView spenRecyclerView3 = this.mFavoriteView;
        if (spenRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteView");
        } else {
            spenRecyclerView = spenRecyclerView3;
        }
        spenRecyclerView.scrollToPosition(position);
    }

    public final boolean addFavorite(@Nullable SpenSettingUIPenInfo info, boolean needScroll) {
        Log.i(TAG, "addFavorite()");
        if (this.mInitComplete && info != null) {
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = this.mAdapter;
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter2 = null;
            if (spenFavoritePenMiniAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                spenFavoritePenMiniAdapter = null;
            }
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter3 = this.mAdapter;
            if (spenFavoritePenMiniAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                spenFavoritePenMiniAdapter3 = null;
            }
            if (spenFavoritePenMiniAdapter.addPen(spenFavoritePenMiniAdapter3.getPenCount(), info)) {
                if (!needScroll) {
                    return true;
                }
                SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter4 = this.mAdapter;
                if (spenFavoritePenMiniAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    spenFavoritePenMiniAdapter4 = null;
                }
                int penCount = spenFavoritePenMiniAdapter4.getPenCount();
                SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter5 = this.mAdapter;
                if (spenFavoritePenMiniAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                } else {
                    spenFavoritePenMiniAdapter2 = spenFavoritePenMiniAdapter5;
                }
                if (penCount == spenFavoritePenMiniAdapter2.getMaxCount()) {
                    penCount--;
                }
                setScrollToPosition(penCount, false);
                return true;
            }
        }
        return false;
    }

    public final void close() {
        if (this.mInitComplete) {
            SpenFavoriteItemDragHelper spenFavoriteItemDragHelper = this.mFavoriteItemDragHelper;
            if (spenFavoriteItemDragHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteItemDragHelper");
                spenFavoriteItemDragHelper = null;
            }
            spenFavoriteItemDragHelper.close();
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = this.mAdapter;
            if (spenFavoritePenMiniAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                spenFavoritePenMiniAdapter = null;
            }
            spenFavoritePenMiniAdapter.close();
            SpenRecyclerView spenRecyclerView = this.mFavoriteView;
            if (spenRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteView");
                spenRecyclerView = null;
            }
            spenRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this.mRecyclerViewListener);
            SpenFavoritePenMiniLayoutHelper spenFavoritePenMiniLayoutHelper = this.mLayoutHelper;
            if (spenFavoritePenMiniLayoutHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayoutHelper");
                spenFavoritePenMiniLayoutHelper = null;
            }
            spenFavoritePenMiniLayoutHelper.close();
            this.mDataChangedListener = null;
            this.mItemEventListener = null;
            this.mInitComplete = false;
        }
    }

    public final void deleteFavorite(int index) {
        Log.i(TAG, "deleteFavorite()");
        if (this.mInitComplete) {
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = this.mAdapter;
            if (spenFavoritePenMiniAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                spenFavoritePenMiniAdapter = null;
            }
            spenFavoritePenMiniAdapter.deletePen(index);
        }
    }

    @NotNull
    public final View getFavoriteContainer() {
        SpenRecyclerView spenRecyclerView = this.mFavoriteView;
        if (spenRecyclerView != null) {
            return spenRecyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFavoriteView");
        return null;
    }

    @Nullable
    public final List<SpenSettingUIPenInfo> getFavoriteList() {
        if (!this.mInitComplete) {
            return new ArrayList();
        }
        SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = this.mAdapter;
        if (spenFavoritePenMiniAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            spenFavoritePenMiniAdapter = null;
        }
        return spenFavoritePenMiniAdapter.getFavoriteList();
    }

    public final int getMode() {
        SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = this.mAdapter;
        if (spenFavoritePenMiniAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            spenFavoritePenMiniAdapter = null;
        }
        return spenFavoritePenMiniAdapter.getMCurrentMode();
    }

    public final int getSelectedItem() {
        Log.i(TAG, "getSelectedItem()");
        SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = this.mAdapter;
        if (spenFavoritePenMiniAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            spenFavoritePenMiniAdapter = null;
        }
        return spenFavoritePenMiniAdapter.getMSelectedPosition();
    }

    public final boolean needScroll() {
        if (!this.mInitComplete) {
            return false;
        }
        LinearLayoutManager linearLayoutManager = this.mLayoutManager;
        SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = null;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
            linearLayoutManager = null;
        }
        int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        LinearLayoutManager linearLayoutManager2 = this.mLayoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
            linearLayoutManager2 = null;
        }
        int iFindLastCompletelyVisibleItemPosition = linearLayoutManager2.findLastCompletelyVisibleItemPosition();
        SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter2 = this.mAdapter;
        if (spenFavoritePenMiniAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            spenFavoritePenMiniAdapter2 = null;
        }
        AbstractC0000a.m26w(AbstractC0622a.m1173s(iFindFirstCompletelyVisibleItemPosition, iFindLastCompletelyVisibleItemPosition, "FirstVisible=", " LastVisible=", " lastItemPos="), TAG, spenFavoritePenMiniAdapter2.getPenCount());
        if (iFindFirstCompletelyVisibleItemPosition == -1 || iFindLastCompletelyVisibleItemPosition == -1) {
            return false;
        }
        if (iFindFirstCompletelyVisibleItemPosition != 0) {
            return true;
        }
        SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter3 = this.mAdapter;
        if (spenFavoritePenMiniAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            spenFavoritePenMiniAdapter = spenFavoritePenMiniAdapter3;
        }
        return iFindLastCompletelyVisibleItemPosition != spenFavoritePenMiniAdapter.getPenCount();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getPointerCount() > 0) {
            this.mToolType = ev.getToolType(0);
        }
        return super.onInterceptTouchEvent(ev);
    }

    public final boolean restoreFavoriteList(@Nullable List<SpenSettingUIPenInfo> totalList, @Nullable List<Integer> insertIndexList, int selectedIndex) {
        if (!this.mInitComplete) {
            return false;
        }
        AbstractC2322a.m1631u(getMode(), "restoreFavoriteList() mode= ", TAG);
        SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = this.mAdapter;
        SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter2 = null;
        if (spenFavoritePenMiniAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            spenFavoritePenMiniAdapter = null;
        }
        spenFavoritePenMiniAdapter.setFavoriteList(totalList);
        if (insertIndexList != null) {
            Iterator<Integer> it = insertIndexList.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (iIntValue != -1) {
                    SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter3 = this.mAdapter;
                    if (spenFavoritePenMiniAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        spenFavoritePenMiniAdapter3 = null;
                    }
                    spenFavoritePenMiniAdapter3.notifyItemInserted(iIntValue);
                }
            }
        }
        SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter4 = this.mAdapter;
        if (spenFavoritePenMiniAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            spenFavoritePenMiniAdapter2 = spenFavoritePenMiniAdapter4;
        }
        spenFavoritePenMiniAdapter2.setSelectedPosition(selectedIndex);
        return true;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setColorTheme(int theme) {
        if (this.mInitComplete) {
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = this.mAdapter;
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter2 = null;
            if (spenFavoritePenMiniAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                spenFavoritePenMiniAdapter = null;
            }
            spenFavoritePenMiniAdapter.setColorTheme(theme);
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter3 = this.mAdapter;
            if (spenFavoritePenMiniAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            } else {
                spenFavoritePenMiniAdapter2 = spenFavoritePenMiniAdapter3;
            }
            spenFavoritePenMiniAdapter2.notifyDataSetChanged();
        }
    }

    public final void setFavoriteDataChangedListener(@Nullable SpenFavoriteDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setFavoriteList(@Nullable List<SpenSettingUIPenInfo> list) {
        if (this.mInitComplete) {
            AbstractC2322a.m1631u(list != null ? list.size() : 0, "setFavoriteList() size=", TAG);
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = this.mAdapter;
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter2 = null;
            if (spenFavoritePenMiniAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                spenFavoritePenMiniAdapter = null;
            }
            spenFavoritePenMiniAdapter.setFavoriteList(list);
            SpenFavoritePenMiniLayoutHelper spenFavoritePenMiniLayoutHelper = this.mLayoutHelper;
            if (spenFavoritePenMiniLayoutHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayoutHelper");
                spenFavoritePenMiniLayoutHelper = null;
            }
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter3 = this.mAdapter;
            if (spenFavoritePenMiniAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                spenFavoritePenMiniAdapter3 = null;
            }
            spenFavoritePenMiniLayoutHelper.updateFavoriteMinSize(this, spenFavoritePenMiniAdapter3);
            LinearLayoutManager linearLayoutManager = this.mLayoutManager;
            if (linearLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
                linearLayoutManager = null;
            }
            linearLayoutManager.removeAllViews();
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter4 = this.mAdapter;
            if (spenFavoritePenMiniAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            } else {
                spenFavoritePenMiniAdapter2 = spenFavoritePenMiniAdapter4;
            }
            spenFavoritePenMiniAdapter2.notifyDataSetChanged();
        }
    }

    public final void setItemEventListener(@Nullable ItemEventListener listener) {
        this.mItemEventListener = listener;
    }

    public final void setMode(int mode, boolean needAnimation) {
        AbstractC6670b.m4754o("setMode() mode=", mode, " animation=", needAnimation, TAG);
        if (this.mInitComplete) {
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = this.mAdapter;
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter2 = null;
            if (spenFavoritePenMiniAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                spenFavoritePenMiniAdapter = null;
            }
            if (spenFavoritePenMiniAdapter.getMCurrentMode() == mode) {
                return;
            }
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter3 = this.mAdapter;
            if (spenFavoritePenMiniAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                spenFavoritePenMiniAdapter3 = null;
            }
            spenFavoritePenMiniAdapter3.setMode(mode);
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter4 = this.mAdapter;
            if (spenFavoritePenMiniAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                spenFavoritePenMiniAdapter4 = null;
            }
            spenFavoritePenMiniAdapter4.setItemAnimation(needAnimation);
            SpenFavoritePenMiniLayoutHelper spenFavoritePenMiniLayoutHelper = this.mLayoutHelper;
            if (spenFavoritePenMiniLayoutHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayoutHelper");
                spenFavoritePenMiniLayoutHelper = null;
            }
            spenFavoritePenMiniLayoutHelper.setRadius(mode);
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter5 = this.mAdapter;
            if (spenFavoritePenMiniAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                spenFavoritePenMiniAdapter5 = null;
            }
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter6 = this.mAdapter;
            if (spenFavoritePenMiniAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                spenFavoritePenMiniAdapter6 = null;
            }
            spenFavoritePenMiniAdapter5.notifyItemRangeChanged(0, spenFavoritePenMiniAdapter6.getItemCount(), 2);
            SpenFavoritePenMiniLayoutHelper spenFavoritePenMiniLayoutHelper2 = this.mLayoutHelper;
            if (spenFavoritePenMiniLayoutHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayoutHelper");
                spenFavoritePenMiniLayoutHelper2 = null;
            }
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter7 = this.mAdapter;
            if (spenFavoritePenMiniAdapter7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            } else {
                spenFavoritePenMiniAdapter2 = spenFavoritePenMiniAdapter7;
            }
            spenFavoritePenMiniLayoutHelper2.updateFavoriteMinSize(this, spenFavoritePenMiniAdapter2);
        }
    }

    public final void setOnPenMiniDragListener(@Nullable OnFavoritePenMiniViewDragListener listener) {
        SpenFavoriteItemDragHelper spenFavoriteItemDragHelper = this.mFavoriteItemDragHelper;
        if (spenFavoriteItemDragHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoriteItemDragHelper");
            spenFavoriteItemDragHelper = null;
        }
        spenFavoriteItemDragHelper.setOnPenMiniDragListener(listener);
    }

    public final void setSelectedItem(int position, boolean focused, boolean needAnimation) {
        if (this.mInitComplete) {
            AbstractC0000a.m27x(AbstractC2821a.m2226q("setSelectedItem() position=", position, " focused=", focused, " animation="), needAnimation, TAG);
            SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = this.mAdapter;
            SpenRecyclerView spenRecyclerView = null;
            if (spenFavoritePenMiniAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                spenFavoritePenMiniAdapter = null;
            }
            int mSelectedPosition = spenFavoritePenMiniAdapter.getMSelectedPosition();
            if (mSelectedPosition != position) {
                SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter2 = this.mAdapter;
                if (spenFavoritePenMiniAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    spenFavoritePenMiniAdapter2 = null;
                }
                spenFavoritePenMiniAdapter2.setSelectedPosition(position);
                if (getMode() == 2) {
                    return;
                }
                SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter3 = this.mAdapter;
                if (spenFavoritePenMiniAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    spenFavoritePenMiniAdapter3 = null;
                }
                spenFavoritePenMiniAdapter3.setItemAnimation(needAnimation);
                if (mSelectedPosition != -1) {
                    SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter4 = this.mAdapter;
                    if (spenFavoritePenMiniAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        spenFavoritePenMiniAdapter4 = null;
                    }
                    spenFavoritePenMiniAdapter4.notifyItemChanged(mSelectedPosition);
                }
                if (position != -1) {
                    SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter5 = this.mAdapter;
                    if (spenFavoritePenMiniAdapter5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                        spenFavoritePenMiniAdapter5 = null;
                    }
                    spenFavoritePenMiniAdapter5.notifyItemChanged(position);
                }
            }
            if (!focused || position == -1 || moveToPosition(position, needAnimation)) {
                return;
            }
            SpenRecyclerView spenRecyclerView2 = this.mFavoriteView;
            if (spenRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoriteView");
            } else {
                spenRecyclerView = spenRecyclerView2;
            }
            spenRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.mRecyclerViewListener);
        }
    }

    public final boolean updateFavorite(int index, @NotNull SpenSettingUIPenInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        Log.i(TAG, "updateFavorite()");
        if (!this.mInitComplete) {
            return false;
        }
        SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = this.mAdapter;
        if (spenFavoritePenMiniAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            spenFavoritePenMiniAdapter = null;
        }
        return spenFavoritePenMiniAdapter.updatePen(index, info);
    }
}
