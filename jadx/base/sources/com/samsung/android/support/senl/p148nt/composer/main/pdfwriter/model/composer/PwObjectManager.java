package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.composer;

import android.graphics.PointF;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectCodeBlock;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTypeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwObjectManager extends ObjectManager {
    private static final String TAG = Logger.createTag("PwObjectManager");

    public PwObjectManager(boolean z) {
        super(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager
    public Pair<SpenObjectBase, Boolean> addContents(int i, List<Content.Base> list, PointF pointF, boolean z) {
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "addContents# to =", " / ");
        sbM778t.append(this.mNote.getPageCount());
        sbM778t.append(" paste position: ");
        sbM778t.append(pointF);
        sbM778t.append(", keepPage:");
        sbM778t.append(z);
        sbM778t.append(", list : ");
        sbM778t.append(list.size());
        Logger.m11003i(str, sbM778t.toString());
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Content.ConvertContract convertContract = getConvertContract(spannableStringBuilder);
        boolean z2 = true;
        for (Content.Base base : list) {
            String str2 = TAG;
            Logger.m11003i(str2, "addContents# content type: " + base.getType());
            SpenObjectBase spenObjectBaseConvertToSpenObject = base.convertToSpenObject(convertContract);
            if (spenObjectBaseConvertToSpenObject == null) {
                if (base.getType() == 2) {
                    Logger.m11000e(str2, "addContents# VoiceManager.isValid is false.");
                    z2 = false;
                } else if (base.getType() == 0) {
                    if (isFocusedTextBox()) {
                        insertTextContents(spannableStringBuilder);
                    } else {
                        SpenObjectTextBox newTextBox = getNewTextBox();
                        newTextBox.insertText(spannableStringBuilder.toString(), 0);
                        if (!TextUtils.isEmpty(newTextBox.getText())) {
                            spenObjectBaseConvertToSpenObject = newTextBox;
                        }
                    }
                    spannableStringBuilder.clear();
                }
                if (spenObjectBaseConvertToSpenObject == null) {
                }
            }
            arrayList.add(spenObjectBaseConvertToSpenObject);
        }
        if (arrayList.isEmpty()) {
            Logger.m10999d(TAG, "addContents# end - newObjList is empty. ");
            return new Pair<>(null, Boolean.valueOf(z2));
        }
        insertObjectList(pointF, this.mNote.getPage(i), arrayList, true);
        Logger.m10999d(TAG, "addContents# end");
        return new Pair<>((SpenObjectBase) AbstractC1974b.m1313f(1, arrayList), Boolean.valueOf(z2));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager
    public void addObjects(int i, List<SpenObjectBase> list, @Nullable PointF pointF) {
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "addObjects# to =", " / ");
        sbM778t.append(this.mNote.getPageCount());
        sbM778t.append(", position : ");
        sbM778t.append(pointF);
        sbM778t.append(", HwMode:");
        AbstractC8014b.m7222x(sbM778t, this.mHwMode, str);
        SpenWPage page = this.mNote.getPage(i);
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>();
        for (SpenObjectBase spenObjectBase : list) {
            String str2 = TAG;
            Logger.m11003i(str2, "addObjects# " + spenObjectBase.getType());
            if (ObjectTypeUtil.isTextType(spenObjectBase.getType()) && spenObjectBase.hasExtraDataByteArray("CopiedText")) {
                SpenObjectShape spenObjectShape = (SpenObjectShape) spenObjectBase;
                arrayList.addAll(getObjectFromObjectSpan(spenObjectShape.getObjectSpan(), true, true, true));
                if (!isEmptyFocusTextBox(spenObjectShape) && spenObjectShape.getText() != null) {
                    int length = spenObjectShape.getText().length();
                    if (isFocusedTextBox()) {
                        int[] cursorFromFocusedTextBox = this.mTextManager.getCursorFromFocusedTextBox();
                        Logger.m11003i(str2, "addObjects# textbox cursor:" + cursorFromFocusedTextBox[0] + " / " + cursorFromFocusedTextBox[1] + ", length:" + length);
                        this.mTextManager.getTextBox().insertText(cursorFromFocusedTextBox[0], spenObjectShape, 0, length);
                    } else {
                        SpenObjectTextBox newTextBox = getNewTextBox();
                        newTextBox.insertText(0, spenObjectShape, 0, length);
                        ArrayList arrayList2 = new ArrayList(1);
                        Object obj = new Object[]{newTextBox}[0];
                        insertObjectList(pointF, page, new ArrayList<>(AbstractC2322a.m1630t(obj, arrayList2, obj, arrayList2)), true ^ this.mHwMode);
                        if (pointF != null) {
                            pointF.offset(0.0f, newTextBox.getRect().height());
                        }
                        Logger.m11003i(str2, "addObjects# newTextBox# length:" + length + ", position:" + pointF);
                    }
                }
            } else if (spenObjectBase.getType() != 10 || !(spenObjectBase instanceof SpenObjectVoice)) {
                if (spenObjectBase instanceof SpenObjectTable) {
                    Logger.m11000e(str2, "addObjects# table is not supported in pdf reader");
                } else if (spenObjectBase instanceof SpenObjectCodeBlock) {
                    Logger.m11000e(str2, "addObjects# code block is not supported in pdf reader");
                } else {
                    arrayList.add(spenObjectBase);
                }
            }
        }
        insertObjectList(pointF, page, arrayList, !this.mHwMode);
        Logger.m11003i(TAG, "addObjects# end");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager
    public boolean addObjectsFromHtml(int i, List<SpenObjectBase> list, @Nullable PointF pointF) {
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "addObjectsFromHtml# to =", " / ");
        sbM778t.append(this.mNote.getPageCount());
        sbM778t.append(", position : ");
        sbM778t.append(pointF);
        sbM778t.append(", HwMode:");
        AbstractC8014b.m7222x(sbM778t, this.mHwMode, str);
        SpenWPage page = this.mNote.getPage(i);
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>();
        boolean z = true;
        for (SpenObjectBase spenObjectBase : list) {
            int type = spenObjectBase.getType();
            String str2 = TAG;
            Logger.m11003i(str2, "addObjectsFromHtml# " + type);
            if (ObjectTypeUtil.isTextType(type)) {
                SpenObjectTextBox spenObjectTextBox = (SpenObjectTextBox) spenObjectBase;
                if (spenObjectTextBox.getText() != null) {
                    int length = spenObjectTextBox.getText().length();
                    if (isFocusedTextBox()) {
                        int[] cursorFromFocusedTextBox = this.mTextManager.getCursorFromFocusedTextBox();
                        Logger.m11003i(str2, "addObjectsFromHtml# textbox cursor:" + cursorFromFocusedTextBox[0] + " / " + cursorFromFocusedTextBox[1] + ", length:" + length);
                        this.mTextManager.getTextBox().insertText(cursorFromFocusedTextBox[0], spenObjectTextBox, 0, spenObjectTextBox.getText().length());
                    } else {
                        SpenObjectTextBox newTextBox = getNewTextBox();
                        newTextBox.insertText(0, spenObjectTextBox, 0, length);
                        ArrayList arrayList2 = new ArrayList(1);
                        Object obj = new Object[]{newTextBox}[0];
                        insertObjectList(pointF, page, new ArrayList<>(AbstractC2322a.m1630t(obj, arrayList2, obj, arrayList2)), !this.mHwMode);
                        if (pointF != null) {
                            pointF.offset(0.0f, newTextBox.getRect().height());
                        }
                        Logger.m11003i(str2, "addObjectsFromHtml# newTextBox# length:" + length + ", position:" + pointF);
                    }
                }
            } else {
                if (spenObjectBase instanceof SpenObjectTable) {
                    Logger.m11000e(str2, "addObjectsFromHtml# table is not supported in pdf reader");
                } else if (spenObjectBase instanceof SpenObjectCodeBlock) {
                    Logger.m11000e(str2, "addObjectsFromHtml# code block is not supported in pdf reader");
                } else {
                    arrayList.add(spenObjectBase);
                }
                z = false;
            }
        }
        insertObjectList(pointF, page, arrayList, !this.mHwMode);
        Logger.m11003i(TAG, "addObjectsFromHtml# end");
        return z;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager
    public boolean isFixedMaxPage() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager
    public boolean isSelectedBodyText() {
        return false;
    }
}
