//Import class yang dibutuhkan
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
 class penjualanBarang {
    public static void main(String args[])
    {
        //Inisialisasi objek untuk masing-masing kelas
         Scanner input = new Scanner(System.in);
         DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
         DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
         //Deklarasi variabel
         int jum=0, i=0;
         double total_bayar=0;
         //Deklarasi array
         int [] kode = new int[5];
         int [] qty = new int[5];
         int [] harga = new int[5];
         double [] sub_total = new double[5];
         double [] diskon= new double [5];
         String [] barang = new String[5];
         
         System.out.println("PROGRAM JAVA TENTANG PENJUALAN BARANG");
         
         System.out.println("Masukan Jumlah Beli : ");
         jum=input.nextInt();
         System.out.println(" ");
         //Memasukan elemen didalam array
         for (i=0; i<jum;i++){
              System.out.println("Masukan Kode Barang Ke-"+(i+1)+" : ");
              kode[i]=input.nextInt();
              System.out.println("Masukan qty Ke-"+(i+1)+" : ");
              qty[i]=input.nextInt();
              //Menentukan barang berdasarkan kode yang dimmasukan
              switch (kode[i]){
                  case 1 : 
                            barang[i]="Bayam  ";
                            harga[i]=25000;
                            diskon[i]=50;
                            break;
                  case 2 : 
                            barang[i]="Kangkung  ";
                            harga[i]=25000;
                            diskon[i]=15;
                            break;
                  case 3 : 
                            barang[i]="Sawi";
                            harga[i]=16000;
                            diskon[i]=0;
                            break;
                  case 4 : 
                            barang[i]="kol        ";
                            harga[i]=16000;
                            diskon[i]=0;
                            break;
                  case 5 : 
                            barang[i]="Wortel    ";
                            harga[i]=16000;
                            diskon[i]=0;
                            break;
                  default : 
                            System.out.println("Kode Barang Tidak Tersedia");
              }
         }
          //Pengaturan format number
          formatRp.setCurrencySymbol("Rp. ");
          formatRp.setMonetaryDecimalSeparator(',');
          formatRp.setGroupingSeparator('.');
          kursIndonesia.setDecimalFormatSymbols(formatRp);
          
          System.out.println(" ");
          System.out.println("No   Nama Barang             Harga            QTY  Diskon   Sub Total");  
          //Menampilkan seluruh elemen di dalam array
          for (i=0; i<jum;i++){ 
             sub_total[i]=((qty[i]*harga[i])-((qty[i]*harga[i]*diskon[i])/100));
             total_bayar+=sub_total[i];
              System.out.println(i+1+"    "+barang[i]+"   "+kursIndonesia.format(harga[i])+"    "+qty[i]+"     "+(int)(diskon[i])+"%"+"     "+kursIndonesia.format(sub_total[i])); 
          }
          System.out.println(" ");
          //Menampilkan total bayar
          System.out.println("Total Bayar : "+kursIndonesia.format(total_bayar));
    }
}
