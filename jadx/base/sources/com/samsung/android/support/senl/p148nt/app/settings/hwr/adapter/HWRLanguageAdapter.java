package com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder.HWRLanguageHolder;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder.HWRLanguageHolderInfo;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder.HolderContract;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayLanguageUtils;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0014\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001?B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001eH\u0016J&\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\u001eH\u0016J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eH\u0016J\u0006\u0010)\u001a\u00020\u0013J,\u0010*\u001a\u00020\u00132\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00180,2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010#H\u0002J\u0012\u0010.\u001a\u00020\u00182\b\u0010/\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u00100\u001a\u00020\u00182\b\u0010/\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u00101\u001a\u00020\u00182\b\u0010/\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u00102\u001a\u00020\u00182\b\u0010/\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u00103\u001a\u00020\u00182\b\u0010/\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u00104\u001a\u00020\u00182\b\u0010/\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u00105\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u00106\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u00107\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u00108\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u00109\u001a\u00020\u0011J\u001e\u0010:\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u001eJ\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0011H\u0002J\u0010\u0010>\u001a\u0004\u0018\u00010\u00112\u0006\u0010/\u001a\u00020\u0011R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u000ej\b\u0012\u0004\u0012\u00020\u000b`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/hwr/adapter/HWRLanguageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/support/senl/nt/app/settings/hwr/adapter/holder/HWRLanguageHolder;", "Lcom/samsung/android/support/senl/nt/app/settings/hwr/adapter/holder/HolderContract;", "adapterContract", "Lcom/samsung/android/support/senl/nt/app/settings/hwr/adapter/AdapterContract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/hwr/adapter/AdapterContract;)V", "mAdapterContract", "mHWRLanguageHolderInfos", "", "Lcom/samsung/android/support/senl/nt/app/settings/hwr/adapter/holder/HWRLanguageHolderInfo;", "mUnHandledHWRLanguageHolderInfos", "mLanguageComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "mCurrentRecognitionLanguage", "", "clearData", "", "addLanguageInfo", "hwrLanguageHolderInfo", "addUnHandledLanguageInfo", "hasDownloadedLanguage", "", "hasAvailableLanguage", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "payloads", "", "", "getItemCount", "getItemId", "", "getItemViewType", "handleHWLanguageHolderInfoBeforeNotify", "checkDuplicatedDisplayLanguage", "displayLanguages", "", "hwrLanguageHolderInfos", "isPreloaded", "locale", "isUpdateAvailable", "isDownloaded", "isInstallable", "isDownloadInQueue", "isDownloadInProgress", "onDownload", "onDownloadCancel", "onDelete", "onHWLanguageChanged", "getCurrentRecognitionLanguage", "onProgressChanged", "progress", VElementFormulasCmd.FMAX, "getIndexOfLocale", "getDisplayData", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHWRLanguageAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HWRLanguageAdapter.kt\ncom/samsung/android/support/senl/nt/app/settings/hwr/adapter/HWRLanguageAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,270:1\n1#2:271\n*E\n"})
public final class HWRLanguageAdapter extends RecyclerView.Adapter<HWRLanguageHolder> implements HolderContract {

    @NotNull
    private static final String TAG = "HWRLanguageAdapter";

    @NotNull
    private final AdapterContract mAdapterContract;

    @NotNull
    private String mCurrentRecognitionLanguage;

    @NotNull
    private List<HWRLanguageHolderInfo> mHWRLanguageHolderInfos;

    @NotNull
    private final Comparator<HWRLanguageHolderInfo> mLanguageComparator;

    @NotNull
    private List<HWRLanguageHolderInfo> mUnHandledHWRLanguageHolderInfos;

