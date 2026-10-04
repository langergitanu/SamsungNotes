package com.samsung.android.support.senl.p148nt.app.settings.detail;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.detail.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8780d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6299a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SettingsImportPrefFragment f6300b;

    public /* synthetic */ RunnableC8780d(SettingsImportPrefFragment settingsImportPrefFragment, int i) {
        this.f6299a = i;
        this.f6300b = settingsImportPrefFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6299a) {
            case 0:
                this.f6300b.importSNoteFromGoogleDrive();
                break;
            case 1:
                SettingsImportPrefFragment.mOnPreferenceClickListener$lambda$15$lambda$10(this.f6300b);
                break;
            case 2:
                SettingsImportPrefFragment.mOnPreferenceClickListener$lambda$15$lambda$11(this.f6300b);
                break;
            case 3:
                this.f6300b.importMemoFromSamsungAccount();
                break;
            case 4:
                SettingsImportPrefFragment.mOnPreferenceClickListener$lambda$15$lambda$13(this.f6300b);
                break;
            case 5:
                this.f6300b.importSNoteFromSamsungAccount();
                break;
            case 6:
                this.f6300b.importSNoteFromGoogleDrive();
                break;
            case 7:
                this.f6300b.importMemoFromSamsungAccount();
                break;
            case 8:
                this.f6300b.importScrapbookFromSamsungAccount();
                break;
            case 9:
                SettingsImportPrefFragment.mOnPreferenceClickListener$lambda$15$lambda$4(this.f6300b);
                break;
            case 10:
                this.f6300b.importScrapbookFromSamsungAccount();
                break;
            case 11:
                SettingsImportPrefFragment.mOnPreferenceClickListener$lambda$15$lambda$6(this.f6300b);
                break;
            case 12:
                this.f6300b.importSNoteFromSamsungAccount();
                break;
            default:
                SettingsImportPrefFragment.mOnPreferenceClickListener$lambda$15$lambda$8(this.f6300b);
                break;
        }
    }
}
