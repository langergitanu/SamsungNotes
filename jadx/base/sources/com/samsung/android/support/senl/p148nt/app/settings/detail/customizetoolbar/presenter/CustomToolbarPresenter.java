package com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.presenter;

import android.content.SharedPreferences;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.FragmentActivity;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.common.utils.SettingToolbarPreferenceUtils;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.presenter.CustomToolbarPresenter;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view.CustomToolbarItem;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view.CustomToolbarView;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.composer.common.ComposerSpenUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.DefaultItemOrder;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import p095X2.SharedPreferencesOnSharedPreferenceChangeListenerC0340a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 D2\u00020\u0001:\u0003CDEB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010*\u001a\u00020+2\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020+J\u0006\u0010.\u001a\u00020+J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u00101\u001a\u000202H\u0002J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u00104\u001a\u00020\fH\u0002J\b\u00105\u001a\u00020\u001fH\u0002J\u0010\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020\u001fH\u0002J\b\u00108\u001a\u00020\u001fH\u0002J\u0010\u00109\u001a\u00020+2\u0006\u00107\u001a\u00020\u001fH\u0002J\u0018\u0010:\u001a\u0002022\u0006\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020=H\u0002J\u0006\u0010>\u001a\u00020=J\u0006\u0010?\u001a\u00020+J\u0006\u0010@\u001a\u00020+J\u0006\u0010A\u001a\u000202J\u0006\u0010B\u001a\u00020+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u000eR \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u001aR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/CustomToolbarPresenter;", "", "contract", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/CustomToolbarPresenter$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/CustomToolbarPresenter$Contract;)V", "customToolbarView", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarView;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "defaultToolbarList", "", "", "getDefaultToolbarList", "()Ljava/util/List;", "defaultToolbarList$delegate", "Lkotlin/Lazy;", "defaultToolbarListAtTablet", "getDefaultToolbarListAtTablet", "defaultToolbarListAtTablet$delegate", "defaultToolbarListAtPhone", "getDefaultToolbarListAtPhone", "defaultToolbarListAtPhone$delegate", "visibleToolbarList", "getVisibleToolbarList", "setVisibleToolbarList", "(Ljava/util/List;)V", "hiddenToolbarList", "getHiddenToolbarList", "setHiddenToolbarList", "cnt", "", "quickColorCount", "getQuickColorCount", "()I", "setQuickColorCount", "(I)V", "quickSizeCount", "getQuickSizeCount", "setQuickSizeCount", "prefListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "setView", "", "onResume", "onPause", "saveOrderList", "getToolbarDisplayList", "getToolbarItemOrderFromSharedPreferences", "isHidden", "", "getToolbarListFromStringData", "data", "getQuickColorCountFromSharedPreferences", "setQuickColorCountToSharedPreferences", "count", "getQuickSizeCountFromSharedPreferences", "setQuickSizeCountToSharedPreferences", "isUnsupportedFeature", "itemType", "supportList", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/CustomToolbarPresenter$SupportList;", "getSupportList", "reset", "invalidateOptionsMenu", "isTabletLayout", "insertSAStatusLogging", "SupportList", "Companion", "Contract", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCustomToolbarPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomToolbarPresenter.kt\ncom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/CustomToolbarPresenter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,272:1\n774#2:273\n865#2,2:274\n774#2:276\n865#2,2:277\n774#2:279\n865#2,2:280\n*S KotlinDebug\n*F\n+ 1 CustomToolbarPresenter.kt\ncom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/CustomToolbarPresenter\n*L\n114#1:273\n114#1:274,2\n43#1:276\n43#1:277,2\n55#1:279\n55#1:280,2\n*E\n"})
public final class CustomToolbarPresenter {

    @NotNull
    private static final String TAG = "CustomToolbarPresenter";

    @NotNull
    private FragmentActivity activity;

    @NotNull
    private final Contract contract;
    private CustomToolbarView customToolbarView;

