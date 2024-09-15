public class Main {
    public static void main(String[] args) {
      Singers singer1 = new Singers();

        System.out.println("Singer's id: " + singer1.getSingersId());
        System.out.println("Singer's name: " + singer1.getSingersName());
        System.out.println("Singer's address: " + singer1.getSingersAddress());
        System.out.println("Singer's Date of birth: " + singer1.getDateOfBirth());
        System.out.println("Singer's Number of albums published: " + singer1.getNumberOfAlbums());

        singer1.setSingersId(1);
        singer1.setSingersName("Juice WRLD");
        singer1.setSingersAddress("Los angeles, USA");
        singer1.setDateOfBirth("December 2, 1998");
        singer1.setNumberOfAlbums(4);

        singer1.singerDescription();


    }
}
