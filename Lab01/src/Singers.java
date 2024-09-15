public class Singers {

    private int singersId;
    private String singersName;
    private String singersAddress;
    private String dateOfBirth;
    private int numberOfAlbums;

    //constructors with no arguments and 5 arguments
    //default values for no argument constructor
    public Singers (){
        this.singersId = 0;
        this.singersName= "Unknown";
        this.singersAddress="941 progress Avenue";
        this.dateOfBirth= "Jan 01, 2001";
        this.numberOfAlbums= 0;
    }


    public Singers (int singersId){}

    public Singers (int singersId, String singersName){}

    public Singers (int singersId, String singersName,
                    String singersAddress){}

    public Singers (int singersId, String singersName,
                    String singersAddress, String dateOfBirth ){}

    public Singers (int singersId, String singersName,
                    String singersAddress, String dateOfBirth,
                    int numberOfAlbums){}



    //setters
    public void setSingersId (int singersId){
        this.singersId = singersId;
    }

    public void setSingersName(String singersName) {
        this.singersName = singersName;
    }

    public void setSingersAddress(String singersAddress) {
        this.singersAddress = singersAddress;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNumberOfAlbums(int numberOfAlbums) {
        this.numberOfAlbums = numberOfAlbums;
    }

    public void setSingerDescription (int singersId, String singersName,
                                      String singersAddress, String dateOfBirth,
                                      int numberOfAlbums){

        this.singersId = singersId;
        this.singersName = singersName;
        this.singersAddress = singersAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbums = numberOfAlbums;

    }

    public void singerDescription(){
        System.out.println("Singer's id: " + singersId);
        System.out.println("Singer's name: " + singersName);
        System.out.println("Singer's address: " + singersAddress);
        System.out.println("Singer's Date of birth: " + dateOfBirth);
        System.out.println("Singer's Number of albums published: " + numberOfAlbums);
    }


    //getters
    public int getSingersId (){
        return singersId;
    }

    public String getSingersName() {
        return singersName;
    }

    public String getSingersAddress() {
        return singersAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfAlbums() {
        return numberOfAlbums;
    }
}



