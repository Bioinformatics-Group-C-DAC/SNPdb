/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snpdb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author renu
 */
public class SNPDbGenerator {

    private EntityManager em;
    private EntityManagerFactory emf;

    public void initEmfAndEm() {
        
        Map dbDetails=new HashMap();
        dbDetails.put("javax.persistence.jdbc.password",System.getProperty("db_password"));
        dbDetails.put("javax.persistence.jdbc.user",System.getProperty("db_username"));
        dbDetails.put("javax.persistence.jdbc.url",System.getProperty("db_url"));
        emf = Persistence.createEntityManagerFactory("TableGen",dbDetails);
        em = emf.createEntityManager();
    }

    public void cleanup() {
        em.close();
    }

    public void populateBWAData(String args[]) {

        //args[0] -> ChickenLine FileName Information File
        //args[1] -> Chromosome Name Information File
        //args[2] -> Path of Directory Contains all Chicken Files
        
        Query query = em.createNativeQuery("LOAD DATA LOCAL INFILE '" + args[0] + "' INTO TABLE ChickenLine_Info FIELDS TERMINATED BY '\\t' LINES TERMINATED BY '\\n' (@col1) set ChickenLine_Name= @col1");

        em.getTransaction().begin();
        query.executeUpdate();

        query = em.createNativeQuery("LOAD DATA LOCAL INFILE '" + args[1] + "' INTO TABLE ChickenLine_Chromosome_Info FIELDS TERMINATED BY'\\t' LINES TERMINATED BY '\\n' (@col1) set Chromosome= @col1;");
        query.executeUpdate();

        File bwaDirectory = new File(args[2]);
        File[] allChickenFiles = bwaDirectory.listFiles();
        String chickenFileFullName = null;
        String chickenFileName=null;
        int extentionSeperator,headerCount;
        
        for (File chickenFile : allChickenFiles) {
            if (chickenFile.isFile() && chickenFile.getName().endsWith(".vcf")) {

                try {
                    chickenFileFullName = chickenFile.getName();
                    extentionSeperator = chickenFileFullName.indexOf(".");
                    chickenFileName = chickenFileFullName.substring(0, extentionSeperator);
                    headerCount = readChickenFile(chickenFile);
                    query = em.createNativeQuery("LOAD DATA LOCAL INFILE '" + chickenFile.getAbsolutePath() + "' INTO TABLE Common_ChickenLines FIELDS TERMINATED BY'\t' LINES TERMINATED BY '\n' ignore " + headerCount + " lines (@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8) set Chromosome_Position=@col2,Ref=@col4, ALT= @col5, ChickenLine_ID = (select ChickenLine_ID from ChickenLine_Info where ChickenLine_Name='" + chickenFileName + "'),Chromosome_ID=(select Chromosome_ID from ChickenLine_Chromosome_Info where @col1 = Chromosome);");                    
                    query.executeUpdate();
                } catch (IOException ex) {
                    Logger.getLogger(SNPDbGenerator.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        
//       StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("test2");
//        // execute SP
//        storedProcedure.execute();
//        System.out.println("stored procedure called");
    }

    /**
    *Reading header inside BWA Input files
    */
    private static int readChickenFile(File chickenFile) throws IOException {
        int lineCounter = 0;
        FileInputStream fis = new FileInputStream(chickenFile);

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.startsWith("#")) {
                lineCounter++;
            }
        }
        br.close();
        return lineCounter;
    }
    
    public static void main(String args[]) {
        SNPDbGenerator snpDbGenerator = new SNPDbGenerator();
        System.out.println("-------------------Starting the Client---------------------");
        snpDbGenerator.initEmfAndEm();
        snpDbGenerator.populateBWAData(args);
        snpDbGenerator.cleanup();
        System.out.println("---------------Shutting down the Client---------------------");
    }
}
