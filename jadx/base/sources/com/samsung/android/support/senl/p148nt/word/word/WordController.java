package com.samsung.android.support.senl.p148nt.word.word;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.common.OfficeController;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.data.WNoteData;
import com.samsung.android.support.senl.p148nt.word.word.data.WordParams;
import kotlin.Metadata;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00152\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J@\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u000fH\u0014J\n\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0014¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/WordController;", "Lcom/samsung/android/support/senl/nt/word/common/OfficeController;", "Lorg/apache/poi/xwpf/usermodel/XWPFDocument;", "Lorg/apache/poi/xwpf/usermodel/XWPFParagraph;", "<init>", "()V", "createOfficeDocument", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "context", "Landroid/content/Context;", "officeParams", "Lcom/samsung/android/support/senl/nt/word/data/OfficeParams;", "wNoteData", "Lcom/samsung/android/support/senl/nt/word/data/WNoteData;", "sdocPath", "", "createOfficeParams", "isLongPage", "", "getMimeType", "getTag", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WordController extends OfficeController<XWPFDocument, XWPFParagraph> {
    private static final String TAG = Logger.createTag("WordController");

    @Override // com.samsung.android.support.senl.p148nt.word.common.OfficeController
    @NotNull
    public OfficeView<XWPFDocument, XWPFParagraph> createOfficeDocument(@Nullable Context context, @Nullable OfficeParams officeParams, @Nullable WNoteData wNoteData, @Nullable String sdocPath) {
        return new WordView(context, officeParams, wNoteData, sdocPath);
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.OfficeController
    @NotNull
    public OfficeParams createOfficeParams(boolean isLongPage) {
        return new WordParams(isLongPage);
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.OfficeController
    @NotNull
    public String getMimeType() {
        return Constants.MIME_DOCX;
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.OfficeController
    @Nullable
    public String getTag() {
        return TAG;
    }
}
