package com.samsung.android.sdk.mobileservice.social.buddy.request;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class BuddyInfoRequest {
    public static final int CERTIFICATE_ITEM = 1;
    public static final int SYNCED_CONTACT_ITEM = 2;
    private int mItemFlags;
    private String mSelectionArg;
    private int mSelectionType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private int mItemFlags = 0;
        private String mSelectionArg;
        private int mSelectionType;

        public Builder(BuddyKey buddyKey) {
            this.mSelectionArg = buddyKey.getKeyword();
            this.mSelectionType = buddyKey.getType();
        }

        public Builder addItemFlags(int i) {
            this.mItemFlags = i | this.mItemFlags;
            return this;
        }

        public BuddyInfoRequest build() {
            return new BuddyInfoRequest(this);
        }
    }

    public int getItemFlags() {
        return this.mItemFlags;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("ITEMS", this.mItemFlags);
        bundle.putInt("SELECTION_TYPE", this.mSelectionType);
        bundle.putString("SELECTION_ARG", this.mSelectionArg);
        return bundle;
    }

    private BuddyInfoRequest(Builder builder) {
        this.mItemFlags = builder.mItemFlags;
        this.mSelectionArg = builder.mSelectionArg;
        this.mSelectionType = builder.mSelectionType;
    }
}
