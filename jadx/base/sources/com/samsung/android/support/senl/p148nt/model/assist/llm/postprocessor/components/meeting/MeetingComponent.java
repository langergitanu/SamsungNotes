package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.meeting;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class MeetingComponent {
    private String mText = "";
    private boolean mIsUpdated = false;

    public boolean exists() {
        return this.mText.length() > 0;
    }

    public boolean getIsUpdated() {
        return this.mIsUpdated;
    }

    public int getLength() {
        return this.mText.length();
    }

    public String getText() {
        return this.mText;
    }

    public void setIsUpdated(boolean z) {
        this.mIsUpdated = z;
    }

    public void setText(String str) {
        this.mText = str;
    }
}
