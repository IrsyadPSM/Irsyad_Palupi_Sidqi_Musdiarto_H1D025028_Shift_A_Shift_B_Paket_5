public class Main {
    public static void main(String[] args) {

        System.out.println("=== 1. State dan Behavior ===");
        Mobil mobil = new Mobil("R 025028 H1D", "Mustang GT", 20, 2);
        mobil.tampilkanInfo();                                                 // method void
        System.out.println("Sisa jarak: " + mobil.hitungSisaJarak() + " km"); // method return value

        System.out.println("\n=== 2. Immutability ===");
        System.out.println("Konstanta BBM_MAKSIMAL: " + Kendaraan.BBM_MAKSIMAL);
        System.out.println("Jumlah roda mobil (private final): " + mobil.getJumlahRoda());

        System.out.println("\n=== 3. Enkapsulasi dan Overloading Konstruktor ===");
        Motor motor1 = new Motor("R 025010 H1D", "Beat Karbu", "Matic");  // 3 parameter, BBM otomatis 0
        Motor motor2 = new Motor("R 025032 H1D", "Aerox", 5, "Matic");    // 4 parameter, BBM diisi 5
        System.out.println("BBM motor1: " + motor1.getBbm() + " liter");
        System.out.println("BBM motor2: " + motor2.getBbm() + " liter");
        mobil.setMerk("Mustang GT500");
        System.out.println("Merk setelah setter: " + mobil.getMerk());
        mobil.isiBbm(100);   // melebihi batas
        mobil.isiBbm(10);    // muat
        System.out.println("BBM sekarang: " + mobil.getBbm() + " liter");

        System.out.println("\n=== 4, 5, 6. Inheritance, Super Chaining, Overriding ===");
        System.out.println("Mobil dan Motor sama-sama turunan Kendaraan");
        motor2.tampilkanInfo();   // di dalamnya memanggil super.tampilkanInfo()

        System.out.println("\n=== 7 dan 8. Abstract Method dengan if/else ===");
        mobil.jalan(30);          // mesin mati
        mobil.nyalakan();
        mobil.jalan(30);          // berhasil
        mobil.jalan(1000);        // BBM tidak cukup
        System.out.println("Kilometer sekarang: " + mobil.getKilometer() + " km");
        System.out.println("BBM sekarang: " + mobil.getBbm() + " liter");

        System.out.println("\n=== 9. Polimorfisme Interface ===");
        DapatDinyalakan kendaraan1 = new Mobil("R 025011 H1D", "Brio", 10, 4);
        DapatDinyalakan kendaraan2 = new Motor("R 025022 H1D", "CBR 1000 CC", 5, "Sport");
        kendaraan1.nyalakan();
        kendaraan2.nyalakan();
        kendaraan1.matikan();

        System.out.println("\n=== 10. Multiple Interface ===");
        System.out.println("Mobil implements DapatDinyalakan dan DapatDiservis");
        DapatDiservis bisaServis = mobil;
        System.out.println(bisaServis.servis());   // kilometer 30, belum perlu
        mobil.setKilometer(150);
        System.out.println(bisaServis.servis());   // kilometer 150, perlu servis
    }
}