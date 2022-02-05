package RedboxInventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * ScannerFactory
 */
//Iman Tanzeem IXT190001
public abstract class ScannerFactory {
    //Iman Tanzeem IXT190001
    private static Scanner _scannerObject;

    public static Scanner GetScannerInstance() {
        if (_scannerObject == null) {
            _scannerObject = new Scanner(System.in);
        }

        return _scannerObject;
    }

    public static void CloseScannerInstance() {
        _scannerObject.close();
        _scannerObject = null;
    }

    public static Scanner GetScannerInstance(String filename) throws FileNotFoundException
    {   
        _scannerObject = new Scanner(new File(filename)); 
        return _scannerObject;
    } 

    public static Scanner GetScannerLine(String line) {
        if (_scannerObject == null) {
            _scannerObject = new Scanner(System.in);
        }

        return _scannerObject;
    }
}