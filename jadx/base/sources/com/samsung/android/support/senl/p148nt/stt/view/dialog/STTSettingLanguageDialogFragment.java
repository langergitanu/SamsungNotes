package com.samsung.android.support.senl.p148nt.stt.view.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.common.C8878a;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.STTLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.base.listener.ChooseLanguageDialogListener;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.common.constant.STTConstant;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.STTSettingLanguageDialogFragment;
import com.samsung.android.support.senl.p148nt.stt.view.language.LanguageInfo;
import com.samsung.android.support.senl.p148nt.stt.view.language.STTLanguageManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 62\u00020\u0001:\u0003456B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u0010J\b\u0010$\u001a\u00020\u001cH\u0004J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020)H\u0004J\b\u0010*\u001a\u00020\u001cH\u0002J\b\u0010+\u001a\u00020\u001cH\u0016J\b\u0010,\u001a\u00020\u001cH\u0016J\b\u0010-\u001a\u00020\u001cH\u0002J\b\u0010.\u001a\u00020\u001cH\u0002J\b\u0010/\u001a\u00020\u001cH\u0002J\u0010\u00100\u001a\u00020\u001c2\b\u00101\u001a\u0004\u0018\u00010\u000bJ\b\u00102\u001a\u00020\u001cH\u0002J\b\u00103\u001a\u00020\u001cH\u0002R\u0014\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "mLanguageAdapter", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment$LanguageAdapter;", "mView", "Landroid/view/View;", "mDownloadedList", "Landroidx/recyclerview/widget/RecyclerView;", "value", "", "selectedLocale", "getSelectedLocale", "()Ljava/lang/String;", "mChooseLanguageDialogListener", "Lcom/samsung/android/support/senl/nt/stt/base/listener/ChooseLanguageDialogListener;", "mSTTLanguageManager", "Lcom/samsung/android/support/senl/nt/stt/view/language/STTLanguageManager;", "mDownloadedLocaleList", "", "mMoreLanguage", "getMMoreLanguage", "()Landroid/view/View;", "setMMoreLanguage", "(Landroid/view/View;)V", "mRecentList", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "", "outState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "setDialogListener", "chooseLanguageDialogListener", "initMoreLanguageLayout", "setMoreLanguageVisibility", "visibility", "", "createAlertDialog", "Landroidx/appcompat/app/AlertDialog;", "init", "onResume", "onDestroyView", "updateRecentUsedList", "updateLanguageList", "addDivider", "addRecentUsedList", "toLanguageTag", "enableConvertButton", "disableConvertButton", "LanguageAdapter", "AdapterContract", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSTTSettingLanguageDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 STTSettingLanguageDialogFragment.kt\ncom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,410:1\n739#2,9:411\n1056#2:424\n37#3:420\n36#3,3:421\n*S KotlinDebug\n*F\n+ 1 STTSettingLanguageDialogFragment.kt\ncom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment\n*L\n190#1:411,9\n194#1:424\n191#1:420\n191#1:421,3\n*E\n"})
public final class STTSettingLanguageDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String DIVIDER = "_DIVIDER";
    private static final int RECENT_MAX_COUNT = 5;

    @NotNull
    private static final String TAG = "STTSettingLanguageDialogFragment";

    @Nullable
    private ChooseLanguageDialogListener mChooseLanguageDialogListener;

    @Nullable
    private RecyclerView mDownloadedList;

    @NotNull
    private final List<String> mDownloadedLocaleList = new ArrayList();

    @Nullable
    private LanguageAdapter mLanguageAdapter;

    @Nullable
    private View mMoreLanguage;

    @Nullable
    private List<String> mRecentList;

    @Nullable
    private STTLanguageManager mSTTLanguageManager;

    @Nullable
    private View mView;

    @Nullable
    private String selectedLocale;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment$AdapterContract;", "", "onSelectItem", "", "position", "", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface AdapterContract {
        void onSelectItem(int position);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "RECENT_MAX_COUNT", "", "DIVIDER", "getDIVIDER", "()Ljava/lang/String;", "setDIVIDER", "(Ljava/lang/String;)V", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getDIVIDER() {
            return STTSettingLanguageDialogFragment.DIVIDER;
        }

        public final void setDIVIDER(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            STTSettingLanguageDialogFragment.DIVIDER = str;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u000f\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\fJ \u0010\u0012\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00102\u000e\u0010\u0018\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0016H\u0017J\b\u0010\u001a\u001a\u00020\u0016H\u0016R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment$LanguageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment$LanguageAdapter$ViewHolder;", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment;", "<init>", "(Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment;)V", "value", "", "selectedLanguageLocale", "getSelectedLanguageLocale", "()Ljava/lang/String;", "mLanguageLocaleList", "", "mCheckedRadioButton", "Landroid/widget/RadioButton;", "setLanguageList", "", "languageLocaleList", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "viewHolder", "position", "getItemCount", "ViewHolder", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class LanguageAdapter extends RecyclerView.Adapter<ViewHolder> {

        @Nullable
        private RadioButton mCheckedRadioButton;

        @Nullable
        private List<String> mLanguageLocaleList;

        @Nullable
        private String selectedLanguageLocale;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment$LanguageAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "mAdapterContract", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment$AdapterContract;", "<init>", "(Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment$LanguageAdapter;Landroid/view/View;Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment$AdapterContract;)V", "getMAdapterContract", "()Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment$AdapterContract;", "setMAdapterContract", "(Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTSettingLanguageDialogFragment$AdapterContract;)V", "mSelectLanguageLayout", "Landroid/widget/LinearLayout;", "getMSelectLanguageLayout", "()Landroid/widget/LinearLayout;", "setMSelectLanguageLayout", "(Landroid/widget/LinearLayout;)V", "mSelectLanguageRadioButton", "Landroid/widget/RadioButton;", "getMSelectLanguageRadioButton", "()Landroid/widget/RadioButton;", "setMSelectLanguageRadioButton", "(Landroid/widget/RadioButton;)V", "mLanguageName", "Landroid/widget/TextView;", "getMLanguageName", "()Landroid/widget/TextView;", "setMLanguageName", "(Landroid/widget/TextView;)V", "mDivider", "getMDivider", "()Landroid/view/View;", "setMDivider", "(Landroid/view/View;)V", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public final class ViewHolder extends RecyclerView.ViewHolder {

            @Nullable
            private AdapterContract mAdapterContract;

            @NotNull
            private View mDivider;

            @NotNull
            private TextView mLanguageName;

            @NotNull
            private LinearLayout mSelectLanguageLayout;

            @Nullable
            private RadioButton mSelectLanguageRadioButton;
            final /* synthetic */ LanguageAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(@NotNull final LanguageAdapter languageAdapter, @Nullable View itemView, AdapterContract adapterContract) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = languageAdapter;
                this.mAdapterContract = adapterContract;
                View viewFindViewById = itemView.findViewById(C11493R.id.item_select_language_layout);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                this.mSelectLanguageLayout = (LinearLayout) viewFindViewById;
                this.mSelectLanguageRadioButton = (RadioButton) itemView.findViewById(C11493R.id.select_language_radio_button);
                View viewFindViewById2 = itemView.findViewById(C11493R.id.language_name);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.mLanguageName = (TextView) viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(C11493R.id.item_divider);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                this.mDivider = viewFindViewById3;
                this.mSelectLanguageLayout.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        STTSettingLanguageDialogFragment.LanguageAdapter.ViewHolder._init_$lambda$0(languageAdapter, this, view);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void _init_$lambda$0(LanguageAdapter languageAdapter, ViewHolder viewHolder, View view) {
                if (languageAdapter.mCheckedRadioButton != null) {
                    RadioButton radioButton = languageAdapter.mCheckedRadioButton;
                    Intrinsics.checkNotNull(radioButton);
                    radioButton.setChecked(false);
                }
                RadioButton radioButton2 = viewHolder.mSelectLanguageRadioButton;
                if (radioButton2 != null) {
                    Intrinsics.checkNotNull(radioButton2);
                    radioButton2.setChecked(true);
                    languageAdapter.mCheckedRadioButton = viewHolder.mSelectLanguageRadioButton;
                }
                AdapterContract adapterContract = viewHolder.mAdapterContract;
                if (adapterContract != null) {
                    Intrinsics.checkNotNull(adapterContract);
                    adapterContract.onSelectItem(viewHolder.getAbsoluteAdapterPosition());
                }
            }

            @Nullable
            public final AdapterContract getMAdapterContract() {
                return this.mAdapterContract;
            }

            @NotNull
            public final View getMDivider() {
                return this.mDivider;
            }

            @NotNull
            public final TextView getMLanguageName() {
                return this.mLanguageName;
            }

            @NotNull
            public final LinearLayout getMSelectLanguageLayout() {
                return this.mSelectLanguageLayout;
            }

            @Nullable
            public final RadioButton getMSelectLanguageRadioButton() {
                return this.mSelectLanguageRadioButton;
            }

            public final void setMAdapterContract(@Nullable AdapterContract adapterContract) {
                this.mAdapterContract = adapterContract;
            }

            public final void setMDivider(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "<set-?>");
                this.mDivider = view;
            }

            public final void setMLanguageName(@NotNull TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.mLanguageName = textView;
            }

            public final void setMSelectLanguageLayout(@NotNull LinearLayout linearLayout) {
                Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
                this.mSelectLanguageLayout = linearLayout;
            }

            public final void setMSelectLanguageRadioButton(@Nullable RadioButton radioButton) {
                this.mSelectLanguageRadioButton = radioButton;
            }
        }

        public LanguageAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<String> list = this.mLanguageLocaleList;
            if (list == null) {
                return 0;
            }
            Intrinsics.checkNotNull(list);
            return list.size();
        }

        @Nullable
        public final String getSelectedLanguageLocale() {
            return this.selectedLanguageLocale;
        }

        public final void setLanguageList(@Nullable String selectedLanguageLocale, @Nullable List<String> languageLocaleList) {
            this.selectedLanguageLocale = selectedLanguageLocale;
            this.mLanguageLocaleList = languageLocaleList;
            notifyDataSetChanged();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0099  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @SuppressLint({"RecyclerView"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onBindViewHolder(@NotNull ViewHolder viewHolder, int position) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            List<String> list = this.mLanguageLocaleList;
            Intrinsics.checkNotNull(list);
            if (list.get(position) == null) {
                return;
            }
            String divider = STTSettingLanguageDialogFragment.INSTANCE.getDIVIDER();
            List<String> list2 = this.mLanguageLocaleList;
            Intrinsics.checkNotNull(list2);
            if (Intrinsics.areEqual(divider, list2.get(position))) {
                viewHolder.getMSelectLanguageLayout().setVisibility(8);
                viewHolder.getMDivider().setVisibility(0);
                return;
            }
            viewHolder.getMDivider().setVisibility(8);
            viewHolder.getMSelectLanguageLayout().setVisibility(0);
            STTLanguageManager companion = STTLanguageManager.INSTANCE.getInstance();
            Intrinsics.checkNotNull(companion);
            List<String> list3 = this.mLanguageLocaleList;
            Intrinsics.checkNotNull(list3);
            LanguageInfo languageInfo = companion.getLanguageInfo(list3.get(position));
            List<String> list4 = this.mLanguageLocaleList;
            Intrinsics.checkNotNull(list4);
            String languageDisplayName = companion.getLanguageDisplayName(list4.get(position));
            viewHolder.getMLanguageName().setText(languageDisplayName);
            String str = this.selectedLanguageLocale;
            if (str != null) {
                List<String> list5 = this.mLanguageLocaleList;
                Intrinsics.checkNotNull(list5);
                if (Intrinsics.areEqual(str, list5.get(position))) {
                    RadioButton mSelectLanguageRadioButton = viewHolder.getMSelectLanguageRadioButton();
                    Intrinsics.checkNotNull(mSelectLanguageRadioButton);
                    mSelectLanguageRadioButton.setChecked(true);
                    this.mCheckedRadioButton = viewHolder.getMSelectLanguageRadioButton();
                } else {
                    RadioButton mSelectLanguageRadioButton2 = viewHolder.getMSelectLanguageRadioButton();
                    Intrinsics.checkNotNull(mSelectLanguageRadioButton2);
                    mSelectLanguageRadioButton2.setChecked(false);
                }
            }
            if (languageInfo != null) {
                viewHolder.getMSelectLanguageLayout().setContentDescription(languageInfo.getLanguageDescription());
            } else {
                viewHolder.getMSelectLanguageLayout().setContentDescription(languageDisplayName);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(C11493R.layout.stt_select_language_dialog_item, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            final STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment = STTSettingLanguageDialogFragment.this;
            return new ViewHolder(this, viewInflate, new AdapterContract() { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.STTSettingLanguageDialogFragment$LanguageAdapter$onCreateViewHolder$1
                @Override // com.samsung.android.support.senl.nt.stt.view.dialog.STTSettingLanguageDialogFragment.AdapterContract
                public void onSelectItem(int position) {
                    STTSettingLanguageDialogFragment.LanguageAdapter languageAdapter = this.this$0;
                    List list = languageAdapter.mLanguageLocaleList;
                    Intrinsics.checkNotNull(list);
                    languageAdapter.selectedLanguageLocale = (String) list.get(position);
                    sTTSettingLanguageDialogFragment.selectedLocale = this.this$0.getSelectedLanguageLocale();
                    Logger.m12710d("STTSettingLanguageDialogFragment", "onClick(). selectedLanguage : " + this.this$0.getSelectedLanguageLocale());
                    sTTSettingLanguageDialogFragment.enableConvertButton();
                }
            });
        }
    }

    private final void addDivider() {
        List<String> list = this.mDownloadedLocaleList;
        List<String> list2 = this.mRecentList;
        Intrinsics.checkNotNull(list2);
        list.add(list2.size(), DIVIDER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAlertDialog$lambda$1(STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        ChooseLanguageDialogListener chooseLanguageDialogListener = sTTSettingLanguageDialogFragment.mChooseLanguageDialogListener;
        if (chooseLanguageDialogListener != null) {
            Intrinsics.checkNotNull(chooseLanguageDialogListener);
            chooseLanguageDialogListener.onDialogClickCancelButton();
        }
        NotesSamsungAnalytics.INSTANCE.insertLog("816", STTConstant.EVENT_TRANSCRIBE_DIALOG_CANCEL_BTN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAlertDialog$lambda$2(STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment, DialogInterface dialogInterface, int i) {
        Logger.m12713i(TAG, "onClick(). transcribeButton - selectedLocale = " + sTTSettingLanguageDialogFragment.selectedLocale);
        String languageTag = Locale.getDefault().toLanguageTag();
        String defaultLocaleTag = STTLanguageHelper.getDefaultLocaleTag();
        ChooseLanguageDialogListener chooseLanguageDialogListener = sTTSettingLanguageDialogFragment.mChooseLanguageDialogListener;
        if (chooseLanguageDialogListener != null) {
            Intrinsics.checkNotNull(chooseLanguageDialogListener);
            chooseLanguageDialogListener.onDialogClickConvertButton();
            STTLanguageHelper.setDefaultLocaleTag(sTTSettingLanguageDialogFragment.selectedLocale);
            sTTSettingLanguageDialogFragment.addRecentUsedList(sTTSettingLanguageDialogFragment.selectedLocale);
        }
        NotesSamsungAnalytics.Companion companion = NotesSamsungAnalytics.INSTANCE;
        companion.insertLog("816", STTConstant.EVENT_TRANSCRIBE_DIALOG_TRANSCRIBE_BTN, sTTSettingLanguageDialogFragment.selectedLocale);
        companion.insertLog("816", STTConstant.EVENT_TRANSCRIBE_DIALOG_TRANSCRIBE_BTN, "b", Intrinsics.areEqual(sTTSettingLanguageDialogFragment.selectedLocale, languageTag) ? 1L : 0L);
        companion.insertLog("816", STTConstant.EVENT_TRANSCRIBE_DIALOG_TRANSCRIBE_BTN, "c", Intrinsics.areEqual(sTTSettingLanguageDialogFragment.selectedLocale, defaultLocaleTag) ? 1L : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAlertDialog$lambda$3(AlertDialog alertDialog, DialogInterface dialogInterface) {
        Button button = alertDialog.getButton(-1);
        ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.weight = 1.0f;
        layoutParams2.width = -1;
        button.setLayoutParams(layoutParams2);
        Button button2 = alertDialog.getButton(-2);
        ViewGroup.LayoutParams layoutParams3 = button2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
        layoutParams4.weight = 1.0f;
        layoutParams4.width = -1;
        button2.setLayoutParams(layoutParams4);
        button.invalidate();
        button2.invalidate();
    }

    private final void disableConvertButton() {
        AlertDialog alertDialog = (AlertDialog) getDialog();
        if (alertDialog != null) {
            alertDialog.getButton(-1).setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableConvertButton() {
        AlertDialog alertDialog = (AlertDialog) getDialog();
        if (alertDialog != null) {
            alertDialog.getButton(-1).setEnabled(true);
        }
    }

    private final void init() {
        STTLanguageManager companion = STTLanguageManager.INSTANCE.getInstance();
        this.mSTTLanguageManager = companion;
        Intrinsics.checkNotNull(companion);
        companion.initLanguageData();
        this.mDownloadedLocaleList.clear();
        List<String> list = this.mDownloadedLocaleList;
        STTLanguageManager sTTLanguageManager = this.mSTTLanguageManager;
        Intrinsics.checkNotNull(sTTLanguageManager);
        List<String> downloadedLocaleList = sTTLanguageManager.getDownloadedLocaleList();
        Intrinsics.checkNotNull(downloadedLocaleList);
        list.addAll(downloadedLocaleList);
        CollectionsKt.sortWith(this.mDownloadedLocaleList, new C8878a(new C11561g(this, 0), 2));
        STTLanguageManager sTTLanguageManager2 = this.mSTTLanguageManager;
        Intrinsics.checkNotNull(sTTLanguageManager2);
        setMoreLanguageVisibility(sTTLanguageManager2.isMoreLanguageAvailable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int init$lambda$4(STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment, String str, String str2) {
        STTLanguageManager sTTLanguageManager = sTTSettingLanguageDialogFragment.mSTTLanguageManager;
        Intrinsics.checkNotNull(sTTLanguageManager);
        String languageDisplayName = sTTLanguageManager.getLanguageDisplayName(str);
        STTLanguageManager sTTLanguageManager2 = sTTSettingLanguageDialogFragment.mSTTLanguageManager;
        Intrinsics.checkNotNull(sTTLanguageManager2);
        return languageDisplayName.compareTo(sTTLanguageManager2.getLanguageDisplayName(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int init$lambda$5(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMoreLanguageLayout$lambda$0(STTSettingLanguageDialogFragment sTTSettingLanguageDialogFragment, View view) {
        Logger.m12710d(TAG, "onClick(). addLanguage");
        ChooseLanguageDialogListener chooseLanguageDialogListener = sTTSettingLanguageDialogFragment.mChooseLanguageDialogListener;
        if (chooseLanguageDialogListener != null) {
            Intrinsics.checkNotNull(chooseLanguageDialogListener);
            chooseLanguageDialogListener.onDialogClickAddLanguageButton();
        }
        NotesSamsungAnalytics.INSTANCE.insertLog("816", STTConstant.EVENT_TRANSCRIBE_DIALOG_ADD_LANGUAGES_BTN);
    }

    private final void setMoreLanguageVisibility(boolean visibility) {
        if (visibility) {
            View view = this.mMoreLanguage;
            Intrinsics.checkNotNull(view);
            view.setVisibility(0);
        } else {
            View view2 = this.mMoreLanguage;
            Intrinsics.checkNotNull(view2);
            view2.setVisibility(8);
        }
    }

    private final void updateLanguageList() {
        String defaultLocaleTag = STTLanguageHelper.getDefaultLocaleTag();
        this.selectedLocale = defaultLocaleTag;
        if (defaultLocaleTag != null) {
            STTLanguageManager companion = STTLanguageManager.INSTANCE.getInstance();
            Intrinsics.checkNotNull(companion);
            LanguageInfo languageInfo = companion.getLanguageInfo(this.selectedLocale);
            if (languageInfo != null && companion.isLangPackInstalled(languageInfo.getLangPackage())) {
                enableConvertButton();
                return;
            }
            this.selectedLocale = null;
        }
        disableConvertButton();
    }

    private final void updateRecentUsedList() {
        List listEmptyList;
        this.mRecentList = new ArrayList();
        Set recentLanguageSet = STTLanguageHelper.getRecentLanguageSet();
        ArrayList arrayList = new ArrayList();
        if (recentLanguageSet == null) {
            Logger.m12713i(TAG, "updateRecentUsedList: invitations size empty");
            recentLanguageSet = new HashSet();
        }
        Iterator it = recentLanguageSet.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            List listM13999t = AbstractC12991c.m13999t(0, ContentUtils.HASH_SYMBOL, (String) it.next());
            if (listM13999t.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            }
            String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
            arrayList.add(new Pair(Integer.valueOf(Integer.parseInt(strArr[1])), strArr[0]));
        }
        CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.STTSettingLanguageDialogFragment$updateRecentUsedList$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Integer) ((Pair) t).first, (Integer) ((Pair) t2).first);
            }
        });
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) ((Pair) arrayList.get(i)).second;
            Iterator<String> it2 = this.mDownloadedLocaleList.iterator();
            int i2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i2 = -1;
                    break;
                }
                String next = it2.next();
                if (!TextUtils.isEmpty(next) && !Intrinsics.areEqual(DIVIDER, next) && Intrinsics.areEqual(next, str)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                Logger.m12713i(TAG, "updateRecentUsedList: mRecentList add = " + str);
                this.mDownloadedLocaleList.remove(i2);
                List<String> list = this.mRecentList;
                Intrinsics.checkNotNull(list);
                List<String> list2 = this.mRecentList;
                Intrinsics.checkNotNull(list2);
                list.add(list2.size(), str);
            }
        }
        updateLanguageList();
        String defaultLocaleTag = STTLanguageHelper.getDefaultLocaleTag();
        if (defaultLocaleTag != null) {
            STTLanguageManager companion = STTLanguageManager.INSTANCE.getInstance();
            Intrinsics.checkNotNull(companion);
            LanguageInfo languageInfo = companion.getLanguageInfo(defaultLocaleTag);
            boolean z = languageInfo != null && companion.isLangPackInstalled(languageInfo.getLangPackage());
            if (!this.mDownloadedLocaleList.isEmpty() && z) {
                addRecentUsedList(defaultLocaleTag);
                this.mDownloadedLocaleList.remove(defaultLocaleTag);
            }
        }
        List<String> list3 = this.mRecentList;
        Intrinsics.checkNotNull(list3);
        if (!list3.isEmpty()) {
            if (this.mDownloadedLocaleList.isEmpty()) {
                List<String> list4 = this.mDownloadedLocaleList;
                List<String> list5 = this.mRecentList;
                Intrinsics.checkNotNull(list5);
                list4.addAll(list5);
            } else {
                List<String> list6 = this.mDownloadedLocaleList;
                List<String> list7 = this.mRecentList;
                Intrinsics.checkNotNull(list7);
                list6.addAll(0, list7);
            }
            addDivider();
        }
        if (this.mDownloadedLocaleList.isEmpty()) {
            RecyclerView recyclerView = this.mDownloadedList;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.setVisibility(8);
        } else {
            RecyclerView recyclerView2 = this.mDownloadedList;
            Intrinsics.checkNotNull(recyclerView2);
            recyclerView2.setVisibility(0);
        }
        LanguageAdapter languageAdapter = this.mLanguageAdapter;
        Intrinsics.checkNotNull(languageAdapter);
        languageAdapter.setLanguageList(this.selectedLocale, this.mDownloadedLocaleList);
        List<String> list8 = this.mRecentList;
        Intrinsics.checkNotNull(list8);
        AbstractC11014a.m12327l(list8.size(), "updateRecentUsedList: mRecentList size = ", TAG);
    }

    public final void addRecentUsedList(@Nullable String toLanguageTag) {
        if (toLanguageTag == null) {
            return;
        }
        if (this.mRecentList == null) {
            this.mRecentList = new ArrayList();
        }
        List<String> list = this.mRecentList;
        Intrinsics.checkNotNull(list);
        list.remove(toLanguageTag);
        List<String> list2 = this.mRecentList;
        Intrinsics.checkNotNull(list2);
        list2.add(0, toLanguageTag);
        List<String> list3 = this.mRecentList;
        Intrinsics.checkNotNull(list3);
        int size = list3.size();
        HashSet hashSet = new HashSet();
        int iMin = (int) Math.min(5.0d, size);
        for (int i = 0; i < iMin; i++) {
            List<String> list4 = this.mRecentList;
            Intrinsics.checkNotNull(list4);
            hashSet.add(((Object) list4.get(i)) + ContentUtils.HASH_SYMBOL + i);
        }
        Logger.m12713i(TAG, "addRecentUsedList: mRecentList size = " + hashSet.size() + " " + toLanguageTag);
        STTLanguageHelper.setRecentLanguageSet(hashSet);
    }

    @NotNull
    public final AlertDialog createAlertDialog() {
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext(), 0, 2, null).create();
        alertDialogCreate.setTitle(C11493R.string.stt_select_language_title);
        alertDialogCreate.setView(this.mView);
        final int i = 0;
        alertDialogCreate.setButton(-2, getString(C11493R.string.dialog_cancel), new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.f

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ STTSettingLanguageDialogFragment f7936b;

            {
                this.f7936b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                switch (i) {
                    case 0:
                        STTSettingLanguageDialogFragment.createAlertDialog$lambda$1(this.f7936b, dialogInterface, i2);
                        break;
                    default:
                        STTSettingLanguageDialogFragment.createAlertDialog$lambda$2(this.f7936b, dialogInterface, i2);
                        break;
                }
            }
        });
        final int i2 = 1;
        alertDialogCreate.setButton(-1, getString(C11493R.string.stt_transcribe_btn), new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.f

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ STTSettingLanguageDialogFragment f7936b;

            {
                this.f7936b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i22) {
                switch (i2) {
                    case 0:
                        STTSettingLanguageDialogFragment.createAlertDialog$lambda$1(this.f7936b, dialogInterface, i22);
                        break;
                    default:
                        STTSettingLanguageDialogFragment.createAlertDialog$lambda$2(this.f7936b, dialogInterface, i22);
                        break;
                }
            }
        });
        alertDialogCreate.setOnShowListener(new DialogInterfaceOnShowListenerC11559e(alertDialogCreate, 1));
        return alertDialogCreate;
    }

    @Nullable
    public final View getMMoreLanguage() {
        return this.mMoreLanguage;
    }

    @Nullable
    public final String getSelectedLocale() {
        return this.selectedLocale;
    }

    public final void initMoreLanguageLayout() {
        View view = this.mView;
        View viewFindViewById = view != null ? view.findViewById(C11493R.id.add_language_layout) : null;
        this.mMoreLanguage = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new ViewOnClickListenerC8556a(this, 28));
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View viewInflate = View.inflate(getContext(), C11493R.layout.stt_language_setting, null);
        this.mView = viewInflate;
        RecyclerView recyclerView = viewInflate != null ? (RecyclerView) viewInflate.findViewById(C11493R.id.language_recyclerview_layout) : null;
        this.mDownloadedList = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        LanguageAdapter languageAdapter = new LanguageAdapter();
        this.mLanguageAdapter = languageAdapter;
        RecyclerView recyclerView2 = this.mDownloadedList;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(languageAdapter);
        }
        initMoreLanguageLayout();
        return createAlertDialog();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.mView != null) {
            this.mView = null;
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        init();
        updateRecentUsedList();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
    }

    public final void setDialogListener(@Nullable ChooseLanguageDialogListener chooseLanguageDialogListener) {
        this.mChooseLanguageDialogListener = chooseLanguageDialogListener;
    }

    public final void setMMoreLanguage(@Nullable View view) {
        this.mMoreLanguage = view;
    }
}
