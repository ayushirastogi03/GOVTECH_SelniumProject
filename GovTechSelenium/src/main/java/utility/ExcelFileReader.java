package utility;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelFileReader {

    private String file;
    private POIFSFileSystem fs;
    private HSSFWorkbook wb;
    private HSSFSheet sheet;
    private HSSFRow row;
    private HSSFCell cell;

    public ExcelFileReader(String fileName)throws IOException{
        this.file=fileName;
        init();
    }

    private void init()throws IOException {
        fs = new POIFSFileSystem(new FileInputStream(new File(file).getCanonicalPath()));
        wb = new HSSFWorkbook(fs);
        sheet = wb.getSheetAt(0);
    }

    public List<String> getTestCaseDataAsList(String testcaseID){
        List<String> testData=new ArrayList();
        DataFormatter dataFormatter= new DataFormatter();

        Iterator<Row> iterator = sheet.rowIterator();
        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            if (currentRow.getCell(0).getStringCellValue().equalsIgnoreCase(testcaseID)) {
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    testData.add(dataFormatter.formatCellValue(currentCell));
                }
            }
        }
        return testData;
    }

    public static void main(String arg[]){
        try{
            ExcelFileReader ex=new ExcelFileReader("GovTechSelenium/src/test/resources/testData/TestData.xls");
            List<String> testDataList=ex.getTestCaseDataAsList("data1");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
