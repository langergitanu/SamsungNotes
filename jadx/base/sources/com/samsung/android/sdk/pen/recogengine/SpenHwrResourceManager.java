package com.samsung.android.sdk.pen.recogengine;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.carousel.RunnableC4617a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.handwriting.resources.HwrLanguageManager;
import com.samsung.android.sdk.handwriting.resources.HwrLanguagePack;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p079T.C0287e;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenHwrResourceManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mLangManager", "Lcom/samsung/android/sdk/handwriting/resources/HwrLanguageManager;", "mDownloadQ", "Ljava/util/Queue;", "", "updateAllHwrResources", "", "updateHwrResource", "language", "updateLanguageList", "updateOnlyList", "", "downloadLanguage", "targetLanguage", "downloadUpdatableLanguages", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHwrResourceManager {

    @NotNull
    private static final String TAG = "SpenHwrResourceManager";

    @NotNull
    private final Queue<String> mDownloadQ = new LinkedList();

    @NotNull
    private final HwrLanguageManager mLangManager;

    public SpenHwrResourceManager(@Nullable Context context) {
        this.mLangManager = new HwrLanguageManager(context);
    }

    private final void downloadLanguage(String targetLanguage) {
        boolean zIsUpdateAvailable;
        String[] availableLanguage = this.mLangManager.getAvailableLanguage();
        if (availableLanguage == null || availableLanguage.length == 0) {
            Log.e(TAG, "downloadLanguage : wrong available language list!");
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(availableLanguage);
        while (true) {
            if (!it.hasNext()) {
                zIsUpdateAvailable = false;
                break;
            }
            String str = (String) it.next();
            if (Intrinsics.areEqual(str, targetLanguage)) {
                zIsUpdateAvailable = this.mLangManager.get(str).isUpdateAvailable();
                break;
            }
        }
        Log.i(TAG, "downloadLanguage : [" + targetLanguage + "] is updatable? = " + zIsUpdateAvailable);
        if (zIsUpdateAvailable) {
            new Thread(new RunnableC4199v(targetLanguage, this, 9)).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadLanguage$lambda$2(final String str, final SpenHwrResourceManager spenHwrResourceManager) {
        AbstractC6670b.m4756q("downloadLanguage : start to download! : ", str, TAG);
        spenHwrResourceManager.mLangManager.get(str).downloadLanguage(new HwrLanguagePack.OnDownloadListener() { // from class: com.samsung.android.sdk.pen.recogengine.SpenHwrResourceManager$downloadLanguage$1$1
            @Override // com.samsung.android.sdk.handwriting.resources.HwrLanguagePack.OnDownloadListener
            public void onComplete(int result) {
                Log.i("SpenHwrResourceManager", "downloadLanguage : download completed! language = " + str + ", result = " + result);
                spenHwrResourceManager.updateLanguageList(true);
            }

            @Override // com.samsung.android.sdk.handwriting.resources.HwrLanguagePack.OnDownloadListener
            public void onProgress(int progress, int max) {
                AbstractC6670b.m4744e(progress, max, "downloadLanguage : progress = ", " / ", "SpenHwrResourceManager");
            }
        });
    }

    private final void downloadUpdatableLanguages() {
        String[] availableLanguage = this.mLangManager.getAvailableLanguage();
        if (availableLanguage == null || availableLanguage.length == 0) {
            Log.e(TAG, "downloadUpdatableLanguages : wrong available language list!");
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(availableLanguage);
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.mLangManager.get(str).isUpdateAvailable()) {
                this.mDownloadQ.add(str);
            }
        }
        Log.i(TAG, "downloadUpdatableLanguages : updatable languages : " + this.mDownloadQ);
        new Thread(new RunnableC4617a(this, 15)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadUpdatableLanguages$lambda$3(SpenHwrResourceManager spenHwrResourceManager) {
        Log.i(TAG, "downloadUpdatableLanguages : start to download!");
        while (spenHwrResourceManager.mDownloadQ.size() > 0) {
            final boolean[] zArr = {false};
            final String strRemove = spenHwrResourceManager.mDownloadQ.remove();
            AbstractC6670b.m4756q("downloadUpdatableLanguages : download start! language = ", strRemove, TAG);
            spenHwrResourceManager.mLangManager.get(strRemove).downloadLanguage(new HwrLanguagePack.OnDownloadListener() { // from class: com.samsung.android.sdk.pen.recogengine.SpenHwrResourceManager$downloadUpdatableLanguages$1$1
                @Override // com.samsung.android.sdk.handwriting.resources.HwrLanguagePack.OnDownloadListener
                public void onComplete(int result) {
                    Log.i("SpenHwrResourceManager", "downloadUpdatableLanguages : download completed! language = " + strRemove + ", result = " + result);
                    zArr[0] = true;
                }

                @Override // com.samsung.android.sdk.handwriting.resources.HwrLanguagePack.OnDownloadListener
                public void onProgress(int progress, int max) {
                    AbstractC6670b.m4744e(progress, max, "downloadUpdatableLanguages : progress = ", " / ", "SpenHwrResourceManager");
                }
            });
            while (!zArr[0]) {
                try {
                    Intrinsics.checkNotNull(spenHwrResourceManager, "null cannot be cast to non-null type java.lang.Object");
                    spenHwrResourceManager.wait(300L);
                } catch (InterruptedException e) {
                    AbstractC2322a.m1636z("downloadUpdatableLanguages : wait is interrupted! ", e.getMessage(), TAG);
                    spenHwrResourceManager.updateLanguageList(true);
                    return;
                }
            }
        }
        spenHwrResourceManager.updateLanguageList(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateHwrResource$lambda$0(SpenHwrResourceManager spenHwrResourceManager, String str, int i) {
        AbstractC2322a.m1631u(i, "updateHwrResource : update result = ", TAG);
        spenHwrResourceManager.downloadLanguage(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLanguageList(boolean updateOnlyList) {
        AbstractC4539a.m3208r("updateLanguageList : updateOnlyList = ", TAG, updateOnlyList);
        this.mLangManager.update(new C7467a(this, updateOnlyList), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateLanguageList$lambda$1(boolean z, SpenHwrResourceManager spenHwrResourceManager, int i) {
        AbstractC2322a.m1631u(i, "updateLanguageList : update result = ", TAG);
        if (z) {
            return;
        }
        spenHwrResourceManager.downloadUpdatableLanguages();
    }

    public final void updateAllHwrResources() {
        Log.i(TAG, "updateAllHwrResources");
        updateLanguageList(false);
    }

    public final void updateHwrResource(@NotNull String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        Log.i(TAG, "updateHwrResource : language = " + language);
        this.mLangManager.update(new C0287e(this, language, 8), true);
    }
}
