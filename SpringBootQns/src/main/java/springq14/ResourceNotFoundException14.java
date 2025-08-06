package springq14;

public class ResourceNotFoundException14 extends RuntimeException {
    public ResourceNotFoundException14(String entity, Long id) {
        super(entity + " with id " + id + " not found");
    }
}
