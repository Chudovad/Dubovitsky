import com.training.nmusabirova.hw5.CompositeFolder;
import com.training.nmusabirova.hw5.CompositeFolderBuilder;
import com.training.nmusabirova.hw5.Folder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompositeFolderTest {
    public static final int FOLDER_SIZE = 1;
    public static final int ELEMENT_SIZE = 0;
    public static final String MAIN_FOLDER_NAME = "Folder";
    public static final String[] ARRAY = {"1", "1.exe"};
    public static final String ELEMENT_NAME = "1";
    public static final String NAME_OF_DEEPER_LEVEL_ELEMENT = "1.exe";
    CompositeFolder compositeFolder;
    Folder compositeFolderElement;

    @Test
    public void testGetSize() {
        compositeFolder = new CompositeFolderBuilder().setName(MAIN_FOLDER_NAME).build();
        assertEquals(FOLDER_SIZE, compositeFolder.getSize());
        assertEquals(ELEMENT_SIZE, compositeFolder.getFolder().getSize());
    }

    @Test
    public void testGetFolder() {
        compositeFolder = new CompositeFolderBuilder().setName(MAIN_FOLDER_NAME).build();
        compositeFolderElement = new CompositeFolderBuilder().setName(ELEMENT_NAME).build();
        compositeFolder.add(compositeFolderElement);
        assertEquals(compositeFolder.getFolder(), compositeFolderElement);
    }

    @Test
    public void testExecute() {
        compositeFolder = new CompositeFolderBuilder().setName(MAIN_FOLDER_NAME).build();
        compositeFolder.execute(ARRAY);
        assertEquals(compositeFolder.getFolder().getName(), ELEMENT_NAME);
        assertEquals(FOLDER_SIZE, compositeFolder.getFolder().getSize());
        assertEquals(compositeFolder.getFolder().getFolder().getName(), NAME_OF_DEEPER_LEVEL_ELEMENT);
        assertEquals(ELEMENT_SIZE, compositeFolder.getFolder().getFolder().getSize());
    }
}