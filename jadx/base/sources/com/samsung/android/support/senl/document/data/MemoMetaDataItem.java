package com.samsung.android.support.senl.document.data;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class MemoMetaDataItem {
    public static final int SCRAP_BOOK_TYPE_IMAGE = 1;
    public static final int SCRAP_BOOK_TYPE_MUSIC = 2;
    public static final int SCRAP_BOOK_TYPE_TEXT = 5;
    public static final int SCRAP_BOOK_TYPE_WEB = 4;
    public static final int SCRAP_BOOK_TYPE_YOUTUBE = 3;
    private static final String TAG = "MemoMetaDataItem";
    private String mTitle = null;
    private String mContent = null;
    private String mCategoryName = null;
    private String mCategoryOrder = null;
    private boolean mHasVoice = false;
    private boolean mHasImage = false;
    private boolean mIsFavorite = false;
    private ConverterFileDataAdapter mImageFile = null;
    private String mLastModifiedAt = "0";
    private String mCreatedAt = "0";
    private String mVoiceRuntime = "0";
    private String mUuid = "";
    private String mVideoPath = null;
    private String mURL = null;
    private String mAudioPath = null;
    private int mScrapBookType = 0;
    private String mScrapBookBodyText = null;
    private String mScrapBookHTMLPath = null;
    private String mScrapBookOriImagePath = null;
    private String mScrapBookDrawingMemoPath = null;

    public String getAudioPath() {
        return this.mAudioPath;
    }

    public String getCategoryName() {
        return this.mCategoryName;
    }

    public String getCategoryOrder() {
        return this.mCategoryOrder;
    }

    public String getContent() {
        return this.mContent;
    }

    public String getCreatedAt() {
        return this.mCreatedAt;
    }

    public boolean getHasImage() {
        return this.mHasImage;
    }

    public boolean getHasVoice() {
        return this.mHasVoice;
    }

    public ConverterFileDataAdapter getImageFile() {
        return this.mImageFile;
    }

    public boolean getIsFavorite() {
        return this.mIsFavorite;
    }

    public String getLastModifiedAt() {
        return this.mLastModifiedAt;
    }

    public String getScrapBookBodyText() {
        return this.mScrapBookBodyText;
    }

    public String getScrapBookHTMLPath() {
        return this.mScrapBookHTMLPath;
    }

    public String getScrapbookDrawingMemoPath() {
        return this.mScrapBookDrawingMemoPath;
    }

    public String getScrapbookOriImagePath() {
        return this.mScrapBookOriImagePath;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getTypeForScrapBook() {
        return this.mScrapBookType;
    }

    public String getURL() {
        return this.mURL;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public String getVoiceRuntime() {
        return this.mVoiceRuntime;
    }

    public void setAudioPath(String str) {
        this.mAudioPath = str;
    }

    public void setCategoryName(String str) {
        this.mCategoryName = str;
    }

    public void setCategoryOrder(String str) {
        this.mCategoryOrder = str;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void setCreatedAt(String str) {
        this.mCreatedAt = str;
    }

    public void setHasImage(boolean z) {
        this.mHasImage = z;
    }

    public void setHasVoice(boolean z) {
        this.mHasVoice = z;
    }

    public void setImageFile(ConverterFileDataAdapter converterFileDataAdapter) {
        this.mImageFile = converterFileDataAdapter;
    }

    public void setIsFavorite(boolean z) {
        this.mIsFavorite = z;
    }

    public void setLastModifiedAt(String str) {
        this.mLastModifiedAt = str;
    }

    public void setScrapBookBodyText(String str) {
        this.mScrapBookBodyText = str;
    }

    public void setScrapBookDrawingMemoPath(String str) {
        this.mScrapBookDrawingMemoPath = str;
    }

    public void setScrapBookHTMLPath(String str) {
        this.mScrapBookHTMLPath = str;
    }

    public void setScrapBookOriImagePath(String str) {
        this.mScrapBookOriImagePath = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setTypeForScrapBook(int i) {
        this.mScrapBookType = i;
    }

    public void setURL(String str) {
        this.mURL = str;
    }

    public void setUuid(String str) {
        this.mUuid = str;
    }

    public void setVideoPath(String str) {
        this.mVideoPath = str;
    }

    public void setVoiceRuntime(String str) {
        this.mVoiceRuntime = str;
    }
}
