package com.samsung.android.support.senl.p148nt.composer.main.cover.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FontUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentCoverUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TypeListAdapter extends RecyclerView.Adapter<TypeViewHolder> {
    private static final int MAX_SUMMARY_CHAR = 200;
    private static final int PAYLOADS_START_STICKER_ANIMATION = 1;
    private static final int PAYLOADS_START_STICKER_NONE_ANIMATION = 2;
    private static final int PAYLOADS_START_STICKER_PREV_NONE_ANIMATION = 3;
    private static final int PAYLOADS_UPDATE_PREVIEW = 0;
    private static final String TAG = "TypeListAdapter";
    private final CoverData mCoverData;
    private int mSelectedPosition;
    private TypeContract mTypeContract;
    private final List<Integer> mTypeList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TypeContract {
        void onSelectType(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class TypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final int STICKER_CONTAINER_DURATION = 350;
        private static final int STICKER_DURATION = 400;
        private static final String TAG = "TypeViewHolder";
        private Contract mContract;
        private final ImageView mCoverLine;
        private final ImageView mPreview;
        private AnimatorSet mScaleAnimatorSet;
        private AnimatorSet mStickerAnimatorSet;
        private final View mStickerContainer;
        private final View mStickerEmptyView;
        private final ImageView mStickerIconView;
        private ObjectAnimator mStickerNoneAnimator;
        private ObjectAnimator mStickerPrevNoneAnimator;
        private final View mStickerView;
        private final EditText mSummaryView;
        private final TextView mTypeTitle;
        private static final PathInterpolator STICKER_CONTAINER_INTERPOLATOR = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
        private static final PathInterpolator STICKER_INTERPOLATOR = new PathInterpolator(0.2f, 0.2f, 0.0f, 1.2f);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface Contract {
            void setSelectType(int i);

            void setSummary(String str);
        }

        public TypeViewHolder(@NonNull View view) {
            super(view);
            ImageView imageView = (ImageView) view.findViewById(C9086R.id.cover_preview);
            this.mPreview = imageView;
            this.mCoverLine = (ImageView) view.findViewById(C9086R.id.cover_line_view);
            this.mSummaryView = (EditText) view.findViewById(C9086R.id.edit_summary);
            TextView textView = (TextView) view.findViewById(C9086R.id.cover_editor_type_item_title);
            this.mTypeTitle = textView;
            this.mStickerContainer = view.findViewById(C9086R.id.sticker_container);
            this.mStickerView = view.findViewById(C9086R.id.sticker_view);
            this.mStickerIconView = (ImageView) view.findViewById(C9086R.id.sticker_icon_view);
            this.mStickerEmptyView = view.findViewById(C9086R.id.sticker_empty_view);
            imageView.setOnClickListener(this);
            textView.setOnClickListener(this);
            setSummaryView();
            setStickerAnimation();
        }

        private void setAccessibility() {
            this.mPreview.setContentDescription(((Object) this.mTypeTitle.getText()) + SQLKeyword.COMMA + this.itemView.getResources().getString(C9086R.string.cover_cateogry));
            ViewCompat.setAccessibilityDelegate(this.mPreview, new AccessibilityDelegateCompat() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.adapter.TypeListAdapter.TypeViewHolder.1
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setSelected(TypeViewHolder.this.getLayoutPosition() == TypeListAdapter.this.mSelectedPosition);
                    accessibilityNodeInfoCompat.setClassName(Button.class.getName());
                }
            });
        }

        private void setEditorMaxLengthFilter() {
            this.mSummaryView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200) { // from class: com.samsung.android.support.senl.nt.composer.main.cover.adapter.TypeListAdapter.TypeViewHolder.5
                @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
                public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
                    CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i4, i5);
                    if (charSequenceFilter != null) {
                        TypeViewHolder.this.showMaxCharToast(200);
                    }
                    return charSequenceFilter;
                }
            }});
        }

        private void setPreviewEnable(int i) {
            this.mSummaryView.setFocusable(false);
            this.mSummaryView.setFocusableInTouchMode(true);
            if (i != 3) {
                this.mSummaryView.setVisibility(8);
                this.mStickerContainer.setVisibility(8);
            } else {
                this.mSummaryView.setVisibility(0);
                this.mStickerContainer.setVisibility(0);
                setSummaryTextColor();
                setStickerBackground();
            }
        }

        private void setStickerAnimation() {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mStickerIconView, "scaleX", 0.0f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.mStickerIconView, "scaleY", 0.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            this.mScaleAnimatorSet = animatorSet;
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            this.mScaleAnimatorSet.setDuration(400L);
            this.mScaleAnimatorSet.setInterpolator(STICKER_INTERPOLATOR);
            this.mStickerPrevNoneAnimator = ObjectAnimator.ofFloat(this.mStickerView, "translationX", this.mStickerContainer.getMeasuredWidth(), 0.0f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.mStickerAnimatorSet = animatorSet2;
            animatorSet2.playTogether(this.mStickerPrevNoneAnimator, objectAnimatorOfFloat, objectAnimatorOfFloat2);
            this.mStickerAnimatorSet.setDuration(350L);
            AnimatorSet animatorSet3 = this.mStickerAnimatorSet;
            PathInterpolator pathInterpolator = STICKER_CONTAINER_INTERPOLATOR;
            animatorSet3.setInterpolator(pathInterpolator);
            this.mStickerAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.adapter.TypeListAdapter.TypeViewHolder.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    TypeViewHolder.this.mStickerEmptyView.setVisibility(8);
                    TypeViewHolder.this.mStickerView.setVisibility(0);
                    TypeViewHolder.this.mStickerIconView.setVisibility(0);
                }
            });
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.mStickerView, "translationX", 0.0f, this.mStickerContainer.getMeasuredWidth());
            this.mStickerNoneAnimator = objectAnimatorOfFloat3;
            objectAnimatorOfFloat3.setDuration(350L);
            this.mStickerNoneAnimator.setInterpolator(pathInterpolator);
            this.mStickerNoneAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.adapter.TypeListAdapter.TypeViewHolder.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    TypeViewHolder.this.mStickerView.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    TypeViewHolder.this.mStickerEmptyView.setVisibility(0);
                    TypeViewHolder.this.mStickerIconView.setVisibility(8);
                }
            });
        }

        private void setStickerBackground() {
            boolean z = (CoverStickerConstants.Category.NONE.UUID.equals(TypeListAdapter.this.mCoverData.getCategoryUuid()) || NotesDocumentCoverUtils.isHigherCoverVersion(TypeListAdapter.this.mCoverData.getCategoryUuid())) ? false : true;
            this.mStickerEmptyView.setVisibility(z ? 8 : 0);
            this.mStickerView.setVisibility(z ? 0 : 8);
            this.mStickerIconView.setVisibility(z ? 0 : 8);
            this.mStickerIconView.setImageDrawable(CoverEditorUtils.getCategoryDrawable(this.itemView.getContext(), TypeListAdapter.this.mCoverData.getCategoryUuid()));
        }

        private void setSummaryTextColor() {
            Pair<Integer, Integer> summaryColor = CoverEditorUtils.getSummaryColor(this.itemView.getContext(), TypeListAdapter.this.mCoverData.getColorId(), TypeListAdapter.this.mCoverData.getSelectedTemplateList().get(3));
            this.mSummaryView.setTextColor(((Integer) summaryColor.first).intValue());
            this.mSummaryView.setHintTextColor(((Integer) summaryColor.second).intValue());
        }

        private void setSummaryView() {
            FontUtils.setFont(this.mSummaryView, "Roboto_Medium");
            this.mSummaryView.setText(TypeListAdapter.this.mCoverData.getSummary());
            if (!TextUtils.isEmpty(TypeListAdapter.this.mCoverData.getSummary())) {
                this.mSummaryView.setBackground(new ColorDrawable(0));
            }
            this.mSummaryView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.adapter.TypeListAdapter.TypeViewHolder.2
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    Logger.m10999d(TypeViewHolder.TAG, "onFocusChange# hasFocus : " + z);
                    SpannableString spannableString = new SpannableString(TypeViewHolder.this.mSummaryView.getText());
                    if (z) {
                        int selectionEnd = TypeViewHolder.this.mSummaryView.getSelectionEnd();
                        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
                        TypeViewHolder.this.mSummaryView.setText(spannableString);
                        TypeViewHolder.this.mSummaryView.setSelection(selectionEnd);
                        TypeViewHolder.this.mSummaryView.setBackground(ResourcesCompat.getDrawable(TypeViewHolder.this.itemView.getResources(), C9086R.drawable.cover_editor_new_preview_edit_summary_bg, null));
                        return;
                    }
                    for (UnderlineSpan underlineSpan : (UnderlineSpan[]) spannableString.getSpans(0, spannableString.length(), UnderlineSpan.class)) {
                        spannableString.removeSpan(underlineSpan);
                    }
                    TypeViewHolder.this.mSummaryView.setText(spannableString);
                    if (!TextUtils.isEmpty(spannableString)) {
                        TypeViewHolder.this.mSummaryView.setBackground(new ColorDrawable(0));
                    }
                    InputMethodCompat.getInstance().hideSoftInput(BaseUtils.getApplicationContext(), TypeViewHolder.this.mSummaryView);
                }
            });
            this.mSummaryView.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.adapter.TypeListAdapter.TypeViewHolder.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    Logger.m10999d(TypeViewHolder.TAG, "onTouch# mSelectedPosition : " + TypeListAdapter.this.mSelectedPosition + ", focus : " + TypeViewHolder.this.mSummaryView.hasFocus());
                    if (TypeListAdapter.this.mSelectedPosition != 3) {
                        TypeViewHolder.this.mContract.setSelectType(3);
                        TypeViewHolder.this.mSummaryView.clearFocus();
                        return true;
                    }
                    if (!TypeViewHolder.this.mSummaryView.hasFocus()) {
                        return false;
                    }
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
            });
            this.mSummaryView.addTextChangedListener(new TextWatcher() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.adapter.TypeListAdapter.TypeViewHolder.4
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    TypeViewHolder.this.mContract.setSummary(editable.toString());
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i4) {
                }
            });
            setEditorMaxLengthFilter();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showMaxCharToast(int i) {
            UserInputSkipper.Tag tag = UserInputSkipper.Tag.Default;
            if (UserInputSkipper.isValidEvent(tag)) {
                UserInputSkipper.setHoldingEventTime(1000L, tag);
                ToastHandler.show(this.itemView.getContext(), this.itemView.getContext().getString(C9086R.string.composer_maximum_input, Integer.valueOf(i)), 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startStickerAnimation() {
            updateStickerBackground();
            this.mScaleAnimatorSet.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startStickerNoneAnimation() {
            updateStickerBackground();
            this.mStickerNoneAnimator.setFloatValues(0.0f, LocaleUtils.isRTLMode() ? -this.mStickerContainer.getMeasuredWidth() : this.mStickerContainer.getMeasuredWidth());
            this.mStickerNoneAnimator.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startStickerPrevNoneAnimation() {
            updateStickerBackground();
            this.mStickerPrevNoneAnimator.setFloatValues(LocaleUtils.isRTLMode() ? -this.mStickerContainer.getMeasuredWidth() : this.mStickerContainer.getMeasuredWidth(), 0.0f);
            this.mStickerAnimatorSet.start();
        }

        private void updateStickerBackground() {
            this.mSummaryView.setFocusable(false);
            this.mSummaryView.setFocusableInTouchMode(true);
            this.mStickerIconView.setImageDrawable(CoverEditorUtils.getCategoryDrawable(this.itemView.getContext(), TypeListAdapter.this.mCoverData.getCategoryUuid()));
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Logger.m10999d(TAG, "onClick# position : " + getLayoutPosition() + ", mSelectedPosition : " + TypeListAdapter.this.mSelectedPosition);
            if (getLayoutPosition() != TypeListAdapter.this.mSelectedPosition) {
                this.mContract.setSelectType(getLayoutPosition());
            }
        }

        public void setContract(Contract contract) {
            this.mContract = contract;
        }

        public void setPreviewBackground(int i) {
            if (i == 0) {
                int backgroundColor = TypeListAdapter.this.mCoverData.getBackgroundColor();
                String thumbnailFilePath = CoverEditorUtils.getThumbnailFilePath(this.itemView.getContext(), TypeListAdapter.this.mCoverData.getNoteUuid(), backgroundColor, TypeListAdapter.this.mCoverData.getBackgroundColorInverted());
                if (thumbnailFilePath != null) {
                    this.mPreview.setImageDrawable(CoverEditorUtils.getThumbnailDrawable(this.itemView.getContext(), thumbnailFilePath));
                    ImageView imageView = this.mPreview;
                    if (!ContentUtils.hasBackgroundColorNotes(backgroundColor, false)) {
                        backgroundColor = this.itemView.getResources().getColor(C9086R.color.basic_list_item_bg_color);
                    }
                    imageView.setBackgroundColor(backgroundColor);
                    this.mPreview.setColorFilter(this.itemView.getResources().getColor(C9086R.color.noteslist_thumbnail_opacity));
                } else {
                    this.mPreview.setBackgroundColor(this.itemView.getResources().getColor(C9086R.color.basic_list_item_bg_color, null));
                }
                this.mCoverLine.setVisibility(8);
            } else {
                this.mPreview.setBackground(CoverEditorUtils.getTemplateDrawable(this.itemView.getContext(), TypeListAdapter.this.mCoverData.getSelectedTemplateList().get(i), TypeListAdapter.this.mCoverData.getColorId()));
                this.mCoverLine.setVisibility(i != 3 ? 0 : 8);
            }
            setAccessibility();
            setPreviewEnable(i);
            this.mSummaryView.setText(TypeListAdapter.this.mCoverData.getSummary());
        }

        public void setTypeTitle(int i) {
            this.mTypeTitle.setText(this.itemView.getResources().getString(((Integer) TypeListAdapter.this.mTypeList.get(i)).intValue()));
        }
    }

    public TypeListAdapter(List<Integer> list, CoverData coverData, int i) {
        this.mTypeList = list;
        this.mCoverData = coverData;
        this.mSelectedPosition = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mCoverData.getSelectedTemplateList().size();
    }

    public void setTypeContract(TypeContract typeContract) {
        this.mTypeContract = typeContract;
    }

    public void updateDownloadedSticker() {
        notifyItemChanged(3, 1);
    }

    public void updateSelectedColor() {
        notifyItemChanged(3, 0);
    }

    public void updateSelectedSticker(int i, int i2) {
        if (i == 0) {
            notifyItemChanged(3, 2);
        } else if (i2 == 0) {
            notifyItemChanged(3, 3);
        } else {
            notifyItemChanged(3, 1);
        }
    }

    public void updateSelectedTemplate(String str) {
        notifyItemChanged(CoverEditorUtils.getTemplateTypeIndex(str), 0);
    }

    public void updateSelectedType(int i) {
        if (i == this.mSelectedPosition) {
            return;
        }
        this.mSelectedPosition = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List list) {
        onBindViewHolder((TypeViewHolder) viewHolder, i, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public TypeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new TypeViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.cover_editor_new_type_list_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull TypeViewHolder typeViewHolder, int i) {
        typeViewHolder.setContract(new TypeViewHolder.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.adapter.TypeListAdapter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.cover.adapter.TypeListAdapter.TypeViewHolder.Contract
            public void setSelectType(int i2) {
                TypeListAdapter.this.mTypeContract.onSelectType(i2);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.cover.adapter.TypeListAdapter.TypeViewHolder.Contract
            public void setSummary(String str) {
                TypeListAdapter.this.mCoverData.setSummary(str);
            }
        });
        typeViewHolder.setTypeTitle(i);
        typeViewHolder.setPreviewBackground(i);
        typeViewHolder.itemView.setId(i);
    }

    public void onBindViewHolder(@NonNull TypeViewHolder typeViewHolder, int i, @NonNull List<Object> list) {
        if (list.isEmpty()) {
            super.onBindViewHolder(typeViewHolder, i, list);
            return;
        }
        if (list.contains(0)) {
            typeViewHolder.setPreviewBackground(i);
            return;
        }
        if (list.contains(1)) {
            typeViewHolder.startStickerAnimation();
        } else if (list.contains(2)) {
            typeViewHolder.startStickerNoneAnimation();
        } else if (list.contains(3)) {
            typeViewHolder.startStickerPrevNoneAnimation();
        }
    }
}
