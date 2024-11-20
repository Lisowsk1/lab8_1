class Audiobook extends Book{
private double duration;
private  double fileSizeMB;

    public Audiobook(String title, String author, String isbn, double fileSizeMB,double duration) {
        super(title, author, isbn);
        this.fileSizeMB = fileSizeMB;
        this.duration = duration;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    public void setFileSizeMB(double fileSizeMB) {
        this.fileSizeMB = fileSizeMB;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println(duration);//will it print filesize??
    }


}