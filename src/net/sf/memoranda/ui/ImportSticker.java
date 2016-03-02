package net.sf.memoranda.ui;

import java.awt.Dimension;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.memoranda.EventsManager;
import net.sf.memoranda.date.CurrentDate;
import net.sf.memoranda.ui.StickerDialog;
import net.sf.memoranda.ui.AppFrame;
import net.sf.memoranda.util.CurrentStorage;

import net.sf.memoranda.util.Local;
import nu.xom.Element;
/*
author: Micah Mehan
Date merged: 29feb16
group: team Cobol
the purpose of this function is to import
a sticker from a text file, contained inside 
the memoranda folder
*/
public class ImportSticker {
    
    static String name;
    static String fileContents;
    static String line;
    static String dateCreated;
    File f1;
    
    public ImportSticker(String x) {
        name = x;
    }
    
    public boolean import_file() throws IOException{
        //System.out.println("got here.");
        //System.out.println(name);
        
        
        
        /*
         We are working on this =)
         */
        File[] files = File.listRoots();
        for(File f : files){
            f.getPath();
            // System.out.println(f.getAbsolutePath());
            f1 = new File(name);
            //System.out.println(f1.getParent());
            //DEBUG
            if (f1.getName().equalsIgnoreCase(name))
                System.out.println("found it");
            
            
            
        }
        try{
            FileReader fr = new FileReader(name);
            BufferedReader br = new BufferedReader(fr);   
            while ((line = br.readLine()) != null){
                // System.out.println(line);
                if(line != null){
                    if (fileContents == null){
                        fileContents = line;
                    }
                    else{
                        fileContents = fileContents + "\n" + line;
                    }
                }
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            /* debug
             System.out.println("After Format : " + sdf.format(f1.lastModified()));
             */
            dateCreated = sdf.format(f1.lastModified());
            if (fileContents == null){
                System.out.println("didn't find it");
                JOptionPane.showMessageDialog(null,Local.getString("We cannot find your document"));
            }
            br.close();
            
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null,Local.getString("there was a problem finding your file"));
            name = null;
            return false;
        }
        // }
        
        JOptionPane.showMessageDialog(null,Local.getString("We imported your file, just click ok (twice)"));
        return true;
        
    }
    
    
}
