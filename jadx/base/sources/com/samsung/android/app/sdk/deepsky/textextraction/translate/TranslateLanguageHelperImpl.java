package com.samsung.android.app.sdk.deepsky.textextraction.translate;

import android.content.Context;
import android.graphics.Insets;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackManager;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LanguageUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.OnDeviceLanguage;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.RecentlyUsedLanguage;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.p138ui.LanguageSelectFragment;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.p138ui.LanguageSelectListener;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p059N3.ViewOnApplyWindowInsetsListenerC0186a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 92\u00020\u0001:\u00019B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\u0010\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\fH\u0016J\b\u0010+\u001a\u00020'H\u0002J\b\u0010,\u001a\u00020'H\u0002J\b\u0010-\u001a\u00020'H\u0002J\u0010\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u0018H\u0016J\b\u00100\u001a\u00020'H\u0016J\u0010\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020$H\u0016J\b\u00103\u001a\u00020'H\u0002J\u0012\u00104\u001a\u00020'2\b\b\u0002\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020'H\u0002J\b\u00108\u001a\u00020'H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslateLanguageHelperImpl;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslateLanguageHelper;", "context", "Landroid/content/Context;", "imageTranslator", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslator;", "langPackManager", "Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LangPackManager;", "languageChangeListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/LanguageChangeListener;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslator;Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LangPackManager;Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/LanguageChangeListener;)V", "langChangeCloseButton", "Landroid/widget/LinearLayout;", "langChangeLayout", "langChangeSourceLayout", "langChangeSourceTextView", "Landroid/widget/TextView;", "langChangeSwapButton", "langChangeTargetLayout", "langChangeTargetTextView", "langCodeButton", "langCodeTextView", "langManageLayout", "layoutState", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/LayoutState;", "outerLayout", "Landroid/widget/FrameLayout;", "recentlyUsedLanguages", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/RecentlyUsedLanguage;", "sourceLangSelectFragment", "Landroidx/fragment/app/DialogFragment;", "sourceLanguage", "", "targetLangSelectFragment", "targetLanguage", "translateLanguageListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslateLanguageListener;", "getDisplaySourceLanguage", "initLangChangeLayout", "", "initLangCodeButton", "initLayout", DBSchema.DocumentThumbnail.LAYOUT, "initSourceLangChangeLayout", "initTargetLangChangeLayout", "initViewInternal", "invalidateLayout", "state", "onConfigurationChanged", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "updateLangCodeButton", "updateLanguage", "doTranslate", "", "updateSourceLanguage", "updateTargetLanguage", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTranslateLanguageHelperImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslateLanguageHelperImpl.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslateLanguageHelperImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,307:1\n1#2:308\n*E\n"})
public final class TranslateLanguageHelperImpl implements TranslateLanguageHelper {

    @NotNull
    private static final String TAG = "TranslateLanguageHelper";

    @NotNull
    private final Context context;

    @Nullable
    private final ImageTranslator imageTranslator;

    @Nullable
    private LinearLayout langChangeCloseButton;

    @Nullable
    private LinearLayout langChangeLayout;

    @Nullable
    private LinearLayout langChangeSourceLayout;

    @Nullable
    private TextView langChangeSourceTextView;

    @Nullable
    private LinearLayout langChangeSwapButton;

    @Nullable
    private LinearLayout langChangeTargetLayout;

    @Nullable
    private TextView langChangeTargetTextView;

    @Nullable
    private LinearLayout langCodeButton;

    @Nullable
    private TextView langCodeTextView;

    @Nullable
    private LinearLayout langManageLayout;

    @NotNull
    private final LangPackManager langPackManager;

    @Nullable
    private final LanguageChangeListener languageChangeListener;

    @NotNull
    private LayoutState layoutState;

    @Nullable
    private FrameLayout outerLayout;

    @NotNull
    private final RecentlyUsedLanguage recentlyUsedLanguages;

    @Nullable
    private DialogFragment sourceLangSelectFragment;

    @NotNull
    private String sourceLanguage;

    @Nullable
    private DialogFragment targetLangSelectFragment;

    @NotNull
    private String targetLanguage;

