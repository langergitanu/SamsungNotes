package com.samsung.android.support.senl.p148nt.model.contextawareness.common.result;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Pair;
import android.util.Size;
import androidx.annotation.NonNull;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MediaObjectSuggestionInfo extends SuggestionInfo {
    private String mName;
    private String mPath;
    private Pair<Integer, Integer> mResolution;
    private String mSize;
    private Bitmap mThumbnail;
    private Uri mUri;

    public MediaObjectSuggestionInfo(SuggestionData suggestionData) {
        super(suggestionData);
    }

    public Bitmap downloadThumbnail(Context context) {
        Bitmap thumbnail = UriFileUtils.getThumbnail(context, this.mUri, new Size(((Integer) this.mResolution.first).intValue(), ((Integer) this.mResolution.second).intValue()));
        this.mThumbnail = thumbnail;
        return thumbnail;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public Pair<Integer, Integer> getResolution() {
        return this.mResolution;
    }

    public String getSize() {
        return this.mSize;
    }

    public Bitmap getThumbnail() {
        return this.mThumbnail;
    }

    public Uri getUri() {
        return this.mUri;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo
    public boolean isValidExecution() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo
    public void setSuggestionInfo() {
        Context applicationContext = BaseUtils.getApplicationContext();
        this.mUri = Uri.parse(this.mIntent.getStringExtra("url"));
        this.mName = UriFileUtils.getContentName(applicationContext.getContentResolver(), this.mUri);
        this.mPath = UriFileUtils.getPath(applicationContext, this.mUri);
        this.mSize = UriFileUtils.getSize(applicationContext, this.mUri);
        this.mResolution = UriFileUtils.getResolution(applicationContext, this.mUri);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("MediaObjectSuggestionInfo{mUri=");
        Uri uri = this.mUri;
        sb.append(uri != null ? uri.toString() : "");
        sb.append(", mName='");
        sb.append(this.mName);
        sb.append("', mPath='");
        sb.append(Logger.getEncode(this.mPath));
        sb.append("', mSize='");
        sb.append(this.mSize);
        sb.append("', mResolution=");
        sb.append(this.mResolution);
        sb.append(", mThumbnail=");
        sb.append(this.mThumbnail);
        sb.append('}');
        return sb.toString();
    }

    public MediaObjectSuggestionInfo(Intent intent) {
        super(intent);
    }
}
