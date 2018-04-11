package sample;

import javafx.collections.ObservableList;
import org.apache.poi.xwpf.usermodel.*;

import java.math.BigInteger;

public class ServicesWriter {
    private ObservableList<Service> serviceList;

    public ServicesWriter(ObservableList<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public void createServicesParagraph(XWPFDocument document) {
        XWPFTable table = document.createTable();
        int index = 1;

        for(Service element : serviceList) {
            XWPFTableRow row = table.createRow();

            createCell(index + ". ", row, 200, ParagraphAlignment.RIGHT);
            createCell(element.getName(), row, 5000, ParagraphAlignment.LEFT);
            createCell("- " + element.getAmount() + element.getUnit(), row, 700, ParagraphAlignment.RIGHT);
            createCell("x", row, 800, ParagraphAlignment.CENTER);
            createCell(element.getPrice() + ",-", row, 700, ParagraphAlignment.RIGHT);
            createCell("- " + element.getSum() + ",-", row, 1500, ParagraphAlignment.RIGHT);

            index++;
        }
        table.getCTTbl().getTblPr().unsetTblBorders();
    }

    private void createCell(String text, XWPFTableRow row, int width, ParagraphAlignment al) {
        XWPFTableCell sumCell = row.createCell();
        sumCell.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(width));
        XWPFParagraph par = sumCell.addParagraph();
        XWPFRun run = par.createRun();
        run.setText(text);
        par.setAlignment(al);
    }
}
