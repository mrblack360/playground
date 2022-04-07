// Written by Maswi<rmaswi360@outlook.com> on April 7, 2022 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileProcessor{
    LocalDateTime time = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMDDHHMMSS");
    String dateTime=formatter.format(time);
    URL filesUrl = getClass().getResource("files/");
    URL exportsUrl = getClass().getResource("exports");
    File folder = new File(filesUrl.getPath());
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        Date sasa = new Date();
        File fileContents;
        FileWriter export;
        Scanner contentReader;
        PrintWriter mwandishi=null;
        Pattern IPPattern=Pattern.compile("172\\.27\\.[0-9]+\\.[0-9]+");
        Pattern MSISDNPattern = Pattern.compile("255\\d{9,12}");
        String MSISDN="";
        String IP="";

        System.out.println(sasa.toString()+": Starting Script...");
        try{
            File exportFile=new File(fileProcessor.exportsUrl.getPath()+"/exports"+fileProcessor.dateTime+".csv");
            if(exportFile.createNewFile()){
                System.out.println(sasa.toString()+": Creating export file...");
            }else{
                System.out.println(sasa.toString()+": Export file is available...");
            }
            export = new FileWriter(fileProcessor.exportsUrl.getPath()+"/exports"+fileProcessor.dateTime+".csv");
            mwandishi = new PrintWriter(export);
            mwandishi.println("MSISDN,IP_ADDRESS");
            System.out.println(sasa.toString()+": Appending Headings...");
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(sasa.toString()+": Reading available files...");
        for (final File file: fileProcessor.folder.listFiles()){
            if(file.isFile()){
            System.out.println(sasa.toString()+": Processing file "+file.getName());
                try{fileContents = new File(fileProcessor.filesUrl.getPath()+file.getName());
                contentReader = new Scanner(fileContents);
                while(contentReader.hasNextLine()){
                    String line = contentReader.nextLine();
                    if (line.contains("<HGSDP")) {
                        IP="";
                        Matcher MSISDNMatcher=MSISDNPattern.matcher(line);
                        if(MSISDNMatcher.find()) {
                            MSISDN=MSISDNMatcher.group();
                        }
                    }else{
                        Matcher IPMatcher=IPPattern.matcher(line);
                        if(IPMatcher.find()){
                            IP=IPMatcher.group();
                        }
                    }
                    if(MSISDN.length()>3 && IP.length()>3){
                        mwandishi.println(MSISDN+","+IP);
                        MSISDN=IP="";
                    }
                }
                contentReader.close();
                }
                catch(FileNotFoundException e){
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
        }
        System.out.println(sasa.toString()+": Exiting script...");
        mwandishi.close();
    }
   
}