package com.samsung.android.sdk.pen.setting.favoritepen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilColor;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0014\n\u0002\b\u000e\b!\u0018\u0000 I2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003:\u0001IB'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0007J\u001e\u0010#\u001a\u00020 2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010$\u001a\u00020%J\u0016\u0010*\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\nJ\u0016\u0010,\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\nJ\u0010\u0010-\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u0016\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007J\u0016\u00101\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u00102\u001a\u00020%J\u0010\u00105\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001d\u001a\u00020\u0007J\u0010\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007H\u0004J\u0012\u0010:\u001a\u0004\u0018\u00010\u00172\u0006\u0010;\u001a\u00020<H\u0004J\u0018\u0010B\u001a\u00020 2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\nH\u0002J\u001c\u0010E\u001a\u00020%2\b\u0010F\u001a\u0004\u0018\u00010\n2\b\u0010G\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010H\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u00102\u001a\u00020%H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u001bR4\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00142\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b#\u0010)R\u0011\u00103\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b4\u0010\u000eR\u0011\u00106\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b7\u0010\u000eR\u0014\u0010=\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u000eR$\u0010?\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010\u000e\"\u0004\bA\u0010\u001b¨\u0006J"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenBaseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMode;", "mContext", "Landroid/content/Context;", "maxCount", "", XmlErrorCodes.LIST, "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "<init>", "(Landroid/content/Context;ILjava/util/List;)V", "getMaxCount", "()I", "mColorThemeUtil", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorThemeUtil;", "mColorUtil", "Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilColor;", "mList", "", "mSelectedPosition", "mUndefinedColorName", "", "mode", "getMode", "setMode", "(I)V", "getItemViewType", "position", "getItemCount", "close", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setFavoriteList", "applyNow", "", "favoriteList", "getFavoriteList", "()Ljava/util/List;", "(Ljava/util/List;)V", "addPen", "info", "updatePen", "deletePen", "changePen", "fromPosition", "toPosition", "changeSelectPen", "needAnimation", "favoritePenCount", "getFavoritePenCount", "getPenInfo", "penCount", "getPenCount", "getVisiblePenColor", "color", "getColorName", "hsvColor", "", "itemOffset", "getItemOffset", "selectedPosition", "getSelectedPosition", "setSelectedPosition", "initList", "source", "findPenPosition", "isSamePenInfo", "info1", "info2", "selectAnimation", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
@SourceDebugExtension({"SMAP\nSpenFavoritePenBaseAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenFavoritePenBaseAdapter.kt\ncom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenBaseAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,264:1\n1#2:265\n*E\n"})
public abstract class SpenFavoritePenBaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements SpenFavoritePenMode {
    public static final int CHANGE_MODE = 2;
    public static final int CHANGE_SELECT = 1;
    public static final int NO_POSITION = -1;

    @NotNull
    private static final String TAG = "SpenFavoritePenBaseAdapter";
    public static final int VIEW_TYPE_ADD = 2;
    public static final int VIEW_TYPE_PEN = 1;

    @NotNull
    private SpenColorThemeUtil mColorThemeUtil;

    @NotNull
    private SpenSettingUtilColor mColorUtil;

    @Nullable
    private List<SpenSettingUIPenInfo> mList;
    private int mSelectedPosition;

    @NotNull
    private final String mUndefinedColorName;
    private final int maxCount;
    private int mode;

