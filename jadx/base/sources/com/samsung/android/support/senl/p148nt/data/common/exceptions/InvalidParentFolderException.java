package com.samsung.android.support.senl.p148nt.data.common.exceptions;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.ExceptionCode;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class InvalidParentFolderException extends Exception {
    private final Info mExtraInfo;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Info {

        @ExceptionCode.Folder
        private final int mExceptionCode;
        private final String mSrcFolderUuid;
        private final String mToParentFolderUuid;

        public Info(String str, String str2, @ExceptionCode.Folder int i) {
            this.mSrcFolderUuid = str;
            this.mToParentFolderUuid = str2;
            this.mExceptionCode = i;
        }

        @ExceptionCode.Folder
        public int getExceptionCode() {
            return this.mExceptionCode;
        }

        public String getSourceFolderUuid() {
            return this.mSrcFolderUuid;
        }

        public String getTargetFolderUuid() {
            return this.mToParentFolderUuid;
        }
    }

    public InvalidParentFolderException(Info info) {
        super(getErrorMessage(info));
        this.mExtraInfo = info;
    }

    private static String getErrorMessage(Info info) {
        String sourceFolderUuid = info.getSourceFolderUuid();
        String targetFolderUuid = info.getTargetFolderUuid();
        switch (info.getExceptionCode()) {
            case 100:
                return AbstractC0541b.m775q("[", sourceFolderUuid, "] folder is ancestor of [", targetFolderUuid, "]");
            case 101:
                return AbstractC0541b.m774p("folder depth exceeds maximum, src/dst: ", sourceFolderUuid, " / ", targetFolderUuid);
            case 102:
                return AbstractC0541b.m772n("parent folder is not used state, parentUuid: ", targetFolderUuid);
            default:
                return "";
        }
    }

    public Info getExtraInfo() {
        return this.mExtraInfo;
    }
}
