package com.samsung.android.support.senl.p148nt.composer.main.base.model.link;

import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class InternalURLSpan extends ClickableSpan implements ParcelableSpan {
    private String mDesc;
    private boolean mIsAllDay;
    private String mTime;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getAllDay() {
        return this.mIsAllDay;
    }

    public String getDesc() {
        return this.mDesc;
    }

    @Override // android.text.ParcelableSpan
    public int getSpanTypeId() {
        return 0;
    }

    public int getSpanTypeIdInternal() {
        return 0;
    }

    public String getTime() {
        return "time:" + this.mTime;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }

    public void setAllDay(boolean z) {
        this.mIsAllDay = z;
    }

    public void setDescription(String str) {
        this.mDesc = str;
    }

    public void setTimeString(String str) {
        this.mTime = str;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }
}
