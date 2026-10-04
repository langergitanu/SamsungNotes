package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ShareFileProvider;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShareHtmlFile {
    private static final String HTML_FILE_NAME = "sharedHtmlFile";
    private static final String TAG = Logger.createTag("ShareHtmlFile");

    public static File createHtmlFile(Context context, CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String str = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\"/></head><body>" + charSequence.toString().replace("\n", "<br>") + "</body></html>";
        File destHtmlFile = getDestHtmlFile(context);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(destHtmlFile);
            try {
                fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
                fileOutputStream.close();
                return destHtmlFile;
            } finally {
            }
        } catch (IOException e) {
            Logger.m11001e(TAG, "createHtml", e);
            return null;
        }
    }

    private static File getDestHtmlFile(Context context) {
        File file = new File(ShareFileProvider.getShareDir(context), "sharedHtmlFile.html");
        if (file.exists() && !file.delete()) {
            Logger.m11000e(TAG, "delete fail");
        }
        return file;
    }
}
