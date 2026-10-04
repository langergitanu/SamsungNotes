package com.samsung.android.settings.external.DynamicActionBar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class DynamicActionBarController {
    private String mAuthority;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MetaData {
        private String mActionButtonText;

        @StringRes
        private int mActionButtonTextResId;
        private String mCategory;
        private String mLaterButtonText;
        private int mLaterButtonTextResId;
        private int mOrder;
        private String mTitle;

        @StringRes
        private int mTitleId;

        public MetaData(@NonNull String str) {
            this.mCategory = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Bundle build() {
            Bundle bundle = new Bundle();
            bundle.putString(DynamicActionBarProvider.META_DATA_CATEGORY_KEY, this.mCategory);
            bundle.putInt(DynamicActionBarProvider.META_DATA_KEY_ORDER, this.mOrder);
            int i = this.mTitleId;
            if (i != 0) {
                bundle.putInt(DynamicActionBarProvider.META_DATA_TITLE, i);
            } else {
                String str = this.mTitle;
                if (str != null) {
                    bundle.putString(DynamicActionBarProvider.META_DATA_TITLE, str);
                }
            }
            int i2 = this.mActionButtonTextResId;
            if (i2 != 0) {
                bundle.putInt(DynamicActionBarProvider.META_DATA_ACTION_BUTTON_TEXT, i2);
            } else {
                String str2 = this.mActionButtonText;
                if (str2 != null) {
                    bundle.putString(DynamicActionBarProvider.META_DATA_ACTION_BUTTON_TEXT, str2);
                }
            }
            int i4 = this.mLaterButtonTextResId;
            if (i4 != 0) {
                bundle.putInt(DynamicActionBarProvider.META_DATA_LATER_BUTTON_TEXT, i4);
                return bundle;
            }
            String str3 = this.mLaterButtonText;
            if (str3 != null) {
                bundle.putString(DynamicActionBarProvider.META_DATA_LATER_BUTTON_TEXT, str3);
            }
            return bundle;
        }

        public MetaData setActionButtonText(@StringRes int i) {
            this.mActionButtonTextResId = i;
            return this;
        }

        public MetaData setLaterButtonText(@StringRes int i) {
            this.mLaterButtonTextResId = i;
            return this;
        }

        public MetaData setOrder(int i) {
            this.mOrder = i;
            return this;
        }

        public MetaData setTitle(@StringRes int i) {
            this.mTitleId = i;
            return this;
        }

        public MetaData setActionButtonText(String str) {
            this.mActionButtonText = str;
            return this;
        }

        public MetaData setLaterButtonText(String str) {
            this.mLaterButtonText = str;
            return this;
        }

        public MetaData setTitle(String str) {
            this.mTitle = str;
            return this;
        }
    }

    public static Uri buildUri(String str, String str2, String str3) {
        return new Uri.Builder().scheme("content").authority(str).appendPath(str2).appendPath(str3).build();
    }

    private void notifyChanged(Context context, String str) {
        context.getContentResolver().notifyChange(buildUri(this.mAuthority, str, getKey()), null);
    }

    public Bundle getBundle() {
        MetaData metaData = getMetaData();
        if (metaData == null) {
            throw new NullPointerException("Should not return null in getMetaData()");
        }
        Bundle bundleBuild = metaData.build();
        String string = new Uri.Builder().scheme("content").authority(this.mAuthority).build().toString();
        bundleBuild.putString(DynamicActionBarProvider.META_DATA_KEYHINT, getKey());
        if (this instanceof DynamicTitle) {
            bundleBuild.putString(DynamicActionBarProvider.META_DATA_TITLE_URI, string);
        }
        if (this instanceof DynamicActionButton) {
            bundleBuild.putString(DynamicActionBarProvider.META_DATA_ACTION_BUTTON_URI, string);
        }
        if (this instanceof DynamicLaterButton) {
            bundleBuild.putString(DynamicActionBarProvider.META_DATA_LATER_BUTTON_URI, string);
        }
        return bundleBuild;
    }

    public abstract String getKey();

    public abstract MetaData getMetaData();

    public void notifyActionButtonTextChanged(Context context) {
        if (this instanceof DynamicActionButton) {
            notifyChanged(context, DynamicActionBarProvider.METHOD_GET_DYNAMIC_ACTION_BUTTON_TEXT);
        }
    }

    public void notifyLaterButtonTextChanged(Context context) {
        if (this instanceof DynamicLaterButton) {
            notifyChanged(context, DynamicActionBarProvider.METHOD_GET_DYNAMIC_LATER_BUTTON_TEXT);
        }
    }

    public void notifyTitleChanged(Context context) {
        if (this instanceof DynamicTitle) {
            notifyChanged(context, DynamicActionBarProvider.METHOD_GET_DYNAMIC_TITLE);
        }
    }

    public void setAuthority(String str) {
        this.mAuthority = str;
    }
}