    /* JADX INFO: renamed from: defaultToolbarList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy defaultToolbarList;

    /* JADX INFO: renamed from: defaultToolbarListAtPhone$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy defaultToolbarListAtPhone;

    /* JADX INFO: renamed from: defaultToolbarListAtTablet$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy defaultToolbarListAtTablet;

    @NotNull
    private List<String> hiddenToolbarList;

    @Nullable
    private SharedPreferences.OnSharedPreferenceChangeListener prefListener;

    @NotNull
    private List<String> visibleToolbarList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/CustomToolbarPresenter$Contract;", "", "getFragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "isTabletLayout", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        @NotNull
        FragmentActivity getFragmentActivity();

        boolean isTabletLayout();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<DefaultItemOrder.TabletItem> entries$0 = EnumEntriesKt.enumEntries(DefaultItemOrder.TabletItem.values());
        public static final /* synthetic */ EnumEntries<DefaultItemOrder.PhoneItem> entries$1 = EnumEntriesKt.enumEntries(DefaultItemOrder.PhoneItem.values());
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J1\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\t¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/CustomToolbarPresenter$SupportList;", "", "isSupportRecognition", "", "isSupportDirectWrite", "isSupportEasyWritingPad", "isSupportHandwritingHelp", "<init>", "(ZZZZ)V", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class SupportList {
        private final boolean isSupportDirectWrite;
        private final boolean isSupportEasyWritingPad;
        private final boolean isSupportHandwritingHelp;
        private final boolean isSupportRecognition;

        public SupportList(boolean z, boolean z2, boolean z3, boolean z4) {
            this.isSupportRecognition = z;
            this.isSupportDirectWrite = z2;
            this.isSupportEasyWritingPad = z3;
            this.isSupportHandwritingHelp = z4;
        }

        public static /* synthetic */ SupportList copy$default(SupportList supportList, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z = supportList.isSupportRecognition;
            }
            if ((i & 2) != 0) {
                z2 = supportList.isSupportDirectWrite;
            }
            if ((i & 4) != 0) {
                z3 = supportList.isSupportEasyWritingPad;
            }
            if ((i & 8) != 0) {
                z4 = supportList.isSupportHandwritingHelp;
            }
            return supportList.copy(z, z2, z3, z4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsSupportRecognition() {
            return this.isSupportRecognition;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsSupportDirectWrite() {
            return this.isSupportDirectWrite;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsSupportEasyWritingPad() {
            return this.isSupportEasyWritingPad;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsSupportHandwritingHelp() {
            return this.isSupportHandwritingHelp;
        }

        @NotNull
        public final SupportList copy(boolean isSupportRecognition, boolean isSupportDirectWrite, boolean isSupportEasyWritingPad, boolean isSupportHandwritingHelp) {
            return new SupportList(isSupportRecognition, isSupportDirectWrite, isSupportEasyWritingPad, isSupportHandwritingHelp);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SupportList)) {
                return false;
            }
            SupportList supportList = (SupportList) other;
            return this.isSupportRecognition == supportList.isSupportRecognition && this.isSupportDirectWrite == supportList.isSupportDirectWrite && this.isSupportEasyWritingPad == supportList.isSupportEasyWritingPad && this.isSupportHandwritingHelp == supportList.isSupportHandwritingHelp;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isSupportHandwritingHelp) + AbstractC0622a.m1160f(this.isSupportEasyWritingPad, AbstractC0622a.m1160f(this.isSupportDirectWrite, Boolean.hashCode(this.isSupportRecognition) * 31, 31), 31);
        }

        public final boolean isSupportDirectWrite() {
            return this.isSupportDirectWrite;
        }

        public final boolean isSupportEasyWritingPad() {
            return this.isSupportEasyWritingPad;
        }

        public final boolean isSupportHandwritingHelp() {
            return this.isSupportHandwritingHelp;
        }

        public final boolean isSupportRecognition() {
            return this.isSupportRecognition;
        }

        @NotNull
        public String toString() {
            boolean z = this.isSupportRecognition;
            boolean z2 = this.isSupportDirectWrite;
            boolean z3 = this.isSupportEasyWritingPad;
            boolean z4 = this.isSupportHandwritingHelp;
            StringBuilder sbM2230u = AbstractC2821a.m2230u("SupportList(isSupportRecognition=", ", isSupportDirectWrite=", ", isSupportEasyWritingPad=", z, z2);
            sbM2230u.append(z3);
            sbM2230u.append(", isSupportHandwritingHelp=");
            sbM2230u.append(z4);
            sbM2230u.append(")");
            return sbM2230u.toString();
        }
    }

