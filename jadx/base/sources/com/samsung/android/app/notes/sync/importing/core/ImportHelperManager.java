package com.samsung.android.app.notes.sync.importing.core;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.types.BasicImportHelperAdapter;
import com.samsung.android.app.notes.sync.importing.core.types.BasicSmartSwitchImportHelperAdapter;
import com.samsung.android.app.notes.sync.importing.core.types.MemoCloudImportType;
import com.samsung.android.app.notes.sync.importing.core.types.MemoLocalImportType;
import com.samsung.android.app.notes.sync.importing.core.types.ScrapbookCloudImportType;
import com.samsung.android.app.notes.sync.importing.core.types.ServerNoteLocalImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SmartSwitchLMemoImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SmartSwitchNMemoImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SmartSwitchQMemoImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SmartSwitchSDocImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SmartSwitchSnbSpdImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SmartSwitchTMemo1ImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SnoteGoogleDriveImportHelperAdapter;
import com.samsung.android.app.notes.sync.importing.core.types.SnoteGoogleDriveImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SnoteLocalImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SnoteNetworkImportType;
import java.util.concurrent.Executor;
import p252w0.C14504b;
import p252w0.C14505c;
import p252w0.C14506d;
import p252w0.C14507e;
import p252w0.C14508f;
import p252w0.C14509g;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ImportHelperManager {
    private static final String TAG = "ImportHelperManager";
    private static ImportHelperManager mInstance;
    private final Executor mImportExecutor = AbstractC4539a.m3201k(TAG);
    private MemoCloudImportHelper mMemoCloudImportHelper = null;
    private MemoLocalImportHelper mMemoLocalImportHelper = null;
    private SnoteCloudImportHelper mSnoteCloudImportHelper = null;
    private SnoteLocalImportHelper mSnoteLocalImportHelper = null;
    private ServerNoteLocalImportHelper mServerNoteLocalImportHelper = null;
    private SnoteGoogleImportHelper mSnoteGoogleImportHelper = null;
    private ScrapbookCloudImportHelper mScrapbookCloudImportHelper = null;
    private C14507e mSSSDocImportHelper = null;
    private C14505c mSSNMemoImportHelper = null;
    private C14504b mSSLMemoImportHelper = null;
    private C14506d mSSQMemoImportHelper = null;
    private C14509g mSSTMemoImportHelper = null;
    private C14508f mSSSNoteImportHelper = null;

    private ImportHelperManager() {
    }

    public static synchronized ImportHelperManager getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new ImportHelperManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    public Executor getImportExecutor() {
        return this.mImportExecutor;
    }

    public synchronized void initImportHelper(@NonNull Context context, @NonNull HelperRegistry helperRegistry) {
        try {
            if (this.mSSSDocImportHelper == null) {
                C14507e c14507e = new C14507e(context, DocTypeConstants.SS_SDOC, false);
                c14507e.f10338a = false;
                c14507e.setAccountListener(c14507e);
                this.mSSSDocImportHelper = c14507e;
            }
            helperRegistry.putHelper(SmartSwitchSDocImportType.class, new BasicSmartSwitchImportHelperAdapter(this.mSSSDocImportHelper));
            if (this.mSSNMemoImportHelper == null) {
                C14505c c14505c = new C14505c(context, DocTypeConstants.MEMO_LOCAL, false);
                c14505c.f10336a = false;
                c14505c.setAccountListener(c14505c);
                this.mSSNMemoImportHelper = c14505c;
            }
            helperRegistry.putHelper(SmartSwitchNMemoImportType.class, new BasicSmartSwitchImportHelperAdapter(this.mSSNMemoImportHelper));
            if (this.mSSLMemoImportHelper == null) {
                C14504b c14504b = new C14504b(context, DocTypeConstants.SS_LMEMO, false);
                c14504b.f10335a = false;
                c14504b.setAccountListener(c14504b);
                this.mSSLMemoImportHelper = c14504b;
            }
            helperRegistry.putHelper(SmartSwitchLMemoImportType.class, new BasicSmartSwitchImportHelperAdapter(this.mSSLMemoImportHelper));
            if (this.mSSQMemoImportHelper == null) {
                C14506d c14506d = new C14506d(context, DocTypeConstants.SS_QMEMO, false);
                c14506d.f10337a = false;
                c14506d.setAccountListener(c14506d);
                this.mSSQMemoImportHelper = c14506d;
            }
            helperRegistry.putHelper(SmartSwitchQMemoImportType.class, new BasicSmartSwitchImportHelperAdapter(this.mSSQMemoImportHelper));
            if (this.mSSTMemoImportHelper == null) {
                C14509g c14509g = new C14509g(context, DocTypeConstants.SS_TMEMO, false);
                c14509g.f10340a = false;
                c14509g.setAccountListener(c14509g);
                this.mSSTMemoImportHelper = c14509g;
            }
            helperRegistry.putHelper(SmartSwitchTMemo1ImportType.class, new BasicSmartSwitchImportHelperAdapter(this.mSSTMemoImportHelper));
            if (this.mSSSNoteImportHelper == null) {
                C14508f c14508f = new C14508f(context, DocTypeConstants.MEMO_LOCAL, false);
                c14508f.f10339a = false;
                c14508f.setAccountListener(c14508f);
                this.mSSSNoteImportHelper = c14508f;
            }
            helperRegistry.putHelper(SmartSwitchSnbSpdImportType.class, new BasicSmartSwitchImportHelperAdapter(this.mSSSNoteImportHelper));
            if (this.mMemoCloudImportHelper == null) {
                this.mMemoCloudImportHelper = new MemoCloudImportHelper(context);
            }
            helperRegistry.putHelper(MemoCloudImportType.class, new BasicImportHelperAdapter(this.mMemoCloudImportHelper));
            if (this.mMemoLocalImportHelper == null) {
                this.mMemoLocalImportHelper = new MemoLocalImportHelper(context);
            }
            helperRegistry.putHelper(MemoLocalImportType.class, new BasicImportHelperAdapter(this.mMemoLocalImportHelper));
            if (this.mSnoteCloudImportHelper == null) {
                this.mSnoteCloudImportHelper = new SnoteCloudImportHelper(context);
            }
            helperRegistry.putHelper(SnoteNetworkImportType.class, new BasicImportHelperAdapter(this.mSnoteCloudImportHelper));
            if (this.mSnoteLocalImportHelper == null) {
                this.mSnoteLocalImportHelper = new SnoteLocalImportHelper(context);
            }
            helperRegistry.putHelper(SnoteLocalImportType.class, new BasicImportHelperAdapter(this.mSnoteLocalImportHelper));
            if (this.mServerNoteLocalImportHelper == null) {
                this.mServerNoteLocalImportHelper = new ServerNoteLocalImportHelper(context);
            }
            helperRegistry.putHelper(ServerNoteLocalImportType.class, new BasicImportHelperAdapter(this.mServerNoteLocalImportHelper));
            if (this.mScrapbookCloudImportHelper == null) {
                this.mScrapbookCloudImportHelper = new ScrapbookCloudImportHelper(context);
            }
            helperRegistry.putHelper(ScrapbookCloudImportType.class, new BasicImportHelperAdapter(this.mScrapbookCloudImportHelper));
            if (this.mSnoteGoogleImportHelper == null) {
                this.mSnoteGoogleImportHelper = new SnoteGoogleImportHelper(context);
            }
            helperRegistry.putHelper(SnoteGoogleDriveImportType.class, new SnoteGoogleDriveImportHelperAdapter(this.mSnoteGoogleImportHelper));
        } catch (Throwable th) {
            throw th;
        }
    }
}
