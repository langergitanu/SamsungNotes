package com.samsung.android.support.senl.p148nt.model.contextawareness.common.result;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.C11397R;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.util.ResultGetter;
import java.util.Arrays;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class SuggestionInfo {
    private static final String TAG = CALogger.createTag("SuggestionInfo");
    protected Drawable mAppIcon;
    private String mId;
    protected Intent mIntent;
    protected String mPackageName;
    private SuggestionData mSuggestionData;
    private String mTitle;

    public SuggestionInfo(SuggestionData suggestionData) {
        this.mSuggestionData = suggestionData;
        this.mId = suggestionData.getId();
        Bundle extras = this.mSuggestionData.getExtras();
        this.mPackageName = extras != null ? extras.getString("source") : "";
        try {
            this.mAppIcon = ResultGetter.getAppIcon(BaseUtils.getApplicationContext(), this.mPackageName);
        } catch (PackageManager.NameNotFoundException unused) {
            setRepresentativeAppIcon();
        }
        this.mTitle = this.mSuggestionData.getTitle();
        DataLogger.m12302d(TAG, "SuggestionInfo from SuggestionItem - id : " + this.mId + ", packageName : " + this.mPackageName + ", appIcon : " + this.mAppIcon + ", title : " + this.mTitle);
    }

    public Drawable getAppIcon() {
        return this.mAppIcon;
    }

    public String getId() {
        return this.mId;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public SuggestionData getSuggestionData() {
        return this.mSuggestionData;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public abstract boolean isValidExecution();

    public void setRepresentativeAppIcon() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (this.mPackageName != null) {
            ListIterator listIterator = Arrays.asList(applicationContext.getResources().getStringArray(C11397R.array.donated_app_image)).listIterator();
            while (listIterator.hasNext()) {
                if (this.mPackageName.equals(listIterator.next())) {
                    this.mAppIcon = applicationContext.getDrawable(C11397R.drawable.representative_app_icon_image);
                    return;
                }
            }
            ListIterator listIterator2 = Arrays.asList(applicationContext.getResources().getStringArray(C11397R.array.donated_app_internet)).listIterator();
            while (listIterator2.hasNext()) {
                if (this.mPackageName.equals(listIterator2.next())) {
                    this.mAppIcon = applicationContext.getDrawable(C11397R.drawable.representative_app_icon_internet);
                    return;
                }
            }
            ListIterator listIterator3 = Arrays.asList(applicationContext.getResources().getStringArray(C11397R.array.donated_app_message)).listIterator();
            while (listIterator3.hasNext()) {
                if (this.mPackageName.equals(listIterator3.next())) {
                    this.mAppIcon = applicationContext.getDrawable(C11397R.drawable.representative_app_icon_message);
                    return;
                }
            }
        }
        this.mAppIcon = applicationContext.getDrawable(R.drawable.sym_def_app_icon);
    }

    public abstract void setSuggestionInfo();

    public SuggestionInfo(Intent intent) {
        this.mIntent = intent;
        this.mPackageName = intent.getStringExtra("source");
        setSuggestionInfo();
    }
}
