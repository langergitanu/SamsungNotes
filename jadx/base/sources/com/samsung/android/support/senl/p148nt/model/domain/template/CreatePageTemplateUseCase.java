package com.samsung.android.support.senl.p148nt.model.domain.template;

import android.graphics.Rect;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.common.utils.DataUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTemplateEntity;
import com.samsung.android.support.senl.p148nt.data.repository.template.NotesTemplateRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.domain.common.BaseUseCase;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0013\u0014B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/domain/template/CreatePageTemplateUseCase;", "Lcom/samsung/android/support/senl/nt/model/domain/common/BaseUseCase;", "Lcom/samsung/android/support/senl/nt/model/domain/template/CreatePageTemplateUseCase$Param;", "", "repository", "Lcom/samsung/android/support/senl/nt/data/repository/template/NotesTemplateRepository;", "<init>", "(Lcom/samsung/android/support/senl/nt/data/repository/template/NotesTemplateRepository;)V", "getRepository", "()Lcom/samsung/android/support/senl/nt/data/repository/template/NotesTemplateRepository;", "execute", "param", "(Lcom/samsung/android/support/senl/nt/model/domain/template/CreatePageTemplateUseCase$Param;)Ljava/lang/Boolean;", "getTemplateFile", "Ljava/io/File;", "filePath", "", DynamicActionBarProvider.METHOD_GET_DATA, "templateFile", "Param", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CreatePageTemplateUseCase extends BaseUseCase<Param, Boolean> {
    private static final String TAG = ModelLogger.createTag("CreatePageTemplateUseCase");

    @NotNull
    private final NotesTemplateRepository repository;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/domain/template/CreatePageTemplateUseCase$Param;", "", "title", "", "filePath", "mimeType", "type", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "getFilePath", "getMimeType", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class Param {

        @NotNull
        private final String filePath;

        @NotNull
        private final String mimeType;

        @NotNull
        private final String title;
        private final int type;

        public Param(@NotNull String title, @NotNull String filePath, @NotNull String mimeType, int i) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            this.title = title;
            this.filePath = filePath;
            this.mimeType = mimeType;
            this.type = i;
        }

        public static /* synthetic */ Param copy$default(Param param, String str, String str2, String str3, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = param.title;
            }
            if ((i2 & 2) != 0) {
                str2 = param.filePath;
            }
            if ((i2 & 4) != 0) {
                str3 = param.mimeType;
            }
            if ((i2 & 8) != 0) {
                i = param.type;
            }
            return param.copy(str, str2, str3, i);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFilePath() {
            return this.filePath;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getType() {
            return this.type;
        }

        @NotNull
        public final Param copy(@NotNull String title, @NotNull String filePath, @NotNull String mimeType, int type) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            return new Param(title, filePath, mimeType, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Param)) {
                return false;
            }
            Param param = (Param) other;
            return Intrinsics.areEqual(this.title, param.title) && Intrinsics.areEqual(this.filePath, param.filePath) && Intrinsics.areEqual(this.mimeType, param.mimeType) && this.type == param.type;
        }

        @NotNull
        public final String getFilePath() {
            return this.filePath;
        }

        @NotNull
        public final String getMimeType() {
            return this.mimeType;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            return Integer.hashCode(this.type) + AbstractC1038a.m1202c(AbstractC1038a.m1202c(this.title.hashCode() * 31, 31, this.filePath), 31, this.mimeType);
        }

        @NotNull
        public String toString() {
            String str = this.title;
            String str2 = this.filePath;
            String str3 = this.mimeType;
            int i = this.type;
            StringBuilder sbM16m = AbstractC0000a.m16m("Param(title=", str, ", filePath=", str2, ", mimeType=");
            sbM16m.append(str3);
            sbM16m.append(", type=");
            sbM16m.append(i);
            sbM16m.append(")");
            return sbM16m.toString();
        }
    }

    public CreatePageTemplateUseCase(@NotNull NotesTemplateRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    private final File getTemplateFile(String filePath) {
        if (filePath.length() == 0) {
            return null;
        }
        File file = new File(filePath);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    private final String getTitle(Param param, File templateFile) {
        return param.getTitle().length() > 0 ? param.getTitle() : FileUtils.extractFileName(templateFile.getAbsolutePath());
    }

    @NotNull
    public final NotesTemplateRepository getRepository() {
        return this.repository;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.domain.common.BaseUseCase
    @NotNull
    public Boolean execute(@NotNull Param param) {
        Intrinsics.checkNotNullParameter(param, "param");
        File templateFile = getTemplateFile(param.getFilePath());
        if (templateFile == null) {
            return Boolean.FALSE;
        }
        try {
            NotesTemplateEntity notesTemplateEntity = new NotesTemplateEntity();
            notesTemplateEntity.setUuid(DataUtils.newUuid());
            notesTemplateEntity.setTitle(getTitle(param, templateFile));
            notesTemplateEntity.setCreatedAt(templateFile.lastModified());
            notesTemplateEntity.setType(param.getType());
            notesTemplateEntity.setData(templateFile.getAbsolutePath());
            notesTemplateEntity.setDisplayName(templateFile.getName());
            notesTemplateEntity.setLastModifiedAt(templateFile.lastModified());
            notesTemplateEntity.setMimeType(param.getMimeType());
            notesTemplateEntity.setSize((int) templateFile.length());
            Rect imageSize = ImageUtils.getImageSize(templateFile.getAbsolutePath());
            notesTemplateEntity.setWidth(imageSize.width());
            notesTemplateEntity.setHeight(imageSize.height());
            this.repository.upsert(notesTemplateEntity);
            DataLogger.m12307i(TAG, "insert, src : " + DataLogger.getEncode(notesTemplateEntity.getData()) + ", dest : " + DataLogger.getEncode(templateFile.getAbsolutePath()));
            return Boolean.TRUE;
        } catch (Exception e) {
            AbstractC11014a.m12314C("execute, e: ", e.getMessage(), TAG);
            return Boolean.FALSE;
        }
    }
}
