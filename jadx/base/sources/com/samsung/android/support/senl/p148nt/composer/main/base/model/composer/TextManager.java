package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer;

import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedTextInfo;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenPredefinedStyleParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.AiMaxLength;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Indent;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.ShapeStyleSpan;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.TextOnlyModeState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.SpanStates;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TextManager {
    private static final String EMPTY_TITLE = "";
    private static final int PHONE_DEVICE_DEFAULT_FONT_SIZE_DELTA = 0;
    private static final int TABLET_DEVICE_DEFAULT_FONT_SIZE_DELTA = -5;
    private static final String TAG = Logger.createTag("TextManager");
    private IContract mContract;
    private SpenObjectShape mCurFocusTextBox;
    private int mDefaultFontSizeDelta;
    private Integer mFontSizeDelta = null;
    private OnCurrentTextStateListener mListener;
    private SpenWNote mNote;
    private SpenWNote.ObjectEventListener mObjectEventListener;
    private Boolean mRTL;
    private RtChecker mRtChecker;
    private SpenObjectShape mSelectedBodyTextBox;
    private ArrayList<Pair<Integer, Integer>> mSelectedCells;
    private SpenObjectTable mSelectedTable;
    private SpanStates mSpanStates;
    protected ISpenNoteTextManager mSpenTextManager;
    private OnTableChangeListener mTableChangeListener;
    private TextOnlyModeState mTextOnlyModeState;
    private SpenObjectTextBox mTitleTextBox;
    private OnTitleUpdateListener mTitleUpdateListener;
    private ToolShareControl mToolShareControl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IContract {
        boolean isKeyboardConnected();

        boolean isSIPShown();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ObjectEventListenerImpl implements SpenWNote.ObjectEventListener {
        public /* synthetic */ ObjectEventListenerImpl(TextManager textManager, int i) {
            this();
        }

        private boolean isEqualWithFocusedCursor(int[] iArr) {
            int[] cursorFromFocusedTextBox = TextManager.this.getCursorFromFocusedTextBox();
            if (iArr[0] != cursorFromFocusedTextBox[0] || cursorFromFocusedTextBox[1] != iArr[1]) {
                return false;
            }
            String str = TextManager.TAG;
            StringBuilder sb = new StringBuilder("isEqualWithFocusedCursor# current: ");
            sb.append(iArr[0]);
            sb.append(" ");
            sb.append(iArr[1]);
            sb.append(" focused: ");
            sb.append(cursorFromFocusedTextBox[0]);
            sb.append(" ");
            AbstractC8014b.m7195A(sb, str, cursorFromFocusedTextBox[1]);
            return true;
        }

        private boolean notifyTitleChanges(SpenObjectChangedInfo spenObjectChangedInfo, int i) {
            if (TextManager.this.mTitleUpdateListener == null || i != 4) {
                return false;
            }
            SpenObjectBase spenObjectBase = spenObjectChangedInfo.objectBase;
            if (spenObjectBase != null && spenObjectBase.getRuntimeHandle() != TextManager.this.mTitleTextBox.getRuntimeHandle()) {
                return false;
            }
            TextManager.this.mTitleUpdateListener.onChangedTitle(TextManager.this.mTitleTextBox.getText());
            return true;
        }

        private void printBulkTextChangeLog(SpenObjectChangedTextInfo spenObjectChangedTextInfo) {
            if (Math.abs(spenObjectChangedTextInfo.count - spenObjectChangedTextInfo.before) >= 10) {
                String string = "onObjectChanged# idx: " + spenObjectChangedTextInfo.index + ", text: " + spenObjectChangedTextInfo.before + " to " + spenObjectChangedTextInfo.count;
                if (TextManager.this.mContract != null && spenObjectChangedTextInfo.before > spenObjectChangedTextInfo.count) {
                    StringBuilder sbM781w = AbstractC0541b.m781w(string, " isKeyboardConnected:");
                    sbM781w.append(TextManager.this.mContract.isKeyboardConnected());
                    sbM781w.append(" isSipShown:");
                    sbM781w.append(TextManager.this.mContract.isSIPShown());
                    string = sbM781w.toString();
                }
                String str = TextManager.TAG;
                StringBuilder sbM781w2 = AbstractC0541b.m781w(string, ", backtrace: ");
                sbM781w2.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
                Logger.m11002f(str, sbM781w2.toString());
            }
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectAdded(SpenWPage spenWPage, @NonNull ArrayList<SpenObjectBase> arrayList, int i) {
            TextManager.this.updateTextOnlyMode();
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectChanged(SpenWPage spenWPage, SpenObjectChangedInfo spenObjectChangedInfo, int i) {
            SpenObjectBase spenObjectBase;
            AbstractC8014b.m7195A(new StringBuilder("ObjectEventListenerImpl#onObjectChanged#  "), TextManager.TAG, spenObjectChangedInfo.property);
            if (spenObjectChangedInfo.property == 15 && (spenObjectBase = spenObjectChangedInfo.objectBase) != null && spenObjectBase.getType() == 2 && TextManager.this.mSelectedTable != null && TextManager.this.mSelectedTable.getType() == 22) {
                boolean focused = spenObjectChangedInfo.objectBase.getFocused();
                AbstractC8014b.m7224z("ObjectEventListenerImpl#onObjectChanged# property(PROPERTY_FOCUS) is changed in TABLE, isFocused: ", TextManager.TAG, focused);
                if (focused) {
                    TextManager.this.setFocusedTextBox((SpenObjectShape) spenObjectChangedInfo.objectBase);
                    TextManager textManager = TextManager.this;
                    textManager.mSelectedCells = textManager.mSelectedTable.getSelectedCellPositions();
                } else {
                    TextManager.this.notifyTableCellChanges();
                    TextManager textManager2 = TextManager.this;
                    textManager2.mSelectedCells = textManager2.mSelectedTable.getSelectedCellPositions();
                }
            }
            if (spenObjectChangedInfo.type == 1 && (spenObjectChangedInfo instanceof SpenObjectChangedTextInfo)) {
                SpenObjectChangedTextInfo spenObjectChangedTextInfo = (SpenObjectChangedTextInfo) spenObjectChangedInfo;
                if (notifyTitleChanges(spenObjectChangedInfo, i)) {
                    return;
                }
                int i2 = spenObjectChangedTextInfo.textChangedType;
                if (i2 == 3 && spenObjectChangedTextInfo.textChangedProperties != 64) {
                    String str = TextManager.TAG;
                    StringBuilder sb = new StringBuilder("ObjectEventListenerImpl#onObjectChanged# paragraph is changed index : ");
                    sb.append(spenObjectChangedTextInfo.index);
                    sb.append(" cnt: ");
                    sb.append(spenObjectChangedTextInfo.count);
                    sb.append(" before: ");
                    AbstractC8014b.m7195A(sb, str, spenObjectChangedTextInfo.before);
                    TextManager textManager3 = TextManager.this;
                    int i4 = spenObjectChangedTextInfo.index;
                    textManager3.onChangedParagraph(i4, spenObjectChangedTextInfo.count + i4);
                    return;
                }
                if (i2 != 1) {
                    if (i2 == 2) {
                        int i5 = spenObjectChangedTextInfo.index;
                        if (isEqualWithFocusedCursor(new int[]{i5, spenObjectChangedTextInfo.count + i5})) {
                            Logger.m11003i(TextManager.TAG, "ObjectEventListenerImpl#onObjectChanged# SPAN is changed");
                            TextManager.this.updateRichTextState();
                            return;
                        }
                        return;
                    }
                    return;
                }
                printBulkTextChangeLog(spenObjectChangedTextInfo);
                String str2 = TextManager.TAG;
                StringBuilder sb2 = new StringBuilder("ObjectEventListenerImpl#onObjectChanged# TEXT is changed index : ");
                sb2.append(spenObjectChangedTextInfo.index);
                sb2.append(" cnt: ");
                sb2.append(spenObjectChangedTextInfo.count);
                sb2.append(" before: ");
                AbstractC8014b.m7195A(sb2, str2, spenObjectChangedTextInfo.before);
                int i6 = spenObjectChangedTextInfo.index;
                if (isEqualWithFocusedCursor(new int[]{i6, spenObjectChangedTextInfo.count + i6})) {
                    TextManager.this.updateRichTextState();
                    return;
                }
                TextManager textManager4 = TextManager.this;
                int i7 = spenObjectChangedTextInfo.index;
                textManager4.onTextChanged(i7, spenObjectChangedTextInfo.count + i7);
            }
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectRemoved(SpenWPage spenWPage, @NonNull ArrayList<SpenObjectBase> arrayList, int i) {
        }

        private ObjectEventListenerImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnCurrentTextStateListener {
        void update(SpanStates spanStates);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnTableChangeListener {
        void onTableChanged(SpenObjectTable spenObjectTable, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnTitleUpdateListener {
        void onChangedTitle(String str);
    }

    private SpanStates.Builder defaultSpanStatesBuilder(SpanStates.IContract iContract, int i) {
        return new SpanStates.Builder(iContract).fontSize(getFontSizeDelta()).fontColor(i).fontBgColor().bold().italic().underline().strikethrough().task().indent().align().textFormat();
    }

    private int[] getParagraphIndex(SpenObjectShape spenObjectShape) {
        return getParagraphIndex(spenObjectShape, getCursor(spenObjectShape));
    }

    private void initRTL() {
        if (this.mRTL == null) {
            this.mRTL = Boolean.valueOf(LocaleUtils.isRTLMode());
        }
    }

    private void initRtChecker() {
        if (this.mRtChecker == null) {
            this.mRtChecker = new RtChecker();
        }
    }

    private boolean isInvalidFontSizeDelta() {
        Integer num = this.mFontSizeDelta;
        return num == null || num.intValue() == Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyTableCellChanges() {
        ArrayList<Pair<Integer, Integer>> arrayList;
        if (this.mTableChangeListener == null || (arrayList = this.mSelectedCells) == null || arrayList.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<Pair<Integer, Integer>> it = this.mSelectedCells.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getSecond());
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            this.mTableChangeListener.onTableChanged(this.mSelectedTable, ((Integer) it2.next()).intValue());
        }
    }

    private void setTitle(SpenObjectTextBox spenObjectTextBox) {
        this.mTitleTextBox = spenObjectTextBox;
        if (spenObjectTextBox == null) {
            this.mTitleTextBox = new SpenObjectTextBox();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void updateParagraph(SpenObjectShape spenObjectShape, int i, int i2) {
        initRTL();
        initRtChecker();
        int[] paragraphIndex = getParagraphIndex(spenObjectShape, new int[]{i, i2});
        int[] iArrCheckParagraph = this.mRtChecker.checkParagraph(spenObjectShape, paragraphIndex[0], paragraphIndex[1], this.mRTL.booleanValue() ? 1 : 0);
        this.mSpanStates.getAlign().setValue(iArrCheckParagraph[0]);
        this.mSpanStates.getTask().setValue(iArrCheckParagraph[1]);
        this.mSpanStates.getIndent().setValue(iArrCheckParagraph[2]);
        if (iArrCheckParagraph.length > 3) {
            this.mSpanStates.getTextFormat().setValue(iArrCheckParagraph[3]);
        }
    }

    public void changeSelectedText(String str) {
        boolean z;
        if (this.mCurFocusTextBox == null) {
            return;
        }
        if (this.mNote.isGroupingHistory()) {
            z = false;
        } else {
            this.mNote.beginHistoryGroup();
            z = true;
        }
        int[] cursor = getCursor(this.mCurFocusTextBox);
        removeText(cursor);
        this.mCurFocusTextBox.insertText(str, cursor[0]);
        if (z) {
            this.mNote.endHistoryGroup();
        }
    }

    public void clearRtState() {
        if (this.mListener != null) {
            this.mSpanStates.clear();
            this.mListener.update(this.mSpanStates);
        }
    }

    public void clearSelection() {
        if (this.mCurFocusTextBox != null) {
            int[] cursorFromFocusedTextBox = getCursorFromFocusedTextBox();
            int i = cursorFromFocusedTextBox[0];
            int i2 = cursorFromFocusedTextBox[1];
            if (i != i2) {
                try {
                    this.mCurFocusTextBox.setCursorPosition(i2);
                } catch (Exception unused) {
                    String str = TAG;
                    StringBuilder sb = new StringBuilder("clearSelection# e: ");
                    sb.append(cursorFromFocusedTextBox[0]);
                    sb.append("/");
                    sb.append(cursorFromFocusedTextBox[1]);
                    sb.append(" / len = ");
                    sb.append(TextUtils.isEmpty(this.mCurFocusTextBox.getText()) ? "null" : Integer.valueOf(this.mCurFocusTextBox.getText().length()));
                    Logger.m11000e(str, sb.toString());
                }
            }
        }
    }

    public void enableTaskNIndentSpan(boolean z) {
        if (this.mListener != null) {
            this.mSpanStates.indent.setEnable(z);
            this.mSpanStates.task.setEnable(z);
            this.mListener.update(this.mSpanStates);
        }
    }

    public int[] getBodyTextCursor() {
        SpenWNote spenWNote = this.mNote;
        return spenWNote == null ? new int[]{-1, -1} : getCursor(spenWNote.getBodyText());
    }

    public int getCurrentViewFontSize() {
        return this.mSpanStates.getFontSize().getViewValue();
    }

    public int[] getCursor(SpenObjectShape spenObjectShape) {
        return TextUtil.getCursor(spenObjectShape);
    }

    public int[] getCursorFromFocusedTextBox() {
        return getCursor(this.mCurFocusTextBox);
    }

    public int getCursorIndex(SpenObjectShape spenObjectShape, PointF pointF) {
        return this.mSpenTextManager.getCurosrIndex(spenObjectShape, pointF);
    }

    public int getCursorIndexToInsertIntoBodyText(PointF pointF) {
        return this.mSpenTextManager.getCursorIndexToInsertIntoBodyText(pointF);
    }

    public android.util.Pair<Integer, Integer> getCursorRangeByRectInBodytext(RectF rectF) {
        return this.mSpenTextManager.getCursorRangeByRectInBodytext(rectF);
    }

    public int getDefaultFontColor() {
        return this.mSpanStates.getFontColor().getDefaultValue();
    }

    public SpenObjectShape getFocusedObject() {
        SpenObjectTable spenObjectTable = this.mSelectedTable;
        return spenObjectTable != null ? spenObjectTable : this.mCurFocusTextBox;
    }

    public int getFontSizeDelta() {
        if (isInvalidFontSizeDelta()) {
            ISpenNoteTextManager iSpenNoteTextManager = this.mSpenTextManager;
            if (iSpenNoteTextManager != null) {
                this.mFontSizeDelta = Integer.valueOf(iSpenNoteTextManager.getTextSizeDelta());
            }
            if (isInvalidFontSizeDelta()) {
                return this.mDefaultFontSizeDelta;
            }
        }
        return this.mFontSizeDelta.intValue();
    }

    public Indent getIndent() {
        return this.mSpanStates.getIndent();
    }

    public SpanStates getLastTextState() {
        return this.mSpanStates;
    }

    public int getLineCountFromBodyTextBottom(PointF pointF) {
        return this.mSpenTextManager.getLineCountFromBodyTextBottom(pointF);
    }

    public RectF getLineRectOfBodyText(SpenWPage spenWPage, float f) {
        return this.mSpenTextManager.getLineRectOfBodyText(spenWPage, f);
    }

    public String getSelectedText() {
        int[] cursor = getCursor(this.mCurFocusTextBox);
        if (cursor[0] == cursor[1]) {
            return null;
        }
        return TextUtil.subString(this.mCurFocusTextBox.getText(), cursor[0], cursor[1], true);
    }

    public ISpenNoteTextManager getSpenNoteTextManager() {
        return this.mSpenTextManager;
    }

    public SpenWNote.ObjectEventListener getSpenObjectListener() {
        if (this.mObjectEventListener == null) {
            this.mObjectEventListener = new ObjectEventListenerImpl(this, 0);
        }
        return this.mObjectEventListener;
    }

    public int getTextBgColor() {
        return this.mSpanStates.getFontBgColor().getValue();
    }

    public SpenObjectShape getTextBox() {
        return this.mCurFocusTextBox;
    }

    public int getTextColor() {
        return this.mSpanStates.getFontColor().getValue();
    }

    public RectF getTextContentRectByCursorRangeInBodytext(int i, int i2) {
        List<RectF> textContentRectsByCursorRangeInBodytext = this.mSpenTextManager.getTextContentRectsByCursorRangeInBodytext(i, i2);
        RectF rectF = new RectF();
        if (textContentRectsByCursorRangeInBodytext != null) {
            Iterator<RectF> it = textContentRectsByCursorRangeInBodytext.iterator();
            while (it.hasNext()) {
                rectF.union(it.next());
            }
        }
        return rectF;
    }

    public int getTextLengthByEmptyBodyTextPage(int i, @NonNull SpenWPage spenWPage) {
        return this.mSpenTextManager.calculateInsertedTextCountWhenInsertEmptyBodyTextTo(i, spenWPage);
    }

    public String getTitle() {
        String text = this.mTitleTextBox.getText();
        if (text != null) {
            return text;
        }
        Logger.addSkipFileLog(2);
        this.mTitleTextBox.setText("", true);
        return "";
    }

    public boolean handleCustomHyperTextAction(String str, SpenObjectShape spenObjectShape, SpenHyperTextSpan spenHyperTextSpan) {
        return false;
    }

    public boolean hasFocusedTextBox() {
        SpenObjectShape spenObjectShape = this.mCurFocusTextBox;
        if (spenObjectShape != null) {
            return spenObjectShape.getFocused() || isSelectedBodyTextBox();
        }
        return false;
    }

    public void init(SpenWNote spenWNote, SpenObjectTextBox spenObjectTextBox, SpenObjectTextBox spenObjectTextBox2, int i, SpanStates.IContract iContract, boolean z) {
        this.mNote = spenWNote;
        setTitle(spenObjectTextBox);
        this.mCurFocusTextBox = spenObjectTextBox2;
        this.mDefaultFontSizeDelta = z ? -5 : 0;
        this.mSpanStates = defaultSpanStatesBuilder(iContract, i).build();
        this.mRTL = null;
    }

    public boolean isAutoFocusEnabled() {
        return this.mSpenTextManager.isAutoFocusEnabled();
    }

    public boolean isCursorBlinking() {
        return this.mSpenTextManager.isCursorBlinking();
    }

    public boolean isSelected() {
        int[] cursorFromFocusedTextBox = getCursorFromFocusedTextBox();
        return cursorFromFocusedTextBox[0] != cursorFromFocusedTextBox[1];
    }

    public boolean isSelectedBodyTextBox() {
        return this.mSelectedBodyTextBox != null;
    }

    public void notifyToListener(int[] iArr) {
        if (this.mListener != null) {
            int i = iArr[0];
            int i2 = iArr[1];
            if (i == i2) {
                updateRichTextStateWithCursor(this.mCurFocusTextBox, i);
            } else {
                updateRichTextStateWithSelection(this.mCurFocusTextBox, i, i2);
            }
        }
    }

    public void onChangedParagraph(int i, int i2) {
        if (this.mListener == null || this.mSpanStates == null) {
            return;
        }
        initRtChecker();
        int[] paragraphIndex = getParagraphIndex(this.mCurFocusTextBox, new int[]{i, i2});
        int i4 = paragraphIndex[1];
        int i5 = paragraphIndex[0];
        if (i4 - i5 > 1) {
            paragraphIndex[0] = i5 + 1;
            i++;
        }
        int cursorPosition = this.mCurFocusTextBox.getCursorPosition();
        if (cursorPosition < i || cursorPosition > i2) {
            return;
        }
        this.mSpanStates.getTask().setValue(this.mRtChecker.checkSingleParagraphTask(this.mCurFocusTextBox, paragraphIndex[0], paragraphIndex[1]));
        this.mListener.update(this.mSpanStates);
    }

    public void onTextChanged(int i, int i2) {
    }

    public boolean removeSelectedText() {
        SpenObjectShape spenObjectShape = this.mCurFocusTextBox;
        if (spenObjectShape == null) {
            return false;
        }
        removeSelectedText(spenObjectShape);
        return true;
    }

    public void removeText(int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        if (i < i2) {
            this.mCurFocusTextBox.removeText(i, i2 - i);
            this.mCurFocusTextBox.setCursorPosition(iArr[0]);
            return;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder("removeText# e: ");
        sb.append(iArr[0]);
        sb.append("/");
        AbstractC8014b.m7195A(sb, str, iArr[1]);
    }

    public void resetSelectedBodyTextBox() {
        this.mSelectedBodyTextBox = null;
    }

    public void resetSelectedTable() {
        if (this.mSelectedTable != null) {
            notifyTableCellChanges();
        }
        this.mSelectedTable = null;
    }

    public void setAiTextFormat(boolean z) {
        if (z) {
            this.mSpenTextManager.setCursorSelectionMaxLength(AiMaxLength.LEN_SELECTED_MAX);
        } else {
            this.mSpenTextManager.setCursorSelectionMaxLength(0);
        }
    }

    public void setAlign(int i, boolean z) {
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null && toolShareControl.getEnabled()) {
            this.mToolShareControl.setAlign(i, z);
            return;
        }
        int[] cursorFromFocusedTextBox = getCursorFromFocusedTextBox();
        int[] paragraphIndex = getParagraphIndex(this.mCurFocusTextBox, cursorFromFocusedTextBox);
        this.mSpanStates.getAlign().setValue(i);
        this.mCurFocusTextBox.appendTextParagraph(this.mSpanStates.getAlign().getSPenSpan(paragraphIndex));
        if (z) {
            notifyToListener(cursorFromFocusedTextBox);
        }
    }

    public void setAutoBlinkOffOnWindowFocusChanged(boolean z) {
        this.mSpenTextManager.setAutoBlinkOffOnWindowFocusChanged(z);
    }

    public void setAutoScrollToCursorOnLayoutChanged(boolean z) {
        this.mSpenTextManager.setAutoFocusEnabled(z);
    }

    public void setContract(IContract iContract) {
        this.mContract = iContract;
    }

    public void setCursorBlink(boolean z) {
        this.mSpenTextManager.setCursorBlink(z);
    }

    public void setFocusedTextBox(SpenObjectShape spenObjectShape) {
        Logger.m11000e(TAG, "setFocusedTextBox");
        this.mCurFocusTextBox = spenObjectShape;
    }

    public void setFontSize(int i) {
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null && toolShareControl.getEnabled()) {
            this.mToolShareControl.setFontSize(i);
            return;
        }
        int[] cursor = getCursor(this.mCurFocusTextBox);
        int deltaSize = i - this.mSpanStates.getFontSize().getDeltaSize();
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "setFontSize : origin ", " delta : ");
        sbM778t.append(this.mSpanStates.getFontSize().getDeltaSize());
        sbM778t.append(" fontSize : ");
        sbM778t.append(deltaSize);
        Logger.m11003i(str, sbM778t.toString());
        this.mSpanStates.getFontSize().setValue(deltaSize);
        this.mSpanStates.getFontSize().applySPenSpan(cursor, this.mCurFocusTextBox);
        if (TextUtils.isEmpty(this.mCurFocusTextBox.getText())) {
            this.mCurFocusTextBox.setHintTextFontSize(this.mSpanStates.getFontSize().getValue());
        }
    }

    public void setListener(OnCurrentTextStateListener onCurrentTextStateListener) {
        this.mListener = onCurrentTextStateListener;
    }

    public void setSelectedBodyTextBox(SpenObjectShape spenObjectShape) {
        Logger.m11004w(TAG, "setSelectedBodyTextBox, " + spenObjectShape);
        this.mSelectedBodyTextBox = spenObjectShape;
    }

    public void setSelectedTable(SpenObjectTable spenObjectTable) {
        Logger.m11004w(TAG, "setSelectedTable, ");
        this.mSelectedTable = spenObjectTable;
        this.mSelectedCells = spenObjectTable == null ? null : spenObjectTable.getSelectedCellPositions();
    }

    public void setSpenTextManager(ISpenNoteTextManager iSpenNoteTextManager) {
        this.mSpenTextManager = iSpenNoteTextManager;
    }

    public void setStyle(int i, boolean z) {
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null && toolShareControl.getEnabled()) {
            this.mToolShareControl.setStyle(i, z);
            return;
        }
        SpenObjectShape spenObjectShape = this.mCurFocusTextBox;
        if (spenObjectShape == null) {
            return;
        }
        int[] cursor = getCursor(spenObjectShape);
        ShapeStyleSpan shapeStyleSpanState = this.mSpanStates.getShapeStyleSpanState(i);
        shapeStyleSpanState.setValue(z);
        shapeStyleSpanState.applySPenSpan(cursor, this.mCurFocusTextBox);
    }

    public void setTableChangeListener(OnTableChangeListener onTableChangeListener) {
        this.mTableChangeListener = onTableChangeListener;
    }

    public void setTask(int i, boolean z) {
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null && toolShareControl.getEnabled()) {
            this.mToolShareControl.setTask(i, z);
            return;
        }
        this.mSpanStates.getTask().setValue(i);
        SpenBulletParagraph sPenSpan = this.mSpanStates.getTask().getSPenSpan(getParagraphIndex(this.mCurFocusTextBox));
        if (z) {
            this.mCurFocusTextBox.appendTextParagraph(sPenSpan);
        } else {
            this.mCurFocusTextBox.removeTextParagraph(sPenSpan);
            this.mSpanStates.getTask().setValue(0);
        }
    }

    public void setTextBgColor(int i) {
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null && toolShareControl.getEnabled()) {
            this.mToolShareControl.setTextBgColor(i);
            return;
        }
        this.mSpanStates.getFontBgColor().setValue(i);
        this.mCurFocusTextBox.appendTextSpan(this.mSpanStates.getFontBgColor().getSPenSpan(getCursor(this.mCurFocusTextBox)));
    }

    public void setTextColor(int i) {
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null && toolShareControl.getEnabled()) {
            this.mToolShareControl.setTextColor(i);
            return;
        }
        this.mSpanStates.getFontColor().setValue(i);
        this.mCurFocusTextBox.appendTextSpan(this.mSpanStates.getFontColor().getSPenSpan(getCursor(this.mCurFocusTextBox)));
    }

    public void setTextFormat(int i, boolean z) {
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null && toolShareControl.getEnabled()) {
            this.mToolShareControl.setTextFormat(i, z);
            return;
        }
        int[] cursorFromFocusedTextBox = getCursorFromFocusedTextBox();
        int[] paragraphIndex = getParagraphIndex(this.mCurFocusTextBox, cursorFromFocusedTextBox);
        this.mSpanStates.getTextFormat().setValue(i);
        if (i == -1) {
            this.mSpanStates.getTextFormat().setTextFormatBody2Style(this.mCurFocusTextBox, paragraphIndex[0], paragraphIndex[1]);
        } else {
            SpenPredefinedStyleParagraph sPenParagraph = this.mSpanStates.getTextFormat().getSPenParagraph(paragraphIndex);
            if (sPenParagraph != null) {
                this.mCurFocusTextBox.appendTextParagraph(sPenParagraph);
            }
        }
        if (z) {
            notifyToListener(cursorFromFocusedTextBox);
        }
    }

    public void setTextOnlyModeState(TextOnlyModeState textOnlyModeState) {
        this.mTextOnlyModeState = textOnlyModeState;
    }

    public void setTitleUpdateListener(OnTitleUpdateListener onTitleUpdateListener) {
        this.mTitleUpdateListener = onTitleUpdateListener;
    }

    public void setTodoState(SpenObjectShape spenObjectShape, int i) {
        ArrayList<SpenTextParagraphBase> arrayListFindTextParagraph = spenObjectShape.findTextParagraph(i, i);
        if (arrayListFindTextParagraph != null) {
            for (SpenTextParagraphBase spenTextParagraphBase : arrayListFindTextParagraph) {
                if (spenTextParagraphBase.getType() == 5) {
                    SpenBulletParagraph spenBulletParagraph = (SpenBulletParagraph) spenTextParagraphBase;
                    if (spenBulletParagraph.getBulletType() == 2 && spenTextParagraphBase.getStart() <= i && spenTextParagraphBase.getEnd() > i) {
                        spenBulletParagraph.Checkout(!spenBulletParagraph.getIsChecked());
                        spenObjectShape.appendTextParagraph(spenBulletParagraph);
                        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_TODO_DONE, !spenBulletParagraph.getIsChecked() ? "1" : "0");
                        return;
                    }
                }
            }
        }
    }

    public void setToolShareControl(ToolShareControl toolShareControl) {
        this.mToolShareControl = toolShareControl;
    }

    public void toggleStyle(int i) {
        SpenObjectShape spenObjectShape = this.mCurFocusTextBox;
        if (spenObjectShape == null) {
            return;
        }
        int[] cursor = getCursor(spenObjectShape);
        ShapeStyleSpan shapeStyleSpanState = this.mSpanStates.getShapeStyleSpanState(i);
        shapeStyleSpanState.toggleValue();
        shapeStyleSpanState.applySPenSpan(cursor, this.mCurFocusTextBox);
        notifyToListener(cursor);
    }

    public void updateBodyObjectSpanPosition(int i, int i2) {
        this.mSpenTextManager.updateBodyObjectSpanPosition(i, i2);
    }

    public void updateRichTextState() {
        notifyToListener(getCursorFromFocusedTextBox());
    }

    public void updateRichTextStateWithCursor(SpenObjectShape spenObjectShape, int i) {
        if (this.mListener == null) {
            return;
        }
        initRtChecker();
        this.mSpanStates = (SpanStates) this.mRtChecker.updateRtSpans(spenObjectShape, i, this.mSpanStates);
        updateParagraph(spenObjectShape, i, i);
        this.mListener.update(this.mSpanStates);
    }

    public void updateRichTextStateWithSelection(SpenObjectShape spenObjectShape, int i, int i2) {
        if (this.mListener == null) {
            return;
        }
        initRtChecker();
        this.mSpanStates = (SpanStates) this.mRtChecker.updateRtSpans(spenObjectShape, i, i2, this.mSpanStates);
        updateParagraph(spenObjectShape, i, i2);
        this.mListener.update(this.mSpanStates);
    }

    public void updateTextOnlyMode() {
        TextOnlyModeState textOnlyModeState = this.mTextOnlyModeState;
        if (textOnlyModeState == null || !textOnlyModeState.canUseTextOnlyMode()) {
            return;
        }
        this.mTextOnlyModeState.setCanUseTextOnlyMode(false, 2);
    }

    public int[] getParagraphIndex(SpenObjectShape spenObjectShape, int[] iArr) {
        return TextUtil.getParagraphIndex(spenObjectShape, iArr);
    }

    public void removeSelectedText(SpenObjectShape spenObjectShape) {
        removeText(getCursor(spenObjectShape));
    }

    public void setTitle(String str) {
        if (str == null || str.equals(this.mTitleTextBox.getText())) {
            return;
        }
        if (this.mNote.isClosed()) {
            Logger.m11000e(TAG, "setTitle# note is closed ");
        } else {
            this.mTitleTextBox.setText(str, true);
            this.mNote.commitHistory();
        }
    }
}
