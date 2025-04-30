// src/PDFGenerator.java
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.util.Map;

public class PDFGenerator {

    public static void generatePDF(Map<String, String[][]> seatingPlan, String outputFile) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(outputFile));
            document.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Font cellFont = new Font(Font.FontFamily.COURIER, 12);

            for (String room : seatingPlan.keySet()) {
                document.add(new Paragraph("Room: " + room, titleFont));
                document.add(new Paragraph(" "));  // space

                String[][] grid = seatingPlan.get(room);
                PdfPTable table = new PdfPTable(grid[0].length); // columns
                table.setWidthPercentage(100);

                for (String[] row : grid) {
                    for (String cell : row) {
                        PdfPCell pdfCell = new PdfPCell(new Phrase(cell == null ? "--" : cell, cellFont));
                        pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfCell.setFixedHeight(25f);
                        table.addCell(pdfCell);
                    }
                }

                document.add(table);
                document.newPage();
            }

            document.close();
            System.out.println("✅ Seating arrangement PDF generated at: " + outputFile);

        } catch (Exception e) {
            System.out.println("❌ Error generating PDF: " + e.getMessage());
        }
    }
}
