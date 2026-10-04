package com.samsung.android.support.senl.p148nt.stt.picker.view;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.sdk.pen.setting.common.ViewOnKeyListenerC7560e;
import com.samsung.android.support.senl.p148nt.base.winset.snackbar.SnackbarHelper;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.picker.view.listener.OnBackKeyListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002$%B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u001a\u001a\u00020\u0018J\u0010\u0010\u001b\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u001c\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0010H\u0002J\u001a\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerSearchView;", "Landroidx/appcompat/widget/SearchView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mSearchBox", "Landroid/widget/EditText;", "mContext", "mInit", "", "mOnSearchVoiceClickListener", "Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerSearchView$OnSearchVoiceClickListener;", "mOnSearchEnterClickListener", "Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerSearchView$OnSearchEnterClickListener;", "mBackKeyListener", "Lcom/samsung/android/support/senl/nt/stt/picker/view/listener/OnBackKeyListener;", "setOnBackKeyListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "init", "setOnSearchVoiceClickListener", "setOnSearchEnterClickListener", "setSearchMoreVisibility", "isVisible", "initSearchData", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", "hint", "", "OnSearchVoiceClickListener", "OnSearchEnterClickListener", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AudioPickerSearchView extends SearchView {

    @Nullable
    private OnBackKeyListener mBackKeyListener;

    @Nullable
    private Context mContext;
    private boolean mInit;

    @Nullable
    private OnSearchEnterClickListener mOnSearchEnterClickListener;

    @Nullable
    private OnSearchVoiceClickListener mOnSearchVoiceClickListener;

    @Nullable
    private EditText mSearchBox;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerSearchView$OnSearchEnterClickListener;", "", "onSearchEnterClick", "", "searchString", "", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnSearchEnterClickListener {
        void onSearchEnterClick(@NotNull String searchString);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerSearchView$OnSearchVoiceClickListener;", "", "onSearchVoiceClick", "", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnSearchVoiceClickListener {
        void onSearchVoiceClick();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioPickerSearchView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(AudioPickerSearchView audioPickerSearchView, View view) {
        OnSearchVoiceClickListener onSearchVoiceClickListener = audioPickerSearchView.mOnSearchVoiceClickListener;
        if (onSearchVoiceClickListener != null) {
            onSearchVoiceClickListener.onSearchVoiceClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$1(AudioPickerSearchView audioPickerSearchView, View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        if (i != 66 && i != 160) {
            return false;
        }
        EditText editText = audioPickerSearchView.mSearchBox;
        if (editText != null) {
            editText.clearFocus();
        }
        OnSearchEnterClickListener onSearchEnterClickListener = audioPickerSearchView.mOnSearchEnterClickListener;
        Intrinsics.checkNotNull(onSearchEnterClickListener);
        EditText editText2 = audioPickerSearchView.mSearchBox;
        onSearchEnterClickListener.onSearchEnterClick(String.valueOf(editText2 != null ? editText2.getText() : null));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2(AudioPickerSearchView audioPickerSearchView, View view) {
        OnBackKeyListener onBackKeyListener = audioPickerSearchView.mBackKeyListener;
        if (onBackKeyListener != null) {
            Intrinsics.checkNotNull(onBackKeyListener);
            onBackKeyListener.onBackKeyDown();
        }
    }

    private final void setSearchMoreVisibility(boolean isVisible) {
        seslSetOverflowMenuButtonVisibility(isVisible ? 0 : 8);
    }

    public final void init() {
        if (this.mSearchBox != null || this.mInit) {
            return;
        }
        final int i = 1;
        setSaveEnabled(true);
        findViewById(C11493R.id.search_close_btn).setContentDescription(getResources().getString(C11493R.string.search_clear_button_description));
        final int i2 = 0;
        findViewById(C11493R.id.search_voice_btn).setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.stt.picker.view.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AudioPickerSearchView f7871b;

            {
                this.f7871b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        AudioPickerSearchView.init$lambda$0(this.f7871b, view);
                        break;
                    default:
                        AudioPickerSearchView.init$lambda$2(this.f7871b, view);
                        break;
                }
            }
        });
        EditText editText = (EditText) findViewById(C11493R.id.search_src_text);
        this.mSearchBox = editText;
        if (editText != null) {
            Context context = this.mContext;
            Intrinsics.checkNotNull(context);
            editText.setHintTextColor(context.getColor(C11493R.color.search_hint_text_color));
        }
        EditText editText2 = this.mSearchBox;
        if (editText2 != null) {
            editText2.setFilters(new InputFilter[]{new InputFilter.LengthFilter() { // from class: com.samsung.android.support.senl.nt.stt.picker.view.AudioPickerSearchView.init.2
                {
                    super(199);
                }

                @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
                public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(dest, "dest");
                    CharSequence charSequenceFilter = super.filter(source, start, end, dest, dstart, dend);
                    if (charSequenceFilter != null && (AudioPickerSearchView.this.mContext instanceof Activity)) {
                        Activity activity = (Activity) AudioPickerSearchView.this.mContext;
                        String string = AudioPickerSearchView.this.getResources().getString(C11493R.string.ss_maximum_number_of_characters_exceeded, 199);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        SnackbarHelper.show(activity, string, 0);
                    }
                    return charSequenceFilter;
                }
            }});
        }
        EditText editText3 = this.mSearchBox;
        if (editText3 != null) {
            editText3.setOnKeyListener(new ViewOnKeyListenerC7560e(this, 3));
        }
        ImageView imageViewSeslGetUpButton = seslGetUpButton();
        imageViewSeslGetUpButton.setVisibility(0);
        imageViewSeslGetUpButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.stt.picker.view.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AudioPickerSearchView f7871b;

            {
                this.f7871b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        AudioPickerSearchView.init$lambda$0(this.f7871b, view);
                        break;
                    default:
                        AudioPickerSearchView.init$lambda$2(this.f7871b, view);
                        break;
                }
            }
        });
        setSearchMoreVisibility(false);
        findViewById(C11493R.id.search_voice_btn).setVisibility(0);
        setImeOptions(268435459);
        EditText editText4 = this.mSearchBox;
        if (editText4 != null) {
            editText4.setPrivateImeOptions("disableImage=true");
        }
        this.mInit = true;
    }

    public final void initSearchData(@Nullable ComponentName componentName, @Nullable String hint) {
        setQueryHint(new SpannableStringBuilder(hint));
        SearchManager searchManager = (SearchManager) getContext().getSystemService("search");
        if (searchManager == null || componentName == null) {
            return;
        }
        setSearchableInfo(searchManager.getSearchableInfo(componentName));
    }

    public final void setOnBackKeyListener(@Nullable OnBackKeyListener listener) {
        this.mBackKeyListener = listener;
    }

    public final void setOnSearchEnterClickListener(@Nullable OnSearchEnterClickListener listener) {
        this.mOnSearchEnterClickListener = listener;
    }

    public final void setOnSearchVoiceClickListener(@Nullable OnSearchVoiceClickListener listener) {
        this.mOnSearchVoiceClickListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioPickerSearchView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioPickerSearchView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        init();
    }
}
