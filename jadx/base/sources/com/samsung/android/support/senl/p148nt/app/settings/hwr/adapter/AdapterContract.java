package com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u000f\u001a\u00020\fH&¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/hwr/adapter/AdapterContract;", "", "isPreloaded", "", "locale", "", "isUpdateAvailable", "isDownloaded", "isInstallable", "isDownloadInQueue", "isDownloadInProgress", "onDownload", "", "onDownloadCancel", "onDelete", "loadLanguageData", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface AdapterContract {
    boolean isDownloadInProgress(@Nullable String locale);

    boolean isDownloadInQueue(@Nullable String locale);

    boolean isDownloaded(@Nullable String locale);

    boolean isInstallable(@Nullable String locale);

    boolean isPreloaded(@Nullable String locale);

    boolean isUpdateAvailable(@Nullable String locale);

    void loadLanguageData();

    void onDelete(@Nullable String locale);

    void onDownload(@Nullable String locale);

    void onDownloadCancel(@Nullable String locale);
}
