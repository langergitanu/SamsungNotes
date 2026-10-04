package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HashTagParam {
    private final String mAttachmentFileNameForRecommendation;
    private final String mBulletListTextForRecommendation;
    private final String mHandwritingForRecommendation;
    private final int mMaxSelectableTagCount;
    private final String mNumberListTextForRecommendation;
    private final String mRecognitionImgUri;
    private final ArrayList<String> mSelectedTags;
    private final String mTextContentsForRecommendation;
    private final String mTitleForRecommendation;
    private final String mTodoListTextForRecommendation;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private String mAttachmentFileNameForRecommendation;
        private String mBulletListTextForRecommendation;
        private String mHandwritingForRecommendation;
        private int mMaxSelectableTagCount = 10;
        private String mNumberListTextForRecommendation;
        private String mRecognitionImgUri;
        private ArrayList<String> mSelectedTags;
        private String mTextContentsForRecommendation;
        private String mTitleForRecommendation;
        private String mTodoListTextForRecommendation;

        public HashTagParam build() {
            return new HashTagParam(this, 0);
        }

        public Builder setAttachmentFileNameForRecommendation(String str) {
            this.mAttachmentFileNameForRecommendation = str;
            return this;
        }

        public Builder setBulletListTextForRecommendation(String str) {
            this.mBulletListTextForRecommendation = str;
            return this;
        }

        public Builder setHandwritingForRecommendation(String str) {
            this.mHandwritingForRecommendation = str;
            return this;
        }

        public Builder setMaxSelectableTagCount(int i) {
            this.mMaxSelectableTagCount = i;
            return this;
        }

        public Builder setNumberListTextForRecommendation(String str) {
            this.mNumberListTextForRecommendation = str;
            return this;
        }

        public Builder setRecognitionImgUri(String str) {
            this.mRecognitionImgUri = str;
            return this;
        }

        public Builder setSelectedTags(ArrayList<String> arrayList) {
            this.mSelectedTags = new ArrayList<>(arrayList);
            return this;
        }

        public Builder setTextContentsForRecommendation(String str) {
            this.mTextContentsForRecommendation = str;
            return this;
        }

        public Builder setTitleForRecommendation(String str) {
            this.mTitleForRecommendation = str;
            return this;
        }

        public Builder setTodoListTextForRecommendation(String str) {
            this.mTodoListTextForRecommendation = str;
            return this;
        }
    }

    public /* synthetic */ HashTagParam(Builder builder, int i) {
        this(builder);
    }

    public String getAttachmentFileNameForRecommendation() {
        return this.mAttachmentFileNameForRecommendation;
    }

    public String getBulletListTextForRecommendation() {
        return this.mBulletListTextForRecommendation;
    }

    public String getHandwritingForRecommendation() {
        return this.mHandwritingForRecommendation;
    }

    public int getMaxSelectableTagCount() {
        return this.mMaxSelectableTagCount;
    }

    public String getNumberListTextForRecommendation() {
        return this.mNumberListTextForRecommendation;
    }

    public String getRecognitionImgUri() {
        return this.mRecognitionImgUri;
    }

    public ArrayList<String> getSelectedTags() {
        return this.mSelectedTags;
    }

    public String getTextContentsForRecommendation() {
        return this.mTextContentsForRecommendation;
    }

    public String getTitleForRecommendation() {
        return this.mTitleForRecommendation;
    }

    public String getTodoListTextForRecommendation() {
        return this.mTodoListTextForRecommendation;
    }

    public String toString() {
        return "\n-@    mSelectedTags: " + this.mSelectedTags + "\n-@    mRecognitionImgUri: " + this.mRecognitionImgUri + "\n-@    mTitleForRecommendation: " + this.mTitleForRecommendation + "\n-@    mTextContentsForRecommendation: " + this.mTextContentsForRecommendation + "\n-@    mAttachmentFileNameForRecommendation: " + this.mAttachmentFileNameForRecommendation + "\n-@    mNumberListTextForRecommendation: " + this.mNumberListTextForRecommendation + "\n-@    mBulletListTextForRecommendation: " + this.mBulletListTextForRecommendation + "\n-@    mTodoListTextForRecommendation: " + this.mTodoListTextForRecommendation + "\n-@    mMaxSelectableTagCount: " + this.mMaxSelectableTagCount + "\n-@    mHandwritingForRecommendation: " + this.mHandwritingForRecommendation;
    }

    private HashTagParam(Builder builder) {
        this.mSelectedTags = builder.mSelectedTags;
        this.mRecognitionImgUri = builder.mRecognitionImgUri;
        this.mMaxSelectableTagCount = builder.mMaxSelectableTagCount;
        this.mTitleForRecommendation = builder.mTitleForRecommendation;
        this.mTextContentsForRecommendation = builder.mTextContentsForRecommendation;
        this.mAttachmentFileNameForRecommendation = builder.mAttachmentFileNameForRecommendation;
        this.mNumberListTextForRecommendation = builder.mNumberListTextForRecommendation;
        this.mBulletListTextForRecommendation = builder.mBulletListTextForRecommendation;
        this.mTodoListTextForRecommendation = builder.mTodoListTextForRecommendation;
        this.mHandwritingForRecommendation = builder.mHandwritingForRecommendation;
    }
}