    public SpenFavoritePenBaseAdapter(@NotNull Context mContext, int i, @Nullable List<? extends SpenSettingUIPenInfo> list) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.maxCount = i;
        String string = mContext.getResources().getString(C7932R.string.pen_palette_color_custom);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.mUndefinedColorName = string;
        this.mColorThemeUtil = new SpenColorThemeUtil(mContext);
        this.mColorUtil = new SpenSettingUtilColor(mContext);
        initList(list);
        this.mSelectedPosition = -1;
        this.mode = 1;
    }

    private final int findPenPosition(SpenSettingUIPenInfo info) {
        List<SpenSettingUIPenInfo> list = this.mList;
        if (list == null) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (isSamePenInfo(list.get(i), info)) {
                return i;
            }
        }
        return -1;
    }

    private final void initList(List<? extends SpenSettingUIPenInfo> source) {
        Log.i(TAG, "initList()");
        if (this.mList == null) {
            this.mList = new ArrayList();
        }
        List<SpenSettingUIPenInfo> list = this.mList;
        if (list != null) {
            list.clear();
        }
        List<? extends SpenSettingUIPenInfo> list2 = source;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            List<SpenSettingUIPenInfo> list3 = this.mList;
            if (list3 != null) {
                list3.add(new SpenSettingUIPenInfo(source.get(i)));
            }
        }
    }

    private final boolean isSamePenInfo(SpenSettingUIPenInfo info1, SpenSettingUIPenInfo info2) {
        return info1 != null && info2 != null && info1.name.compareTo(info2.name) == 0 && info1.sizeLevel == info2.sizeLevel && info1.color == info2.color && Float.compare(info1.particleSize, info2.particleSize) == 0 && info1.colorUIInfo == info2.colorUIInfo;
    }

    private final void selectAnimation(int position, boolean needAnimation) {
        if (position != -1) {
            if (needAnimation) {
                notifyItemChanged(position, 1);
            } else {
                notifyItemChanged(position);
            }
        }
    }

    public final boolean addPen(int position, @NotNull SpenSettingUIPenInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        List<SpenSettingUIPenInfo> list = this.mList;
        if (list == null || position < 0 || position > list.size()) {
            return false;
        }
        int i = this.mSelectedPosition;
        if (i > -1 && position <= i) {
            setSelectedPosition(i + 1);
        }
        list.add(position, info);
        if (position < this.maxCount - 1) {
            notifyItemInserted(position);
        } else {
            notifyItemChanged(position);
        }
        return true;
    }

    public final boolean changePen(int fromPosition, int toPosition) {
        Log.i(TAG, AbstractC0622a.m1164j(fromPosition, toPosition, "changePen [", " -> ", "]"));
        List<SpenSettingUIPenInfo> list = this.mList;
        if (list == null || list.size() == 0 || fromPosition >= list.size() || toPosition >= list.size()) {
            return false;
        }
        int i = this.mSelectedPosition;
        if (fromPosition < toPosition) {
            list.add(toPosition + 1, new SpenSettingUIPenInfo(list.get(fromPosition)));
            list.remove(fromPosition);
            int i2 = this.mSelectedPosition;
            if (i2 != -1) {
                if (fromPosition + 1 <= i2 && i2 <= toPosition) {
                    this.mSelectedPosition = i2 - 1;
                } else if (i2 == fromPosition) {
                    this.mSelectedPosition = toPosition;
                }
            }
        } else {
            list.add(toPosition, new SpenSettingUIPenInfo(list.get(fromPosition)));
            list.remove(fromPosition + 1);
            int i4 = this.mSelectedPosition;
            if (i4 != -1) {
                if (toPosition <= i4 && i4 < fromPosition) {
                    this.mSelectedPosition = i4 + 1;
                } else if (i4 == fromPosition) {
                    this.mSelectedPosition = toPosition;
                }
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4765z(new Object[]{Integer.valueOf(i), Integer.valueOf(getMSelectedPosition())}, 2, "changeSelected[%d -> %d]", "format(format, *args)", TAG);
        return true;
    }

    public final boolean changeSelectPen(int position, boolean needAnimation) {
        int mSelectedPosition = getMSelectedPosition();
        if (mSelectedPosition == position) {
            return false;
        }
        setSelectedPosition(position);
        selectAnimation(mSelectedPosition, needAnimation);
        selectAnimation(position, needAnimation);
        return true;
    }

    public void close() {
        List<SpenSettingUIPenInfo> list = this.mList;
        if (list != null) {
            list.clear();
        }
        this.mList = null;
        this.mColorThemeUtil.close();
        this.mColorUtil.close();
    }

    public void deletePen(int position) {
        List<SpenSettingUIPenInfo> list = this.mList;
        if (list == null || getItemViewType(position) != 1) {
            return;
        }
        int i = this.mSelectedPosition;
        if (i > -1) {
            if (i == position) {
                setSelectedPosition(-1);
            } else if (position < i) {
                setSelectedPosition(i - 1);
            }
        }
        list.remove(position);
        notifyItemRemoved(position);
    }

    @Nullable
    public final String getColorName(@NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        String colorName = this.mColorUtil.getColorName(hsvColor);
        return colorName == null ? this.mUndefinedColorName : colorName;
    }

    @Nullable
    public List<SpenSettingUIPenInfo> getFavoriteList() {
        return new ArrayList(this.mList);
    }

    @Deprecated(message = "")
    public final int getFavoritePenCount() {
        List<SpenSettingUIPenInfo> list = this.mList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int itemOffset = getItemOffset();
        List<SpenSettingUIPenInfo> list = this.mList;
        return (list == null || list.size() == 0) ? itemOffset : list.size() + itemOffset;
    }

    public int getItemOffset() {
        return (getMCurrentMode() != 1 || getFavoritePenCount() >= this.maxCount) ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        int itemCount = getItemCount();
        int itemOffset = getItemOffset();
        return (itemCount <= itemOffset || position >= itemCount - itemOffset) ? 2 : 1;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMode
    /* JADX INFO: renamed from: getMode, reason: from getter */
    public int getMCurrentMode() {
        return this.mode;
    }

    public final int getPenCount() {
        List<SpenSettingUIPenInfo> list = this.mList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Nullable
    public final SpenSettingUIPenInfo getPenInfo(int position) {
        List<SpenSettingUIPenInfo> list = this.mList;
        if (list == null || position >= list.size()) {
            return null;
        }
        return new SpenSettingUIPenInfo(list.get(position));
    }

    /* JADX INFO: renamed from: getSelectedPosition, reason: from getter */
    public final int getMSelectedPosition() {
        return this.mSelectedPosition;
    }

    public final int getVisiblePenColor(int color) {
        return this.mColorThemeUtil.getColor(color);
    }

    public final void setColorTheme(int theme) {
        this.mColorThemeUtil.setColorTheme(theme);
    }

    public final void setFavoriteList(@Nullable List<? extends SpenSettingUIPenInfo> list, boolean applyNow) {
        DiffUtil.DiffResult diffResultCalculateDiff;
        if (applyNow) {
            List<SpenSettingUIPenInfo> favoriteList = getFavoriteList();
            Intrinsics.checkNotNull(favoriteList);
            Intrinsics.checkNotNull(list);
            diffResultCalculateDiff = DiffUtil.calculateDiff(new SpenFavoriteDiffUtilCallback(favoriteList, list, this.maxCount, getItemOffset()));
        } else {
            diffResultCalculateDiff = null;
        }
        int i = this.mSelectedPosition;
        SpenSettingUIPenInfo penInfo = i != -1 ? getPenInfo(i) : null;
        initList(list);
        setSelectedPosition(penInfo != null ? findPenPosition(penInfo) : -1);
        if (diffResultCalculateDiff != null) {
            diffResultCalculateDiff.dispatchUpdatesTo(this);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMode
    public void setMode(int i) {
        this.mode = i;
    }

    public final void setSelectedPosition(int i) {
        AbstractC2322a.m1631u(i, "setSelectedPosition=", TAG);
        this.mSelectedPosition = i;
    }

    public final boolean updatePen(int position, @NotNull SpenSettingUIPenInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (this.mList == null || getItemViewType(position) != 1) {
            return false;
        }
        List<SpenSettingUIPenInfo> list = this.mList;
        Intrinsics.checkNotNull(list);
        list.set(position, info);
        notifyItemChanged(position);
        return true;
    }

    public void setFavoriteList(@Nullable List<SpenSettingUIPenInfo> list) {
        String strValueOf = list != null ? Integer.valueOf(list.size()) : "NULL";
        Log.i(TAG, "setFavoriteList() list=" + strValueOf + " selected=" + this.mSelectedPosition);
        setFavoriteList(list, false);
    }
}
