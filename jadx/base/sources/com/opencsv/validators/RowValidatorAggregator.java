package com.opencsv.validators;

import com.opencsv.exceptions.CsvValidationException;
import com.samsung.android.scs.p140ai.sdkcommon.asr.C7233a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RowValidatorAggregator {
    private static final int CAPACITY = 512;
    private static final int MULTIPLIER = 3;
    private List<RowValidator> validators = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isValid$0(String[] strArr, RowValidator rowValidator) {
        return rowValidator.isValid(strArr);
    }

    public void addValidator(RowValidator rowValidator) {
        if (rowValidator != null) {
            this.validators.add(rowValidator);
        }
    }

    public boolean isValid(String[] strArr) {
        return this.validators.stream().allMatch(new C7233a(strArr, 18));
    }

    public void setValidators(List<RowValidator> list) {
        this.validators = list;
    }

    public void validate(String[] strArr) {
        if (this.validators.isEmpty()) {
            return;
        }
        Iterator<RowValidator> it = this.validators.iterator();
        StringBuilder sb = null;
        while (it.hasNext()) {
            try {
                it.next().validate(strArr);
            } catch (CsvValidationException e) {
                if (sb == null) {
                    sb = new StringBuilder(Math.max((e.getMessage().length() + 2) * 3, 512));
                }
                sb.append(e.getMessage());
                sb.append("\n");
            }
        }
        if (sb != null && sb.length() > 0) {
            throw new CsvValidationException(sb.toString());
        }
    }
}
