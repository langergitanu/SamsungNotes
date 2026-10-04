package com.samsung.android.sdk.pen.text;

import android.text.Editable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.text.SpenInputManager;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\r"}, m13886d2 = {"com/samsung/android/sdk/pen/text/SpenInputManager$mPreUpdateTextListener$1", "Lcom/samsung/android/sdk/pen/text/SpenInputManager$PreUpdateTextListener;", "onInsertText", "", "str", "", "start", "", "expandPara", "onInsertTextCursor", "onReplaceText", "before", "onRemoveText", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenInputManager$mPreUpdateTextListener$1 implements SpenInputManager.PreUpdateTextListener {
    final /* synthetic */ SpenInputManager this$0;

    public SpenInputManager$mPreUpdateTextListener$1(SpenInputManager spenInputManager) {
        this.this$0 = spenInputManager;
    }

    @Override // com.samsung.android.sdk.pen.text.SpenInputManager.PreUpdateTextListener
    public boolean onInsertText(String str, int start, boolean expandPara) {
        Intrinsics.checkNotNullParameter(str, "str");
        SpenWNote wNote = this.this$0.getWNote();
        SpenObjectTextBox bodyText = wNote != null ? wNote.getBodyText() : null;
        if (this.this$0.mBodyTextContext != null && bodyText != null) {
            SpenWNote spenWNote = this.this$0.mBodyTextContextDocument;
            SpenObjectTextBox bodyText2 = spenWNote != null ? spenWNote.getBodyText() : null;
            if (bodyText2 != null) {
                bodyText2.copy(bodyText);
            }
            if (bodyText2 != null) {
                bodyText2.insertText(str, start, expandPara);
            }
            SpenBodyTextContext spenBodyTextContext = this.this$0.mBodyTextContext;
            Intrinsics.checkNotNull(spenBodyTextContext);
            spenBodyTextContext.measureText();
            SpenBodyTextContext spenBodyTextContext2 = this.this$0.mBodyTextContext;
            Intrinsics.checkNotNull(spenBodyTextContext2);
            int measuredHeight = spenBodyTextContext2.getMeasuredHeight();
            SpenWNote wNote2 = this.this$0.getWNote();
            Integer numValueOf = wNote2 != null ? Integer.valueOf(wNote2.getHeight()) : null;
            Intrinsics.checkNotNull(numValueOf);
            if (measuredHeight > numValueOf.intValue()) {
                Editable mEditable = this.this$0.getMEditable();
                if (mEditable != null) {
                    SpenInputManager spenInputManager = this.this$0;
                    spenInputManager.mIsInputBlockedDueToNoteHeightLimit = true;
                    mEditable.delete(start, str.length() + start);
                    SpenTextLimitListener spenTextLimitListener = spenInputManager.mTextLimitListener;
                    if (spenTextLimitListener != null) {
                        spenTextLimitListener.onExceedMaxHeight();
                    }
                    spenInputManager.mIsInputBlockedDueToNoteHeightLimit = false;
                }
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.android.sdk.pen.text.SpenInputManager.PreUpdateTextListener
    public boolean onInsertTextCursor(String str) {
        SpenObjectTextBox bodyText;
        Intrinsics.checkNotNullParameter(str, "str");
        SpenWNote wNote = this.this$0.getWNote();
        SpenObjectTextBox bodyText2 = wNote != null ? wNote.getBodyText() : null;
        if (this.this$0.mBodyTextContext != null && bodyText2 != null) {
            SpenWNote spenWNote = this.this$0.mBodyTextContextDocument;
            SpenObjectTextBox bodyText3 = spenWNote != null ? spenWNote.getBodyText() : null;
            SpenWNote wNote2 = this.this$0.getWNote();
            Integer numValueOf = (wNote2 == null || (bodyText = wNote2.getBodyText()) == null) ? null : Integer.valueOf(bodyText.getCursorPosition());
            Intrinsics.checkNotNull(numValueOf);
            int iIntValue = numValueOf.intValue();
            if (bodyText3 != null) {
                bodyText3.copy(bodyText2);
            }
            if (bodyText3 != null) {
                bodyText3.setCursorPosition(iIntValue);
            }
            if (bodyText3 != null) {
                bodyText3.insertTextAtCursor(str);
            }
            SpenBodyTextContext spenBodyTextContext = this.this$0.mBodyTextContext;
            Intrinsics.checkNotNull(spenBodyTextContext);
            spenBodyTextContext.measureText();
            SpenBodyTextContext spenBodyTextContext2 = this.this$0.mBodyTextContext;
            Intrinsics.checkNotNull(spenBodyTextContext2);
            int measuredHeight = spenBodyTextContext2.getMeasuredHeight();
            SpenWNote wNote3 = this.this$0.getWNote();
            Integer numValueOf2 = wNote3 != null ? Integer.valueOf(wNote3.getHeight()) : null;
            Intrinsics.checkNotNull(numValueOf2);
            if (measuredHeight > numValueOf2.intValue()) {
                Editable mEditable = this.this$0.getMEditable();
                if (mEditable != null) {
                    SpenInputManager spenInputManager = this.this$0;
                    spenInputManager.mIsInputBlockedDueToNoteHeightLimit = true;
                    mEditable.delete(iIntValue, str.length() + iIntValue);
                    SpenTextLimitListener spenTextLimitListener = spenInputManager.mTextLimitListener;
                    if (spenTextLimitListener != null) {
                        spenTextLimitListener.onExceedMaxHeight();
                    }
                    spenInputManager.mIsInputBlockedDueToNoteHeightLimit = false;
                }
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.android.sdk.pen.text.SpenInputManager.PreUpdateTextListener
    public boolean onRemoveText(int start, int before) {
        String strSubstring;
        SpenWNote wNote = this.this$0.getWNote();
        SpenObjectTextBox bodyText = wNote != null ? wNote.getBodyText() : null;
        if (this.this$0.mBodyTextContext != null && bodyText != null) {
            SpenWNote spenWNote = this.this$0.mBodyTextContextDocument;
            SpenObjectTextBox bodyText2 = spenWNote != null ? spenWNote.getBodyText() : null;
            if (bodyText2 != null) {
                bodyText2.copy(bodyText);
            }
            if (bodyText2 != null) {
                bodyText2.removeText(start, before);
            }
            String text = bodyText.getText();
            if (text != null) {
                strSubstring = text.substring(start, before + start);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            } else {
                strSubstring = null;
            }
            SpenBodyTextContext spenBodyTextContext = this.this$0.mBodyTextContext;
            Intrinsics.checkNotNull(spenBodyTextContext);
            spenBodyTextContext.measureText();
            SpenBodyTextContext spenBodyTextContext2 = this.this$0.mBodyTextContext;
            Intrinsics.checkNotNull(spenBodyTextContext2);
            int measuredHeight = spenBodyTextContext2.getMeasuredHeight();
            AbstractC2322a.m1631u(measuredHeight, "PreUpdateTextContentListener onRemoveText ", "SpenInputManager");
            SpenWNote wNote2 = this.this$0.getWNote();
            Integer numValueOf = wNote2 != null ? Integer.valueOf(wNote2.getHeight()) : null;
            Intrinsics.checkNotNull(numValueOf);
            if (measuredHeight > numValueOf.intValue()) {
                Editable mEditable = this.this$0.getMEditable();
                if (mEditable != null) {
                    SpenInputManager spenInputManager = this.this$0;
                    spenInputManager.mIsInputBlockedDueToNoteHeightLimit = true;
                    mEditable.insert(start, strSubstring);
                    SpenTextLimitListener spenTextLimitListener = spenInputManager.mTextLimitListener;
                    if (spenTextLimitListener != null) {
                        spenTextLimitListener.onExceedMaxHeight();
                    }
                    spenInputManager.mIsInputBlockedDueToNoteHeightLimit = false;
                }
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.android.sdk.pen.text.SpenInputManager.PreUpdateTextListener
    public boolean onReplaceText(String str, int start, int before) {
        String strSubstring;
        Intrinsics.checkNotNullParameter(str, "str");
        SpenWNote wNote = this.this$0.getWNote();
        SpenObjectTextBox bodyText = wNote != null ? wNote.getBodyText() : null;
        if (this.this$0.mBodyTextContext != null && bodyText != null) {
            SpenWNote spenWNote = this.this$0.mBodyTextContextDocument;
            SpenObjectTextBox bodyText2 = spenWNote != null ? spenWNote.getBodyText() : null;
            if (bodyText2 != null) {
                bodyText2.copy(bodyText);
            }
            if (bodyText2 != null) {
                bodyText2.replaceText(str, start, before);
            }
            String text = bodyText.getText();
            if (text != null) {
                strSubstring = text.substring(start, before + start);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            } else {
                strSubstring = null;
            }
            SpenBodyTextContext spenBodyTextContext = this.this$0.mBodyTextContext;
            Intrinsics.checkNotNull(spenBodyTextContext);
            spenBodyTextContext.measureText();
            SpenBodyTextContext spenBodyTextContext2 = this.this$0.mBodyTextContext;
            Intrinsics.checkNotNull(spenBodyTextContext2);
            int measuredHeight = spenBodyTextContext2.getMeasuredHeight();
            SpenWNote wNote2 = this.this$0.getWNote();
            Integer numValueOf = wNote2 != null ? Integer.valueOf(wNote2.getHeight()) : null;
            Intrinsics.checkNotNull(numValueOf);
            if (measuredHeight > numValueOf.intValue()) {
                Editable mEditable = this.this$0.getMEditable();
                if (mEditable != null) {
                    SpenInputManager spenInputManager = this.this$0;
                    spenInputManager.mIsInputBlockedDueToNoteHeightLimit = true;
                    mEditable.replace(start, str.length() + start, strSubstring);
                    spenInputManager.restartInputConnection();
                    SpenTextLimitListener spenTextLimitListener = spenInputManager.mTextLimitListener;
                    if (spenTextLimitListener != null) {
                        spenTextLimitListener.onExceedMaxHeight();
                    }
                    spenInputManager.mIsInputBlockedDueToNoteHeightLimit = false;
                }
                return false;
            }
        }
        return true;
    }
}