    @Nullable
    private TranslateLanguageListener translateLanguageListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutState.values().length];
            try {
                iArr[LayoutState.HIDDEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutState.LANGUAGE_CODE_BUTTON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LayoutState.LANGUAGE_CHANGE_LAYOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TranslateLanguageHelperImpl(@NotNull Context context, @Nullable ImageTranslator imageTranslator, @NotNull LangPackManager langPackManager, @Nullable LanguageChangeListener languageChangeListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(langPackManager, "langPackManager");
        this.context = context;
        this.imageTranslator = imageTranslator;
        this.langPackManager = langPackManager;
        this.languageChangeListener = languageChangeListener;
        this.sourceLanguage = LangPackConfigConstants.LANGUAGE_CODE_AUTO;
        this.targetLanguage = LanguageUtil.INSTANCE.createTargetLanguage();
        this.recentlyUsedLanguages = new RecentlyUsedLanguage(context);
        this.layoutState = LayoutState.HIDDEN;
    }

    private final String getDisplaySourceLanguage() {
        String str = this.sourceLanguage;
        ImageTranslator imageTranslator = this.imageTranslator;
        if (imageTranslator == null || !Intrinsics.areEqual(str, LangPackConfigConstants.LANGUAGE_CODE_AUTO)) {
            return str;
        }
        int detectedLanguageNumber = imageTranslator.getDetectedLanguageNumber();
        LibLogger.m5432i(TAG, "detected lang number: " + detectedLanguageNumber);
        return detectedLanguageNumber == 1 ? imageTranslator.getMostDetectedLanguage() : str;
    }

    private final void initLangChangeLayout() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        FrameLayout frameLayout = this.outerLayout;
        LinearLayout linearLayout3 = null;
        LinearLayout linearLayout4 = frameLayout != null ? (LinearLayout) frameLayout.findViewById(C7039R.id.lang_change_layout) : null;
        this.langChangeLayout = linearLayout4;
        if (linearLayout4 == null || (linearLayout = (LinearLayout) linearLayout4.findViewById(C7039R.id.lang_change_swap_button)) == null) {
            linearLayout = null;
        } else {
            linearLayout.setOnClickListener(new ViewOnClickListenerC7090a(this, 0));
            linearLayout.setContentDescription(linearLayout.getContext().getResources().getString(C7039R.string.lang_select_swap));
            linearLayout.setTooltipText(linearLayout.getContext().getResources().getString(C7039R.string.lang_select_swap));
        }
        this.langChangeSwapButton = linearLayout;
        LinearLayout linearLayout5 = this.langChangeLayout;
        if (linearLayout5 != null && (linearLayout2 = (LinearLayout) linearLayout5.findViewById(C7039R.id.lang_change_close_button)) != null) {
            linearLayout2.setOnClickListener(new ViewOnClickListenerC7090a(this, 1));
            linearLayout2.setContentDescription(linearLayout2.getContext().getResources().getString(C7039R.string.lang_select_close));
            linearLayout2.setTooltipText(linearLayout2.getContext().getResources().getString(C7039R.string.lang_select_close));
            linearLayout3 = linearLayout2;
        }
        this.langChangeCloseButton = linearLayout3;
        initSourceLangChangeLayout();
        initTargetLangChangeLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLangChangeLayout$lambda$7$lambda$6(TranslateLanguageHelperImpl this$0, View view) {
        String mostDetectedLanguage;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.sourceLanguage, LangPackConfigConstants.LANGUAGE_CODE_AUTO)) {
            ImageTranslator imageTranslator = this$0.imageTranslator;
            if (imageTranslator == null || (mostDetectedLanguage = imageTranslator.getMostDetectedLanguage()) == null) {
                mostDetectedLanguage = "en";
            }
            String str = this$0.targetLanguage;
            this$0.targetLanguage = mostDetectedLanguage;
            this$0.sourceLanguage = str;
        } else {
            String str2 = this$0.targetLanguage;
            this$0.targetLanguage = this$0.sourceLanguage;
            this$0.sourceLanguage = str2;
        }
        ImageTranslator imageTranslator2 = this$0.imageTranslator;
        if (imageTranslator2 != null) {
            imageTranslator2.removeCache();
        }
        updateLanguage$default(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLangChangeLayout$lambda$9$lambda$8(TranslateLanguageHelperImpl this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.invalidateLayout(LayoutState.LANGUAGE_CODE_BUTTON);
    }

    private final void initLangCodeButton() {
        LinearLayout linearLayout;
        FrameLayout frameLayout = this.outerLayout;
        if (frameLayout == null || (linearLayout = (LinearLayout) frameLayout.findViewById(C7039R.id.lang_code_button)) == null) {
            linearLayout = null;
        } else {
            int i = 2;
            linearLayout.setOnClickListener(new ViewOnClickListenerC7090a(this, i));
            linearLayout.setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC0186a(linearLayout, i));
            linearLayout.requestApplyInsets();
        }
        this.langCodeButton = linearLayout;
        this.langCodeTextView = linearLayout != null ? (TextView) linearLayout.findViewById(C7039R.id.lang_code_text) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLangCodeButton$lambda$3$lambda$0(TranslateLanguageHelperImpl this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TranslateLanguageListener translateLanguageListener = this$0.translateLanguageListener;
        if (translateLanguageListener != null) {
            translateLanguageListener.onCodeClicked();
        }
        this$0.updateLanguage(false);
        this$0.invalidateLayout(LayoutState.LANGUAGE_CHANGE_LAYOUT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets initLangCodeButton$lambda$3$lambda$2(LinearLayout this_apply, View view, WindowInsets insets) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "insets.getInsets(WindowI…at.Type.navigationBars())");
        Insets insets3 = insets.getInsets(WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets3, "insets.getInsets(WindowI…pat.Type.displayCutout())");
        boolean z = this_apply.getResources().getConfiguration().getLayoutDirection() == 0;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            int dimensionPixelSize = this_apply.getResources().getDimensionPixelSize(C7039R.dimen.lang_code_button_margin);
            if (this_apply.getResources().getConfiguration().orientation == 2) {
                if (z) {
                    i = insets2.right + dimensionPixelSize;
                    i2 = insets3.right;
                } else {
                    i = insets2.left + dimensionPixelSize;
                    i2 = insets3.left;
                }
                marginLayoutParams.setMarginEnd(i2 + i);
            } else {
                marginLayoutParams.setMarginEnd(dimensionPixelSize);
            }
            view.setLayoutParams(marginLayoutParams);
        }
        return insets;
    }

    private final void initSourceLangChangeLayout() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2 = this.langChangeLayout;
        if (linearLayout2 == null || (linearLayout = (LinearLayout) linearLayout2.findViewById(C7039R.id.lang_change_source_layout)) == null) {
            linearLayout = null;
        } else {
            linearLayout.setOnClickListener(new ViewOnClickListenerC7091b(this, linearLayout, 1));
        }
        this.langChangeSourceLayout = linearLayout;
        this.langChangeSourceTextView = linearLayout != null ? (TextView) linearLayout.findViewById(C7039R.id.lang_change_source_text) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSourceLangChangeLayout$lambda$12$lambda$11(final TranslateLanguageHelperImpl this$0, LinearLayout this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        TranslateLanguageListener translateLanguageListener = this$0.translateLanguageListener;
        if (translateLanguageListener != null) {
            translateLanguageListener.onSourceExpanded();
        }
        Context context = this_apply.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LanguageSelectFragment languageSelectFragment = new LanguageSelectFragment(context, this$0.langPackManager, true, this$0.sourceLanguage, this$0.recentlyUsedLanguages.getRecentlyUsedLanguages(true), new LanguageSelectListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslateLanguageHelperImpl$initSourceLangChangeLayout$1$1$1
            @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.data.p138ui.LanguageSelectListener
            public void onLanguageSelected(@Nullable OnDeviceLanguage selectedLanguage) {
                String code;
                ImageTranslator imageTranslator;
                String str = this.this$0.sourceLanguage;
                TranslateLanguageHelperImpl translateLanguageHelperImpl = this.this$0;
                if (selectedLanguage == null || (code = selectedLanguage.getCode()) == null) {
                    code = this.this$0.sourceLanguage;
                }
                translateLanguageHelperImpl.sourceLanguage = code;
                if (!Intrinsics.areEqual(str, this.this$0.sourceLanguage) && (imageTranslator = this.this$0.imageTranslator) != null) {
                    imageTranslator.removeCache();
                }
                TranslateLanguageHelperImpl.updateLanguage$default(this.this$0, false, 1, null);
                TranslateLanguageListener translateLanguageListener2 = this.this$0.translateLanguageListener;
                if (translateLanguageListener2 != null) {
                    translateLanguageListener2.onSourceSelected(this.this$0.sourceLanguage);
                }
            }
        });
        Context context2 = this_apply.getContext();
        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        languageSelectFragment.show(((FragmentActivity) context2).getSupportFragmentManager(), TAG);
        this$0.sourceLangSelectFragment = languageSelectFragment;
    }

    private final void initTargetLangChangeLayout() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2 = this.langChangeLayout;
        if (linearLayout2 == null || (linearLayout = (LinearLayout) linearLayout2.findViewById(C7039R.id.lang_change_target_layout)) == null) {
            linearLayout = null;
        } else {
            linearLayout.setOnClickListener(new ViewOnClickListenerC7091b(this, linearLayout, 0));
        }
        this.langChangeTargetLayout = linearLayout;
        this.langChangeTargetTextView = linearLayout != null ? (TextView) linearLayout.findViewById(C7039R.id.lang_change_target_text) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTargetLangChangeLayout$lambda$15$lambda$14(final TranslateLanguageHelperImpl this$0, LinearLayout this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        TranslateLanguageListener translateLanguageListener = this$0.translateLanguageListener;
        if (translateLanguageListener != null) {
            translateLanguageListener.onTargetExpanded();
        }
        Context context = this_apply.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LanguageSelectFragment languageSelectFragment = new LanguageSelectFragment(context, this$0.langPackManager, false, this$0.targetLanguage, this$0.recentlyUsedLanguages.getRecentlyUsedLanguages(false), new LanguageSelectListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslateLanguageHelperImpl$initTargetLangChangeLayout$1$1$1
            @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.data.p138ui.LanguageSelectListener
            public void onLanguageSelected(@Nullable OnDeviceLanguage selectedLanguage) {
                String code;
                ImageTranslator imageTranslator;
                String str = this.this$0.targetLanguage;
                TranslateLanguageHelperImpl translateLanguageHelperImpl = this.this$0;
                if (selectedLanguage == null || (code = selectedLanguage.getCode()) == null) {
                    code = this.this$0.targetLanguage;
                }
                translateLanguageHelperImpl.targetLanguage = code;
                if (!Intrinsics.areEqual(str, this.this$0.targetLanguage) && (imageTranslator = this.this$0.imageTranslator) != null) {
                    imageTranslator.removeCache();
                }
                TranslateLanguageHelperImpl.updateLanguage$default(this.this$0, false, 1, null);
                TranslateLanguageListener translateLanguageListener2 = this.this$0.translateLanguageListener;
                if (translateLanguageListener2 != null) {
                    translateLanguageListener2.onTargetSelected(this.this$0.targetLanguage);
                }
            }
        });
        Context context2 = this_apply.getContext();
        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        languageSelectFragment.show(((FragmentActivity) context2).getSupportFragmentManager(), TAG);
        this$0.targetLangSelectFragment = languageSelectFragment;
    }

    private final void initViewInternal() {
        LinearLayout linearLayout = this.langManageLayout;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        LayoutInflater.from(this.context).inflate(C7039R.layout.translate_lang_layout, this.langManageLayout);
        LinearLayout linearLayout2 = this.langManageLayout;
        this.outerLayout = linearLayout2 != null ? (FrameLayout) linearLayout2.findViewById(C7039R.id.lang_outer_layout) : null;
        initLangCodeButton();
        initLangChangeLayout();
        updateLanguage(false);
    }

    private final void updateLangCodeButton() {
        String strSubstring;
        if (this.targetLanguage.length() == 4) {
            strSubstring = this.targetLanguage.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            strSubstring = this.targetLanguage;
        }
        if (Intrinsics.areEqual(strSubstring, LangPackConfigConstants.LANGUAGE_CODE_KO)) {
            strSubstring = "kr";
        }
        LibLogger.m5432i(TAG, "update language code button text to \"" + strSubstring + "\"");
        TextView textView = this.langCodeTextView;
        if (textView == null) {
            return;
        }
        String upperCase = strSubstring.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        textView.setText(upperCase);
    }

    private final void updateLanguage(boolean doTranslate) {
        updateSourceLanguage();
        updateTargetLanguage();
        updateLangCodeButton();
        this.recentlyUsedLanguages.updateLanguages(this.sourceLanguage, this.targetLanguage);
        LanguageChangeListener languageChangeListener = this.languageChangeListener;
        if (languageChangeListener != null) {
            languageChangeListener.onLanguageChanged(doTranslate);
        }
    }

    public static /* synthetic */ void updateLanguage$default(TranslateLanguageHelperImpl translateLanguageHelperImpl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        translateLanguageHelperImpl.updateLanguage(z);
    }

    private final void updateSourceLanguage() {
        String displaySourceLanguage = getDisplaySourceLanguage();
        LibLogger.m5432i(TAG, "update source language to \"" + displaySourceLanguage + "\"");
        TextView textView = this.langChangeSourceTextView;
        if (textView != null) {
            textView.setText(LanguageUtil.INSTANCE.getDisplayNameFromLangCode(this.context, displaySourceLanguage));
        }
        ImageTranslator imageTranslator = this.imageTranslator;
        if (imageTranslator != null) {
            imageTranslator.setSourceLanguage(this.sourceLanguage);
        }
    }

    private final void updateTargetLanguage() {
        LibLogger.m5432i(TAG, "update target language to \"" + this.targetLanguage + "\"");
        TextView textView = this.langChangeTargetTextView;
        if (textView != null) {
            textView.setText(LanguageUtil.INSTANCE.getDisplayNameFromLangCode(this.context, this.targetLanguage));
        }
        ImageTranslator imageTranslator = this.imageTranslator;
        if (imageTranslator != null) {
            imageTranslator.setTargetLanguage(this.targetLanguage);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslateLanguageHelper
    public void initLayout(@NotNull LinearLayout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        LibLogger.m5432i(TAG, "initialize TranslateLanguageHelper layout");
        this.langManageLayout = layout;
        initViewInternal();
        invalidateLayout(LayoutState.HIDDEN);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslateLanguageHelper
    public void invalidateLayout(@NotNull LayoutState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.layoutState = state;
        if (this.langManageLayout == null) {
            C70882 c70882 = new Function0<Integer>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslateLanguageHelperImpl.invalidateLayout.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Integer invoke() {
                    return Integer.valueOf(LibLogger.m5430e(TranslateLanguageHelperImpl.TAG, "invalidateLayout - Layout is not set yet"));
                }
            };
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            LinearLayout linearLayout = this.langCodeButton;
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
            }
            LinearLayout linearLayout2 = this.langChangeLayout;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setVisibility(4);
            return;
        }
        if (i == 2) {
            initLangCodeButton();
            LinearLayout linearLayout3 = this.langChangeLayout;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(4);
            }
            LinearLayout linearLayout4 = this.langCodeButton;
            if (linearLayout4 == null) {
                return;
            }
            linearLayout4.setVisibility(0);
            return;
        }
        if (i != 3) {
            return;
        }
        initLangChangeLayout();
        LinearLayout linearLayout5 = this.langCodeButton;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(4);
        }
        LinearLayout linearLayout6 = this.langChangeLayout;
        if (linearLayout6 == null) {
            return;
        }
        linearLayout6.setVisibility(0);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslateLanguageHelper
    public void onConfigurationChanged() {
        if (this.langManageLayout == null) {
            C70892 c70892 = new Function0<Integer>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslateLanguageHelperImpl.onConfigurationChanged.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Integer invoke() {
                    return Integer.valueOf(LibLogger.m5430e(TranslateLanguageHelperImpl.TAG, "onConfigurationChanged - Layout is not set yet"));
                }
            };
        } else {
            initViewInternal();
            invalidateLayout(this.layoutState);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslateLanguageHelper
    public void setListener(@NotNull TranslateLanguageListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.translateLanguageListener = listener;
    }
}
