package pt.oficinadosnumeros.api.problem;

public enum ProblemType {

    VALIDATION_ERROR("validation-error", 400, "Bad Request"),
    MODEL_NOT_FOUND("model-not-found", 404, "Not Found"),
    INTERNAL_ERROR("internal-error", 500, "Internal Server Error");

    private static final String BASE_URI =
        "https://oficinadosnumeros.pt/problems/";

    private final String slug;
    private final int status;
    private final String title;

    ProblemType(String slug, int status, String title) {
        this.slug = slug;
        this.status = status;
        this.title = title;
    }

    public String getTypeUri() {
        return BASE_URI + slug;
    }

    public int getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }
}
