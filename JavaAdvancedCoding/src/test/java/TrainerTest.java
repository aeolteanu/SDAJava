import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainerTest {
    @Test


    public void verifyIsAuthorizedTrainer(){
        //Given
        Trainer trainer = new Trainer(null,null,null, true);


        //Then
        assertTrue(trainer.isAuthorized());

    }
}
