package com.samsung.android.app.notes.sync.migration.backup.task.osmosis;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.datastore.core.DataStoreFactory;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.app.notes.sync.migration.proto.datastore.C6824f;
import com.samsung.android.app.notes.sync.migration.proto.datastore.C6832n;
import com.samsung.android.app.notes.sync.migration.proto.writer.AbstractC6833a;
import com.samsung.android.app.notes.sync.synchronization.managers.C6907j;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.document.util.FileUtil;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.Base16Utils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.collector.util.NoteCreateModeUtil;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.FilesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import os_migration_data_types.p233v1.AttachmentType;
import os_migration_data_types.p233v1.NoteMeta;
import p001A.AbstractC0000a;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0148f;
import p049L0.C0168a;
import p053M0.AbstractC0173a;
import p064P0.C0194a;
import p069Q0.C0211f;
import p069Q0.C0215j;
import p079T.AbstractC0299q;
import p080T0.AbstractC0300a;
import p080T0.AbstractC0301b;
import p097Y0.C0344a;
import p102Z0.C0350a;
import p186h1.AbstractC12031l;
import p186h1.C12028i;
import p234q1.C14433b;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.backup.task.osmosis.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6793d extends AbstractC0173a {

    /* JADX INFO: renamed from: l */
    public static final String f4204l = "SS$".concat("OSmosisIndexingTask");

    /* JADX INFO: renamed from: g */
    public final String f4205g;

    /* JADX INFO: renamed from: h */
    public final int f4206h;

    /* JADX INFO: renamed from: i */
    public int f4207i;

    /* JADX INFO: renamed from: j */
    public final CoroutineScope f4208j;

    /* JADX INFO: renamed from: k */
    public OSmosisIndexingTask$State f4209k;

    public C6793d(C0168a c0168a) {
        super(c0168a);
        this.f4205g = "";
        this.f4208j = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.f4209k = OSmosisIndexingTask$State.NONE;
        String str = c0168a.f515c;
        Intrinsics.checkNotNullExpressionValue(str, "getTargetDir(...)");
        this.f4205g = FileUtils.getParentDirectory(str);
        this.f4206h = c0168a.f531s;
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0296  */
    @Override // p053M0.AbstractC0173a
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo436a() throws Exception {
        String str;
        C0168a c0168a;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        C0168a c0168a2;
        int i;
        String str13;
        int i2;
        String str14;
        String str15;
        String str16;
        String str17;
        JSONObject jSONObject;
        C0168a c0168a3;
        int i4;
        int i5;
        String str18;
        String str19;
        NotesDocumentEntity notesDocumentEntity;
        Iterator<NotesDocumentEntity> it;
        String str20;
        String str21;
        Context context;
        NotesDocumentEntity notesDocumentEntity2;
        NotesDocumentEntity notesDocumentEntity3;
        SpenWNote spenWNoteOpen;
        C0168a c0168a4;
        String uuid;
        ArrayList arrayListM656a;
        String strM491Z;
        String str22 = f4204l;
        AbstractC0299q.m643n(str22, "doInBackground");
        OSmosisIndexingTask$State oSmosisIndexingTask$State = OSmosisIndexingTask$State.DATA_CREATING;
        this.f4209k = oSmosisIndexingTask$State;
        int i6 = AbstractC6792c.f4203a[oSmosisIndexingTask$State.ordinal()];
        this.f4207i = i6 != 1 ? i6 != 2 ? this.f4207i : 90 : 10;
        C0168a c0168a5 = this.f549a;
        File file = new File(c0168a5.f515c);
        if (file.exists()) {
            FileUtil.deleteFile(file);
        }
        file.mkdirs();
        C0194a param = new C0194a();
        param.f603a = AbstractC0173a.m435b();
        param.f604b = c0168a5.f529q;
        String str23 = this.f4205g;
        param.f607e = AbstractC0541b.m756B(str23, "/NOTES/meta");
        String str24 = "/NOTES/data";
        param.f608f = AbstractC0541b.m756B(str23, "/NOTES/data");
        param.f609g = AbstractC0541b.m756B(str23, "/NOTES_ATTACHMENTS/meta");
        param.f610h = AbstractC0541b.m756B(str23, "/NOTES_ATTACHMENTS/data");
        Intrinsics.checkNotNullExpressionValue(param, "build(...)");
        Intrinsics.checkNotNullParameter(param, "param");
        ArrayList metaMessages = new ArrayList();
        Context context2 = param.f603a;
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        List outputDirectories = CollectionsKt.listOf((Object[]) new String[]{param.f608f, param.f610h});
        String str25 = "context";
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(outputDirectories, "outputDirectories");
        Intrinsics.checkNotNullParameter(metaMessages, "metaMessages");
        String str26 = (String) outputDirectories.get(0);
        Context context3 = context2;
        String str27 = (String) outputDirectories.get(1);
        if (AbstractC14517a.m15122G(str26) && AbstractC14517a.m15122G(str27)) {
            NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context3).createDocumentDataRepository();
            String str28 = str27;
            Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
            str3 = "/NOTES_ATTACHMENTS/meta";
            Iterator<NotesDocumentEntity> it2 = notesDocumentRepositoryCreateDocumentDataRepository.getAllDataList(false, true).iterator();
            while (it2.hasNext()) {
                NotesDocumentEntity next = it2.next();
                if (!UUIDUtils.isGenUuid(next.getUuid())) {
                    try {
                        try {
                            String str29 = str28;
                            try {
                                notesDocumentEntity3 = next;
                                try {
                                    try {
                                        try {
                                            it = it2;
                                            str20 = str29;
                                        } catch (Exception e) {
                                            e = e;
                                            str21 = str22;
                                            str19 = str24;
                                            it = it2;
                                            context = context3;
                                            notesDocumentEntity = notesDocumentEntity3;
                                            str20 = str29;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        spenWNoteOpen = null;
                                        DocumentFileManager.getInstance().close(notesDocumentEntity3.getFilePath(), spenWNoteOpen, true);
                                        throw th;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    str21 = str22;
                                    str19 = str24;
                                    it = it2;
                                    context = context3;
                                    str20 = str29;
                                    notesDocumentEntity = notesDocumentEntity3;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                str19 = str24;
                                notesDocumentEntity = next;
                                str21 = str22;
                                it = it2;
                                context = context3;
                                str20 = str29;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            notesDocumentEntity2 = next;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        str19 = str24;
                        notesDocumentEntity = next;
                        it = it2;
                        str20 = str28;
                        str21 = str22;
                        context = context3;
                    }
                    try {
                        spenWNoteOpen = DocumentFileManager.getInstance().open(context3, next.getFilePath(), SpenDocumentDisplayUtils.getScreenWidth(context3), NoteCreateModeUtil.getNoteCreateMode(), false, false);
                        str21 = str22;
                        context = context3;
                        try {
                            try {
                                int i7 = AbstractC0301b.f772a;
                                uuid = notesDocumentEntity3.getUuid();
                                c0168a4 = c0168a5;
                            } catch (Throwable th3) {
                                th = th3;
                                notesDocumentEntity = notesDocumentEntity3;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            c0168a4 = c0168a5;
                        }
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str20);
                            str19 = str24;
                            try {
                                sb.append("/");
                                sb.append(uuid);
                                arrayListM656a = AbstractC0300a.m656a(context, spenWNoteOpen, sb.toString());
                                String uuid2 = notesDocumentEntity3.getUuid();
                                Intrinsics.checkNotNullExpressionValue(uuid2, "getUuid(...)");
                                strM491Z = C0211f.m491Z(str26, str20, uuid2, arrayListM656a);
                                Intrinsics.checkNotNull(notesDocumentEntity3);
                                notesDocumentEntity = notesDocumentEntity3;
                            } catch (Exception e7) {
                                e = e7;
                                notesDocumentEntity = notesDocumentEntity3;
                                String str30 = C0211f.f642d;
                                String message = e.getMessage();
                                Context context4 = context;
                                StringBuilder sb2 = new StringBuilder();
                                notesDocumentEntity3 = notesDocumentEntity;
                                try {
                                    sb2.append("create failed ");
                                    sb2.append(message);
                                    AbstractC0299q.m646q(str30, sb2.toString());
                                    Unit unit = Unit.INSTANCE;
                                    DocumentFileManager.getInstance().close(notesDocumentEntity3.getFilePath(), spenWNoteOpen, true);
                                    c0168a5 = c0168a4;
                                    str22 = str21;
                                    str24 = str19;
                                    context3 = context4;
                                    str28 = str20;
                                    it2 = it;
                                } catch (Throwable th4) {
                                    th = th4;
                                    DocumentFileManager.getInstance().close(notesDocumentEntity3.getFilePath(), spenWNoteOpen, true);
                                    throw th;
                                }
                            }
                        } catch (Exception e8) {
                            e = e8;
                            str19 = str24;
                            notesDocumentEntity = notesDocumentEntity3;
                            String str302 = C0211f.f642d;
                            String message2 = e.getMessage();
                            Context context42 = context;
                            StringBuilder sb22 = new StringBuilder();
                            notesDocumentEntity3 = notesDocumentEntity;
                            sb22.append("create failed ");
                            sb22.append(message2);
                            AbstractC0299q.m646q(str302, sb22.toString());
                            Unit unit2 = Unit.INSTANCE;
                            DocumentFileManager.getInstance().close(notesDocumentEntity3.getFilePath(), spenWNoteOpen, true);
                            c0168a5 = c0168a4;
                            str22 = str21;
                            str24 = str19;
                            context3 = context42;
                            str28 = str20;
                            it2 = it;
                        }
                        try {
                            try {
                                metaMessages.add(C0211f.m492a0(context, notesDocumentEntity, strM491Z, arrayListM656a));
                                DocumentFileManager.getInstance().close(notesDocumentEntity.getFilePath(), spenWNoteOpen, true);
                                c0168a5 = c0168a4;
                                str24 = str19;
                                context3 = context;
                                str22 = str21;
                            } catch (Throwable th5) {
                                th = th5;
                                notesDocumentEntity3 = notesDocumentEntity;
                                DocumentFileManager.getInstance().close(notesDocumentEntity3.getFilePath(), spenWNoteOpen, true);
                                throw th;
                            }
                        } catch (Exception e9) {
                            e = e9;
                            String str3022 = C0211f.f642d;
                            String message22 = e.getMessage();
                            Context context422 = context;
                            StringBuilder sb222 = new StringBuilder();
                            notesDocumentEntity3 = notesDocumentEntity;
                            sb222.append("create failed ");
                            sb222.append(message22);
                            AbstractC0299q.m646q(str3022, sb222.toString());
                            Unit unit22 = Unit.INSTANCE;
                            DocumentFileManager.getInstance().close(notesDocumentEntity3.getFilePath(), spenWNoteOpen, true);
                            c0168a5 = c0168a4;
                            str22 = str21;
                            str24 = str19;
                            context3 = context422;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        str21 = str22;
                        str19 = str24;
                        context = context3;
                        notesDocumentEntity = notesDocumentEntity3;
                        c0168a4 = c0168a5;
                        spenWNoteOpen = null;
                        String str30222 = C0211f.f642d;
                        String message222 = e.getMessage();
                        Context context4222 = context;
                        StringBuilder sb2222 = new StringBuilder();
                        notesDocumentEntity3 = notesDocumentEntity;
                        sb2222.append("create failed ");
                        sb2222.append(message222);
                        AbstractC0299q.m646q(str30222, sb2222.toString());
                        Unit unit222 = Unit.INSTANCE;
                        DocumentFileManager.getInstance().close(notesDocumentEntity3.getFilePath(), spenWNoteOpen, true);
                        c0168a5 = c0168a4;
                        str22 = str21;
                        str24 = str19;
                        context3 = context4222;
                        str28 = str20;
                        it2 = it;
                    } catch (Throwable th6) {
                        th = th6;
                        notesDocumentEntity2 = notesDocumentEntity3;
                        notesDocumentEntity3 = notesDocumentEntity2;
                        spenWNoteOpen = null;
                        DocumentFileManager.getInstance().close(notesDocumentEntity3.getFilePath(), spenWNoteOpen, true);
                        throw th;
                    }
                    str28 = str20;
                    it2 = it;
                }
            }
            str = str22;
            c0168a = c0168a5;
            str2 = str24;
        } else {
            str = str22;
            c0168a = c0168a5;
            str2 = "/NOTES/data";
            str3 = "/NOTES_ATTACHMENTS/meta";
        }
        Context context5 = param.f603a;
        Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
        List outputDirectories2 = CollectionsKt.listOf((Object[]) new String[]{param.f607e, param.f609g});
        String str31 = C0215j.f646d;
        Intrinsics.checkNotNullParameter(context5, "context");
        Intrinsics.checkNotNullParameter(outputDirectories2, "outputDirectories");
        Intrinsics.checkNotNullParameter(metaMessages, "metaMessages");
        String str32 = (String) outputDirectories2.get(0);
        String str33 = (String) outputDirectories2.get(1);
        if (AbstractC14517a.m15122G(str32) && AbstractC14517a.m15122G(str33)) {
            if (AbstractC14517a.m15122G(context5.getFilesDir().getAbsolutePath() + "/datastore")) {
                Iterator it3 = metaMessages.iterator();
                while (true) {
                    str18 = ".filemetadata";
                    if (!it3.hasNext()) {
                        break;
                    }
                    C0350a c0350a = (C0350a) it3.next();
                    Context context6 = context5;
                    String fileName = c0350a.f873a + ".filemetadata";
                    Intrinsics.checkNotNullParameter(fileName, "fileName");
                    Context context7 = BaseUtils.getContext();
                    Iterator it4 = it3;
                    C12028i serializer = new C12028i();
                    Intrinsics.checkNotNullParameter(context7, "context");
                    Intrinsics.checkNotNullParameter(fileName, "fileName");
                    ArrayList arrayList = metaMessages;
                    Intrinsics.checkNotNullParameter(serializer, "noteMetaSerializer");
                    Intrinsics.checkNotNullParameter(context7, "context");
                    Intrinsics.checkNotNullParameter(fileName, "fileName");
                    Intrinsics.checkNotNullParameter(serializer, "serializer");
                    AbstractC6833a.f4244b = new C6832n(DataStoreFactory.create$default(DataStoreFactory.INSTANCE, serializer, null, null, null, new C0344a(context7, fileName, 0), 14, null));
                    AbstractC6833a.m4990e(c0350a.f873a);
                    AbstractC6833a.m4995j(c0350a.f874b);
                    AbstractC6833a.m4987b(c0350a.f875c);
                    AbstractC6833a.m4992g(c0350a.f876d);
                    AbstractC6833a.m4994i(c0350a.f877e);
                    String str34 = c0350a.f878f;
                    if (str34 != null) {
                        AbstractC6833a.m4989d(str34);
                    }
                    AbstractC6833a.m4991f(c0350a.f879g);
                    context5 = context6;
                    it3 = it4;
                    metaMessages = arrayList;
                }
                Context context8 = context5;
                ArrayList arrayList2 = metaMessages;
                FileUtils.moveFiles(context8.getFilesDir().getAbsolutePath() + "/datastore", str32);
                AbstractC0299q.m643n(str31, AbstractC11014a.m12321f("createNoteMetaProtoDataStore ", arrayList2.size(), " NoteMeta files are created and moved to ", str32, " directory."));
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    C0350a c0350a2 = (C0350a) it5.next();
                    Iterator it6 = c0350a2.f881i.iterator();
                    while (it6.hasNext()) {
                        String str35 = (String) it6.next();
                        Iterator it7 = it5;
                        String fileName2 = FileUtils.extractFileName(str35) + str18;
                        Intrinsics.checkNotNullParameter(fileName2, "fileName");
                        Iterator it8 = it6;
                        Context context9 = BaseUtils.getContext();
                        C6907j serializer2 = new C6907j();
                        Intrinsics.checkNotNullParameter(context9, str25);
                        Intrinsics.checkNotNullParameter(fileName2, "fileName");
                        Intrinsics.checkNotNullParameter(serializer2, "attachmentMetaSerializer");
                        Intrinsics.checkNotNullParameter(context9, str25);
                        Intrinsics.checkNotNullParameter(fileName2, "fileName");
                        Intrinsics.checkNotNullParameter(serializer2, "serializer");
                        AbstractC6833a.f4243a = new C6824f(DataStoreFactory.create$default(DataStoreFactory.INSTANCE, serializer2, null, null, null, new C0344a(context9, fileName2, 0), 14, null));
                        AbstractC6833a.m4993h(c0350a2.f873a);
                        AbstractC6833a.m4988c(str35);
                        AbstractC6833a.m4986a(AttachmentType.ATTACHMENT_TYPE_OTHER);
                        it5 = it7;
                        it6 = it8;
                        str18 = str18;
                        str25 = str25;
                    }
                }
                FileUtils.moveFiles(context8.getFilesDir().getAbsolutePath() + "/datastore", str33);
                AbstractC0299q.m643n(str31, AbstractC11014a.m12321f("createAttachmentMetaProtoDataStore ", arrayList2.size(), " AttachmentMeta files are created and moved to ", str33, " directory."));
            }
        }
        OSmosisIndexingTask$State oSmosisIndexingTask$State2 = OSmosisIndexingTask$State.DATA_INDEXING;
        this.f4209k = oSmosisIndexingTask$State2;
        int i8 = AbstractC6792c.f4203a[oSmosisIndexingTask$State2.ordinal()];
        this.f4207i = i8 != 1 ? i8 != 2 ? this.f4207i : 90 : 10;
        String strM756B = AbstractC0541b.m756B(str23, "/NOTES/meta");
        String strM756B2 = AbstractC0541b.m756B(str23, str2);
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        File[] fileArrListFiles = new File(strM756B).listFiles();
        jSONObject2.put(ImportItem.ITEM_TYPE, "NOTE");
        jSONObject2.put("item_type_version", 1);
        jSONObject2.put("is_file_metadata_type", true);
        String str36 = "count";
        String str37 = ".datafile";
        String str38 = "parseFrom(...)";
        String str39 = "file";
        int i9 = this.f4206h;
        if (fileArrListFiles != null) {
            String str40 = "file_metadata_list";
            int length = fileArrListFiles.length;
            String str41 = "next_index_file";
            String str42 = "size";
            String str43 = ".json";
            JSONArray jSONArray2 = jSONArray;
            long j = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            String str44 = "count";
            int i14 = 0;
            while (i14 < length) {
                int i15 = i11 + 1;
                int i16 = length;
                int i17 = i14;
                File file2 = new File(fileArrListFiles[i14].getAbsolutePath());
                Intrinsics.checkNotNullParameter(file2, str39);
                NoteMeta noteMeta = NoteMeta.parseFrom(FilesKt.readBytes(file2));
                Intrinsics.checkNotNullExpressionValue(noteMeta, str38);
                String str45 = str38;
                String str46 = str39;
                long length2 = new File(AbstractC2821a.m2221l(strM756B2, File.separator, noteMeta.getId(), ".datafile")).length();
                JSONObject jSONObject3 = new JSONObject();
                Intrinsics.checkNotNullParameter(noteMeta, "noteMeta");
                jSONObject3.put("value", Base16Utils.encode(noteMeta.toByteArray()));
                jSONObject3.put("data_file_size", length2);
                jSONArray2.put(jSONObject3);
                int i18 = i12 + 1;
                long j2 = j + length2;
                int i19 = i13 + 1;
                String str47 = strM756B2;
                if (i19 == i9 || i11 == ArraysKt.getLastIndex(fileArrListFiles)) {
                    String strM11h = i10 > 0 ? AbstractC0000a.m11h(i10, "NOTES_index") : "NOTES_index";
                    int i20 = i10 + 1;
                    String strM756B3 = i20 * i9 < fileArrListFiles.length ? AbstractC0541b.m756B(strM11h, "1") : "";
                    str13 = str41;
                    jSONObject2.remove(str13);
                    if ((strM756B3.length() > 0 ? strM756B3 : null) != null) {
                        i2 = i20;
                        str14 = str43;
                        jSONObject2.put(str13, strM756B3.concat(str14));
                    } else {
                        i2 = i20;
                        str14 = str43;
                    }
                    str15 = str44;
                    jSONObject2.put(str15, i18);
                    str16 = str42;
                    jSONObject2.put(str16, j2);
                    str17 = str40;
                    jSONObject2.put(str17, jSONArray2);
                    File fileM4955e = m4955e(jSONObject2, strM11h);
                    jSONObject = jSONObject2;
                    c0168a3 = c0168a;
                    AbstractC12031l.m13721k(AbstractC0173a.m435b(), fileM4955e, c0168a3.f513a);
                    jSONArray2 = new JSONArray();
                    j = 0;
                    i4 = 0;
                    i5 = 0;
                } else {
                    i2 = i10;
                    j = j2;
                    i4 = i18;
                    i5 = i19;
                    str15 = str44;
                    str17 = str40;
                    str16 = str42;
                    str14 = str43;
                    str13 = str41;
                    jSONObject = jSONObject2;
                    c0168a3 = c0168a;
                }
                i12 = i4;
                strM756B2 = str47;
                c0168a = c0168a3;
                jSONObject2 = jSONObject;
                str44 = str15;
                i14 = i17 + 1;
                str43 = str14;
                str40 = str17;
                str42 = str16;
                str41 = str13;
                i10 = i2;
                str38 = str45;
                i11 = i15;
                length = i16;
                i13 = i5;
                str39 = str46;
            }
            str6 = str38;
            str36 = str44;
            str7 = str40;
            str8 = str42;
            str5 = str43;
            str4 = str41;
        } else {
            str4 = "next_index_file";
            str5 = ".json";
            str6 = "parseFrom(...)";
            str7 = "file_metadata_list";
            str8 = "size";
        }
        String str48 = str39;
        C0168a c0168a6 = c0168a;
        AbstractC0299q.m643n(str, "createNotesIndexJson " + (fileArrListFiles != null ? Integer.valueOf(fileArrListFiles.length) : null) + " meta files found in " + strM756B);
        String str49 = c0168a6.f515c;
        Intrinsics.checkNotNullExpressionValue(str49, "getTargetDir(...)");
        String strM756B4 = AbstractC0541b.m756B(FileUtils.getParentDirectory(str49), str3);
        String str50 = c0168a6.f515c;
        Intrinsics.checkNotNullExpressionValue(str50, "getTargetDir(...)");
        String strM756B5 = AbstractC0541b.m756B(FileUtils.getParentDirectory(str50), "/NOTES_ATTACHMENTS/data");
        JSONObject jSONObject4 = new JSONObject();
        JSONArray jSONArray3 = new JSONArray();
        File[] fileArrListFiles2 = new File(strM756B4).listFiles();
        C0168a c0168a7 = c0168a6;
        jSONObject4.put(ImportItem.ITEM_TYPE, "NOTES_ATTACHMENTS");
        jSONObject4.put("item_type_version", 1);
        jSONObject4.put("is_file_metadata_type", true);
        if (fileArrListFiles2 != null) {
            int length3 = fileArrListFiles2.length;
            String str51 = str7;
            String str52 = str8;
            String str53 = str36;
            JSONArray jSONArray4 = jSONArray3;
            long j3 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i21 < length3) {
                int i26 = i22 + 1;
                int i27 = length3;
                int i28 = i21;
                File file3 = new File(fileArrListFiles2[i21].getAbsolutePath());
                Intrinsics.checkNotNullParameter(file3, str48);
                NoteMeta noteMeta2 = NoteMeta.parseFrom(FilesKt.readBytes(file3));
                Intrinsics.checkNotNullExpressionValue(noteMeta2, str6);
                String str54 = str5;
                String str55 = strM756B5;
                String str56 = str37;
                long length4 = new File(AbstractC2821a.m2221l(strM756B5, File.separator, noteMeta2.getId(), str37)).length();
                JSONObject jSONObject5 = new JSONObject();
                Intrinsics.checkNotNullParameter(noteMeta2, "noteMeta");
                jSONObject5.put("value", Base16Utils.encode(noteMeta2.toByteArray()));
                jSONObject5.put("data_file_size", length4);
                jSONArray4.put(jSONObject5);
                int i29 = i24 + 1;
                long j5 = j3 + length4;
                int i30 = i25 + 1;
                int i31 = i9;
                if (i30 == i9 || i22 == ArraysKt.getLastIndex(fileArrListFiles2)) {
                    String strM11h2 = i23 > 0 ? AbstractC0000a.m11h(i23, "NOTES_ATTACHMENTS_index") : "NOTES_ATTACHMENTS_index";
                    i23++;
                    String strM756B6 = i23 * i31 < fileArrListFiles2.length ? AbstractC0541b.m756B(strM11h2, "1") : "";
                    jSONObject4.remove(str4);
                    if ((strM756B6.length() > 0 ? strM756B6 : null) != null) {
                        str9 = str54;
                        jSONObject4.put(str4, strM756B6.concat(str9));
                    } else {
                        str9 = str54;
                    }
                    str10 = str53;
                    jSONObject4.put(str10, i29);
                    jSONObject4.put(str52, j5);
                    str11 = str51;
                    jSONObject4.put(str11, jSONArray4);
                    str12 = str56;
                    c0168a2 = c0168a7;
                    AbstractC12031l.m13721k(AbstractC0173a.m435b(), m4955e(jSONObject4, strM11h2), c0168a2.f513a);
                    jSONArray4 = new JSONArray();
                    j3 = 0;
                    i = 0;
                    i29 = 0;
                } else {
                    str12 = str56;
                    i = i30;
                    j3 = j5;
                    str10 = str53;
                    str9 = str54;
                    c0168a2 = c0168a7;
                    str11 = str51;
                }
                str53 = str10;
                i21 = i28 + 1;
                c0168a7 = c0168a2;
                str5 = str9;
                str51 = str11;
                str37 = str12;
                i22 = i26;
                strM756B5 = str55;
                i25 = i;
                i9 = i31;
                i24 = i29;
                length3 = i27;
            }
        }
        AbstractC0299q.m643n(str, "createNotesAttachmentsIndexJson " + (fileArrListFiles2 != null ? Integer.valueOf(fileArrListFiles2.length) : null) + " meta files found in " + strM756B4);
    }

    @Override // p053M0.AbstractC0173a
    /* JADX INFO: renamed from: c */
    public final void mo437c() {
        String str = f4204l;
        AbstractC0299q.m643n(str, "onPostExecute");
        CoroutineScopeKt.cancel$default(this.f4208j, null, 1, null);
        String str2 = C0148f.f420k;
        AbstractC0147e.f419a.f439i = false;
        C0148f.m356l(100);
        Intent intent = new Intent("com.samsung.android.intent.action.RESPONSE_PREPARE_OSMOSIS_NOTES");
        C0168a c0168a = this.f549a;
        intent.putExtra("PREPARE_TYPE", c0168a.f532t);
        intent.putExtra("IS_AVAILABLE_BNR", 1);
        intent.putExtra("BNR_ERROR_CODE", 0);
        AbstractC0173a.m435b().sendBroadcast(intent, "com.wssnps.permission.COM_WSSNPS");
        Debugger.INSTANCE.m8619d(str, "sendPrepareResponseIntent# prepareType " + c0168a.f532t);
        C14433b c14433b = this.f552d;
        if (c14433b != null) {
            c14433b.m15040r();
        }
    }

    @Override // p053M0.AbstractC0173a
    /* JADX INFO: renamed from: d */
    public final void mo438d() {
        AbstractC0299q.m643n(f4204l, "onPreExecute");
        String str = C0148f.f420k;
        AbstractC0147e.f419a.f439i = true;
        C0148f.m356l(1);
        BuildersKt__Builders_commonKt.launch$default(this.f4208j, null, null, new OSmosisIndexingTask$onPreExecute$1(this, null), 3, null);
    }

    /* JADX INFO: renamed from: e */
    public final File m4955e(JSONObject jSONObject, String str) throws Exception {
        File file = new File(this.f549a.f515c);
        if (!file.exists() && !file.mkdirs()) {
            throw new Exception("createJsonOutput failed to make json directory");
        }
        File file2 = new File(AbstractC0541b.m756B(AbstractC0155m.m387b(file.getAbsolutePath(), str), ".json"));
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (!FileUtils.mkFile(file2, string)) {
            throw new Exception("createJsonOutput failed to make json file");
        }
        AbstractC0299q.m643n(f4204l, "createJsonOutput jsonFile " + Logger.getEncode(file2.getPath()));
        return file2;
    }
}
