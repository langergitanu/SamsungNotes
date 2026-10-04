package com.samsung.android.support.senl.p148nt.composer.main.cover.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoverData implements Parcelable, Cloneable {
    public static final Parcelable.Creator<CoverData> CREATOR = new Parcelable.Creator<CoverData>() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.model.CoverData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @RequiresApi(api = 29)
        public CoverData createFromParcel(Parcel parcel) {
            return new CoverData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CoverData[] newArray(int i) {
            return new CoverData[i];
        }
    };
    public static final int GENERATE_NONE = 0;
    public static final int GENERATING = 1;
    public static final String KEY_COVER_DATA = "cover_data";
    public static final String KEY_EXTRACT_TEXT = "extract_text";
    public static final String KEY_GENERATE_COVER = "generate";
    public static final String KEY_IS_CHANGED = "is_changed";
    public static final String KEY_IS_TITLE_CHANGED = "is_title_changed";
    private int mAvailableAutoCover;
    private int mBackgroundColor;
    private int mBackgroundColorInverted;
    private String mCategoryUuid;
    private String mColorId;
    private int mCoverType;
    private long mCreatedAt;
    private String mDocPath;
    private String mExtractStr;
    private int mGenerateState;
    private int mIsEnabled;
    private boolean mIsGeneratedCover;
    private boolean mIsGeneratedTitle;
    private long mLastModifiedAt;
    private String mNoteUuid;
    private ArrayList<String> mSelectedTemplateList;
    private int mState;
    private String mSummary;
    private String mTemplateUuid;
    private String mTitle;

    public CoverData(String str) {
        this.mTitle = "";
        this.mSummary = "";
        this.mTemplateUuid = "DEFAULT:///";
        this.mColorId = "DEFAULT:///";
        this.mCategoryUuid = CoverStickerConstants.Category.NONE.UUID;
        this.mExtractStr = "";
        this.mIsGeneratedCover = false;
        this.mIsGeneratedTitle = false;
        this.mNoteUuid = str;
    }

    public static List<Pair<String, Integer>> createBgColorIds() {
        return new ArrayList(Arrays.asList(new Pair(CoverConstants.Color.SKY_BLUE, Integer.valueOf(C9086R.string.cover_color_sky_blue_tts)), new Pair(CoverConstants.Color.LAVENDER, Integer.valueOf(C9086R.string.cover_color_lavender_tts)), new Pair(CoverConstants.Color.CORAL, Integer.valueOf(C9086R.string.cover_color_coral_tts)), new Pair(CoverConstants.Color.ORANGE, Integer.valueOf(C9086R.string.cover_color_orange_tts)), new Pair(CoverConstants.Color.YELLOW, Integer.valueOf(C9086R.string.cover_color_yellow_tts)), new Pair(CoverConstants.Color.BEIGE, Integer.valueOf(C9086R.string.cover_color_beige_tts)), new Pair(CoverConstants.Color.GREEN, Integer.valueOf(C9086R.string.cover_color_green_tts)), new Pair(CoverConstants.Color.VIVID_BLUE, Integer.valueOf(C9086R.string.cover_color_vivid_blue_tts)), new Pair(CoverConstants.Color.VIVID_PURPLE, Integer.valueOf(C9086R.string.cover_color_vivid_purple_tts)), new Pair(CoverConstants.Color.VIVID_CORAL, Integer.valueOf(C9086R.string.cover_color_vivid_coral_tts)), new Pair(CoverConstants.Color.VIVID_ORANGE, Integer.valueOf(C9086R.string.cover_color_vivid_orange_tts)), new Pair(CoverConstants.Color.VIVID_YELLOW, Integer.valueOf(C9086R.string.cover_color_vivid_yellow_tts)), new Pair(CoverConstants.Color.VIVID_GREEN, Integer.valueOf(C9086R.string.cover_color_vivid_green_tts)), new Pair(CoverConstants.Color.NAVY, Integer.valueOf(C9086R.string.cover_color_navy_tts))));
    }

    public static List<Pair<String, Integer>> createCategoryList() {
        return new ArrayList(Arrays.asList(new Pair(CoverStickerConstants.Category.TRAVEL.UUID, Integer.valueOf(C9086R.string.cover_sticker_travel_tts)), new Pair(CoverStickerConstants.Category.INFORMATION.UUID, Integer.valueOf(C9086R.string.cover_sticker_information_tts)), new Pair(CoverStickerConstants.Category.PLANNER.UUID, Integer.valueOf(C9086R.string.cover_sticker_planner_tts)), new Pair(CoverStickerConstants.Category.RECIPE.UUID, Integer.valueOf(C9086R.string.cover_sticker_recipe_tts)), new Pair(CoverStickerConstants.Category.TODO.UUID, Integer.valueOf(C9086R.string.cover_sticker_todo_tts)), new Pair(CoverStickerConstants.Category.STUDY.UUID, Integer.valueOf(C9086R.string.cover_sticker_study_tts)), new Pair(CoverStickerConstants.Category.SHOPPING.UUID, Integer.valueOf(C9086R.string.cover_sticker_shopping_tts)), new Pair(CoverStickerConstants.Category.CASHBOOK.UUID, Integer.valueOf(C9086R.string.cover_sticker_cashbook_tts)), new Pair(CoverStickerConstants.Category.WORKOUT.UUID, Integer.valueOf(C9086R.string.cover_sticker_workout_tts)), new Pair(CoverStickerConstants.Category.DIARY.UUID, Integer.valueOf(C9086R.string.cover_sticker_diary_tts)), new Pair(CoverStickerConstants.Category.WORK.UUID, Integer.valueOf(C9086R.string.cover_sticker_work_tts)), new Pair(CoverStickerConstants.Category.NONE.UUID, Integer.valueOf(C9086R.string.cover_sticker_none_tts))));
    }

    public static HashMap<String, Integer> createCategoryMap() {
        HashMap<String, Integer> map = new HashMap<>();
        for (Pair<String, Integer> pair : CoverEditorUtils.createStickerList()) {
            if (!((String) pair.first).equals(CoverStickerConstants.Category.NONE.UUID)) {
                map.put((String) pair.first, (Integer) pair.second);
            }
        }
        return map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof CoverData)) {
            return super.equals(obj);
        }
        CoverData coverData = (CoverData) obj;
        if (!this.mSummary.equals(coverData.mSummary) || !this.mCategoryUuid.equals(coverData.mCategoryUuid) || !this.mTemplateUuid.equals(coverData.mTemplateUuid) || !this.mColorId.equals(coverData.mColorId) || this.mIsEnabled != coverData.mIsEnabled) {
            return false;
        }
        ArrayList<String> arrayList = this.mSelectedTemplateList;
        return (arrayList == null || arrayList.equals(coverData.mSelectedTemplateList)) && this.mIsGeneratedCover == coverData.mIsGeneratedCover && this.mIsGeneratedTitle == coverData.mIsGeneratedTitle;
    }

    public boolean getAvailableAutoCover() {
        return this.mAvailableAutoCover == 1;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getBackgroundColorInverted() {
        return this.mBackgroundColorInverted;
    }

    public String getCategoryUuid() {
        return this.mCategoryUuid;
    }

    public String getColorId() {
        return this.mColorId;
    }

    public long getCreatedAt() {
        return this.mCreatedAt;
    }

    public String getDocPath() {
        return this.mDocPath;
    }

    public String getExtractStr() {
        return this.mExtractStr;
    }

    public int getGenerateState() {
        return this.mGenerateState;
    }

    public boolean getIsGeneratedCover() {
        return this.mIsGeneratedCover;
    }

    public boolean getIsGeneratedTitle() {
        return this.mIsGeneratedTitle;
    }

    public long getLastModifiedAt() {
        return this.mLastModifiedAt;
    }

    public String getNoteUuid() {
        return this.mNoteUuid;
    }

    public List<String> getSelectedTemplateList() {
        return this.mSelectedTemplateList;
    }

    public int getState() {
        return this.mState;
    }

    public String getSummary() {
        return this.mSummary;
    }

    public String getTemplateUuid() {
        return this.mTemplateUuid;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isAiGeneratedCover() {
        return CscFeature.INSTANCE.getInstance().isChinaAiFeature() && this.mState == 4;
    }

    public boolean isEnabled() {
        return this.mIsEnabled == 1;
    }

    public void setAvailableAutoCover(boolean z) {
        this.mAvailableAutoCover = z ? 1 : 0;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setBackgroundColorInverted(int i) {
        this.mBackgroundColorInverted = i;
    }

    public void setCategoryUuid(String str) {
        this.mCategoryUuid = str;
    }

    public void setColorId(String str) {
        this.mColorId = str;
    }

    public void setCreatedAt(long j) {
        this.mCreatedAt = j;
    }

    public void setDocPath(String str) {
        this.mDocPath = str;
    }

    public void setEnabled(boolean z) {
        this.mIsEnabled = z ? 1 : 0;
    }

    public void setExtractStr(String str) {
        this.mExtractStr = str;
    }

    public void setGenerateState(int i) {
        this.mGenerateState = i;
    }

    public void setIsGeneratedCover(boolean z) {
        this.mIsGeneratedCover = z;
    }

    public void setIsGeneratedTitle(boolean z) {
        this.mIsGeneratedTitle = z;
    }

    public void setLastModifiedAt(long j) {
        this.mLastModifiedAt = j;
    }

    public void setNoteUuid(String str) {
        this.mNoteUuid = str;
    }

    public void setSelectedTemplateList(ArrayList<String> arrayList) {
        this.mSelectedTemplateList = arrayList;
    }

    public void setSelectedTemplateUuid(int i, String str) {
        this.mSelectedTemplateList.set(i, str);
    }

    public void setState(int i) {
        this.mState = i;
    }

    public void setSummary(String str) {
        this.mSummary = str;
    }

    public void setTemplateUuid(String str) {
        this.mTemplateUuid = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // android.os.Parcelable
    @RequiresApi(api = 29)
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.mNoteUuid);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSummary);
        parcel.writeString(this.mTemplateUuid);
        parcel.writeString(this.mColorId);
        parcel.writeString(this.mCategoryUuid);
        parcel.writeInt(this.mState);
        parcel.writeInt(this.mIsEnabled);
        parcel.writeInt(this.mAvailableAutoCover);
        parcel.writeLong(this.mCreatedAt);
        parcel.writeLong(this.mLastModifiedAt);
        parcel.writeString(this.mDocPath);
        parcel.writeString(this.mExtractStr);
        parcel.writeInt(this.mGenerateState);
        parcel.writeStringList(this.mSelectedTemplateList);
        parcel.writeInt(this.mCoverType);
        parcel.writeInt(this.mBackgroundColor);
        parcel.writeInt(this.mBackgroundColorInverted);
        parcel.writeBoolean(this.mIsGeneratedCover);
        parcel.writeBoolean(this.mIsGeneratedTitle);
    }

    @NonNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CoverData m22192clone() {
        CoverData coverData = (CoverData) super.clone();
        coverData.setTitle(this.mTitle);
        coverData.setSummary(this.mSummary);
        coverData.setCategoryUuid(this.mCategoryUuid);
        coverData.setTemplateUuid(this.mTemplateUuid);
        coverData.setColorId(this.mColorId);
        coverData.setEnabled(this.mIsEnabled == 1);
        coverData.setSelectedTemplateList(this.mSelectedTemplateList);
        coverData.setIsGeneratedCover(this.mIsGeneratedCover);
        coverData.setIsGeneratedTitle(this.mIsGeneratedTitle);
        return coverData;
    }

    @RequiresApi(api = 29)
    public CoverData(Parcel parcel) {
        this.mTitle = "";
        this.mSummary = "";
        this.mTemplateUuid = "DEFAULT:///";
        this.mColorId = "DEFAULT:///";
        this.mCategoryUuid = CoverStickerConstants.Category.NONE.UUID;
        this.mExtractStr = "";
        this.mIsGeneratedCover = false;
        this.mIsGeneratedTitle = false;
        this.mNoteUuid = parcel.readString();
        this.mTitle = parcel.readString();
        this.mSummary = parcel.readString();
        this.mTemplateUuid = parcel.readString();
        this.mColorId = parcel.readString();
        this.mCategoryUuid = parcel.readString();
        this.mState = parcel.readInt();
        this.mIsEnabled = parcel.readInt();
        this.mAvailableAutoCover = parcel.readInt();
        this.mCreatedAt = parcel.readLong();
        this.mLastModifiedAt = parcel.readLong();
        this.mDocPath = parcel.readString();
        this.mExtractStr = parcel.readString();
        this.mGenerateState = parcel.readInt();
        this.mSelectedTemplateList = parcel.createStringArrayList();
        this.mCoverType = parcel.readInt();
        this.mBackgroundColor = parcel.readInt();
        this.mBackgroundColorInverted = parcel.readInt();
        this.mIsGeneratedCover = parcel.readBoolean();
        this.mIsGeneratedTitle = parcel.readBoolean();
    }
}
