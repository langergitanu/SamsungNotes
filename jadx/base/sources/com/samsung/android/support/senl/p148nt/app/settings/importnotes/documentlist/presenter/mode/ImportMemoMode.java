package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentModeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportMemoMode;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentMode;", "presenter", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentModeContract$IPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentModeContract$IPresenter;)V", "taskType", "", "getTaskType", "()I", "defaultCategoryText", "getDefaultCategoryText", "appName", "", "getAppName", "()Ljava/lang/String;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class ImportMemoMode extends ImportDocumentMode {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportMemoMode(@Nullable ImportDocumentModeContract.IPresenter iPresenter) {
        super(iPresenter);
        Intrinsics.checkNotNull(iPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode
    @NotNull
    public String getAppName() {
        if (TextUtils.isEmpty(this.mAppName)) {
            Context applicationContext = BaseUtils.getApplicationContext();
            this.mAppName = applicationContext != null ? applicationContext.getString(C8003R.string.settings_import_downloading_dialog_memo) : null;
        }
        String str = this.mAppName;
        Intrinsics.checkNotNull(str);
        return str;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode
    public int getDefaultCategoryText() {
        return C8003R.string.settings_import_memo_all_memo;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode
    public int getTaskType() {
        return 200;
    }
}
