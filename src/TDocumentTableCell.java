import java.io.IOException;

import com.itextpdf.text.DocumentException;

public class TDocumentTableCell extends TDocumentElement {

    public int columnSpan;
    public ALIGNMENT horizontal;
    public ALIGNMENT vertical;
    public ALIGNMENT type;

    public TDocumentTableCell() {
        this.columnSpan = 1;
        this.horizontal = ALIGNMENT.LEFT;
        this.vertical = ALIGNMENT.MIDDLE;
        this.type = ALIGNMENT.DATA;
    }

    @Override
    public void accept(IDocumentVisitor documentVisitor) throws DocumentException, IOException {
        documentVisitor.visit(this);
    }

    public TDocumentTableCell(ALIGNMENT type) {
        this.type = type;
    }
}