    public HWRLanguageAdapter(@NotNull AdapterContract adapterContract) {
        Intrinsics.checkNotNullParameter(adapterContract, "adapterContract");
        this.mLanguageComparator = new Comparator<HWRLanguageHolderInfo>() { // from class: com.samsung.android.support.senl.nt.app.settings.hwr.adapter.HWRLanguageAdapter$mLanguageComparator$1
            private final String hwrLanguageLocale;
            private final String systemLocale = RecognitionUtil.getSystemLocale(BaseUtils.getContext());

            {
                String hWRLanguage = RecognitionUtil.getHWRLanguage(BaseUtils.getContext());
                Intrinsics.checkNotNullExpressionValue(hWRLanguage, "getHWRLanguage(...)");
                this.hwrLanguageLocale = hWRLanguage;
            }

            @Override // java.util.Comparator
            public int compare(HWRLanguageHolderInfo languageInfo1, HWRLanguageHolderInfo languageInfo2) {
                Intrinsics.checkNotNullParameter(languageInfo1, "languageInfo1");
                Intrinsics.checkNotNullParameter(languageInfo2, "languageInfo2");
                if (languageInfo1.getType() == languageInfo2.getType()) {
                    if (Intrinsics.areEqual(this.hwrLanguageLocale, languageInfo1.getLocale())) {
                        return -1;
                    }
                    if (Intrinsics.areEqual(this.hwrLanguageLocale, languageInfo2.getLocale())) {
                        return 1;
                    }
                    if (Intrinsics.areEqual(this.systemLocale, languageInfo1.getLocale())) {
                        return -1;
                    }
                    if (Intrinsics.areEqual(this.systemLocale, languageInfo2.getLocale())) {
                        return 1;
                    }
                }
                return languageInfo1.compareTo(languageInfo2);
            }
        };
        this.mCurrentRecognitionLanguage = "";
        setHasStableIds(true);
        this.mHWRLanguageHolderInfos = new ArrayList();
        this.mUnHandledHWRLanguageHolderInfos = new ArrayList();
        this.mAdapterContract = adapterContract;
    }

