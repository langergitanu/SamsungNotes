package com.samsung.android.support.senl.p148nt.model.domain.coedit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.composer.document.capture.SpenNoteCapturePage;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.common.util.DataStrategy;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.composer.SpenNoteTextManagerWrapper;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.ToolConstructor;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.common.utils.SpenWNoteObjectHelper;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.SdocXDocumentLocker;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.save.DocumentPostSaveOperation;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.domain.common.BaseUseCase;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCopyUtils;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import com.samsung.android.support.senl.p148nt.model.utils.NotesDocumentDeleteUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u000256B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J.\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u001fH\u0002J(\u0010%\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u001fH\u0002J.\u0010'\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010\"2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u001a\u0010-\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010\"H\u0002J\"\u0010.\u001a\u0004\u0018\u00010*2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\"H\u0002J,\u0010/\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u00100\u001a\u00020\u0003H\u0002J\u001c\u00101\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u00102\u001a\u0004\u0018\u00010\u0013H\u0002J\u0018\u00103\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u00104\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/domain/coedit/AddNoteToSharedNotebookUseCase;", "Lcom/samsung/android/support/senl/nt/model/domain/common/BaseUseCase;", "Lcom/samsung/android/support/senl/nt/model/domain/coedit/AddNoteToSharedNotebookUseCase$Param;", "", "mAppContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mCapturePage", "Lcom/samsung/android/sdk/composer/document/capture/SpenNoteCapturePage;", "execute", "param", "(Lcom/samsung/android/support/senl/nt/model/domain/coedit/AddNoteToSharedNotebookUseCase$Param;)Ljava/lang/Integer;", "isSourceAvailable", "", "srcEntity", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentEntity;", "copyFile", "srcPath", "", "newPath", "createNewEntity", "updateCopiedDocument", "newEntity", "updateDocument", ExternalDataConstants.DOCUMENT_TABLE_NAME, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "convertMath", "", "convertMathObjects", "page", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "objects", "", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "capturePage", "tempPage", "changeObjectToImageWithCapturedBitmap", "obj", "changeObjectToImage", CoeditServiceConstants.Element.NAME_OBJECT, "bitmap", "Landroid/graphics/Bitmap;", "imageRect", "Landroid/graphics/RectF;", "removeObject", "captureObject", "insertImageObject", "index", "saveToFile", "filePath", "saveToDB", "deleteCopiedFile", "Param", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AddNoteToSharedNotebookUseCase extends BaseUseCase<Param, Integer> {

    @NotNull
    private static final String TAG;

    @NotNull
    private final Context mAppContext;

    @Nullable
    private SpenNoteCapturePage mCapturePage;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/domain/coedit/AddNoteToSharedNotebookUseCase$Param;", "", "srcUuid", "", "newUuid", "newPath", "spaceId", "groupId", GroupContract.Group.LEADER_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSrcUuid", "()Ljava/lang/String;", "getNewUuid", "getNewPath", "getSpaceId", "getGroupId", "getOwnerId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class Param {

        @NotNull
        private final String groupId;

        @NotNull
        private final String newPath;

        @NotNull
        private final String newUuid;

        @NotNull
        private final String ownerId;

        @NotNull
        private final String spaceId;

        @NotNull
        private final String srcUuid;

        public Param(@NotNull String srcUuid, @NotNull String newUuid, @NotNull String newPath, @NotNull String spaceId, @NotNull String groupId, @NotNull String ownerId) {
            Intrinsics.checkNotNullParameter(srcUuid, "srcUuid");
            Intrinsics.checkNotNullParameter(newUuid, "newUuid");
            Intrinsics.checkNotNullParameter(newPath, "newPath");
            Intrinsics.checkNotNullParameter(spaceId, "spaceId");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intrinsics.checkNotNullParameter(ownerId, "ownerId");
            this.srcUuid = srcUuid;
            this.newUuid = newUuid;
            this.newPath = newPath;
            this.spaceId = spaceId;
            this.groupId = groupId;
            this.ownerId = ownerId;
        }

        public static /* synthetic */ Param copy$default(Param param, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = param.srcUuid;
            }
            if ((i & 2) != 0) {
                str2 = param.newUuid;
            }
            if ((i & 4) != 0) {
                str3 = param.newPath;
            }
            if ((i & 8) != 0) {
                str4 = param.spaceId;
            }
            if ((i & 16) != 0) {
                str5 = param.groupId;
            }
            if ((i & 32) != 0) {
                str6 = param.ownerId;
            }
            String str7 = str5;
            String str8 = str6;
            return param.copy(str, str2, str3, str4, str7, str8);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSrcUuid() {
            return this.srcUuid;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getNewUuid() {
            return this.newUuid;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getNewPath() {
            return this.newPath;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSpaceId() {
            return this.spaceId;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getGroupId() {
            return this.groupId;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getOwnerId() {
            return this.ownerId;
        }

        @NotNull
        public final Param copy(@NotNull String srcUuid, @NotNull String newUuid, @NotNull String newPath, @NotNull String spaceId, @NotNull String groupId, @NotNull String ownerId) {
            Intrinsics.checkNotNullParameter(srcUuid, "srcUuid");
            Intrinsics.checkNotNullParameter(newUuid, "newUuid");
            Intrinsics.checkNotNullParameter(newPath, "newPath");
            Intrinsics.checkNotNullParameter(spaceId, "spaceId");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intrinsics.checkNotNullParameter(ownerId, "ownerId");
            return new Param(srcUuid, newUuid, newPath, spaceId, groupId, ownerId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Param)) {
                return false;
            }
            Param param = (Param) other;
            return Intrinsics.areEqual(this.srcUuid, param.srcUuid) && Intrinsics.areEqual(this.newUuid, param.newUuid) && Intrinsics.areEqual(this.newPath, param.newPath) && Intrinsics.areEqual(this.spaceId, param.spaceId) && Intrinsics.areEqual(this.groupId, param.groupId) && Intrinsics.areEqual(this.ownerId, param.ownerId);
        }

        @NotNull
        public final String getGroupId() {
            return this.groupId;
        }

        @NotNull
        public final String getNewPath() {
            return this.newPath;
        }

        @NotNull
        public final String getNewUuid() {
            return this.newUuid;
        }

        @NotNull
        public final String getOwnerId() {
            return this.ownerId;
        }

        @NotNull
        public final String getSpaceId() {
            return this.spaceId;
        }

        @NotNull
        public final String getSrcUuid() {
            return this.srcUuid;
        }

        public int hashCode() {
            return this.ownerId.hashCode() + AbstractC1038a.m1202c(AbstractC1038a.m1202c(AbstractC1038a.m1202c(AbstractC1038a.m1202c(this.srcUuid.hashCode() * 31, 31, this.newUuid), 31, this.newPath), 31, this.spaceId), 31, this.groupId);
        }

        @NotNull
        public String toString() {
            String str = this.srcUuid;
            String str2 = this.newUuid;
            String str3 = this.newPath;
            String str4 = this.spaceId;
            String str5 = this.groupId;
            String str6 = this.ownerId;
            StringBuilder sbM16m = AbstractC0000a.m16m("Param(srcUuid=", str, ", newUuid=", str2, ", newPath=");
            AbstractC2821a.m2207B(sbM16m, str3, ", spaceId=", str4, ", groupId=");
            return AbstractC0541b.m776r(sbM16m, str5, ", ownerId=", str6, ")");
        }
    }

    static {
        String strCreateTag = ModelLogger.createTag("ImportNoteToSharedNotebookUseCase");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public AddNoteToSharedNotebookUseCase(@NotNull Context mAppContext) {
        Intrinsics.checkNotNullParameter(mAppContext, "mAppContext");
        this.mAppContext = mAppContext;
    }

    private final Bitmap captureObject(SpenNoteCapturePage capturePage, SpenWPage tempPage, SpenObjectBase obj) {
        tempPage.insertObject(obj, 0);
        Bitmap bitmapCaptureRect = capturePage.captureRect(obj.getRect());
        tempPage.removeObject(obj);
        return bitmapCaptureRect;
    }

    private final boolean changeObjectToImage(SpenWPage page, SpenObjectBase object, Bitmap bitmap, RectF imageRect) {
        int iRemoveObject = removeObject(page, object);
        if (bitmap != null) {
            return insertImageObject(page, bitmap, imageRect, iRemoveObject);
        }
        DataLogger.m12309w(TAG, "changeObjectToImage, bitmap is null. Object is removed");
        return false;
    }

    private final boolean changeObjectToImageWithCapturedBitmap(SpenWPage page, SpenObjectBase obj, SpenNoteCapturePage capturePage, SpenWPage tempPage) {
        int iRemoveObject = removeObject(page, obj);
        Bitmap bitmapCaptureObject = captureObject(capturePage, tempPage, obj);
        if (bitmapCaptureObject != null) {
            return insertImageObject(page, bitmapCaptureObject, obj.getRect(), iRemoveObject);
        }
        DataLogger.m12309w(TAG, "changeObjectToImageWithCapturedBitmap, bitmap is null. Object is removed");
        return false;
    }

    private final void convertMath(SpenWNote document) {
        int pageCount = document.getPageCount();
        if (pageCount < 1) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iConvertMathObjects = 0;
        document.setPageDefaultHeight(document.getPage(0).getHeight());
        SpenWPage spenWPageInsertPage = document.insertPage(pageCount);
        spenWPageInsertPage.setBackgroundColor(0);
        SpenNoteCapturePage spenNoteCapturePage = new SpenNoteCapturePage(this.mAppContext);
        this.mCapturePage = spenNoteCapturePage;
        Intrinsics.checkNotNull(spenNoteCapturePage);
        spenNoteCapturePage.setWNote(document);
        SpenNoteCapturePage spenNoteCapturePage2 = this.mCapturePage;
        Intrinsics.checkNotNull(spenNoteCapturePage2);
        spenNoteCapturePage2.setContents(spenWPageInsertPage, document.getBodyText(), pageCount);
        int size = 0;
        for (SpenWPage spenWPage : document.getPageList()) {
            ArrayList<SpenObjectBase> objectList = spenWPage.getObjectList(1572864);
            if (!objectList.isEmpty()) {
                size += objectList.size();
                SpenNoteCapturePage spenNoteCapturePage3 = this.mCapturePage;
                Intrinsics.checkNotNull(spenNoteCapturePage3);
                iConvertMathObjects += convertMathObjects(spenWPage, objectList, spenNoteCapturePage3, spenWPageInsertPage);
            }
        }
        document.removePage(pageCount);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(iConvertMathObjects, size, "convert math objects to images ", "/", SQLKeyword.COMMA);
        sbM1173s.append(jCurrentTimeMillis2);
        sbM1173s.append("ms");
        DataLogger.m12307i(str, sbM1173s.toString());
    }

    private final int convertMathObjects(SpenWPage page, List<SpenObjectBase> objects, SpenNoteCapturePage capturePage, SpenWPage tempPage) {
        int i = 0;
        for (SpenObjectBase spenObjectBase : objects) {
            if (spenObjectBase.getType() == 20 && changeObjectToImage(page, spenObjectBase, spenObjectBase.getCapturedBitmap(), spenObjectBase.getRect())) {
                i++;
                DataLogger.m12307i(TAG, "convert math objects to images, use plot cache");
            } else if (changeObjectToImageWithCapturedBitmap(page, spenObjectBase, capturePage, tempPage)) {
                i++;
            }
        }
        return i;
    }

    private final boolean copyFile(String srcPath, String newPath) {
        try {
            DocumentFileManager.getInstance().copy(srcPath, newPath);
            return SdocXDocumentLocker.unlockSdocXFile(newPath);
        } catch (IOException e) {
            AbstractC11014a.m12314C("fail to copy a document, e : ", e.getMessage(), TAG);
            return false;
        }
    }

    private final NotesDocumentEntity createNewEntity(NotesDocumentEntity srcEntity, Param param) {
        NotesDocumentEntity notesDocumentEntityMo22193clone = srcEntity.mo22193clone();
        Intrinsics.checkNotNullExpressionValue(notesDocumentEntityMo22193clone, "clone(...)");
        if (UUIDUtils.isCoeditUuid(srcEntity.getUuid()) && srcEntity.getIsDeleted() == 2) {
            notesDocumentEntityMo22193clone.setIsDeleted(0);
            notesDocumentEntityMo22193clone.setCategoryIsDirty(1);
            notesDocumentEntityMo22193clone.setCategoryServerTimeStamp(Long.valueOf(TimeManager.INSTANCE.getCurrentTime(this.mAppContext)));
            notesDocumentEntityMo22193clone.setRecycleBinTimeMoved(0L);
        }
        notesDocumentEntityMo22193clone.setId(null);
        notesDocumentEntityMo22193clone.setUuid(param.getNewUuid());
        notesDocumentEntityMo22193clone.setIsDirty(1);
        notesDocumentEntityMo22193clone.setFilePath(param.getNewPath());
        notesDocumentEntityMo22193clone.setAbsolutePath("");
        notesDocumentEntityMo22193clone.setCategoryUuid(PredefinedCategory.COEDIT_NOTES.getUuid());
        notesDocumentEntityMo22193clone.setMdeSpaceId(param.getSpaceId());
        notesDocumentEntityMo22193clone.setMdeGroupId(param.getGroupId());
        notesDocumentEntityMo22193clone.setMdeOwnerId(param.getOwnerId());
        notesDocumentEntityMo22193clone.setIsFavorite(0);
        notesDocumentEntityMo22193clone.setIsLock(0);
        notesDocumentEntityMo22193clone.setLockAccountGuid("");
        notesDocumentEntityMo22193clone.setMdeItemId("");
        String str = TAG;
        String spaceId = param.getSpaceId();
        String groupId = param.getGroupId();
        String ownerId = param.getOwnerId();
        StringBuilder sbM16m = AbstractC0000a.m16m("createNewEntity, space/group/owner: ", spaceId, "/", groupId, "/");
        sbM16m.append(ownerId);
        DataLogger.m12307i(str, sbM16m.toString());
        return notesDocumentEntityMo22193clone;
    }

    private final void deleteCopiedFile(NotesDocumentEntity newEntity) {
        DataLogger.m12305f(TAG, "#deleteCopiedFile, uuid/path: " + newEntity.getUuid() + "/" + DataLogger.getEncode(newEntity.getFilePath()));
        NotesDocumentDeleteUtils.deleteDocumentFile(this.mAppContext, newEntity.getUuid(), newEntity.getFilePath(), null, null, 6);
    }

    private final boolean insertImageObject(SpenWPage page, Bitmap bitmap, RectF imageRect, int index) {
        SpenObjectImage spenObjectImageMakeObjectImage = SpenObjectConstructor.makeObjectImage();
        spenObjectImageMakeObjectImage.setRect(imageRect, false);
        spenObjectImageMakeObjectImage.setImage(bitmap);
        page.insertObject(spenObjectImageMakeObjectImage, index);
        return true;
    }

    private final boolean isSourceAvailable(NotesDocumentEntity srcEntity) {
        if (!srcEntity.isSdocx()) {
            DataLogger.m12309w(TAG, "src file is not .sdocx");
            return false;
        }
        if (srcEntity.getIsDeleted() == 1) {
            DataLogger.m12309w(TAG, "src file is deleted");
            return false;
        }
        if (srcEntity.getCorrupted() == 1) {
            DataLogger.m12309w(TAG, "src file is corrupted");
            return false;
        }
        if (SpenWNoteFile.getPageMode(srcEntity.getFilePath()) == SpenWNote.PageMode.SINGLE) {
            DataLogger.m12309w(TAG, "src file is not LIST Type");
            return false;
        }
        String filePath = srcEntity.getFilePath();
        Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
        if (SpenWNoteFile.getOrientation(filePath) != SpenWNote.Orientation.LANDSCAPE_NEW) {
            return true;
        }
        DataLogger.m12309w(TAG, "src file is not Portrait Type");
        return false;
    }

    private final int removeObject(SpenWPage page, SpenObjectBase object) {
        int objectIndex = page.getObjectIndex(object);
        page.removeObject(object);
        return objectIndex;
    }

    private final boolean saveToDB(SpenWNote document, NotesDocumentEntity newEntity) {
        return DocumentWriteResolver.save(this.mAppContext, true, newEntity.getFilePath(), newEntity, document, newEntity.getLockAccountGuid(), true, TAG);
    }

    private final boolean saveToFile(SpenWNote document, String filePath) {
        try {
            DocumentFileManager.getInstance().saveAsDirectory(document, filePath);
            return true;
        } catch (IOException e) {
            AbstractC11014a.m12314C("saveToFile, e : ", e.getMessage(), TAG);
            return false;
        }
    }

    private final int updateCopiedDocument(NotesDocumentEntity newEntity) {
        DocumentFileManager documentFileManager;
        String filePath;
        int i = 110;
        SpenWNote spenWNoteOpen = null;
        try {
            try {
                try {
                    spenWNoteOpen = DocumentFileManager.getInstance().open(this.mAppContext, newEntity.getFilePath(), 2160, 8500, true, true);
                    int iCanAllowToChangeCoedit = DocumentCopyUtils.canAllowToChangeCoedit(spenWNoteOpen);
                    if (iCanAllowToChangeCoedit != 101) {
                        i = iCanAllowToChangeCoedit;
                    } else if (updateDocument(spenWNoteOpen, newEntity)) {
                        i = 100;
                    }
                    SpenNoteCapturePage spenNoteCapturePage = this.mCapturePage;
                    if (spenNoteCapturePage != null) {
                        Intrinsics.checkNotNull(spenNoteCapturePage);
                        spenNoteCapturePage.close();
                    }
                    documentFileManager = DocumentFileManager.getInstance();
                    filePath = newEntity.getFilePath();
                } catch (Exception e) {
                    DataLogger.m12303e(TAG, "updateCopiedDocument, e: " + e.getMessage());
                    SpenNoteCapturePage spenNoteCapturePage2 = this.mCapturePage;
                    if (spenNoteCapturePage2 != null) {
                        Intrinsics.checkNotNull(spenNoteCapturePage2);
                        spenNoteCapturePage2.close();
                    }
                    documentFileManager = DocumentFileManager.getInstance();
                    filePath = newEntity.getFilePath();
                }
                documentFileManager.close(filePath, spenWNoteOpen, true);
            } catch (IOException e2) {
                AbstractC11014a.m12314C("fail to close a document, e : ", e2.getMessage(), TAG);
            }
            return i;
        } finally {
        }
    }

    private final boolean updateDocument(SpenWNote document, NotesDocumentEntity newEntity) {
        SpenDisplay spenDisplayMakeSpenDisplay = ToolConstructor.makeSpenDisplay(this.mAppContext);
        int iCalculateTextSizeDelta = SpenNoteTextManagerWrapper.calculateTextSizeDelta(spenDisplayMakeSpenDisplay, document.getBodyTextFontSizeDelta());
        spenDisplayMakeSpenDisplay.close();
        List objectList = new SpenWNoteObjectHelper().getObjectList(document, 70);
        Intrinsics.checkNotNullExpressionValue(objectList, "getObjectList(...)");
        objectList.add(document.getBodyText());
        DocumentCopyUtils.removeUnsupportedCharactersForCoedit((List<SpenObjectShape>) objectList);
        document.invertBackgroundColor(false);
        document.setBodyTextFontSizeDelta(iCalculateTextSizeDelta);
        document.setFixedTextDirection(SpenWNote.TextDirection.TEXT_DIRECTION_LTR);
        document.setFixedBackgroundTheme(SpenWNote.BackgroundTheme.THEME_LIGHT);
        document.setServerCheckPoint(-1L);
        document.initializeCoeditData();
        convertMath(document);
        return saveToFile(document, newEntity.getFilePath()) && saveToDB(document, newEntity);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.domain.common.BaseUseCase
    @NotNull
    public Integer execute(@NotNull Param param) {
        Intrinsics.checkNotNullParameter(param, "param");
        String str = TAG;
        DataLogger.m12307i(str, "execute, srcUuid : " + param.getSrcUuid() + ", newUuid : " + param.getNewUuid());
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(this.mAppContext).createDocumentDataRepository();
        Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
        NotesDocumentEntity notesDocumentEntity = notesDocumentRepositoryCreateDocumentDataRepository.get(param.getSrcUuid());
        if (notesDocumentEntity == null) {
            DataLogger.m12303e(str, "src entity is null");
            return 110;
        }
        if (!isSourceAvailable(notesDocumentEntity)) {
            return 110;
        }
        try {
            NotesDocumentEntity notesDocumentEntityCreateNewEntity = createNewEntity(notesDocumentEntity, param);
            String filePath = notesDocumentEntity.getFilePath();
            Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
            if (!copyFile(filePath, param.getNewPath())) {
                return 110;
            }
            int iUpdateCopiedDocument = updateCopiedDocument(notesDocumentEntityCreateNewEntity);
            if (iUpdateCopiedDocument == 100) {
                new DocumentPostSaveOperation(this.mAppContext, true, notesDocumentEntityCreateNewEntity, null).setStrategy(new DataStrategy(44).getMStrategy()).run();
            } else {
                deleteCopiedFile(notesDocumentEntityCreateNewEntity);
            }
            DataLogger.m12307i(str, "execute, result : " + iUpdateCopiedDocument);
            return Integer.valueOf(iUpdateCopiedDocument);
        } catch (CloneNotSupportedException e) {
            DataLogger.m12303e(TAG, "fail to clone src entity, e : " + e.getMessage());
            return 110;
        }
    }
}
