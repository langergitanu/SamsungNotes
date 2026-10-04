package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constants.WritingMode;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.SpenDocumentRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.entity.WordDocumentEntityContainer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OpenParam {
    private String mDocPath;
    private String mLockAccountGuid;
    private int mPageHeight;
    private int mPageType;
    private int mPageWidth;
    private String mUuid;

    @WritingMode
    private int mWritingMode = 0;
    private SpenWNote.Orientation mOrientation = SpenWNote.Orientation.PORTRAIT;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private final OpenParam mOpenParam = new OpenParam();

        public OpenParam done() {
            return this.mOpenParam;
        }

        public Builder setDocPath(String str) {
            this.mOpenParam.setDocPath(str);
            return this;
        }

        public Builder setLockAccountGuid(String str) {
            this.mOpenParam.setLockAccountGuid(str);
            return this;
        }

        public Builder setOrientation(SpenWNote.Orientation orientation) {
            this.mOpenParam.setNoteOrientation(orientation);
            return this;
        }

        public Builder setPageHeight(int i) {
            this.mOpenParam.setPageHeight(i);
            return this;
        }

        public Builder setPageType(int i) {
            this.mOpenParam.setPageType(i);
            return this;
        }

        public Builder setPageWidth(int i) {
            this.mOpenParam.setPageWidth(i);
            return this;
        }

        public Builder setUuid(String str) {
            this.mOpenParam.setUuid(str);
            return this;
        }

        public Builder setWritingMode(@WritingMode int i) {
            this.mOpenParam.setWritingMode(i);
            return this;
        }
    }

    public String getDocPath() {
        return this.mDocPath;
    }

    public String getLockAccountGuid() {
        return this.mLockAccountGuid;
    }

    public SpenWNote.Orientation getNoteOrientation() {
        return this.mOrientation;
    }

    public int getPageHeight() {
        return this.mPageHeight;
    }

    public SpenWNote.PageMode getPageMode() {
        return this.mPageType == 0 ? SpenWNote.PageMode.SINGLE : SpenWNote.PageMode.LIST;
    }

    public int getPageWidth() {
        return this.mPageWidth;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public int getWritingMode() {
        return this.mWritingMode;
    }

    public DocumentRepository<SpenWordDocument, WordDocumentEntityContainer> makeDocRepository(String str, DocumentSubscriptionId documentSubscriptionId) {
        return SpenDocumentRepositoryFactory.newInstance(getUuid(), "", getDocPath(), "", str, documentSubscriptionId).createWordDocRepository().setPageWidth(getPageWidth()).setPageHeight(getPageHeight()).setPageMode(getPageMode()).setOrientation(getNoteOrientation()).setLockAccountGuid(getLockAccountGuid()).setWritingMode(getWritingMode());
    }

    public void setDocPath(String str) {
        this.mDocPath = str;
    }

    public void setLockAccountGuid(String str) {
        this.mLockAccountGuid = str;
    }

    public void setNoteOrientation(SpenWNote.Orientation orientation) {
        this.mOrientation = orientation;
    }

    public void setPageHeight(int i) {
        this.mPageHeight = i;
    }

    public void setPageType(int i) {
        this.mPageType = i;
    }

    public void setPageWidth(int i) {
        this.mPageWidth = i;
    }

    public void setUuid(String str) {
        this.mUuid = str;
    }

    public void setWritingMode(@WritingMode int i) {
        this.mWritingMode = i;
    }
}
