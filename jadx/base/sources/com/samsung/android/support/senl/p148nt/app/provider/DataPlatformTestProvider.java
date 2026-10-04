package com.samsung.android.support.senl.p148nt.app.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.sync.providers.DataUpdateObserverImpl;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.DataUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.DisplayDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentTextSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesRetryEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectResolver;
import com.samsung.android.support.senl.p148nt.model.document.DocumentInitializer;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.helper.BaseDocumentHelper;
import com.samsung.android.support.senl.p148nt.model.helper.CreateDocumentHelper;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016JO\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J1\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u001aJ;\u0010\u001b\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0005H\u0002J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\f2\b\u0010!\u001a\u0004\u0018\u00010\u001fH\u0016¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/provider/DataPlatformTestProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "onCreate", "", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "values", "Landroid/content/ContentValues;", "insertNote", "", "insertNoteDbOnly", OpenSessionApi.ITEM_LIMIT_DELETE, "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", Constants.ARG_UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "initContext", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "extras", "Entities", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DataPlatformTestProvider extends ContentProvider {

    @NotNull
    private static final String TAG = "DataPlatformTestProvider";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/provider/DataPlatformTestProvider$Entities;", "", "values", "Landroid/content/ContentValues;", "<init>", "(Landroid/content/ContentValues;)V", "mDocEntity", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentEntity;", "getMDocEntity", "()Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentEntity;", "mTextSearchEntity", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentTextSearchEntity;", "getMTextSearchEntity", "()Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentTextSearchEntity;", "mStrokeEntities", "", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesStrokeSearchEntity;", "getMStrokeEntities", "()Ljava/util/List;", "mRetryEntity", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesRetryEntity;", "getMRetryEntity", "()Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesRetryEntity;", "getDocEntity", "uuid", "", ExternalDataConstants.Column.BODY_TEXT, "getTextSearchEntity", "getStrokeEntities", "getRetryEntity", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Entities {

        @NotNull
        private final NotesDocumentEntity mDocEntity;

        @NotNull
        private final NotesRetryEntity mRetryEntity;

        @NotNull
        private final List<NotesStrokeSearchEntity> mStrokeEntities;

        @NotNull
        private final NotesDocumentTextSearchEntity mTextSearchEntity;

        public Entities(@NotNull ContentValues values) {
            Intrinsics.checkNotNullParameter(values, "values");
            String asString = values.getAsString("UUID");
            asString = asString == null ? "" : asString;
            String asString2 = values.getAsString(ExternalDataConstants.Column.BODY_TEXT);
            String str = asString2 != null ? asString2 : "";
            this.mDocEntity = getDocEntity(asString, str, values);
            this.mTextSearchEntity = getTextSearchEntity(asString, str);
            this.mStrokeEntities = getStrokeEntities(asString, values);
            this.mRetryEntity = getRetryEntity(asString, values);
        }

        private final NotesDocumentEntity getDocEntity(String uuid, String bodyText, ContentValues values) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            NotesDocumentEntity notesDocumentEntity = new NotesDocumentEntity();
            notesDocumentEntity.setUuid(uuid);
            String asString = values.getAsString("title");
            if (asString == null) {
                asString = "";
            }
            notesDocumentEntity.setTitle(asString);
            notesDocumentEntity.setContent(DisplayDataConverter.trimMaxContentString(bodyText));
            Long asLong = values.getAsLong("createdAt");
            notesDocumentEntity.setCreatedAt(asLong != null ? asLong.longValue() : jCurrentTimeMillis);
            Long asLong2 = values.getAsLong("lastModifiedAt");
            if (asLong2 != null) {
                jCurrentTimeMillis = asLong2.longValue();
            }
            notesDocumentEntity.setLastModifiedAt(jCurrentTimeMillis);
            return notesDocumentEntity;
        }

        private final NotesRetryEntity getRetryEntity(String uuid, ContentValues values) {
            Long asLong = values.getAsLong("lastModifiedAt");
            NotesRetryEntity notesRetryEntityCreateRetryEntity = CollectResolver.createRetryEntity(uuid, asLong != null ? asLong.longValue() : System.currentTimeMillis(), 2);
            Intrinsics.checkNotNullExpressionValue(notesRetryEntityCreateRetryEntity, "createRetryEntity(...)");
            return notesRetryEntityCreateRetryEntity;
        }

        private final List<NotesStrokeSearchEntity> getStrokeEntities(String uuid, ContentValues values) {
            String asString = values.getAsString(ExternalDataConstants.Column.HANDWRITING_TEXT);
            if (asString == null) {
                asString = "";
            }
            List<String> listM13999t = AbstractC12991c.m13999t(0, " ", asString);
            ArrayList arrayList = new ArrayList();
            for (String str : listM13999t) {
                if (str.length() != 0) {
                    NotesStrokeSearchEntity notesStrokeSearchEntity = new NotesStrokeSearchEntity();
                    notesStrokeSearchEntity.setDocUuid(uuid);
                    notesStrokeSearchEntity.setText(str);
                    arrayList.add(notesStrokeSearchEntity);
                }
            }
            return arrayList;
        }

        private final NotesDocumentTextSearchEntity getTextSearchEntity(String uuid, String bodyText) {
            NotesDocumentTextSearchEntity notesDocumentTextSearchEntity = new NotesDocumentTextSearchEntity();
            notesDocumentTextSearchEntity.setDocUuid(uuid);
            notesDocumentTextSearchEntity.setStrippedContent(bodyText);
            return notesDocumentTextSearchEntity;
        }

        @NotNull
        public final NotesDocumentEntity getMDocEntity() {
            return this.mDocEntity;
        }

        @NotNull
        public final NotesRetryEntity getMRetryEntity() {
            return this.mRetryEntity;
        }

        @NotNull
        public final List<NotesStrokeSearchEntity> getMStrokeEntities() {
            return this.mStrokeEntities;
        }

        @NotNull
        public final NotesDocumentTextSearchEntity getMTextSearchEntity() {
            return this.mTextSearchEntity;
        }
    }

    private final boolean initContext() {
        if (getContext() == null) {
            return false;
        }
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        DataUtils.setContext(context.getApplicationContext());
        return true;
    }

    private final void insertNote(ContentValues values) {
        String asString = values.getAsString("UUID");
        if (asString == null) {
            asString = "";
        }
        if (asString.length() == 0) {
            asString = UUIDUtils.newUUID(getContext());
        }
        String asString2 = values.getAsString("title");
        final String str = asString2 == null ? "" : asString2;
        String asString3 = values.getAsString(ExternalDataConstants.Column.BODY_TEXT);
        final String str2 = asString3 == null ? "" : asString3;
        final Long asLong = values.getAsLong("createdAt");
        final Long asLong2 = values.getAsLong("lastModifiedAt");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        DocumentSubscriptionId BACKGROUND_DOCUMENT_SERVICE_ID = DocumentSubscriptionId.BACKGROUND_DOCUMENT_SERVICE_ID;
        Intrinsics.checkNotNullExpressionValue(BACKGROUND_DOCUMENT_SERVICE_ID, "BACKGROUND_DOCUMENT_SERVICE_ID");
        new CreateDocumentHelper(context, BACKGROUND_DOCUMENT_SERVICE_ID).setUuid(asString).setListener(new BaseDocumentHelper.Listener() { // from class: com.samsung.android.support.senl.nt.app.provider.DataPlatformTestProvider.insertNote.1
            @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
            public void onFailed(String uuid) {
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                Logger.m8698e(DataPlatformTestProvider.TAG, "insertNote, onFailed, uuid: " + uuid);
                countDownLatch.countDown();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
            public void onOpen(NotesDocument<ISpenDocument> document, String uuid) {
                Intrinsics.checkNotNullParameter(document, "document");
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                ISpenDocument doc = document.getDoc();
                if (doc == 0) {
                    AbstractC4539a.m3214x("insertNote, onOpen, doc is null, uuid: ", uuid, DataPlatformTestProvider.TAG);
                    countDownLatch.countDown();
                    return;
                }
                Context context2 = this.getContext();
                Intrinsics.checkNotNull(context2);
                new DocumentInitializer(context2).initNewNote((SpenWNote) doc);
                String str3 = str;
                if (str3 != null) {
                    doc.insertTitle(str3);
                }
                if (!TextUtils.isEmpty(str2)) {
                    doc.insertBody(str2);
                }
                if (asLong != null) {
                    document.getDocumentEntityContainer().getEntity().getTimeSaveParam().setCreatedTime(asLong);
                }
                if (asLong2 != null) {
                    document.getDocumentEntityContainer().getEntity().getTimeSaveParam().setLastModifiedTime(asLong2);
                }
            }

            @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
            public void onSave(NotesDocument<ISpenDocument> document, String uuid) {
                Intrinsics.checkNotNullParameter(document, "document");
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                Logger.m8697d(DataPlatformTestProvider.TAG, "insertNote, onSave, uuid: " + uuid);
                countDownLatch.countDown();
            }
        }).execute();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            AbstractC4539a.m3214x("insertNote, e: ", e.getMessage(), TAG);
        }
    }

    private final void insertNoteDbOnly(ContentValues values) {
        Entities entities = new Entities(values);
        if (TextUtils.isEmpty(entities.getMDocEntity().getUuid())) {
            Logger.m8697d(TAG, "insertNoteDbOnly, uuid is empty");
        } else {
            NotesDatabaseManager.getInstance().getDebugDao().insert(entities.getMDocEntity(), entities.getMTextSearchEntity(), entities.getMStrokeEntities(), entities.getMRetryEntity());
            AbstractC4539a.m3188B("insertNoteDbOnly - end, uuid: ", entities.getMDocEntity().getUuid(), TAG);
        }
    }

    @Override // android.content.ContentProvider
    @NotNull
    public Bundle call(@NotNull String method, @Nullable String uri, @Nullable Bundle extras) {
        Intrinsics.checkNotNullParameter(method, "method");
        Bundle bundle = new Bundle();
        if (!initContext()) {
            Logger.m8697d(TAG, "call, context is null");
            return bundle;
        }
        DataUpdateManager.Companion companion = DataUpdateManager.INSTANCE;
        companion.getInstance().addObserver(0, new DataUpdateObserverImpl(DataUtils.getContext()));
        if (Intrinsics.areEqual(ExternalDataConstants.Method.NOTIFY_DATA_UPDATED, method)) {
            companion.getInstance().onDataUpdated(2);
        }
        return bundle;
    }

    @Override // android.content.ContentProvider
    public int delete(@NotNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (!initContext()) {
            Logger.m8697d(TAG, "delete, context is null");
            return 0;
        }
        if (selectionArgs == null) {
            NotesDatabaseManager.getInstance().getDebugDao().deleteAll();
            Logger.m8697d(TAG, "delete all");
            return 0;
        }
        NotesDatabaseManager.getInstance().getDebugDao().deleteNotes(ArraysKt.asList(selectionArgs));
        Logger.m8697d(TAG, "delete, uuids: " + ArraysKt.asList(selectionArgs));
        return selectionArgs.length;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues values) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Logger.m8697d(TAG, "insert - start");
        if (!initContext()) {
            Logger.m8697d(TAG, "insert, context is null");
            return null;
        }
        if (values == null) {
            Logger.m8697d(TAG, "insert, selectionArgs is null");
            return null;
        }
        Boolean asBoolean = values.getAsBoolean(ExternalDataConstants.KEY_INSERT_NOTE_DB_ONLY);
        if (asBoolean == null || asBoolean.booleanValue()) {
            insertNoteDbOnly(values);
        } else {
            insertNote(values);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Logger.m8697d(TAG, "query");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NotNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (!initContext()) {
            Logger.m8697d(TAG, "update, context is null");
            return 0;
        }
        if (values == null) {
            Logger.m8697d(TAG, "update, selectionArgs is null");
            return 0;
        }
        Entities entities = new Entities(values);
        if (TextUtils.isEmpty(entities.getMDocEntity().getUuid())) {
            Logger.m8697d(TAG, "update, uuid is empty");
            return 0;
        }
        int iUpdate = NotesDatabaseManager.getInstance().getDebugDao().update(entities.getMDocEntity(), entities.getMTextSearchEntity(), entities.getMStrokeEntities());
        AbstractC4539a.m3188B("update, uuid: ", entities.getMDocEntity().getUuid(), TAG);
        return iUpdate;
    }
}
