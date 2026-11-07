public class Mobil extends Kendaraan implements DapatDinyalakan, DapatDiservis {

    // Atribut instans kekal, nilainya tidak bisa diubah lagi (syarat 2)
    private final int jumlahRoda = 4;
    private int jumlahPintu;

    public Mobil(String platNomor, String merk, int jumlahPintu) {
        super(platNomor, merk);
        this.jumlahPintu = jumlahPintu;
    }

    public Mobil(String platNomor, String merk, int bbm, int jumlahPintu) {
        super(platNomor, merk, bbm);
        this.jumlahPintu = jumlahPintu;
    }

    public int getJumlahRoda() {
        return jumlahRoda;
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Roda      : " + jumlahRoda);
        System.out.println("Pintu     : " + jumlahPintu);
    }

    // Implementasi abstract method dengan if/else (syarat 8)
    @Override
    public void jalan(int jarak) {
        if (isMesinHidup()) {
            if (hitungSisaJarak() >= jarak) {
                setKilometer(getKilometer() + jarak);
                setBbm(getBbm() - jarak / KM_PER_LITER);
                System.out.println("Mobil berjalan " + jarak + " km");
            } else {
                System.out.println("Mobil tidak bisa jalan " + jarak + " km, BBM tidak cukup");
            }
        } else {
            System.out.println("Mobil belum bisa jalan, mesin masih mati");
        }
    }

    @Override
    public void nyalakan() {
        if (getBbm() > 0) {
            setMesinHidup(true);
            System.out.println("Mesin mobil menyala");
        } else {
            System.out.println("Mesin mobil gagal menyala, BBM habis");
        }
    }

    @Override
    public void matikan() {
        setMesinHidup(false);
        System.out.println("Mesin mobil dimatikan");
    }

    @Override
    public String servis() {
        if (getKilometer() >= 100) {
            return "Mobil perlu servis berkala";
        } else {
            return "Mobil belum perlu servis";
        }
    }
}
