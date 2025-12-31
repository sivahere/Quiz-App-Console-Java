public class User {
    int crtAns;
    int wrongAns;

    public User() {
        this.crtAns = 0;
        this.wrongAns = 0;
    }

    public int getCrtAns() {
        return crtAns;
    }

    public void setCrtAns(int crtAns) {
        this.crtAns = crtAns;
    }

    public int getWrongAns() {
        return wrongAns;
    }

    public String getStatus() {
        if (this.crtAns == 0 && this.wrongAns == 0) {
            return "Unattempted";
        }
        double perc = ((double) (this.crtAns) / (double) (this.crtAns + this.wrongAns)) * 100.0;
        if (perc >= 50.0) {
            return "Pass :))";
        }
        return "Fail :((";
    }

    public void setWrongAns(int wrongAns) {
        this.wrongAns = wrongAns;
    }

}
