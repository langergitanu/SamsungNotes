package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.title.coedit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleCoeditMemberInfo {
    public static final String ADD_MEMBER = "AddMember";
    private boolean mLeader;
    private String mMemberId;
    private String mMemberName;
    private String mUri;
    private boolean mWriter;

    public TitleCoeditMemberInfo(String str, String str2, String str3) {
        this.mMemberId = str;
        this.mMemberName = str2;
        this.mUri = str3;
    }

    public String getMemberId() {
        return this.mMemberId;
    }

    public String getMemberName() {
        return this.mMemberName;
    }

    public String getUri() {
        return this.mUri;
    }

    public boolean isLeader() {
        return this.mLeader;
    }

    public boolean isWriter() {
        return this.mWriter;
    }

    public void setLeader(boolean z) {
        this.mLeader = z;
    }

    public void setWriter(boolean z) {
        this.mWriter = z;
    }
}
