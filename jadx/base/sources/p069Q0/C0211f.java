package p069Q0;

import android.content.Context;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.component.ImageComponent;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.processing.MarkdownGenerator;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.processing.MarkdownWriter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p102Z0.C0350a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: Q0.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0211f extends AbstractC14517a {

    /* JADX INFO: renamed from: d */
    public static final String f642d = "SS$".concat("MarkDownCreator");

    /* JADX INFO: renamed from: Z */
    public static String m491Z(String str, String str2, String str3, ArrayList arrayList) {
        String strM2221l = AbstractC2821a.m2221l(str, "/", str3, ".datafile");
        MarkdownDocument markdownDocument = new MarkdownDocument();
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            markdownDocument.addComponent(new ImageComponent(StringsKt.m14139M((String) next, str2, Extension.DOT)));
        }
        MarkdownWriter.INSTANCE.write(strM2221l, MarkdownGenerator.INSTANCE.generate(markdownDocument));
        return strM2221l;
    }

    /* JADX INFO: renamed from: a0 */
    public static C0350a m492a0(Context context, NotesDocumentEntity notesDocumentEntity, String markdownPath, ArrayList attachments) {
        ArrayList tags = new ArrayList();
        Iterator<NotesTagEntity> it = NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository().getTagListByDocUuid(notesDocumentEntity.getUuid()).iterator();
        while (it.hasNext()) {
            tags.add(it.next().getDisplayName());
        }
        String absoluteFolderPath = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().getAbsoluteFolderPath(notesDocumentEntity.getUuid());
        String uuid = notesDocumentEntity.getUuid();
        Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
        String title = notesDocumentEntity.getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
        long createdAt = notesDocumentEntity.getCreatedAt();
        long lastModifiedAt = notesDocumentEntity.getLastModifiedAt();
        boolean isSynced = notesDocumentEntity.getIsSynced();
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(markdownPath, "markdownPath");
        Intrinsics.checkNotNullParameter(attachments, "attachments");
        C0350a c0350a = new C0350a();
        c0350a.f873a = uuid;
        c0350a.f874b = title;
        c0350a.f875c = createdAt;
        c0350a.f876d = lastModifiedAt;
        c0350a.f877e = tags;
        c0350a.f878f = absoluteFolderPath;
        c0350a.f879g = isSynced;
        c0350a.f880h = markdownPath;
        c0350a.f881i = attachments;
        return c0350a;
    }
}
