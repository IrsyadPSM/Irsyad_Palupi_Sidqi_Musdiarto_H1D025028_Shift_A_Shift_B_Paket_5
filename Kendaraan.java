public abstract class Kendaraan {

    // Konstanta global (syarat 2)
    public static final int BBM_MAKSIMAL = 50;
    public static final int KM_PER_LITER = 10;

    // Semua atribut private (syarat 3)
    private String platNomor;
    private String merk;
    private int bbm;
    private int kilometer = 0;
    private boolean mesinHidup;

    // Konstruktor 1: BBM tidak diisi, otomatis 0 (syarat 3, overloading)
    public Kendaraan(String platNomor, String merk) {
        this.platNomor = platNomor;
        this.merk = merk;
    }

    // Konstruktor 2: BBM ikut diisi
    public Kendaraan(String platNomor, String merk, int bbm) {
        this.platNomor = platNomor;
        this.merk = merk;
        this.bbm = bbm;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getBbm() {
        return bbm;
    }

    public void setBbm(int bbm) {
        this.bbm = bbm;
    }

    public int getKilometer() {
        return kilometer;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
    }

    public boolean isMesinHidup() {
        return mesinHidup;
    }

    public void setMesinHidup(boolean mesinHidup) {
        this.mesinHidup = mesinHidup;
    }

    // Method prosedur / void (syarat 1)
    public void isiBbm(int liter) {
        if (bbm + liter > BBM_MAKSIMAL) {
            System.out.println("Tangki tidak muat, maksimal " + BBM_MAKSIMAL + " liter");
        } else {
            bbm = bbm + liter;
            System.out.println("BBM diisi " + liter + " liter");
        }
    }

    // Method prosedur yang nanti di-override subclass (syarat 5 dan 6)
    public void tampilkanInfo() {
        System.out.println("Plat      : " + platNomor);
        System.out.println("Merk      : " + merk);
        System.out.println("BBM       : " + bbm + " liter");
        System.out.println("Kilometer : " + kilometer + " km");
        if (mesinHidup) {
            System.out.println("Mesin     : hidup");
        } else {
            System.out.println("Mesin     : mati");
        }
    }

    // Method fungsi / return value (syarat 1)
    public int hitungSisaJarak() {
        return bbm * KM_PER_LITER;
    }

    // Abstract method (syarat 7)
    public abstract void jalan(int jarak);
}
