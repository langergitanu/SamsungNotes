package org.junit.runner;

import org.junit.runners.Suite;
import org.junit.runners.model.RunnerBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class Computer {
    public static Computer serial() {
        return new Computer();
    }

    public Runner getRunner(RunnerBuilder runnerBuilder, Class<?> cls) {
        return runnerBuilder.runnerForClass(cls);
    }

    public Runner getSuite(final RunnerBuilder runnerBuilder, Class<?>[] clsArr) {
        return new Suite(new RunnerBuilder() { // from class: org.junit.runner.Computer.1
            @Override // org.junit.runners.model.RunnerBuilder
            public Runner runnerForClass(Class<?> cls) {
                return Computer.this.getRunner(runnerBuilder, cls);
            }
        }, clsArr) { // from class: org.junit.runner.Computer.2
            @Override // org.junit.runners.ParentRunner
            public String getName() {
                return "classes";
            }
        };
    }
}
