package org.apache.commons.text.diff;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.exception.C13834b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EditScript<T> {
    private final List<EditCommand<T>> commands = new ArrayList();
    private int lcsLength = 0;
    private int modifications = 0;

    public void append(DeleteCommand<T> deleteCommand) {
        this.commands.add(deleteCommand);
        this.modifications++;
    }

    public int getLCSLength() {
        return this.lcsLength;
    }

    public int getModifications() {
        return this.modifications;
    }

    public void visit(CommandVisitor<T> commandVisitor) {
        this.commands.forEach(new C13834b(commandVisitor, 8));
    }

    public void append(InsertCommand<T> insertCommand) {
        this.commands.add(insertCommand);
        this.modifications++;
    }

    public void append(KeepCommand<T> keepCommand) {
        this.commands.add(keepCommand);
        this.lcsLength++;
    }
}
