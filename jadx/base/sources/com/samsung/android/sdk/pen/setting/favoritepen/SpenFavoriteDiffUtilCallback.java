package com.samsung.android.sdk.pen.setting.favoritepen;

import androidx.recyclerview.widget.DiffUtil;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u001e\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "mOldList", "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "mNewList", "mMax", "", "mOffset", "<init>", "(Ljava/util/List;Ljava/util/List;II)V", "getOldListSize", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "areContentsFavorite", "isButton", XmlErrorCodes.LIST, "position", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenFavoriteDiffUtilCallback extends DiffUtil.Callback {

    @NotNull
    private static final String TAG = "SpenFavoriteDiffUtilCallback";
    private final int mMax;

    @NotNull
    private final List<SpenSettingUIPenInfo> mNewList;
    private final int mOffset;

    @NotNull
    private final List<SpenSettingUIPenInfo> mOldList;

    /* JADX WARN: Multi-variable type inference failed */
    public SpenFavoriteDiffUtilCallback(@NotNull List<? extends SpenSettingUIPenInfo> mOldList, @NotNull List<? extends SpenSettingUIPenInfo> mNewList, int i, int i2) {
        Intrinsics.checkNotNullParameter(mOldList, "mOldList");
        Intrinsics.checkNotNullParameter(mNewList, "mNewList");
        this.mOldList = mOldList;
        this.mNewList = mNewList;
        this.mMax = i;
        this.mOffset = i2;
    }

    private final boolean areContentsFavorite(int oldItemPosition, int newItemPosition) {
        return oldItemPosition < this.mOldList.size() && newItemPosition < this.mNewList.size();
    }

    private final boolean isButton(List<? extends SpenSettingUIPenInfo> list, int position) {
        int size = list.size();
        return position == size && this.mOffset != 0 && size < this.mMax;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        if (isButton(this.mOldList, oldItemPosition) && isButton(this.mNewList, newItemPosition)) {
            return true;
        }
        return Intrinsics.areEqual(this.mNewList.get(newItemPosition), this.mOldList.get(oldItemPosition));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        if (!areContentsFavorite(oldItemPosition, newItemPosition)) {
            return isButton(this.mOldList, oldItemPosition) && isButton(this.mNewList, newItemPosition);
        }
        SpenSettingUIPenInfo spenSettingUIPenInfo = this.mOldList.get(oldItemPosition);
        SpenSettingUIPenInfo spenSettingUIPenInfo2 = this.mNewList.get(newItemPosition);
        return Intrinsics.areEqual(spenSettingUIPenInfo, spenSettingUIPenInfo2) || Intrinsics.areEqual(spenSettingUIPenInfo2, spenSettingUIPenInfo);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return Math.min(this.mNewList.size() + this.mOffset, this.mMax);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return Math.min(this.mOldList.size() + this.mOffset, this.mMax);
    }
}
