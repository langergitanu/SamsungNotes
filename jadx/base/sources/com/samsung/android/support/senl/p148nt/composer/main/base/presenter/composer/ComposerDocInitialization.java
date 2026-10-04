package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.util.Pair;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.SpenDocumentInitializer;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectLayoutOption;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextBoxData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.BodyTextAlign;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.BodyTextFontSize;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.common.ModelManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.TemplateUtil;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import java.util.ArrayList;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerDocInitialization {
    private static final String TAG = Logger.createTag("ComposerDocInitialization");
    private final Activity mActivity;
    private final boolean mLoadSettingBgColor;
    private final SpenWNote mNote;
    private final NoteManager mNoteManager;
    private final int mObjectLayoutType;
    private final PageManager mPageManager;
    private final int mSinglePageDefaultPageCount;
    private int mSpenPageType;
    private final TextManager mTextManager;
    private final boolean mUseTemplate;

    public ComposerDocInitialization(Activity activity, SpenWNote spenWNote, ModelManager modelManager, boolean z) {
        this(activity, spenWNote, modelManager, 2, z, true);
    }

    private int getHeightFromValue(Activity activity) {
        Intent intent;
        return this.mNote.getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW ? DocumentPageRatio.PageRatioType.A4_LANDSCAPE.getHeight(this.mNote.getPageDefaultWidth()) : this.mNote.getPageMode() == SpenWNote.PageMode.LIST ? (activity == null || (intent = activity.getIntent()) == null || !intent.hasExtra(SettingsConstants.SETTINGS_PAGE_SIZE)) ? DocumentPageRatio.getPageRatioTypeFromSettings().getHeight(this.mNote.getPageDefaultWidth()) : DocumentPageRatio.convertFromSettings(intent.getIntExtra(SettingsConstants.SETTINGS_PAGE_SIZE, 0)).getHeight(this.mNote.getPageDefaultWidth()) : DocumentPageRatio.PageRatioType.A4_PORTRAIT.getHeight(this.mNote.getPageDefaultWidth());
    }

    private void initBodyText(SpenWNote spenWNote, ObjectTextBoxData objectTextBoxData) {
        SpenObjectTextBox bodyText = spenWNote.getBodyText();
        bodyText.setTextAlignment(objectTextBoxData.getDefaultAlign());
        bodyText.setFontSize(objectTextBoxData.getDefaultFontSize());
        bodyText.setTextColor(objectTextBoxData.getDefaultFontColor());
        bodyText.setAutoFitOption(2);
        bodyText.setMargin(16.0f, 10.0f, 16.0f, 10.0f);
        spenWNote.commitHistory();
    }

    private void initDefaultTemplate(Intent intent, NoteManager noteManager) {
        if (!this.mUseTemplate) {
            noteManager.setDefaultTemplate(this.mSpenPageType, null);
            return;
        }
        Pair<Integer, String> pageTypeAndPathFromIntent = TemplateUtil.getPageTypeAndPathFromIntent(intent);
        this.mSpenPageType = pageTypeAndPathFromIntent.first.intValue();
        String str = TAG;
        StringBuilder sb = new StringBuilder("initDefaultTemplate# ");
        sb.append(this.mSpenPageType);
        sb.append(" ");
        String str2 = pageTypeAndPathFromIntent.second;
        AbstractC8014b.m7213o(sb, str2 != null ? Logger.getEncode(str2) : "null", str);
        noteManager.setDefaultTemplate(this.mSpenPageType, pageTypeAndPathFromIntent.second);
    }

    private void initEmptyBodyTextForCoedit(SpenWNote spenWNote) {
        boolean z;
        boolean z2;
        if (spenWNote.isCoeditMode()) {
            SpenObjectTextBox bodyText = spenWNote.getBodyText();
            if (TextUtils.isEmpty(bodyText.getText())) {
                ArrayList<SpenTextSpanBase> textSpan = bodyText.getTextSpan();
                boolean z3 = false;
                if (textSpan != null) {
                    z = false;
                    z2 = false;
                    for (SpenTextSpanBase spenTextSpanBase : textSpan) {
                        if (spenTextSpanBase.getType() == 3) {
                            z = true;
                        } else if (spenTextSpanBase.getType() == 1) {
                            z2 = true;
                        }
                    }
                } else {
                    z = false;
                    z2 = false;
                }
                if (!z) {
                    bodyText.setFontSize(new BodyTextFontSize(this.mTextManager.getFontSizeDelta()).getValue());
                }
                if (!z2) {
                    bodyText.setTextColor(this.mActivity.getResources().getColor(C9086R.color.composer_light_font_color, null));
                }
                ArrayList<SpenTextParagraphBase> textParagraph = bodyText.getTextParagraph();
                if (textParagraph != null) {
                    Iterator<SpenTextParagraphBase> it = textParagraph.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().getType() == 3) {
                                z3 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (!z3) {
                    bodyText.setTextAlignment(BodyTextAlign.getStoredValue());
                }
                AbstractC8014b.m7215q(AbstractC2821a.m2230u("initEmptyBodyTextForCoedit# ", SQLKeyword.COMMA, SQLKeyword.COMMA, z, z2), z3, TAG);
            }
        }
    }

    private void initNew(boolean z, int i, int i2) {
        if (this.mNote == null) {
            return;
        }
        int defaultBackgroundColor = CommonUtil.resolveAttribute(this.mActivity, C9086R.attr.backgroundColor).data;
        if (this.mLoadSettingBgColor) {
            defaultBackgroundColor = BackgroundColorUtil.getDefaultBackgroundColor(defaultBackgroundColor);
        }
        if (this.mPageManager.getPageList() != null && this.mPageManager.getPageCount() > 0) {
            this.mPageManager.getPageList().clear();
            this.mPageManager.setBlockToInsert(true);
        }
        if (z) {
            this.mPageManager.init(1, SpenWNote.PageMode.SINGLE);
            SpenWPage spenWPageAppendPage = this.mNote.appendPage(i, i2 * this.mSinglePageDefaultPageCount);
            spenWPageAppendPage.setBackgroundColor(defaultBackgroundColor);
            setTemplate(spenWPageAppendPage, 3);
            this.mPageManager.add(new PageInfo(0, i, 0, spenWPageAppendPage.getId()));
        } else {
            this.mPageManager.init(2, SpenWNote.PageMode.LIST);
            this.mPageManager.updatePageInfo(this.mNote.getOrientation());
            for (int i4 = 0; i4 < 2; i4++) {
                SpenWPage spenWPageAppendPage2 = this.mNote.appendPage(i, i2);
                spenWPageAppendPage2.setBackgroundColor(defaultBackgroundColor);
                setTemplate(spenWPageAppendPage2, 2);
                this.mPageManager.add(new PageInfo(i4, i, i2, spenWPageAppendPage2.getId()));
            }
        }
        this.mPageManager.setBlockToInsert(false);
        setInvertBackgroundColor();
        setFixedParamCoeditNote();
        initBodyText(this.mNote, new ObjectTextBoxData(new BodyTextFontSize(this.mTextManager.getFontSizeDelta()).getValue(), BodyTextAlign.getStoredValue(), this.mActivity.getResources().getColor(C9086R.color.composer_light_font_color, null)));
    }

    private void setTemplate(SpenWPage spenWPage, int i) {
        if (this.mNoteManager.getDefTemplateType() == 16) {
            this.mNoteManager.setTemplate(spenWPage, 0, (String) null, (String) null, i);
        } else if (this.mNoteManager.getDefTemplateType() == 17) {
            this.mNoteManager.setDynamicTemplate(spenWPage, new ArrayList<>());
        } else {
            NoteManager noteManager = this.mNoteManager;
            noteManager.setTemplate(spenWPage, noteManager.getDefTemplateType(), this.mNoteManager.getDefTemplatePath(), this.mNoteManager.getDefTemplatePath(), i);
        }
    }

    public void init(boolean z) {
        int pageCount = this.mNote.getPageCount();
        String str = TAG;
        AbstractC0000a.m3D(pageCount, "initData# page count: ", str);
        initDefaultTemplate(this.mActivity.getIntent(), this.mNoteManager);
        new SpenDocumentInitializer().setPageVerticalPadding(this.mNote);
        this.mNote.setObjectDefaultFlowLayoutType(this.mObjectLayoutType);
        boolean z2 = true;
        if (pageCount == 0) {
            initNew(this.mNote.getPageMode() == SpenWNote.PageMode.SINGLE, this.mNote.getPageDefaultWidth(), getHeightFromValue(this.mActivity));
            z = true;
        } else if (pageCount == 1 && this.mNote.getPageMode() == SpenWNote.PageMode.LIST) {
            this.mNote.appendPage();
            Logger.printFileLog(str + "#ListPageAppendPage");
            z = true;
            z2 = false;
        } else {
            z2 = false;
        }
        if (!z2) {
            initEmptyBodyTextForCoedit(this.mNote);
        }
        if (z || z) {
            this.mNote.clearHistory();
            Logger.m11003i(str, "clearHistory ");
        }
    }

    public void initNoteManager(SpenWNote spenWNote) {
        this.mNoteManager.init(spenWNote, spenWNote.getPageDefaultWidth() / 360.0f);
    }

    public void setFixedParamCoeditNote() {
        if (this.mNote.isCoeditMode()) {
            this.mNote.setFixedTextDirection(SpenWNote.TextDirection.TEXT_DIRECTION_LTR);
            this.mNote.setFixedBackgroundTheme(SpenWNote.BackgroundTheme.THEME_LIGHT);
        }
    }

    public void setInvertBackgroundColor() {
        if (this.mNote.isCoeditMode()) {
            if (ContextUtils.isNightMode(this.mActivity) && BackgroundColorUtil.getDefaultBackgroundInvert()) {
                ToastHandler.show(this.mActivity, C9086R.string.coedit_swiched_to_light_mode, 0);
            }
            this.mNote.invertBackgroundColor(false);
            return;
        }
        if (this.mSpenPageType == 12) {
            this.mNote.invertBackgroundColor(false);
        } else {
            this.mNote.invertBackgroundColor(BackgroundColorUtil.getDefaultBackgroundInvert());
        }
    }

    public void setPageDefaultHeight() {
        setPageDefaultHeight(this.mNote);
    }

    public ComposerDocInitialization(Activity activity, SpenWNote spenWNote, ModelManager modelManager, int i, boolean z, boolean z2) {
        this.mSpenPageType = 0;
        this.mActivity = activity;
        this.mNote = spenWNote;
        this.mPageManager = modelManager.getPageManager();
        this.mNoteManager = modelManager.getNoteManager();
        this.mTextManager = modelManager.getTextManager();
        int layoutOption = modelManager.getObjectManager().getLayoutOption();
        int i2 = ObjectLayoutOption.LAYOUT_WRAP_TEXT_AROUND;
        this.mObjectLayoutType = layoutOption != i2 ? ObjectLayoutOption.LAYOUT_WRAP_TEXT_BEHIND : i2;
        this.mSinglePageDefaultPageCount = i;
        this.mUseTemplate = z;
        this.mLoadSettingBgColor = z2;
        Logger.m10999d(TAG, "ComposerDocInitialization end");
    }

    public static void setPageDefaultHeight(SpenWNote spenWNote) {
        if (spenWNote.getPageDefaultHeight() != 0) {
            return;
        }
        int height = spenWNote.getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW ? DocumentPageRatio.PageRatioType.A4_LANDSCAPE.getHeight(spenWNote.getPageDefaultWidth()) : DocumentPageRatio.PageRatioType.A4_PORTRAIT.getHeight(spenWNote.getPageDefaultWidth());
        Logger.m10999d(TAG, "setPageDefaultHeight#" + height);
        spenWNote.setPageDefaultHeight(height);
    }
}
