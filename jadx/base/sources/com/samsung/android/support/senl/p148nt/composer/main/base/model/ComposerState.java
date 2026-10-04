package com.samsung.android.support.senl.p148nt.composer.main.base.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.p153ai.drawing.AiDrawingState;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerState implements Parcelable {
    public static final String KEY_STATE = "composer_state_key";
    static final int REQUEST_CODE_INVALID = -1;
    private AiDrawingState mAiDrawingState;
    private int mFoldState;
    private boolean mIsBackgroundColorInverted;
    private boolean mIsBlockedSip;
    private boolean mIsDeleteOnlyMode;
    private boolean mIsEditable;
    private boolean mIsExceptionalSIPStateHiddenOnUos;
    private boolean mIsFinishAfterSave;
    private boolean mIsFullScreenMode;
    private boolean mIsInAppCollaborationMode;
    private boolean mIsLaserPenMode;
    private boolean mIsLastStateLockCanvas;
    private boolean mIsMoveOnlyMode;
    private boolean mIsNeedGuideView;
    private boolean mIsRunningCoverEditor;
    private boolean mIsRunningDrawing;
    private boolean mIsSaved;
    private boolean mIsSecured;
    private boolean mIsSupportedAiCover;
    private boolean mIsSupportedAiMenu;
    private boolean mIsSupportedSolveMath;
    private boolean mIsTranslated;
    private boolean mIsUsingViewMode;
    private int mLastRequestCode;
    private String mMode;
    private String mPrevMode;
    private int mTitleMaxLength;
    private static final String TAG = Logger.createTag(com.samsung.android.support.senl.p148nt.composer.main.simple.model.ComposerState.KEY_STATE);
    public static final Parcelable.Creator<ComposerState> CREATOR = new Parcelable.Creator<ComposerState>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.ComposerState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ComposerState createFromParcel(Parcel parcel) {
            return new ComposerState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ComposerState[] newArray(int i) {
            return new ComposerState[i];
        }
    };

    public ComposerState() {
        this.mIsEditable = true;
        this.mIsBackgroundColorInverted = false;
        this.mIsFinishAfterSave = false;
        this.mLastRequestCode = -1;
        this.mTitleMaxLength = 50;
        this.mFoldState = 0;
        this.mIsUsingViewMode = false;
        this.mIsExceptionalSIPStateHiddenOnUos = false;
        this.mIsSupportedAiMenu = false;
        this.mIsSupportedSolveMath = false;
        this.mIsSupportedAiCover = false;
        this.mIsNeedGuideView = true;
        this.mAiDrawingState = AiDrawingState.NONE;
    }

    public void blockSip(boolean z) {
        this.mIsBlockedSip = z;
    }

    public void clearLastRequestCode() {
        this.mLastRequestCode = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void disableIsNeedGuideView() {
        this.mIsNeedGuideView = false;
    }

    public AiDrawingState getAiDrawingState() {
        return this.mAiDrawingState;
    }

    public int getFoldState() {
        return this.mFoldState;
    }

    public boolean getIsExceptionalSIPStateHiddenOnUos() {
        return this.mIsExceptionalSIPStateHiddenOnUos;
    }

    public int getLastRequestCode() {
        return this.mLastRequestCode;
    }

    public String getMode() {
        return this.mMode;
    }

    public String getPrevMode() {
        return this.mPrevMode;
    }

    public int getTitleMaxLength() {
        return this.mTitleMaxLength;
    }

    public boolean isBackgroundColorInverted() {
        return this.mIsBackgroundColorInverted;
    }

    public boolean isBlockedSip() {
        return this.mIsBlockedSip;
    }

    public boolean isDeleteOnlyMode() {
        return this.mIsDeleteOnlyMode;
    }

    public boolean isEditable() {
        return this.mIsEditable;
    }

    public boolean isFinishAfterSave() {
        return this.mIsFinishAfterSave;
    }

    public boolean isFullScreenMode() {
        return this.mIsFullScreenMode;
    }

    public boolean isInAppCollaborationMode() {
        return this.mIsInAppCollaborationMode;
    }

    public boolean isLaserPenMode() {
        return this.mIsLaserPenMode;
    }

    public boolean isLastStateLockCanvas() {
        return this.mIsLastStateLockCanvas;
    }

    public boolean isMoveOnlyMode() {
        return this.mIsMoveOnlyMode;
    }

    public boolean isNeedGuideView() {
        return this.mIsNeedGuideView;
    }

    public boolean isRunningCoverEditor() {
        return this.mIsRunningCoverEditor;
    }

    public boolean isRunningDrawing() {
        return this.mIsRunningDrawing;
    }

    public boolean isSaved() {
        return this.mIsSaved;
    }

    public boolean isSecured() {
        return this.mIsSecured;
    }

    public boolean isSupportedAiCover() {
        return this.mIsSupportedAiCover;
    }

    public boolean isSupportedAiMenu() {
        return this.mIsSupportedAiMenu;
    }

    public boolean isSupportedSolveMath() {
        return this.mIsSupportedSolveMath;
    }

    public boolean isTranslated() {
        return this.mIsTranslated;
    }

    public boolean isUsingViewMode() {
        return this.mIsUsingViewMode;
    }

    public void restoreState(Bundle bundle) {
        ComposerState composerState = (ComposerState) bundle.getParcelable(KEY_STATE);
        if (composerState == null) {
            return;
        }
        this.mMode = composerState.getMode();
        this.mPrevMode = composerState.getPrevMode();
        this.mIsEditable = composerState.isEditable();
        this.mIsSecured = composerState.isSecured();
        this.mIsBlockedSip = composerState.isBlockedSip();
        this.mIsRunningDrawing = composerState.isRunningDrawing();
        this.mIsBackgroundColorInverted = composerState.isBackgroundColorInverted();
        this.mIsLastStateLockCanvas = composerState.isLastStateLockCanvas();
        this.mIsFullScreenMode = composerState.isFullScreenMode();
        this.mIsInAppCollaborationMode = composerState.isInAppCollaborationMode();
        this.mIsFinishAfterSave = composerState.isFinishAfterSave();
        this.mLastRequestCode = composerState.getLastRequestCode();
        this.mIsDeleteOnlyMode = composerState.isDeleteOnlyMode();
        this.mTitleMaxLength = composerState.getTitleMaxLength();
        this.mFoldState = composerState.getFoldState();
        this.mIsSaved = composerState.isSaved();
        this.mIsUsingViewMode = composerState.isUsingViewMode();
        this.mIsSupportedAiMenu = composerState.isSupportedAiMenu();
        this.mIsSupportedSolveMath = composerState.isSupportedSolveMath();
        this.mIsSupportedAiCover = composerState.isSupportedAiCover();
        this.mIsRunningCoverEditor = composerState.isRunningCoverEditor();
        this.mIsNeedGuideView = composerState.isNeedGuideView();
        this.mIsMoveOnlyMode = composerState.isMoveOnlyMode();
        this.mIsLaserPenMode = composerState.isLaserPenMode();
        this.mAiDrawingState = composerState.getAiDrawingState();
    }

    public void setAiDrawingState(AiDrawingState aiDrawingState) {
        this.mAiDrawingState = aiDrawingState;
    }

    public void setBackgroundColorInverted(boolean z) {
        this.mIsBackgroundColorInverted = z;
    }

    public void setDeleteOnlyMode(boolean z) {
        this.mIsDeleteOnlyMode = z;
    }

    public void setEditable(boolean z) {
        this.mIsEditable = z;
    }

    public void setFinishAfterSave(boolean z) {
        this.mIsFinishAfterSave = z;
    }

    public void setFoldState(int i) {
        this.mFoldState = i;
    }

    public void setIsExceptionalSIPStateHiddenOnUos(boolean z) {
        AbstractC8014b.m7220v("setIsExceptionalSIPStateHiddenOnUos# ", TAG, z);
        this.mIsExceptionalSIPStateHiddenOnUos = z;
    }

    public void setIsFullScreenMode(boolean z) {
        this.mIsFullScreenMode = z;
    }

    public void setIsInAppCollaborationMode(boolean z) {
        this.mIsInAppCollaborationMode = z;
    }

    public void setIsSaved(boolean z) {
        this.mIsSaved = z;
    }

    public void setIsSupportedAiCover(boolean z) {
        this.mIsSupportedAiCover = z;
        AbstractC8014b.m7222x(new StringBuilder("setIsSupportedAiCover# "), this.mIsSupportedAiCover, TAG);
    }

    public void setIsSupportedAiMenu(boolean z) {
        this.mIsSupportedAiMenu = z;
        AbstractC8014b.m7222x(new StringBuilder("mIsSupportedAiMenu# "), this.mIsSupportedAiMenu, TAG);
    }

    public void setIsSupportedSolveMath(boolean z) {
        this.mIsSupportedSolveMath = z;
        AbstractC8014b.m7222x(new StringBuilder("setIsSupportedSolveMath# "), this.mIsSupportedSolveMath, TAG);
    }

    public void setIsUsingViewMode(boolean z) {
        this.mIsUsingViewMode = z;
        AbstractC8014b.m7222x(new StringBuilder("mIsUsingViewMode# "), this.mIsUsingViewMode, TAG);
    }

    public void setLaserPenMode(boolean z) {
        this.mIsLaserPenMode = z;
    }

    public void setLastRequestCode(int i) {
        AbstractC0000a.m3D(i, "setLastRequestCode# ", TAG);
        this.mLastRequestCode = i;
    }

    public void setLastStateLockCanvas(boolean z) {
        this.mIsLastStateLockCanvas = z;
    }

    public void setMode(String str) {
        this.mMode = str;
    }

    public void setMoveOnlyMode(boolean z) {
        this.mIsMoveOnlyMode = z;
    }

    public void setPrevMode(String str) {
        this.mPrevMode = str;
    }

    public void setRunningCoverEditor(boolean z) {
        this.mIsRunningCoverEditor = z;
        AbstractC8014b.m7222x(new StringBuilder("setRunningCoverEditor# "), this.mIsRunningCoverEditor, TAG);
    }

    public void setRunningDrawing(boolean z) {
        this.mIsRunningDrawing = z;
    }

    public void setSecured(boolean z) {
        this.mIsSecured = z;
        setEditable(!z);
    }

    public void setTitleMaxLength(int i) {
        this.mTitleMaxLength = i;
    }

    public void setTranslated(boolean z) {
        this.mIsTranslated = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mMode);
        parcel.writeString(this.mPrevMode);
        parcel.writeByte(this.mIsEditable ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsSecured ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsBlockedSip ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsRunningDrawing ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsBackgroundColorInverted ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsLastStateLockCanvas ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsFullScreenMode ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsInAppCollaborationMode ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsFinishAfterSave ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mLastRequestCode);
        parcel.writeByte(this.mIsDeleteOnlyMode ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mTitleMaxLength);
        parcel.writeInt(this.mFoldState);
        parcel.writeByte(this.mIsSaved ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsUsingViewMode ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsSupportedAiMenu ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsSupportedSolveMath ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsSupportedAiCover ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsRunningCoverEditor ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsNeedGuideView ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsMoveOnlyMode ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsLaserPenMode ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mAiDrawingState.toString());
    }

    public ComposerState(Parcel parcel) {
        this.mIsEditable = true;
        this.mMode = parcel.readString();
        this.mPrevMode = parcel.readString();
        this.mIsEditable = parcel.readByte() != 0;
        this.mIsSecured = parcel.readByte() != 0;
        this.mIsBlockedSip = parcel.readByte() != 0;
        this.mIsRunningDrawing = parcel.readByte() != 0;
        this.mIsBackgroundColorInverted = parcel.readByte() != 0;
        this.mIsLastStateLockCanvas = parcel.readByte() != 0;
        this.mIsFullScreenMode = parcel.readByte() != 0;
        this.mIsInAppCollaborationMode = parcel.readByte() != 0;
        this.mIsFinishAfterSave = parcel.readByte() != 0;
        this.mLastRequestCode = parcel.readInt();
        this.mIsDeleteOnlyMode = parcel.readByte() != 0;
        this.mTitleMaxLength = parcel.readInt();
        this.mFoldState = parcel.readInt();
        this.mIsSaved = parcel.readByte() != 0;
        this.mIsUsingViewMode = parcel.readByte() != 0;
        this.mIsSupportedAiMenu = parcel.readByte() != 0;
        this.mIsSupportedSolveMath = parcel.readByte() != 0;
        this.mIsSupportedAiCover = parcel.readByte() != 0;
        this.mIsRunningCoverEditor = parcel.readByte() != 0;
        this.mIsNeedGuideView = parcel.readByte() != 0;
        this.mIsMoveOnlyMode = parcel.readByte() != 0;
        this.mIsLaserPenMode = parcel.readByte() != 0;
        String string = parcel.readString();
        this.mAiDrawingState = TextUtils.isEmpty(string) ? AiDrawingState.NONE : AiDrawingState.valueOf(string);
    }
}
