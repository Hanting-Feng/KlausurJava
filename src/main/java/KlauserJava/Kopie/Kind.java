package KlauserJava.Kopie;

public class Kind implements Cloneable{
    public String name;
    public int alter;
    public Kind(Kind kind){
        this.name = kind.name;
        this.alter = kind.alter;
    }
    @Override
    public Kind clone(){
        try{
            return (Kind) super.clone();
        }catch (Exception e){
            throw new AssertionError();
        }
    }
    public int hashCode(){
        return 31 * name.hashCode() + Integer.hashCode(alter);
    }
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Kind)) return false;
        Kind kind = (Kind) o;
        return name.equals(kind.name) && (alter == kind.alter);
    }
}
