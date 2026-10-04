package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste;

import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.util.Pair;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCopyUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditRestriction {
    public static final int ERR_NONE = 0;
    public static final int ERR_OBJECT_SPAN = 2;
    public static final int ERR_OVER_MAX_COUNT = 1;
    public static final int ERR_OVER_MAX_COUNT_LARGE_ITEMS = 3;
    private static final String TAG = Logger.createTag("TaskPaste$CoeditRestriction");
    ComposerModel mComposerModel;

    public CoeditRestriction(ComposerModel composerModel) {
        this.mComposerModel = composerModel;
    }

    private int applyCoeditRestrictionToObjectSpan(SpenObjectTextBox spenObjectTextBox) {
        List<SpenObjectSpan> filteredLargeSizeItems = this.mComposerModel.getComposerSpenDocModel().getFilteredLargeSizeItems(spenObjectTextBox);
        int size = filteredLargeSizeItems.size();
        int largeSizeItemsCount = this.mComposerModel.getComposerSpenDocModel().getLargeSizeItemsCount();
        int i = 100 - largeSizeItemsCount;
        if (size <= i) {
            return 0;
        }
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(size, largeSizeItemsCount, "applyCoeditRestriction# i: ", " c: ", " a: ");
        sbM1173s.append(i);
        Logger.m11003i(str, sbM1173s.toString());
        int iMax = size - Math.max(0, i);
        for (int i2 = 1; i2 <= iMax; i2++) {
            spenObjectTextBox.removeObjectSpan(filteredLargeSizeItems.get(size - i2));
        }
        return 3;
    }

    private void removeOverMaxCount(List list) {
        int size = list.size();
        while (true) {
            size--;
            if (size < 100) {
                return;
            } else {
                list.remove(size);
            }
        }
    }

    private void removeUnsupportedCharsFromObjects(List<SpenObjectBase> list) {
        ArrayList arrayList = new ArrayList();
        for (SpenObjectBase spenObjectBase : list) {
            if (spenObjectBase instanceof SpenObjectShape) {
                arrayList.add((SpenObjectShape) spenObjectBase);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        DocumentCopyUtils.removeUnsupportedCharactersForCoedit(arrayList);
    }

    public boolean applyCoeditRestriction(SpenWNote spenWNote) {
        if (!this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote()) {
            return false;
        }
        if (spenWNote.getPageCount() < 200) {
            return false;
        }
        Logger.m10999d(TAG, "applyCoeditRestriction");
        ArrayList<SpenWPage> pageList = spenWNote.getPageList();
        ArrayList<SpenWPage> arrayList = new ArrayList<>();
        for (int i = 200; i < spenWNote.getPageCount(); i += 2) {
            arrayList.add(pageList.get(i));
            arrayList.add(pageList.get(i + 1));
        }
        spenWNote.removePageList(arrayList);
        return true;
    }

    public int applyCoeditRestrictionToContent(List<Pair<Content.Base, Uri>> list) {
        if (!this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote()) {
            return 0;
        }
        Logger.m10999d(TAG, "applyCoeditRestrictionToContent");
        int i = list.size() > 100 ? 1 : 0;
        ArrayList arrayList = new ArrayList();
        for (Pair<Content.Base, Uri> pair : list) {
            if (((Content.Base) pair.first).getType() == 1 || ((Content.Base) pair.first).getType() == 2) {
                arrayList.add(pair);
            }
        }
        int size = arrayList.size();
        int largeSizeItemsCount = this.mComposerModel.getComposerSpenDocModel().getLargeSizeItemsCount();
        int i2 = 100 - largeSizeItemsCount;
        if (size > i2) {
            String str = TAG;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(size, largeSizeItemsCount, "applyCoeditRestriction# i: ", " c: ", " a: ");
            sbM1173s.append(i2);
            Logger.m11003i(str, sbM1173s.toString());
            int iMax = size - Math.max(0, i2);
            for (int i4 = 1; i4 <= iMax; i4++) {
                list.remove((Pair) arrayList.get(size - i4));
            }
            i = 3;
        }
        removeOverMaxCount(list);
        return i;
    }

    public int applyCoeditRestrictionToObjects(List<SpenObjectBase> list, boolean z) {
        if (!this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote()) {
            return 0;
        }
        if (!z) {
            return applyCoeditRestrictionToObjects(list);
        }
        if (!(list.get(0) instanceof SpenObjectTextBox)) {
            Logger.m11000e(TAG, "applyCoeditRestrictionToObjects# unexpected object type");
            return 0;
        }
        SpenObjectTextBox spenObjectTextBox = (SpenObjectTextBox) list.get(0);
        int iApplyCoeditRestrictionToObjectSpan = applyCoeditRestrictionToObjectSpan(spenObjectTextBox);
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(spenObjectTextBox);
            DocumentCopyUtils.removeUnsupportedCharactersForCoedit(arrayList);
        }
        return iApplyCoeditRestrictionToObjectSpan;
    }

    public boolean isCoeditMaxCountLimit(List list) {
        return this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote() && list != null && list.size() > 100;
    }

    public void removeUnsupportedChars(List<Content.Base> list) {
        if (this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote()) {
            for (Content.Base base : list) {
                if (base instanceof Content.Text) {
                    Content.Text text = (Content.Text) base;
                    text.setText(DocumentCopyUtils.removeUnsupportedCharactersForCoedit(new SpannableStringBuilder(text.getText())));
                } else if (base instanceof Content.HtmlContent) {
                    for (SpenObjectBase spenObjectBase : ((Content.HtmlContent) base).mObjectList) {
                        if (spenObjectBase instanceof SpenObjectTextBox) {
                            DocumentCopyUtils.removeUnsupportedCharactersForCoedit((SpenObjectTextBox) spenObjectBase);
                        }
                    }
                }
            }
        }
    }

    private int applyCoeditRestrictionToObjects(List<SpenObjectBase> list) {
        int i;
        if (!this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote() || list == null || list.isEmpty()) {
            return 0;
        }
        if (list.size() > 100) {
            removeOverMaxCount(list);
            i = 1;
        } else {
            i = 0;
        }
        List<SpenObjectBase> filteredLargeSizeItems = this.mComposerModel.getComposerSpenDocModel().getFilteredLargeSizeItems(list);
        int size = filteredLargeSizeItems.size();
        int largeSizeItemsCount = this.mComposerModel.getComposerSpenDocModel().getLargeSizeItemsCount();
        int i2 = 100 - largeSizeItemsCount;
        if (size > i2) {
            String str = TAG;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(size, largeSizeItemsCount, "applyCoeditRestriction# i: ", " c: ", " a: ");
            sbM1173s.append(i2);
            Logger.m11003i(str, sbM1173s.toString());
            int iMax = size - Math.max(0, i2);
            for (int i4 = 1; i4 <= iMax; i4++) {
                list.remove(filteredLargeSizeItems.get(size - i4));
            }
            i = 3;
        }
        removeUnsupportedCharsFromObjects(list);
        return i;
    }
}
