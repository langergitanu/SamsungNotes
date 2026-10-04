package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action;

import android.content.ClipData;
import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.composer.action.PasteHelper;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipDataBackupPath;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipboardCacheManager;
import com.samsung.android.support.senl.p148nt.base.composer.content.ObjectHelper;
import com.samsung.android.support.senl.p148nt.base.composer.content.ObjectTypeHelper;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmObjectManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTask;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.SmTextManager;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ;2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00039:;B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\"\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010 H\u0002J \u0010'\u001a\u00020\u001a2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+H\u0002J\b\u0010,\u001a\u00020\u001aH\u0002J*\u0010-\u001a\u00020\u001a2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+2\b\u0010&\u001a\u0004\u0018\u00010 H\u0002J\u001a\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u0002002\b\u0010&\u001a\u0004\u0018\u00010 H\u0002J\u0010\u00101\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u00102\u001a\u00020\u001aH\u0002J\u0018\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\u0003H\u0016J\u0010\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u000208H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmPasteTask;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmPasteTask$Inputs;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmPasteTask$Results;", "<init>", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "beginHistory", "", "getBeginHistory", "()Z", "setBeginHistory", "(Z)V", "errorMsgStringId", "", "getErrorMsgStringId", "()Ljava/lang/Integer;", "setErrorMsgStringId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "run", "", "clear", "paste", "clipData", "Landroid/content/ClipData;", "pastePosition", "Landroid/graphics/PointF;", "pasteSpenObjects", "backupNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "restoreFilePath", "", "position", "removeUnsupportedObject", "objectList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "setErrorMsg", "addObjects", "insertText", "newTextBox", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "pasteRawContents", "endHistoryGroup", "notifyCallback", "success", "results", "makeResults", "context", "Landroid/content/Context;", "Inputs", "Results", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmPasteTask extends SmTask<Inputs, Results> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("SmPasteTask");
    private boolean beginHistory;

    @Nullable
    private Integer errorMsgStringId;

    @NotNull
    private Handler handler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmPasteTask$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return SmPasteTask.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmPasteTask$Inputs;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Inputs;", "context", "Landroid/content/Context;", "objectManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "textManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "clipData", "Landroid/content/ClipData;", "pastePosition", "Landroid/graphics/PointF;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;Landroid/content/ClipData;Landroid/graphics/PointF;)V", "getContext", "()Landroid/content/Context;", "getObjectManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "getTextManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "getClipData", "()Landroid/content/ClipData;", "getPastePosition", "()Landroid/graphics/PointF;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Inputs implements SmTask.Inputs {

        @NotNull
        private final ClipData clipData;

        @NotNull
        private final Context context;

        @NotNull
        private final SmObjectManager objectManager;

        @Nullable
        private final PointF pastePosition;

        @NotNull
        private final SmTextManager textManager;

        public Inputs(@NotNull Context context, @NotNull SmObjectManager objectManager, @NotNull SmTextManager textManager, @NotNull ClipData clipData, @Nullable PointF pointF) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(objectManager, "objectManager");
            Intrinsics.checkNotNullParameter(textManager, "textManager");
            Intrinsics.checkNotNullParameter(clipData, "clipData");
            this.context = context;
            this.objectManager = objectManager;
            this.textManager = textManager;
            this.clipData = clipData;
            this.pastePosition = pointF;
        }

        @NotNull
        public final ClipData getClipData() {
            return this.clipData;
        }

        @NotNull
        public final Context getContext() {
            return this.context;
        }

        @NotNull
        public final SmObjectManager getObjectManager() {
            return this.objectManager;
        }

        @Nullable
        public final PointF getPastePosition() {
            return this.pastePosition;
        }

        @NotNull
        public final SmTextManager getTextManager() {
            return this.textManager;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmPasteTask$Results;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Results;", "context", "Landroid/content/Context;", "errorMsgStringId", "", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "getContext", "()Landroid/content/Context;", "getErrorMsgStringId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "showErrorToast", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Results implements SmTask.Results {

        @NotNull
        private final Context context;

        @Nullable
        private final Integer errorMsgStringId;

        public Results(@NotNull Context context, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.errorMsgStringId = num;
        }

        @NotNull
        public final Context getContext() {
            return this.context;
        }

        @Nullable
        public final Integer getErrorMsgStringId() {
            return this.errorMsgStringId;
        }

        public final void showErrorToast() {
            Integer num = this.errorMsgStringId;
            if (num != null) {
                ToastHandler.show(this.context, num.intValue(), 0);
            } else {
                ToastHandler.show(this.context, C8875R.string.composer_failed_to_copy, 0);
            }
        }
    }

    public SmPasteTask() {
        super(TAG);
        this.handler = new Handler(Looper.getMainLooper());
    }

    private final void addObjects(ArrayList<SpenObjectBase> objectList, PointF position) {
        SmLogger.m8661d(getTag(), "addObjects# " + objectList.size() + " position: " + position);
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>();
        Iterator<SpenObjectBase> it = objectList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenObjectBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenObjectBase spenObjectBase = next;
            if (ObjectTypeHelper.INSTANCE.isTextType(spenObjectBase.getType()) && spenObjectBase.hasExtraDataByteArray("CopiedText")) {
                insertText((SpenObjectShape) spenObjectBase, position);
            } else {
                arrayList.add(spenObjectBase);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        if (position == null) {
            getInputs().getObjectManager().getSpenNoteObjectInserter().insertObject(getInputs().getObjectManager().getNote().getPage(0), arrayList, false, false);
        } else {
            getInputs().getObjectManager().getSpenNoteObjectInserter().insertObject(arrayList, position, false, false);
        }
        getInputs().getObjectManager().selectObject(arrayList);
    }

    private final void endHistoryGroup() {
        if (this.beginHistory) {
            getInputs().getObjectManager().getNote().endHistoryGroup();
        }
    }

    private final void insertText(SpenObjectShape newTextBox, PointF position) {
        SmLogger.m8661d(getTag(), "insertText#");
        boolean zIsSelectedTextBox = getInputs().getObjectManager().isSelectedTextBox();
        if (!zIsSelectedTextBox) {
            SmLogger.m8661d(getTag(), "insertText# textbox is not selected");
            getInputs().getObjectManager().selectObject(getInputs().getTextManager().getTextBox());
        }
        if (TextUtils.isEmpty(newTextBox.getText())) {
            SmLogger.m8661d(getTag(), "insertText# text is empty");
            return;
        }
        String text = newTextBox.getText();
        Intrinsics.checkNotNull(text);
        int length = text.length();
        String text2 = newTextBox.getText();
        if (text2 != null) {
            int[] paragraphIndex = TextUtil.getParagraphIndex(newTextBox, new int[]{0, text2.length() - 1});
            newTextBox.removeTextParagraph(paragraphIndex[0], paragraphIndex[1], 4);
        }
        if (position != null) {
            getInputs().getObjectManager().insertText(newTextBox, position, false);
        } else {
            getInputs().getTextManager().getTextBox().insertText(getInputs().getTextManager().getCursor()[0], newTextBox, 0, length);
        }
        if (zIsSelectedTextBox) {
            return;
        }
        getInputs().getObjectManager().selectObject((SpenObjectBase) null);
    }

    private final Results makeResults(Context context) {
        return new Results(context, this.errorMsgStringId);
    }

    private final void paste(ClipData clipData) {
        PointF pastePosition;
        if (!getInputs().getObjectManager().getNote().isGroupingHistory()) {
            getInputs().getObjectManager().getNote().beginHistoryGroup();
            this.beginHistory = true;
        }
        if (getInputs().getObjectManager().isSelectedTextBox()) {
            pastePosition = null;
            SmTextManager.removeSelectedText$default(getInputs().getTextManager(), false, 1, null);
        } else {
            pastePosition = getInputs().getObjectManager().getSpenControlObjectManager().getPastePosition();
        }
        paste(clipData, pastePosition);
    }

    private final void pasteRawContents(ClipData clipData) {
        int itemCount = clipData.getItemCount();
        SmLogger.m8661d(getTag(), "pasteRawContents# clipData item count:" + itemCount);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < itemCount; i++) {
            ClipData.Item itemAt = clipData.getItemAt(i);
            if (!TextUtils.isEmpty(itemAt.getHtmlText())) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(CharUtils.fromHtml(itemAt.getHtmlText()));
                ImageSpan[] imageSpanArr = (ImageSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), ImageSpan.class);
                Intrinsics.checkNotNull(imageSpanArr);
                List listReversed = ArraysKt.reversed(imageSpanArr);
                int size = listReversed.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ImageSpan imageSpan = (ImageSpan) listReversed.get(i2);
                    int spanStart = spannableStringBuilder2.getSpanStart(imageSpan);
                    int spanEnd = spannableStringBuilder2.getSpanEnd(imageSpan);
                    spannableStringBuilder2.removeSpan(imageSpan);
                    spannableStringBuilder2.delete(spanStart, spanEnd);
                }
                SpannableStringBuilder spannableStringBuilderRearrangeText = PasteHelper.INSTANCE.rearrangeText(spannableStringBuilder2, 0, spannableStringBuilder2.length());
                if (imageSpanArr.length != 0) {
                    setErrorMsg();
                }
                spannableStringBuilder.append((CharSequence) spannableStringBuilderRearrangeText);
            } else if (!TextUtils.isEmpty(itemAt.getText())) {
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(StringsKt.m14139M(itemAt.getText().toString(), "\r\n", "\n"));
                spannableStringBuilder.append((CharSequence) PasteHelper.INSTANCE.rearrangeText(spannableStringBuilder3, 0, spannableStringBuilder3.length()));
            }
        }
        if (spannableStringBuilder.length() > 0) {
            SmLogger.m8661d(getTag(), "pasteRawContents# length " + spannableStringBuilder.length());
            SpenObjectTextBox spenObjectTextBoxMakeNewTextBox = getInputs().getObjectManager().makeNewTextBox();
            spenObjectTextBoxMakeNewTextBox.insertText(spannableStringBuilder.toString(), 0);
            CharUtils.convertSpannablerToSpen(spannableStringBuilder, spenObjectTextBoxMakeNewTextBox);
            int[] cursor = getInputs().getTextManager().getCursor();
            SpenObjectTextBox textBox = getInputs().getTextManager().getTextBox();
            int i4 = cursor[0];
            String text = spenObjectTextBoxMakeNewTextBox.getText();
            Intrinsics.checkNotNull(text);
            textBox.insertText(i4, spenObjectTextBoxMakeNewTextBox, 0, text.length());
        }
        SmLogger.m8661d(getTag(), "pasteRawContents# end");
    }

    private final void pasteSpenObjects(SpenWNote backupNote, String restoreFilePath, PointF position) {
        ArrayList<SpenObjectBase> arrayListRestoreObjectList = backupNote.restoreObjectList(restoreFilePath);
        int size = arrayListRestoreObjectList.size();
        removeUnsupportedObject(arrayListRestoreObjectList);
        SmLogger.m8661d(getTag(), "pasteSpenObject# " + arrayListRestoreObjectList.size() + "/" + size);
        this.handler.post(new RunnableC8928b(this, 2, arrayListRestoreObjectList, position));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pasteSpenObjects$lambda$1(SmPasteTask smPasteTask, ArrayList arrayList, PointF pointF) {
        smPasteTask.addObjects(arrayList, pointF);
        SmLogger.m8661d(smPasteTask.getTag(), "pasteSpenObject# end");
        smPasteTask.endHistoryGroup();
        smPasteTask.notifyCallback(true, smPasteTask.makeResults(smPasteTask.getInputs().getContext()));
    }

    private final void removeUnsupportedObject(ArrayList<SpenObjectBase> objectList) {
        Iterator<SpenObjectBase> it = objectList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenObjectBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenObjectBase spenObjectBase = next;
            if (ObjectTypeHelper.INSTANCE.isTextType(spenObjectBase.getType())) {
                if (!spenObjectBase.hasExtraDataByteArray("CopiedText")) {
                    it.remove();
                    setErrorMsg();
                } else if (spenObjectBase.getType() == 2 && ObjectHelper.INSTANCE.removeObjectSpan((SpenObjectTextBox) spenObjectBase)) {
                    setErrorMsg();
                }
            } else if (spenObjectBase.getType() != 1) {
                it.remove();
                setErrorMsg();
            }
        }
    }

    private final void setErrorMsg() {
        if (this.errorMsgStringId == null) {
            this.errorMsgStringId = Integer.valueOf(C8875R.string.sticky_memo_can_paste);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.ITask
    public void clear() {
        this.handler.removeCallbacksAndMessages(null);
        clearService();
    }

    public final boolean getBeginHistory() {
        return this.beginHistory;
    }

    @Nullable
    public final Integer getErrorMsgStringId() {
        return this.errorMsgStringId;
    }

    @NotNull
    public final Handler getHandler() {
        return this.handler;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTask
    public void run() {
        if (getInputs().getPastePosition() == null) {
            paste(getInputs().getClipData());
        } else {
            paste(getInputs().getClipData(), getInputs().getPastePosition());
        }
    }

    public final void setBeginHistory(boolean z) {
        this.beginHistory = z;
    }

    public final void setErrorMsgStringId(@Nullable Integer num) {
        this.errorMsgStringId = num;
    }

    public final void setHandler(@NotNull Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.handler = handler;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTask
    public void notifyCallback(boolean success, @NotNull Results results) {
        Intrinsics.checkNotNullParameter(results, "results");
        endHistoryGroup();
        super.notifyCallback(success, results);
    }

    private final void paste(ClipData clipData, PointF pastePosition) {
        if (!this.beginHistory && !getInputs().getObjectManager().getNote().isGroupingHistory()) {
            getInputs().getObjectManager().getNote().beginHistoryGroup();
        }
        String backupPathFromHtml = ClipDataBackupPath.getBackupPathFromHtml(clipData);
        if (ClipDataBackupPath.isNoteClip(backupPathFromHtml)) {
            if (ClipboardCacheManager.isPageData(backupPathFromHtml)) {
                SmLogger.m8661d(getTag(), "getContentsFromClipData# page data");
                setErrorMsg();
                notifyCallback(false, makeResults(getInputs().getContext()));
                return;
            } else {
                setExecutorService(Executors.newSingleThreadExecutor(new SenlThreadFactory(SmCopyTask.INSTANCE.getTAG())));
                if (getExecutorService() != null) {
                    SpenWNote note = getInputs().getObjectManager().getNote();
                    Intrinsics.checkNotNull(backupPathFromHtml);
                    pasteSpenObjects(note, backupPathFromHtml, pastePosition);
                    return;
                }
                return;
            }
        }
        pasteRawContents(clipData);
        notifyCallback(true, makeResults(getInputs().getContext()));
    }
}
