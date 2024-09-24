package KlauserJava.Enumeration;

public enum Country {
    GERMANY("GER"),UK("GBR"),CHINA("CHN");
    private final String iso3CountryCode;
    Country(String iso3CountryCode){

        this.iso3CountryCode = iso3CountryCode;
    }
    public String getIso3CountryCode(){
        return iso3CountryCode;
    }
    public static Country getDefault(){
        return GERMANY;
    }
    public static Country getRandow(){
        return values()[(int) (Math.random() * 3)];
        //values() 是在 enum 类型中自动生成的静态方法，它返回一个包含所有 enum 常量的数组。
    }
}
