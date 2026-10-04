package com.samsung.android.support.senl.p148nt.data.repository.pdfwriter;

import androidx.annotation.NonNull;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PDFWriterRepository {
    private final PDFWriterDataSource mDataSource;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PDFWriterDataSource {
        void delete(@NonNull String str);

        String getFilePath(@NonNull String str);

        String getUuid(@NonNull String str);

        void insert(@NonNull String str, @NonNull String str2);

        void trimDummy(Set<String> set);
    }

    public PDFWriterRepository(PDFWriterDataSource pDFWriterDataSource) {
        this.mDataSource = pDFWriterDataSource;
    }

    public void delete(@NonNull String str) {
        this.mDataSource.delete(str);
    }

    public String getFilePath(@NonNull String str) {
        return this.mDataSource.getFilePath(str);
    }

    public String getUuid(@NonNull String str) {
        return this.mDataSource.getUuid(str);
    }

    public void insert(@NonNull String str, @NonNull String str2) {
        this.mDataSource.insert(str, str2);
    }

    public void trimDummy(Set<String> set) {
        this.mDataSource.trimDummy(set);
    }
}
