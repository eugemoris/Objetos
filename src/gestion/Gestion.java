/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;



/**
 *
 * @author eugem
 */
public class Gestion {

    public void lectura() throws FileNotFoundException, IOException
            
    {
        try{
           
            String rutaArch = System.getProperty("user.home")+"/Libro1.xls";//despues mandar por parametro
            File archivo= new File (rutaArch);
            InputStream excel = new FileInputStream(archivo);
            HSSFWorkbook libro = new HSSFWorkbook(excel);  //representacion de la hoja de excel
            HSSFSheet hoja = libro.getSheetAt(0);//elegimos la hoja que se pasa por parametro
            HSSFRow fila; // nos permite leer una fila de la hoja excel, y de ahi el contenido de las celdas
            HSSFCell celda;  //inicializo el objeto que leerá el valor de la celda
            int cantFilas = hoja.getLastRowNum(); //obtengo el numero de filas ocupadas en la hoja
            int cantCol=0; //mas adelante obtengo el numero de columnas ocupadas
            String valorCelda; //cadena para almacenar los valores de las celdas
            for (int i = 0; i < cantFilas; i++)
            {
                fila= hoja.getRow(i);
                if (fila == null)
                {
                    break;
                }
                else
                {
                   cantCol=fila.getLastCellNum();
                    for (int c=0; c< cantCol;c++)
                    {
                        valorCelda= fila.getCell(c).getStringCellValue();
                        System.out.println(valorCelda);
                    }
                }
            }
            excel.close();
        }
        
       catch (FileNotFoundException fileNotFoundException)
       {
           System.out.println("el archivo no existe");
       }
        
        
        
        
        //Workbook libro = new HSSFWorkbook();
        //FileOutputStream arch = new FileOutputStream(archivo);
        //Sheet hoja= libro.createSheet("Encuesta");
        
    }

    /**
     *
     */

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            lectura();
        } catch (IOException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