    private final void checkDuplicatedDisplayLanguage(Map<String, Boolean> displayLanguages, List<HWRLanguageHolderInfo> hwrLanguageHolderInfos) {
        Intrinsics.checkNotNull(hwrLanguageHolderInfos);
        int size = hwrLanguageHolderInfos.size();
        for (int i = 0; i < size; i++) {
            String displayLanguage = DisplayLanguageUtils.INSTANCE.getDisplayLanguage(hwrLanguageHolderInfos.get(i).getLocale());
            Boolean bool = displayLanguages.get(displayLanguage);
            if (bool == null) {
                displayLanguages.put(displayLanguage, Boolean.FALSE);
            } else if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
                displayLanguages.remove(displayLanguage);
                displayLanguages.put(displayLanguage, Boolean.TRUE);
            }
        }
    }

    private final int getIndexOfLocale(String locale) {
        int size = this.mHWRLanguageHolderInfos.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(this.mHWRLanguageHolderInfos.get(i).getLocale(), locale)) {
                return i;
            }
        }
        return -1;
    }

    public final void addLanguageInfo(@NotNull HWRLanguageHolderInfo hwrLanguageHolderInfo) {
        Intrinsics.checkNotNullParameter(hwrLanguageHolderInfo, "hwrLanguageHolderInfo");
        this.mHWRLanguageHolderInfos.add(hwrLanguageHolderInfo);
    }

    public final void addUnHandledLanguageInfo(@NotNull HWRLanguageHolderInfo hwrLanguageHolderInfo) {
        Intrinsics.checkNotNullParameter(hwrLanguageHolderInfo, "hwrLanguageHolderInfo");
        this.mUnHandledHWRLanguageHolderInfos.add(hwrLanguageHolderInfo);
    }

    public final void clearData() {
        this.mHWRLanguageHolderInfos.clear();
        this.mUnHandledHWRLanguageHolderInfos.clear();
    }

    @NotNull
    /* JADX INFO: renamed from: getCurrentRecognitionLanguage, reason: from getter */
    public final String getMCurrentRecognitionLanguage() {
        return this.mCurrentRecognitionLanguage;
    }

    @Nullable
    public final String getDisplayData(@NotNull String locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        int size = this.mHWRLanguageHolderInfos.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(this.mHWRLanguageHolderInfos.get(i).getLocale(), locale)) {
                return this.mHWRLanguageHolderInfos.get(i).getDisplayData();
            }
        }
        return "";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mHWRLanguageHolderInfos.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.mHWRLanguageHolderInfos.get(position).getLocale().hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.mHWRLanguageHolderInfos.get(position).getType();
    }

    public final void handleHWLanguageHolderInfoBeforeNotify() {
        HashMap map = new HashMap();
        checkDuplicatedDisplayLanguage(map, this.mHWRLanguageHolderInfos);
        checkDuplicatedDisplayLanguage(map, this.mUnHandledHWRLanguageHolderInfos);
        int size = this.mHWRLanguageHolderInfos.size();
        for (int i = 0; i < size; i++) {
            String locale = this.mHWRLanguageHolderInfos.get(i).getLocale();
            DisplayLanguageUtils displayLanguageUtils = DisplayLanguageUtils.INSTANCE;
            Boolean bool = map.get(displayLanguageUtils.getDisplayLanguage(locale));
            if (bool == null) {
                this.mHWRLanguageHolderInfos.get(i).setDisplayData(DisplayLanguageUtils.getDisplayName(locale));
            } else if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                this.mHWRLanguageHolderInfos.get(i).setDisplayData(DisplayLanguageUtils.getDisplayName(locale));
            } else {
                this.mHWRLanguageHolderInfos.get(i).setDisplayData(displayLanguageUtils.getDisplayNameWithoutCountry(locale));
            }
        }
        Collections.sort(this.mHWRLanguageHolderInfos, this.mLanguageComparator);
    }

    public final boolean hasAvailableLanguage() {
        Iterator<HWRLanguageHolderInfo> it = this.mHWRLanguageHolderInfos.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == 6) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasDownloadedLanguage() {
        Iterator<HWRLanguageHolderInfo> it = this.mHWRLanguageHolderInfos.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == 3) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder.HolderContract
    public boolean isDownloadInProgress(@Nullable String locale) {
        return this.mAdapterContract.isDownloadInProgress(locale);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder.HolderContract
    public boolean isDownloadInQueue(@Nullable String locale) {
        return this.mAdapterContract.isDownloadInQueue(locale);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder.HolderContract
    public boolean isDownloaded(@Nullable String locale) {
        return this.mAdapterContract.isDownloaded(locale);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder.HolderContract
    public boolean isInstallable(@Nullable String locale) {
        return this.mAdapterContract.isInstallable(locale);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder.HolderContract
    public boolean isPreloaded(@Nullable String locale) {
        return this.mAdapterContract.isPreloaded(locale);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder.HolderContract
    public boolean isUpdateAvailable(@Nullable String locale) {
        return this.mAdapterContract.isUpdateAvailable(locale);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder.HolderContract
    public void onDelete(@Nullable String locale) {
        this.mAdapterContract.onDelete(locale);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder.HolderContract
    public void onDownload(@Nullable String locale) {
        this.mAdapterContract.onDownload(locale);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder.HolderContract
    public void onDownloadCancel(@Nullable String locale) {
        this.mAdapterContract.onDownloadCancel(locale);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder.HolderContract
    public void onHWLanguageChanged(@Nullable String locale) {
        String hWRLanguage = RecognitionUtil.getHWRLanguage(BaseUtils.getContext());
        if (locale != null) {
            this.mCurrentRecognitionLanguage = locale;
            RecognitionUtil.setHWRLanguage(locale);
        }
        int indexOfLocale = getIndexOfLocale(hWRLanguage.toString());
        if (indexOfLocale >= 0) {
            notifyItemChanged(indexOfLocale, Boolean.FALSE);
        }
        Integer numValueOf = locale != null ? Integer.valueOf(getIndexOfLocale(locale)) : null;
        Intrinsics.checkNotNull(numValueOf);
        if (numValueOf.intValue() >= 0) {
            notifyItemChanged(numValueOf.intValue(), Boolean.FALSE);
        }
    }

    public final void onProgressChanged(@NotNull String locale, int progress, int max) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        int indexOfLocale = getIndexOfLocale(locale);
        if (indexOfLocale >= 0) {
            HWRLanguageHolderInfo hWRLanguageHolderInfo = this.mHWRLanguageHolderInfos.get(indexOfLocale);
            hWRLanguageHolderInfo.setProgress(progress);
            hWRLanguageHolderInfo.setTotal(max);
            notifyItemChanged(indexOfLocale, Boolean.TRUE);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((HWRLanguageHolder) viewHolder, i, (List<? extends Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public HWRLanguageHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.settings_hwr_language_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new HWRLanguageHolder(viewInflate, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull HWRLanguageHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.decorate(this.mHWRLanguageHolderInfos.get(position));
    }

    public void onBindViewHolder(@NotNull HWRLanguageHolder holder, int position, @NotNull List<? extends Object> payloads) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            bool = null;
        } else {
            Object obj = payloads.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            bool = (Boolean) obj;
        }
        if (bool == null) {
            onBindViewHolder(holder, position);
            return;
        }
        MainLogger.m7254d(TAG, "onBindViewHolder, position " + position + ", payLoad " + bool + ", type " + holder.getItemViewType());
        if (holder.getItemViewType() == 0) {
            holder.decorateSwitch();
        } else if (holder.getItemViewType() == 6) {
            holder.decorateState();
        } else if (holder.getItemViewType() == 3) {
            holder.decorateRadioButton();
        }
    }
}
