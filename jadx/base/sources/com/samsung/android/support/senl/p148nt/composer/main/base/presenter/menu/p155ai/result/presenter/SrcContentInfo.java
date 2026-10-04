package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.content.Context;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfCursorPosition;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiBixbyParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking.Chunk;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking.ChunkSizePolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking.DefaultBoundaryPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking.InputChunkingPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking.ModelInputChunker;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.span.ResolvableSpanObject;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SrcContentInfo implements Parcelable {
    private AiBixbyParam mAiBixbyParam;
    private List<Chunk> mChunkList;
    private int mCompletedIndex;
    private boolean mDirtyFlag;
    public int mEndPos;
    private String mGenerateStyle;
    private String mInputFilePath;
    private int mInputIndex;
    public boolean mIsBGColorInverted;
    public boolean mIsConvertibleColor;
    private boolean mIsSelected;
    public ArrayList<RectF> mLineRectFList;
    private List<String> mOutputFilePaths;
    public boolean mOverwriteNextLineFlag;
    public PdfSelectionPos mPdfEndPos;
    public PdfSelectionPos mPdfStartPos;
    public ArrayList<SpenTextSpanBase> mRecognizedTextSpanList;
    private String mSAForAIScenario;
    private String mSAForAIScenarioScreenID;
    public RectF mSelectedRectF;
    private String mSelectedText;
    private List<ResolvableSpanObject> mSpanObjectList;
    public SpenWNote mSrcNote;
    public int mSrcPageEndIndex;
    public int mSrcPageIndex;
    public int mSrcType;
    public int mStartPos;
    private String mSubResultText;
    private String mTextData;
    private static final String TAG = Logger.createTag("SrcContentInfo", AiConstants.PREFIX_TAG);
    public static final Parcelable.Creator<SrcContentInfo> CREATOR = new Parcelable.Creator<SrcContentInfo>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.SrcContentInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SrcContentInfo createFromParcel(Parcel parcel) {
            return new SrcContentInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SrcContentInfo[] newArray(int i) {
            return new SrcContentInfo[i];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SrcType {
        public static final int SRC_TYPE_BODY_TEXT = 1;
        public static final int SRC_TYPE_HW = 2;
        public static final int SRC_TYPE_NONE = -1;
        public static final int SRC_TYPE_PDF = 0;
        public static final int SRC_TYPE_STROKE_FOR_IMAGE = 3;
        public static final int SRC_TYPE_TEMPLATE = 4;
    }

    public SrcContentInfo(String str, int i, int i2, List<ResolvableSpanObject> list) {
        this.mSelectedText = "";
        this.mOverwriteNextLineFlag = true;
        this.mIsConvertibleColor = false;
        this.mIsBGColorInverted = false;
        this.mSAForAIScenario = "";
        this.mSAForAIScenarioScreenID = "802";
        this.mIsSelected = true;
        this.mDirtyFlag = false;
        this.mSubResultText = null;
        this.mAiBixbyParam = new AiBixbyParam();
        this.mInputIndex = 0;
        this.mCompletedIndex = -1;
        this.mSelectedText = str;
        this.mStartPos = i;
        this.mEndPos = i2;
        this.mSrcType = 1;
        this.mSpanObjectList = list;
    }

    private boolean isChinaAiFeature() {
        return CscFeature.INSTANCE.getInstance().isChinaAiFeature();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$chunk$0(char c, char c2) {
        return c2 == '\n' || c2 == '\t' || c2 == 12290;
    }

    public void chunk(ChunkSizePolicy chunkSizePolicy) {
        String selectedText = getSelectedText();
        if (!isChinaAiFeature() && chunkSizePolicy.getUnitMaxLength() >= 5000 && selectedText.length() > 5000) {
            Logger.m10999d(TAG, "chunk# len: " + selectedText.length());
            chunkSizePolicy = chunkSizePolicy.copy(chunkSizePolicy.getUnitMinLength(), selectedText.length() / 2, chunkSizePolicy.getExtraLength(), chunkSizePolicy.getSplitLastIfExceedsMax());
        }
        ModelInputChunker modelInputChunkerBuild = ModelInputChunker.builder().policy(InputChunkingPolicy.builder().boundary(isChinaAiFeature() ? new C9471p() : DefaultBoundaryPolicy.INSTANCE).chunkSize(chunkSizePolicy).build()).build();
        List<ResolvableSpanObject> list = this.mSpanObjectList;
        if (list == null) {
            this.mChunkList = modelInputChunkerBuild.chunk(selectedText);
        } else {
            this.mChunkList = modelInputChunkerBuild.chunk(selectedText, list);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AiBixbyParam getAiBixbyParam() {
        return this.mAiBixbyParam;
    }

    public List<Chunk> getChunkList() {
        return this.mChunkList;
    }

    public int getCompletedIndex() {
        return this.mCompletedIndex;
    }

    public String getGenerateStyle() {
        return this.mGenerateStyle;
    }

    public String getInputFilePath() {
        return this.mInputFilePath;
    }

    public int getInputIndex() {
        return this.mInputIndex;
    }

    public List<String> getInputList() {
        List<Chunk> list = this.mChunkList;
        return list == null ? new ArrayList() : (List) list.stream().map(new C9461f(3)).collect(Collectors.toList());
    }

    public String getNextInput() {
        List<Chunk> list = this.mChunkList;
        if (list != null) {
            int size = list.size();
            int i = this.mInputIndex;
            if (size > i) {
                List<Chunk> list2 = this.mChunkList;
                this.mInputIndex = i + 1;
                return list2.get(i).getText();
            }
        }
        Logger.m11000e(TAG, "getNextInput# out of bounds or mChunkList is null");
        return "";
    }

    public String getNextResolvedInput() {
        List<Chunk> list = this.mChunkList;
        if (list != null) {
            int size = list.size();
            int i = this.mInputIndex;
            if (size > i) {
                List<Chunk> list2 = this.mChunkList;
                this.mInputIndex = i + 1;
                return list2.get(i).getResolvedText();
            }
        }
        Logger.m11000e(TAG, "getNextResolvedInput# out of bounds or mChunkList is null");
        return "";
    }

    public List<String> getOutputFilePaths() {
        return this.mOutputFilePaths;
    }

    public String getSAForAIScenario() {
        return this.mSAForAIScenario;
    }

    public String getSAForAIScenarioScreenID() {
        return this.mSAForAIScenarioScreenID;
    }

    @NonNull
    public String getSelectedText() {
        return TextUtils.isEmpty(this.mSelectedText) ? "" : this.mSelectedText;
    }

    public int getSrcType() {
        return this.mSrcType;
    }

    public String getSubResultText() {
        return this.mSubResultText;
    }

    public String getTextData() {
        return this.mTextData;
    }

    public boolean hasDirty() {
        return this.mDirtyFlag;
    }

    public boolean hasNextInputUnit() {
        List<Chunk> list = this.mChunkList;
        return list != null && this.mInputIndex < list.size();
    }

    public boolean isOverwriteNextLineFlag() {
        return this.mOverwriteNextLineFlag;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public void resetInputIndex() {
        this.mInputIndex = 0;
        this.mCompletedIndex = -1;
    }

    public void setAiBixbyParam(AiBixbyParam aiBixbyParam) {
        this.mAiBixbyParam = aiBixbyParam;
    }

    public void setBGColorInverted(Context context, SpenWNote spenWNote) {
        if (spenWNote.getPage(0).getBackgroundColor() == BackgroundColorUtil.getBlackColor(context)) {
            this.mIsBGColorInverted = true;
        }
    }

    public void setCompletedIndex(int i) {
        this.mCompletedIndex = i;
    }

    public void setConvertibleColor(boolean z) {
        this.mIsConvertibleColor = z;
    }

    public void setDirty(boolean z) {
        this.mDirtyFlag = z;
    }

    public SrcContentInfo setGenerateTheme(String str) {
        this.mGenerateStyle = str;
        return this;
    }

    public SrcContentInfo setInputFilePath(@NonNull String str) {
        this.mInputFilePath = str;
        return this;
    }

    public void setInputIndex(int i) {
        this.mInputIndex = i;
    }

    public SrcContentInfo setLineRectFList(ArrayList<RectF> arrayList) {
        this.mLineRectFList = arrayList;
        return this;
    }

    public SrcContentInfo setOutputFilePaths(List<String> list) {
        this.mOutputFilePaths = list;
        return this;
    }

    public void setOverwriteNextLineFlag(boolean z) {
        this.mOverwriteNextLineFlag = z;
    }

    public void setPdfEndPos(PdfSelectionPos pdfSelectionPos) {
        this.mPdfEndPos = pdfSelectionPos;
    }

    public void setPdfStartPos(PdfSelectionPos pdfSelectionPos) {
        this.mPdfStartPos = pdfSelectionPos;
    }

    public SrcContentInfo setRecognizedTextSpanList(ArrayList<SpenTextSpanBase> arrayList) {
        this.mRecognizedTextSpanList = arrayList;
        return this;
    }

    public void setSAForAIScenario(String str) {
        this.mSAForAIScenario = str;
    }

    public void setSAForAIScenarioScreenID(String str) {
        this.mSAForAIScenarioScreenID = str;
    }

    public void setSelected(boolean z) {
        this.mIsSelected = z;
    }

    public SrcContentInfo setSelectedRectF(RectF rectF) {
        this.mSelectedRectF = rectF;
        return this;
    }

    public SrcContentInfo setSelectedText(@NonNull String str) {
        this.mSelectedText = str;
        return this;
    }

    public void setSrcNote(SpenWNote spenWNote) {
        this.mSrcNote = spenWNote;
    }

    public SrcContentInfo setSrcPageIndex(int i, int i2) {
        this.mSrcPageIndex = i;
        this.mSrcPageEndIndex = i2;
        return this;
    }

    public SrcContentInfo setSrcType(int i) {
        this.mSrcType = i;
        return this;
    }

    public void setSubResultText(String str) {
        this.mSubResultText = str;
    }

    public SrcContentInfo setTextData(@NonNull String str) {
        this.mTextData = str;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.mSelectedText);
        parcel.writeInt(this.mStartPos);
        parcel.writeInt(this.mEndPos);
        parcel.writeInt(this.mSrcType);
        parcel.writeInt(this.mSrcPageIndex);
        parcel.writeInt(this.mSrcPageEndIndex);
        parcel.writeParcelable(this.mSelectedRectF, i);
        parcel.writeList(this.mLineRectFList);
        parcel.writeByte(this.mOverwriteNextLineFlag ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsConvertibleColor ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsBGColorInverted ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.mPdfStartPos, i);
        parcel.writeParcelable(this.mPdfEndPos, i);
        parcel.writeString(this.mSAForAIScenario);
        parcel.writeString(this.mSAForAIScenarioScreenID);
        parcel.writeByte(this.mIsSelected ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mInputIndex);
        parcel.writeString(this.mGenerateStyle);
        parcel.writeString(this.mInputFilePath);
        parcel.writeList(this.mOutputFilePaths);
        parcel.writeString(this.mTextData);
        parcel.writeString(this.mSubResultText);
        parcel.writeList(this.mSpanObjectList);
        parcel.writeList(this.mChunkList);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PdfSelectionPos implements Parcelable {
        public static final Parcelable.Creator<PdfSelectionPos> CREATOR = new Parcelable.Creator<PdfSelectionPos>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.SrcContentInfo.PdfSelectionPos.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PdfSelectionPos createFromParcel(Parcel parcel) {
                return new PdfSelectionPos(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PdfSelectionPos[] newArray(int i) {
                return new PdfSelectionPos[i];
            }
        };
        private int mCursorIndex;
        private int mPageIndex;

        public PdfSelectionPos(SpenNotePdfCursorPosition spenNotePdfCursorPosition) {
            this.mPageIndex = 0;
            this.mCursorIndex = 0;
            this.mPageIndex = spenNotePdfCursorPosition.getPageIndex();
            this.mCursorIndex = spenNotePdfCursorPosition.getCursorIndex();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SpenNotePdfCursorPosition getSpenPdfSelectionPos() {
            return new SpenNotePdfCursorPosition(this.mPageIndex, this.mCursorIndex);
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder("PdfSelectionPos{pageIndex: ");
            sb.append(this.mPageIndex);
            sb.append(" cursor: ");
            return AbstractC2821a.m2223n(sb, "}", this.mCursorIndex);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeInt(this.mPageIndex);
            parcel.writeInt(this.mCursorIndex);
        }

        public PdfSelectionPos(Parcel parcel) {
            this.mPageIndex = 0;
            this.mCursorIndex = 0;
            this.mPageIndex = parcel.readInt();
            this.mCursorIndex = parcel.readInt();
        }
    }

    public SrcContentInfo(String str, int i) {
        this.mSelectedText = "";
        this.mOverwriteNextLineFlag = true;
        this.mIsConvertibleColor = false;
        this.mIsBGColorInverted = false;
        this.mSAForAIScenario = "";
        this.mSAForAIScenarioScreenID = "802";
        this.mIsSelected = true;
        this.mDirtyFlag = false;
        this.mSubResultText = null;
        this.mAiBixbyParam = new AiBixbyParam();
        this.mInputIndex = 0;
        this.mCompletedIndex = -1;
        this.mSelectedText = str;
        this.mStartPos = i;
        this.mSrcType = 2;
    }

    public SrcContentInfo(String str) {
        this.mSelectedText = "";
        this.mOverwriteNextLineFlag = true;
        this.mIsConvertibleColor = false;
        this.mIsBGColorInverted = false;
        this.mSAForAIScenario = "";
        this.mSAForAIScenarioScreenID = "802";
        this.mIsSelected = true;
        this.mDirtyFlag = false;
        this.mSubResultText = null;
        this.mAiBixbyParam = new AiBixbyParam();
        this.mInputIndex = 0;
        this.mCompletedIndex = -1;
        this.mSelectedText = str;
        this.mStartPos = 0;
        this.mSrcType = 0;
    }

    public SrcContentInfo(int i) {
        this.mSelectedText = "";
        this.mOverwriteNextLineFlag = true;
        this.mIsConvertibleColor = false;
        this.mIsBGColorInverted = false;
        this.mSAForAIScenario = "";
        this.mSAForAIScenarioScreenID = "802";
        this.mIsSelected = true;
        this.mDirtyFlag = false;
        this.mSubResultText = null;
        this.mAiBixbyParam = new AiBixbyParam();
        this.mInputIndex = 0;
        this.mCompletedIndex = -1;
        this.mSrcType = i;
    }

    public SrcContentInfo(Parcel parcel) {
        this.mSelectedText = "";
        this.mOverwriteNextLineFlag = true;
        this.mIsConvertibleColor = false;
        this.mIsBGColorInverted = false;
        this.mSAForAIScenario = "";
        this.mSAForAIScenarioScreenID = "802";
        this.mIsSelected = true;
        this.mDirtyFlag = false;
        this.mSubResultText = null;
        this.mAiBixbyParam = new AiBixbyParam();
        this.mInputIndex = 0;
        this.mCompletedIndex = -1;
        this.mSelectedText = parcel.readString();
        this.mStartPos = parcel.readInt();
        this.mEndPos = parcel.readInt();
        this.mSrcType = parcel.readInt();
        this.mSrcPageIndex = parcel.readInt();
        this.mSrcPageEndIndex = parcel.readInt();
        this.mSelectedRectF = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
        this.mLineRectFList = parcel.readArrayList(RectF.class.getClassLoader());
        this.mOverwriteNextLineFlag = parcel.readByte() != 0;
        this.mIsConvertibleColor = parcel.readByte() != 0;
        this.mIsBGColorInverted = parcel.readByte() != 0;
        this.mPdfStartPos = (PdfSelectionPos) parcel.readParcelable(PdfSelectionPos.class.getClassLoader());
        this.mPdfEndPos = (PdfSelectionPos) parcel.readParcelable(PdfSelectionPos.class.getClassLoader());
        this.mSAForAIScenario = parcel.readString();
        this.mSAForAIScenarioScreenID = parcel.readString();
        this.mIsSelected = parcel.readByte() != 0;
        this.mInputIndex = parcel.readInt();
        this.mGenerateStyle = parcel.readString();
        this.mInputFilePath = parcel.readString();
        this.mOutputFilePaths = parcel.readArrayList(String.class.getClassLoader());
        this.mTextData = parcel.readString();
        this.mSubResultText = parcel.readString();
        this.mSpanObjectList = parcel.readArrayList(ResolvableSpanObject.class.getClassLoader());
        this.mChunkList = parcel.readArrayList(Chunk.class.getClassLoader());
    }
}
