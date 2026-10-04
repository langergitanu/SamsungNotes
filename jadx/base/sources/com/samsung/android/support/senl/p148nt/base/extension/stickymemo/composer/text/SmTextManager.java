package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text;

import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenAlignmentParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenPredefinedStyleParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.composer.text.checker.paragraph.ParagraphChecker;
import com.samsung.android.support.senl.p148nt.base.composer.text.checker.span.SpanChecker;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Alignment;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.FontColor;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.ShapeStyleSpan;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.span.SmSpanStates;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ^2\u00020\u0001:\u0002]^B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010&\u001a\u00020'2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u0017J\u0006\u0010+\u001a\u00020\u0019J\b\u0010,\u001a\u0004\u0018\u00010-J\u0010\u0010.\u001a\u00020'2\b\b\u0002\u0010/\u001a\u00020\u0019J\u0006\u00100\u001a\u00020'J\u0018\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020)2\b\b\u0002\u00103\u001a\u00020\u0019J\u0006\u00104\u001a\u00020)J\u000e\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020)J\u0006\u00107\u001a\u00020)J\u000e\u00108\u001a\u00020'2\u0006\u00106\u001a\u00020)J\u0006\u00109\u001a\u00020)J\u0016\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020\u0019J\u000e\u0010=\u001a\u00020'2\u0006\u0010;\u001a\u00020)J\u0016\u0010>\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020?2\u0006\u0010@\u001a\u00020)J\u0016\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020)2\u0006\u00103\u001a\u00020\u0019J\u0016\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020)2\u0006\u00103\u001a\u00020\u0019J\u0016\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020)2\u0006\u0010<\u001a\u00020\u0019J\u000e\u0010G\u001a\u00020'2\u0006\u0010F\u001a\u00020)J\u0006\u0010H\u001a\u00020IJ\b\u0010J\u001a\u00020IH\u0002J\u0018\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020)H\u0002J\u0010\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u00020IH\u0002J\u000e\u0010O\u001a\u00020'2\u0006\u0010N\u001a\u00020)J\u0016\u0010P\u001a\u00020'2\u0006\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020)J\u0018\u0010Q\u001a\u00020'2\u0006\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020)H\u0002J\u000e\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020\u0011J\u000e\u0010T\u001a\u00020'2\u0006\u0010<\u001a\u00020\u0019J\u000e\u0010U\u001a\u00020)2\u0006\u0010V\u001a\u00020WJ\u000e\u0010X\u001a\u00020'2\u0006\u0010<\u001a\u00020\u0019J\u000e\u0010Y\u001a\u00020\u00192\u0006\u0010Z\u001a\u00020[J\u0006\u0010\\\u001a\u00020'R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R+\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00198B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006_"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "", "<init>", "()V", "spenTextManager", "Lcom/samsung/android/sdk/composer/text/ISpenNoteTextManager;", "getSpenTextManager", "()Lcom/samsung/android/sdk/composer/text/ISpenNoteTextManager;", "setSpenTextManager", "(Lcom/samsung/android/sdk/composer/text/ISpenNoteTextManager;)V", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "getDoc", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setDoc", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;)V", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "getTextBox", "()Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "setTextBox", "(Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;)V", "spanState", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/span/SmSpanStates;", "<set-?>", "", "isRTL", "()Z", "setRTL", "(Z)V", "isRTL$delegate", "Lkotlin/properties/ReadWriteProperty;", "textStateChangeListener", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager$TextStateChangeListener;", "getTextStateChangeListener", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager$TextStateChangeListener;", "setTextStateChangeListener", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager$TextStateChangeListener;)V", "init", "", "defFontColor", "", "getSpanState", "isSelected", "getSelectedText", "", "removeSelectedText", "commitHistory", "clearSelection", "setFontSize", "fontSize", "notify", "getFontSize", "setTextColor", "color", "getTextColor", "setTextBgColor", "getTextBgColor", "setTask", "taskType", "enable", "toggleTask", "setTodoState", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "paragraphIndex", "setAlign", "align", "setTextFormat", "format", "setStyle", "style", "toggleStyle", "getCursor", "", "getParagraphIndex", "cursorStart", "cursorEnd", "notifyToListener", "cursor", "updateSpanStateCursor", "updateSpanStateSelection", "updateParagraph", "setDefaultState", "obj", "setCursorBlink", "getCursorIndex", "position", "Landroid/graphics/PointF;", "setAutoBlinkOffOnWindowFocusChanged", "isOverHeight", "context", "Landroid/content/Context;", "showExceedToast", "TextStateChangeListener", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmTextManager {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {AbstractC1974b.m1328u(SmTextManager.class, "isRTL", "isRTL()Z", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("SmTextManager");
    public SpenWNote doc;

    /* JADX INFO: renamed from: isRTL$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty isRTL = Delegates.INSTANCE.notNull();
    private SmSpanStates spanState;
    public ISpenNoteTextManager spenTextManager;
    public SpenObjectTextBox textBox;

    @Nullable
    private TextStateChangeListener textStateChangeListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return SmTextManager.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager$TextStateChangeListener;", "", "onChangedState", "", "smSpanStates", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/span/SmSpanStates;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface TextStateChangeListener {
        void onChangedState(@NotNull SmSpanStates smSpanStates);
    }

    private final int[] getParagraphIndex() {
        int[] paragraphIndex = TextUtil.getParagraphIndex(getTextBox(), getCursor());
        Intrinsics.checkNotNullExpressionValue(paragraphIndex, "getParagraphIndex(...)");
        return paragraphIndex;
    }

    private final boolean isRTL() {
        return ((Boolean) this.isRTL.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    private final void notifyToListener(int[] cursor) {
        if (this.textStateChangeListener != null) {
            int i = cursor[0];
            int i2 = cursor[1];
            if (i == i2) {
                updateSpanStateCursor(i);
            } else {
                updateSpanStateSelection(i, i2);
            }
        }
    }

    public static /* synthetic */ void removeSelectedText$default(SmTextManager smTextManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        smTextManager.removeSelectedText(z);
    }

    public static /* synthetic */ void setFontSize$default(SmTextManager smTextManager, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        smTextManager.setFontSize(i, z);
    }

    private final void setRTL(boolean z) {
        this.isRTL.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    private final void updateParagraph(int cursorStart, int cursorEnd) {
        ParagraphChecker paragraphChecker = new ParagraphChecker();
        int[] paragraphIndex = getParagraphIndex(cursorStart, cursorEnd);
        int[] iArrCheckParagraph = paragraphChecker.checkParagraph(getTextBox(), paragraphIndex[0], paragraphIndex[1], isRTL() ? 1 : 0);
        SmSpanStates smSpanStates = this.spanState;
        SmSpanStates smSpanStates2 = null;
        if (smSpanStates == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates = null;
        }
        smSpanStates.getBodyTextAlign().setValue(iArrCheckParagraph[0]);
        SmSpanStates smSpanStates3 = this.spanState;
        if (smSpanStates3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates3 = null;
        }
        smSpanStates3.getTask().setValue(iArrCheckParagraph[1]);
        SmSpanStates smSpanStates4 = this.spanState;
        if (smSpanStates4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates4 = null;
        }
        smSpanStates4.getIndent().setValue(iArrCheckParagraph[2]);
        SmSpanStates smSpanStates5 = this.spanState;
        if (smSpanStates5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
        } else {
            smSpanStates2 = smSpanStates5;
        }
        smSpanStates2.getTextFormat().setValue(iArrCheckParagraph[3]);
    }

    public final void clearSelection() {
        Object objValueOf;
        int[] cursor = getCursor();
        if (cursor[0] != cursor[1]) {
            try {
                getTextBox().setCursorPosition(cursor[1]);
            } catch (Exception unused) {
                String str = TAG;
                int i = cursor[0];
                int i2 = cursor[1];
                if (TextUtils.isEmpty(getTextBox().getText())) {
                    objValueOf = "null";
                } else {
                    String text = getTextBox().getText();
                    Intrinsics.checkNotNull(text);
                    objValueOf = Integer.valueOf(text.length());
                }
                StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "clearSelection# e: ", "/", " / len = ");
                sbM1173s.append(objValueOf);
                SmLogger.m8662e(str, sbM1173s.toString());
            }
        }
    }

    @NotNull
    public final int[] getCursor() {
        int[] cursor = TextUtil.getCursor(getTextBox());
        Intrinsics.checkNotNullExpressionValue(cursor, "getCursor(...)");
        return cursor;
    }

    public final int getCursorIndex(@NotNull PointF position) {
        Intrinsics.checkNotNullParameter(position, "position");
        return getSpenTextManager().getCurosrIndex(getTextBox(), position);
    }

    @NotNull
    public final SpenWNote getDoc() {
        SpenWNote spenWNote = this.doc;
        if (spenWNote != null) {
            return spenWNote;
        }
        Intrinsics.throwUninitializedPropertyAccessException("doc");
        return null;
    }

    public final int getFontSize() {
        SmSpanStates smSpanStates = this.spanState;
        if (smSpanStates == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates = null;
        }
        return smSpanStates.getBodyTextFontSize().getValue();
    }

    @Nullable
    public final String getSelectedText() {
        int[] cursor = getCursor();
        if (cursor[0] == cursor[1]) {
            return null;
        }
        return TextUtil.subString(getTextBox().getText(), cursor[0], cursor[1], true);
    }

    @NotNull
    public final SmSpanStates getSpanState() {
        SmSpanStates smSpanStates = this.spanState;
        if (smSpanStates != null) {
            return smSpanStates;
        }
        Intrinsics.throwUninitializedPropertyAccessException("spanState");
        return null;
    }

    @NotNull
    public final ISpenNoteTextManager getSpenTextManager() {
        ISpenNoteTextManager iSpenNoteTextManager = this.spenTextManager;
        if (iSpenNoteTextManager != null) {
            return iSpenNoteTextManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("spenTextManager");
        return null;
    }

    public final int getTextBgColor() {
        SmSpanStates smSpanStates = this.spanState;
        if (smSpanStates == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates = null;
        }
        return smSpanStates.getFontBgColor().getValue();
    }

    @NotNull
    public final SpenObjectTextBox getTextBox() {
        SpenObjectTextBox spenObjectTextBox = this.textBox;
        if (spenObjectTextBox != null) {
            return spenObjectTextBox;
        }
        Intrinsics.throwUninitializedPropertyAccessException(ExternalDataConstants.Column.TEXT_BOX);
        return null;
    }

    public final int getTextColor() {
        SmSpanStates smSpanStates = this.spanState;
        if (smSpanStates == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates = null;
        }
        return smSpanStates.getFontColor().getValue();
    }

    @Nullable
    public final TextStateChangeListener getTextStateChangeListener() {
        return this.textStateChangeListener;
    }

    public final void init(@NotNull SpenWNote doc, @NotNull ISpenNoteTextManager spenTextManager, int defFontColor) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        Intrinsics.checkNotNullParameter(spenTextManager, "spenTextManager");
        setDoc(doc);
        setTextBox(doc.getBodyText());
        setSpenTextManager(spenTextManager);
        setRTL(LocaleUtils.isRTLMode());
        SmSpanStates smSpanStates = new SmSpanStates();
        smSpanStates.setFontColor(new FontColor(defFontColor));
        smSpanStates.setBodyTextAlign(new Alignment(SmSpanStates.INSTANCE.getDEFAULT_PREF_NAME(), "StickyMemo_Align", isRTL() ? 1 : 0));
        smSpanStates.getTask().setEnable(true);
        this.spanState = smSpanStates;
    }

    public final boolean isOverHeight(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(context);
        spenBodyTextContext.setDocument(getDoc());
        spenBodyTextContext.measureText();
        boolean z = spenBodyTextContext.getMeasuredHeight() > getDoc().getHeight();
        spenBodyTextContext.close();
        return z;
    }

    public final boolean isSelected() {
        int[] cursor = getCursor();
        return cursor[0] != cursor[1];
    }

    public final void removeSelectedText(boolean commitHistory) {
        int[] cursor = getCursor();
        if (cursor[0] >= cursor[1]) {
            return;
        }
        SpenObjectTextBox textBox = getTextBox();
        int i = cursor[0];
        textBox.removeText(i, cursor[1] - i);
        getTextBox().setCursorPosition(cursor[0]);
        if (commitHistory) {
            getDoc().commitHistory();
        }
    }

    public final void setAlign(int align, boolean notify) {
        int[] cursor = getCursor();
        int[] paragraphIndex = getParagraphIndex(cursor[0], cursor[1]);
        SmSpanStates smSpanStates = this.spanState;
        SmSpanStates smSpanStates2 = null;
        if (smSpanStates == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates = null;
        }
        smSpanStates.getBodyTextAlign().setValue(align);
        SmSpanStates smSpanStates3 = this.spanState;
        if (smSpanStates3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
        } else {
            smSpanStates2 = smSpanStates3;
        }
        SpenAlignmentParagraph sPenSpan = smSpanStates2.getBodyTextAlign().getSPenSpan(paragraphIndex);
        Intrinsics.checkNotNullExpressionValue(sPenSpan, "getSPenSpan(...)");
        getTextBox().appendTextParagraph(sPenSpan);
        if (notify) {
            notifyToListener(cursor);
        }
    }

    public final void setAutoBlinkOffOnWindowFocusChanged(boolean enable) {
        getSpenTextManager().setAutoBlinkOffOnWindowFocusChanged(enable);
    }

    public final void setCursorBlink(boolean enable) {
        getSpenTextManager().setCursorBlink(enable);
    }

    public final void setDefaultState(@NotNull SpenObjectTextBox obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        obj.setTextAlignment(isRTL() ? 1 : 0);
        SmSpanStates smSpanStates = this.spanState;
        SmSpanStates smSpanStates2 = null;
        if (smSpanStates == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates = null;
        }
        obj.setFontSize(smSpanStates.getBodyTextFontSize().getDefaultValue());
        SmSpanStates smSpanStates3 = this.spanState;
        if (smSpanStates3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
        } else {
            smSpanStates2 = smSpanStates3;
        }
        obj.setTextColor(smSpanStates2.getFontColor().getDefaultValue());
        obj.setAutoFitOption(2);
    }

    public final void setDoc(@NotNull SpenWNote spenWNote) {
        Intrinsics.checkNotNullParameter(spenWNote, "<set-?>");
        this.doc = spenWNote;
    }

    public final void setFontSize(int fontSize, boolean notify) {
        boolean zIsGroupingHistory = getDoc().isGroupingHistory();
        if (!zIsGroupingHistory) {
            getDoc().beginHistoryGroup();
        }
        int[] cursor = getCursor();
        SmSpanStates smSpanStates = this.spanState;
        SmSpanStates smSpanStates2 = null;
        if (smSpanStates == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates = null;
        }
        int deltaSize = fontSize - smSpanStates.getBodyTextFontSize().getDeltaSize();
        SmSpanStates smSpanStates3 = this.spanState;
        if (smSpanStates3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates3 = null;
        }
        smSpanStates3.getBodyTextFontSize().setValue(deltaSize);
        SmSpanStates smSpanStates4 = this.spanState;
        if (smSpanStates4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates4 = null;
        }
        smSpanStates4.getBodyTextFontSize().applySPenSpan(cursor, getTextBox());
        if (TextUtils.isEmpty(getTextBox().getText())) {
            SpenObjectTextBox textBox = getTextBox();
            SmSpanStates smSpanStates5 = this.spanState;
            if (smSpanStates5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spanState");
            } else {
                smSpanStates2 = smSpanStates5;
            }
            textBox.setHintTextFontSize(smSpanStates2.getBodyTextFontSize().getValue());
        }
        if (!zIsGroupingHistory) {
            getDoc().endHistoryGroup();
        }
        if (notify) {
            notifyToListener(cursor);
        }
    }

    public final void setSpenTextManager(@NotNull ISpenNoteTextManager iSpenNoteTextManager) {
        Intrinsics.checkNotNullParameter(iSpenNoteTextManager, "<set-?>");
        this.spenTextManager = iSpenNoteTextManager;
    }

    public final void setStyle(int style, boolean enable) {
        int[] cursor = getCursor();
        SmSpanStates smSpanStates = this.spanState;
        if (smSpanStates == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates = null;
        }
        ShapeStyleSpan shapeStyleSpanState = smSpanStates.getShapeStyleSpanState(style);
        shapeStyleSpanState.setValue(enable);
        shapeStyleSpanState.applySPenSpan(cursor, getTextBox());
    }

    public final void setTask(int taskType, boolean enable) {
        boolean zIsGroupingHistory = getDoc().isGroupingHistory();
        if (!zIsGroupingHistory) {
            getDoc().beginHistoryGroup();
        }
        SmSpanStates smSpanStates = this.spanState;
        SmSpanStates smSpanStates2 = null;
        if (smSpanStates == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates = null;
        }
        smSpanStates.getTask().setValue(taskType);
        int[] paragraphIndex = getParagraphIndex();
        SmSpanStates smSpanStates3 = this.spanState;
        if (smSpanStates3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates3 = null;
        }
        SpenBulletParagraph sPenSpan = smSpanStates3.getTask().getSPenSpan(paragraphIndex);
        if (enable) {
            getTextBox().appendTextParagraph(sPenSpan);
        } else {
            getTextBox().removeTextParagraph(sPenSpan);
            SmSpanStates smSpanStates4 = this.spanState;
            if (smSpanStates4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spanState");
            } else {
                smSpanStates2 = smSpanStates4;
            }
            smSpanStates2.getTask().setValue(0);
        }
        if (zIsGroupingHistory) {
            return;
        }
        getDoc().endHistoryGroup();
    }

    public final void setTextBgColor(int color) {
        SmSpanStates smSpanStates = this.spanState;
        SmSpanStates smSpanStates2 = null;
        if (smSpanStates == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates = null;
        }
        smSpanStates.getFontBgColor().setValue(color);
        int[] cursor = getCursor();
        SpenObjectTextBox textBox = getTextBox();
        SmSpanStates smSpanStates3 = this.spanState;
        if (smSpanStates3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
        } else {
            smSpanStates2 = smSpanStates3;
        }
        textBox.appendTextSpan(smSpanStates2.getFontBgColor().getSPenSpan(cursor));
    }

    public final void setTextBox(@NotNull SpenObjectTextBox spenObjectTextBox) {
        Intrinsics.checkNotNullParameter(spenObjectTextBox, "<set-?>");
        this.textBox = spenObjectTextBox;
    }

    public final void setTextColor(int color) {
        SmSpanStates smSpanStates = this.spanState;
        SmSpanStates smSpanStates2 = null;
        if (smSpanStates == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates = null;
        }
        smSpanStates.getFontColor().setValue(color);
        int[] cursor = getCursor();
        SpenObjectTextBox textBox = getTextBox();
        SmSpanStates smSpanStates3 = this.spanState;
        if (smSpanStates3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
        } else {
            smSpanStates2 = smSpanStates3;
        }
        textBox.appendTextSpan(smSpanStates2.getFontColor().getSPenSpan(cursor));
    }

    public final void setTextFormat(int format, boolean notify) {
        int[] cursor = getCursor();
        int[] paragraphIndex = getParagraphIndex(cursor[0], cursor[1]);
        SmSpanStates smSpanStates = this.spanState;
        SmSpanStates smSpanStates2 = null;
        if (smSpanStates == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates = null;
        }
        smSpanStates.getTextFormat().setValue(format);
        if (format == -1) {
            SmSpanStates smSpanStates3 = this.spanState;
            if (smSpanStates3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spanState");
            } else {
                smSpanStates2 = smSpanStates3;
            }
            smSpanStates2.getTextFormat().setTextFormatBody2Style(getTextBox(), paragraphIndex[0], paragraphIndex[1]);
        } else {
            SmSpanStates smSpanStates4 = this.spanState;
            if (smSpanStates4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spanState");
            } else {
                smSpanStates2 = smSpanStates4;
            }
            SpenPredefinedStyleParagraph sPenParagraph = smSpanStates2.getTextFormat().getSPenParagraph(paragraphIndex);
            if (sPenParagraph != null) {
                getTextBox().appendTextParagraph(sPenParagraph);
            }
        }
        if (notify) {
            notifyToListener(cursor);
        }
    }

    public final void setTextStateChangeListener(@Nullable TextStateChangeListener textStateChangeListener) {
        this.textStateChangeListener = textStateChangeListener;
    }

    public final void setTodoState(@NotNull SpenObjectShape textBox, int paragraphIndex) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        ArrayList<SpenTextParagraphBase> arrayListFindTextParagraph = textBox.findTextParagraph(paragraphIndex, paragraphIndex);
        if (arrayListFindTextParagraph != null) {
            Iterator<SpenTextParagraphBase> it = arrayListFindTextParagraph.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenTextParagraphBase next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SpenTextParagraphBase spenTextParagraphBase = next;
                if (spenTextParagraphBase.getType() == 5) {
                    Intrinsics.checkNotNull(spenTextParagraphBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph");
                    SpenBulletParagraph spenBulletParagraph = (SpenBulletParagraph) spenTextParagraphBase;
                    if (spenBulletParagraph.getBulletType() == 2 && spenTextParagraphBase.getStart() <= paragraphIndex && spenTextParagraphBase.getEnd() > paragraphIndex) {
                        spenBulletParagraph.Checkout(!spenBulletParagraph.getIsChecked());
                        textBox.appendTextParagraph(spenBulletParagraph);
                        return;
                    }
                }
            }
        }
    }

    public final void showExceedToast() {
        ToastHandler.show(BaseUtils.getApplicationContext(), C8875R.string.sticky_memo_notify_text_limitation, 0);
    }

    public final void toggleStyle(int style) {
        int[] cursor = getCursor();
        SmSpanStates smSpanStates = this.spanState;
        if (smSpanStates == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates = null;
        }
        ShapeStyleSpan shapeStyleSpanState = smSpanStates.getShapeStyleSpanState(style);
        shapeStyleSpanState.toggleValue();
        shapeStyleSpanState.applySPenSpan(cursor, getTextBox());
        notifyToListener(cursor);
    }

    public final void toggleTask(int taskType) {
        setTask(taskType, getSpanState().getTask().getValue() != taskType);
    }

    public final void updateSpanStateCursor(int cursor) {
        SpanChecker spanChecker = new SpanChecker();
        SpenObjectTextBox textBox = getTextBox();
        SmSpanStates smSpanStates = this.spanState;
        SmSpanStates smSpanStates2 = null;
        if (smSpanStates == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates = null;
        }
        spanChecker.updateRtSpans(textBox, cursor, smSpanStates);
        updateParagraph(cursor, cursor);
        TextStateChangeListener textStateChangeListener = this.textStateChangeListener;
        if (textStateChangeListener != null) {
            SmSpanStates smSpanStates3 = this.spanState;
            if (smSpanStates3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spanState");
            } else {
                smSpanStates2 = smSpanStates3;
            }
            textStateChangeListener.onChangedState(smSpanStates2);
        }
    }

    public final void updateSpanStateSelection(int cursorStart, int cursorEnd) {
        SpanChecker spanChecker = new SpanChecker();
        SpenObjectTextBox textBox = getTextBox();
        SmSpanStates smSpanStates = this.spanState;
        SmSpanStates smSpanStates2 = null;
        if (smSpanStates == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanState");
            smSpanStates = null;
        }
        spanChecker.updateRtSpans(textBox, cursorStart, cursorEnd, smSpanStates);
        updateParagraph(cursorStart, cursorEnd);
        TextStateChangeListener textStateChangeListener = this.textStateChangeListener;
        if (textStateChangeListener != null) {
            SmSpanStates smSpanStates3 = this.spanState;
            if (smSpanStates3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spanState");
            } else {
                smSpanStates2 = smSpanStates3;
            }
            textStateChangeListener.onChangedState(smSpanStates2);
        }
    }

    private final int[] getParagraphIndex(int cursorStart, int cursorEnd) {
        int[] paragraphIndex = TextUtil.getParagraphIndex(getTextBox(), new int[]{cursorStart, cursorEnd});
        Intrinsics.checkNotNullExpressionValue(paragraphIndex, "getParagraphIndex(...)");
        return paragraphIndex;
    }
}
