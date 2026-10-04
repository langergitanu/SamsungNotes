package com.airbnb.lottie.network;

import androidx.annotation.RestrictTo;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public enum FileExtension {
    JSON(".json"),
    ZIP(Constants.ZIP_EXTENSION_WITH_DOT),
    GZIP(".gz");

    public final String extension;

    FileExtension(String str) {
        this.extension = str;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
