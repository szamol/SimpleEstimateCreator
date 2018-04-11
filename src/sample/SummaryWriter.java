package sample;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

class SummaryWriter {

    private int laborCost, materialCost;
    private boolean isVatAdded;

    SummaryWriter(int laborCost, int materialCost, boolean isVatAdded) {
        this.laborCost = laborCost;
        this.materialCost = materialCost;
        this.isVatAdded = isVatAdded;
    }

    public void createSummaryParagraph(XWPFDocument document) {
        XWPFParagraph summaryParagraph = document.createParagraph();
        XWPFRun summaryRun = summaryParagraph.createRun();
        summaryParagraph.setAlignment(ParagraphAlignment.RIGHT);

        summaryRun.addBreak();
        summaryRun.setText("------------------------");
        summaryRun.addBreak();
        summaryRun.setText("Robocizna - " + laborCost + ",-");
        summaryRun.addBreak();
        summaryRun.setText("Materiały - " + materialCost + ",-");
        summaryRun.addBreak();
        summaryRun.setText("------------------------");
        summaryRun.addBreak();
        if (isVatAdded) summaryRun.setText("- " + (laborCost+materialCost) + ",- +VAT");
        else summaryRun.setText("- " + (laborCost+materialCost) + ",-");
    }
}
