package com.samsung.android.support.senl.p148nt.composer.main.base.widget.share;

import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakePdf;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface ShareMenuContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Presenter {
        boolean canShowWordExportOption();

        void executeSaveDirectoryPicker();

        void executeShareNote();

        List<ShareType> getShareMenuList();

        boolean isSingleMode();

        void setPdfShareType(TaskMakePdf.PdfShareType pdfShareType);

        void setShareType(ShareType shareType);

        void stopRecordAndAudio();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ShareType {
        SDOC(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C9086R.string.composer_share_sdoc_jp : C9086R.string.composer_share_sdoc),
        PDF(C9086R.string.composer_share_pdf),
        DOC(C9086R.string.composer_share_doc),
        PPTX(C9086R.string.composer_share_pptx),
        IMAGE(C9086R.string.composer_share_image),
        TEXT(C9086R.string.composer_share_text_only);

        public int resId;

        ShareType(int i) {
            this.resId = i;
        }
    }
}
