package com.samsung.android.support.senl.p148nt.model.document;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.SpenDocumentInitializer;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.C11397R;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentStyleRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentBackgroundUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DocumentInitializer {
    public static final int DEFAULT_PAGE_COUNT = 2;
    private static final String TAG = ModelLogger.createTag("DocumentInitializer");
    private final Context mAppContext;
    private int mPageTemplateType = 0;
    private String mPageTemplatePath = null;

    public DocumentInitializer(@NonNull Context context) {
        this.mAppContext = context;
    }

    private void appendNewPages(@NonNull SpenWNote spenWNote) {
        int i;
        String str;
        int pageDefaultWidth = spenWNote.getPageDefaultWidth();
        int pageDefaultHeight = spenWNote.getPageDefaultHeight();
        int defaultBackgroundColor = DocumentBackgroundUtils.getDefaultBackgroundColor(getDefaultBgColor());
        try {
            int i2 = this.mPageTemplateType;
            if (i2 == 16) {
                str = null;
                i = 0;
            } else {
                i = i2;
                str = this.mPageTemplatePath;
            }
            String str2 = str;
            if (spenWNote.getPageMode() == SpenWNote.PageMode.SINGLE) {
                setPageBackground(spenWNote.appendPage(pageDefaultWidth, pageDefaultHeight * 2), i, str, str2, defaultBackgroundColor, 3);
            } else {
                for (int i4 = 0; i4 < 2; i4++) {
                    setPageBackground(spenWNote.appendPage(pageDefaultWidth, pageDefaultHeight), i, str, str2, defaultBackgroundColor, 2);
                }
            }
        } catch (Exception e) {
            DataLogger.m12303e(TAG, "appendNewPages, e: " + e.getMessage());
        } catch (Throwable th) {
            throw th;
        }
        DataLogger.m12302d(TAG, "appendNewPages: " + spenWNote.getPageCount());
    }

    private int getDefaultBgColor() {
        return this.mAppContext.getResources().getColor(C11397R.color.background_color_white, null);
    }

    private void loadPageTemplate() {
        Pair<Integer, String> defaultTemplate = new DocumentStyleRepository().getDefaultTemplate();
        this.mPageTemplateType = defaultTemplate.first.intValue();
        this.mPageTemplatePath = defaultTemplate.second;
    }

    private void setInvertBackgroundColor(@NonNull SpenWNote spenWNote) {
        if (this.mPageTemplateType == 12) {
            spenWNote.invertBackgroundColor(false);
        } else {
            spenWNote.invertBackgroundColor(DocumentBackgroundUtils.getDefaultInvertBackground());
        }
    }

    private void setPageBackground(@NonNull SpenWPage spenWPage, int i, @Nullable String str, @Nullable String str2, int i2, int i4) {
        spenWPage.setTemplateType(i);
        spenWPage.setBackgroundImage(str, true);
        spenWPage.setTemplateURI(str2);
        spenWPage.setBackgroundColor(i2);
        spenWPage.setBackgroundImageMode(i4);
    }

    private void setPageVerticalPadding(@NonNull SpenWNote spenWNote) {
        new SpenDocumentInitializer().setPageVerticalPadding(spenWNote);
    }

    @WorkerThread
    public void initNewNote(@NonNull SpenWNote spenWNote) {
        loadPageTemplate();
        setPageDefaultHeight(spenWNote);
        setPageVerticalPadding(spenWNote);
        appendNewPages(spenWNote);
        setInvertBackgroundColor(spenWNote);
    }

    public void setPageDefaultHeight(@NonNull SpenWNote spenWNote) {
        int height = (spenWNote.getPageMode() == SpenWNote.PageMode.LIST ? DocumentPageRatio.getPageRatioTypeFromSettings() : DocumentPageRatio.PAGE_RATIO).getHeight(spenWNote.getPageDefaultWidth());
        spenWNote.setPageDefaultHeight(height);
        DataLogger.m12302d(TAG, "setPageDefaultHeight: " + height);
    }
}
