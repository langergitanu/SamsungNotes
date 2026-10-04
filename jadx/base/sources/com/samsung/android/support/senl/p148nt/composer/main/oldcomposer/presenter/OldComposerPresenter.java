package com.samsung.android.support.senl.p148nt.composer.main.oldcomposer.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OldComposerPresenter extends BaseComposerPresenter {
    private static final String TAG = Logger.createTag("OldComposerPresenter");

    public OldComposerPresenter(@NonNull BaseComposerPresenter.ComponentFactory componentFactory) {
        super(componentFactory);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter
    public boolean setDocumentUuid(Activity activity, @Nullable Bundle bundle) {
        Intent intent = activity.getIntent();
        boolean z = false;
        if (TextUtils.isEmpty(intent.getStringExtra("sdoc_uuid"))) {
            intent.putExtra("sdoc_uuid", UUIDUtils.newUUID(activity, false));
            z = true;
        }
        String stringExtra = intent.getStringExtra("doc_path");
        if (!TextUtils.isEmpty(stringExtra) && FileUtils.exists(stringExtra)) {
            return z;
        }
        Logger.m11000e(TAG, "setDocumentUuid# newUUID ");
        this.mComposerCloser.finish("OldComposerPresenter");
        return z;
    }
}
