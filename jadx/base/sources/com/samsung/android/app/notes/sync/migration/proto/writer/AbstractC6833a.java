package com.samsung.android.app.notes.sync.migration.proto.writer;

import com.samsung.android.app.notes.sync.migration.proto.datastore.C6824f;
import com.samsung.android.app.notes.sync.migration.proto.datastore.C6832n;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import os_migration_data_types.p233v1.AttachmentType;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.proto.writer.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC6833a {

    /* JADX INFO: renamed from: a */
    public static C6824f f4243a;

    /* JADX INFO: renamed from: b */
    public static C6832n f4244b;

    /* JADX INFO: renamed from: a */
    public static void m4986a(AttachmentType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        BuildersKt__BuildersKt.runBlocking$default(null, new AttachmentMetaWriter$Companion$setAttachmentType$1(type, null), 1, null);
    }

    /* JADX INFO: renamed from: b */
    public static void m4987b(long j) {
        BuildersKt__BuildersKt.runBlocking$default(null, new NoteMetaWriter$Companion$setCreationDataMillisSinceEpoch$1(j, null), 1, null);
    }

    /* JADX INFO: renamed from: c */
    public static void m4988c(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        BuildersKt__BuildersKt.runBlocking$default(null, new AttachmentMetaWriter$Companion$setFileName$1(fileName, null), 1, null);
    }

    /* JADX INFO: renamed from: d */
    public static void m4989d(String folderPath) {
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        BuildersKt__BuildersKt.runBlocking$default(null, new NoteMetaWriter$Companion$setFolderPath$1(folderPath, null), 1, null);
    }

    /* JADX INFO: renamed from: e */
    public static void m4990e(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__BuildersKt.runBlocking$default(null, new NoteMetaWriter$Companion$setId$1(id, null), 1, null);
    }

    /* JADX INFO: renamed from: f */
    public static void m4991f(boolean z) {
        BuildersKt__BuildersKt.runBlocking$default(null, new NoteMetaWriter$Companion$setIsCloudSynced$1(z, null), 1, null);
    }

    /* JADX INFO: renamed from: g */
    public static void m4992g(long j) {
        BuildersKt__BuildersKt.runBlocking$default(null, new NoteMetaWriter$Companion$setLastModifiedDateMillisSinceEpoch$1(j, null), 1, null);
    }

    /* JADX INFO: renamed from: h */
    public static void m4993h(String noteId) {
        Intrinsics.checkNotNullParameter(noteId, "noteId");
        BuildersKt__BuildersKt.runBlocking$default(null, new AttachmentMetaWriter$Companion$setNoteId$1(noteId, null), 1, null);
    }

    /* JADX INFO: renamed from: i */
    public static void m4994i(ArrayList tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        BuildersKt__BuildersKt.runBlocking$default(null, new NoteMetaWriter$Companion$setTags$1(tags, null), 1, null);
    }

    /* JADX INFO: renamed from: j */
    public static void m4995j(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        BuildersKt__BuildersKt.runBlocking$default(null, new NoteMetaWriter$Companion$setTitle$1(title, null), 1, null);
    }
}
