package com.samsung.android.imagetranslation.util;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.util.Pair;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Discriminator {
    private static final String TAG = "Discriminator";

    private static double calculateScore(@NonNull List<LttOcrResult.BlockInfo> list) {
        double dDoubleValue = 0.0d;
        double d = 0.0d;
        for (Pair<Rule, Double> pair : getWeightedRules()) {
            dDoubleValue += pair.second.doubleValue();
            double dDoubleValue2 = pair.second.doubleValue() * pair.first.getScore(list);
            d += dDoubleValue2;
            LTTLogger.m5458d(TAG, pair.first.getClass().getSimpleName() + " weighted score : " + dDoubleValue2);
        }
        double d2 = dDoubleValue > 0.0d ? d / dDoubleValue : 0.0d;
        LTTLogger.m5458d(TAG, "score: " + d2);
        return d2;
    }

    private static List<Pair<Rule, Double>> getWeightedRules() {
        WordCountRule wordCountRule = new WordCountRule();
        Double dValueOf = Double.valueOf(1.0d);
        Object[] objArr = {new Pair(wordCountRule, dValueOf), new Pair(new LineWidthRule(), dValueOf)};
        ArrayList arrayList = new ArrayList(2);
        for (int i = 0; i < 2; i++) {
            Object obj = objArr[i];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static boolean isDocument(@NonNull LttOcrResult lttOcrResult) {
        return calculateScore(lttOcrResult.getBlockInfoList()) > 0.5d;
    }

    public static boolean isParagraph(@NonNull Context context, @NonNull LttOcrResult.BlockInfo blockInfo) {
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{blockInfo}[0];
        return calculateScore(AbstractC2322a.m1630t(obj, arrayList, obj, arrayList)) > 0.5d || isShortSentence(context, blockInfo);
    }

    public static boolean isShortSentence(@NonNull Context context, @NonNull LttOcrResult.BlockInfo blockInfo) {
        if (BlockInfoUtil.getWordCount(blockInfo) >= 24) {
            return false;
        }
        return new NLPAnalyzer(context).isSentenceBlock(blockInfo);
    }

    public static boolean isParagraph(@NonNull LttOcrResult.BlockInfo blockInfo) {
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{blockInfo}[0];
        return calculateScore(AbstractC2322a.m1630t(obj, arrayList, obj, arrayList)) > 0.5d;
    }
}
