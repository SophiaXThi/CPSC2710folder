import com.sun.source.tree.StringTemplateTree;

public class Airport {

    //instance variables
    private String ident;
    private String aircraftType;
    private String airportName;
    private Integer elevationFt;
    private String continent;
    private String isoCountry;
    private String municipality;
    private String gpsCode;
    private String iataCode;
    private String localCode;
    private Double latitudeCoordinates;
    private Double longitudeCoordinates;

    //Create getters and setters

    //GETTERS***************************************
    private String getIdent(){
        return ident;
    }

    private String getAircraftType(){
        return aircraftType;
    }

    private String getAirportName(){
        return airportName;
    }

    private Integer getElevationFt(){
        return elevationFt;
    }

    private String getContinent(){
        return continent;
    }

    private String getIsoCountry(){
        return isoCountry;
    }

    private String getMunicipality(){
        return municipality;
    }

    private String getGpsCode(){
        return gpsCode;
    }

    private String getIataCode(){
        return iataCode;
    }

    private String getLocalCode(){
        return localCode;
    }

    private Double getLatitudeCoordinates(){
        return latitudeCoordinates;
    }

    private Double getLongitudeCoordinates(){
        return longitudeCoordinates;
    }

    //Setters**************************************************
    private void setIdent(String si){
        this.ident = si;
    }

    private void setAircraftType(String at){
        this.aircraftType = at;
    }

    private void setAirportName(String an){
        this.airportName = an;
    }

    private void setElevationFt(int eft){
        this.elevationFt = eft;
    }

    private void setContinent(String cn){
        this.continent = cn;
    }

    private void setIsoCountry(String isc){
        this.isoCountry = isc;
    }

    private void setMunicipality(String mun){
        this.municipality = mun;
    }

    private void setGpsCode(String gc){
        this.gpsCode = gc;
    }

    private void setIataCode(String ic){
        this.iataCode = ic;
    }

    private void setLocalCode(String lcc){
        this.localCode = lcc;
    }

    private void setLatitudeCoordinates(Double latc){
        this.latitudeCoordinates = latc;
    }

    private void setLongitudeCoordinates(Double lngc){
        this.longitudeCoordinates = lngc;
    }

    public static List<Airport> readAll() throws IOException{
        //Reads in the CSV file
        
    }



}

