package com.samsung.android.support.senl.document.memoconverter.xml;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class XMLItem {
    private long createdTime;
    private long modifiedTime;
    private String templateType = null;
    private String content = null;

    public String getContent() {
        return this.content;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public long getModifiedTime() {
        return this.modifiedTime;
    }

    public String getTemplateType() {
        return this.templateType;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreatedTime(long j) {
        this.createdTime = j;
    }

    public void setModifiedTime(long j) {
        this.modifiedTime = j;
    }

    public void setTemplateType(String str) {
        this.templateType = str;
    }
}
