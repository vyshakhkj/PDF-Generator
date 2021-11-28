import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.text.DocumentException;

public class PdfGenerator {

    public static void main(String[] args) throws DocumentException, IOException {
        documentRender();
    }

    public static void documentRender() throws DocumentException, IOException {
        TDocument ds = new TDocument(3);
        ds.setTitle("Multiplication Table");
        TDocumentTable table = new TDocumentTable();
        table.setBorder(1);
        table.setWidth(100);
        table.setBgColor("#EFEEEC");
        TDocumentTableRow row = new TDocumentTableRow();

        TDocumentText headtxt = new TDocumentText("Multiplicand");
        headtxt.font = true;
        headtxt.color = "#800000";
        TDocumentTableCell cell = new TDocumentTableCell(TDocumentElement.ALIGNMENT.HEADING);
        cell.addObject(headtxt);
        row.addObject(cell);

        headtxt = new TDocumentText("Multiplier");
        headtxt.color = "#800000";
        cell = new TDocumentTableCell(TDocumentElement.ALIGNMENT.HEADING);
        cell.addObject(headtxt);
        row.addObject(cell);
        headtxt = new TDocumentText("Result");
        headtxt.color = "#800000";
        cell = new TDocumentTableCell(TDocumentElement.ALIGNMENT.HEADING);
        cell.addObject(headtxt);
        row.addObject(cell);
        table.addObject(row);

        Integer a = 16;
        Integer j = 1;

        while (j < 12)
        {
            row = new TDocumentTableRow();
            cell = new TDocumentTableCell(TDocumentElement.ALIGNMENT.DATA);
            cell.addObject(new TDocumentText(a.toString()));
            row.addObject(cell);
            cell = new TDocumentTableCell(TDocumentElement.ALIGNMENT.DATA);

            cell.addObject(new TDocumentText(j.toString()));
            row.addObject(cell);
            cell = new TDocumentTableCell(TDocumentElement.ALIGNMENT.DATA);
            Integer result = a * j;
            cell.addObject(new TDocumentText(result.toString()));

            row.addObject(cell);
            table.addObject(row);
            j++;
        }

        ds.addObject(table);

        String filename = "C:\\Personal\\pdftest.pdf";
        ds.accept(new PDFVisitor(filename));
    }
}
