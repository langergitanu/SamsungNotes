package com.samsung.android.support.senl.p148nt.stt.picker.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\bR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/model/FilterInfo;", "", "timeFilterNone", "", "<init>", "(I)V", "time", "mIsShowFilter", "", "mIsShowHistorySearch", "getTime", "setTime", "", "isShowFilter", "setIsShowFilter", "isShowHistorySearch", "setIsShowHistorySearch", "hasTimeFilter", "FilterConstant", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FilterInfo {
    private boolean mIsShowFilter = true;
    private boolean mIsShowHistorySearch = true;
    private int time;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/model/FilterInfo$FilterConstant;", "", "<init>", "()V", "TIME_FILTER_NONE", "", "TIME_FILTER_YESTERDAY", "TIME_FILTER_PAST_7_DAYS", "TIME_FILTER_PAST_30_DAYS", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class FilterConstant {

        @NotNull
        public static final FilterConstant INSTANCE = new FilterConstant();
        public static final int TIME_FILTER_NONE = -1;
        public static final int TIME_FILTER_PAST_30_DAYS = 2;
        public static final int TIME_FILTER_PAST_7_DAYS = 1;
        public static final int TIME_FILTER_YESTERDAY = 0;

        private FilterConstant() {
        }
    }

    public FilterInfo(int i) {
        this.time = i;
    }

    public final int getTime() {
        return this.time;
    }

    public final boolean hasTimeFilter() {
        return this.time != -1;
    }

    /* JADX INFO: renamed from: isShowFilter, reason: from getter */
    public final boolean getMIsShowFilter() {
        return this.mIsShowFilter;
    }

    /* JADX INFO: renamed from: isShowHistorySearch, reason: from getter */
    public final boolean getMIsShowHistorySearch() {
        return this.mIsShowHistorySearch;
    }

    public final void setIsShowFilter(boolean mIsShowFilter) {
        this.mIsShowFilter = mIsShowFilter;
    }

    public final void setIsShowHistorySearch(boolean mIsShowHistorySearch) {
        this.mIsShowHistorySearch = mIsShowHistorySearch;
    }

    public final void setTime(int time) {
        this.time = time;
    }
}
