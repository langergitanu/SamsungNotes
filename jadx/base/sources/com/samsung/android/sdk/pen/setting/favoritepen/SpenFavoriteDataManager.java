package com.samsung.android.sdk.pen.setting.favoritepen;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t\b\u0001\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006J\u0010\u0010\u001f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J\u0006\u0010 \u001a\u00020\u000bJ\u0010\u0010#\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J \u0010\u0015\u001a\u00020\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001d2\u0006\u0010$\u001a\u00020\rH\u0002J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010!\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDataManager;", "", "<init>", "()V", "mFavoriteList", "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "mDeleteList", "", "mSelectedIndex", "close", "", "addFavorite", "", "info", "updateFavorite", "index", XmlErrorCodes.LIST, "favoriteList", "getFavoriteList", "()Ljava/util/List;", "setFavoriteList", "(Ljava/util/List;)V", "selectedIndex", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "deleteList", "", "getDeleteList", "addDeleteFavoritePen", "clearDeleteList", "favoriteCount", "getFavoriteCount", "findSelectedIndex", "autoSelectedCheck", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
@SourceDebugExtension({"SMAP\nSpenFavoriteDataManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenFavoriteDataManager.kt\ncom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDataManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
public final class SpenFavoriteDataManager {

    @NotNull
    private static final String TAG = "SpenSettingFavoritePenManager";
    private int mSelectedIndex = -1;

    @NotNull
    private List<SpenSettingUIPenInfo> mFavoriteList = new ArrayList();

    @NotNull
    private List<Integer> mDeleteList = new ArrayList();

    private final int findSelectedIndex(SpenSettingUIPenInfo info) {
        int size = this.mFavoriteList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            if (Intrinsics.areEqual(info, this.mFavoriteList.get(i))) {
                break;
            }
            i++;
        }
        AbstractC2322a.m1631u(i, "findSelectedIndex() index=", TAG);
        return i;
    }

    public final void addDeleteFavoritePen(@Nullable SpenSettingUIPenInfo info) {
        if (info == null) {
            return;
        }
        this.mDeleteList.add(Integer.valueOf(findSelectedIndex(info)));
    }

    public final boolean addFavorite(@Nullable SpenSettingUIPenInfo info) {
        return addFavorite(this.mFavoriteList.size(), info);
    }

    public final void clearDeleteList() {
        this.mDeleteList.clear();
    }

    public final void close() {
        this.mFavoriteList.clear();
        this.mDeleteList.clear();
    }

    @Nullable
    public final List<Integer> getDeleteList() {
        if (this.mDeleteList.isEmpty()) {
            return null;
        }
        CollectionsKt.sort(this.mDeleteList);
        return new ArrayList(this.mDeleteList);
    }

    public final int getFavoriteCount() {
        return this.mFavoriteList.size();
    }

    @Nullable
    public final List<SpenSettingUIPenInfo> getFavoriteList() {
        return new ArrayList(this.mFavoriteList);
    }

    /* JADX INFO: renamed from: getSelectedIndex, reason: from getter */
    public final int getMSelectedIndex() {
        return this.mSelectedIndex;
    }

    public final void setFavoriteList(@Nullable List<SpenSettingUIPenInfo> list) {
        setFavoriteList(list, false);
    }

    public final void setSelectedIndex(int i) {
        if (this.mSelectedIndex == i) {
            return;
        }
        this.mSelectedIndex = i;
        int size = this.mFavoriteList.size();
        if (i > -1 && i >= size) {
            this.mSelectedIndex = -1;
        }
        AbstractC2322a.m1631u(i, "setSelectedIndex() index=", TAG);
    }

    public final boolean updateFavorite(int index, @NotNull SpenSettingUIPenInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (index < 0 || index >= this.mFavoriteList.size()) {
            return false;
        }
        this.mFavoriteList.set(index, new SpenSettingUIPenInfo(info));
        return true;
    }

    private final boolean addFavorite(int index, SpenSettingUIPenInfo info) {
        if (index < 0 || index > this.mFavoriteList.size() || info == null) {
            return false;
        }
        int mSelectedIndex = getMSelectedIndex();
        if (mSelectedIndex != -1 && index <= mSelectedIndex) {
            setSelectedIndex(index + 1);
        }
        this.mFavoriteList.add(index, new SpenSettingUIPenInfo(info));
        return true;
    }

    private final void setFavoriteList(List<? extends SpenSettingUIPenInfo> list, boolean autoSelectedCheck) {
        int i;
        SpenSettingUIPenInfo spenSettingUIPenInfo = (!autoSelectedCheck || (i = this.mSelectedIndex) == -1) ? null : this.mFavoriteList.get(i);
        this.mFavoriteList.clear();
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mFavoriteList.add(new SpenSettingUIPenInfo(list.get(i2)));
        }
        int iFindSelectedIndex = spenSettingUIPenInfo != null ? findSelectedIndex(spenSettingUIPenInfo) : -1;
        this.mSelectedIndex = iFindSelectedIndex;
        Log.i(TAG, "setFavoriteList() autoSelectedCheck=" + autoSelectedCheck + " mSelectedIndex=" + iFindSelectedIndex);
    }
}
