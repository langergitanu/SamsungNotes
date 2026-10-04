package p087V0;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.importer.task.CreateSdocXTask;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.FilesKt__FileReadWriteKt;
import p079T.AbstractC0299q;
import p176e1.AbstractC11975a;
import p183g1.C12013b;
import p186h1.AbstractC12029j;

/* JADX INFO: renamed from: V0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class CallableC0323a implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f834a;

    /* JADX INFO: renamed from: b */
    public final Object f835b;

    public /* synthetic */ CallableC0323a(Object obj, int i) {
        this.f834a = i;
        this.f835b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.f834a;
        Object obj = this.f835b;
        switch (i) {
            case 0:
                CallableC0325c callableC0325c = (CallableC0325c) obj;
                String str = callableC0325c.f838b;
                String str2 = callableC0325c.f839c;
                String str3 = AbstractC12029j.f8794a;
                return new C0324b((List) FolderManager.getInstance().executeOperation(new CallableC0325c(str, str2)));
            case 1:
                String str4 = PredefinedCategory.UNCATEGORIZED.getPath() + ((String) obj).replaceAll("[\\*/\\\\\\?:<>\\|\"]+", "");
                String strFindAndMakeCategory = FolderManager.getInstance().findAndMakeCategory(str4);
                Debugger.m8607d("ImportResolver", "addCategory, newFolderPath : " + str4 + ", newFolderUuid : " + strFindAndMakeCategory);
                return strFindAndMakeCategory;
            default:
                AbstractC0299q.m643n(C12013b.f8766v, "ConvertMarkDownCallable");
                String strM12320e = AbstractC11014a.m12320e(AbstractC11975a.m13543f().getFilesDir(), "/SmartSwitch");
                String strM756B = AbstractC0541b.m756B(strM12320e, "/Attachments/");
                String strM756B2 = AbstractC0541b.m756B(strM12320e, "/Markdown Example.md");
                SpenWNote note = ((CreateSdocXTask) obj).getNote();
                String text$default = FilesKt__FileReadWriteKt.readText$default(new File(strM756B2), null, 1, null);
                MarkdownConverter markdownConverter = new MarkdownConverter();
                Intrinsics.checkNotNull(note);
                markdownConverter.insertMarkdown(note, text$default, strM756B);
                return note;
        }
    }

    public CallableC0323a(C12013b c12013b, CreateSdocXTask task) {
        this.f834a = 2;
        Intrinsics.checkNotNullParameter(task, "task");
        this.f835b = task;
    }
}
