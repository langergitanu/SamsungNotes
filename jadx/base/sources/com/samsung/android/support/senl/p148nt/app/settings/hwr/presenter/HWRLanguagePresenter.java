package com.samsung.android.support.senl.p148nt.app.settings.hwr.presenter;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.util.CollectionUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.AdapterContract;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.HWRLanguageAdapter;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder.HWRLanguageHolderInfo;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.common.Constants;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.listener.DeleteListener;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.listener.DownloadListener;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.listener.ListenerCallback;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Event;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.EventBus;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.EventManager;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.LanguageDownloadCompleteEvent;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.LanguageDownloadProgressEvent;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p044K.C0158a;
import p095X2.SharedPreferencesOnSharedPreferenceChangeListenerC0340a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\u001c\u0018\u0000 H2\u00020\u0001:\u0001HB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020!H\u0002J\u0006\u0010#\u001a\u00020!J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020!H\u0002J\u0018\u0010'\u001a\u00020!2\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0)H\u0002J\b\u0010+\u001a\u00020!H\u0002J\b\u0010,\u001a\u00020!H\u0002J\b\u0010-\u001a\u00020!H\u0003J\u0006\u0010.\u001a\u00020!J\u000e\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\rJ\u000e\u00103\u001a\u00020!2\u0006\u00104\u001a\u000205J\u0010\u00106\u001a\u00020!2\b\u00107\u001a\u0004\u0018\u000105J\u0012\u00108\u001a\u00020\u001f2\b\u00109\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010:\u001a\u00020\u001f2\b\u00109\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010;\u001a\u00020\u001f2\b\u00109\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010<\u001a\u00020\u001f2\b\u00109\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010=\u001a\u00020\u001f2\b\u00109\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010>\u001a\u00020\u001f2\b\u00109\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010?\u001a\u00020!2\b\u00109\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010@\u001a\u00020!2\b\u00109\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010A\u001a\u00020!2\b\u00109\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010B\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\rH\u0002J\u0010\u0010C\u001a\u00020\u00102\u0006\u00109\u001a\u00020\rH\u0002J\u000e\u0010D\u001a\u00020!2\u0006\u0010E\u001a\u00020\rJ\b\u0010F\u001a\u00020!H\u0002J\b\u0010G\u001a\u00020!H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001a8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u0006I"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/hwr/presenter/HWRLanguagePresenter;", "Lcom/samsung/android/support/senl/nt/app/settings/hwr/adapter/AdapterContract;", "presenterContract", "Lcom/samsung/android/support/senl/nt/app/settings/hwr/presenter/PresenterContract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/hwr/presenter/PresenterContract;)V", "hwrLanguageAdapter", "Lcom/samsung/android/support/senl/nt/app/settings/hwr/adapter/HWRLanguageAdapter;", "getHwrLanguageAdapter", "()Lcom/samsung/android/support/senl/nt/app/settings/hwr/adapter/HWRLanguageAdapter;", "mPresenterContract", "mDownloadListenerMap", "", "", "Lcom/samsung/android/support/senl/nt/app/settings/hwr/listener/DownloadListener;", "mDeleteListenerMap", "Lcom/samsung/android/support/senl/nt/app/settings/hwr/listener/DeleteListener;", "mDownloadInQueue", "", "mLanguageDownloadHelper", "Lcom/samsung/android/support/senl/nt/model/collector/recognition/extractor/TextRecognitionLanguageDownloadHelper;", "mCaller", "mListenableDownloadProgress", "Lcom/samsung/android/support/senl/nt/model/collector/recognition/extractor/Listenable;", "mListenableDownloadComplete", "mHWRLanguageChangeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "mHWRLanguageListChangeListener", "com/samsung/android/support/senl/nt/app/settings/hwr/presenter/HWRLanguagePresenter$mHWRLanguageListChangeListener$1", "Lcom/samsung/android/support/senl/nt/app/settings/hwr/presenter/HWRLanguagePresenter$mHWRLanguageListChangeListener$1;", "mHasTranslationFilter", "", "initialize", "", "initLanguageDownloadHelper", "onResume", "loadLanguageData", "addSwitchInfo", "addDescriptionInfo", "addLanguageInfo", "languageInfo", "", "Lcom/samsung/android/support/senl/nt/model/collector/recognition/extractor/TextRecognitionLanguageDownloadHelper$LanguageInfo;", "addHeaderInfo", "addFooterInfo", "notifyLoadFinished", "onDestroy", "setCaller", NotesConstants.KEY_CALLER, "isCallFromComposer", "()Z", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "Landroid/os/Bundle;", "onRestoreInstanceState", "savedInstanceState", "isPreloaded", "locale", "isUpdateAvailable", "isDownloaded", "isInstallable", "isDownloadInQueue", "isDownloadInProgress", "onDownload", "onDownloadCancel", "onDelete", "getDownloadListener", "getDeleteListener", "setLanguageListFilter", "filterType", "registerListener", "unregisterListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHWRLanguagePresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HWRLanguagePresenter.kt\ncom/samsung/android/support/senl/nt/app/settings/hwr/presenter/HWRLanguagePresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,539:1\n1#2:540\n*E\n"})
public final class HWRLanguagePresenter implements AdapterContract {

