package com.samsung.android.support.senl.p148nt.app.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.samsung.android.support.senl.p145cm.base.framework.view.HoverCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ResourcesUtils;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class HoverPopupTextView extends AppCompatTextView {
    public static final String TAG = "HoverPopupTextView";
    int mBackgroundColor;
    private boolean mForceHover;
    boolean mHasBackgroundColor;
    private boolean mHoverEnable;
    boolean mIsDarkBackground;
    boolean mIsSdoc;
    boolean mIsSupportInvertedBGColor;
    boolean mIsTitle;
    private CharSequence mOriginalText;

    public HoverPopupTextView(Context context) {
        super(context);
        this.mForceHover = false;
        this.mHoverEnable = true;
    }

    private void dismissHoverPopup() {
        HoverCompat.getInstance().dismiss(this);
    }

    private boolean isEllipsized() {
        int lineCount;
        return getLayout() != null && (lineCount = getLayout().getLineCount()) > 0 && getLayout().getEllipsisCount(lineCount - 1) > 0;
    }

    private void setHoverPopup() {
        TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(C8003R.layout.noteslist_hover_popup_text, (ViewGroup) null, false);
        textView.setText(this.mOriginalText);
        textView.getBackground().setTint(this.mBackgroundColor);
        if (this.mIsSupportInvertedBGColor || this.mIsSdoc) {
            textView.setTextColor(getResources().getColor(C8003R.color.noteslist_item_title_color, null));
        } else if (!this.mHasBackgroundColor || !this.mIsDarkBackground) {
            textView.setTextColor(getResources().getColor(C8003R.color.noteslist_item_text_content_color_has_bg_note, null));
        } else if (this.mIsTitle) {
            textView.setTextColor(getResources().getColor(C8003R.color.noteslist_item_title_color_white, null));
        } else {
            textView.setTextColor(getResources().getColor(C8003R.color.noteslist_item_text_content_color_black_bg_note, null));
        }
        HoverCompat.getInstance().setCustomView(this, textView);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (!this.mHoverEnable || motionEvent.getToolType(0) != 2) {
            return super.onHoverEvent(motionEvent);
        }
        if (HoverCompat.getInstance().getHoverPopup(this) != null && (this.mForceHover || isEllipsized())) {
            int action = motionEvent.getAction();
            if (action == 9) {
                setHoverPopup();
            } else if (action == 10) {
                dismissHoverPopup();
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    public void setOriginalText(CharSequence charSequence) {
        setText((CharSequence) null);
        this.mIsTitle = false;
        this.mOriginalText = charSequence;
        HoverCompat.getInstance().setPopupType(this, 0);
        setText(this.mOriginalText);
    }

    public void setTitleOriginalTitle(CharSequence charSequence, int i, boolean z, boolean z2) {
        setOriginalText(charSequence, i, z, z2, false, true);
        this.mIsTitle = true;
    }

    public HoverPopupTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mForceHover = false;
        this.mHoverEnable = true;
    }

    public void setOriginalText(CharSequence charSequence, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        setText((CharSequence) null);
        this.mIsTitle = false;
        this.mOriginalText = charSequence;
        this.mIsSdoc = z;
        this.mIsSupportInvertedBGColor = z2;
        this.mForceHover = z3;
        this.mHoverEnable = z4;
        HoverCompat.getInstance().setPopupType(this, 0);
        setText(this.mOriginalText);
        if (ContentUtils.hasBackgroundColorNotes(i, z)) {
            this.mHasBackgroundColor = true;
            if (i == getResources().getColor(C8003R.color.composer_main_background_dark, null)) {
                this.mIsDarkBackground = true;
                this.mBackgroundColor = getResources().getColor(NotesUtils.getAntiGreenisFilteredColor(C8003R.color.noteslist_card_view_bg_color_black), null);
                return;
            } else {
                this.mIsDarkBackground = false;
                this.mBackgroundColor = i;
                return;
            }
        }
        this.mHasBackgroundColor = false;
        this.mIsDarkBackground = false;
        if (!this.mIsSupportInvertedBGColor && !z) {
            this.mBackgroundColor = ResourcesUtils.getDefaultBackgroundColor(getResources());
        } else {
            this.mBackgroundColor = getResources().getColor(NotesUtils.getAntiGreenisFilteredColor(C8003R.color.basic_list_item_bg_color), null);
        }
    }

    public HoverPopupTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mForceHover = false;
        this.mHoverEnable = true;
    }
}
