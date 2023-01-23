package HeavenlyBody;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
private final Key key;
private final int orbital;
private final Set<HeavenlyBody> satellites;

public enum BodyTypes{
    STAR,
    PLANET,
    DWARF_PLANET,
    MOON,
    COMET,
    ASTEROID
}

    public HeavenlyBody( String name,int orbital,BodyTypes bodyType) {
        this.orbital = orbital;
        this.satellites = new HashSet<HeavenlyBody>();
        this.key = new Key(name,bodyType);
    }

    public Key getKey() {
        return key;
    }

    public int getOrbital() {
        return orbital;
    }

    public Set<HeavenlyBody> getSatellites() {
        return this.satellites;
    }

    public boolean addSatellite(HeavenlyBody heavenlyBody){

    return this.satellites.add(heavenlyBody);
    }

    public static Key makeKey(String name , BodyTypes bodyType){

    return new Key(name,bodyType);
    }
    @Override
    public String toString(){

    return this.key.name+ " : "+ this.key.bodyType+ " -"+this.orbital;

    }

    @Override
    public boolean equals(Object obj) {
    if(this==obj){
        return true;
    }
    if(obj instanceof HeavenlyBody){

        HeavenlyBody heavenlyBody = ((HeavenlyBody) obj);

        return this.key.equals((heavenlyBody.getKey()));
    }

    return false;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    public static final class Key{
   private final String name;

   private final BodyTypes bodyType;

   public Key(String name,BodyTypes bodyType){
        this.name = name;
        this.bodyType = bodyType;

        }

    public String getName() {
        return name;
    }

    public BodyTypes getBodyType() {
        return bodyType;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+57+this.bodyType.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if(this==obj){
           return true;
       }

       String ans = ((Key)obj).getName();

       if(this.name.equals(ans)){

           if(this.bodyType==((Key)obj).getBodyType()){

               return true;
           }
       }
       return false;
    }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
}


}