    @NotNull
    private static final String TAG = "HWRLanguagePresenter";

    @NotNull
    private final HWRLanguageAdapter hwrLanguageAdapter;

    @NotNull
    private String mCaller;

    @NotNull
    private final Map<String, DeleteListener> mDeleteListenerMap;

    @Nullable
    private List<String> mDownloadInQueue;

    @NotNull
    private final Map<String, DownloadListener> mDownloadListenerMap;

    @SuppressLint({"NotifyDataSetChanged"})
    @NotNull
    private final SharedPreferences.OnSharedPreferenceChangeListener mHWRLanguageChangeListener;

    @NotNull
    private final HWRLanguagePresenter$mHWRLanguageListChangeListener$1 mHWRLanguageListChangeListener;
    private boolean mHasTranslationFilter;

    @Nullable
    private TextRecognitionLanguageDownloadHelper mLanguageDownloadHelper;

    @NotNull
    private final Listenable mListenableDownloadComplete;

    @NotNull
    private final Listenable mListenableDownloadProgress;

    @NotNull
    private final PresenterContract mPresenterContract;

    /* JADX WARN: Type inference failed for: r2v8, types: [com.samsung.android.support.senl.nt.app.settings.hwr.presenter.HWRLanguagePresenter$mHWRLanguageListChangeListener$1] */
    public HWRLanguagePresenter(@NotNull PresenterContract presenterContract) {
        Intrinsics.checkNotNullParameter(presenterContract, "presenterContract");
        this.hwrLanguageAdapter = new HWRLanguageAdapter(this);
        this.mPresenterContract = presenterContract;
        this.mDownloadListenerMap = new HashMap();
        this.mDeleteListenerMap = new HashMap();
        this.mDownloadInQueue = new ArrayList();
        this.mCaller = SettingsConstants.CALLEE_SETTINGS;
        this.mListenableDownloadProgress = new Listenable() { // from class: com.samsung.android.support.senl.nt.app.settings.hwr.presenter.HWRLanguagePresenter$mListenableDownloadProgress$1
            @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable
            public String requestName() {
                String definedEventName = LanguageDownloadProgressEvent.getDefinedEventName();
                Intrinsics.checkNotNullExpressionValue(definedEventName, "getDefinedEventName(...)");
                return definedEventName;
            }

            @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable
            public void run(Event event) {
                Intrinsics.checkNotNullParameter(event, "event");
                try {
                    LanguageDownloadProgressEvent languageDownloadProgressEvent = (LanguageDownloadProgressEvent) event;
                    HWRLanguageAdapter hwrLanguageAdapter = this.this$0.getHwrLanguageAdapter();
                    String locale = languageDownloadProgressEvent.getLocale();
                    Intrinsics.checkNotNullExpressionValue(locale, "getLocale(...)");
                    hwrLanguageAdapter.onProgressChanged(locale, languageDownloadProgressEvent.getProgress(), languageDownloadProgressEvent.getMax());
                } catch (ClassCastException e) {
                    AbstractC6670b.m4738C("ListenableDownloadProgress# ", e.getMessage(), "HWRLanguagePresenter");
                }
            }
        };
        this.mListenableDownloadComplete = new Listenable() { // from class: com.samsung.android.support.senl.nt.app.settings.hwr.presenter.HWRLanguagePresenter$mListenableDownloadComplete$1
            @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable
            public String requestName() {
                String definedEventName = LanguageDownloadCompleteEvent.getDefinedEventName();
                Intrinsics.checkNotNullExpressionValue(definedEventName, "getDefinedEventName(...)");
                return definedEventName;
            }

            @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Listenable
            public void run(Event event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.loadLanguageData();
            }
        };
        this.mHWRLanguageChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 10);
        this.mHWRLanguageListChangeListener = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.app.settings.hwr.presenter.HWRLanguagePresenter$mHWRLanguageListChangeListener$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent == null) {
                    return;
                }
                Constants.ChangeAction changeAction = Constants.ChangeAction.getEntries().get(intent.getIntExtra(Constants.KEY_HANDWRITING_LANGUAGE_CHANGE_ACTION, Constants.ChangeAction.NONE.ordinal()));
                if (changeAction == Constants.ChangeAction.DELETED) {
                    if (intent.getIntExtra(Constants.KEY_HANDWRITING_LANGUAGE_DELETED_INSTANCE, -1) != this.this$0.hashCode()) {
                        this.this$0.loadLanguageData();
                        return;
                    }
                    return;
                }
                if (changeAction != Constants.ChangeAction.DOWNLOAD_PROGRESS) {
                    if ((changeAction == Constants.ChangeAction.DOWNLOAD_SUCCESS || changeAction == Constants.ChangeAction.DOWNLOAD_FAILED || changeAction == Constants.ChangeAction.DOWNLOAD_CANCELLED) && intent.getIntExtra(Constants.KEY_HANDWRITING_LANGUAGE_DOWNLOADED_INSTANCE, -1) != this.this$0.hashCode()) {
                        this.this$0.loadLanguageData();
                        return;
                    }
                    return;
                }
                if (intent.getIntExtra(Constants.KEY_HANDWRITING_LANGUAGE_DOWNLOADED_INSTANCE, -1) != this.this$0.hashCode()) {
                    String stringExtra = intent.getStringExtra(Constants.KEY_DOWNLOADING_HANDWRITING_LANGUAGE);
                    if (TextUtils.isEmpty(stringExtra)) {
                        return;
                    }
                    int intExtra = intent.getIntExtra(Constants.KEY_DOWNLOADING_HANDWRITING_LANGUAGE_MAX, 0);
                    int intExtra2 = intent.getIntExtra(Constants.KEY_DOWNLOADING_HANDWRITING_LANGUAGE_PROGRESS, -1);
                    if (intExtra <= 0 || intExtra2 < 0) {
                        return;
                    }
                    HWRLanguageAdapter hwrLanguageAdapter = this.this$0.getHwrLanguageAdapter();
                    Intrinsics.checkNotNull(stringExtra);
                    hwrLanguageAdapter.onProgressChanged(stringExtra, intExtra2, intExtra);
                }
            }
        };
    }

    private final void addDescriptionInfo() {
        if (isCallFromComposer()) {
            return;
        }
        this.hwrLanguageAdapter.addLanguageInfo(new HWRLanguageHolderInfo(1));
    }

    private final void addFooterInfo() {
        if (this.hwrLanguageAdapter.hasDownloadedLanguage()) {
            this.hwrLanguageAdapter.addLanguageInfo(new HWRLanguageHolderInfo(4));
        }
        if (this.hwrLanguageAdapter.hasAvailableLanguage()) {
            this.hwrLanguageAdapter.addLanguageInfo(new HWRLanguageHolderInfo(7));
        }
    }

    private final void addHeaderInfo() {
        if (this.hwrLanguageAdapter.hasDownloadedLanguage()) {
            this.hwrLanguageAdapter.addLanguageInfo(new HWRLanguageHolderInfo(2));
        }
        if (this.hwrLanguageAdapter.hasAvailableLanguage()) {
            this.hwrLanguageAdapter.addLanguageInfo(new HWRLanguageHolderInfo(5));
        }
    }

    private final void addLanguageInfo(List<? extends TextRecognitionLanguageDownloadHelper.LanguageInfo> languageInfo) {
        for (TextRecognitionLanguageDownloadHelper.LanguageInfo languageInfo2 : languageInfo) {
            Intrinsics.checkNotNull(languageInfo2);
            String locale = languageInfo2.getLocale();
            TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
            Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
            if (!textRecognitionLanguageDownloadHelper.isExistOnDevice(locale)) {
                HWRLanguageAdapter hWRLanguageAdapter = this.hwrLanguageAdapter;
                Intrinsics.checkNotNull(locale);
                hWRLanguageAdapter.addLanguageInfo(new HWRLanguageHolderInfo(locale, 6));
            } else if (isCallFromComposer()) {
                HWRLanguageAdapter hWRLanguageAdapter2 = this.hwrLanguageAdapter;
                Intrinsics.checkNotNull(locale);
                hWRLanguageAdapter2.addUnHandledLanguageInfo(new HWRLanguageHolderInfo(locale, 3));
            } else {
                HWRLanguageAdapter hWRLanguageAdapter3 = this.hwrLanguageAdapter;
                Intrinsics.checkNotNull(locale);
                hWRLanguageAdapter3.addLanguageInfo(new HWRLanguageHolderInfo(locale, 3));
            }
        }
    }

    private final void addSwitchInfo() {
        if (isCallFromComposer()) {
            return;
        }
        this.hwrLanguageAdapter.addLanguageInfo(new HWRLanguageHolderInfo(0));
    }

    private final DeleteListener getDeleteListener(String locale) {
        DeleteListener deleteListener = this.mDeleteListenerMap.get(locale);
        if (deleteListener != null) {
            return deleteListener;
        }
        DeleteListener deleteListener2 = new DeleteListener(new WeakReference(this.mPresenterContract.getGetContext()), locale, new ListenerCallback.DeleteResultCallback() { // from class: com.samsung.android.support.senl.nt.app.settings.hwr.presenter.HWRLanguagePresenter.getDeleteListener.1
            @Override // com.samsung.android.support.senl.nt.app.settings.hwr.listener.ListenerCallback.DeleteResultCallback
            public void onDeleted(String deletedLanguage) {
                if (Intrinsics.areEqual(deletedLanguage, HWRLanguagePresenter.this.getHwrLanguageAdapter().getMCurrentRecognitionLanguage())) {
                    RecognitionUtil.setHWRLanguage(RecognitionUtil.getSystemLocale(BaseUtils.getContext()));
                }
                HWRLanguagePresenter.this.loadLanguageData();
                LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(BaseUtils.getContext());
                Intent intent = new Intent(Constants.HANDWRITING_LANGUAGE_CHANGED_NOTIFICATION_INTENT_FILTER);
                intent.putExtra(Constants.KEY_HANDWRITING_LANGUAGE_CHANGE_ACTION, Constants.ChangeAction.DELETED.ordinal());
                intent.putExtra(Constants.KEY_HANDWRITING_LANGUAGE_DELETED_INSTANCE, intent.hashCode());
                localBroadcastManager.sendBroadcast(intent);
            }
        });
        this.mDeleteListenerMap.put(locale, deleteListener2);
        return deleteListener2;
    }

    private final DownloadListener getDownloadListener(final String locale) {
        DownloadListener downloadListener = this.mDownloadListenerMap.get(locale);
        if (downloadListener != null) {
            return downloadListener;
        }
        DownloadListener downloadListener2 = new DownloadListener(new WeakReference(this.mPresenterContract.getGetContext()), locale, new ListenerCallback.DownloadResultCallback() { // from class: com.samsung.android.support.senl.nt.app.settings.hwr.presenter.HWRLanguagePresenter.getDownloadListener.1
            @Override // com.samsung.android.support.senl.nt.app.settings.hwr.listener.ListenerCallback.DownloadResultCallback
            public void onCancelled(Context context, String locale2) {
                Boolean boolValueOf = locale2 != null ? Boolean.valueOf(HWRLanguagePresenter.this.isDownloaded(locale2)) : null;
                Intrinsics.checkNotNull(boolValueOf);
                if (boolValueOf.booleanValue()) {
                    return;
                }
                if (context != null) {
                    String string = context.getString(C8003R.string.settings_handwriting_recognition_download_cancel, HWRLanguagePresenter.this.getHwrLanguageAdapter().getDisplayData(locale2));
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    ToastHandler.show(context, string, 0);
                }
                HWRLanguagePresenter.this.loadLanguageData();
                LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(BaseUtils.getContext());
                Intent intent = new Intent(Constants.HANDWRITING_LANGUAGE_CHANGED_NOTIFICATION_INTENT_FILTER);
                intent.putExtra(Constants.KEY_HANDWRITING_LANGUAGE_CHANGE_ACTION, Constants.ChangeAction.DOWNLOAD_CANCELLED.ordinal());
                intent.putExtra(Constants.KEY_HANDWRITING_LANGUAGE_DOWNLOADED_INSTANCE, intent.hashCode());
                localBroadcastManager.sendBroadcast(intent);
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.hwr.listener.ListenerCallback.DownloadResultCallback
            public void onFailed(Context context, String locale2) {
                Boolean boolValueOf = locale2 != null ? Boolean.valueOf(HWRLanguagePresenter.this.isDownloaded(locale2)) : null;
                Intrinsics.checkNotNull(boolValueOf);
                if (boolValueOf.booleanValue()) {
                    return;
                }
                if (context != null) {
                    String string = context.getString(C8003R.string.settings_handwriting_recognition_download_fail, HWRLanguagePresenter.this.getHwrLanguageAdapter().getDisplayData(locale2));
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    ToastHandler.show(context, string, 0);
                }
                HWRLanguagePresenter.this.loadLanguageData();
                LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(BaseUtils.getContext());
                Intent intent = new Intent(Constants.HANDWRITING_LANGUAGE_CHANGED_NOTIFICATION_INTENT_FILTER);
                intent.putExtra(Constants.KEY_HANDWRITING_LANGUAGE_CHANGE_ACTION, Constants.ChangeAction.DOWNLOAD_FAILED.ordinal());
                intent.putExtra(Constants.KEY_HANDWRITING_LANGUAGE_DOWNLOADED_INSTANCE, intent.hashCode());
                localBroadcastManager.sendBroadcast(intent);
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.hwr.listener.ListenerCallback.DownloadResultCallback
            public void onProgress(int progress, int max) {
                HWRLanguagePresenter.this.getHwrLanguageAdapter().onProgressChanged(locale, progress, max);
                LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(BaseUtils.getContext());
                Intent intent = new Intent(Constants.HANDWRITING_LANGUAGE_CHANGED_NOTIFICATION_INTENT_FILTER);
                String str = locale;
                intent.putExtra(Constants.KEY_HANDWRITING_LANGUAGE_CHANGE_ACTION, Constants.ChangeAction.DOWNLOAD_PROGRESS.ordinal());
                intent.putExtra(Constants.KEY_DOWNLOADING_HANDWRITING_LANGUAGE, str);
                intent.putExtra(Constants.KEY_DOWNLOADING_HANDWRITING_LANGUAGE_PROGRESS, progress);
                intent.putExtra(Constants.KEY_DOWNLOADING_HANDWRITING_LANGUAGE_MAX, max);
                intent.putExtra(Constants.KEY_HANDWRITING_LANGUAGE_DOWNLOADED_INSTANCE, intent.hashCode());
                localBroadcastManager.sendBroadcast(intent);
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.hwr.listener.ListenerCallback.DownloadResultCallback
            public void onSuccess(Context context, String locale2) {
                if (context != null) {
                    String string = context.getString(C8003R.string.settings_handwriting_recognition_download_succces, locale2 != null ? HWRLanguagePresenter.this.getHwrLanguageAdapter().getDisplayData(locale2) : null);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    ToastHandler.show(context, string, 0);
                }
                HWRLanguagePresenter.this.loadLanguageData();
                LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(BaseUtils.getContext());
                Intent intent = new Intent(Constants.HANDWRITING_LANGUAGE_CHANGED_NOTIFICATION_INTENT_FILTER);
                intent.putExtra(Constants.KEY_HANDWRITING_LANGUAGE_CHANGE_ACTION, Constants.ChangeAction.DOWNLOAD_SUCCESS.ordinal());
                intent.putExtra(Constants.KEY_HANDWRITING_LANGUAGE_DOWNLOADED_INSTANCE, intent.hashCode());
                localBroadcastManager.sendBroadcast(intent);
            }
        });
        this.mDownloadListenerMap.put(locale, downloadListener2);
        return downloadListener2;
    }

    private final void initLanguageDownloadHelper() {
        if (this.mLanguageDownloadHelper == null) {
            TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = new TextRecognitionLanguageDownloadHelper(BaseUtils.getApplicationContext());
            this.mLanguageDownloadHelper = textRecognitionLanguageDownloadHelper;
            Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
            textRecognitionLanguageDownloadHelper.init(C0158a.m407a().m414e());
            EventBus eventBus = EventManager.getEventBus();
            eventBus.register(this.mListenableDownloadProgress);
            eventBus.register(this.mListenableDownloadComplete);
        }
    }

    private final boolean isCallFromComposer() {
        return Intrinsics.areEqual(SettingsConstants.CALLEE_COMPOSER, this.mCaller);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mHWRLanguageChangeListener$lambda$0(HWRLanguagePresenter hWRLanguagePresenter, SharedPreferences sharedPreferences, String str) {
        if (!Intrinsics.areEqual(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_LANGUAGE, str)) {
            if (Intrinsics.areEqual(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION, str)) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HWRLanguagePresenter$mHWRLanguageChangeListener$1$1(hWRLanguagePresenter, null), 3, null);
                return;
            }
            return;
        }
        Logger.m8698e(TAG, "onSharedPreferenceChanged, currentRecognitionLanguage : " + hWRLanguagePresenter.hwrLanguageAdapter.getMCurrentRecognitionLanguage() + ", savedRecognitionLanguage : " + RecognitionUtil.getHWRLanguage(BaseUtils.getContext()));
        RecognitionUtil.setHWREnabledChanged(true);
        hWRLanguagePresenter.notifyLoadFinished();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void notifyLoadFinished() {
        this.hwrLanguageAdapter.handleHWLanguageHolderInfoBeforeNotify();
        this.hwrLanguageAdapter.notifyDataSetChanged();
        this.mPresenterContract.onDataLoadFinished(this.hwrLanguageAdapter.getItemCount());
    }

    private final void registerListener() {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").registerOnSharedPreferenceChangeListener(this.mHWRLanguageChangeListener);
        LocalBroadcastManager.getInstance(BaseUtils.getContext()).registerReceiver(this.mHWRLanguageListChangeListener, new IntentFilter(Constants.HANDWRITING_LANGUAGE_CHANGED_NOTIFICATION_INTENT_FILTER));
    }

    private final void unregisterListener() {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").unregisterOnSharedPreferenceChangeListener(this.mHWRLanguageChangeListener);
        LocalBroadcastManager.getInstance(BaseUtils.getContext()).unregisterReceiver(this.mHWRLanguageListChangeListener);
    }

    @NotNull
    public final HWRLanguageAdapter getHwrLanguageAdapter() {
        return this.hwrLanguageAdapter;
    }

    public final void initialize() {
        initLanguageDownloadHelper();
        registerListener();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.AdapterContract
    public boolean isDownloadInProgress(@Nullable String locale) {
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
        Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
        return textRecognitionLanguageDownloadHelper.isDownloadInProgress(locale);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.AdapterContract
    public boolean isDownloadInQueue(@Nullable String locale) {
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
        Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
        if (textRecognitionLanguageDownloadHelper.getLocaleListInQueue().contains(locale)) {
            return true;
        }
        List<String> list = this.mDownloadInQueue;
        if (list == null) {
            return false;
        }
        Intrinsics.checkNotNull(list);
        return CollectionsKt.contains(list, locale) && !isDownloaded(locale);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.AdapterContract
    public boolean isDownloaded(@Nullable String locale) {
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
        Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
        return textRecognitionLanguageDownloadHelper.isDownloaded(locale);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.AdapterContract
    public boolean isInstallable(@Nullable String locale) {
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
        Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
        return textRecognitionLanguageDownloadHelper.isInstallable(locale);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.AdapterContract
    public boolean isPreloaded(@Nullable String locale) {
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
        Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
        return textRecognitionLanguageDownloadHelper.isPreloaded(locale);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.AdapterContract
    public boolean isUpdateAvailable(@Nullable String locale) {
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
        Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
        return textRecognitionLanguageDownloadHelper.isUpdateAvailable(locale);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.AdapterContract
    public void loadLanguageData() {
        List<TextRecognitionLanguageDownloadHelper.LanguageInfo> languageInfoList;
        if (this.mHasTranslationFilter) {
            TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
            Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
            languageInfoList = textRecognitionLanguageDownloadHelper.getLanguageInfoListForAiLanguage();
        } else {
            TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper2 = this.mLanguageDownloadHelper;
            Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper2);
            languageInfoList = textRecognitionLanguageDownloadHelper2.getLanguageInfoList();
        }
        AbstractC8014b.m7201c(languageInfoList.size(), "language list size : ", TAG);
        if (CollectionUtils.isEmpty(languageInfoList)) {
            return;
        }
        this.hwrLanguageAdapter.clearData();
        addSwitchInfo();
        addDescriptionInfo();
        Intrinsics.checkNotNull(languageInfoList);
        addLanguageInfo(languageInfoList);
        addHeaderInfo();
        addFooterInfo();
        notifyLoadFinished();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.AdapterContract
    public void onDelete(@Nullable String locale) {
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
        Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
        textRecognitionLanguageDownloadHelper.deleteLanguage(locale, locale != null ? getDeleteListener(locale) : null);
    }

    public final void onDestroy() {
        Iterator<DownloadListener> it = this.mDownloadListenerMap.values().iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.mDownloadListenerMap.clear();
        Iterator<DeleteListener> it2 = this.mDeleteListenerMap.values().iterator();
        while (it2.hasNext()) {
            it2.next().release();
        }
        this.mDeleteListenerMap.clear();
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
        Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
        textRecognitionLanguageDownloadHelper.close();
        List<String> list = this.mDownloadInQueue;
        Intrinsics.checkNotNull(list);
        list.clear();
        EventManager.getEventBus().unregister(this.mListenableDownloadProgress);
        EventManager.getEventBus().unregister(this.mListenableDownloadComplete);
        unregisterListener();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.AdapterContract
    public void onDownload(@Nullable String locale) {
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
        Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
        if (textRecognitionLanguageDownloadHelper.getLocaleListInQueue().contains(locale)) {
            return;
        }
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper2 = this.mLanguageDownloadHelper;
        Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper2);
        textRecognitionLanguageDownloadHelper2.download(locale, locale != null ? getDownloadListener(locale) : null);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.AdapterContract
    public void onDownloadCancel(@Nullable String locale) {
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
        Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
        textRecognitionLanguageDownloadHelper.cancelDownload(locale);
    }

    public final void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.mDownloadInQueue = TypeIntrinsics.asMutableList(savedInstanceState.getSerializable(SettingsConstants.SETTINGS_HANDWRITING_DOWNLOAD_IN_QUEUE));
        }
    }

    public final void onResume() {
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
        if (textRecognitionLanguageDownloadHelper == null) {
            return;
        }
        Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
        textRecognitionLanguageDownloadHelper.isInitFinished(new C7737b(this, 23));
    }

    public final void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
        if (textRecognitionLanguageDownloadHelper == null) {
            return;
        }
        Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
        List<String> localeListInQueue = textRecognitionLanguageDownloadHelper.getLocaleListInQueue();
        Intrinsics.checkNotNull(localeListInQueue, "null cannot be cast to non-null type java.io.Serializable");
        outState.putSerializable(SettingsConstants.SETTINGS_HANDWRITING_DOWNLOAD_IN_QUEUE, (Serializable) localeListInQueue);
    }

    public final void setCaller(@NotNull String caller) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        this.mCaller = caller;
    }

    public final void setLanguageListFilter(@NotNull String filterType) {
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        if (TextUtils.isEmpty(filterType)) {
            return;
        }
        this.mHasTranslationFilter = Intrinsics.areEqual(filterType, SettingsConstants.LANGUAGE_LIST_FILTER_TYPE_TRANSLATION);
    }
}
