package com.samsung.android.support.senl.p148nt.base.winset.app.language;

import android.content.Context;
import android.content.res.Configuration;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p071Q2.ViewOnClickListenerC0220b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0003\u001b\u001c\u001dBU\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/UnsupportedTranslationLanguageAdapter;", "Landroid/widget/ArrayAdapter;", "", "mContext", "Landroid/content/Context;", "mLayoutId", "", "textId", "mLocale", "", "data", "description", "mListener", "Lcom/samsung/android/support/senl/nt/base/winset/app/language/UnsupportedTranslationLanguageAdapter$OnDownLoadButtonClickListener;", "<init>", "(Landroid/content/Context;IILjava/util/List;Ljava/util/List;Ljava/util/List;Lcom/samsung/android/support/senl/nt/base/winset/app/language/UnsupportedTranslationLanguageAdapter$OnDownLoadButtonClickListener;)V", "getView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "setStateForDownloadAndUpdateButton", "", "holder", "Lcom/samsung/android/support/senl/nt/base/winset/app/language/UnsupportedTranslationLanguageAdapter$ViewHolder;", "updateSelectedLanguageCheckbox", "OnDownLoadButtonClickListener", "ViewHolder", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UnsupportedTranslationLanguageAdapter extends ArrayAdapter<String> {

    @NotNull
    private static final String TAG = "SupportedTranslationLanguageAdapter";

    @NotNull
    private final List<String> description;

    @NotNull
    private final Context mContext;
    private final int mLayoutId;

    @NotNull
    private final OnDownLoadButtonClickListener mListener;

    @NotNull
    private final List<String> mLocale;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/UnsupportedTranslationLanguageAdapter$OnDownLoadButtonClickListener;", "", "onDownloadClick", "", "locale", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnDownLoadButtonClickListener {
        void onDownloadClick(@Nullable String locale);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/UnsupportedTranslationLanguageAdapter$ViewHolder;", "", "<init>", "()V", "checkedText", "Landroid/widget/TextView;", "getCheckedText", "()Landroid/widget/TextView;", "setCheckedText", "(Landroid/widget/TextView;)V", "downloadBtn", "Landroid/widget/ImageView;", "getDownloadBtn", "()Landroid/widget/ImageView;", "setDownloadBtn", "(Landroid/widget/ImageView;)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ViewHolder {

        @Nullable
        private TextView checkedText;

        @Nullable
        private ImageView downloadBtn;

        @Nullable
        public final TextView getCheckedText() {
            return this.checkedText;
        }

        @Nullable
        public final ImageView getDownloadBtn() {
            return this.downloadBtn;
        }

        public final void setCheckedText(@Nullable TextView textView) {
            this.checkedText = textView;
        }

        public final void setDownloadBtn(@Nullable ImageView imageView) {
            this.downloadBtn = imageView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsupportedTranslationLanguageAdapter(@NotNull Context mContext, int i, int i2, @NotNull List<String> mLocale, @Nullable List<String> list, @NotNull List<String> description, @NotNull OnDownLoadButtonClickListener mListener) {
        super(mContext, i, i2, list);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mLocale, "mLocale");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        Intrinsics.checkNotNull(list);
        this.mContext = mContext;
        this.mLayoutId = i;
        this.mLocale = mLocale;
        this.description = description;
        this.mListener = mListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getView$lambda$0(UnsupportedTranslationLanguageAdapter unsupportedTranslationLanguageAdapter, int i, View view) {
        unsupportedTranslationLanguageAdapter.mListener.onDownloadClick(unsupportedTranslationLanguageAdapter.mLocale.get(i));
    }

    private final void setStateForDownloadAndUpdateButton(int position, ViewHolder holder) {
        if (holder == null) {
            return;
        }
        ImageView downloadBtn = holder.getDownloadBtn();
        if (downloadBtn != null) {
            downloadBtn.setVisibility(0);
        }
        ImageView downloadBtn2 = holder.getDownloadBtn();
        if (downloadBtn2 != null) {
            downloadBtn2.setAlpha(0.5f);
        }
    }

    private final void updateSelectedLanguageCheckbox(int position, ViewHolder holder) {
        if (holder.getCheckedText() != null) {
            String str = this.description.get(position);
            TextView checkedText = holder.getCheckedText();
            if (checkedText != null) {
                checkedText.setContentDescription(str);
            }
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NotNull
    public View getView(int position, @Nullable View convertView, @NotNull ViewGroup parent) {
        ViewHolder viewHolder;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (convertView == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getResources().getValue(C8875R.dimen.font_scale_tiny, typedValue, true);
            float f = typedValue.getFloat();
            this.mContext.getResources().getValue(C8875R.dimen.font_scale_extra_small, typedValue, true);
            float f4 = typedValue.getFloat();
            this.mContext.getResources().getValue(C8875R.dimen.font_scale_small, typedValue, true);
            float f5 = typedValue.getFloat();
            viewHolder = new ViewHolder();
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.mLayoutId, parent, false);
            viewHolder.setCheckedText((TextView) viewInflate.findViewById(C8875R.id.language_text));
            viewHolder.setDownloadBtn((ImageView) viewInflate.findViewById(C8875R.id.download));
            ImageView downloadBtn = viewHolder.getDownloadBtn();
            if (downloadBtn != null) {
                downloadBtn.setOnClickListener(new ViewOnClickListenerC0220b(this, position, 1));
            }
            Configuration configuration = this.mContext.getResources().getConfiguration();
            if (configuration != null) {
                float f6 = configuration.fontScale;
                if (f6 <= f) {
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C8875R.dimen.listrow_tiny_min_height_1line);
                    TextView checkedText = viewHolder.getCheckedText();
                    if (checkedText != null) {
                        checkedText.setMinHeight(dimensionPixelSize);
                    }
                } else if (f6 <= f4) {
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(C8875R.dimen.listrow_extra_small_min_height_1line);
                    TextView checkedText2 = viewHolder.getCheckedText();
                    if (checkedText2 != null) {
                        checkedText2.setMinHeight(dimensionPixelSize2);
                    }
                } else if (f6 <= f5) {
                    int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(C8875R.dimen.listrow_small_min_height_1line);
                    TextView checkedText3 = viewHolder.getCheckedText();
                    if (checkedText3 != null) {
                        checkedText3.setMinHeight(dimensionPixelSize3);
                    }
                } else {
                    TextView checkedText4 = viewHolder.getCheckedText();
                    ViewGroup.LayoutParams layoutParams = checkedText4 != null ? checkedText4.getLayoutParams() : null;
                    if (layoutParams != null) {
                        layoutParams.height = -2;
                    }
                    TextView checkedText5 = viewHolder.getCheckedText();
                    if (checkedText5 != null) {
                        checkedText5.setLayoutParams(layoutParams);
                    }
                }
            }
            viewInflate.setTag(viewHolder);
            convertView = viewInflate;
        } else {
            Object tag = convertView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.winset.app.language.UnsupportedTranslationLanguageAdapter.ViewHolder");
            viewHolder = (ViewHolder) tag;
        }
        updateSelectedLanguageCheckbox(position, viewHolder);
        setStateForDownloadAndUpdateButton(position, viewHolder);
        View view = super.getView(position, convertView, parent);
        Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
        return view;
    }
}
