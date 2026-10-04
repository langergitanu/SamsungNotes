package com.samsung.android.support.senl.p148nt.composer.main.base.model.share;

import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public enum ShareErrorCode {
    None(C9086R.string.editor_error_description_none),
    FileNotFound(C9086R.string.editor_error_description_file_not_found),
    PermissionFailed(C9086R.string.editor_error_description_fail_permission),
    CreateFileFailed(C9086R.string.editor_error_description_fail_create_file);

    private int mResId;

    ShareErrorCode(int i) {
        this.mResId = i;
    }

    public int getId() {
        return ordinal();
    }
}
