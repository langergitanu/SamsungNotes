package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.SpannableStringBuilder;
import android.text.style.BulletSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.lifecycle.LiveData;
import com.samsung.android.imagetranslation.util.AbstractC7150s;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.TypedArrayCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.SOMRecognizedInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.model.RecognizeTextInfo;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.link.CustomLinkSpec;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.link.CustomLinkify;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.link.LinkAction;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesOrganizedDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.TextInfo;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.facade.RecognitionFacade;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SOMRecognizeUtil {
    private static final float ADDED_RECOGNIZED_WIDTH_HEIGHT = 1.0f;
    private static final int MAX_RECOGNIZED_PAGE_COUNT = 2;
    private static final String TAG = "SOMRecognizeUtil";
    private static final Object mConvertedColorsLock = new Object();
    private static final Map<Integer, Integer> mConvertedColors = new HashMap();

    private static void addWhiteSpaceIfTextInfoEndWithLink(SpannableStringBuilder spannableStringBuilder, int i) {
        int length = spannableStringBuilder.length();
        if (i == length) {
            spannableStringBuilder.insert(i, (CharSequence) Constant.WHITE_SPACE_STRING);
        } else {
            if (i >= length || '\n' != spannableStringBuilder.charAt(i)) {
                return;
            }
            spannableStringBuilder.insert(i, (CharSequence) Constant.WHITE_SPACE_STRING);
        }
    }

    public static void applyBulletToTextData(SpannableStringBuilder spannableStringBuilder) {
        for (int length = spannableStringBuilder.length() - 2; length >= 0; length--) {
            if (spannableStringBuilder.charAt(length) == '\n') {
                int i = length + 1;
                if (spannableStringBuilder.charAt(i) != '\n') {
                    spannableStringBuilder.insert(i, Constant.WHITE_SPACE_FOR_LINK_ICON);
                    spannableStringBuilder.setSpan(new BulletSpan(), i, length + 2, 33);
                }
            }
        }
        spannableStringBuilder.insert(0, Constant.WHITE_SPACE_FOR_LINK_ICON);
        spannableStringBuilder.setSpan(new BulletSpan(), 0, 1, 33);
    }

    public static void applyColorToDecoratedTextInfo(SpannableStringBuilder spannableStringBuilder, JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String next = jSONObject.keys().next();
                if (!Constant.NEW_LINE_STRING.equals(next)) {
                    int i4 = jSONObject.getInt(next);
                    int iIndexOf = spannableStringBuilder.toString().indexOf(next, i);
                    if (iIndexOf >= 0) {
                        int length2 = next.length() + iIndexOf;
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(i4), iIndexOf, length2, 33);
                        i = length2;
                    }
                }
            } catch (JSONException e) {
                MainLogger.m7255e(TAG, "applyColorToDecoratedTextInfo, JSONException: " + e.getMessage());
            }
        }
    }

    public static void applyLinkToTextData(final Context context, SpannableStringBuilder spannableStringBuilder) {
        int iRemoveWhiteSpaceFromEnd;
        ArrayList<CustomLinkSpec> arrayListAddLinks = CustomLinkify.getInstance(context).addLinks(spannableStringBuilder.toString(), 63);
        for (int size = arrayListAddLinks.size() - 1; size >= 0; size--) {
            CustomLinkSpec customLinkSpec = arrayListAddLinks.get(size);
            final int type = customLinkSpec.getType();
            int start = customLinkSpec.getStart();
            int end = customLinkSpec.getEnd();
            if (type != 7 || isFormulaActionLinkEnable()) {
                Drawable linkIcon = getLinkIcon(context, type);
                if (linkIcon != null) {
                    spannableStringBuilder.insert(start, Constant.WHITE_SPACE_FOR_LINK_ICON);
                    linkIcon.setBounds(0, 0, context.getResources().getDimensionPixelSize(C8003R.dimen.som_recognized_card_title_text_size), context.getResources().getDimensionPixelSize(C8003R.dimen.som_recognized_card_title_text_size));
                    spannableStringBuilder.setSpan(new ImageSpan(linkIcon), start, start + 1, 33);
                    start += 2;
                    end += 2;
                }
                if (type == 2 || type == 3 || type == 1) {
                    iRemoveWhiteSpaceFromEnd = removeWhiteSpaceFromEnd(spannableStringBuilder, start, end);
                } else {
                    if (type == 6) {
                        iRemoveWhiteSpaceFromEnd = removeContinuousWhiteSpaceFromEnd(spannableStringBuilder, start, end);
                    }
                    removeNewLineInsideLink(spannableStringBuilder, start, end);
                    addWhiteSpaceIfTextInfoEndWithLink(spannableStringBuilder, end);
                    final String string = spannableStringBuilder.subSequence(start, end).toString();
                    spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.common.SOMRecognizeUtil.1
                        @Override // android.text.style.ClickableSpan
                        public void onClick(@NonNull View view) {
                            MainLogger.m7258i(SOMRecognizeUtil.TAG, "applyLinkToTextData, onClickSpan, linkTextInfo: " + string + SQLKeyword.COMMA + type + ", result: " + new LinkAction().startActivityHyperTextByType(context, string, type, true));
                        }
                    }, start, end, 33);
                    spannableStringBuilder.setSpan(getLinkTypefaceSpan(), start, end, 33);
                }
                end -= iRemoveWhiteSpaceFromEnd;
                removeNewLineInsideLink(spannableStringBuilder, start, end);
                addWhiteSpaceIfTextInfoEndWithLink(spannableStringBuilder, end);
                final String string2 = spannableStringBuilder.subSequence(start, end).toString();
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.common.SOMRecognizeUtil.1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view) {
                        MainLogger.m7258i(SOMRecognizeUtil.TAG, "applyLinkToTextData, onClickSpan, linkTextInfo: " + string2 + SQLKeyword.COMMA + type + ", result: " + new LinkAction().startActivityHyperTextByType(context, string2, type, true));
                    }
                }, start, end, 33);
                spannableStringBuilder.setSpan(getLinkTypefaceSpan(), start, end, 33);
            }
        }
    }

    public static int getConvertedColor(int i) {
        int iIntValue;
        synchronized (mConvertedColorsLock) {
            initConvertedColors();
            Integer num = mConvertedColors.get(Integer.valueOf(i));
            Integer numValueOf = Integer.valueOf(i);
            if (num == null) {
                num = numValueOf;
            }
            iIntValue = num.intValue();
        }
        return iIntValue;
    }

    @Nullable
    public static Drawable getLinkIcon(Context context, int i) {
        if (i == 2) {
            return AppCompatResources.getDrawable(context, C8003R.drawable.ic_som_recognized_line_phone);
        }
        if (i == 3) {
            return AppCompatResources.getDrawable(context, C8003R.drawable.ic_som_recognized_link_web);
        }
        if (i == 1) {
            return AppCompatResources.getDrawable(context, C8003R.drawable.ic_som_recognized_link_email);
        }
        if (i == 7) {
            return AppCompatResources.getDrawable(context, C8003R.drawable.ic_som_recognized_link_formula);
        }
        if (i == 5) {
            return AppCompatResources.getDrawable(context, C8003R.drawable.ic_som_recognized_link_address);
        }
        if (i == 6) {
            return AppCompatResources.getDrawable(context, C8003R.drawable.ic_som_recognized_link_datetime);
        }
        return null;
    }

    private static MetricAffectingSpan getLinkTypefaceSpan() {
        return Build.VERSION.SDK_INT >= 28 ? AbstractC7150s.m5510n(Typeface.create(Typeface.create("sec", 0), 500, false)) : new StyleSpan(1);
    }

    public static List<NotesOrganizedDocumentEntity> getOrganizedDocumentEntities(Collection<String> collection) {
        return DataManager.getInstance().getOrganizedDocumentEntities(collection);
    }

    public static NotesOrganizedDocumentEntity getOrganizedDocumentEntity(String str) {
        return DataManager.getInstance().getOrganizedDocumentEntity(str);
    }

    public static List<NotesOrganizedDocumentEntity> getOrganizedDocuments() {
        return DataManager.getInstance().getOrganizedDocuments();
    }

    public static LiveData<List<NotesOrganizedDocumentEntity>> getOrganizedDocumentsLiveData() {
        return DataManager.getInstance().getOrganizedDocumentsLiveData();
    }

    private static List<String> getPageIds(SpenWNote spenWNote, String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList<SpenWPage> pageList = spenWNote.getPageList();
        int size = 2;
        if (pageList.size() < 2) {
            size = pageList.size();
        } else {
            StringBuilder sbM15l = AbstractC0000a.m15l("getPageIds, uuid: ", str, ", pageSize: ");
            sbM15l.append(pageList.size());
            MainLogger.m7259w(TAG, sbM15l.toString());
        }
        for (int i = 0; i < size; i++) {
            arrayList.add(pageList.get(i).getId());
        }
        return arrayList;
    }

    public static RectF getRecognitionRect(SpenWNote spenWNote) {
        RectF drawnRectOfAllObject = spenWNote.getPage(0).getDrawnRectOfAllObject();
        float f = drawnRectOfAllObject.right;
        float f4 = 2.8285713f * f;
        float f5 = drawnRectOfAllObject.bottom - drawnRectOfAllObject.top;
        if (f4 >= f5) {
            f4 = f5;
        }
        float f6 = drawnRectOfAllObject.top;
        return new RectF(0.0f, f6, f + 1.0f, f4 + f6 + 1.0f);
    }

    public static MainListDocumentData getRecognizeTargetNoteData(String str) {
        for (MainListDocumentData mainListDocumentData : getRecognizeTargetNoteData().values()) {
            if (mainListDocumentData.getUuid().equals(str)) {
                return mainListDocumentData;
            }
        }
        return null;
    }

    public static SOMRecognizedInfo getSOMRecognized(Context context, String str, RecognizeTextInfo recognizeTextInfo, String str2, String str3, long j, String str4) {
        if (recognizeTextInfo.getContentsInfo().length() <= 0) {
            MainLogger.m7255e(TAG, AbstractC0541b.m775q("getSOMRecognized, caller: ", str4, ", uuid: ", str, ", content info is null"));
            return null;
        }
        String string = recognizeTextInfo.getContentStr().toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        applyColorToDecoratedTextInfo(spannableStringBuilder, recognizeTextInfo.getContentsInfo());
        removeMultipleWhiteSpace(spannableStringBuilder);
        applyLinkToTextData(context, spannableStringBuilder);
        MainLogger.m7259w(TAG, "getSOMRecognized, caller: " + str4 + ", lastModifiedTime: " + j);
        return new SOMRecognizedInfo(str, string, spannableStringBuilder, str2, str3, j);
    }

    private static void initConvertedColors() {
        if (mConvertedColors.isEmpty()) {
            TypedArrayCompat.Companion companion = TypedArrayCompat.INSTANCE;
            TypedArray typedArrayObtainTypedArray = companion.getInstance().obtainTypedArray(C8003R.array.screenoff_pen_paired_color_set);
            TypedArray typedArrayObtainTypedArray2 = companion.getInstance().obtainTypedArray(C8003R.array.screenoff_pen_saved_color_set);
            TypedArray typedArrayObtainTypedArray3 = companion.getInstance().obtainTypedArray(C8003R.array.screenoff_pen_color_palette_set);
            TypedArray typedArrayObtainTypedArray4 = companion.getInstance().obtainTypedArray(C8003R.array.screenoff_pen_saved_color_palette_set);
            try {
                try {
                    int length = typedArrayObtainTypedArray.length();
                    for (int i = 0; i < length; i++) {
                        mConvertedColors.put(Integer.valueOf(typedArrayObtainTypedArray2.getColor(i, 0)), Integer.valueOf(typedArrayObtainTypedArray.getColor(i, 0)));
                    }
                    int length2 = typedArrayObtainTypedArray3.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        mConvertedColors.put(Integer.valueOf(typedArrayObtainTypedArray4.getColor(i2, 0)), Integer.valueOf(typedArrayObtainTypedArray3.getColor(i2, 0)));
                    }
                    mConvertedColors.put(-16777216, Integer.valueOf(BaseUtils.getApplicationContext().getColor(C8003R.color.som_recognized_item_info_view_text_color)));
                } catch (Exception e) {
                    MainLogger.m7255e(TAG, "initConvertedColors# exception " + e.getMessage());
                    mConvertedColors.clear();
                }
                typedArrayObtainTypedArray.recycle();
                typedArrayObtainTypedArray2.recycle();
                typedArrayObtainTypedArray3.recycle();
                typedArrayObtainTypedArray4.recycle();
            } catch (Throwable th) {
                typedArrayObtainTypedArray.recycle();
                typedArrayObtainTypedArray2.recycle();
                typedArrayObtainTypedArray3.recycle();
                typedArrayObtainTypedArray4.recycle();
                throw th;
            }
        }
    }

    public static boolean isFormulaActionLinkEnable() {
        return PackageManagerCompat.INSTANCE.getInstance().isPackageInstalled(BaseUtils.getApplicationContext(), Constants.CALCULATOR_PACKAGE_NAME, Constants.CALCULATOR_PACKAGE_MIN_VERSIONCODE);
    }

    public static boolean isTargetNote(MainListDocumentData mainListDocumentData) {
        return mainListDocumentData != null && mainListDocumentData.getCategoryUuid().equals(FolderConstants.ScreenOffMemo.UUID) && mainListDocumentData.getUuid().endsWith("_screenoff") && mainListDocumentData.getIsLock() == 0;
    }

    public static List<TextInfo> recognizeWord(Context context, SpenWNote spenWNote, String str) {
        return spenWNote.getPageMode() == SpenWNote.PageMode.LIST ? new RecognitionFacade().recognizeWord(context, str, spenWNote, getPageIds(spenWNote, str), new CancellationSignal()) : new RecognitionFacade().recognizeWord(context, str, spenWNote, getRecognitionRect(spenWNote), new CancellationSignal());
    }

    private static int removeContinuousWhiteSpaceFromEnd(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        int i4 = 0;
        for (int i5 = i2 - 1; i < i5; i5--) {
            if (spannableStringBuilder.length() <= i5) {
                StringBuilder sbM778t = AbstractC0541b.m778t(i5, "removeContinuousWhiteSpaceFromEnd, ignore, textIdx: ", ", length: ");
                sbM778t.append(spannableStringBuilder.length());
                MainLogger.m7259w(TAG, sbM778t.toString());
            } else if (' ' == spannableStringBuilder.charAt(i5 - 1) && ' ' == spannableStringBuilder.charAt(i5)) {
                spannableStringBuilder.replace(i5, i5 + 1, "");
                i4++;
            }
        }
        return i4;
    }

    private static void removeMultipleWhiteSpace(SpannableStringBuilder spannableStringBuilder) {
        for (int length = spannableStringBuilder.length() - 1; length > 0; length--) {
            if (' ' == spannableStringBuilder.charAt(length - 1) && ' ' == spannableStringBuilder.charAt(length)) {
                spannableStringBuilder.replace(length, length + 1, "");
            }
        }
    }

    private static void removeNewLineInsideLink(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        for (int i4 = i2 - 1; i < i4; i4--) {
            if (i4 > spannableStringBuilder.length() && '\n' == spannableStringBuilder.charAt(i4)) {
                spannableStringBuilder.replace(i4, i4 + 1, (CharSequence) Constant.WHITE_SPACE_STRING);
            }
        }
    }

    private static int removeWhiteSpaceFromEnd(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        int i4 = 0;
        for (int i5 = i2 - 1; i <= i5; i5--) {
            if (spannableStringBuilder.length() <= i5) {
                StringBuilder sbM778t = AbstractC0541b.m778t(i5, "removeWhiteSpaceFromEnd, ignore, textIdx: ", ", length: ");
                sbM778t.append(spannableStringBuilder.length());
                MainLogger.m7259w(TAG, sbM778t.toString());
            } else if (' ' == spannableStringBuilder.charAt(i5)) {
                spannableStringBuilder.replace(i5, i5 + 1, "");
                i4++;
            }
        }
        return i4;
    }

    public static void setOrganizeDocumentEntity(NotesOrganizedDocumentEntity notesOrganizedDocumentEntity) {
        DataManager.getInstance().setOrganizeDocumentEntity(notesOrganizedDocumentEntity);
    }

    public static Map<String, MainListDocumentData> getRecognizeTargetNoteData() {
        List<MainListDocumentData> all;
        HashMap map = new HashMap();
        if (FeatureUtils.isSOMFeatureSupported() && (all = DataManager.getInstance().getAll(NotesUtils.getSOMRecognizedCardSortParam())) != null) {
            for (MainListDocumentData mainListDocumentData : all) {
                if (map.size() > 20) {
                    break;
                }
                if (isTargetNote(mainListDocumentData)) {
                    map.put(mainListDocumentData.getUuid(), mainListDocumentData);
                }
            }
        }
        return map;
    }
}
