package sample;

import javafx.collections.ObservableList;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileOutputStream;

public class DocumentManger {

    private static XWPFDocument document = new XWPFDocument();

    public static void addContractorToDocument(String company ,String name, String city, String adress, String phone) {
        ContractorWriter contractorWriter = new ContractorWriter(company, name, city, adress, phone);
        contractorWriter.createContractorParagraph(document);
    }

    public static void addClientToDocument(String name) {
        ClientWriter clientWriter = new ClientWriter(name);
        clientWriter.createClientParagraph(document);
    }

    public static void addServicesToDocument(ObservableList<Service> serviceList) {
        ServicesWriter servicesWriter = new ServicesWriter(serviceList);
        servicesWriter.createServicesParagraph(document);
    }

    public static void addSummaryToDocument(int laborCost, int materialsCost, boolean isVatAdded) {
        SummaryWriter summaryWriter = new SummaryWriter(laborCost, materialsCost, isVatAdded);
        summaryWriter.createSummaryParagraph(document);
    }

    public static void saveDocument(String fileName) {
        try {
            FileOutputStream output = new FileOutputStream(fileName + ".docx");
            document.write(output);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
