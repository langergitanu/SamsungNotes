package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.service;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.CustomSaveStrategy;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.save.SaveModel;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007H\u0016J&\u0010\b\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007H\u0016¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/service/SOMSaveStrategy;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/service/CustomSaveStrategy;", "<init>", "()V", "onOpen", "", "repository", "Lcom/samsung/android/support/senl/nt/model/documents/data/DocumentRepository;", "onClose", "docState", "Lcom/samsung/android/support/senl/nt/model/repository/data/NotesDocument;", "Lcom/samsung/android/support/senl/nt/model/documents/spen/SpenWordDocument;", "onSave", "onSaveCache", "onCacheLoadFailed", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SOMSaveStrategy extends CustomSaveStrategy {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.CustomSaveStrategy
    public void onCacheLoadFailed(@NotNull DocumentRepository<?, ?> repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        repository.setSaveStrategy(67592);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.CustomSaveStrategy
    public void onClose(@NotNull DocumentRepository<?, ?> repository, @NotNull NotesDocument<SpenWordDocument> docState) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(docState, "docState");
        repository.setSaveStrategy(SaveModel.DEFAULT_SCREEN_OFF_CLOSE_STRATEGY);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.CustomSaveStrategy
    public void onOpen(@NotNull DocumentRepository<?, ?> repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        repository.setSaveStrategy(67592);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.CustomSaveStrategy
    public void onSave(@NotNull DocumentRepository<?, ?> repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        repository.setSaveStrategy(67592);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.CustomSaveStrategy
    public void onSaveCache(@NotNull DocumentRepository<?, ?> repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        repository.setSaveStrategy(SaveModel.DEFAULT_SCREEN_OFF_SAVE_CACHE_STRATEGY);
    }
}
