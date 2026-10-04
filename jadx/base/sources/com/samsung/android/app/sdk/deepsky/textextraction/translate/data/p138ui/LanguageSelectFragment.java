package com.samsung.android.app.sdk.deepsky.textextraction.translate.data.p138ui;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackManager;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LanguageUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.OnDeviceLanguage;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util.DrawUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;
import p071Q2.ViewOnClickListenerC0219a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 .2\u00020\u0001:\u0001.B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010\u00182\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ui/LanguageSelectFragment;", "Landroidx/fragment/app/DialogFragment;", "context", "Landroid/content/Context;", "langPackManager", "Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LangPackManager;", "isSourceLanguageSelection", "", "currentSelectedLanguage", "", "recentlyUsedLanguages", "", "onLanguageSelectListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ui/LanguageSelectListener;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LangPackManager;ZLjava/lang/String;Ljava/util/List;Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ui/LanguageSelectListener;)V", "languageColorStateList", "Landroid/content/res/ColorStateList;", "selectableLanguageGroup", "Landroid/widget/LinearLayout;", "selectedLanguage", "Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/OnDeviceLanguage;", "addAddLanguageButton", "", "view", "Landroid/view/View;", "addAutoAndRecentlyUsedLanguages", "addCancelAndActionButtons", "addDivider", "addInstalledLanguages", "checkSelectedLanguage", "createLanguageRadioButton", "lang", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "setContent", "setLanguageSelectHeading", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLanguageSelectFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LanguageSelectFragment.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ui/LanguageSelectFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,202:1\n1549#2:203\n1620#2,3:204\n800#2,11:207\n1549#2:218\n1620#2,3:219\n766#2:222\n857#2,2:223\n1855#2,2:225\n*S KotlinDebug\n*F\n+ 1 LanguageSelectFragment.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ui/LanguageSelectFragment\n*L\n142#1:203\n142#1:204,3\n144#1:207,11\n144#1:218\n144#1:219,3\n146#1:222\n146#1:223,2\n148#1:225,2\n*E\n"})
public final class LanguageSelectFragment extends DialogFragment {

    @NotNull
    private static final String TAG = "LanguageSelectFragment";

    @NotNull
    private final Context context;

    @NotNull
    private final String currentSelectedLanguage;
    private final boolean isSourceLanguageSelection;

    @NotNull
    private final LangPackManager langPackManager;

    @NotNull
    private final ColorStateList languageColorStateList;

    @Nullable
    private final LanguageSelectListener onLanguageSelectListener;

    @NotNull
    private final List<String> recentlyUsedLanguages;

    @Nullable
    private LinearLayout selectableLanguageGroup;

    @Nullable
    private OnDeviceLanguage selectedLanguage;

