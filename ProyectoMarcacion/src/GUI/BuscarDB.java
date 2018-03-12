/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author ivana
 */
public class BuscarDB {
    
    String tRut = " " ;
    String tApellido = " ";
    String tNombre = " ";
    String tEmpresa = " ";
    String tCargo = " ";
        
    
    public BuscarDB(File fileName,String Rut){
        
        List cellData = new ArrayList();
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
            
            
            XSSFSheet hssfSheet = workBook.getSheetAt(0);
            Iterator rowIterator = hssfSheet.rowIterator();
            
            while(rowIterator.hasNext()){
                XSSFRow hssfRow = (XSSFRow) rowIterator.next();
                
                Iterator iterator = hssfRow.cellIterator();
               List cellTemp = new ArrayList();
               
               while(iterator.hasNext()){
                   XSSFCell hssfCell = (XSSFCell) iterator.next();
                   
                   cellTemp.add(hssfCell);
                   
               }
               
               cellData.add(cellTemp);
                
            }
            
        }catch(Exception e){
            
        }
        if(verificar(cellData,Rut)>=0){
            obtener(cellData,verificar(cellData,Rut));
        }
    }
    
    
    private void obtener(List cellDataList,int a){
        
        
        
        for(int i = a; i <= a; i++){
         
            List cellTempList = (List) cellDataList.get(i);
            for (int j = 0; j < cellTempList.size(); j++) {
                XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
                
                String stringCellValue = hssfCell.toString();
                switch (j) {
                    case 0:
                        tRut = stringCellValue;
                        break;
                    case 1:
                        tApellido = stringCellValue;
                        break;
                    case 2:
                        tNombre = stringCellValue;
                        break;
                    case 3:
                        tEmpresa = stringCellValue;
                        break;
                    case 4:
                        tCargo = stringCellValue;
                        break;
                    default:
                        break;
                }
            }
            System.out.println();
        }

    }
    
    private int verificar(List cellDataList, String rut){
        
        boolean founded = false;
        boolean end = false;
        int count = 0;
        int save_i = -1;
        while(end == false && founded == false ){
        
            for(int i = 0; i < cellDataList.size();i++){
                List cellTempList = (List) cellDataList.get(i);
                XSSFCell hssfCell = (XSSFCell) cellTempList.get(0);
                String stringCellValue = hssfCell.toString();
                if(stringCellValue.equals(rut)){
                    founded = true;
                    save_i = i;
                }else{
                    count++;
                }
                
            }
            end = true;
        }
        if(founded == true){
            return save_i;
        }else{
            return -1;
        }
        
    }

    public String gettRut() {
        return tRut;
    }

    public String gettApellido() {
        return tApellido;
    }

    public String gettNombre() {
        return tNombre;
    }

    public String gettEmpresa() {
        return tEmpresa;
    }

    public String gettCargo() {
        return tCargo;
    }
    
    public void resetName(){
       tRut = " " ;
       tApellido = " ";
       tNombre = " ";
       tEmpresa = " ";
       tCargo = " ";
    }

}