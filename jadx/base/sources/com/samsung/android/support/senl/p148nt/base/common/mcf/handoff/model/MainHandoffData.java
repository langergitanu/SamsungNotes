package com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.model;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.io.Serializable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bJ\u0016\u0010\u001d\u001a\u00020\u00132\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bJ\u0010\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010\u0007J\b\u0010!\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u0007J\b\u0010$\u001a\u0004\u0018\u00010\u0007J\u0010\u0010%\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010\u0007J\b\u0010'\u001a\u0004\u0018\u00010\u0007J\u0010\u0010(\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010\u0007J\b\u0010*\u001a\u0004\u0018\u00010\u0007J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0011H\u0002J\u0006\u0010-\u001a\u00020\u0011J\u0010\u0010.\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u00010\u0000J\u0013\u00100\u001a\u00020\u00112\b\u00101\u001a\u0004\u0018\u000102H\u0096\u0002J\b\u00103\u001a\u00020\u0007H\u0016J\b\u00104\u001a\u000205H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/model/MainHandoffData;", "Ljava/io/Serializable;", "<init>", "()V", "serialVersionUID", "", "mActivityType", "", "mActionType", "mFolderUuid", "mSelectedTags", "", "mCategoryUuid", "mGroupId", "mSpaceId", "mSearchText", "mIsSyncEnabledOnSender", "", "setActivityType", "", "activityType", "getActivityType", "setActionType", "actionType", "getActionType", "setFolderUuid", NotesConstants.KEY_FOLDER_UUID, "getFolderUuid", "getSelectedTags", "setSelectedTags", "selectedTags", "setCategoryUuid", "categoryUuid", "getCategoryUuid", "setGroupId", "groupId", "getGroupId", "setSpaceId", "spaceId", "getSpaceId", "serSearchText", "searchText", "getSearchText", "setSyncEnabledOnSender", "syncEnabledOnSender", "isSyncEnabledOnSender", "isSameAction", "data", "equals", "other", "", "toString", "hashCode", "", "HandoffDataBuilder", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MainHandoffData implements Serializable {

    @Nullable
    private String mActionType;

    @Nullable
    private String mActivityType;

    @Nullable
    private String mCategoryUuid;

    @Nullable
    private String mFolderUuid;

    @Nullable
    private String mGroupId;

    @Nullable
    private String mSearchText;

    @Nullable
    private Set<String> mSelectedTags;

    @Nullable
    private String mSpaceId;
    private final long serialVersionUID = 1;
    private boolean mIsSyncEnabledOnSender = true;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\tJ\u0016\u0010\u000e\u001a\u00020\u00002\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/model/MainHandoffData$HandoffDataBuilder;", "", "<init>", "()V", "mMainHandoffData", "Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/model/MainHandoffData;", "build", "setActivityType", "activityType", "", "setActionType", "actionType", "setFolderUuid", NotesConstants.KEY_FOLDER_UUID, "setSelectedTags", "selectedTags", "", "setCategoryUuid", "categoryUuid", "setGroupId", "groupId", "setSpaceId", "spaceId", "setSearchText", "searchText", "setSyncEnabledOnSender", "syncEnabledOnSender", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class HandoffDataBuilder {

        @NotNull
        private final MainHandoffData mMainHandoffData = new MainHandoffData();

        @NotNull
        /* JADX INFO: renamed from: build, reason: from getter */
        public final MainHandoffData getMMainHandoffData() {
            return this.mMainHandoffData;
        }

        @NotNull
        public final HandoffDataBuilder setActionType(@Nullable String actionType) {
            this.mMainHandoffData.setActionType(actionType);
            return this;
        }

        @NotNull
        public final HandoffDataBuilder setActivityType(@Nullable String activityType) {
            this.mMainHandoffData.setActivityType(activityType);
            return this;
        }

        @NotNull
        public final HandoffDataBuilder setCategoryUuid(@Nullable String categoryUuid) {
            this.mMainHandoffData.setCategoryUuid(categoryUuid);
            return this;
        }

        @NotNull
        public final HandoffDataBuilder setFolderUuid(@Nullable String folderUuid) {
            this.mMainHandoffData.setFolderUuid(folderUuid);
            return this;
        }

        @NotNull
        public final HandoffDataBuilder setGroupId(@Nullable String groupId) {
            this.mMainHandoffData.setGroupId(groupId);
            return this;
        }

        @NotNull
        public final HandoffDataBuilder setSearchText(@Nullable String searchText) {
            this.mMainHandoffData.serSearchText(searchText);
            return this;
        }

        @NotNull
        public final HandoffDataBuilder setSelectedTags(@Nullable Set<String> selectedTags) {
            this.mMainHandoffData.setSelectedTags(selectedTags);
            return this;
        }

        @NotNull
        public final HandoffDataBuilder setSpaceId(@Nullable String spaceId) {
            this.mMainHandoffData.setSpaceId(spaceId);
            return this;
        }

        @NotNull
        public final HandoffDataBuilder setSyncEnabledOnSender(boolean syncEnabledOnSender) {
            this.mMainHandoffData.setSyncEnabledOnSender(syncEnabledOnSender);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSyncEnabledOnSender(boolean syncEnabledOnSender) {
        this.mIsSyncEnabledOnSender = syncEnabledOnSender;
    }

    public boolean equals(@Nullable Object other) {
        String str;
        if (!(other instanceof MainHandoffData)) {
            return false;
        }
        MainHandoffData mainHandoffData = (MainHandoffData) other;
        String str2 = this.mActivityType;
        if (str2 != null && !Intrinsics.areEqual(str2, mainHandoffData.mActivityType)) {
            return false;
        }
        String str3 = this.mActionType;
        if ((str3 != null && !Intrinsics.areEqual(str3, mainHandoffData.mActionType)) || this.mIsSyncEnabledOnSender != mainHandoffData.mIsSyncEnabledOnSender) {
            return false;
        }
        if (Intrinsics.areEqual("folder_move", this.mActionType)) {
            String str4 = this.mFolderUuid;
            return str4 != null && Intrinsics.areEqual(str4, mainHandoffData.mFolderUuid);
        }
        if (Intrinsics.areEqual("tag_note", this.mActionType)) {
            Set<String> set = this.mSelectedTags;
            return set != null && Intrinsics.areEqual(set, mainHandoffData.mSelectedTags);
        }
        if (Intrinsics.areEqual("old_note", this.mActionType)) {
            String str5 = this.mCategoryUuid;
            return str5 != null && Intrinsics.areEqual(str5, mainHandoffData.mCategoryUuid);
        }
        if (Intrinsics.areEqual("gcs_note", this.mActionType) || Intrinsics.areEqual("coedit_space", this.mActionType)) {
            String str6 = this.mGroupId;
            return str6 != null && Intrinsics.areEqual(str6, mainHandoffData.mGroupId) && (str = this.mSpaceId) != null && Intrinsics.areEqual(str, mainHandoffData.mSpaceId);
        }
        if (!Intrinsics.areEqual("search", this.mActionType)) {
            return true;
        }
        String str7 = this.mSearchText;
        return str7 != null && Intrinsics.areEqual(str7, mainHandoffData.mSearchText);
    }

    @Nullable
    /* JADX INFO: renamed from: getActionType, reason: from getter */
    public final String getMActionType() {
        return this.mActionType;
    }

    @Nullable
    /* JADX INFO: renamed from: getActivityType, reason: from getter */
    public final String getMActivityType() {
        return this.mActivityType;
    }

    @Nullable
    /* JADX INFO: renamed from: getCategoryUuid, reason: from getter */
    public final String getMCategoryUuid() {
        return this.mCategoryUuid;
    }

    @Nullable
    /* JADX INFO: renamed from: getFolderUuid, reason: from getter */
    public final String getMFolderUuid() {
        return this.mFolderUuid;
    }

    @Nullable
    /* JADX INFO: renamed from: getGroupId, reason: from getter */
    public final String getMGroupId() {
        return this.mGroupId;
    }

    @Nullable
    /* JADX INFO: renamed from: getSearchText, reason: from getter */
    public final String getMSearchText() {
        return this.mSearchText;
    }

    @Nullable
    public final Set<String> getSelectedTags() {
        return this.mSelectedTags;
    }

    @Nullable
    /* JADX INFO: renamed from: getSpaceId, reason: from getter */
    public final String getMSpaceId() {
        return this.mSpaceId;
    }

    public int hashCode() {
        String str = this.mActivityType;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mActionType;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mFolderUuid;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Set<String> set = this.mSelectedTags;
        int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
        String str4 = this.mCategoryUuid;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mGroupId;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.mSpaceId;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.mSearchText;
        return Boolean.hashCode(this.mIsSyncEnabledOnSender) + ((iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31);
    }

    public final boolean isSameAction(@Nullable MainHandoffData data) {
        String str;
        return (data == null || (str = this.mActionType) == null || !Intrinsics.areEqual(str, data.mActionType)) ? false : true;
    }

    /* JADX INFO: renamed from: isSyncEnabledOnSender, reason: from getter */
    public final boolean getMIsSyncEnabledOnSender() {
        return this.mIsSyncEnabledOnSender;
    }

    public final void serSearchText(@Nullable String searchText) {
        this.mSearchText = searchText;
    }

    public final void setActionType(@Nullable String actionType) {
        this.mActionType = actionType;
    }

    public final void setActivityType(@Nullable String activityType) {
        this.mActivityType = activityType;
    }

    public final void setCategoryUuid(@Nullable String categoryUuid) {
        this.mCategoryUuid = categoryUuid;
    }

    public final void setFolderUuid(@Nullable String folderUuid) {
        this.mFolderUuid = folderUuid;
    }

    public final void setGroupId(@Nullable String groupId) {
        this.mGroupId = groupId;
    }

    public final void setSelectedTags(@Nullable Set<String> selectedTags) {
        this.mSelectedTags = selectedTags;
    }

    public final void setSpaceId(@Nullable String spaceId) {
        this.mSpaceId = spaceId;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.mActivityType)) {
            sb.append(" activity: ");
            sb.append(Logger.getEncode(this.mActivityType));
            sb.append('\t');
        }
        if (!TextUtils.isEmpty(this.mActionType)) {
            sb.append(" action: ");
            sb.append(Logger.getEncode(this.mActionType));
            sb.append('\t');
        }
        sb.append(" syncEnabledOnSender: ");
        sb.append(Logger.getEncode(String.valueOf(this.mIsSyncEnabledOnSender)));
        sb.append('\t');
        if (!TextUtils.isEmpty(this.mFolderUuid)) {
            sb.append(" folderUuid: ");
            sb.append(Logger.getEncode(this.mFolderUuid));
            sb.append('\t');
        }
        if (this.mSelectedTags != null) {
            sb.append(" selectedTags: ");
            sb.append(Logger.getEncode(String.valueOf(this.mSelectedTags)));
            sb.append('\t');
        }
        if (!TextUtils.isEmpty(this.mCategoryUuid)) {
            sb.append(" categoryUuid: ");
            sb.append(Logger.getEncode(this.mCategoryUuid));
            sb.append('\t');
        }
        if (!TextUtils.isEmpty(this.mGroupId)) {
            sb.append(" groupId: ");
            sb.append(Logger.getEncode(this.mGroupId));
            sb.append('\t');
        }
        if (!TextUtils.isEmpty(this.mSpaceId)) {
            sb.append(" spaceId: ");
            sb.append(Logger.getEncode(this.mSpaceId));
            sb.append('\t');
        }
        if (this.mSearchText != null) {
            sb.append(" search: ");
            sb.append(Logger.getEncode(this.mSearchText));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