    public CustomToolbarPresenter(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.contract = contract;
        this.activity = contract.getFragmentActivity();
        final int i = 0;
        this.defaultToolbarList = LazyKt.lazy(new Function0(this) { // from class: X2.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CustomToolbarPresenter f863b;

            {
                this.f863b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i) {
                    case 0:
                        return CustomToolbarPresenter.defaultToolbarList_delegate$lambda$0(this.f863b);
                    case 1:
                        return CustomToolbarPresenter.defaultToolbarListAtTablet_delegate$lambda$2(this.f863b);
                    default:
                        return CustomToolbarPresenter.defaultToolbarListAtPhone_delegate$lambda$4(this.f863b);
                }
            }
        });
        final int i2 = 1;
        this.defaultToolbarListAtTablet = LazyKt.lazy(new Function0(this) { // from class: X2.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CustomToolbarPresenter f863b;

            {
                this.f863b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i2) {
                    case 0:
                        return CustomToolbarPresenter.defaultToolbarList_delegate$lambda$0(this.f863b);
                    case 1:
                        return CustomToolbarPresenter.defaultToolbarListAtTablet_delegate$lambda$2(this.f863b);
                    default:
                        return CustomToolbarPresenter.defaultToolbarListAtPhone_delegate$lambda$4(this.f863b);
                }
            }
        });
        final int i4 = 2;
        this.defaultToolbarListAtPhone = LazyKt.lazy(new Function0(this) { // from class: X2.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CustomToolbarPresenter f863b;

            {
                this.f863b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i4) {
                    case 0:
                        return CustomToolbarPresenter.defaultToolbarList_delegate$lambda$0(this.f863b);
                    case 1:
                        return CustomToolbarPresenter.defaultToolbarListAtTablet_delegate$lambda$2(this.f863b);
                    default:
                        return CustomToolbarPresenter.defaultToolbarListAtPhone_delegate$lambda$4(this.f863b);
                }
            }
        });
        this.visibleToolbarList = getToolbarItemOrderFromSharedPreferences(false);
        this.hiddenToolbarList = getToolbarItemOrderFromSharedPreferences(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List defaultToolbarListAtPhone_delegate$lambda$4(CustomToolbarPresenter customToolbarPresenter) {
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.toList(EntriesMappings.entries$1).iterator();
        while (it.hasNext()) {
            arrayList.add(((DefaultItemOrder.PhoneItem) it.next()).getItemInfo().name());
        }
        SupportList supportList = customToolbarPresenter.getSupportList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!customToolbarPresenter.isUnsupportedFeature((String) obj, supportList)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List defaultToolbarListAtTablet_delegate$lambda$2(CustomToolbarPresenter customToolbarPresenter) {
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.toList(EntriesMappings.entries$0).iterator();
        while (it.hasNext()) {
            arrayList.add(((DefaultItemOrder.TabletItem) it.next()).getItemInfo().name());
        }
        SupportList supportList = customToolbarPresenter.getSupportList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!customToolbarPresenter.isUnsupportedFeature((String) obj, supportList)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List defaultToolbarList_delegate$lambda$0(CustomToolbarPresenter customToolbarPresenter) {
        return customToolbarPresenter.isTabletLayout() ? customToolbarPresenter.getDefaultToolbarListAtTablet() : customToolbarPresenter.getDefaultToolbarListAtPhone();
    }

    private final List<String> getDefaultToolbarListAtPhone() {
        return (List) this.defaultToolbarListAtPhone.getValue();
    }

    private final List<String> getDefaultToolbarListAtTablet() {
        return (List) this.defaultToolbarListAtTablet.getValue();
    }

    private final int getQuickColorCountFromSharedPreferences() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_CUSTOMIZE_TOOLBAR_QUICK_COLOR_USE_COUNT, 3);
    }

    private final int getQuickSizeCountFromSharedPreferences() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_CUSTOMIZE_TOOLBAR_QUICK_SIZE_USE_COUNT, 1);
    }

    private final List<String> getToolbarItemOrderFromSharedPreferences(boolean isHidden) {
        String string = SharedPreferencesCompat.INSTANCE.getInstance("Settings").getString(isHidden ? SettingsConstants.SETTINGS_CANDIDATE_TOOLBAR_ITEM_ORDER : SettingsConstants.SETTINGS_TOOLBAR_ITEM_ORDER, "");
        return CollectionsKt.toMutableList((Collection) ((string == null || string.length() == 0) ? !isHidden ? getDefaultToolbarList() : CollectionsKt.emptyList() : getToolbarListFromStringData(string)));
    }

    private final List<String> getToolbarListFromStringData(String data) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(data);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String string = jSONArray.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                arrayList.add(string);
            }
            return arrayList;
        } catch (JSONException e) {
            MainLogger.m7255e(TAG, e.getMessage());
            return arrayList;
        }
    }

    private final boolean isUnsupportedFeature(String itemType, SupportList supportList) {
        boolean zIsSupportRecognition = supportList.isSupportRecognition();
        return Intrinsics.areEqual("DirectWrite", itemType) ? !supportList.isSupportDirectWrite() : Intrinsics.areEqual("Shape", itemType) ? !zIsSupportRecognition : Intrinsics.areEqual("EasyWritePad", itemType) ? !supportList.isSupportEasyWritingPad() : Intrinsics.areEqual("Assistance", itemType) ? !supportList.isSupportHandwritingHelp() : (Intrinsics.areEqual("Align", itemType) || Intrinsics.areEqual("ConvertText", itemType)) ? !zIsSupportRecognition || FeatureInfo.isBeautifierFeatureEnabled() : Intrinsics.areEqual("CleanUpAndConvertText", itemType) ? (zIsSupportRecognition && FeatureInfo.isBeautifierFeatureEnabled()) ? false : true : Intrinsics.areEqual("SmartPen", itemType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void onResume$lambda$5(CustomToolbarPresenter customToolbarPresenter, SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case 7157054:
                    if (!str.equals(SettingsConstants.SETTINGS_CANDIDATE_TOOLBAR_ITEM_ORDER)) {
                        return;
                    }
                    break;
                case 277627906:
                    if (!str.equals(SettingsConstants.SETTINGS_TOOLBAR_ITEM_ORDER)) {
                        return;
                    }
                    break;
                case 1241208653:
                    if (!str.equals(SettingsConstants.SETTINGS_CUSTOMIZE_TOOLBAR_QUICK_COLOR_USE_COUNT)) {
                        return;
                    }
                    break;
                case 2112474759:
                    if (!str.equals(SettingsConstants.SETTINGS_CUSTOMIZE_TOOLBAR_QUICK_SIZE_USE_COUNT)) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            customToolbarPresenter.visibleToolbarList = customToolbarPresenter.getToolbarItemOrderFromSharedPreferences(false);
            customToolbarPresenter.hiddenToolbarList = customToolbarPresenter.getToolbarItemOrderFromSharedPreferences(true);
            CustomToolbarView customToolbarView = customToolbarPresenter.customToolbarView;
            if (customToolbarView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("customToolbarView");
                customToolbarView = null;
            }
            customToolbarView.onSharedPreferenceChanged();
        }
    }

    private final void setQuickColorCountToSharedPreferences(int count) {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putInt(SettingsConstants.SETTINGS_CUSTOMIZE_TOOLBAR_QUICK_COLOR_USE_COUNT, count);
    }

    private final void setQuickSizeCountToSharedPreferences(int count) {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putInt(SettingsConstants.SETTINGS_CUSTOMIZE_TOOLBAR_QUICK_SIZE_USE_COUNT, count);
    }

    @NotNull
    public final List<String> getDefaultToolbarList() {
        return (List) this.defaultToolbarList.getValue();
    }

    @NotNull
    public final List<String> getHiddenToolbarList() {
        return this.hiddenToolbarList;
    }

    public final int getQuickColorCount() {
        return getQuickColorCountFromSharedPreferences();
    }

    public final int getQuickSizeCount() {
        return getQuickSizeCountFromSharedPreferences();
    }

    @NotNull
    public final SupportList getSupportList() {
        boolean zIsSupported = RecognitionUtil.isSupported(this.activity);
        return new SupportList(zIsSupported, ComposerSpenUtils.canUseSpen(this.activity) && zIsSupported, FeatureInfo.isEnabledEasyWritingPad(this.activity), FeatureInfo.isHandwritingHelpEnabled(this.activity));
    }

    @NotNull
    public final List<String> getToolbarDisplayList() {
        List listPlus = CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) this.visibleToolbarList, (Iterable) CollectionsKt.listOf(CustomToolbarView.DELETION_MARKER)), (Iterable) this.hiddenToolbarList);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listPlus) {
            String str = (String) obj;
            if (getDefaultToolbarList().contains(str) || Intrinsics.areEqual(str, CustomToolbarView.DELETION_MARKER)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<String> getVisibleToolbarList() {
        return this.visibleToolbarList;
    }

    public final void insertSAStatusLogging() {
        Iterator<String> it = this.visibleToolbarList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            String str = CustomToolbarItem.INSTANCE.getItemMapForSALogging().get(next);
            String str2 = str != null ? str : "";
            if (str2.length() == 0) {
                MainLogger.m7254d(TAG, "insertSAStatusLogging# There is no SA Logging Definition for \"" + next + "\"");
            } else {
                CommonSamsungAnalytics.INSTANCE.insertLog("234", str2, "a");
            }
        }
        for (String str3 : this.hiddenToolbarList) {
            String str4 = CustomToolbarItem.INSTANCE.getItemMapForSALogging().get(str3);
            if (str4 == null) {
                str4 = "";
            }
            if (str4.length() == 0) {
                MainLogger.m7254d(TAG, "insertSAStatusLogging# There is no SA Logging Definition for \"" + str3 + "\"");
            } else {
                CommonSamsungAnalytics.INSTANCE.insertLog("234", str4, "b");
            }
        }
    }

    public final void invalidateOptionsMenu() {
        this.activity.invalidateOptionsMenu();
    }

    public final boolean isTabletLayout() {
        return this.contract.isTabletLayout();
    }

    public final void onPause() {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.prefListener;
        if (onSharedPreferenceChangeListener != null) {
            SettingToolbarPreferenceUtils.INSTANCE.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    public final void onResume() {
        if (this.prefListener == null) {
            this.prefListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 0);
        }
        SettingToolbarPreferenceUtils settingToolbarPreferenceUtils = SettingToolbarPreferenceUtils.INSTANCE;
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.prefListener;
        Intrinsics.checkNotNull(onSharedPreferenceChangeListener);
        settingToolbarPreferenceUtils.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public final void reset() {
        SettingToolbarPreferenceUtils.saveToolbarList(getDefaultToolbarList(), CollectionsKt.emptyList());
        SettingToolbarPreferenceUtils.setDefaultQuickColorCountValue();
        SettingToolbarPreferenceUtils.setDefaultQuickSizeCountValue();
        CustomToolbarView customToolbarView = this.customToolbarView;
        if (customToolbarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbarView");
            customToolbarView = null;
        }
        customToolbarView.reset();
    }

    public final void saveOrderList() {
        SettingToolbarPreferenceUtils.saveToolbarList(this.visibleToolbarList, this.hiddenToolbarList);
    }

    public final void setHiddenToolbarList(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.hiddenToolbarList = list;
    }

    public final void setQuickColorCount(int i) {
        setQuickColorCountToSharedPreferences(i);
    }

    public final void setQuickSizeCount(int i) {
        setQuickSizeCountToSharedPreferences(i);
    }

    public final void setView(@NotNull CustomToolbarView customToolbarView) {
        Intrinsics.checkNotNullParameter(customToolbarView, "customToolbarView");
        this.customToolbarView = customToolbarView;
    }

    public final void setVisibleToolbarList(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.visibleToolbarList = list;
    }
}
