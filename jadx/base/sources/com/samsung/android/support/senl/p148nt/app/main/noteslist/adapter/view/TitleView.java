package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ResourcesUtils;
import com.samsung.android.support.senl.p148nt.app.common.widget.HoverPopupTextView;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.NotesHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.NotesHolderUtil;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TitleView extends HoverPopupTextView {
    private static final String TAG = "TitleView";
    private ThumbnailContract mNoteTitleContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TitleParam {
        private int mBackgroundColor;
        private CharSequence mContent;
        private HighlightText mHighlightText;
        private boolean mIsLock;
        private boolean mIsSdoc;
        private boolean mIsSupportInvertedBGColor;
        private int mMaxLine;
        private int mViewMode;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class TitleParamBuilder {
            private final TitleParam mTitleParam = new TitleParam();

            public TitleParam build() {
                return this.mTitleParam;
            }

            public TitleParamBuilder setBackgroundColor(int i) {
                this.mTitleParam.setBackgroundColor(i);
                return this;
            }

            public TitleParamBuilder setContent(CharSequence charSequence) {
                this.mTitleParam.setContent(charSequence);
                return this;
            }

            public TitleParamBuilder setHighlightText(HighlightText highlightText) {
                this.mTitleParam.setHighlightText(highlightText);
                return this;
            }

            public TitleParamBuilder setIsLock(boolean z) {
                this.mTitleParam.setIsLock(z);
                return this;
            }

            public TitleParamBuilder setIsSdoc(boolean z) {
                this.mTitleParam.setIsSdoc(z);
                return this;
            }

            public TitleParamBuilder setIsSupportInvertedBGColor(boolean z) {
                this.mTitleParam.setIsSupportInvertedBGColor(z);
                return this;
            }

            public TitleParamBuilder setMaxLine(int i) {
                this.mTitleParam.setMaxLine(i);
                return this;
            }

            public TitleParamBuilder setViewMode(int i) {
                this.mTitleParam.setViewMode(i);
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBackgroundColor(int i) {
            this.mBackgroundColor = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContent(CharSequence charSequence) {
            this.mContent = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHighlightText(HighlightText highlightText) {
            this.mHighlightText = highlightText;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsLock(boolean z) {
            this.mIsLock = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsSdoc(boolean z) {
            this.mIsSdoc = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsSupportInvertedBGColor(boolean z) {
            this.mIsSupportInvertedBGColor = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMaxLine(int i) {
            this.mMaxLine = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setViewMode(int i) {
            this.mViewMode = i;
        }

        public int getBackgroundColor() {
            return this.mBackgroundColor;
        }

        public CharSequence getContent() {
            return this.mContent;
        }

        public List<String> getHighlightText() {
            HighlightText highlightText = this.mHighlightText;
            return highlightText == null ? new ArrayList() : highlightText.getHighlightText();
        }

        public boolean getIsLock() {
            return this.mIsLock;
        }

        public boolean getIsSdoc() {
            return this.mIsSdoc;
        }

        public boolean getIsSupportInvertedBGColor() {
            return this.mIsSupportInvertedBGColor;
        }

        public int getMaxLine() {
            return this.mMaxLine;
        }

        public int getViewMode() {
            return this.mViewMode;
        }
    }

    public TitleView(Context context) {
        super(context);
    }

    private CharSequence getContentTitle(CharSequence charSequence) {
        if (charSequence.length() > 300) {
            MainLogger.m7254d(TAG, "getTextContentTitle# textContent subSequence");
            charSequence = charSequence.subSequence(0, 300);
        }
        CharSequence charSequenceRemoveStrikethroughSpan = NotesHolderUtil.removeStrikethroughSpan(charSequence);
        if (charSequenceRemoveStrikethroughSpan.toString().contains("\u200b")) {
            charSequenceRemoveStrikethroughSpan = NotesHolderUtil.removeZeroWidthSpace(charSequenceRemoveStrikethroughSpan);
        }
        return TextUtils.isEmpty(charSequenceRemoveStrikethroughSpan.toString().replace("\n", "").trim()) ? this.mNoteTitleContract.getResources().getString(C8003R.string.noteslist_title_no_title) : charSequenceRemoveStrikethroughSpan;
    }

    private CharSequence getCoverContentTitle(CharSequence charSequence, long j, boolean z) {
        return z ? this.mNoteTitleContract.getResources().getString(C8003R.string.noteslist_title_text_ps, NotesUtils.getTitleTime(j)) : getContentTitle(charSequence);
    }

    @SuppressLint({"StringFormatInvalid"})
    private CharSequence getNoteContentTitle(CharSequence charSequence, long j) {
        return (ContentUtils.isGridViewMode(this.mNoteTitleContract.getViewMode()) && this.mNoteTitleContract.getNotesHolderInfo().hasTextOnly()) ? this.mNoteTitleContract.getResources().getString(C8003R.string.noteslist_title_text_ps, NotesUtils.getTitleTime(j)) : getContentTitle(charSequence);
    }

    private CharSequence removeNewline(CharSequence charSequence) {
        return charSequence.toString().contains("\n") ? charSequence.subSequence(0, charSequence.toString().split("\n")[0].length()) : charSequence;
    }

    public void init() {
        setVisibility(8);
    }

    public void setAutoTitle(MainListDocumentData mainListDocumentData, HighlightText highlightText, int i) {
        CharSequence string;
        if (mainListDocumentData == null) {
            return;
        }
        String recommendedTitle = mainListDocumentData.getRecommendedTitle();
        AutoTitleCreator.CreationPriority creationPriorityFind = AutoTitleCreator.CreationPriority.find(mainListDocumentData.getRecommendedTitle());
        String content = mainListDocumentData.getContent();
        boolean zIsEmpty = TextUtils.isEmpty(content);
        boolean zIsLock = NotesUtils.isLock(this.mNoteTitleContract.getNotesHolderInfo().getLockType());
        StringBuilder sb = new StringBuilder("setAutoTitle# uuid : ");
        sb.append(mainListDocumentData.getUuid());
        sb.append(", hasTextContent : ");
        sb.append(!zIsEmpty);
        sb.append(", recommendedType : ");
        sb.append(creationPriorityFind);
        sb.append(", has recommendedTitle : ");
        sb.append(!TextUtils.isEmpty(recommendedTitle));
        MainLogger.m7258i(TAG, sb.toString());
        if (zIsLock) {
            string = this.mNoteTitleContract.getContext().getString(C8003R.string.noteslist_title_lock_note);
        } else if (!TextUtils.isEmpty(mainListDocumentData.getStrokeUuid())) {
            string = this.mNoteTitleContract.getResources().getString(C8003R.string.noteslist_title_handwritten_note_ps, NotesUtils.getTitleTime(mainListDocumentData.getCreatedAt()));
        } else if (!TextUtils.isEmpty(recommendedTitle)) {
            string = NotesUtils.getRecommendedTitle(this.mNoteTitleContract.getContext(), creationPriorityFind, recommendedTitle, mainListDocumentData.getCreatedAt());
        } else if (zIsEmpty) {
            string = this.mNoteTitleContract.getResources().getString(C8003R.string.noteslist_title_no_title);
        } else {
            string = removeNewline(getNoteContentTitle(content, mainListDocumentData.getCreatedAt()));
            if (ContentUtils.isGridViewMode(this.mNoteTitleContract.getViewMode()) && !this.mNoteTitleContract.getNotesHolderInfo().hasTextOnly()) {
                i = 1;
            }
        }
        if ("null".contentEquals(string)) {
            string = this.mNoteTitleContract.getResources().getString(C8003R.string.noteslist_title_no_title);
        }
        setTitle(string, highlightText, i);
    }

    public void setCoeditAutoTitle(MainListDocumentData mainListDocumentData, HighlightText highlightText, int i) {
        String string;
        MainLogger.m7258i(TAG, "setCoeditAutoTitle");
        String coeditNoteCreatorName = SesCoeditShareReadResolver.getInstance().getCoeditNoteCreatorName(mainListDocumentData.getMdeSpaceId(), mainListDocumentData.getMdeItemId());
        if (coeditNoteCreatorName == null) {
            MainLogger.m7255e(TAG, "setCoeditAutoTitle# userInfo is null");
            string = this.mNoteTitleContract.getResources().getString(C8003R.string.noteslist_title_no_title);
        } else {
            string = TextUtils.isEmpty(coeditNoteCreatorName) ? this.mNoteTitleContract.getResources().getString(C8003R.string.noteslist_title_no_title) : this.mNoteTitleContract.getResources().getString(C8003R.string.co_edit_note_auto_title, coeditNoteCreatorName, NotesUtils.getTitleTime(mainListDocumentData.getCreatedAt()));
        }
        setTitle(string, highlightText, i);
    }

    public void setCoverAutoTitle(MainListDocumentData mainListDocumentData, boolean z) {
        if (mainListDocumentData == null) {
            return;
        }
        String recommendedTitle = mainListDocumentData.getRecommendedTitle();
        AutoTitleCreator.CreationPriority creationPriorityFind = AutoTitleCreator.CreationPriority.find(mainListDocumentData.getRecommendedTitle());
        String content = mainListDocumentData.getContent();
        setCoverTitle(!TextUtils.isEmpty(mainListDocumentData.getStrokeUuid()) ? this.mNoteTitleContract.getResources().getString(C8003R.string.noteslist_title_handwritten_note_ps, NotesUtils.getTitleTime(mainListDocumentData.getCreatedAt())) : !TextUtils.isEmpty(recommendedTitle) ? NotesUtils.getRecommendedTitle(this.mNoteTitleContract.getContext(), creationPriorityFind, recommendedTitle, mainListDocumentData.getCreatedAt()) : !TextUtils.isEmpty(content) ? removeNewline(getCoverContentTitle(content, mainListDocumentData.getCreatedAt(), z)) : this.mNoteTitleContract.getResources().getString(C8003R.string.noteslist_title_no_title));
    }

    public void setCoverTitle(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() <= 0) {
            setVisibility(8);
        } else {
            setVisibility(0);
            while (charSequence.length() >= 2 && (charSequence.charAt(0) == '\n' || charSequence.charAt(0) == '\t' || charSequence.charAt(0) == ' ')) {
                charSequence = charSequence.subSequence(1, charSequence.length());
            }
            charSequence = TextUtils.concat(LocaleUtils.isRTLMode() ? UnicodeUtils.RLM : "\u200e", charSequence);
            setMaxLines(2);
            setTextColor(getResources().getColor(C8003R.color.noteslist_item_title_color, null));
            setText(charSequence);
        }
        setTitleOriginalTitle(charSequence, ResourcesUtils.getDefaultBackgroundColor(getResources()), false, false);
    }

    public void setNoteTitleContract(ThumbnailContract thumbnailContract) {
        this.mNoteTitleContract = thumbnailContract;
    }

    public void setTitle(CharSequence charSequence, HighlightText highlightText, int i) {
        if (charSequence == null || charSequence.length() <= 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        NotesHolderInfo notesHolderInfo = this.mNoteTitleContract.getNotesHolderInfo();
        notesHolderInfo.setTitle(charSequence);
        setTitle(new TitleParam.TitleParamBuilder().setContent(charSequence).setHighlightText(highlightText).setViewMode(this.mNoteTitleContract.getViewMode()).setMaxLine(i).setBackgroundColor(notesHolderInfo.getBackgroundColor()).setIsSdoc(notesHolderInfo.isSdoc()).setIsLock(NotesUtils.isLock(notesHolderInfo.getLockType())).setIsSupportInvertedBGColor(notesHolderInfo.isSupportInvertedBGColor()).build());
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void setTitle(TitleParam titleParam) {
        String str;
        CharSequence content = titleParam.getContent();
        CharSequence charSequenceSubSequence = content;
        if (content != null) {
            int length = content.length();
            charSequenceSubSequence = content;
            if (length >= 2) {
                String strTrim = content.toString().trim();
                charSequenceSubSequence = strTrim;
                if (ContentUtils.isSimpleViewMode(titleParam.getViewMode())) {
                    charSequenceSubSequence = strTrim.subSequence(0, strTrim.toString().split("\n")[0].length());
                }
            }
        }
        setMaxLines(titleParam.getMaxLine());
        if (LocaleUtils.isRTLMode()) {
            str = UnicodeUtils.RLM;
        } else {
            str = "\u200e";
        }
        SpannableString highlightText = NotesHolderUtil.setHighlightText(this, new SpannableString(TextUtils.concat(str, charSequenceSubSequence)), titleParam.getHighlightText());
        if (highlightText == null) {
            return;
        }
        if (titleParam.getViewMode() == 1 && !titleParam.getIsSupportInvertedBGColor() && !titleParam.getIsSdoc() && !titleParam.getIsLock()) {
            if (titleParam.getBackgroundColor() == getContext().getResources().getColor(C8003R.color.composer_main_background_dark, null)) {
                setTextColor(getContext().getResources().getColor(C8003R.color.noteslist_item_title_color_white, null));
            } else {
                setTextColor(getContext().getResources().getColor(C8003R.color.noteslist_item_text_content_color_has_bg_note, null));
            }
        } else {
            setTextColor(getContext().getResources().getColor(C8003R.color.noteslist_item_title_color, null));
        }
        setTitleOriginalTitle(highlightText, titleParam.getBackgroundColor(), titleParam.getIsSdoc(), titleParam.getIsSupportInvertedBGColor());
    }
}
