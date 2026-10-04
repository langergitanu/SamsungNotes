package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter;

import android.content.res.TypedArray;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.TypedArrayCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.TemplateIndexConverter;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ImageTemplatePresenterUtil {
    private static final String TAG = "ImageTemplatePresenterUtil";

    public static TypedArray getItemIndexArray(int i) {
        return i != 10 ? i != 13 ? i != 16 ? i != 19 ? TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_creative_template_item_index) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_journals_template_item_index) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_planners_template_item_index) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_academic_template_item_index) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_basic_template_item_index);
    }

    public static TypedArray getItemNameArray() {
        return TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_essential_template_name);
    }

    public static TypedArray getItemResourceArray(float f) {
        return DocumentPageRatio.PageRatioType.LONG.equal(f) ? TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_essential_template_long_drawable_res) : DocumentPageRatio.PageRatioType.A4_LANDSCAPE.equal(f) ? TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_essential_template_land_drawable_res) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_essential_template_drawable_res);
    }

    public static TypedArray getItemTypeArray(int i) {
        return i != 10 ? i != 13 ? i != 16 ? i != 19 ? TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_creative_template_item_type) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_journals_template_item_type) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_planners_template_item_type) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_academic_template_item_type) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_basic_template_item_type);
    }

    public static int getTemplateTypeFromTemplateName(String str) {
        int i;
        int i2;
        TypedArray wPageIndexArray = getWPageIndexArray();
        Integer numValueOf = null;
        for (int i4 : TemplateViewType.TYPE_IMAGE_TEMPLATES) {
            if (numValueOf != null) {
                break;
            }
            TypedArray itemIndexArray = getItemIndexArray(i4);
            TypedArray itemTypeArray = getItemTypeArray(i4);
            int length = itemIndexArray.length();
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                if (itemTypeArray.getInt(i5, -1) == 0 && (i = itemIndexArray.getInt(i5, -1)) >= 0 && (i2 = wPageIndexArray.getInt(i, -1)) >= 0 && str.equals(String.valueOf(i2))) {
                    numValueOf = Integer.valueOf(i4);
                    break;
                }
                i5++;
            }
            itemIndexArray.recycle();
        }
        wPageIndexArray.recycle();
        if (numValueOf == null) {
            numValueOf = 10;
        }
        return numValueOf.intValue();
    }

    public static TypedArray getWPageIndexArray() {
        return TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.comp_change_template_essential_template_wpage_index);
    }

    public static boolean isSelectedTemplateItem(String str, TemplateItem templateItem) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TemplateIndexConverter.convertTemplateNameToWPageIndex(templateItem.getName()) == Integer.parseInt(str);
    }
}
