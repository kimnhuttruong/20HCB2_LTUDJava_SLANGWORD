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

class HocSinh implements Serializable {
    String MHS;
    String TenHS;
    String Diem;
    String HinhAnh;
    String DiaChi;
    String GhiChu;

    static List<HocSinh> capNhatHS(List<HocSinh> dsHocSinh) {
        HocSinh hs = new HocSinh();
        int index = 0;
        try {
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap So thu tu SV can Update: ");
            index = Integer.parseInt(dataIn.readLine()) - 1;

            hs = dsHocSinh.get(index);

            System.out.println("cap nhat thong tin SV : " + hs.TenHS);

            System.out.print("Nhap ten SV : ");
            hs.TenHS = dataIn.readLine();

            System.out.print("Nhap diem SV : ");
            hs.Diem = dataIn.readLine();

            System.out.print("Nhap hinh anh SV : ");
            hs.HinhAnh = dataIn.readLine();

            System.out.print("Nhap dia chi SV : ");
            hs.DiaChi = dataIn.readLine();

            System.out.print("Nhap ghi chu SV : ");
            hs.GhiChu = dataIn.readLine();
            return dsHocSinh;
        } catch (IOException e) {
            e.printStackTrace();
            return dsHocSinh;
        }

    }

    static void writeListHocSinhBinary() {
        File file = new File("dsHocSinh.txt");

        try (FileOutputStream fos = new FileOutputStream(file);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(bos);) {

            List<HocSinh> dsHocSinh = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                HocSinh hs = new HocSinh();
                hs.MHS = "MHS " + i;
                hs.TenHS = "TenHS " + i;
                hs.Diem = " " + i % 10;
                hs.HinhAnh = "HinhAnh " + i;
                hs.DiaChi = "DiaChi " + i;
                hs.GhiChu = "GhiChu " + i;
                dsHocSinh.add(hs);
            }
            out.writeObject(dsHocSinh);
            out.flush();
            byte[] data = bos.toByteArray();
            fos.write(data);

            System.out.println("Successfully written data to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static List<HocSinh> readListHocSinhBinary() throws Exception {
        String inputFile = "dsHocSinh.txt";
        List<HocSinh> dsHocSinh = new ArrayList<>();

        try {
            FileInputStream fstream = new FileInputStream(inputFile);
            ObjectInputStream ostream = new ObjectInputStream(fstream);
            while (true) {
                List<HocSinh> obj;
                try {
                    obj = (List<HocSinh>) ostream.readObject();

                } catch (EOFException e) {
                    break;
                }
                dsHocSinh = obj;
                // do something with obj
            }
            fstream.close();
        } catch (IOException e) {

        }
        System.out.println("Successfully written data to the file");
        return dsHocSinh;

    }

    static List<HocSinh> addHocSinh(List<HocSinh> dsHocSinh) throws Exception {
        HocSinh hs = new HocSinh();
        try {
            Integer stt = dsHocSinh.size() + 1;
            hs.MHS = stt.toString();
            System.out.print("Them SV thu " + hs.MHS);

            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Nhap ten SV : ");
            hs.TenHS = dataIn.readLine();

            System.out.print("Nhap diem SV : ");
            hs.Diem = (dataIn.readLine());

            System.out.print("Nhap hinh anh SV : ");
            hs.HinhAnh = dataIn.readLine();

            System.out.print("Nhap dia chi SV : ");
            hs.DiaChi = dataIn.readLine();

            System.out.print("Nhap ghi chu SV : ");
            hs.GhiChu = dataIn.readLine();

        } catch (IOException e) {
            e.printStackTrace();

        }
        dsHocSinh.add(hs);
        System.out.println("Them Thanh Cong");
        return dsHocSinh;

    }

    static List<HocSinh> deleteHocSinh(List<HocSinh> dsHocSinh) throws Exception {
        int index = 0;
        try {
            System.out.print("Xoa thong tin SV : ");
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Nhap So thu tu SV (bat dau tu 1): ");
            index = Integer.parseInt(dataIn.readLine()) - 1;

        } catch (IOException e) {
            e.printStackTrace();

        }
        dsHocSinh.remove(index);
        System.out.println("Xoa Thanh Cong");
        return dsHocSinh;

    }

    static void exportCSV(List<HocSinh> dsHocSinh) throws IOException {
        List<List<String>> dataLines = new ArrayList<>();
        for (int i = 0; i < dsHocSinh.size(); i++) {
            HocSinh hs = dsHocSinh.get(i);
            List<String> list = Arrays.asList(hs.MHS, hs.TenHS, hs.Diem, hs.HinhAnh, hs.DiaChi, hs.GhiChu);
            dataLines.add(list);
        }

        String csvFile = "export.csv";
        Writer out;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {

            for (List<String> rowData : dataLines) {
                bw.write(String.join(",", rowData));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static List<HocSinh> importCSV() throws IOException {
        List<HocSinh> dsHocSinh = new ArrayList<>();
        String path = "export.csv";

        try (BufferedReader bir = new BufferedReader(new FileReader(path))) {
            String line = bir.readLine();

            while (line != null) {

                String[] result = line.split(",");
                System.out.println(result);
                HocSinh hs = new HocSinh();
                hs.MHS = result[0];
                hs.TenHS = result[1];
                hs.Diem = (result[2]);
                hs.HinhAnh = result[3];
                hs.DiaChi = result[4];
                hs.GhiChu = result[5];
                dsHocSinh.add(hs);
                line = bir.readLine();
            }
        }
        return dsHocSinh;

    }

    static List<HocSinh> sortByDiem(List<HocSinh> dsHocSinh, boolean ascending) throws IOException {
        List<String> tempDiem = new ArrayList<>();
        for (int i = 0; i < dsHocSinh.size(); i++) {
            tempDiem.add((dsHocSinh.get(i).Diem));
        }
        List<HocSinh> dsHocSinhMoi = new ArrayList<>();
        Collections.sort(tempDiem);
        if (ascending) {
            while (!tempDiem.isEmpty()) {
                for (int i = 0; i < dsHocSinh.size(); i++) {
                    if (dsHocSinh.get(i).Diem == tempDiem.get(tempDiem.size() - 1)) {
                        dsHocSinhMoi.add(dsHocSinh.get(i));
                        dsHocSinh.remove(i);
                        break;
                    }
                }
                tempDiem.remove(tempDiem.size() - 1);
            }
            return dsHocSinhMoi;
        } else {
            while (!tempDiem.isEmpty()) {
                for (int i = 0; i < dsHocSinh.size(); i++) {
                    if (dsHocSinh.get(i).Diem == tempDiem.get(0)) {
                        dsHocSinhMoi.add(dsHocSinh.get(i));
                        dsHocSinh.remove(i);
                        break;
                    }
                }
                tempDiem.remove(0);
            }
            return dsHocSinhMoi;
        }

    }

    static List<HocSinh> sortByMHS(List<HocSinh> dsHocSinh, boolean ascending) throws IOException {
        List<String> tempMHS = new ArrayList<>();
        for (int i = 0; i < dsHocSinh.size(); i++) {
            tempMHS.add((dsHocSinh.get(i).MHS));
        }
        List<HocSinh> dsHocSinhMoi = new ArrayList<>();
        Collections.sort(tempMHS);
        if (ascending) {
            while (!tempMHS.isEmpty()) {
                for (int i = 0; i < dsHocSinh.size(); i++) {
                    if (dsHocSinh.get(i).MHS == tempMHS.get(tempMHS.size() - 1)) {
                        dsHocSinhMoi.add(dsHocSinh.get(i));
                        dsHocSinh.remove(i);
                        break;
                    }
                }
                tempMHS.remove(tempMHS.size() - 1);
            }
            return dsHocSinhMoi;
        } else {
            while (!tempMHS.isEmpty()) {
                for (int i = 0; i < dsHocSinh.size(); i++) {
                    if (dsHocSinh.get(i).MHS == tempMHS.get(0)) {
                        dsHocSinhMoi.add(dsHocSinh.get(i));
                        dsHocSinh.remove(i);
                        break;
                    }
                }
                tempMHS.remove(0);
            }
            return dsHocSinhMoi;
        }

    }

    public static void main(String args[]) throws Exception {
        // CopyRight @ Kim Nhut Truong - 20424083 - 20HCB2

        String inputFile = "dsHocSinh.txt";
        writeListHocSinhBinary();

        List<HocSinh> dsHocSinh = new ArrayList<>();
        dsHocSinh = readListHocSinhBinary();
        dsHocSinh = deleteHocSinh(dsHocSinh);
        dsHocSinh = addHocSinh(dsHocSinh);
        dsHocSinh = capNhatHS(dsHocSinh);
        dsHocSinh = sortByDiem(dsHocSinh, true);
        dsHocSinh = sortByDiem(dsHocSinh, false);
        dsHocSinh = sortByMHS(dsHocSinh, true);
        dsHocSinh = sortByMHS(dsHocSinh, false);
        exportCSV(dsHocSinh);
        dsHocSinh = importCSV();

        System.out.println(dsHocSinh.get(7).TenHS);
        System.out.println(dsHocSinh.size());
        HocSinh hs = new HocSinh();
        hs.MHS = "MHS";
        hs.TenHS = "TenHS";
        hs.Diem = "1";
        hs.HinhAnh = "HinhAnh";
        hs.DiaChi = "DiaChi";
        hs.GhiChu = "GhiChu";
        // hs = capNhatHS(hs);

    }
}