    public LanguageSelectFragment(@NotNull Context context, @NotNull LangPackManager langPackManager, boolean z, @NotNull String currentSelectedLanguage, @NotNull List<String> recentlyUsedLanguages, @Nullable LanguageSelectListener languageSelectListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(langPackManager, "langPackManager");
        Intrinsics.checkNotNullParameter(currentSelectedLanguage, "currentSelectedLanguage");
        Intrinsics.checkNotNullParameter(recentlyUsedLanguages, "recentlyUsedLanguages");
        this.context = context;
        this.langPackManager = langPackManager;
        this.isSourceLanguageSelection = z;
        this.currentSelectedLanguage = currentSelectedLanguage;
        this.recentlyUsedLanguages = recentlyUsedLanguages;
        this.onLanguageSelectListener = languageSelectListener;
        this.languageColorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[]{-16842912}}, new int[]{context.getColor(C7039R.color.lang_select_checked_button_color), context.getColor(C7039R.color.lang_select_unchecked_button_color)});
    }

    private final void addAddLanguageButton(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C7039R.id.lang_select_add_languages_button);
        linearLayout.setOnClickListener(new ViewOnClickListenerC0157a(linearLayout, 15));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addAddLanguageButton$lambda$6$lambda$5(LinearLayout linearLayout, View view) {
        Intent intent = new Intent("com.samsung.android.settings.action.LANGUAGE_PACK_SETTINGS");
        intent.putExtra("package", linearLayout.getContext().getPackageName());
        linearLayout.getContext().startActivity(intent);
    }

    private final void addAutoAndRecentlyUsedLanguages() {
        LinearLayout linearLayout;
        if (this.isSourceLanguageSelection && (linearLayout = this.selectableLanguageGroup) != null) {
            linearLayout.addView(createLanguageRadioButton(OnDeviceLanguage.INSTANCE.getAUTO()));
        }
        Iterator<String> it = this.recentlyUsedLanguages.iterator();
        while (it.hasNext()) {
            OnDeviceLanguage onDeviceLanguage = new OnDeviceLanguage(it.next(), "", null, null, false, null, 60, null);
            LinearLayout linearLayout2 = this.selectableLanguageGroup;
            if (linearLayout2 != null) {
                linearLayout2.addView(createLanguageRadioButton(onDeviceLanguage));
            }
        }
    }

    private final void addCancelAndActionButtons(View view) {
        ((TextView) view.findViewById(C7039R.id.lang_select_cancel_text)).setOnClickListener(new ViewOnClickListenerC0157a(this, 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addCancelAndActionButtons$lambda$8$lambda$7(LanguageSelectFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectedLanguage = null;
        this$0.dismiss();
    }

    private final void addDivider() {
        LinearLayout linearLayout = this.selectableLanguageGroup;
        if (linearLayout != null) {
            View view = new View(this.context);
            view.setBackgroundResource(C7039R.drawable.line_dotted);
            DrawUtil drawUtil = DrawUtil.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, drawUtil.convertDpToPx(context, Float.valueOf(8.0f)));
            layoutParams.setMargins(view.getContext().getResources().getDimensionPixelSize(C7039R.dimen.dialog_layout_margin_horizontal), 0, view.getContext().getResources().getDimensionPixelSize(C7039R.dimen.dialog_layout_margin_horizontal), 0);
            view.setLayoutParams(layoutParams);
            linearLayout.addView(view);
        }
    }

    private final void addInstalledLanguages() {
        LinearLayout linearLayout;
        for (OnDeviceLanguage onDeviceLanguage : this.langPackManager.getAllInstalledOnDeviceLangList()) {
            if (!this.recentlyUsedLanguages.contains(onDeviceLanguage.getCode()) && (linearLayout = this.selectableLanguageGroup) != null) {
                linearLayout.addView(createLanguageRadioButton(onDeviceLanguage));
            }
        }
    }

    private final void checkSelectedLanguage() {
        LinearLayout linearLayout = this.selectableLanguageGroup;
        if (linearLayout != null) {
            IntRange intRangeUntil = RangesKt.until(0, linearLayout.getChildCount());
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(intRangeUntil));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                arrayList.add(linearLayout.getChildAt(((IntIterator) it).nextInt()));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (obj instanceof LinearLayout) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt.m13952k(arrayList2));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add((RadioButton) ((LinearLayout) it2.next()).findViewById(C7039R.id.language_item_radio_button));
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : arrayList3) {
                if (Intrinsics.areEqual(((RadioButton) obj2).getTag(), this.currentSelectedLanguage)) {
                    arrayList4.add(obj2);
                }
            }
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                ((RadioButton) it3.next()).setChecked(true);
            }
        }
    }

    private final LinearLayout createLanguageRadioButton(OnDeviceLanguage lang) {
        View viewInflate = LayoutInflater.from(this.context).inflate(C7039R.layout.language_item, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) viewInflate;
        RadioButton radioButton = (RadioButton) linearLayout.findViewById(C7039R.id.language_item_radio_button);
        radioButton.setButtonTintList(this.languageColorStateList);
        radioButton.setTag(lang.getCode());
        TextView textView = (TextView) linearLayout.findViewById(C7039R.id.radio_text);
        LanguageUtil languageUtil = LanguageUtil.INSTANCE;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setText(languageUtil.getDisplayNameFromLangCode(context, lang.getCode()));
        linearLayout.setOnClickListener(new ViewOnClickListenerC0219a(this, lang, 7));
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createLanguageRadioButton$lambda$18$lambda$17(LanguageSelectFragment this$0, OnDeviceLanguage lang, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lang, "$lang");
        this$0.selectedLanguage = lang;
        this$0.dismiss();
    }

    private final void setContent(View view) {
        this.selectableLanguageGroup = (LinearLayout) view.findViewById(C7039R.id.lang_select_group);
        setLanguageSelectHeading(view);
        addAutoAndRecentlyUsedLanguages();
        addDivider();
        addInstalledLanguages();
        checkSelectedLanguage();
        addAddLanguageButton(view);
        addCancelAndActionButtons(view);
    }

    private final void setLanguageSelectHeading(View view) {
        TextView textView = (TextView) view.findViewById(C7039R.id.lang_select_heading_text);
        textView.setText(this.isSourceLanguageSelection ? textView.getContext().getString(C7039R.string.lang_select_source_language) : textView.getContext().getString(C7039R.string.lang_select_target_language));
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = new Dialog(this.context);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.requestFeature(1);
            window.addFlags(256);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                Intrinsics.checkNotNullExpressionValue(attributes, "attributes");
                attributes.gravity = 81;
                attributes.windowAnimations = C7039R.style.DialogAnimation;
            }
        }
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(C7039R.layout.language_select_dialog, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        setContent(view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        LanguageSelectListener languageSelectListener = this.onLanguageSelectListener;
        if (languageSelectListener != null) {
            languageSelectListener.onLanguageSelected(this.selectedLanguage);
        }
        super.onDismiss(dialog);
    }
}
