package infrastructure;

import java.util.List;

public interface FileDeserializerInterface {
    List<String> deserialize(String file);
}
