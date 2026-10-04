package com.samsung.android.support.senl.p148nt.base.winset.app.language;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u0016\u0017BY\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/SupportedTranslationLanguageAdapter;", "Landroid/widget/ArrayAdapter;", "", "context", "Landroid/content/Context;", "mLayoutId", "", "textId", "mLocale", "", "data", "mDescription", "mListener", "Lcom/samsung/android/support/senl/nt/base/winset/app/language/SupportedTranslationLanguageAdapter$LanguageListener;", "<init>", "(Landroid/content/Context;IILjava/util/List;Ljava/util/List;Ljava/util/List;Lcom/samsung/android/support/senl/nt/base/winset/app/language/SupportedTranslationLanguageAdapter$LanguageListener;)V", "getView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "LanguageListener", "ViewHolder", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SupportedTranslationLanguageAdapter extends ArrayAdapter<String> {

    @NotNull
    private final List<String> mDescription;
    private final int mLayoutId;

    @NotNull
    private final LanguageListener mListener;

    @NotNull
    private final List<String> mLocale;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/SupportedTranslationLanguageAdapter$LanguageListener;", "", "currentCheckedIndex", "", "getCurrentCheckedIndex", "()I", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface LanguageListener {
        int getCurrentCheckedIndex();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/SupportedTranslationLanguageAdapter$ViewHolder;", "", "<init>", "()V", "checkedText", "Landroid/widget/CheckedTextView;", "getCheckedText", "()Landroid/widget/CheckedTextView;", "setCheckedText", "(Landroid/widget/CheckedTextView;)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ViewHolder {

        @Nullable
        private CheckedTextView checkedText;

        @Nullable
        public final CheckedTextView getCheckedText() {
            return this.checkedText;
        }

        public final void setCheckedText(@Nullable CheckedTextView checkedTextView) {
            this.checkedText = checkedTextView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SupportedTranslationLanguageAdapter(@Nullable Context context, int i, int i2, @NotNull List<String> mLocale, @Nullable List<String> list, @NotNull List<String> mDescription, @NotNull LanguageListener mListener) {
        super(context, i, i2, list);
        Intrinsics.checkNotNullParameter(mLocale, "mLocale");
        Intrinsics.checkNotNullParameter(mDescription, "mDescription");
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(list);
        this.mLayoutId = i;
        this.mLocale = mLocale;
        this.mDescription = mDescription;
        this.mListener = mListener;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NotNull
    public View getView(int position, @Nullable View convertView, @NotNull ViewGroup parent) {
        ViewHolder viewHolder;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (convertView == null) {
            Resources resources = parent.getContext().getResources();
            TypedValue typedValue = new TypedValue();
            resources.getValue(C8875R.dimen.font_scale_tiny, typedValue, true);
            float f = typedValue.getFloat();
            resources.getValue(C8875R.dimen.font_scale_extra_small, typedValue, true);
            float f4 = typedValue.getFloat();
            resources.getValue(C8875R.dimen.font_scale_small, typedValue, true);
            float f5 = typedValue.getFloat();
            viewHolder = new ViewHolder();
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.mLayoutId, parent, false);
            viewHolder.setCheckedText((CheckedTextView) viewInflate.findViewById(C8875R.id.language_text));
            Configuration configuration = resources.getConfiguration();
            if (configuration != null) {
                float f6 = configuration.fontScale;
                if (f6 <= f) {
                    int dimensionPixelSize = resources.getDimensionPixelSize(C8875R.dimen.listrow_tiny_min_height_1line);
                    CheckedTextView checkedText = viewHolder.getCheckedText();
                    if (checkedText != null) {
                        checkedText.setMinHeight(dimensionPixelSize);
                    }
                } else if (f6 <= f4) {
                    int dimensionPixelSize2 = resources.getDimensionPixelSize(C8875R.dimen.listrow_extra_small_min_height_1line);
                    CheckedTextView checkedText2 = viewHolder.getCheckedText();
                    if (checkedText2 != null) {
                        checkedText2.setMinHeight(dimensionPixelSize2);
                    }
                } else if (f6 <= f5) {
                    int dimensionPixelSize3 = resources.getDimensionPixelSize(C8875R.dimen.listrow_small_min_height_1line);
                    CheckedTextView checkedText3 = viewHolder.getCheckedText();
                    if (checkedText3 != null) {
                        checkedText3.setMinHeight(dimensionPixelSize3);
                    }
                } else {
                    CheckedTextView checkedText4 = viewHolder.getCheckedText();
                    ViewGroup.LayoutParams layoutParams = checkedText4 != null ? checkedText4.getLayoutParams() : null;
                    if (layoutParams != null) {
                        layoutParams.height = -2;
                    }
                    CheckedTextView checkedText5 = viewHolder.getCheckedText();
                    if (checkedText5 != null) {
                        checkedText5.setLayoutParams(layoutParams);
                    }
                }
            }
            viewInflate.setTag(viewHolder);
            convertView = viewInflate;
        } else {
            Object tag = convertView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.winset.app.language.SupportedTranslationLanguageAdapter.ViewHolder");
            viewHolder = (ViewHolder) tag;
        }
        if (viewHolder.getCheckedText() != null) {
            if (position == this.mListener.getCurrentCheckedIndex()) {
                CheckedTextView checkedText6 = viewHolder.getCheckedText();
                if (checkedText6 != null) {
                    checkedText6.setChecked(true);
                }
            } else {
                CheckedTextView checkedText7 = viewHolder.getCheckedText();
                if (checkedText7 != null) {
                    checkedText7.setChecked(false);
                }
            }
            String str = this.mDescription.get(position);
            CheckedTextView checkedText8 = viewHolder.getCheckedText();
            if (checkedText8 != null) {
                checkedText8.setContentDescription(str);
            }
            CheckedTextView checkedText9 = viewHolder.getCheckedText();
            if (checkedText9 != null) {
                checkedText9.setTag(this.mLocale.get(position));
            }
        }
        View view = super.getView(position, convertView, parent);
        Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
        return view;
    }
}
