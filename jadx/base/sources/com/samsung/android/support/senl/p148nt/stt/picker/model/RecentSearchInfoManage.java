package com.samsung.android.support.senl.p148nt.stt.picker.model;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.picker.utils.PreferenceUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ&\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\bJ\u001e\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0002J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0006J\u0016\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/model/RecentSearchInfoManage;", "", "<init>", "()V", "mRecentSearchList", "", "", "loadRecentSearchSize", "", "context", "Landroid/content/Context;", "loadRecentSearch", "", XmlErrorCodes.LIST, "size", "saveRecentSearch", "", "addRecentSearch", "searchText", "removeRecentSearch", "index", "removeAllRecentSearch", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RecentSearchInfoManage {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_SIZE = 10;

    @NotNull
    private static final String PICKER_RECENT_V1 = "_stt_picker_recent_v1";

    @NotNull
    private static final String RECENT_SEARCH = "stt_picker_recent_search_";

    @NotNull
    private static final String RECENT_SEARCH_NUM = "stt_picker_recent_search_num";

    @NotNull
    private static final String TAG = "RecentSearchInfoManage";

    @NotNull
    private List<String> mRecentSearchList = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/model/RecentSearchInfoManage$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "PICKER_RECENT_V1", "RECENT_SEARCH_NUM", "RECENT_SEARCH", "MAX_SIZE", "", "getInstance", "Lcom/samsung/android/support/senl/nt/stt/picker/model/RecentSearchInfoManage;", "RecentSearchInfoManageHolder", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/model/RecentSearchInfoManage$Companion$RecentSearchInfoManageHolder;", "", "<init>", "()V", "instance", "Lcom/samsung/android/support/senl/nt/stt/picker/model/RecentSearchInfoManage;", "getInstance", "()Lcom/samsung/android/support/senl/nt/stt/picker/model/RecentSearchInfoManage;", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class RecentSearchInfoManageHolder {

            @NotNull
            public static final RecentSearchInfoManageHolder INSTANCE = new RecentSearchInfoManageHolder();

            @NotNull
            private static final RecentSearchInfoManage instance = new RecentSearchInfoManage();

            private RecentSearchInfoManageHolder() {
            }

            @NotNull
            public final RecentSearchInfoManage getInstance() {
                return instance;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RecentSearchInfoManage getInstance() {
            return RecentSearchInfoManageHolder.INSTANCE.getInstance();
        }

        private Companion() {
        }
    }

    private final void saveRecentSearch(Context context, List<String> list) {
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i++;
            PreferenceUtils.INSTANCE.putString(context, PICKER_RECENT_V1, AbstractC0000a.m11h(i2, RECENT_SEARCH), list.get(i2));
        }
        PreferenceUtils.INSTANCE.putInt(context, PICKER_RECENT_V1, RECENT_SEARCH_NUM, i);
    }

    public final void addRecentSearch(@NotNull Context context, @NotNull String searchText) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        int size = this.mRecentSearchList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            if (Intrinsics.areEqual(searchText, this.mRecentSearchList.get(i2))) {
                i = i2;
            }
        }
        if (i == -1 && size == 10) {
            i = 9;
        }
        if (i != -1) {
            this.mRecentSearchList.remove(i);
        }
        this.mRecentSearchList.add(0, searchText);
        saveRecentSearch(context, this.mRecentSearchList);
    }

    public final void loadRecentSearch(@NotNull Context context, @Nullable List<String> list, int size) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (list != null) {
            for (int i = 0; i < size; i++) {
                list.add(String.valueOf(PreferenceUtils.INSTANCE.getString(context, PICKER_RECENT_V1, AbstractC0000a.m11h(i, RECENT_SEARCH), "")));
            }
            this.mRecentSearchList = list;
        }
    }

    public final int loadRecentSearchSize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = PreferenceUtils.INSTANCE.getInt(context, PICKER_RECENT_V1, RECENT_SEARCH_NUM, 0);
        Logger.m12710d(TAG, "loadRecentSearchSize# " + i);
        return i;
    }

    public final void removeAllRecentSearch(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRecentSearchList.clear();
        saveRecentSearch(context, this.mRecentSearchList);
    }

    public final void removeRecentSearch(@NotNull Context context, int index) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRecentSearchList.remove(index);
        saveRecentSearch(context, this.mRecentSearchList);
    }
}
