package HeavenlyBody;

public class Planet extends HeavenlyBody{
    public Planet(String name,int orbital) {
        super(name,orbital, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody heavenlyBody) {

        if(heavenlyBody.getKey().getBodyType()== BodyTypes.MOON){

            return super.addSatellite(heavenlyBody);
        }
        return false;
    }
}
