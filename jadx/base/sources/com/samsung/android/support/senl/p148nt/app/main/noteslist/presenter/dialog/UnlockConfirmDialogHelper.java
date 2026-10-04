package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.app.C8003R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class UnlockConfirmDialogHelper {
    private final Caller mCaller;
    private final Context mContext;
    private final boolean mIsSaveAs;
    private final int mLockedNotesCount;
    private String mMessage;
    private String mNegativeButton;
    private String mPositiveButton;
    private String mTitle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Caller {
        PICKER,
        SHARE,
        SHARE_NO_PROVIDER,
        IMPORT_NOTE
    }

    public UnlockConfirmDialogHelper(Context context, Caller caller, int i, boolean z) {
        this.mContext = context;
        this.mCaller = caller;
        this.mLockedNotesCount = i;
        this.mIsSaveAs = z;
        init();
    }

    public Caller getCaller() {
        return this.mCaller;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getNegativeButton() {
        return this.mNegativeButton;
    }

    public String getPositiveButton() {
        return this.mPositiveButton;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void init() {
        String string;
        Context context;
        int i;
        String string2;
        Context context2;
        int i2;
        Caller caller = this.mCaller;
        if (caller != Caller.SHARE) {
            if (caller == Caller.SHARE_NO_PROVIDER) {
                this.mMessage = this.mContext.getString(this.mIsSaveAs ? C8003R.string.save_as_except_lock_notes : C8003R.string.share_except_lock_notes);
                this.mPositiveButton = this.mContext.getString(this.mIsSaveAs ? C8003R.string.save_as : C8003R.string.action_share);
                this.mNegativeButton = this.mContext.getString(C8003R.string.dialog_cancel);
                return;
            } else {
                if (caller == Caller.IMPORT_NOTE) {
                    int i4 = this.mLockedNotesCount;
                    this.mTitle = i4 > 1 ? this.mContext.getString(C8003R.string.locked_notes_confirm_title, Integer.valueOf(i4)) : this.mContext.getString(C8003R.string.locked_note_confirm_title);
                    this.mMessage = this.mLockedNotesCount > 1 ? this.mContext.getString(C8003R.string.share_locked_notes_content) : this.mContext.getString(C8003R.string.share_locked_note_content);
                    this.mPositiveButton = this.mContext.getString(C8003R.string.dialog_continue);
                    this.mNegativeButton = this.mContext.getString(C8003R.string.dialog_cancel);
                    return;
                }
                if (caller == Caller.PICKER) {
                    this.mTitle = this.mContext.getString(C8003R.string.locked_note_confirm_title);
                    this.mMessage = this.mContext.getString(C8003R.string.widget_dialog_unlock_for_widget);
                    this.mPositiveButton = this.mContext.getString(C8003R.string.action_more_unlock);
                    this.mNegativeButton = this.mContext.getString(C8003R.string.dialog_cancel);
                    return;
                }
                return;
            }
        }
        if (this.mIsSaveAs) {
            int i5 = this.mLockedNotesCount;
            string = i5 > 1 ? this.mContext.getString(C8003R.string.locked_notes_confirm_title, Integer.valueOf(i5)) : this.mContext.getString(C8003R.string.locked_note_confirm_title);
        } else {
            string = this.mContext.getString(C8003R.string.share_locked_notes_title);
        }
        this.mTitle = string;
        if (this.mIsSaveAs) {
            if (this.mLockedNotesCount > 1) {
                context2 = this.mContext;
                i2 = C8003R.string.save_locked_notes_content;
            } else {
                context2 = this.mContext;
                i2 = C8003R.string.save_locked_note_content;
            }
            string2 = context2.getString(i2);
        } else {
            if (this.mLockedNotesCount > 1) {
                context = this.mContext;
                i = C8003R.string.share_locked_notes_content;
            } else {
                context = this.mContext;
                i = C8003R.string.share_locked_note_content;
            }
            string2 = context.getString(i);
        }
        this.mMessage = string2;
        this.mPositiveButton = this.mIsSaveAs ? this.mContext.getString(C8003R.string.action_more_unlock) : this.mContext.getString(C8003R.string.share_locked_notes_positive);
        this.mNegativeButton = this.mContext.getString(C8003R.string.dialog_cancel);
    }
}
