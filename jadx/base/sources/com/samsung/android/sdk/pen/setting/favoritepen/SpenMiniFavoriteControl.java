package com.samsung.android.sdk.pen.setting.favoritepen;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.common.SpenLayoutConfigHelper;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniLayoutV2;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0006J\u0016\u0010(\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u001aJ\u001e\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001aJ\u0018\u00106\u001a\u00020%2\u000e\u00107\u001a\n\u0012\u0004\u0012\u000203\u0018\u000102H\u0016J\u0012\u00108\u001a\u00020\u001a2\b\u00109\u001a\u0004\u0018\u000103H\u0016J\u001a\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u000103H\u0016J\u0012\u0010<\u001a\u00020%2\b\u0010=\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010>\u001a\u00020\u001aJ\b\u0010?\u001a\u00020\u001aH\u0002J\u0018\u0010@\u001a\u00020\u001a2\u0010\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u00010AJ\u0010\u0010B\u001a\u00020%2\b\u0010=\u001a\u0004\u0018\u00010\u0013J\u0010\u0010C\u001a\u00020%2\b\u0010=\u001a\u0004\u0018\u00010\u0015J\u0010\u0010D\u001a\u00020%2\b\u0010=\u001a\u0004\u0018\u00010\u0017J\b\u0010E\u001a\u00020%H\u0016J\b\u0010F\u001a\u00020%H\u0016J\u0010\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020\u0006H\u0016J\b\u0010I\u001a\u00020\u001aH\u0016J\b\u0010J\u001a\u00020%H\u0016J\u0012\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010M\u001a\u0004\u0018\u00010LH\u0016J\u0010\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\u001aH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u000e\u0010!\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b+\u0010\u001dR\u0011\u0010/\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b0\u0010\u001dR\u0019\u00101\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001028F¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006Q"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenMiniFavoriteControl;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteMiniViewInterface;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteData;", "context", "Landroid/content/Context;", "maxCount", "", "<init>", "(Landroid/content/Context;I)V", "mFavoriteDataManager", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDataManager;", "mLayoutConfigHelper", "Lcom/samsung/android/sdk/pen/setting/common/SpenLayoutConfigHelper;", "mBackupEditFavorite", "mFavoriteLayout", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniLayoutV2;", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDataChangedListener;", "mAddButtonClickListener", "Landroid/view/View$OnClickListener;", "mViewItemClickListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteViewItemClickListener;", "mViewDragListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/OnFavoritePenMiniViewDragListener;", "mColorTheme", "mIsDataChangedByUser", "", "mMaxCount", "getMaxCount", "()I", "value", "mode", "getMode", "mOnDataChangedListener", "mOnItemEventListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniLayoutV2$ItemEventListener;", "close", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setMode", "needAnimation", "selectedItem", "getSelectedItem", "setSelectedItem", "position", "focused", "favoriteCount", "getFavoriteCount", "favoriteList", "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "getFavoriteList", "()Ljava/util/List;", "setFavoriteList", XmlErrorCodes.LIST, "addFavorite", "info", "updateFavorite", "index", "setFavoriteDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "applyFavoriteFromView", "applyFavoriteToView", "isSameFavoriteList", "", "setAddButtonClickListener", "setViewItemClickListener", "setOnPenMiniDragListener", "saveViewState", "restoreViewState", "setViewOrientation", "orientation", "hasView", "clearView", "getView", "Landroid/view/View;", "getContainerView", "isNotReady", "containView", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenMiniFavoriteControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenMiniFavoriteControl.kt\ncom/samsung/android/sdk/pen/setting/favoritepen/SpenMiniFavoriteControl\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,311:1\n37#2,2:312\n*S KotlinDebug\n*F\n+ 1 SpenMiniFavoriteControl.kt\ncom/samsung/android/sdk/pen/setting/favoritepen/SpenMiniFavoriteControl\n*L\n211#1:312,2\n*E\n"})
public final class SpenMiniFavoriteControl implements SpenFavoriteMiniViewInterface, SpenFavoriteData {

    @NotNull
    private static final String TAG = "SpenMiniFavoriteControl";

    @Nullable
    private View.OnClickListener mAddButtonClickListener;

    @Nullable
    private SpenFavoriteDataManager mBackupEditFavorite;
    private int mColorTheme;

    @Nullable
    private SpenFavoriteDataChangedListener mDataChangedListener;

    @NotNull
    private SpenFavoriteDataManager mFavoriteDataManager;

    @Nullable
    private SpenFavoritePenMiniLayoutV2 mFavoriteLayout;
    private boolean mIsDataChangedByUser;

    @NotNull
    private SpenLayoutConfigHelper mLayoutConfigHelper;
    private final int mMaxCount;

    @NotNull
    private final SpenFavoriteDataChangedListener mOnDataChangedListener;

    @NotNull
    private final SpenFavoritePenMiniLayoutV2.ItemEventListener mOnItemEventListener;

    @Nullable
    private OnFavoritePenMiniViewDragListener mViewDragListener;

    @Nullable
    private SpenFavoriteViewItemClickListener mViewItemClickListener;
    private int mode;

    public SpenMiniFavoriteControl(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFavoriteDataManager = new SpenFavoriteDataManager();
        this.mLayoutConfigHelper = new SpenLayoutConfigHelper(context, 1);
        this.mMaxCount = i;
        this.mode = 1;
        this.mOnDataChangedListener = new SpenFavoriteDataChangedListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenMiniFavoriteControl$mOnDataChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteDataChangedListener
            public void onFavoriteDataChanged(List<SpenSettingUIPenInfo> list) {
                if (this.this$0.isNotReady(true)) {
                    return;
                }
                this.this$0.mFavoriteDataManager.setFavoriteList(list);
                SpenFavoriteDataManager spenFavoriteDataManager = this.this$0.mFavoriteDataManager;
                SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2 = this.this$0.mFavoriteLayout;
                spenFavoriteDataManager.setSelectedIndex(spenFavoritePenMiniLayoutV2 != null ? spenFavoritePenMiniLayoutV2.getSelectedItem() : 0);
                Log.i("SpenMiniFavoriteControl", "onFavoriteDataChanged() size=" + (list != null ? Integer.valueOf(list.size()) : null));
                SpenFavoriteDataChangedListener spenFavoriteDataChangedListener = this.this$0.mDataChangedListener;
                if (spenFavoriteDataChangedListener != null) {
                    spenFavoriteDataChangedListener.onFavoriteDataChanged(list);
                }
            }
        };
        this.mOnItemEventListener = new SpenFavoritePenMiniLayoutV2.ItemEventListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenMiniFavoriteControl$mOnItemEventListener$1
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniLayoutV2.ItemEventListener
            public void onAddItemClick() {
                Log.i("SpenMiniFavoriteControl", "AddButtonClick() ");
                View.OnClickListener onClickListener = this.this$0.mAddButtonClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(null);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniLayoutV2.ItemEventListener
            public void onItemClick(int mode, int position, SpenSettingUIPenInfo info) {
                SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2;
                Intrinsics.checkNotNullParameter(info, "info");
                if (this.this$0.isNotReady(false)) {
                    return;
                }
                if (this.this$0.getMode() != 2) {
                    this.this$0.mFavoriteDataManager.setSelectedIndex(position);
                    SpenFavoriteViewItemClickListener spenFavoriteViewItemClickListener = this.this$0.mViewItemClickListener;
                    if (spenFavoriteViewItemClickListener != null) {
                        spenFavoriteViewItemClickListener.onViewItemClick(info);
                        return;
                    }
                    return;
                }
                this.this$0.mFavoriteDataManager.addDeleteFavoritePen(info);
                this.this$0.mIsDataChangedByUser = true;
                if (this.this$0.hasView() && (spenFavoritePenMiniLayoutV2 = this.this$0.mFavoriteLayout) != null) {
                    spenFavoritePenMiniLayoutV2.deleteFavorite(position);
                }
            }
        };
        this.mColorTheme = 0;
        this.mode = 1;
        this.mIsDataChangedByUser = false;
    }

    private final boolean applyFavoriteToView() {
        if (isNotReady(true)) {
            return false;
        }
        AbstractC2322a.m1631u(this.mode, "applyFavoriteToView() mode= ", TAG);
        SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2 = this.mFavoriteLayout;
        if (spenFavoritePenMiniLayoutV2 != null && !spenFavoritePenMiniLayoutV2.restoreFavoriteList(this.mFavoriteDataManager.getFavoriteList(), this.mFavoriteDataManager.getDeleteList(), this.mFavoriteDataManager.getMSelectedIndex())) {
            return false;
        }
        this.mFavoriteDataManager.clearDeleteList();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isNotReady(boolean containView) {
        return containView && !hasView();
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public boolean addFavorite(@Nullable SpenSettingUIPenInfo info) {
        if (isNotReady(true)) {
            return false;
        }
        Log.i(TAG, "addFavorite()");
        SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2 = this.mFavoriteLayout;
        if (spenFavoritePenMiniLayoutV2 != null) {
            if (!spenFavoritePenMiniLayoutV2.needScroll()) {
                Log.i(TAG, "==== Don't need scroll ===");
                if (!this.mFavoriteDataManager.addFavorite(info)) {
                    return false;
                }
                spenFavoritePenMiniLayoutV2.setFavoriteList(this.mFavoriteDataManager.getFavoriteList());
                return true;
            }
            Log.i(TAG, "==== Has scroll ===");
            if (spenFavoritePenMiniLayoutV2.addFavorite(info, true) && this.mFavoriteDataManager.addFavorite(info)) {
                this.mFavoriteDataManager.setSelectedIndex(spenFavoritePenMiniLayoutV2.getSelectedItem());
                return true;
            }
        }
        return false;
    }

    public final boolean applyFavoriteFromView() {
        Log.i(TAG, "applyFavoriteInView()");
        if (isNotReady(true)) {
            return false;
        }
        SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2 = this.mFavoriteLayout;
        if (isSameFavoriteList(spenFavoritePenMiniLayoutV2 != null ? spenFavoritePenMiniLayoutV2.getFavoriteList() : null)) {
            Log.i(TAG, "Is Same FavoriteList.");
            return false;
        }
        SpenFavoriteDataManager spenFavoriteDataManager = this.mFavoriteDataManager;
        SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV22 = this.mFavoriteLayout;
        spenFavoriteDataManager.setFavoriteList(spenFavoritePenMiniLayoutV22 != null ? spenFavoritePenMiniLayoutV22.getFavoriteList() : null);
        SpenFavoriteDataManager spenFavoriteDataManager2 = this.mFavoriteDataManager;
        SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV23 = this.mFavoriteLayout;
        spenFavoriteDataManager2.setSelectedIndex(spenFavoritePenMiniLayoutV23 != null ? spenFavoritePenMiniLayoutV23.getSelectedItem() : 0);
        this.mFavoriteDataManager.clearDeleteList();
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteMiniViewInterface
    public void clearView() {
        if (hasView()) {
            SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2 = this.mFavoriteLayout;
            if (spenFavoritePenMiniLayoutV2 != null) {
                spenFavoritePenMiniLayoutV2.close();
            }
            this.mFavoriteLayout = null;
        }
    }

    public final void close() {
        if (isNotReady(false)) {
            return;
        }
        this.mFavoriteDataManager.close();
        SpenFavoriteDataManager spenFavoriteDataManager = this.mBackupEditFavorite;
        if (spenFavoriteDataManager != null) {
            spenFavoriteDataManager.close();
        }
        this.mBackupEditFavorite = null;
        SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2 = this.mFavoriteLayout;
        if (spenFavoritePenMiniLayoutV2 != null) {
            spenFavoritePenMiniLayoutV2.close();
        }
        this.mFavoriteLayout = null;
        this.mDataChangedListener = null;
        this.mAddButtonClickListener = null;
        this.mViewItemClickListener = null;
        this.mViewDragListener = null;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteMiniViewInterface
    @Nullable
    public View getContainerView() {
        SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2;
        if (!hasView() || (spenFavoritePenMiniLayoutV2 = this.mFavoriteLayout) == null) {
            return null;
        }
        return spenFavoritePenMiniLayoutV2.getFavoriteContainer();
    }

    public final int getFavoriteCount() {
        if (isNotReady(false)) {
            return 0;
        }
        return this.mFavoriteDataManager.getFavoriteCount();
    }

    @Nullable
    public final List<SpenSettingUIPenInfo> getFavoriteList() {
        return isNotReady(false) ? new ArrayList() : this.mFavoriteDataManager.getFavoriteList();
    }

    /* JADX INFO: renamed from: getMaxCount, reason: from getter */
    public final int getMMaxCount() {
        return this.mMaxCount;
    }

    public final int getMode() {
        return this.mode;
    }

    public final int getSelectedItem() {
        Log.i(TAG, "getSelectedItem()");
        if (isNotReady(false)) {
            return -1;
        }
        return this.mFavoriteDataManager.getMSelectedIndex();
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteMiniViewInterface
    @Nullable
    public View getView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isNotReady(false)) {
            return null;
        }
        Log.i(TAG, "getView() orientation=" + this.mLayoutConfigHelper.getMOrientation());
        if (hasView()) {
            return this.mFavoriteLayout;
        }
        SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2 = new SpenFavoritePenMiniLayoutV2(context, getMMaxCount(), this.mLayoutConfigHelper.getMOrientation());
        this.mFavoriteLayout = spenFavoritePenMiniLayoutV2;
        spenFavoritePenMiniLayoutV2.setMode(spenFavoritePenMiniLayoutV2.getMode(), false);
        spenFavoritePenMiniLayoutV2.setColorTheme(this.mColorTheme);
        spenFavoritePenMiniLayoutV2.setFavoriteDataChangedListener(this.mOnDataChangedListener);
        spenFavoritePenMiniLayoutV2.setItemEventListener(this.mOnItemEventListener);
        return this.mFavoriteLayout;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteMiniViewInterface
    public boolean hasView() {
        return this.mFavoriteLayout != null;
    }

    public final boolean isSameFavoriteList(@Nullable List<? extends SpenSettingUIPenInfo> list) {
        SpenSettingUIPenInfo[] spenSettingUIPenInfoArr;
        List<SpenSettingUIPenInfo> favoriteList = getFavoriteList();
        if (favoriteList == null) {
            return false;
        }
        return (list == null || (spenSettingUIPenInfoArr = (SpenSettingUIPenInfo[]) list.toArray(new SpenSettingUIPenInfo[0])) == null) ? favoriteList.isEmpty() : Arrays.equals(spenSettingUIPenInfoArr, favoriteList.toArray(new SpenSettingUIPenInfo[0]));
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteMiniViewInterface
    public void restoreViewState() {
        SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2;
        SpenFavoriteDataManager spenFavoriteDataManager;
        if (isNotReady(true) || (spenFavoritePenMiniLayoutV2 = this.mFavoriteLayout) == null) {
            return;
        }
        if (this.mode != 2 || (spenFavoriteDataManager = this.mBackupEditFavorite) == null) {
            spenFavoritePenMiniLayoutV2.setFavoriteList(this.mFavoriteDataManager.getFavoriteList());
            spenFavoritePenMiniLayoutV2.setSelectedItem(this.mFavoriteDataManager.getMSelectedIndex(), true, false);
        } else {
            spenFavoritePenMiniLayoutV2.setFavoriteList(spenFavoriteDataManager != null ? spenFavoriteDataManager.getFavoriteList() : null);
            SpenFavoriteDataManager spenFavoriteDataManager2 = this.mBackupEditFavorite;
            spenFavoritePenMiniLayoutV2.setSelectedItem(spenFavoriteDataManager2 != null ? spenFavoriteDataManager2.getMSelectedIndex() : 0, true, false);
        }
        SpenFavoriteDataManager spenFavoriteDataManager3 = this.mBackupEditFavorite;
        if (spenFavoriteDataManager3 != null) {
            spenFavoriteDataManager3.close();
        }
        this.mBackupEditFavorite = null;
        OnFavoritePenMiniViewDragListener onFavoritePenMiniViewDragListener = this.mViewDragListener;
        if (onFavoritePenMiniViewDragListener == null) {
            return;
        }
        spenFavoritePenMiniLayoutV2.setOnPenMiniDragListener(onFavoritePenMiniViewDragListener);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteMiniViewInterface
    public void saveViewState() {
        if (isNotReady(true)) {
            return;
        }
        AbstractC2322a.m1631u(this.mode, "saveViewState() mode= ", TAG);
        if (this.mode == 2) {
            SpenFavoriteDataManager spenFavoriteDataManager = new SpenFavoriteDataManager();
            this.mBackupEditFavorite = spenFavoriteDataManager;
            SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2 = this.mFavoriteLayout;
            if (spenFavoritePenMiniLayoutV2 != null) {
                spenFavoriteDataManager.setFavoriteList(spenFavoritePenMiniLayoutV2.getFavoriteList());
                spenFavoriteDataManager.setSelectedIndex(spenFavoritePenMiniLayoutV2.getSelectedItem());
            }
        }
    }

    public final void setAddButtonClickListener(@Nullable View.OnClickListener listener) {
        this.mAddButtonClickListener = listener;
    }

    public final void setColorTheme(int theme) {
        SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2;
        AbstractC6670b.m4744e(this.mColorTheme, theme, "setColorTheme() [", "->", TAG);
        if (this.mColorTheme == theme) {
            return;
        }
        this.mColorTheme = theme;
        if (hasView() && (spenFavoritePenMiniLayoutV2 = this.mFavoriteLayout) != null) {
            spenFavoritePenMiniLayoutV2.setColorTheme(theme);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public void setFavoriteDataChangedListener(@Nullable SpenFavoriteDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public void setFavoriteList(@Nullable List<SpenSettingUIPenInfo> list) {
        SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2;
        if (isNotReady(false)) {
            return;
        }
        AbstractC2322a.m1631u(list != null ? list.size() : 0, "setFavoriteList() size=", TAG);
        this.mFavoriteDataManager.setFavoriteList(list);
        if (hasView() && (spenFavoritePenMiniLayoutV2 = this.mFavoriteLayout) != null) {
            spenFavoritePenMiniLayoutV2.setFavoriteList(list);
        }
        this.mFavoriteDataManager.clearDeleteList();
    }

    public final boolean setMode(int mode, boolean needAnimation) {
        SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2;
        AbstractC0000a.m27x(AbstractC0622a.m1173s(this.mode, mode, "setMode() mode=[", "->", "] needAnimation="), needAnimation, TAG);
        int i = this.mode;
        if (i == mode) {
            return false;
        }
        if (i == 2 && this.mIsDataChangedByUser) {
            applyFavoriteToView();
        }
        this.mIsDataChangedByUser = false;
        this.mode = mode;
        if (!hasView() || (spenFavoritePenMiniLayoutV2 = this.mFavoriteLayout) == null) {
            return true;
        }
        spenFavoritePenMiniLayoutV2.setMode(mode, needAnimation);
        return true;
    }

    public final void setOnPenMiniDragListener(@Nullable OnFavoritePenMiniViewDragListener listener) {
        SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2;
        this.mViewDragListener = listener;
        if (hasView() && (spenFavoritePenMiniLayoutV2 = this.mFavoriteLayout) != null) {
            spenFavoritePenMiniLayoutV2.setOnPenMiniDragListener(this.mViewDragListener);
        }
    }

    public final void setSelectedItem(int position, boolean focused, boolean needAnimation) {
        SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2;
        if (isNotReady(false)) {
            return;
        }
        if (hasView() && (spenFavoritePenMiniLayoutV2 = this.mFavoriteLayout) != null) {
            spenFavoritePenMiniLayoutV2.setSelectedItem(position, focused, needAnimation);
        }
        this.mFavoriteDataManager.setSelectedIndex(position);
    }

    public final void setViewItemClickListener(@Nullable SpenFavoriteViewItemClickListener listener) {
        this.mViewItemClickListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteMiniViewInterface
    public void setViewOrientation(int orientation) {
        if (isNotReady(false)) {
            return;
        }
        AbstractC6670b.m4754o("setViewOrientation=", orientation, " hasView=", hasView(), TAG);
        this.mLayoutConfigHelper.setOrientation(orientation);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public boolean updateFavorite(int index, @Nullable SpenSettingUIPenInfo info) {
        if (isNotReady(true)) {
            return false;
        }
        AbstractC2322a.m1631u(index, "updateFavorite() index=", TAG);
        if (this.mode != 1 || info == null) {
            Log.i(TAG, "updateFavorite is possible in ViewMode.");
            return false;
        }
        SpenFavoritePenMiniLayoutV2 spenFavoritePenMiniLayoutV2 = this.mFavoriteLayout;
        if (spenFavoritePenMiniLayoutV2 != null) {
            if (!spenFavoritePenMiniLayoutV2.updateFavorite(index, info)) {
                return false;
            }
            this.mFavoriteDataManager.setFavoriteList(spenFavoritePenMiniLayoutV2.getFavoriteList());
            this.mFavoriteDataManager.setSelectedIndex(spenFavoritePenMiniLayoutV2.getSelectedItem());
        }
        return true;
    }
}
