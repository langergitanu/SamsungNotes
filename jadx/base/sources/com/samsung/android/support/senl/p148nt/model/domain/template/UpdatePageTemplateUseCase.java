package com.samsung.android.support.senl.p148nt.model.domain.template;

import androidx.core.util.Consumer;
import com.samsung.android.sdk.scs.p142ai.text.bnlp.CallableC7766b;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTemplateEntity;
import com.samsung.android.support.senl.p148nt.data.repository.template.NotesTemplateRepository;
import com.samsung.android.support.senl.p148nt.model.domain.common.BaseUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/domain/template/UpdatePageTemplateUseCase;", "Lcom/samsung/android/support/senl/nt/model/domain/common/BaseUseCase;", "Lcom/samsung/android/support/senl/nt/model/domain/template/UpdatePageTemplateUseCase$Param;", "", "repository", "Lcom/samsung/android/support/senl/nt/data/repository/template/NotesTemplateRepository;", "<init>", "(Lcom/samsung/android/support/senl/nt/data/repository/template/NotesTemplateRepository;)V", "getRepository", "()Lcom/samsung/android/support/senl/nt/data/repository/template/NotesTemplateRepository;", "execute", "param", "(Lcom/samsung/android/support/senl/nt/model/domain/template/UpdatePageTemplateUseCase$Param;)Ljava/lang/Boolean;", "Param", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UpdatePageTemplateUseCase extends BaseUseCase<Param, Boolean> {

    @NotNull
    private final NotesTemplateRepository repository;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/domain/template/UpdatePageTemplateUseCase$Param;", "", "uuid", "", "consumer", "Landroidx/core/util/Consumer;", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesTemplateEntity;", "<init>", "(Ljava/lang/String;Landroidx/core/util/Consumer;)V", "getUuid", "()Ljava/lang/String;", "getConsumer", "()Landroidx/core/util/Consumer;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class Param {

        @NotNull
        private final Consumer<NotesTemplateEntity> consumer;

        @NotNull
        private final String uuid;

        public Param(@NotNull String uuid, @NotNull Consumer<NotesTemplateEntity> consumer) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            this.uuid = uuid;
            this.consumer = consumer;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Param copy$default(Param param, String str, Consumer consumer, int i, Object obj) {
            if ((i & 1) != 0) {
                str = param.uuid;
            }
            if ((i & 2) != 0) {
                consumer = param.consumer;
            }
            return param.copy(str, consumer);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUuid() {
            return this.uuid;
        }

        @NotNull
        public final Consumer<NotesTemplateEntity> component2() {
            return this.consumer;
        }

        @NotNull
        public final Param copy(@NotNull String uuid, @NotNull Consumer<NotesTemplateEntity> consumer) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            return new Param(uuid, consumer);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Param)) {
                return false;
            }
            Param param = (Param) other;
            return Intrinsics.areEqual(this.uuid, param.uuid) && Intrinsics.areEqual(this.consumer, param.consumer);
        }

        @NotNull
        public final Consumer<NotesTemplateEntity> getConsumer() {
            return this.consumer;
        }

        @NotNull
        public final String getUuid() {
            return this.uuid;
        }

        public int hashCode() {
            return this.consumer.hashCode() + (this.uuid.hashCode() * 31);
        }

        @NotNull
        public String toString() {
            return "Param(uuid=" + this.uuid + ", consumer=" + this.consumer + ")";
        }
    }

    public UpdatePageTemplateUseCase(@NotNull NotesTemplateRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean execute$lambda$0(UpdatePageTemplateUseCase updatePageTemplateUseCase, Param param) {
        NotesTemplateEntity entity = updatePageTemplateUseCase.repository.getEntity(param.getUuid());
        if (entity == null) {
            return Boolean.FALSE;
        }
        param.getConsumer().accept(entity);
        updatePageTemplateUseCase.repository.upsert(entity);
        return Boolean.TRUE;
    }

    @NotNull
    public final NotesTemplateRepository getRepository() {
        return this.repository;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.domain.common.BaseUseCase
    @NotNull
    public Boolean execute(@NotNull Param param) {
        Intrinsics.checkNotNullParameter(param, "param");
        Object objRunInTransaction = this.repository.runInTransaction(new CallableC7766b(this, param, 6));
        Intrinsics.checkNotNullExpressionValue(objRunInTransaction, "runInTransaction(...)");
        return (Boolean) objRunInTransaction;
    }
}
