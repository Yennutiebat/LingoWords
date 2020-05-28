package infrastructure;

import domain.Word;

import java.io.File;
import java.util.List;

public interface FileDeserializerInterface {
    List<String> deserialize(String file);
}
