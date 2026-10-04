package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FocusViewParams {
    private FocusViewParamsBuilder.FocusType mFocusType;
    private String mFolderUuid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FocusViewParamsBuilder {
        private FocusType focusType;
        private String folderUuid;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public enum FocusType {
            NONE,
            SEARCH
        }

        public FocusViewParams build() {
            return new FocusViewParams(this);
        }

        public FocusViewParamsBuilder setFocusType(FocusType focusType) {
            this.focusType = focusType;
            return this;
        }

        public FocusViewParamsBuilder setFolderUuid(String str) {
            this.folderUuid = str;
            return this;
        }
    }

    public FocusViewParams(FocusViewParamsBuilder focusViewParamsBuilder) {
        this.mFolderUuid = focusViewParamsBuilder.folderUuid;
        this.mFocusType = focusViewParamsBuilder.focusType;
    }

    public boolean hasFocus(String str) {
        if (this.mFocusType == FocusViewParamsBuilder.FocusType.NONE || TextUtils.isEmpty(this.mFolderUuid)) {
            return false;
        }
        return this.mFolderUuid.equals(str);
    }

    public boolean hasSearchFocusType() {
        return this.mFocusType == FocusViewParamsBuilder.FocusType.SEARCH;
    }
}
