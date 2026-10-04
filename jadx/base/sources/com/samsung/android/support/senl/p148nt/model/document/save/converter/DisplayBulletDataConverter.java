package com.samsung.android.support.senl.p148nt.model.document.save.converter;

import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.TaskSpan;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/document/save/converter/DisplayBulletDataConverter;", "", "<init>", "()V", "convertBulletTypeBasedOnIndentLevel", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "bodyTextBox", "convertNumberToBulletString", "", "span", "Lcom/samsung/android/support/senl/nt/base/common/displaydata/TaskSpan;", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DisplayBulletDataConverter {

    @NotNull
    public static final DisplayBulletDataConverter INSTANCE = new DisplayBulletDataConverter();

    private DisplayBulletDataConverter() {
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectTextBox convertBulletTypeBasedOnIndentLevel(@NotNull SpenObjectTextBox bodyTextBox) {
        Intrinsics.checkNotNullParameter(bodyTextBox, "bodyTextBox");
        SpenObjectShape spenObjectShapeConvertBulletTypeBasedOnIndentLevel = ContentUtils.convertBulletTypeBasedOnIndentLevel(bodyTextBox);
        Intrinsics.checkNotNull(spenObjectShapeConvertBulletTypeBasedOnIndentLevel, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectTextBox");
        return (SpenObjectTextBox) spenObjectShapeConvertBulletTypeBasedOnIndentLevel;
    }

    @JvmStatic
    @NotNull
    public static final String convertNumberToBulletString(@NotNull TaskSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        int number = span.getNumber();
        int taskStatus = span.getTaskStatus();
        if (number <= 0) {
            return "";
        }
        switch (taskStatus) {
            case 10:
                return ContentUtils.convertToArabicNumber(number);
            case 11:
                return ContentUtils.convertAlphabet(number, true);
            case 12:
                return ContentUtils.convertAlphabet(number, false);
            case 13:
                return ContentUtils.convertRomanNumeral(number);
            default:
                return String.valueOf(number);
        }
    }
}
