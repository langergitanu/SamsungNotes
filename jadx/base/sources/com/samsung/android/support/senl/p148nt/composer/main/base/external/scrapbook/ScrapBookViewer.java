package com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.CustomWebView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ScrapBookViewer extends AppCompatActivity {
    public static final String ARG_PATH = "path";
    public static final String ARG_URL = "url";
    private static final String DIR = "scrapbook";
    private static final String TAG = Logger.createTag("ScrapBookViewer");
    private static final String URL_FILE = "url";
    private CustomWebView mWebView;

    private static String getExtractedDir(String str) {
        File file = new File(str, DIR);
        if (!file.exists() && !file.mkdir()) {
            return "";
        }
        return file.getAbsolutePath() + File.separator;
    }

    private static String getFolderName(File file, String str) {
        File[] fileArrListFiles;
        int i;
        File[] fileArrListFiles2 = file.listFiles();
        if (fileArrListFiles2 == null) {
            return String.valueOf(0);
        }
        int i2 = 0;
        while (i2 < fileArrListFiles2.length) {
            File file2 = fileArrListFiles2[i2];
            if (file2.exists() && (fileArrListFiles = file2.listFiles()) != null) {
                for (File file3 : fileArrListFiles) {
                    i = (file3.getName().equals("url") && str.equals(loadUrlFromCacheFile(file3))) ? 0 : i + 1;
                }
            }
            i2++;
        }
        return String.valueOf(i2);
    }

    public static Intent getIntentForScrapbook(Context context, String str, String str2, String str3) throws Throwable {
        if (str2 == null) {
            Logger.m10999d(TAG, "getIntentForScrapbook# url is null");
            str2 = "";
        }
        Intent intent = new Intent(context, (Class<?>) ScrapBookViewer.class);
        intent.putExtra("url", str2);
        File file = new File(getExtractedDir(str3));
        File file2 = new File(file, getFolderName(file, str2));
        if (!file2.exists() && !file2.mkdir()) {
            Logger.m10999d(TAG, "getIntentForScrapbook# mkdir fail");
            return intent;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(file2.getPath());
        String str4 = File.separator;
        File file3 = new File(AbstractC0622a.m1170p(str4, Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_DONE, sb));
        String strExtract = file2.getPath() + str4 + MhtmlExtractor.EXTRACTED_HTML_FILE_MAIN;
        if (!file3.exists()) {
            strExtract = new MhtmlExtractor(context, str).extract(str2, file2.getAbsolutePath());
            saveUrlToCacheFile(file2, str2);
            try {
                file3.createNewFile();
            } catch (IOException e) {
                Logger.m11000e(TAG, e.getMessage());
            }
        }
        intent.putExtra("path", strExtract);
        return intent;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:0|2|(8:48|3|51|4|49|5|57|6)|46|7|39|(2:(0)|(1:60))) */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger.m11000e(com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.ScrapBookViewer.TAG, r4.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0016 A[EXC_TOP_SPLITTER, PHI: r1 r4
      0x0016: PHI (r1v7 java.lang.String) = (r1v5 java.lang.String), (r1v14 java.lang.String) binds: [B:37:0x0055, B:6:0x0013] A[DONT_GENERATE, DONT_INLINE]
      0x0016: PHI (r4v8 java.io.ObjectInputStream) = (r4v7 java.io.ObjectInputStream), (r4v14 java.io.ObjectInputStream) binds: [B:37:0x0055, B:6:0x0013] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String loadUrlFromCacheFile(File file) throws Throwable {
        Object e;
        ObjectInputStream objectInputStream;
        String str;
        Throwable th;
        ?? r12 = 0;
        try {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        str = (String) objectInputStream.readObject();
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            Logger.m11000e(TAG, e.toString());
                            if (objectInputStream != null) {
                            }
                            return str;
                        } catch (ClassNotFoundException e3) {
                            e = e3;
                            Logger.m11000e(TAG, e.toString());
                            if (objectInputStream != null) {
                            }
                            return str;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            try {
                                th.addSuppressed(th3);
                            } catch (IOException | ClassNotFoundException e5) {
                                str = "";
                                e = e5;
                                Logger.m11000e(TAG, e.toString());
                                if (objectInputStream != null) {
                                    objectInputStream.close();
                                }
                                return str;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    objectInputStream = null;
                }
            } catch (Throwable th5) {
                th = th5;
                r12 = file;
                if (r12 != 0) {
                    try {
                        r12.close();
                    } catch (IOException e6) {
                        Logger.m11000e(TAG, e6.getMessage());
                    }
                }
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            e = e;
            objectInputStream = null;
            str = "";
            Logger.m11000e(TAG, e.toString());
            if (objectInputStream != null) {
            }
            return str;
        } catch (ClassNotFoundException e8) {
            e = e8;
            e = e;
            objectInputStream = null;
            str = "";
            Logger.m11000e(TAG, e.toString());
            if (objectInputStream != null) {
            }
            return str;
        } catch (Throwable th6) {
            th = th6;
            if (r12 != 0) {
            }
            throw th;
        }
        objectInputStream.close();
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0076 A[Catch: IOException -> 0x0047, TRY_ENTER, TRY_LEAVE, TryCatch #0 {IOException -> 0x0047, blocks: (B:15:0x0043, B:38:0x0076), top: B:46:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.ObjectOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void saveUrlToCacheFile(File file, String str) throws Throwable {
        IOException e;
        Throwable th;
        StringBuilder sb = new StringBuilder();
        sb.append(file.getAbsolutePath());
        ?? file2 = new File(AbstractC0622a.m1170p(File.separator, "url", sb));
        if (!file2.exists()) {
            try {
                if (!file2.createNewFile()) {
                    return;
                }
            } catch (IOException e2) {
                Logger.m11001e(TAG, e2.getMessage(), e2);
                return;
            }
        }
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream((File) file2);
                    try {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                        try {
                            objectOutputStream.writeObject(str);
                            fileOutputStream.close();
                            objectOutputStream.close();
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th4) {
                                th.addSuppressed(th4);
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (IOException e3) {
                    Logger.m11001e(TAG, e3.getMessage(), e3);
                }
            } catch (IOException e5) {
                e = e5;
                Logger.m11000e(TAG, e.toString());
                if (file2 == 0) {
                    file2.close();
                }
            }
        } catch (IOException e6) {
            file2 = 0;
            e = e6;
            Logger.m11000e(TAG, e.toString());
            if (file2 == 0) {
            }
        } catch (Throwable th6) {
            file2 = 0;
            th = th6;
            if (file2 != 0) {
                try {
                    file2.close();
                } catch (IOException e7) {
                    Logger.m11001e(TAG, e7.getMessage(), e7);
                }
            }
            throw th;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C9086R.layout.activity_scrapbook_viewer);
        String stringExtra = getIntent().getStringExtra("path");
        final String stringExtra2 = getIntent().getStringExtra("url");
        setSupportActionBar((Toolbar) findViewById(C9086R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(stringExtra2);
        CustomWebView customWebView = (CustomWebView) findViewById(C9086R.id.webview);
        this.mWebView = customWebView;
        customWebView.setOnSingleTapUpListener(new CustomWebView.OnSingleTapUpListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.scrapbook.ScrapBookViewer.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.external.scrapbook.CustomWebView.OnSingleTapUpListener
            public void onSingleTapUp() {
                if (TextUtils.isEmpty(stringExtra2)) {
                    Logger.m11000e(ScrapBookViewer.TAG, "onSingleTapUp# url is empty");
                    return;
                }
                if (stringExtra2.startsWith("file://")) {
                    Logger.m11000e(ScrapBookViewer.TAG, "onSingleTapUp# url is FileUri " + Logger.getEncode(stringExtra2));
                    return;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(stringExtra2));
                intent.addFlags(268435456);
                ScrapBookViewer.this.startActivity(intent);
            }
        });
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.scrapbook.ScrapBookViewer.2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return true;
            }
        });
        this.mWebView.getSettings().setAllowFileAccess(true);
        this.mWebView.loadUrl("file://" + stringExtra);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CustomWebView customWebView = this.mWebView;
        if (customWebView != null) {
            try {
                ((ViewGroup) customWebView.getParent()).removeView(this.mWebView);
                this.mWebView.destroy();
            } catch (Exception e) {
                Logger.m11001e(TAG, e.getMessage(), e);
            }
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        try {
            onBackPressed();
            return true;
        } catch (IllegalStateException e) {
            Logger.m11000e(TAG, e.getMessage());
            return true;
        }
    }
}
