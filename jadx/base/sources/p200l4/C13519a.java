package p200l4;

import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerCacheFileUtil;
import com.samsung.android.support.senl.p148nt.model.securefolder.domain.ImportNoteFromSecureSpaceUseCase;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: l4.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C13519a implements FilenameFilter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9507a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9508b;

    public /* synthetic */ C13519a(Object obj, int i) {
        this.f9507a = i;
        this.f9508b = obj;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f9507a) {
            case 0:
                return ((ImportNoteFromSecureSpaceUseCase) this.f9508b).lambda$getImportTargetFiles$0(file, str);
            case 1:
                return ((ImportNoteFromSecureSpaceUseCase) this.f9508b).lambda$getDeleteTargetFiles$1(file, str);
            default:
                return ComposerCacheFileUtil.lambda$trimPageThumbnail$4((Pattern) this.f9508b, file, str);
        }
    }
}
