package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share;

import android.content.Context;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocConverterHelper {
    private static Creator mCreator;
    private static DocConverterHelper mInstance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Creator {
        DocConverterHelper create();
    }

    public static synchronized DocConverterHelper getInstance() {
        try {
            Creator creator = mCreator;
            if (creator != null) {
                mInstance = creator.create();
                mCreator = null;
            }
            if (mInstance == null) {
                mInstance = new DocConverterHelper();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    public static void setCreator(Creator creator) {
        mCreator = creator;
    }

    public boolean isActivated() {
        return false;
    }

    public String wdocToPPT(Context context, SpenWNote spenWNote, String str, String str2, String str3) {
        return "";
    }

    public String wdocToWord(Context context, SpenWNote spenWNote, String str, String str2, String str3) {
        return "";
    }
}
