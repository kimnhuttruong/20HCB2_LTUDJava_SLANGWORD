import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.io.Serializable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.*;

class SlangWord implements Serializable {
    String id;
    String des;
    static List<SlangWord> importCSV(String filename) throws IOException {
        List<SlangWord> dsSlangWord = new ArrayList<>();
        String path = filename;

        try (BufferedReader bir = new BufferedReader(new FileReader(path))) {
            String line = bir.readLine();
            while (line != null) {
                try{
                    String[] result = line.split("`");
                    SlangWord sl = new SlangWord();
                    sl.id = result[0];
                    sl.des = result[1];
                    dsSlangWord.add(sl);
                    line = bir.readLine();
                }
                catch(Exception e){
                    SlangWord sl = new SlangWord();
                    sl.id = line;
                    sl.des = line;
                    dsSlangWord.add(sl);
                    line = bir.readLine();
                }
               
        }
        return dsSlangWord;
        }
    }
    static String timKiemTheoSlangWord(List<SlangWord> dsSlangWord)throws IOException  {
        SlangWord sw = new SlangWord();
        try {
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap slang word: ");
            sw.id = dataIn.readLine();
            for(int i=0;i<dsSlangWord.size();i++){
                if(dsSlangWord.get(i).id == null ? sw.id == null : dsSlangWord.get(i).id.equals(sw.id))
                {
                    System.out.println("Result: "+dsSlangWord.get(i).des);
                    return sw.id;
                }
            }
            System.out.println("Not found");
            return sw.id;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }
    static SlangWord randomSlangWord(List<SlangWord> dsSlangWord)throws IOException  {
        SlangWord sw = new SlangWord();
        try {
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
            Random generator = new Random();
            int value = generator.nextInt(dsSlangWord.size()) ;
            
            return dsSlangWord.get(value);
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
     static boolean  randomGameSlangWord(List<SlangWord> dsSlangWord)throws IOException  {
        SlangWord cauhoi = new SlangWord();
        int traloi=4;
        try {
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
            cauhoi=randomSlangWord(dsSlangWord);
            List<SlangWord> dsDapAn = new ArrayList<>();
            dsDapAn.add(cauhoi);
            System.out.print("Cau hoi: "+ cauhoi.id);
            for(int i=0;i<3;i++)
            {
                SlangWord dapan = new SlangWord();
                dapan=randomSlangWord(dsSlangWord);
                dsDapAn.add(dapan);
            }
            Collections.sort(dsDapAn, new Comparator<>(){

                public int compare(SlangWord o1, SlangWord o2)
                {
                   return o1.id.compareTo(o2.id);
                }
              });
            System.out.println("");
            for(int i=0;i<4;i++)
            {
               System.out.println("Lua chon"+ (i+1)+": "+dsDapAn.get(i).des);
            }
            System.out.print("tra loi: ");
            String nhap=dataIn.readLine();
            switch (nhap) {    
                        case "1":
                            traloi= Integer.parseInt(nhap);
                            break;
                       case "2":
                            traloi= Integer.parseInt(nhap);
                           break;
                        case "3":
                            traloi= Integer.parseInt(nhap);
                            break;
                         case "4":
                            traloi= Integer.parseInt(nhap);
                            break;
                        default:
                            System.out.print("tra loi sai");
                            return false;
                        } 
            if(dsDapAn.get(traloi-1).des == cauhoi.des)
            {
                System.out.print("tra loi dung");
                return true;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            return false;
        } System.out.print("tra loi sai");
        return false;
    }
     static boolean  randomGameDefintion(List<SlangWord> dsSlangWord)throws IOException  {
        SlangWord cauhoi = new SlangWord();
        int traloi=4;
        try {
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
            cauhoi=randomSlangWord(dsSlangWord);
            List<SlangWord> dsDapAn = new ArrayList<>();
            dsDapAn.add(cauhoi);
            System.out.print("Cau hoi: "+ cauhoi.des);
            for(int i=0;i<3;i++)
            {
                SlangWord dapan = new SlangWord();
                dapan=randomSlangWord(dsSlangWord);
                dsDapAn.add(dapan);
            }
            Collections.sort(dsDapAn, new Comparator<>(){

                public int compare(SlangWord o1, SlangWord o2)
                {
                   return o1.id.compareTo(o2.id);
                }
              });
            System.out.println("");
            for(int i=0;i<4;i++)
            {
               System.out.println("Lua chon"+ (i+1)+": "+dsDapAn.get(i).id);
            }
            System.out.print("tra loi: ");
            String nhap=dataIn.readLine();
            switch (nhap) {    
                        case "1":
                            traloi= Integer.parseInt(nhap);
                            break;
                       case "2":
                            traloi= Integer.parseInt(nhap);
                           break;
                        case "3":
                            traloi= Integer.parseInt(nhap);
                            break;
                         case "4":
                            traloi= Integer.parseInt(nhap);
                            break;
                        default:
                            System.out.print("tra loi sai");
                            return false;
                        } 
            if(dsDapAn.get(traloi-1).id == cauhoi.id)
            {
                System.out.print("tra loi dung");
                return true;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            return false;
        } System.out.print("tra loi sai");
        return false;
    }
    static String timKiemTheoDefintion(List<SlangWord> dsSlangWord)throws IOException  {
        SlangWord sw = new SlangWord();
        List<String> dsSlangWordResult = new ArrayList<>();
        try {
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap defintion: ");
            sw.des = dataIn.readLine();
            System.out.println("Result:");
            for(int i=0;i<dsSlangWord.size();i++){
                if(dsSlangWord.get(i).des.contains(sw.des))
                {
                    System.out.println(dsSlangWord.get(i).id+" - "+dsSlangWord.get(i).des);
                    dsSlangWordResult.add(dsSlangWord.get(i).id);
                }
            }
            if(dsSlangWordResult.size()==0)
                System.out.print("Not found");
            System.out.println(" ");
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    static List<SlangWord>  themSlangWord(List<SlangWord> dsSlangWord)throws IOException  {
        SlangWord sw = new SlangWord();
        try {
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nhap thong tin Slang word");
            System.out.print("Nhap slang word: ");
            sw.id = dataIn.readLine();
            System.out.print("Nhap defintion: ");
            sw.des = dataIn.readLine();
            for(int i=0;i<dsSlangWord.size();i++){
                if(dsSlangWord.get(i).id == null ? sw.id == null : dsSlangWord.get(i).id.equals(sw.id))
                {
                    System.out.println("Slang word da ton tai ");
                    String loaiGhiDe="n";
                    System.out.print("vui long chon loai ghi de:  'o'-overwrite , 'd'-duplicate, 'n'-cancel ");
                    System.out.println("Loai: ");
                    loaiGhiDe = dataIn.readLine();
                    switch (loaiGhiDe) {    
                        case "o":
                            dsSlangWord.get(i).des=sw.des;
                            System.out.println("Da overwrite");
                            return dsSlangWord;
                        case "d":  
                            dsSlangWord.add(sw);
                            System.out.println("Da duplicate");
                            return dsSlangWord;
                        case "n":   
                            System.out.println("Da cancel");
                            return dsSlangWord;
                        default:
                            System.out.println("Da cancel");
                            return dsSlangWord;
                        }   
                }
            }
            dsSlangWord.add(sw);
            System.out.println("Da them slang word thanh cong");
        } catch (IOException e) {
            e.printStackTrace();
            return dsSlangWord;
        }
        return dsSlangWord;
    }
    static List<SlangWord>  xoaSlangWord(List<SlangWord> dsSlangWord)throws IOException  {
        SlangWord sw = new SlangWord();
        try {
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
          
            System.out.print("Nhap slang word: ");
            sw.id = dataIn.readLine();
            for(int i=0;i<dsSlangWord.size();i++){
                if(dsSlangWord.get(i).id == null ? sw.id == null : dsSlangWord.get(i).id.equals(sw.id))
                {
                    System.out.println("Confirm Delete "+ dsSlangWord.get(i).id+" - "+ dsSlangWord.get(i).des);
                    String loaiGhiDe="n";
                    System.out.print("vui long confirm:  'y'-yes , 'n'-no");
                    System.out.println("Loai: ");
                    loaiGhiDe = dataIn.readLine();
                    switch (loaiGhiDe) {    
                        case "y":
                            dsSlangWord.remove(i);
                            System.out.println("Da xoa");
                            return dsSlangWord;
                        case "n":   
                            System.out.println("Da cancel");
                            return dsSlangWord;
                        default:
                            System.out.println("Da cancel");
                            return dsSlangWord;
                        }   
                }
            }
            
            System.out.println("Slang word khong ton tai");
            
        } catch (IOException e) {
            e.printStackTrace();
            return dsSlangWord;
        }
        return dsSlangWord;
    }
    static List<SlangWord>  chinhsuaSlangWord(List<SlangWord> dsSlangWord)throws IOException  {
        SlangWord sw = new SlangWord();
        try {
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nhap thong tin Slang word");
            System.out.print("Nhap slang word: ");
            sw.id = dataIn.readLine();
            for(int i=0;i<dsSlangWord.size();i++){
                if(dsSlangWord.get(i).id == null ? sw.id == null : dsSlangWord.get(i).id.equals(sw.id))
                {
                    System.out.println("Nhap thong tin Slang word chinh sua");
                    System.out.print("Nhap slang word: ");
                    sw.id = dataIn.readLine();
                    System.out.print("Nhap defintion: ");
                    sw.des = dataIn.readLine();
                    String loaiGhiDe="n";
                    System.out.println("confirm:  'y'-yes , 'n'-no ");
                    System.out.print("Loai: ");
                    loaiGhiDe = dataIn.readLine();
                    switch (loaiGhiDe) {    
                        case "y":
                            dsSlangWord.get(i).des=sw.des;
                            dsSlangWord.get(i).id=sw.id;
                            System.out.println("Da chinh sua thanh cong");
                            return dsSlangWord;
                        case "n":   
                            System.out.println("Da cancel");
                            return dsSlangWord;
                        default:
                            System.out.println("Da cancel");
                            return dsSlangWord;
                        }   
                }
            }
           
            System.out.println("Slang word khong ton tai");
        } catch (IOException e) {
            e.printStackTrace();
            return dsSlangWord;
        }
        return dsSlangWord;
    }


    public static void main(String args[]) throws Exception {
        // CopyRight @ Kim Nhut Truong - 20424083 - 20HCB2

        String inputFile = "slang.txt";
//        writeListSlangWordBinary();
        List<String> history=new ArrayList<>();
        List<SlangWord> dsSlangWord = new ArrayList<>();
        dsSlangWord= importCSV(inputFile);
        
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        String chucNang="";
        while(true){
            System.out.print("Chon chuc nang: ");
            chucNang = dataIn.readLine();
            switch (chucNang) {    
                case "1":
                    String result=timKiemTheoSlangWord(dsSlangWord);
                    if(result!="")
                        history.add(result);
                    break;  
                case "2":    
                    timKiemTheoDefintion(dsSlangWord);
                    break; 
                case "3":   
                    System.out.println("History:");
                    System.out.println(history.toString().replaceAll("]", "").substring(1));
                    break;   
                case "4":   
                    System.out.println("Them slang word:");
                    dsSlangWord=themSlangWord(dsSlangWord);
                    break;  
                case "5":   
                    System.out.println("Chinh sua slang word:");
                    dsSlangWord=chinhsuaSlangWord(dsSlangWord);
                    break;  
                case "6":   
                    System.out.println("Xoa slang word:");
                    dsSlangWord=xoaSlangWord(dsSlangWord);
                    break; 
                case "8":   
                    System.out.println("random slang word:");
                     SlangWord sw = new SlangWord();
                    sw=randomSlangWord(dsSlangWord);
                     System.out.println(sw.id+" - "+sw.des);
                    break; 
                 case "9":   
                    randomGameSlangWord(dsSlangWord);
                    break; 
                case "10":   
                    randomGameDefintion(dsSlangWord);
                    break; 
                default:
                    System.out.println("Exit");
                    return;
            }   
        }
       
//        dsSlangWord = readListSlangWordBinary();
//        dsSlangWord = deleteSlangWord(dsSlangWord);
//        dsSlangWord = addSlangWord(dsSlangWord);
//        dsSlangWord = capNhatHS(dsSlangWord);
//        dsSlangWord = sortByDiem(dsSlangWord, true);
//        dsSlangWord = sortByDiem(dsSlangWord, false);
//        dsSlangWord = sortByMHS(dsSlangWord, true);
//        dsSlangWord = sortByMHS(dsSlangWord, false);
//        exportCSV(dsSlangWord);
//        dsSlangWord = importCSV();

//        System.out.println(dsSlangWord.get(7).TenHS);
//        System.out.println(dsSlangWord.size());
//        SlangWord hs = new SlangWord();
//        hs.MHS = "MHS";
//        hs.TenHS = "TenHS";
//        hs.Diem = "1";
//        hs.HinhAnh = "HinhAnh";
//        hs.DiaChi = "DiaChi";
//        hs.GhiChu = "GhiChu";
        // hs = capNhatHS(hs);

    }
}