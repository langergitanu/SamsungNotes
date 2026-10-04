package com.opencsv.validators;

import com.opencsv.exceptions.CsvValidationException;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize.C9478c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class LineValidatorAggregator {
    private static final int CAPACITY = 512;
    private static final int MULTIPLIER = 3;
    private List<LineValidator> validators = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isValid$0(String str, LineValidator lineValidator) {
        return lineValidator.isValid(str);
    }

    public void addValidator(LineValidator lineValidator) {
        if (lineValidator != null) {
            this.validators.add(lineValidator);
        }
    }

    public boolean isValid(String str) {
        return this.validators.stream().allMatch(new C9478c(str, 10));
    }

    public void setValidators(List<LineValidator> list) {
        this.validators = list;
    }

    public void validate(String str) {
        if (this.validators.isEmpty()) {
            return;
        }
        Iterator<LineValidator> it = this.validators.iterator();
        StringBuilder sb = null;
        while (it.hasNext()) {
            try {
                it.next().validate(str);
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
