package enums;

public enum Url {

    FYI_URL("https://fyi.ai/");

    private String url;

    public String getUrl() {return url;}

    private Url(String url) {
        this.url = url;
    }

}
