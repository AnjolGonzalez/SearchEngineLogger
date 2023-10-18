package com.pluralsight;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SearchEngineLogger {
    public static void main(String[] args) {
        logAction("Launch");
        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.print("Enter a search term (X to exit): ");
            String input = scan.nextLine().trim();

            if("X".equalsIgnoreCase(input)){
                logAction("Exit");
                break;
            }else {
                logAction("Search: " + input);
            }
        }
        scan.close();
        System.exit(0);
    }
        public static void logAction(String action){
            try {
                BufferedWriter logger = new BufferedWriter(new FileWriter("log.txt", true));
                LocalDateTime.now();
                DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String timeStamp = LocalDateTime.now().format(formatDate);

                logger.write(timeStamp + " " + action);
                logger.newLine();
                logger.close();

            } catch (IOException error) {
                error.printStackTrace();
                //Trace is a list of errors
            }
        }
    }
