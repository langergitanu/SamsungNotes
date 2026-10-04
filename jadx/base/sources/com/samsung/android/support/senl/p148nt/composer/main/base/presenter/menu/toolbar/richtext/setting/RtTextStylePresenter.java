package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting;

import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.richtext.TextStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtTextStylePresenter {
    public static final int MAX_STYLE_COUNT = 10;
    public static final int MIN_STYLE_COUNT = 1;
    private static final String TAG = Logger.createTag("RtTextStylePresenter");
    private ObjectManager mObjectManager;
    private TextManager mTextManager;
    private List<TextStyle> mTextStyles = new ArrayList();

    public RtTextStylePresenter(ComposerViewContract.IPresenter iPresenter) {
        this.mTextManager = iPresenter.getTextManager();
        this.mObjectManager = iPresenter.getObjectManager();
        loadData();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger.m11000e(com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtTextStylePresenter.TAG, "addTextStyle# isSame ");
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getEmptyIndex() {
        int i = 0;
        while (i < 10) {
            Iterator<TextStyle> it = this.mTextStyles.iterator();
            while (it.hasNext()) {
                if (it.next().getIndex() == i) {
                    break;
                }
            }
            return i;
        }
        return 0;
    }

    public boolean addTextStyle(TextStyle textStyle) {
        if (getStyleCount() >= 10) {
            Logger.m11000e(TAG, "addTextStyle# max count ");
            return false;
        }
        Iterator<TextStyle> it = this.mTextStyles.iterator();
        while (it.hasNext()) {
            if (it.next().equals(textStyle)) {
                Logger.m11000e(TAG, "addTextStyle# isSame ");
                return false;
            }
        }
        TextStyle textStyle2 = new TextStyle(textStyle);
        textStyle2.setIndex(getEmptyIndex());
        this.mTextStyles.add(textStyle2);
        return true;
    }

    public boolean applyStyle(int i) {
        if (this.mTextStyles.size() <= i) {
            Logger.m11000e(TAG, "applyStyle size : " + this.mTextStyles.size() + " index : " + i);
            return false;
        }
        TextStyle textStyle = this.mTextStyles.get(i);
        this.mObjectManager.commitHistory();
        this.mObjectManager.getSelectedObjectManager().setFocusCurTextBox();
        this.mTextManager.setStyle(5, textStyle.isBold());
        this.mTextManager.setStyle(6, textStyle.isItalic());
        this.mTextManager.setStyle(7, textStyle.isUnderline());
        this.mTextManager.setStyle(20, textStyle.isStrikethrough());
        this.mTextManager.setFontSize(textStyle.getFontSize());
        this.mTextManager.setTextColor(textStyle.getFontColor());
        this.mTextManager.setTextBgColor(textStyle.getFontBgColor());
        this.mObjectManager.commitHistory();
        return true;
    }

    public TextStyle getStyle(int i) {
        return this.mTextStyles.size() > i ? this.mTextStyles.get(i) : this.mTextStyles.get(0);
    }

    public int getStyleCount() {
        return this.mTextStyles.size();
    }

    public List<TextStyle> getStyles() {
        return this.mTextStyles;
    }

    public boolean isContainTextStyleList(TextStyle textStyle) {
        Iterator<TextStyle> it = this.mTextStyles.iterator();
        while (it.hasNext()) {
            if (it.next().equals(textStyle)) {
                return true;
            }
        }
        return false;
    }

    public void loadData() {
        String string = SharedPreferencesCompat.getInstance(TextStyle.KEY_TEXT_STYLE_INFO).getString(TextStyle.KEY_TEXT_STYLE_LIST, "");
        if (TextUtils.isEmpty(string)) {
            string = "0;1;2";
            SharedPreferencesCompat.getInstance(TextStyle.KEY_TEXT_STYLE_INFO).putString(TextStyle.KEY_TEXT_STYLE_LIST, "0;1;2");
        }
        String[] strArrSplit = string.split(";");
        if (strArrSplit.length == 0) {
            Logger.m11000e(TAG, "loadData data.length 0 ");
            return;
        }
        for (String str : strArrSplit) {
            TextStyle index = new TextStyle().setIndex(Integer.parseInt(str));
            if (index.load()) {
                this.mTextStyles.add(index);
            }
        }
    }

    public boolean removeTextStyle(TextStyle textStyle) {
        for (TextStyle textStyle2 : this.mTextStyles) {
            if (textStyle2.equals(textStyle)) {
                this.mTextStyles.remove(textStyle2);
                return true;
            }
        }
        return false;
    }

    public boolean saveData(List<TextStyle> list) {
        this.mTextStyles.clear();
        this.mTextStyles.addAll(list);
        return saveData();
    }

    public boolean saveData() {
        if (this.mTextStyles.isEmpty()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        int size = this.mTextStyles.size();
        for (int i = 0; i < size; i++) {
            TextStyle textStyle = this.mTextStyles.get(i);
            if (textStyle.save()) {
                sb.append(textStyle.getIndex());
                if (i != size - 1) {
                    sb.append(";");
                }
            }
        }
        String string = SharedPreferencesCompat.getInstance(TextStyle.KEY_TEXT_STYLE_INFO).getString(TextStyle.KEY_TEXT_STYLE_LIST, "");
        if (!TextUtils.isEmpty(string) && string.equals(sb.toString())) {
            return false;
        }
        SharedPreferencesCompat.getInstance(TextStyle.KEY_TEXT_STYLE_INFO).putString(TextStyle.KEY_TEXT_STYLE_LIST, sb.toString());
        return true;
    }
}
